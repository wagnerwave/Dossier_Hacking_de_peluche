package a.d.c.t.b;

import a.d.c.r.e;
import com.tuya.spongycastle.crypto.macs.HMac;
import com.tuya.spongycastle.math.ec.Tnaf;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final NumberFormat f3042a = new DecimalFormat("000000000");

    /* renamed from: b  reason: collision with root package name */
    public static final NumberFormat f3043b = new DecimalFormat("000");

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f3044c = {"\nABCDEFGHIJKLMNOPQRSTUVWXYZ￺\u001c\u001d\u001e￻ ￼\"#$%&'()*+,-./0123456789:￱￲￳￴￸", "`abcdefghijklmnopqrstuvwxyz￺\u001c\u001d\u001e￻{￼}~;<=>?[\\]^_ ,./:@!|￼￵￶￼￰￲￳￴￷", "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚ￺\u001c\u001d\u001eÛÜÝÞßª¬±²³µ¹º¼½¾￷ ￹￳￴￸", "àáâãäåæçèéêëìíîïðñòóôõö÷øùú￺\u001c\u001d\u001e￻ûüýþÿ¡¨«¯°´·¸»¿￷ ￲￹￴￸", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a￺￼￼\u001b￻\u001c\u001d\u001e\u001f ¢£¤¥¦§©­®¶￷ ￲￳￹￸", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?"};

    public static e a(byte[] bArr, int i) {
        String str;
        int i2;
        StringBuilder sb = new StringBuilder(144);
        if (i == 2 || i == 3) {
            if (i == 2) {
                str = new DecimalFormat("0000000000".substring(0, b(bArr, new byte[]{39, 40, 41, 42, 31, 32}))).format((long) b(bArr, new byte[]{33, 34, 35, 36, 25, 26, 27, 28, 29, 30, 19, 20, 21, 22, 23, 24, 13, 14, 15, Tnaf.POW_2_WIDTH, 17, 18, 7, 8, 9, 10, 11, 12, 1, 2}));
            } else {
                str = String.valueOf(new char[]{f3044c[0].charAt(b(bArr, new byte[]{39, 40, 41, 42, 31, 32})), f3044c[0].charAt(b(bArr, new byte[]{33, 34, 35, 36, 25, 26})), f3044c[0].charAt(b(bArr, new byte[]{27, 28, 29, 30, 19, 20})), f3044c[0].charAt(b(bArr, new byte[]{21, 22, 23, 24, 13, 14})), f3044c[0].charAt(b(bArr, new byte[]{15, Tnaf.POW_2_WIDTH, 17, 18, 7, 8})), f3044c[0].charAt(b(bArr, new byte[]{9, 10, 11, 12, 1, 2}))});
            }
            String format = f3043b.format((long) b(bArr, new byte[]{53, HMac.IPAD, 43, 44, 45, 46, 47, 48, 37, 38}));
            String format2 = f3043b.format((long) b(bArr, new byte[]{55, 56, 57, 58, 59, 60, 49, 50, 51, 52}));
            sb.append(c(bArr, 10, 84));
            if (sb.toString().startsWith("[)>\u001e01\u001d")) {
                sb.insert(9, str + 29 + format + 29 + format2 + 29);
            } else {
                sb.insert(0, str + 29 + format + 29 + format2 + 29);
            }
        } else {
            if (i == 4) {
                i2 = 93;
            } else if (i == 5) {
                i2 = 77;
            }
            sb.append(c(bArr, 1, i2));
        }
        return new e(bArr, sb.toString(), (List<byte[]>) null, String.valueOf(i));
    }

    public static int b(byte[] bArr, byte[] bArr2) {
        int i = 0;
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            int i3 = bArr2[i2] - 1;
            i += (((1 << (5 - (i3 % 6))) & bArr[i3 / 6]) == 0 ? 0 : 1) << ((bArr2.length - i2) - 1);
        }
        return i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0050, code lost:
        r6 = r4;
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005a, code lost:
        r7 = r5 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005c, code lost:
        if (r5 != 0) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005e, code lost:
        r4 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005f, code lost:
        r3 = r3 + 1;
        r5 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004b, code lost:
        r5 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c(byte[] r12, int r13, int r14) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            r2 = -1
            r3 = r13
            r4 = 0
            r5 = -1
            r6 = 0
        L_0x000b:
            int r7 = r13 + r14
            r8 = 1
            if (r3 >= r7) goto L_0x0062
            java.lang.String[] r7 = f3044c
            r7 = r7[r4]
            byte r9 = r12[r3]
            char r7 = r7.charAt(r9)
            switch(r7) {
                case 65520: goto L_0x0053;
                case 65521: goto L_0x0053;
                case 65522: goto L_0x0053;
                case 65523: goto L_0x0053;
                case 65524: goto L_0x0053;
                case 65525: goto L_0x004f;
                case 65526: goto L_0x004d;
                case 65527: goto L_0x004a;
                case 65528: goto L_0x0048;
                case 65529: goto L_0x004b;
                case 65530: goto L_0x001d;
                case 65531: goto L_0x0021;
                default: goto L_0x001d;
            }
        L_0x001d:
            r0.append(r7)
            goto L_0x005a
        L_0x0021:
            int r3 = r3 + 1
            byte r7 = r12[r3]
            int r7 = r7 << 24
            int r3 = r3 + r8
            byte r9 = r12[r3]
            int r9 = r9 << 18
            int r7 = r7 + r9
            int r3 = r3 + r8
            byte r9 = r12[r3]
            int r9 = r9 << 12
            int r7 = r7 + r9
            int r3 = r3 + r8
            byte r9 = r12[r3]
            int r9 = r9 << 6
            int r7 = r7 + r9
            int r3 = r3 + r8
            byte r9 = r12[r3]
            int r7 = r7 + r9
            java.text.NumberFormat r9 = f3042a
            long r10 = (long) r7
            java.lang.String r7 = r9.format(r10)
            r0.append(r7)
            goto L_0x005a
        L_0x0048:
            r4 = 1
            goto L_0x004b
        L_0x004a:
            r4 = 0
        L_0x004b:
            r5 = -1
            goto L_0x005a
        L_0x004d:
            r5 = 3
            goto L_0x0050
        L_0x004f:
            r5 = 2
        L_0x0050:
            r6 = r4
            r4 = 0
            goto L_0x005a
        L_0x0053:
            r5 = 65520(0xfff0, float:9.1813E-41)
            int r7 = r7 - r5
            r6 = r4
            r4 = r7
            r5 = 1
        L_0x005a:
            int r7 = r5 + -1
            if (r5 != 0) goto L_0x005f
            r4 = r6
        L_0x005f:
            int r3 = r3 + r8
            r5 = r7
            goto L_0x000b
        L_0x0062:
            int r12 = r0.length()
            if (r12 <= 0) goto L_0x007f
            int r12 = r0.length()
            int r12 = r12 - r8
            char r12 = r0.charAt(r12)
            r13 = 65532(0xfffc, float:9.183E-41)
            if (r12 != r13) goto L_0x007f
            int r12 = r0.length()
            int r12 = r12 - r8
            r0.setLength(r12)
            goto L_0x0062
        L_0x007f:
            java.lang.String r12 = r0.toString()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.c.t.b.b.c(byte[], int, int):java.lang.String");
    }
}
