package com.tuya.smart.sdk.bean;

public class GroupShareBean {
    public String iconUrl;
    public long id;
    public String name;
    public boolean share;

    public String getIconUrl() {
        return this.iconUrl;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public boolean isShare() {
        return this.share;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setShare(boolean z) {
        this.share = z;
    }
}
