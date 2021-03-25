package a.d.a.a.h.g;

public final class e9 implements f9 {

    /* renamed from: a  reason: collision with root package name */
    public static final c2<Boolean> f1675a;

    /* renamed from: b  reason: collision with root package name */
    public static final c2<Boolean> f1676b;

    /* renamed from: c  reason: collision with root package name */
    public static final c2<Boolean> f1677c;

    static {
        l2 l2Var = new l2(d2.a("com.google.android.gms.measurement"));
        f1675a = c2.d(l2Var, "measurement.client.ad_impression.dev", false);
        f1676b = c2.d(l2Var, "measurement.service.separate_public_internal_event_blacklisting", false);
        f1677c = c2.d(l2Var, "measurement.service.ad_impression", false);
        c2.b(l2Var, "measurement.id.service.ad_impression", 0);
    }

    public final boolean a() {
        return true;
    }

    public final boolean b() {
        return f1675a.h().booleanValue();
    }

    public final boolean c() {
        return f1676b.h().booleanValue();
    }

    public final boolean d() {
        return f1677c.h().booleanValue();
    }
}
