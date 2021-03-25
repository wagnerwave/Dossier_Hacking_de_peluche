package a.d.c.r;

import a.d.c.e;
import com.tutk.IOTC.AVFrame;
import java.util.Map;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2993a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f2994b;

    static {
        String property = System.getProperty("file.encoding");
        f2993a = property;
        f2994b = "SJIS".equalsIgnoreCase(property) || "EUC_JP".equalsIgnoreCase(f2993a);
    }

    public static String a(byte[] bArr, Map<e, ?> map) {
        byte b2;
        byte b3;
        String str;
        byte[] bArr2 = bArr;
        Map<e, ?> map2 = map;
        if (map2 != null && (str = (String) map2.get(e.CHARACTER_SET)) != null) {
            return str;
        }
        if (bArr2.length > 3 && bArr2[0] == -17 && bArr2[1] == -69 && bArr2[2] == -65) {
            return "UTF8";
        }
        int length = bArr2.length;
        boolean z = true;
        boolean z2 = true;
        boolean z3 = true;
        int i = 0;
        boolean z4 = false;
        int i2 = 0;
        int i3 = 0;
        boolean z5 = false;
        boolean z6 = false;
        for (int i4 = 0; i4 < length && (z || z2 || z3); i4++) {
            byte b4 = bArr2[i4] & AVFrame.FRM_STATE_UNKOWN;
            if (b4 < 128 || b4 > 191) {
                if (i > 0) {
                    z3 = false;
                }
                if (b4 >= 192 && b4 <= 253) {
                    for (int i5 = b4; (i5 & 64) != 0; i5 <<= 1) {
                        i++;
                    }
                    z4 = true;
                }
            } else if (i > 0) {
                i--;
            }
            if ((b4 == 194 || b4 == 195) && i4 < length - 1 && (b3 = bArr2[i4 + 1] & AVFrame.FRM_STATE_UNKOWN) <= 191 && ((b4 == 194 && b3 >= 160) || (b4 == 195 && b3 >= 128))) {
                z5 = true;
            }
            if (b4 >= Byte.MAX_VALUE && b4 <= 159) {
                z = false;
            }
            if (b4 >= 161 && b4 <= 223 && !z6) {
                i3++;
            }
            if (!z6 && ((b4 >= 240 && b4 <= 255) || b4 == 128 || b4 == 160)) {
                z2 = false;
            }
            if (((b4 < 129 || b4 > 159) && (b4 < 224 || b4 > 239)) || z6) {
                z6 = false;
            } else {
                if (i4 < bArr2.length - 1 && (b2 = bArr2[i4 + 1] & AVFrame.FRM_STATE_UNKOWN) >= 64 && b2 <= 252) {
                    i2++;
                } else {
                    z2 = false;
                }
                z6 = true;
            }
        }
        return (!z2 || !f2994b) ? (!(i > 0 ? false : z3) || !z4) ? (!z2 || (i2 < 3 && i3 * 20 <= length)) ? (z5 || !z) ? f2993a : "ISO8859_1" : "SJIS" : "UTF8" : "SJIS";
    }
}
