package a.d.a.a.h.g;

public final class fb implements cb {

    /* renamed from: a  reason: collision with root package name */
    public static final c2<Boolean> f1707a;

    /* renamed from: b  reason: collision with root package name */
    public static final c2<Boolean> f1708b;

    static {
        l2 l2Var = new l2(d2.a("com.google.android.gms.measurement"));
        f1707a = c2.d(l2Var, "measurement.collection.efficient_engagement_reporting_enabled_2", true);
        f1708b = c2.d(l2Var, "measurement.collection.redundant_engagement_removal_enabled", false);
        c2.b(l2Var, "measurement.id.collection.redundant_engagement_removal_enabled", 0);
    }

    public final boolean a() {
        return f1707a.h().booleanValue();
    }

    public final boolean b() {
        return f1708b.h().booleanValue();
    }
}
