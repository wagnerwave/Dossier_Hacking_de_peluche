package a.d.a.a.c.a.d.c;

import a.d.a.a.h.b.c;
import a.d.a.a.h.b.d;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public final class p extends c implements q {
    public p(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    public final void F(o oVar, GoogleSignInOptions googleSignInOptions) {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f1463b);
        d.b(obtain, oVar);
        if (googleSignInOptions == null) {
            obtain.writeInt(0);
        } else {
            obtain.writeInt(1);
            googleSignInOptions.writeToParcel(obtain, 0);
        }
        e(102, obtain);
    }

    public final void x(o oVar, GoogleSignInOptions googleSignInOptions) {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f1463b);
        d.b(obtain, oVar);
        if (googleSignInOptions == null) {
            obtain.writeInt(0);
        } else {
            obtain.writeInt(1);
            googleSignInOptions.writeToParcel(obtain, 0);
        }
        e(103, obtain);
    }
}
