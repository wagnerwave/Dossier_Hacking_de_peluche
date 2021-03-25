package e.a.a.k0;

import e.a.a.j0.c;
import e.a.a.m;
import e.a.a.n;

public class j implements n {
    public void b(m mVar, c cVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        } else if (!mVar.j("User-Agent")) {
            c params = mVar.getParams();
            if (params != null) {
                String str = (String) params.e("http.useragent");
                if (str != null) {
                    mVar.e("User-Agent", str);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
    }
}
