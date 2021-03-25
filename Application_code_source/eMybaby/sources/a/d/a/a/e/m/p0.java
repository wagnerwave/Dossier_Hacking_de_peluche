package a.d.a.a.e.m;

import a.d.a.a.f.a;
import a.d.a.a.h.e.b;
import a.d.a.a.h.e.c;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.zzj;

public final class p0 extends b implements o0 {
    public p0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    public final boolean K(zzj zzj, a aVar) {
        Parcel e2 = e();
        c.c(e2, zzj);
        c.b(e2, aVar);
        Parcel g = g(5, e2);
        boolean z = g.readInt() != 0;
        g.recycle();
        return z;
    }
}
