package com.tuya.smart.android.mqtt;

public interface ITuyaMqttRetainChannelListener {
    void onMessageReceived(MqttMessageBean mqttMessageBean);
}
