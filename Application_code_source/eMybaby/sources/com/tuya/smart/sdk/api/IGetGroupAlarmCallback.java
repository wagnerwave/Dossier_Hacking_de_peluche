package com.tuya.smart.sdk.api;

import com.tuya.smart.android.device.bean.AlarmTimerBean;
import java.util.ArrayList;

public interface IGetGroupAlarmCallback {
    void onError(String str, String str2);

    void onSuccess(ArrayList<AlarmTimerBean> arrayList);
}
