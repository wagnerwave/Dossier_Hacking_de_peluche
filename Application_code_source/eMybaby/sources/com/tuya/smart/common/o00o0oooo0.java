package com.tuya.smart.common;

import a.a.a.a.a;
import a.j.a.b;
import android.os.Handler;
import android.os.Message;
import com.tuya.smart.common.o00o0o0o0o;

public class o00o0oooo0 extends o00o0o0o0o {
    public static final int O000000o = 7;
    public static final int O00000Oo = 1;
    public static final String O00000o0 = "WifiInfoAction";
    public final int O00000o;
    public final int O00000oO;
    public final boolean O00000oo;
    public final o00o0o0o0o.O000000o O0000O0o;
    public final byte[] O0000OOo;
    public byte[] O0000Oo;
    public final String O0000Oo0;
    public int O0000OoO;
    public boolean O0000Ooo;
    public Handler O0000o00 = new Handler(new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (o00o0oooo0.this.O0000Ooo) {
                return true;
            }
            if (message.what != 1) {
                return false;
            }
            o00o0oooo0 o00o0oooo0 = o00o0oooo0.this;
            o00o0oooo0.O000000o(o00o0oooo0.O00000Oo());
            return false;
        }
    });

    public o00o0oooo0(o00oo000oo o00oo000oo) {
        this.O0000Oo0 = o00oo000oo.O000000o();
        this.O0000OOo = o00oo000oo.O00000Oo();
        this.O0000O0o = o00oo000oo.O00000o0();
        this.O00000oo = o00oo000oo.O00000o();
        this.O00000oO = o00oo000oo.O00000oO();
        this.O00000o = o00oo000oo.O0000O0o();
        O000000o(o00oo000oo);
        StringBuilder n = a.n("meshAddress: ");
        n.append(this.O00000oO);
        o00oo0oo00.O000000o(O00000o0, n.toString());
    }

    private byte O000000o(byte[] bArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += bArr[i3];
        }
        return (byte) (i2 & 255);
    }

    private void O000000o(o00o0o0o0o.O000000o o000000o, byte[] bArr) {
        StringBuilder n = a.n("mVendorId: ");
        n.append(this.O00000o);
        o00oo0oo00.O000000o(O00000o0, n.toString());
        o00oo0oo00.O000000o(O00000o0, "mMeshIndex: " + this.O0000OoO + " " + o00oo0o00o.O00000Oo(bArr, ":"));
        new o00o0ooooo().O000000o(this.O00000oO).O000000o(b.BLE_GATT_OP_CTRL_F0.f()).O000000o(this.O0000Oo0).O00000Oo(bArr).O000000o(this.O0000OOo).O000000o(this.O00000oo).O00000Oo(this.O00000o).O000000o(o000000o).O0000OOo().O000000o();
    }

    private void O000000o(o00oo000oo o00oo000oo) {
        StringBuilder n = a.n("builder: ");
        n.append(o00oo000oo.O0000Oo());
        o00oo0oo00.O000000o(O00000o0, n.toString());
        String O0000OOo2 = o00oo000oo.O0000OOo();
        String O0000Oo02 = o00oo000oo.O0000Oo0();
        String O0000Oo2 = o00oo000oo.O0000Oo();
        int length = O0000Oo2.getBytes().length;
        int length2 = O0000OOo2.getBytes().length;
        int length3 = O0000Oo02.getBytes().length;
        byte[] bArr = new byte[a.b(length3, length2, length, 4)];
        this.O0000Oo = bArr;
        bArr[0] = (byte) (bArr.length & 255);
        bArr[1] = (byte) (length2 & 255);
        StringBuilder n2 = a.n("ssid:");
        n2.append(a.e.a.a.r.a.b(O0000OOo2.getBytes()));
        o00oo0oo00.O00000Oo(O00000o0, n2.toString());
        System.arraycopy(O0000OOo2.getBytes(), 0, this.O0000Oo, 2, length2);
        int i = length2 + 2;
        int i2 = i + 1;
        this.O0000Oo[i] = (byte) (length3 & 255);
        if (length3 > 0) {
            System.arraycopy(O0000Oo02.getBytes(), 0, this.O0000Oo, i2, length3);
            i2 += length3;
        }
        this.O0000Oo[i2] = (byte) (length & 255);
        System.arraycopy(O0000Oo2.getBytes(), 0, this.O0000Oo, i2 + 1, length);
        o00oo0oo00.O000000o(O00000o0, o00oo0o00o.O00000Oo(this.O0000Oo, ":"));
    }

    /* access modifiers changed from: private */
    public void O000000o(byte[] bArr) {
        if (bArr == null) {
            o00o0o0o0o.O000000o o000000o = this.O0000O0o;
            if (o000000o != null) {
                o000000o.O00000Oo();
                return;
            }
            return;
        }
        O000000o((o00o0o0o0o.O000000o) new o00o0o0o0o.O000000o() {
            public void O000000o(String str, String str2) {
                if (o00o0oooo0.this.O0000O0o != null) {
                    o00o0oooo0.this.O0000O0o.O000000o(str, str2);
                }
            }

            public void O00000Oo() {
                o00o0oooo0.this.O0000o00.sendEmptyMessageDelayed(1, 500);
            }
        }, bArr);
    }

    public void O000000o() {
        this.O0000Ooo = false;
        this.O0000o00.sendEmptyMessage(1);
    }

    public byte[] O00000Oo() {
        int i;
        byte[] bArr = this.O0000Oo;
        int length = bArr.length;
        int i2 = this.O0000OoO;
        if (length <= i2 * 7) {
            return null;
        }
        byte[] bArr2 = new byte[10];
        int length2 = bArr.length - (i2 * 7);
        if (length2 / 7 > 0) {
            if (length2 == 7) {
                bArr2[0] = -1;
            } else {
                bArr2[0] = (byte) (i2 & 255);
            }
            i = 7;
        } else {
            i = bArr.length % 7;
            bArr2[0] = -1;
        }
        bArr2[1] = (byte) (i & 255);
        byte[] bArr3 = this.O0000Oo;
        int i3 = this.O0000OoO;
        this.O0000OoO = i3 + 1;
        System.arraycopy(bArr3, i3 * 7, bArr2, 2, i);
        int i4 = 2 + i;
        bArr2[i4] = O000000o(bArr2, i4);
        return bArr2;
    }

    public void O00000o0() {
        this.O0000Ooo = true;
    }
}
