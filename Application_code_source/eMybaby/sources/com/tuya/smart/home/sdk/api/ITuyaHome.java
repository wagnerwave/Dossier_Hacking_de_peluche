package com.tuya.smart.home.sdk.api;

import com.tuya.smart.common.o0ooo0000o;
import com.tuya.smart.home.sdk.bean.DeviceAndGroupInHomeBean;
import com.tuya.smart.home.sdk.bean.HomeBean;
import com.tuya.smart.home.sdk.bean.RoomBean;
import com.tuya.smart.home.sdk.callback.ITuyaGetRoomListCallback;
import com.tuya.smart.home.sdk.callback.ITuyaHomeResultCallback;
import com.tuya.smart.home.sdk.callback.ITuyaResultCallback;
import com.tuya.smart.home.sdk.callback.ITuyaRoomResultCallback;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.bean.BlueMeshBean;
import com.tuya.smart.sdk.bean.CloudZigbeeGroupCreateBean;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.GroupBean;
import com.tuya.smart.sdk.bean.GroupDeviceBean;
import com.tuya.smart.sdk.bean.SigMeshBean;
import java.util.List;

public interface ITuyaHome {
    void addRoom(String str, ITuyaRoomResultCallback iTuyaRoomResultCallback);

    void bindNewConfigDevs(List<String> list, IResultCallback iResultCallback);

    void createBlueMesh(String str, ITuyaResultCallback<BlueMeshBean> iTuyaResultCallback);

    void createGroup(String str, String str2, List<String> list, ITuyaResultCallback<Long> iTuyaResultCallback);

    void createSigMesh(ITuyaResultCallback<SigMeshBean> iTuyaResultCallback);

    void createZigbeeGroup(String str, String str2, int i, String str3, ITuyaResultCallback<CloudZigbeeGroupCreateBean> iTuyaResultCallback);

    void dismissHome(IResultCallback iResultCallback);

    HomeBean getHomeBean();

    void getHomeDetail(ITuyaHomeResultCallback iTuyaHomeResultCallback);

    void getHomeLocalCache(ITuyaHomeResultCallback iTuyaHomeResultCallback);

    void onDestroy();

    void queryDeviceListToAddGroup(long j, String str, ITuyaResultCallback<List<GroupDeviceBean>> iTuyaResultCallback);

    List<RoomBean> queryRoomInfoByDevice(List<DeviceBean> list);

    List<RoomBean> queryRoomInfoByGroup(List<GroupBean> list);

    void queryRoomList(ITuyaGetRoomListCallback iTuyaGetRoomListCallback);

    void queryZigbeeDeviceListToAddGroup(long j, String str, String str2, ITuyaResultCallback<List<GroupDeviceBean>> iTuyaResultCallback);

    void registerHomeDeviceStatusListener(ITuyaHomeDeviceStatusListener iTuyaHomeDeviceStatusListener);

    void registerHomeStatusListener(ITuyaHomeStatusListener iTuyaHomeStatusListener);

    void registerProductWarnListener(IWarningMsgListener iWarningMsgListener);

    void removeRoom(long j, IResultCallback iResultCallback);

    void sortDevInHome(String str, List<DeviceAndGroupInHomeBean> list, IResultCallback iResultCallback);

    void sortHome(List<Long> list, IResultCallback iResultCallback);

    void sortRoom(List<Long> list, IResultCallback iResultCallback);

    void unRegisterHomeDeviceStatusListener(ITuyaHomeDeviceStatusListener iTuyaHomeDeviceStatusListener);

    void unRegisterHomeStatusListener(ITuyaHomeStatusListener iTuyaHomeStatusListener);

    void unRegisterProductWarnListener(IWarningMsgListener iWarningMsgListener);

    @o0ooo0000o
    void unSubscribeTopics(List<String> list);

    void updateHome(String str, double d2, double d3, String str2, IResultCallback iResultCallback);

    void updateHome(String str, double d2, double d3, String str2, List<String> list, boolean z, IResultCallback iResultCallback);
}
