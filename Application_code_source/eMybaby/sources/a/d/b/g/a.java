package a.d.b.g;

import java.util.Set;

public abstract class a implements e {
    public <T> T a(Class<T> cls) {
        a.d.b.j.a<T> c2 = c(cls);
        if (c2 == null) {
            return null;
        }
        return c2.get();
    }

    public <T> Set<T> b(Class<T> cls) {
        return d(cls).get();
    }
}
