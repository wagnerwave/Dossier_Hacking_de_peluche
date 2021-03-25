package a.d.a.a.i.b;

import a.c.a.f.b;
import a.d.a.a.h.g.aa;
import a.d.a.a.h.g.c9;
import a.d.a.a.h.g.i6;
import a.d.a.a.h.g.q0;
import a.d.a.a.h.g.r0;
import a.d.a.a.h.g.s0;
import a.d.a.a.h.g.y5;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import java.util.Map;

public final class w4 extends m9 implements b {

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, Map<String, String>> f2588d = new ArrayMap();

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, Map<String, Boolean>> f2589e = new ArrayMap();
    public final Map<String, Map<String, Boolean>> f = new ArrayMap();
    public final Map<String, r0> g = new ArrayMap();
    public final Map<String, Map<String, Integer>> h = new ArrayMap();
    public final Map<String, String> i = new ArrayMap();

    public w4(o9 o9Var) {
        super(o9Var);
    }

    public static Map<String, String> u(r0 r0Var) {
        ArrayMap arrayMap = new ArrayMap();
        for (s0 next : r0Var.zzg) {
            arrayMap.put(next.zzd, next.zze);
        }
        return arrayMap;
    }

    @WorkerThread
    public final boolean A(String str) {
        b();
        r0 s = s(str);
        if (s == null) {
            return false;
        }
        return s.zzk;
    }

    @WorkerThread
    public final long B(String str) {
        String h2 = h(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(h2)) {
            return 0;
        }
        try {
            return Long.parseLong(h2);
        } catch (NumberFormatException e2) {
            i().i.c("Unable to parse timezone offset. appId", x3.s(str), e2);
            return 0;
        }
    }

    public final boolean C(String str) {
        return "1".equals(h(str, "measurement.upload.blacklist_internal"));
    }

    public final boolean D(String str) {
        return "1".equals(h(str, "measurement.upload.blacklist_public"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007f, code lost:
        if (r2 != null) goto L_0x0048;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d9  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void E(java.lang.String r13) {
        /*
            r12 = this;
            r12.n()
            r12.b()
            a.c.a.f.b.h(r13)
            java.util.Map<java.lang.String, a.d.a.a.h.g.r0> r0 = r12.g
            java.lang.Object r0 = r0.get(r13)
            if (r0 != 0) goto L_0x00de
            a.d.a.a.i.b.d r0 = r12.q()
            r1 = 0
            if (r0 == 0) goto L_0x00dd
            a.c.a.f.b.h(r13)
            r0.b()
            r0.n()
            android.database.sqlite.SQLiteDatabase r2 = r0.t()     // Catch:{ SQLiteException -> 0x006d, all -> 0x006b }
            java.lang.String r3 = "apps"
            r4 = 1
            java.lang.String[] r5 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x006d, all -> 0x006b }
            java.lang.String r6 = "remote_config"
            r10 = 0
            r5[r10] = r6     // Catch:{ SQLiteException -> 0x006d, all -> 0x006b }
            java.lang.String r6 = "app_id=?"
            java.lang.String[] r7 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x006d, all -> 0x006b }
            r7[r10] = r13     // Catch:{ SQLiteException -> 0x006d, all -> 0x006b }
            r8 = 0
            r9 = 0
            r11 = 0
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r11
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x006d, all -> 0x006b }
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0069 }
            if (r3 != 0) goto L_0x004c
        L_0x0048:
            r2.close()
            goto L_0x0082
        L_0x004c:
            byte[] r3 = r2.getBlob(r10)     // Catch:{ SQLiteException -> 0x0069 }
            boolean r4 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x0069 }
            if (r4 == 0) goto L_0x0065
            a.d.a.a.i.b.x3 r4 = r0.i()     // Catch:{ SQLiteException -> 0x0069 }
            a.d.a.a.i.b.z3 r4 = r4.f     // Catch:{ SQLiteException -> 0x0069 }
            java.lang.String r5 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r6 = a.d.a.a.i.b.x3.s(r13)     // Catch:{ SQLiteException -> 0x0069 }
            r4.b(r5, r6)     // Catch:{ SQLiteException -> 0x0069 }
        L_0x0065:
            r2.close()
            goto L_0x0083
        L_0x0069:
            r3 = move-exception
            goto L_0x0070
        L_0x006b:
            r13 = move-exception
            goto L_0x00d7
        L_0x006d:
            r2 = move-exception
            r3 = r2
            r2 = r1
        L_0x0070:
            a.d.a.a.i.b.x3 r0 = r0.i()     // Catch:{ all -> 0x00d5 }
            a.d.a.a.i.b.z3 r0 = r0.f     // Catch:{ all -> 0x00d5 }
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r5 = a.d.a.a.i.b.x3.s(r13)     // Catch:{ all -> 0x00d5 }
            r0.c(r4, r5, r3)     // Catch:{ all -> 0x00d5 }
            if (r2 == 0) goto L_0x0082
            goto L_0x0048
        L_0x0082:
            r3 = r1
        L_0x0083:
            if (r3 != 0) goto L_0x00a4
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r0 = r12.f2588d
            r0.put(r13, r1)
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Boolean>> r0 = r12.f2589e
            r0.put(r13, r1)
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Boolean>> r0 = r12.f
            r0.put(r13, r1)
            java.util.Map<java.lang.String, a.d.a.a.h.g.r0> r0 = r12.g
            r0.put(r13, r1)
            java.util.Map<java.lang.String, java.lang.String> r0 = r12.i
            r0.put(r13, r1)
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Integer>> r0 = r12.h
            r0.put(r13, r1)
            return
        L_0x00a4:
            a.d.a.a.h.g.r0 r0 = r12.t(r13, r3)
            a.d.a.a.h.g.y5$b r0 = r0.r()
            a.d.a.a.h.g.r0$a r0 = (a.d.a.a.h.g.r0.a) r0
            r12.v(r13, r0)
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r2 = r12.f2588d
            a.d.a.a.h.g.i7 r3 = r0.m()
            a.d.a.a.h.g.y5 r3 = (a.d.a.a.h.g.y5) r3
            a.d.a.a.h.g.r0 r3 = (a.d.a.a.h.g.r0) r3
            java.util.Map r3 = u(r3)
            r2.put(r13, r3)
            java.util.Map<java.lang.String, a.d.a.a.h.g.r0> r2 = r12.g
            a.d.a.a.h.g.i7 r0 = r0.m()
            a.d.a.a.h.g.y5 r0 = (a.d.a.a.h.g.y5) r0
            a.d.a.a.h.g.r0 r0 = (a.d.a.a.h.g.r0) r0
            r2.put(r13, r0)
            java.util.Map<java.lang.String, java.lang.String> r0 = r12.i
            r0.put(r13, r1)
            goto L_0x00de
        L_0x00d5:
            r13 = move-exception
            r1 = r2
        L_0x00d7:
            if (r1 == 0) goto L_0x00dc
            r1.close()
        L_0x00dc:
            throw r13
        L_0x00dd:
            throw r1
        L_0x00de:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.w4.E(java.lang.String):void");
    }

    @WorkerThread
    public final String h(String str, String str2) {
        b();
        E(str);
        Map map = this.f2588d.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    public final boolean p() {
        return false;
    }

    @WorkerThread
    public final r0 s(String str) {
        n();
        b();
        b.h(str);
        E(str);
        return this.g.get(str);
    }

    @WorkerThread
    public final r0 t(String str, byte[] bArr) {
        if (bArr == null) {
            return r0.zzm;
        }
        try {
            r0 r0Var = (r0) ((y5) ((r0.a) s9.x((r0.a) r0.zzm.q(), bArr)).m());
            z3 z3Var = i().n;
            boolean z = true;
            String str2 = null;
            Long valueOf = (r0Var.zzc & 1) != 0 ? Long.valueOf(r0Var.zzd) : null;
            if ((r0Var.zzc & 2) == 0) {
                z = false;
            }
            if (z) {
                str2 = r0Var.zze;
            }
            z3Var.c("Parsed config. version, gmp_app_id", valueOf, str2);
            return r0Var;
        } catch (i6 | RuntimeException e2) {
            i().i.c("Unable to merge remote config. appId", x3.s(str), e2);
            return r0.zzm;
        }
    }

    public final void v(String str, r0.a aVar) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        for (int i2 = 0; i2 < ((r0) aVar.f2047b).zzh.size(); i2++) {
            q0.a aVar2 = (q0.a) ((r0) aVar.f2047b).zzh.get(i2).r();
            if (TextUtils.isEmpty(aVar2.n())) {
                i().i.a("EventConfig contained null event name");
            } else {
                String n = aVar2.n();
                String c1 = b.c1(aVar2.n(), z5.f2662a, z5.f2664c);
                if (!TextUtils.isEmpty(c1)) {
                    if (aVar2.f2048c) {
                        aVar2.k();
                        aVar2.f2048c = false;
                    }
                    q0.s((q0) aVar2.f2047b, c1);
                    if (aVar.f2048c) {
                        aVar.k();
                        aVar.f2048c = false;
                    }
                    r0.t((r0) aVar.f2047b, i2, (q0) ((y5) aVar2.m()));
                }
                if (!c9.b() || !this.f2563a.g.o(q.U0)) {
                    n = aVar2.n();
                }
                arrayMap.put(n, Boolean.valueOf(((q0) aVar2.f2047b).zze));
                arrayMap2.put(aVar2.n(), Boolean.valueOf(((q0) aVar2.f2047b).zzf));
                if ((((q0) aVar2.f2047b).zzc & 8) != 0) {
                    if (aVar2.o() < 2 || aVar2.o() > 65535) {
                        i().i.c("Invalid sampling rate. Event name, sample rate", aVar2.n(), Integer.valueOf(aVar2.o()));
                    } else {
                        arrayMap3.put(aVar2.n(), Integer.valueOf(aVar2.o()));
                    }
                }
            }
        }
        this.f2589e.put(str, arrayMap);
        this.f.put(str, arrayMap2);
        this.h.put(str, arrayMap3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:78:0x029e, code lost:
        r5.c(r8, r10, java.lang.Integer.valueOf(r6));
     */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean w(java.lang.String r21, byte[] r22, java.lang.String r23) {
        /*
            r20 = this;
            r1 = r20
            r2 = r21
            r20.n()
            r20.b()
            a.c.a.f.b.h(r21)
            a.d.a.a.h.g.r0 r0 = r20.t(r21, r22)
            a.d.a.a.h.g.y5$b r0 = r0.r()
            r3 = r0
            a.d.a.a.h.g.r0$a r3 = (a.d.a.a.h.g.r0.a) r3
            r1.v(r2, r3)
            java.util.Map<java.lang.String, a.d.a.a.h.g.r0> r0 = r1.g
            a.d.a.a.h.g.i7 r4 = r3.m()
            a.d.a.a.h.g.y5 r4 = (a.d.a.a.h.g.y5) r4
            a.d.a.a.h.g.r0 r4 = (a.d.a.a.h.g.r0) r4
            r0.put(r2, r4)
            java.util.Map<java.lang.String, java.lang.String> r0 = r1.i
            r4 = r23
            r0.put(r2, r4)
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r0 = r1.f2588d
            a.d.a.a.h.g.i7 r4 = r3.m()
            a.d.a.a.h.g.y5 r4 = (a.d.a.a.h.g.y5) r4
            a.d.a.a.h.g.r0 r4 = (a.d.a.a.h.g.r0) r4
            java.util.Map r4 = u(r4)
            r0.put(r2, r4)
            a.d.a.a.i.b.d r0 = r20.q()
            java.util.ArrayList r4 = new java.util.ArrayList
            MessageType r5 = r3.f2047b
            a.d.a.a.h.g.r0 r5 = (a.d.a.a.h.g.r0) r5
            a.d.a.a.h.g.f6<a.d.a.a.h.g.h0> r5 = r5.zzi
            java.util.List r5 = java.util.Collections.unmodifiableList(r5)
            r4.<init>(r5)
            if (r0 == 0) goto L_0x03dd
            java.lang.String r6 = "app_id=? and audience_id=?"
            java.lang.String r7 = "event_filters"
            java.lang.String r8 = "app_id=?"
            java.lang.String r9 = "property_filters"
            a.c.a.f.b.k(r4)
            r11 = 0
        L_0x0061:
            int r12 = r4.size()
            if (r11 >= r12) goto L_0x01e3
            java.lang.Object r12 = r4.get(r11)
            a.d.a.a.h.g.h0 r12 = (a.d.a.a.h.g.h0) r12
            a.d.a.a.h.g.y5$b r12 = r12.r()
            a.d.a.a.h.g.h0$a r12 = (a.d.a.a.h.g.h0.a) r12
            MessageType r14 = r12.f2047b
            a.d.a.a.h.g.h0 r14 = (a.d.a.a.h.g.h0) r14
            a.d.a.a.h.g.f6<a.d.a.a.h.g.i0> r14 = r14.zzf
            int r14 = r14.size()
            if (r14 == 0) goto L_0x0165
            r14 = 0
        L_0x0080:
            MessageType r15 = r12.f2047b
            a.d.a.a.h.g.h0 r15 = (a.d.a.a.h.g.h0) r15
            a.d.a.a.h.g.f6<a.d.a.a.h.g.i0> r15 = r15.zzf
            int r15 = r15.size()
            if (r14 >= r15) goto L_0x0165
            MessageType r15 = r12.f2047b
            a.d.a.a.h.g.h0 r15 = (a.d.a.a.h.g.h0) r15
            a.d.a.a.h.g.f6<a.d.a.a.h.g.i0> r15 = r15.zzf
            java.lang.Object r15 = r15.get(r14)
            a.d.a.a.h.g.i0 r15 = (a.d.a.a.h.g.i0) r15
            a.d.a.a.h.g.y5$b r15 = r15.r()
            a.d.a.a.h.g.i0$a r15 = (a.d.a.a.h.g.i0.a) r15
            java.lang.Object r16 = r15.clone()
            a.d.a.a.h.g.y5$b r16 = (a.d.a.a.h.g.y5.b) r16
            r5 = r16
            a.d.a.a.h.g.i0$a r5 = (a.d.a.a.h.g.i0.a) r5
            MessageType r13 = r15.f2047b
            a.d.a.a.h.g.i0 r13 = (a.d.a.a.h.g.i0) r13
            java.lang.String r13 = r13.zze
            java.lang.String[] r10 = a.d.a.a.i.b.z5.f2662a
            java.lang.String[] r1 = a.d.a.a.i.b.z5.f2664c
            java.lang.String r1 = a.c.a.f.b.c1(r13, r10, r1)
            if (r1 == 0) goto L_0x00cb
            boolean r10 = r5.f2048c
            if (r10 == 0) goto L_0x00c2
            r5.k()
            r10 = 0
            r5.f2048c = r10
        L_0x00c2:
            MessageType r10 = r5.f2047b
            a.d.a.a.h.g.i0 r10 = (a.d.a.a.h.g.i0) r10
            a.d.a.a.h.g.i0.t(r10, r1)
            r1 = 1
            goto L_0x00cc
        L_0x00cb:
            r1 = 0
        L_0x00cc:
            r10 = 0
        L_0x00cd:
            MessageType r13 = r15.f2047b
            a.d.a.a.h.g.i0 r13 = (a.d.a.a.h.g.i0) r13
            a.d.a.a.h.g.f6<a.d.a.a.h.g.j0> r13 = r13.zzf
            int r13 = r13.size()
            if (r10 >= r13) goto L_0x0131
            MessageType r13 = r15.f2047b
            a.d.a.a.h.g.i0 r13 = (a.d.a.a.h.g.i0) r13
            a.d.a.a.h.g.f6<a.d.a.a.h.g.j0> r13 = r13.zzf
            java.lang.Object r13 = r13.get(r10)
            a.d.a.a.h.g.j0 r13 = (a.d.a.a.h.g.j0) r13
            r17 = r15
            java.lang.String r15 = r13.zzg
            r18 = r3
            java.lang.String[] r3 = a.d.a.a.i.b.c6.f2128a
            r19 = r6
            java.lang.String[] r6 = a.d.a.a.i.b.c6.f2129b
            java.lang.String r3 = a.c.a.f.b.c1(r15, r3, r6)
            if (r3 == 0) goto L_0x0128
            a.d.a.a.h.g.y5$b r1 = r13.r()
            a.d.a.a.h.g.j0$a r1 = (a.d.a.a.h.g.j0.a) r1
            boolean r6 = r1.f2048c
            if (r6 == 0) goto L_0x0107
            r1.k()
            r6 = 0
            r1.f2048c = r6
        L_0x0107:
            MessageType r6 = r1.f2047b
            a.d.a.a.h.g.j0 r6 = (a.d.a.a.h.g.j0) r6
            a.d.a.a.h.g.j0.s(r6, r3)
            a.d.a.a.h.g.i7 r1 = r1.m()
            a.d.a.a.h.g.y5 r1 = (a.d.a.a.h.g.y5) r1
            a.d.a.a.h.g.j0 r1 = (a.d.a.a.h.g.j0) r1
            boolean r3 = r5.f2048c
            if (r3 == 0) goto L_0x0120
            r5.k()
            r3 = 0
            r5.f2048c = r3
        L_0x0120:
            MessageType r3 = r5.f2047b
            a.d.a.a.h.g.i0 r3 = (a.d.a.a.h.g.i0) r3
            a.d.a.a.h.g.i0.s(r3, r10, r1)
            r1 = 1
        L_0x0128:
            int r10 = r10 + 1
            r15 = r17
            r3 = r18
            r6 = r19
            goto L_0x00cd
        L_0x0131:
            r18 = r3
            r19 = r6
            if (r1 == 0) goto L_0x015b
            boolean r1 = r12.f2048c
            if (r1 == 0) goto L_0x0141
            r12.k()
            r1 = 0
            r12.f2048c = r1
        L_0x0141:
            MessageType r1 = r12.f2047b
            a.d.a.a.h.g.h0 r1 = (a.d.a.a.h.g.h0) r1
            a.d.a.a.h.g.i7 r3 = r5.m()
            a.d.a.a.h.g.y5 r3 = (a.d.a.a.h.g.y5) r3
            a.d.a.a.h.g.i0 r3 = (a.d.a.a.h.g.i0) r3
            a.d.a.a.h.g.h0.s(r1, r14, r3)
            a.d.a.a.h.g.i7 r1 = r12.m()
            a.d.a.a.h.g.y5 r1 = (a.d.a.a.h.g.y5) r1
            a.d.a.a.h.g.h0 r1 = (a.d.a.a.h.g.h0) r1
            r4.set(r11, r1)
        L_0x015b:
            int r14 = r14 + 1
            r1 = r20
            r3 = r18
            r6 = r19
            goto L_0x0080
        L_0x0165:
            r18 = r3
            r19 = r6
            MessageType r1 = r12.f2047b
            a.d.a.a.h.g.h0 r1 = (a.d.a.a.h.g.h0) r1
            a.d.a.a.h.g.f6<a.d.a.a.h.g.l0> r1 = r1.zze
            int r1 = r1.size()
            if (r1 == 0) goto L_0x01d9
            r1 = 0
        L_0x0176:
            MessageType r3 = r12.f2047b
            a.d.a.a.h.g.h0 r3 = (a.d.a.a.h.g.h0) r3
            a.d.a.a.h.g.f6<a.d.a.a.h.g.l0> r3 = r3.zze
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x01d9
            MessageType r3 = r12.f2047b
            a.d.a.a.h.g.h0 r3 = (a.d.a.a.h.g.h0) r3
            a.d.a.a.h.g.f6<a.d.a.a.h.g.l0> r3 = r3.zze
            java.lang.Object r3 = r3.get(r1)
            a.d.a.a.h.g.l0 r3 = (a.d.a.a.h.g.l0) r3
            java.lang.String r5 = r3.zze
            java.lang.String[] r6 = a.d.a.a.i.b.b6.f2100a
            java.lang.String[] r10 = a.d.a.a.i.b.b6.f2101b
            java.lang.String r5 = a.c.a.f.b.c1(r5, r6, r10)
            if (r5 == 0) goto L_0x01d6
            a.d.a.a.h.g.y5$b r3 = r3.r()
            a.d.a.a.h.g.l0$a r3 = (a.d.a.a.h.g.l0.a) r3
            boolean r6 = r3.f2048c
            if (r6 == 0) goto L_0x01ab
            r3.k()
            r6 = 0
            r3.f2048c = r6
            goto L_0x01ac
        L_0x01ab:
            r6 = 0
        L_0x01ac:
            MessageType r10 = r3.f2047b
            a.d.a.a.h.g.l0 r10 = (a.d.a.a.h.g.l0) r10
            a.d.a.a.h.g.l0.s(r10, r5)
            boolean r5 = r12.f2048c
            if (r5 == 0) goto L_0x01bc
            r12.k()
            r12.f2048c = r6
        L_0x01bc:
            MessageType r5 = r12.f2047b
            a.d.a.a.h.g.h0 r5 = (a.d.a.a.h.g.h0) r5
            a.d.a.a.h.g.i7 r3 = r3.m()
            a.d.a.a.h.g.y5 r3 = (a.d.a.a.h.g.y5) r3
            a.d.a.a.h.g.l0 r3 = (a.d.a.a.h.g.l0) r3
            a.d.a.a.h.g.h0.t(r5, r1, r3)
            a.d.a.a.h.g.i7 r3 = r12.m()
            a.d.a.a.h.g.y5 r3 = (a.d.a.a.h.g.y5) r3
            a.d.a.a.h.g.h0 r3 = (a.d.a.a.h.g.h0) r3
            r4.set(r11, r3)
        L_0x01d6:
            int r1 = r1 + 1
            goto L_0x0176
        L_0x01d9:
            int r11 = r11 + 1
            r1 = r20
            r3 = r18
            r6 = r19
            goto L_0x0061
        L_0x01e3:
            r18 = r3
            r19 = r6
            r0.n()
            r0.b()
            a.c.a.f.b.h(r21)
            a.c.a.f.b.k(r4)
            android.database.sqlite.SQLiteDatabase r1 = r0.t()
            r1.beginTransaction()
            r0.n()     // Catch:{ all -> 0x03d6 }
            r0.b()     // Catch:{ all -> 0x03d6 }
            a.c.a.f.b.h(r21)     // Catch:{ all -> 0x03d6 }
            android.database.sqlite.SQLiteDatabase r3 = r0.t()     // Catch:{ all -> 0x03d6 }
            r5 = 1
            java.lang.String[] r6 = new java.lang.String[r5]     // Catch:{ all -> 0x03d6 }
            r10 = 0
            r6[r10] = r2     // Catch:{ all -> 0x03d6 }
            r3.delete(r9, r8, r6)     // Catch:{ all -> 0x03d6 }
            java.lang.String[] r6 = new java.lang.String[r5]     // Catch:{ all -> 0x03d6 }
            r6[r10] = r2     // Catch:{ all -> 0x03d6 }
            r3.delete(r7, r8, r6)     // Catch:{ all -> 0x03d6 }
            java.util.Iterator r3 = r4.iterator()     // Catch:{ all -> 0x03d6 }
        L_0x021b:
            boolean r5 = r3.hasNext()     // Catch:{ all -> 0x03d6 }
            if (r5 == 0) goto L_0x030e
            java.lang.Object r5 = r3.next()     // Catch:{ all -> 0x03d6 }
            a.d.a.a.h.g.h0 r5 = (a.d.a.a.h.g.h0) r5     // Catch:{ all -> 0x03d6 }
            r0.n()     // Catch:{ all -> 0x03d6 }
            r0.b()     // Catch:{ all -> 0x03d6 }
            a.c.a.f.b.h(r21)     // Catch:{ all -> 0x03d6 }
            a.c.a.f.b.k(r5)     // Catch:{ all -> 0x03d6 }
            int r6 = r5.zzc     // Catch:{ all -> 0x03d6 }
            r8 = 1
            r6 = r6 & r8
            if (r6 == 0) goto L_0x023b
            r6 = 1
            goto L_0x023c
        L_0x023b:
            r6 = 0
        L_0x023c:
            if (r6 != 0) goto L_0x024e
            a.d.a.a.i.b.x3 r5 = r0.i()     // Catch:{ all -> 0x03d6 }
            a.d.a.a.i.b.z3 r5 = r5.i     // Catch:{ all -> 0x03d6 }
            java.lang.String r6 = "Audience with no ID. appId"
            java.lang.Object r8 = a.d.a.a.i.b.x3.s(r21)     // Catch:{ all -> 0x03d6 }
            r5.b(r6, r8)     // Catch:{ all -> 0x03d6 }
            goto L_0x021b
        L_0x024e:
            int r6 = r5.zzd     // Catch:{ all -> 0x03d6 }
            a.d.a.a.h.g.f6<a.d.a.a.h.g.i0> r8 = r5.zzf     // Catch:{ all -> 0x03d6 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x03d6 }
        L_0x0256:
            boolean r10 = r8.hasNext()     // Catch:{ all -> 0x03d6 }
            if (r10 == 0) goto L_0x0279
            java.lang.Object r10 = r8.next()     // Catch:{ all -> 0x03d6 }
            a.d.a.a.h.g.i0 r10 = (a.d.a.a.h.g.i0) r10     // Catch:{ all -> 0x03d6 }
            boolean r10 = r10.u()     // Catch:{ all -> 0x03d6 }
            if (r10 != 0) goto L_0x0256
            a.d.a.a.i.b.x3 r5 = r0.i()     // Catch:{ all -> 0x03d6 }
            a.d.a.a.i.b.z3 r5 = r5.i     // Catch:{ all -> 0x03d6 }
            java.lang.String r8 = "Event filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Object r10 = a.d.a.a.i.b.x3.s(r21)     // Catch:{ all -> 0x03d6 }
        L_0x0274:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x03d6 }
            goto L_0x029e
        L_0x0279:
            a.d.a.a.h.g.f6<a.d.a.a.h.g.l0> r8 = r5.zze     // Catch:{ all -> 0x03d6 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x03d6 }
        L_0x027f:
            boolean r10 = r8.hasNext()     // Catch:{ all -> 0x03d6 }
            if (r10 == 0) goto L_0x02a3
            java.lang.Object r10 = r8.next()     // Catch:{ all -> 0x03d6 }
            a.d.a.a.h.g.l0 r10 = (a.d.a.a.h.g.l0) r10     // Catch:{ all -> 0x03d6 }
            boolean r10 = r10.t()     // Catch:{ all -> 0x03d6 }
            if (r10 != 0) goto L_0x027f
            a.d.a.a.i.b.x3 r5 = r0.i()     // Catch:{ all -> 0x03d6 }
            a.d.a.a.i.b.z3 r5 = r5.i     // Catch:{ all -> 0x03d6 }
            java.lang.String r8 = "Property filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Object r10 = a.d.a.a.i.b.x3.s(r21)     // Catch:{ all -> 0x03d6 }
            goto L_0x0274
        L_0x029e:
            r5.c(r8, r10, r6)     // Catch:{ all -> 0x03d6 }
            goto L_0x021b
        L_0x02a3:
            a.d.a.a.h.g.f6<a.d.a.a.h.g.i0> r8 = r5.zzf     // Catch:{ all -> 0x03d6 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x03d6 }
        L_0x02a9:
            boolean r10 = r8.hasNext()     // Catch:{ all -> 0x03d6 }
            if (r10 == 0) goto L_0x02bd
            java.lang.Object r10 = r8.next()     // Catch:{ all -> 0x03d6 }
            a.d.a.a.h.g.i0 r10 = (a.d.a.a.h.g.i0) r10     // Catch:{ all -> 0x03d6 }
            boolean r10 = r0.O(r2, r6, r10)     // Catch:{ all -> 0x03d6 }
            if (r10 != 0) goto L_0x02a9
            r8 = 0
            goto L_0x02be
        L_0x02bd:
            r8 = 1
        L_0x02be:
            if (r8 == 0) goto L_0x02d9
            a.d.a.a.h.g.f6<a.d.a.a.h.g.l0> r5 = r5.zze     // Catch:{ all -> 0x03d6 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x03d6 }
        L_0x02c6:
            boolean r10 = r5.hasNext()     // Catch:{ all -> 0x03d6 }
            if (r10 == 0) goto L_0x02d9
            java.lang.Object r10 = r5.next()     // Catch:{ all -> 0x03d6 }
            a.d.a.a.h.g.l0 r10 = (a.d.a.a.h.g.l0) r10     // Catch:{ all -> 0x03d6 }
            boolean r10 = r0.P(r2, r6, r10)     // Catch:{ all -> 0x03d6 }
            if (r10 != 0) goto L_0x02c6
            r8 = 0
        L_0x02d9:
            if (r8 != 0) goto L_0x0308
            r0.n()     // Catch:{ all -> 0x03d6 }
            r0.b()     // Catch:{ all -> 0x03d6 }
            a.c.a.f.b.h(r21)     // Catch:{ all -> 0x03d6 }
            android.database.sqlite.SQLiteDatabase r5 = r0.t()     // Catch:{ all -> 0x03d6 }
            r8 = 2
            java.lang.String[] r10 = new java.lang.String[r8]     // Catch:{ all -> 0x03d6 }
            r11 = 0
            r10[r11] = r2     // Catch:{ all -> 0x03d6 }
            java.lang.String r12 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x03d6 }
            r13 = 1
            r10[r13] = r12     // Catch:{ all -> 0x03d6 }
            r12 = r19
            r5.delete(r9, r12, r10)     // Catch:{ all -> 0x03d6 }
            java.lang.String[] r8 = new java.lang.String[r8]     // Catch:{ all -> 0x03d6 }
            r8[r11] = r2     // Catch:{ all -> 0x03d6 }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x03d6 }
            r8[r13] = r6     // Catch:{ all -> 0x03d6 }
            r5.delete(r7, r12, r8)     // Catch:{ all -> 0x03d6 }
            goto L_0x030a
        L_0x0308:
            r12 = r19
        L_0x030a:
            r19 = r12
            goto L_0x021b
        L_0x030e:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x03d6 }
            r3.<init>()     // Catch:{ all -> 0x03d6 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x03d6 }
        L_0x0317:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x03d6 }
            if (r5 == 0) goto L_0x033a
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x03d6 }
            a.d.a.a.h.g.h0 r5 = (a.d.a.a.h.g.h0) r5     // Catch:{ all -> 0x03d6 }
            int r6 = r5.zzc     // Catch:{ all -> 0x03d6 }
            r7 = 1
            r6 = r6 & r7
            if (r6 == 0) goto L_0x032b
            r6 = 1
            goto L_0x032c
        L_0x032b:
            r6 = 0
        L_0x032c:
            if (r6 == 0) goto L_0x0335
            int r5 = r5.zzd     // Catch:{ all -> 0x03d6 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x03d6 }
            goto L_0x0336
        L_0x0335:
            r5 = 0
        L_0x0336:
            r3.add(r5)     // Catch:{ all -> 0x03d6 }
            goto L_0x0317
        L_0x033a:
            r0.W(r2, r3)     // Catch:{ all -> 0x03d6 }
            r1.setTransactionSuccessful()     // Catch:{ all -> 0x03d6 }
            r1.endTransaction()
            r1 = r18
            boolean r0 = r1.f2048c     // Catch:{ RuntimeException -> 0x0363 }
            if (r0 == 0) goto L_0x034f
            r1.k()     // Catch:{ RuntimeException -> 0x0363 }
            r3 = 0
            r1.f2048c = r3     // Catch:{ RuntimeException -> 0x0363 }
        L_0x034f:
            MessageType r0 = r1.f2047b     // Catch:{ RuntimeException -> 0x0363 }
            a.d.a.a.h.g.r0 r0 = (a.d.a.a.h.g.r0) r0     // Catch:{ RuntimeException -> 0x0363 }
            a.d.a.a.h.g.r0.s(r0)     // Catch:{ RuntimeException -> 0x0363 }
            a.d.a.a.h.g.i7 r0 = r1.m()     // Catch:{ RuntimeException -> 0x0363 }
            a.d.a.a.h.g.y5 r0 = (a.d.a.a.h.g.y5) r0     // Catch:{ RuntimeException -> 0x0363 }
            a.d.a.a.h.g.r0 r0 = (a.d.a.a.h.g.r0) r0     // Catch:{ RuntimeException -> 0x0363 }
            byte[] r0 = r0.j()     // Catch:{ RuntimeException -> 0x0363 }
            goto L_0x0375
        L_0x0363:
            r0 = move-exception
            a.d.a.a.i.b.x3 r3 = r20.i()
            a.d.a.a.i.b.z3 r3 = r3.i
            java.lang.Object r4 = a.d.a.a.i.b.x3.s(r21)
            java.lang.String r5 = "Unable to serialize reduced-size config. Storing full config instead. appId"
            r3.c(r5, r4, r0)
            r0 = r22
        L_0x0375:
            a.d.a.a.i.b.d r3 = r20.q()
            a.c.a.f.b.h(r21)
            r3.b()
            r3.n()
            android.content.ContentValues r4 = new android.content.ContentValues
            r4.<init>()
            java.lang.String r5 = "remote_config"
            r4.put(r5, r0)
            android.database.sqlite.SQLiteDatabase r0 = r3.t()     // Catch:{ SQLiteException -> 0x03b5 }
            java.lang.String r5 = "apps"
            java.lang.String r6 = "app_id = ?"
            r7 = 1
            java.lang.String[] r8 = new java.lang.String[r7]     // Catch:{ SQLiteException -> 0x03b5 }
            r7 = 0
            r8[r7] = r2     // Catch:{ SQLiteException -> 0x03b5 }
            int r0 = r0.update(r5, r4, r6, r8)     // Catch:{ SQLiteException -> 0x03b5 }
            long r4 = (long) r0     // Catch:{ SQLiteException -> 0x03b5 }
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x03c5
            a.d.a.a.i.b.x3 r0 = r3.i()     // Catch:{ SQLiteException -> 0x03b5 }
            a.d.a.a.i.b.z3 r0 = r0.f     // Catch:{ SQLiteException -> 0x03b5 }
            java.lang.String r4 = "Failed to update remote config (got 0). appId"
            java.lang.Object r5 = a.d.a.a.i.b.x3.s(r21)     // Catch:{ SQLiteException -> 0x03b5 }
            r0.b(r4, r5)     // Catch:{ SQLiteException -> 0x03b5 }
            goto L_0x03c5
        L_0x03b5:
            r0 = move-exception
            a.d.a.a.i.b.x3 r3 = r3.i()
            a.d.a.a.i.b.z3 r3 = r3.f
            java.lang.Object r4 = a.d.a.a.i.b.x3.s(r21)
            java.lang.String r5 = "Error storing remote config. appId"
            r3.c(r5, r4, r0)
        L_0x03c5:
            r3 = r20
            java.util.Map<java.lang.String, a.d.a.a.h.g.r0> r0 = r3.g
            a.d.a.a.h.g.i7 r1 = r1.m()
            a.d.a.a.h.g.y5 r1 = (a.d.a.a.h.g.y5) r1
            a.d.a.a.h.g.r0 r1 = (a.d.a.a.h.g.r0) r1
            r0.put(r2, r1)
            r1 = 1
            return r1
        L_0x03d6:
            r0 = move-exception
            r3 = r20
            r1.endTransaction()
            throw r0
        L_0x03dd:
            r3 = r1
            r0 = 0
            goto L_0x03e1
        L_0x03e0:
            throw r0
        L_0x03e1:
            goto L_0x03e0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.w4.w(java.lang.String, byte[], java.lang.String):boolean");
    }

    @WorkerThread
    public final boolean x(String str, String str2) {
        Boolean bool;
        b();
        E(str);
        if ("1".equals(h(str, "measurement.upload.blacklist_internal")) && v9.s0(str2)) {
            return true;
        }
        if ("1".equals(h(str, "measurement.upload.blacklist_public")) && v9.V(str2)) {
            return true;
        }
        Map map = this.f2589e.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @WorkerThread
    public final boolean y(String str, String str2) {
        Boolean bool;
        b();
        E(str);
        if ("ecommerce_purchase".equals(str2)) {
            return true;
        }
        if (aa.b() && this.f2563a.g.o(q.D0) && ("purchase".equals(str2) || "refund".equals(str2))) {
            return true;
        }
        Map map = this.f.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @WorkerThread
    public final int z(String str, String str2) {
        Integer num;
        b();
        E(str);
        Map map = this.h.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }
}
