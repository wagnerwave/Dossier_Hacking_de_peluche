package com.tuya.smart.sdk.bean;

import java.util.List;

public class ShareIdBean {
    public List<String> devIds;
    public List<String> meshIds;

    public List<String> getDevIds() {
        return this.devIds;
    }

    public List<String> getMeshIds() {
        return this.meshIds;
    }

    public void setDevIds(List<String> list) {
        this.devIds = list;
    }

    public void setMeshIds(List<String> list) {
        this.meshIds = list;
    }
}
