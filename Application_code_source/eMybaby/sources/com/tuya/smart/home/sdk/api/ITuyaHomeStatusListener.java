package com.tuya.smart.home.sdk.api;

public interface ITuyaHomeStatusListener {
    void onDeviceAdded(String str);

    void onDeviceRemoved(String str);

    void onGroupAdded(long j);

    void onGroupRemoved(long j);

    void onMeshAdded(String str);
}
