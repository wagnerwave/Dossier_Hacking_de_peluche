package a.d.a.a.i.b;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzn;

public final class e8 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bundle f2171a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ zzn f2172b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ u7 f2173c;

    public e8(u7 u7Var, Bundle bundle, zzn zzn) {
        this.f2173c = u7Var;
        this.f2171a = bundle;
        this.f2172b = zzn;
    }

    public final void run() {
        u7 u7Var = this.f2173c;
        p3 p3Var = u7Var.f2549d;
        if (p3Var == null) {
            u7Var.i().f.a("Failed to send default event parameters to service");
            return;
        }
        try {
            p3Var.H(this.f2171a, this.f2172b);
        } catch (RemoteException e2) {
            this.f2173c.i().f.b("Failed to send default event parameters to service", e2);
        }
    }
}
