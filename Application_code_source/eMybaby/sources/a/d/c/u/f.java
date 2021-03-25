package a.d.c.u;

import a.d.c.r.a;

public final class f extends n {
    public final int[] h = new int[4];

    public int j(a aVar, int[] iArr, StringBuilder sb) {
        int[] iArr2 = this.h;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int i = aVar.f2965b;
        int i2 = iArr[1];
        for (int i3 = 0; i3 < 4 && i2 < i; i3++) {
            sb.append((char) (n.h(aVar, iArr2, i2, n.f) + 48));
            for (int i4 : iArr2) {
                i2 += i4;
            }
        }
        int i5 = n.l(aVar, i2, true, n.f3072e)[1];
        for (int i6 = 0; i6 < 4 && i5 < i; i6++) {
            sb.append((char) (n.h(aVar, iArr2, i5, n.f) + 48));
            for (int i7 : iArr2) {
                i5 += i7;
            }
        }
        return i5;
    }

    public a.d.c.a o() {
        return a.d.c.a.EAN_8;
    }
}
