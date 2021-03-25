package com.tuya.sdk.hardware;

import android.app.Application;
import com.tuya.smart.common.Oo0;
import com.tuya.smart.common.o0000ooo0;
import com.tuya.smart.common.o000oo000;
import com.tuya.smart.common.o0o00o0o00;
import com.tuya.smart.sdk.constant.ServiceNotification;

public class HardwareBusinessPlugin extends Oo0.O000000o {
    public static final o0000ooo0 mPlugin = new o0000ooo0();

    public void configure() {
        Oo0.O000000o.registerService(o0o00o0o00.class, mPlugin);
    }

    public void dependency() {
    }

    public void execute() {
    }

    public void initApplication(Application application) {
        o000oo000.O000000o().O000000o(ServiceNotification.getInstance().getNotificationId(), ServiceNotification.getInstance().getNotification());
    }
}
