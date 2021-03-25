package com.tuya.sdk.scene.bean;

import java.util.List;
import java.util.Map;

public class LocalSceneResultBean {
    public Map<String, Integer> errorCode;
    public List<String> failure;
    public List<String> success;

    public Map<String, Integer> getErrorCode() {
        return this.errorCode;
    }

    public List<String> getFailure() {
        return this.failure;
    }

    public List<String> getSuccess() {
        return this.success;
    }

    public void setErrorCode(Map<String, Integer> map) {
        this.errorCode = map;
    }

    public void setFailure(List<String> list) {
        this.failure = list;
    }

    public void setSuccess(List<String> list) {
        this.success = list;
    }
}
