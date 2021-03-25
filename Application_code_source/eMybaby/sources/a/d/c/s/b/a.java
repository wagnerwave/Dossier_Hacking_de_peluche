package a.d.c.s.b;

import a.d.c.f;
import a.d.c.r.b;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final b f3010a;

    /* renamed from: b  reason: collision with root package name */
    public final b f3011b;

    /* renamed from: c  reason: collision with root package name */
    public final e f3012c;

    public a(b bVar) {
        b bVar2 = bVar;
        int i = bVar2.f2967b;
        if (i < 8 || i > 144 || (i & 1) != 0) {
            throw f.f2869a;
        }
        e a2 = e.a(i, bVar2.f2966a);
        this.f3012c = a2;
        int i2 = a2.f3026b;
        int i3 = a2.f3027c;
        if (bVar2.f2967b == i2) {
            int i4 = a2.f3028d;
            int i5 = a2.f3029e;
            int i6 = i2 / i4;
            int i7 = i3 / i5;
            b bVar3 = new b(i7 * i5, i6 * i4);
            for (int i8 = 0; i8 < i6; i8++) {
                int i9 = i8 * i4;
                for (int i10 = 0; i10 < i7; i10++) {
                    int i11 = i10 * i5;
                    for (int i12 = 0; i12 < i4; i12++) {
                        int i13 = ((i4 + 2) * i8) + 1 + i12;
                        int i14 = i9 + i12;
                        for (int i15 = 0; i15 < i5; i15++) {
                            if (bVar2.a(((i5 + 2) * i10) + 1 + i15, i13)) {
                                bVar3.d(i11 + i15, i14);
                            }
                        }
                    }
                }
            }
            this.f3010a = bVar3;
            this.f3011b = new b(bVar3.f2966a, bVar3.f2967b);
            return;
        }
        throw new IllegalArgumentException("Dimension of bitMarix must match the version size");
    }

    public boolean a(int i, int i2, int i3, int i4) {
        if (i < 0) {
            i += i3;
            i2 += 4 - ((i3 + 4) & 7);
        }
        if (i2 < 0) {
            i2 += i4;
            i += 4 - ((i4 + 4) & 7);
        }
        this.f3011b.d(i2, i);
        return this.f3010a.a(i2, i);
    }

    public int b(int i, int i2, int i3, int i4) {
        int i5 = i - 2;
        int i6 = i2 - 2;
        int i7 = (a(i5, i6, i3, i4) ? 1 : 0) << 1;
        int i8 = i2 - 1;
        if (a(i5, i8, i3, i4)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        int i10 = i - 1;
        if (a(i10, i6, i3, i4)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        if (a(i10, i8, i3, i4)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (a(i10, i2, i3, i4)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (a(i, i6, i3, i4)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (a(i, i8, i3, i4)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        return a(i, i2, i3, i4) ? i15 | 1 : i15;
    }
}
