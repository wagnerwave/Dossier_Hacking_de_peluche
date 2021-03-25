package com.tuya.sdk.personal;

import android.app.Application;
import com.tuya.smart.common.Oo0;
import com.tuya.smart.common.o0o00o00o0;
import com.tuya.smart.common.o0o00o0ooo;
import com.tuya.smart.common.oo00o00oo;

public class PersonalPlugin extends Oo0.O000000o {
    public static final oo00o00oo tuyaPersonalPlugin = new oo00o00oo();

    public void configure() {
        Oo0.O000000o.registerService(o0o00o0ooo.class, tuyaPersonalPlugin);
    }

    public void dependency() {
        dependsOn(o0o00o00o0.class);
    }

    public void execute() {
    }

    public void initApplication(Application application) {
    }
}
