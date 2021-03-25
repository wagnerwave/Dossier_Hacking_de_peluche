package com.tuya.smart.android.mvp.bean;

public class Result {
    public String error;
    public String errorCode;
    public Object obj;
    public boolean success;

    public Result() {
        this.success = true;
    }

    public Result(Object obj2) {
        this.success = true;
        this.obj = obj2;
    }

    public Result(String str, String str2) {
        this.success = false;
        this.errorCode = str;
        this.error = str2;
    }

    public Result(boolean z, String str, String str2) {
        this.success = z;
        this.errorCode = str;
        this.error = str2;
    }

    public String getError() {
        return this.error;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public Object getObj() {
        return this.obj;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setError(String str) {
        this.error = str;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setObj(Object obj2) {
        this.obj = obj2;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
