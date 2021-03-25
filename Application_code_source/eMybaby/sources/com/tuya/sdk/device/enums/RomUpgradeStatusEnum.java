package com.tuya.sdk.device.enums;

public enum RomUpgradeStatusEnum {
    NO_NEW_VERSION(0),
    NEW_VERSION(1),
    UPGRADING(2);
    
    public int status;

    /* access modifiers changed from: public */
    RomUpgradeStatusEnum(int i) {
        this.status = i;
    }

    public static RomUpgradeStatusEnum to(int i) {
        for (RomUpgradeStatusEnum romUpgradeStatusEnum : values()) {
            if (romUpgradeStatusEnum.status == i) {
                return romUpgradeStatusEnum;
            }
        }
        return null;
    }

    public int getType() {
        return this.status;
    }

    public void setType(int i) {
        this.status = i;
    }
}
