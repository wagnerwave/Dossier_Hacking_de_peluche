package a.d.a.a.c.a.d.c;

import a.d.a.a.c.a.d.a;
import a.d.a.a.e.k.d;
import a.d.a.a.e.k.e;
import a.d.a.a.e.k.l.l;
import a.d.a.a.e.m.a0;
import a.d.a.a.e.m.b0;
import a.d.a.a.e.m.p;
import a.d.a.a.h.b.b;
import android.content.Context;
import android.os.Binder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

public final class r extends b implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1222a;

    public r(Context context) {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
        this.f1222a = context;
    }

    public final boolean e(int i, Parcel parcel, Parcel parcel2, int i2) {
        BasePendingResult basePendingResult;
        if (i == 1) {
            g();
            a a2 = a.a(this.f1222a);
            GoogleSignInAccount b2 = a2.b();
            GoogleSignInOptions googleSignInOptions = GoogleSignInOptions.p;
            if (b2 != null) {
                googleSignInOptions = a2.c();
            }
            Context context = this.f1222a;
            a.c.a.f.b.k(googleSignInOptions);
            a aVar = new a(context, googleSignInOptions);
            if (b2 != null) {
                d dVar = aVar.g;
                Context context2 = aVar.f1254a;
                boolean z = aVar.b() == 3;
                f.f1217a.a("Revoking access", new Object[0]);
                String g = a.a(context2).g("refreshToken");
                f.c(context2);
                e a3 = z ? c.a(g) : dVar.a(new k(dVar));
                a3.a(new a0(a3, new a.d.a.a.l.e(), new b0(), p.f1407a));
            } else {
                d dVar2 = aVar.g;
                Context context3 = aVar.f1254a;
                boolean z2 = aVar.b() == 3;
                f.f1217a.a("Signing out", new Object[0]);
                f.c(context3);
                if (z2) {
                    Status status = Status.f4205e;
                    a.c.a.f.b.l(status, "Result must not be null");
                    basePendingResult = new l(dVar2);
                    basePendingResult.e(status);
                } else {
                    basePendingResult = dVar2.a(new i(dVar2));
                }
                basePendingResult.a(new a0(basePendingResult, new a.d.a.a.l.e(), new b0(), p.f1407a));
            }
        } else if (i != 2) {
            return false;
        } else {
            g();
            l.b(this.f1222a).a();
        }
        return true;
    }

    public final void g() {
        if (!a.c.a.f.b.T(this.f1222a, Binder.getCallingUid())) {
            int callingUid = Binder.getCallingUid();
            StringBuilder sb = new StringBuilder(52);
            sb.append("Calling UID ");
            sb.append(callingUid);
            sb.append(" is not Google Play services.");
            throw new SecurityException(sb.toString());
        }
    }
}
