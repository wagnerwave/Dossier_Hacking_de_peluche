package com.tuya.smart.sdk.bean;

import java.util.List;
import java.util.Map;

public class GroupBean {
    public static final int TYPE_BLE_MESH = 1;
    public static final int TYPE_WIFI = 0;
    public String category;
    public List<String> devIds;
    public List<DeviceBean> deviceBeans;
    public int deviceNum;
    public int displayOrder;
    public Map<String, String> dpName;
    public Map<String, Object> dps;
    public int homeDisplayOrder;
    public String iconUrl;
    public long id;
    public boolean isShare;
    public String localId;
    public String localKey;
    public String meshId;
    public String name;
    public String productId;
    public String pv;
    public long time;
    public int type;

    public String getCategory() {
        return this.category;
    }

    public List<String> getDevIds() {
        return this.devIds;
    }

    public List<DeviceBean> getDeviceBeans() {
        return this.deviceBeans;
    }

    public int getDeviceNum() {
        return this.deviceNum;
    }

    public int getDisplayOrder() {
        return this.displayOrder;
    }

    public Map<String, String> getDpName() {
        return this.dpName;
    }

    public Map<String, Object> getDps() {
        return this.dps;
    }

    public int getHomeDisplayOrder() {
        return this.homeDisplayOrder;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public long getId() {
        return this.id;
    }

    public boolean getIsOnline() {
        return false;
    }

    public String getLocalId() {
        return this.localId;
    }

    public String getLocalKey() {
        return this.localKey;
    }

    public String getMeshId() {
        return this.meshId;
    }

    public String getName() {
        return this.name;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getPv() {
        return this.pv;
    }

    public long getTime() {
        return this.time;
    }

    public int getType() {
        return this.type;
    }

    public boolean isShare() {
        return this.isShare;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setDevIds(List<String> list) {
        this.devIds = list;
    }

    public void setDeviceBeans(List<DeviceBean> list) {
        this.deviceBeans = list;
    }

    public void setDeviceNum(int i) {
        this.deviceNum = i;
    }

    public void setDisplayOrder(int i) {
        this.displayOrder = i;
    }

    public void setDpName(Map<String, String> map) {
        this.dpName = map;
    }

    public void setDps(Map<String, Object> map) {
        this.dps = map;
    }

    public void setHomeDisplayOrder(int i) {
        this.homeDisplayOrder = i;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setIsShare(boolean z) {
        this.isShare = z;
    }

    public void setLocalId(String str) {
        this.localId = str;
    }

    public void setLocalKey(String str) {
        this.localKey = str;
    }

    public void setMeshId(String str) {
        this.meshId = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setPv(String str) {
        this.pv = str;
    }

    public void setShare(boolean z) {
        this.isShare = z;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public void setType(int i) {
        this.type = i;
    }
}
