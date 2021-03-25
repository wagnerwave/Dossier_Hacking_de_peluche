package com.tuya.smart.sdk.api;

public interface IOtaListener {
    void onFailure(int i, String str, String str2);

    void onProgress(int i, int i2);

    void onSuccess(int i);
}
