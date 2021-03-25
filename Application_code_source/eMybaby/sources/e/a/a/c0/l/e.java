package e.a.a.c0.l;

import e.a.a.b0.a;
import e.a.a.b0.f;
import e.a.a.b0.g;
import e.a.a.b0.h;
import e.a.a.d0.j;
import e.a.a.k0.c;
import e.a.a.m;
import e.a.a.n;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class e implements n {

    /* renamed from: a  reason: collision with root package name */
    public final Log f4852a = LogFactory.getLog(e.class);

    public void b(m mVar, c cVar) {
        String str;
        Log log;
        if (mVar == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        } else if (cVar == null) {
            throw new IllegalArgumentException("HTTP context may not be null");
        } else if (!mVar.j("Proxy-Authorization")) {
            j jVar = (j) cVar.b("http.connection");
            if (jVar == null) {
                log = this.f4852a;
                str = "HTTP connection not set in the context";
            } else if (!jVar.g().f()) {
                e.a.a.b0.e eVar = (e.a.a.b0.e) cVar.b("http.auth.proxy-scope");
                if (eVar == null) {
                    log = this.f4852a;
                    str = "Proxy auth state not set in the context";
                } else {
                    a aVar = eVar.f4842a;
                    if (aVar != null) {
                        h hVar = eVar.f4844c;
                        if (hVar == null) {
                            log = this.f4852a;
                            str = "User credentials not available";
                        } else if (eVar.f4843b != null || !aVar.e()) {
                            try {
                                mVar.h(aVar instanceof g ? ((g) aVar).a(hVar, mVar, cVar) : aVar.c(hVar, mVar));
                                return;
                            } catch (f e2) {
                                if (this.f4852a.isErrorEnabled()) {
                                    Log log2 = this.f4852a;
                                    StringBuilder n = a.a.a.a.a.n("Proxy authentication error: ");
                                    n.append(e2.getMessage());
                                    log2.error(n.toString());
                                    return;
                                }
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } else {
                return;
            }
            log.debug(str);
        }
    }
}
