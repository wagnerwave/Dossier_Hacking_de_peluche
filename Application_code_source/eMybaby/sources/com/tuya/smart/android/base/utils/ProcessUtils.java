package com.tuya.smart.android.base.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Process;
import androidx.appcompat.widget.ActivityChooserModel;
import com.tuya.smart.android.common.utils.L;

public class ProcessUtils {
    public static String getProcessName(Application application) {
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) application.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            if (activityManager == null) {
                return "";
            }
            for (ActivityManager.RunningAppProcessInfo next : activityManager.getRunningAppProcesses()) {
                if (next.pid == myPid) {
                    return next.processName;
                }
            }
            return "";
        } catch (Exception e2) {
            L.e("ProcessUtils", "getProcessName error" + e2);
        }
    }
}
