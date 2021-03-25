package com.tuya.sdk.sigmesh.presenter;

import a.e.a.a.o.h.b;
import com.tuya.smart.common.o000000o0o;

public class TuyaSigMeshConnectImpl$1 extends b {
    public final /* synthetic */ o000000o0o this$0;

    public TuyaSigMeshConnectImpl$1(o000000o0o o000000o0o) {
        this.this$0 = o000000o0o;
    }

    public void onBluetoothStateChanged(boolean z) {
        if (z && !this.this$0.O0000OoO && !this.this$0.O0000oO0) {
            this.this$0.O0000Oo0();
            this.this$0.O0000Oo();
        } else if (!z) {
            this.this$0.O0000Oo0();
        }
    }
}
