package a.d.a.a.h.g;

public final class sb implements tb {

    /* renamed from: a  reason: collision with root package name */
    public static final c2<Boolean> f1938a;

    /* renamed from: b  reason: collision with root package name */
    public static final c2<Boolean> f1939b;

    /* renamed from: c  reason: collision with root package name */
    public static final c2<Boolean> f1940c;

    /* renamed from: d  reason: collision with root package name */
    public static final c2<Boolean> f1941d;

    static {
        l2 l2Var = new l2(d2.a("com.google.android.gms.measurement"));
        f1938a = c2.d(l2Var, "measurement.sdk.collection.enable_extend_user_property_size", true);
        f1939b = c2.d(l2Var, "measurement.sdk.collection.last_deep_link_referrer2", true);
        f1940c = c2.d(l2Var, "measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        f1941d = c2.d(l2Var, "measurement.sdk.collection.last_gclid_from_referrer2", false);
        c2.b(l2Var, "measurement.id.sdk.collection.last_deep_link_referrer2", 0);
    }

    public final boolean a() {
        return f1938a.h().booleanValue();
    }

    public final boolean b() {
        return f1939b.h().booleanValue();
    }

    public final boolean c() {
        return f1940c.h().booleanValue();
    }

    public final boolean d() {
        return f1941d.h().booleanValue();
    }
}
