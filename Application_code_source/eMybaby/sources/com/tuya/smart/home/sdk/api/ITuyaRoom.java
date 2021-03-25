package com.tuya.smart.home.sdk.api;

import com.tuya.smart.home.sdk.bean.DeviceAndGroupInRoomBean;
import com.tuya.smart.sdk.api.IResultCallback;
import java.util.List;

public interface ITuyaRoom {
    void addDevice(String str, IResultCallback iResultCallback);

    void addGroup(long j, IResultCallback iResultCallback);

    void moveDevGroupListFromRoom(List<DeviceAndGroupInRoomBean> list, IResultCallback iResultCallback);

    void removeDevice(String str, IResultCallback iResultCallback);

    void removeGroup(Long l, IResultCallback iResultCallback);

    void sortDevInRoom(List<DeviceAndGroupInRoomBean> list, IResultCallback iResultCallback);

    void updateRoom(String str, IResultCallback iResultCallback);
}
