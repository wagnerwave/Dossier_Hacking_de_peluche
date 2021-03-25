package com.tuya.smart.sdk.api;

public interface ITuyaDataCallback<T> {
    void onError(String str, String str2);

    void onSuccess(T t);
}
