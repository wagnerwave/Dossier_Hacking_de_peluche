package com.tuya.smart.interior.device.bean;

import java.util.Map;

public class BlueMeshBatchReportBean {
    public String cid;
    public Map<String, Object> dps;

    public String getCid() {
        return this.cid;
    }

    public Map<String, Object> getDps() {
        return this.dps;
    }

    public void setCid(String str) {
        this.cid = str;
    }

    public void setDps(Map<String, Object> map) {
        this.dps = map;
    }
}
