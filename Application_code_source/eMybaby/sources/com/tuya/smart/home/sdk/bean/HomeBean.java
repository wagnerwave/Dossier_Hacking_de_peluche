package com.tuya.smart.home.sdk.bean;

import com.tuya.smart.sdk.bean.BlueMeshBean;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.GroupBean;
import com.tuya.smart.sdk.bean.SigMeshBean;
import java.util.ArrayList;
import java.util.List;

public class HomeBean {
    public boolean admin;
    public String background;
    public List<DeviceBean> deviceList = new ArrayList();
    public String geoName;
    public List<GroupBean> groupList = new ArrayList();
    public long homeId;
    public int homeStatus;
    public String inviteName;
    public double lat;
    public double lon;
    public List<BlueMeshBean> meshList = new ArrayList();
    public String name;
    public List<RoomBean> rooms = new ArrayList();
    public List<DeviceBean> sharedDeviceList = new ArrayList();
    public List<GroupBean> sharedGroupList = new ArrayList();
    public List<SigMeshBean> sigMeshList = new ArrayList();

    public String getBackground() {
        return this.background;
    }

    public List<DeviceBean> getDeviceList() {
        return this.deviceList;
    }

    public String getGeoName() {
        return this.geoName;
    }

    public List<GroupBean> getGroupList() {
        return this.groupList;
    }

    public long getHomeId() {
        return this.homeId;
    }

    public int getHomeStatus() {
        return this.homeStatus;
    }

    public String getInviteName() {
        return this.inviteName;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLon() {
        return this.lon;
    }

    public List<BlueMeshBean> getMeshList() {
        return this.meshList;
    }

    public String getName() {
        return this.name;
    }

    public List<RoomBean> getRooms() {
        return this.rooms;
    }

    public List<DeviceBean> getSharedDeviceList() {
        return this.sharedDeviceList;
    }

    public List<GroupBean> getSharedGroupList() {
        return this.sharedGroupList;
    }

    public List<SigMeshBean> getSigMeshList() {
        return this.sigMeshList;
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

    public void setDeviceList(List<DeviceBean> list) {
        this.deviceList = list;
    }

    public void setGeoName(String str) {
        this.geoName = str;
    }

    public void setGroupList(List<GroupBean> list) {
        this.groupList = list;
    }

    public void setHomeId(long j) {
        this.homeId = j;
    }

    public void setHomeStatus(int i) {
        this.homeStatus = i;
    }

    public void setInviteName(String str) {
        this.inviteName = str;
    }

    public void setLat(double d2) {
        this.lat = d2;
    }

    public void setLon(double d2) {
        this.lon = d2;
    }

    public void setMeshList(List<BlueMeshBean> list) {
        this.meshList = list;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRooms(List<RoomBean> list) {
        this.rooms = list;
    }

    public void setSharedDeviceList(List<DeviceBean> list) {
        this.sharedDeviceList = list;
    }

    public void setSharedGroupList(List<GroupBean> list) {
        this.sharedGroupList = list;
    }

    public void setSigMeshList(List<SigMeshBean> list) {
        this.sigMeshList = list;
    }
}
