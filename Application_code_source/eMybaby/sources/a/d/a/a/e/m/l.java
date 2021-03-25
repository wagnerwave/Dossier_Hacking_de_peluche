package a.d.a.a.e.m;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.GetServiceRequest;

public final class l implements m {

    /* renamed from: a  reason: collision with root package name */
    public final IBinder f1404a;

    public l(IBinder iBinder) {
        this.f1404a = iBinder;
    }

    public final void E(k kVar, GetServiceRequest getServiceRequest) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder(kVar.asBinder());
            obtain.writeInt(1);
            getServiceRequest.writeToParcel(obtain, 0);
            this.f1404a.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.f1404a;
    }
}
