package com.tuya.smart.home.sdk.bean;

public class MemberWrapperBean {
    public String account;
    public boolean admin;
    public String countryCode;
    public String headPic;
    public long homeId;
    public long memberId;
    public String nickName;
    public String uid;

    public static final class Builder {
        public String account;
        public boolean admin;
        public String countryCode;
        public String headPic;
        public long homeId;
        public long memberId;
        public String nickName;
        public String uid;

        public MemberWrapperBean build() {
            return new MemberWrapperBean(this);
        }

        public Builder setAccount(String str) {
            this.account = str;
            return this;
        }

        public Builder setAdmin(boolean z) {
            this.admin = z;
            return this;
        }

        public Builder setCountryCode(String str) {
            this.countryCode = str;
            return this;
        }

        public Builder setHeadPic(String str) {
            this.headPic = str;
            return this;
        }

        public Builder setHomeId(long j) {
            this.homeId = j;
            return this;
        }

        public Builder setMemberId(long j) {
            this.memberId = j;
            return this;
        }

        public Builder setNickName(String str) {
            this.nickName = str;
            return this;
        }

        public Builder setUid(String str) {
            this.uid = str;
            return this;
        }
    }

    public MemberWrapperBean(Builder builder) {
        this.homeId = builder.homeId;
        this.nickName = builder.nickName;
        this.admin = builder.admin;
        this.memberId = builder.memberId;
        this.headPic = builder.headPic;
        this.account = builder.account;
        this.uid = builder.uid;
        this.countryCode = builder.countryCode;
    }

    public String getAccount() {
        return this.account;
    }

    public String getCountryCode() {
        return this.countryCode;
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

    public String getNickName() {
        return this.nickName;
    }

    public String getUid() {
        return this.uid;
    }

    public boolean isAdmin() {
        return this.admin;
    }
}
