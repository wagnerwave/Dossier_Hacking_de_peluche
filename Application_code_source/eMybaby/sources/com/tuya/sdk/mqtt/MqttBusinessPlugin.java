package com.tuya.sdk.mqtt;

import android.app.Application;
import com.tuya.smart.common.Oo0;
import com.tuya.smart.common.o0o00o0oo0;
import com.tuya.smart.common.o0o00oo0oo;
import com.tuya.smart.common.o0oo0o00o;

public class MqttBusinessPlugin extends Oo0.O000000o {
    public static final o0oo0o00o plugin = new o0oo0o00o();

    public void configure() {
        Oo0.O000000o.registerService(o0o00o0oo0.class, plugin);
    }

    public void dependency() {
        dependsOn(o0o00oo0oo.class);
    }

    public void execute() {
    }

    public void initApplication(Application application) {
    }
}
