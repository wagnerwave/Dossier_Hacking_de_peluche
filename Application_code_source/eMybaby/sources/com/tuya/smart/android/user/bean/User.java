package com.tuya.smart.android.user.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable, Cloneable {
    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel parcel) {
            User user = new User();
            int unused = user.regFrom = parcel.readInt();
            String unused2 = user.username = parcel.readString();
            String unused3 = user.sid = parcel.readString();
            String unused4 = user.uid = parcel.readString();
            String unused5 = user.service = parcel.readString();
            String unused6 = user.ecode = parcel.readString();
            String unused7 = user.nickName = parcel.readString();
            String unused8 = user.phoneCode = parcel.readString();
            String unused9 = user.partnerIdentity = parcel.readString();
            String unused10 = user.mobile = parcel.readString();
            int unused11 = user.userType = parcel.readInt();
            int unused12 = user.productCount = parcel.readInt();
            Domain unused13 = user.domain = Domain.CREATOR.createFromParcel(parcel);
            String unused14 = user.headPic = parcel.readString();
            String unused15 = user.timezoneId = parcel.readString();
            int unused16 = user.dataVersion = parcel.readInt();
            int unused17 = user.tempUnit = parcel.readInt();
            String unused18 = user.snsNickname = parcel.readString();
            return user;
        }

        public User[] newArray(int i) {
            return new User[0];
        }
    };
    public int dataVersion;
    public Domain domain;
    public String ecode;
    public String email;
    public String headPic;
    public String mobile;
    public String nickName;
    public String partnerIdentity;
    public String phoneCode;
    public int productCount;
    public int regFrom;
    public String service;
    public String sid;
    public String snsNickname;
    public int tempUnit;
    public String timezoneId;
    public String uid;
    public int userType;
    public String username;

    public Object clone() {
        try {
            return (User) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public int getDataVersion() {
        return this.dataVersion;
    }

    public Domain getDomain() {
        return this.domain;
    }

    public String getEcode() {
        return this.ecode;
    }

    public String getEmail() {
        return this.email;
    }

    public String getHeadPic() {
        return this.headPic;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getPartnerIdentity() {
        return this.partnerIdentity;
    }

    public String getPhoneCode() {
        return this.phoneCode;
    }

    public int getProductCount() {
        return this.productCount;
    }

    public int getRegFrom() {
        return this.regFrom;
    }

    public String getService() {
        return this.service;
    }

    public String getSid() {
        return this.sid;
    }

    public String getSnsNickname() {
        return this.snsNickname;
    }

    public int getTempUnit() {
        return this.tempUnit;
    }

    public String getTimezoneId() {
        return this.timezoneId;
    }

    public String getUid() {
        return this.uid;
    }

    public int getUserType() {
        return this.userType;
    }

    public String getUsername() {
        return this.username;
    }

    public void setDataVersion(int i) {
        this.dataVersion = i;
    }

    public void setDomain(Domain domain2) {
        this.domain = domain2;
    }

    public void setEcode(String str) {
        this.ecode = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setHeadPic(String str) {
        this.headPic = str;
    }

    public void setMobile(String str) {
        this.mobile = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setPartnerIdentity(String str) {
        this.partnerIdentity = str;
    }

    public void setPhoneCode(String str) {
        this.phoneCode = str;
    }

    public void setProductCount(int i) {
        this.productCount = i;
    }

    public void setRegFrom(int i) {
        this.regFrom = i;
    }

    public void setService(String str) {
        this.service = str;
    }

    public void setSid(String str) {
        this.sid = str;
    }

    public void setSnsNickname(String str) {
        this.snsNickname = str;
    }

    public void setTempUnit(int i) {
        this.tempUnit = i;
    }

    public void setTimezoneId(String str) {
        this.timezoneId = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUserType(int i) {
        this.userType = i;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.regFrom);
        parcel.writeString(this.username);
        parcel.writeString(this.sid);
        parcel.writeString(this.uid);
        parcel.writeString(this.service);
        parcel.writeString(this.ecode);
        parcel.writeString(this.nickName);
        parcel.writeString(this.phoneCode);
        parcel.writeString(this.partnerIdentity);
        parcel.writeString(this.mobile);
        parcel.writeInt(this.userType);
        parcel.writeInt(this.productCount);
        this.domain.writeToParcel(parcel, i);
        parcel.writeString(this.headPic);
        parcel.writeString(this.timezoneId);
        parcel.writeInt(this.dataVersion);
        parcel.writeInt(this.tempUnit);
        parcel.writeString(this.snsNickname);
    }
}
