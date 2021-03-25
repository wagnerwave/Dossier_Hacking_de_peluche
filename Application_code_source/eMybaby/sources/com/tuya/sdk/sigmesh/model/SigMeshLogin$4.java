package com.tuya.sdk.sigmesh.model;

import a.e.a.a.o.j.a;
import com.inuker.bluetooth.library.model.BleGattProfile;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.common.o00o0o0o0o;
import com.tuya.smart.common.ooooo0o0o;

public class SigMeshLogin$4 implements a {
    public final /* synthetic */ ooooo0o0o this$0;
    public final /* synthetic */ o00o0o0o0o.O000000o val$action;

    public SigMeshLogin$4(ooooo0o0o ooooo0o0o, o00o0o0o0o.O000000o o000000o) {
        this.this$0 = ooooo0o0o;
        this.val$action = o000000o;
    }

    public void onResponse(int i, BleGattProfile bleGattProfile) {
        if (this.val$action == null) {
            return;
        }
        if (i != 0) {
            L.e(ooooo0o0o.O0000Oo, "discoveryServices fail");
            this.val$action.O000000o(String.valueOf(i), "discoveryServices fail");
            return;
        }
        L.e(ooooo0o0o.O0000Oo, "discoveryServices success");
        this.val$action.O00000Oo();
    }
}
