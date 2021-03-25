package com.tuya.sdk.home.bean;

public class MemberResponseBean {
    public boolean admin;
    public int dealStatus;
    public long gid;
    public String headPic;
    public long id;
    public String mobile;
    public String name;
    public String uid;
    public String username;

    public int getDealStatus() {
        return this.dealStatus;
    }

    public long getGid() {
        return this.gid;
    }

    public String getHeadPic() {
        return this.headPic;
    }

    public long getId() {
        return this.id;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getName() {
        return this.name;
    }

    public String getUid() {
        return this.uid;
    }

    public String getUsername() {
        return this.username;
    }

    public boolean isAdmin() {
        return this.admin;
    }

    public void setAdmin(boolean z) {
        this.admin = z;
    }

    public void setDealStatus(int i) {
        this.dealStatus = i;
    }

    public void setGid(long j) {
        this.gid = j;
    }

    public void setHeadPic(String str) {
        this.headPic = str;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setMobile(String str) {
        this.mobile = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }
}
