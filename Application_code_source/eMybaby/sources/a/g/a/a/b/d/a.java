package a.g.a.a.b.d;

import a.g.a.a.b.c;
import java.util.Collection;
import java.util.Comparator;

public class a<K, V> implements c<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public final c<K, V> f3350a;

    /* renamed from: b  reason: collision with root package name */
    public final Comparator<K> f3351b;

    public a(c<K, V> cVar, Comparator<K> comparator) {
        this.f3350a = cVar;
        this.f3351b = comparator;
    }

    public synchronized void clear() {
        this.f3350a.clear();
    }

    public synchronized V get(K k) {
        return this.f3350a.get(k);
    }

    public synchronized Collection<K> keys() {
        return this.f3350a.keys();
    }

    public synchronized boolean put(K k, V v) {
        K k2 = null;
        for (K next : this.f3350a.keys()) {
            if (this.f3351b.compare(k, next) == 0) {
                k2 = next;
            }
        }
        this.f3350a.remove(k2);
        return this.f3350a.put(k, v);
    }

    public synchronized void remove(K k) {
        this.f3350a.remove(k);
    }
}
