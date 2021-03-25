package com.tuya.sdk.tuyamesh.blemesh.action;

import a.e.a.a.o.j.i;
import com.tuya.smart.common.o00o0oo0oo;

public class OtaAction$1 implements i {
    public final /* synthetic */ o00o0oo0oo this$0;
    public final /* synthetic */ boolean val$finalIsLast;

    public OtaAction$1(o00o0oo0oo o00o0oo0oo, boolean z) {
        this.this$0 = o00o0oo0oo;
        this.val$finalIsLast = z;
    }

    public void onResponse(int i) {
        if (i != 0) {
            this.this$0.O0000O0o();
            o00o0oo0oo.O000000o o000000o = this.this$0.O0000OOo;
            if (o000000o != null) {
                o000000o.O000000o(String.valueOf(i), "command ota data fail");
                return;
            }
            return;
        }
        if (this.val$finalIsLast) {
            this.this$0.O00000oo();
        } else {
            this.this$0.a_();
        }
        this.this$0.O00000oO();
    }
}
