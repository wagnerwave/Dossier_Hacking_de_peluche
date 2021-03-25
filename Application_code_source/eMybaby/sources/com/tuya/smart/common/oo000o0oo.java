package com.tuya.smart.common;

import android.content.Context;
import com.tuya.smart.android.network.TuyaSmartNetWork;
import com.tuya.smart.security.jni.JNICLibrary;

public class oo000o0oo {
    public static void O000000o(Context context) {
        try {
            JNICLibrary.doCommandNative(context, 0, TuyaSmartNetWork.mAppSecret.getBytes(), TuyaSmartNetWork.mAppId.getBytes(), TuyaSmartNetWork.mNTY, TuyaSmartNetWork.mD);
        } catch (Exception e2) {
            e2.getMessage();
        }
    }
}
