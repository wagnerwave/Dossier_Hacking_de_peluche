package com.tuya.smart.android.camera.api;

import com.tuya.smart.android.camera.api.bean.CameraPushDataBean;
import com.tuya.smart.sdk.api.ITuyaGetBeanCallback;

public interface ITuyaHomeCamera {
    void publish(String str, String str2, String str3, Object obj, int i);

    void publishWirelessWake(String str, byte[] bArr);

    void registerCamera308Listener(ITuyaGetBeanCallback<String> iTuyaGetBeanCallback);

    void registerCameraP2P302Listener(ITuyaGetBeanCallback<String> iTuyaGetBeanCallback);

    void registerCameraPushListener(ITuyaGetBeanCallback<CameraPushDataBean> iTuyaGetBeanCallback);

    void unRegisterCamera308Listener(ITuyaGetBeanCallback<String> iTuyaGetBeanCallback);

    void unRegisterCameraP2P302Listener(ITuyaGetBeanCallback<String> iTuyaGetBeanCallback);

    void unRegisterCameraPushListener(ITuyaGetBeanCallback<CameraPushDataBean> iTuyaGetBeanCallback);
}
