package com.tuya.sdk.tuyamesh.blemesh.action;

import a.a.a.a.a;
import a.e.a.a.o.j.e;
import com.tuya.smart.common.o00o0oo0oo;
import com.tuya.smart.common.o00oo0o00o;
import com.tuya.smart.common.o00oo0oo00;

public class OtaAction$3 implements e {
    public final /* synthetic */ o00o0oo0oo this$0;

    public OtaAction$3(o00o0oo0oo o00o0oo0oo) {
        this.this$0 = o00o0oo0oo;
    }

    public void onResponse(int i, byte[] bArr) {
        StringBuilder n = a.n("update finish consume time ");
        n.append(System.currentTimeMillis() - this.this$0.O0000Ooo);
        o00oo0oo00.O00000Oo(o00o0oo0oo.O000000o, n.toString());
        o00oo0oo00.O000000o(o00o0oo0oo.O000000o, "last read packet response : " + o00oo0o00o.O00000Oo(bArr, ":"));
        this.this$0.O0000O0o();
        this.this$0.O00000oO();
        o00o0oo0oo.O000000o o000000o = this.this$0.O0000OOo;
        if (o000000o != null) {
            o000000o.O000000o();
        }
    }
}
