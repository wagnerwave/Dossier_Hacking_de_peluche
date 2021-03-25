package com.tuya.sdk.home.bean;

import com.tuya.smart.home.sdk.bean.DeviceAndGroupInRoomBean;
import java.util.List;

public class RoomResponseBean {
    public String background;
    public int displayOrder;
    public long id;
    public List<DeviceAndGroupInRoomBean> ids;
    public String name;
    public boolean sel;

    public String getBackground() {
        return this.background;
    }

    public int getDisplayOrder() {
        return this.displayOrder;
    }

    public long getId() {
        return this.id;
    }

    public List<DeviceAndGroupInRoomBean> getIds() {
        return this.ids;
    }

    public String getName() {
        return this.name;
    }

    public boolean isSel() {
        return this.sel;
    }

    public void setBackground(String str) {
        this.background = str;
    }

    public void setDisplayOrder(int i) {
        this.displayOrder = i;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setIds(List<DeviceAndGroupInRoomBean> list) {
        this.ids = list;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSel(boolean z) {
        this.sel = z;
    }
}
