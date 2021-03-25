package com.tuya.smart.sdk.bean;

import a.a.a.a.a;
import java.util.ArrayList;

public class TimerTask {
    public ArrayList<Timer> mTimerList;
    public TimerTaskStatus mTimerTaskStatus;

    public ArrayList<Timer> getTimerList() {
        return this.mTimerList;
    }

    public TimerTaskStatus getTimerTaskStatus() {
        return this.mTimerTaskStatus;
    }

    public void setTimerList(ArrayList<Timer> arrayList) {
        this.mTimerList = arrayList;
    }

    public void setTimerTaskStatus(TimerTaskStatus timerTaskStatus) {
        this.mTimerTaskStatus = timerTaskStatus;
    }

    public String toString() {
        StringBuilder n = a.n("TimerTask{mTimerTaskStatus=");
        n.append(this.mTimerTaskStatus.toString());
        n.append(",\n mTimerList=");
        n.append('}');
        return n.toString();
    }
}
