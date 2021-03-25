package com.tuya.smart.android.device.enums;

import android.text.TextUtils;

public enum ModeEnum {
    RW("rw"),
    WR("wr"),
    RO("ro");
    
    public String type;

    /* access modifiers changed from: public */
    ModeEnum(String str) {
        this.type = str;
    }

    public static ModeEnum to(String str) {
        if (str == null) {
            return null;
        }
        for (ModeEnum modeEnum : values()) {
            if (TextUtils.equals(str, modeEnum.type)) {
                return modeEnum;
            }
        }
        return null;
    }

    public String getType() {
        return this.type;
    }
}
