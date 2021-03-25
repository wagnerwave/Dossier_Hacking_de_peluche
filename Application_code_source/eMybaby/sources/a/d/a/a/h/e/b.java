package a.d.a.a.h.e;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public class b implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    public final IBinder f1467a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1468b;

    public b(IBinder iBinder, String str) {
        this.f1467a = iBinder;
        this.f1468b = str;
    }

    public IBinder asBinder() {
        return this.f1467a;
    }

    public final Parcel e() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f1468b);
        return obtain;
    }

    public final Parcel g(int i, Parcel parcel) {
        parcel = Parcel.obtain();
        try {
            this.f1467a.transact(i, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e2) {
            throw e2;
        } finally {
            parcel.recycle();
        }
    }
}
