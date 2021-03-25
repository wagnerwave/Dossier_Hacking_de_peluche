package com.tuya.sdk.bluemesh.local.login;

import a.e.a.a.o.h.a;
import com.tuya.smart.common.O00OOo;
import com.tuya.smart.common.O00oo000;
import com.tuya.smart.common.o00oo0oo00;

public class ConnectAndLoginMesh$1 extends a {
    public final /* synthetic */ O00oo000 this$0;

    public ConnectAndLoginMesh$1(O00oo000 o00oo000) {
        this.this$0 = o00oo000;
    }

    public void onConnectStatusChanged(String str, int i) {
        o00oo0oo00.O000000o(O00oo000.O0000OOo, "onConnectStatusChanged: " + str + " status: " + i);
        if (i == 16) {
            o00oo0oo00.O000000o(O00oo000.O0000OOo, "connect onSuccess");
            this.this$0.O0000O0o.O000000o(this.this$0.O00000oO, O00OOo.O0000Oo0);
            this.this$0.O000000o(false);
        }
    }
}
