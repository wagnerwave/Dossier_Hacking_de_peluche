package com.tuya.smart.common;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.NonNull;
import com.tuya.smart.android.common.utils.L;

public class o00o00ooo {
    public static final String O000000o = "ServiceUtil";

    public static boolean O000000o(@NonNull Context context, @NonNull Intent intent) {
        if (Build.VERSION.SDK_INT < 26) {
            context.startService(intent);
            return true;
        } else if (o000oo000.O000000o().O00000Oo() != null) {
            context.startForegroundService(intent);
            return true;
        } else {
            L.e(O000000o, "startForegroundService failure with not config notification");
            return false;
        }
    }
}
