package a.d.a.a.h.f;

import a.d.a.a.b.a;
import a.d.a.a.b.f;
import a.d.a.a.e.q.c;
import android.content.Context;
import android.content.SharedPreferences;

public final class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s f1569a;

    public v(s sVar) {
        this.f1569a = sVar;
    }

    public final void run() {
        s sVar = this.f1569a;
        sVar.u();
        f.b();
        Context context = sVar.f1490a.f1503a;
        if (!x0.b(context)) {
            sVar.p("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!y0.c(context)) {
            sVar.q("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!a.a(context)) {
            sVar.p("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        u0 k = sVar.k();
        if (k != null) {
            f.b();
            k.u();
            if (k.f1567d == 0) {
                long j = k.f1566c.getLong("first_run", 0);
                if (j != 0) {
                    k.f1567d = j;
                } else if (((c) k.f1490a.f1505c) != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    SharedPreferences.Editor edit = k.f1566c.edit();
                    edit.putLong("first_run", currentTimeMillis);
                    if (!edit.commit()) {
                        k.p("Failed to commit first run time");
                    }
                    k.f1567d = currentTimeMillis;
                } else {
                    throw null;
                }
            }
            if (!sVar.D("android.permission.ACCESS_NETWORK_STATE")) {
                sVar.q("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
                sVar.u();
                f.b();
                sVar.m = true;
                sVar.g.v();
                sVar.z();
            }
            if (!sVar.D("android.permission.INTERNET")) {
                sVar.q("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
                sVar.u();
                f.b();
                sVar.m = true;
                sVar.g.v();
                sVar.z();
            }
            if (y0.c(sVar.f1490a.f1503a)) {
                sVar.o("AnalyticsService registered in the app manifest and enabled");
            } else {
                sVar.p("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
            }
            if (!sVar.m && !sVar.f1555d.x()) {
                sVar.x();
            }
            sVar.z();
            return;
        }
        throw null;
    }
}
