package com.tuya.sdk.home;

import android.app.Application;
import com.tuya.smart.common.Oo0;
import com.tuya.smart.common.o0o0000o0;
import com.tuya.smart.common.o0o000oooo;
import com.tuya.smart.common.o0o00o00o0;
import com.tuya.smart.common.o0o00o00oo;
import com.tuya.smart.common.o0o00o0o0o;
import com.tuya.smart.common.o0o00o0oo0;
import com.tuya.smart.common.o0o00o0ooo;
import com.tuya.smart.common.o0o00oo0oo;

public class HomePlugin extends Oo0.O000000o {
    public static final o0o0000o0 tuyaHomePlugin = new o0o0000o0();

    public void configure() {
        Oo0.O000000o.registerService(o0o00o0o0o.class, tuyaHomePlugin);
    }

    public void dependency() {
        dependsOn(o0o00oo0oo.class);
        dependsOn(o0o00o00o0.class);
        dependsOn(o0o00o00oo.class);
        dependsOn(o0o00o0oo0.class);
        dependsOn(o0o000oooo.class);
        dependsOn(o0o00o0ooo.class);
    }

    public void execute() {
    }

    public void initApplication(Application application) {
    }
}
