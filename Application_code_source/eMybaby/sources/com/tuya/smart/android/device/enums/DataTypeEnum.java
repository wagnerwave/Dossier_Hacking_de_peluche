package com.tuya.smart.android.device.enums;

import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;

public enum DataTypeEnum {
    OBJ(IconCompat.EXTRA_OBJ),
    RAW("raw"),
    FILE("file");
    
    public String type;

    /* access modifiers changed from: public */
    DataTypeEnum(String str) {
        this.type = str;
    }

    public static DataTypeEnum to(String str) {
        if (str == null) {
            return null;
        }
        for (DataTypeEnum dataTypeEnum : values()) {
            if (TextUtils.equals(str, dataTypeEnum.type)) {
                return dataTypeEnum;
            }
        }
        return null;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }
}
