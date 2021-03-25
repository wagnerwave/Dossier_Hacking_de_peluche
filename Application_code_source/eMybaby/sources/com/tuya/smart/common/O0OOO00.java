package com.tuya.smart.common;

import a.e.a.a.r.a;
import a.j.a.b;
import com.tuya.smart.android.common.utils.L;
import com.tuya.smart.common.o00o0o0o0o;
import com.tuya.smart.sdk.api.IResultCallback;

public class O0OOO00 {
    public static final String O000000o = "TuyaBlueMeshGroupControl";

    public void O000000o(o00o0o00oo o00o0o00oo, String str, final IResultCallback iResultCallback) {
        new o00o0ooooo().O000000o(b.BLE_GATT_OP_CTRL_E0.f()).O000000o(a.c(str)).O000000o(o00o0o00oo.O00000o()).O00000Oo(new byte[]{-1, -1}).O00000Oo(o00o0o00oo.O00000o0()).O000000o(o00o0o00oo.O00000Oo()).O000000o(false).O000000o((o00o0o0o0o.O000000o) new o00o0o0o0o.O000000o() {
            public void O000000o(String str, String str2) {
                L.d(O0OOO00.O000000o, "onFailure: code: " + str + " error: " + str2);
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(str, str2);
                }
            }

            public void O00000Oo() {
                L.d(O0OOO00.O000000o, "command getParams success");
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        }).O0000OOo().O000000o();
    }

    public void O000000o(o00o0o00oo o00o0o00oo, String str, String str2, final IResultCallback iResultCallback) {
        new o00oo00000().O000000o(o00o0o00oo.O00000o()).O00000o0(a.c(str2)).O000000o(65535).O00000Oo(a.c(str)).O000000o(false).O000000o(o00o0o00oo.O00000Oo()).O00000oO().O00000Oo(new o00o0o0o0o.O000000o() {
            public void O000000o(String str, String str2) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(str, str2);
                }
            }

            public void O00000Oo() {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public void O000000o(o00o0o00oo o00o0o00oo, String str, String str2, String str3, final IResultCallback iResultCallback) {
        new o00oo00000().O000000o(o00o0o00oo.O00000o()).O000000o(a.c(str2)).O00000Oo(a.c(str)).O00000o0(a.c(str3)).O000000o(false).O000000o(o00o0o00oo.O00000Oo()).O00000oO().O000000o(new o00o0o0o0o.O000000o() {
            public void O000000o(String str, String str2) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(str, str2);
                }
            }

            public void O00000Oo() {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public byte[] O000000o(int i, String str) {
        return new o00o0ooooo().O000000o(b.BLE_GATT_OP_CTRL_E0.f()).O000000o(a.c(str)).O00000Oo(i).O00000Oo(new byte[]{-1, -1}).O0000OOo().O00000o0();
    }

    public byte[] O000000o(int i, String str, String str2) {
        return new o00oo00000().O000000o(a.c(str)).O00000Oo(i).O00000o0(a.c(str2)).O00000oO().O000000o();
    }

    public void O00000Oo(o00o0o00oo o00o0o00oo, String str, final IResultCallback iResultCallback) {
        new o00o0ooooo().O000000o(b.BLE_GATT_OP_CTRL_DA.f()).O000000o(a.c(str)).O000000o(o00o0o00oo.O00000o()).O00000Oo(new byte[]{100}).O00000Oo(o00o0o00oo.O00000o0()).O000000o(o00o0o00oo.O00000Oo()).O000000o(false).O000000o((o00o0o0o0o.O000000o) new o00o0o0o0o.O000000o() {
            public void O000000o(String str, String str2) {
                L.d(O0OOO00.O000000o, "onFailure: code: " + str + " error: " + str2);
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(str, str2);
                }
            }

            public void O00000Oo() {
                L.d(O0OOO00.O000000o, "command getParams success");
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        }).O0000OOo().O000000o();
    }

    public void O00000Oo(o00o0o00oo o00o0o00oo, String str, String str2, String str3, final IResultCallback iResultCallback) {
        new o00oo00000().O000000o(o00o0o00oo.O00000o()).O000000o(a.c(str2)).O00000o0(a.c(str3)).O00000Oo(a.c(str)).O000000o(false).O000000o(o00o0o00oo.O00000Oo()).O00000oO().O00000Oo(new o00o0o0o0o.O000000o() {
            public void O000000o(String str, String str2) {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onError(str, str2);
                }
            }

            public void O00000Oo() {
                IResultCallback iResultCallback = iResultCallback;
                if (iResultCallback != null) {
                    iResultCallback.onSuccess();
                }
            }
        });
    }

    public byte[] O00000Oo(int i, String str) {
        return new o00oo00000().O00000o0(a.c(str)).O000000o(65535).O00000Oo(i).O00000oO().O00000Oo();
    }

    public byte[] O00000Oo(int i, String str, String str2) {
        return new o00oo00000().O000000o(a.c(str)).O00000o0(a.c(str2)).O00000Oo(i).O00000oO().O00000Oo();
    }

    public byte[] O00000o0(int i, String str) {
        return new o00o0ooooo().O000000o(b.BLE_GATT_OP_CTRL_DA.f()).O000000o(a.c(str)).O00000Oo(i).O00000Oo(new byte[]{100}).O0000OOo().O00000o0();
    }
}
