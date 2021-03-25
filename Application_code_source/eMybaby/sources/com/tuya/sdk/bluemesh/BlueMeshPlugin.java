package com.tuya.sdk.bluemesh;

import android.app.Application;
import com.tuya.smart.common.O00000Oo;
import com.tuya.smart.common.Oo0;
import com.tuya.smart.common.o0o000oooo;
import com.tuya.smart.common.o0o00o00o0;
import com.tuya.smart.common.o0o00o0o0o;
import com.tuya.smart.common.o0o00o0oo0;

public class BlueMeshPlugin extends Oo0.O000000o {
    public static final O00000Oo tuyaBlueMeshPlugin = new O00000Oo();

    public void configure() {
        Oo0.O000000o.registerService(o0o000oooo.class, tuyaBlueMeshPlugin);
    }

    public void dependency() {
        dependsOn(o0o00o0oo0.class);
        dependsOn(o0o00o0o0o.class);
        dependsOn(o0o00o00o0.class);
    }

    public void execute() {
    }

    public void initApplication(Application application) {
    }
}
