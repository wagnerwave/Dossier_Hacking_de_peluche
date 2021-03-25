package com.tuya.sdk.personal.bean;

public class UserReceivedShareBean {
    public long id;
    public String mname;
    public String mobile;
    public String receivedName;

    public long getId() {
        return this.id;
    }

    public String getMname() {
        return this.mname;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getReceivedName() {
        return this.receivedName;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setMname(String str) {
        this.mname = str;
    }

    public void setMobile(String str) {
        this.mobile = str;
    }

    public void setReceivedName(String str) {
        this.receivedName = str;
    }
}
