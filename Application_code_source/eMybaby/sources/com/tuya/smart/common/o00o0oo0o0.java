package com.tuya.smart.common;

import a.a.a.a.a;
import a.e.a.a.o.j.d;
import a.e.a.a.o.j.h;
import a.e.a.a.o.j.i;
import a.e.a.a.r.b;
import a.j.a.a;
import com.tutk.IOTC.AVFrame;
import com.tuya.sdk.tuyamesh.bean.CommandBean;
import com.tuya.sdk.tuyamesh.blemesh.action.NotificationAction$1;
import com.tuya.sdk.tuyamesh.blemesh.action.NotificationAction$2;
import com.tuya.sdk.tuyamesh.blemesh.action.NotificationAction$3;
import com.tuya.smart.common.o00o0o0o0o;
import java.util.UUID;

public class o00o0oo0o0 extends o00o0o0o0o {
    public static final String O000000o = "NotificationAction";
    public final byte[] O00000Oo;
    public String O00000o;
    public O000000o O00000o0;
    public final d O00000oO = new NotificationAction$1(this);

    public interface O000000o extends o00o0o0o0o.O000000o {
        void O000000o();

        void O000000o(byte[] bArr);
    }

    public o00o0oo0o0(String str, byte[] bArr, O000000o o000000o) {
        this.O00000o0 = o000000o;
        this.O00000o = str;
        this.O00000Oo = (byte[]) bArr.clone();
    }

    /* access modifiers changed from: private */
    public void O000000o(UUID uuid, UUID uuid2, byte[] bArr) {
        byte[] O000000o2 = o00oo00ooo.O000000o(this.O00000o);
        int i = 0;
        System.arraycopy(bArr, 0, O000000o2, 3, 5);
        byte[] bArr2 = this.O00000Oo;
        byte[] bArr3 = new byte[16];
        byte[] bArr4 = new byte[16];
        System.arraycopy(O000000o2, 0, bArr3, 1, 8);
        for (int i2 = 0; i2 < 13; i2++) {
            int i3 = i2 & 15;
            if (i3 == 0) {
                bArr4 = b.c(bArr2, bArr3);
                bArr3[0] = (byte) (bArr3[0] + 1);
            }
            if (bArr4 != null) {
                int i4 = i2 + 7;
                bArr[i4] = (byte) (bArr4[i3] ^ bArr[i4]);
            }
        }
        for (int i5 = 0; i5 < 16; i5++) {
            bArr3[i5] = 0;
        }
        System.arraycopy(O000000o2, 0, bArr3, 0, 8);
        bArr3[8] = (byte) 13;
        byte[] c2 = b.c(bArr2, bArr3);
        for (int i6 = 0; i6 < 13; i6++) {
            if (c2 != null) {
                int i7 = i6 & 15;
                c2[i7] = (byte) (c2[i7] ^ bArr[i6 + 7]);
            }
            if ((i6 & 15) == 15 || i6 == 12) {
                c2 = b.c(bArr2, c2);
            }
        }
        while (true) {
            if (i < 2) {
                if (c2 != null && bArr[i + 5] != c2[i]) {
                    bArr = null;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        StringBuilder n = a.n("Notify Data --> ");
        n.append(o00oo0o00o.O00000Oo(bArr, ","));
        o00oo0oo00.O000000o("NotificationAction", n.toString());
        O000000o o000000o = this.O00000o0;
        if (o000000o != null) {
            o000000o.O000000o(bArr);
        }
    }

    public void O000000o() {
        a.j.a.a a2 = a.j.a.a.a();
        UUID b2 = a2.b(a.c.SERVICE);
        UUID b3 = a2.b(a.c.NOTIFY);
        CommandBean newInstance = CommandBean.newInstance();
        newInstance.serviceUUID = b2;
        newInstance.macAddress = this.O00000o;
        newInstance.characteristicUUID = b3;
        O000000o(newInstance, this.O00000oO);
    }

    public void O00000Oo() {
        a.j.a.a a2 = a.j.a.a.a();
        UUID b2 = a2.b(a.c.SERVICE);
        UUID b3 = a2.b(a.c.NOTIFY);
        CommandBean newInstance = CommandBean.newInstance();
        newInstance.serviceUUID = b2;
        newInstance.macAddress = this.O00000o;
        newInstance.characteristicUUID = b3;
        O000000o(newInstance, (h) new NotificationAction$2(this));
    }

    public void O00000Oo(byte[] bArr) {
        a.j.a.a a2 = a.j.a.a.a();
        UUID b2 = a2.b(a.c.SERVICE);
        UUID b3 = a2.b(a.c.NOTIFY);
        CommandBean newInstance = CommandBean.newInstance();
        newInstance.type = CommandBean.CommandType.WRITE;
        newInstance.data = bArr;
        newInstance.macAddress = this.O00000o;
        newInstance.serviceUUID = b2;
        newInstance.characteristicUUID = b3;
        O000000o(newInstance, (i) new NotificationAction$3(this));
    }

    public void O00000o() {
        O00000Oo(new byte[]{1});
    }

    public void O00000o0() {
        this.O00000o0 = null;
    }

    public void O000000o(byte[] bArr) {
        if (bArr.length >= 20) {
            byte b2 = bArr[7];
            if ((bArr[8] << 8) + (bArr[9] & AVFrame.FRM_STATE_UNKOWN) == a.j.a.a.a().f3699c) {
                byte b3 = bArr[3];
                byte b4 = bArr[4];
                System.arraycopy(bArr, 10, new byte[10], 0, 10);
            }
        }
    }
}
