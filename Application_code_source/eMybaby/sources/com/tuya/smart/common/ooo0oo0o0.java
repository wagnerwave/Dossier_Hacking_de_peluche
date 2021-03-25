package com.tuya.smart.common;

import a.a.a.a.a;
import a.e.a.a.o.j.d;
import a.e.a.a.o.j.h;
import a.e.a.a.o.j.i;
import a.j.a.a;
import com.tutk.IOTC.AVFrame;
import com.tuya.sdk.sigmesh.action.SigMeshNotificationAction$1;
import com.tuya.sdk.sigmesh.action.SigMeshNotificationAction$2;
import com.tuya.sdk.sigmesh.action.SigMeshNotificationAction$3;
import com.tuya.sdk.sigmesh.action.SigMeshNotificationAction$4;
import com.tuya.sdk.tuyamesh.bean.CommandBean;
import com.tuya.smart.common.o00o0o0o0o;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

public class ooo0oo0o0 extends o00o0o0o0o {
    public static String O000000o = "proxy";
    public static String O00000Oo = "provision";
    public static final String O00000o = "NotificationAction";
    public static String O00000o0 = "ota";
    public O000000o O00000oO;
    public byte[] O00000oo;
    public int O0000O0o;
    public String O0000OOo;
    public final d O0000Oo = new SigMeshNotificationAction$1(this);
    public String O0000Oo0;
    public final d O0000OoO = new SigMeshNotificationAction$2(this);

    public interface O000000o extends o00o0o0o0o.O000000o {
        void O000000o(String str);

        void O000000o(byte[] bArr);
    }

    public ooo0oo0o0(String str, O000000o o000000o) {
        this.O00000oO = o000000o;
        this.O0000OOo = str;
    }

    /* access modifiers changed from: private */
    public void O000000o(UUID uuid, UUID uuid2, byte[] bArr) {
        if (O00000Oo(bArr)) {
            byte[] O000000o2 = O000000o(oo0o0oooo.O000000o().O00000Oo(), bArr);
            if (O000000o2 != null) {
                bArr = O00000Oo(oo0o0oooo.O000000o().O00000Oo(), O000000o2);
            } else {
                return;
            }
        }
        StringBuilder n = a.n("Notify Data --> ");
        n.append(o00oo0o00o.O00000Oo(bArr, ","));
        o00oo0oo00.O000000o("NotificationAction", n.toString());
        O000000o o000000o = this.O00000oO;
        if (o000000o != null) {
            o000000o.O000000o(bArr);
        }
    }

    private byte[] O000000o(int i, byte[] bArr) {
        int i2 = (bArr[0] & 192) >> 6;
        if (i2 == 1) {
            byte[] bArr2 = new byte[bArr.length];
            this.O00000oo = bArr2;
            bArr2[0] = (byte) (bArr[0] & 63 & AVFrame.FRM_STATE_UNKOWN);
            System.arraycopy(bArr, 1, bArr2, 1, bArr.length - 1);
            return null;
        } else if (i2 == 3) {
            int length = bArr.length - 1;
            byte[] bArr3 = new byte[length];
            System.arraycopy(bArr, 1, bArr3, 0, bArr.length - 1);
            ByteBuffer order = ByteBuffer.allocate(length + this.O00000oo.length).order(ByteOrder.BIG_ENDIAN);
            order.put(this.O00000oo);
            order.put(bArr3);
            byte[] array = order.array();
            this.O00000oo = array;
            return array;
        } else if (i2 != 2) {
            return null;
        } else {
            int length2 = bArr.length - 1;
            byte[] bArr4 = new byte[length2];
            System.arraycopy(bArr, 1, bArr4, 0, bArr.length - 1);
            ByteBuffer order2 = ByteBuffer.allocate(length2 + this.O00000oo.length).order(ByteOrder.BIG_ENDIAN);
            order2.put(this.O00000oo);
            order2.put(bArr4);
            this.O00000oo = order2.array();
            return null;
        }
    }

    private boolean O00000Oo(byte[] bArr) {
        int i = (bArr[0] & 192) >> 6;
        return i == 1 || i == 2 || i == 3;
    }

    private byte[] O00000Oo(int i, byte[] bArr) {
        int length = ((i - 1) + bArr.length) / i;
        if (length <= 1) {
            return bArr;
        }
        int i2 = length - 1;
        int length2 = bArr.length - i2;
        byte[] bArr2 = new byte[length2];
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            int min = Math.min(length2 - i3, i);
            if (i5 == 0) {
                System.arraycopy(bArr, i4, bArr2, i3, min);
                bArr2[0] = (byte) (bArr2[0] & 63);
            } else {
                if (i5 != i2) {
                    min--;
                }
                System.arraycopy(bArr, i4 + 1, bArr2, i3, min);
            }
            i4 += i;
            i3 += min;
        }
        return bArr2;
    }

    public void O000000o() {
        this.O0000Oo0 = O00000o0;
        UUID uuid = o00o00o000.O0000OoO;
        UUID uuid2 = o00o00o000.O0000o00;
        CommandBean newInstance = CommandBean.newInstance();
        newInstance.serviceUUID = uuid;
        newInstance.macAddress = this.O0000OOo;
        newInstance.characteristicUUID = uuid2;
        O000000o(newInstance, this.O0000OoO);
    }

    public void O000000o(byte[] bArr) {
        a.j.a.a a2 = a.j.a.a.a();
        UUID b2 = a2.b(a.c.SERVICE);
        UUID b3 = a2.b(a.c.NOTIFY);
        CommandBean newInstance = CommandBean.newInstance();
        newInstance.type = CommandBean.CommandType.WRITE;
        newInstance.data = bArr;
        newInstance.macAddress = this.O0000OOo;
        newInstance.serviceUUID = b2;
        newInstance.characteristicUUID = b3;
        O000000o(newInstance, (i) new SigMeshNotificationAction$4(this));
    }

    public void O00000Oo() {
        o00oo0oo00.O000000o("NotificationAction", "enableProvisioningNotification");
        this.O0000Oo0 = O00000Oo;
        UUID uuid = o00o00o000.O00000oO;
        UUID uuid2 = o00o00o000.O0000O0o;
        CommandBean newInstance = CommandBean.newInstance();
        newInstance.serviceUUID = uuid;
        newInstance.macAddress = this.O0000OOo;
        newInstance.characteristicUUID = uuid2;
        O000000o(newInstance, this.O0000Oo);
    }

    public void O00000o() {
        a.j.a.a a2 = a.j.a.a.a();
        UUID b2 = a2.b(a.c.SERVICE);
        UUID b3 = a2.b(a.c.NOTIFY);
        CommandBean newInstance = CommandBean.newInstance();
        newInstance.serviceUUID = b2;
        newInstance.macAddress = this.O0000OOo;
        newInstance.characteristicUUID = b3;
        O000000o(newInstance, (h) new SigMeshNotificationAction$3(this));
    }

    public void O00000o0() {
        o00oo0oo00.O000000o("NotificationAction", "enableProxyNotification");
        this.O0000Oo0 = O000000o;
        UUID uuid = o00o00o000.O0000OOo;
        UUID uuid2 = o00o00o000.O0000Oo;
        CommandBean newInstance = CommandBean.newInstance();
        newInstance.serviceUUID = uuid;
        newInstance.macAddress = this.O0000OOo;
        newInstance.characteristicUUID = uuid2;
        O000000o(newInstance, this.O0000Oo);
    }

    public void O00000oO() {
        this.O00000oO = null;
    }

    public void O00000oo() {
        O000000o(new byte[]{1});
    }
}
