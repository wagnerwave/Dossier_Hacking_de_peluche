package com.tuya.sdk.device;

import android.app.Application;
import com.tuya.smart.common.Oo0;
import com.tuya.smart.common.o000000;
import com.tuya.smart.common.o0000000;
import com.tuya.smart.common.o0o000oooo;
import com.tuya.smart.common.o0o00o00o0;
import com.tuya.smart.common.o0o00o00oo;
import com.tuya.smart.common.o0o00o0o00;
import com.tuya.smart.common.o0o00o0o0o;
import com.tuya.smart.common.o0o00o0oo0;
import com.tuya.smart.common.o0o00oo0oo;

public class DevicePlugin extends Oo0.O000000o {
    public static final o0000000 mDevicePlugin = new o0000000();
    public static final o000000 mGroupPlugin = new o000000();

    public void configure() {
        Oo0.O000000o.registerService(o0o00o00o0.class, mDevicePlugin);
        Oo0.O000000o.registerService(o0o00o00oo.class, mGroupPlugin);
    }

    public void dependency() {
        dependsOn(o0o00oo0oo.class);
        dependsOn(o0o00o0oo0.class);
        dependsOn(o0o000oooo.class);
        dependsOn(o0o00o0o00.class);
        dependsOn(o0o00o0o0o.class);
    }

    public void execute() {
    }

    public void initApplication(Application application) {
    }
}
