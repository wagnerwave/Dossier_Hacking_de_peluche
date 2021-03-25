package e.a.a.c0.l;

import e.a.a.i0.l;
import e.a.a.k0.c;
import e.a.a.m;
import e.a.a.n;
import java.util.Collection;

public class d implements n {
    public void b(m mVar, c cVar) {
        Collection<e.a.a.c> collection;
        if (mVar == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        } else if (!((l) mVar.f()).f5154b.equalsIgnoreCase("CONNECT") && (collection = (Collection) mVar.getParams().e("http.default-headers")) != null) {
            for (e.a.a.c h : collection) {
                mVar.h(h);
            }
        }
    }
}
