package com.tuya.smart.home.sdk.api;

public interface ITuyaHomeDeviceStatusListener {
    void onDeviceDpUpdate(String str, String str2);

    void onDeviceInfoUpdate(String str);

    void onDeviceStatusChanged(String str, boolean z);
}
