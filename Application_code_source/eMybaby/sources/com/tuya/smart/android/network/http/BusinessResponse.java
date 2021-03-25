package com.tuya.smart.android.network.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import java.lang.reflect.Type;

public class BusinessResponse {
    public static final String KEY_APINAME = "api";
    public static final String KEY_ERRCODE = "errorCode";
    public static final String KEY_ERRMSG = "errorMsg";
    public static final String KEY_EXPIRES = "expires";
    public static final String KEY_LIST = "list";
    public static final String KEY_RESULT = "result";
    public static final String KEY_STATUS = "status";
    public static final String KEY_SUCCESS = "success";
    public static final String KEY_VERSION = "v";
    public static final String RESULT_EXCEPTION = "EXCEPTION";
    public static final String RESULT_HTTP_ERROR = "HTTP_ERROR";
    public static final String RESULT_SESSION_INVALID = "USER_SESSION_INVALID";
    public static final String RESULT_SESSION_LOSS = "USER_SESSION_LOSS";
    public static final String RESULT_SUCCESS = "SUCCESS";
    public static final String RESULT_THROW_CACHE = "THROW_CACHE";
    public static final String RESULT_TIMEOUT = "TIMEOUT";
    public static final String RESULT_TIME_ERROR = "TIME_ERROR";
    public static final String RESULT_TIME_INVALID = "TIME_VALIDATE_FAILED";
    public static final String RESULT_UNKNOWN = "UNKNOWN";
    public String api;
    public String errorCode;
    public String errorMsg;
    public Long expires;
    public String result;
    public Boolean success = Boolean.FALSE;
    public long t;
    public long timestamp;
    public String v;

    public static BusinessResponse Builder(byte[] bArr) {
        return (BusinessResponse) JSON.parseObject(bArr, (Type) BusinessResponse.class, new Feature[0]);
    }

    public String getApi() {
        return this.api;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public Long getExpires() {
        return this.expires;
    }

    public String getResult() {
        return this.result;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public long getT() {
        return this.t;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getV() {
        return this.v;
    }

    public boolean isSuccess() {
        return this.success.booleanValue();
    }

    public void setApi(String str) {
        this.api = str;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setExpires(Long l) {
        this.expires = l;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public void setSuccess(Boolean bool) {
        this.success = bool;
    }

    public void setT(long j) {
        this.t = j;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public void setV(String str) {
        this.v = str;
    }

    public boolean shouldCache() {
        return this.expires != null;
    }
}
