package a.d.a.a.i.b;

import com.google.android.gms.measurement.internal.zzkw;
import com.google.android.gms.measurement.internal.zzn;

public final class v7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f2569a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ zzkw f2570b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ zzn f2571c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ u7 f2572d;

    public v7(u7 u7Var, boolean z, zzkw zzkw, zzn zzn) {
        this.f2572d = u7Var;
        this.f2569a = z;
        this.f2570b = zzkw;
        this.f2571c = zzn;
    }

    public final void run() {
        u7 u7Var = this.f2572d;
        p3 p3Var = u7Var.f2549d;
        if (p3Var == null) {
            u7Var.i().f.a("Discarding data. Failed to set user property");
            return;
        }
        u7Var.y(p3Var, this.f2569a ? null : this.f2570b, this.f2571c);
        this.f2572d.H();
    }
}
