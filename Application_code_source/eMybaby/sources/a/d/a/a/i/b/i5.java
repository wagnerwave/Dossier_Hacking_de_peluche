package a.d.a.a.i.b;

import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzw;

public final class i5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ zzw f2265a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ zzn f2266b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d5 f2267c;

    public i5(d5 d5Var, zzw zzw, zzn zzn) {
        this.f2267c = d5Var;
        this.f2265a = zzw;
        this.f2266b = zzn;
    }

    public final void run() {
        this.f2267c.f2148a.Q();
        if (this.f2265a.f4292c.e() == null) {
            this.f2267c.f2148a.E(this.f2265a, this.f2266b);
        } else {
            this.f2267c.f2148a.p(this.f2265a, this.f2266b);
        }
    }
}
