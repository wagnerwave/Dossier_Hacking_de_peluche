package a.d.a.a.c.a.d;

import a.c.a.f.b;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;

public final class i implements Parcelable.Creator<SignInAccount> {
    public final Object createFromParcel(Parcel parcel) {
        int A0 = b.A0(parcel);
        String str = "";
        GoogleSignInAccount googleSignInAccount = null;
        String str2 = str;
        while (parcel.dataPosition() < A0) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 4) {
                str = b.t(parcel, readInt);
            } else if (i == 7) {
                googleSignInAccount = (GoogleSignInAccount) b.s(parcel, readInt, GoogleSignInAccount.CREATOR);
            } else if (i != 8) {
                b.v0(parcel, readInt);
            } else {
                str2 = b.t(parcel, readInt);
            }
        }
        b.A(parcel, A0);
        return new SignInAccount(str, googleSignInAccount, str2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new SignInAccount[i];
    }
}
