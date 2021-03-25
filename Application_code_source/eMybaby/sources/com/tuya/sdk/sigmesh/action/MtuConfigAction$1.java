package com.tuya.sdk.sigmesh.action;

import a.e.a.a.o.j.c;
import com.tuya.smart.common.o00oo0o0o0;
import com.tuya.smart.common.ooo00oo0o;

public class MtuConfigAction$1 implements c {
    public final /* synthetic */ ooo00oo0o this$0;

    public MtuConfigAction$1(ooo00oo0o ooo00oo0o) {
        this.this$0 = ooo00oo0o;
    }

    public void onResponse(int i, Integer num) {
        if (this.this$0.O00000o0 == null) {
            return;
        }
        if (i == 0) {
            this.this$0.O00000o0.O000000o(num);
        } else {
            this.this$0.O00000o0.O000000o(o00oo0o0o0.O0000o0O, "request mtu fail");
        }
    }
}
