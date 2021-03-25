package a.d.c.r.l;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final a f3005a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f3006b;

    public b(a aVar, int[] iArr) {
        if (iArr.length != 0) {
            this.f3005a = aVar;
            int length = iArr.length;
            int i = 1;
            if (length <= 1 || iArr[0] != 0) {
                this.f3006b = iArr;
                return;
            }
            while (i < length && iArr[i] == 0) {
                i++;
            }
            if (i == length) {
                aVar.c();
                this.f3006b = aVar.f3002c.f3006b;
                return;
            }
            int[] iArr2 = new int[(length - i)];
            this.f3006b = iArr2;
            System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
            return;
        }
        throw new IllegalArgumentException();
    }

    public b a(b bVar) {
        if (!this.f3005a.equals(bVar.f3005a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (e()) {
            return bVar;
        } else {
            if (bVar.e()) {
                return this;
            }
            int[] iArr = this.f3006b;
            int[] iArr2 = bVar.f3006b;
            if (iArr.length <= iArr2.length) {
                int[] iArr3 = iArr;
                iArr = iArr2;
                iArr2 = iArr3;
            }
            int[] iArr4 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr4, 0, length);
            for (int i = length; i < iArr.length; i++) {
                iArr4[i] = a.a(iArr2[i - length], iArr[i]);
            }
            return new b(this.f3005a, iArr4);
        }
    }

    public int b(int i) {
        if (i == 0) {
            return c(0);
        }
        int[] iArr = this.f3006b;
        int length = iArr.length;
        if (i == 1) {
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                i2 = a.a(i2, this.f3006b[i3]);
            }
            return i2;
        }
        int i4 = iArr[0];
        for (int i5 = 1; i5 < length; i5++) {
            i4 = this.f3005a.f(i, i4) ^ this.f3006b[i5];
        }
        return i4;
    }

    public int c(int i) {
        int[] iArr = this.f3006b;
        return iArr[(iArr.length - 1) - i];
    }

    public int d() {
        return this.f3006b.length - 1;
    }

    public boolean e() {
        return this.f3006b[0] == 0;
    }

    public b f(int i) {
        if (i == 0) {
            a aVar = this.f3005a;
            aVar.c();
            return aVar.f3002c;
        } else if (i == 1) {
            return this;
        } else {
            int length = this.f3006b.length;
            int[] iArr = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = this.f3005a.f(this.f3006b[i2], i);
            }
            return new b(this.f3005a, iArr);
        }
    }

    public b g(b bVar) {
        if (!this.f3005a.equals(bVar.f3005a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (e() || bVar.e()) {
            a aVar = this.f3005a;
            aVar.c();
            return aVar.f3002c;
        } else {
            int[] iArr = this.f3006b;
            int length = iArr.length;
            int[] iArr2 = bVar.f3006b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    int i4 = i + i3;
                    iArr3[i4] = iArr3[i4] ^ this.f3005a.f(i2, iArr2[i3]);
                }
            }
            return new b(this.f3005a, iArr3);
        }
    }

    public String toString() {
        char c2;
        StringBuilder sb = new StringBuilder(d() * 8);
        for (int d2 = d(); d2 >= 0; d2--) {
            int c3 = c(d2);
            if (c3 != 0) {
                if (c3 < 0) {
                    sb.append(" - ");
                    c3 = -c3;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (d2 == 0 || c3 != 1) {
                    a aVar = this.f3005a;
                    aVar.c();
                    if (c3 != 0) {
                        int i = aVar.f3001b[c3];
                        if (i == 0) {
                            c2 = '1';
                        } else if (i == 1) {
                            c2 = 'a';
                        } else {
                            sb.append("a^");
                            sb.append(i);
                        }
                        sb.append(c2);
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
                if (d2 != 0) {
                    if (d2 == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(d2);
                    }
                }
            }
        }
        return sb.toString();
    }
}
