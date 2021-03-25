package a.d.a.a.h.g;

public final class mb implements nb {

    /* renamed from: a  reason: collision with root package name */
    public static final c2<Boolean> f1837a;

    /* renamed from: b  reason: collision with root package name */
    public static final c2<Boolean> f1838b;

    /* renamed from: c  reason: collision with root package name */
    public static final c2<Boolean> f1839c;

    static {
        l2 l2Var = new l2(d2.a("com.google.android.gms.measurement"));
        f1837a = c2.d(l2Var, "measurement.client.global_params", true);
        f1838b = c2.d(l2Var, "measurement.service.global_params_in_payload", true);
        f1839c = c2.d(l2Var, "measurement.service.global_params", true);
        c2.b(l2Var, "measurement.id.service.global_params", 0);
    }

    public final boolean a() {
        return true;
    }

    public final boolean b() {
        return f1837a.h().booleanValue();
    }

    public final boolean c() {
        return f1838b.h().booleanValue();
    }

    public final boolean d() {
        return f1839c.h().booleanValue();
    }
}
