package com.tuya.smart.android.blemesh.builder;

import com.tuya.smart.android.blemesh.api.ITuyaBlueMeshSearchListener;
import java.util.UUID;

public class SearchBuilder {
    public String meshName;
    public UUID[] serviceUUIDs;
    public int timeOut = 100;
    public ITuyaBlueMeshSearchListener tuyaBlueMeshSearchListener;

    public SearchBuilder build() {
        return this;
    }

    public String getMeshName() {
        return this.meshName;
    }

    public UUID[] getServiceUUIDs() {
        return this.serviceUUIDs;
    }

    public int getTimeOut() {
        return this.timeOut;
    }

    public ITuyaBlueMeshSearchListener getTuyaBlueMeshSearchListener() {
        return this.tuyaBlueMeshSearchListener;
    }

    public SearchBuilder setMeshName(String str) {
        this.meshName = str;
        return this;
    }

    public SearchBuilder setServiceUUIDs(UUID[] uuidArr) {
        this.serviceUUIDs = uuidArr;
        return this;
    }

    public SearchBuilder setTimeOut(int i) {
        this.timeOut = i * 1000;
        return this;
    }

    public SearchBuilder setTuyaBlueMeshSearchListener(ITuyaBlueMeshSearchListener iTuyaBlueMeshSearchListener) {
        this.tuyaBlueMeshSearchListener = iTuyaBlueMeshSearchListener;
        return this;
    }
}
