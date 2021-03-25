package com.tuya.smart.android.device;

public class TuyaSmartLink {
    static {
        try {
            System.loadLibrary("TuyaSmartLink");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static native void sendStatusStop();

    public static native int smartLink(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5);
}
