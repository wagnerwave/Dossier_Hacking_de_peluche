package com.tuya.sdk.sigmesh.connect;

import a.e.a.a.o.j.a;
import com.inuker.bluetooth.library.model.BleGattProfile;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.common.O00OOo;
import com.tuya.smart.common.O00o;
import com.tuya.smart.common.o00oo0oo00;
import com.tuya.smart.common.oooo0o0o0;

public class ConnectSigMesh$5 implements a {
    public final /* synthetic */ oooo0o0o0 this$0;

    public ConnectSigMesh$5(oooo0o0o0 oooo0o0o0) {
        this.this$0 = oooo0o0o0;
    }

    public void onResponse(int i, BleGattProfile bleGattProfile) {
        o00oo0oo00.O00000Oo(oooo0o0o0.O0000O0o, "connect response: " + i);
        if (i != 0) {
            O00o O00000oO = this.this$0.O00000oO;
            SearchDeviceBean O000000o = this.this$0.O00000o0;
            O00000oO.O000000o(O000000o, O00OOo.O0000Oo, "connect fail " + i);
            this.this$0.O00000oo();
            return;
        }
        StringBuilder n = a.a.a.a.a.n("service size: ");
        n.append(bleGattProfile.a().size());
        o00oo0oo00.O00000Oo(oooo0o0o0.O0000O0o, n.toString());
        this.this$0.O00000oO.O000000o(bleGattProfile.a());
    }
}
