package a.d.a.a.i.b;

import a.c.a.f.b;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.internal.zzam;

public final class m implements Parcelable.Creator<zzam> {
    public final Object createFromParcel(Parcel parcel) {
        int A0 = b.A0(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < A0) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 2) {
                b.v0(parcel, readInt);
            } else {
                bundle = b.r(parcel, readInt);
            }
        }
        b.A(parcel, A0);
        return new zzam(bundle);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzam[i];
    }
}
