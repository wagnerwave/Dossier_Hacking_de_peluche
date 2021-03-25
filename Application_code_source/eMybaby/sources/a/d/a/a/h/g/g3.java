package a.d.a.a.h.g;

import a.c.a.d.a;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class g3 extends AbstractSet<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c3 f1713a;

    public g3(c3 c3Var) {
        this.f1713a = c3Var;
    }

    public final void clear() {
        this.f1713a.clear();
    }

    public final boolean contains(@NullableDecl Object obj) {
        Map g = this.f1713a.g();
        if (g != null) {
            return g.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            int b2 = this.f1713a.b(entry.getKey());
            if (b2 == -1 || !a.z(this.f1713a.f1638d[b2], entry.getValue())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        c3 c3Var = this.f1713a;
        Map g = c3Var.g();
        return g != null ? g.entrySet().iterator() : new e3(c3Var);
    }

    public final boolean remove(@NullableDecl Object obj) {
        Map g = this.f1713a.g();
        if (g != null) {
            return g.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (this.f1713a.d()) {
            return false;
        }
        int i = this.f1713a.i();
        Object key = entry.getKey();
        Object value = entry.getValue();
        c3 c3Var = this.f1713a;
        int c2 = j3.c(key, value, i, c3Var.f1635a, c3Var.f1636b, c3Var.f1637c, c3Var.f1638d);
        if (c2 == -1) {
            return false;
        }
        this.f1713a.c(c2, i);
        c3 c3Var2 = this.f1713a;
        c3Var2.f--;
        c3Var2.h();
        return true;
    }

    public final int size() {
        return this.f1713a.size();
    }
}
