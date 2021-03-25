package a.d.a.a.h.g;

public final class p9 implements m9 {

    /* renamed from: a  reason: collision with root package name */
    public static final c2<Boolean> f1885a;

    /* renamed from: b  reason: collision with root package name */
    public static final c2<Long> f1886b;

    static {
        l2 l2Var = new l2(d2.a("com.google.android.gms.measurement"));
        f1885a = c2.d(l2Var, "measurement.sdk.attribution.cache", true);
        f1886b = c2.b(l2Var, "measurement.sdk.attribution.cache.ttl", 604800000);
    }

    public final boolean a() {
        return f1885a.h().booleanValue();
    }

    public final long b() {
        return f1886b.h().longValue();
    }
}
