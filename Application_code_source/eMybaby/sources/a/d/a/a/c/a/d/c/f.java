package a.d.a.a.c.a.d.c;

import a.d.a.a.c.a.d.b;
import a.d.a.a.e.k.d;
import a.d.a.a.e.n.a;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;
import com.google.android.gms.common.api.Status;
import java.util.Iterator;
import java.util.Set;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static a f1217a = new a("GoogleSignInCommon", new String[0]);

    @Nullable
    public static b a(@Nullable Intent intent) {
        if (intent == null) {
            return new b((GoogleSignInAccount) null, Status.g);
        }
        Status status = (Status) intent.getParcelableExtra("googleSignInStatus");
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) intent.getParcelableExtra("googleSignInAccount");
        if (googleSignInAccount != null) {
            return new b(googleSignInAccount, Status.f4205e);
        }
        if (status == null) {
            status = Status.g;
        }
        return new b((GoogleSignInAccount) null, status);
    }

    public static Intent b(Context context, GoogleSignInOptions googleSignInOptions) {
        f1217a.a("getSignInIntent()", new Object[0]);
        SignInConfiguration signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, SignInHubActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("config", signInConfiguration);
        intent.putExtra("config", bundle);
        return intent;
    }

    public static void c(Context context) {
        Set<d> set;
        l.b(context).a();
        synchronized (d.f1263a) {
            set = d.f1263a;
        }
        Iterator<d> it = set.iterator();
        if (!it.hasNext()) {
            synchronized (a.d.a.a.e.k.l.f.p) {
                if (a.d.a.a.e.k.l.f.q != null) {
                    a.d.a.a.e.k.l.f fVar = a.d.a.a.e.k.l.f.q;
                    fVar.h.incrementAndGet();
                    fVar.m.sendMessageAtFrontOfQueue(fVar.m.obtainMessage(10));
                }
            }
        } else if (it.next() != null) {
            throw new UnsupportedOperationException();
        } else {
            throw null;
        }
    }
}
