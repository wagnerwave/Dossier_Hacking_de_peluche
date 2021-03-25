package com.tuya.smart.sdk.api.bluemesh;

import com.tuya.smart.sdk.bean.DeviceBean;

public interface IBlueMeshActivatorListener {
    void onFailure(String str, String str2);

    void onStep(String str, Object obj);

    void onSuccess(DeviceBean deviceBean);
}
