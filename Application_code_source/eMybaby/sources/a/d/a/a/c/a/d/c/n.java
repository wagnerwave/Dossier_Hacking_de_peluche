package a.d.a.a.c.a.d.c;

import a.d.a.a.h.b.b;
import a.d.a.a.h.b.d;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

public abstract class n extends b implements o {
    public n() {
        super("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }

    public final boolean e(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 101:
                GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) d.a(parcel, GoogleSignInAccount.CREATOR);
                Status status = (Status) d.a(parcel, Status.CREATOR);
                throw new UnsupportedOperationException();
            case 102:
                o((Status) d.a(parcel, Status.CREATOR));
                break;
            case 103:
                D((Status) d.a(parcel, Status.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
