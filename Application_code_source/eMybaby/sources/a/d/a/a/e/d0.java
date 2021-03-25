package a.d.a.a.e;

import a.c.a.f.b;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.zzj;

public final class d0 implements Parcelable.Creator<zzj> {
    public final Object createFromParcel(Parcel parcel) {
        int A0 = b.A0(parcel);
        boolean z = false;
        String str = null;
        IBinder iBinder = null;
        boolean z2 = false;
        while (parcel.dataPosition() < A0) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 1) {
                str = b.t(parcel, readInt);
            } else if (i == 2) {
                iBinder = b.a0(parcel, readInt);
            } else if (i == 3) {
                z = b.Z(parcel, readInt);
            } else if (i != 4) {
                b.v0(parcel, readInt);
            } else {
                z2 = b.Z(parcel, readInt);
            }
        }
        b.A(parcel, A0);
        return new zzj(str, iBinder, z, z2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzj[i];
    }
}
