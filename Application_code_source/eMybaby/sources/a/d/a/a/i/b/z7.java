package a.d.a.a.i.b;

import a.d.a.a.h.g.od;
import a.d.a.a.h.g.u9;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzn;

public final class z7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ zzn f2668a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ od f2669b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ u7 f2670c;

    public z7(u7 u7Var, zzn zzn, od odVar) {
        this.f2670c = u7Var;
        this.f2668a = zzn;
        this.f2669b = odVar;
    }

    public final void run() {
        String str = null;
        try {
            if (!u9.b() || !this.f2670c.f2563a.g.o(q.P0) || this.f2670c.k().x().k()) {
                p3 p3Var = this.f2670c.f2549d;
                if (p3Var == null) {
                    this.f2670c.i().f.a("Failed to get app instance id");
                } else {
                    str = p3Var.G(this.f2668a);
                    if (str != null) {
                        this.f2670c.o().g.set(str);
                        this.f2670c.k().l.b(str);
                    }
                    this.f2670c.H();
                }
                this.f2670c.e().M(this.f2669b, str);
            }
            this.f2670c.i().k.a("Analytics storage consent denied; will not get app instance id");
            this.f2670c.o().g.set((Object) null);
            this.f2670c.k().l.b((String) null);
            this.f2670c.e().M(this.f2669b, str);
        } catch (RemoteException e2) {
            this.f2670c.i().f.b("Failed to get app instance id", e2);
        } catch (Throwable th) {
            this.f2670c.e().M(this.f2669b, (String) null);
            throw th;
        }
    }
}
