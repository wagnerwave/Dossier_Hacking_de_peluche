package com.tuya.smart.home.sdk.api;

import com.tuya.smart.home.sdk.callback.ITuyaResultCallback;
import com.tuya.smart.sdk.bean.CloudZigbeeGroupCreateBean;
import com.tuya.smart.sdk.bean.GroupDeviceBean;
import java.util.List;

public interface ITuyaGroupModel {
    void createNewGroup(long j, String str, String str2, List<String> list, ITuyaResultCallback<Long> iTuyaResultCallback);

    void createZigbeeEmptyGroup(String str, long j, String str2, int i, String str3, ITuyaResultCallback<CloudZigbeeGroupCreateBean> iTuyaResultCallback);

    void getGroupDeviceList(long j, long j2, String str, ITuyaResultCallback<List<GroupDeviceBean>> iTuyaResultCallback);

    void getZigbeeGroupDeviceList(long j, long j2, String str, String str2, ITuyaResultCallback<List<GroupDeviceBean>> iTuyaResultCallback);

    void onDestroy();
}
