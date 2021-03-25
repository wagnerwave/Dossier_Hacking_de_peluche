package com.tuya.sdk.tuyamesh.blemesh.action;

import a.a.a.a.a;
import a.e.a.a.o.j.e;
import com.tuya.smart.common.O00o0;
import com.tuya.smart.common.o00o0oo0oo;
import com.tuya.smart.common.o00oo0o00o;
import com.tuya.smart.common.o00oo0oo00;
import java.util.Arrays;

public class OtaAction$5 implements e {
    public final /* synthetic */ o00o0oo0oo this$0;
    public final /* synthetic */ O00o0 val$callback;

    public OtaAction$5(o00o0oo0oo o00o0oo0oo, O00o0 o00o0) {
        this.this$0 = o00o0oo0oo;
        this.val$callback = o00o0;
    }

    public void onResponse(int i, byte[] bArr) {
        if (i != 0) {
            this.val$callback.O000000o(String.valueOf(i), "requestFirmware fail");
            return;
        }
        StringBuilder o = a.o("requestFirmware code:", i, "   data:");
        o.append(o00oo0o00o.O00000Oo(bArr, ":"));
        o00oo0oo00.O00000Oo(o00o0oo0oo.O000000o, o.toString());
        this.val$callback.O000000o(a.e.a.a.r.a.a(Arrays.copyOf(bArr, 3)));
    }
}
