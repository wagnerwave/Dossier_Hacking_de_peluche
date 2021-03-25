package a.d.a.a.e.m;

import a.d.a.a.h.e.a;
import android.os.IBinder;
import android.os.IInterface;

public abstract class n0 extends a implements o0 {
    public static o0 g(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        return queryLocalInterface instanceof o0 ? (o0) queryLocalInterface : new p0(iBinder);
    }
}
