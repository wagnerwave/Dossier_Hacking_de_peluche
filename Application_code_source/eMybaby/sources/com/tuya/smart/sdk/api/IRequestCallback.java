package com.tuya.smart.sdk.api;

public interface IRequestCallback {
    void onFailure(String str, String str2);

    void onSuccess(Object obj);
}
