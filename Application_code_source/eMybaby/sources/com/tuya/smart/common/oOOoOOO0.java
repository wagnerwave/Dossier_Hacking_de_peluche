package com.tuya.smart.common;

import com.tuya.smart.android.base.TuyaSmartSdk;
import com.tuya.smart.home.sdk.callback.ITuyaResultCallback;
import com.tuya.smart.sdk.api.IGroupListener;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.ITuyaGroup;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.GroupBean;
import com.tuya.smart.sdk.bean.ZigbeeGroupCreateResultBean;
import com.tuya.smart.sdk.enums.TYDevicePublishModeEnum;
import java.util.List;
import java.util.Map;

public class oOOoOOO0 implements ITuyaGroup {
    public final oO00000o O000000o;
    public long O00000Oo;
    public oO0OOo0o O00000o;
    public GroupBean O00000o0;

    public oOOoOOO0(long j) {
        this.O000000o = new oO00000o(j);
        this.O00000Oo = j;
        GroupBean groupBean = oO0OO000.O000000o().getGroupBean(j);
        this.O00000o0 = groupBean;
        if (groupBean != null && groupBean.getType() == 2) {
            this.O00000o = new oO0OoOO0(TuyaSmartSdk.getApplication(), this.O00000o0.getMeshId());
        }
    }

    public void addDevice(String str, IResultCallback iResultCallback) {
        this.O000000o.O00000Oo(str, iResultCallback);
    }

    public void dismissGroup(IResultCallback iResultCallback) {
        o0o00o00o0 o0o00o00o0;
        GroupBean groupBean = this.O00000o0;
        if (!(groupBean == null || groupBean.getType() != 2 || (o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)) == null)) {
            String meshId = this.O00000o0.getMeshId();
            List<String> devIds = this.O00000o0.getDevIds();
            String localId = this.O00000o0.getLocalId();
            if (devIds != null && devIds.size() > 0) {
                o0o00o00o0.O00000Oo(this.O00000Oo).sendCommand(meshId, devIds, localId, 1, (ITuyaResultCallback<ZigbeeGroupCreateResultBean>) null);
            }
        }
        this.O000000o.O000000o(iResultCallback);
    }

    public void onDestroy() {
        unRegisterGroupListener();
        this.O000000o.onDestroy();
    }

    public void publishDps(String str, final IResultCallback iResultCallback) {
        GroupBean groupBean = this.O00000o0;
        oOO0O00O O00000Oo2 = new oOO0O00O() {
            public void onError(String str, String str2) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(str, str2);
                }
                Map<String, String> O000000o2 = O000000o();
                O000000o2.put("code", str);
                O000000o2.put("msg", str2);
                oOO0O0O0.O000000o(oOO0O0O0.O00000Oo, O000000o2);
            }

            public void onSuccess() {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
                Map<String, String> O000000o2 = O000000o();
                O000000o2.put("code", oOO0O0O0.O0000oO0);
                O000000o2.put("msg", "success");
                oOO0O0O0.O000000o(oOO0O0O0.O00000Oo, O000000o2);
            }
        }.O00000Oo((groupBean == null || groupBean.getType() != 2) ? String.valueOf(this.O00000Oo) : this.O00000o0.getMeshId());
        Map<String, String> O000000o2 = O00000Oo2.O000000o();
        O000000o2.put(oOO0O0O0.O0000Ooo, str);
        oOO0O0O0.O000000o(oOO0O0O0.O000000o, O000000o2);
        GroupBean groupBean2 = this.O00000o0;
        if (groupBean2 == null || groupBean2.getType() != 2) {
            this.O000000o.O000000o(this.O00000Oo, str, O00000Oo2);
            return;
        }
        Map<String, Object> dps = this.O00000o0.getDps();
        List<DeviceBean> deviceBeans = this.O00000o0.getDeviceBeans();
        if (deviceBeans != null && deviceBeans.size() > 0) {
            DeviceBean deviceBean = deviceBeans.get(0);
            for (DeviceBean next : deviceBeans) {
                Map<String, Object> dps2 = next.getDps();
                if (!(dps2 == null || dps == null || !dps2.equals(dps))) {
                    deviceBean = next;
                }
            }
            if (deviceBean != null) {
                this.O00000o.O000000o(this.O00000o0.getMeshId(), deviceBean.getNodeId(), str, 2, this.O00000o0.getLocalId(), O00000Oo2);
            }
        }
    }

    public void publishDps(String str, TYDevicePublishModeEnum tYDevicePublishModeEnum, IResultCallback iResultCallback) {
        this.O000000o.O000000o(this.O00000Oo, str, tYDevicePublishModeEnum, iResultCallback);
    }

    public void registerGroupListener(IGroupListener iGroupListener) {
    }

    public void removeDevice(String str, IResultCallback iResultCallback) {
        this.O000000o.O00000o0(str, iResultCallback);
    }

    public void renameGroup(String str, IResultCallback iResultCallback) {
        this.O000000o.O000000o(str, iResultCallback);
    }

    public void unRegisterGroupListener() {
    }

    public void updateDeviceList(List<String> list, IResultCallback iResultCallback) {
        this.O000000o.O000000o(list, iResultCallback);
    }
}
