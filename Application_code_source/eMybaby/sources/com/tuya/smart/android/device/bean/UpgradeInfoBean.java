package com.tuya.smart.android.device.bean;

import java.io.Serializable;

public class UpgradeInfoBean implements Serializable {
    public static final int UPGRADE_STATUS_DEFAULT = 0;
    public static final int UPGRADE_STATUS_READY = 1;
    public static final int UPGRADE_STATUS_UPGRADING = 2;
    public static final int UPGRADE_TYPE_CHECKING = 3;
    public static final int UPGRADE_TYPE_FORCED = 2;
    public static final int UPGRADE_TYPE_REMIND = 0;
    public String currentVersion;
    public String desc;
    public long firmwareDeployTime;
    public long lastUpgradeTime;
    public int timeout;
    public int type;
    public String typeDesc;
    public int upgradeStatus;
    public int upgradeType;
    public String version;

    public String getCurrentVersion() {
        return this.currentVersion;
    }

    public String getDesc() {
        return this.desc;
    }

    public long getFirmwareDeployTime() {
        return this.firmwareDeployTime;
    }

    public long getLastUpgradeTime() {
        return this.lastUpgradeTime;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public int getType() {
        return this.type;
    }

    public String getTypeDesc() {
        return this.typeDesc;
    }

    public int getUpgradeStatus() {
        return this.upgradeStatus;
    }

    public int getUpgradeType() {
        return this.upgradeType;
    }

    public String getVersion() {
        return this.version;
    }

    public void setCurrentVersion(String str) {
        this.currentVersion = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setFirmwareDeployTime(long j) {
        this.firmwareDeployTime = j;
    }

    public void setLastUpgradeTime(long j) {
        this.lastUpgradeTime = j;
    }

    public void setTimeout(int i) {
        this.timeout = i;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setTypeDesc(String str) {
        this.typeDesc = str;
    }

    public void setUpgradeStatus(int i) {
        this.upgradeStatus = i;
    }

    public void setUpgradeType(int i) {
        this.upgradeType = i;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
