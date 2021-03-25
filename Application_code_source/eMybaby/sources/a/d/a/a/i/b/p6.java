package a.d.a.a.i.b;

import java.util.concurrent.atomic.AtomicReference;

public final class p6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f2459a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f6 f2460b;

    public p6(f6 f6Var, long j) {
        this.f2460b = f6Var;
        this.f2459a = j;
    }

    public final void run() {
        this.f2460b.y(this.f2459a, true);
        this.f2460b.q().C(new AtomicReference());
    }
}
