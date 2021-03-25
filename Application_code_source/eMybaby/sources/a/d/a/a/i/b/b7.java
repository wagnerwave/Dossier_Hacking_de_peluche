package a.d.a.a.i.b;

public final class b7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f2102a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f2103b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f2104c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f2105d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ f6 f2106e;

    public b7(f6 f6Var, e eVar, int i, long j, boolean z) {
        this.f2106e = f6Var;
        this.f2102a = eVar;
        this.f2103b = i;
        this.f2104c = j;
        this.f2105d = z;
    }

    public final void run() {
        this.f2106e.A(this.f2102a);
        f6.C(this.f2106e, this.f2102a, this.f2103b, this.f2104c, false, this.f2105d);
    }
}
