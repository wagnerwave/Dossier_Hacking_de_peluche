package a.d.a.a.i.b;

import a.d.a.a.h.g.u9;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzn;
import java.util.concurrent.atomic.AtomicReference;

public final class a8 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f2089a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ zzn f2090b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ u7 f2091c;

    public a8(u7 u7Var, AtomicReference atomicReference, zzn zzn) {
        this.f2091c = u7Var;
        this.f2089a = atomicReference;
        this.f2090b = zzn;
    }

    public final void run() {
        AtomicReference atomicReference;
        synchronized (this.f2089a) {
            try {
                if (!u9.b() || !this.f2091c.f2563a.g.o(q.P0) || this.f2091c.k().x().k()) {
                    p3 p3Var = this.f2091c.f2549d;
                    if (p3Var == null) {
                        this.f2091c.i().f.a("Failed to get app instance id");
                        this.f2089a.notify();
                        return;
                    }
                    this.f2089a.set(p3Var.G(this.f2090b));
                    String str = (String) this.f2089a.get();
                    if (str != null) {
                        this.f2091c.o().g.set(str);
                        this.f2091c.k().l.b(str);
                    }
                    this.f2091c.H();
                    atomicReference = this.f2089a;
                    atomicReference.notify();
                    return;
                }
                this.f2091c.i().k.a("Analytics storage consent denied; will not get app instance id");
                this.f2091c.o().g.set((Object) null);
                this.f2091c.k().l.b((String) null);
                this.f2089a.set((Object) null);
                this.f2089a.notify();
            } catch (RemoteException e2) {
                try {
                    this.f2091c.i().f.b("Failed to get app instance id", e2);
                    atomicReference = this.f2089a;
                } catch (Throwable th) {
                    this.f2089a.notify();
                    throw th;
                }
            }
        }
    }
}
