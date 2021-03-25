package a.d.a.a.h.g;

import a.c.a.f.b;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.measurement.zzae;

public final class g implements Parcelable.Creator<zzae> {
    public final Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int A0 = b.A0(parcel);
        long j = 0;
        long j2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        Bundle bundle = null;
        boolean z = false;
        while (parcel.dataPosition() < A0) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    j = b.c0(parcel2, readInt);
                    break;
                case 2:
                    j2 = b.c0(parcel2, readInt);
                    break;
                case 3:
                    z = b.Z(parcel2, readInt);
                    break;
                case 4:
                    str = b.t(parcel2, readInt);
                    break;
                case 5:
                    str2 = b.t(parcel2, readInt);
                    break;
                case 6:
                    str3 = b.t(parcel2, readInt);
                    break;
                case 7:
                    bundle = b.r(parcel2, readInt);
                    break;
                default:
                    b.v0(parcel2, readInt);
                    break;
            }
        }
        b.A(parcel2, A0);
        return new zzae(j, j2, z, str, str2, str3, bundle);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzae[i];
    }
}
