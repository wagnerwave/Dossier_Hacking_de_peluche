package com.tuya.smart.common;

import a.a.a.a.a;
import com.tuya.smart.common.OO0OO0o;
import com.tuya.smart.home.sdk.api.config.IConfig;
import com.tuya.smart.home.sdk.api.config.IConnectListener;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.HashMap;
import java.util.Map;

public class o0OOoOoo extends OOO000o implements IConfig, IConnectListener {
    public IConfig O000000o;
    public IConnectListener O00000Oo;
    public OOOOo0 O00000o;
    public boolean O00000o0;
    public OOO0OO0 O00000oO;

    public o0OOoOoo(OOOOo0 oOOOo0) {
        O000000o(oOOOo0.O0000O0o());
        this.O00000Oo = oOOOo0.O00000o();
        this.O000000o = oOOOo0.O000000o((IConnectListener) this).O00000oO();
        this.O00000o = oOOOo0;
    }

    @Deprecated
    public void O00000o() {
        this.O000000o.cancel();
    }

    @Deprecated
    public void O00000o0() {
        this.O00000oO = new OOO0OO0();
        HashMap r = a.r("type", OO0OO0o.O00000o0.O00000oo);
        r.put("token", this.O00000o.O00000oo());
        this.O00000oO.O000000o(r, (Map<String, Object>) null);
        IConfig iConfig = this.O000000o;
        if (iConfig instanceof OOOO0) {
            ((OOOO0) iConfig).O000000o(this.O00000oO);
        }
        this.O000000o.start();
    }

    public void cancel() {
        super.cancel();
        O00000o();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0098, code lost:
        if (r10 != null) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00da, code lost:
        if (r10 != null) goto L_0x00dc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActiveError(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            super.onActiveError(r9, r10)
            com.tuya.smart.home.sdk.api.config.IConnectListener r0 = r8.O00000Oo
            if (r0 == 0) goto L_0x00fc
            r0.onActiveError(r9, r10)
            java.lang.Class<com.tuya.smart.common.o0oo0o0ooo> r10 = com.tuya.smart.common.o0oo0o0ooo.class
            java.lang.Object r10 = com.tuya.smart.common.Oo0.O000000o(r10)
            com.tuya.smart.common.o0oo0o0ooo r10 = (com.tuya.smart.common.o0oo0o0ooo) r10
            boolean r0 = r8.O00000o0
            if (r0 == 0) goto L_0x0017
            return
        L_0x0017:
            java.lang.String r0 = "1007"
            boolean r9 = android.text.TextUtils.equals(r9, r0)
            r0 = 0
            java.lang.String r1 = "config_result"
            if (r9 == 0) goto L_0x003b
            com.tuya.smart.common.OOO0OO0 r9 = r8.O00000oO
            if (r9 == 0) goto L_0x00fc
            boolean r9 = r9.O00000Oo()
            if (r9 != 0) goto L_0x00fc
            com.tuya.smart.common.OOO0OO0 r9 = r8.O00000oO
            r10 = 1
            r9.O000000o((boolean) r10)
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            java.lang.String r10 = "success"
            goto L_0x00f4
        L_0x003b:
            com.tuya.smart.home.sdk.api.config.IConfig r9 = r8.O000000o
            if (r9 == 0) goto L_0x00e3
            boolean r2 = r9 instanceof com.tuya.smart.common.OOOO0
            if (r2 == 0) goto L_0x00e3
            com.tuya.smart.common.OOOO0 r9 = (com.tuya.smart.common.OOOO0) r9
            com.tuya.smart.common.OOO r9 = r9.O000000o()
            com.tuya.smart.home.sdk.api.config.IConfig r2 = r8.O000000o
            com.tuya.smart.common.OOOO0 r2 = (com.tuya.smart.common.OOOO0) r2
            com.tuya.smart.common.OOOO0O r2 = r2.O00000Oo()
            com.tuya.smart.common.OOO00Oo r3 = r9.O00000o0()
            java.lang.String r4 = "f22f53893cedc95aa34844b792f341ba"
            java.lang.String r5 = "bssid"
            java.lang.String r6 = "token"
            java.lang.String r7 = "type"
            if (r3 == 0) goto L_0x009b
            com.tuya.smart.common.OOO00Oo r3 = r9.O00000o0()
            java.util.Map r3 = r3.O00000oo()
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x009b
            com.tuya.smart.common.OOO00Oo r9 = r9.O00000o0()
            if (r9 == 0) goto L_0x00e3
            java.util.Map r2 = r9.O00000oO()
            java.lang.String r3 = "wifi_config_ez_2"
            r2.put(r7, r3)
            java.util.Map r2 = r9.O00000oO()
            com.tuya.smart.common.OOOOo0 r3 = r8.O00000o
            java.lang.String r3 = r3.O00000oo()
            r2.put(r6, r3)
            java.util.Map r2 = r9.O00000oO()
            android.app.Application r3 = com.tuya.smart.sdk.TuyaSdk.getApplication()
            java.lang.String r3 = com.tuya.smart.android.device.utils.WiFiUtil.getBssid(r3)
            r2.put(r5, r3)
            if (r10 == 0) goto L_0x00e3
            goto L_0x00dc
        L_0x009b:
            com.tuya.smart.common.OOO00Oo r9 = r2.O000000o()
            if (r9 == 0) goto L_0x00e3
            com.tuya.smart.common.OOO00Oo r9 = r2.O000000o()
            java.util.Map r9 = r9.O00000oo()
            int r9 = r9.size()
            if (r9 <= 0) goto L_0x00e3
            com.tuya.smart.common.OOO00Oo r9 = r2.O000000o()
            if (r9 == 0) goto L_0x00e3
            java.util.Map r2 = r9.O00000oO()
            java.lang.String r3 = "wifi_config_ez_multi"
            r2.put(r7, r3)
            java.util.Map r2 = r9.O00000oO()
            com.tuya.smart.common.OOOOo0 r3 = r8.O00000o
            java.lang.String r3 = r3.O00000oo()
            r2.put(r6, r3)
            java.util.Map r2 = r9.O00000oO()
            android.app.Application r3 = com.tuya.smart.sdk.TuyaSdk.getApplication()
            java.lang.String r3 = com.tuya.smart.android.device.utils.WiFiUtil.getBssid(r3)
            r2.put(r5, r3)
            if (r10 == 0) goto L_0x00e3
        L_0x00dc:
            java.util.Map r9 = r9.O00000oO()
            r10.O000000o(r4, r9)
        L_0x00e3:
            com.tuya.smart.common.OOO0OO0 r9 = r8.O00000oO
            if (r9 == 0) goto L_0x00fc
            boolean r9 = r9.O00000Oo()
            if (r9 != 0) goto L_0x00fc
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            java.lang.String r10 = "failure"
        L_0x00f4:
            r9.put(r1, r10)
            com.tuya.smart.common.OOO0OO0 r10 = r8.O00000oO
            r10.O00000o0(r9, r0)
        L_0x00fc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.o0OOoOoo.onActiveError(java.lang.String, java.lang.String):void");
    }

    public void onActiveSuccess(DeviceBean deviceBean) {
        super.O000000o();
        IConnectListener iConnectListener = this.O00000Oo;
        if (iConnectListener != null) {
            iConnectListener.onActiveSuccess(deviceBean);
            this.O00000o0 = true;
            OOO0OO0 ooo0oo0 = this.O00000oO;
            if (ooo0oo0 != null && !ooo0oo0.O00000Oo()) {
                this.O00000oO.O000000o(true);
                HashMap hashMap = new HashMap();
                hashMap.put("config_result", "success");
                this.O00000oO.O00000o0(hashMap, (Map<String, Object>) null);
            }
        }
    }

    public void onConfigEnd() {
        IConnectListener iConnectListener = this.O00000Oo;
        if (iConnectListener != null) {
            iConnectListener.onConfigEnd();
        }
    }

    public void onConfigStart() {
        IConnectListener iConnectListener = this.O00000Oo;
        if (iConnectListener != null) {
            iConnectListener.onConfigStart();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.O000000o.onDestroy();
    }

    public void onDeviceBindSuccess(DeviceBean deviceBean) {
        IConnectListener iConnectListener = this.O00000Oo;
        if (iConnectListener != null) {
            iConnectListener.onDeviceBindSuccess(deviceBean);
        }
    }

    public void onDeviceFind(String str) {
        IConnectListener iConnectListener = this.O00000Oo;
        if (iConnectListener != null) {
            iConnectListener.onDeviceFind(str);
        }
    }

    public void onWifiError(String str) {
        IConnectListener iConnectListener = this.O00000Oo;
        if (iConnectListener != null) {
            iConnectListener.onWifiError(str);
        }
        this.O000000o.cancel();
    }

    public void start() {
        super.start();
        O00000o0();
    }
}
