package a.d.a.a.i.b;

public final class t7 extends i {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ u7 f2533e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t7(u7 u7Var, x5 x5Var) {
        super(x5Var);
        this.f2533e = u7Var;
    }

    public final void a() {
        u7 u7Var = this.f2533e;
        u7Var.b();
        if (u7Var.D()) {
            u7Var.i().n.a("Inactivity, disconnecting from the service");
            u7Var.F();
        }
    }
}
