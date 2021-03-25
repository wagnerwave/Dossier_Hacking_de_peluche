package com.tuya.smart.blescan.utils;

import android.util.Log;

public class ScanLog {
    public static final String TAG = "scan:";
    public static final boolean openLog = true;

    public static void d(String str, String str2) {
        Log.d(TAG + str, str2);
    }

    public static void e(String str, String str2) {
        Log.e(TAG + str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        Log.e(TAG + str, str2, th);
    }

    public static void i(String str, String str2) {
        Log.i(TAG + str, str2);
    }

    public static void w(String str, String str2) {
    }
}
