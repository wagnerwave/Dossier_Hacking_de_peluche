package com.tuya.smart.home.sdk.api;

import com.tuya.smart.home.sdk.bean.DeviceAndGroupInRoomBean;
import com.tuya.smart.home.sdk.bean.HomeBean;
import com.tuya.smart.home.sdk.bean.RoomBean;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.GroupBean;
import java.util.List;

public interface IHomeCacheManager {
    void addDevListToRoom(long j, List<String> list);

    void addDevToGroup(long j, String str);

    void addDevToHome(long j, String str);

    void addDevToMesh(String str, String str2);

    void addDevToRoom(long j, String str);

    void addGroupListToRoom(long j, List<Long> list);

    void addGroupToHome(long j, long j2);

    void addGroupToMesh(String str, long j);

    void addGroupToRoom(long j, long j2);

    void addMeshToHome(long j, String str);

    void addRoomToHome(long j, long j2);

    void addRoomToHome(long j, RoomBean roomBean);

    void addShareDevToPersonal(String str);

    void addShareGroupToPersonal(long j);

    void clearRelation();

    List<DeviceBean> getDevList(long j);

    GroupBean getGroupBean(long j);

    List<GroupBean> getGroupList(long j);

    HomeBean getHomeBean(long j);

    long getHomeIdByDevId(String str);

    long getHomeIdByGroupId(long j);

    long getHomeIdByMeshId(String str);

    List<RoomBean> getHomeRoomList(long j);

    List<DeviceBean> getMeshDeviceList(String str);

    List<GroupBean> getMeshGroupList(String str);

    RoomBean getRoomBeanByGroup(long j);

    RoomBean getRoomBeanByGroup(long j, long j2);

    RoomBean getRoomBeanByRoomId(long j);

    RoomBean getRoomBeanBydevice(long j, String str);

    RoomBean getRoomBeanBydevice(String str);

    List<DeviceBean> getRoomDeviceList(long j);

    List<GroupBean> getRoomGroupList(long j);

    List<DeviceBean> getShareDeviceList();

    List<GroupBean> getShareGroupList();

    void onDestroy();

    void putHomeBean(long j);

    void putHomeBean(HomeBean homeBean);

    void removeDevFromGroup(long j, String str);

    void removeDevFromRoom(long j, String str);

    void removeDevFromRoom(String str);

    void removeDevice(String str);

    void removeGroup(long j);

    void removeGroupFromRoom(long j);

    void removeGroupFromRoom(long j, long j2);

    void removeHome(long j);

    void removeMesh(String str);

    void removeRoom(long j);

    void removeShareDevice(String str);

    void removeShareGroup(long j);

    void replaceDevGroupToRoom(List<DeviceAndGroupInRoomBean> list, long j);

    void resetShareNode();

    void updateDeviceList(long j, List<String> list);
}
