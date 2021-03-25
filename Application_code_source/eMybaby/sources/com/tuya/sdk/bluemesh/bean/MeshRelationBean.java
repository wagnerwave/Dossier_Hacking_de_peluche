package com.tuya.sdk.bluemesh.bean;

public class MeshRelationBean {
    public boolean isOnline;
    public String nodeId;

    public boolean getIsOnline() {
        return this.isOnline;
    }

    public String getNodeId() {
        return this.nodeId;
    }

    public void setIsOnline(boolean z) {
        this.isOnline = z;
    }

    public void setNodeId(String str) {
        this.nodeId = str;
    }
}
