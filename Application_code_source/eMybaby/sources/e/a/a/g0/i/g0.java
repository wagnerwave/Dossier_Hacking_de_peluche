package e.a.a.g0.i;

import e.a.a.e0.a;
import e.a.a.e0.b;
import e.a.a.e0.c;
import e.a.a.e0.e;
import e.a.a.e0.g;
import e.a.a.e0.k;
import e.a.a.e0.l;
import e.a.a.e0.m;

public class g0 implements c {
    public void a(b bVar, e eVar) {
        if ((bVar instanceof l) && (bVar instanceof a) && !((a) bVar).e("version")) {
            throw new g("Violates RFC 2965. Version attribute is required.");
        }
    }

    public boolean b(b bVar, e eVar) {
        return true;
    }

    public void c(m mVar, String str) {
        int i;
        if (str != null) {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                i = -1;
            }
            if (i >= 0) {
                ((c) mVar).h = i;
                return;
            }
            throw new k("Invalid cookie version.");
        }
        throw new k("Missing value for version attribute");
    }
}
