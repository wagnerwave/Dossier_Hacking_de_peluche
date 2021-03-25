package com.tuya.sdk.sigmesh.action;

import a.a.a.a.a;
import a.e.a.a.o.j.e;
import com.tuya.smart.common.o00oo0o00o;
import com.tuya.smart.common.o00oo0oo00;
import com.tuya.smart.common.ooo0ooo00;

public class SigOtaAction$10 implements e {
    public final /* synthetic */ ooo0ooo00 this$0;

    public SigOtaAction$10(ooo0ooo00 ooo0ooo00) {
        this.this$0 = ooo0ooo00;
    }

    public void onResponse(int i, byte[] bArr) {
        StringBuilder o = a.o("read response code:", i, "   data:");
        o.append(o00oo0o00o.O00000Oo(bArr, ":"));
        o00oo0oo00.O00000Oo(ooo0ooo00.O0000o00, o.toString());
        this.this$0.a_();
    }
}
