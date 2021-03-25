package com.tuya.smart.android.hardware;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tuya.smart.android.hardware.ITransferAidlInterface;
import com.tuya.smart.android.hardware.bean.HgwBean;
import java.util.List;

public interface ITransferServiceAidlInterface extends IInterface {

    public static abstract class Stub extends Binder implements ITransferServiceAidlInterface {
        public static final String DESCRIPTOR = "com.tuya.smart.android.hardware.ITransferServiceAidlInterface";
        public static final int TRANSACTION_addGw = 3;
        public static final int TRANSACTION_closeService = 9;
        public static final int TRANSACTION_controlByBinary = 7;
        public static final int TRANSACTION_deleteGw = 4;
        public static final int TRANSACTION_getGw = 5;
        public static final int TRANSACTION_getServiceVersion = 8;
        public static final int TRANSACTION_queryGw = 6;
        public static final int TRANSACTION_registerCallback = 1;
        public static final int TRANSACTION_unRegisterCallback = 2;

        public static class Proxy implements ITransferServiceAidlInterface {
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public void addGw(HgwBean hgwBean) {
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
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void closeService() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean controlByBinary(String str, int i, byte[] bArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    boolean z = false;
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.readByteArray(bArr);
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void deleteGw(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public HgwBean getGw(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? HgwBean.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public String getServiceVersion() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<HgwBean> queryGw() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(HgwBean.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void registerCallback(ITransferAidlInterface iTransferAidlInterface) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iTransferAidlInterface != null ? iTransferAidlInterface.asBinder() : null);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unRegisterCallback(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITransferServiceAidlInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ITransferServiceAidlInterface)) ? new Proxy(iBinder) : (ITransferServiceAidlInterface) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        registerCallback(ITransferAidlInterface.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        unRegisterCallback(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        addGw(parcel.readInt() != 0 ? HgwBean.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        deleteGw(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        HgwBean gw = getGw(parcel.readString());
                        parcel2.writeNoException();
                        if (gw != null) {
                            parcel2.writeInt(1);
                            gw.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        List<HgwBean> queryGw = queryGw();
                        parcel2.writeNoException();
                        parcel2.writeTypedList(queryGw);
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        String readString = parcel.readString();
                        int readInt = parcel.readInt();
                        byte[] createByteArray = parcel.createByteArray();
                        boolean controlByBinary = controlByBinary(readString, readInt, createByteArray);
                        parcel2.writeNoException();
                        parcel2.writeInt(controlByBinary ? 1 : 0);
                        parcel2.writeByteArray(createByteArray);
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        String serviceVersion = getServiceVersion();
                        parcel2.writeNoException();
                        parcel2.writeString(serviceVersion);
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        closeService();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    void addGw(HgwBean hgwBean);

    void closeService();

    boolean controlByBinary(String str, int i, byte[] bArr);

    void deleteGw(String str);

    HgwBean getGw(String str);

    String getServiceVersion();

    List<HgwBean> queryGw();

    void registerCallback(ITransferAidlInterface iTransferAidlInterface);

    void unRegisterCallback(String str);
}
