package com.tuya.smart.android.device.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class DevLocationBean implements Parcelable {
    public static final Parcelable.Creator<DevLocationBean> CREATOR = new Parcelable.Creator<DevLocationBean>() {
        public DevLocationBean createFromParcel(Parcel parcel) {
            return new DevLocationBean(parcel);
        }

        public DevLocationBean[] newArray(int i) {
            return new DevLocationBean[i];
        }
    };
    public String devId;
    public String gwId;
    public double lat;
    public double lon;
    public int lower;
    public int status = -1;
    public int upper;

    public DevLocationBean() {
    }

    public DevLocationBean(Parcel parcel) {
        this.lat = parcel.readDouble();
        this.lon = parcel.readDouble();
        this.devId = parcel.readString();
        this.gwId = parcel.readString();
        this.lower = parcel.readInt();
        this.upper = parcel.readInt();
        this.status = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public String getDevId() {
        return this.devId;
    }

    public String getGwId() {
        return this.gwId;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLon() {
        return this.lon;
    }

    public int getLower() {
        return this.lower;
    }

    public int getStatus() {
        return this.status;
    }

    public int getUpper() {
        return this.upper;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setGwId(String str) {
        this.gwId = str;
    }

    public void setLat(double d2) {
        this.lat = d2;
    }

    public void setLon(double d2) {
        this.lon = d2;
    }

    public void setLower(int i) {
        this.lower = i;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setUpper(int i) {
        this.upper = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.lat);
        parcel.writeDouble(this.lon);
        parcel.writeString(this.devId);
        parcel.writeString(this.gwId);
        parcel.writeInt(this.lower);
        parcel.writeInt(this.upper);
        parcel.writeInt(this.status);
    }
}
