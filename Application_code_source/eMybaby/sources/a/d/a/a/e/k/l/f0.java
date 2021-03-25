package a.d.a.a.e.k.l;

import a.d.a.a.e.k.l.f;
import a.d.a.a.e.m.j;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.internal.zak;
import java.util.Set;

public final class f0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ zak f1297a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d0 f1298b;

    public f0(d0 d0Var, zak zak) {
        this.f1298b = d0Var;
        this.f1297a = zak;
    }

    public final void run() {
        d0 d0Var = this.f1298b;
        zak zak = this.f1297a;
        if (d0Var != null) {
            ConnectionResult connectionResult = zak.f4302b;
            if (connectionResult.h()) {
                ResolveAccountResponse resolveAccountResponse = zak.f4303c;
                connectionResult = resolveAccountResponse.f4228c;
                if (!connectionResult.h()) {
                    String valueOf = String.valueOf(connectionResult);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 48);
                    sb.append("Sign-in succeeded with resolve account failure: ");
                    sb.append(valueOf);
                    Log.wtf("SignInCoordinator", sb.toString(), new Exception());
                } else {
                    e0 e0Var = d0Var.g;
                    j e2 = resolveAccountResponse.e();
                    Set<Scope> set = d0Var.f1278d;
                    f.b bVar = (f.b) e0Var;
                    if (bVar == null) {
                        throw null;
                    } else if (e2 == null || set == null) {
                        Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                        bVar.b(new ConnectionResult(4));
                        d0Var.f.disconnect();
                        return;
                    } else {
                        bVar.f1292c = e2;
                        bVar.f1293d = set;
                        if (bVar.f1294e) {
                            bVar.f1290a.c(e2, set);
                        }
                        d0Var.f.disconnect();
                        return;
                    }
                }
            }
            ((f.b) d0Var.g).b(connectionResult);
            d0Var.f.disconnect();
            return;
        }
        throw null;
    }
}
