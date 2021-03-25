package com.tuya.smart.common;

import a.e.a.a.n.a;
import com.tutk.IOTC.AVFrame;
import com.tuya.sdk.sigmesh.bean.OTAFileRep;
import com.tuya.sdk.sigmesh.bean.Ret;
import java.util.ArrayList;
import java.util.List;

public class o00o000ooo {
    public static final String O000000o = "TuyaOtaDataReceiver";
    public final int O00000Oo = 0;
    public final int O00000o = 2;
    public final int O00000o0 = 1;
    public final int O00000oO = 3;
    public int O00000oo = 0;
    public int O0000O0o = 0;
    public int O0000OOo = 0;
    public int O0000Oo = 0;
    public List<byte[]> O0000Oo0 = new ArrayList();

    public static int O000000o(OTAFileRep oTAFileRep, byte[] bArr) {
        try {
            if (a.a(o00o0000oo.O000000o(bArr, 0, oTAFileRep.alreadyLength)) == oTAFileRep.alreadyCRC32) {
                return oTAFileRep.alreadyLength;
            }
            o00oo0oo00.O00000Oo(O000000o, "getFileAccessIndex:  crc32 is not equal ，start from 0");
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private int O000000o(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return 2;
        }
        int i = 0;
        int i2 = 0;
        while (i < 4 && i < bArr.length) {
            byte b2 = bArr[i];
            i2 |= (b2 & Byte.MAX_VALUE) << (i * 7);
            if (((b2 >> 7) & 1) == 0) {
                break;
            }
            i++;
        }
        if (i == 4) {
            return 2;
        }
        int i3 = i + 1;
        if (i2 == 0) {
            int i4 = 0;
            while (i3 <= i + 4 && i3 < bArr.length) {
                byte b3 = bArr[i3];
                i4 |= (b3 & Byte.MAX_VALUE) << (((i3 - 1) - i) * 7);
                if (((b3 >> 7) & 1) == 0) {
                    break;
                }
                i3++;
            }
            this.O0000O0o = i4;
            this.O0000OOo = 0;
            this.O00000oo = 0;
            if (i3 == i + 5 || bArr.length < i3 + 2) {
                return 2;
            }
            this.O0000Oo0.clear();
            int i5 = i3 + 1;
            this.O0000Oo = (bArr[i5] >> 4) & 15;
            i3 = i5 + 1;
        }
        if (i2 == 0 || i2 > this.O00000oo) {
            byte[] O000000o2 = o00o0000oo.O000000o(bArr, i3, bArr.length - i3);
            this.O0000OOo += O000000o2.length;
            this.O00000oo = i2;
            this.O0000Oo0.add(O000000o2);
            o00oo0oo00.O00000o0(O000000o, "index = " + i2 + ",maxLength = " + this.O0000O0o + ", receLength = " + this.O0000OOo + ",tempLength = " + O000000o2.length);
            int i6 = this.O0000OOo;
            int i7 = this.O0000O0o;
            if (i6 < i7) {
                return 1;
            }
            return i6 == i7 ? 0 : 3;
        }
        StringBuilder n = a.a.a.a.a.n("unpack:  something wrong lastIndex = ");
        n.append(this.O00000oo);
        n.append(", index = ");
        n.append(i2);
        o00oo0oo00.O00000Oo(O000000o, n.toString());
        return 2;
    }

    public Ret O000000o(byte[] bArr, String str, byte[] bArr2) {
        int O000000o2 = O000000o(bArr);
        if (O000000o2 == 0) {
            Ret ret = new Ret();
            ret.version = this.O0000Oo;
            byte[] O000000o3 = o00o0000oo.O000000o(this.O0000Oo0);
            ret.raw = O000000o3;
            if (!(O000000o3 == null || O000000o3.length == 0)) {
                ret.parse(O000000o((int) O000000o3[0] & AVFrame.FRM_STATE_UNKOWN, str, bArr2));
            }
            return ret;
        } else if (O000000o2 == 1) {
            o00oo0oo00.O000000o(O000000o, "parseDataReceived: wait for next frame");
            return null;
        } else {
            o00oo0oo00.O00000Oo(O000000o, "parseDataReceived: something wrong");
            return null;
        }
    }

    public byte[] O000000o(int i, String str, byte[] bArr) {
        if (i == 4) {
            return o00o0000oo.O00000Oo(str);
        }
        if (i == 5) {
            return o00o0000oo.O00000Oo(str, bArr);
        }
        return null;
    }
}
