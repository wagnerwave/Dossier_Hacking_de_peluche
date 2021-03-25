package a.d.a.a.h.g;

import android.os.Bundle;
import android.os.Parcel;

public abstract class rd extends p0 implements od {
    public rd() {
        super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    public final boolean e(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        f((Bundle) u.a(parcel, Bundle.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
