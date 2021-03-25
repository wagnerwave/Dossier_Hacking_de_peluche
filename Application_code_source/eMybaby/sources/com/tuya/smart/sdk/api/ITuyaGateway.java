package com.tuya.smart.sdk.api;

import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.List;

public interface ITuyaGateway {
    void broadcastDps(String str, IResultCallback iResultCallback);

    void getSubDevList(ITuyaDataCallback<List<DeviceBean>> iTuyaDataCallback);

    void multicastDps(String str, String str2, IResultCallback iResultCallback);

    void onDestroy();

    void publishDps(String str, String str2, IResultCallback iResultCallback);

    void registerSubDevListener(ISubDevListener iSubDevListener);

    void unRegisterSubDevListener();
}
