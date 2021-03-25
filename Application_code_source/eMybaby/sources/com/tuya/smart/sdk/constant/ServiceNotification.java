package com.tuya.smart.sdk.constant;

import android.app.Notification;
import com.tuya.smart.common.Oo0;
import com.tuya.smart.common.o0o00o00o0;

public class ServiceNotification {
    public static final int mGetNotificationId = 2018062716;
    public static final ServiceNotification mServiceNotication = new ServiceNotification();
    public Notification mNotification;

    public ServiceNotification() {
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        if (o0o00o00o0 != null) {
            this.mNotification = o0o00o00o0.O0000o0();
        }
    }

    public static ServiceNotification getInstance() {
        return mServiceNotication;
    }

    public Notification getNotification() {
        return this.mNotification;
    }

    public int getNotificationId() {
        return mGetNotificationId;
    }

    public void setNotification(Notification notification) {
        this.mNotification = notification;
    }
}
