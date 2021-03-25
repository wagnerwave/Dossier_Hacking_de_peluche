package com.tuya.smart.sdk.api;

import com.tuya.smart.home.sdk.callback.ITuyaResultCallback;
import com.tuya.smart.sdk.bean.ZigbeeGroupCreateResultBean;
import java.util.List;

public interface ITuyaZigbeeGroup {
    void sendCommand(String str, List<String> list, String str2, int i, ITuyaResultCallback<ZigbeeGroupCreateResultBean> iTuyaResultCallback);

    void updateGroupDeviceList(long j, List<String> list, IResultCallback iResultCallback);
}
