package a.d.a.a.i.b;

import java.util.ArrayList;

public final class y8 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o9 f2645a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f2646b;

    public y8(o9 o9Var, Runnable runnable) {
        this.f2645a = o9Var;
        this.f2646b = runnable;
    }

    public final void run() {
        this.f2645a.Q();
        o9 o9Var = this.f2645a;
        Runnable runnable = this.f2646b;
        o9Var.T();
        if (o9Var.n == null) {
            o9Var.n = new ArrayList();
        }
        o9Var.n.add(runnable);
        this.f2645a.P();
    }
}
