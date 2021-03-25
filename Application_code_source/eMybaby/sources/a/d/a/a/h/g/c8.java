package a.d.a.a.h.g;

import a.a.a.a.a;
import com.tuya.smart.common.o0ooo00oo;
import java.util.Map;

public final class c8 implements Comparable<c8>, Map.Entry<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public final K f1646a;

    /* renamed from: b  reason: collision with root package name */
    public V f1647b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ z7 f1648c;

    public c8(z7 z7Var, K k, V v) {
        this.f1648c = z7Var;
        this.f1646a = k;
        this.f1647b = v;
    }

    public c8(z7 z7Var, Map.Entry<K, V> entry) {
        V value = entry.getValue();
        this.f1648c = z7Var;
        this.f1646a = (Comparable) entry.getKey();
        this.f1647b = value;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return this.f1646a.compareTo(((c8) obj).f1646a);
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        K k = this.f1646a;
        Object key = entry.getKey();
        if (k == null ? key == null : k.equals(key)) {
            V v = this.f1647b;
            Object value = entry.getValue();
            if (v == null) {
                z = value == null;
            } else {
                z = v.equals(value);
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final /* synthetic */ Object getKey() {
        return this.f1646a;
    }

    public final V getValue() {
        return this.f1647b;
    }

    public final int hashCode() {
        K k = this.f1646a;
        int i = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.f1647b;
        if (v != null) {
            i = v.hashCode();
        }
        return hashCode ^ i;
    }

    public final V setValue(V v) {
        this.f1648c.j();
        V v2 = this.f1647b;
        this.f1647b = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f1646a);
        String valueOf2 = String.valueOf(this.f1647b);
        return a.d(valueOf2.length() + valueOf.length() + 1, valueOf, o0ooo00oo.O0000Oo0, valueOf2);
    }
}
