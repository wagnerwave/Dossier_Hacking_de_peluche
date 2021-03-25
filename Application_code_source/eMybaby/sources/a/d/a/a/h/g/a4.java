package a.d.a.a.h.g;

import java.util.Map;

public final class a4<K, V> extends u3<Map.Entry<K, V>> {

    /* renamed from: c  reason: collision with root package name */
    public final transient r3<K, V> f1593c;

    /* renamed from: d  reason: collision with root package name */
    public final transient Object[] f1594d;

    /* renamed from: e  reason: collision with root package name */
    public final transient int f1595e;

    public a4(r3 r3Var, Object[] objArr, int i) {
        this.f1593c = r3Var;
        this.f1594d = objArr;
        this.f1595e = i;
    }

    public final int c(Object[] objArr, int i) {
        return o().c(objArr, i);
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.f1593c.get(key));
        }
    }

    /* renamed from: d */
    public final e4<Map.Entry<K, V>> iterator() {
        return (e4) o().iterator();
    }

    public final boolean m() {
        return true;
    }

    public final m3<Map.Entry<K, V>> p() {
        return new z3(this);
    }

    public final int size() {
        return this.f1595e;
    }
}
