package a.d.a.a.h.f;

public final /* synthetic */ class z0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final y0 f1587a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1588b;

    /* renamed from: c  reason: collision with root package name */
    public final r0 f1589c;

    public z0(y0 y0Var, int i, r0 r0Var) {
        this.f1587a = y0Var;
        this.f1588b = i;
        this.f1589c = r0Var;
    }

    public final void run() {
        y0 y0Var = this.f1587a;
        int i = this.f1588b;
        r0 r0Var = this.f1589c;
        if (((c1) y0Var.f1583b).b(i)) {
            r0Var.o("Local AnalyticsService processed last dispatch request");
        }
    }
}
