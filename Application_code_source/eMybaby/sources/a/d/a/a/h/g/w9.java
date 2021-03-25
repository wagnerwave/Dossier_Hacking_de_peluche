package a.d.a.a.h.g;

public final class w9 implements x9 {

    /* renamed from: a  reason: collision with root package name */
    public static final c2<Boolean> f2012a;

    /* renamed from: b  reason: collision with root package name */
    public static final c2<Boolean> f2013b;

    /* renamed from: c  reason: collision with root package name */
    public static final c2<Long> f2014c;

    static {
        l2 l2Var = new l2(d2.a("com.google.android.gms.measurement"));
        f2012a = c2.d(l2Var, "measurement.client.consent_state_v1", false);
        f2013b = c2.d(l2Var, "measurement.service.consent_state_v1_W33", false);
        f2014c = c2.b(l2Var, "measurement.service.storage_consent_support_version", 203290);
    }

    public final boolean a() {
        return true;
    }

    public final boolean b() {
        return f2012a.h().booleanValue();
    }

    public final boolean c() {
        return f2013b.h().booleanValue();
    }

    public final long d() {
        return f2014c.h().longValue();
    }
}
