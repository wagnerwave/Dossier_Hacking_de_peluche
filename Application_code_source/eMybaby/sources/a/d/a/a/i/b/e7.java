package a.d.a.a.i.b;

public final class e7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f2169a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f6 f2170b;

    public e7(f6 f6Var, boolean z) {
        this.f2170b = f6Var;
        this.f2169a = z;
    }

    public final void run() {
        boolean d2 = this.f2170b.f2563a.d();
        boolean B = this.f2170b.f2563a.B();
        this.f2170b.f2563a.A = Boolean.valueOf(this.f2169a);
        if (B == this.f2169a) {
            this.f2170b.f2563a.i().n.b("Default data collection state already set to", Boolean.valueOf(this.f2169a));
        }
        if (this.f2170b.f2563a.d() == d2 || this.f2170b.f2563a.d() != this.f2170b.f2563a.B()) {
            this.f2170b.f2563a.i().k.c("Default data collection is different than actual status", Boolean.valueOf(this.f2169a), Boolean.valueOf(d2));
        }
        this.f2170b.P();
    }
}
