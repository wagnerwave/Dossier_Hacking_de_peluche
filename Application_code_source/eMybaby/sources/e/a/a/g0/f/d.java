package e.a.a.g0.f;

import e.a.a.b0.j;
import e.a.a.c;

public class d extends l {
    public static final char[] i = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: c  reason: collision with root package name */
    public boolean f4949c = false;

    /* renamed from: d  reason: collision with root package name */
    public String f4950d;

    /* renamed from: e  reason: collision with root package name */
    public long f4951e;
    public String f;
    public String g;
    public String h;

    public static String k(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length * 2)];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            char[] cArr2 = i;
            cArr[i3] = cArr2[(bArr[i2] & 240) >> 4];
            cArr[i3 + 1] = cArr2[bArr[i2] & 15];
        }
        return new String(cArr);
    }

    public void b(c cVar) {
        super.b(cVar);
        if (i("realm") == null) {
            throw new j("missing realm in challenge");
        } else if (i("nonce") != null) {
            this.f4949c = true;
        } else {
            throw new j("missing nonce in challenge");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:131|132|133) */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0372, code lost:
        throw new e.a.a.g0.f.n("Unsupported algorithm in HTTP Digest authentication: " + r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x037e, code lost:
        throw new e.a.a.b0.f(a.a.a.a.a.k("Unsuppported digest algorithm: ", r10));
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:131:0x035c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public e.a.a.c c(e.a.a.b0.h r25, e.a.a.m r26) {
        /*
            r24 = this;
            r0 = r24
            if (r25 == 0) goto L_0x03ab
            if (r26 == 0) goto L_0x03a3
            java.util.Map r1 = r24.j()
            e.a.a.y r2 = r26.f()
            e.a.a.i0.l r2 = (e.a.a.i0.l) r2
            java.lang.String r2 = r2.f5154b
            java.lang.String r3 = "methodname"
            r1.put(r3, r2)
            java.util.Map r1 = r24.j()
            e.a.a.y r2 = r26.f()
            e.a.a.i0.l r2 = (e.a.a.i0.l) r2
            java.lang.String r2 = r2.f5155c
            java.lang.String r4 = "uri"
            r1.put(r4, r2)
            java.lang.String r1 = "charset"
            java.lang.String r2 = r0.i(r1)
            if (r2 != 0) goto L_0x003f
            e.a.a.j0.c r2 = r26.getParams()
            java.lang.String r2 = a.e.a.a.r.b.t(r2)
            java.util.Map r5 = r24.j()
            r5.put(r1, r2)
        L_0x003f:
            java.lang.String r2 = r0.i(r4)
            java.lang.String r5 = "realm"
            java.lang.String r6 = r0.i(r5)
            java.lang.String r7 = "nonce"
            java.lang.String r8 = r0.i(r7)
            java.lang.String r9 = "opaque"
            java.lang.String r10 = r0.i(r9)
            java.lang.String r3 = r0.i(r3)
            java.lang.String r11 = "algorithm"
            java.lang.String r12 = r0.i(r11)
            if (r2 == 0) goto L_0x039b
            if (r6 == 0) goto L_0x0393
            if (r8 == 0) goto L_0x038b
            java.lang.String r13 = "qop"
            java.lang.String r14 = r0.i(r13)
            java.lang.String r15 = "auth"
            r26 = r9
            if (r14 == 0) goto L_0x0092
            java.util.StringTokenizer r9 = new java.util.StringTokenizer
            r16 = r10
            java.lang.String r10 = ","
            r9.<init>(r14, r10)
        L_0x007a:
            boolean r10 = r9.hasMoreTokens()
            if (r10 == 0) goto L_0x0090
            java.lang.String r10 = r9.nextToken()
            java.lang.String r10 = r10.trim()
            boolean r10 = r10.equals(r15)
            if (r10 == 0) goto L_0x007a
            r9 = 2
            goto L_0x0095
        L_0x0090:
            r9 = -1
            goto L_0x0095
        L_0x0092:
            r16 = r10
            r9 = 0
        L_0x0095:
            r10 = -1
            if (r9 == r10) goto L_0x037f
            java.lang.String r10 = "MD5"
            if (r12 != 0) goto L_0x009d
            r12 = r10
        L_0x009d:
            java.lang.String r1 = r0.i(r1)
            if (r1 != 0) goto L_0x00a5
            java.lang.String r1 = "ISO-8859-1"
        L_0x00a5:
            java.lang.String r14 = "MD5-sess"
            boolean r17 = r12.equalsIgnoreCase(r14)
            if (r17 == 0) goto L_0x00ae
            goto L_0x00af
        L_0x00ae:
            r10 = r12
        L_0x00af:
            java.security.MessageDigest r10 = java.security.MessageDigest.getInstance(r10)     // Catch:{ Exception -> 0x035c }
            java.security.Principal r17 = r25.b()
            r18 = r15
            java.lang.String r15 = r17.getName()
            r17 = r11
            java.lang.String r11 = r25.a()
            r19 = r13
            java.lang.String r13 = r0.f4950d
            boolean r13 = r8.equals(r13)
            r20 = r4
            r21 = r5
            r4 = 1
            if (r13 == 0) goto L_0x00dc
            r13 = r2
            r22 = r3
            long r2 = r0.f4951e
            long r2 = r2 + r4
            r0.f4951e = r2
            goto L_0x00e6
        L_0x00dc:
            r13 = r2
            r22 = r3
            r0.f4951e = r4
            r2 = 0
            r0.f = r2
            r0.f4950d = r8
        L_0x00e6:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = 256(0x100, float:3.59E-43)
            r2.<init>(r3)
            java.util.Formatter r3 = new java.util.Formatter
            java.util.Locale r4 = java.util.Locale.US
            r3.<init>(r2, r4)
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]
            r23 = r5
            long r4 = r0.f4951e
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r5 = 0
            r23[r5] = r4
            java.lang.String r4 = "%08x"
            r5 = r23
            r3.format(r4, r5)
            java.lang.String r3 = r2.toString()
            java.lang.String r4 = r0.f
            if (r4 != 0) goto L_0x0123
            java.security.SecureRandom r4 = new java.security.SecureRandom
            r4.<init>()
            r5 = 8
            byte[] r5 = new byte[r5]
            r4.nextBytes(r5)
            java.lang.String r4 = k(r5)
            r0.f = r4
        L_0x0123:
            r4 = 0
            r0.g = r4
            r0.h = r4
            boolean r4 = r12.equalsIgnoreCase(r14)
            r5 = 58
            if (r4 == 0) goto L_0x0168
            r4 = 0
            r2.setLength(r4)
            r2.append(r15)
            r2.append(r5)
            r2.append(r6)
            r2.append(r5)
            r2.append(r11)
            java.lang.String r11 = r2.toString()
            byte[] r11 = a.e.a.a.r.b.r(r11, r1)
            byte[] r11 = r10.digest(r11)
            java.lang.String r11 = k(r11)
            r2.setLength(r4)
            r2.append(r11)
            r2.append(r5)
            r2.append(r8)
            r2.append(r5)
            java.lang.String r4 = r0.f
            r2.append(r4)
            goto L_0x017b
        L_0x0168:
            r4 = 0
            r2.setLength(r4)
            r2.append(r15)
            r2.append(r5)
            r2.append(r6)
            r2.append(r5)
            r2.append(r11)
        L_0x017b:
            java.lang.String r4 = r2.toString()
            r0.g = r4
            java.lang.String r4 = r0.g
            byte[] r4 = a.e.a.a.r.b.r(r4, r1)
            byte[] r4 = r10.digest(r4)
            java.lang.String r4 = k(r4)
            r11 = 2
            if (r9 != r11) goto L_0x019a
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
        L_0x0197:
            r14 = r22
            goto L_0x01a3
        L_0x019a:
            r11 = 1
            if (r9 == r11) goto L_0x0354
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            goto L_0x0197
        L_0x01a3:
            r11.append(r14)
            r11.append(r5)
            r11.append(r13)
            java.lang.String r11 = r11.toString()
            r0.h = r11
            java.lang.String r11 = r0.h
            byte[] r1 = a.e.a.a.r.b.r(r11, r1)
            byte[] r1 = r10.digest(r1)
            java.lang.String r1 = k(r1)
            java.lang.String r11 = "auth-int"
            r14 = 0
            r2.setLength(r14)
            r2.append(r4)
            r2.append(r5)
            r2.append(r8)
            r2.append(r5)
            if (r9 != 0) goto L_0x01d5
            goto L_0x01f0
        L_0x01d5:
            r2.append(r3)
            r2.append(r5)
            java.lang.String r4 = r0.f
            r2.append(r4)
            r2.append(r5)
            r4 = 1
            if (r9 != r4) goto L_0x01e8
            r4 = r11
            goto L_0x01ea
        L_0x01e8:
            r4 = r18
        L_0x01ea:
            r2.append(r4)
            r2.append(r5)
        L_0x01f0:
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            if (r1 == 0) goto L_0x034c
            java.lang.String r2 = "US-ASCII"
            byte[] r1 = r1.getBytes(r2)     // Catch:{ UnsupportedEncodingException -> 0x0344 }
            byte[] r1 = r10.digest(r1)
            java.lang.String r1 = k(r1)
            e.a.a.l0.b r2 = new e.a.a.l0.b
            r4 = 128(0x80, float:1.794E-43)
            r2.<init>(r4)
            boolean r4 = r0.f4947a
            if (r4 == 0) goto L_0x0215
            java.lang.String r4 = "Proxy-Authorization"
            goto L_0x0217
        L_0x0215:
            java.lang.String r4 = "Authorization"
        L_0x0217:
            r2.b(r4)
            java.lang.String r4 = ": Digest "
            r2.b(r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 20
            r4.<init>(r5)
            e.a.a.i0.k r5 = new e.a.a.i0.k
            java.lang.String r10 = "username"
            r5.<init>(r10, r15)
            r4.add(r5)
            e.a.a.i0.k r5 = new e.a.a.i0.k
            r10 = r21
            r5.<init>(r10, r6)
            r4.add(r5)
            e.a.a.i0.k r5 = new e.a.a.i0.k
            r5.<init>(r7, r8)
            r4.add(r5)
            e.a.a.i0.k r5 = new e.a.a.i0.k
            r6 = r20
            r5.<init>(r6, r13)
            r4.add(r5)
            e.a.a.i0.k r5 = new e.a.a.i0.k
            java.lang.String r6 = "response"
            r5.<init>(r6, r1)
            r4.add(r5)
            java.lang.String r1 = "nc"
            if (r9 == 0) goto L_0x0280
            e.a.a.i0.k r5 = new e.a.a.i0.k
            r6 = 1
            if (r9 != r6) goto L_0x0261
            r15 = r11
            goto L_0x0263
        L_0x0261:
            r15 = r18
        L_0x0263:
            r6 = r19
            r5.<init>(r6, r15)
            r4.add(r5)
            e.a.a.i0.k r5 = new e.a.a.i0.k
            r5.<init>(r1, r3)
            r4.add(r5)
            e.a.a.i0.k r3 = new e.a.a.i0.k
            java.lang.String r5 = r0.f
            java.lang.String r7 = "cnonce"
            r3.<init>(r7, r5)
            r4.add(r3)
            goto L_0x0282
        L_0x0280:
            r6 = r19
        L_0x0282:
            e.a.a.i0.k r3 = new e.a.a.i0.k
            r5 = r17
            r3.<init>(r5, r12)
            r4.add(r3)
            if (r16 == 0) goto L_0x029a
            e.a.a.i0.k r3 = new e.a.a.i0.k
            r5 = r26
            r7 = r16
            r3.<init>(r5, r7)
            r4.add(r3)
        L_0x029a:
            r3 = 0
        L_0x029b:
            int r5 = r4.size()
            if (r3 >= r5) goto L_0x033e
            java.lang.Object r5 = r4.get(r3)
            e.a.a.i0.k r5 = (e.a.a.i0.k) r5
            if (r3 <= 0) goto L_0x02ae
            java.lang.String r7 = ", "
            r2.b(r7)
        L_0x02ae:
            java.lang.String r7 = r5.f5151a
            boolean r7 = r1.equals(r7)
            if (r7 != 0) goto L_0x02c1
            java.lang.String r7 = r5.f5151a
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x02bf
            goto L_0x02c1
        L_0x02bf:
            r7 = 0
            goto L_0x02c2
        L_0x02c1:
            r7 = 1
        L_0x02c2:
            r8 = 1
            r7 = r7 ^ r8
            java.lang.String r9 = r5.getName()
            int r9 = r9.length()
            java.lang.String r10 = r5.getValue()
            if (r10 == 0) goto L_0x02d9
            int r10 = r10.length()
            int r10 = r10 + 3
            int r9 = r9 + r10
        L_0x02d9:
            r2.e(r9)
            java.lang.String r9 = r5.getName()
            r2.b(r9)
            java.lang.String r5 = r5.getValue()
            if (r5 == 0) goto L_0x033a
            r9 = 61
            r2.a(r9)
            if (r7 != 0) goto L_0x030b
            r9 = 0
        L_0x02f1:
            int r10 = r5.length()
            if (r9 >= r10) goto L_0x030b
            if (r7 != 0) goto L_0x030b
            char r7 = r5.charAt(r9)
            java.lang.String r10 = " ;,:@()<>\\\"/[]?={}\t"
            int r7 = r10.indexOf(r7)
            if (r7 < 0) goto L_0x0307
            r7 = 1
            goto L_0x0308
        L_0x0307:
            r7 = 0
        L_0x0308:
            int r9 = r9 + 1
            goto L_0x02f1
        L_0x030b:
            r9 = 34
            if (r7 == 0) goto L_0x0312
            r2.a(r9)
        L_0x0312:
            r10 = 0
        L_0x0313:
            int r11 = r5.length()
            if (r10 >= r11) goto L_0x0335
            char r11 = r5.charAt(r10)
            java.lang.String r12 = "\"\\"
            int r12 = r12.indexOf(r11)
            if (r12 < 0) goto L_0x0327
            r12 = 1
            goto L_0x0328
        L_0x0327:
            r12 = 0
        L_0x0328:
            if (r12 == 0) goto L_0x032f
            r12 = 92
            r2.a(r12)
        L_0x032f:
            r2.a(r11)
            int r10 = r10 + 1
            goto L_0x0313
        L_0x0335:
            if (r7 == 0) goto L_0x033a
            r2.a(r9)
        L_0x033a:
            int r3 = r3 + 1
            goto L_0x029b
        L_0x033e:
            e.a.a.i0.o r1 = new e.a.a.i0.o
            r1.<init>(r2)
            return r1
        L_0x0344:
            java.lang.Error r1 = new java.lang.Error
            java.lang.String r2 = "HttpClient requires ASCII support"
            r1.<init>(r2)
            throw r1
        L_0x034c:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Parameter may not be null"
            r1.<init>(r2)
            throw r1
        L_0x0354:
            e.a.a.b0.f r1 = new e.a.a.b0.f
            java.lang.String r2 = "qop-int method is not suppported"
            r1.<init>(r2)
            throw r1
        L_0x035c:
            e.a.a.g0.f.n r1 = new e.a.a.g0.f.n     // Catch:{ n -> 0x0373 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ n -> 0x0373 }
            r2.<init>()     // Catch:{ n -> 0x0373 }
            java.lang.String r3 = "Unsupported algorithm in HTTP Digest authentication: "
            r2.append(r3)     // Catch:{ n -> 0x0373 }
            r2.append(r10)     // Catch:{ n -> 0x0373 }
            java.lang.String r2 = r2.toString()     // Catch:{ n -> 0x0373 }
            r1.<init>(r2)     // Catch:{ n -> 0x0373 }
            throw r1     // Catch:{ n -> 0x0373 }
        L_0x0373:
            e.a.a.b0.f r1 = new e.a.a.b0.f
            java.lang.String r2 = "Unsuppported digest algorithm: "
            java.lang.String r2 = a.a.a.a.a.k(r2, r10)
            r1.<init>(r2)
            throw r1
        L_0x037f:
            e.a.a.b0.f r1 = new e.a.a.b0.f
            java.lang.String r2 = "None of the qop methods is supported: "
            java.lang.String r2 = a.a.a.a.a.k(r2, r14)
            r1.<init>(r2)
            throw r1
        L_0x038b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Nonce may not be null"
            r1.<init>(r2)
            throw r1
        L_0x0393:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Realm may not be null"
            r1.<init>(r2)
            throw r1
        L_0x039b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "URI may not be null"
            r1.<init>(r2)
            throw r1
        L_0x03a3:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "HTTP request may not be null"
            r1.<init>(r2)
            throw r1
        L_0x03ab:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Credentials may not be null"
            r1.<init>(r2)
            goto L_0x03b4
        L_0x03b3:
            throw r1
        L_0x03b4:
            goto L_0x03b3
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.g0.f.d.c(e.a.a.b0.h, e.a.a.m):e.a.a.c");
    }

    public boolean e() {
        return false;
    }

    public boolean f() {
        if ("true".equalsIgnoreCase(i("stale"))) {
            return false;
        }
        return this.f4949c;
    }

    public String g() {
        return "digest";
    }
}
