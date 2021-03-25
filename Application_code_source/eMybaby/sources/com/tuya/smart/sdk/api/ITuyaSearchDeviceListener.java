package com.tuya.smart.sdk.api;

import com.tuya.smart.sdk.enums.DeviceActiveEnum;

public interface ITuyaSearchDeviceListener {
    void onDeviceFind(String str, DeviceActiveEnum deviceActiveEnum);
}
