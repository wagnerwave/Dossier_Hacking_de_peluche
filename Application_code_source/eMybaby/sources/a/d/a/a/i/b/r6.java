package a.d.a.a.i.b;

import a.c.a.f.b;

public final class r6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e6 f2501a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f6 f2502b;

    public r6(f6 f6Var, e6 e6Var) {
        this.f2502b = f6Var;
        this.f2501a = e6Var;
    }

    public final void run() {
        e6 e6Var;
        f6 f6Var = this.f2502b;
        e6 e6Var2 = this.f2501a;
        f6Var.b();
        f6Var.u();
        if (!(e6Var2 == null || e6Var2 == (e6Var = f6Var.f2194d))) {
            b.o(e6Var == null, "EventInterceptor already set.");
        }
        f6Var.f2194d = e6Var2;
    }
}
