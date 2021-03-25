package com.tuya.sdk.bluemesh.bean;

import a.a.a.a.a;
import com.tuya.sdk.timer.bean.DpTimerBean;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.common.Oo0;
import com.tuya.smart.common.o0o00o00o0;
import com.tuya.smart.sdk.bean.DeviceBean;
import java.util.HashMap;
import java.util.Map;

public class MeshSubDevWifiStatus {
    public static final String TAG = "MeshSubDevWifiStatus";
    public String nodeId;
    public Map<String, Boolean> wifiList = new HashMap();

    public MeshSubDevWifiStatus(String str) {
        this.nodeId = str;
    }

    public boolean getCloudStatus() {
        for (Map.Entry next : this.wifiList.entrySet()) {
            boolean booleanValue = ((Boolean) next.getValue()).booleanValue();
            DeviceBean deviceBean = ((o0o00o00o0) Oo0.O000000o(o0o00o00o0.class)).O0000OOo().getDeviceBean((String) next.getKey());
            if (deviceBean != null && deviceBean.isBleMeshWifi() && deviceBean.isCloudOnline() && booleanValue) {
                return true;
            }
        }
        return false;
    }

    public void setDevCloudStatus(String str, boolean z) {
        L.d(TAG, "setDevCloudStatus  gwId:" + str + DpTimerBean.FILL + z);
        this.wifiList.put(str, Boolean.valueOf(z));
    }

    public String toString() {
        StringBuilder n = a.n("MeshSubDevWifiStatus{nodeId='");
        a.x(n, this.nodeId, '\'', ", wifiList=");
        n.append(this.wifiList.toString());
        n.append('}');
        return n.toString();
    }
}
