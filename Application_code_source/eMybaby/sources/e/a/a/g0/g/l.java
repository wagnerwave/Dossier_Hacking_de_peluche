package e.a.a.g0.g;

import e.a.a.i0.m;
import e.a.a.k0.c;
import e.a.a.o;
import java.util.List;
import java.util.Map;

public class l extends a {
    public boolean a(o oVar, c cVar) {
        if (oVar != null) {
            return ((m) oVar.s()).f5157b == 401;
        }
        throw new IllegalArgumentException("HTTP response may not be null");
    }

    public Map<String, e.a.a.c> b(o oVar, c cVar) {
        if (oVar != null) {
            return d(oVar.p("WWW-Authenticate"));
        }
        throw new IllegalArgumentException("HTTP response may not be null");
    }

    public List<String> c(o oVar, c cVar) {
        List<String> list = (List) oVar.getParams().e("http.auth.target-scheme-pref");
        return list != null ? list : a.f4974b;
    }
}
