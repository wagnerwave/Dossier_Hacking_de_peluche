package com.tuya.smart.android.device.api;

public interface IPropertyCallback<T> {
    void onError(String str, String str2);

    void onSuccess(T t);
}
