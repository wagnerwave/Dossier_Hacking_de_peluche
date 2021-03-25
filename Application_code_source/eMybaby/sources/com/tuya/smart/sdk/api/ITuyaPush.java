package com.tuya.smart.sdk.api;

import com.tuya.smart.home.sdk.callback.ITuyaResultCallback;
import com.tuya.smart.sdk.bean.push.MQCompensationBean;
import com.tuya.smart.sdk.bean.push.PushStatusBean;
import com.tuya.smart.sdk.bean.push.PushType;

public interface ITuyaPush {
    void getPushStatus(ITuyaResultCallback<PushStatusBean> iTuyaResultCallback);

    void getPushStatusByType(PushType pushType, ITuyaDataCallback<Boolean> iTuyaDataCallback);

    void onDestroy();

    void registerDevice(String str, String str2, IResultCallback iResultCallback);

    void registerMQPushListener(ITuyaGetBeanCallback<MQCompensationBean> iTuyaGetBeanCallback);

    void setPushStatus(boolean z, ITuyaDataCallback<Boolean> iTuyaDataCallback);

    void setPushStatusByType(PushType pushType, boolean z, ITuyaDataCallback<Boolean> iTuyaDataCallback);
}
