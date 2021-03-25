package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.tuya.sdk.device.bean.CloudControlBean2;
import com.tuya.sdk.device.bean.OtaProgressEventBean;
import com.tuya.sdk.device.bean.Protocol_25_DataBean;
import com.tuya.sdk.device.bean.PublishQueryBean2_1;
import com.tuya.sdk.device.bean.RomUpdateProgressEventBean;
import com.tuya.smart.android.common.utils.Base64;
import com.tuya.smart.android.common.utils.HexUtil;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.network.TuyaApiParams;
import com.tuya.smart.home.sdk.bean.WarnMessageBean;
import com.tuya.smart.interior.device.bean.BlueMeshBatchReportBean;
import com.tuya.smart.interior.device.bean.CloudControlRawBean;
import com.tuya.smart.interior.device.bean.DeviceRespBean;
import com.tuya.smart.interior.device.bean.GroupRespBean;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.GroupBean;
import com.tuya.smart.sdk.bean.ProductBean;
import com.tuya.spongycastle.jcajce.provider.config.ProviderConfigurationPermission;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class oO00O0Oo {
    public static final String O000000o = "mqtt protocol";
    public Handler O00000Oo = new Handler(Looper.getMainLooper());

    /* access modifiers changed from: private */
    public void O000000o(long j, Long l, int i, CopyOnWriteArrayList<o0o0o00000> copyOnWriteArrayList) {
        final CopyOnWriteArrayList<o0o0o00000> copyOnWriteArrayList2 = copyOnWriteArrayList;
        final long j2 = j;
        final Long l2 = l;
        final int i2 = i;
        this.O00000Oo.post(new Runnable() {
            public void run() {
                CopyOnWriteArrayList copyOnWriteArrayList = copyOnWriteArrayList2;
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    Iterator it = copyOnWriteArrayList2.iterator();
                    while (it.hasNext()) {
                        ((o0o0o00000) it.next()).onResult(new o0o0ooo0o0(j2, l2.longValue(), i2));
                    }
                }
            }
        });
    }

    private void O000000o(long j, String str, boolean z, CopyOnWriteArrayList<o0o0o00000> copyOnWriteArrayList) {
        ProductBean.SchemaInfo schemaInfo;
        boolean z2 = false;
        LinkedHashMap linkedHashMap = (LinkedHashMap) JSON.parseObject(str, new TypeReference<LinkedHashMap<String, Object>>() {
        }, new Feature[0]);
        GroupRespBean O00000o0 = o0O000Oo.O000000o().O00000o0(j);
        if (O00000o0 != null) {
            String productId = O00000o0.getProductId();
            ProductBean O000000o2 = oO0O00Oo.O000000o().O000000o(productId);
            if (!(O000000o2 == null || (schemaInfo = O000000o2.getSchemaInfo()) == null)) {
                z2 = oOO0OO0O.O00000Oo(O00000o0.getDps(), schemaInfo.getSchemaMap());
            }
            if (!oOO0OO0O.O000000o(productId, (LinkedHashMap<String, Object>) linkedHashMap)) {
                L.d(O000000o, "checkReceiveCommond error");
                return;
            }
            Map<String, Object> O000000o3 = oO0O0Oo0.O000000o(O00000o0, (Map<String, Object>) linkedHashMap);
            if (O000000o3 != null && O000000o3.size() > 0 && copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                L.d(O000000o, "Cloud: " + z + " dps: " + str);
                if (z2) {
                    str = JSON.toJSONString(O000000o3);
                }
                final String str2 = str;
                final CopyOnWriteArrayList<o0o0o00000> copyOnWriteArrayList2 = copyOnWriteArrayList;
                final long j2 = j;
                final boolean z3 = z;
                this.O00000Oo.post(new Runnable() {
                    public void run() {
                        Iterator it = copyOnWriteArrayList2.iterator();
                        while (it.hasNext()) {
                            ((o0o0o00000) it.next()).onResult(new o0o0ooooo0(j2, str2, z3));
                        }
                    }
                });
            }
        }
    }

    private void O000000o(JSONObject jSONObject) {
        String str;
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        String string = jSONObject2.getString(o0ooo00oo.O00000o0);
        DeviceBean dev = oOo0oooO.O000000o().getDev(string);
        if (dev == null || dev.getIsLocalOnline().booleanValue()) {
            if (dev == null) {
                str = "Device == null";
            } else {
                StringBuilder n = a.n("local is online ，data from cloud: ");
                n.append(jSONObject2.getString("dps"));
                str = n.toString();
            }
            L.d(O000000o, str);
            return;
        }
        oO0O0Oo0.O000000o(string, string, jSONObject2.getString("dps"), true);
    }

    private void O000000o(JSONObject jSONObject, final CopyOnWriteArrayList<o0o0o00000> copyOnWriteArrayList) {
        this.O00000Oo.post(new Runnable() {
            public void run() {
                CopyOnWriteArrayList copyOnWriteArrayList = copyOnWriteArrayList;
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    Iterator it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        ((o0o0o00000) it.next()).onResult(new o0o0oooo00());
                    }
                }
            }
        });
    }

    private void O000000o(DeviceRespBean deviceRespBean, boolean z) {
        DeviceRespBean.DevModule subpieces = deviceRespBean.getModuleMap().getSubpieces();
        if (subpieces != null) {
            subpieces.setIsOnline(z);
        }
    }

    private void O000000o(String str, int i, String str2) {
        DeviceRespBean O000000o2;
        if (oOo0oooO.O000000o().getDev(str) != null && (O000000o2 = oOo0oooO.O000000o().O000000o(str)) != null) {
            String valueOf = String.valueOf(i);
            if (O000000o2.getDpName() == null) {
                O000000o2.setDpName(new HashMap());
            }
            O000000o2.getDpName().put(valueOf, str2);
            oOo0oooO.O000000o().addDevList(Collections.singletonList(O000000o2));
            o0O0O00O.O000000o(str);
        }
    }

    private void O000000o(String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        if (jSONObject2 != null) {
            String string = jSONObject2.getString("devId");
            if (TextUtils.isEmpty(string)) {
                L.d(O000000o, "devid =null gateway update");
                oOo0oooO.O000000o().queryDev(str);
                return;
            }
            L.d(O000000o, "devid=" + string + " sub dev update");
            oOo0oooO.O000000o().querySubDev(str, string, new ITuyaDataCallback<DeviceBean>() {
                /* renamed from: O000000o */
                public void onSuccess(DeviceBean deviceBean) {
                    L.d(oO00O0Oo.O000000o, "querySubDev success");
                }

                public void onError(String str, String str2) {
                    a.v("errormsg=", str2, oO00O0Oo.O000000o);
                }
            });
        }
    }

    private void O000000o(String str, JSONObject jSONObject, List<o0o0o00000> list) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        String string = jSONObject2.getString("devId");
        String string2 = jSONObject2.getString("name");
        DeviceRespBean O00000o0 = oO00O0o0.O000000o().O00000o0(string);
        if (O00000o0 != null) {
            O00000o0.setName(string2);
        }
        L.d(O000000o, "devInfo: " + str);
        oO00O0o0.O000000o().O000000o(O00000o0);
        o0O0O00O.O00000oO(str, string);
    }

    private void O000000o(final String str, JSONObject jSONObject, final CopyOnWriteArrayList<o0o0o00000> copyOnWriteArrayList) {
        final String string = jSONObject.getJSONObject("data").getString("cids");
        this.O00000Oo.post(new Runnable() {
            public void run() {
                CopyOnWriteArrayList copyOnWriteArrayList = copyOnWriteArrayList;
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    Iterator it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        ((o0o0o00000) it.next()).onResult(new o0oo0000o0(str, string));
                    }
                }
            }
        });
    }

    private void O000000o(String str, JSONObject jSONObject, CopyOnWriteArrayList<o0o0o00000> copyOnWriteArrayList, HashMap<Class, CopyOnWriteArrayList<o0o0o00000>> hashMap) {
        if (str.startsWith(o0O00Oo0.O00000o)) {
            O000000o(jSONObject);
            return;
        }
        boolean containsKey = jSONObject.containsKey("s");
        int intValue = jSONObject.getIntValue("s");
        if (!containsKey || !oOo0000O.O000000o().O000000o(str, intValue)) {
            O000000o(str, (CloudControlBean2) jSONObject.getObject("data", CloudControlBean2.class), copyOnWriteArrayList, hashMap);
        }
    }

    private void O000000o(String str, CloudControlBean2 cloudControlBean2, CopyOnWriteArrayList<o0o0o00000> copyOnWriteArrayList, HashMap<Class, CopyOnWriteArrayList<o0o0o00000>> hashMap) {
        if (Long.getLong(str) != null) {
            return;
        }
        if (cloudControlBean2.getCtype() == 2) {
            if (!TextUtils.isEmpty(cloudControlBean2.getMbid())) {
                String jSONString = JSON.toJSONString(cloudControlBean2.getDps());
                long j = 0;
                for (GroupBean next : o0O000Oo.O000000o().O00000Oo()) {
                    if (TextUtils.equals(next.getLocalId(), cloudControlBean2.getMbid())) {
                        j = next.getId();
                    }
                }
                if (j != 0) {
                    O000000o(j, jSONString, true, hashMap.get(o0o0ooooo0.class));
                }
            }
        } else if (!TextUtils.isEmpty(cloudControlBean2.getCid())) {
            oO00O0o0.O000000o().O000000o(str, cloudControlBean2.getCid(), cloudControlBean2.getDps());
            DeviceRespBean O000000o2 = oO00O0o0.O000000o().O000000o(str, cloudControlBean2.getCid());
            O000000o(str, cloudControlBean2.getCid(), O000000o2 != null ? O000000o2.getDevId() : "", cloudControlBean2.getCtype(), JSON.toJSONString(cloudControlBean2.getDps()), copyOnWriteArrayList);
        } else {
            String jSONString2 = JSON.toJSONString(cloudControlBean2.getDps());
            a.v("success with dps: ", jSONString2, O000000o);
            oO0O0Oo0.O000000o(str, str, jSONString2, true);
        }
    }

    private void O000000o(String str, String str2, String str3, int i, String str4, List<o0o0o00000> list) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) JSON.parseObject(str4, new TypeReference<LinkedHashMap<String, Object>>() {
        }, new Feature[0]);
        boolean O00000o0 = oOO0OO0O.O00000o0(str3, linkedHashMap);
        if (!oOO0OO0O.O00000Oo(str3, (Map<String, Object>) linkedHashMap)) {
            L.d(O000000o, "checkReceiveCommond error");
            return;
        }
        Map<String, Object> O000000o2 = oO0O0Oo0.O000000o(str3, (Map<String, Object>) linkedHashMap);
        if (O000000o2 != null && O000000o2.size() > 0 && list != null && !list.isEmpty()) {
            L.d(O000000o, "meshId:" + str + " cid:" + str2 + " Cloud: " + true + " dps: " + str4);
            if (O00000o0) {
                str4 = JSON.toJSONString(O000000o2);
            }
            final String str5 = str4;
            final List<o0o0o00000> list2 = list;
            final String str6 = str;
            final String str7 = str2;
            final String str8 = str3;
            final int i2 = i;
            this.O00000Oo.post(new Runnable() {
                public void run() {
                    if (!list2.isEmpty()) {
                        for (o0o0o00000 onResult : list2) {
                            onResult.onResult(new o0o0oooooo(str6, str7, str8, i2, str5));
                        }
                    }
                }
            });
        }
    }

    private void O000000o(String str, List<String> list, boolean z) {
        if (list != null) {
            for (String O000000o2 : list) {
                DeviceRespBean O000000o3 = oO00O0o0.O000000o().O000000o(str, O000000o2);
                if (O000000o3 != null) {
                    DeviceBean dev = oOo0oooO.O000000o().getDev(O000000o3.getDevId());
                    if (dev != null) {
                        if (dev.isBleMesh()) {
                            O00000o0(O000000o3, z);
                        } else if (dev.is433SubDev()) {
                            O000000o(O000000o3, z);
                        } else {
                            O00000Oo(O000000o3, z);
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private void O000000o(String str, final CopyOnWriteArrayList<o0o0o00000> copyOnWriteArrayList) {
        this.O00000Oo.post(new Runnable() {
            public void run() {
                CopyOnWriteArrayList copyOnWriteArrayList = copyOnWriteArrayList;
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    Iterator it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        ((o0o0o00000) it.next()).onResult(new o0o0oo0000());
                    }
                }
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void O00000Oo(com.alibaba.fastjson.JSONObject r5) {
        /*
            r4 = this;
            java.lang.String r0 = "data"
            com.alibaba.fastjson.JSONObject r5 = r5.getJSONObject(r0)
            r0 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r1 = "firmwareType"
            java.lang.Integer r2 = r5.getInteger(r1)
            if (r2 == 0) goto L_0x0018
            java.lang.Integer r1 = r5.getInteger(r1)
            goto L_0x0019
        L_0x0018:
            r1 = r0
        L_0x0019:
            java.lang.String r2 = "type"
            java.lang.Integer r3 = r5.getInteger(r2)
            if (r3 == 0) goto L_0x003b
            java.lang.Integer r1 = r5.getInteger(r2)
            int r2 = r1.intValue()
            r3 = 1
            if (r2 != r3) goto L_0x002d
            goto L_0x003c
        L_0x002d:
            int r0 = r1.intValue()
            r2 = 2
            if (r0 != r2) goto L_0x003b
            r0 = 9
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x003c
        L_0x003b:
            r0 = r1
        L_0x003c:
            java.lang.String r1 = "gwId"
            java.lang.String r2 = r5.getString(r1)
            if (r2 == 0) goto L_0x0049
        L_0x0044:
            java.lang.String r1 = r5.getString(r1)
            goto L_0x0054
        L_0x0049:
            java.lang.String r1 = "devId"
            java.lang.String r2 = r5.getString(r1)
            if (r2 == 0) goto L_0x0052
            goto L_0x0044
        L_0x0052:
            java.lang.String r1 = ""
        L_0x0054:
            java.lang.String r2 = "status"
            int r5 = r5.getIntValue(r2)
            com.tuya.smart.common.o0O0O00O.O000000o((java.lang.String) r1, (int) r5, (java.lang.Integer) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.oO00O0Oo.O00000Oo(com.alibaba.fastjson.JSONObject):void");
    }

    private void O00000Oo(JSONObject jSONObject, CopyOnWriteArrayList<o0o0o00000> copyOnWriteArrayList) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        final long longValue = jSONObject2.getLong("id").longValue();
        final String string = jSONObject2.getString("name");
        final CopyOnWriteArrayList<o0o0o00000> copyOnWriteArrayList2 = copyOnWriteArrayList;
        this.O00000Oo.post(new Runnable() {
            public void run() {
                CopyOnWriteArrayList copyOnWriteArrayList = copyOnWriteArrayList2;
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    Iterator it = copyOnWriteArrayList2.iterator();
                    while (it.hasNext()) {
                        ((o0o0o00000) it.next()).onResult(new o0o0ooo0oo(longValue, string, 2));
                    }
                }
            }
        });
    }

    private void O00000Oo(DeviceRespBean deviceRespBean, boolean z) {
        DeviceRespBean.DevModule wifi = deviceRespBean.getModuleMap().getWifi();
        if (wifi != null) {
            wifi.setIsOnline(z);
        }
        DeviceRespBean.DevModule zigbee = deviceRespBean.getModuleMap().getZigbee();
        if (zigbee != null) {
            zigbee.setIsOnline(z);
        }
    }

    private void O00000Oo(String str, JSONObject jSONObject) {
        L.d(O000000o, "dpInfoChanged");
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        if (jSONObject2 != null) {
            String string = jSONObject2.getString("eventType");
            if (!TextUtils.isEmpty(string) && "DP_NAME_UPDATE".equals(string)) {
                O000000o(jSONObject2.getString("devId"), jSONObject2.getIntValue("dpId"), jSONObject2.getString("name"));
                return;
            }
            return;
        }
        L.e(O000000o, "dpInfoChanged data is null.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void O00000Oo(final java.lang.String r5, com.alibaba.fastjson.JSONObject r6, java.util.List<com.tuya.smart.common.o0o0o00000> r7) {
        /*
            r4 = this;
            java.lang.String r7 = "type"
            java.lang.String r7 = r6.getString(r7)
            java.lang.String r0 = "data"
            com.alibaba.fastjson.JSONObject r6 = r6.getJSONObject(r0)
            java.lang.String r0 = "devId"
            java.lang.String r6 = r6.getString(r0)
            int r0 = r7.hashCode()
            r1 = -331869833(0xffffffffec381177, float:-8.900993E26)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x003c
            r1 = 96417(0x178a1, float:1.35109E-40)
            if (r0 == r1) goto L_0x0032
            r1 = 99339(0x1840b, float:1.39204E-40)
            if (r0 == r1) goto L_0x0028
            goto L_0x0046
        L_0x0028:
            java.lang.String r0 = "del"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0046
            r7 = 2
            goto L_0x0047
        L_0x0032:
            java.lang.String r0 = "add"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0046
            r7 = 1
            goto L_0x0047
        L_0x003c:
            java.lang.String r0 = "bat_add"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0046
            r7 = 0
            goto L_0x0047
        L_0x0046:
            r7 = -1
        L_0x0047:
            java.lang.String r0 = "mqtt protocol"
            if (r7 == 0) goto L_0x00a0
            if (r7 == r3) goto L_0x0077
            if (r7 == r2) goto L_0x0050
            goto L_0x00b9
        L_0x0050:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r1 = "delete: "
            r7.append(r1)
            r7.append(r5)
            java.lang.String r1 = " subDev: "
            r7.append(r1)
            r7.append(r6)
            java.lang.String r7 = r7.toString()
            com.tuya.smart.android.common.utils.L.d(r0, r7)
            com.tuya.smart.common.o0o0o0000o r7 = com.tuya.smart.common.oO00O0o0.O000000o()
            r7.O000000o((java.lang.String) r6)
            com.tuya.smart.common.o0O0O00O.O00000o0(r5, r6)
            goto L_0x00b9
        L_0x0077:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r1 = "add: "
            r7.append(r1)
            r7.append(r5)
            java.lang.String r1 = "subDev:"
            r7.append(r1)
            r7.append(r6)
            java.lang.String r7 = r7.toString()
            com.tuya.smart.android.common.utils.L.d(r0, r7)
            com.tuya.smart.common.oOo0oooO r7 = com.tuya.smart.common.oOo0oooO.O000000o()
            com.tuya.smart.common.oO00O0Oo$3 r0 = new com.tuya.smart.common.oO00O0Oo$3
            r0.<init>(r5, r6)
            r7.querySubDev(r5, r6, r0)
            goto L_0x00b9
        L_0x00a0:
            java.lang.String r6 = "bat_add: bat_add"
            com.tuya.smart.android.common.utils.L.d(r0, r6)
            java.lang.Class<com.tuya.smart.common.o0o00o00o0> r6 = com.tuya.smart.common.o0o00o00o0.class
            java.lang.Object r6 = com.tuya.smart.common.Oo0.O000000o(r6)
            com.tuya.smart.common.o0o00o00o0 r6 = (com.tuya.smart.common.o0o00o00o0) r6
            com.tuya.smart.common.o0o0o000oo r6 = r6.O0000Ooo()
            com.tuya.smart.common.oO00O0Oo$2 r7 = new com.tuya.smart.common.oO00O0Oo$2
            r7.<init>(r5)
            r6.O00000Oo((java.lang.String) r5, (com.tuya.smart.sdk.api.ITuyaDataCallback<java.util.List<com.tuya.smart.sdk.bean.DeviceBean>>) r7)
        L_0x00b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.oO00O0Oo.O00000Oo(java.lang.String, com.alibaba.fastjson.JSONObject, java.util.List):void");
    }

    private void O00000Oo(String str, JSONObject jSONObject, final CopyOnWriteArrayList<o0o0o00000> copyOnWriteArrayList) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        if (jSONObject2 != null) {
            String string = jSONObject2.getString("devId");
            String string2 = jSONObject2.getString("triggerUid");
            int intValue = jSONObject2.getIntValue("warnLevel");
            String string3 = jSONObject2.getString("productId");
            long longValue = jSONObject2.getLong("latestWarnTime").longValue();
            long longValue2 = jSONObject2.getLong("id").longValue();
            final WarnMessageBean warnMessageBean = new WarnMessageBean();
            warnMessageBean.setDevId(string);
            warnMessageBean.setLastProdWarnId(longValue2);
            warnMessageBean.setLatestWarnTime(longValue);
            warnMessageBean.setUid(string2);
            warnMessageBean.setWarnLevel(intValue);
            warnMessageBean.setProductId(string3);
            this.O00000Oo.post(new Runnable() {
                public void run() {
                    CopyOnWriteArrayList copyOnWriteArrayList = copyOnWriteArrayList;
                    if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                        Iterator it = copyOnWriteArrayList.iterator();
                        while (it.hasNext()) {
                            ((o0o0o00000) it.next()).onResult(new o0oo0000oo(warnMessageBean));
                        }
                    }
                }
            });
            o0O0O00O.O000000o(warnMessageBean);
        }
    }

    private void O00000o(String str, JSONObject jSONObject) {
        L.d(O000000o, "gwInfoChanged");
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        if (jSONObject2 != null) {
            String string = jSONObject2.getString("meshId");
            if (!TextUtils.isEmpty(string)) {
                L.d(O000000o, "meshId:" + string + " on off line");
                oOo0oooO.O000000o().querySubDev(string, jSONObject2.getString("devId"), (ITuyaDataCallback<DeviceBean>) null);
            } else if (oOo0oooO.O000000o().getDev(jSONObject2.getString(o0ooo00oo.O00000o0)) == null) {
            } else {
                if (jSONObject2.containsKey("name")) {
                    String string2 = jSONObject2.getString(o0ooo00oo.O00000o0);
                    String string3 = jSONObject2.getString("devId");
                    if (TextUtils.isEmpty(string2)) {
                        string2 = string3;
                    }
                    DeviceRespBean O000000o2 = oOo0oooO.O000000o().O000000o(string2);
                    O000000o2.setName(jSONObject2.getString("name"));
                    oOo0oooO.O000000o().addDevList(Collections.singletonList(O000000o2));
                    L.d(O000000o, "deviceInfoUpdate: " + string2);
                    o0O0O00O.O000000o(string2);
                    return;
                }
                L.d(O000000o, "queryDev by gwInfoChanged");
                oOo0oooO.O000000o().queryDev(jSONObject2.getString(o0ooo00oo.O00000o0));
            }
        } else {
            oOo0oooO.O000000o().queryDev(str);
        }
    }

    private void O00000o(String str, JSONObject jSONObject, List<o0o0o00000> list) {
        int i;
        OtaProgressEventBean otaProgressEventBean = (OtaProgressEventBean) jSONObject.getObject("data", OtaProgressEventBean.class);
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        if (jSONObject2.get("firmwareType") != null) {
            Object obj = jSONObject2.get("firmwareType");
            i = (obj instanceof String ? Integer.valueOf((String) obj) : (Integer) obj).intValue();
        } else {
            i = -1;
        }
        if (i == -1) {
            RomUpdateProgressEventBean romUpdateProgressEventBean = (RomUpdateProgressEventBean) jSONObject.getObject("data", RomUpdateProgressEventBean.class);
            if (oO00O0o0.O000000o().O00000Oo(romUpdateProgressEventBean.getGwId()) == null) {
                L.d(O000000o, "dealWithDeviceTopicUnSigned dev ==null");
            } else {
                o0O0O00O.O000000o(romUpdateProgressEventBean);
            }
        } else {
            if (TextUtils.isEmpty(otaProgressEventBean.getDevId())) {
                otaProgressEventBean.setMeshId(str);
            }
            L.d(O000000o, "topicId: " + str);
            o0O0O00O.O000000o(otaProgressEventBean);
        }
    }

    private void O00000o(String str, JSONObject jSONObject, CopyOnWriteArrayList<o0o0o00000> copyOnWriteArrayList) {
        final JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        final Integer integer = jSONObject.getInteger(o0ooo00oo.O00000oo);
        final CopyOnWriteArrayList<o0o0o00000> copyOnWriteArrayList2 = copyOnWriteArrayList;
        final JSONObject jSONObject3 = jSONObject;
        final String str2 = str;
        this.O00000Oo.post(new Runnable() {
            public void run() {
                CopyOnWriteArrayList copyOnWriteArrayList = copyOnWriteArrayList2;
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    Iterator it = copyOnWriteArrayList2.iterator();
                    while (it.hasNext()) {
                        o0o0o00000 o0o0o00000 = (o0o0o00000) it.next();
                        if (jSONObject3 != null) {
                            o0o0o00000.onResult(new o0o0oo0ooo(str2, jSONObject2, integer));
                        }
                    }
                }
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void O00000o0(com.alibaba.fastjson.JSONObject r10, java.util.concurrent.CopyOnWriteArrayList<com.tuya.smart.common.o0o0o00000> r11) {
        /*
            r9 = this;
            java.lang.String r0 = "type"
            java.lang.String r0 = r10.getString(r0)
            java.lang.String r1 = "data"
            com.alibaba.fastjson.JSONObject r10 = r10.getJSONObject(r1)
            java.lang.String r1 = "id"
            java.lang.Long r1 = r10.getLong(r1)
            long r6 = r1.longValue()
            java.lang.String r1 = "name"
            java.lang.String r8 = r10.getString(r1)
            int r10 = r0.hashCode()
            r1 = 96417(0x178a1, float:1.35109E-40)
            r2 = 0
            r3 = -1
            r4 = 1
            if (r10 == r1) goto L_0x0038
            r1 = 99339(0x1840b, float:1.39204E-40)
            if (r10 == r1) goto L_0x002e
            goto L_0x0042
        L_0x002e:
            java.lang.String r10 = "del"
            boolean r10 = r0.equals(r10)
            if (r10 == 0) goto L_0x0042
            r10 = 0
            goto L_0x0043
        L_0x0038:
            java.lang.String r10 = "add"
            boolean r10 = r0.equals(r10)
            if (r10 == 0) goto L_0x0042
            r10 = 1
            goto L_0x0043
        L_0x0042:
            r10 = -1
        L_0x0043:
            if (r10 == 0) goto L_0x0049
            if (r10 == r4) goto L_0x004a
            r4 = -1
            goto L_0x004a
        L_0x0049:
            r4 = 0
        L_0x004a:
            android.os.Handler r10 = r9.O00000Oo
            com.tuya.smart.common.oO00O0Oo$14 r0 = new com.tuya.smart.common.oO00O0Oo$14
            r2 = r0
            r3 = r9
            r5 = r11
            r2.<init>(r4, r5, r6, r8)
            r10.post(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.oO00O0Oo.O00000o0(com.alibaba.fastjson.JSONObject, java.util.concurrent.CopyOnWriteArrayList):void");
    }

    private void O00000o0(DeviceRespBean deviceRespBean, boolean z) {
        DeviceRespBean.DevModule bluetooth = deviceRespBean.getModuleMap().getBluetooth();
        if (bluetooth != null) {
            bluetooth.setIsOnline(z);
        }
    }

    private void O00000o0(String str, JSONObject jSONObject) {
        L.d(O000000o, "deviceInfoChanged");
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        if (jSONObject2 == null) {
            oOo0oooO.O000000o().queryDev(str, new ITuyaDataCallback<DeviceBean>() {
                /* renamed from: O000000o */
                public void onSuccess(DeviceBean deviceBean) {
                    StringBuilder n = a.n("deviceBean devId:");
                    n.append(deviceBean.getDevId());
                    n.append(" online: ");
                    n.append(deviceBean.getIsOnline());
                    L.d(oO00O0Oo.O000000o, n.toString());
                }

                public void onError(String str, String str2) {
                    a.v("errorCode: ", str, oO00O0Oo.O000000o);
                }
            });
        } else if (oOo0oooO.O000000o().getDev(jSONObject2.getString("devId")) != null) {
            String string = jSONObject2.getString(o0ooo00oo.O00000o0);
            String string2 = jSONObject2.getString("devId");
            if (TextUtils.isEmpty(string)) {
                string = string2;
            }
            boolean z = false;
            DeviceRespBean O000000o2 = oOo0oooO.O000000o().O000000o(string);
            if (jSONObject2.containsKey("name")) {
                O000000o2.setName(jSONObject2.getString("name"));
                o0O0O00O.O000000o(string);
                L.d(O000000o, "deviceInfoUpdate: " + string);
            }
            if (jSONObject2.containsKey("online")) {
                Boolean bool = jSONObject2.getBoolean("online");
                DeviceRespBean.DevModule wifi = O000000o2.getModuleMap().getWifi();
                if (wifi != null) {
                    wifi.setIsOnline(bool.booleanValue());
                }
                z = true;
                L.d(O000000o, "onlineStatus: " + bool);
            }
            if (z) {
                oOo0oooO.O000000o().addDevList(Collections.singletonList(O000000o2));
            }
        }
    }

    private void O00000o0(String str, JSONObject jSONObject, final List<o0o0o00000> list) {
        final long j;
        String string = jSONObject.getString("type");
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        try {
            j = Long.valueOf(str).longValue();
        } catch (Exception unused) {
            j = -1;
        }
        final String str2 = null;
        if (jSONObject2 != null) {
            str2 = jSONObject2.getString(o0ooo00oo.O00000o0);
        }
        char c2 = 65535;
        int hashCode = string.hashCode();
        if (hashCode != 96417) {
            if (hashCode != 96673) {
                if (hashCode == 99339 && string.equals("del")) {
                    c2 = 0;
                }
            } else if (string.equals(ProviderConfigurationPermission.ALL_STR)) {
                c2 = 2;
            }
        } else if (string.equals("add")) {
            c2 = 1;
        }
        if (c2 == 0) {
            L.d(O000000o, "devId: " + str2);
            DeviceBean O00000Oo2 = oO00O0o0.O000000o().O00000Oo(str2);
            if (O00000Oo2 != null && O00000Oo2.isZigBeeWifi()) {
                L.d(O000000o, "zigBee");
                for (DeviceBean devId : oO00O0o0.O000000o().O00000o(str2)) {
                    o0O0O00O.O00000o0(str2, devId.getDevId());
                }
            }
            oO00O0o0.O000000o().O000000o(str2);
            o0O0O00O.O000000o(j, str2);
        } else if (c2 == 1) {
            oOo0oooO.O000000o().queryDev(str2, new ITuyaDataCallback<DeviceBean>() {
                /* renamed from: O000000o */
                public void onSuccess(DeviceBean deviceBean) {
                    StringBuilder n = a.n("query device: ");
                    n.append(deviceBean.getDevId());
                    L.d(oO00O0Oo.O000000o, n.toString());
                    if (deviceBean.isZigBeeWifi()) {
                        StringBuilder n2 = a.n("query ZigBee subDevList: ");
                        n2.append(deviceBean.getDevId());
                        L.d(oO00O0Oo.O000000o, n2.toString());
                        oOo0oooO.O000000o().O000000o(str2, (ITuyaDataCallback<List<DeviceBean>>) new ITuyaDataCallback<List<DeviceBean>>() {
                            /* renamed from: O000000o */
                            public void onSuccess(List<DeviceBean> list) {
                                StringBuilder n = a.n("query ZigBee subDevList success :");
                                n.append(list.size());
                                L.d(oO00O0Oo.O000000o, n.toString());
                                for (DeviceBean next : list) {
                                    StringBuilder n2 = a.n("subDeviceAdd: ");
                                    n2.append(str2);
                                    n2.append(":");
                                    n2.append(next.getDevId());
                                    n2.append(" online: ");
                                    n2.append(next.getIsOnline());
                                    L.d(oO00O0Oo.O000000o, n2.toString());
                                    o0O0O00O.O00000o(str2, next.getDevId());
                                }
                            }

                            public void onError(String str, String str2) {
                                L.d(oO00O0Oo.O000000o, "query ZigBee subDevList failure : errorCode: " + str + "errorMessage:" + str2);
                            }
                        });
                    }
                    StringBuilder n3 = a.n("homeID: ");
                    n3.append(j);
                    n3.append("gwId: ");
                    n3.append(str2);
                    n3.append(" online: ");
                    n3.append(deviceBean.getIsOnline());
                    L.d(oO00O0Oo.O000000o, n3.toString());
                    o0O0O00O.O00000Oo(j, str2);
                }

                public void onError(String str, String str2) {
                }
            });
        } else if (c2 == 2) {
            this.O00000Oo.post(new Runnable() {
                public void run() {
                    List list = list;
                    if (list != null && !list.isEmpty()) {
                        for (o0o0o00000 onResult : list) {
                            onResult.onResult(new o0o0o0oooo());
                        }
                    }
                }
            });
        }
    }

    private void O00000o0(String str, JSONObject jSONObject, CopyOnWriteArrayList<o0o0o00000> copyOnWriteArrayList) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        if (jSONObject2 != null) {
            Long l = jSONObject2.getLong(TuyaApiParams.KEY_GID);
            String string = jSONObject2.getString("dpId");
            String string2 = jSONObject2.getString("name");
            long parseLong = Long.parseLong(str);
            GroupRespBean O00000o0 = o0O000Oo.O000000o().O00000o0(l.longValue());
            O00000o0.getDpName().put(string, string2);
            o0O000Oo.O000000o().O000000o(O00000o0);
            O000000o(parseLong, Long.valueOf(O00000o0.getId()), 2, copyOnWriteArrayList);
            return;
        }
        L.e(O000000o, "dpInfoChanged data is null.");
    }

    private void O00000oO(final String str, JSONObject jSONObject, final List<o0o0o00000> list) {
        final byte[] decodeBase64 = Base64.decodeBase64(((CloudControlRawBean) jSONObject.getObject("data", CloudControlRawBean.class)).getRaw().getBytes());
        if (L.getLogStatus()) {
            L.d(O000000o, HexUtil.bytesToHexString(decodeBase64));
        }
        this.O00000Oo.post(new Runnable() {
            public void run() {
                List list = list;
                if (list != null && !list.isEmpty()) {
                    for (o0o0o00000 onResult : list) {
                        onResult.onResult(new o0o0oo0o0o(str, decodeBase64));
                    }
                }
            }
        });
    }

    private void O00000oO(String str, JSONObject jSONObject, CopyOnWriteArrayList<o0o0o00000> copyOnWriteArrayList) {
        final JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        final Integer integer = jSONObject.getInteger(o0ooo00oo.O00000oo);
        final CopyOnWriteArrayList<o0o0o00000> copyOnWriteArrayList2 = copyOnWriteArrayList;
        final JSONObject jSONObject3 = jSONObject;
        final String str2 = str;
        this.O00000Oo.post(new Runnable() {
            public void run() {
                CopyOnWriteArrayList copyOnWriteArrayList = copyOnWriteArrayList2;
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    Iterator it = copyOnWriteArrayList2.iterator();
                    while (it.hasNext()) {
                        o0o0o00000 o0o0o00000 = (o0o0o00000) it.next();
                        if (jSONObject3 != null) {
                            o0o0o00000.onResult(new o0o0oo0oo0(str2, jSONObject2, integer));
                        }
                    }
                }
            }
        });
    }

    private void O00000oo(String str, JSONObject jSONObject, List<o0o0o00000> list) {
        Protocol_25_DataBean protocol_25_DataBean = (Protocol_25_DataBean) jSONObject.getObject("data", Protocol_25_DataBean.class);
        final List<String> offline = protocol_25_DataBean.getOffline();
        final List<String> online = protocol_25_DataBean.getOnline();
        final String devId = protocol_25_DataBean.getDevId();
        O000000o(str, offline, false);
        O000000o(str, online, true);
        o0O0O00O.O00000Oo();
        final List<o0o0o00000> list2 = list;
        final String str2 = str;
        this.O00000Oo.post(new Runnable() {
            public void run() {
                List list = list2;
                if (list != null && !list.isEmpty()) {
                    for (o0o0o00000 onResult : list2) {
                        onResult.onResult(new o0o0oo0o00(str2, devId, online, offline));
                    }
                }
            }
        });
    }

    private void O00000oo(String str, JSONObject jSONObject, CopyOnWriteArrayList<o0o0o00000> copyOnWriteArrayList) {
        if (jSONObject != null && copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            final int intValue = jSONObject.getIntValue("action");
            final ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("rets");
                if (jSONArray != null) {
                    for (int i = 0; i < jSONArray.size(); i++) {
                        arrayList.add((Integer) jSONArray.get(i));
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            final String string = jSONObject.getString(TuyaApiParams.KEY_GID);
            final CopyOnWriteArrayList<o0o0o00000> copyOnWriteArrayList2 = copyOnWriteArrayList;
            final String str2 = str;
            this.O00000Oo.post(new Runnable() {
                public void run() {
                    Iterator it = copyOnWriteArrayList2.iterator();
                    while (it.hasNext()) {
                        ((o0o0o00000) it.next()).onResult(new o0o0oo000o(intValue, str2, string, arrayList));
                    }
                }
            });
        }
    }

    private void O0000O0o(String str, JSONObject jSONObject, List<o0o0o00000> list) {
    }

    private void O0000O0o(String str, JSONObject jSONObject, final CopyOnWriteArrayList<o0o0o00000> copyOnWriteArrayList) {
        final PublishQueryBean2_1 publishQueryBean2_1 = (PublishQueryBean2_1) JSON.toJavaObject(jSONObject, PublishQueryBean2_1.class);
        StringBuilder n = a.n("onSuccessWithProtocol2:");
        n.append(publishQueryBean2_1.getData());
        L.d(O000000o, n.toString());
        this.O00000Oo.post(new Runnable() {
            public void run() {
                CopyOnWriteArrayList copyOnWriteArrayList = copyOnWriteArrayList;
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    Iterator it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        ((o0o0o00000) it.next()).onResult(new o0o0oo00o0(JSON.toJSONString(publishQueryBean2_1.getData())));
                    }
                }
            }
        });
    }

    private void O0000OOo(String str, JSONObject jSONObject, CopyOnWriteArrayList<o0o0o00000> copyOnWriteArrayList) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        final Integer integer = jSONObject.getInteger(o0ooo00oo.O00000oo);
        final String string = jSONObject2.getString("etype");
        final String string2 = jSONObject2.getString("edata");
        final CopyOnWriteArrayList<o0o0o00000> copyOnWriteArrayList2 = copyOnWriteArrayList;
        final String str2 = str;
        this.O00000Oo.post(new Runnable() {
            public void run() {
                CopyOnWriteArrayList copyOnWriteArrayList = copyOnWriteArrayList2;
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    Iterator it = copyOnWriteArrayList2.iterator();
                    while (it.hasNext()) {
                        ((o0o0o00000) it.next()).onResult(new o0o0oooo0o(str2, integer, string, string2));
                    }
                }
            }
        });
    }

    private void O0000Oo(String str, JSONObject jSONObject, CopyOnWriteArrayList<o0o0o00000> copyOnWriteArrayList) {
        if (jSONObject != null) {
            try {
                O000000o(Long.valueOf(str).longValue(), jSONObject.getJSONObject("data").getString("dps"), true, copyOnWriteArrayList);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void O0000Oo0(String str, JSONObject jSONObject, CopyOnWriteArrayList<o0o0o00000> copyOnWriteArrayList) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("data").getJSONObject("data");
        final String string = jSONObject2.getString("type");
        final String string2 = jSONObject2.getString("link");
        final long longValue = jSONObject.getLong(o0ooo00oo.O00000oo).longValue();
        L.i(O000000o, "dealProtocol52: " + string + ";   link: " + string2 + ";  t: " + longValue);
        final CopyOnWriteArrayList<o0o0o00000> copyOnWriteArrayList2 = copyOnWriteArrayList;
        this.O00000Oo.post(new Runnable() {
            public void run() {
                CopyOnWriteArrayList copyOnWriteArrayList = copyOnWriteArrayList2;
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    Iterator it = copyOnWriteArrayList2.iterator();
                    while (it.hasNext()) {
                        ((o0o0o00000) it.next()).onResult(new o0oo00000o(string, string2, longValue));
                    }
                }
            }
        });
    }

    private void O0000OoO(String str, JSONObject jSONObject, final CopyOnWriteArrayList<o0o0o00000> copyOnWriteArrayList) {
        ITuyaDataCallback iTuyaDataCallback;
        oOo0oooO ooo0oooo;
        String string = jSONObject.getString("type");
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        final long parseLong = Long.parseLong(str);
        Long l = jSONObject2.getLong("id");
        if (l != null) {
            char c2 = 65535;
            int hashCode = string.hashCode();
            if (hashCode != -838846263) {
                if (hashCode != 96417) {
                    if (hashCode == 99339 && string.equals("del")) {
                        c2 = 2;
                    }
                } else if (string.equals("add")) {
                    c2 = 1;
                }
            } else if (string.equals("update")) {
                c2 = 0;
            }
            if (c2 == 0) {
                ooo0oooo = oOo0oooO.O000000o();
                iTuyaDataCallback = new ITuyaDataCallback<GroupBean>() {
                    /* renamed from: O000000o */
                    public void onSuccess(GroupBean groupBean) {
                        oO00O0Oo.this.O000000o(parseLong, Long.valueOf(groupBean.getId()), 2, (CopyOnWriteArrayList<o0o0o00000>) copyOnWriteArrayList);
                    }

                    public void onError(String str, String str2) {
                    }
                };
            } else if (c2 == 1) {
                ooo0oooo = oOo0oooO.O000000o();
                iTuyaDataCallback = new ITuyaDataCallback<GroupBean>() {
                    /* renamed from: O000000o */
                    public void onSuccess(GroupBean groupBean) {
                        oO00O0Oo.this.O000000o(parseLong, Long.valueOf(groupBean.getId()), 1, (CopyOnWriteArrayList<o0o0o00000>) copyOnWriteArrayList);
                    }

                    public void onError(String str, String str2) {
                    }
                };
            } else if (c2 == 2) {
                o0O000Oo.O000000o().O00000Oo(l.longValue());
                O000000o(parseLong, l, 0, copyOnWriteArrayList);
                return;
            } else {
                return;
            }
            ooo0oooo.O000000o(l, (ITuyaDataCallback<GroupBean>) iTuyaDataCallback);
        }
    }

    private void O0000Ooo(String str, JSONObject jSONObject, CopyOnWriteArrayList<o0o0o00000> copyOnWriteArrayList) {
        if (jSONObject != null && copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            final int intValue = jSONObject.getIntValue("action");
            JSONArray jSONArray = jSONObject.getJSONArray("cids");
            final ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.size(); i++) {
                arrayList.add((String) jSONArray.get(i));
            }
            final ArrayList arrayList2 = new ArrayList();
            try {
                JSONArray jSONArray2 = jSONObject.getJSONArray("rets");
                if (jSONArray2 != null) {
                    for (int i2 = 0; i2 < jSONArray2.size(); i2++) {
                        arrayList2.add((Integer) jSONArray2.get(i2));
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            final String string = jSONObject.getString(TuyaApiParams.KEY_SESSION);
            final String string2 = jSONObject.getString(TuyaApiParams.KEY_GID);
            final CopyOnWriteArrayList<o0o0o00000> copyOnWriteArrayList2 = copyOnWriteArrayList;
            final String str2 = str;
            this.O00000Oo.post(new Runnable() {
                public void run() {
                    Iterator it = copyOnWriteArrayList2.iterator();
                    while (it.hasNext()) {
                        ((o0o0o00000) it.next()).onResult(new o0o0oo00oo(str2, intValue, string, string2, arrayList, arrayList2));
                    }
                }
            });
        }
    }

    private void O0000o0(final String str, JSONObject jSONObject, final CopyOnWriteArrayList<o0o0o00000> copyOnWriteArrayList) {
        final List<BlueMeshBatchReportBean> parseArray = JSON.parseArray(jSONObject.getJSONArray("data").toJSONString(), BlueMeshBatchReportBean.class);
        for (BlueMeshBatchReportBean next : parseArray) {
            oO00O0o0.O000000o().O000000o(str, next.getCid(), next.getDps());
        }
        this.O00000Oo.post(new Runnable() {
            public void run() {
                CopyOnWriteArrayList copyOnWriteArrayList = copyOnWriteArrayList;
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    Iterator it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        ((o0o0o00000) it.next()).onResult(new o0o0ooo000(str, parseArray));
                    }
                }
            }
        });
    }

    private void O0000o00(String str, JSONObject jSONObject, CopyOnWriteArrayList<o0o0o00000> copyOnWriteArrayList) {
        String string = jSONObject.getString("type");
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        final long parseLong = str.startsWith("m/ug/") ? Long.parseLong(str.replace("m/ug/", "")) : -1;
        final String string2 = jSONObject2.getString("meshId");
        char c2 = 65535;
        if (string.hashCode() == 96417 && string.equals("add")) {
            c2 = 0;
        }
        if (c2 == 0) {
            final CopyOnWriteArrayList<o0o0o00000> copyOnWriteArrayList2 = copyOnWriteArrayList;
            this.O00000Oo.post(new Runnable() {
                public void run() {
                    CopyOnWriteArrayList copyOnWriteArrayList = copyOnWriteArrayList2;
                    if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                        Iterator it = copyOnWriteArrayList2.iterator();
                        while (it.hasNext()) {
                            ((o0o0o00000) it.next()).onResult(new o0o0ooo00o(parseLong, string2, true));
                        }
                    }
                }
            });
        }
    }

    public void O000000o(int i, String str, JSONObject jSONObject, HashMap<Class, CopyOnWriteArrayList<o0o0o00000>> hashMap) {
        Class<o0o0ooo0oo> cls = o0o0ooo0oo.class;
        Class<o0o0ooo0o0> cls2 = o0o0ooo0o0.class;
        L.d(O000000o, "protocol: " + i + " topicId: " + str + " data: " + jSONObject.toJSONString());
        if (i == 0) {
            O00000o0(str, jSONObject, (List<o0o0o00000>) hashMap.get(o0o0o0oooo.class));
        } else if (i == 1) {
            O00000o(str, jSONObject);
        } else if (i == 3) {
            O00000o0(str, jSONObject);
        } else if (i == 4) {
            O000000o(str, jSONObject, hashMap.get(o0o0oooooo.class), hashMap);
        } else if (i == 29) {
            O00000oO(str, jSONObject, (List<o0o0o00000>) hashMap.get(o0o0oo0o0o.class));
        } else if (i == 30) {
            O0000o0(str, jSONObject, hashMap.get(o0o0ooo000.class));
        } else if (i == 39) {
            O00000o0(jSONObject, hashMap.get(cls));
        } else if (i == 40) {
            O00000Oo(jSONObject, hashMap.get(cls));
        } else if (i == 43) {
            O0000OOo(str, jSONObject, hashMap.get(o0o0oooo0o.class));
        } else if (i != 44) {
            switch (i) {
                case 9:
                    O00000Oo(jSONObject);
                    return;
                case 14:
                    o0O0O00O.O000000o();
                    return;
                case 16:
                    O00000o(str, jSONObject, (List<o0o0o00000>) hashMap.get(o0oo000o00.class));
                    return;
                case 23:
                    O0000O0o(str, jSONObject, hashMap.get(o0o0oo00o0.class));
                    return;
                case 25:
                    O00000oo(str, jSONObject, (List<o0o0o00000>) hashMap.get(o0o0oo0o00.class));
                    return;
                case 37:
                    O0000OoO(str, jSONObject, hashMap.get(cls2));
                    return;
                case 47:
                    O0000Oo(str, jSONObject, hashMap.get(o0o0ooooo0.class));
                    return;
                case 50:
                    O00000Oo(str, jSONObject);
                    return;
                case 56:
                    O00000Oo(str, jSONObject, hashMap.get(o0oo0000oo.class));
                    return;
                case 201:
                    O000000o(str, hashMap.get(o0o0oo0000.class));
                    return;
                case o0oO0Ooo.O000O0Oo:
                    O00000oo(str, jSONObject.getJSONObject("data"), hashMap.get(o0o0oo000o.class));
                    return;
                case 205:
                    O0000Ooo(str, jSONObject.getJSONObject("data"), hashMap.get(o0o0oo00oo.class));
                    return;
                case o0oO0Ooo.O000Oo0O:
                    O00000oO(str, jSONObject, hashMap.get(o0o0oo0oo0.class));
                    return;
                case 308:
                    O00000o(str, jSONObject, hashMap.get(o0o0oo0ooo.class));
                    return;
                case o0oO0Ooo.O000OOOo:
                    O000000o(jSONObject, hashMap.get(o0o0oooo00.class));
                    return;
                case o0oO0Ooo.O00O0Oo:
                    O0000O0o(str, jSONObject, (List<o0o0o00000>) hashMap.get(o0oo000000.class));
                    return;
                default:
                    switch (i) {
                        case 33:
                            O00000Oo(str, jSONObject, (List<o0o0o00000>) hashMap.get(o0oo000oo0.class));
                            return;
                        case 34:
                            O000000o(str, jSONObject, (List<o0o0o00000>) hashMap.get(o0oo000ooo.class));
                            return;
                        case 35:
                            O0000o00(str, jSONObject, hashMap.get(o0o0ooo00o.class));
                            return;
                        default:
                            switch (i) {
                                case 52:
                                    O0000Oo0(str, jSONObject, hashMap.get(o0oo00000o.class));
                                    return;
                                case 53:
                                    O00000o0(str, jSONObject, hashMap.get(cls2));
                                    return;
                                case 54:
                                    O000000o(str, jSONObject, hashMap.get(o0oo0000o0.class));
                                    return;
                                default:
                                    o0O0O00O.O000000o(i, str, jSONObject);
                                    return;
                            }
                    }
            }
        } else {
            O000000o(str, jSONObject);
        }
    }
}
