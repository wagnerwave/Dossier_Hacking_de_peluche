package com.tuya.smart.android.mqtt;

import com.tuya.smart.sdk.api.IResultCallback;
import java.util.HashMap;

public interface ITuyaMqttChannel {
    void registerMqttRetainChannelListener(ITuyaMqttRetainChannelListener iTuyaMqttRetainChannelListener);

    void sendDeviceMqttMessage(String str, HashMap<String, Object> hashMap, int i, IResultCallback iResultCallback);

    void unRegisterMqttRetainChannelListener(ITuyaMqttRetainChannelListener iTuyaMqttRetainChannelListener);
}
