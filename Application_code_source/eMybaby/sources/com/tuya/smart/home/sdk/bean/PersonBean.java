package com.tuya.smart.home.sdk.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class PersonBean implements Parcelable {
    public static final Parcelable.Creator<PersonBean> CREATOR = new Parcelable.Creator<PersonBean>() {
        public PersonBean createFromParcel(Parcel parcel) {
            PersonBean personBean = new PersonBean();
            String unused = personBean.name = parcel.readString();
            String unused2 = personBean.mobile = parcel.readString();
            String unused3 = personBean.uid = parcel.readString();
            long unused4 = personBean.id = parcel.readLong();
            int unused5 = personBean.gid = parcel.readInt();
            String unused6 = personBean.mname = parcel.readString();
            String unused7 = personBean.username = parcel.readString();
            String unused8 = personBean.memberName = parcel.readString();
            String unused9 = personBean.receivedName = parcel.readString();
            String unused10 = personBean.headPic = parcel.readString();
            return personBean;
        }

        public PersonBean[] newArray(int i) {
            return new PersonBean[i];
        }
    };
    public int gid;
    public String headPic;
    public long id;
    public String memberName;
    public String mname;
    public String mobile;
    public String name;
    public String receivedName;
    public String uid;
    public String username;

    public int describeContents() {
        return 0;
    }

    public Integer getGid() {
        return Integer.valueOf(this.gid);
    }

    public String getHeadPic() {
        return this.headPic;
    }

    public long getId() {
        return this.id;
    }

    public String getMemberName() {
        return this.memberName;
    }

    public String getMname() {
        return this.mname;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getName() {
        return this.name;
    }

    public String getReceivedName() {
        return this.receivedName;
    }

    public String getUid() {
        return this.uid;
    }

    public String getUsername() {
        return this.username;
    }

    public void setGid(Integer num) {
        this.gid = num.intValue();
    }

    public void setHeadPic(String str) {
        this.headPic = str;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setMemberName(String str) {
        this.memberName = str;
    }

    public void setMname(String str) {
        this.mname = str;
    }

    public void setMobile(String str) {
        this.mobile = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setReceivedName(String str) {
        this.receivedName = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.mobile);
        parcel.writeString(this.uid);
        parcel.writeLong(this.id);
        parcel.writeInt(this.gid);
        parcel.writeString(this.mname);
        parcel.writeString(this.username);
        parcel.writeString(this.memberName);
    }
}
