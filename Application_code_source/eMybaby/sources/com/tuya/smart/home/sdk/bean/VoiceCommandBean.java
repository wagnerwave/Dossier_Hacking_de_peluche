package com.tuya.smart.home.sdk.bean;

public class VoiceCommandBean {
    public String dmText;
    public boolean keepSession;

    public String getDmText() {
        return this.dmText;
    }

    public boolean isKeepSession() {
        return this.keepSession;
    }

    public void setDmText(String str) {
        this.dmText = str;
    }

    public void setKeepSession(boolean z) {
        this.keepSession = z;
    }
}
