package a.d.a.a.h.g;

import a.c.a.d.a;
import java.util.AbstractMap;
import java.util.Map;

public final class z3 extends m3<Map.Entry<K, V>> {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a4 f2055c;

    public z3(a4 a4Var) {
        this.f2055c = a4Var;
    }

    public final /* synthetic */ Object get(int i) {
        a.s(i, this.f2055c.f1595e);
        Object[] objArr = this.f2055c.f1594d;
        int i2 = i * 2;
        return new AbstractMap.SimpleImmutableEntry(objArr[i2], objArr[i2 + 1]);
    }

    public final boolean m() {
        return true;
    }

    public final int size() {
        return this.f2055c.f1595e;
    }
}
