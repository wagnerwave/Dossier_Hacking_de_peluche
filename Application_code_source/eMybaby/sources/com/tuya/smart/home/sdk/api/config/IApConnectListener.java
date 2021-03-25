package com.tuya.smart.home.sdk.api.config;

import com.tuya.smart.sdk.bean.DeviceBean;

public interface IApConnectListener {
    void onActiveCommandError(int i);

    void onActiveCommandSuccess();

    void onActiveError(String str, String str2);

    void onActiveSuccess(DeviceBean deviceBean);

    void onConfigError(int i);

    void onConfigSuccess();

    void onDeviceBindSuccess(DeviceBean deviceBean);

    void onDeviceConnect(String str);

    void onDeviceDisconnect(String str);
}
