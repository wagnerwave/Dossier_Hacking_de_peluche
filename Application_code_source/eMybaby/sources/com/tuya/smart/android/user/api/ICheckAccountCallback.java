package com.tuya.smart.android.user.api;

public interface ICheckAccountCallback {
    void onError(String str, String str2);

    void onSuccess();
}
