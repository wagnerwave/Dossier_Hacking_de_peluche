package com.tuya.smart.home.sdk.api;

import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.GroupBean;
import java.util.List;

public interface ITuyaHomeChangeListener {
    void onHomeAdded(long j);

    void onHomeInfoChanged(long j);

    void onHomeInvite(long j, String str);

    void onHomeRemoved(long j);

    void onServerConnectSuccess();

    void onSharedDeviceList(List<DeviceBean> list);

    void onSharedGroupList(List<GroupBean> list);
}
