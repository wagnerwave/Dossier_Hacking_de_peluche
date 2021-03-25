package a.d.a.a.h.g;

public final class v9 implements s9 {

    /* renamed from: a  reason: collision with root package name */
    public static final c2<Boolean> f1989a;

    /* renamed from: b  reason: collision with root package name */
    public static final c2<Boolean> f1990b;

    static {
        l2 l2Var = new l2(d2.a("com.google.android.gms.measurement"));
        f1989a = c2.d(l2Var, "measurement.service.configurable_service_limits", true);
        f1990b = c2.d(l2Var, "measurement.client.configurable_service_limits", true);
        c2.b(l2Var, "measurement.id.service.configurable_service_limits", 0);
    }

    public final boolean a() {
        return true;
    }

    public final boolean b() {
        return f1989a.h().booleanValue();
    }

    public final boolean c() {
        return f1990b.h().booleanValue();
    }
}
