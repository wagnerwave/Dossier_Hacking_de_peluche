package com.tuya.smart.android.blemesh.builder;

import com.tuya.smart.android.blemesh.api.ITuyaBlueMeshActivatorListener;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.common.o00oo0o000;
import com.tuya.smart.sdk.bean.BlueMeshBean;
import java.util.List;

public class TuyaBlueMeshActivatorBuilder {
    public BlueMeshBean blueMeshBean;
    public long homeId;
    public ITuyaBlueMeshActivatorListener iTuyaBlueMeshActivator;
    public List<SearchDeviceBean> mSearchDeviceBeans;
    public String meshId;
    public String meshName;
    public String meshOriginName = o00oo0o000.O000000o;
    public String meshOriginPassword = "123456";
    public String meshPassword;
    public String productKey;
    public int timeOut = 100;
    public String uuid;
    public String version;
    public String wifiPassword;
    public String wifiSsid;

    public BlueMeshBean getBlueMeshBean() {
        return this.blueMeshBean;
    }

    public long getHomeId() {
        return this.homeId;
    }

    public String getMeshId() {
        return this.meshId;
    }

    public String getMeshName() {
        return this.meshName;
    }

    public String getMeshOriginName() {
        return this.meshOriginName;
    }

    public String getMeshOriginPassword() {
        return this.meshOriginPassword;
    }

    public String getMeshPassword() {
        return this.meshPassword;
    }

    public String getProductKey() {
        return this.productKey;
    }

    public List<SearchDeviceBean> getSearchDeviceBeans() {
        return this.mSearchDeviceBeans;
    }

    public int getTimeOut() {
        return this.timeOut;
    }

    public ITuyaBlueMeshActivatorListener getTuyaBlueMeshActivatorListener() {
        return this.iTuyaBlueMeshActivator;
    }

    public String getUuid() {
        return this.uuid;
    }

    public String getVersion() {
        return this.version;
    }

    public String getWifiPassword() {
        return this.wifiPassword;
    }

    public String getWifiSsid() {
        return this.wifiSsid;
    }

    public TuyaBlueMeshActivatorBuilder setBlueMeshBean(BlueMeshBean blueMeshBean2) {
        this.blueMeshBean = blueMeshBean2;
        this.meshId = blueMeshBean2.getMeshId();
        this.meshPassword = blueMeshBean2.getPassword();
        this.meshName = blueMeshBean2.getCode();
        return this;
    }

    public TuyaBlueMeshActivatorBuilder setHomeId(long j) {
        this.homeId = j;
        return this;
    }

    public TuyaBlueMeshActivatorBuilder setMeshName(String str) {
        this.meshName = str;
        return this;
    }

    public TuyaBlueMeshActivatorBuilder setMeshOriginName(String str) {
        this.meshOriginName = str;
        return this;
    }

    public TuyaBlueMeshActivatorBuilder setMeshOriginPassword(String str) {
        this.meshOriginPassword = str;
        return this;
    }

    public TuyaBlueMeshActivatorBuilder setProductKey(String str) {
        this.productKey = str;
        return this;
    }

    public TuyaBlueMeshActivatorBuilder setSearchDeviceBeans(List<SearchDeviceBean> list) {
        this.mSearchDeviceBeans = list;
        return this;
    }

    public TuyaBlueMeshActivatorBuilder setTimeOut(int i) {
        this.timeOut = i;
        return this;
    }

    public TuyaBlueMeshActivatorBuilder setTuyaBlueMeshActivatorListener(ITuyaBlueMeshActivatorListener iTuyaBlueMeshActivatorListener) {
        this.iTuyaBlueMeshActivator = iTuyaBlueMeshActivatorListener;
        return this;
    }

    public TuyaBlueMeshActivatorBuilder setUuid(String str) {
        this.uuid = str;
        return this;
    }

    public TuyaBlueMeshActivatorBuilder setVersion(String str) {
        this.version = str;
        return this;
    }

    public TuyaBlueMeshActivatorBuilder setWifiPassword(String str) {
        this.wifiPassword = str;
        return this;
    }

    public TuyaBlueMeshActivatorBuilder setWifiSsid(String str) {
        this.wifiSsid = str;
        return this;
    }
}
