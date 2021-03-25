package a.d.c.w.b;

import a.d.c.f;
import a.d.c.r.b;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final b f3140a;

    /* renamed from: b  reason: collision with root package name */
    public i f3141b;

    /* renamed from: c  reason: collision with root package name */
    public g f3142c;

    public a(b bVar) {
        int i = bVar.f2967b;
        if (i < 21 || (i & 3) != 1) {
            throw f.f2869a;
        }
        this.f3140a = bVar;
    }

    public final int a(int i, int i2, int i3) {
        return this.f3140a.a(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    public g b() {
        g gVar = this.f3142c;
        if (gVar != null) {
            return gVar;
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 6; i3++) {
            i2 = a(i3, 8, i2);
        }
        int a2 = a(8, 7, a(8, 8, a(7, 8, i2)));
        for (int i4 = 5; i4 >= 0; i4--) {
            a2 = a(8, i4, a2);
        }
        int i5 = this.f3140a.f2967b;
        int i6 = i5 - 7;
        for (int i7 = i5 - 1; i7 >= i6; i7--) {
            i = a(8, i7, i);
        }
        for (int i8 = i5 - 8; i8 < i5; i8++) {
            i = a(i8, 8, i);
        }
        g a3 = g.a(a2, i);
        if (a3 == null) {
            a3 = g.a(a2 ^ 21522, i ^ 21522);
        }
        this.f3142c = a3;
        if (a3 != null) {
            return a3;
        }
        throw f.f2869a;
    }

    public i c() {
        i iVar = this.f3141b;
        if (iVar != null) {
            return iVar;
        }
        int i = this.f3140a.f2967b;
        int i2 = (i - 17) >> 2;
        if (i2 <= 6) {
            return i.e(i2);
        }
        int i3 = i - 11;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 5; i6 >= 0; i6--) {
            for (int i7 = i - 9; i7 >= i3; i7--) {
                i5 = a(i7, i6, i5);
            }
        }
        i b2 = i.b(i5);
        if (b2 == null || b2.c() != i) {
            for (int i8 = 5; i8 >= 0; i8--) {
                for (int i9 = i - 9; i9 >= i3; i9--) {
                    i4 = a(i8, i9, i4);
                }
            }
            i b3 = i.b(i4);
            if (b3 == null || b3.c() != i) {
                throw f.f2869a;
            }
            this.f3141b = b3;
            return b3;
        }
        this.f3141b = b2;
        return b2;
    }
}
