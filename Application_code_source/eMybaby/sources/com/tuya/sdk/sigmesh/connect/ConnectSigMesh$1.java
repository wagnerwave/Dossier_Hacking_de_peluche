package com.tuya.sdk.sigmesh.connect;

import a.e.a.a.o.j.a;
import com.inuker.bluetooth.library.model.BleGattProfile;
import com.tuya.smart.common.o00o0o0o0o;
import com.tuya.smart.common.o00oo0oo00;
import com.tuya.smart.common.oooo0o0o0;

public class ConnectSigMesh$1 implements a {
    public final /* synthetic */ oooo0o0o0 this$0;
    public final /* synthetic */ o00o0o0o0o.O000000o val$action;

    public ConnectSigMesh$1(oooo0o0o0 oooo0o0o0, o00o0o0o0o.O000000o o000000o) {
        this.this$0 = oooo0o0o0;
        this.val$action = o000000o;
    }

    public void onResponse(int i, BleGattProfile bleGattProfile) {
        if (this.val$action == null) {
            return;
        }
        if (i != 0) {
            o00oo0oo00.O00000Oo(oooo0o0o0.O0000O0o, "discoveryServices fail");
            this.val$action.O000000o(String.valueOf(i), "discoveryServices fail");
            return;
        }
        o00oo0oo00.O00000Oo(oooo0o0o0.O0000O0o, "discoveryServices success");
        this.val$action.O00000Oo();
    }
}
