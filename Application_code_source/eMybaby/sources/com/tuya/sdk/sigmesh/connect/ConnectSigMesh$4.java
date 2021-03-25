package com.tuya.sdk.sigmesh.connect;

import a.e.a.a.o.h.a;
import com.tuya.smart.common.O00OOo;
import com.tuya.smart.common.o00oo0oo00;
import com.tuya.smart.common.oooo0o0o0;

public class ConnectSigMesh$4 extends a {
    public final /* synthetic */ oooo0o0o0 this$0;

    public ConnectSigMesh$4(oooo0o0o0 oooo0o0o0) {
        this.this$0 = oooo0o0o0;
    }

    public void onConnectStatusChanged(String str, int i) {
        o00oo0oo00.O00000Oo(oooo0o0o0.O0000O0o, "onConnectStatusChanged: " + str + " status: " + i);
        if (i == 16) {
            o00oo0oo00.O000000o(oooo0o0o0.O0000O0o, "connect onSuccess");
            if (!this.this$0.O0000Oo0) {
                this.this$0.O00000oO.O000000o(this.this$0.O00000o0, O00OOo.O0000Oo0);
                this.this$0.O00000oO.O000000o(this.this$0.O00000o0, this.this$0.O00000oo);
            }
            boolean unused = this.this$0.O0000Oo0 = true;
        } else if (this.this$0.O0000Oo0) {
            o00oo0oo00.O00000Oo(oooo0o0o0.O0000O0o, "unknow error connect break off");
            this.this$0.O00000oO.O000000o(this.this$0.O00000o0, O00OOo.O000OoOo, "connect break off");
        }
    }
}
