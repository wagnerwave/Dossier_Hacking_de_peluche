package com.tuya.smart.common;

import com.alibaba.fastjson.JSONObject;
import com.tuya.sdk.device.bean.OtaProgressEventBean;
import com.tuya.sdk.device.bean.OtaUpdateEventBean;
import com.tuya.sdk.device.bean.RomUpdateBean;
import com.tuya.sdk.device.bean.RomUpdateConfirmEventBean;
import com.tuya.sdk.device.bean.RomUpdateProgressEventBean;
import com.tuya.sdk.device.enums.RomDevTypeEnum;
import com.tuya.sdk.device.enums.RomUpdateEnum;
import com.tuya.smart.android.base.event.BaseEventSender;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.hardware.bean.HgwBean;
import com.tuya.smart.home.sdk.bean.WarnMessageBean;
import com.tuya.smart.interior.event.DevUpdateEventModel;
import com.tuya.smart.interior.event.DeviceUpdateEventModel;
import com.tuya.smart.interior.event.ZigbeeSubDevDpUpdateEventModel;
import java.util.HashMap;

public class o0O0O00O extends BaseEventSender {
    public static final String O000000o = "DeviceEventSender";

    public static void O000000o() {
        BaseEventSender.send(new o());
    }

    public static void O000000o(int i, String str, JSONObject jSONObject) {
        BaseEventSender.send(new o0OO0OO0(i, str, jSONObject));
    }

    public static void O000000o(int i, String str, byte[] bArr) {
        BaseEventSender.send(new o0O00o00(i, str, false, bArr));
    }

    public static void O000000o(long j, String str) {
        BaseEventSender.send(new DeviceUpdateEventModel(j, str, 1));
    }

    public static void O000000o(OtaProgressEventBean otaProgressEventBean) {
        BaseEventSender.send(otaProgressEventBean);
    }

    public static void O000000o(RomUpdateProgressEventBean romUpdateProgressEventBean) {
        BaseEventSender.send(romUpdateProgressEventBean);
    }

    public static void O000000o(HgwBean hgwBean, boolean z) {
        BaseEventSender.send(new o0OO00OO(hgwBean, z));
    }

    public static void O000000o(WarnMessageBean warnMessageBean) {
        BaseEventSender.send(new o0oo0000oo(warnMessageBean));
    }

    public static void O000000o(String str) {
        BaseEventSender.send(new DeviceUpdateEventModel(-1, str, 2));
    }

    public static void O000000o(String str, int i, Integer num) {
        BaseEventSender.send(new OtaUpdateEventBean(str, RomUpdateEnum.to(i), num.intValue()));
    }

    public static void O000000o(String str, String str2) {
        L.d(O000000o, "devUpdate");
        BaseEventSender.send(new DevUpdateEventModel(str, str2));
    }

    public static void O000000o(String str, String str2, int i, int i2) {
        BaseEventSender.send(new RomUpdateBean(str, str2, RomUpdateEnum.to(i), RomDevTypeEnum.to(i2)));
    }

    public static void O000000o(String str, String str2, String str3, int i, String str4, boolean z) {
        BaseEventSender.send(new ZigbeeSubDevDpUpdateEventModel(str, str2, str3, i, str4, z));
    }

    public static void O000000o(String str, String str2, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(oOO0O0O0.O0000Oo0, str);
        hashMap.put("type", oOO0O0O0.O0000oOO);
        hashMap.put(oOO0O0O0.O0000Ooo, str2);
        hashMap.put(oOO0O0O0.O0000o, String.valueOf(z));
        oOO0O0O0.O000000o(oOO0O0O0.O00000oo, hashMap);
        BaseEventSender.send(new o0O0O0o0(str, str2, z));
    }

    public static void O00000Oo() {
        L.d(O000000o, "deviceListChanged");
        BaseEventSender.send(new o0O0oo0o());
    }

    public static void O00000Oo(int i, String str, byte[] bArr) {
        BaseEventSender.send(new o0O00o00(i, str, true, bArr));
    }

    public static void O00000Oo(long j, String str) {
        BaseEventSender.send(new DeviceUpdateEventModel(j, str, 0));
    }

    public static void O00000Oo(String str, String str2) {
        BaseEventSender.send(new RomUpdateConfirmEventBean(str, str2));
    }

    public static void O00000o(String str, String str2) {
        BaseEventSender.send(new DeviceUpdateEventModel(str, str2, 0));
    }

    public static void O00000o0() {
        L.d(O000000o, "groupDeviceListChanged");
        BaseEventSender.send(new o0O0OOOo());
    }

    public static void O00000o0(String str, String str2) {
        BaseEventSender.send(new DeviceUpdateEventModel(str, str2, 1));
    }

    public static void O00000oO(String str, String str2) {
        BaseEventSender.send(new DeviceUpdateEventModel(str, str2, 2));
    }
}
