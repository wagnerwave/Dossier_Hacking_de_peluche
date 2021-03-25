package com.tuya.sdk.bluemesh.mesh.presenter;

import a.e.a.a.o.h.b;
import com.tuya.smart.common.OO00O;

public class TuyaBlueMeshConnectImpl$1 extends b {
    public final /* synthetic */ OO00O this$0;

    public TuyaBlueMeshConnectImpl$1(OO00O oo00o) {
        this.this$0 = oo00o;
    }

    public void onBluetoothStateChanged(boolean z) {
        if (z && !this.this$0.O0000Oo && !this.this$0.O0000o00) {
            if (this.this$0.O0000Oo0 != null) {
                this.this$0.O0000Oo0.O00000o0();
            }
            this.this$0.O0000Oo0();
        } else if (!z && this.this$0.O0000Oo0 != null) {
            this.this$0.O0000Oo0.O00000o0();
        }
    }
}
