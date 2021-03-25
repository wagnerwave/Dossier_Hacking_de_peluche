package a.d.a.a.h.g;

public final class yb implements zb {

    /* renamed from: a  reason: collision with root package name */
    public static final c2<Boolean> f2052a;

    /* renamed from: b  reason: collision with root package name */
    public static final c2<Boolean> f2053b;

    static {
        l2 l2Var = new l2(d2.a("com.google.android.gms.measurement"));
        f2052a = c2.d(l2Var, "measurement.sdk.screen.manual_screen_view_logging", true);
        f2053b = c2.d(l2Var, "measurement.sdk.screen.disabling_automatic_reporting", true);
    }

    public final boolean a() {
        return true;
    }

    public final boolean b() {
        return f2052a.h().booleanValue();
    }

    public final boolean c() {
        return f2053b.h().booleanValue();
    }
}
