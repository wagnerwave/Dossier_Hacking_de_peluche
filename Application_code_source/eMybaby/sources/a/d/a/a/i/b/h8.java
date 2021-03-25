package a.d.a.a.i.b;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzar;
import com.google.android.gms.measurement.internal.zzn;

public final class h8 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f2245a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f2246b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ zzar f2247c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ zzn f2248d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f2249e;
    public final /* synthetic */ u7 f;

    public h8(u7 u7Var, boolean z, boolean z2, zzar zzar, zzn zzn, String str) {
        this.f = u7Var;
        this.f2245a = z;
        this.f2246b = z2;
        this.f2247c = zzar;
        this.f2248d = zzn;
        this.f2249e = str;
    }

    public final void run() {
        u7 u7Var = this.f;
        p3 p3Var = u7Var.f2549d;
        if (p3Var == null) {
            u7Var.i().f.a("Discarding data. Failed to send event to service");
            return;
        }
        if (this.f2245a) {
            u7Var.y(p3Var, this.f2246b ? null : this.f2247c, this.f2248d);
        } else {
            try {
                if (TextUtils.isEmpty(this.f2249e)) {
                    p3Var.A(this.f2247c, this.f2248d);
                } else {
                    p3Var.R(this.f2247c, this.f2249e, this.f.i().E());
                }
            } catch (RemoteException e2) {
                this.f.i().f.b("Failed to send event to the service", e2);
            }
        }
        this.f.H();
    }
}
