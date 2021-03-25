package com.tuya.sdk.config.bean;

public class GwBindResultBean {
    public String errorCode;
    public String errorMsg;
    public String gwId;

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getGwId() {
        return this.gwId;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setGwId(String str) {
        this.gwId = str;
    }
}
