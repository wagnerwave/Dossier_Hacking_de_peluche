package a.d.a.a.i.b;

import a.d.a.a.h.g.i0;

public final class fa extends ia {
    public i0 g;
    public final /* synthetic */ ba h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public fa(ba baVar, String str, int i, i0 i0Var) {
        super(str, i);
        this.h = baVar;
        this.g = i0Var;
    }

    public final int a() {
        return this.g.zzd;
    }

    public final boolean g() {
        return false;
    }

    public final boolean h() {
        return this.g.w();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v45, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v50, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v51, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v58, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v59, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v60, resolved type: java.lang.Boolean} */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x03a5, code lost:
        r7 = java.lang.Boolean.FALSE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x016f, code lost:
        if (r5.booleanValue() == false) goto L_0x03a5;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x03d2  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x03da A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x03db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean i(java.lang.Long r17, java.lang.Long r18, a.d.a.a.h.g.x0 r19, long r20, a.d.a.a.i.b.l r22, boolean r23) {
        /*
            r16 = this;
            r0 = r16
            r1 = r19
            boolean r2 = a.d.a.a.h.g.la.b()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x001e
            a.d.a.a.i.b.ba r2 = r0.h
            a.d.a.a.i.b.c5 r2 = r2.f2563a
            a.d.a.a.i.b.ka r2 = r2.g
            java.lang.String r5 = r0.f2279a
            a.d.a.a.i.b.n3<java.lang.Boolean> r6 = a.d.a.a.i.b.q.d0
            boolean r2 = r2.t(r5, r6)
            if (r2 == 0) goto L_0x001e
            r2 = 1
            goto L_0x001f
        L_0x001e:
            r2 = 0
        L_0x001f:
            a.d.a.a.h.g.i0 r5 = r0.g
            boolean r5 = r5.zzk
            if (r5 == 0) goto L_0x002a
            r5 = r22
            long r5 = r5.f2337e
            goto L_0x002c
        L_0x002a:
            r5 = r20
        L_0x002c:
            a.d.a.a.i.b.ba r7 = r0.h
            a.d.a.a.i.b.x3 r7 = r7.i()
            r8 = 2
            boolean r7 = r7.x(r8)
            java.lang.String r9 = "null"
            if (r7 == 0) goto L_0x0108
            a.d.a.a.i.b.ba r7 = r0.h
            a.d.a.a.i.b.x3 r7 = r7.i()
            a.d.a.a.i.b.z3 r7 = r7.n
            int r10 = r0.f2280b
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            a.d.a.a.h.g.i0 r11 = r0.g
            boolean r11 = r11.u()
            if (r11 == 0) goto L_0x005a
            a.d.a.a.h.g.i0 r11 = r0.g
            int r11 = r11.zzd
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            goto L_0x005b
        L_0x005a:
            r11 = 0
        L_0x005b:
            a.d.a.a.i.b.ba r12 = r0.h
            a.d.a.a.i.b.v3 r12 = r12.d()
            a.d.a.a.h.g.i0 r13 = r0.g
            java.lang.String r13 = r13.zze
            java.lang.String r12 = r12.u(r13)
            java.lang.String r13 = "Evaluating filter. audience, filter, event"
            r7.d(r13, r10, r11, r12)
            a.d.a.a.i.b.ba r7 = r0.h
            a.d.a.a.i.b.x3 r7 = r7.i()
            a.d.a.a.i.b.z3 r7 = r7.n
            a.d.a.a.i.b.ba r10 = r0.h
            a.d.a.a.i.b.s9 r10 = r10.l()
            a.d.a.a.h.g.i0 r11 = r0.g
            if (r10 == 0) goto L_0x0106
            if (r11 != 0) goto L_0x0085
            r8 = r9
            goto L_0x0100
        L_0x0085:
            java.lang.String r12 = "\nevent_filter {\n"
            java.lang.StringBuilder r12 = a.a.a.a.a.n(r12)
            boolean r13 = r11.u()
            if (r13 == 0) goto L_0x009c
            int r13 = r11.zzd
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            java.lang.String r14 = "filter_id"
            a.d.a.a.i.b.s9.L(r12, r4, r14, r13)
        L_0x009c:
            a.d.a.a.i.b.v3 r13 = r10.d()
            java.lang.String r14 = r11.zze
            java.lang.String r13 = r13.u(r14)
            java.lang.String r14 = "event_name"
            a.d.a.a.i.b.s9.L(r12, r4, r14, r13)
            boolean r13 = r11.zzi
            boolean r14 = r11.zzj
            boolean r15 = r11.zzk
            java.lang.String r13 = a.d.a.a.i.b.s9.A(r13, r14, r15)
            boolean r14 = r13.isEmpty()
            if (r14 != 0) goto L_0x00c0
            java.lang.String r14 = "filter_type"
            a.d.a.a.i.b.s9.L(r12, r4, r14, r13)
        L_0x00c0:
            boolean r13 = r11.w()
            if (r13 == 0) goto L_0x00d1
            a.d.a.a.h.g.k0 r13 = r11.zzh
            if (r13 != 0) goto L_0x00cc
            a.d.a.a.h.g.k0 r13 = a.d.a.a.h.g.k0.zzi
        L_0x00cc:
            java.lang.String r14 = "event_count_filter"
            a.d.a.a.i.b.s9.J(r12, r3, r14, r13)
        L_0x00d1:
            a.d.a.a.h.g.f6<a.d.a.a.h.g.j0> r13 = r11.zzf
            int r13 = r13.size()
            if (r13 <= 0) goto L_0x00f4
            java.lang.String r13 = "  filters {\n"
            r12.append(r13)
            a.d.a.a.h.g.f6<a.d.a.a.h.g.j0> r11 = r11.zzf
            java.util.Iterator r11 = r11.iterator()
        L_0x00e4:
            boolean r13 = r11.hasNext()
            if (r13 == 0) goto L_0x00f4
            java.lang.Object r13 = r11.next()
            a.d.a.a.h.g.j0 r13 = (a.d.a.a.h.g.j0) r13
            r10.I(r12, r8, r13)
            goto L_0x00e4
        L_0x00f4:
            a.d.a.a.i.b.s9.H(r12, r3)
            java.lang.String r8 = "}\n}\n"
            r12.append(r8)
            java.lang.String r8 = r12.toString()
        L_0x0100:
            java.lang.String r10 = "Filter definition"
            r7.b(r10, r8)
            goto L_0x0108
        L_0x0106:
            r1 = 0
            throw r1
        L_0x0108:
            r7 = 0
            a.d.a.a.h.g.i0 r8 = r0.g
            boolean r8 = r8.u()
            if (r8 == 0) goto L_0x0418
            a.d.a.a.h.g.i0 r8 = r0.g
            int r10 = r8.zzd
            r11 = 256(0x100, float:3.59E-43)
            if (r10 <= r11) goto L_0x011b
            goto L_0x0418
        L_0x011b:
            boolean r10 = r8.zzi
            boolean r11 = r8.zzj
            boolean r8 = r8.zzk
            if (r10 != 0) goto L_0x012a
            if (r11 != 0) goto L_0x012a
            if (r8 == 0) goto L_0x0128
            goto L_0x012a
        L_0x0128:
            r8 = 0
            goto L_0x012b
        L_0x012a:
            r8 = 1
        L_0x012b:
            if (r23 == 0) goto L_0x0153
            if (r8 != 0) goto L_0x0153
            a.d.a.a.i.b.ba r1 = r0.h
            a.d.a.a.i.b.x3 r1 = r1.i()
            a.d.a.a.i.b.z3 r1 = r1.n
            int r2 = r0.f2280b
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            a.d.a.a.h.g.i0 r4 = r0.g
            boolean r4 = r4.u()
            if (r4 == 0) goto L_0x014d
            a.d.a.a.h.g.i0 r4 = r0.g
            int r4 = r4.zzd
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
        L_0x014d:
            java.lang.String r4 = "Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            r1.c(r4, r2, r7)
            return r3
        L_0x0153:
            a.d.a.a.h.g.i0 r10 = r0.g
            java.lang.String r11 = r1.zze
            boolean r12 = r10.w()
            if (r12 == 0) goto L_0x0173
            a.d.a.a.h.g.k0 r12 = r10.zzh
            if (r12 != 0) goto L_0x0163
            a.d.a.a.h.g.k0 r12 = a.d.a.a.h.g.k0.zzi
        L_0x0163:
            java.lang.Boolean r5 = a.d.a.a.i.b.ia.b(r5, r12)
            if (r5 != 0) goto L_0x016b
            goto L_0x03c7
        L_0x016b:
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L_0x0173
            goto L_0x03a5
        L_0x0173:
            java.util.HashSet r5 = new java.util.HashSet
            r5.<init>()
            a.d.a.a.h.g.f6<a.d.a.a.h.g.j0> r6 = r10.zzf
            java.util.Iterator r6 = r6.iterator()
        L_0x017e:
            boolean r12 = r6.hasNext()
            if (r12 == 0) goto L_0x01b1
            java.lang.Object r12 = r6.next()
            a.d.a.a.h.g.j0 r12 = (a.d.a.a.h.g.j0) r12
            java.lang.String r13 = r12.zzg
            boolean r13 = r13.isEmpty()
            if (r13 == 0) goto L_0x01ab
            a.d.a.a.i.b.ba r5 = r0.h
            a.d.a.a.i.b.x3 r5 = r5.i()
            a.d.a.a.i.b.z3 r5 = r5.i
            a.d.a.a.i.b.ba r6 = r0.h
            a.d.a.a.i.b.v3 r6 = r6.d()
            java.lang.String r6 = r6.u(r11)
            java.lang.String r10 = "null or empty param name in filter. event"
            r5.b(r10, r6)
            goto L_0x03c7
        L_0x01ab:
            java.lang.String r12 = r12.zzg
            r5.add(r12)
            goto L_0x017e
        L_0x01b1:
            androidx.collection.ArrayMap r6 = new androidx.collection.ArrayMap
            r6.<init>()
            a.d.a.a.h.g.f6<a.d.a.a.h.g.z0> r7 = r1.zzd
            java.util.Iterator r7 = r7.iterator()
        L_0x01bc:
            boolean r12 = r7.hasNext()
            if (r12 == 0) goto L_0x022c
            java.lang.Object r12 = r7.next()
            a.d.a.a.h.g.z0 r12 = (a.d.a.a.h.g.z0) r12
            java.lang.String r13 = r12.zzd
            boolean r13 = r5.contains(r13)
            if (r13 == 0) goto L_0x01bc
            boolean r13 = r12.z()
            if (r13 == 0) goto L_0x01ea
            java.lang.String r13 = r12.zzd
            boolean r14 = r12.z()
            if (r14 == 0) goto L_0x01e5
            long r14 = r12.zzf
            java.lang.Long r12 = java.lang.Long.valueOf(r14)
            goto L_0x01e6
        L_0x01e5:
            r12 = 0
        L_0x01e6:
            r6.put(r13, r12)
            goto L_0x01bc
        L_0x01ea:
            boolean r13 = r12.B()
            if (r13 == 0) goto L_0x01ff
            java.lang.String r13 = r12.zzd
            boolean r14 = r12.B()
            if (r14 == 0) goto L_0x01e5
            double r14 = r12.zzh
            java.lang.Double r12 = java.lang.Double.valueOf(r14)
            goto L_0x01e6
        L_0x01ff:
            boolean r13 = r12.w()
            if (r13 == 0) goto L_0x020a
            java.lang.String r13 = r12.zzd
            java.lang.String r12 = r12.zze
            goto L_0x01e6
        L_0x020a:
            a.d.a.a.i.b.ba r5 = r0.h
            a.d.a.a.i.b.x3 r5 = r5.i()
            a.d.a.a.i.b.z3 r5 = r5.i
            a.d.a.a.i.b.ba r6 = r0.h
            a.d.a.a.i.b.v3 r6 = r6.d()
            java.lang.String r6 = r6.u(r11)
            a.d.a.a.i.b.ba r7 = r0.h
            a.d.a.a.i.b.v3 r7 = r7.d()
            java.lang.String r10 = r12.zzd
            java.lang.String r7 = r7.x(r10)
            java.lang.String r10 = "Unknown value for param. event, param"
            goto L_0x03c0
        L_0x022c:
            a.d.a.a.h.g.f6<a.d.a.a.h.g.j0> r5 = r10.zzf
            java.util.Iterator r5 = r5.iterator()
        L_0x0232:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x03c5
            java.lang.Object r7 = r5.next()
            a.d.a.a.h.g.j0 r7 = (a.d.a.a.h.g.j0) r7
            int r10 = r7.zzc
            r10 = r10 & 4
            if (r10 == 0) goto L_0x0246
            r10 = 1
            goto L_0x0247
        L_0x0246:
            r10 = 0
        L_0x0247:
            if (r10 == 0) goto L_0x024f
            boolean r10 = r7.zzf
            if (r10 == 0) goto L_0x024f
            r10 = 1
            goto L_0x0250
        L_0x024f:
            r10 = 0
        L_0x0250:
            java.lang.String r12 = r7.zzg
            boolean r13 = r12.isEmpty()
            if (r13 == 0) goto L_0x0271
            a.d.a.a.i.b.ba r5 = r0.h
            a.d.a.a.i.b.x3 r5 = r5.i()
            a.d.a.a.i.b.z3 r5 = r5.i
            a.d.a.a.i.b.ba r6 = r0.h
            a.d.a.a.i.b.v3 r6 = r6.d()
            java.lang.String r6 = r6.u(r11)
            java.lang.String r7 = "Event has empty param name. event"
            r5.b(r7, r6)
            goto L_0x03c3
        L_0x0271:
            java.lang.Object r13 = r6.get(r12)
            boolean r14 = r13 instanceof java.lang.Long
            if (r14 == 0) goto L_0x02b9
            boolean r14 = r7.v()
            if (r14 != 0) goto L_0x029f
            a.d.a.a.i.b.ba r5 = r0.h
            a.d.a.a.i.b.x3 r5 = r5.i()
            a.d.a.a.i.b.z3 r5 = r5.i
            a.d.a.a.i.b.ba r6 = r0.h
            a.d.a.a.i.b.v3 r6 = r6.d()
            java.lang.String r6 = r6.u(r11)
            a.d.a.a.i.b.ba r7 = r0.h
            a.d.a.a.i.b.v3 r7 = r7.d()
            java.lang.String r7 = r7.x(r12)
            java.lang.String r10 = "No number filter for long param. event, param"
            goto L_0x03c0
        L_0x029f:
            java.lang.Long r13 = (java.lang.Long) r13
            long r12 = r13.longValue()
            a.d.a.a.h.g.k0 r7 = r7.w()
            java.lang.Boolean r7 = a.d.a.a.i.b.ia.b(r12, r7)
            if (r7 != 0) goto L_0x02b1
            goto L_0x03c3
        L_0x02b1:
            boolean r7 = r7.booleanValue()
            if (r7 != r10) goto L_0x0232
            goto L_0x03a5
        L_0x02b9:
            boolean r14 = r13 instanceof java.lang.Double
            if (r14 == 0) goto L_0x0308
            boolean r14 = r7.v()
            if (r14 != 0) goto L_0x02e3
            a.d.a.a.i.b.ba r5 = r0.h
            a.d.a.a.i.b.x3 r5 = r5.i()
            a.d.a.a.i.b.z3 r5 = r5.i
            a.d.a.a.i.b.ba r6 = r0.h
            a.d.a.a.i.b.v3 r6 = r6.d()
            java.lang.String r6 = r6.u(r11)
            a.d.a.a.i.b.ba r7 = r0.h
            a.d.a.a.i.b.v3 r7 = r7.d()
            java.lang.String r7 = r7.x(r12)
            java.lang.String r10 = "No number filter for double param. event, param"
            goto L_0x03c0
        L_0x02e3:
            java.lang.Double r13 = (java.lang.Double) r13
            double r12 = r13.doubleValue()
            a.d.a.a.h.g.k0 r7 = r7.w()
            java.math.BigDecimal r14 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x02fb }
            r14.<init>(r12)     // Catch:{ NumberFormatException -> 0x02fb }
            double r12 = java.lang.Math.ulp(r12)     // Catch:{ NumberFormatException -> 0x02fb }
            java.lang.Boolean r7 = a.d.a.a.i.b.ia.f(r14, r7, r12)     // Catch:{ NumberFormatException -> 0x02fb }
            goto L_0x02fc
        L_0x02fb:
            r7 = 0
        L_0x02fc:
            if (r7 != 0) goto L_0x0300
            goto L_0x03c3
        L_0x0300:
            boolean r7 = r7.booleanValue()
            if (r7 != r10) goto L_0x0232
            goto L_0x03a5
        L_0x0308:
            boolean r14 = r13 instanceof java.lang.String
            if (r14 == 0) goto L_0x0382
            boolean r14 = r7.t()
            if (r14 == 0) goto L_0x0323
            java.lang.String r13 = (java.lang.String) r13
            a.d.a.a.h.g.m0 r7 = r7.u()
            a.d.a.a.i.b.ba r12 = r0.h
            a.d.a.a.i.b.x3 r12 = r12.i()
            java.lang.Boolean r7 = a.d.a.a.i.b.ia.e(r13, r7, r12)
            goto L_0x0339
        L_0x0323:
            boolean r14 = r7.v()
            if (r14 == 0) goto L_0x0363
            java.lang.String r13 = (java.lang.String) r13
            boolean r14 = a.d.a.a.i.b.s9.P(r13)
            if (r14 == 0) goto L_0x0344
            a.d.a.a.h.g.k0 r7 = r7.w()
            java.lang.Boolean r7 = a.d.a.a.i.b.ia.d(r13, r7)
        L_0x0339:
            if (r7 != 0) goto L_0x033d
            goto L_0x03c3
        L_0x033d:
            boolean r7 = r7.booleanValue()
            if (r7 != r10) goto L_0x0232
            goto L_0x03a5
        L_0x0344:
            a.d.a.a.i.b.ba r5 = r0.h
            a.d.a.a.i.b.x3 r5 = r5.i()
            a.d.a.a.i.b.z3 r5 = r5.i
            a.d.a.a.i.b.ba r6 = r0.h
            a.d.a.a.i.b.v3 r6 = r6.d()
            java.lang.String r6 = r6.u(r11)
            a.d.a.a.i.b.ba r7 = r0.h
            a.d.a.a.i.b.v3 r7 = r7.d()
            java.lang.String r7 = r7.x(r12)
            java.lang.String r10 = "Invalid param value for number filter. event, param"
            goto L_0x03c0
        L_0x0363:
            a.d.a.a.i.b.ba r5 = r0.h
            a.d.a.a.i.b.x3 r5 = r5.i()
            a.d.a.a.i.b.z3 r5 = r5.i
            a.d.a.a.i.b.ba r6 = r0.h
            a.d.a.a.i.b.v3 r6 = r6.d()
            java.lang.String r6 = r6.u(r11)
            a.d.a.a.i.b.ba r7 = r0.h
            a.d.a.a.i.b.v3 r7 = r7.d()
            java.lang.String r7 = r7.x(r12)
            java.lang.String r10 = "No filter for String param. event, param"
            goto L_0x03c0
        L_0x0382:
            a.d.a.a.i.b.ba r5 = r0.h
            a.d.a.a.i.b.x3 r5 = r5.i()
            if (r13 != 0) goto L_0x03a8
            a.d.a.a.i.b.z3 r5 = r5.n
            a.d.a.a.i.b.ba r6 = r0.h
            a.d.a.a.i.b.v3 r6 = r6.d()
            java.lang.String r6 = r6.u(r11)
            a.d.a.a.i.b.ba r7 = r0.h
            a.d.a.a.i.b.v3 r7 = r7.d()
            java.lang.String r7 = r7.x(r12)
            java.lang.String r10 = "Missing param for filter. event, param"
            r5.c(r10, r6, r7)
        L_0x03a5:
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            goto L_0x03c7
        L_0x03a8:
            a.d.a.a.i.b.z3 r5 = r5.i
            a.d.a.a.i.b.ba r6 = r0.h
            a.d.a.a.i.b.v3 r6 = r6.d()
            java.lang.String r6 = r6.u(r11)
            a.d.a.a.i.b.ba r7 = r0.h
            a.d.a.a.i.b.v3 r7 = r7.d()
            java.lang.String r7 = r7.x(r12)
            java.lang.String r10 = "Unknown param type. event, param"
        L_0x03c0:
            r5.c(r10, r6, r7)
        L_0x03c3:
            r7 = 0
            goto L_0x03c7
        L_0x03c5:
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
        L_0x03c7:
            a.d.a.a.i.b.ba r5 = r0.h
            a.d.a.a.i.b.x3 r5 = r5.i()
            a.d.a.a.i.b.z3 r5 = r5.n
            if (r7 != 0) goto L_0x03d2
            goto L_0x03d3
        L_0x03d2:
            r9 = r7
        L_0x03d3:
            java.lang.String r6 = "Event filter result"
            r5.b(r6, r9)
            if (r7 != 0) goto L_0x03db
            return r4
        L_0x03db:
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            r0.f2281c = r4
            boolean r4 = r7.booleanValue()
            if (r4 != 0) goto L_0x03e6
            return r3
        L_0x03e6:
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            r0.f2282d = r4
            if (r8 == 0) goto L_0x0417
            boolean r4 = r19.A()
            if (r4 == 0) goto L_0x0417
            long r4 = r1.zzf
            java.lang.Long r1 = java.lang.Long.valueOf(r4)
            a.d.a.a.h.g.i0 r4 = r0.g
            boolean r5 = r4.zzj
            if (r5 == 0) goto L_0x040b
            if (r2 == 0) goto L_0x0408
            boolean r2 = r4.w()
            if (r2 == 0) goto L_0x0408
            r1 = r17
        L_0x0408:
            r0.f = r1
            goto L_0x0417
        L_0x040b:
            if (r2 == 0) goto L_0x0415
            boolean r2 = r4.w()
            if (r2 == 0) goto L_0x0415
            r1 = r18
        L_0x0415:
            r0.f2283e = r1
        L_0x0417:
            return r3
        L_0x0418:
            a.d.a.a.i.b.ba r1 = r0.h
            a.d.a.a.i.b.x3 r1 = r1.i()
            a.d.a.a.i.b.z3 r1 = r1.i
            java.lang.String r2 = r0.f2279a
            java.lang.Object r2 = a.d.a.a.i.b.x3.s(r2)
            a.d.a.a.h.g.i0 r3 = r0.g
            boolean r3 = r3.u()
            if (r3 == 0) goto L_0x0437
            a.d.a.a.h.g.i0 r3 = r0.g
            int r3 = r3.zzd
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0438
        L_0x0437:
            r3 = 0
        L_0x0438:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r5 = "Invalid event filter ID. appId, id"
            r1.c(r5, r2, r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.fa.i(java.lang.Long, java.lang.Long, a.d.a.a.h.g.x0, long, a.d.a.a.i.b.l, boolean):boolean");
    }
}
