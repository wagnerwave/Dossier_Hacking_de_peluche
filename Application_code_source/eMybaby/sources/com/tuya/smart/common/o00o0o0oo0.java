package com.tuya.smart.common;

import a.a.a.a.a;
import a.e.a.a.o.j.i;
import a.e.a.a.r.b;
import a.j.a.a;
import com.tuya.sdk.tuyamesh.bean.CommandBean;
import com.tuya.sdk.tuyamesh.blemesh.action.CommandAction$1;
import com.tuya.sdk.tuyamesh.blemesh.action.CommandAction$2;
import com.tuya.smart.common.o00o0o0o0o;
import java.util.UUID;

public class o00o0o0oo0 extends o00o0o0o0o {
    public static final String O000000o = "CommandAction";
    public final int O00000Oo = o00o0o0ooo.O000000o().O00000Oo();
    public o00o0o0o0o.O000000o O00000o;
    public final byte[] O00000o0;
    public final boolean O00000oO;
    public final int O00000oo;
    public final byte O0000O0o;
    public final byte[] O0000OOo;
    public final int O0000Oo;
    public final String O0000Oo0;

    public o00o0o0oo0(o00o0ooooo o00o0ooooo) {
        this.O0000Oo0 = o00o0ooooo.O000000o();
        this.O00000o0 = o00o0ooooo.O00000Oo();
        this.O00000o = o00o0ooooo.O00000o0();
        this.O00000oO = o00o0ooooo.O00000o();
        this.O00000oo = o00o0ooooo.O00000oo();
        this.O0000O0o = o00o0ooooo.O00000oO();
        this.O0000OOo = o00o0ooooo.O0000O0o();
        this.O0000Oo = o00o0ooooo.O0000Oo0();
    }

    private void O000000o(byte[] bArr) {
        StringBuilder n = a.n("sendCommand#NoEncrypt: ");
        n.append(o00oo0o00o.O00000Oo(bArr, ":"));
        o00oo0oo00.O000000o(O000000o, n.toString());
        byte[] O000000o2 = o00oo00ooo.O000000o(this.O0000Oo0, this.O00000Oo);
        byte[] bArr2 = this.O00000o0;
        byte[] bArr3 = new byte[16];
        byte[] bArr4 = new byte[16];
        System.arraycopy(O000000o2, 0, bArr3, 0, 8);
        bArr3[8] = 15;
        byte[] c2 = b.c(bArr2, bArr3);
        for (int i = 0; i < 15; i++) {
            if (c2 != null) {
                int i2 = i & 15;
                c2[i2] = (byte) (c2[i2] ^ bArr[i + 5]);
            }
            if ((i & 15) == 15 || i == 14) {
                c2 = b.c(bArr2, c2);
            }
        }
        for (int i3 = 0; i3 < 2; i3++) {
            if (c2 != null) {
                bArr[i3 + 3] = c2[i3];
            }
        }
        if (c2 != null) {
            for (int i4 = 0; i4 < c2.length; i4++) {
                c2[i4] = 0;
            }
        }
        if (c2 != null) {
            System.arraycopy(O000000o2, 0, c2, 1, 8);
        }
        for (int i5 = 0; i5 < 15; i5++) {
            int i6 = i5 & 15;
            if (i6 == 0) {
                bArr4 = b.c(bArr2, c2);
                if (c2 != null) {
                    c2[0] = (byte) (c2[0] + 1);
                }
            }
            if (bArr4 != null) {
                int i7 = i5 + 5;
                bArr[i7] = (byte) (bArr4[i6] ^ bArr[i7]);
            }
        }
        a.j.a.a a2 = a.j.a.a.a();
        UUID b2 = a2.b(a.c.SERVICE);
        UUID b3 = a2.b(a.c.COMMAND);
        CommandBean newInstance = CommandBean.newInstance();
        newInstance.data = bArr;
        newInstance.serviceUUID = b2;
        newInstance.macAddress = this.O0000Oo0;
        newInstance.characteristicUUID = b3;
        if (this.O00000oO) {
            O00000Oo(newInstance, new CommandAction$1(this));
        } else {
            O000000o(newInstance, (i) new CommandAction$2(this));
        }
    }

    public void O000000o() {
        O000000o(O00000Oo());
    }

    public byte[] O00000Oo() {
        byte[] bArr = new byte[20];
        int i = this.O00000Oo;
        bArr[0] = (byte) (i & 255);
        bArr[1] = (byte) ((i >> 8) & 255);
        bArr[2] = (byte) ((i >> 16) & 255);
        bArr[3] = 0;
        bArr[4] = 0;
        int i2 = this.O00000oo;
        bArr[5] = (byte) (i2 & 255);
        bArr[6] = (byte) ((i2 >> 8) & 255);
        bArr[7] = (byte) (this.O0000O0o | 192);
        int i3 = this.O0000Oo;
        bArr[8] = (byte) ((i3 >> 8) & 255);
        bArr[9] = (byte) (i3 & 255);
        byte[] bArr2 = this.O0000OOo;
        if (bArr2 != null) {
            System.arraycopy(bArr2, 0, bArr, 10, bArr2.length);
        }
        o00oo0oo00.O000000o(O000000o, o00oo0o00o.O00000Oo(bArr, ":"));
        return bArr;
    }

    public void O00000o() {
        this.O00000o = null;
    }

    public byte[] O00000o0() {
        byte[] bArr = new byte[15];
        System.arraycopy(O00000Oo(), 5, bArr, 0, 15);
        o00oo0oo00.O000000o(O000000o, o00oo0o00o.O00000Oo(bArr, ":"));
        return bArr;
    }
}
