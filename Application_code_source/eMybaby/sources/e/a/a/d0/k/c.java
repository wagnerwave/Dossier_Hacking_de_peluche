package e.a.a.d0.k;

import e.a.a.d0.l.a;
import e.a.a.d0.l.b;
import e.a.a.j;
import java.net.InetAddress;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final j f4862a;

    /* renamed from: b  reason: collision with root package name */
    public static final a f4863b;

    static {
        j jVar = new j("127.0.0.255", 0, "no-host");
        f4862a = jVar;
        f4863b = new a((InetAddress) null, jVar, a.g, false, e.a.a.d0.l.c.PLAIN, b.PLAIN);
    }

    public static a a(e.a.a.j0.c cVar) {
        if (cVar != null) {
            a aVar = (a) cVar.e("http.route.forced-route");
            if (aVar == null || !f4863b.equals(aVar)) {
                return aVar;
            }
            return null;
        }
        throw new IllegalArgumentException("Parameters must not be null.");
    }
}
