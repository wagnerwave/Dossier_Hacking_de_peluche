package com.tuya.smart.home.sdk.bean.scene.condition.property;

public class TimerProperty implements IProperty {
    public static final long serialVersionUID = -2896022744741701846L;
    public static final String type = "timer";
    public String data;
    public String loops;
    public String time;
    public String timezoneId;

    public static String getType() {
        return "timer";
    }

    public String getData() {
        return this.data;
    }

    public String getLoops() {
        return this.loops;
    }

    public String getTime() {
        return this.time;
    }

    public String getTimezoneId() {
        return this.timezoneId;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setLoops(String str) {
        this.loops = str;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public void setTimezoneId(String str) {
        this.timezoneId = str;
    }
}
