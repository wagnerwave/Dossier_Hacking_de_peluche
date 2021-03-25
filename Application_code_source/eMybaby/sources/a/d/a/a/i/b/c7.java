package a.d.a.a.i.b;

public final class c7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f2132a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f2133b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f2134c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f2135d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f2136e;
    public final /* synthetic */ f6 f;

    public c7(f6 f6Var, e eVar, long j, int i, long j2, boolean z) {
        this.f = f6Var;
        this.f2132a = eVar;
        this.f2133b = j;
        this.f2134c = i;
        this.f2135d = j2;
        this.f2136e = z;
    }

    public final void run() {
        this.f.A(this.f2132a);
        this.f.y(this.f2133b, false);
        f6.C(this.f, this.f2132a, this.f2134c, this.f2135d, true, this.f2136e);
    }
}
