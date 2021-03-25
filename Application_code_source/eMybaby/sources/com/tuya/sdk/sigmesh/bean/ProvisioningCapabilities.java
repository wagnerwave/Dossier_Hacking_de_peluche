package com.tuya.sdk.sigmesh.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class ProvisioningCapabilities implements Parcelable {
    public static final Parcelable.Creator<ProvisioningCapabilities> CREATOR = new Parcelable.Creator<ProvisioningCapabilities>() {
        public ProvisioningCapabilities createFromParcel(Parcel parcel) {
            return new ProvisioningCapabilities(parcel);
        }

        public ProvisioningCapabilities[] newArray(int i) {
            return new ProvisioningCapabilities[i];
        }
    };
    public short algorithm;
    public short inputOOBAction;
    public byte inputOOBSize;
    public byte numberOfElements;
    public short outputOOBAction;
    public byte outputOOBSize;
    public byte publicKeyType;
    public byte[] rawCapabilities;
    public byte staticOOBType;

    public ProvisioningCapabilities() {
    }

    public ProvisioningCapabilities(Parcel parcel) {
        this.rawCapabilities = parcel.createByteArray();
        this.numberOfElements = parcel.readByte();
        this.algorithm = (short) parcel.readInt();
        this.publicKeyType = parcel.readByte();
        this.staticOOBType = parcel.readByte();
        this.outputOOBSize = parcel.readByte();
        this.outputOOBAction = (short) parcel.readInt();
        this.inputOOBSize = parcel.readByte();
        this.inputOOBAction = (short) parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public short getInputOOBAction() {
        return this.inputOOBAction;
    }

    public byte getInputOOBSize() {
        return this.inputOOBSize;
    }

    public byte getNumberOfElements() {
        return this.numberOfElements;
    }

    public short getOutputOOBAction() {
        return this.outputOOBAction;
    }

    public byte getOutputOOBSize() {
        return this.outputOOBSize;
    }

    public byte getPublicKeyType() {
        return this.publicKeyType;
    }

    public byte[] getRawCapabilities() {
        return this.rawCapabilities;
    }

    public byte getStaticOOBType() {
        return this.staticOOBType;
    }

    public short getSupportedAlgorithm() {
        return this.algorithm;
    }

    public void setInputOOBAction(short s) {
        this.inputOOBAction = s;
    }

    public void setInputOOBSize(byte b2) {
        this.inputOOBSize = b2;
    }

    public void setNumberOfElements(byte b2) {
        this.numberOfElements = b2;
    }

    public void setOutputOOBAction(short s) {
        this.outputOOBAction = s;
    }

    public void setOutputOOBSize(byte b2) {
        this.outputOOBSize = b2;
    }

    public void setPublicKeyType(byte b2) {
        this.publicKeyType = b2;
    }

    public void setRawCapabilities(byte[] bArr) {
        this.rawCapabilities = bArr;
    }

    public void setStaticOOBType(byte b2) {
        this.staticOOBType = b2;
    }

    public void setSupportedAlgorithm(short s) {
        this.algorithm = s;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.rawCapabilities);
        parcel.writeByte(this.numberOfElements);
        parcel.writeInt(this.algorithm);
        parcel.writeByte(this.publicKeyType);
        parcel.writeByte(this.staticOOBType);
        parcel.writeByte(this.outputOOBSize);
        parcel.writeInt(this.outputOOBAction);
        parcel.writeByte(this.inputOOBSize);
        parcel.writeInt(this.inputOOBAction);
    }
}
