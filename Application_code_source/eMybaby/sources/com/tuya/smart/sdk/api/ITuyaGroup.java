package com.tuya.smart.sdk.api;

import com.tuya.smart.sdk.enums.TYDevicePublishModeEnum;
import java.util.List;

public interface ITuyaGroup {
    void addDevice(String str, IResultCallback iResultCallback);

    void dismissGroup(IResultCallback iResultCallback);

    void onDestroy();

    void publishDps(String str, IResultCallback iResultCallback);

    void publishDps(String str, TYDevicePublishModeEnum tYDevicePublishModeEnum, IResultCallback iResultCallback);

    void registerGroupListener(IGroupListener iGroupListener);

    void removeDevice(String str, IResultCallback iResultCallback);

    void renameGroup(String str, IResultCallback iResultCallback);

    void unRegisterGroupListener();

    void updateDeviceList(List<String> list, IResultCallback iResultCallback);
}
