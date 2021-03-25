package a.d.a.a.h.g;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public final class q3 extends a implements a2 {
    public q3(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    public final Bundle f(Bundle bundle) {
        Parcel e2 = e();
        u.c(e2, bundle);
        Parcel g = g(1, e2);
        Bundle bundle2 = (Bundle) u.a(g, Bundle.CREATOR);
        g.recycle();
        return bundle2;
    }
}
