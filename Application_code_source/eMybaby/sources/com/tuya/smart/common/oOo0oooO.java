package com.tuya.smart.common;

import a.a.a.a.a;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.TuyaConcurrentList;
import com.tuya.smart.android.device.bean.SchemaBean;
import com.tuya.smart.android.device.event.ForeGroundStatusEvent;
import com.tuya.smart.android.device.event.ForeGroundStatusModel;
import com.tuya.smart.interior.device.bean.DeviceRespBean;
import com.tuya.smart.interior.device.bean.GroupRespBean;
import com.tuya.smart.interior.event.DevUpdateEvent;
import com.tuya.smart.interior.event.DevUpdateEventModel;
import com.tuya.smart.interior.event.DeviceUpdateEvent;
import com.tuya.smart.interior.event.DeviceUpdateEventModel;
import com.tuya.smart.interior.event.ZigbeeSubDevDpUpdateEvent;
import com.tuya.smart.interior.event.ZigbeeSubDevDpUpdateEventModel;
import com.tuya.smart.sdk.TuyaSdk;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import com.tuya.smart.sdk.api.ITuyaDeviceListManager;
import com.tuya.smart.sdk.api.ITuyaSearchDeviceListener;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.GroupBean;
import com.tuya.smart.sdk.bean.ProductBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class oOo0oooO implements ForeGroundStatusEvent, o0O0O0Oo, o0OO000o, o0o0o00000, DevUpdateEvent, DeviceUpdateEvent, ZigbeeSubDevDpUpdateEvent, ITuyaDeviceListManager {
    public static final String O000000o = "TuyaSmartDevice";
    public static volatile oOo0oooO O00000Oo;
    public oOo0o0oO O00000o;
    public o0o0o000oo O00000o0;
    public ooOOO00O O00000oO;
    public o0o000oooo O00000oo = ((o0o000oooo) Oo0.O000000o(o0o000oooo.class));
    public TuyaConcurrentList<o0o0o00o00> O0000O0o = new TuyaConcurrentList<>();
    public TuyaConcurrentList<o0o0o00o0o> O0000OOo = new TuyaConcurrentList<>();
    public TuyaConcurrentList<o0o0o00ooo> O0000Oo0 = new TuyaConcurrentList<>();

    public oOo0oooO() {
        L.d(O000000o, "initDevice");
        this.O00000o0 = new oO0O0OoO();
        this.O00000o = new oOo0o0oO();
        this.O00000oO = new ooOOO00O();
        TuyaSdk.getEventBus().register(this);
        registerDeviceMqttListener(o0o0oooooo.class, this);
        registerDeviceMqttListener(o0o0oo0o00.class, this);
    }

    public static oOo0oooO O000000o() {
        if (O00000Oo == null) {
            synchronized (oOo0oooO.class) {
                if (O00000Oo == null) {
                    O00000Oo = new oOo0oooO();
                }
            }
        }
        return O00000Oo;
    }

    private void O000000o(o0o0oo0o00 o0o0oo0o00) {
        ArrayList arrayList = new ArrayList();
        if (o0o0oo0o00.O00000o0() != null) {
            arrayList.addAll(o0o0oo0o00.O00000o0());
        }
        if (o0o0oo0o00.O00000Oo() != null) {
            arrayList.addAll(o0o0oo0o00.O00000Oo());
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            DeviceBean subDeviceBeanByNodeId = oO0OO000.O000000o().getSubDeviceBeanByNodeId(o0o0oo0o00.O000000o(), (String) it.next());
            if (subDeviceBeanByNodeId != null) {
                O000000o(subDeviceBeanByNodeId.getDevId(), subDeviceBeanByNodeId.getIsOnline());
            }
        }
    }

    private void O000000o(DeviceBean deviceBean) {
        O000000o(deviceBean.getDevId(), JSON.toJSONString(deviceBean.getDps()), true);
    }

    private void O000000o(final String str, final Boolean bool) {
        this.O0000Oo0.query(new TuyaConcurrentList.QueryListCallback<o0o0o00ooo>() {
            /* renamed from: O000000o */
            public void query(o0o0o00ooo o0o0o00ooo) {
                o0o0o00ooo.O000000o(str, bool.booleanValue());
            }
        });
    }

    private void O000000o(final String str, final String str2, final boolean z) {
        this.O0000O0o.query(new TuyaConcurrentList.QueryListCallback<o0o0o00o00>() {
            /* renamed from: O000000o */
            public void query(o0o0o00o00 o0o0o00o00) {
                o0o0o00o00.O000000o(str, str2, z);
            }
        });
    }

    private boolean O00000Oo(DeviceBean deviceBean) {
        return deviceBean.isZigBeeWifi();
    }

    private void O00000o(DeviceBean deviceBean) {
        for (DeviceBean next : oO0OO000.O000000o().getSubDeviceBean(deviceBean.getDevId())) {
            O000000o(next.getDevId(), next.getIsOnline());
        }
    }

    private void O00000o0(final String str) {
        this.O0000OOo.query(new TuyaConcurrentList.QueryListCallback<o0o0o00o0o>() {
            /* renamed from: O000000o */
            public void query(o0o0o00o0o o0o0o00o0o) {
                o0o0o00o0o.O000000o(str);
            }
        });
    }

    private boolean O00000o0(DeviceBean deviceBean) {
        return !TextUtils.isEmpty(deviceBean.getMeshId());
    }

    public DeviceRespBean O000000o(String str) {
        return oO00O0o0.O000000o().O00000o0(str);
    }

    public DeviceRespBean O000000o(String str, String str2) {
        return oO00O0o0.O000000o().O000000o(str, str2);
    }

    @Deprecated
    public void O000000o(Context context, String str, String str2, final IResultCallback iResultCallback) {
        new oO000OOO(context, str2).removeDevice(new IResultCallback() {
            public void onError(String str, String str2) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(str, str2);
                }
            }

            public void onSuccess() {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    @Deprecated
    public void O000000o(Context context, String str, String str2, String str3, IResultCallback iResultCallback) {
        new oO000OOO(context, str2).renameGw(str, str3, iResultCallback);
    }

    public void O000000o(Long l, ITuyaDataCallback<GroupBean> iTuyaDataCallback) {
        this.O00000o0.O000000o(l, iTuyaDataCallback);
    }

    public void O000000o(String str, ITuyaDataCallback<List<DeviceBean>> iTuyaDataCallback) {
        this.O00000o0.O00000Oo(str, iTuyaDataCallback);
    }

    public void O000000o(List<DeviceRespBean> list) {
        oO00O0o0.O000000o().O000000o(list);
    }

    public List<DeviceBean> O00000Oo(String str) {
        return oO00O0o0.O000000o().O00000o(str);
    }

    public boolean O00000Oo() {
        return this.O00000oO.O00000o0();
    }

    public void addDevList(List<DeviceRespBean> list) {
        oO00O0o0.O000000o().O00000Oo(list);
    }

    public void addProductList(List<ProductBean> list) {
        oO0O00Oo.O000000o().O00000Oo(list);
    }

    public void discoveredLanDevice(ITuyaSearchDeviceListener iTuyaSearchDeviceListener) {
        this.O00000o.O000000o(iTuyaSearchDeviceListener);
    }

    public DeviceBean getDev(String str) {
        return this.O00000o0.O00000o(str);
    }

    public List<DeviceBean> getDevList() {
        return this.O00000o0.O00000Oo();
    }

    public Object getDp(String str, String str2) {
        return this.O00000o0.O00000Oo(str, str2);
    }

    public Map<String, Object> getDps(String str) {
        return this.O00000o0.O00000o0(str);
    }

    public GroupBean getGroupBean(long j) {
        return o0O000Oo.O000000o().O000000o(j);
    }

    public void getGroupSchema(List<GroupRespBean> list, ITuyaDataCallback<List<GroupBean>> iTuyaDataCallback) {
        this.O00000o0.O00000Oo(list, iTuyaDataCallback);
    }

    public Map<String, SchemaBean> getSchema(String str) {
        return this.O00000o0.O00000Oo(str);
    }

    public void getSchema(List<DeviceRespBean> list, ITuyaDataCallback<List<DeviceBean>> iTuyaDataCallback) {
        this.O00000o0.O000000o(list, iTuyaDataCallback);
    }

    public DeviceBean getSubDeviceBeanByNodeId(String str, String str2) {
        return oO00O0o0.O000000o().O00000o0(str, str2);
    }

    public void onDestroy() {
        L.d(O000000o, "onDestroy");
        stopServerService();
        this.O00000o0.O000000o();
        O000000o().unRegisterDeviceMqttListener(o0o0oooooo.class, this);
        O000000o().unRegisterDeviceMqttListener(o0o0oo0o00.class, this);
        try {
            oO00O0o0.O000000o().O00000Oo();
            oO0O00Oo.O000000o().O00000Oo();
            o0O000Oo.O000000o().O00000o0();
        } catch (Exception e2) {
            L.e(O000000o, e2.getMessage());
            e2.printStackTrace();
        }
        o0o000oooo o0o000oooo = this.O00000oo;
        if (o0o000oooo != null) {
            o0o000oooo.O000000o().onDestroy();
            this.O00000oo.O00000Oo().onDestroy();
        }
        TuyaSdk.getEventBus().unregister(this);
        this.O00000o.O00000o();
        this.O0000O0o.clear();
        this.O0000OOo.clear();
        this.O0000Oo0.clear();
        O00000Oo = null;
    }

    public void onEvent(ForeGroundStatusModel foreGroundStatusModel) {
        StringBuilder n = a.n("isForeground: ");
        n.append(foreGroundStatusModel.isForeground());
        L.d(O000000o, n.toString());
        if (foreGroundStatusModel.isForeground()) {
            startHardwareService();
            startServerService();
        }
    }

    public void onEventMainThread(o0O0O0o0 o0o0o0o0) {
        O000000o(o0o0o0o0.O000000o(), o0o0o0o0.O00000Oo(), o0o0o0o0.O00000o0());
    }

    public void onEventMainThread(o0OO00OO o0oo00oo) {
        O00000o0(o0oo00oo.O000000o().getGwId());
    }

    public void onEventMainThread(DevUpdateEventModel devUpdateEventModel) {
        DeviceBean O00000Oo2 = oO00O0o0.O000000o().O00000Oo(devUpdateEventModel.getDevId());
        if (O00000Oo(O00000Oo2)) {
            O00000o(O00000Oo2);
            O000000o(O00000Oo2.getDevId(), O00000Oo2.getIsOnline());
        } else if (O00000o0(O00000Oo2)) {
            O000000o(O00000Oo2);
        }
    }

    public void onEventMainThread(DeviceUpdateEventModel deviceUpdateEventModel) {
        if (deviceUpdateEventModel.getMode() == 2) {
            O00000o0(deviceUpdateEventModel.getDevId());
        }
    }

    public void onEventMainThread(ZigbeeSubDevDpUpdateEventModel zigbeeSubDevDpUpdateEventModel) {
        O000000o(zigbeeSubDevDpUpdateEventModel.getDevId(), zigbeeSubDevDpUpdateEventModel.getDps(), zigbeeSubDevDpUpdateEventModel.isFromCloud());
    }

    public void onResult(Object obj) {
        if (obj instanceof o0o0oo0o00) {
            O000000o((o0o0oo0o00) obj);
        } else if (obj instanceof o0o0oooooo) {
            o0o0oooooo o0o0oooooo = (o0o0oooooo) obj;
            O000000o(o0o0oooooo.O00000oO(), o0o0oooooo.O00000o(), true);
        }
    }

    public void queryDev(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.O00000o0.O000000o(str, (ITuyaDataCallback<DeviceBean>) null);
        }
    }

    public void queryDev(String str, ITuyaDataCallback<DeviceBean> iTuyaDataCallback) {
        this.O00000o0.O000000o(str, iTuyaDataCallback);
    }

    public void queryDps(String str) {
        this.O00000o0.O00000oO(str);
    }

    public void querySubDev(String str, String str2, ITuyaDataCallback<DeviceBean> iTuyaDataCallback) {
        this.O00000o0.O000000o(str, str2, iTuyaDataCallback);
    }

    public void registerDeviceDpUpdateListener(o0o0o00o00 o0o0o00o00) {
        this.O0000O0o.add(o0o0o00o00);
    }

    public void registerDeviceHardwareResponseListener(int i, o0o00ooooo o0o00ooooo) {
        this.O00000o.O000000o(i, o0o00ooooo);
    }

    public void registerDeviceInfoChangeListener(o0o0o00o0o o0o0o00o0o) {
        this.O0000OOo.add(o0o0o00o0o);
    }

    public <T> void registerDeviceMqttListener(Class<T> cls, o0o0o00000<T> o0o0o00000) {
        this.O00000oO.O000000o(cls, o0o0o00000);
    }

    public void registerDeviceOnlineStatusListener(o0o0o00ooo o0o0o00ooo) {
        this.O0000Oo0.add(o0o0o00ooo);
    }

    public void registerTuyaHardwareOnlineStatusListener(o0o0o0o0o0 o0o0o0o0o0) {
        this.O00000o.O000000o(o0o0o0o0o0);
    }

    public void removeDevCache(String str) {
        DeviceBean O00000o2 = this.O00000o0.O00000o(str);
        if (O00000o2 != null) {
            if (TextUtils.isEmpty(O00000o2.getMeshId())) {
                o0o00o0o0o o0o00o0o0o = (o0o00o0o0o) Oo0.O000000o(o0o00o0o0o.class);
                long j = 0;
                if (o0o00o0o0o != null) {
                    j = o0o00o0o0o.O00000o0().getHomeIdByDevId(str);
                }
                o0O0O00O.O000000o(j, str);
            } else {
                o0O0O00O.O00000o0(O00000o2.getMeshId(), str);
            }
        }
        if (this.O00000o0.O000000o(str)) {
            L.d(O000000o, "gwId: " + str + " remove success");
        }
    }

    public void startHardwareService() {
        this.O00000o.O00000Oo();
    }

    public void startServerService() {
        this.O00000oO.O000000o();
    }

    public void stopHardwareService() {
        this.O00000o.O00000o0();
    }

    public void stopServerService() {
        this.O00000oO.O00000o();
    }

    public void unRegisterDeviceDpUpdateListener(o0o0o00o00 o0o0o00o00) {
        this.O0000O0o.remove(o0o0o00o00);
    }

    public void unRegisterDeviceHardwareResponseListener(o0o00ooooo o0o00ooooo) {
        this.O00000o.O000000o(o0o00ooooo);
    }

    public void unRegisterDeviceInfoChangeListener(o0o0o00o0o o0o0o00o0o) {
        this.O0000OOo.remove(o0o0o00o0o);
    }

    public <T> void unRegisterDeviceMqttListener(Class<T> cls, o0o0o00000<T> o0o0o00000) {
        this.O00000oO.O00000Oo(cls, o0o0o00000);
    }

    public void unRegisterDeviceOnlineStatusListener(o0o0o00ooo o0o0o00ooo) {
        this.O0000Oo0.remove(o0o0o00ooo);
    }

    public void unRegisterDiscoveredLanDeviceListener(ITuyaSearchDeviceListener iTuyaSearchDeviceListener) {
        this.O00000o.O00000Oo(iTuyaSearchDeviceListener);
    }

    public void unRegisterTuyaHardwareOnlineStatusListener(o0o0o0o0o0 o0o0o0o0o0) {
        this.O00000o.O00000Oo(o0o0o0o0o0);
    }
}
