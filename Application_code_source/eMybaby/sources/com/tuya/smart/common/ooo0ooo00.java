package com.tuya.smart.common;

import a.a.a.a.a;
import a.e.a.a.o.j.e;
import com.tuya.sdk.sigmesh.action.SigOtaAction$10;
import com.tuya.sdk.sigmesh.action.SigOtaAction$5;
import com.tuya.sdk.sigmesh.action.SigOtaAction$6;
import com.tuya.sdk.sigmesh.action.SigOtaAction$7;
import com.tuya.sdk.sigmesh.action.SigOtaAction$8;
import com.tuya.sdk.sigmesh.action.SigOtaAction$9;
import com.tuya.sdk.sigmesh.bean.ControlMessage;
import com.tuya.sdk.sigmesh.bean.Message;
import com.tuya.sdk.sigmesh.util.ExtendedInvalidCipherTextException;
import com.tuya.sdk.timer.bean.DpTimerBean;
import com.tuya.sdk.tuyamesh.bean.CommandBean;
import com.tuya.smart.common.o00o0o0o0o;
import com.tuya.smart.common.o00o0oo0oo;
import com.tuya.smart.common.ooo0oo0o0;
import java.util.ArrayList;
import java.util.UUID;

public class ooo0ooo00 extends o00o0oo0oo {
    public static final int O000000o = 65280;
    public static final int O00000Oo = 65281;
    public static final int O00000o0 = 65282;
    public static final String O0000o00 = "SigOtaAction";
    public ooo0oo0o0.O000000o O0000o = new ooo0oo0o0.O000000o() {
        public void O000000o(String str) {
            ooo0ooo00.this.O0000OoO.postDelayed(new Runnable() {
                public void run() {
                    ooo0ooo00.this.O0000Ooo();
                }
            }, 500);
        }

        public void O000000o(String str, String str2) {
            o00oo0oo00.O00000Oo(ooo0ooo00.O0000o00, "notify fail " + str + DpTimerBean.FILL + str2);
            if (ooo0ooo00.this.O0000OOo != null) {
                ooo0ooo00.this.O0000OOo.O000000o(String.valueOf(str), "start notify error");
            }
        }

        public void O000000o(byte[] bArr) {
            StringBuilder n = a.n("Notify onUnSecretNotify --> ");
            n.append(o00oo0o00o.O00000Oo(bArr, ":"));
            o00oo0oo00.O000000o(ooo0ooo00.O0000o00, n.toString());
            if (bArr[0] != 0 && bArr[0] == 2) {
                try {
                    Message O00000o = ooo0ooo00.this.O0000o0o.O00000o(bArr);
                    if (O00000o == null) {
                        o00oo0oo00.O00000o(ooo0ooo00.O0000o00, "Message reassembly may not be completed yet!");
                    } else if (O00000o instanceof ControlMessage) {
                        ooo0o0o00 O0000O0o = oo0o0oooo.O000000o().O0000O0o();
                        if (((ControlMessage) O00000o).getOpCode() != 3) {
                            return;
                        }
                        if (O0000O0o instanceof ooo0o0ooo) {
                            o00oo0oo00.O00000Oo(ooo0ooo00.O0000o00, "Proxy Config SetFilter Type success");
                            ooo0ooo00.this.O0000OoO.postDelayed(new Runnable() {
                                public void run() {
                                    ooo0ooo00.this.O0000OoO();
                                }
                            }, 500);
                        } else if (O0000O0o instanceof ooo0o0o0o) {
                            o00oo0oo00.O00000Oo(ooo0ooo00.O0000o00, "Proxy Config AddAddress To Filter success");
                        }
                    }
                } catch (ExtendedInvalidCipherTextException e2) {
                    StringBuilder n2 = a.n("Decryption failed in ");
                    n2.append(e2.getTag());
                    n2.append(" : ");
                    n2.append(e2.getMessage());
                    o00oo0oo00.O00000Oo(ooo0ooo00.O0000o00, n2.toString());
                }
            }
        }

        public void O00000Oo() {
        }
    };
    public int O0000o0;
    public ooo0oo0o0 O0000o0O;
    public o000oo0000 O0000o0o;

    public class O000000o extends o00o0oo0oo.O00000Oo {
        public byte[] O00000o;
        public int O00000o0;
        public int O00000oO;

        public O000000o() {
        }

        public void O000000o() {
            this.O00000oO = 0;
            this.O00000o0 = 0;
            this.O00000Oo = -1;
            this.O00000o = null;
        }

        public void O000000o(byte[] bArr) {
            O000000o();
            this.O00000o = bArr;
            int length = bArr.length;
            int i = length % 16;
            int i2 = length / 16;
            if (i != 0) {
                i2 = (int) Math.floor((double) (i2 + 1));
            }
            this.O00000o0 = i2;
        }

        public void O000000o(byte[] bArr, int i) {
            bArr[0] = (byte) (i & 255);
            bArr[1] = (byte) ((i >> 8) & 255);
        }

        public byte[] O000000o(int i) {
            int length = this.O00000o.length;
            if (length > 16) {
                length = i + 1 == this.O00000o0 ? length - (i * 16) : 16;
            }
            int i2 = length + 4;
            byte[] bArr = new byte[20];
            for (int i3 = 0; i3 < 20; i3++) {
                bArr[i3] = -1;
            }
            System.arraycopy(this.O00000o, i * 16, bArr, 2, i2 - 4);
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
            throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.ooo0ooo00.O000000o.O00000Oo(byte[]):int");
        }

        public void O00000Oo(byte[] bArr, int i) {
            int length = bArr.length - 2;
            bArr[length] = (byte) (i & 255);
            bArr[length + 1] = (byte) ((i >> 8) & 255);
        }

        public boolean O00000Oo() {
            int i = this.O00000o0;
            return i > 0 && this.O00000Oo + 1 < i;
        }

        public int O00000o() {
            return this.O00000Oo + 1;
        }

        public boolean O00000o0() {
            return this.O00000Oo + 1 == this.O00000o0;
        }

        public byte[] O00000oO() {
            int O00000o2 = O00000o();
            byte[] O000000o2 = O000000o(O00000o2);
            this.O00000Oo = O00000o2;
            return O000000o2;
        }

        public byte[] O00000oo() {
            byte[] bArr = new byte[16];
            for (int i = 0; i < 16; i++) {
                bArr[i] = -1;
            }
            O000000o(bArr, O00000o());
            O00000Oo(bArr, O00000Oo(bArr));
            return bArr;
        }

        public int O0000O0o() {
            return this.O00000oO;
        }

        public int O0000OOo() {
            return this.O00000Oo;
        }

        public boolean O0000Oo0() {
            int floor = (int) Math.floor((double) ((((float) O00000o()) / ((float) this.O00000o0)) * 100.0f));
            if (floor == this.O00000oO) {
                return false;
            }
            this.O00000oO = floor;
            return true;
        }
    }

    public ooo0ooo00(o00oo0000o o00oo0000o) {
        super(o00oo0000o);
        this.O0000o0 = o00oo0000o.O0000O0o();
        this.O0000o0o = oo0o0oooo.O000000o().O0000OoO();
        O000000o o000000o = new O000000o();
        this.O00000oO = o000000o;
        o000000o.O000000o(this.O00000o);
    }

    /* access modifiers changed from: private */
    public void O0000OoO() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new o000oo0o00(oo0o0oooo.O000000o().O00000o0()[0], oo0o0oooo.O000000o().O00000o0()[1]));
        arrayList.add(new o000oo0o00((byte) -1, (byte) -1));
        new ooo0o0o0o(arrayList).O000000o(this.O00000oo, this.O0000o0o, oo0o0oooo.O000000o().O00000o0(), o000oo0o0o.O000000o(this.O0000o0), new o00o0o0o0o.O000000o() {
            public void O000000o(String str, String str2) {
                if (ooo0ooo00.this.O0000OOo != null) {
                    ooo0ooo00.this.O0000OOo.O000000o(String.valueOf(str), "start notify error");
                }
            }

            public void O00000Oo() {
                ooo0ooo00.this.O0000OoO.postDelayed(new Runnable() {
                    public void run() {
                        ooo0ooo00.this.O0000o00();
                    }
                }, 500);
            }
        });
    }

    /* access modifiers changed from: private */
    public void O0000Ooo() {
        new ooo0o0ooo(0).O000000o(this.O00000oo, this.O0000o0o, oo0o0oooo.O000000o().O00000o0(), o000oo0o0o.O000000o(this.O0000o0), new o00o0o0o0o.O000000o() {
            public void O000000o(String str, String str2) {
                if (ooo0ooo00.this.O0000OOo != null) {
                    ooo0ooo00.this.O0000OOo.O000000o(String.valueOf(str), "start notify error");
                }
            }

            public void O00000Oo() {
            }
        });
    }

    /* access modifiers changed from: private */
    public void O0000o0() {
        UUID uuid = o00o00o000.O000000o;
        UUID uuid2 = o00o00o000.O00000Oo;
        CommandBean newInstance = CommandBean.newInstance();
        newInstance.serviceUUID = uuid;
        newInstance.macAddress = this.O00000oo;
        newInstance.characteristicUUID = uuid2;
        newInstance.data = new byte[]{1, -1};
        O00000Oo(newInstance, new SigOtaAction$7(this));
    }

    /* access modifiers changed from: private */
    public void O0000o00() {
        UUID uuid = o00o00o000.O000000o;
        UUID uuid2 = o00o00o000.O00000Oo;
        CommandBean newInstance = CommandBean.newInstance();
        newInstance.serviceUUID = uuid;
        newInstance.macAddress = this.O00000oo;
        newInstance.characteristicUUID = uuid2;
        newInstance.data = new byte[]{0, -1};
        O00000Oo(newInstance, new SigOtaAction$6(this));
    }

    /* access modifiers changed from: private */
    public void O0000o0O() {
        o00oo0oo00.O000000o(O0000o00, "sendOtaEndCommand");
        UUID uuid = o00o00o000.O000000o;
        UUID uuid2 = o00o00o000.O00000Oo;
        CommandBean newInstance = CommandBean.newInstance();
        newInstance.serviceUUID = uuid;
        newInstance.macAddress = this.O00000oo;
        newInstance.characteristicUUID = uuid2;
        int O0000OOo = ((O000000o) this.O00000oO).O0000OOo();
        int i = O0000OOo ^ -1;
        newInstance.data = new byte[]{2, -1, (byte) (O0000OOo & 255), (byte) ((O0000OOo >> 8) & 255), (byte) (i & 255), (byte) ((i >> 8) & 255)};
        O00000Oo(newInstance, new SigOtaAction$8(this));
    }

    public void O000000o() {
        this.O0000Ooo = System.currentTimeMillis();
        o00oo0oo00.O000000o(O0000o00, "sendOtaData");
        if (!this.O0000Oo0) {
            this.O0000o0O = new ooo0oo0o0(this.O00000oo, this.O0000o);
            this.O0000OoO.postDelayed(new Runnable() {
                public void run() {
                    ooo0ooo00.this.O0000o0O.O00000o0();
                }
            }, 2000);
            this.O0000Oo0 = true;
        }
    }

    public void O000000o(O00o0 o00o0) {
        UUID uuid = o00o00o000.O00000o0;
        UUID uuid2 = o00o00o000.O00000o;
        CommandBean newInstance = CommandBean.newInstance();
        newInstance.serviceUUID = uuid;
        newInstance.macAddress = this.O00000oo;
        newInstance.characteristicUUID = uuid2;
        o00oo0oo00.O00000Oo(O0000o00, "read requestFirmware");
        O000000o(newInstance, (e) new SigOtaAction$9(this, o00o0));
    }

    public boolean O00000o0() {
        int O00000o = this.O00000oO.O00000o() * 16;
        if (O00000o <= 0 || O00000o % 128 != 0) {
            return false;
        }
        StringBuilder n = a.n("onCommandSampled ota read packet ");
        n.append(this.O00000oO.O00000o());
        o00oo0oo00.O000000o(O0000o00, n.toString());
        UUID uuid = o00o00o000.O00000o0;
        UUID uuid2 = o00o00o000.O00000o;
        CommandBean newInstance = CommandBean.newInstance();
        newInstance.serviceUUID = uuid;
        newInstance.macAddress = this.O00000oo;
        newInstance.characteristicUUID = uuid2;
        O000000o(newInstance, (e) new SigOtaAction$10(this));
        return true;
    }

    public boolean a_() {
        if (!this.O00000oO.O00000Oo()) {
            return false;
        }
        UUID uuid = o00o00o000.O000000o;
        UUID uuid2 = o00o00o000.O00000Oo;
        CommandBean newInstance = CommandBean.newInstance();
        newInstance.serviceUUID = uuid;
        newInstance.macAddress = this.O00000oo;
        newInstance.characteristicUUID = uuid2;
        newInstance.data = this.O00000oO.O00000oO();
        O00000Oo(newInstance, new SigOtaAction$5(this, ((O000000o) this.O00000oO).O00000o0()));
        return false;
    }
}
