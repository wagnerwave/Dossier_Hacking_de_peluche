package com.tuya.sdk.config;

import android.app.Application;
import com.tuya.smart.common.OO0O0o0;
import com.tuya.smart.common.Oo0;
import com.tuya.smart.common.o0o00o000o;

public class ActivatorPlugin extends Oo0.O000000o {
    public static final OO0O0o0 plugin = new OO0O0o0();

    public void configure() {
        Oo0.O000000o.registerService(o0o00o000o.class, plugin);
    }

    public void dependency() {
    }

    public void execute() {
    }

    public void initApplication(Application application) {
    }
}
