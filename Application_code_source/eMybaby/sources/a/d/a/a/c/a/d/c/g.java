package a.d.a.a.c.a.d.c;

import a.c.a.f.b;
import a.d.a.a.e.k.d;
import a.d.a.a.e.m.c;
import a.d.a.a.e.m.f;
import a.d.a.a.h.b.a;
import android.accounts.Account;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class g extends f<q> {
    public final GoogleSignInOptions z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(Context context, Looper looper, c cVar, @Nullable GoogleSignInOptions googleSignInOptions, d.a aVar, d.b bVar) {
        super(context, looper, 91, cVar, aVar, bVar);
        Map<Integer, GoogleSignInOptionsExtensionParcelable> map;
        String str;
        String str2;
        boolean z2;
        boolean z3;
        boolean z4;
        Account account;
        HashSet hashSet;
        c cVar2 = cVar;
        GoogleSignInOptions googleSignInOptions2 = googleSignInOptions;
        if (googleSignInOptions2 != null) {
            new HashSet();
            new HashMap();
            b.k(googleSignInOptions);
            hashSet = new HashSet(googleSignInOptions2.f4172b);
            boolean z5 = googleSignInOptions2.f4175e;
            boolean z6 = googleSignInOptions2.f;
            boolean z7 = googleSignInOptions2.f4174d;
            String str3 = googleSignInOptions2.g;
            Account account2 = googleSignInOptions2.f4173c;
            String str4 = googleSignInOptions2.h;
            Map<Integer, GoogleSignInOptionsExtensionParcelable> h = GoogleSignInOptions.h(googleSignInOptions2.i);
            String str5 = googleSignInOptions2.j;
            z3 = z5;
            str = str4;
            map = h;
            z2 = z6;
            str2 = str3;
            account = account2;
            z4 = z7;
        } else {
            HashSet hashSet2 = new HashSet();
            account = null;
            str = null;
            map = new HashMap<>();
            z4 = false;
            z3 = false;
            z2 = false;
            str2 = null;
            hashSet = hashSet2;
        }
        byte[] bArr = new byte[16];
        a.f1461a.nextBytes(bArr);
        String encodeToString = Base64.encodeToString(bArr, 11);
        if (!cVar2.f1373c.isEmpty()) {
            for (Scope add : cVar2.f1373c) {
                hashSet.add(add);
                hashSet.addAll(Arrays.asList(new Scope[0]));
            }
        }
        if (hashSet.contains(GoogleSignInOptions.o) && hashSet.contains(GoogleSignInOptions.n)) {
            hashSet.remove(GoogleSignInOptions.n);
        }
        if (z4 && (account == null || !hashSet.isEmpty())) {
            hashSet.add(GoogleSignInOptions.m);
        }
        this.z = new GoogleSignInOptions(3, new ArrayList(hashSet), account, z4, z3, z2, str2, str, map, encodeToString);
    }

    public final int f() {
        return a.d.a.a.e.g.f1241a;
    }

    public final /* synthetic */ IInterface l(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        return queryLocalInterface instanceof q ? (q) queryLocalInterface : new p(iBinder);
    }

    public final String q() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    public final String r() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }
}
