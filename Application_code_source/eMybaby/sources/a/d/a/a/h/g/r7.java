package a.d.a.a.h.g;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class r7 {

    /* renamed from: c  reason: collision with root package name */
    public static final r7 f1920c = new r7();

    /* renamed from: a  reason: collision with root package name */
    public final x7 f1921a = new v6();

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentMap<Class<?>, v7<?>> f1922b = new ConcurrentHashMap();

    public final <T> v7<T> a(Class<T> cls) {
        v7 v7Var;
        b7 b7Var;
        n5<?> n5Var;
        h8<?, ?> h8Var;
        s6 s6Var;
        o7 o7Var;
        n5<?> n5Var2;
        h8<?, ?> h8Var2;
        s6 s6Var2;
        o7 o7Var2;
        n5<?> n5Var3;
        h8<?, ?> h8Var3;
        s6 s6Var3;
        v7 m7Var;
        a6.f(cls, "messageType");
        v7<T> v7Var2 = (v7) this.f1922b.get(cls);
        if (v7Var2 != null) {
            return v7Var2;
        }
        v6 v6Var = (v6) this.f1921a;
        if (v6Var != null) {
            Class<y5> cls2 = y5.class;
            w7.n(cls);
            g7 b2 = v6Var.f1988a.b(cls);
            if (b2.b()) {
                if (cls2.isAssignableFrom(cls)) {
                    m7Var = new m7(w7.f2011d, o5.f1865a, b2.c());
                } else {
                    h8<?, ?> h8Var4 = w7.f2009b;
                    n5<?> n5Var4 = o5.f1866b;
                    if (n5Var4 != null) {
                        m7Var = new m7(h8Var4, n5Var4, b2.c());
                    } else {
                        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                    }
                }
                v7Var = m7Var;
            } else {
                boolean isAssignableFrom = cls2.isAssignableFrom(cls);
                boolean z = false;
                if (isAssignableFrom) {
                    if (b2.a() == 1) {
                        z = true;
                    }
                    if (z) {
                        o7Var = q7.f1899b;
                        s6Var3 = s6.f1935b;
                        h8Var3 = w7.f2011d;
                        n5Var3 = o5.f1865a;
                    } else {
                        o7Var = q7.f1899b;
                        n5Var3 = null;
                        s6Var3 = s6.f1935b;
                        h8Var3 = w7.f2011d;
                    }
                    s6Var = s6Var3;
                    h8Var = h8Var3;
                    n5Var = n5Var3;
                    b7Var = d7.f1667b;
                } else {
                    if (b2.a() == 1) {
                        z = true;
                    }
                    if (z) {
                        o7Var2 = q7.f1898a;
                        s6Var2 = s6.f1934a;
                        h8Var2 = w7.f2009b;
                        n5Var2 = o5.f1866b;
                        if (n5Var2 == null) {
                            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                        }
                    } else {
                        o7Var2 = q7.f1898a;
                        n5Var2 = null;
                        s6Var2 = s6.f1934a;
                        h8Var2 = w7.f2010c;
                    }
                    s6Var = s6Var2;
                    h8Var = h8Var2;
                    b7Var = d7.f1666a;
                    n5Var = n5Var2;
                }
                v7Var = k7.n(cls, b2, o7Var, s6Var, h8Var, n5Var, b7Var);
            }
            a6.f(cls, "messageType");
            a6.f(v7Var, "schema");
            v7<T> putIfAbsent = this.f1922b.putIfAbsent(cls, v7Var);
            if (putIfAbsent != null) {
                return putIfAbsent;
            }
            return v7Var;
        }
        throw null;
    }

    public final <T> v7<T> b(T t) {
        return a(t.getClass());
    }
}
