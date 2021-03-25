package com.tuya.smart.common;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tuya.smart.android.base.TuyaSmartSdk;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.api.WifiSignalListener;
import com.tuya.smart.sdk.bean.DeviceBean;

public class oO00OOo0 implements o0o0o00000<o0o0oo00o0> {
    public static final String O000000o = "20001";
    public static final String O00000Oo = "reqType";
    public static final String O00000o = "sigQry";
    public static final String O00000o0 = "data";
    public final oO000OOO O00000oO;
    public WifiSignalListener O00000oo;
    public String O0000O0o;
    public o0o00o00o0 O0000OOo;

    public oO00OOo0(String str) {
        this.O00000oO = new oO000OOO(TuyaSmartSdk.getApplication(), str);
        this.O0000O0o = str;
    }

    public void O000000o() {
        this.O00000oO.onDestroy();
        this.O00000oo = null;
        o0o00o00o0 o0o00o00o0 = this.O0000OOo;
        if (o0o00o00o0 != null) {
            o0o00o00o0.O0000o00().unRegisterDeviceMqttListener(o0o0oo00o0.class, this);
        }
    }

    /* renamed from: O000000o */
    public void onResult(o0o0oo00o0 o0o0oo00o0) {
        Object obj;
        WifiSignalListener wifiSignalListener;
        JSONObject parseObject = JSON.parseObject(o0o0oo00o0.O000000o());
        String string = parseObject.getString("data");
        String string2 = parseObject.getString(O00000Oo);
        if (!TextUtils.isEmpty(string2) && string2.equals(O00000o) && (obj = JSON.parseObject(string).get("signal")) != null && (wifiSignalListener = this.O00000oo) != null) {
            wifiSignalListener.onSignalValueFind(obj.toString());
        }
    }

    public void O000000o(WifiSignalListener wifiSignalListener) {
        this.O00000oo = wifiSignalListener;
        o0o00o00o0 o0o00o00o0 = (o0o00o00o0) Oo0.O000000o(o0o00o00o0.class);
        this.O0000OOo = o0o00o00o0;
        if (o0o00o00o0 != null) {
            o0o00o00o0.O0000o00().registerDeviceMqttListener(o0o0oo00o0.class, this);
        }
        DeviceBean dev = oOo0oooO.O000000o().getDev(this.O0000O0o);
        if (dev == null || !dev.isWifiDevice()) {
            WifiSignalListener wifiSignalListener2 = this.O00000oo;
            if (wifiSignalListener2 != null) {
                wifiSignalListener2.onError(O000000o, "the device has no wifi capability");
                return;
            }
            return;
        }
        this.O00000oO.query("{\"reqType\": \"sigQry\"} ", new IResultCallback() {
            public void onError(String str, String str2) {
                if (oO00OOo0.this.O00000oo != null) {
                    oO00OOo0.this.O00000oo.onError(str, str2);
                }
            }

            public void onSuccess() {
            }
        });
    }
}
