package a.d.a.a.j.b;

import a.d.a.a.e.k.l.d0;
import a.d.a.a.e.k.l.f0;
import a.d.a.a.h.d.a;
import a.d.a.a.h.d.c;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.signin.internal.zab;
import com.google.android.gms.signin.internal.zak;

public abstract class f extends a implements c {
    public f() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    public boolean U(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 3) {
            ConnectionResult connectionResult = (ConnectionResult) c.a(parcel, ConnectionResult.CREATOR);
            zab zab = (zab) c.a(parcel, zab.CREATOR);
        } else if (i == 4 || i == 6) {
            Status status = (Status) c.a(parcel, Status.CREATOR);
        } else if (i == 7) {
            Status status2 = (Status) c.a(parcel, Status.CREATOR);
            GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) c.a(parcel, GoogleSignInAccount.CREATOR);
        } else if (i != 8) {
            return false;
        } else {
            d0 d0Var = (d0) this;
            d0Var.f1276b.post(new f0(d0Var, (zak) c.a(parcel, zak.CREATOR)));
        }
        parcel2.writeNoException();
        return true;
    }
}
