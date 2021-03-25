package com.tuya.sdk.device.enums;

public enum RomUpdateEnum {
    READY(1),
    UPDATING(2),
    UPDATED(3),
    ERROR(4),
    TIMEOUT(5);
    
    public int type;

    /* access modifiers changed from: public */
    RomUpdateEnum(int i) {
        this.type = i;
    }

    public static RomUpdateEnum to(int i) {
        for (RomUpdateEnum romUpdateEnum : values()) {
            if (romUpdateEnum.type == i) {
                return romUpdateEnum;
            }
        }
        return null;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
