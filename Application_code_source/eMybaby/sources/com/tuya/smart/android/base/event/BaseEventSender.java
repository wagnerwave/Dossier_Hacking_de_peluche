package com.tuya.smart.android.base.event;

import com.tuya.smart.android.base.TuyaSmartSdk;
import com.tuya.smart.android.device.event.ForeGroundStatusModel;

public class BaseEventSender {
    public static void send(Object obj) {
        TuyaSmartSdk.getEventBus().post(obj);
    }

    public static void sendForeGroundStatus(boolean z) {
        send(new ForeGroundStatusModel(z));
    }

    public static void sendNetworkStatus(boolean z) {
        send(new NetWorkStatusEventModel(z));
    }
}
