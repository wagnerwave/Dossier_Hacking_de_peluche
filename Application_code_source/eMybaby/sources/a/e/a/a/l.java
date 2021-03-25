package a.e.a.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface l extends IInterface {

    public static abstract class a extends Binder implements l {

        /* renamed from: a.e.a.a.l$a$a  reason: collision with other inner class name */
        public static class C0075a implements l {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f3232a;

            public C0075a(IBinder iBinder) {
                this.f3232a = iBinder;
            }

            public IBinder asBinder() {
                return this.f3232a;
            }

            public void p(int i, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.inuker.bluetooth.library.IResponse");
                    obtain.writeInt(i);
                    obtain.writeInt(1);
                    bundle.writeToParcel(obtain, 0);
                    this.f3232a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.inuker.bluetooth.library.IResponse");
        }

        public static l e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.inuker.bluetooth.library.IResponse");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof l)) ? new C0075a(iBinder) : (l) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.inuker.bluetooth.library.IResponse");
                int readInt = parcel.readInt();
                Bundle bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                p(readInt, bundle);
                parcel2.writeNoException();
                if (bundle != null) {
                    parcel2.writeInt(1);
                    bundle.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.inuker.bluetooth.library.IResponse");
                return true;
            }
        }
    }

    void p(int i, Bundle bundle);
}
