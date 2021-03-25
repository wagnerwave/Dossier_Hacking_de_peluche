package com.tuya.sdk.bluemesh.local.login;

import a.e.a.a.o.j.a;
import com.inuker.bluetooth.library.model.BleGattProfile;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.common.O00OOo;
import com.tuya.smart.common.O00o;
import com.tuya.smart.common.O00oo000;
import com.tuya.smart.common.o00oo0oo00;

public class ConnectAndLoginMesh$2 implements a {
    public final /* synthetic */ O00oo000 this$0;

    public ConnectAndLoginMesh$2(O00oo000 o00oo000) {
        this.this$0 = o00oo000;
    }

    public void onResponse(int i, BleGattProfile bleGattProfile) {
        o00oo0oo00.O00000Oo(O00oo000.O0000OOo, "connect response: " + i);
        if (i != 0) {
            O00o O00000Oo = this.this$0.O0000O0o;
            SearchDeviceBean O000000o = this.this$0.O00000oO;
            O00000Oo.O000000o(O000000o, O00OOo.O0000Oo, "connect fail " + i);
        }
    }
}
