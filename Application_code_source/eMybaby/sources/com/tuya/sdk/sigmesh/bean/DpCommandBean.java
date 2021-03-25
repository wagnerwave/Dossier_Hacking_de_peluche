package com.tuya.sdk.sigmesh.bean;

import a.a.a.a.a;

public class DpCommandBean {
    public String dpId;
    public String dpType;
    public Object dpValue;

    public String getDpId() {
        return this.dpId;
    }

    public String getDpType() {
        return this.dpType;
    }

    public Object getDpValue() {
        return this.dpValue;
    }

    public void setDpId(String str) {
        this.dpId = str;
    }

    public void setDpType(String str) {
        this.dpType = str;
    }

    public void setDpValue(Object obj) {
        this.dpValue = obj;
    }

    public String toString() {
        StringBuilder n = a.n("DpCommandBean{dpType='");
        a.x(n, this.dpType, '\'', ", dpId='");
        a.x(n, this.dpId, '\'', ", dpValue=");
        n.append(this.dpValue);
        n.append('}');
        return n.toString();
    }
}
