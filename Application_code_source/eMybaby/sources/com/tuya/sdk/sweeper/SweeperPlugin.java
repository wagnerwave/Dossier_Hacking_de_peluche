package com.tuya.sdk.sweeper;

import android.app.Application;
import com.tuya.smart.common.Oo0;
import com.tuya.smart.common.o00o00o00o;
import com.tuya.smart.common.o0o00oo00o;

public class SweeperPlugin extends Oo0.O000000o {
    public static final o00o00o00o tuyaSweeperPlugin = new o00o00o00o();

    public void configure() {
        Oo0.O000000o.registerService(o0o00oo00o.class, tuyaSweeperPlugin);
    }

    public void dependency() {
        dependsOn(o0o00oo00o.class);
    }

    public void execute() {
    }

    public void initApplication(Application application) {
    }
}
