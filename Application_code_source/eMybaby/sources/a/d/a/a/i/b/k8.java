package a.d.a.a.i.b;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzw;

public final class k8 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f2324a = true;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f2325b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ zzw f2326c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ zzn f2327d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ zzw f2328e;
    public final /* synthetic */ u7 f;

    public k8(u7 u7Var, boolean z, zzw zzw, zzn zzn, zzw zzw2) {
        this.f = u7Var;
        this.f2325b = z;
        this.f2326c = zzw;
        this.f2327d = zzn;
        this.f2328e = zzw2;
    }

    public final void run() {
        u7 u7Var = this.f;
        p3 p3Var = u7Var.f2549d;
        if (p3Var == null) {
            u7Var.i().f.a("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.f2324a) {
            u7Var.y(p3Var, this.f2325b ? null : this.f2326c, this.f2327d);
        } else {
            try {
                if (TextUtils.isEmpty(this.f2328e.f4290a)) {
                    p3Var.l(this.f2326c, this.f2327d);
                } else {
                    p3Var.r(this.f2326c);
                }
            } catch (RemoteException e2) {
                this.f.i().f.b("Failed to send conditional user property to the service", e2);
            }
        }
        this.f.H();
    }
}
