package e.a.a.j0;

public abstract class a implements c {
    public int b(String str, int i) {
        Object e2 = e(str);
        return e2 == null ? i : ((Integer) e2).intValue();
    }

    public boolean c(String str, boolean z) {
        Object e2 = e(str);
        return e2 == null ? z : ((Boolean) e2).booleanValue();
    }

    public boolean d(String str) {
        return !c(str, false);
    }

    public boolean f(String str) {
        return c(str, false);
    }

    public c g(String str, boolean z) {
        setParameter(str, z ? Boolean.TRUE : Boolean.FALSE);
        return this;
    }

    public c h(String str, int i) {
        setParameter(str, new Integer(i));
        return this;
    }
}
