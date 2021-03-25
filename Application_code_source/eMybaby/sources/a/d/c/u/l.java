package a.d.c.u;

import a.d.c.a;
import a.d.c.c;
import a.d.c.e;
import a.d.c.f;
import java.util.Map;

public final class l extends n {
    public final n h = new e();

    public static a.d.c.l p(a.d.c.l lVar) {
        String str = lVar.f2875a;
        if (str.charAt(0) == '0') {
            return new a.d.c.l(str.substring(1), (byte[]) null, lVar.f2877c, a.UPC_A);
        }
        throw f.f2869a;
    }

    public a.d.c.l a(c cVar, Map<e, ?> map) {
        return p(this.h.a(cVar, map));
    }

    public a.d.c.l b(int i, a.d.c.r.a aVar, Map<e, ?> map) {
        return p(this.h.b(i, aVar, map));
    }

    public int j(a.d.c.r.a aVar, int[] iArr, StringBuilder sb) {
        return this.h.j(aVar, iArr, sb);
    }

    public a.d.c.l k(int i, a.d.c.r.a aVar, int[] iArr, Map<e, ?> map) {
        return p(this.h.k(i, aVar, iArr, map));
    }

    public a o() {
        return a.UPC_A;
    }
}
