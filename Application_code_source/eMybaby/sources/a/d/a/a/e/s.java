package a.d.a.a.e;

import a.c.a.f.b;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;

public final class s implements Parcelable.Creator<ConnectionResult> {
    public final Object createFromParcel(Parcel parcel) {
        int A0 = b.A0(parcel);
        int i = 0;
        PendingIntent pendingIntent = null;
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < A0) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i = b.b0(parcel, readInt);
            } else if (i3 == 2) {
                i2 = b.b0(parcel, readInt);
            } else if (i3 == 3) {
                pendingIntent = (PendingIntent) b.s(parcel, readInt, PendingIntent.CREATOR);
            } else if (i3 != 4) {
                b.v0(parcel, readInt);
            } else {
                str = b.t(parcel, readInt);
            }
        }
        b.A(parcel, A0);
        return new ConnectionResult(i, i2, pendingIntent, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ConnectionResult[i];
    }
}
