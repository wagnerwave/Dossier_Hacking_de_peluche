package e.a.a.c0.l;

import e.a.a.b0.a;
import e.a.a.b0.e;
import e.a.a.b0.g;
import e.a.a.b0.h;
import e.a.a.i0.l;
import e.a.a.k0.c;
import e.a.a.m;
import e.a.a.n;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class f implements n {

    /* renamed from: a  reason: collision with root package name */
    public final Log f4853a = LogFactory.getLog(f.class);

    public void b(m mVar, c cVar) {
        String str;
        Log log;
        if (mVar == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        } else if (cVar == null) {
            throw new IllegalArgumentException("HTTP context may not be null");
        } else if (!((l) mVar.f()).f5154b.equalsIgnoreCase("CONNECT") && !mVar.j("Authorization")) {
            e eVar = (e) cVar.b("http.auth.target-scope");
            if (eVar == null) {
                log = this.f4853a;
                str = "Target auth state not set in the context";
            } else {
                a aVar = eVar.f4842a;
                if (aVar != null) {
                    h hVar = eVar.f4844c;
                    if (hVar == null) {
                        log = this.f4853a;
                        str = "User credentials not available";
                    } else if (eVar.f4843b != null || !aVar.e()) {
                        try {
                            mVar.h(aVar instanceof g ? ((g) aVar).a(hVar, mVar, cVar) : aVar.c(hVar, mVar));
                            return;
                        } catch (e.a.a.b0.f e2) {
                            if (this.f4853a.isErrorEnabled()) {
                                Log log2 = this.f4853a;
                                StringBuilder n = a.a.a.a.a.n("Authentication error: ");
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
            log.debug(str);
        }
    }
}
