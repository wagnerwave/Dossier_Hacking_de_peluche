package com.tuya.smart.android.common.utils;

import com.tuya.smart.common.o0ooo00oo;
import org.json.JSONException;
import org.json.JSONObject;

public class LogBean {
    public final Object data;
    public final long t = System.currentTimeMillis();
    public final String type;

    public LogBean(String str, Object obj) {
        this.type = str;
        this.data = obj;
    }

    public String formatLog() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.type);
            jSONObject.put("data", this.data);
            jSONObject.put(o0ooo00oo.O00000oo, this.t);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public Object getData() {
        return this.data;
    }

    public long getT() {
        return this.t;
    }

    public String getType() {
        return this.type;
    }
}
