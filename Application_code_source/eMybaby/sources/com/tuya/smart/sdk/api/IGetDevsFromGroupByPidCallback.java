package com.tuya.smart.sdk.api;

import com.tuya.smart.sdk.bean.GroupDeviceBean;
import java.util.List;

public interface IGetDevsFromGroupByPidCallback {
    void onError(String str, String str2);

    void onSuccess(List<GroupDeviceBean> list);
}
