package com.tuya.sdk.timer.bean;

import com.alibaba.fastjson.JSONObject;
import java.util.Iterator;

public class DpTimerBean {
    public static final String FILL = "  ";
    public static final int STATUE_CLOSE = 0;
    public static final int STATUE_OPEN = 1;
    public String date;
    public JSONObject dps;
    public String loops;
    public int status;
    public String time;

    public String getDate() {
        return this.date;
    }

    public String getDpId() {
        Iterator<String> it = this.dps.keySet().iterator();
        String str = "";
        while (it.hasNext()) {
            str = it.next();
        }
        return str;
    }

    public JSONObject getDps() {
        return this.dps;
    }

    public String getLoops() {
        return this.loops;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTime() {
        return this.time;
    }

    public boolean isEnabled() {
        return this.status == 1;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setDps(JSONObject jSONObject) {
        this.dps = jSONObject;
    }

    public void setLoops(String str) {
        this.loops = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setTime(String str) {
        this.time = str;
    }
}
