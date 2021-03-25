package com.tuya.smart.interior.enums;

public enum ActiveEnum {
    UNACTIVE(0),
    ACTIVING(1),
    ACTIVED(2);
    
    public int type;

    /* access modifiers changed from: public */
    ActiveEnum(int i) {
        this.type = i;
    }

    public static ActiveEnum to(int i) {
        for (ActiveEnum activeEnum : values()) {
            if (activeEnum.type == i) {
                return activeEnum;
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
