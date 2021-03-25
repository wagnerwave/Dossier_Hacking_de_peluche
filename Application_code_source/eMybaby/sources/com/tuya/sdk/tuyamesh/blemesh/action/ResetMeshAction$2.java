package com.tuya.sdk.tuyamesh.blemesh.action;

import a.e.a.a.o.j.i;
import com.tuya.sdk.tuyamesh.bean.CommandBean;
import com.tuya.smart.common.o00o0ooo00;

public class ResetMeshAction$2 implements i {
    public final /* synthetic */ o00o0ooo00 this$0;
    public final /* synthetic */ CommandBean val$ltkCmd;
    public final /* synthetic */ CommandBean val$pwdCmd;

    public ResetMeshAction$2(o00o0ooo00 o00o0ooo00, CommandBean commandBean, CommandBean commandBean2) {
        this.this$0 = o00o0ooo00;
        this.val$pwdCmd = commandBean;
        this.val$ltkCmd = commandBean2;
    }

    public void onResponse(int i) {
        this.this$0.O000000o(this.val$pwdCmd, (i) new i() {
            public void onResponse(int i) {
                ResetMeshAction$2 resetMeshAction$2 = ResetMeshAction$2.this;
                resetMeshAction$2.this$0.O000000o(resetMeshAction$2.val$ltkCmd, (i) new i() {
                    public void onResponse(int i) {
                        ResetMeshAction$2.this.this$0.O00000o0();
                    }
                });
            }
        });
    }
}
