package a.d.a.a.e.k;

import a.c.a.f.b;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

public final class n implements Parcelable.Creator<Status> {
    public final Object createFromParcel(Parcel parcel) {
        int A0 = b.A0(parcel);
        String str = null;
        PendingIntent pendingIntent = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < A0) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = b.b0(parcel, readInt);
            } else if (i3 == 2) {
                str = b.t(parcel, readInt);
            } else if (i3 == 3) {
                pendingIntent = (PendingIntent) b.s(parcel, readInt, PendingIntent.CREATOR);
            } else if (i3 != 1000) {
                b.v0(parcel, readInt);
            } else {
                i = b.b0(parcel, readInt);
            }
        }
        b.A(parcel, A0);
        return new Status(i, i2, str, pendingIntent);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Status[i];
    }
}
