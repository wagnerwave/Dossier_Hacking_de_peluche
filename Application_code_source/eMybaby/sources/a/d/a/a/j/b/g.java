package a.d.a.a.j.b;

import a.d.a.a.h.d.b;
import a.d.a.a.h.d.c;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.signin.internal.zai;

public final class g extends b implements e {
    public g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void T(zai zai, c cVar) {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f1466b);
        c.c(obtain, zai);
        obtain.writeStrongBinder(cVar.asBinder());
        Parcel obtain2 = Parcel.obtain();
        try {
            this.f1465a.transact(12, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain.recycle();
            obtain2.recycle();
        }
    }
}
