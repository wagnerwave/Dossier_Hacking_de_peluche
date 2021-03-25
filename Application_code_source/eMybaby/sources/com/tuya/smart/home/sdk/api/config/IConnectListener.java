package com.tuya.smart.home.sdk.api.config;

import com.tuya.smart.sdk.bean.DeviceBean;

public interface IConnectListener {
    void onActiveError(String str, String str2);

    void onActiveSuccess(DeviceBean deviceBean);

    void onConfigEnd();

    void onConfigStart();

    void onDeviceBindSuccess(DeviceBean deviceBean);

    void onDeviceFind(String str);

    void onWifiError(String str);
}
