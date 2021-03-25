package com.tuya.smart.android.blemesh.bean;

public class BLEUpgradeInfoBean {
    public BLEUpgradeBean gw;
    public String versionHintMessage;

    public BLEUpgradeBean getGw() {
        return this.gw;
    }

    public int getUpgradeType() {
        if (getGw() != null) {
            return getGw().getUpgradeType();
        }
        return -1;
    }

    public String getVersionHintMessage() {
        return this.versionHintMessage;
    }

    public boolean isNeedUpgrade() {
        return getGw() != null && getGw().getUpgradeStatus() == 1;
    }

    public void setGw(BLEUpgradeBean bLEUpgradeBean) {
        this.gw = bLEUpgradeBean;
    }

    public void setVersionHintMessage(String str) {
        this.versionHintMessage = str;
    }
}
