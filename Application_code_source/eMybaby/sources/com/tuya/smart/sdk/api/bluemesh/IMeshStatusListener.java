package com.tuya.smart.sdk.api.bluemesh;

public interface IMeshStatusListener {
    boolean getMeshDeviceCloudStatus(String str, String str2);

    boolean getMeshDeviceLocalStatus(String str, String str2);
}
