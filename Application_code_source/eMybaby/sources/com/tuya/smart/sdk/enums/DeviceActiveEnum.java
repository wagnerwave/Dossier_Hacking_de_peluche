package com.tuya.smart.sdk.enums;

public enum DeviceActiveEnum {
    UNACTIVE(0),
    ACTIVING(1),
    ACTIVED(2);
    
    public int type;

    /* access modifiers changed from: public */
    DeviceActiveEnum(int i) {
        this.type = i;
    }

    public static DeviceActiveEnum to(int i) {
        for (DeviceActiveEnum deviceActiveEnum : values()) {
            if (deviceActiveEnum.type == i) {
                return deviceActiveEnum;
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
