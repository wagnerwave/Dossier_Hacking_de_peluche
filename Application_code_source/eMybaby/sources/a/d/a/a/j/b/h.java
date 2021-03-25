package a.d.a.a.j.b;

import a.c.a.f.b;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.signin.internal.zai;

public final class h implements Parcelable.Creator<zai> {
    public final Object createFromParcel(Parcel parcel) {
        int A0 = b.A0(parcel);
        int i = 0;
        ResolveAccountRequest resolveAccountRequest = null;
        while (parcel.dataPosition() < A0) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = b.b0(parcel, readInt);
            } else if (i2 != 2) {
                b.v0(parcel, readInt);
            } else {
                resolveAccountRequest = (ResolveAccountRequest) b.s(parcel, readInt, ResolveAccountRequest.CREATOR);
            }
        }
        b.A(parcel, A0);
        return new zai(i, resolveAccountRequest);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zai[i];
    }
}
