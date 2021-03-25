package a.d.a.a.h.g;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class i3 extends AbstractSet<K> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c3 f1733a;

    public i3(c3 c3Var) {
        this.f1733a = c3Var;
    }

    public final void clear() {
        this.f1733a.clear();
    }

    public final boolean contains(Object obj) {
        return this.f1733a.containsKey(obj);
    }

    public final Iterator<K> iterator() {
        c3 c3Var = this.f1733a;
        Map g = c3Var.g();
        return g != null ? g.keySet().iterator() : new b3(c3Var);
    }

    public final boolean remove(@NullableDecl Object obj) {
        Map g = this.f1733a.g();
        if (g != null) {
            return g.keySet().remove(obj);
        }
        return this.f1733a.f(obj) != c3.j;
    }

    public final int size() {
        return this.f1733a.size();
    }
}
