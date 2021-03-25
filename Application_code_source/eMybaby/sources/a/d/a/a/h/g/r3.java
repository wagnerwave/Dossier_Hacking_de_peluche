package a.d.a.a.h.g;

import a.c.a.d.a;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class r3<K, V> implements Serializable, Map<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public transient u3<Map.Entry<K, V>> f1912a;

    /* renamed from: b  reason: collision with root package name */
    public transient u3<K> f1913b;

    /* renamed from: c  reason: collision with root package name */
    public transient n3<V> f1914c;

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(@NullableDecl Object obj) {
        return ((n3) values()).contains(obj);
    }

    public Set entrySet() {
        u3<Map.Entry<K, V>> u3Var = this.f1912a;
        if (u3Var != null) {
            return u3Var;
        }
        x3 x3Var = (x3) this;
        a4 a4Var = new a4(x3Var, x3Var.f2024e, x3Var.f);
        this.f1912a = a4Var;
        return a4Var;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public abstract V get(@NullableDecl Object obj);

    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    public int hashCode() {
        return a.u((u3) entrySet());
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Set keySet() {
        u3<K> u3Var = this.f1913b;
        if (u3Var != null) {
            return u3Var;
        }
        x3 x3Var = (x3) this;
        c4 c4Var = new c4(x3Var, new b4(x3Var.f2024e, 0, x3Var.f));
        this.f1913b = c4Var;
        return c4Var;
    }

    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        int size = size();
        if (size >= 0) {
            StringBuilder sb = new StringBuilder((int) Math.min(((long) size) << 3, 1073741824));
            sb.append('{');
            boolean z = true;
            for (Map.Entry entry : entrySet()) {
                if (!z) {
                    sb.append(", ");
                }
                z = false;
                sb.append(entry.getKey());
                sb.append('=');
                sb.append(entry.getValue());
            }
            sb.append('}');
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder("size".length() + 40);
        sb2.append("size");
        sb2.append(" cannot be negative but was: ");
        sb2.append(size);
        throw new IllegalArgumentException(sb2.toString());
    }

    public Collection values() {
        n3<V> n3Var = this.f1914c;
        if (n3Var != null) {
            return n3Var;
        }
        x3 x3Var = (x3) this;
        b4 b4Var = new b4(x3Var.f2024e, 1, x3Var.f);
        this.f1914c = b4Var;
        return b4Var;
    }
}
