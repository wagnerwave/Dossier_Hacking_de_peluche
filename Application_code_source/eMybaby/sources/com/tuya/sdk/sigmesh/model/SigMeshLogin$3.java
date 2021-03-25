package com.tuya.sdk.sigmesh.model;

import a.e.a.a.o.h.a;
import com.tuya.sdk.sigmesh.bean.TuyaSigMeshBean;
import com.tuya.smart.android.blemesh.bean.MeshClientStatusEnum;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.common.o00oo00ooo;
import com.tuya.smart.common.o00oo0o0o0;
import com.tuya.smart.common.o00oo0ooo0;
import com.tuya.smart.common.ooooo0o0o;
import com.tuya.smart.mqtt.MqttServiceConstants;
import com.tuya.smart.sdk.bean.DeviceBean;

public class SigMeshLogin$3 extends a {
    public final /* synthetic */ ooooo0o0o this$0;

    public SigMeshLogin$3(ooooo0o0o ooooo0o0o) {
        this.this$0 = ooooo0o0o;
    }

    public void onConnectStatusChanged(String str, int i) {
        L.d(ooooo0o0o.O0000Oo, "mac: " + str + " status: " + i);
        if (i == 16) {
            L.d(ooooo0o0o.O0000Oo, "Login onSuccess");
            this.this$0.O000000o(MeshClientStatusEnum.CONNECTED);
            DeviceBean meshSubDevBeanByMac = this.this$0.O0000o0o.getMeshSubDevBeanByMac(o00oo00ooo.O00000Oo(this.this$0.O0000o0O.getMacAdress()));
            ooooo0o0o ooooo0o0o = this.this$0;
            TuyaSigMeshBean unused = ooooo0o0o.O0000Ooo = o00oo0ooo0.O000000o(ooooo0o0o.O0000Ooo, this.this$0.O0000o0O, meshSubDevBeanByMac);
            ooooo0o0o ooooo0o0o2 = this.this$0;
            ooooo0o0o2.resultSuccess(ooooo0o0o.O00000oO, ooooo0o0o2.O0000o0O);
        } else if (i != 32) {
        } else {
            if (this.this$0.O0000oO0) {
                L.d(ooooo0o0o.O0000Oo, "connecting not handle status");
                return;
            }
            this.this$0.resultError(ooooo0o0o.O00000Oo, o00oo0o0o0.O0000O0o, MqttServiceConstants.DISCONNECT_ACTION);
            this.this$0.O00000Oo(str);
        }
    }
}
