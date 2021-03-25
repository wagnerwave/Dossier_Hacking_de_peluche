package a.d.a.a.j.b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.signin.internal.zab;

public final class b implements Parcelable.Creator<zab> {
    public final Object createFromParcel(Parcel parcel) {
        int A0 = a.c.a.f.b.A0(parcel);
        int i = 0;
        Intent intent = null;
        int i2 = 0;
        while (parcel.dataPosition() < A0) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i = a.c.a.f.b.b0(parcel, readInt);
            } else if (i3 == 2) {
                i2 = a.c.a.f.b.b0(parcel, readInt);
            } else if (i3 != 3) {
                a.c.a.f.b.v0(parcel, readInt);
            } else {
                intent = (Intent) a.c.a.f.b.s(parcel, readInt, Intent.CREATOR);
            }
        }
        a.c.a.f.b.A(parcel, A0);
        return new zab(i, i2, intent);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zab[i];
    }
}
