package com.tuya.smart.sdk.bean;

public class BlueMeshGroupBean {
    public String category;
    public long id;
    public String localId;
    public String name;
    public long time;

    public String getCategory() {
        return this.category;
    }

    public long getId() {
        return this.id;
    }

    public String getLocalId() {
        return this.localId;
    }

    public String getName() {
        return this.name;
    }

    public long getTime() {
        return this.time;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setLocalId(String str) {
        this.localId = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setTime(long j) {
        this.time = j;
    }
}
