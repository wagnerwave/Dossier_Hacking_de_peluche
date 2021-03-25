package com.tuya.smart.sdk.bean.message;

public enum MessageType {
    MSG_REPORT(1),
    MSG_FAMILY(2),
    MSG_NOTIFY(3);
    
    public int value;

    /* access modifiers changed from: public */
    MessageType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public MessageType parseInt(int i) {
        for (MessageType messageType : values()) {
            if (messageType.value == i) {
                return messageType;
            }
        }
        return null;
    }
}
