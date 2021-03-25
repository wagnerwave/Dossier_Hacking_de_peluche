package com.tuya.smart.home.sdk.api;

import com.tuya.smart.android.device.api.IGetDataPointStatCallback;
import com.tuya.smart.android.device.api.IPropertyCallback;
import com.tuya.smart.android.device.enums.DataPointTypeEnum;
import com.tuya.smart.sdk.api.IResultCallback;
import java.util.List;
import java.util.Map;

public interface IDevModel {
    void addZigBeeGroup(List<String> list, String str, IResultCallback iResultCallback);

    void addZigBeeScene(List<String> list, String str, String str2, IResultCallback iResultCallback);

    void autoConfigExecute(String str, String str2, String str3, long j, IResultCallback iResultCallback);

    void broadcastSend(String str, IResultCallback iResultCallback);

    void gatewayRouterConfigExecute(int i, String str, String str2, long j, IResultCallback iResultCallback);

    void getDataPointStat(DataPointTypeEnum dataPointTypeEnum, long j, int i, String str, String str2, IGetDataPointStatCallback iGetDataPointStatCallback);

    void getDeviceProperty(String str, String str2, IPropertyCallback<Map> iPropertyCallback);

    void getDp(String str, IResultCallback iResultCallback);

    void getDpList(List<String> list, IResultCallback iResultCallback);

    void getInitiativeQueryDpsInfo(String str, List<String> list, List<Integer> list2, IResultCallback iResultCallback);

    void intranetControl(String str, IResultCallback iResultCallback);

    boolean isIntranetControl();

    void localSceneExecute(String str, String str2, IResultCallback iResultCallback);

    void localSceneExecuteNew(String str, IResultCallback iResultCallback);

    void multicastSend(String str, String str2, IResultCallback iResultCallback);

    void onDestroy();

    void query(String str, IResultCallback iResultCallback);

    void removeDevice(IResultCallback iResultCallback);

    void removeZigBeeGroup(List<String> list, String str, IResultCallback iResultCallback);

    void removeZigBeeScene(List<String> list, String str, String str2, IResultCallback iResultCallback);

    void renameGw(String str, String str2, IResultCallback iResultCallback);

    void renameSubDevName(String str, String str2, String str3, IResultCallback iResultCallback);

    void saveDeviceProperty(String str, String str2, String str3, String str4, IResultCallback iResultCallback);

    void sceneExecuteMqtt(String str, IResultCallback iResultCallback);

    void send(String str, IResultCallback iResultCallback);

    void sendDpsByApi(String str, String str2, IResultCallback iResultCallback);

    void sendScene(String str, IResultCallback iResultCallback);
}
