package com.tuya.smart.home.sdk.bean.scene;

import java.io.Serializable;
import java.util.Map;

public class ConditionExtraInfoBean implements Serializable {
    public static final String CAL_TYPE_DURATION = "duration";
    public String calType;
    public String cityName;
    public String delayTime;
    public long maxSeconds;
    public String members;
    public Map<String, String> percent;
    public Map<String, String> percent1;
    public String tempUnit;
    public long timeWindow;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ConditionExtraInfoBean.class != obj.getClass()) {
            return false;
        }
        ConditionExtraInfoBean conditionExtraInfoBean = (ConditionExtraInfoBean) obj;
        if (this.timeWindow != conditionExtraInfoBean.timeWindow || this.maxSeconds != conditionExtraInfoBean.maxSeconds) {
            return false;
        }
        String str = this.tempUnit;
        if (str == null ? conditionExtraInfoBean.tempUnit != null : !str.equals(conditionExtraInfoBean.tempUnit)) {
            return false;
        }
        String str2 = this.cityName;
        if (str2 == null ? conditionExtraInfoBean.cityName != null : !str2.equals(conditionExtraInfoBean.cityName)) {
            return false;
        }
        String str3 = this.delayTime;
        if (str3 == null ? conditionExtraInfoBean.delayTime != null : !str3.equals(conditionExtraInfoBean.delayTime)) {
            return false;
        }
        Map<String, String> map = this.percent;
        if (map == null ? conditionExtraInfoBean.percent != null : !map.equals(conditionExtraInfoBean.percent)) {
            return false;
        }
        Map<String, String> map2 = this.percent1;
        if (map2 == null ? conditionExtraInfoBean.percent1 != null : !map2.equals(conditionExtraInfoBean.percent1)) {
            return false;
        }
        String str4 = this.members;
        if (str4 == null ? conditionExtraInfoBean.members != null : !str4.equals(conditionExtraInfoBean.members)) {
            return false;
        }
        String str5 = this.calType;
        String str6 = conditionExtraInfoBean.calType;
        return str5 != null ? str5.equals(str6) : str6 == null;
    }

    public String getCalType() {
        return this.calType;
    }

    public String getCityName() {
        return this.cityName;
    }

    public String getDelayTime() {
        return this.delayTime;
    }

    public long getMaxSeconds() {
        return this.maxSeconds;
    }

    public String getMembers() {
        return this.members;
    }

    public Map<String, String> getPercent() {
        return this.percent;
    }

    public Map<String, String> getPercent1() {
        return this.percent1;
    }

    public String getTempUnit() {
        return this.tempUnit;
    }

    public long getTimeWindow() {
        return this.timeWindow;
    }

    public int hashCode() {
        String str = this.tempUnit;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.cityName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.delayTime;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Map<String, String> map = this.percent;
        int hashCode4 = (hashCode3 + (map != null ? map.hashCode() : 0)) * 31;
        Map<String, String> map2 = this.percent1;
        int hashCode5 = (hashCode4 + (map2 != null ? map2.hashCode() : 0)) * 31;
        String str4 = this.members;
        int hashCode6 = str4 != null ? str4.hashCode() : 0;
        long j = this.timeWindow;
        int i2 = (((hashCode5 + hashCode6) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        String str5 = this.calType;
        if (str5 != null) {
            i = str5.hashCode();
        }
        long j2 = this.maxSeconds;
        return ((i2 + i) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public void setCalType(String str) {
        this.calType = str;
    }

    public void setCityName(String str) {
        this.cityName = str;
    }

    public void setDelayTime(String str) {
        this.delayTime = str;
    }

    public void setMaxSeconds(long j) {
        this.maxSeconds = j;
    }

    public void setMembers(String str) {
        this.members = str;
    }

    public void setPercent(Map<String, String> map) {
        this.percent = map;
    }

    public void setPercent1(Map<String, String> map) {
        this.percent1 = map;
    }

    public void setTempUnit(String str) {
        this.tempUnit = str;
    }

    public void setTimeWindow(long j) {
        this.timeWindow = j;
    }
}
