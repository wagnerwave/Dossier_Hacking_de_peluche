package com.tuya.smart.android.config.bean;

public class ConfigErrorRespBean {
    public static final String DEVICE_ALREADY_BIND = "DEVICE_ALREADY_BIND";
    public String errorCode;
    public String errorMsg;
    public String icon;
    public String iconUrl;
    public String id;
    public String name;

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setName(String str) {
        this.name = str;
    }
}
