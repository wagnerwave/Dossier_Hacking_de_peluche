package com.tuya.smart.sdk.api;

import androidx.annotation.Nullable;
import com.tuya.smart.android.device.bean.SchemaBean;
import com.tuya.smart.common.o0o00ooooo;
import com.tuya.smart.common.o0o0o00000;
import com.tuya.smart.common.o0o0o00o00;
import com.tuya.smart.common.o0o0o00o0o;
import com.tuya.smart.common.o0o0o00ooo;
import com.tuya.smart.common.o0o0o0o0o0;
import com.tuya.smart.interior.device.bean.DeviceRespBean;
import com.tuya.smart.interior.device.bean.GroupRespBean;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.GroupBean;
import com.tuya.smart.sdk.bean.ProductBean;
import java.util.List;
import java.util.Map;

public interface ITuyaDeviceListManager {
    void addDevList(List<DeviceRespBean> list);

    void addProductList(List<ProductBean> list);

    void discoveredLanDevice(ITuyaSearchDeviceListener iTuyaSearchDeviceListener);

    @Nullable
    DeviceBean getDev(String str);

    List<DeviceBean> getDevList();

    Object getDp(String str, String str2);

    Map<String, Object> getDps(String str);

    @Nullable
    GroupBean getGroupBean(long j);

    void getGroupSchema(List<GroupRespBean> list, ITuyaDataCallback<List<GroupBean>> iTuyaDataCallback);

    Map<String, SchemaBean> getSchema(String str);

    void getSchema(List<DeviceRespBean> list, ITuyaDataCallback<List<DeviceBean>> iTuyaDataCallback);

    @Nullable
    DeviceBean getSubDeviceBeanByNodeId(String str, String str2);

    void onDestroy();

    void queryDev(String str);

    void queryDev(String str, ITuyaDataCallback<DeviceBean> iTuyaDataCallback);

    void queryDps(String str);

    void querySubDev(String str, String str2, ITuyaDataCallback<DeviceBean> iTuyaDataCallback);

    void registerDeviceDpUpdateListener(o0o0o00o00 o0o0o00o00);

    void registerDeviceHardwareResponseListener(int i, o0o00ooooo o0o00ooooo);

    void registerDeviceInfoChangeListener(o0o0o00o0o o0o0o00o0o);

    <T> void registerDeviceMqttListener(Class<T> cls, o0o0o00000<T> o0o0o00000);

    void registerDeviceOnlineStatusListener(o0o0o00ooo o0o0o00ooo);

    void registerTuyaHardwareOnlineStatusListener(o0o0o0o0o0 o0o0o0o0o0);

    void removeDevCache(String str);

    void startHardwareService();

    void startServerService();

    void stopHardwareService();

    void stopServerService();

    void unRegisterDeviceDpUpdateListener(o0o0o00o00 o0o0o00o00);

    void unRegisterDeviceHardwareResponseListener(o0o00ooooo o0o00ooooo);

    void unRegisterDeviceInfoChangeListener(o0o0o00o0o o0o0o00o0o);

    <T> void unRegisterDeviceMqttListener(Class<T> cls, o0o0o00000<T> o0o0o00000);

    void unRegisterDeviceOnlineStatusListener(o0o0o00ooo o0o0o00ooo);

    void unRegisterDiscoveredLanDeviceListener(ITuyaSearchDeviceListener iTuyaSearchDeviceListener);

    void unRegisterTuyaHardwareOnlineStatusListener(o0o0o0o0o0 o0o0o0o0o0);
}
