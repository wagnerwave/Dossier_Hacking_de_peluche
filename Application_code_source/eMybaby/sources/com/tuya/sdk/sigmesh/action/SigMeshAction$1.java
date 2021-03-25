package com.tuya.sdk.sigmesh.action;

import a.e.a.a.o.j.i;
import com.tuya.smart.common.o00o0o0o0o;
import com.tuya.smart.common.ooo0oo000;

public class SigMeshAction$1 implements i {
    public final /* synthetic */ ooo0oo000 this$0;
    public final /* synthetic */ o00o0o0o0o.O000000o val$action;

    public SigMeshAction$1(ooo0oo000 ooo0oo000, o00o0o0o0o.O000000o o000000o) {
        this.this$0 = ooo0oo000;
        this.val$action = o000000o;
    }

    public void onResponse(int i) {
        if (i == 0) {
            o00o0o0o0o.O000000o o000000o = this.val$action;
            if (o000000o != null) {
                o000000o.O00000Oo();
                return;
            }
            return;
        }
        o00o0o0o0o.O000000o o000000o2 = this.val$action;
        if (o000000o2 != null) {
            o000000o2.O000000o("11005", "sendPdu fail " + i);
        }
    }
}
