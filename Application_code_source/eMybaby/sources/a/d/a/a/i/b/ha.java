package a.d.a.a.i.b;

import a.d.a.a.h.g.l0;

public final class ha extends ia {
    public l0 g;
    public final /* synthetic */ ba h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ha(ba baVar, String str, int i, l0 l0Var) {
        super(str, i);
        this.h = baVar;
        this.g = l0Var;
    }

    public final int a() {
        return this.g.zzd;
    }

    public final boolean g() {
        return true;
    }

    public final boolean h() {
        return false;
    }

    /* JADX WARNING: type inference failed for: r5v13, types: [java.lang.Integer] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0172 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0173  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean i(java.lang.Long r12, java.lang.Long r13, a.d.a.a.h.g.f1 r14, boolean r15) {
        /*
            r11 = this;
            boolean r0 = a.d.a.a.h.g.la.b()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x001a
            a.d.a.a.i.b.ba r0 = r11.h
            a.d.a.a.i.b.c5 r0 = r0.f2563a
            a.d.a.a.i.b.ka r0 = r0.g
            java.lang.String r3 = r11.f2279a
            a.d.a.a.i.b.n3<java.lang.Boolean> r4 = a.d.a.a.i.b.q.b0
            boolean r0 = r0.t(r3, r4)
            if (r0 == 0) goto L_0x001a
            r0 = 1
            goto L_0x001b
        L_0x001a:
            r0 = 0
        L_0x001b:
            a.d.a.a.h.g.l0 r3 = r11.g
            boolean r4 = r3.zzg
            boolean r5 = r3.zzh
            boolean r3 = r3.zzi
            if (r4 != 0) goto L_0x002c
            if (r5 != 0) goto L_0x002c
            if (r3 == 0) goto L_0x002a
            goto L_0x002c
        L_0x002a:
            r4 = 0
            goto L_0x002d
        L_0x002c:
            r4 = 1
        L_0x002d:
            r5 = 0
            if (r15 == 0) goto L_0x0056
            if (r4 != 0) goto L_0x0056
            a.d.a.a.i.b.ba r12 = r11.h
            a.d.a.a.i.b.x3 r12 = r12.i()
            a.d.a.a.i.b.z3 r12 = r12.n
            int r13 = r11.f2280b
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            a.d.a.a.h.g.l0 r14 = r11.g
            boolean r14 = r14.t()
            if (r14 == 0) goto L_0x0050
            a.d.a.a.h.g.l0 r14 = r11.g
            int r14 = r14.zzd
            java.lang.Integer r5 = java.lang.Integer.valueOf(r14)
        L_0x0050:
            java.lang.String r14 = "Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            r12.c(r14, r13, r5)
            return r2
        L_0x0056:
            a.d.a.a.h.g.l0 r6 = r11.g
            a.d.a.a.h.g.j0 r6 = r6.zzf
            if (r6 != 0) goto L_0x005e
            a.d.a.a.h.g.j0 r6 = a.d.a.a.h.g.j0.zzh
        L_0x005e:
            boolean r7 = r6.zzf
            int r8 = r14.zzc
            r8 = r8 & 8
            if (r8 == 0) goto L_0x0068
            r8 = 1
            goto L_0x0069
        L_0x0068:
            r8 = 0
        L_0x0069:
            if (r8 == 0) goto L_0x0095
            boolean r8 = r6.v()
            if (r8 != 0) goto L_0x0089
            a.d.a.a.i.b.ba r6 = r11.h
            a.d.a.a.i.b.x3 r6 = r6.i()
            a.d.a.a.i.b.z3 r6 = r6.i
            a.d.a.a.i.b.ba r7 = r11.h
            a.d.a.a.i.b.v3 r7 = r7.d()
            java.lang.String r8 = r14.zze
            java.lang.String r7 = r7.y(r8)
            java.lang.String r8 = "No number filter for long property. property"
            goto L_0x015a
        L_0x0089:
            long r8 = r14.zzg
            a.d.a.a.h.g.k0 r5 = r6.w()
            java.lang.Boolean r5 = a.d.a.a.i.b.ia.b(r8, r5)
            goto L_0x013f
        L_0x0095:
            int r8 = r14.zzc
            r8 = r8 & 32
            if (r8 == 0) goto L_0x009d
            r8 = 1
            goto L_0x009e
        L_0x009d:
            r8 = 0
        L_0x009e:
            if (r8 == 0) goto L_0x00d2
            boolean r8 = r6.v()
            if (r8 != 0) goto L_0x00be
            a.d.a.a.i.b.ba r6 = r11.h
            a.d.a.a.i.b.x3 r6 = r6.i()
            a.d.a.a.i.b.z3 r6 = r6.i
            a.d.a.a.i.b.ba r7 = r11.h
            a.d.a.a.i.b.v3 r7 = r7.d()
            java.lang.String r8 = r14.zze
            java.lang.String r7 = r7.y(r8)
            java.lang.String r8 = "No number filter for double property. property"
            goto L_0x015a
        L_0x00be:
            double r8 = r14.zzi
            a.d.a.a.h.g.k0 r6 = r6.w()
            java.math.BigDecimal r10 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x013f }
            r10.<init>(r8)     // Catch:{ NumberFormatException -> 0x013f }
            double r8 = java.lang.Math.ulp(r8)     // Catch:{ NumberFormatException -> 0x013f }
            java.lang.Boolean r5 = a.d.a.a.i.b.ia.f(r10, r6, r8)     // Catch:{ NumberFormatException -> 0x013f }
            goto L_0x013f
        L_0x00d2:
            int r8 = r14.zzc
            r8 = r8 & 4
            if (r8 == 0) goto L_0x00da
            r8 = 1
            goto L_0x00db
        L_0x00da:
            r8 = 0
        L_0x00db:
            if (r8 == 0) goto L_0x0144
            boolean r8 = r6.t()
            if (r8 != 0) goto L_0x012f
            boolean r8 = r6.v()
            if (r8 != 0) goto L_0x0100
            a.d.a.a.i.b.ba r6 = r11.h
            a.d.a.a.i.b.x3 r6 = r6.i()
            a.d.a.a.i.b.z3 r6 = r6.i
            a.d.a.a.i.b.ba r7 = r11.h
            a.d.a.a.i.b.v3 r7 = r7.d()
            java.lang.String r8 = r14.zze
            java.lang.String r7 = r7.y(r8)
            java.lang.String r8 = "No string or number filter defined. property"
            goto L_0x015a
        L_0x0100:
            java.lang.String r8 = r14.zzf
            boolean r8 = a.d.a.a.i.b.s9.P(r8)
            if (r8 == 0) goto L_0x0113
            java.lang.String r5 = r14.zzf
            a.d.a.a.h.g.k0 r6 = r6.w()
            java.lang.Boolean r5 = a.d.a.a.i.b.ia.d(r5, r6)
            goto L_0x013f
        L_0x0113:
            a.d.a.a.i.b.ba r6 = r11.h
            a.d.a.a.i.b.x3 r6 = r6.i()
            a.d.a.a.i.b.z3 r6 = r6.i
            a.d.a.a.i.b.ba r7 = r11.h
            a.d.a.a.i.b.v3 r7 = r7.d()
            java.lang.String r8 = r14.zze
            java.lang.String r7 = r7.y(r8)
            java.lang.String r8 = r14.zzf
            java.lang.String r9 = "Invalid user property value for Numeric number filter. property, value"
            r6.c(r9, r7, r8)
            goto L_0x015d
        L_0x012f:
            java.lang.String r5 = r14.zzf
            a.d.a.a.h.g.m0 r6 = r6.u()
            a.d.a.a.i.b.ba r8 = r11.h
            a.d.a.a.i.b.x3 r8 = r8.i()
            java.lang.Boolean r5 = a.d.a.a.i.b.ia.e(r5, r6, r8)
        L_0x013f:
            java.lang.Boolean r5 = a.d.a.a.i.b.ia.c(r5, r7)
            goto L_0x015d
        L_0x0144:
            a.d.a.a.i.b.ba r6 = r11.h
            a.d.a.a.i.b.x3 r6 = r6.i()
            a.d.a.a.i.b.z3 r6 = r6.i
            a.d.a.a.i.b.ba r7 = r11.h
            a.d.a.a.i.b.v3 r7 = r7.d()
            java.lang.String r8 = r14.zze
            java.lang.String r7 = r7.y(r8)
            java.lang.String r8 = "User property has no value, property"
        L_0x015a:
            r6.b(r8, r7)
        L_0x015d:
            a.d.a.a.i.b.ba r6 = r11.h
            a.d.a.a.i.b.x3 r6 = r6.i()
            a.d.a.a.i.b.z3 r6 = r6.n
            if (r5 != 0) goto L_0x016a
            java.lang.String r7 = "null"
            goto L_0x016b
        L_0x016a:
            r7 = r5
        L_0x016b:
            java.lang.String r8 = "Property filter result"
            r6.b(r8, r7)
            if (r5 != 0) goto L_0x0173
            return r1
        L_0x0173:
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            r11.f2281c = r6
            if (r3 == 0) goto L_0x0180
            boolean r3 = r5.booleanValue()
            if (r3 != 0) goto L_0x0180
            return r2
        L_0x0180:
            if (r15 == 0) goto L_0x0188
            a.d.a.a.h.g.l0 r15 = r11.g
            boolean r15 = r15.zzg
            if (r15 == 0) goto L_0x018a
        L_0x0188:
            r11.f2282d = r5
        L_0x018a:
            boolean r15 = r5.booleanValue()
            if (r15 == 0) goto L_0x01c7
            if (r4 == 0) goto L_0x01c7
            int r15 = r14.zzc
            r15 = r15 & r2
            if (r15 == 0) goto L_0x0198
            r1 = 1
        L_0x0198:
            if (r1 == 0) goto L_0x01c7
            long r14 = r14.zzd
            if (r12 == 0) goto L_0x01a2
            long r14 = r12.longValue()
        L_0x01a2:
            if (r0 == 0) goto L_0x01b4
            a.d.a.a.h.g.l0 r12 = r11.g
            boolean r0 = r12.zzg
            if (r0 == 0) goto L_0x01b4
            boolean r12 = r12.zzh
            if (r12 != 0) goto L_0x01b4
            if (r13 == 0) goto L_0x01b4
            long r14 = r13.longValue()
        L_0x01b4:
            a.d.a.a.h.g.l0 r12 = r11.g
            boolean r12 = r12.zzh
            if (r12 == 0) goto L_0x01c1
            java.lang.Long r12 = java.lang.Long.valueOf(r14)
            r11.f = r12
            goto L_0x01c7
        L_0x01c1:
            java.lang.Long r12 = java.lang.Long.valueOf(r14)
            r11.f2283e = r12
        L_0x01c7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.ha.i(java.lang.Long, java.lang.Long, a.d.a.a.h.g.f1, boolean):boolean");
    }
}
