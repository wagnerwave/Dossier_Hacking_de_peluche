package a.d.a.a.e.k;

import a.c.a.f.b;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;

public final class m implements Parcelable.Creator<Scope> {
    public final Object createFromParcel(Parcel parcel) {
        int A0 = b.A0(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < A0) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = b.b0(parcel, readInt);
            } else if (i2 != 2) {
                b.v0(parcel, readInt);
            } else {
                str = b.t(parcel, readInt);
            }
        }
        b.A(parcel, A0);
        return new Scope(i, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Scope[i];
    }
}
