package com.tuya.smart.common;

import android.text.TextUtils;
import com.tuya.smart.android.base.TuyaSmartSdk;
import com.tuya.smart.android.device.api.IGetDataPointStatCallback;
import com.tuya.smart.android.device.api.IPropertyCallback;
import com.tuya.smart.android.device.enums.DataPointTypeEnum;
import com.tuya.smart.home.sdk.api.IWarningMsgListener;
import com.tuya.smart.interior.device.bean.DeviceRespBean;
import com.tuya.smart.sdk.api.IDevListener;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.ITuyaDevice;
import com.tuya.smart.sdk.api.WifiSignalListener;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.enums.TYDevicePublishModeEnum;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class oOo00OO0 implements ITuyaDevice {
    public final String O000000o;
    public final oO000OOO O00000Oo;
    public oO00OOo0 O00000o;
    public oO0Oo0O0 O00000o0;
    public ooooOO00 O00000oO;

    /* renamed from: com.tuya.smart.common.oOo00OO0$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] O000000o;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        static {
            /*
                com.tuya.smart.sdk.enums.TYDevicePublishModeEnum[] r0 = com.tuya.smart.sdk.enums.TYDevicePublishModeEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                O000000o = r0
                com.tuya.smart.sdk.enums.TYDevicePublishModeEnum r1 = com.tuya.smart.sdk.enums.TYDevicePublishModeEnum.TYDevicePublishModeInternet     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r0 = 2
                int[] r1 = O000000o     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.tuya.smart.sdk.enums.TYDevicePublishModeEnum r2 = com.tuya.smart.sdk.enums.TYDevicePublishModeEnum.TYDevicePublishModeLocal     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 0
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r1 = O000000o     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tuya.smart.sdk.enums.TYDevicePublishModeEnum r2 = com.tuya.smart.sdk.enums.TYDevicePublishModeEnum.TYDevicePublishModeAuto     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 3
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.oOo00OO0.AnonymousClass1.<clinit>():void");
        }
    }

    public oOo00OO0(String str) {
        this.O000000o = str;
        this.O00000Oo = new oO000OOO(TuyaSmartSdk.getApplication(), str);
        this.O00000o = new oO00OOo0(str);
    }

    private void O000000o(String str, IResultCallback iResultCallback) {
        if (this.O00000Oo.isIntranetControl()) {
            this.O00000Oo.intranetControl(str, iResultCallback);
        } else if (iResultCallback != null) {
            iResultCallback.onError("10201", "device is not in intranet online");
        }
    }

    private void O00000Oo(String str, IResultCallback iResultCallback) {
        if (oOo0oooO.O000000o().O00000Oo()) {
            this.O00000Oo.O000000o(str, iResultCallback);
        } else {
            iResultCallback.onError("10202", "device is not in cloud online");
        }
    }

    public String O000000o() {
        return this.O000000o;
    }

    public void getDataPointStat(DataPointTypeEnum dataPointTypeEnum, long j, int i, String str, IGetDataPointStatCallback iGetDataPointStatCallback) {
        this.O00000Oo.getDataPointStat(dataPointTypeEnum, j, i, str, "sum", iGetDataPointStatCallback);
    }

    public void getDeviceProperty(IPropertyCallback<Map> iPropertyCallback) {
        this.O00000Oo.O000000o(iPropertyCallback);
    }

    public void getDp(String str, IResultCallback iResultCallback) {
        this.O00000Oo.getDp(str, iResultCallback);
    }

    public void getDpList(List<String> list, IResultCallback iResultCallback) {
        this.O00000Oo.getDpList(list, iResultCallback);
    }

    public void getInitiativeQueryDpsInfoWithDpsArray(List<Integer> list, IResultCallback iResultCallback) {
        String str;
        long j;
        DeviceBean dev = oOo0oooO.O000000o().getDev(this.O000000o);
        ArrayList arrayList = new ArrayList();
        String str2 = this.O000000o;
        if (dev != null) {
            if (!TextUtils.isEmpty(dev.getMeshId())) {
                j = oOo0oooO.O000000o().getDev(dev.getMeshId()).getDevAttribute();
                str = dev.getMeshId();
                if (!TextUtils.isEmpty(dev.getNodeId())) {
                    arrayList.add(dev.getNodeId());
                }
            } else {
                str = str2;
                j = dev.getDevAttribute();
            }
            if ((j & 2) == 0) {
                iResultCallback.onError("data error", "device is not support");
            } else {
                this.O00000Oo.getInitiativeQueryDpsInfo(str, arrayList, list, iResultCallback);
            }
        }
    }

    public void onDestroy() {
        this.O00000Oo.onDestroy();
        unRegisterDevListener();
        oO00OOo0 oo00ooo0 = this.O00000o;
        if (oo00ooo0 != null) {
            oo00ooo0.O000000o();
        }
        ooooOO00 oooooo00 = this.O00000oO;
        if (oooooo00 != null) {
            oooooo00.O000000o();
        }
    }

    public void publishDps(String str, IResultCallback iResultCallback) {
        DeviceBean dev = oOo0oooO.O000000o().getDev(this.O000000o);
        if (dev == null || dev.getProductBean() == null || dev.getProductBean().getCapability() != 8) {
            this.O00000Oo.send(str, iResultCallback);
        } else {
            this.O00000Oo.sendDpsByApi(this.O000000o, str, iResultCallback);
        }
    }

    public void publishDps(String str, TYDevicePublishModeEnum tYDevicePublishModeEnum, IResultCallback iResultCallback) {
        int i = AnonymousClass1.O000000o[tYDevicePublishModeEnum.ordinal()];
        if (i == 1) {
            O00000Oo(str, iResultCallback);
        } else if (i == 2) {
            O000000o(str, iResultCallback);
        } else if (i == 3) {
            publishDps(str, iResultCallback);
        }
    }

    public void queryData(String str, IResultCallback iResultCallback) {
        this.O00000Oo.query(str, iResultCallback);
    }

    public void registerDevListener(IDevListener iDevListener) {
        if (this.O00000o0 == null) {
            DeviceRespBean O000000o2 = oOo0oooO.O000000o().O000000o(this.O000000o);
            if (O000000o2 == null || TextUtils.isEmpty(O000000o2.getNodeId())) {
                this.O00000o0 = new oO00OO0O(this.O000000o, iDevListener);
            } else {
                this.O00000o0 = new oOo00o00(O000000o2.getMeshId(), O000000o2.getDevId(), O000000o2.getNodeId(), iDevListener);
            }
        }
    }

    public void registerWarnMessageListener(IWarningMsgListener iWarningMsgListener) {
        if (this.O00000oO == null) {
            this.O00000oO = new ooooOO00(iWarningMsgListener);
        }
    }

    public void removeDevice(IResultCallback iResultCallback) {
        this.O00000Oo.removeDevice(iResultCallback);
    }

    public void renameDevice(String str, IResultCallback iResultCallback) {
        DeviceBean dev = oOo0oooO.O000000o().getDev(this.O000000o);
        if (dev == null || (!dev.isZigBeeSubDev() && !dev.isBleMesh() && !dev.is433SubDev())) {
            this.O00000Oo.renameGw(this.O000000o, str, iResultCallback);
        } else {
            this.O00000Oo.renameSubDevName(dev.getMeshId(), this.O000000o, str, iResultCallback);
        }
    }

    public void requestWifiSignal(WifiSignalListener wifiSignalListener) {
        this.O00000o.O000000o(wifiSignalListener);
    }

    public void resetFactory(IResultCallback iResultCallback) {
        this.O00000Oo.O00000Oo(iResultCallback);
    }

    public void saveDeviceProperty(String str, String str2, IResultCallback iResultCallback) {
        this.O00000Oo.O000000o(str, str2, iResultCallback);
    }

    public void unRegisterDevListener() {
        oO0Oo0O0 oo0oo0o0 = this.O00000o0;
        if (oo0oo0o0 != null) {
            oo0oo0o0.O000000o();
            this.O00000o0 = null;
        }
    }
}
