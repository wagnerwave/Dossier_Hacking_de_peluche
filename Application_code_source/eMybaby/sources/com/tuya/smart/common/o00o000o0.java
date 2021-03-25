package com.tuya.smart.common;

import android.os.Binder;
import com.tuya.sdk.hardware.bean.HResponse;
import com.tuya.smart.android.hardware.bean.HgwBean;
import com.tuya.smart.android.hardware.service.DevTransferService;

public class o00o000o0 extends Binder {
    public DevTransferService O000000o;
    public o000o0000 O00000Oo;

    public o00o000o0(DevTransferService devTransferService) {
        this.O000000o = devTransferService;
    }

    public DevTransferService O000000o() {
        return this.O000000o;
    }

    public void O000000o(HResponse hResponse) {
        o000o0000 o000o0000 = this.O00000Oo;
        if (o000o0000 != null) {
            o000o0000.O000000o(hResponse);
        }
    }

    public void O000000o(HgwBean hgwBean, boolean z) {
        o000o0000 o000o0000 = this.O00000Oo;
        if (o000o0000 != null) {
            o000o0000.O000000o(hgwBean, z);
        }
    }

    public void O000000o(o000o0000 o000o0000) {
        this.O00000Oo = o000o0000;
    }
}
