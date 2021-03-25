package com.tuya.smart.home.sdk.callback;

import com.tuya.smart.sdk.api.ITuyaGetBeanCallback;
import com.tuya.smart.sdk.bean.SpeechTTSBean;

public interface ITuyaVoiceTransfer {
    void onConnect();

    void onDestroy();

    void subscribeServer(ITuyaGetBeanCallback<SpeechTTSBean> iTuyaGetBeanCallback);

    void unSubscribeServer(ITuyaGetBeanCallback<SpeechTTSBean> iTuyaGetBeanCallback);
}
