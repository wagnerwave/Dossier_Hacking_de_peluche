package a.d.a.a.e.m;

import a.c.a.f.b;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.zza;

public final class f0 implements Parcelable.Creator<zza> {
    public final Object createFromParcel(Parcel parcel) {
        int A0 = b.A0(parcel);
        Bundle bundle = null;
        Feature[] featureArr = null;
        int i = 0;
        while (parcel.dataPosition() < A0) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                bundle = b.r(parcel, readInt);
            } else if (i2 == 2) {
                featureArr = (Feature[]) b.v(parcel, readInt, Feature.CREATOR);
            } else if (i2 != 3) {
                b.v0(parcel, readInt);
            } else {
                i = b.b0(parcel, readInt);
            }
        }
        b.A(parcel, A0);
        return new zza(bundle, featureArr, i);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zza[i];
    }
}
