package com.tuya.sdk.sigmesh.action;

import a.a.a.a.a;
import a.e.a.a.o.j.i;
import com.tuya.smart.common.o00oo0oo00;
import com.tuya.smart.common.ooo0ooo00;

public class SigOtaAction$8 implements i {
    public final /* synthetic */ ooo0ooo00 this$0;

    public SigOtaAction$8(ooo0ooo00 ooo0ooo00) {
        this.this$0 = ooo0ooo00;
    }

    public void onResponse(int i) {
        StringBuilder n = a.n("update finish consume time ");
        n.append(System.currentTimeMillis() - this.this$0.O0000Ooo);
        o00oo0oo00.O00000Oo(ooo0ooo00.O0000o00, n.toString());
        o00oo0oo00.O000000o(ooo0ooo00.O0000o00, "last read packet response code: " + i);
        this.this$0.O0000O0o();
        this.this$0.O00000oO();
        if (this.this$0.O0000OOo != null) {
            this.this$0.O0000OOo.O000000o();
        }
    }
}
