package a.d.a.a.j.b;

import a.c.a.f.b;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.internal.zak;

public final class i implements Parcelable.Creator<zak> {
    public final Object createFromParcel(Parcel parcel) {
        int A0 = b.A0(parcel);
        ConnectionResult connectionResult = null;
        ResolveAccountResponse resolveAccountResponse = null;
        int i = 0;
        while (parcel.dataPosition() < A0) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = b.b0(parcel, readInt);
            } else if (i2 == 2) {
                connectionResult = (ConnectionResult) b.s(parcel, readInt, ConnectionResult.CREATOR);
            } else if (i2 != 3) {
                b.v0(parcel, readInt);
            } else {
                resolveAccountResponse = (ResolveAccountResponse) b.s(parcel, readInt, ResolveAccountResponse.CREATOR);
            }
        }
        b.A(parcel, A0);
        return new zak(i, connectionResult, resolveAccountResponse);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zak[i];
    }
}
