package com.tuya.sdk.home.bean;

import java.util.List;

public class HomeResponseBean {
    public boolean admin;
    public String background;
    public int dealStatus;
    public String geoName;
    public long gid;
    public long id;
    public double lat;
    public double lon;
    public String name;
    public String nickName;
    public List<RoomResponseBean> rooms;

    public String getBackground() {
        return this.background;
    }

    public int getDealStatus() {
        return this.dealStatus;
    }

    public String getGeoName() {
        return this.geoName;
    }

    public long getGid() {
        return this.gid;
    }

    @Deprecated
    public long getId() {
        return this.id;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLon() {
        return this.lon;
    }

    public String getName() {
        return this.name;
    }

    public String getNickName() {
        return this.nickName;
    }

    public List<RoomResponseBean> getRooms() {
        return this.rooms;
    }

    public boolean isAdmin() {
        return this.admin;
    }

    public void setAdmin(boolean z) {
        this.admin = z;
    }

    public void setBackground(String str) {
        this.background = str;
    }

    public void setDealStatus(int i) {
        this.dealStatus = i;
    }

    public void setGeoName(String str) {
        this.geoName = str;
    }

    public void setGid(long j) {
        this.gid = j;
    }

    @Deprecated
    public void setId(long j) {
        this.id = j;
    }

    public void setLat(double d2) {
        this.lat = d2;
    }

    public void setLon(double d2) {
        this.lon = d2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setRooms(List<RoomResponseBean> list) {
        this.rooms = list;
    }
}
