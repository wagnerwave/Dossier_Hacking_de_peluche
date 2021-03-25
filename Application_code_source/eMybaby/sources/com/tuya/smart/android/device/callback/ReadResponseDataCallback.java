package com.tuya.smart.android.device.callback;

import com.tuya.smart.android.hardware.bean.TuyaFrame;

public interface ReadResponseDataCallback {
    void OnResponseDataCallback(String str, TuyaFrame tuyaFrame);
}
