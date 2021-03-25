package a.d.a.a.h.g;

import android.os.IBinder;
import android.os.IInterface;

public abstract class k4 extends p0 implements a2 {
    public static a2 g(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
        return queryLocalInterface instanceof a2 ? (a2) queryLocalInterface : new q3(iBinder);
    }
}
