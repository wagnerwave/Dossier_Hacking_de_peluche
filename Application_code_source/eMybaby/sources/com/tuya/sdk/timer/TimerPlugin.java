package com.tuya.sdk.timer;

import android.app.Application;
import com.tuya.smart.common.Oo0;
import com.tuya.smart.common.o00o00ooo0;
import com.tuya.smart.common.o0o00o00o0;
import com.tuya.smart.common.o0o00o00oo;
import com.tuya.smart.common.o0o00oo0o0;

public class TimerPlugin extends Oo0.O000000o {
    public static final o00o00ooo0 tuyaTimerPlugin = new o00o00ooo0();

    public void configure() {
        Oo0.O000000o.registerService(o0o00oo0o0.class, tuyaTimerPlugin);
    }

    public void dependency() {
        dependsOn(o0o00o00o0.class);
        dependsOn(o0o00o00oo.class);
    }

    public void execute() {
    }

    public void initApplication(Application application) {
    }
}
