package a.d.b.m;

import a.d.b.g.e;
import a.d.b.g.h;
import a.d.b.g.x;
import java.util.Set;

public final /* synthetic */ class b implements h {

    /* renamed from: a  reason: collision with root package name */
    public static final b f2850a = new b();

    public Object a(e eVar) {
        Set<e> b2 = ((x) eVar).b(e.class);
        d dVar = d.f2853b;
        if (dVar == null) {
            synchronized (d.class) {
                dVar = d.f2853b;
                if (dVar == null) {
                    dVar = new d();
                    d.f2853b = dVar;
                }
            }
        }
        return new c(b2, dVar);
    }
}
