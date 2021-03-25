package a.d.a.a.i.b;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzn;

public final class f8 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ zzn f2196a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u7 f2197b;

    public f8(u7 u7Var, zzn zzn) {
        this.f2197b = u7Var;
        this.f2196a = zzn;
    }

    public final void run() {
        u7 u7Var = this.f2197b;
        p3 p3Var = u7Var.f2549d;
        if (p3Var == null) {
            u7Var.i().f.a("Failed to send measurementEnabled to service");
            return;
        }
        try {
            p3Var.w(this.f2196a);
            this.f2197b.H();
        } catch (RemoteException e2) {
            this.f2197b.i().f.b("Failed to send measurementEnabled to the service", e2);
        }
    }
}
