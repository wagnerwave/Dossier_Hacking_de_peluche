package com.tuya.sdk.personal.bean;

public class DevShareBean {
    public String homeName;
    public String iconUrl;
    public String id;
    public String name;
    public String room;
    public boolean share;
    public boolean tempShare;

    public String getHomeName() {
        return this.homeName;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getRoom() {
        return this.room;
    }

    public boolean isShare() {
        return this.share;
    }

    public boolean isTempShare() {
        return this.tempShare;
    }

    public void setHomeName(String str) {
        this.homeName = str;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRoom(String str) {
        this.room = str;
    }

    public void setShare(boolean z) {
        this.share = z;
    }

    public void setTempShare(boolean z) {
        this.tempShare = z;
    }
}
