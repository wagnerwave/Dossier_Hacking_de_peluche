package a.d.c.v.b;

import a.d.c.f;
import a.d.c.r.b;
import a.d.c.r.e;

public final class c {
    public e a(b bVar) {
        a aVar = new a(bVar);
        b bVar2 = aVar.f3121a;
        int i = bVar2.f2966a;
        int i2 = bVar2.f2967b;
        aVar.f = new int[929];
        int[] iArr = new int[i];
        int[] iArr2 = new int[929];
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1;
        int i7 = 0;
        while (i6 < i2) {
            if (i7 < 90) {
                int i8 = 0;
                for (int i9 = 0; i9 < i; i9++) {
                    if (aVar.f3121a.a(i9, i6) != aVar.f3121a.a(i9, i6 - 1)) {
                        i8++;
                    }
                }
                if (((float) i8) <= 6.0f) {
                    for (int i10 = 0; i10 < i; i10++) {
                        if (aVar.f3121a.a(i10, i6)) {
                            iArr[i10] = iArr[i10] + 1;
                        }
                    }
                    i3++;
                    if (((float) i3) >= 2.0f) {
                        z = true;
                    }
                } else {
                    if (z) {
                        i5 = aVar.b(iArr, i7, i4, iArr2, i5);
                        if (i5 != -1) {
                            for (int i11 = 0; i11 < i; i11++) {
                                iArr[i11] = 0;
                            }
                            i7++;
                            i4 = 0;
                        } else {
                            throw f.f2869a;
                        }
                    }
                    z = false;
                    i3 = 0;
                }
                i4++;
                i6++;
            } else {
                throw f.f2869a;
            }
        }
        if (z) {
            if (i7 < 90) {
                i5 = aVar.b(iArr, i7, i4, iArr2, i5);
                aVar.f3122b = i7 + 1;
            } else {
                throw f.f2869a;
            }
        }
        aVar.f = a.c(aVar.f, aVar.f3125e);
        int[] c2 = a.c(iArr2, i5);
        if (c2.length != 0) {
            int i12 = 1 << (aVar.g + 1);
            int[] iArr3 = aVar.f;
            if (iArr3.length > (i12 / 2) + 3 || i12 < 0 || i12 > 512) {
                throw f.f2869a;
            } else if (iArr3.length > 3) {
                throw f.f2869a;
            } else if (c2.length >= 4) {
                int i13 = c2[0];
                if (i13 <= c2.length) {
                    if (i13 == 0) {
                        if (i12 < c2.length) {
                            c2[0] = c2.length - i12;
                        } else {
                            throw f.f2869a;
                        }
                    }
                    return b.b(c2);
                }
                throw f.f2869a;
            } else {
                throw f.f2869a;
            }
        } else {
            throw f.f2869a;
        }
    }
}
