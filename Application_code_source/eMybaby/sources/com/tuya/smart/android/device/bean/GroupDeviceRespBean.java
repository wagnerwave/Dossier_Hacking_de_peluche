package com.tuya.smart.android.device.bean;

import a.a.a.a.a;

public class GroupDeviceRespBean {
    public boolean checked;
    public String devId;
    public String devName;
    public Boolean devOnline;
    public String gwId;
    public String gwName;
    public Boolean gwOnline;
    public String iconUrl;
    public String productId;

    public String getDevId() {
        return this.devId;
    }

    public String getDevName() {
        return this.devName;
    }

    public String getGwId() {
        return this.gwId;
    }

    public String getGwName() {
        return this.gwName;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getProductId() {
        return this.productId;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public Boolean isDevOnline() {
        return this.devOnline;
    }

    public Boolean isGwOnline() {
        return this.gwOnline;
    }

    public void setChecked(boolean z) {
        this.checked = z;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setDevName(String str) {
        this.devName = str;
    }

    public void setDevOnline(Boolean bool) {
        this.devOnline = bool;
    }

    public void setGwId(String str) {
        this.gwId = str;
    }

    public void setGwName(String str) {
        this.gwName = str;
    }

    public void setGwOnline(Boolean bool) {
        this.gwOnline = bool;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public String toString() {
        StringBuilder n = a.n("GroupDeviceBean{gwId='");
        a.x(n, this.gwId, '\'', ", gwOnline=");
        n.append(this.gwOnline);
        n.append(", iconUrl='");
        a.x(n, this.iconUrl, '\'', ", gwName='");
        a.x(n, this.gwName, '\'', ", devName='");
        a.x(n, this.devName, '\'', ", devOnline=");
        n.append(this.devOnline);
        n.append(", devId='");
        a.x(n, this.devId, '\'', ", checked=");
        n.append(this.checked);
        n.append(", productId='");
        n.append(this.productId);
        n.append('\'');
        n.append('}');
        return n.toString();
    }
}
