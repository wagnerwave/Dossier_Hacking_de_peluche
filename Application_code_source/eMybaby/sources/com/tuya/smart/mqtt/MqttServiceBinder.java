package com.tuya.smart.mqtt;

import android.os.Binder;

public class MqttServiceBinder extends Binder {
    public String activityToken;
    public MqttService mqttService;

    public MqttServiceBinder(MqttService mqttService2) {
        this.mqttService = mqttService2;
    }

    public String getActivityToken() {
        return this.activityToken;
    }

    public MqttService getService() {
        return this.mqttService;
    }

    public void setActivityToken(String str) {
        this.activityToken = str;
    }
}
