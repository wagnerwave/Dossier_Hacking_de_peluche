package com.tuya.smart.sdk.bean.push;

public enum PushType {
    PUSH_ALARM(0),
    PUSH_FAMILY(1),
    PUSH_NOTIFY(2);
    
    public int value;

    /* access modifiers changed from: public */
    PushType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public PushType parseInt(int i) {
        for (PushType pushType : values()) {
            if (pushType.value == i) {
                return pushType;
            }
        }
        return null;
    }
}
