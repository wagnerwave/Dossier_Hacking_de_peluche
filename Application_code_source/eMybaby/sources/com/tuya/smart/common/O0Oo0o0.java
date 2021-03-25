package com.tuya.smart.common;

import a.e.a.a.r.a;
import a.j.a.b;
import com.tuya.smart.android.blemesh.bean.DpsParseBean;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.common.o00o0o0o0o;
import com.tuya.smart.common.o00o0oo0o0;
import com.tuya.smart.sdk.api.IResultCallback;
import com.tuya.spongycastle.math.ec.Tnaf;

public class O0Oo0o0 {
    public static final String O000000o = "TuyaBlueMeshControl";

    public void O000000o(o00o0o00oo o00o0o00oo, final IResultCallback iResultCallback) {
        new o00o0ooooo().O000000o(b.BLE_GATT_OP_CTRL_DA.f()).O000000o(65535).O000000o(o00o0o00oo.O00000o()).O00000Oo(o00o0o00oo.O00000o0()).O00000Oo(new byte[]{Tnaf.POW_2_WIDTH}).O000000o(o00o0o00oo.O00000Oo()).O000000o(false).O000000o((o00o0o0o0o.O000000o) new o00o0o0o0o.O000000o() {
            public void O000000o(String str, String str2) {
                L.d(O0Oo0o0.O000000o, "onFailure: code: " + str + " error: " + str2);
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(str, str2);
                }
            }

            public void O00000Oo() {
                L.d(O0Oo0o0.O000000o, "command getParams success");
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        }).O0000OOo().O000000o();
    }

    public void O000000o(o00o0o00oo o00o0o00oo, String str, String str2, DpsParseBean dpsParseBean, final IResultCallback iResultCallback) {
        int c2 = a.c(str);
        new o00o0ooooo().O000000o(dpsParseBean.getOpCode()).O00000Oo(dpsParseBean.getParams()).O000000o(c2).O000000o(o00o0o00oo.O00000o()).O00000Oo(a.c(str2)).O000000o(o00o0o00oo.O00000Oo()).O000000o(false).O000000o((o00o0o0o0o.O000000o) new o00o0o0o0o.O000000o() {
            public void O000000o(String str, String str2) {
                L.d(O0Oo0o0.O000000o, "onFailure: code: " + str + " error: " + str2);
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(str, str2);
                }
            }

            public void O00000Oo() {
                L.d(O0Oo0o0.O000000o, "command getParams success");
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        }).O0000OOo().O000000o();
    }

    public void O000000o(o00o0o00oo o00o0o00oo, String str, String str2, final IResultCallback iResultCallback) {
        new o00o0ooooo().O000000o(b.BLE_GATT_OP_CTRL_E3.f()).O000000o(a.c(str2)).O000000o(o00o0o00oo.O00000o()).O00000Oo(a.c(str)).O000000o(o00o0o00oo.O00000Oo()).O000000o(false).O000000o((o00o0o0o0o.O000000o) new o00o0o0o0o.O000000o() {
            public void O000000o(String str, String str2) {
                L.d(O0Oo0o0.O000000o, "onFailure: code: " + str + " error: " + str2);
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(str, str2);
                }
            }

            public void O00000Oo() {
                L.d(O0Oo0o0.O000000o, "command getParams success");
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        }).O0000OOo().O000000o();
    }

    public byte[] O000000o(int i) {
        return new o00o0ooooo().O000000o(b.BLE_GATT_OP_CTRL_DA.f()).O000000o(65535).O00000Oo(i).O00000Oo(new byte[]{Tnaf.POW_2_WIDTH}).O0000OOo().O00000o0();
    }

    public byte[] O000000o(int i, String str) {
        return new o00o0ooooo().O000000o(b.BLE_GATT_OP_CTRL_E3.f()).O000000o(a.c(str)).O00000Oo(i).O0000OOo().O00000o0();
    }

    public byte[] O000000o(String str, String str2, DpsParseBean dpsParseBean) {
        return new o00o0ooooo().O000000o(dpsParseBean.getOpCode()).O00000Oo(dpsParseBean.getParams()).O000000o(a.c(str2)).O00000Oo(a.c(str)).O0000OOo().O00000o0();
    }

    public void O00000Oo(o00o0o00oo o00o0o00oo, IResultCallback iResultCallback) {
        L.d(O000000o, "queryAllOnlineStatusByLocal");
        new o00o0oo0o0(o00o0o00oo.O00000Oo(), o00o0o00oo.O00000o(), (o00o0oo0o0.O000000o) null).O00000o();
    }
}
