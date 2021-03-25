package com.tuya.smart.android.blemesh.api;

public interface BusinessResultListener<T, F> {
    void onFailure(F f, T t, String str);

    void onSuccess(F f, T t, String str);
}
