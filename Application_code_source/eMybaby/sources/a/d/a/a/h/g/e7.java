package a.d.a.a.h.g;

import java.util.Iterator;
import java.util.Map;

public final class e7 implements b7 {
    public final Map<?, ?> b(Object obj) {
        return (c7) obj;
    }

    public final Object c(Object obj) {
        ((c7) obj).f1645a = false;
        return obj;
    }

    public final Object d(Object obj, Object obj2) {
        c7 c7Var = (c7) obj;
        c7 c7Var2 = (c7) obj2;
        if (!c7Var2.isEmpty()) {
            if (!c7Var.f1645a) {
                c7Var = c7Var.isEmpty() ? new c7() : new c7(c7Var);
            }
            c7Var.c();
            if (!c7Var2.isEmpty()) {
                c7Var.putAll(c7Var2);
            }
        }
        return c7Var;
    }

    public final boolean e(Object obj) {
        return !((c7) obj).f1645a;
    }

    public final Map<?, ?> f(Object obj) {
        return (c7) obj;
    }

    public final z6<?, ?> g(Object obj) {
        a7 a7Var = (a7) obj;
        throw new NoSuchMethodError();
    }

    public final Object h(Object obj) {
        c7 c7Var = c7.f1644b;
        return c7Var.isEmpty() ? new c7() : new c7(c7Var);
    }

    public final int i(int i, Object obj, Object obj2) {
        c7 c7Var = (c7) obj;
        a7 a7Var = (a7) obj2;
        if (c7Var.isEmpty()) {
            return 0;
        }
        Iterator it = c7Var.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
