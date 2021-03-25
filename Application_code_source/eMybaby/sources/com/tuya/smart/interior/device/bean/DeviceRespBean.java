package com.tuya.smart.interior.device.bean;

import com.tuya.smart.sdk.api.IStorageCache;
import java.util.Map;

public class DeviceRespBean implements IStorageCache {
    public long activeTime;
    public boolean decodeRawed;
    public long devAttribute;
    public String devId;
    public String devKey;
    public int displayOrder;
    public long dpMaxTime;
    public Map<String, String> dpName;
    public Map<String, Object> dps;
    public long errorCode;
    public int homeDisplayOrder;
    public String iconUrl;
    public boolean isShare;
    public String lat;
    public String localKey;
    public String lon;
    public String mac;
    public String meshId;
    public ModuleMap moduleMap;
    public String name;
    public String nodeId;
    public String productId;
    public long resptime;
    public String runtimeEnv;
    public Map<String, Object> skills;
    public String timezoneId;
    public String uuid;
    public boolean virtual;

    public static class DevModule {
        public String bv;
        public String cadv;
        public boolean isOnline;
        public String pv;
        public String verSw;

        public String getBv() {
            return this.bv;
        }

        public String getCadv() {
            return this.cadv;
        }

        public boolean getIsOnline() {
            return this.isOnline;
        }

        public String getPv() {
            return this.pv;
        }

        public String getVerSw() {
            return this.verSw;
        }

        public void setBv(String str) {
            this.bv = str;
        }

        public void setCadv(String str) {
            this.cadv = str;
        }

        public void setIsOnline(boolean z) {
            this.isOnline = z;
        }

        public void setPv(String str) {
            this.pv = str;
        }

        public void setVerSw(String str) {
            this.verSw = str;
        }
    }

    public static class ModuleMap {
        public DevModule bluetooth;
        public DevModule gprs;
        public DevModule infrared;
        public DevModule mcu;
        public DevModule subpieces;
        public DevModule wifi;
        public DevModule zigbee;

        public DevModule getBluetooth() {
            return this.bluetooth;
        }

        public DevModule getGprs() {
            return this.gprs;
        }

        public DevModule getInfrared() {
            return this.infrared;
        }

        public DevModule getMcu() {
            return this.mcu;
        }

        public DevModule getSubpieces() {
            return this.subpieces;
        }

        public DevModule getWifi() {
            return this.wifi;
        }

        public DevModule getZigbee() {
            return this.zigbee;
        }

        public void setBluetooth(DevModule devModule) {
            this.bluetooth = devModule;
        }

        public void setGprs(DevModule devModule) {
            this.gprs = devModule;
        }

        public void setInfrared(DevModule devModule) {
            this.infrared = devModule;
        }

        public void setMcu(DevModule devModule) {
            this.mcu = devModule;
        }

        public void setSubpieces(DevModule devModule) {
            this.subpieces = devModule;
        }

        public void setWifi(DevModule devModule) {
            this.wifi = devModule;
        }

        public void setZigbee(DevModule devModule) {
            this.zigbee = devModule;
        }
    }

    public long getActiveTime() {
        return this.activeTime;
    }

    public long getDevAttribute() {
        return this.devAttribute;
    }

    public String getDevId() {
        return this.devId;
    }

    public String getDevKey() {
        return this.devKey;
    }

    public int getDisplayOrder() {
        return this.displayOrder;
    }

    public long getDpMaxTime() {
        return this.dpMaxTime;
    }

    public Map<String, String> getDpName() {
        return this.dpName;
    }

    public Map<String, Object> getDps() {
        return this.dps;
    }

    public long getErrorCode() {
        return this.errorCode;
    }

    public int getHomeDisplayOrder() {
        return this.homeDisplayOrder;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public boolean getIsShare() {
        return this.isShare;
    }

    public Object getKey() {
        return this.devId;
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

    public String getMac() {
        return this.mac;
    }

    public String getMeshId() {
        return this.meshId;
    }

    public ModuleMap getModuleMap() {
        return this.moduleMap;
    }

    public String getName() {
        return this.name;
    }

    public String getNodeId() {
        return this.nodeId;
    }

    public String getProductId() {
        return this.productId;
    }

    public long getResptime() {
        return this.resptime;
    }

    public String getRuntimeEnv() {
        return this.runtimeEnv;
    }

    public Map<String, Object> getSkills() {
        return this.skills;
    }

    public String getTimezoneId() {
        return this.timezoneId;
    }

    public String getUuid() {
        return this.uuid;
    }

    public boolean isDecodeRawed() {
        return this.decodeRawed;
    }

    public boolean isVirtual() {
        return this.virtual;
    }

    public void setActiveTime(long j) {
        this.activeTime = j;
    }

    public void setDecodeRawed(boolean z) {
        this.decodeRawed = z;
    }

    public void setDevAttribute(long j) {
        this.devAttribute = j;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setDevKey(String str) {
        this.devKey = str;
    }

    public void setDisplayOrder(int i) {
        this.displayOrder = i;
    }

    public void setDpMaxTime(long j) {
        this.dpMaxTime = j;
    }

    public void setDpName(Map<String, String> map) {
        this.dpName = map;
    }

    public void setDps(Map<String, Object> map) {
        this.dps = map;
    }

    public void setErrorCode(long j) {
        this.errorCode = j;
    }

    public void setHomeDisplayOrder(int i) {
        this.homeDisplayOrder = i;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setIsShare(boolean z) {
        this.isShare = z;
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

    public void setMac(String str) {
        this.mac = str;
    }

    public void setMeshId(String str) {
        this.meshId = str;
    }

    public void setModuleMap(ModuleMap moduleMap2) {
        this.moduleMap = moduleMap2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNodeId(String str) {
        this.nodeId = str;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setResptime(long j) {
        this.resptime = j;
    }

    public void setRuntimeEnv(String str) {
        this.runtimeEnv = str;
    }

    public void setSkills(Map<String, Object> map) {
        this.skills = map;
    }

    public void setTimezoneId(String str) {
        this.timezoneId = str;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public void setVirtual(boolean z) {
        this.virtual = z;
    }
}
