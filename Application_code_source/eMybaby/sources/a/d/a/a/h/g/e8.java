package a.d.a.a.h.g;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

public class e8 extends AbstractSet<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ z7 f1674a;

    public e8(z7 z7Var, y7 y7Var) {
        this.f1674a = z7Var;
    }

    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.f1674a.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    public void clear() {
        this.f1674a.clear();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.f1674a.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 != value) {
            return obj2 != null && obj2.equals(value);
        }
        return true;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new f8(this.f1674a, (y7) null);
    }

    public boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.f1674a.remove(entry.getKey());
        return true;
    }

    public int size() {
        return this.f1674a.size();
    }
}
