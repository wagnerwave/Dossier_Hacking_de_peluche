package e.a.a.k0;

import e.a.a.m;
import e.a.a.n;
import e.a.a.o;
import e.a.a.p;
import java.util.ArrayList;
import java.util.List;

public final class b implements d, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public final List f5177a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final List f5178b = new ArrayList();

    public void b(m mVar, c cVar) {
        for (int i = 0; i < this.f5177a.size(); i++) {
            ((n) this.f5177a.get(i)).b(mVar, cVar);
        }
    }

    public void c(o oVar, c cVar) {
        for (int i = 0; i < this.f5178b.size(); i++) {
            ((p) this.f5178b.get(i)).c(oVar, cVar);
        }
    }

    public Object clone() {
        b bVar = (b) super.clone();
        bVar.f5177a.clear();
        bVar.f5177a.addAll(this.f5177a);
        bVar.f5178b.clear();
        bVar.f5178b.addAll(this.f5178b);
        return bVar;
    }

    public final void d(n nVar) {
        this.f5177a.add(nVar);
    }
}
