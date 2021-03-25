package a.d.a.a.h.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class d implements b, IInterface {

    /* renamed from: a  reason: collision with root package name */
    public final IBinder f1459a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1460b = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";

    public d(IBinder iBinder) {
        this.f1459a = iBinder;
    }

    public final boolean J(boolean z) {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f1460b);
        a.a(obtain);
        Parcel e2 = e(2, obtain);
        boolean z2 = e2.readInt() != 0;
        e2.recycle();
        return z2;
    }

    public IBinder asBinder() {
        return this.f1459a;
    }

    public final Parcel e(int i, Parcel parcel) {
        parcel = Parcel.obtain();
        try {
            this.f1459a.transact(i, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e2) {
            throw e2;
        } finally {
            parcel.recycle();
        }
    }

    public final String getId() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f1460b);
        Parcel e2 = e(1, obtain);
        String readString = e2.readString();
        e2.recycle();
        return readString;
    }
}
