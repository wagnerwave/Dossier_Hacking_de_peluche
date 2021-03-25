package com.tuya.smart.common;

import android.text.TextUtils;
import com.tuya.sdk.bluemesh.bean.MeshRelationBean;
import com.tuya.sdk.bluemesh.bean.MeshSubDevWifiStatus;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class OooOO {
    public static final String O000000o = "MeshCloudStatusManager";
    public Map<String, Map<String, MeshSubDevWifiStatus>> O00000Oo;

    public static class O000000o {
        public static OooOO O000000o = new OooOO();
    }

    public OooOO() {
        this.O00000Oo = new HashMap();
        this.O00000Oo = new HashMap();
    }

    public static OooOO O000000o() {
        return O000000o.O000000o;
    }

    public void O000000o(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<DeviceBean> meshDeviceList = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)).O0000OOo().getMeshDeviceList(str);
        if (meshDeviceList != null) {
            for (DeviceBean next : meshDeviceList) {
                if (!next.isBleMeshWifi()) {
                    boolean O000000o2 = O000000o(str, next.getDevId());
                    String nodeId = next.getNodeId();
                    if (O000000o2) {
                        arrayList.add(nodeId);
                    } else {
                        arrayList2.add(nodeId);
                    }
                }
            }
            O0000o.O000000o(str, "", (List<String>) arrayList, (List<String>) arrayList2);
        }
    }

    public void O000000o(String str, String str2, String str3, boolean z) {
        Map map = this.O00000Oo.get(str);
        if (map == null) {
            map = new HashMap();
            this.O00000Oo.put(str, map);
        }
        MeshSubDevWifiStatus meshSubDevWifiStatus = (MeshSubDevWifiStatus) map.get(str3);
        if (meshSubDevWifiStatus == null) {
            meshSubDevWifiStatus = new MeshSubDevWifiStatus(str3);
            map.put(str3, meshSubDevWifiStatus);
        }
        meshSubDevWifiStatus.setDevCloudStatus(str2, z);
    }

    public void O000000o(String str, Map<String, List<MeshRelationBean>> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            for (MeshRelationBean meshRelationBean : (List) next.getValue()) {
                MeshSubDevWifiStatus meshSubDevWifiStatus = (MeshSubDevWifiStatus) hashMap.get(meshRelationBean.getNodeId());
                if (meshSubDevWifiStatus == null) {
                    meshSubDevWifiStatus = new MeshSubDevWifiStatus(meshRelationBean.getNodeId());
                    hashMap.put(meshRelationBean.getNodeId(), meshSubDevWifiStatus);
                }
                meshSubDevWifiStatus.setDevCloudStatus((String) next.getKey(), meshRelationBean.getIsOnline());
            }
        }
        this.O00000Oo.put(str, hashMap);
        L.e(O000000o, "meshSubDevWifiStatusList:" + this.O00000Oo.toString());
    }

    public boolean O000000o(String str, String str2) {
        DeviceBean deviceBean;
        MeshSubDevWifiStatus meshSubDevWifiStatus;
        Class cls = o0o00o00o0.class;
        DeviceBean deviceBean2 = Oo0.O000000o(cls) != null ? ((o0o00o00o0) Oo0.O000000o(cls)).O0000OOo().getDeviceBean(str2) : null;
        if (deviceBean2 == null || !deviceBean2.isBlueMesh()) {
            return deviceBean2 != null && !TextUtils.isEmpty(deviceBean2.getParentId()) && (deviceBean = ((o0o00o00o0) Oo0.O000000o(cls)).O0000OOo().getDeviceBean(deviceBean2.getParentId())) != null && deviceBean.isCloudOnline() && deviceBean2.isCloudOnline();
        }
        if (!this.O00000Oo.containsKey(str) || (meshSubDevWifiStatus = (MeshSubDevWifiStatus) this.O00000Oo.get(str).get(deviceBean2.getNodeId())) == null) {
            return false;
        }
        return meshSubDevWifiStatus.getCloudStatus();
    }
}
