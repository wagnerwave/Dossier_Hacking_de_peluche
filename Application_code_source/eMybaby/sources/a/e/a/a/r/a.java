package a.e.a.a.r;

import android.text.TextUtils;
import com.tuya.smart.common.oOO0O0O0;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f3295a = new byte[0];

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] cArr = new char[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            cArr[i] = (char) bArr[i];
        }
        stringBuffer.append(cArr);
        return stringBuffer.toString();
    }

    public static String b(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (!(bArr == null || bArr.length == 0)) {
            for (int i = 0; i < bArr.length; i++) {
                sb.append(b.o("%02X", Byte.valueOf(bArr[i])));
            }
        }
        return sb.toString();
    }

    public static int c(String str) {
        if (!TextUtils.isEmpty(str)) {
            return Integer.parseInt(str, 16);
        }
        return 0;
    }

    public static String d(int i) {
        String hexString = Integer.toHexString(i);
        return hexString.length() % 2 == 1 ? a.a.a.a.a.k(oOO0O0O0.O0000oO0, hexString) : hexString;
    }
}
