package com.tuya.smart.sdk.api;

import com.tuya.smart.sdk.bean.DeviceBean;

public interface ITuyaSmartQRCodeActivatorListener {
    void onActiveSuccess(DeviceBean deviceBean);

    void onError(String str, String str2);
}
