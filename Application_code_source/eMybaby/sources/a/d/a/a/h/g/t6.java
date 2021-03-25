package a.d.a.a.h.g;

public final class t6 extends s6 {
    public t6(r6 r6Var) {
        super((r6) null);
    }

    public static <E> f6<E> c(Object obj, long j) {
        return (f6) n8.r(obj, j);
    }

    public final <E> void a(Object obj, Object obj2, long j) {
        f6 c2 = c(obj, j);
        f6 c3 = c(obj2, j);
        int size = c2.size();
        int size2 = c3.size();
        if (size > 0 && size2 > 0) {
            if (!c2.a()) {
                c2 = c2.f(size2 + size);
            }
            c2.addAll(c3);
        }
        if (size > 0) {
            c3 = c2;
        }
        n8.f(obj, j, c3);
    }

    public final void b(Object obj, long j) {
        c(obj, j).k();
    }
}
