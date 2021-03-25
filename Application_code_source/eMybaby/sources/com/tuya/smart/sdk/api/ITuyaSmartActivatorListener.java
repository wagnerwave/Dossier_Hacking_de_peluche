package com.tuya.smart.sdk.api;

import com.tuya.smart.sdk.bean.DeviceBean;

public interface ITuyaSmartActivatorListener {
    void onActiveSuccess(DeviceBean deviceBean);

    void onError(String str, String str2);

    void onStep(String str, Object obj);
}
