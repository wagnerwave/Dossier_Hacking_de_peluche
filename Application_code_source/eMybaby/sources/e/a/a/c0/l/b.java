package e.a.a.c0.l;

import e.a.a.b0.a;
import e.a.a.b0.d;
import e.a.a.b0.e;
import e.a.a.b0.h;
import e.a.a.c0.f;
import e.a.a.j;
import e.a.a.k0.c;
import e.a.a.m;
import e.a.a.n;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class b implements n {

    /* renamed from: a  reason: collision with root package name */
    public final Log f4850a = LogFactory.getLog(b.class);

    public final void a(j jVar, a aVar, e eVar, f fVar) {
        String g = aVar.g();
        if (this.f4850a.isDebugEnabled()) {
            Log log = this.f4850a;
            log.debug("Re-using cached '" + g + "' auth scheme for " + jVar);
        }
        h a2 = fVar.a(new d(jVar.f5170a, jVar.f5172c, (String) null, g));
        if (a2 != null) {
            eVar.f4842a = aVar;
            eVar.f4844c = a2;
            return;
        }
        this.f4850a.debug("No credentials for preemptive authentication");
    }

    public void b(m mVar, c cVar) {
        a a2;
        a a3;
        Log log;
        String str;
        if (mVar == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        } else if (cVar != null) {
            e.a.a.c0.a aVar = (e.a.a.c0.a) cVar.b("http.auth.auth-cache");
            if (aVar == null) {
                log = this.f4850a;
                str = "Auth cache not set in the context";
            } else {
                f fVar = (f) cVar.b("http.auth.credentials-provider");
                if (fVar == null) {
                    log = this.f4850a;
                    str = "Credentials provider not set in the context";
                } else {
                    j jVar = (j) cVar.b("http.target_host");
                    e eVar = (e) cVar.b("http.auth.target-scope");
                    if (!(jVar == null || eVar == null || eVar.f4842a != null || (a3 = aVar.a(jVar)) == null)) {
                        a(jVar, a3, eVar, fVar);
                    }
                    j jVar2 = (j) cVar.b("http.proxy_host");
                    e eVar2 = (e) cVar.b("http.auth.proxy-scope");
                    if (jVar2 != null && eVar2 != null && eVar2.f4842a == null && (a2 = aVar.a(jVar2)) != null) {
                        a(jVar2, a2, eVar2, fVar);
                        return;
                    }
                    return;
                }
            }
            log.debug(str);
        } else {
            throw new IllegalArgumentException("HTTP context may not be null");
        }
    }
}
