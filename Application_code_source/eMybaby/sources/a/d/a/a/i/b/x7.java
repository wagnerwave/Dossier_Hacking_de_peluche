package a.d.a.a.i.b;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzn;

public final class x7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ zzn f2624a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u7 f2625b;

    public x7(u7 u7Var, zzn zzn) {
        this.f2625b = u7Var;
        this.f2624a = zzn;
    }

    public final void run() {
        u7 u7Var = this.f2625b;
        p3 p3Var = u7Var.f2549d;
        if (p3Var == null) {
            u7Var.i().f.a("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            p3Var.P(this.f2624a);
        } catch (RemoteException e2) {
            this.f2625b.i().f.b("Failed to reset data on the service: remote exception", e2);
        }
        this.f2625b.H();
    }
}
