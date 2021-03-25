package com.tuya.smart.home.sdk.bean;

import java.util.List;

public class SpeechGuideBean {
    public boolean hasDevice;
    public List<String> voiceList;

    public List<String> getVoiceList() {
        return this.voiceList;
    }

    public boolean isHasDevice() {
        return this.hasDevice;
    }

    public void setHasDevice(boolean z) {
        this.hasDevice = z;
    }

    public void setVoiceList(List<String> list) {
        this.voiceList = list;
    }
}
