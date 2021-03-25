package a.d.a.a.h.g;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;

public final class k3 extends AbstractCollection<V> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c3 f1769a;

    public k3(c3 c3Var) {
        this.f1769a = c3Var;
    }

    public final void clear() {
        this.f1769a.clear();
    }

    public final Iterator<V> iterator() {
        c3 c3Var = this.f1769a;
        Map g = c3Var.g();
        return g != null ? g.values().iterator() : new d3(c3Var);
    }

    public final int size() {
        return this.f1769a.size();
    }
}
