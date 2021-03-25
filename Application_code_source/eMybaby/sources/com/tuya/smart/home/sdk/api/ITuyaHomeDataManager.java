package com.tuya.smart.home.sdk.api;

import com.tuya.smart.android.device.bean.SchemaBean;
import com.tuya.smart.home.sdk.bean.HomeBean;
import com.tuya.smart.home.sdk.bean.RoomBean;
import com.tuya.smart.interior.device.bean.DeviceRespBean;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import com.tuya.smart.sdk.api.ITuyaSearchDeviceListener;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.GroupBean;
import com.tuya.smart.sdk.bean.ProductBean;
import java.util.List;
import java.util.Map;

public interface ITuyaHomeDataManager {
    void addDevRespList(List<DeviceRespBean> list);

    void addProductList(List<ProductBean> list);

    void discoveredLanDevice(ITuyaSearchDeviceListener iTuyaSearchDeviceListener);

    DeviceRespBean getDevRespBean(String str);

    List<DeviceRespBean> getDevRespBeanList();

    DeviceBean getDeviceBean(String str);

    RoomBean getDeviceRoomBean(String str);

    Object getDp(String str, String str2);

    Map<String, Object> getDps(String str);

    GroupBean getGroupBean(long j);

    List<DeviceBean> getGroupDeviceList(long j);

    RoomBean getGroupRoomBean(long j);

    HomeBean getHomeBean(long j);

    List<DeviceBean> getHomeDeviceList(long j);

    List<GroupBean> getHomeGroupList(long j);

    List<RoomBean> getHomeRoomList(long j);

    List<DeviceBean> getMeshDeviceList(String str);

    List<GroupBean> getMeshGroupList(String str);

    ProductBean getProductBean(String str);

    RoomBean getRoomBean(long j);

    List<DeviceBean> getRoomDeviceList(long j);

    List<GroupBean> getRoomGroupList(long j);

    Map<String, SchemaBean> getSchema(String str);

    void getSubDevList(String str, ITuyaDataCallback<List<DeviceBean>> iTuyaDataCallback);

    DeviceRespBean getSubDevRespBean(String str, String str2);

    List<DeviceBean> getSubDeviceBean(String str);

    DeviceBean getSubDeviceBeanByNodeId(String str, String str2);

    void queryDev(String str, ITuyaDataCallback<DeviceBean> iTuyaDataCallback);

    void querySubDev(String str, String str2, ITuyaDataCallback<DeviceBean> iTuyaDataCallback);

    void unRegisterDiscoveredLanDeviceListener(ITuyaSearchDeviceListener iTuyaSearchDeviceListener);
}
