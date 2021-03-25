package com.tuya.smart.android.hardware;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tuya.smart.android.hardware.bean.HgwBean;

public interface ITransferAidlInterface extends IInterface {

    public static abstract class Stub extends Binder implements ITransferAidlInterface {
        public static final String DESCRIPTOR = "com.tuya.smart.android.hardware.ITransferAidlInterface";
        public static final int TRANSACTION_closeService = 5;
        public static final int TRANSACTION_getAppId = 4;
        public static final int TRANSACTION_gwOff = 2;
        public static final int TRANSACTION_gwOn = 1;
        public static final int TRANSACTION_responseByBinary = 3;

        public static class Proxy implements ITransferAidlInterface {
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void closeService() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getAppId() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public void gwOff(HgwBean hgwBean) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (hgwBean != null) {
                        obtain.writeInt(1);
                        hgwBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void gwOn(HgwBean hgwBean) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (hgwBean != null) {
                        obtain.writeInt(1);
                        hgwBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void responseByBinary(String str, String str2, int i, int i2, int i3, byte[] bArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    obtain2.readByteArray(bArr);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITransferAidlInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ITransferAidlInterface)) ? new Proxy(iBinder) : (ITransferAidlInterface) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            HgwBean hgwBean = null;
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                if (parcel.readInt() != 0) {
                    hgwBean = HgwBean.CREATOR.createFromParcel(parcel);
                }
                gwOn(hgwBean);
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                if (parcel.readInt() != 0) {
                    hgwBean = HgwBean.CREATOR.createFromParcel(parcel);
                }
                gwOff(hgwBean);
                parcel2.writeNoException();
                return true;
            } else if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                int readInt = parcel.readInt();
                int readInt2 = parcel.readInt();
                int readInt3 = parcel.readInt();
                byte[] createByteArray = parcel.createByteArray();
                responseByBinary(readString, readString2, readInt, readInt2, readInt3, createByteArray);
                parcel2.writeNoException();
                parcel2.writeByteArray(createByteArray);
                return true;
            } else if (i == 4) {
                parcel.enforceInterface(DESCRIPTOR);
                String appId = getAppId();
                parcel2.writeNoException();
                parcel2.writeString(appId);
                return true;
            } else if (i == 5) {
                parcel.enforceInterface(DESCRIPTOR);
                closeService();
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    void closeService();

    String getAppId();

    void gwOff(HgwBean hgwBean);

    void gwOn(HgwBean hgwBean);

    void responseByBinary(String str, String str2, int i, int i2, int i3, byte[] bArr);
}
