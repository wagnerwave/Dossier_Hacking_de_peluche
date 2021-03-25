package com.tuya.sdk.device.enums;

public enum RomUpgradeTypeEnum {
    REMIND(0),
    FORCED(2),
    CHECK(3);
    
    public int mType;

    /* access modifiers changed from: public */
    RomUpgradeTypeEnum(int i) {
        this.mType = i;
    }

    public static RomUpgradeTypeEnum to(int i) {
        for (RomUpgradeTypeEnum romUpgradeTypeEnum : values()) {
            if (romUpgradeTypeEnum.mType == i) {
                return romUpgradeTypeEnum;
            }
        }
        return null;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
