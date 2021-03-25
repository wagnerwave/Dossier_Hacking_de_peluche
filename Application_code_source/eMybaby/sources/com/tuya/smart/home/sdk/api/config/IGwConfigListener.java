package com.tuya.smart.home.sdk.api.config;

import com.tuya.smart.android.config.bean.ConfigErrorRespBean;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.List;

public interface IGwConfigListener {
    void onDevOnline(DeviceBean deviceBean);

    void onFind(List<DeviceBean> list);

    void onFindErrorList(List<ConfigErrorRespBean> list);
}
