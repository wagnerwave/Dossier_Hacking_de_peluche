package a.d.a.a.i.b;

import java.util.concurrent.atomic.AtomicReference;

public final class k6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f2322a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f6 f2323b;

    public k6(f6 f6Var, AtomicReference atomicReference) {
        this.f2323b = f6Var;
        this.f2322a = atomicReference;
    }

    public final void run() {
        synchronized (this.f2322a) {
            try {
                AtomicReference atomicReference = this.f2322a;
                ka kaVar = this.f2323b.f2563a.g;
                q3 p = this.f2323b.p();
                p.u();
                String str = p.f2474c;
                if (kaVar != null) {
                    atomicReference.set(Boolean.valueOf(kaVar.t(str, q.K)));
                    this.f2322a.notify();
                } else {
                    throw null;
                }
            } catch (Throwable th) {
                this.f2322a.notify();
                throw th;
            }
        }
    }
}
