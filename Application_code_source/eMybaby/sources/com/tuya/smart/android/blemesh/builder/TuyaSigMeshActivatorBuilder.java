package com.tuya.smart.android.blemesh.builder;

import com.tuya.smart.android.blemesh.api.ITuyaBlueMeshActivatorListener;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.sdk.bean.SigMeshBean;
import java.util.List;

public class TuyaSigMeshActivatorBuilder {
    public long homeId;
    public ITuyaBlueMeshActivatorListener iTuyaBlueMeshActivator;
    public List<SearchDeviceBean> mSearchDeviceBeans;
    public SigMeshBean sigMeshBean;
    public int timeOut = 100;

    public long getHomeId() {
        return this.homeId;
    }

    public List<SearchDeviceBean> getSearchDeviceBeans() {
        return this.mSearchDeviceBeans;
    }

    public SigMeshBean getSigMeshBean() {
        return this.sigMeshBean;
    }

    public int getTimeOut() {
        return this.timeOut;
    }

    public ITuyaBlueMeshActivatorListener getTuyaBlueMeshActivatorListener() {
        return this.iTuyaBlueMeshActivator;
    }

    public TuyaSigMeshActivatorBuilder setHomeId(long j) {
        this.homeId = j;
        return this;
    }

    public TuyaSigMeshActivatorBuilder setSearchDeviceBeans(List<SearchDeviceBean> list) {
        this.mSearchDeviceBeans = list;
        return this;
    }

    public TuyaSigMeshActivatorBuilder setSigMeshBean(SigMeshBean sigMeshBean2) {
        this.sigMeshBean = sigMeshBean2;
        return this;
    }

    public TuyaSigMeshActivatorBuilder setTimeOut(int i) {
        this.timeOut = i;
        return this;
    }

    public TuyaSigMeshActivatorBuilder setTuyaBlueMeshActivatorListener(ITuyaBlueMeshActivatorListener iTuyaBlueMeshActivatorListener) {
        this.iTuyaBlueMeshActivator = iTuyaBlueMeshActivatorListener;
        return this;
    }
}
