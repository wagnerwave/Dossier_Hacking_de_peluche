package com.tuya.smart.mqtt;

import android.app.Notification;
import com.tuya.smart.sdk.constant.ServiceNotification;

public class MqttServiceNotification {
    public static final MqttServiceNotification mServiceNotication = new MqttServiceNotification();
    public int mGetNotificationId = ServiceNotification.mGetNotificationId;
    public Notification mNotification;

    public static MqttServiceNotification getInstance() {
        return mServiceNotication;
    }

    public Notification getNotification() {
        return this.mNotification;
    }

    public int getNotificationId() {
        return this.mGetNotificationId;
    }

    public void setNotification(int i, Notification notification) {
        this.mNotification = notification;
        this.mGetNotificationId = i;
    }
}
