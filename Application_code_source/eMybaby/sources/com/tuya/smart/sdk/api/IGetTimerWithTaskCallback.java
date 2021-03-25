package com.tuya.smart.sdk.api;

import com.tuya.smart.sdk.bean.TimerTask;

public interface IGetTimerWithTaskCallback {
    void onError(String str, String str2);

    void onSuccess(TimerTask timerTask);
}
