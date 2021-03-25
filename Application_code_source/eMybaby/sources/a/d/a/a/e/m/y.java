package a.d.a.a.e.m;

import a.d.a.a.f.a;
import a.d.a.a.h.d.b;
import a.d.a.a.h.d.c;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.SignInButtonConfig;

public final class y extends b implements n {
    public y(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    public final a O(a aVar, SignInButtonConfig signInButtonConfig) {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f1466b);
        c.b(obtain, aVar);
        obtain.writeInt(1);
        signInButtonConfig.writeToParcel(obtain, 0);
        obtain = Parcel.obtain();
        try {
            this.f1465a.transact(2, obtain, obtain, 0);
            obtain.readException();
            obtain.recycle();
            return a.C0063a.g(obtain.readStrongBinder());
        } catch (RuntimeException e2) {
            throw e2;
        } finally {
            obtain.recycle();
        }
    }
}
