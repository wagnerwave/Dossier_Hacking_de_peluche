package a.d.a.a.e.k.l;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class y extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public Context f1345a;

    /* renamed from: b  reason: collision with root package name */
    public final p0 f1346b;

    public y(p0 p0Var) {
        this.f1346b = p0Var;
    }

    public final synchronized void a() {
        if (this.f1345a != null) {
            this.f1345a.unregisterReceiver(this);
        }
        this.f1345a = null;
    }

    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            p0 p0Var = this.f1346b;
            p0Var.f1320b.f1316b.j();
            if (p0Var.f1319a.isShowing()) {
                p0Var.f1319a.dismiss();
            }
            a();
        }
    }
}
