package com.tuya.smart.android.blemesh.bean;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;

public class SearchDeviceBean implements Parcelable {
    public static final Parcelable.Creator<SearchDeviceBean> CREATOR = new Parcelable.Creator<SearchDeviceBean>() {
        public SearchDeviceBean createFromParcel(Parcel parcel) {
            return new SearchDeviceBean(parcel);
        }

        public SearchDeviceBean[] newArray(int i) {
            return new SearchDeviceBean[i];
        }
    };
    public BluetoothDevice device;
    public String macAdress;
    public int meshAddress;
    public String meshName;
    public byte[] productId;
    public int rssi;
    public byte[] scanRecord;
    public byte[] sessionKey;
    public int status;
    public int type;
    public int vendorId;
    public String version;

    public SearchDeviceBean() {
    }

    public SearchDeviceBean(Parcel parcel) {
        this.meshName = parcel.readString();
        this.meshAddress = parcel.readInt();
        this.status = parcel.readInt();
        this.macAdress = parcel.readString();
        this.productId = parcel.createByteArray();
        this.vendorId = parcel.readInt();
        this.device = (BluetoothDevice) parcel.readParcelable(BluetoothDevice.class.getClassLoader());
        this.scanRecord = parcel.createByteArray();
        this.rssi = parcel.readInt();
        this.sessionKey = parcel.createByteArray();
        this.version = parcel.readString();
        this.type = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public BluetoothDevice getDevice() {
        return this.device;
    }

    public String getMacAdress() {
        return this.macAdress;
    }

    public int getMeshAddress() {
        return this.meshAddress;
    }

    public String getMeshName() {
        return this.meshName;
    }

    public byte[] getProductId() {
        byte[] bArr = this.productId;
        if (bArr != null) {
            return (byte[]) bArr.clone();
        }
        return null;
    }

    public int getRssi() {
        return this.rssi;
    }

    public byte[] getScanRecord() {
        byte[] bArr = this.scanRecord;
        if (bArr != null) {
            return (byte[]) bArr.clone();
        }
        return null;
    }

    public byte[] getSessionKey() {
        byte[] bArr = this.sessionKey;
        if (bArr != null) {
            return (byte[]) bArr.clone();
        }
        return null;
    }

    public int getStatus() {
        return this.status;
    }

    public int getType() {
        return this.type;
    }

    public int getVendorId() {
        return this.vendorId;
    }

    public String getVersion() {
        return this.version;
    }

    public void setDevice(BluetoothDevice bluetoothDevice) {
        this.device = bluetoothDevice;
    }

    public void setMacAdress(String str) {
        this.macAdress = str;
    }

    public void setMeshAddress(int i) {
        this.meshAddress = i;
    }

    public void setMeshName(String str) {
        this.meshName = str;
    }

    public void setProductId(byte[] bArr) {
        if (bArr != null) {
            this.productId = (byte[]) bArr.clone();
        } else {
            this.productId = null;
        }
    }

    public void setRssi(int i) {
        this.rssi = i;
    }

    public void setScanRecord(byte[] bArr) {
        if (bArr != null) {
            this.scanRecord = (byte[]) bArr.clone();
        } else {
            this.scanRecord = null;
        }
    }

    public void setSessionKey(byte[] bArr) {
        if (bArr != null) {
            this.sessionKey = (byte[]) bArr.clone();
        } else {
            this.sessionKey = null;
        }
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setVendorId(int i) {
        this.vendorId = i;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.meshName);
        parcel.writeInt(this.meshAddress);
        parcel.writeInt(this.status);
        parcel.writeString(this.macAdress);
        parcel.writeByteArray(this.productId);
        parcel.writeInt(this.vendorId);
        parcel.writeParcelable(this.device, i);
        parcel.writeByteArray(this.scanRecord);
        parcel.writeInt(this.rssi);
        parcel.writeByteArray(this.sessionKey);
        parcel.writeString(this.version);
        parcel.writeInt(this.type);
    }
}
