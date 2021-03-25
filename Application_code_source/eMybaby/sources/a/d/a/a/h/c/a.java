package a.d.a.a.h.c;

import a.d.a.a.c.a.b;
import a.d.a.a.e.g;
import a.d.a.a.e.k.d;
import a.d.a.a.e.m.c;
import a.d.a.a.e.m.f;
import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashSet;

public final class a extends f<b> {
    public final Bundle z;

    public a(Context context, Looper looper, c cVar, a.d.a.a.c.a.c cVar2, d.a aVar, d.b bVar) {
        super(context, looper, 16, cVar, aVar, bVar);
        if (cVar2 == null) {
            this.z = new Bundle();
            return;
        }
        throw new NoSuchMethodError();
    }

    public final int f() {
        return g.f1241a;
    }

    public final boolean j() {
        HashSet hashSet;
        c cVar = this.w;
        Account account = cVar.f1371a;
        if (TextUtils.isEmpty(account != null ? account.name : null)) {
            return false;
        }
        c.b bVar = cVar.f1374d.get(b.f1203c);
        if (bVar == null || bVar.f1381a.isEmpty()) {
            hashSet = cVar.f1372b;
        } else {
            HashSet hashSet2 = new HashSet(cVar.f1372b);
            hashSet2.addAll(bVar.f1381a);
            hashSet = hashSet2;
        }
        return !hashSet.isEmpty();
    }

    public final /* synthetic */ IInterface l(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        return queryLocalInterface instanceof b ? (b) queryLocalInterface : new c(iBinder);
    }

    public final Bundle n() {
        return this.z;
    }

    public final String q() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    public final String r() {
        return "com.google.android.gms.auth.service.START";
    }
}
