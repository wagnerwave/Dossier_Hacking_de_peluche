package a.d.a.a.i.b;

import java.util.concurrent.atomic.AtomicReference;

public final class x6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f2622a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f6 f2623b;

    public x6(f6 f6Var, AtomicReference atomicReference) {
        this.f2623b = f6Var;
        this.f2622a = atomicReference;
    }

    public final void run() {
        synchronized (this.f2622a) {
            try {
                AtomicReference atomicReference = this.f2622a;
                ka kaVar = this.f2623b.f2563a.g;
                q3 p = this.f2623b.p();
                p.u();
                atomicReference.set(Long.valueOf(kaVar.n(p.f2474c, q.M)));
                this.f2622a.notify();
            } catch (Throwable th) {
                this.f2622a.notify();
                throw th;
            }
        }
    }
}
