package a.d.a.a.h.g;

import java.util.Map;

public final class l6<K> implements Map.Entry<K, Object> {

    /* renamed from: a  reason: collision with root package name */
    public Map.Entry<K, j6> f1807a;

    public l6(Map.Entry entry, m6 m6Var) {
        this.f1807a = entry;
    }

    public final K getKey() {
        return this.f1807a.getKey();
    }

    public final Object getValue() {
        if (this.f1807a.getValue() == null) {
            return null;
        }
        j6.d();
        throw null;
    }

    public final Object setValue(Object obj) {
        if (obj instanceof i7) {
            j6 value = this.f1807a.getValue();
            i7 i7Var = value.f1844a;
            value.f1845b = null;
            value.f1844a = (i7) obj;
            return i7Var;
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
