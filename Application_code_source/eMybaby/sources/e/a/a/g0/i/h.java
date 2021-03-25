package e.a.a.g0.i;

import a.a.a.a.a;
import e.a.a.e0.b;
import e.a.a.e0.c;
import e.a.a.e0.e;
import e.a.a.e0.g;
import e.a.a.e0.m;

public class h implements c {
    public void a(b bVar, e eVar) {
        if (!b(bVar, eVar)) {
            StringBuilder n = a.n("Illegal path attribute \"");
            n.append(bVar.g());
            n.append("\". Path of origin: \"");
            throw new g(a.m(n, eVar.f4899c, "\""));
        }
    }

    public boolean b(b bVar, e eVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        } else if (eVar != null) {
            String str = eVar.f4899c;
            String g = bVar.g();
            if (g == null) {
                g = "/";
            }
            boolean z = false;
            if (g.length() > 1 && g.endsWith("/")) {
                g = g.substring(0, g.length() - 1);
            }
            boolean startsWith = str.startsWith(g);
            if (!startsWith || str.length() == g.length() || g.endsWith("/")) {
                return startsWith;
            }
            if (str.charAt(g.length()) == '/') {
                z = true;
            }
            return z;
        } else {
            throw new IllegalArgumentException("Cookie origin may not be null");
        }
    }

    public void c(m mVar, String str) {
        if (str == null || str.trim().length() == 0) {
            str = "/";
        }
        ((c) mVar).f = str;
    }
}
