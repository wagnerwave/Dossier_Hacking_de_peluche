package e.a.a.c0.l;

import e.a.a.d0.j;
import e.a.a.d0.l.a;
import e.a.a.i0.l;
import e.a.a.m;
import e.a.a.n;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class c implements n {

    /* renamed from: a  reason: collision with root package name */
    public final Log f4851a = LogFactory.getLog(c.class);

    public void b(m mVar, e.a.a.k0.c cVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        } else if (((l) mVar.f()).f5154b.equalsIgnoreCase("CONNECT")) {
            mVar.o("Proxy-Connection", "Keep-Alive");
        } else {
            j jVar = (j) cVar.b("http.connection");
            if (jVar == null) {
                this.f4851a.debug("HTTP connection not set in the context");
                return;
            }
            a g = jVar.g();
            if ((g.b() == 1 || g.f()) && !mVar.j("Connection")) {
                mVar.e("Connection", "Keep-Alive");
            }
            if (g.b() == 2 && !g.f() && !mVar.j("Proxy-Connection")) {
                mVar.e("Proxy-Connection", "Keep-Alive");
            }
        }
    }
}
