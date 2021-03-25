package d.a.a.i;

import e.a.a.c0.g;
import e.a.a.d0.m.e;
import e.a.a.d0.m.f;
import e.a.a.d0.m.j;
import e.a.a.d0.n.d;
import e.a.a.g0.h.o.h;
import e.a.a.q;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public g f4833a;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f4834a = new a((C0105a) null);
    }

    public a(C0105a aVar) {
        e.a.a.j0.b bVar = new e.a.a.j0.b();
        bVar.setParameter("http.protocol.version", q.f);
        bVar.setParameter("http.protocol.content-charset", "utf-8");
        bVar.setParameter("http.protocol.expect-continue", Boolean.FALSE);
        bVar.f5174a.put("http.useragent", "HockeySDK/Android");
        e.a.a.d0.m.g gVar = new e.a.a.d0.m.g();
        gVar.b(new f("http", (j) new e(), 80));
        d dVar = new d();
        e.a.a.d0.n.g gVar2 = d.f4890d;
        if (gVar2 != null) {
            dVar.f4893c = gVar2;
            gVar.b(new f("https", (j) dVar, 443));
            this.f4833a = new e.a.a.g0.g.g(new h(bVar, gVar), bVar);
            return;
        }
        throw new IllegalArgumentException("Hostname verifier may not be null");
    }
}
