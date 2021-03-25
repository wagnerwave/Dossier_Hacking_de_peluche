package com.tuya.smart.common;

import com.tuya.smart.android.device.api.IGetDataPointStatCallback;
import com.tuya.smart.android.device.api.IPropertyCallback;
import com.tuya.smart.android.device.enums.DataPointTypeEnum;
import com.tuya.smart.home.sdk.api.IWarningMsgListener;
import com.tuya.smart.sdk.api.IDevListener;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.ITuyaDevice;
import com.tuya.smart.sdk.api.WifiSignalListener;
import com.tuya.smart.sdk.enums.TYDevicePublishModeEnum;
import java.util.List;
import java.util.Map;

public class oOo00o0o implements ITuyaDevice {
    public oOo00OO0 O000000o;
    public String O00000Oo;

    public oOo00o0o(String str) {
        this.O000000o = new oOo00OO0(str);
        this.O00000Oo = str;
    }

    public void getDataPointStat(DataPointTypeEnum dataPointTypeEnum, long j, int i, String str, IGetDataPointStatCallback iGetDataPointStatCallback) {
        this.O000000o.getDataPointStat(dataPointTypeEnum, j, i, str, iGetDataPointStatCallback);
    }

    public void getDeviceProperty(IPropertyCallback<Map> iPropertyCallback) {
        this.O000000o.getDeviceProperty(iPropertyCallback);
    }

    public void getDp(String str, IResultCallback iResultCallback) {
        this.O000000o.getDp(str, iResultCallback);
    }

    public void getDpList(List<String> list, IResultCallback iResultCallback) {
        this.O000000o.getDpList(list, iResultCallback);
    }

    public void getInitiativeQueryDpsInfoWithDpsArray(List<Integer> list, IResultCallback iResultCallback) {
        this.O000000o.getInitiativeQueryDpsInfoWithDpsArray(list, iResultCallback);
    }

    public void onDestroy() {
        this.O000000o.onDestroy();
    }

    public void publishDps(String str, IResultCallback iResultCallback) {
        this.O000000o.publishDps(str, iResultCallback);
    }

    public void publishDps(String str, TYDevicePublishModeEnum tYDevicePublishModeEnum, IResultCallback iResultCallback) {
        this.O000000o.publishDps(str, tYDevicePublishModeEnum, iResultCallback);
    }

    public void queryData(String str, IResultCallback iResultCallback) {
        this.O000000o.queryData(str, iResultCallback);
    }

    public void registerDevListener(IDevListener iDevListener) {
        this.O000000o.registerDevListener(iDevListener);
    }

    public void registerWarnMessageListener(IWarningMsgListener iWarningMsgListener) {
        this.O000000o.registerWarnMessageListener(iWarningMsgListener);
    }

    public void removeDevice(final IResultCallback iResultCallback) {
        this.O000000o.removeDevice(new IResultCallback() {
            public void onError(String str, String str2) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(str, str2);
                }
            }

            public void onSuccess() {
                o0o00o0o0o o0o00o0o0o = (o0o00o0o0o) Oo0.O000000o(o0o00o0o0o.class);
                if (o0o00o0o0o != null) {
                    o0o00o0o0o.O00000o0().removeDevice(oOo00o0o.this.O00000Oo);
                }
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void renameDevice(String str, IResultCallback iResultCallback) {
        this.O000000o.renameDevice(str, iResultCallback);
    }

    public void requestWifiSignal(WifiSignalListener wifiSignalListener) {
        this.O000000o.requestWifiSignal(wifiSignalListener);
    }

    public void resetFactory(IResultCallback iResultCallback) {
        this.O000000o.resetFactory(iResultCallback);
    }

    public void saveDeviceProperty(String str, String str2, IResultCallback iResultCallback) {
        this.O000000o.saveDeviceProperty(str, str2, iResultCallback);
    }

    public void unRegisterDevListener() {
        this.O000000o.unRegisterDevListener();
    }
}
