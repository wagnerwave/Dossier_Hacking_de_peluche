package com.tuya.smart.home.sdk.bean;

import java.util.List;

public class ShareSentUserDetailBean {
    public boolean autoSharing;
    public List<DeviceShareBean> devices;
    public String mobile;
    public String nameWithoutRemark;
    public String remarkName;

    public List<DeviceShareBean> getDevices() {
        return this.devices;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getNameWithoutRemark() {
        return this.nameWithoutRemark;
    }

    public String getRemarkName() {
        return this.remarkName;
    }

    public boolean isAutoSharing() {
        return this.autoSharing;
    }

    public void setAutoSharing(boolean z) {
        this.autoSharing = z;
    }

    public void setDevices(List<DeviceShareBean> list) {
        this.devices = list;
    }

    public void setMobile(String str) {
        this.mobile = str;
    }

    public void setNameWithoutRemark(String str) {
        this.nameWithoutRemark = str;
    }

    public void setRemarkName(String str) {
        this.remarkName = str;
    }
}
