package com.tuya.sdk.device.enums;

public enum RomDevTypeEnum {
    GW(1),
    DEV(2);
    
    public int type;

    /* access modifiers changed from: public */
    RomDevTypeEnum(int i) {
        this.type = i;
    }

    public static RomDevTypeEnum to(int i) {
        for (RomDevTypeEnum romDevTypeEnum : values()) {
            if (romDevTypeEnum.type == i) {
                return romDevTypeEnum;
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
