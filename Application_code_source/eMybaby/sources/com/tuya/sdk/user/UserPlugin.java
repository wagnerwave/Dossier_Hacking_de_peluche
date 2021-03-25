package com.tuya.sdk.user;

import android.app.Application;
import com.tuya.smart.common.Oo0;
import com.tuya.smart.common.o00ooo00oo;
import com.tuya.smart.common.o0o00o00o0;
import com.tuya.smart.common.o0o00oo0oo;

public class UserPlugin extends Oo0.O000000o {
    public static final o00ooo00oo mUserPlugin = new o00ooo00oo();

    public void configure() {
        Oo0.O000000o.registerService(o0o00oo0oo.class, mUserPlugin);
    }

    public void dependency() {
        dependsOn(o0o00o00o0.class);
    }

    public void execute() {
    }

    public void initApplication(Application application) {
    }
}
