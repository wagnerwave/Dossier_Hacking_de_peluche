package com.tuya.sdk.config.enums;

public enum WifiSecurityEnum {
    NOPASS(0),
    WEP(1),
    WPA(2),
    WPA2(3);
    
    public int type;

    /* access modifiers changed from: public */
    WifiSecurityEnum(int i) {
        this.type = i;
    }

    public static WifiSecurityEnum to(int i) {
        for (WifiSecurityEnum wifiSecurityEnum : values()) {
            if (wifiSecurityEnum.type == i) {
                return wifiSecurityEnum;
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
