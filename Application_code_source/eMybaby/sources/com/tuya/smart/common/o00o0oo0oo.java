package com.tuya.smart.common;

import a.e.a.a.o.j.e;
import a.j.a.a;
import a.j.a.c;
import android.os.Handler;
import android.os.Looper;
import com.tuya.sdk.timer.bean.DpTimerBean;
import com.tuya.sdk.tuyamesh.bean.CommandBean;
import com.tuya.sdk.tuyamesh.blemesh.action.OtaAction$1;
import com.tuya.sdk.tuyamesh.blemesh.action.OtaAction$2;
import com.tuya.sdk.tuyamesh.blemesh.action.OtaAction$3;
import com.tuya.sdk.tuyamesh.blemesh.action.OtaAction$5;
import com.tuya.smart.common.o00o0oo0o0;
import java.util.UUID;

public class o00o0oo0oo extends o00o0o0o0o {
    public static final String O000000o = "OtaAction";
    public final byte[] O00000o;
    public O00000Oo O00000oO;
    public String O00000oo;
    public byte[] O0000O0o;
    public O000000o O0000OOo;
    public o00o0oo0o0 O0000Oo = null;
    public boolean O0000Oo0;
    public Handler O0000OoO = new Handler(Looper.getMainLooper());
    public long O0000Ooo = 0;

    public interface O000000o {
        void O000000o();

        void O000000o(int i);

        void O000000o(String str, String str2);
    }

    public static class O00000Oo {
        public int O000000o;
        public int O00000Oo = -1;
        public int O00000o;
        public byte[] O00000o0;

        public void O000000o() {
            this.O00000o = 0;
            this.O000000o = 0;
            this.O00000Oo = -1;
            this.O00000o0 = null;
        }

        public void O000000o(byte[] bArr) {
            O000000o();
            this.O00000o0 = bArr;
            int length = bArr.length;
            int i = length % 16;
            int i2 = length / 16;
            if (i != 0) {
                i2 = (int) Math.floor((double) (i2 + 1));
            }
            this.O000000o = i2;
        }

        public void O000000o(byte[] bArr, int i) {
            bArr[0] = (byte) (i & 255);
            bArr[1] = (byte) ((i >> 8) & 255);
        }

        public byte[] O000000o(int i) {
            int length = this.O00000o0.length;
            if (length > 16) {
                length = i + 1 == this.O000000o ? length - (i * 16) : 16;
            }
            int i2 = length + 4;
            byte[] bArr = new byte[i2];
            System.arraycopy(this.O00000o0, i * 16, bArr, 2, i2 - 4);
            O000000o(bArr, i);
            O00000Oo(bArr, O00000Oo(bArr));
            return bArr;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: byte} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int O00000Oo(byte[] r10) {
            /*
                r9 = this;
                int r0 = r10.length
                r1 = 2
                int r0 = r0 - r1
                short[] r1 = new short[r1]
                r1 = {0, -24575} // fill-array
                r2 = 0
                r3 = 65535(0xffff, float:9.1834E-41)
                r4 = 0
                r5 = 65535(0xffff, float:9.1834E-41)
            L_0x0010:
                if (r4 >= r0) goto L_0x002a
                byte r6 = r10[r4]
                r7 = 0
            L_0x0015:
                r8 = 8
                if (r7 >= r8) goto L_0x0027
                int r8 = r5 >> 1
                r5 = r5 ^ r6
                r5 = r5 & 1
                short r5 = r1[r5]
                r5 = r5 & r3
                r5 = r5 ^ r8
                int r6 = r6 >> 1
                int r7 = r7 + 1
                goto L_0x0015
            L_0x0027:
                int r4 = r4 + 1
                goto L_0x0010
            L_0x002a:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.o00o0oo0oo.O00000Oo.O00000Oo(byte[]):int");
        }

        public void O00000Oo(byte[] bArr, int i) {
            int length = bArr.length - 2;
            bArr[length] = (byte) (i & 255);
            bArr[length + 1] = (byte) ((i >> 8) & 255);
        }

        public boolean O00000Oo() {
            int i = this.O000000o;
            return i > 0 && this.O00000Oo + 1 < i;
        }

        public int O00000o() {
            return this.O00000Oo + 1;
        }

        public byte[] O00000oO() {
            int O00000o2 = O00000o();
            byte[] O000000o2 = O000000o(O00000o2);
            this.O00000Oo = O00000o2;
            return O000000o2;
        }

        public byte[] O00000oo() {
            byte[] bArr = new byte[4];
            int O00000o2 = O00000o();
            O000000o(bArr, O00000o2);
            int O00000Oo2 = O00000Oo(bArr);
            O00000Oo(bArr, O00000Oo2);
            o00oo0oo00.O000000o(o00o0oo0oo.O000000o, "ota check packet ---> index : " + O00000o2 + " crc : " + O00000Oo2 + " content : " + o00oo0o00o.O00000Oo(bArr, ":"));
            return bArr;
        }

        public int O0000O0o() {
            return this.O00000o;
        }

        public boolean O0000Oo0() {
            int floor = (int) Math.floor((double) ((((float) O00000o()) / ((float) this.O000000o)) * 100.0f));
            if (floor == this.O00000o) {
                return false;
            }
            this.O00000o = floor;
            return true;
        }
    }

    public o00o0oo0oo(o00oo0000o o00oo0000o) {
        this.O00000o = o00oo0000o.O0000Oo();
        O00000Oo o00000Oo = new O00000Oo();
        this.O00000oO = o00000Oo;
        o00000Oo.O000000o(this.O00000o);
        this.O00000oo = o00oo0000o.O00000Oo();
        this.O0000O0o = o00oo0000o.O00000o();
        this.O0000OOo = o00oo0000o.O00000o0();
    }

    public void O000000o() {
        this.O0000Ooo = System.currentTimeMillis();
        o00oo0oo00.O000000o(O000000o, "sendOtaData");
        if (!this.O0000Oo0) {
            a_();
            this.O0000Oo0 = true;
        }
    }

    public void O000000o(O00o0 o00o0) {
        UUID uuid = c.SERVICE_DEVICE_INFORMATION.f3721a;
        UUID uuid2 = c.CHARACTERISTIC_FIRMWARE.f3721a;
        CommandBean newInstance = CommandBean.newInstance();
        newInstance.serviceUUID = uuid;
        newInstance.macAddress = this.O00000oo;
        newInstance.characteristicUUID = uuid2;
        O000000o(newInstance, (e) new OtaAction$5(this, o00o0));
    }

    public int O00000o() {
        return this.O00000oO.O0000O0o();
    }

    public boolean O00000o0() {
        int i = a.a().f3701e;
        int O00000o2 = this.O00000oO.O00000o() * 16;
        if (O00000o2 <= 0 || O00000o2 % i != 0) {
            return false;
        }
        a a2 = a.a();
        UUID b2 = a2.b(a.c.SERVICE);
        UUID b3 = a2.b(a.c.OTA);
        CommandBean newInstance = CommandBean.newInstance();
        newInstance.serviceUUID = b2;
        newInstance.macAddress = this.O00000oo;
        newInstance.characteristicUUID = b3;
        O000000o(newInstance, (e) new OtaAction$2(this));
        return true;
    }

    public void O00000oO() {
        O000000o o000000o;
        if (this.O00000oO.O0000Oo0() && (o000000o = this.O0000OOo) != null) {
            o000000o.O000000o(O00000o());
        }
    }

    public void O00000oo() {
        o00oo0oo00.O00000Oo(O000000o, "sendOtaCheckPacket");
        a a2 = a.a();
        UUID b2 = a2.b(a.c.SERVICE);
        UUID b3 = a2.b(a.c.OTA);
        CommandBean newInstance = CommandBean.newInstance();
        newInstance.serviceUUID = b2;
        newInstance.macAddress = this.O00000oo;
        newInstance.characteristicUUID = b3;
        O000000o(newInstance, (e) new OtaAction$3(this));
    }

    public void O0000O0o() {
        this.O0000OoO.removeCallbacksAndMessages((Object) null);
        this.O00000oO.O000000o();
        this.O0000Oo0 = false;
    }

    public void O0000OOo() {
        O0000O0o();
    }

    public void O0000Oo() {
        this.O0000OOo = null;
        this.O0000Oo0 = false;
    }

    public void O0000Oo0() {
        o00o0oo0o0 o00o0oo0o0 = new o00o0oo0o0(this.O00000oo, this.O0000O0o, new o00o0oo0o0.O000000o() {
            public void O000000o() {
                o00oo0oo00.O000000o(o00o0oo0oo.O000000o, "enableNotificationSuccess ");
            }

            public void O000000o(String str, String str2) {
                o00oo0oo00.O000000o(o00o0oo0oo.O000000o, "enableNotification onFailure  " + str + DpTimerBean.FILL + str2);
            }

            public void O000000o(byte[] bArr) {
                StringBuilder n = a.a.a.a.a.n("OTA Notify: ");
                n.append(o00oo0o00o.O00000Oo(bArr, ":"));
                o00oo0oo00.O000000o(o00o0oo0oo.O000000o, n.toString());
            }

            public void O00000Oo() {
                o00oo0oo00.O000000o(o00o0oo0oo.O000000o, "enableNotification onSuccess");
            }
        });
        this.O0000Oo = o00o0oo0o0;
        o00o0oo0o0.O000000o();
    }

    public boolean a_() {
        int i = a.a().f3700d;
        boolean z = false;
        a a2 = a.a();
        UUID b2 = a2.b(a.c.SERVICE);
        UUID b3 = a2.b(a.c.OTA);
        CommandBean newInstance = CommandBean.newInstance();
        newInstance.serviceUUID = b2;
        newInstance.macAddress = this.O00000oo;
        newInstance.characteristicUUID = b3;
        if (this.O00000oO.O00000Oo()) {
            newInstance.data = this.O00000oO.O00000oO();
        } else {
            newInstance.data = this.O00000oO.O00000oo();
            z = true;
        }
        O00000Oo(newInstance, new OtaAction$1(this, z));
        return z;
    }
}
