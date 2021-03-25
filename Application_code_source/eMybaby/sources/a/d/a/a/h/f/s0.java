package a.d.a.a.h.f;

import a.c.a.f.b;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class s0 extends BroadcastReceiver {

    /* renamed from: d  reason: collision with root package name */
    public static final String f1557d = s0.class.getName();

    /* renamed from: a  reason: collision with root package name */
    public final h f1558a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1559b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1560c;

    public s0(h hVar) {
        b.k(hVar);
        this.f1558a = hVar;
    }

    public final void a() {
        if (this.f1559b) {
            this.f1558a.c().o("Unregistering connectivity change receiver");
            this.f1559b = false;
            this.f1560c = false;
            try {
                this.f1558a.f1503a.unregisterReceiver(this);
            } catch (IllegalArgumentException e2) {
                this.f1558a.c().n("Failed to unregister the network broadcast receiver", e2);
            }
        }
    }

    public final boolean b() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f1558a.f1503a.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (SecurityException unused) {
        }
    }

    public void onReceive(Context context, Intent intent) {
        this.f1558a.c();
        this.f1558a.e();
        String action = intent.getAction();
        this.f1558a.c().b("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean b2 = b();
            if (this.f1560c != b2) {
                this.f1560c = b2;
                b e2 = this.f1558a.e();
                e2.b("Network connectivity status changed", Boolean.valueOf(b2));
                e2.h().a(new c(e2, b2));
            }
        } else if (!"com.google.analytics.RADIO_POWERED".equals(action)) {
            this.f1558a.c().l("NetworkBroadcastReceiver received unknown action", action);
        } else if (!intent.hasExtra(f1557d)) {
            b e3 = this.f1558a.e();
            e3.o("Radio powered up");
            e3.u();
            Context context2 = e3.f1490a.f1503a;
            if (!x0.b(context2) || !y0.c(context2)) {
                e3.u();
                e3.h().a(new d(e3, (h0) null));
                return;
            }
            Intent intent2 = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            intent2.setComponent(new ComponentName(context2, "com.google.android.gms.analytics.AnalyticsService"));
            context2.startService(intent2);
        }
    }
}
