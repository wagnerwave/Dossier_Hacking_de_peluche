package com.tuya.sdk.bluemesh.mesh.model;

import a.e.a.a.o.h.a;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.common.O0o00;
import com.tuya.smart.common.o00oo0o0o0;
import com.tuya.smart.mqtt.MqttServiceConstants;

public class MeshLogin$4 extends a {
    public final /* synthetic */ O0o00 this$0;

    public MeshLogin$4(O0o00 o0o00) {
        this.this$0 = o0o00;
    }

    public void onConnectStatusChanged(String str, int i) {
        L.d(O0o00.O0000Oo0, "mac: " + str + " status: " + i);
        if (i == 16) {
            O0o00 o0o00 = this.this$0;
            o0o00.O00000Oo(o0o00.O0000o0O, this.this$0.O0000o0o);
        } else if (i != 32) {
        } else {
            if (this.this$0.O0000oO0) {
                L.d(O0o00.O0000Oo0, "connecting not handle status");
                return;
            }
            this.this$0.resultError(243, o00oo0o0o0.O0000O0o, MqttServiceConstants.DISCONNECT_ACTION);
            this.this$0.O00000Oo(str);
        }
    }
}
