package com.tuya.smart.sdk.bean;

import java.util.HashMap;
import java.util.List;

public class ShortCutBean {
    public List<String> displayDps;
    public HashMap<String, String> displayMsgs;
    public List<Integer> faultDps;
    public List<String> quickOpDps;
    public int switchDp;

    public List<String> getDisplayDps() {
        return this.displayDps;
    }

    public HashMap<String, String> getDisplayMsgs() {
        return this.displayMsgs;
    }

    public List<Integer> getFaultDps() {
        return this.faultDps;
    }

    public List<String> getQuickOpDps() {
        return this.quickOpDps;
    }

    public int getSwitchDp() {
        return this.switchDp;
    }

    public void setDisplayDps(List<String> list) {
        this.displayDps = list;
    }

    public void setDisplayMsgs(HashMap<String, String> hashMap) {
        this.displayMsgs = hashMap;
    }

    public void setFaultDps(List<Integer> list) {
        this.faultDps = list;
    }

    public void setQuickOpDps(List<String> list) {
        this.quickOpDps = list;
    }

    public void setSwitchDp(int i) {
        this.switchDp = i;
    }
}
