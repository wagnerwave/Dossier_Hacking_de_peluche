package a.e.a.a;

import a.e.a.a.l;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface k extends IInterface {

    public static abstract class a extends Binder implements k {

        /* renamed from: a.e.a.a.k$a$a  reason: collision with other inner class name */
        public static class C0074a implements k {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f3231a;

            public C0074a(IBinder iBinder) {
                this.f3231a = iBinder;
            }

            public void L(int i, Bundle bundle, l lVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.inuker.bluetooth.library.IBluetoothService");
                    obtain.writeInt(i);
                    obtain.writeInt(1);
                    bundle.writeToParcel(obtain, 0);
                    obtain.writeStrongBinder(lVar != null ? lVar.asBinder() : null);
                    this.f3231a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f3231a;
            }
        }

        public a() {
            attachInterface(this, "com.inuker.bluetooth.library.IBluetoothService");
        }

        public static k e(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.inuker.bluetooth.library.IBluetoothService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof k)) ? new C0074a(iBinder) : (k) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.inuker.bluetooth.library.IBluetoothService");
                int readInt = parcel.readInt();
                Bundle bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                L(readInt, bundle, l.a.e(parcel.readStrongBinder()));
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
                parcel2.writeString("com.inuker.bluetooth.library.IBluetoothService");
                return true;
            }
        }
    }

    void L(int i, Bundle bundle, l lVar);
}
