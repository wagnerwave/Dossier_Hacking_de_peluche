package com.tuya.smart.home.sdk.bean;

import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.GroupBean;
import java.util.List;

public class RoomBean {
    public String background;
    public List<DeviceBean> deviceList;
    public int displayOrder;
    public List<GroupBean> groupList;
    public String name;
    public long roomId;
    public boolean sel;

    public String getBackground() {
        return this.background;
    }

    public List<DeviceBean> getDeviceList() {
        return this.deviceList;
    }

    public int getDisplayOrder() {
        return this.displayOrder;
    }

    public List<GroupBean> getGroupList() {
        return this.groupList;
    }

    public String getName() {
        return this.name;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public boolean isSel() {
        return this.sel;
    }

    public void setBackground(String str) {
        this.background = str;
    }

    public void setDeviceList(List<DeviceBean> list) {
        this.deviceList = list;
    }

    public void setDisplayOrder(int i) {
        this.displayOrder = i;
    }

    public void setGroupList(List<GroupBean> list) {
        this.groupList = list;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    public void setSel(boolean z) {
        this.sel = z;
    }
}
