package d.a.a;

import com.tutk.IOTC.AVFrame;
import com.tutk.IOTC.Camera;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f4810a;

    /* renamed from: b  reason: collision with root package name */
    public static String f4811b;

    /* renamed from: c  reason: collision with root package name */
    public static String f4812c;

    /* renamed from: d  reason: collision with root package name */
    public static String f4813d;

    /* renamed from: e  reason: collision with root package name */
    public static String f4814e;
    public static String f;
    public static String g;
    public static String h;

    public static String a(byte[] bArr) {
        char[] charArray = Camera.HEXES.toCharArray();
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i] & AVFrame.FRM_STATE_UNKOWN;
            int i2 = i * 2;
            cArr[i2] = charArray[b2 >>> 4];
            cArr[i2 + 1] = charArray[b2 & 15];
        }
        return new String(cArr).replaceAll("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})", "$1-$2-$3-$4-$5");
    }
}
