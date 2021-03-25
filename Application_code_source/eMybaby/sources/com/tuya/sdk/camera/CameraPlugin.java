package com.tuya.sdk.camera;

import android.app.Application;
import com.tuya.smart.common.OO0O0O;
import com.tuya.smart.common.Oo0;
import com.tuya.smart.common.o0o00o0000;
import com.tuya.smart.common.o0o00o00o0;

public class CameraPlugin extends Oo0.O000000o {
    public static final OO0O0O tuyaCameraPlugin = new OO0O0O();

    public void configure() {
        Oo0.O000000o.registerService(o0o00o0000.class, tuyaCameraPlugin);
    }

    public void dependency() {
        dependsOn(o0o00o00o0.class);
    }

    public void execute() {
    }

    public void initApplication(Application application) {
    }
}
