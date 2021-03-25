package a.d.c.u;

import a.d.c.i;
import a.d.c.r.a;

public final class e extends n {
    public static final int[] i = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};
    public final int[] h = new int[4];

    public int j(a aVar, int[] iArr, StringBuilder sb) {
        int[] iArr2 = this.h;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int i2 = aVar.f2965b;
        int i3 = iArr[1];
        int i4 = 0;
        for (int i5 = 0; i5 < 6 && i3 < i2; i5++) {
            int h2 = n.h(aVar, iArr2, i3, n.g);
            sb.append((char) ((h2 % 10) + 48));
            for (int i6 : iArr2) {
                i3 += i6;
            }
            if (h2 >= 10) {
                i4 |= 1 << (5 - i5);
            }
        }
        for (int i7 = 0; i7 < 10; i7++) {
            if (i4 == i[i7]) {
                sb.insert(0, (char) (i7 + 48));
                int i8 = n.l(aVar, i3, true, n.f3072e)[1];
                for (int i9 = 0; i9 < 6 && i8 < i2; i9++) {
                    sb.append((char) (n.h(aVar, iArr2, i8, n.f) + 48));
                    for (int i10 : iArr2) {
                        i8 += i10;
                    }
                }
                return i8;
            }
        }
        throw i.f2874a;
    }

    public a.d.c.a o() {
        return a.d.c.a.EAN_13;
    }
}
