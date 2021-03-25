package a.g.a.a.b;

import java.util.Collection;

public interface c<K, V> {
    void clear();

    V get(K k);

    Collection<K> keys();

    boolean put(K k, V v);

    void remove(K k);
}
