package a.d.a.a.e;

import a.c.a.f.b;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;

public final class t implements Parcelable.Creator<Feature> {
    public final Object createFromParcel(Parcel parcel) {
        int A0 = b.A0(parcel);
        String str = null;
        int i = 0;
        long j = -1;
        while (parcel.dataPosition() < A0) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                str = b.t(parcel, readInt);
            } else if (i2 == 2) {
                i = b.b0(parcel, readInt);
            } else if (i2 != 3) {
                b.v0(parcel, readInt);
            } else {
                j = b.c0(parcel, readInt);
            }
        }
        b.A(parcel, A0);
        return new Feature(str, i, j);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Feature[i];
    }
}
