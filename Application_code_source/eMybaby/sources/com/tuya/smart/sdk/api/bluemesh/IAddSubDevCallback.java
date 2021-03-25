package com.tuya.smart.sdk.api.bluemesh;

import com.tuya.smart.sdk.bean.DeviceBean;

public interface IAddSubDevCallback {
    void onError(String str, String str2);

    void onSuccess(DeviceBean deviceBean);
}
