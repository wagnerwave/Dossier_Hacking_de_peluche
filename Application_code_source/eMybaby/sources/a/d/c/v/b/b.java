package a.d.c.v.b;

import java.math.BigInteger;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f3126a = {';', '<', '>', '@', '[', '\\', '}', '_', '`', '~', '!', 13, 9, ',', ':', 10, '-', '.', '$', '/', '\"', '|', '*', '(', ')', '?', '{', '}', '\''};

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f3127b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '&', 13, 9, ',', ':', '#', '-', '.', '$', '/', '+', '%', '*', '=', '^'};

    /* renamed from: c  reason: collision with root package name */
    public static final BigInteger[] f3128c;

    public enum a {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        f3128c = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900);
        f3128c[1] = valueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = f3128c;
            if (i < bigIntegerArr2.length) {
                bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(valueOf);
                i++;
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0059 A[LOOP:1: B:22:0x0057->B:23:0x0059, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(int r21, int[] r22, int r23, java.lang.StringBuilder r24) {
        /*
            r0 = r21
            r1 = r24
            r3 = 900(0x384, double:4.447E-321)
            r7 = 922(0x39a, float:1.292E-42)
            r8 = 6
            r9 = 0
            r11 = 923(0x39b, float:1.293E-42)
            r12 = 928(0x3a0, float:1.3E-42)
            r13 = 902(0x386, float:1.264E-42)
            r14 = 924(0x39c, float:1.295E-42)
            r15 = 901(0x385, float:1.263E-42)
            r5 = 900(0x384, float:1.261E-42)
            if (r0 != r15) goto L_0x0088
            char[] r0 = new char[r8]
            int[] r6 = new int[r8]
            r10 = r23
            r2 = 0
            r16 = 0
            r18 = 0
        L_0x0023:
            r8 = r22[r9]
            if (r10 >= r8) goto L_0x0076
            if (r18 != 0) goto L_0x0076
            int r8 = r10 + 1
            r10 = r22[r10]
            if (r10 >= r5) goto L_0x0039
            r6[r2] = r10
            int r2 = r2 + 1
            long r16 = r16 * r3
            long r3 = (long) r10
            long r16 = r16 + r3
            goto L_0x0048
        L_0x0039:
            if (r10 == r5) goto L_0x004a
            if (r10 == r15) goto L_0x004a
            if (r10 == r13) goto L_0x004a
            if (r10 == r14) goto L_0x004a
            if (r10 == r12) goto L_0x004a
            if (r10 == r11) goto L_0x004a
            if (r10 != r7) goto L_0x0048
            goto L_0x004a
        L_0x0048:
            r10 = r8
            goto L_0x004f
        L_0x004a:
            int r8 = r8 + -1
            r10 = r8
            r18 = 1
        L_0x004f:
            int r3 = r2 % 5
            if (r3 != 0) goto L_0x0071
            if (r2 <= 0) goto L_0x0071
            r2 = 0
            r3 = 6
        L_0x0057:
            if (r2 >= r3) goto L_0x006d
            int r3 = 5 - r2
            r19 = 256(0x100, double:1.265E-321)
            long r7 = r16 % r19
            int r8 = (int) r7
            char r7 = (char) r8
            r0[r3] = r7
            r3 = 8
            long r16 = r16 >> r3
            int r2 = r2 + 1
            r3 = 6
            r7 = 922(0x39a, float:1.292E-42)
            goto L_0x0057
        L_0x006d:
            r1.append(r0)
            r2 = 0
        L_0x0071:
            r3 = 900(0x384, double:4.447E-321)
            r7 = 922(0x39a, float:1.292E-42)
            goto L_0x0023
        L_0x0076:
            int r0 = r2 / 5
            int r0 = r0 * 5
        L_0x007a:
            if (r0 >= r2) goto L_0x0085
            r3 = r6[r0]
            char r3 = (char) r3
            r1.append(r3)
            int r0 = r0 + 1
            goto L_0x007a
        L_0x0085:
            r0 = r10
            goto L_0x00f1
        L_0x0088:
            if (r0 != r14) goto L_0x00ef
            r0 = r23
            r2 = 0
            r3 = 0
            r16 = 0
        L_0x0090:
            r6 = r22[r9]
            if (r0 >= r6) goto L_0x00f1
            if (r2 != 0) goto L_0x00f1
            int r6 = r0 + 1
            r0 = r22[r0]
            if (r0 >= r5) goto L_0x00a9
            int r3 = r3 + 1
            r7 = 900(0x384, double:4.447E-321)
            long r16 = r16 * r7
            long r7 = (long) r0
            long r16 = r16 + r7
            r0 = r6
            r4 = 922(0x39a, float:1.292E-42)
            goto L_0x00c2
        L_0x00a9:
            if (r0 == r5) goto L_0x00bc
            if (r0 == r15) goto L_0x00bc
            if (r0 == r13) goto L_0x00bc
            if (r0 == r14) goto L_0x00bc
            if (r0 == r12) goto L_0x00bc
            if (r0 == r11) goto L_0x00bc
            r4 = 922(0x39a, float:1.292E-42)
            if (r0 != r4) goto L_0x00ba
            goto L_0x00be
        L_0x00ba:
            r0 = r6
            goto L_0x00c2
        L_0x00bc:
            r4 = 922(0x39a, float:1.292E-42)
        L_0x00be:
            int r6 = r6 + -1
            r0 = r6
            r2 = 1
        L_0x00c2:
            int r6 = r3 % 5
            if (r6 != 0) goto L_0x00e9
            if (r3 <= 0) goto L_0x00e9
            r6 = 6
            char[] r7 = new char[r6]
            r8 = 0
        L_0x00cc:
            if (r8 >= r6) goto L_0x00e3
            int r10 = 5 - r8
            r19 = 255(0xff, double:1.26E-321)
            long r4 = r16 & r19
            int r5 = (int) r4
            char r4 = (char) r5
            r7[r10] = r4
            r4 = 8
            long r16 = r16 >> r4
            int r8 = r8 + 1
            r4 = 922(0x39a, float:1.292E-42)
            r5 = 900(0x384, float:1.261E-42)
            goto L_0x00cc
        L_0x00e3:
            r4 = 8
            r1.append(r7)
            goto L_0x00ec
        L_0x00e9:
            r4 = 8
            r6 = 6
        L_0x00ec:
            r5 = 900(0x384, float:1.261E-42)
            goto L_0x0090
        L_0x00ef:
            r0 = r23
        L_0x00f1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.c.v.b.b.a(int, int[], int, java.lang.StringBuilder):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0095, code lost:
        r3 = c(r14, r3, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static a.d.c.r.e b(int[] r14) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = 100
            r0.<init>(r1)
            r1 = 1
            r2 = r14[r1]
            r3 = 2
        L_0x000b:
            r4 = 0
            r5 = r14[r4]
            if (r3 >= r5) goto L_0x00ad
            r5 = 913(0x391, float:1.28E-42)
            if (r2 == r5) goto L_0x009a
            r5 = 924(0x39c, float:1.295E-42)
            if (r2 == r5) goto L_0x009a
            switch(r2) {
                case 900: goto L_0x0095;
                case 901: goto L_0x009a;
                case 902: goto L_0x001f;
                default: goto L_0x001b;
            }
        L_0x001b:
            int r3 = r3 + -1
            goto L_0x0095
        L_0x001f:
            r2 = 15
            int[] r2 = new int[r2]
            r6 = 0
            r7 = 0
        L_0x0025:
            r8 = r14[r4]
            if (r3 >= r8) goto L_0x009e
            if (r6 != 0) goto L_0x009e
            int r8 = r3 + 1
            r3 = r14[r3]
            r9 = r14[r4]
            if (r8 != r9) goto L_0x0034
            r6 = 1
        L_0x0034:
            r9 = 900(0x384, float:1.261E-42)
            if (r3 >= r9) goto L_0x003d
            r2[r7] = r3
            int r7 = r7 + 1
            goto L_0x0054
        L_0x003d:
            if (r3 == r9) goto L_0x0051
            r9 = 901(0x385, float:1.263E-42)
            if (r3 == r9) goto L_0x0051
            if (r3 == r5) goto L_0x0051
            r9 = 928(0x3a0, float:1.3E-42)
            if (r3 == r9) goto L_0x0051
            r9 = 923(0x39b, float:1.293E-42)
            if (r3 == r9) goto L_0x0051
            r9 = 922(0x39a, float:1.292E-42)
            if (r3 != r9) goto L_0x0054
        L_0x0051:
            int r8 = r8 + -1
            r6 = 1
        L_0x0054:
            int r9 = r7 % 15
            if (r9 == 0) goto L_0x005e
            r9 = 902(0x386, float:1.264E-42)
            if (r3 == r9) goto L_0x005e
            if (r6 == 0) goto L_0x0090
        L_0x005e:
            java.math.BigInteger r3 = java.math.BigInteger.ZERO
            r9 = 0
        L_0x0061:
            if (r9 >= r7) goto L_0x007c
            java.math.BigInteger[] r10 = f3128c
            int r11 = r7 - r9
            int r11 = r11 - r1
            r10 = r10[r11]
            r11 = r2[r9]
            long r11 = (long) r11
            java.math.BigInteger r11 = java.math.BigInteger.valueOf(r11)
            java.math.BigInteger r10 = r10.multiply(r11)
            java.math.BigInteger r3 = r3.add(r10)
            int r9 = r9 + 1
            goto L_0x0061
        L_0x007c:
            java.lang.String r3 = r3.toString()
            char r7 = r3.charAt(r4)
            r9 = 49
            if (r7 != r9) goto L_0x0092
            java.lang.String r3 = r3.substring(r1)
            r0.append(r3)
            r7 = 0
        L_0x0090:
            r3 = r8
            goto L_0x0025
        L_0x0092:
            a.d.c.f r14 = a.d.c.f.f2869a
            throw r14
        L_0x0095:
            int r3 = c(r14, r3, r0)
            goto L_0x009e
        L_0x009a:
            int r3 = a(r2, r14, r3, r0)
        L_0x009e:
            int r2 = r14.length
            if (r3 >= r2) goto L_0x00aa
            int r2 = r3 + 1
            r3 = r14[r3]
            r13 = r3
            r3 = r2
            r2 = r13
            goto L_0x000b
        L_0x00aa:
            a.d.c.f r14 = a.d.c.f.f2869a
            throw r14
        L_0x00ad:
            a.d.c.r.e r14 = new a.d.c.r.e
            java.lang.String r0 = r0.toString()
            r1 = 0
            r14.<init>(r1, r0, r1, r1)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.c.v.b.b.b(int[]):a.d.c.r.e");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0077, code lost:
        if (r15 == 29) goto L_0x00bb;
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0129 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0126  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int c(int[] r16, int r17, java.lang.StringBuilder r18) {
        /*
            r0 = r18
            r1 = 0
            r2 = r16[r1]
            r3 = 1
            int r2 = r2 << r3
            int[] r2 = new int[r2]
            r4 = r16[r1]
            int r4 = r4 << r3
            int[] r4 = new int[r4]
            r5 = r17
            r6 = 0
            r7 = 0
        L_0x0012:
            r8 = r16[r1]
            r9 = 913(0x391, float:1.28E-42)
            if (r5 >= r8) goto L_0x0049
            if (r6 != 0) goto L_0x0049
            int r8 = r5 + 1
            r5 = r16[r5]
            r10 = 900(0x384, float:1.261E-42)
            if (r5 >= r10) goto L_0x002f
            int r9 = r5 / 30
            r2[r7] = r9
            int r9 = r7 + 1
            int r5 = r5 % 30
            r2[r9] = r5
            int r7 = r7 + 2
            goto L_0x0038
        L_0x002f:
            if (r5 == r9) goto L_0x003e
            r9 = 924(0x39c, float:1.295E-42)
            if (r5 == r9) goto L_0x003a
            switch(r5) {
                case 900: goto L_0x003a;
                case 901: goto L_0x003a;
                case 902: goto L_0x003a;
                default: goto L_0x0038;
            }
        L_0x0038:
            r5 = r8
            goto L_0x0012
        L_0x003a:
            int r5 = r8 + -1
            r6 = 1
            goto L_0x0012
        L_0x003e:
            r2[r7] = r9
            int r5 = r8 + 1
            r8 = r16[r8]
            r4[r7] = r8
            int r7 = r7 + 1
            goto L_0x0012
        L_0x0049:
            a.d.c.v.b.b$a r6 = a.d.c.v.b.b.a.MIXED
            a.d.c.v.b.b$a r8 = a.d.c.v.b.b.a.LOWER
            a.d.c.v.b.b$a r10 = a.d.c.v.b.b.a.PUNCT_SHIFT
            a.d.c.v.b.b$a r11 = a.d.c.v.b.b.a.ALPHA
            r13 = r11
            r14 = r13
            r12 = 0
        L_0x0054:
            if (r12 >= r7) goto L_0x0131
            r15 = r2[r12]
            int r1 = r13.ordinal()
            r9 = 29
            if (r1 == 0) goto L_0x00ef
            if (r1 == r3) goto L_0x00c9
            r3 = 2
            if (r1 == r3) goto L_0x009e
            r3 = 3
            if (r1 == r3) goto L_0x008c
            r3 = 4
            if (r1 == r3) goto L_0x007a
            r3 = 5
            if (r1 == r3) goto L_0x0070
            goto L_0x010e
        L_0x0070:
            if (r15 >= r9) goto L_0x0077
            char[] r1 = f3126a
            char r1 = r1[r15]
            goto L_0x0081
        L_0x0077:
            if (r15 != r9) goto L_0x0089
            goto L_0x00bb
        L_0x007a:
            r1 = 26
            if (r15 >= r1) goto L_0x0084
            int r15 = r15 + 65
            char r1 = (char) r15
        L_0x0081:
            r13 = r14
            goto L_0x00f6
        L_0x0084:
            if (r15 != r1) goto L_0x0089
            r13 = r14
            goto L_0x00fc
        L_0x0089:
            r13 = r14
            goto L_0x010e
        L_0x008c:
            if (r15 >= r9) goto L_0x0094
            char[] r1 = f3126a
            char r1 = r1[r15]
            goto L_0x00f6
        L_0x0094:
            if (r15 != r9) goto L_0x0097
            goto L_0x00bb
        L_0x0097:
            r1 = 913(0x391, float:1.28E-42)
            if (r15 != r1) goto L_0x0123
            r1 = r4[r12]
            goto L_0x00eb
        L_0x009e:
            r1 = 25
            if (r15 >= r1) goto L_0x00a7
            char[] r1 = f3127b
            char r1 = r1[r15]
            goto L_0x00f6
        L_0x00a7:
            if (r15 != r1) goto L_0x00ad
            a.d.c.v.b.b$a r13 = a.d.c.v.b.b.a.PUNCT
            goto L_0x010e
        L_0x00ad:
            r1 = 26
            if (r15 != r1) goto L_0x00b2
            goto L_0x00fc
        L_0x00b2:
            r1 = 27
            if (r15 != r1) goto L_0x00b7
            goto L_0x0107
        L_0x00b7:
            r1 = 28
            if (r15 != r1) goto L_0x00be
        L_0x00bb:
            r13 = r11
            goto L_0x010e
        L_0x00be:
            if (r15 != r9) goto L_0x00c2
            goto L_0x0113
        L_0x00c2:
            r1 = 913(0x391, float:1.28E-42)
            if (r15 != r1) goto L_0x0123
            r1 = r4[r12]
            goto L_0x00eb
        L_0x00c9:
            r1 = 26
            if (r15 >= r1) goto L_0x00d0
            int r15 = r15 + 97
            goto L_0x00f5
        L_0x00d0:
            if (r15 != r1) goto L_0x00d3
            goto L_0x00fc
        L_0x00d3:
            r1 = 27
            if (r15 != r1) goto L_0x00dd
            a.d.c.v.b.b$a r1 = a.d.c.v.b.b.a.ALPHA_SHIFT
            r14 = r13
            r13 = r1
            r1 = 0
            goto L_0x00f6
        L_0x00dd:
            r1 = 28
            if (r15 != r1) goto L_0x00e2
            goto L_0x010d
        L_0x00e2:
            if (r15 != r9) goto L_0x00e5
            goto L_0x0113
        L_0x00e5:
            r1 = 913(0x391, float:1.28E-42)
            if (r15 != r1) goto L_0x0123
            r1 = r4[r12]
        L_0x00eb:
            r3 = r1
            r1 = 913(0x391, float:1.28E-42)
            goto L_0x011f
        L_0x00ef:
            r1 = 26
            if (r15 >= r1) goto L_0x00fa
            int r15 = r15 + 65
        L_0x00f5:
            char r1 = (char) r15
        L_0x00f6:
            r3 = r1
            r1 = 913(0x391, float:1.28E-42)
            goto L_0x0124
        L_0x00fa:
            if (r15 != r1) goto L_0x0103
        L_0x00fc:
            r1 = 32
            r1 = 913(0x391, float:1.28E-42)
            r3 = 32
            goto L_0x0124
        L_0x0103:
            r1 = 27
            if (r15 != r1) goto L_0x0109
        L_0x0107:
            r13 = r8
            goto L_0x010e
        L_0x0109:
            r1 = 28
            if (r15 != r1) goto L_0x0111
        L_0x010d:
            r13 = r6
        L_0x010e:
            r1 = 913(0x391, float:1.28E-42)
            goto L_0x0123
        L_0x0111:
            if (r15 != r9) goto L_0x0119
        L_0x0113:
            r14 = r13
            r1 = 913(0x391, float:1.28E-42)
            r3 = 0
            r13 = r10
            goto L_0x0124
        L_0x0119:
            r1 = 913(0x391, float:1.28E-42)
            if (r15 != r1) goto L_0x0123
            r3 = r4[r12]
        L_0x011f:
            char r3 = (char) r3
            r0.append(r3)
        L_0x0123:
            r3 = 0
        L_0x0124:
            if (r3 == 0) goto L_0x0129
            r0.append(r3)
        L_0x0129:
            int r12 = r12 + 1
            r1 = 0
            r3 = 1
            r9 = 913(0x391, float:1.28E-42)
            goto L_0x0054
        L_0x0131:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.c.v.b.b.c(int[], int, java.lang.StringBuilder):int");
    }
}
