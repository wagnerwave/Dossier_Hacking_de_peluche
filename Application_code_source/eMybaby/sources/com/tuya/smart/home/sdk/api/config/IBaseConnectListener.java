package com.tuya.smart.home.sdk.api.config;

import com.tuya.smart.sdk.bean.DeviceBean;

public interface IBaseConnectListener {
    void onActiveError(String str, String str2);

    void onActiveSuccess(DeviceBean deviceBean);
}
