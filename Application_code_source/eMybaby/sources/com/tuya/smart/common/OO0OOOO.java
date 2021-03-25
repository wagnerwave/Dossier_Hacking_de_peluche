package com.tuya.smart.common;

import com.tuya.smart.android.base.event.BaseEventSender;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.interior.device.bean.DeviceRespBean;
import com.tuya.smart.interior.event.DeviceUpdateEventModel;
import com.tuya.smart.sdk.bean.ProductBean;

public class OO0OOOO extends BaseEventSender {
    public static final String O000000o = "ConfigEventSender";

    public static void O000000o(long j, String str) {
        L.d(O000000o, "deviceAdd homeId: " + j + " devId: " + str);
        O00000Oo(j, str);
        BaseEventSender.send(new DeviceUpdateEventModel(j, str, 0));
    }

    public static void O000000o(String str, String str2) {
        L.d(O000000o, "subDeviceAdd meshId: " + str + " devId: " + str2);
        o0o00o0o0o o0o00o0o0o = (o0o00o0o0o) Oo0.O000000o(o0o00o0o0o.class);
        if (o0o00o0o0o != null) {
            long homeIdByDevId = o0o00o0o0o.O00000o0().getHomeIdByDevId(str2);
            if (homeIdByDevId != -1) {
                O00000Oo(homeIdByDevId, str2);
            }
        }
        BaseEventSender.send(new DeviceUpdateEventModel(str, str2, 0));
    }

    public static void O00000Oo(long j, String str) {
        DeviceRespBean O00000o0;
        ProductBean productBean;
        o0o00o0o0o o0o00o0o0o = (o0o00o0o0o) Oo0.O000000o(o0o00o0o0o.class);
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        if (o0o00o0o0o != null && o0o00o00o0 != null && (O00000o0 = o0o00o00o0.O0000OoO().O00000o0(str)) != null && (productBean = o0o00o00o0.O0000OOo().getProductBean(O00000o0.getProductId())) != null) {
            o0o00o0o0o.O00000oO().O000000o(j, O00000o0, productBean);
        }
    }
}
