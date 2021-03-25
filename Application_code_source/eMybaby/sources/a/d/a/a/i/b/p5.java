package a.d.a.a.i.b;

import com.google.android.gms.measurement.internal.zzar;

public final class p5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ zzar f2456a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2457b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d5 f2458c;

    public p5(d5 d5Var, zzar zzar, String str) {
        this.f2458c = d5Var;
        this.f2456a = zzar;
        this.f2457b = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00e3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r34 = this;
            r0 = r34
            a.d.a.a.i.b.d5 r1 = r0.f2458c
            a.d.a.a.i.b.o9 r1 = r1.f2148a
            r1.Q()
            a.d.a.a.i.b.d5 r1 = r0.f2458c
            a.d.a.a.i.b.o9 r1 = r1.f2148a
            com.google.android.gms.measurement.internal.zzar r2 = r0.f2456a
            java.lang.String r4 = r0.f2457b
            a.d.a.a.i.b.d r3 = r1.J()
            a.d.a.a.i.b.a4 r3 = r3.T(r4)
            if (r3 == 0) goto L_0x010f
            java.lang.String r5 = r3.M()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x0027
            goto L_0x010f
        L_0x0027:
            java.lang.Boolean r5 = r1.y(r3)
            if (r5 != 0) goto L_0x0049
            java.lang.String r5 = r2.f4276a
            java.lang.String r6 = "_ui"
            boolean r5 = r6.equals(r5)
            if (r5 != 0) goto L_0x0062
            a.d.a.a.i.b.c5 r5 = r1.j
            a.d.a.a.i.b.x3 r5 = r5.i()
            a.d.a.a.i.b.z3 r5 = r5.i
            java.lang.Object r6 = a.d.a.a.i.b.x3.s(r4)
            java.lang.String r7 = "Could not find package. appId"
            r5.b(r7, r6)
            goto L_0x0062
        L_0x0049:
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L_0x0062
            a.d.a.a.i.b.c5 r1 = r1.j
            a.d.a.a.i.b.x3 r1 = r1.i()
            a.d.a.a.i.b.z3 r1 = r1.f
            java.lang.Object r2 = a.d.a.a.i.b.x3.s(r4)
            java.lang.String r3 = "App version does not match; dropping event. appId"
            r1.b(r3, r2)
            goto L_0x011c
        L_0x0062:
            com.google.android.gms.measurement.internal.zzn r15 = new com.google.android.gms.measurement.internal.zzn
            java.lang.String r5 = r3.v()
            java.lang.String r6 = r3.M()
            long r7 = r3.N()
            java.lang.String r9 = r3.O()
            long r10 = r3.P()
            long r12 = r3.Q()
            boolean r16 = r3.T()
            r17 = 0
            java.lang.String r18 = r3.H()
            long r19 = r3.g()
            r21 = 0
            r23 = 0
            boolean r24 = r3.h()
            boolean r25 = r3.i()
            r26 = 0
            java.lang.String r27 = r3.y()
            java.lang.Boolean r28 = r3.j()
            long r29 = r3.S()
            java.util.List r31 = r3.k()
            boolean r14 = a.d.a.a.h.g.jb.b()
            if (r14 == 0) goto L_0x00c5
            a.d.a.a.i.b.c5 r14 = r1.j
            a.d.a.a.i.b.ka r14 = r14.g
            java.lang.String r0 = r3.o()
            r33 = r2
            a.d.a.a.i.b.n3<java.lang.Boolean> r2 = a.d.a.a.i.b.q.k0
            boolean r0 = r14.t(r0, r2)
            if (r0 == 0) goto L_0x00c7
            java.lang.String r0 = r3.B()
            goto L_0x00c8
        L_0x00c5:
            r33 = r2
        L_0x00c7:
            r0 = 0
        L_0x00c8:
            boolean r2 = a.d.a.a.h.g.u9.b()
            if (r2 == 0) goto L_0x00e3
            a.d.a.a.i.b.c5 r2 = r1.j
            a.d.a.a.i.b.ka r2 = r2.g
            a.d.a.a.i.b.n3<java.lang.Boolean> r3 = a.d.a.a.i.b.q.Q0
            boolean r2 = r2.o(r3)
            if (r2 == 0) goto L_0x00e3
            a.d.a.a.i.b.e r2 = r1.a(r4)
            java.lang.String r2 = r2.d()
            goto L_0x00e5
        L_0x00e3:
            java.lang.String r2 = ""
        L_0x00e5:
            r32 = r2
            r14 = 0
            r3 = r15
            r2 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            r18 = r19
            r20 = r21
            r22 = r23
            r23 = r24
            r24 = r25
            r25 = r26
            r26 = r27
            r27 = r28
            r28 = r29
            r30 = r31
            r31 = r0
            r3.<init>((java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (long) r7, (java.lang.String) r9, (long) r10, (long) r12, (java.lang.String) r14, (boolean) r15, (boolean) r16, (java.lang.String) r17, (long) r18, (long) r20, (int) r22, (boolean) r23, (boolean) r24, (boolean) r25, (java.lang.String) r26, (java.lang.Boolean) r27, (long) r28, (java.util.List<java.lang.String>) r30, (java.lang.String) r31, (java.lang.String) r32)
            r0 = r33
            r1.A(r0, r2)
            goto L_0x011c
        L_0x010f:
            a.d.a.a.i.b.c5 r0 = r1.j
            a.d.a.a.i.b.x3 r0 = r0.i()
            a.d.a.a.i.b.z3 r0 = r0.m
            java.lang.String r1 = "No app data available; dropping event"
            r0.b(r1, r4)
        L_0x011c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.p5.run():void");
    }
}
