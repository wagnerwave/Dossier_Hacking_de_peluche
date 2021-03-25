package a.d.a.a.h.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public abstract class c extends Binder implements b, IInterface {
    public static b e(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        return queryLocalInterface instanceof b ? (b) queryLocalInterface : new d(iBinder);
    }
}
