package com.tuya.sdk.sigmesh.action;

import a.e.a.a.o.j.i;
import com.tuya.smart.common.ooo0oo0oo;

public class SigNewOtaAction$4 implements i {
    public final /* synthetic */ ooo0oo0oo this$0;
    public final /* synthetic */ int val$index;
    public final /* synthetic */ byte[][] val$packetData;
    public final /* synthetic */ i val$response;

    public SigNewOtaAction$4(ooo0oo0oo ooo0oo0oo, i iVar, byte[][] bArr, int i) {
        this.this$0 = ooo0oo0oo;
        this.val$response = iVar;
        this.val$packetData = bArr;
        this.val$index = i;
    }

    public void onResponse(int i) {
        if (i != 0) {
            i iVar = this.val$response;
            if (iVar != null) {
                iVar.onResponse(-1);
                return;
            }
            return;
        }
        this.this$0.O000000o(this.val$packetData, this.val$index + 1, this.val$response);
    }
}
