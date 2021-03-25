package com.tuya.sdk.tuyamesh.blemesh.action;

import a.e.a.a.o.j.e;
import a.j.a.b;
import com.tuya.smart.common.o00o0ooo00;
import com.tuya.smart.common.o00oo0oo00;

public class ResetMeshAction$3 implements e {
    public final /* synthetic */ o00o0ooo00 this$0;

    public ResetMeshAction$3(o00o0ooo00 o00o0ooo00) {
        this.this$0 = o00o0ooo00;
    }

    public void onResponse(int i, byte[] bArr) {
        o00oo0oo00.O000000o(o00o0ooo00.O00000o0, "check onResponse:" + i);
        this.this$0.O0000Oo.removeMessages(113);
        if (bArr == null || bArr[0] != b.BLE_GATT_OP_PAIR_CONFIRM.f() || !this.this$0.O000000o(bArr)) {
            this.this$0.O000000o("13004", "set mesh failure");
        } else {
            this.this$0.O00000o();
        }
    }
}
