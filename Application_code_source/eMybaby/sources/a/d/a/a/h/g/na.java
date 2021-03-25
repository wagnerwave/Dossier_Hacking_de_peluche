package a.d.a.a.h.g;

public final class na implements ka {

    /* renamed from: a  reason: collision with root package name */
    public static final c2<Boolean> f1854a;

    /* renamed from: b  reason: collision with root package name */
    public static final c2<Boolean> f1855b;

    /* renamed from: c  reason: collision with root package name */
    public static final c2<Boolean> f1856c;

    static {
        l2 l2Var = new l2(d2.a("com.google.android.gms.measurement"));
        c2.d(l2Var, "measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        f1854a = c2.d(l2Var, "measurement.audience.refresh_event_count_filters_timestamp", false);
        f1855b = c2.d(l2Var, "measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        f1856c = c2.d(l2Var, "measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }

    public final boolean a() {
        return true;
    }

    public final boolean b() {
        return f1854a.h().booleanValue();
    }

    public final boolean c() {
        return f1855b.h().booleanValue();
    }

    public final boolean d() {
        return f1856c.h().booleanValue();
    }
}
