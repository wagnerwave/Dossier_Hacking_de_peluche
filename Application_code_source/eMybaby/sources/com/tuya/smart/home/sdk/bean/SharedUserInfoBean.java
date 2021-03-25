package com.tuya.smart.home.sdk.bean;

public class SharedUserInfoBean {
    public long homeId;
    public String iconUrl;
    public long memeberId;
    public String mobile;
    public String remarkName;
    public String userName;

    public long getHomeId() {
        return this.homeId;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public long getMemeberId() {
        return this.memeberId;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getRemarkName() {
        return this.remarkName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setHomeId(long j) {
        this.homeId = j;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setMemeberId(long j) {
        this.memeberId = j;
    }

    public void setMobile(String str) {
        this.mobile = str;
    }

    public void setRemarkName(String str) {
        this.remarkName = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }
}
