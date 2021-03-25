package com.tuya.smart.home.sdk.callback;

public interface ITuyaResultCallback<T> {
    void onError(String str, String str2);

    void onSuccess(T t);
}
