package e.a.a.k0;

import e.a.a.f;
import e.a.a.i0.l;
import e.a.a.j;
import e.a.a.k;
import e.a.a.m;
import e.a.a.n;
import e.a.a.q;
import e.a.a.v;
import e.a.a.w;
import java.net.InetAddress;

public class i implements n {
    public void b(m mVar, c cVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        } else if (cVar != null) {
            w wVar = ((l) mVar.f()).f5153a;
            if ((!((l) mVar.f()).f5154b.equalsIgnoreCase("CONNECT") || !wVar.c(q.f5193e)) && !mVar.j("Host")) {
                j jVar = (j) cVar.b("http.target_host");
                if (jVar == null) {
                    f fVar = (f) cVar.b("http.connection");
                    if (fVar instanceof k) {
                        k kVar = (k) fVar;
                        InetAddress remoteAddress = kVar.getRemoteAddress();
                        int remotePort = kVar.getRemotePort();
                        if (remoteAddress != null) {
                            jVar = new j(remoteAddress.getHostName(), remotePort, (String) null);
                        }
                    }
                    if (jVar == null) {
                        if (!wVar.c(q.f5193e)) {
                            throw new v("Target host missing");
                        }
                        return;
                    }
                }
                mVar.e("Host", jVar.b());
            }
        } else {
            throw new IllegalArgumentException("HTTP context may not be null");
        }
    }
}
