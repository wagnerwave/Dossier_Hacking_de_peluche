package a.d.a.a.i.b;

import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzam;
import com.google.android.gms.measurement.internal.zzar;
import com.google.android.gms.measurement.internal.zzn;

public final class q5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ zzar f2481a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ zzn f2482b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d5 f2483c;

    public q5(d5 d5Var, zzar zzar, zzn zzn) {
        this.f2483c = d5Var;
        this.f2481a = zzar;
        this.f2482b = zzn;
    }

    public final void run() {
        zzam zzam;
        d5 d5Var = this.f2483c;
        zzar zzar = this.f2481a;
        zzn zzn = this.f2482b;
        if (d5Var != null) {
            boolean z = false;
            if (!(!"_cmp".equals(zzar.f4276a) || (zzam = zzar.f4277b) == null || zzam.f4275a.size() == 0)) {
                String string = zzar.f4277b.f4275a.getString("_cis");
                if (!TextUtils.isEmpty(string) && (("referrer broadcast".equals(string) || "referrer API".equals(string)) && d5Var.f2148a.j.g.t(zzn.f4285a, q.S))) {
                    z = true;
                }
            }
            if (z) {
                d5Var.f2148a.i().l.b("Event has been filtered ", zzar.toString());
                zzar = new zzar("_cmpx", zzar.f4277b, zzar.f4278c, zzar.f4279d);
            }
            this.f2483c.f2148a.Q();
            this.f2483c.f2148a.k(zzar, this.f2482b);
            return;
        }
        throw null;
    }
}
