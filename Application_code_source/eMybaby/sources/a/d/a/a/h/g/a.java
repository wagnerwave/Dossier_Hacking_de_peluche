package a.d.a.a.h.g;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    public final IBinder f1590a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1591b;

    public a(IBinder iBinder, String str) {
        this.f1590a = iBinder;
        this.f1591b = str;
    }

    public IBinder asBinder() {
        return this.f1590a;
    }

    public final Parcel e() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f1591b);
        return obtain;
    }

    public final Parcel g(int i, Parcel parcel) {
        parcel = Parcel.obtain();
        try {
            this.f1590a.transact(i, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e2) {
            throw e2;
        } finally {
            parcel.recycle();
        }
    }

    public final void h(int i, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.f1590a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
