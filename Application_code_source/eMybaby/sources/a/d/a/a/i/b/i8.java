package a.d.a.a.i.b;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzn;

public final class i8 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ zzn f2275a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u7 f2276b;

    public i8(u7 u7Var, zzn zzn) {
        this.f2276b = u7Var;
        this.f2275a = zzn;
    }

    public final void run() {
        u7 u7Var = this.f2276b;
        p3 p3Var = u7Var.f2549d;
        if (p3Var == null) {
            u7Var.i().f.a("Failed to send consent settings to service");
            return;
        }
        try {
            p3Var.n(this.f2275a);
            this.f2276b.H();
        } catch (RemoteException e2) {
            this.f2276b.i().f.b("Failed to send consent settings to the service", e2);
        }
    }
}
