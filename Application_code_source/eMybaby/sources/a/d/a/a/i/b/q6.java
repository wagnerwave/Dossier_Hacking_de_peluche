package a.d.a.a.i.b;

import a.c.a.f.b;
import a.d.a.a.h.g.c9;
import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzar;
import com.google.android.gms.measurement.internal.zzkw;
import com.google.android.gms.measurement.internal.zzw;

public final class q6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bundle f2484a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f6 f2485b;

    public q6(f6 f6Var, Bundle bundle) {
        this.f2485b = f6Var;
        this.f2484a = bundle;
    }

    public final void run() {
        f6 f6Var = this.f2485b;
        Bundle bundle = this.f2484a;
        f6Var.b();
        f6Var.u();
        b.k(bundle);
        b.h(bundle.getString("name"));
        b.h(bundle.getString("origin"));
        b.k(bundle.get("value"));
        if (!f6Var.f2563a.d()) {
            f6Var.i().n.a("Conditional property not set since app measurement is disabled");
            return;
        }
        zzkw zzkw = new zzkw(bundle.getString("name"), bundle.getLong("triggered_timestamp"), bundle.get("value"), bundle.getString("origin"));
        try {
            zzar B = f6Var.e().B(bundle.getString("app_id"), bundle.getString("triggered_event_name"), bundle.getBundle("triggered_event_params"), bundle.getString("origin"), 0, c9.b() && f6Var.f2563a.g.o(q.S0));
            zzar B2 = f6Var.e().B(bundle.getString("app_id"), bundle.getString("timed_out_event_name"), bundle.getBundle("timed_out_event_params"), bundle.getString("origin"), 0, c9.b() && f6Var.f2563a.g.o(q.S0));
            zzar B3 = f6Var.e().B(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), bundle.getString("origin"), 0, c9.b() && f6Var.f2563a.g.o(q.S0));
            String string = bundle.getString("app_id");
            String string2 = bundle.getString("origin");
            long j = bundle.getLong("creation_timestamp");
            String string3 = bundle.getString("trigger_event_name");
            long j2 = bundle.getLong("trigger_timeout");
            long j3 = bundle.getLong("time_to_live");
            zzw zzw = r3;
            zzw zzw2 = new zzw(string, string2, zzkw, j, false, string3, B2, j2, B, j3, B3);
            f6Var.q().A(zzw);
        } catch (IllegalArgumentException unused) {
        }
    }
}
