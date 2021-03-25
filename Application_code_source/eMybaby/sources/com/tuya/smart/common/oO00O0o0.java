package com.tuya.smart.common;

import a.a.a.a.a;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.android.hardware.bean.HgwBean;
import com.tuya.smart.interior.device.bean.DevResp;
import com.tuya.smart.interior.device.bean.DeviceRespBean;
import com.tuya.smart.interior.device.bean.GwDevResp;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.smart.sdk.bean.DeviceBean;
import com.tuya.smart.sdk.bean.ProductBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class oO00O0o0 implements o0o0o0000o {
    public static final String O00000Oo = "smart/mb/in/";
    public static volatile oO00O0o0 O00000o = null;
    public static final String O00000o0 = "TuyaDevListCacheManager";
    public Map<String, DeviceRespBean> O000000o = new ConcurrentHashMap();

    public static o0o0o0000o O000000o() {
        if (O00000o == null) {
            synchronized (oO00O0o0.class) {
                if (O00000o == null) {
                    O00000o = new oO00O0o0();
                }
            }
        }
        return O00000o;
    }

    private synchronized void O000000o(Map<String, DeviceRespBean> map) {
        this.O000000o.clear();
        this.O000000o.putAll(map);
    }

    private void O000000o(Map<String, DeviceRespBean> map, List<DeviceRespBean> list) {
        o0o00o0oo0 o0o00o0oo0;
        for (DeviceRespBean next : list) {
            if (TextUtils.isEmpty(next.getMeshId()) && (o0o00o0oo0 = (o0o00o0oo0) Oo0.O000000o(o0o00o0oo0.class)) != null) {
                o0oo0oo000 O000000o2 = o0o00o0oo0.O000000o();
                StringBuilder n = a.n("smart/mb/in/");
                n.append(next.getDevId());
                O000000o2.O00000Oo(n.toString(), (IResultCallback) null);
            }
            map.put(next.getDevId(), next);
            if (!next.isDecodeRawed()) {
                L.d(O00000o0, "decodeRaw success");
                oOO0OO0O.O00000o(next.getProductId(), next.getDps());
                next.setDecodeRawed(true);
            } else {
                L.d(O00000o0, "dps decoded ");
            }
        }
    }

    private DeviceBean O00000Oo(DeviceRespBean deviceRespBean) {
        ProductBean O000000o2;
        if (deviceRespBean == null || (O000000o2 = oO0O00Oo.O000000o().O000000o(deviceRespBean.getProductId())) == null) {
            return null;
        }
        return O000000o(deviceRespBean, O000000o2);
    }

    private void O00000Oo(Map<String, DeviceRespBean> map) {
        this.O000000o.putAll(map);
    }

    private synchronized void O00000o0(List<DeviceRespBean> list) {
        L.d(O00000o0, "devRespList start" + list.size());
        HashMap hashMap = new HashMap();
        O000000o((Map<String, DeviceRespBean>) hashMap, list);
        O000000o((Map<String, DeviceRespBean>) hashMap);
        for (DeviceRespBean devId : list) {
            oO0O0Oo0.O000000o(devId.getDevId());
        }
    }

    private DeviceRespBean O00000oO(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.O000000o.get(str);
        }
        L.d(O00000o0, "getFromGwMap gwId == null");
        return null;
    }

    private boolean O00000oo(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.O000000o.containsKey(str);
        }
        L.d(O00000o0, "checkGwFromMap gwId == null");
        return false;
    }

    private DeviceRespBean O0000O0o(String str) {
        if (TextUtils.isEmpty(str)) {
            L.d(O00000o0, "removeFromGWMap gwId == null");
            return null;
        }
        DeviceBean O00000Oo2 = O00000Oo(str);
        if (O00000Oo2 != null && O00000Oo2.isZigBeeWifi()) {
            for (DeviceBean devId : O000000o().O00000o(str)) {
                this.O000000o.remove(devId.getDevId());
            }
        }
        return this.O000000o.remove(str);
    }

    private void O0000OOo(String str) {
        L.d(O00000o0, "deleteGwConnect devId: " + str);
        oOo0o0oO.O000000o(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x000a, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x000a, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tuya.smart.interior.device.bean.DeviceRespBean O000000o(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            java.util.Map<java.lang.String, com.tuya.smart.interior.device.bean.DeviceRespBean> r0 = r5.O000000o
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x000a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0097
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r1 = r1.getValue()
            com.tuya.smart.interior.device.bean.DeviceRespBean r1 = (com.tuya.smart.interior.device.bean.DeviceRespBean) r1
            java.lang.String r2 = r1.getNodeId()     // Catch:{ Exception -> 0x0058 }
            r3 = 16
            int r2 = java.lang.Integer.parseInt(r2, r3)     // Catch:{ Exception -> 0x0058 }
            int r3 = java.lang.Integer.parseInt(r7, r3)     // Catch:{ Exception -> 0x0058 }
            java.lang.String r4 = r1.getMeshId()     // Catch:{ Exception -> 0x0058 }
            boolean r4 = android.text.TextUtils.equals(r4, r6)     // Catch:{ Exception -> 0x0058 }
            if (r4 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x0037
            return r1
        L_0x0037:
            java.lang.String r4 = r1.getMeshId()     // Catch:{ Exception -> 0x0058 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0058 }
            if (r4 != 0) goto L_0x000a
            java.lang.String r4 = r1.getMeshId()     // Catch:{ Exception -> 0x0058 }
            com.tuya.smart.sdk.bean.DeviceBean r4 = r5.O00000Oo((java.lang.String) r4)     // Catch:{ Exception -> 0x0058 }
            if (r4 == 0) goto L_0x000a
            java.lang.String r4 = r4.getMeshId()     // Catch:{ Exception -> 0x0058 }
            boolean r4 = android.text.TextUtils.equals(r4, r6)     // Catch:{ Exception -> 0x0058 }
            if (r4 == 0) goto L_0x000a
            if (r2 != r3) goto L_0x000a
            return r1
        L_0x0058:
            java.lang.String r2 = r1.getMeshId()
            boolean r2 = android.text.TextUtils.equals(r2, r6)
            if (r2 == 0) goto L_0x006e
            java.lang.String r2 = r1.getNodeId()
            boolean r2 = android.text.TextUtils.equals(r7, r2)
            if (r2 == 0) goto L_0x006e
            return r1
        L_0x006e:
            java.lang.String r2 = r1.getMeshId()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x000a
            java.lang.String r2 = r1.getMeshId()
            com.tuya.smart.sdk.bean.DeviceBean r2 = r5.O00000Oo((java.lang.String) r2)
            if (r2 == 0) goto L_0x000a
            java.lang.String r2 = r2.getMeshId()
            boolean r2 = android.text.TextUtils.equals(r2, r6)
            if (r2 == 0) goto L_0x000a
            java.lang.String r2 = r1.getNodeId()
            boolean r2 = android.text.TextUtils.equals(r7, r2)
            if (r2 == 0) goto L_0x000a
            return r1
        L_0x0097:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.oO00O0o0.O000000o(java.lang.String, java.lang.String):com.tuya.smart.interior.device.bean.DeviceRespBean");
    }

    public DeviceBean O000000o(DeviceRespBean deviceRespBean, ProductBean productBean) {
        DeviceBean deviceBean = new DeviceBean();
        deviceBean.setLocalKey(deviceRespBean.getLocalKey());
        deviceBean.setIsShare(Boolean.valueOf(deviceRespBean.getIsShare()));
        deviceBean.setTime(deviceRespBean.getActiveTime());
        deviceBean.setDevId(deviceRespBean.getDevId());
        deviceBean.setParentId(deviceRespBean.getMeshId());
        DeviceRespBean O00000o02 = !TextUtils.isEmpty(deviceRespBean.getMeshId()) ? O00000o0(deviceRespBean.getMeshId()) : null;
        deviceBean.setMeshId((O00000o02 == null || TextUtils.isEmpty(O00000o02.getMeshId())) ? deviceRespBean.getMeshId() : O00000o02.getMeshId());
        deviceBean.setNodeId(deviceRespBean.getNodeId());
        deviceBean.setDps(deviceRespBean.getDps());
        deviceBean.setName(deviceRespBean.getName());
        deviceBean.setProductId(deviceRespBean.getProductId());
        deviceBean.setTimezoneId(deviceRespBean.getTimezoneId());
        deviceBean.setDisplayOrder(deviceRespBean.getDisplayOrder());
        deviceBean.setHomeDisplayOrder(deviceRespBean.getHomeDisplayOrder());
        deviceBean.setErrorCode(deviceRespBean.getErrorCode());
        deviceBean.setDpMaxTime(deviceRespBean.getDpMaxTime());
        deviceBean.setSkills(deviceRespBean.getSkills());
        deviceBean.setLon(deviceRespBean.getLon());
        deviceBean.setLat(deviceRespBean.getLat());
        deviceBean.setDpName(deviceRespBean.getDpName());
        deviceBean.setDevKey(deviceRespBean.getDevKey());
        deviceBean.setMac(deviceRespBean.getMac());
        DeviceRespBean.ModuleMap moduleMap = deviceRespBean.getModuleMap();
        int i = 0;
        DeviceRespBean.DevModule zigbee = deviceRespBean.getModuleMap().getZigbee();
        if (zigbee == null) {
            zigbee = deviceRespBean.getModuleMap().getInfrared();
        }
        if (moduleMap.getBluetooth() != null) {
            if (moduleMap.getWifi() != null) {
                zigbee = moduleMap.getWifi();
                i = 2;
            } else {
                i = 5;
                zigbee = moduleMap.getBluetooth();
            }
        } else if (moduleMap.getWifi() != null) {
            if (moduleMap.getMcu() == null) {
                i = 4;
            }
            zigbee = moduleMap.getWifi();
        } else if (moduleMap.getGprs() != null) {
            i = 6;
            zigbee = moduleMap.getGprs();
        } else if (moduleMap.getSubpieces() != null) {
            zigbee = moduleMap.getSubpieces();
        }
        if (zigbee != null) {
            deviceBean.setPv(zigbee.getPv());
            deviceBean.setBv(zigbee.getBv());
            deviceBean.setVerSw(zigbee.getVerSw());
            deviceBean.setIsOnline(Boolean.valueOf(zigbee.getIsOnline()));
            deviceBean.setCadv(zigbee.getCadv());
        }
        deviceBean.setProductBean(productBean);
        o0o00o0o00 o0o00o0o00 = (o0o00o0o00) Oo0.O000000o(o0o00o0o00.class);
        if (o0o00o0o00 != null) {
            deviceBean.setHgwBean(o0o00o0o00.O000000o().O00000Oo(deviceRespBean.getDevId()));
        }
        deviceBean.setPanelConfig(productBean.getPanelConfig());
        deviceBean.setRuntimeEnv(deviceRespBean.getRuntimeEnv());
        deviceBean.setAbility(i);
        deviceBean.setVirtual(deviceRespBean.isVirtual());
        deviceBean.setUuid(deviceRespBean.getUuid());
        deviceBean.setIconUrl(deviceRespBean.getIconUrl());
        deviceBean.setGwType(deviceRespBean.isVirtual() ? "v" : "s");
        deviceBean.setDevAttribute(deviceRespBean.getDevAttribute());
        return deviceBean;
    }

    public DeviceBean O000000o(GwDevResp gwDevResp) {
        DeviceBean deviceBean = new DeviceBean();
        deviceBean.setDevId(gwDevResp.getGwId());
        deviceBean.setVerSw(gwDevResp.getVerSw());
        deviceBean.setAbility(gwDevResp.getAbility());
        deviceBean.setIconUrl(gwDevResp.getIconUrl());
        deviceBean.setIsOnline(gwDevResp.getIsOnline());
        deviceBean.setName(gwDevResp.getName());
        deviceBean.setUuid(gwDevResp.getUuid());
        deviceBean.setIsShare(gwDevResp.getIsShare());
        deviceBean.setTime(gwDevResp.getTime());
        deviceBean.setPv(gwDevResp.getPv());
        deviceBean.setBv(gwDevResp.getBv());
        deviceBean.setLat(gwDevResp.getLat());
        deviceBean.setRuntimeEnv(gwDevResp.getRuntimeEnv());
        deviceBean.setLon(gwDevResp.getLon());
        deviceBean.setLocalKey(gwDevResp.getLocalKey());
        deviceBean.setGwType(gwDevResp.getGwType());
        if (TextUtils.isEmpty(deviceBean.getDevId())) {
            deviceBean.setDevId(gwDevResp.getId());
        }
        List<DevResp> devices = gwDevResp.getDevices();
        if (devices != null && devices.size() > 0) {
            DevResp devResp = devices.get(0);
            ProductBean.SchemaInfo schemaInfo = new ProductBean.SchemaInfo();
            schemaInfo.setSchema(devResp.getSchema());
            schemaInfo.setSchemaExt(devResp.getSchemaExt());
            deviceBean.setSchema(schemaInfo.getSchema());
            deviceBean.setSchemaExt(schemaInfo.getSchemaExt());
            deviceBean.setSchemaMap(schemaInfo.getSchemaMap());
            deviceBean.setUiConfig(devResp.getUiConfig());
            deviceBean.setUi(devResp.getUi());
            deviceBean.setPanelConfig(devResp.getPanelConfig());
            deviceBean.setAttribute((long) devResp.getAttribute());
            deviceBean.setDisplayDps(devResp.getDisplayDps());
            deviceBean.setDisplayMsgs(devResp.getDisplayMsgs());
            deviceBean.setAppRnVersion(devResp.getAppRnVersion());
            deviceBean.setDps(devResp.getDps());
            deviceBean.setFaultDps(devResp.getFaultDps());
            deviceBean.setI18nTime(devResp.getI18nTime());
            deviceBean.setIconUrl(devResp.getIconUrl());
            deviceBean.setQuickOpDps(devResp.getQuickOpDps());
            deviceBean.setIsOnline(devResp.getIsOnline());
            deviceBean.setRnFind(devResp.getRnFind());
            deviceBean.setProductId(devResp.getProductId());
            deviceBean.setUiName(devResp.getUiName());
            deviceBean.setUiPhase(devResp.getUiPhase());
            deviceBean.setSwitchDp(devResp.getSwitchDp());
            deviceBean.setUiType(devResp.getUiType());
            deviceBean.setSupportGroup(devResp.isSupportGroup());
        }
        return deviceBean;
    }

    public void O000000o(DeviceRespBean deviceRespBean) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(deviceRespBean);
        O000000o((Map<String, DeviceRespBean>) hashMap, (List<DeviceRespBean>) arrayList);
        O00000Oo((Map<String, DeviceRespBean>) hashMap);
        oO0O0Oo0.O000000o(deviceRespBean.getDevId());
    }

    public void O000000o(DeviceRespBean deviceRespBean, Map<String, Object> map) {
        if (deviceRespBean != null) {
            if (deviceRespBean.getDps() == null) {
                deviceRespBean.setDps(new HashMap());
            }
            for (Map.Entry next : map.entrySet()) {
                deviceRespBean.getDps().put(next.getKey(), next.getValue());
            }
        }
    }

    public void O000000o(String str, String str2, Map<String, Object> map) {
        O000000o(O000000o(str, str2), map);
    }

    public void O000000o(List<DeviceRespBean> list) {
        if (L.getLogStatus()) {
            StringBuilder n = a.n("updateDevList: ");
            n.append(JSON.toJSONString(list));
            L.d(O00000o0, n.toString());
        }
        O00000o0(list);
    }

    public boolean O000000o(HgwBean hgwBean) {
        return (hgwBean == null || TextUtils.isEmpty(hgwBean.getGwId()) || this.O000000o.get(hgwBean.getGwId()) == null) ? false : true;
    }

    public boolean O000000o(String str) {
        O0000OOo(str);
        return (this.O000000o == null || O0000O0o(str) == null) ? false : true;
    }

    public DeviceRespBean O00000Oo(String str, String str2) {
        DeviceBean O00000Oo2;
        for (Map.Entry<String, DeviceRespBean> value : this.O000000o.entrySet()) {
            DeviceRespBean deviceRespBean = (DeviceRespBean) value.getValue();
            String str3 = "";
            str2 = TextUtils.isEmpty(str2) ? str3 : str2.toLowerCase();
            if (!TextUtils.isEmpty(deviceRespBean.getMac())) {
                str3 = deviceRespBean.getMac().toLowerCase();
            }
            if (TextUtils.equals(deviceRespBean.getMeshId(), str) && TextUtils.equals(str2, str3)) {
                return deviceRespBean;
            }
            if (!TextUtils.isEmpty(deviceRespBean.getMeshId()) && (O00000Oo2 = O00000Oo(deviceRespBean.getMeshId())) != null && TextUtils.equals(O00000Oo2.getMeshId(), str) && TextUtils.equals(str2, str3)) {
                return deviceRespBean;
            }
        }
        return null;
    }

    public DeviceBean O00000Oo(String str) {
        ProductBean O000000o2;
        DeviceRespBean O00000oO = O00000oO(str);
        if (O00000oO == null || (O000000o2 = oO0O00Oo.O000000o().O000000o(O00000oO.getProductId())) == null) {
            return null;
        }
        return O000000o(O00000oO, O000000o2);
    }

    public void O00000Oo() {
        this.O000000o.clear();
    }

    public synchronized void O00000Oo(List<DeviceRespBean> list) {
        if (L.getLogStatus()) {
            L.d(O00000o0, "addDevList: " + JSON.toJSONString(list));
        }
        HashMap hashMap = new HashMap();
        O000000o((Map<String, DeviceRespBean>) hashMap, list);
        this.O000000o.putAll(hashMap);
        for (DeviceRespBean devId : list) {
            oO0O0Oo0.O000000o(devId.getDevId());
        }
    }

    public DeviceBean O00000o(String str, String str2) {
        return O00000Oo(O00000Oo(str, str2));
    }

    public List<DeviceRespBean> O00000o() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, DeviceRespBean> value : this.O000000o.entrySet()) {
            arrayList.add(value.getValue());
        }
        return arrayList;
    }

    public List<DeviceBean> O00000o(String str) {
        DeviceBean O00000Oo2;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, DeviceRespBean> value : this.O000000o.entrySet()) {
            DeviceRespBean deviceRespBean = (DeviceRespBean) value.getValue();
            if (TextUtils.equals(deviceRespBean.getMeshId(), str)) {
                O00000Oo2 = O00000Oo(deviceRespBean);
                if (O00000Oo2 == null) {
                }
            } else if (!TextUtils.isEmpty(deviceRespBean.getMeshId())) {
                DeviceBean O00000Oo3 = O00000Oo(deviceRespBean.getMeshId());
                if (O00000Oo3 != null) {
                    if (TextUtils.equals(O00000Oo3.getMeshId(), str)) {
                        O00000Oo2 = O00000Oo(deviceRespBean);
                        if (O00000Oo2 == null) {
                        }
                    }
                }
            }
            arrayList.add(O00000Oo2);
        }
        return arrayList;
    }

    public DeviceRespBean O00000o0(String str) {
        return this.O000000o.get(str);
    }

    public DeviceBean O00000o0(String str, String str2) {
        return O00000Oo(O000000o(str, str2));
    }

    public List<DeviceBean> O00000o0() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, DeviceRespBean> value : this.O000000o.entrySet()) {
            DeviceRespBean deviceRespBean = (DeviceRespBean) value.getValue();
            ProductBean O000000o2 = oO0O00Oo.O000000o().O000000o(deviceRespBean.getProductId());
            if (O000000o2 != null) {
                arrayList.add(O000000o(deviceRespBean, O000000o2));
            }
        }
        return arrayList;
    }
}
