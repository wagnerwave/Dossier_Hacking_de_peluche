package com.tuya.smart.common;

import a.a.a.a.a;
import com.tutk.IOTC.AVFrame;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class O00Ooo00 {
    public static final String O000000o = "AuthKeyUUIDParser";
    public List<O00000Oo> O00000Oo = new ArrayList();
    public int O00000o0;

    public static class O000000o {
        public String O000000o;
        public String O00000Oo;

        public String O000000o() {
            return this.O000000o;
        }

        public void O000000o(String str) {
            this.O000000o = str;
        }

        public String O00000Oo() {
            String O000000o2 = o00oo0oo0o.O000000o(this.O000000o);
            return O000000o2.length() > 24 ? O000000o2.substring(8, 24) : "";
        }

        public void O00000Oo(String str) {
            this.O00000Oo = str;
        }

        public String O00000o0() {
            return this.O00000Oo;
        }
    }

    public static class O00000Oo {
        public int O000000o;
        public byte[] O00000Oo;

        public O00000Oo() {
        }

        public static /* synthetic */ int O00000Oo(O00000Oo o00000Oo) {
            int i = o00000Oo.O000000o;
            o00000Oo.O000000o = i + 1;
            return i;
        }

        public static /* synthetic */ int O00000o0(O00000Oo o00000Oo) {
            int i = o00000Oo.O000000o;
            o00000Oo.O000000o = i - 1;
            return i;
        }
    }

    private byte O000000o(byte[] bArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += bArr[i3];
        }
        return (byte) (i2 & 255);
    }

    private byte[] O00000Oo() {
        if (!O00000o0()) {
            StringBuilder n = a.n("valiadate data failure ");
            n.append(this.O00000Oo.size());
            o00oo0oo00.O000000o(O000000o, n.toString());
            return null;
        }
        byte[] bArr = new byte[this.O00000o0];
        for (O00000Oo next : this.O00000Oo) {
            if (next.O000000o == 255) {
                int unused = next.O000000o = this.O00000o0 / 7;
                if (this.O00000o0 % 7 != 0) {
                    O00000Oo.O00000Oo(next);
                }
                O00000Oo.O00000o0(next);
            }
            System.arraycopy(next.O00000Oo, 0, bArr, next.O000000o * 7, next.O00000Oo.length);
        }
        return bArr;
    }

    private boolean O00000o0() {
        int i = this.O00000o0;
        if (i == 0) {
            return false;
        }
        int i2 = i / 7;
        if (i % 7 != 0) {
            i2++;
        }
        return this.O00000Oo.size() == i2;
    }

    public O000000o O000000o() {
        byte[] O00000Oo2 = O00000Oo();
        if (O00000Oo2 == null) {
            return null;
        }
        StringBuilder n = a.n("data:");
        n.append(o00oo0o00o.O00000Oo(O00000Oo2, " "));
        o00oo0oo00.O00000Oo(O000000o, n.toString());
        O000000o o000000o = new O000000o();
        int i = O00000Oo2[1] & AVFrame.FRM_STATE_UNKOWN;
        byte b2 = O00000Oo2[0] & AVFrame.FRM_STATE_UNKOWN;
        byte b3 = O00000Oo2[i + 2];
        byte[] bArr = new byte[i];
        byte[] bArr2 = new byte[((b2 - i) - 3)];
        System.arraycopy(O00000Oo2, 2, bArr, 0, i);
        System.arraycopy(O00000Oo2, i + 3, bArr2, 0, b3);
        o00oo0oo00.O00000Oo(O000000o, "authkey:" + o00oo0o00o.O00000Oo(bArr, " "));
        try {
            o000000o.O000000o(new String(bArr, "US-ASCII"));
            o000000o.O00000Oo(new String(bArr2, "US-ASCII"));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        return o000000o;
    }

    public void O000000o(byte[] bArr) {
        byte b2 = bArr[0] & AVFrame.FRM_STATE_UNKOWN;
        int i = bArr[1] & AVFrame.FRM_STATE_UNKOWN;
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 2, bArr2, 0, i);
        O00000Oo o00000Oo = new O00000Oo();
        byte[] unused = o00000Oo.O00000Oo = bArr2;
        int unused2 = o00000Oo.O000000o = b2;
        if (b2 == 0) {
            this.O00000o0 = bArr[2] & AVFrame.FRM_STATE_UNKOWN;
        }
        int i2 = i + 2;
        if (O000000o(bArr, i2) == bArr[i2]) {
            this.O00000Oo.add(o00000Oo);
        }
    }
}
