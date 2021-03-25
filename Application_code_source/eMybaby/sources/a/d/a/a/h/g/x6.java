package a.d.a.a.h.g;

public final class x6 implements f7 {

    /* renamed from: a  reason: collision with root package name */
    public f7[] f2027a;

    public x6(f7... f7VarArr) {
        this.f2027a = f7VarArr;
    }

    public final boolean a(Class<?> cls) {
        for (f7 a2 : this.f2027a) {
            if (a2.a(cls)) {
                return true;
            }
        }
        return false;
    }

    public final g7 b(Class<?> cls) {
        for (f7 f7Var : this.f2027a) {
            if (f7Var.a(cls)) {
                return f7Var.b(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
