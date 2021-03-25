package com.tuya.sdk.hardware.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class HResponse implements Parcelable {
    public static final Parcelable.Creator<HResponse> CREATOR = new Parcelable.Creator<HResponse>() {
        public HResponse createFromParcel(Parcel parcel) {
            return new HResponse(parcel);
        }

        public HResponse[] newArray(int i) {
            return new HResponse[i];
        }
    };
    public int code;
    public byte[] dataBinary;
    public String devId;
    public int seq;
    public int type;
    public String version;

    public HResponse() {
    }

    public HResponse(Parcel parcel) {
        this.devId = parcel.readString();
        this.type = parcel.readInt();
        this.seq = parcel.readInt();
        this.code = parcel.readInt();
    }

    public HResponse(String str, int i, int i2, int i3, byte[] bArr, String str2) {
        this.devId = str;
        this.type = i;
        this.seq = i2;
        this.code = i3;
        this.dataBinary = bArr;
        this.version = str2;
    }

    public int describeContents() {
        return 0;
    }

    public int getCode() {
        return this.code;
    }

    public byte[] getDataBinary() {
        return this.dataBinary;
    }

    public String getDevId() {
        return this.devId;
    }

    public int getSeq() {
        return this.seq;
    }

    public int getType() {
        return this.type;
    }

    public String getVersion() {
        return this.version;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setDataBinary(byte[] bArr) {
        this.dataBinary = bArr;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setSeq(int i) {
        this.seq = i;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.devId);
        parcel.writeInt(this.type);
        parcel.writeInt(this.seq);
        parcel.writeInt(this.code);
    }
}
