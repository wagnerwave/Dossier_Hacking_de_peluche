package com.tuya.sdk.timer.bean;

import java.util.ArrayList;

public class GroupTimerBean {
    public String id;
    public ArrayList<DpTimerBean> timers;

    public String getId() {
        return this.id;
    }

    public ArrayList<DpTimerBean> getTimers() {
        return this.timers;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setTimers(ArrayList<DpTimerBean> arrayList) {
        this.timers = arrayList;
    }
}
