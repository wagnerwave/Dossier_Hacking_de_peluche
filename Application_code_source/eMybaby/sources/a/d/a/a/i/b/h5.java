package a.d.a.a.i.b;

import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzw;

public final class h5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ zzw f2241a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d5 f2242b;

    public h5(d5 d5Var, zzw zzw) {
        this.f2242b = d5Var;
        this.f2241a = zzw;
    }

    public final void run() {
        this.f2242b.f2148a.Q();
        if (this.f2241a.f4292c.e() == null) {
            o9 o9Var = this.f2242b.f2148a;
            zzw zzw = this.f2241a;
            if (o9Var != null) {
                zzn x = o9Var.x(zzw.f4290a);
                if (x != null) {
                    o9Var.E(zzw, x);
                    return;
                }
                return;
            }
            throw null;
        }
        o9 o9Var2 = this.f2242b.f2148a;
        zzw zzw2 = this.f2241a;
        if (o9Var2 != null) {
            zzn x2 = o9Var2.x(zzw2.f4290a);
            if (x2 != null) {
                o9Var2.p(zzw2, x2);
                return;
            }
            return;
        }
        throw null;
    }
}
