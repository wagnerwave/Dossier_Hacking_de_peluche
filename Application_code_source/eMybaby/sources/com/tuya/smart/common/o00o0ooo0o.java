package com.tuya.smart.common;

import a.a.a.a.a;
import com.tutk.IOTC.AVFrame;
import com.tuya.sdk.timer.bean.DpTimerBean;
import com.tuya.smart.common.o00o0o0o0o;
import com.tuya.smart.common.o00o0oo0o0;

public class o00o0ooo0o extends o00o0o0o0o {
    public static final String O000000o = "ResetMeshAddressAction";
    public final int O00000Oo;
    public final int O00000o;
    public final String O00000o0;
    public byte[] O00000oO;
    public byte O00000oo = -32;
    public O000000o O0000O0o;
    public int O0000OOo = 3;
    public o00o0oo0o0 O0000Oo0 = null;

    public interface O000000o {
        void O000000o();

        void O000000o(String str, String str2);
    }

    public o00o0ooo0o(o00oo000o0 o00oo000o0) {
        this.O00000Oo = o00oo000o0.O00000o0();
        this.O00000o0 = o00oo000o0.O000000o();
        this.O00000o = o00oo000o0.O00000oO();
        this.O00000oO = o00oo000o0.O00000Oo();
        this.O0000O0o = o00oo000o0.O00000oo();
    }

    /* access modifiers changed from: private */
    public void O000000o(byte[] bArr) {
        String str;
        if (bArr.length >= 20) {
            byte b2 = bArr[7] & AVFrame.FRM_STATE_UNKOWN;
            int i = (bArr[8] << 8) + (bArr[9] & AVFrame.FRM_STATE_UNKOWN);
            StringBuilder o = a.o("vendorId: ", i, "     mVendorId: ");
            o.append(this.O00000o);
            o00oo0oo00.O000000o(O000000o, o.toString());
            if (i != this.O00000o) {
                str = "vendorId != mVendorId";
            } else if (b2 != 225) {
                str = a.h("error opcode: ", b2);
            } else {
                int i2 = (bArr[10] & AVFrame.FRM_STATE_UNKOWN) + (bArr[11] << 8);
                o00oo0oo00.O000000o(O000000o, "meshAddress: " + i2);
                o00o0oo0o0 o00o0oo0o0 = this.O0000Oo0;
                if (o00o0oo0o0 != null) {
                    o00o0oo0o0.O00000o0();
                }
                O000000o o000000o = this.O0000O0o;
                if (o000000o != null) {
                    o000000o.O000000o();
                    return;
                }
                return;
            }
            o00oo0oo00.O00000Oo(O000000o, str);
        }
    }

    /* access modifiers changed from: private */
    public void O00000o() {
        int i = this.O00000Oo;
        byte[] bArr = {(byte) (i & 255), (byte) ((i >> 8) & 255)};
        StringBuilder n = a.n("prepare update mesh address -->");
        n.append(this.O00000o0);
        n.append(" new : ");
        n.append(Integer.toHexString(this.O00000Oo));
        o00oo0oo00.O000000o(O000000o, n.toString());
        new o00o0ooooo().O000000o(this.O00000oo).O00000Oo(bArr).O000000o(0).O000000o(this.O00000oO).O00000Oo(this.O00000o).O000000o(this.O00000o0).O000000o(false).O000000o((o00o0o0o0o.O000000o) new o00o0o0o0o.O000000o() {
            public void O000000o(String str, String str2) {
            }

            public void O00000Oo() {
                o00oo0oo00.O000000o(o00o0ooo0o.O000000o, "command getParams success");
            }
        }).O0000OOo().O000000o();
    }

    public static /* synthetic */ int O00000o0(o00o0ooo0o o00o0ooo0o) {
        int i = o00o0ooo0o.O0000OOo;
        o00o0ooo0o.O0000OOo = i - 1;
        return i;
    }

    private void O00000o0() {
        new o00o0ooooo().O000000o(this.O00000oo).O00000Oo(new byte[]{-1, -1}).O000000o(0).O000000o(this.O00000oO).O00000Oo(this.O00000o).O000000o(this.O00000o0).O000000o(true).O000000o((o00o0o0o0o.O000000o) new o00o0o0o0o.O000000o() {
            public void O000000o(String str, String str2) {
            }

            public void O00000Oo() {
                o00oo0oo00.O000000o(o00o0ooo0o.O000000o, "command getParams success");
            }
        }).O0000OOo().O000000o();
    }

    private void O00000oO() {
        o00o0oo0o0 o00o0oo0o0 = new o00o0oo0o0(this.O00000o0, this.O00000oO, new o00o0oo0o0.O000000o() {
            public void O000000o() {
                o00oo0oo00.O000000o(o00o0ooo0o.O000000o, "enableNotificationSuccess ");
                o00o0ooo0o.this.O00000o();
            }

            public void O000000o(String str, String str2) {
                o00oo0oo00.O000000o(o00o0ooo0o.O000000o, "enableNotification onFailure  " + str + DpTimerBean.FILL + str2);
                if (o00o0ooo0o.this.O0000OOo >= 0) {
                    o00o0ooo0o.O00000o0(o00o0ooo0o.this);
                    o00o0ooo0o.this.O0000Oo0.O000000o();
                    return;
                }
                o00o0ooo0o.this.O0000O0o.O000000o(O00OOo.O00000oo, "enable Notification fail");
            }

            public void O000000o(byte[] bArr) {
                o00oo0oo00.O000000o(o00o0ooo0o.O000000o, "onUnSecretNotify ");
                o00o0ooo0o.this.O000000o(bArr);
            }

            public void O00000Oo() {
                o00oo0oo00.O000000o(o00o0ooo0o.O000000o, "enableNotification onSuccess");
            }
        });
        this.O0000Oo0 = o00o0oo0o0;
        o00o0oo0o0.O000000o();
    }

    public void O000000o() {
        StringBuilder n = a.n("resetDeviceAddress mMeshAddress: ");
        n.append(this.O00000Oo);
        o00oo0oo00.O000000o(O000000o, n.toString());
        this.O0000OOo = 3;
        O00000oO();
    }

    public void O00000Oo() {
        o00o0oo0o0 o00o0oo0o0 = this.O0000Oo0;
        if (o00o0oo0o0 != null) {
            o00o0oo0o0.O00000o0();
            this.O0000Oo0 = null;
        }
    }
}
