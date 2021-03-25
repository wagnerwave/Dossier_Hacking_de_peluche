package com.tuya.smart.android.network.api;

public class ApiEventBean {
    public String api;
    public String apiVersion;
    public String errorCode;
    public String errorMsg;
    public String requestTime;
    public String responseTime;
    public boolean success;
    public String useTime;

    public String getApi() {
        return this.api;
    }

    public String getApiVersion() {
        return this.apiVersion;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getRequestTime() {
        return this.requestTime;
    }

    public String getResponseTime() {
        return this.responseTime;
    }

    public String getUseTime() {
        return this.useTime;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setApi(String str) {
        this.api = str;
    }

    public void setApiVersion(String str) {
        this.apiVersion = str;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setRequestTime(String str) {
        this.requestTime = str;
    }

    public void setResponseTime(String str) {
        this.responseTime = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public void setUseTime(String str) {
        this.useTime = str;
    }
}
