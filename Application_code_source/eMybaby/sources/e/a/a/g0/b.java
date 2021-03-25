package e.a.a.g0;

import e.a.a.i0.j;
import e.a.a.i0.m;
import e.a.a.i0.n;
import e.a.a.k0.c;
import e.a.a.o;
import e.a.a.q;
import e.a.a.u;
import e.a.a.w;

public class b {
    public boolean a(o oVar, c cVar) {
        w wVar = ((m) oVar.s()).f5156a;
        e.a.a.c l = oVar.l("Transfer-Encoding");
        if (l == null) {
            e.a.a.c[] p = oVar.p("Content-Length");
            if (p != null && p.length == 1) {
                try {
                    if (Integer.parseInt(p[0].getValue()) < 0) {
                        return false;
                    }
                } catch (NumberFormatException unused) {
                }
            }
            return false;
        } else if (!"chunked".equalsIgnoreCase(l.getValue())) {
            return false;
        }
        j g = oVar.g("Connection");
        if (!g.hasNext()) {
            g = oVar.g("Proxy-Connection");
        }
        if (g.hasNext()) {
            try {
                n nVar = new n(g);
                boolean z = false;
                while (nVar.hasNext()) {
                    String c2 = nVar.c();
                    if ("Close".equalsIgnoreCase(c2)) {
                        return false;
                    }
                    if ("Keep-Alive".equalsIgnoreCase(c2)) {
                        z = true;
                    }
                }
                if (z) {
                    return true;
                }
            } catch (u unused2) {
                return false;
            }
        }
        return !wVar.c(q.f5193e);
    }
}
