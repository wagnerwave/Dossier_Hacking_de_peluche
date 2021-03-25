package com.tuya.sdk.config.enums;

public enum GwModeEnum {
    AP(1),
    EC(0);
    
    public int type;

    /* access modifiers changed from: public */
    GwModeEnum(int i) {
        this.type = i;
    }

    public static GwModeEnum to(int i) {
        for (GwModeEnum gwModeEnum : values()) {
            if (i == gwModeEnum.type) {
                return gwModeEnum;
            }
        }
        return null;
    }

    public int getType() {
        return this.type;
    }
}
