package com.tuya.smart.sdk.enums;

public enum TempUnitEnum {
    Celsius(1),
    Fahrenheit(2);
    
    public int type;

    /* access modifiers changed from: public */
    TempUnitEnum(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }
}
