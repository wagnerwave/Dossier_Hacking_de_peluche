package com.tuya.smart.home.sdk.constant;

import com.tuya.smart.common.oOO0O0O0;

public enum TimerTypeEnum {
    DEVICE(1),
    MESH(2),
    DEVICE_GROUP(3),
    MESH_GROUP(4);
    
    public String timeType;

    /* access modifiers changed from: public */
    TimerTypeEnum(int i) {
        String str;
        if (i == 1) {
            str = oOO0O0O0.O0000oOO;
        } else if (i == 2) {
            str = "mesh";
        } else if (i == 3) {
            str = "device_group";
        } else if (i == 4) {
            str = "mesh_group";
        } else {
            return;
        }
        this.timeType = str;
    }
}
