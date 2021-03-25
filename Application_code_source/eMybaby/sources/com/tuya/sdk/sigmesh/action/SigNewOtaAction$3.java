package com.tuya.sdk.sigmesh.action;

import a.e.a.a.o.j.i;
import com.tuya.smart.common.ooo0oo0oo;

public class SigNewOtaAction$3 implements i {
    public final /* synthetic */ ooo0oo0oo this$0;

    public SigNewOtaAction$3(ooo0oo0oo ooo0oo0oo) {
        this.this$0 = ooo0oo0oo;
    }

    public void onResponse(int i) {
        if (i != 0) {
            this.this$0.O0000O0o();
            if (this.this$0.O0000OOo != null) {
                this.this$0.O0000OOo.O000000o(String.valueOf(i), "command ota data fail");
            }
        }
    }
}
