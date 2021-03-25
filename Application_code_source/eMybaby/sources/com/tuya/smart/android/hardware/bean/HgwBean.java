package com.tuya.smart.android.hardware.bean;

import a.a.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;

public class HgwBean implements Parcelable {
    public static final Parcelable.Creator<HgwBean> CREATOR = new Parcelable.Creator<HgwBean>() {
        public HgwBean createFromParcel(Parcel parcel) {
            return new HgwBean(parcel);
        }

        public HgwBean[] newArray(int i) {
            return new HgwBean[i];
        }
    };
    public int ablilty;
    public int active;
    public boolean encrypt;
    public String gwId;
    public String ip;
    public long lastSeenTime = 0;
    public int mode;
    public String productKey;
    public boolean token;
    public String version;
    public boolean wf_cfg;

    public HgwBean() {
    }

    public HgwBean(Parcel parcel) {
        this.ip = parcel.readString();
        this.gwId = parcel.readString();
        this.active = parcel.readInt();
        this.ablilty = parcel.readInt();
        this.lastSeenTime = parcel.readLong();
        this.mode = parcel.readInt();
        boolean z = false;
        this.encrypt = parcel.readByte() == 1;
        this.productKey = parcel.readString();
        this.version = parcel.readString();
        this.token = parcel.readByte() == 1;
        this.wf_cfg = parcel.readByte() == 1 ? true : z;
    }

    public HgwBean(String str, String str2, int i, int i2, long j, int i3, boolean z, String str3, String str4, boolean z2, boolean z3) {
        this.ip = str;
        this.gwId = str2;
        this.active = i;
        this.ablilty = i2;
        this.lastSeenTime = j;
        this.mode = i3;
        this.encrypt = z;
        this.productKey = str3;
        this.version = str4;
        this.token = z2;
        this.wf_cfg = z3;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof HgwBean)) {
            return false;
        }
        return ((HgwBean) obj).gwId.equals(this.gwId);
    }

    public int getAblilty() {
        return this.ablilty;
    }

    public int getActive() {
        return this.active;
    }

    public String getGwId() {
        return this.gwId;
    }

    public String getIp() {
        return this.ip;
    }

    public long getLastSeenTime() {
        return this.lastSeenTime;
    }

    public int getMode() {
        return this.mode;
    }

    public String getProductKey() {
        return this.productKey;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isEncrypt() {
        return this.encrypt;
    }

    public boolean isToken() {
        return this.token;
    }

    public boolean isWf_cfg() {
        return this.wf_cfg;
    }

    public void setAblilty(int i) {
        this.ablilty = i;
    }

    public void setActive(int i) {
        this.active = i;
    }

    public void setEncrypt(boolean z) {
        this.encrypt = z;
    }

    public void setGwId(String str) {
        this.gwId = str;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public void setLastSeenTime(long j) {
        this.lastSeenTime = j;
    }

    public void setMode(int i) {
        this.mode = i;
    }

    public void setProductKey(String str) {
        this.productKey = str;
    }

    public void setToken(boolean z) {
        this.token = z;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        StringBuilder n = a.n("HgwBean{ip='");
        a.x(n, this.ip, '\'', ", gwId='");
        a.x(n, this.gwId, '\'', ", active=");
        n.append(this.active);
        n.append(", ability=");
        n.append(this.ablilty);
        n.append(", lastSeenTime=");
        n.append(this.lastSeenTime);
        n.append(", mode=");
        n.append(this.mode);
        n.append(", encrypt=");
        n.append(this.encrypt);
        n.append(", productKey='");
        a.x(n, this.productKey, '\'', ", version='");
        a.x(n, this.version, '\'', ", token=");
        n.append(this.token);
        n.append(", wf_cfg=");
        n.append(this.wf_cfg);
        n.append('}');
        return n.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.ip);
        parcel.writeString(this.gwId);
        parcel.writeInt(this.active);
        parcel.writeInt(this.ablilty);
        parcel.writeLong(this.lastSeenTime);
        parcel.writeInt(this.mode);
        parcel.writeByte(this.encrypt ? (byte) 1 : 0);
        parcel.writeString(this.productKey);
        parcel.writeString(this.version);
        parcel.writeByte(this.token ? (byte) 1 : 0);
        parcel.writeByte(this.wf_cfg ? (byte) 1 : 0);
    }
}
