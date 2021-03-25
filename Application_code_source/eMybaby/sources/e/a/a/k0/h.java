package e.a.a.k0;

import e.a.a.g;
import e.a.a.i0.l;
import e.a.a.j0.c;
import e.a.a.m;
import e.a.a.n;
import e.a.a.q;
import e.a.a.w;

public class h implements n {
    public void b(m mVar, c cVar) {
        g b2;
        if (mVar == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        } else if ((mVar instanceof e.a.a.h) && (b2 = ((e.a.a.h) mVar).b()) != null && b2.getContentLength() != 0) {
            w wVar = ((l) mVar.f()).f5153a;
            c params = mVar.getParams();
            if (params == null) {
                throw new IllegalArgumentException("HTTP parameters may not be null");
            } else if (params.c("http.protocol.expect-continue", false) && !wVar.c(q.f5193e)) {
                mVar.e("Expect", "100-continue");
            }
        }
    }
}
