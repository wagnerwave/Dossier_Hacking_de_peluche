package a.d.a.a.i.b;

import android.net.Uri;

public final class g7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f2219a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Uri f2220b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f2221c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f2222d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ d7 f2223e;

    public g7(d7 d7Var, boolean z, Uri uri, String str, String str2) {
        this.f2223e = d7Var;
        this.f2219a = z;
        this.f2220b = uri;
        this.f2221c = str;
        this.f2222d = str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0045, code lost:
        if (r2.f2151a.f2563a.g.o(a.d.a.a.i.b.q.g0) == false) goto L_0x0075;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a0 A[SYNTHETIC, Splitter:B:32:0x00a0] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00fb A[Catch:{ Exception -> 0x01cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x010c A[SYNTHETIC, Splitter:B:50:0x010c] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x013b A[Catch:{ Exception -> 0x01cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x013d A[Catch:{ Exception -> 0x01cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01b4 A[Catch:{ Exception -> 0x01cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01c0 A[Catch:{ Exception -> 0x01cc }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r18 = this;
            r1 = r18
            a.d.a.a.i.b.d7 r2 = r1.f2223e
            boolean r0 = r1.f2219a
            android.net.Uri r3 = r1.f2220b
            java.lang.String r4 = r1.f2221c
            java.lang.String r5 = r1.f2222d
            a.d.a.a.i.b.f6 r6 = r2.f2151a
            r6.b()
            a.d.a.a.i.b.f6 r6 = r2.f2151a     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.c5 r6 = r6.f2563a     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.ka r6 = r6.g     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.n3<java.lang.Boolean> r7 = a.d.a.a.i.b.q.f0     // Catch:{ Exception -> 0x01cc }
            boolean r6 = r6.o(r7)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r7 = "Activity created with data 'referrer' without required params"
            java.lang.String r8 = "utm_medium"
            java.lang.String r9 = "_cis"
            java.lang.String r10 = "utm_source"
            java.lang.String r11 = "utm_campaign"
            java.lang.String r12 = "gclid"
            if (r6 != 0) goto L_0x0047
            a.d.a.a.i.b.f6 r6 = r2.f2151a     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.c5 r6 = r6.f2563a     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.ka r6 = r6.g     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.n3<java.lang.Boolean> r14 = a.d.a.a.i.b.q.h0     // Catch:{ Exception -> 0x01cc }
            boolean r6 = r6.o(r14)     // Catch:{ Exception -> 0x01cc }
            if (r6 != 0) goto L_0x0047
            a.d.a.a.i.b.f6 r6 = r2.f2151a     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.c5 r6 = r6.f2563a     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.ka r6 = r6.g     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.n3<java.lang.Boolean> r14 = a.d.a.a.i.b.q.g0     // Catch:{ Exception -> 0x01cc }
            boolean r6 = r6.o(r14)     // Catch:{ Exception -> 0x01cc }
            if (r6 == 0) goto L_0x0075
        L_0x0047:
            a.d.a.a.i.b.f6 r6 = r2.f2151a     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.v9 r6 = r6.e()     // Catch:{ Exception -> 0x01cc }
            boolean r14 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x01cc }
            if (r14 == 0) goto L_0x0054
            goto L_0x0075
        L_0x0054:
            boolean r14 = r5.contains(r12)     // Catch:{ Exception -> 0x01cc }
            if (r14 != 0) goto L_0x0077
            boolean r14 = r5.contains(r11)     // Catch:{ Exception -> 0x01cc }
            if (r14 != 0) goto L_0x0077
            boolean r14 = r5.contains(r10)     // Catch:{ Exception -> 0x01cc }
            if (r14 != 0) goto L_0x0077
            boolean r14 = r5.contains(r8)     // Catch:{ Exception -> 0x01cc }
            if (r14 != 0) goto L_0x0077
            a.d.a.a.i.b.x3 r6 = r6.i()     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.z3 r6 = r6.m     // Catch:{ Exception -> 0x01cc }
            r6.a(r7)     // Catch:{ Exception -> 0x01cc }
        L_0x0075:
            r6 = 0
            goto L_0x0099
        L_0x0077:
            java.lang.String r14 = "https://google.com/search?"
            int r15 = r5.length()     // Catch:{ Exception -> 0x01cc }
            if (r15 == 0) goto L_0x0084
            java.lang.String r14 = r14.concat(r5)     // Catch:{ Exception -> 0x01cc }
            goto L_0x008a
        L_0x0084:
            java.lang.String r15 = new java.lang.String     // Catch:{ Exception -> 0x01cc }
            r15.<init>(r14)     // Catch:{ Exception -> 0x01cc }
            r14 = r15
        L_0x008a:
            android.net.Uri r14 = android.net.Uri.parse(r14)     // Catch:{ Exception -> 0x01cc }
            android.os.Bundle r6 = r6.x(r14)     // Catch:{ Exception -> 0x01cc }
            if (r6 == 0) goto L_0x0099
            java.lang.String r14 = "referrer"
            r6.putString(r9, r14)     // Catch:{ Exception -> 0x01cc }
        L_0x0099:
            r14 = 1
            java.lang.String r15 = "_cmp"
            r16 = 0
            if (r0 == 0) goto L_0x00fb
            a.d.a.a.i.b.f6 r0 = r2.f2151a     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.v9 r0 = r0.e()     // Catch:{ Exception -> 0x01cc }
            android.os.Bundle r0 = r0.x(r3)     // Catch:{ Exception -> 0x01cc }
            if (r0 == 0) goto L_0x00fc
            java.lang.String r3 = "intent"
            r0.putString(r9, r3)     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.f6 r3 = r2.f2151a     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.c5 r3 = r3.f2563a     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.ka r3 = r3.g     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.n3<java.lang.Boolean> r9 = a.d.a.a.i.b.q.f0     // Catch:{ Exception -> 0x01cc }
            boolean r3 = r3.o(r9)     // Catch:{ Exception -> 0x01cc }
            if (r3 == 0) goto L_0x00e0
            boolean r3 = r0.containsKey(r12)     // Catch:{ Exception -> 0x01cc }
            if (r3 != 0) goto L_0x00e0
            if (r6 == 0) goto L_0x00e0
            boolean r3 = r6.containsKey(r12)     // Catch:{ Exception -> 0x01cc }
            if (r3 == 0) goto L_0x00e0
            java.lang.String r3 = "_cer"
            java.lang.String r9 = "gclid=%s"
            java.lang.Object[] r13 = new java.lang.Object[r14]     // Catch:{ Exception -> 0x01cc }
            java.lang.String r17 = r6.getString(r12)     // Catch:{ Exception -> 0x01cc }
            r13[r16] = r17     // Catch:{ Exception -> 0x01cc }
            java.lang.String r9 = java.lang.String.format(r9, r13)     // Catch:{ Exception -> 0x01cc }
            r0.putString(r3, r9)     // Catch:{ Exception -> 0x01cc }
        L_0x00e0:
            a.d.a.a.i.b.f6 r3 = r2.f2151a     // Catch:{ Exception -> 0x01cc }
            r3.H(r4, r15, r0)     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.f6 r3 = r2.f2151a     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.c5 r3 = r3.f2563a     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.ka r3 = r3.g     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.n3<java.lang.Boolean> r9 = a.d.a.a.i.b.q.L0     // Catch:{ Exception -> 0x01cc }
            boolean r3 = r3.o(r9)     // Catch:{ Exception -> 0x01cc }
            if (r3 == 0) goto L_0x00fc
            a.d.a.a.i.b.f6 r3 = r2.f2151a     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.ca r3 = r3.n     // Catch:{ Exception -> 0x01cc }
            r3.a(r4, r0)     // Catch:{ Exception -> 0x01cc }
            goto L_0x00fc
        L_0x00fb:
            r0 = 0
        L_0x00fc:
            a.d.a.a.i.b.f6 r3 = r2.f2151a     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.c5 r3 = r3.f2563a     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.ka r3 = r3.g     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.n3<java.lang.Boolean> r9 = a.d.a.a.i.b.q.h0     // Catch:{ Exception -> 0x01cc }
            boolean r3 = r3.o(r9)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r9 = "auto"
            if (r3 == 0) goto L_0x0135
            a.d.a.a.i.b.f6 r3 = r2.f2151a     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.c5 r3 = r3.f2563a     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.ka r3 = r3.g     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.n3<java.lang.Boolean> r13 = a.d.a.a.i.b.q.g0     // Catch:{ Exception -> 0x01cc }
            boolean r3 = r3.o(r13)     // Catch:{ Exception -> 0x01cc }
            if (r3 != 0) goto L_0x0135
            if (r6 == 0) goto L_0x0135
            boolean r3 = r6.containsKey(r12)     // Catch:{ Exception -> 0x01cc }
            if (r3 == 0) goto L_0x0135
            if (r0 == 0) goto L_0x012a
            boolean r0 = r0.containsKey(r12)     // Catch:{ Exception -> 0x01cc }
            if (r0 != 0) goto L_0x0135
        L_0x012a:
            a.d.a.a.i.b.f6 r0 = r2.f2151a     // Catch:{ Exception -> 0x01cc }
            java.lang.String r3 = "_lgclid"
            java.lang.String r13 = r6.getString(r12)     // Catch:{ Exception -> 0x01cc }
            r0.J(r9, r3, r13)     // Catch:{ Exception -> 0x01cc }
        L_0x0135:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x01cc }
            if (r0 == 0) goto L_0x013d
            goto L_0x01da
        L_0x013d:
            a.d.a.a.i.b.f6 r0 = r2.f2151a     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.x3 r0 = r0.i()     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.z3 r0 = r0.m     // Catch:{ Exception -> 0x01cc }
            java.lang.String r3 = "Activity created with referrer"
            r0.b(r3, r5)     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.f6 r0 = r2.f2151a     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.c5 r0 = r0.f2563a     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.ka r0 = r0.g     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.n3<java.lang.Boolean> r3 = a.d.a.a.i.b.q.g0     // Catch:{ Exception -> 0x01cc }
            boolean r0 = r0.o(r3)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r3 = "_ldl"
            if (r0 == 0) goto L_0x0188
            if (r6 == 0) goto L_0x0177
            a.d.a.a.i.b.f6 r0 = r2.f2151a     // Catch:{ Exception -> 0x01cc }
            r0.H(r4, r15, r6)     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.f6 r0 = r2.f2151a     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.c5 r0 = r0.f2563a     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.ka r0 = r0.g     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.n3<java.lang.Boolean> r5 = a.d.a.a.i.b.q.L0     // Catch:{ Exception -> 0x01cc }
            boolean r0 = r0.o(r5)     // Catch:{ Exception -> 0x01cc }
            if (r0 == 0) goto L_0x0184
            a.d.a.a.i.b.f6 r0 = r2.f2151a     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.ca r0 = r0.n     // Catch:{ Exception -> 0x01cc }
            r0.a(r4, r6)     // Catch:{ Exception -> 0x01cc }
            goto L_0x0184
        L_0x0177:
            a.d.a.a.i.b.f6 r0 = r2.f2151a     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.x3 r0 = r0.i()     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.z3 r0 = r0.m     // Catch:{ Exception -> 0x01cc }
            java.lang.String r4 = "Referrer does not contain valid parameters"
            r0.b(r4, r5)     // Catch:{ Exception -> 0x01cc }
        L_0x0184:
            a.d.a.a.i.b.f6 r0 = r2.f2151a     // Catch:{ Exception -> 0x01cc }
            r5 = 0
            goto L_0x01c8
        L_0x0188:
            boolean r0 = r5.contains(r12)     // Catch:{ Exception -> 0x01cc }
            if (r0 == 0) goto L_0x01b1
            boolean r0 = r5.contains(r11)     // Catch:{ Exception -> 0x01cc }
            if (r0 != 0) goto L_0x01b2
            boolean r0 = r5.contains(r10)     // Catch:{ Exception -> 0x01cc }
            if (r0 != 0) goto L_0x01b2
            boolean r0 = r5.contains(r8)     // Catch:{ Exception -> 0x01cc }
            if (r0 != 0) goto L_0x01b2
            java.lang.String r0 = "utm_term"
            boolean r0 = r5.contains(r0)     // Catch:{ Exception -> 0x01cc }
            if (r0 != 0) goto L_0x01b2
            java.lang.String r0 = "utm_content"
            boolean r0 = r5.contains(r0)     // Catch:{ Exception -> 0x01cc }
            if (r0 == 0) goto L_0x01b1
            goto L_0x01b2
        L_0x01b1:
            r14 = 0
        L_0x01b2:
            if (r14 != 0) goto L_0x01c0
            a.d.a.a.i.b.f6 r0 = r2.f2151a     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.x3 r0 = r0.i()     // Catch:{ Exception -> 0x01cc }
            a.d.a.a.i.b.z3 r0 = r0.m     // Catch:{ Exception -> 0x01cc }
            r0.a(r7)     // Catch:{ Exception -> 0x01cc }
            goto L_0x01da
        L_0x01c0:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x01cc }
            if (r0 != 0) goto L_0x01da
            a.d.a.a.i.b.f6 r0 = r2.f2151a     // Catch:{ Exception -> 0x01cc }
        L_0x01c8:
            r0.J(r9, r3, r5)     // Catch:{ Exception -> 0x01cc }
            goto L_0x01da
        L_0x01cc:
            r0 = move-exception
            a.d.a.a.i.b.f6 r2 = r2.f2151a
            a.d.a.a.i.b.x3 r2 = r2.i()
            a.d.a.a.i.b.z3 r2 = r2.f
            java.lang.String r3 = "Throwable caught in handleReferrerForOnActivityCreated"
            r2.b(r3, r0)
        L_0x01da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.g7.run():void");
    }
}
