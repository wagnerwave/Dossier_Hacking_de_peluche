package com.tuya.smart.home.sdk.bean.scene;

import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.GroupBean;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class SceneTaskGroupDevice implements Serializable {
    public List<DeviceBean> devices;
    public Map<String, Map> exts;
    public List<GroupBean> goups;

    public List<DeviceBean> getDevices() {
        return this.devices;
    }

    public Map<String, Map> getExts() {
        return this.exts;
    }

    public List<GroupBean> getGoups() {
        return this.goups;
    }

    public void setDevices(List<DeviceBean> list) {
        this.devices = list;
    }

    public void setExts(Map<String, Map> map) {
        this.exts = map;
    }

    public void setGoups(List<GroupBean> list) {
        this.goups = list;
    }
}
