package com.tuya.smart.sdk.api;

import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.List;

public interface IGetSubDevListCallback {
    void onError(String str, String str2);

    void onSuccess(List<DeviceBean> list);
}
