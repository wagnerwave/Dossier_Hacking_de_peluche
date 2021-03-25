package com.tuya.smart.sdk.api;

import com.tuya.smart.sdk.bean.TimerTask;
import java.util.ArrayList;

public interface IGetAllTimerWithDevIdCallback {
    void onError(String str, String str2);

    void onSuccess(ArrayList<TimerTask> arrayList);
}
