package com.tuya.smart.android.network.business;

import com.tuya.smart.android.network.http.BusinessResponse;

public class BusinessResult<T> {
    public String apiName;
    public BusinessResponse bizResponse;
    public T bizResult;

    public String getApiName() {
        return this.apiName;
    }

    public BusinessResponse getBizResponse() {
        return this.bizResponse;
    }

    public T getBizResult() {
        return this.bizResult;
    }

    public void setApiName(String str) {
        this.apiName = str;
    }

    public void setBizResponse(BusinessResponse businessResponse) {
        this.bizResponse = businessResponse;
    }

    public void setBizResult(T t) {
        this.bizResult = t;
    }
}
