package a.d.a.a.h.g;

import a.c.a.d.a;
import com.tuya.smart.common.o0ooo00oo;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class z2<K, V> implements Map.Entry<K, V> {
    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (!a.z(((h3) this).f1721a, entry.getKey()) || !a.z(getValue(), entry.getValue())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public abstract V getValue();

    public int hashCode() {
        K k = ((h3) this).f1721a;
        Object value = getValue();
        int i = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        if (value != null) {
            i = value.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        String valueOf = String.valueOf(((h3) this).f1721a);
        String valueOf2 = String.valueOf(getValue());
        return a.a.a.a.a.d(valueOf2.length() + valueOf.length() + 1, valueOf, o0ooo00oo.O0000Oo0, valueOf2);
    }
}
