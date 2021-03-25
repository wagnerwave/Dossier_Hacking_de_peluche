package e.b.a.a.a.u.r;

import com.tutk.IOTC.AVFrame;
import com.tuya.spongycastle.math.ec.Tnaf;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f5300a = "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

    public static byte[] a(String str) {
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        byte[] bArr = new byte[((length * 3) / 4)];
        int i = 0;
        int i2 = 0;
        while (true) {
            if (length < 4) {
                break;
            }
            long c2 = c(bytes, i, 4);
            length -= 4;
            i += 4;
            for (int i3 = 2; i3 >= 0; i3--) {
                bArr[i2 + i3] = (byte) ((int) (c2 & 255));
                c2 >>= 8;
            }
            i2 += 3;
        }
        if (length == 3) {
            long c3 = c(bytes, i, 3);
            for (int i4 = 1; i4 >= 0; i4--) {
                bArr[i2 + i4] = (byte) ((int) (c3 & 255));
                c3 >>= 8;
            }
        }
        if (length == 2) {
            bArr[i2] = (byte) ((int) (c(bytes, i, 2) & 255));
        }
        return bArr;
    }

    public static String b(byte[] bArr) {
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer(((length + 2) / 3) * 4);
        int i = 0;
        while (length >= 3) {
            stringBuffer.append(d((long) (((bArr[i] & AVFrame.FRM_STATE_UNKOWN) << Tnaf.POW_2_WIDTH) | ((bArr[i + 1] & AVFrame.FRM_STATE_UNKOWN) << 8) | (bArr[i + 2] & AVFrame.FRM_STATE_UNKOWN)), 4));
            i += 3;
            length -= 3;
        }
        if (length == 2) {
            stringBuffer.append(d((long) (((bArr[i] & AVFrame.FRM_STATE_UNKOWN) << 8) | (bArr[i + 1] & AVFrame.FRM_STATE_UNKOWN)), 3));
        }
        if (length == 1) {
            stringBuffer.append(d((long) (bArr[i] & AVFrame.FRM_STATE_UNKOWN), 2));
        }
        return stringBuffer.toString();
    }

    public static final long c(byte[] bArr, int i, int i2) {
        int i3 = 0;
        long j = 0;
        while (i2 > 0) {
            i2--;
            int i4 = i + 1;
            byte b2 = bArr[i];
            long j2 = b2 == 47 ? 1 : 0;
            if (b2 >= 48 && b2 <= 57) {
                j2 = (long) ((b2 + 2) - 48);
            }
            if (b2 >= 65 && b2 <= 90) {
                j2 = (long) ((b2 + 12) - 65);
            }
            if (b2 >= 97 && b2 <= 122) {
                j2 = (long) ((b2 + 38) - 97);
            }
            j += j2 << i3;
            i3 += 6;
            i = i4;
        }
        return j;
    }

    public static final String d(long j, int i) {
        StringBuffer stringBuffer = new StringBuffer(i);
        while (i > 0) {
            i--;
            stringBuffer.append(f5300a[(int) (63 & j)]);
            j >>= 6;
        }
        return stringBuffer.toString();
    }
}
