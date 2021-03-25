package com.tuya.smart.android.device.bean;

public class HardwareUpgradeBean {
    public UpgradeInfoBean dev;
    public UpgradeInfoBean gw;

    public UpgradeInfoBean getDev() {
        return this.dev;
    }

    public UpgradeInfoBean getGw() {
        return this.gw;
    }

    public void setDev(UpgradeInfoBean upgradeInfoBean) {
        this.dev = upgradeInfoBean;
    }

    public void setGw(UpgradeInfoBean upgradeInfoBean) {
        this.gw = upgradeInfoBean;
    }
}
