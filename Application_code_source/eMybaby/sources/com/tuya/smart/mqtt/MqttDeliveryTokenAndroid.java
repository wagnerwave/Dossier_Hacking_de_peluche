package com.tuya.smart.mqtt;

import e.b.a.a.a.c;
import e.b.a.a.a.e;
import e.b.a.a.a.o;

public class MqttDeliveryTokenAndroid extends MqttTokenAndroid implements e {
    public o message;

    public MqttDeliveryTokenAndroid(MqttAndroidClient mqttAndroidClient, Object obj, c cVar, o oVar) {
        super(mqttAndroidClient, obj, cVar);
        this.message = oVar;
    }

    public o getMessage() {
        return this.message;
    }

    public void notifyDelivery(o oVar) {
        this.message = oVar;
        super.notifyComplete();
    }

    public void setMessage(o oVar) {
        this.message = oVar;
    }
}
