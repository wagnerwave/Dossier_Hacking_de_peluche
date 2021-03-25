package com.tuya.sdk.tuyamesh.blemesh.action;

import a.e.a.a.o.j.i;
import com.tuya.sdk.tuyamesh.bean.CommandBean;
import com.tuya.smart.common.o00o0oo00o;
import com.tuya.smart.common.o00oo0oo00;

public class LoginAction$2 implements i {
    public final /* synthetic */ o00o0oo00o this$0;
    public final /* synthetic */ CommandBean val$rCmd;

    public LoginAction$2(o00o0oo00o o00o0oo00o, CommandBean commandBean) {
        this.this$0 = o00o0oo00o;
        this.val$rCmd = commandBean;
    }

    public void onResponse(int i) {
        o00oo0oo00.O000000o(o00o0oo00o.O00000Oo, "code" + i);
        if (i == 0) {
            o00o0oo00o o00o0oo00o = this.this$0;
            o00o0oo00o.O000000o(this.val$rCmd, o00o0oo00o.O0000OoO);
            return;
        }
        this.this$0.O000000o("login_error", "error:-1");
    }
}
