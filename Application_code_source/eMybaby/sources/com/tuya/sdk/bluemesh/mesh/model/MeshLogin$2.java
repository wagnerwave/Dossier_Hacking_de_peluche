package com.tuya.sdk.bluemesh.mesh.model;

import a.e.a.a.o.j.a;
import com.inuker.bluetooth.library.model.BleGattProfile;
import com.tuya.sdk.timer.bean.DpTimerBean;
import com.tuya.smart.android.blemesh.bean.MeshClientStatusEnum;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.common.O0o00;
import com.tuya.smart.common.o00oo0o0o0;

public class MeshLogin$2 implements a {
    public final /* synthetic */ O0o00 this$0;
    public final /* synthetic */ String val$macAddress;

    public MeshLogin$2(O0o00 o0o00, String str) {
        this.this$0 = o0o00;
        this.val$macAddress = str;
    }

    public void onResponse(int i, BleGattProfile bleGattProfile) {
        StringBuilder o = a.a.a.a.a.o("connect code: ", i, "   ");
        o.append(this.val$macAddress);
        o.append(DpTimerBean.FILL);
        o.append(this);
        L.e(O0o00.O0000Oo0, o.toString());
        boolean unused = this.this$0.O0000oO0 = false;
        if (i != 0) {
            this.this$0.O000000o(MeshClientStatusEnum.INIT);
            this.this$0.resultError(O0o00.O00000o, o00oo0o0o0.O0000OOo, "connect failure");
        }
    }
}
