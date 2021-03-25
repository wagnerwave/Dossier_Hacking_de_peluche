package a.d.a.a.j.b;

import a.d.a.a.e.g;
import a.d.a.a.e.k.d;
import a.d.a.a.e.k.l.d0;
import a.d.a.a.e.k.l.f0;
import a.d.a.a.e.m.b;
import a.d.a.a.e.m.c;
import a.d.a.a.e.m.f;
import a.d.a.a.j.e;
import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.signin.internal.zai;
import com.google.android.gms.signin.internal.zak;

public class a extends f<e> implements e {
    public final c A;
    public final Bundle B;
    public Integer C;
    public final boolean z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context, Looper looper, c cVar, d.a aVar, d.b bVar) {
        super(context, looper, 44, cVar, aVar, bVar);
        c cVar2 = cVar;
        a.d.a.a.j.a aVar2 = cVar2.g;
        Integer num = cVar2.h;
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", cVar2.f1371a);
        if (num != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
        }
        if (aVar2 != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", aVar2.f2674a);
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", aVar2.f2675b);
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", aVar2.f2676c);
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", aVar2.f2677d);
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", aVar2.f2678e);
            bundle.putString("com.google.android.gms.signin.internal.logSessionId", aVar2.f);
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", aVar2.g);
            Long l = aVar2.h;
            if (l != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", l.longValue());
            }
            Long l2 = aVar2.i;
            if (l2 != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", l2.longValue());
            }
        }
        this.z = true;
        this.A = cVar2;
        this.B = bundle;
        this.C = cVar2.h;
    }

    public final void connect() {
        i(new b.d());
    }

    public final void d(c cVar) {
        a.c.a.f.b.l(cVar, "Expecting a valid ISignInCallbacks");
        try {
            Account account = this.A.f1371a;
            if (account == null) {
                account = new Account("<<default account>>", "com.google");
            }
            GoogleSignInAccount googleSignInAccount = null;
            if ("<<default account>>".equals(account.name)) {
                googleSignInAccount = a.d.a.a.c.a.d.c.a.a(this.f1356b).b();
            }
            ((e) p()).T(new zai(new ResolveAccountRequest(account, this.C.intValue(), googleSignInAccount)), cVar);
        } catch (RemoteException e2) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                d0 d0Var = (d0) cVar;
                d0Var.f1276b.post(new f0(d0Var, new zak()));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e2);
            }
        }
    }

    public int f() {
        return g.f1241a;
    }

    public boolean j() {
        return this.z;
    }

    public /* synthetic */ IInterface l(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return queryLocalInterface instanceof e ? (e) queryLocalInterface : new g(iBinder);
    }

    public Bundle n() {
        if (!this.f1356b.getPackageName().equals(this.A.f1375e)) {
            this.B.putString("com.google.android.gms.signin.internal.realClientPackageName", this.A.f1375e);
        }
        return this.B;
    }

    public String q() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    public String r() {
        return "com.google.android.gms.signin.service.START";
    }
}
