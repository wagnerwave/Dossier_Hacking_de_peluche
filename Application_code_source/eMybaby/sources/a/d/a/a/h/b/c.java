package a.d.a.a.h.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public class c implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    public final IBinder f1462a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1463b;

    public c(IBinder iBinder, String str) {
        this.f1462a = iBinder;
        this.f1463b = str;
    }

    public IBinder asBinder() {
        return this.f1462a;
    }

    public final void e(int i, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.f1462a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
