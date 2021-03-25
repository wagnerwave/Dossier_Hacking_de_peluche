package a.d.a.a.i.b;

public final class l6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f2350a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f6 f2351b;

    public l6(f6 f6Var, long j) {
        this.f2351b = f6Var;
        this.f2350a = j;
    }

    public final void run() {
        this.f2351b.k().q.b(this.f2350a);
        this.f2351b.i().m.b("Session timeout duration set", Long.valueOf(this.f2350a));
    }
}
