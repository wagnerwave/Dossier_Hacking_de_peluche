package com.tuya.smart.common;

import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.sdk.api.bluemesh.IBlueMeshActivatorListener;
import com.tuya.smart.sdk.api.bluemesh.ITuyaBlueMeshActivator;
import com.tuya.smart.sdk.bean.DeviceBean;

public class O0o0000 {
    public static final int O000000o = 50;
    public static final int O00000Oo = 51;
    public static final String O00000o0 = "CheckDeviceActivatorStatus";
    public ITuyaBlueMeshActivator O00000o;

    public void O000000o() {
        ITuyaBlueMeshActivator iTuyaBlueMeshActivator = this.O00000o;
        if (iTuyaBlueMeshActivator != null) {
            iTuyaBlueMeshActivator.stopActivator();
        }
    }

    public void O000000o(String str, final O0Oo000 o0Oo000) {
        ITuyaBlueMeshActivator O000000o2 = O0OoOo.O000000o(str, new IBlueMeshActivatorListener() {
            public void onFailure(String str, String str2) {
                O0Oo000 o0Oo000 = o0Oo000;
                if (o0Oo000 != null) {
                    o0Oo000.O000000o(str, str2);
                }
            }

            public void onStep(String str, Object obj) {
                L.d(O0o0000.O00000o0, "step: " + str + "devId" + obj);
            }

            public void onSuccess(DeviceBean deviceBean) {
                O0Oo000 o0Oo000 = o0Oo000;
                if (o0Oo000 != null) {
                    o0Oo000.O000000o(deviceBean);
                }
            }
        });
        this.O00000o = O000000o2;
        O000000o2.startActivator();
    }
}
