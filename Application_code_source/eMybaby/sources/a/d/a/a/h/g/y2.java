package a.d.a.a.h.g;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class y2<K, V> implements w3<K, V> {
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof w3) {
            return a().equals(((w3) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return ((s3) this).f1928a.hashCode();
    }

    public String toString() {
        return ((s3) this).f1928a.toString();
    }
}
