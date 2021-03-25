package a.d.a.a.h.b;

import a.d.a.a.c.a.a;
import a.d.a.a.e.k.d;
import a.d.a.a.e.m.c;
import a.d.a.a.e.m.f;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.util.Base64;

public final class e extends f<g> {
    public final a.C0054a z;

    public e(Context context, Looper looper, c cVar, a.C0054a aVar, d.a aVar2, d.b bVar) {
        super(context, looper, 68, cVar, aVar2, bVar);
        a.C0054a.C0055a aVar3 = new a.C0054a.C0055a(aVar == null ? a.C0054a.f1194d : aVar);
        byte[] bArr = new byte[16];
        a.f1461a.nextBytes(bArr);
        aVar3.f1200c = Base64.encodeToString(bArr, 11);
        this.z = new a.C0054a(aVar3);
    }

    public final int f() {
        return 12800000;
    }

    public final /* synthetic */ IInterface l(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        return queryLocalInterface instanceof g ? (g) queryLocalInterface : new f(iBinder);
    }

    public final Bundle n() {
        a.C0054a aVar = this.z;
        if (aVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", aVar.f1195a);
            bundle.putBoolean("force_save_dialog", aVar.f1196b);
            bundle.putString("log_session_id", aVar.f1197c);
            return bundle;
        }
        throw null;
    }

    public final String q() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    public final String r() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }
}
