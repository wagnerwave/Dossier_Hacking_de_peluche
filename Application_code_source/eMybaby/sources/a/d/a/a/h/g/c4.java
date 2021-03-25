package a.d.a.a.h.g;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class c4<K> extends u3<K> {

    /* renamed from: c  reason: collision with root package name */
    public final transient r3<K, ?> f1640c;

    /* renamed from: d  reason: collision with root package name */
    public final transient m3<K> f1641d;

    public c4(r3<K, ?> r3Var, m3<K> m3Var) {
        this.f1640c = r3Var;
        this.f1641d = m3Var;
    }

    public final int c(Object[] objArr, int i) {
        return this.f1641d.c(objArr, i);
    }

    public final boolean contains(@NullableDecl Object obj) {
        return this.f1640c.get(obj) != null;
    }

    /* renamed from: d */
    public final e4<K> iterator() {
        return (e4) this.f1641d.iterator();
    }

    public final boolean m() {
        return true;
    }

    public final m3<K> o() {
        return this.f1641d;
    }

    public final int size() {
        return this.f1640c.size();
    }
}
