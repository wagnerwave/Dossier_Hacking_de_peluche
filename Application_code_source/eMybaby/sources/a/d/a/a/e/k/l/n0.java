package a.d.a.a.e.k.l;

import a.d.a.a.e.c;
import a.d.a.a.e.g;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.MainThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;

public final class n0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final o0 f1315a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m0 f1316b;

    public n0(m0 m0Var, o0 o0Var) {
        this.f1316b = m0Var;
        this.f1315a = o0Var;
    }

    @MainThread
    public final void run() {
        if (this.f1316b.f1311b) {
            ConnectionResult connectionResult = this.f1315a.f1318b;
            if (connectionResult.e()) {
                m0 m0Var = this.f1316b;
                m0Var.f4216a.startActivityForResult(GoogleApiActivity.b(m0Var.b(), connectionResult.f4193c, this.f1315a.f1317a, false), 1);
                return;
            }
            c cVar = this.f1316b.f1314e;
            int i = connectionResult.f4192b;
            if (cVar == null) {
                throw null;
            } else if (g.g(i)) {
                m0 m0Var2 = this.f1316b;
                c cVar2 = m0Var2.f1314e;
                Activity b2 = m0Var2.b();
                m0 m0Var3 = this.f1316b;
                cVar2.i(b2, m0Var3.f4216a, connectionResult.f4192b, m0Var3);
            } else if (connectionResult.f4192b == 18) {
                Dialog e2 = c.e(this.f1316b.b(), this.f1316b);
                m0 m0Var4 = this.f1316b;
                c cVar3 = m0Var4.f1314e;
                Context applicationContext = m0Var4.b().getApplicationContext();
                p0 p0Var = new p0(this, e2);
                if (cVar3 != null) {
                    IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
                    intentFilter.addDataScheme("package");
                    y yVar = new y(p0Var);
                    applicationContext.registerReceiver(yVar, intentFilter);
                    yVar.f1345a = applicationContext;
                    if (!g.f(applicationContext, "com.google.android.gms")) {
                        p0Var.f1320b.f1316b.j();
                        if (p0Var.f1319a.isShowing()) {
                            p0Var.f1319a.dismiss();
                        }
                        yVar.a();
                        return;
                    }
                    return;
                }
                throw null;
            } else {
                this.f1316b.i(connectionResult, this.f1315a.f1317a);
            }
        }
    }
}
