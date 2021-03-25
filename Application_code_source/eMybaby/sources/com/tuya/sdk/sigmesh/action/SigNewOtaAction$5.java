package com.tuya.sdk.sigmesh.action;

import a.a.a.a.a;
import a.e.a.a.o.j.e;
import com.tuya.smart.common.O00o0;
import com.tuya.smart.common.o00oo0o00o;
import com.tuya.smart.common.o00oo0oo00;
import com.tuya.smart.common.ooo0oo0oo;

public class SigNewOtaAction$5 implements e {
    public final /* synthetic */ ooo0oo0oo this$0;
    public final /* synthetic */ O00o0 val$callback;

    public SigNewOtaAction$5(ooo0oo0oo ooo0oo0oo, O00o0 o00o0) {
        this.this$0 = ooo0oo0oo;
        this.val$callback = o00o0;
    }

    public void onResponse(int i, byte[] bArr) {
        String str;
        if (i != 0) {
            o00oo0oo00.O00000Oo(ooo0oo0oo.O00000Oo, "requestFirmware fail code:" + i);
            this.val$callback.O000000o(String.valueOf(i), "requestFirmware fail");
            return;
        }
        StringBuilder o = a.o("requestFirmware code:", i, "   data:");
        o.append(o00oo0o00o.O00000Oo(bArr, ":"));
        o00oo0oo00.O00000Oo(ooo0oo0oo.O00000Oo, o.toString());
        if (bArr.length > 4) {
            str = a.e.a.a.r.a.a(new byte[]{bArr[2]}) + "." + a.e.a.a.r.a.a(new byte[]{bArr[3]});
        } else {
            str = "";
        }
        this.val$callback.O000000o(str);
    }
}
