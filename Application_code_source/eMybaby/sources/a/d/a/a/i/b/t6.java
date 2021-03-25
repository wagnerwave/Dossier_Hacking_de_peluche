package a.d.a.a.i.b;

import java.util.concurrent.atomic.AtomicReference;

public final class t6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f2531a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f6 f2532b;

    public t6(f6 f6Var, AtomicReference atomicReference) {
        this.f2532b = f6Var;
        this.f2531a = atomicReference;
    }

    public final void run() {
        synchronized (this.f2531a) {
            try {
                AtomicReference atomicReference = this.f2531a;
                ka kaVar = this.f2532b.f2563a.g;
                q3 p = this.f2532b.p();
                p.u();
                String str = p.f2474c;
                String str2 = null;
                if (kaVar != null) {
                    n3<String> n3Var = q.L;
                    if (str != null) {
                        str2 = kaVar.f2331c.h(str, n3Var.f2393a);
                    }
                    atomicReference.set(n3Var.a(str2));
                    this.f2531a.notify();
                } else {
                    throw null;
                }
            } catch (Throwable th) {
                this.f2531a.notify();
                throw th;
            }
        }
    }
}
