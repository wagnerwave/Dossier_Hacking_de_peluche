package com.tuya.smart.sdk.bean;

import a.a.a.a.a;

public class TimerTaskStatus {
    public boolean mIsOpen;
    public String mTimerName;

    public String getTimerName() {
        return this.mTimerName;
    }

    public boolean isOpen() {
        return this.mIsOpen;
    }

    public void setIsOpen(boolean z) {
        this.mIsOpen = z;
    }

    public void setTimerName(String str) {
        this.mTimerName = str;
    }

    public String toString() {
        StringBuilder n = a.n("TimerTaskStatus{mTimerName='");
        a.x(n, this.mTimerName, '\'', ", mIsOpen=");
        n.append(this.mIsOpen);
        n.append('}');
        return n.toString();
    }
}
