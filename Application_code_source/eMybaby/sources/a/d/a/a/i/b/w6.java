package a.d.a.a.i.b;

import java.util.concurrent.atomic.AtomicReference;

public final class w6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f2595a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f6 f2596b;

    public w6(f6 f6Var, AtomicReference atomicReference) {
        this.f2596b = f6Var;
        this.f2595a = atomicReference;
    }

    public final void run() {
        synchronized (this.f2595a) {
            try {
                AtomicReference atomicReference = this.f2595a;
                ka kaVar = this.f2596b.f2563a.g;
                q3 p = this.f2596b.p();
                p.u();
                atomicReference.set(Integer.valueOf(kaVar.q(p.f2474c, q.N)));
                this.f2595a.notify();
            } catch (Throwable th) {
                this.f2595a.notify();
                throw th;
            }
        }
    }
}
