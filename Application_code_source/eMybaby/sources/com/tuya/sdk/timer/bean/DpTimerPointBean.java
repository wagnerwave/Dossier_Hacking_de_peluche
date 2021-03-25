package com.tuya.sdk.timer.bean;

import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class DpTimerPointBean {
    public JSONObject dps;
    public String time;

    public DpTimerPointBean(String str) {
        this.time = str;
    }

    public DpTimerPointBean(String str, String str2, boolean z) {
        this.time = str;
        HashMap hashMap = new HashMap();
        hashMap.put(str2, Boolean.valueOf(z));
        this.dps = new JSONObject((Map<String, Object>) hashMap);
    }

    public DpTimerPointBean(String str, Map<String, Object> map) {
        this.time = str;
        this.dps = new JSONObject(map);
    }

    public JSONObject getDps() {
        return this.dps;
    }

    public String getTime() {
        return this.time;
    }

    public void setDps(JSONObject jSONObject) {
        this.dps = jSONObject;
    }

    public void setTime(String str) {
        this.time = str;
    }
}
