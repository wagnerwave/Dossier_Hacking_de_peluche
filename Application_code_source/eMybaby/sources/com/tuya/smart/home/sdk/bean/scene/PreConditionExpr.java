package com.tuya.smart.home.sdk.bean.scene;

import java.io.Serializable;

public class PreConditionExpr implements Serializable {
    public String cityId;
    public String cityName;
    public String end;
    public String loops;
    public String start;
    public String timeInterval;
    public String timeZoneId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PreConditionExpr.class != obj.getClass()) {
            return false;
        }
        PreConditionExpr preConditionExpr = (PreConditionExpr) obj;
        String str = this.loops;
        if (str == null ? preConditionExpr.loops != null : !str.equals(preConditionExpr.loops)) {
            return false;
        }
        String str2 = this.start;
        if (str2 == null ? preConditionExpr.start != null : !str2.equals(preConditionExpr.start)) {
            return false;
        }
        String str3 = this.end;
        if (str3 == null ? preConditionExpr.end != null : !str3.equals(preConditionExpr.end)) {
            return false;
        }
        String str4 = this.timeInterval;
        if (str4 == null ? preConditionExpr.timeInterval != null : !str4.equals(preConditionExpr.timeInterval)) {
            return false;
        }
        String str5 = this.cityId;
        if (str5 == null ? preConditionExpr.cityId != null : !str5.equals(preConditionExpr.cityId)) {
            return false;
        }
        String str6 = this.timeZoneId;
        if (str6 == null ? preConditionExpr.timeZoneId != null : !str6.equals(preConditionExpr.timeZoneId)) {
            return false;
        }
        String str7 = this.cityName;
        String str8 = preConditionExpr.cityName;
        return str7 != null ? str7.equals(str8) : str8 == null;
    }

    public String getCityId() {
        return this.cityId;
    }

    public String getCityName() {
        return this.cityName;
    }

    public String getEnd() {
        return this.end;
    }

    public String getLoops() {
        return this.loops;
    }

    public String getStart() {
        return this.start;
    }

    public String getTimeInterval() {
        return this.timeInterval;
    }

    public String getTimeZoneId() {
        return this.timeZoneId;
    }

    public int hashCode() {
        String str = this.loops;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.start;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.end;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.timeInterval;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.cityId;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.timeZoneId;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.cityName;
        if (str7 != null) {
            i = str7.hashCode();
        }
        return hashCode6 + i;
    }

    public void setCityId(String str) {
        this.cityId = str;
    }

    public void setCityName(String str) {
        this.cityName = str;
    }

    public void setEnd(String str) {
        this.end = str;
    }

    public void setLoops(String str) {
        this.loops = str;
    }

    public void setStart(String str) {
        this.start = str;
    }

    public void setTimeInterval(String str) {
        this.timeInterval = str;
    }

    public void setTimeZoneId(String str) {
        this.timeZoneId = str;
    }
}
