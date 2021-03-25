package com.tuya.smart.android.user.bean;

import a.a.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;

public class Domain implements Parcelable, Cloneable {
    public static final Parcelable.Creator<Domain> CREATOR = new Parcelable.Creator<Domain>() {
        public Domain createFromParcel(Parcel parcel) {
            Domain domain = new Domain();
            domain.setGwApiUrl(parcel.readString());
            domain.setGwMqttUrl(parcel.readString());
            domain.setMobileApiUrl(parcel.readString());
            domain.setMobileMqttUrl(parcel.readString());
            domain.setMobileMqttsUrl(parcel.readString());
            domain.setRegionCode(parcel.readString());
            domain.setMobileMediaMqttUrl(parcel.readString());
            domain.setLogUrl(parcel.readString());
            return domain;
        }

        public Domain[] newArray(int i) {
            return new Domain[0];
        }
    };
    public static final String DOMAIN_AY = "AY";
    public static final String DOMAIN_AZ = "AZ";
    public static final String DOMAIN_EU = "EU";
    public static final String DOMAIN_SH = "SH";
    public static final String DOMAIN_Undefined = "UE";
    public String aispeechHttpsUrl;
    public String gwApiUrl;
    public String gwMqttUrl;
    public String logUrl;
    public String mobileApiUrl;
    public String mobileMediaMqttUrl;
    public String mobileMqttUrl;
    public String mobileMqttsUrl;
    public String regionCode;

    public int describeContents() {
        return 0;
    }

    public String getAispeechHttpsUrl() {
        return this.aispeechHttpsUrl;
    }

    public String getGwApiUrl() {
        return this.gwApiUrl;
    }

    public String getGwMqttUrl() {
        return this.gwMqttUrl;
    }

    public String getLogUrl() {
        return this.logUrl;
    }

    public String getMobileApiUrl() {
        return this.mobileApiUrl;
    }

    public String getMobileMediaMqttUrl() {
        return this.mobileMediaMqttUrl;
    }

    public String getMobileMqttUrl() {
        return this.mobileMqttUrl;
    }

    public String getMobileMqttsUrl() {
        return this.mobileMqttsUrl;
    }

    public String getRegionCode() {
        return this.regionCode;
    }

    public void setAispeechHttpsUrl(String str) {
        this.aispeechHttpsUrl = str;
    }

    public void setGwApiUrl(String str) {
        this.gwApiUrl = str;
    }

    public void setGwMqttUrl(String str) {
        this.gwMqttUrl = str;
    }

    public void setLogUrl(String str) {
        this.logUrl = str;
    }

    public void setMobileApiUrl(String str) {
        this.mobileApiUrl = str;
    }

    public void setMobileMediaMqttUrl(String str) {
        this.mobileMediaMqttUrl = str;
    }

    public void setMobileMqttUrl(String str) {
        this.mobileMqttUrl = str;
    }

    public void setMobileMqttsUrl(String str) {
        this.mobileMqttsUrl = str;
    }

    public void setRegionCode(String str) {
        this.regionCode = str;
    }

    public String toString() {
        StringBuilder n = a.n("Domain{gwApiUrl='");
        a.x(n, this.gwApiUrl, '\'', ", gwMqttUrl='");
        a.x(n, this.gwMqttUrl, '\'', ", mobileApiUrl='");
        a.x(n, this.mobileApiUrl, '\'', ", mobileMqttUrl='");
        a.x(n, this.mobileMqttUrl, '\'', ", regionCode='");
        n.append(this.regionCode);
        n.append('\'');
        n.append('}');
        return n.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.gwApiUrl);
        parcel.writeString(this.gwMqttUrl);
        parcel.writeString(this.mobileApiUrl);
        parcel.writeString(this.mobileMqttUrl);
        parcel.writeString(this.mobileMqttsUrl);
        parcel.writeString(this.regionCode);
        parcel.writeString(this.mobileMediaMqttUrl);
        parcel.writeString(this.logUrl);
    }
}
