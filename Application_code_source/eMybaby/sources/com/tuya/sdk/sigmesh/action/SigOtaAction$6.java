package com.tuya.sdk.sigmesh.action;

import a.e.a.a.o.j.i;
import com.tuya.smart.common.ooo0ooo00;

public class SigOtaAction$6 implements i {
    public final /* synthetic */ ooo0ooo00 this$0;

    public SigOtaAction$6(ooo0ooo00 ooo0ooo00) {
        this.this$0 = ooo0ooo00;
    }

    public void onResponse(int i) {
        if (i != 0) {
            this.this$0.O0000O0o();
            if (this.this$0.O0000OOo != null) {
                this.this$0.O0000OOo.O000000o(String.valueOf(i), "command ota data fail");
                return;
            }
            return;
        }
        this.this$0.O0000o0();
    }
}
