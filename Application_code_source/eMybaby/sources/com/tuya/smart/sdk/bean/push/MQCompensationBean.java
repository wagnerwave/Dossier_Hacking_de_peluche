package com.tuya.smart.sdk.bean.push;

public class MQCompensationBean {
    public String link;
    public long timeStamp;
    public String type;

    public MQCompensationBean() {
    }

    public MQCompensationBean(String str, String str2, long j) {
        this.type = str;
        this.link = str2;
        this.timeStamp = j;
    }

    public String getLink() {
        return this.link;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public String getType() {
        return this.type;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void setTimeStamp(long j) {
        this.timeStamp = j;
    }

    public void setType(String str) {
        this.type = str;
    }
}
