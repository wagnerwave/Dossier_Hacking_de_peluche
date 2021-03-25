package a.d.a.a.c.a.d.c;

import a.c.a.f.b;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;

public final class s implements Parcelable.Creator<SignInConfiguration> {
    public final Object createFromParcel(Parcel parcel) {
        int A0 = b.A0(parcel);
        String str = null;
        GoogleSignInOptions googleSignInOptions = null;
        while (parcel.dataPosition() < A0) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 2) {
                str = b.t(parcel, readInt);
            } else if (i != 5) {
                b.v0(parcel, readInt);
            } else {
                googleSignInOptions = (GoogleSignInOptions) b.s(parcel, readInt, GoogleSignInOptions.CREATOR);
            }
        }
        b.A(parcel, A0);
        return new SignInConfiguration(str, googleSignInOptions);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new SignInConfiguration[i];
    }
}
