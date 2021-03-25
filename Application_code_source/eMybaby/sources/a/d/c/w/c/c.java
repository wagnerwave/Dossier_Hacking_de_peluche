package a.d.c.w.c;

import a.d.c.i;
import a.d.c.n;
import a.d.c.o;
import a.d.c.r.b;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public final b f3177a;

    /* renamed from: b  reason: collision with root package name */
    public o f3178b;

    public c(b bVar) {
        this.f3177a = bVar;
    }

    public final float a(n nVar, n nVar2) {
        float d2 = d((int) nVar.f2885a, (int) nVar.f2886b, (int) nVar2.f2885a, (int) nVar2.f2886b);
        float d3 = d((int) nVar2.f2885a, (int) nVar2.f2886b, (int) nVar.f2885a, (int) nVar.f2886b);
        if (Float.isNaN(d2)) {
            return d3 / 7.0f;
        }
        return Float.isNaN(d3) ? d2 / 7.0f : (d2 + d3) / 14.0f;
    }

    public a b(float f, int i, int i2, float f2) {
        a c2;
        a c3;
        int i3 = (int) (f2 * f);
        int max = Math.max(0, i - i3);
        int min = Math.min(this.f3177a.f2966a - 1, i + i3) - max;
        float f3 = 3.0f * f;
        if (((float) min) >= f3) {
            int max2 = Math.max(0, i2 - i3);
            int min2 = Math.min(this.f3177a.f2967b - 1, i2 + i3) - max2;
            if (((float) min2) >= f3) {
                b bVar = new b(this.f3177a, max, max2, min, min2, f, this.f3178b);
                int i4 = bVar.f3174c;
                int i5 = bVar.f;
                int i6 = bVar.f3176e + i4;
                int i7 = bVar.f3175d + (i5 >> 1);
                int[] iArr = new int[3];
                for (int i8 = 0; i8 < i5; i8++) {
                    int i9 = ((i8 & 1) == 0 ? (i8 + 1) >> 1 : -((i8 + 1) >> 1)) + i7;
                    iArr[0] = 0;
                    iArr[1] = 0;
                    iArr[2] = 0;
                    int i10 = i4;
                    while (i10 < i6 && !bVar.f3172a.a(i10, i9)) {
                        i10++;
                    }
                    int i11 = 0;
                    while (i10 < i6) {
                        if (!bVar.f3172a.a(i10, i9)) {
                            if (i11 == 1) {
                                i11++;
                            }
                            iArr[i11] = iArr[i11] + 1;
                        } else if (i11 == 1) {
                            iArr[i11] = iArr[i11] + 1;
                        } else if (i11 != 2) {
                            i11++;
                            iArr[i11] = iArr[i11] + 1;
                        } else if (bVar.b(iArr) && (c3 = bVar.c(iArr, i9, i10)) != null) {
                            return c3;
                        } else {
                            iArr[0] = iArr[2];
                            iArr[1] = 1;
                            iArr[2] = 0;
                            i11 = 1;
                        }
                        i10++;
                    }
                    if (bVar.b(iArr) && (c2 = bVar.c(iArr, i9, i6)) != null) {
                        return c2;
                    }
                }
                if (!bVar.f3173b.isEmpty()) {
                    return bVar.f3173b.get(0);
                }
                throw i.f2874a;
            }
            throw i.f2874a;
        }
        throw i.f2874a;
    }

    public final float c(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        double d2;
        boolean z;
        c cVar;
        int i11 = 1;
        boolean z2 = Math.abs(i4 - i2) > Math.abs(i3 - i);
        if (z2) {
            i7 = i;
            i8 = i2;
            i5 = i3;
            i6 = i4;
        } else {
            i8 = i;
            i7 = i2;
            i6 = i3;
            i5 = i4;
        }
        int abs = Math.abs(i6 - i8);
        int i12 = i5 - i7;
        int abs2 = Math.abs(i12);
        int i13 = (-abs) >> 1;
        int i14 = -1;
        int i15 = i8 < i6 ? 1 : -1;
        if (i7 < i5) {
            i14 = 1;
        }
        int i16 = i6 + i15;
        int i17 = i8;
        int i18 = i7;
        int i19 = 0;
        while (true) {
            if (i17 == i16) {
                i9 = i16;
                i10 = i12;
                break;
            }
            int i20 = z2 ? i18 : i17;
            boolean z3 = z2;
            int i21 = z2 ? i17 : i18;
            if (i19 == i11) {
                cVar = this;
                i9 = i16;
                i10 = i12;
                z = true;
            } else {
                cVar = this;
                i9 = i16;
                i10 = i12;
                z = false;
            }
            if (z == cVar.f3177a.a(i20, i21)) {
                if (i19 == 2) {
                    int i22 = i17 - i8;
                    int i23 = i18 - i7;
                    d2 = (double) ((i23 * i23) + (i22 * i22));
                    break;
                }
                i19++;
            }
            i13 += abs2;
            if (i13 > 0) {
                if (i18 == i5) {
                    break;
                }
                i18 += i14;
                i13 -= abs;
            }
            i17 += i15;
            i12 = i10;
            i16 = i9;
            z2 = z3;
            i11 = 1;
        }
        if (i19 != 2) {
            return Float.NaN;
        }
        int i24 = i9 - i8;
        d2 = (double) ((i10 * i10) + (i24 * i24));
        return (float) Math.sqrt(d2);
    }

    public final float d(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float c2 = c(i, i2, i3, i4);
        int i5 = i - (i3 - i);
        int i6 = 0;
        if (i5 < 0) {
            f = ((float) i) / ((float) (i - i5));
            i5 = 0;
        } else {
            int i7 = this.f3177a.f2966a;
            if (i5 >= i7) {
                int i8 = i7 - 1;
                f = ((float) ((i7 - 1) - i)) / ((float) (i5 - i));
                i5 = i8;
            } else {
                f = 1.0f;
            }
        }
        float f3 = (float) i2;
        int i9 = (int) (f3 - (((float) (i4 - i2)) * f));
        if (i9 < 0) {
            f2 = f3 / ((float) (i2 - i9));
        } else {
            int i10 = this.f3177a.f2967b;
            if (i9 >= i10) {
                f2 = ((float) ((i10 - 1) - i2)) / ((float) (i9 - i2));
                i6 = i10 - 1;
            } else {
                i6 = i9;
                f2 = 1.0f;
            }
        }
        return (c(i, i2, (int) ((((float) (i5 - i)) * f2) + ((float) i)), i6) + c2) - 1.0f;
    }
}
