package a.d.a.a.i.b;

import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.measurement.internal.zzn;

public final class c8 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ zzn f2137a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u7 f2138b;

    public c8(u7 u7Var, zzn zzn) {
        this.f2138b = u7Var;
        this.f2137a = zzn;
    }

    public final void run() {
        u7 u7Var = this.f2138b;
        p3 p3Var = u7Var.f2549d;
        if (p3Var == null) {
            u7Var.i().f.a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            p3Var.m(this.f2137a);
            this.f2138b.s().B();
            this.f2138b.y(p3Var, (AbstractSafeParcelable) null, this.f2137a);
            this.f2138b.H();
        } catch (RemoteException e2) {
            this.f2138b.i().f.b("Failed to send app launch to the service", e2);
        }
    }
}
