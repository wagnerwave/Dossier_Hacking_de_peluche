package com.tuya.smart.sdk.api;

public interface IResultStatusCallback {
    void onError(String str, String str2);

    void onSuccess();
}
