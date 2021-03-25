package com.tuya.smart.android.sweeper.bean;

public class SweeperHistoryBean {
    public String bucket;
    public String extend;
    public String file;
    public int id;
    public long time;

    public String getBucket() {
        return this.bucket;
    }

    public String getExtend() {
        return this.extend;
    }

    public String getFile() {
        return this.file;
    }

    public int getId() {
        return this.id;
    }

    public long getTime() {
        return this.time;
    }

    public void setBucket(String str) {
        this.bucket = str;
    }

    public void setExtend(String str) {
        this.extend = str;
    }

    public void setFile(String str) {
        this.file = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setTime(long j) {
        this.time = j;
    }
}
