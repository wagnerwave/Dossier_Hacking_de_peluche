package com.tuya.smart.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.common.utils.TuyaUtil;
import com.tuya.smart.android.network.Business;
import com.tuya.smart.android.network.http.BusinessResponse;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class oO0Ooooo implements o0o00oooo0 {
    public static final String O000000o = "DevCloudControlImpl";
    public final o000 O00000Oo = new o000();

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void O000000o(java.lang.String r7, java.util.Map<java.lang.String, java.lang.Object> r8, com.tuya.smart.sdk.bean.DeviceBean r9, java.lang.String r10, int r11, java.lang.String r12, com.tuya.smart.common.o0oo00o00o r13, com.tuya.smart.sdk.api.IResultCallback r14) {
        /*
            r6 = this;
            com.alibaba.fastjson.JSONObject r0 = new com.alibaba.fastjson.JSONObject
            r0.<init>()
            java.lang.String r1 = r9.getCadv()
            java.lang.String r2 = "1.0.2"
            int r1 = com.tuya.smart.android.common.utils.TuyaUtil.compareVersion(r1, r2)
            java.lang.String r2 = "ctype"
            java.lang.String r3 = "cid"
            java.lang.String r4 = "devId"
            java.lang.String r5 = "dps"
            if (r1 < 0) goto L_0x004a
            boolean r1 = android.text.TextUtils.equals(r10, r7)
            if (r1 != 0) goto L_0x003d
            boolean r1 = android.text.TextUtils.isEmpty(r10)
            if (r1 != 0) goto L_0x003d
            com.tuya.smart.sdk.bean.ProductBean r1 = r9.getProductBean()
            boolean r1 = r1.hasInfrared()
            if (r1 == 0) goto L_0x0033
            r0.put((java.lang.String) r4, (java.lang.Object) r7)
            goto L_0x003d
        L_0x0033:
            r0.put((java.lang.String) r3, (java.lang.Object) r10)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r11)
            r0.put((java.lang.String) r2, (java.lang.Object) r10)
        L_0x003d:
            boolean r10 = android.text.TextUtils.isEmpty(r12)
            if (r10 != 0) goto L_0x00c6
            java.lang.String r10 = "mbid"
            r0.put((java.lang.String) r10, (java.lang.Object) r12)
            goto L_0x00c6
        L_0x004a:
            java.lang.String r12 = r9.getCadv()
            java.lang.String r1 = "1.0.1"
            int r12 = com.tuya.smart.android.common.utils.TuyaUtil.compareVersion(r12, r1)
            if (r12 >= 0) goto L_0x00a2
            boolean r12 = r9.isBleMesh()
            if (r12 != 0) goto L_0x00a2
            boolean r12 = r9.hasZigBee()
            if (r12 != 0) goto L_0x00a2
            boolean r12 = r9.is433Wifi()
            if (r12 == 0) goto L_0x007d
            java.lang.String r12 = r9.getNodeId()
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x007d
            java.lang.String r12 = r9.getParentId()
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x007d
            goto L_0x00a2
        L_0x007d:
            r0.put((java.lang.String) r4, (java.lang.Object) r7)
            r0.put((java.lang.String) r5, (java.lang.Object) r8)
            java.lang.String r8 = r9.getPv()
            r10 = 1074161254(0x40066666, float:2.1)
            boolean r8 = com.tuya.smart.android.common.utils.TuyaUtil.checkPvVersion(r8, r10)
            if (r8 != 0) goto L_0x00c9
            java.lang.String r8 = r9.getPv()
            r10 = 1073741824(0x40000000, float:2.0)
            boolean r8 = com.tuya.smart.android.common.utils.TuyaUtil.checkPvVersion(r8, r10)
            if (r8 == 0) goto L_0x00c9
            java.lang.String r8 = "gwId"
            r0.put((java.lang.String) r8, (java.lang.Object) r7)
            goto L_0x00c9
        L_0x00a2:
            boolean r12 = android.text.TextUtils.equals(r10, r7)
            if (r12 != 0) goto L_0x00c6
            boolean r12 = android.text.TextUtils.isEmpty(r10)
            if (r12 != 0) goto L_0x00c6
            com.tuya.smart.sdk.bean.ProductBean r12 = r9.getProductBean()
            boolean r12 = r12.hasInfrared()
            if (r12 == 0) goto L_0x00bc
            r0.put((java.lang.String) r4, (java.lang.Object) r7)
            goto L_0x00c6
        L_0x00bc:
            r0.put((java.lang.String) r3, (java.lang.Object) r10)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r11)
            r0.put((java.lang.String) r2, (java.lang.Object) r10)
        L_0x00c6:
            r0.put((java.lang.String) r5, (java.lang.Object) r8)
        L_0x00c9:
            boolean r8 = com.tuya.smart.android.common.utils.L.getLogStatus()
            if (r8 == 0) goto L_0x00f1
            java.lang.String r8 = "SandR o:"
            java.lang.StringBuilder r8 = a.a.a.a.a.n(r8)
            int r10 = r13.O000000o()
            r8.append(r10)
            java.lang.String r10 = " s: "
            r8.append(r10)
            int r10 = r13.O00000Oo()
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            java.lang.String r10 = "DevCloudControlImpl"
            com.tuya.smart.android.common.utils.L.d(r10, r8)
        L_0x00f1:
            java.lang.String r8 = r9.getPv()
            java.lang.String r9 = r9.getLocalKey()
            r10 = r0
            r11 = r13
            r12 = r14
            com.tuya.smart.common.oO00O00o.O000000o((java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (com.alibaba.fastjson.JSONObject) r10, (com.tuya.smart.common.o0oo00o00o) r11, (com.tuya.smart.sdk.api.IResultCallback) r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.oO0Ooooo.O000000o(java.lang.String, java.util.Map, com.tuya.smart.sdk.bean.DeviceBean, java.lang.String, int, java.lang.String, com.tuya.smart.common.o0oo00o00o, com.tuya.smart.sdk.api.IResultCallback):void");
    }

    public void O000000o() {
        this.O00000Oo.onDestroy();
    }

    public void O000000o(int i, String str, String str2, long j, o0oo00o00o o0oo00o00o, IResultCallback iResultCallback) {
        String str3 = str;
        DeviceBean dev = oOo0oooO.O000000o().getDev(str);
        if (dev == null) {
            iResultCallback.onError("11002", "deviceBean == null");
            return;
        }
        int i2 = i;
        String str4 = str;
        String str5 = str2;
        long j2 = j;
        oO00O00o.O000000o(i2, str4, str5, j2, dev.getPv(), dev.getLocalKey(), o0oo00o00o, iResultCallback);
    }

    public void O000000o(String str, String str2, o0oo00o00o o0oo00o00o, IResultCallback iResultCallback) {
        DeviceBean dev = oOo0oooO.O000000o().getDev(str2);
        if (dev == null) {
            iResultCallback.onError("11002", "deviceBean == null");
            return;
        }
        oO00O00o.O000000o(str, str2, dev.getPv(), dev.getLocalKey(), o0oo00o00o, iResultCallback);
    }

    public void O000000o(String str, String str2, String str3, long j, o0oo00o00o o0oo00o00o, IResultCallback iResultCallback) {
        String str4 = str2;
        DeviceBean dev = oOo0oooO.O000000o().getDev(str2);
        if (dev == null) {
            iResultCallback.onError("11002", "deviceBean == null");
            return;
        }
        String str5 = str;
        String str6 = str2;
        String str7 = str3;
        long j2 = j;
        oO00O00o.O000000o(str5, str6, str7, j2, dev.getPv(), dev.getLocalKey(), o0oo00o00o, iResultCallback);
    }

    public void O000000o(String str, String str2, String str3, IResultCallback iResultCallback) {
        O000000o(str, str2, str3, "", iResultCallback);
    }

    public void O000000o(String str, final String str2, String str3, String str4, final IResultCallback iResultCallback) {
        L.d(O000000o, "network control");
        o0o0o0ooo0 o0o0o0ooo0 = new o0o0o0ooo0();
        o0o0o0ooo0.O000000o(str);
        o0o0o0ooo0.O00000Oo(str2);
        o0o0o0ooo0.O00000o0(str3);
        o0o0o0ooo0.O00000o(str4);
        if (iResultCallback instanceof oOO0O00O) {
            oOO0O00O ooo0o00o = (oOO0O00O) iResultCallback;
            ooo0o00o.O00000o = oOO0O0O0.O00000o;
            Map<String, String> O000000o2 = ooo0o00o.O000000o();
            O000000o2.put(o0ooo00oo.O00000o0, str);
            O000000o2.put(oOO0O0O0.O0000Ooo, str3);
            O000000o2.put("pcc", str4);
            oOO0O0O0.O000000o(oOO0O0O0.O00000o, O000000o2);
        }
        this.O00000Oo.O000000o(o0o0o0ooo0, (Business.ResultListener<Boolean>) new Business.ResultListener<Boolean>() {
            /* renamed from: O000000o */
            public void onFailure(BusinessResponse businessResponse, Boolean bool, String str) {
                L.d(oO0Ooooo.O000000o, "server control failure");
                if (businessResponse.getErrorCode().equals(o0O00O0o.O000000o)) {
                    oOo0oooO.O000000o().queryDev(str2);
                }
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(businessResponse.getErrorCode(), businessResponse.getErrorMsg());
                }
            }

            /* renamed from: O00000Oo */
            public void onSuccess(BusinessResponse businessResponse, Boolean bool, String str) {
                L.d(oO0Ooooo.O000000o, "server control success");
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void O000000o(String str, String str2, String str3, List<String> list, o0oo00o00o o0oo00o00o, IResultCallback iResultCallback) {
        DeviceBean dev = oOo0oooO.O000000o().getDev(str);
        if (dev == null) {
            iResultCallback.onError("11002", "deviceBean == null");
            return;
        }
        oO00O00o.O000000o(str, dev.getPv(), dev.getLocalKey(), 0, str2, str3, list, o0oo00o00o, iResultCallback);
    }

    public void O000000o(String str, String str2, List<String> list, o0oo00o00o o0oo00o00o, IResultCallback iResultCallback) {
        DeviceBean dev = oOo0oooO.O000000o().getDev(str);
        if (dev == null) {
            iResultCallback.onError("11002", "deviceBean == null");
            return;
        }
        oO00O00o.O000000o(str, dev.getPv(), dev.getLocalKey(), 0, str2, list, o0oo00o00o, iResultCallback);
    }

    public void O000000o(String str, LinkedHashMap<String, Object> linkedHashMap, o0oo00o00o o0oo00o00o, IResultCallback iResultCallback) {
        DeviceBean dev = oOo0oooO.O000000o().getDev(str);
        String str2 = str;
        oO00O00o.O00000Oo(str2, dev.getPv(), dev.getLocalKey(), new JSONObject((Map<String, Object>) linkedHashMap), o0oo00o00o, iResultCallback);
    }

    public void O000000o(String str, LinkedHashMap<String, Object> linkedHashMap, String str2, int i, String str3, o0oo00o00o o0oo00o00o, IResultCallback iResultCallback) {
        String str4 = str;
        IResultCallback iResultCallback2 = iResultCallback;
        DeviceBean dev = oOo0oooO.O000000o().getDev(str);
        if (dev == null) {
            if (iResultCallback2 != null) {
                iResultCallback2.onError("11002", "dev==null");
            }
        } else if (TuyaUtil.checkPvVersion(dev.getPv(), 1.1f)) {
            O000000o(str, linkedHashMap, dev, str2, i, str3, o0oo00o00o, iResultCallback);
        } else {
            LinkedHashMap<String, Object> linkedHashMap2 = linkedHashMap;
            O000000o(str, str, JSON.toJSONString((Object) linkedHashMap, SerializerFeature.WriteMapNullValue), iResultCallback2);
        }
    }

    public void O000000o(String str, List<String> list, List<Integer> list2, o0oo00o00o o0oo00o00o, IResultCallback iResultCallback) {
        DeviceBean dev = oOo0oooO.O000000o().getDev(str);
        if (dev == null) {
            iResultCallback.onError("11002", "deviceBean == null");
            return;
        }
        oO00O00o.O000000o(str, list, list2, dev.getPv(), dev.getLocalKey(), o0oo00o00o, iResultCallback);
    }

    public void O00000Oo(String str, String str2, String str3, List<String> list, o0oo00o00o o0oo00o00o, IResultCallback iResultCallback) {
        DeviceBean dev = oOo0oooO.O000000o().getDev(str);
        if (dev == null) {
            iResultCallback.onError("11002", "deviceBean == null");
            return;
        }
        oO00O00o.O000000o(str, dev.getPv(), dev.getLocalKey(), 1, str2, str3, list, o0oo00o00o, iResultCallback);
    }

    public void O00000Oo(String str, String str2, List<String> list, o0oo00o00o o0oo00o00o, IResultCallback iResultCallback) {
        DeviceBean dev = oOo0oooO.O000000o().getDev(str);
        if (dev == null) {
            iResultCallback.onError("11002", "deviceBean == null");
            return;
        }
        oO00O00o.O000000o(str, dev.getPv(), dev.getLocalKey(), 1, str2, list, o0oo00o00o, iResultCallback);
    }
}
