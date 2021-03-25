package a.d.a.a.h.g;

public final class xb implements ub {

    /* renamed from: a  reason: collision with root package name */
    public static final c2<Boolean> f2035a;

    /* renamed from: b  reason: collision with root package name */
    public static final c2<Boolean> f2036b;

    /* renamed from: c  reason: collision with root package name */
    public static final c2<Boolean> f2037c;

    static {
        l2 l2Var = new l2(d2.a("com.google.android.gms.measurement"));
        c2.b(l2Var, "measurement.id.lifecycle.app_in_background_parameter", 0);
        f2035a = c2.d(l2Var, "measurement.lifecycle.app_backgrounded_engagement", false);
        f2036b = c2.d(l2Var, "measurement.lifecycle.app_backgrounded_tracking", true);
        f2037c = c2.d(l2Var, "measurement.lifecycle.app_in_background_parameter", false);
        c2.b(l2Var, "measurement.id.lifecycle.app_backgrounded_tracking", 0);
    }

    public final boolean a() {
        return f2035a.h().booleanValue();
    }

    public final boolean b() {
        return f2036b.h().booleanValue();
    }

    public final boolean c() {
        return f2037c.h().booleanValue();
    }
}
