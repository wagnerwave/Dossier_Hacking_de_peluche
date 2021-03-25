package e.a.a.c0.k;

import e.a.a.c;
import e.a.a.g;
import e.a.a.h;

public abstract class b extends f implements h {
    public g f;

    public g b() {
        return this.f;
    }

    public boolean c() {
        c l = l("Expect");
        return l != null && "100-continue".equalsIgnoreCase(l.getValue());
    }

    public Object clone() {
        b bVar = (b) super.clone();
        g gVar = this.f;
        if (gVar != null) {
            bVar.f = (g) a.e.a.a.r.b.d(gVar);
        }
        return bVar;
    }
}
