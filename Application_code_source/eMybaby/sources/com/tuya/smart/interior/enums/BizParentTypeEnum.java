package com.tuya.smart.interior.enums;

public enum BizParentTypeEnum {
    LOCATION(2),
    MESH(3),
    ROOM(4),
    GROUP(5),
    DEVICE(6);
    
    public int type;

    /* access modifiers changed from: public */
    BizParentTypeEnum(int i) {
        this.type = i;
    }

    public static BizParentTypeEnum to(int i) {
        for (BizParentTypeEnum bizParentTypeEnum : values()) {
            if (bizParentTypeEnum.type == i) {
                return bizParentTypeEnum;
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
