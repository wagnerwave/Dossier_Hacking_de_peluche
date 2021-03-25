package com.tuya.smart.android.device;

public class TuyaNetworkApi {
    static {
        System.loadLibrary("c++_shared");
        System.loadLibrary("network-android");
    }

    public static native int SendBroadcast(byte[] bArr, int i, int i2, boolean z);

    public static native void closeAllConnection();

    public static native int connectDevice(String str);

    public static native void enableDebug(boolean z);

    public static native byte[] encryptAesData(String str, String str2);

    public static native byte[] encryptAesDataForUDP(String str);

    public static native void listenUDP(int i);

    public static native void native_deInit();

    public static native void native_init(Object obj);

    public static native byte[] parseAesData(byte[] bArr, String str);

    public static native void registerNativeCallback(Object obj, String[] strArr, String[] strArr2);

    public static native int sendBytes(byte[] bArr, int i, int i2, String str);

    public static native int sendCMD(String str, int i, int i2, int i3, int i4);

    public static native void setSecurityContent(byte[] bArr);

    public static native void shutDownUDPListen();

    public static native void stopBroadcast();
}
