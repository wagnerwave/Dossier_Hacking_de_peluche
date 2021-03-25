package com.tuya.smart.home.sdk.bean.scene;

import java.io.Serializable;

public class PlaceFacadeBean implements Serializable {
    public static final long serialVersionUID = 1350187840951367579L;
    public String area;
    public boolean choose;
    public String city;
    public long cityId;
    public String pinyin;
    public String province;

    public String getArea() {
        return this.area;
    }

    public String getCity() {
        return this.city;
    }

    public long getCityId() {
        return this.cityId;
    }

    public String getPinyin() {
        return this.pinyin;
    }

    public String getProvince() {
        return this.province;
    }

    public boolean isChoose() {
        return this.choose;
    }

    public void setArea(String str) {
        this.area = str;
    }

    public void setChoose(boolean z) {
        this.choose = z;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCityId(long j) {
        this.cityId = j;
    }

    public void setPinyin(String str) {
        this.pinyin = str;
    }

    public void setProvince(String str) {
        this.province = str;
    }
}
