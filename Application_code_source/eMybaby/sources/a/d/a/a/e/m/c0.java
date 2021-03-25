package a.d.a.a.e.m;

import a.c.a.f.b;
import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.ResolveAccountRequest;

public final class c0 implements Parcelable.Creator<ResolveAccountRequest> {
    public final Object createFromParcel(Parcel parcel) {
        int A0 = b.A0(parcel);
        int i = 0;
        Account account = null;
        GoogleSignInAccount googleSignInAccount = null;
        int i2 = 0;
        while (parcel.dataPosition() < A0) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i = b.b0(parcel, readInt);
            } else if (i3 == 2) {
                account = (Account) b.s(parcel, readInt, Account.CREATOR);
            } else if (i3 == 3) {
                i2 = b.b0(parcel, readInt);
            } else if (i3 != 4) {
                b.v0(parcel, readInt);
            } else {
                googleSignInAccount = (GoogleSignInAccount) b.s(parcel, readInt, GoogleSignInAccount.CREATOR);
            }
        }
        b.A(parcel, A0);
        return new ResolveAccountRequest(i, account, i2, googleSignInAccount);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ResolveAccountRequest[i];
    }
}
