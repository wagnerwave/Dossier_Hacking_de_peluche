package a.d.a.a.i.b;

import com.google.android.gms.measurement.internal.zzkw;
import com.google.android.gms.measurement.internal.zzn;

public final class r5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ zzkw f2498a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ zzn f2499b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d5 f2500c;

    public r5(d5 d5Var, zzkw zzkw, zzn zzn) {
        this.f2500c = d5Var;
        this.f2498a = zzkw;
        this.f2499b = zzn;
    }

    public final void run() {
        this.f2500c.f2148a.Q();
        if (this.f2498a.e() == null) {
            this.f2500c.f2148a.C(this.f2498a, this.f2499b);
        } else {
            this.f2500c.f2148a.n(this.f2498a, this.f2499b);
        }
    }
}
