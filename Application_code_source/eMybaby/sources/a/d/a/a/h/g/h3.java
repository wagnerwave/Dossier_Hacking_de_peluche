package a.d.a.a.h.g;

import a.c.a.d.a;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class h3 extends z2<K, V> {
    @NullableDecl

    /* renamed from: a  reason: collision with root package name */
    public final K f1721a;

    /* renamed from: b  reason: collision with root package name */
    public int f1722b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c3 f1723c;

    public h3(c3 c3Var, int i) {
        this.f1723c = c3Var;
        this.f1721a = c3Var.f1637c[i];
        this.f1722b = i;
    }

    public final void a() {
        int i = this.f1722b;
        if (i == -1 || i >= this.f1723c.size() || !a.z(this.f1721a, this.f1723c.f1637c[this.f1722b])) {
            this.f1722b = this.f1723c.b(this.f1721a);
        }
    }

    @NullableDecl
    public final K getKey() {
        return this.f1721a;
    }

    @NullableDecl
    public final V getValue() {
        Map g = this.f1723c.g();
        if (g != null) {
            return g.get(this.f1721a);
        }
        a();
        int i = this.f1722b;
        if (i == -1) {
            return null;
        }
        return this.f1723c.f1638d[i];
    }

    public final V setValue(V v) {
        Map g = this.f1723c.g();
        if (g != null) {
            return g.put(this.f1721a, v);
        }
        a();
        int i = this.f1722b;
        if (i == -1) {
            this.f1723c.put(this.f1721a, v);
            return null;
        }
        V[] vArr = this.f1723c.f1638d;
        V v2 = vArr[i];
        vArr[i] = v;
        return v2;
    }
}
