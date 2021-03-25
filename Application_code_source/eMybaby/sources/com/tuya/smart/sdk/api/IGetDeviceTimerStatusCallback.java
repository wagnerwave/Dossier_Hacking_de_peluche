package com.tuya.smart.sdk.api;

import com.tuya.smart.sdk.bean.TimerTaskStatus;
import java.util.ArrayList;

public interface IGetDeviceTimerStatusCallback {
    void onError(String str, String str2);

    void onSuccess(ArrayList<TimerTaskStatus> arrayList);
}
