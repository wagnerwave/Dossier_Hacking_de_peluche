package a.d.c.u.p.f.c;

import a.d.c.r.a;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    public final a f3116a;

    /* renamed from: b  reason: collision with root package name */
    public final m f3117b = new m();

    /* renamed from: c  reason: collision with root package name */
    public final StringBuilder f3118c = new StringBuilder();

    public s(a aVar) {
        this.f3116a = aVar;
    }

    public static int d(a aVar, int i, int i2) {
        if (i2 <= 32) {
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                if (aVar.a(i + i4)) {
                    i3 |= 1 << ((i2 - i4) - 1);
                }
            }
            return i3;
        }
        throw new IllegalArgumentException("extractNumberValueFromBitArray can't handle more than 32 bits");
    }

    public String a(StringBuilder sb, int i) {
        String str = null;
        while (true) {
            o b2 = b(i, str);
            String a2 = r.a(b2.f3105b);
            if (a2 != null) {
                sb.append(a2);
            }
            String valueOf = b2.f3107d ? String.valueOf(b2.f3106c) : null;
            int i2 = b2.f3110a;
            if (i == i2) {
                return sb.toString();
            }
            i = i2;
            str = valueOf;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0396, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0055, code lost:
        if (r1 >= 63) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x03a7, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0176, code lost:
        if (r1 >= 253) goto L_0x017a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x02c6  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x03b1  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x03c1  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x03d3  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x00ec A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0258 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x0372 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x017d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a.d.c.u.p.f.c.o b(int r14, java.lang.String r15) {
        /*
            r13 = this;
            java.lang.StringBuilder r0 = r13.f3118c
            r1 = 0
            r0.setLength(r1)
            if (r15 == 0) goto L_0x000d
            java.lang.StringBuilder r0 = r13.f3118c
            r0.append(r15)
        L_0x000d:
            a.d.c.u.p.f.c.m r15 = r13.f3117b
            r15.f3098a = r14
            a.d.c.u.p.f.c.m$a r14 = a.d.c.u.p.f.c.m.a.NUMERIC
            a.d.c.u.p.f.c.m$a r15 = a.d.c.u.p.f.c.m.a.ISO_IEC_646
            a.d.c.u.p.f.c.m$a r0 = a.d.c.u.p.f.c.m.a.ALPHA
        L_0x0017:
            a.d.c.u.p.f.c.m r1 = r13.f3117b
            int r2 = r1.f3098a
            a.d.c.u.p.f.c.m$a r1 = r1.f3099b
            if (r1 != r0) goto L_0x0021
            r1 = 1
            goto L_0x0022
        L_0x0021:
            r1 = 0
        L_0x0022:
            r3 = 15
            r4 = 16
            r5 = 32
            r6 = 63
            r7 = 36
            r8 = 5
            if (r1 == 0) goto L_0x0129
        L_0x002f:
            a.d.c.u.p.f.c.m r1 = r13.f3117b
            int r1 = r1.f3098a
            int r9 = r1 + 5
            a.d.c.r.a r10 = r13.f3116a
            int r11 = r10.f2965b
            r12 = 6
            if (r9 <= r11) goto L_0x003d
            goto L_0x0059
        L_0x003d:
            int r9 = d(r10, r1, r8)
            if (r9 < r8) goto L_0x0046
            if (r9 >= r4) goto L_0x0046
            goto L_0x0057
        L_0x0046:
            int r9 = r1 + 6
            a.d.c.r.a r10 = r13.f3116a
            int r11 = r10.f2965b
            if (r9 <= r11) goto L_0x004f
            goto L_0x0059
        L_0x004f:
            int r1 = d(r10, r1, r12)
            if (r1 < r4) goto L_0x0059
            if (r1 >= r6) goto L_0x0059
        L_0x0057:
            r1 = 1
            goto L_0x005a
        L_0x0059:
            r1 = 0
        L_0x005a:
            if (r1 == 0) goto L_0x00ec
            a.d.c.u.p.f.c.m r1 = r13.f3117b
            int r1 = r1.f3098a
            a.d.c.r.a r9 = r13.f3116a
            int r9 = d(r9, r1, r8)
            if (r9 != r3) goto L_0x0070
            a.d.c.u.p.f.c.n r9 = new a.d.c.u.p.f.c.n
            int r1 = r1 + 5
            r9.<init>(r1, r7)
            goto L_0x00bd
        L_0x0070:
            if (r9 < r8) goto L_0x0081
            if (r9 >= r3) goto L_0x0081
            a.d.c.u.p.f.c.n r10 = new a.d.c.u.p.f.c.n
            int r1 = r1 + 5
            int r9 = r9 + 48
            int r9 = r9 - r8
            char r9 = (char) r9
            r10.<init>(r1, r9)
        L_0x007f:
            r9 = r10
            goto L_0x00bd
        L_0x0081:
            a.d.c.r.a r9 = r13.f3116a
            int r9 = d(r9, r1, r12)
            r10 = 58
            if (r9 < r5) goto L_0x0098
            if (r9 >= r10) goto L_0x0098
            a.d.c.u.p.f.c.n r10 = new a.d.c.u.p.f.c.n
            int r1 = r1 + 6
            int r9 = r9 + 33
            char r9 = (char) r9
            r10.<init>(r1, r9)
            goto L_0x007f
        L_0x0098:
            switch(r9) {
                case 58: goto L_0x00b3;
                case 59: goto L_0x00b0;
                case 60: goto L_0x00ad;
                case 61: goto L_0x00aa;
                case 62: goto L_0x00a7;
                default: goto L_0x009b;
            }
        L_0x009b:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "Decoding invalid alphanumeric value: "
            java.lang.String r15 = a.a.a.a.a.h(r15, r9)
            r14.<init>(r15)
            throw r14
        L_0x00a7:
            r9 = 47
            goto L_0x00b5
        L_0x00aa:
            r9 = 46
            goto L_0x00b5
        L_0x00ad:
            r9 = 45
            goto L_0x00b5
        L_0x00b0:
            r9 = 44
            goto L_0x00b5
        L_0x00b3:
            r9 = 42
        L_0x00b5:
            a.d.c.u.p.f.c.n r10 = new a.d.c.u.p.f.c.n
            int r1 = r1 + 6
            r10.<init>(r1, r9)
            goto L_0x007f
        L_0x00bd:
            a.d.c.u.p.f.c.m r1 = r13.f3117b
            int r10 = r9.f3110a
            r1.f3098a = r10
            char r1 = r9.f3104b
            if (r1 != r7) goto L_0x00c9
            r1 = 1
            goto L_0x00ca
        L_0x00c9:
            r1 = 0
        L_0x00ca:
            if (r1 == 0) goto L_0x00e3
            a.d.c.u.p.f.c.o r1 = new a.d.c.u.p.f.c.o
            a.d.c.u.p.f.c.m r3 = r13.f3117b
            int r3 = r3.f3098a
            java.lang.StringBuilder r4 = r13.f3118c
            java.lang.String r4 = r4.toString()
            r1.<init>(r3, r4)
            a.d.c.u.p.f.c.l r3 = new a.d.c.u.p.f.c.l
            r4 = 1
            r3.<init>(r1, r4)
            goto L_0x0293
        L_0x00e3:
            java.lang.StringBuilder r1 = r13.f3118c
            char r9 = r9.f3104b
            r1.append(r9)
            goto L_0x002f
        L_0x00ec:
            a.d.c.u.p.f.c.m r1 = r13.f3117b
            int r1 = r1.f3098a
            boolean r1 = r13.e(r1)
            if (r1 == 0) goto L_0x0101
            a.d.c.u.p.f.c.m r1 = r13.f3117b
            r3 = 3
            r1.a(r3)
            a.d.c.u.p.f.c.m r1 = r13.f3117b
            r1.f3099b = r14
            goto L_0x0120
        L_0x0101:
            a.d.c.u.p.f.c.m r1 = r13.f3117b
            int r1 = r1.f3098a
            boolean r1 = r13.f(r1)
            if (r1 == 0) goto L_0x0120
            a.d.c.u.p.f.c.m r1 = r13.f3117b
            int r3 = r1.f3098a
            int r3 = r3 + r8
            a.d.c.r.a r4 = r13.f3116a
            int r4 = r4.f2965b
            if (r3 >= r4) goto L_0x011a
            r1.a(r8)
            goto L_0x011c
        L_0x011a:
            r1.f3098a = r4
        L_0x011c:
            a.d.c.u.p.f.c.m r1 = r13.f3117b
            r1.f3099b = r15
        L_0x0120:
            a.d.c.u.p.f.c.l r3 = new a.d.c.u.p.f.c.l
            r1 = 0
            r4 = 0
            r3.<init>(r1, r4)
            goto L_0x0293
        L_0x0129:
            a.d.c.u.p.f.c.m r1 = r13.f3117b
            a.d.c.u.p.f.c.m$a r1 = r1.f3099b
            if (r1 != r15) goto L_0x0131
            r1 = 1
            goto L_0x0132
        L_0x0131:
            r1 = 0
        L_0x0132:
            r5 = 7
            if (r1 == 0) goto L_0x0298
        L_0x0135:
            a.d.c.u.p.f.c.m r1 = r13.f3117b
            int r1 = r1.f3098a
            int r6 = r1 + 5
            a.d.c.r.a r7 = r13.f3116a
            int r9 = r7.f2965b
            r10 = 116(0x74, float:1.63E-43)
            r11 = 64
            r12 = 8
            if (r6 <= r9) goto L_0x0148
            goto L_0x017a
        L_0x0148:
            int r6 = d(r7, r1, r8)
            if (r6 < r8) goto L_0x0151
            if (r6 >= r4) goto L_0x0151
            goto L_0x0178
        L_0x0151:
            int r6 = r1 + 7
            a.d.c.r.a r7 = r13.f3116a
            int r9 = r7.f2965b
            if (r6 <= r9) goto L_0x015a
            goto L_0x017a
        L_0x015a:
            int r6 = d(r7, r1, r5)
            if (r6 < r11) goto L_0x0163
            if (r6 >= r10) goto L_0x0163
            goto L_0x0178
        L_0x0163:
            int r6 = r1 + 8
            a.d.c.r.a r7 = r13.f3116a
            int r9 = r7.f2965b
            if (r6 <= r9) goto L_0x016c
            goto L_0x017a
        L_0x016c:
            int r1 = d(r7, r1, r12)
            r6 = 232(0xe8, float:3.25E-43)
            if (r1 < r6) goto L_0x017a
            r6 = 253(0xfd, float:3.55E-43)
            if (r1 >= r6) goto L_0x017a
        L_0x0178:
            r1 = 1
            goto L_0x017b
        L_0x017a:
            r1 = 0
        L_0x017b:
            if (r1 == 0) goto L_0x0258
            a.d.c.u.p.f.c.m r1 = r13.f3117b
            int r1 = r1.f3098a
            a.d.c.r.a r6 = r13.f3116a
            int r6 = d(r6, r1, r8)
            if (r6 != r3) goto L_0x0194
            a.d.c.u.p.f.c.n r6 = new a.d.c.u.p.f.c.n
            int r1 = r1 + 5
            r7 = 36
            r6.<init>(r1, r7)
            goto L_0x0228
        L_0x0194:
            if (r6 < r8) goto L_0x01a6
            if (r6 >= r3) goto L_0x01a6
            a.d.c.u.p.f.c.n r7 = new a.d.c.u.p.f.c.n
            int r1 = r1 + 5
            int r6 = r6 + 48
            int r6 = r6 - r8
            char r6 = (char) r6
            r7.<init>(r1, r6)
        L_0x01a3:
            r6 = r7
            goto L_0x0228
        L_0x01a6:
            a.d.c.r.a r6 = r13.f3116a
            int r6 = d(r6, r1, r5)
            r7 = 90
            if (r6 < r11) goto L_0x01bd
            if (r6 >= r7) goto L_0x01bd
            a.d.c.u.p.f.c.n r7 = new a.d.c.u.p.f.c.n
            int r1 = r1 + 7
            int r6 = r6 + 1
            char r6 = (char) r6
            r7.<init>(r1, r6)
            goto L_0x01a3
        L_0x01bd:
            if (r6 < r7) goto L_0x01cc
            if (r6 >= r10) goto L_0x01cc
            a.d.c.u.p.f.c.n r7 = new a.d.c.u.p.f.c.n
            int r1 = r1 + 7
            int r6 = r6 + 7
            char r6 = (char) r6
            r7.<init>(r1, r6)
            goto L_0x01a3
        L_0x01cc:
            a.d.c.r.a r6 = r13.f3116a
            int r6 = d(r6, r1, r12)
            switch(r6) {
                case 232: goto L_0x021d;
                case 233: goto L_0x021a;
                case 234: goto L_0x0217;
                case 235: goto L_0x0214;
                case 236: goto L_0x0211;
                case 237: goto L_0x020e;
                case 238: goto L_0x020b;
                case 239: goto L_0x0208;
                case 240: goto L_0x0205;
                case 241: goto L_0x0202;
                case 242: goto L_0x01ff;
                case 243: goto L_0x01fc;
                case 244: goto L_0x01f9;
                case 245: goto L_0x01f6;
                case 246: goto L_0x01f3;
                case 247: goto L_0x01f0;
                case 248: goto L_0x01ed;
                case 249: goto L_0x01ea;
                case 250: goto L_0x01e7;
                case 251: goto L_0x01e4;
                case 252: goto L_0x01e1;
                default: goto L_0x01d5;
            }
        L_0x01d5:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.String r15 = "Decoding invalid ISO/IEC 646 value: "
            java.lang.String r15 = a.a.a.a.a.h(r15, r6)
            r14.<init>(r15)
            throw r14
        L_0x01e1:
            r6 = 32
            goto L_0x021f
        L_0x01e4:
            r6 = 95
            goto L_0x021f
        L_0x01e7:
            r6 = 63
            goto L_0x021f
        L_0x01ea:
            r6 = 62
            goto L_0x021f
        L_0x01ed:
            r6 = 61
            goto L_0x021f
        L_0x01f0:
            r6 = 60
            goto L_0x021f
        L_0x01f3:
            r6 = 59
            goto L_0x021f
        L_0x01f6:
            r6 = 58
            goto L_0x021f
        L_0x01f9:
            r6 = 47
            goto L_0x021f
        L_0x01fc:
            r6 = 46
            goto L_0x021f
        L_0x01ff:
            r6 = 45
            goto L_0x021f
        L_0x0202:
            r6 = 44
            goto L_0x021f
        L_0x0205:
            r6 = 43
            goto L_0x021f
        L_0x0208:
            r6 = 42
            goto L_0x021f
        L_0x020b:
            r6 = 41
            goto L_0x021f
        L_0x020e:
            r6 = 40
            goto L_0x021f
        L_0x0211:
            r6 = 39
            goto L_0x021f
        L_0x0214:
            r6 = 38
            goto L_0x021f
        L_0x0217:
            r6 = 37
            goto L_0x021f
        L_0x021a:
            r6 = 34
            goto L_0x021f
        L_0x021d:
            r6 = 33
        L_0x021f:
            a.d.c.u.p.f.c.n r7 = new a.d.c.u.p.f.c.n
            int r1 = r1 + 8
            r7.<init>(r1, r6)
            goto L_0x01a3
        L_0x0228:
            a.d.c.u.p.f.c.m r1 = r13.f3117b
            int r7 = r6.f3110a
            r1.f3098a = r7
            char r1 = r6.f3104b
            r7 = 36
            if (r1 != r7) goto L_0x0236
            r1 = 1
            goto L_0x0237
        L_0x0236:
            r1 = 0
        L_0x0237:
            if (r1 == 0) goto L_0x024f
            a.d.c.u.p.f.c.o r1 = new a.d.c.u.p.f.c.o
            a.d.c.u.p.f.c.m r3 = r13.f3117b
            int r3 = r3.f3098a
            java.lang.StringBuilder r4 = r13.f3118c
            java.lang.String r4 = r4.toString()
            r1.<init>(r3, r4)
            a.d.c.u.p.f.c.l r3 = new a.d.c.u.p.f.c.l
            r4 = 1
            r3.<init>(r1, r4)
            goto L_0x0293
        L_0x024f:
            java.lang.StringBuilder r1 = r13.f3118c
            char r6 = r6.f3104b
            r1.append(r6)
            goto L_0x0135
        L_0x0258:
            a.d.c.u.p.f.c.m r1 = r13.f3117b
            int r1 = r1.f3098a
            boolean r1 = r13.e(r1)
            if (r1 == 0) goto L_0x026d
            a.d.c.u.p.f.c.m r1 = r13.f3117b
            r3 = 3
            r1.a(r3)
            a.d.c.u.p.f.c.m r1 = r13.f3117b
            r1.f3099b = r14
            goto L_0x028c
        L_0x026d:
            a.d.c.u.p.f.c.m r1 = r13.f3117b
            int r1 = r1.f3098a
            boolean r1 = r13.f(r1)
            if (r1 == 0) goto L_0x028c
            a.d.c.u.p.f.c.m r1 = r13.f3117b
            int r3 = r1.f3098a
            int r3 = r3 + r8
            a.d.c.r.a r4 = r13.f3116a
            int r4 = r4.f2965b
            if (r3 >= r4) goto L_0x0286
            r1.a(r8)
            goto L_0x0288
        L_0x0286:
            r1.f3098a = r4
        L_0x0288:
            a.d.c.u.p.f.c.m r1 = r13.f3117b
            r1.f3099b = r0
        L_0x028c:
            a.d.c.u.p.f.c.l r3 = new a.d.c.u.p.f.c.l
            r1 = 0
            r4 = 0
            r3.<init>(r1, r4)
        L_0x0293:
            boolean r1 = r3.f3097b
            r4 = 1
            goto L_0x03aa
        L_0x0298:
            a.d.c.u.p.f.c.m r1 = r13.f3117b
            int r1 = r1.f3098a
            int r3 = r1 + 7
            a.d.c.r.a r4 = r13.f3116a
            int r4 = r4.f2965b
            if (r3 <= r4) goto L_0x02ab
            int r1 = r1 + 4
            if (r1 > r4) goto L_0x02a9
            goto L_0x02b8
        L_0x02a9:
            r1 = 0
            goto L_0x02c3
        L_0x02ab:
            r3 = r1
        L_0x02ac:
            int r4 = r1 + 3
            if (r3 >= r4) goto L_0x02bd
            a.d.c.r.a r4 = r13.f3116a
            boolean r4 = r4.a(r3)
            if (r4 == 0) goto L_0x02ba
        L_0x02b8:
            r1 = 1
            goto L_0x02c3
        L_0x02ba:
            int r3 = r3 + 1
            goto L_0x02ac
        L_0x02bd:
            a.d.c.r.a r1 = r13.f3116a
            boolean r1 = r1.a(r4)
        L_0x02c3:
            r3 = 4
            if (r1 == 0) goto L_0x0372
            a.d.c.u.p.f.c.m r1 = r13.f3117b
            int r1 = r1.f3098a
            int r4 = r1 + 7
            a.d.c.r.a r6 = r13.f3116a
            int r7 = r6.f2965b
            r8 = 10
            if (r4 <= r7) goto L_0x02f1
            int r1 = d(r6, r1, r3)
            if (r1 != 0) goto L_0x02e4
            a.d.c.u.p.f.c.p r1 = new a.d.c.u.p.f.c.p
            a.d.c.r.a r3 = r13.f3116a
            int r3 = r3.f2965b
            r1.<init>(r3, r8, r8)
            goto L_0x0301
        L_0x02e4:
            a.d.c.u.p.f.c.p r3 = new a.d.c.u.p.f.c.p
            a.d.c.r.a r4 = r13.f3116a
            int r4 = r4.f2965b
            int r1 = r1 + -1
            r3.<init>(r4, r1, r8)
            r1 = r3
            goto L_0x0301
        L_0x02f1:
            int r1 = d(r6, r1, r5)
            int r1 = r1 + -8
            int r3 = r1 / 11
            int r1 = r1 % 11
            a.d.c.u.p.f.c.p r6 = new a.d.c.u.p.f.c.p
            r6.<init>(r4, r3, r1)
            r1 = r6
        L_0x0301:
            a.d.c.u.p.f.c.m r3 = r13.f3117b
            int r4 = r1.f3110a
            r3.f3098a = r4
            int r3 = r1.f3108b
            if (r3 != r8) goto L_0x030d
            r3 = 1
            goto L_0x030e
        L_0x030d:
            r3 = 0
        L_0x030e:
            if (r3 == 0) goto L_0x0343
            int r3 = r1.f3109c
            if (r3 != r8) goto L_0x0316
            r3 = 1
            goto L_0x0317
        L_0x0316:
            r3 = 0
        L_0x0317:
            if (r3 == 0) goto L_0x0329
            a.d.c.u.p.f.c.o r1 = new a.d.c.u.p.f.c.o
            a.d.c.u.p.f.c.m r3 = r13.f3117b
            int r3 = r3.f3098a
            java.lang.StringBuilder r4 = r13.f3118c
            java.lang.String r4 = r4.toString()
            r1.<init>(r3, r4)
            goto L_0x033b
        L_0x0329:
            a.d.c.u.p.f.c.o r3 = new a.d.c.u.p.f.c.o
            a.d.c.u.p.f.c.m r4 = r13.f3117b
            int r4 = r4.f3098a
            java.lang.StringBuilder r5 = r13.f3118c
            java.lang.String r5 = r5.toString()
            int r1 = r1.f3109c
            r3.<init>(r4, r5, r1)
            r1 = r3
        L_0x033b:
            a.d.c.u.p.f.c.l r3 = new a.d.c.u.p.f.c.l
            r4 = 1
            r3.<init>(r1, r4)
            r1 = 1
            goto L_0x03a7
        L_0x0343:
            java.lang.StringBuilder r3 = r13.f3118c
            int r4 = r1.f3108b
            r3.append(r4)
            int r3 = r1.f3109c
            if (r3 != r8) goto L_0x0350
            r3 = 1
            goto L_0x0351
        L_0x0350:
            r3 = 0
        L_0x0351:
            if (r3 == 0) goto L_0x0369
            a.d.c.u.p.f.c.o r1 = new a.d.c.u.p.f.c.o
            a.d.c.u.p.f.c.m r3 = r13.f3117b
            int r3 = r3.f3098a
            java.lang.StringBuilder r4 = r13.f3118c
            java.lang.String r4 = r4.toString()
            r1.<init>(r3, r4)
            a.d.c.u.p.f.c.l r3 = new a.d.c.u.p.f.c.l
            r4 = 1
            r3.<init>(r1, r4)
            goto L_0x03a8
        L_0x0369:
            java.lang.StringBuilder r3 = r13.f3118c
            int r1 = r1.f3109c
            r3.append(r1)
            goto L_0x0298
        L_0x0372:
            r1 = 1
            a.d.c.u.p.f.c.m r4 = r13.f3117b
            int r4 = r4.f3098a
            int r5 = r4 + 1
            a.d.c.r.a r6 = r13.f3116a
            int r6 = r6.f2965b
            if (r5 <= r6) goto L_0x0380
            goto L_0x0391
        L_0x0380:
            r5 = 0
        L_0x0381:
            if (r5 >= r3) goto L_0x0396
            int r6 = r5 + r4
            a.d.c.r.a r7 = r13.f3116a
            int r8 = r7.f2965b
            if (r6 >= r8) goto L_0x0396
            boolean r6 = r7.a(r6)
            if (r6 == 0) goto L_0x0393
        L_0x0391:
            r4 = 0
            goto L_0x0397
        L_0x0393:
            int r5 = r5 + 1
            goto L_0x0381
        L_0x0396:
            r4 = 1
        L_0x0397:
            if (r4 == 0) goto L_0x03a0
            a.d.c.u.p.f.c.m r4 = r13.f3117b
            r4.f3099b = r0
            r4.a(r3)
        L_0x03a0:
            a.d.c.u.p.f.c.l r3 = new a.d.c.u.p.f.c.l
            r4 = 0
            r5 = 0
            r3.<init>(r4, r5)
        L_0x03a7:
            r4 = 1
        L_0x03a8:
            boolean r1 = r3.f3097b
        L_0x03aa:
            a.d.c.u.p.f.c.m r5 = r13.f3117b
            int r5 = r5.f3098a
            if (r2 == r5) goto L_0x03b1
            goto L_0x03b2
        L_0x03b1:
            r4 = 0
        L_0x03b2:
            if (r4 != 0) goto L_0x03b7
            if (r1 != 0) goto L_0x03b7
            goto L_0x03b9
        L_0x03b7:
            if (r1 == 0) goto L_0x0017
        L_0x03b9:
            a.d.c.u.p.f.c.o r14 = r3.f3096a
            if (r14 == 0) goto L_0x03d3
            boolean r15 = r14.f3107d
            if (r15 == 0) goto L_0x03d3
            a.d.c.u.p.f.c.o r15 = new a.d.c.u.p.f.c.o
            a.d.c.u.p.f.c.m r0 = r13.f3117b
            int r0 = r0.f3098a
            java.lang.StringBuilder r1 = r13.f3118c
            java.lang.String r1 = r1.toString()
            int r14 = r14.f3106c
            r15.<init>(r0, r1, r14)
            return r15
        L_0x03d3:
            a.d.c.u.p.f.c.o r14 = new a.d.c.u.p.f.c.o
            a.d.c.u.p.f.c.m r15 = r13.f3117b
            int r15 = r15.f3098a
            java.lang.StringBuilder r0 = r13.f3118c
            java.lang.String r0 = r0.toString()
            r14.<init>(r15, r0)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.c.u.p.f.c.s.b(int, java.lang.String):a.d.c.u.p.f.c.o");
    }

    public int c(int i, int i2) {
        return d(this.f3116a, i, i2);
    }

    public final boolean e(int i) {
        int i2 = i + 3;
        if (i2 > this.f3116a.f2965b) {
            return false;
        }
        while (i < i2) {
            if (this.f3116a.a(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    public final boolean f(int i) {
        if (i + 1 > this.f3116a.f2965b) {
            return false;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = i2 + i;
            a aVar = this.f3116a;
            if (i3 >= aVar.f2965b) {
                return true;
            }
            if (i2 == 2) {
                if (!aVar.a(i + 2)) {
                    return false;
                }
            } else if (aVar.a(i3)) {
                return false;
            }
        }
        return true;
    }
}
