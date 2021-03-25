package com.tuya.smart.android.sweeper.bean;

public class SweeperDataBean {
    public String devId;
    public String mapPath;
    public int mapType = -1;

    public String getDevId() {
        return this.devId;
    }

    public String getMapPath() {
        return this.mapPath;
    }

    public int getMapType() {
        return this.mapType;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setMapPath(String str) {
        this.mapPath = str;
    }

    public void setMapType(int i) {
        this.mapType = i;
    }
}
