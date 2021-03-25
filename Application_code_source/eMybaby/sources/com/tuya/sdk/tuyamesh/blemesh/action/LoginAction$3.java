package com.tuya.sdk.tuyamesh.blemesh.action;

import a.e.a.a.o.j.e;
import a.j.a.b;
import com.tuya.smart.common.o00o0oo00o;
import com.tuya.smart.common.o00oo00ooo;
import com.tuya.smart.common.o00oo0oo00;

public class LoginAction$3 implements e {
    public final /* synthetic */ o00o0oo00o this$0;

    public LoginAction$3(o00o0oo00o o00o0oo00o) {
        this.this$0 = o00o0oo00o;
    }

    public void onResponse(int i, byte[] bArr) {
        o00oo0oo00.O000000o(o00o0oo00o.O00000Oo, "login onResponse:" + i);
        this.this$0.O0000Oo.removeMessages(34);
        if (i != 0 || bArr[0] == b.BLE_GATT_OP_PAIR_ENC_FAIL.f()) {
            this.this$0.O000000o("13003", "encryption is not correct");
            return;
        }
        byte[] bArr2 = new byte[16];
        byte[] bArr3 = new byte[8];
        System.arraycopy(bArr, 1, bArr2, 0, 16);
        System.arraycopy(bArr, 1, bArr3, 0, 8);
        byte[] O000000o = o00oo00ooo.O000000o(this.this$0.O00000o0, this.this$0.O00000o, this.this$0.O00000oo, bArr3, bArr2);
        if (O000000o == null) {
            this.this$0.O000000o("13003", "sessionKey invalid");
        } else if (this.this$0.O00000oO != null) {
            this.this$0.O00000oO.O000000o(O000000o);
        }
    }
}
