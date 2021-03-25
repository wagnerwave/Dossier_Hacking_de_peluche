package com.tuya.smart.android.mqtt;

import com.alibaba.fastjson.JSONObject;

public class MqttMessageBean {
    public JSONObject data;
    public String dataId;
    public int protocol;

    public MqttMessageBean() {
    }

    public MqttMessageBean(int i, String str, JSONObject jSONObject) {
        this.protocol = i;
        this.dataId = str;
        this.data = jSONObject;
    }

    public JSONObject getData() {
        return this.data;
    }

    public String getDataId() {
        return this.dataId;
    }

    public int getProtocol() {
        return this.protocol;
    }

    public void setData(JSONObject jSONObject) {
        this.data = jSONObject;
    }

    public void setDataId(String str) {
        this.dataId = str;
    }

    public void setProtocol(int i) {
        this.protocol = i;
    }
}
