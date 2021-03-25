package com.tuya.smart.sdk.api;

import com.tuya.smart.android.device.api.IGetDataPointStatCallback;
import com.tuya.smart.android.device.api.IPropertyCallback;
import com.tuya.smart.android.device.enums.DataPointTypeEnum;
import com.tuya.smart.home.sdk.api.IWarningMsgListener;
import com.tuya.smart.sdk.enums.TYDevicePublishModeEnum;
import java.util.List;
import java.util.Map;

public interface ITuyaDevice {
    void getDataPointStat(DataPointTypeEnum dataPointTypeEnum, long j, int i, String str, IGetDataPointStatCallback iGetDataPointStatCallback);

    void getDeviceProperty(IPropertyCallback<Map> iPropertyCallback);

    void getDp(String str, IResultCallback iResultCallback);

    void getDpList(List<String> list, IResultCallback iResultCallback);

    void getInitiativeQueryDpsInfoWithDpsArray(List<Integer> list, IResultCallback iResultCallback);

    void onDestroy();

    void publishDps(String str, IResultCallback iResultCallback);

    void publishDps(String str, TYDevicePublishModeEnum tYDevicePublishModeEnum, IResultCallback iResultCallback);

    void queryData(String str, IResultCallback iResultCallback);

    void registerDevListener(IDevListener iDevListener);

    void registerWarnMessageListener(IWarningMsgListener iWarningMsgListener);

    void removeDevice(IResultCallback iResultCallback);

    void renameDevice(String str, IResultCallback iResultCallback);

    void requestWifiSignal(WifiSignalListener wifiSignalListener);

    void resetFactory(IResultCallback iResultCallback);

    void saveDeviceProperty(String str, String str2, IResultCallback iResultCallback);

    void unRegisterDevListener();
}
