package com.tuya.smart.common;

import a.a.a.a.a;
import android.content.Context;
import android.content.pm.PackageManager;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.sdk.TuyaSdk;

public class o00oo0oooo {
    public static boolean O000000o(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        StringBuilder n = a.n("package:");
        n.append(TuyaSdk.getApplication().getPackageName());
        L.d("tuya", n.toString());
        return packageManager.checkPermission(str, TuyaSdk.getApplication().getPackageName()) == 0;
    }
}
