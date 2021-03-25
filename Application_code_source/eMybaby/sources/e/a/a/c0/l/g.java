package e.a.a.c0.l;

import e.a.a.b0.e;
import e.a.a.c0.a;
import e.a.a.g0.g.b;
import e.a.a.j;
import e.a.a.k0.c;
import e.a.a.o;
import e.a.a.p;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class g implements p {

    /* renamed from: a  reason: collision with root package name */
    public final Log f4854a = LogFactory.getLog(g.class);

    public final void a(a aVar, j jVar, e eVar) {
        e.a.a.b0.a aVar2 = eVar.f4842a;
        if (eVar.f4843b == null) {
            return;
        }
        if (eVar.f4844c != null) {
            if (this.f4854a.isDebugEnabled()) {
                Log log = this.f4854a;
                StringBuilder n = a.a.a.a.a.n("Caching '");
                n.append(aVar2.g());
                n.append("' auth scheme for ");
                n.append(jVar);
                log.debug(n.toString());
            }
            aVar.c(jVar, aVar2);
            return;
        }
        aVar.b(jVar);
    }

    public final boolean b(e eVar) {
        e.a.a.b0.a aVar = eVar.f4842a;
        if (aVar != null && aVar.f()) {
            String g = aVar.g();
            if (g.equalsIgnoreCase("Basic") || g.equalsIgnoreCase("Digest")) {
                return true;
            }
        }
        return false;
    }

    public void c(o oVar, c cVar) {
        if (oVar == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        } else if (cVar != null) {
            a aVar = (a) cVar.b("http.auth.auth-cache");
            j jVar = (j) cVar.b("http.target_host");
            e eVar = (e) cVar.b("http.auth.target-scope");
            if (!(jVar == null || eVar == null || !b(eVar))) {
                if (aVar == null) {
                    aVar = new b();
                    cVar.e("http.auth.auth-cache", aVar);
                }
                a(aVar, jVar, eVar);
            }
            j jVar2 = (j) cVar.b("http.proxy_host");
            e eVar2 = (e) cVar.b("http.auth.proxy-scope");
            if (jVar2 != null && eVar2 != null && b(eVar2)) {
                if (aVar == null) {
                    aVar = new b();
                    cVar.e("http.auth.auth-cache", aVar);
                }
                a(aVar, jVar2, eVar2);
            }
        } else {
            throw new IllegalArgumentException("HTTP context may not be null");
        }
    }
}
