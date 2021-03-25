package com.tuya.smart.android.device.enums;

import android.text.TextUtils;
import com.roomorama.caldroid.CaldroidFragment;

public enum DataPointTypeEnum {
    DAY("day"),
    WEEK("week"),
    MONTH(CaldroidFragment.MONTH);
    
    public String type;

    /* access modifiers changed from: public */
    DataPointTypeEnum(String str) {
        this.type = str;
    }

    public static DataPointTypeEnum to(String str) {
        if (str == null) {
            return null;
        }
        for (DataPointTypeEnum dataPointTypeEnum : values()) {
            if (TextUtils.equals(str, dataPointTypeEnum.type)) {
                return dataPointTypeEnum;
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
