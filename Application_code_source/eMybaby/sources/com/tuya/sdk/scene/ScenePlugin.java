package com.tuya.sdk.scene;

import android.app.Application;
import com.tuya.smart.common.Oo0;
import com.tuya.smart.common.o0o00o00o0;
import com.tuya.smart.common.o0o00oo000;
import com.tuya.smart.common.oo00ooooo;

public class ScenePlugin extends Oo0.O000000o {
    public static final oo00ooooo tuyaScenePlugin = new oo00ooooo();

    public void configure() {
        Oo0.O000000o.registerService(o0o00oo000.class, tuyaScenePlugin);
    }

    public void dependency() {
        dependsOn(o0o00o00o0.class);
    }

    public void execute() {
    }

    public void initApplication(Application application) {
    }
}
