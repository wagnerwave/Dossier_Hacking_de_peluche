package a.d.a.a.h.f;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;
import java.util.Map;

public final class p0 implements o0, IInterface {

    /* renamed from: a  reason: collision with root package name */
    public final IBinder f1548a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1549b = "com.google.android.gms.analytics.internal.IAnalyticsService";

    public p0(IBinder iBinder) {
        this.f1548a = iBinder;
    }

    public final void C(Map map, long j, String str, List<Object> list) {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f1549b);
        obtain.writeMap(map);
        obtain.writeLong(j);
        obtain.writeString(str);
        obtain.writeTypedList(list);
        Parcel obtain2 = Parcel.obtain();
        try {
            this.f1548a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain.recycle();
            obtain2.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f1548a;
    }
}
