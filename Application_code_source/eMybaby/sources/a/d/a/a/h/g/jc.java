package a.d.a.a.h.g;

public final class jc implements gc {

    /* renamed from: a  reason: collision with root package name */
    public static final c2<Boolean> f1753a;

    /* renamed from: b  reason: collision with root package name */
    public static final c2<Double> f1754b;

    /* renamed from: c  reason: collision with root package name */
    public static final c2<Long> f1755c;

    /* renamed from: d  reason: collision with root package name */
    public static final c2<Long> f1756d;

    /* renamed from: e  reason: collision with root package name */
    public static final c2<String> f1757e;

    static {
        l2 l2Var = new l2(d2.a("com.google.android.gms.measurement"));
        f1753a = c2.d(l2Var, "measurement.test.boolean_flag", false);
        f1754b = c2.a(l2Var, "measurement.test.double_flag");
        f1755c = c2.b(l2Var, "measurement.test.int_flag", -2);
        f1756d = c2.b(l2Var, "measurement.test.long_flag", -1);
        f1757e = c2.c(l2Var, "measurement.test.string_flag", "---");
    }

    public final boolean a() {
        return f1753a.h().booleanValue();
    }

    public final double b() {
        return f1754b.h().doubleValue();
    }

    public final long c() {
        return f1755c.h().longValue();
    }

    public final long d() {
        return f1756d.h().longValue();
    }

    public final String e() {
        return f1757e.h();
    }
}
