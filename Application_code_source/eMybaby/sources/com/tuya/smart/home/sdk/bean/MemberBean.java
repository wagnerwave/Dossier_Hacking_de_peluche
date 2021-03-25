package com.tuya.smart.home.sdk.bean;

import com.tuya.smart.home.sdk.anntation.MemberStatus;

public class MemberBean {
    public String account;
    public boolean admin;
    public String headPic;
    public long homeId;
    public long memberId;
    @MemberStatus
    public int memberStatus;
    public String nickName;
    public String uid;

    public String getAccount() {
        return this.account;
    }

    public String getHeadPic() {
        return this.headPic;
    }

    public long getHomeId() {
        return this.homeId;
    }

    public long getMemberId() {
        return this.memberId;
    }

    @MemberStatus
    public int getMemberStatus() {
        return this.memberStatus;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getUid() {
        return this.uid;
    }

    public boolean isAdmin() {
        return this.admin;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setAdmin(boolean z) {
        this.admin = z;
    }

    public void setHeadPic(String str) {
        this.headPic = str;
    }

    public void setHomeId(long j) {
        this.homeId = j;
    }

    public void setMemberId(long j) {
        this.memberId = j;
    }

    public void setMemberStatus(@MemberStatus int i) {
        this.memberStatus = i;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }
}
