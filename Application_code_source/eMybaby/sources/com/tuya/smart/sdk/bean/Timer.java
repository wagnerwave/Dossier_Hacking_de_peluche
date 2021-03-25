package com.tuya.smart.sdk.bean;

import a.a.a.a.a;

public class Timer {
    public static final int STATUE_OPEN = 1;
    public String mDate;
    public String mDpId;
    public String mLoops;
    public int mStatus;
    public String mTime;
    public String mTimerId;
    public String mValue;

    public String getDate() {
        return this.mDate;
    }

    public String getDpId() {
        return this.mDpId;
    }

    public String getLoops() {
        return this.mLoops;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getTime() {
        return this.mTime;
    }

    public String getTimerId() {
        return this.mTimerId;
    }

    public String getValue() {
        return this.mValue;
    }

    public boolean isOpen() {
        return this.mStatus == 1;
    }

    public void setDate(String str) {
        this.mDate = str;
    }

    public void setDpId(String str) {
        this.mDpId = str;
    }

    public void setLoops(String str) {
        this.mLoops = str;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }

    public void setTime(String str) {
        this.mTime = str;
    }

    public void setTimerId(String str) {
        this.mTimerId = str;
    }

    public void setValue(String str) {
        this.mValue = str;
    }

    public String toString() {
        StringBuilder n = a.n("Timer{mTimerId='");
        a.x(n, this.mTimerId, '\'', ", mDate='");
        a.x(n, this.mDate, '\'', ", mDpId='");
        a.x(n, this.mDpId, '\'', ", mLoops='");
        a.x(n, this.mLoops, '\'', ", mStatus=");
        n.append(this.mStatus);
        n.append(", mTime='");
        n.append(this.mTime);
        n.append('\'');
        n.append('}');
        return n.toString();
    }
}
