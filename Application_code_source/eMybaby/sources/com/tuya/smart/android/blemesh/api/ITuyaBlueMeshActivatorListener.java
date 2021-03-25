package com.tuya.smart.android.blemesh.api;

import com.tuya.smart.sdk.bean.DeviceBean;

public interface ITuyaBlueMeshActivatorListener {
    void onError(String str, String str2, String str3);

    void onFinish();

    void onSuccess(String str, DeviceBean deviceBean);
}
