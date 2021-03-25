package a.d.a.a.c.a.d.c;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;

public final class b implements Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> {
    public final Object createFromParcel(Parcel parcel) {
        int A0 = a.c.a.f.b.A0(parcel);
        int i = 0;
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < A0) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i = a.c.a.f.b.b0(parcel, readInt);
            } else if (i3 == 2) {
                i2 = a.c.a.f.b.b0(parcel, readInt);
            } else if (i3 != 3) {
                a.c.a.f.b.v0(parcel, readInt);
            } else {
                bundle = a.c.a.f.b.r(parcel, readInt);
            }
        }
        a.c.a.f.b.A(parcel, A0);
        return new GoogleSignInOptionsExtensionParcelable(i, i2, bundle);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleSignInOptionsExtensionParcelable[i];
    }
}
