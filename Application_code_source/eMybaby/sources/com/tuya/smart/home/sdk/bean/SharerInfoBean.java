package com.tuya.smart.home.sdk.bean;

import a.a.a.a.a;

public class SharerInfoBean {
    public String email;
    public String headPic;
    public String mobile;
    public String name;
    public int regFrom;

    public String getEmail() {
        return this.email;
    }

    public String getHeadPic() {
        return this.headPic;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getName() {
        return this.name;
    }

    public int getRegFrom() {
        return this.regFrom;
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

    public void setName(String str) {
        this.name = str;
    }

    public void setRegFrom(int i) {
        this.regFrom = i;
    }

    public String toString() {
        StringBuilder n = a.n("SharerInfoBean{email='");
        a.x(n, this.email, '\'', ", headPic='");
        a.x(n, this.headPic, '\'', ", mobile='");
        a.x(n, this.mobile, '\'', ", name='");
        a.x(n, this.name, '\'', ", regFrom=");
        n.append(this.regFrom);
        n.append('}');
        return n.toString();
    }
}
