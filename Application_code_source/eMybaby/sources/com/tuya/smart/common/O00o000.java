package com.tuya.smart.common;

import a.a.a.a.a;
import a.j.a.b;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tutk.IOTC.AVFrame;
import com.tuya.sdk.timer.bean.DpTimerBean;
import com.tuya.smart.android.blemesh.bean.SearchDeviceBean;
import com.tuya.smart.common.O00Ooo00;
import com.tuya.smart.common.o00o0o0o0o;
import com.tuya.smart.common.o00o0oo0o0;

public class O00o000 {
    public static final int O000000o = 67;
    public static final String O00000Oo = "ObtainAuthKeyUuid";
    public static final long O0000Oo0 = 5000;
    public o00o0o0oo0 O00000o;
    public o00o0oo0o0 O00000o0;
    public O00Ooo00 O00000oO;
    public SearchDeviceBean O00000oo;
    public O00o0000 O0000O0o;
    public int O0000OOo = 3;
    public Handler O0000Oo;
    public Handler.Callback O0000OoO = new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 67) {
                return false;
            }
            StringBuilder n = a.n("ObtainAuthKeyUuid time out try ");
            n.append(O00o000.this.O0000OOo);
            Log.e(O00o000.O00000Oo, n.toString());
            if (O00o000.this.O0000OOo > 0) {
                O00o000.O00000Oo(O00o000.this);
                O00o000.this.O00000Oo();
                return false;
            }
            O00o000.this.O0000O0o.O000000o(O00o000.this.O00000oo, O00OOo.O00000o, "Obtain AuthKey Uuid Fail");
            return false;
        }
    };

    public O00o000(O00o0000 o00o0000) {
        this.O0000O0o = o00o0000;
        this.O0000Oo = new Handler(Looper.getMainLooper(), this.O0000OoO);
    }

    /* access modifiers changed from: private */
    public void O000000o(byte[] bArr, int i) {
        O00Ooo00 o00Ooo00;
        o00oo0oo00.O000000o(O00000Oo, "onCommandNotify");
        if (bArr.length >= 20) {
            byte b2 = bArr[7] & AVFrame.FRM_STATE_UNKOWN;
            if ((bArr[8] << 8) + (bArr[9] & AVFrame.FRM_STATE_UNKOWN) == i) {
                byte[] bArr2 = new byte[10];
                System.arraycopy(bArr, 10, bArr2, 0, 10);
                o00oo0oo00.O000000o(O00000Oo, "opcode: " + o00oo0o0oo.O000000o(new byte[]{(byte) b2}) + " params: " + o00oo0o00o.O00000Oo(bArr2, ":"));
                if (b2 == (b.BLE_GATT_OP_CTRL_DF.f() & AVFrame.FRM_STATE_UNKOWN)) {
                    O00Ooo00 o00Ooo002 = this.O00000oO;
                    if (o00Ooo002 != null) {
                        o00Ooo002.O000000o(bArr2);
                    }
                    if (bArr2[0] == -1 && (o00Ooo00 = this.O00000oO) != null) {
                        if (o00Ooo00.O000000o() == null) {
                            o00oo0oo00.O00000Oo(O00000Oo, "mAuthKeyParser == null");
                            return;
                        }
                        StringBuilder n = a.n("params[0] FF ");
                        n.append(this.O00000oO.O000000o());
                        o00oo0oo00.O00000Oo(O00000Oo, n.toString());
                        this.O0000Oo.removeMessages(67);
                        O00Ooo00.O000000o O000000o2 = this.O00000oO.O000000o();
                        if (O000000o2 == null) {
                            o00oo0oo00.O00000Oo(O00000Oo, "AUTHKEY_PARSE_FAILURE try again");
                            O00000Oo();
                            return;
                        }
                        O00o0000 o00o0000 = this.O0000O0o;
                        if (o00o0000 != null) {
                            o00o0000.O000000o(this.O00000oo, O000000o2);
                        }
                    }
                }
            }
        }
    }

    public static /* synthetic */ int O00000Oo(O00o000 o00o000) {
        int i = o00o000.O0000OOo;
        o00o000.O0000OOo = i - 1;
        return i;
    }

    public void O000000o() {
        this.O0000OOo = 3;
        o00o0oo0o0 o00o0oo0o0 = this.O00000o0;
        if (o00o0oo0o0 != null) {
            o00o0oo0o0.O00000o0();
        }
    }

    public void O000000o(SearchDeviceBean searchDeviceBean) {
        this.O0000OOo = 3;
        this.O00000oo = searchDeviceBean;
        o00o0oo0o0 o00o0oo0o0 = new o00o0oo0o0(searchDeviceBean.getMacAdress(), this.O00000oo.getSessionKey(), new o00o0oo0o0.O000000o() {
            public void O000000o() {
                o00oo0oo00.O000000o(O00o000.O00000Oo, "enableNotificationSuccess");
                O00o000.this.O00000Oo();
            }

            public void O000000o(String str, String str2) {
                o00oo0oo00.O000000o(O00o000.O00000Oo, "onFailure " + str + DpTimerBean.FILL + str2);
                if (O00o000.this.O0000OOo > 0) {
                    O00o000.O00000Oo(O00o000.this);
                    O00o000.this.O00000o0.O000000o();
                } else if (O00o000.this.O0000O0o != null) {
                    O00o000.this.O0000O0o.O000000o(O00o000.this.O00000oo, O00OOo.O00000o, str2);
                }
            }

            public void O000000o(byte[] bArr) {
                o00oo0oo00.O000000o(O00o000.O00000Oo, "onUnSecretNotify");
                O00o000 o00o000 = O00o000.this;
                o00o000.O000000o(bArr, o00o000.O00000oo.getVendorId());
            }

            public void O00000Oo() {
                o00oo0oo00.O000000o(O00o000.O00000Oo, "onSuccess");
            }
        });
        this.O00000o0 = o00o0oo0o0;
        o00o0oo0o0.O000000o();
    }

    public void O00000Oo() {
        StringBuilder n = a.n("sendObtainAuthKeyUuidCommand trySendCount:");
        n.append(this.O0000OOo);
        o00oo0oo00.O000000o(O00000Oo, n.toString());
        int i = this.O0000OOo;
        if (i == 0) {
            O00o0000 o00o0000 = this.O0000O0o;
            if (o00o0000 != null) {
                o00o0000.O000000o(this.O00000oo, O00OOo.O00000o, "obtain auth try 3 times faill");
                return;
            }
            return;
        }
        this.O0000OOo = i - 1;
        o00o0o0oo0 O0000OOo2 = new o00o0ooooo().O00000Oo(this.O00000oo.getVendorId()).O000000o(this.O00000oo.getSessionKey()).O000000o(b.BLE_GATT_OP_CTRL_CF.f()).O000000o(this.O00000oo.getMacAdress()).O000000o(0).O000000o((o00o0o0o0o.O000000o) new o00o0o0o0o.O000000o() {
            public void O000000o(String str, String str2) {
                o00oo0oo00.O000000o(O00o000.O00000Oo, "sendAuthKeyCommand fail " + str + DpTimerBean.FILL + str2);
                O00o000.this.O00000Oo();
            }

            public void O00000Oo() {
                o00oo0oo00.O000000o(O00o000.O00000Oo, "sendAuthKeyCommand success");
                O00Ooo00 unused = O00o000.this.O00000oO = new O00Ooo00();
                O00o000.this.O0000Oo.sendEmptyMessageDelayed(67, 5000);
            }
        }).O0000OOo();
        this.O00000o = O0000OOo2;
        O0000OOo2.O000000o();
    }

    public SearchDeviceBean O00000o() {
        return this.O00000oo;
    }

    public void O00000o0() {
        o00o0o0oo0 o00o0o0oo0 = this.O00000o;
        if (o00o0o0oo0 != null) {
            o00o0o0oo0.O00000o();
        }
        o00o0oo0o0 o00o0oo0o0 = this.O00000o0;
        if (o00o0oo0o0 != null) {
            o00o0oo0o0.O00000o0();
        }
    }
}
