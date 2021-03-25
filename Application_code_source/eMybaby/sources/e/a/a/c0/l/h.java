package e.a.a.c0.l;

import e.a.a.c;
import e.a.a.e0.b;
import e.a.a.e0.e;
import e.a.a.e0.k;
import e.a.a.i0.j;
import e.a.a.o;
import e.a.a.p;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class h implements p {

    /* renamed from: a  reason: collision with root package name */
    public final Log f4855a = LogFactory.getLog(h.class);

    public final void a(j jVar, e.a.a.e0.h hVar, e eVar, e.a.a.c0.e eVar2) {
        while (jVar.hasNext()) {
            c b2 = jVar.b();
            try {
                for (b next : hVar.c(b2, eVar)) {
                    try {
                        hVar.a(next, eVar);
                        eVar2.b(next);
                        if (this.f4855a.isDebugEnabled()) {
                            Log log = this.f4855a;
                            log.debug("Cookie accepted: \"" + next + "\". ");
                        }
                    } catch (k e2) {
                        if (this.f4855a.isWarnEnabled()) {
                            Log log2 = this.f4855a;
                            log2.warn("Cookie rejected: \"" + next + "\". " + e2.getMessage());
                        }
                    }
                }
            } catch (k e3) {
                if (this.f4855a.isWarnEnabled()) {
                    Log log3 = this.f4855a;
                    log3.warn("Invalid cookie header: \"" + b2 + "\". " + e3.getMessage());
                }
            }
        }
    }

    public void c(o oVar, e.a.a.k0.c cVar) {
        Log log;
        String str;
        if (oVar == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        } else if (cVar != null) {
            e.a.a.e0.h hVar = (e.a.a.e0.h) cVar.b("http.cookie-spec");
            if (hVar == null) {
                log = this.f4855a;
                str = "Cookie spec not specified in HTTP context";
            } else {
                e.a.a.c0.e eVar = (e.a.a.c0.e) cVar.b("http.cookie-store");
                if (eVar == null) {
                    log = this.f4855a;
                    str = "Cookie store not specified in HTTP context";
                } else {
                    e eVar2 = (e) cVar.b("http.cookie-origin");
                    if (eVar2 == null) {
                        log = this.f4855a;
                        str = "Cookie origin not specified in HTTP context";
                    } else {
                        a(oVar.g("Set-Cookie"), hVar, eVar2, eVar);
                        if (hVar.d() > 0) {
                            a(oVar.g("Set-Cookie2"), hVar, eVar2, eVar);
                            return;
                        }
                        return;
                    }
                }
            }
            log.debug(str);
        } else {
            throw new IllegalArgumentException("HTTP context may not be null");
        }
    }
}
