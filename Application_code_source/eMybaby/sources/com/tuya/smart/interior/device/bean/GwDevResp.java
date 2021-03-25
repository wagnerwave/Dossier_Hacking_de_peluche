package com.tuya.smart.interior.device.bean;

import java.util.List;

@Deprecated
public class GwDevResp {
    public int ability;
    public long activeTime;
    public String bv;
    public List<DevResp> devices;
    public String gwId;
    public String gwType;
    public String icon;
    public String iconUrl;
    public String id;
    public Boolean isActive;
    public Boolean isOnline;
    public Boolean isShare;
    public String lat;
    public String localKey;
    public String lon;
    public String meshId;
    public String name;
    public String ownerId;
    public String pv;
    public String runtimeEnv;
    public long time;
    public long updateCacheTime;
    public String uuid;
    public String verSw;

    public int getAbility() {
        return this.ability;
    }

    public long getActiveTime() {
        return this.activeTime;
    }

    public String getBv() {
        return this.bv;
    }

    public List<DevResp> getDevices() {
        return this.devices;
    }

    public String getGwId() {
        return this.gwId;
    }

    public String getGwType() {
        return this.gwType;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getId() {
        return this.id;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public Boolean getIsOnline() {
        return this.isOnline;
    }

    public Boolean getIsShare() {
        return this.isShare;
    }

    public String getLat() {
        return this.lat;
    }

    public String getLocalKey() {
        return this.localKey;
    }

    public String getLon() {
        return this.lon;
    }

    public String getMeshId() {
        return this.meshId;
    }

    public String getName() {
        return this.name;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public String getPv() {
        return this.pv;
    }

    public String getRuntimeEnv() {
        return this.runtimeEnv;
    }

    public long getTime() {
        return this.time;
    }

    public long getUpdateCacheTime() {
        return this.updateCacheTime;
    }

    public String getUuid() {
        return this.uuid;
    }

    public String getVerSw() {
        return this.verSw;
    }

    public void setAbility(int i) {
        this.ability = i;
    }

    public void setActiveTime(long j) {
        this.activeTime = j;
    }

    public void setBv(String str) {
        this.bv = str;
    }

    public void setDevices(List<DevResp> list) {
        this.devices = list;
    }

    public void setGwId(String str) {
        this.gwId = str;
    }

    public void setGwType(String str) {
        this.gwType = str;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setIsActive(Boolean bool) {
        this.isActive = bool;
    }

    public void setIsOnline(Boolean bool) {
        this.isOnline = bool;
    }

    public void setIsShare(Boolean bool) {
        this.isShare = bool;
    }

    public void setLat(String str) {
        this.lat = str;
    }

    public void setLocalKey(String str) {
        this.localKey = str;
    }

    public void setLon(String str) {
        this.lon = str;
    }

    public void setMeshId(String str) {
        this.meshId = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOwnerId(String str) {
        this.ownerId = str;
    }

    public void setPv(String str) {
        this.pv = str;
    }

    public void setRuntimeEnv(String str) {
        this.runtimeEnv = str;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public void setUpdateCacheTime(long j) {
        this.updateCacheTime = j;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public void setVerSw(String str) {
        this.verSw = str;
    }
}
