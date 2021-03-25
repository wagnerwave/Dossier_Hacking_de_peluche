package com.tuya.smart.sdk.bean;

import java.util.List;
import java.util.Map;

public class ZigbeeGroupCreateResultBean {
    public Map<String, Integer> errorCode;
    public List<String> failure;
    public String gid;
    public String gwId;
    public int operateType;
    public List<Integer> results;
    public List<String> success;

    public Map<String, Integer> getErrorCode() {
        return this.errorCode;
    }

    public List<String> getFailure() {
        return this.failure;
    }

    public String getGid() {
        return this.gid;
    }

    public String getGwId() {
        return this.gwId;
    }

    public int getOperateType() {
        return this.operateType;
    }

    public List<Integer> getResults() {
        return this.results;
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

    public void setGid(String str) {
        this.gid = str;
    }

    public void setGwId(String str) {
        this.gwId = str;
    }

    public void setOperateType(int i) {
        this.operateType = i;
    }

    public void setResults(List<Integer> list) {
        this.results = list;
    }

    public void setSuccess(List<String> list) {
        this.success = list;
    }
}
