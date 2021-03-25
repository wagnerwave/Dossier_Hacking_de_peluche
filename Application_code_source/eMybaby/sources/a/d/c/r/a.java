package a.d.c.r;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public int[] f2964a;

    /* renamed from: b  reason: collision with root package name */
    public int f2965b;

    public a(int i) {
        this.f2965b = i;
        this.f2964a = new int[((i + 31) >> 5)];
    }

    public boolean a(int i) {
        return ((1 << (i & 31)) & this.f2964a[i >> 5]) != 0;
    }

    public int b(int i) {
        int i2 = this.f2965b;
        if (i >= i2) {
            return i2;
        }
        int i3 = i >> 5;
        int i4 = (((1 << (i & 31)) - 1) ^ -1) & this.f2964a[i3];
        while (i4 == 0) {
            i3++;
            int[] iArr = this.f2964a;
            if (i3 == iArr.length) {
                return this.f2965b;
            }
            i4 = iArr[i3];
        }
        int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i4) + (i3 << 5);
        int i5 = this.f2965b;
        return numberOfTrailingZeros > i5 ? i5 : numberOfTrailingZeros;
    }

    public int c(int i) {
        int i2 = this.f2965b;
        if (i >= i2) {
            return i2;
        }
        int i3 = i >> 5;
        int i4 = (((1 << (i & 31)) - 1) ^ -1) & (this.f2964a[i3] ^ -1);
        while (i4 == 0) {
            i3++;
            int[] iArr = this.f2964a;
            if (i3 == iArr.length) {
                return this.f2965b;
            }
            i4 = iArr[i3] ^ -1;
        }
        int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i4) + (i3 << 5);
        int i5 = this.f2965b;
        return numberOfTrailingZeros > i5 ? i5 : numberOfTrailingZeros;
    }

    public boolean d(int i, int i2, boolean z) {
        int i3;
        if (i2 < i) {
            throw new IllegalArgumentException();
        } else if (i2 == i) {
            return true;
        } else {
            int i4 = i2 - 1;
            int i5 = i >> 5;
            int i6 = i4 >> 5;
            int i7 = i5;
            while (i7 <= i6) {
                int i8 = i7 > i5 ? 0 : i & 31;
                int i9 = i7 < i6 ? 31 : i4 & 31;
                if (i8 == 0 && i9 == 31) {
                    i3 = -1;
                } else {
                    i3 = 0;
                    while (i8 <= i9) {
                        i3 |= 1 << i8;
                        i8++;
                    }
                }
                int i10 = this.f2964a[i7] & i3;
                if (!z) {
                    i3 = 0;
                }
                if (i10 != i3) {
                    return false;
                }
                i7++;
            }
            return true;
        }
    }

    public void e() {
        int[] iArr = new int[this.f2964a.length];
        int i = this.f2965b;
        for (int i2 = 0; i2 < i; i2++) {
            if (a((i - i2) - 1)) {
                int i3 = i2 >> 5;
                iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
            }
        }
        this.f2964a = iArr;
    }

    public void f(int i) {
        int[] iArr = this.f2964a;
        int i2 = i >> 5;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.f2965b);
        for (int i = 0; i < this.f2965b; i++) {
            if ((i & 7) == 0) {
                sb.append(' ');
            }
            sb.append(a(i) ? 'X' : '.');
        }
        return sb.toString();
    }
}
