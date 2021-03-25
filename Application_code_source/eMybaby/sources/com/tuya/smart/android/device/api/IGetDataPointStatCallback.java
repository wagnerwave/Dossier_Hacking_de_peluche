package com.tuya.smart.android.device.api;

import com.tuya.smart.android.device.bean.DataPointStatBean;

public interface IGetDataPointStatCallback {
    void onError(String str, String str2);

    void onSuccess(DataPointStatBean dataPointStatBean);
}
