package a.d.a.a.h.g;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public final class d extends a implements b {
    public d(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    public final int a() {
        Parcel g = g(2, e());
        int readInt = g.readInt();
        g.recycle();
        return readInt;
    }

    public final void q(String str, String str2, Bundle bundle, long j) {
        Parcel e2 = e();
        e2.writeString(str);
        e2.writeString(str2);
        u.c(e2, bundle);
        e2.writeLong(j);
        h(1, e2);
    }
}
