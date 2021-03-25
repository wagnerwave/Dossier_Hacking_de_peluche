package a.g.a.a.b;

import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class a<K, V> implements c<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public final Map<K, Reference<V>> f3346a = Collections.synchronizedMap(new HashMap());

    public abstract Reference<V> a(V v);

    public void clear() {
        this.f3346a.clear();
    }

    public V get(K k) {
        Reference reference = this.f3346a.get(k);
        if (reference != null) {
            return reference.get();
        }
        return null;
    }

    public Collection<K> keys() {
        return this.f3346a.keySet();
    }

    public boolean put(K k, V v) {
        this.f3346a.put(k, a(v));
        return true;
    }

    public void remove(K k) {
        this.f3346a.remove(k);
    }
}
