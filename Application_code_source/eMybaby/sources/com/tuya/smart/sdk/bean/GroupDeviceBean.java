package com.tuya.smart.sdk.bean;

public class GroupDeviceBean {
    public boolean checked;
    public DeviceBean deviceBean;
    public String productId;

    public DeviceBean getDeviceBean() {
        return this.deviceBean;
    }

    public String getProductId() {
        return this.productId;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void setChecked(boolean z) {
        this.checked = z;
    }

    public void setDeviceBean(DeviceBean deviceBean2) {
        this.deviceBean = deviceBean2;
    }

    public void setProductId(String str) {
        this.productId = str;
    }
}
