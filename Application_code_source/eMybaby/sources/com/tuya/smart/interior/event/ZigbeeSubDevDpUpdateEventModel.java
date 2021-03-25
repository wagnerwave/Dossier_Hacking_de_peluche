package com.tuya.smart.interior.event;

public class ZigbeeSubDevDpUpdateEventModel {
    public final String cid;
    public final String devId;
    public final String dps;
    public final boolean isFromCloud;
    public final String meshId;
    public final int type;

    public ZigbeeSubDevDpUpdateEventModel(String str, String str2, String str3, int i, String str4, boolean z) {
        this.meshId = str;
        this.cid = str2;
        this.type = i;
        this.dps = str4;
        this.devId = str3;
        this.isFromCloud = z;
    }

    public String getCid() {
        return this.cid;
    }

    public String getDevId() {
        return this.devId;
    }

    public String getDps() {
        return this.dps;
    }

    public String getMeshId() {
        return this.meshId;
    }

    public int getType() {
        return this.type;
    }

    public boolean isFromCloud() {
        return this.isFromCloud;
    }
}
