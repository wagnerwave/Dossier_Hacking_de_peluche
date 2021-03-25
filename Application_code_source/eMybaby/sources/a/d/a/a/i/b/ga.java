package a.d.a.a.i.b;

import a.d.a.a.h.g.x0;

public final class ga {

    /* renamed from: a  reason: collision with root package name */
    public x0 f2229a;

    /* renamed from: b  reason: collision with root package name */
    public Long f2230b;

    /* renamed from: c  reason: collision with root package name */
    public long f2231c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ba f2232d;

    public ga(ba baVar, ea eaVar) {
        this.f2232d = baVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: a.d.a.a.h.g.f6<a.d.a.a.h.g.z0>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: a.d.a.a.h.g.f6<a.d.a.a.h.g.z0>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: a.d.a.a.h.g.f6<a.d.a.a.h.g.z0>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: a.d.a.a.h.g.f6<a.d.a.a.h.g.z0>} */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ef, code lost:
        if (r14 != null) goto L_0x00d8;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final a.d.a.a.h.g.x0 a(java.lang.String r19, a.d.a.a.h.g.x0 r20) {
        /*
            r18 = this;
            r1 = r18
            r3 = r19
            r8 = r20
            java.lang.String r0 = r8.zze
            a.d.a.a.h.g.f6<a.d.a.a.h.g.z0> r9 = r8.zzd
            a.d.a.a.i.b.ba r2 = r1.f2232d
            a.d.a.a.i.b.s9 r2 = r2.l()
            java.lang.String r4 = "_eid"
            java.lang.Object r2 = r2.R(r8, r4)
            r5 = r2
            java.lang.Long r5 = (java.lang.Long) r5
            r2 = 1
            r10 = 0
            if (r5 == 0) goto L_0x001f
            r6 = 1
            goto L_0x0020
        L_0x001f:
            r6 = 0
        L_0x0020:
            if (r6 == 0) goto L_0x002c
            java.lang.String r7 = "_ep"
            boolean r7 = r0.equals(r7)
            if (r7 == 0) goto L_0x002c
            r7 = 1
            goto L_0x002d
        L_0x002c:
            r7 = 0
        L_0x002d:
            r11 = 0
            if (r7 == 0) goto L_0x01c1
            a.d.a.a.i.b.ba r0 = r1.f2232d
            a.d.a.a.i.b.s9 r0 = r0.l()
            java.lang.String r6 = "_en"
            java.lang.Object r0 = r0.R(r8, r6)
            r13 = r0
            java.lang.String r13 = (java.lang.String) r13
            boolean r0 = android.text.TextUtils.isEmpty(r13)
            r6 = 0
            if (r0 == 0) goto L_0x0055
            a.d.a.a.i.b.ba r0 = r1.f2232d
            a.d.a.a.i.b.x3 r0 = r0.i()
            a.d.a.a.i.b.z3 r0 = r0.g
            java.lang.String r2 = "Extra parameter without an event name. eventId"
            r0.b(r2, r5)
            return r6
        L_0x0055:
            a.d.a.a.h.g.x0 r0 = r1.f2229a
            if (r0 == 0) goto L_0x006b
            java.lang.Long r0 = r1.f2230b
            if (r0 == 0) goto L_0x006b
            long r14 = r5.longValue()
            java.lang.Long r0 = r1.f2230b
            long r16 = r0.longValue()
            int r0 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x0119
        L_0x006b:
            a.d.a.a.i.b.ba r0 = r1.f2232d
            a.d.a.a.i.b.d r7 = r0.q()
            r7.b()
            r7.n()
            android.database.sqlite.SQLiteDatabase r0 = r7.t()     // Catch:{ SQLiteException -> 0x00e2, all -> 0x00de }
            java.lang.String r14 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r15 = 2
            java.lang.String[] r15 = new java.lang.String[r15]     // Catch:{ SQLiteException -> 0x00e2, all -> 0x00de }
            r15[r10] = r3     // Catch:{ SQLiteException -> 0x00e2, all -> 0x00de }
            java.lang.String r16 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x00e2, all -> 0x00de }
            r15[r2] = r16     // Catch:{ SQLiteException -> 0x00e2, all -> 0x00de }
            android.database.Cursor r14 = r0.rawQuery(r14, r15)     // Catch:{ SQLiteException -> 0x00e2, all -> 0x00de }
            boolean r0 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x00dc }
            if (r0 != 0) goto L_0x00a2
            a.d.a.a.i.b.x3 r0 = r7.i()     // Catch:{ SQLiteException -> 0x00dc }
            a.d.a.a.i.b.z3 r0 = r0.n     // Catch:{ SQLiteException -> 0x00dc }
            java.lang.String r15 = "Main event not found"
            r0.a(r15)     // Catch:{ SQLiteException -> 0x00dc }
            r14.close()
            r0 = r6
            goto L_0x00f3
        L_0x00a2:
            byte[] r0 = r14.getBlob(r10)     // Catch:{ SQLiteException -> 0x00dc }
            long r15 = r14.getLong(r2)     // Catch:{ SQLiteException -> 0x00dc }
            java.lang.Long r15 = java.lang.Long.valueOf(r15)     // Catch:{ SQLiteException -> 0x00dc }
            a.d.a.a.h.g.x0$a r6 = a.d.a.a.h.g.x0.C()     // Catch:{ IOException -> 0x00c8 }
            a.d.a.a.h.g.h7 r0 = a.d.a.a.i.b.s9.x(r6, r0)     // Catch:{ IOException -> 0x00c8 }
            a.d.a.a.h.g.x0$a r0 = (a.d.a.a.h.g.x0.a) r0     // Catch:{ IOException -> 0x00c8 }
            a.d.a.a.h.g.i7 r0 = r0.m()     // Catch:{ IOException -> 0x00c8 }
            a.d.a.a.h.g.y5 r0 = (a.d.a.a.h.g.y5) r0     // Catch:{ IOException -> 0x00c8 }
            a.d.a.a.h.g.x0 r0 = (a.d.a.a.h.g.x0) r0     // Catch:{ IOException -> 0x00c8 }
            android.util.Pair r0 = android.util.Pair.create(r0, r15)     // Catch:{ SQLiteException -> 0x00dc }
            r14.close()
            goto L_0x00f3
        L_0x00c8:
            r0 = move-exception
            a.d.a.a.i.b.x3 r6 = r7.i()     // Catch:{ SQLiteException -> 0x00dc }
            a.d.a.a.i.b.z3 r6 = r6.f     // Catch:{ SQLiteException -> 0x00dc }
            java.lang.String r15 = "Failed to merge main event. appId, eventId"
            java.lang.Object r10 = a.d.a.a.i.b.x3.s(r19)     // Catch:{ SQLiteException -> 0x00dc }
            r6.d(r15, r10, r5, r0)     // Catch:{ SQLiteException -> 0x00dc }
        L_0x00d8:
            r14.close()
            goto L_0x00f2
        L_0x00dc:
            r0 = move-exception
            goto L_0x00e4
        L_0x00de:
            r0 = move-exception
            r6 = 0
            goto L_0x01bb
        L_0x00e2:
            r0 = move-exception
            r14 = 0
        L_0x00e4:
            a.d.a.a.i.b.x3 r6 = r7.i()     // Catch:{ all -> 0x01b9 }
            a.d.a.a.i.b.z3 r6 = r6.f     // Catch:{ all -> 0x01b9 }
            java.lang.String r7 = "Error selecting main event"
            r6.b(r7, r0)     // Catch:{ all -> 0x01b9 }
            if (r14 == 0) goto L_0x00f2
            goto L_0x00d8
        L_0x00f2:
            r0 = 0
        L_0x00f3:
            if (r0 == 0) goto L_0x01aa
            java.lang.Object r6 = r0.first
            if (r6 != 0) goto L_0x00fb
            goto L_0x01aa
        L_0x00fb:
            a.d.a.a.h.g.x0 r6 = (a.d.a.a.h.g.x0) r6
            r1.f2229a = r6
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r6 = r0.longValue()
            r1.f2231c = r6
            a.d.a.a.i.b.ba r0 = r1.f2232d
            a.d.a.a.i.b.s9 r0 = r0.l()
            a.d.a.a.h.g.x0 r6 = r1.f2229a
            java.lang.Object r0 = r0.R(r6, r4)
            java.lang.Long r0 = (java.lang.Long) r0
            r1.f2230b = r0
        L_0x0119:
            long r6 = r1.f2231c
            r14 = 1
            long r6 = r6 - r14
            r1.f2231c = r6
            int r0 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r0 > 0) goto L_0x0154
            a.d.a.a.i.b.ba r0 = r1.f2232d
            a.d.a.a.i.b.d r4 = r0.q()
            r4.b()
            a.d.a.a.i.b.x3 r0 = r4.i()
            a.d.a.a.i.b.z3 r0 = r0.n
            java.lang.String r5 = "Clearing complex main event info. appId"
            r0.b(r5, r3)
            android.database.sqlite.SQLiteDatabase r0 = r4.t()     // Catch:{ SQLiteException -> 0x0147 }
            java.lang.String r5 = "delete from main_event_params where app_id=?"
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0147 }
            r6 = 0
            r2[r6] = r3     // Catch:{ SQLiteException -> 0x0147 }
            r0.execSQL(r5, r2)     // Catch:{ SQLiteException -> 0x0147 }
            goto L_0x0166
        L_0x0147:
            r0 = move-exception
            a.d.a.a.i.b.x3 r2 = r4.i()
            a.d.a.a.i.b.z3 r2 = r2.f
            java.lang.String r3 = "Error clearing complex main event"
            r2.b(r3, r0)
            goto L_0x0166
        L_0x0154:
            a.d.a.a.i.b.ba r0 = r1.f2232d
            a.d.a.a.i.b.d r2 = r0.q()
            long r6 = r1.f2231c
            a.d.a.a.h.g.x0 r0 = r1.f2229a
            r3 = r19
            r4 = r5
            r5 = r6
            r7 = r0
            r2.Q(r3, r4, r5, r7)
        L_0x0166:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            a.d.a.a.h.g.x0 r2 = r1.f2229a
            a.d.a.a.h.g.f6<a.d.a.a.h.g.z0> r2 = r2.zzd
            java.util.Iterator r2 = r2.iterator()
        L_0x0173:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0190
            java.lang.Object r3 = r2.next()
            a.d.a.a.h.g.z0 r3 = (a.d.a.a.h.g.z0) r3
            a.d.a.a.i.b.ba r4 = r1.f2232d
            r4.l()
            java.lang.String r4 = r3.zzd
            a.d.a.a.h.g.z0 r4 = a.d.a.a.i.b.s9.w(r8, r4)
            if (r4 != 0) goto L_0x0173
            r0.add(r3)
            goto L_0x0173
        L_0x0190:
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x019b
            r0.addAll(r9)
            r9 = r0
            goto L_0x01a8
        L_0x019b:
            a.d.a.a.i.b.ba r0 = r1.f2232d
            a.d.a.a.i.b.x3 r0 = r0.i()
            a.d.a.a.i.b.z3 r0 = r0.g
            java.lang.String r2 = "No unique parameters in main event. eventName"
            r0.b(r2, r13)
        L_0x01a8:
            r0 = r13
            goto L_0x0206
        L_0x01aa:
            a.d.a.a.i.b.ba r0 = r1.f2232d
            a.d.a.a.i.b.x3 r0 = r0.i()
            a.d.a.a.i.b.z3 r0 = r0.g
            java.lang.String r2 = "Extra parameter without existing main event. eventName, eventId"
            r0.c(r2, r13, r5)
            r2 = 0
            return r2
        L_0x01b9:
            r0 = move-exception
            r6 = r14
        L_0x01bb:
            if (r6 == 0) goto L_0x01c0
            r6.close()
        L_0x01c0:
            throw r0
        L_0x01c1:
            if (r6 == 0) goto L_0x0206
            r1.f2230b = r5
            r1.f2229a = r8
            a.d.a.a.i.b.ba r2 = r1.f2232d
            a.d.a.a.i.b.s9 r2 = r2.l()
            java.lang.Long r4 = java.lang.Long.valueOf(r11)
            java.lang.String r6 = "_epc"
            java.lang.Object r2 = r2.R(r8, r6)
            if (r2 != 0) goto L_0x01da
            goto L_0x01db
        L_0x01da:
            r4 = r2
        L_0x01db:
            java.lang.Long r4 = (java.lang.Long) r4
            long r6 = r4.longValue()
            r1.f2231c = r6
            int r2 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r2 > 0) goto L_0x01f5
            a.d.a.a.i.b.ba r2 = r1.f2232d
            a.d.a.a.i.b.x3 r2 = r2.i()
            a.d.a.a.i.b.z3 r2 = r2.g
            java.lang.String r3 = "Complex event with zero extra param count. eventName"
            r2.b(r3, r0)
            goto L_0x0206
        L_0x01f5:
            a.d.a.a.i.b.ba r2 = r1.f2232d
            a.d.a.a.i.b.d r2 = r2.q()
            long r6 = r1.f2231c
            r3 = r19
            r4 = r5
            r5 = r6
            r7 = r20
            r2.Q(r3, r4, r5, r7)
        L_0x0206:
            a.d.a.a.h.g.y5$b r2 = r20.r()
            a.d.a.a.h.g.x0$a r2 = (a.d.a.a.h.g.x0.a) r2
            r2.q(r0)
            boolean r0 = r2.f2048c
            if (r0 == 0) goto L_0x0219
            r2.k()
            r3 = 0
            r2.f2048c = r3
        L_0x0219:
            MessageType r0 = r2.f2047b
            a.d.a.a.h.g.x0 r0 = (a.d.a.a.h.g.x0) r0
            a.d.a.a.h.g.x0.t(r0)
            boolean r0 = r2.f2048c
            if (r0 == 0) goto L_0x022a
            r2.k()
            r3 = 0
            r2.f2048c = r3
        L_0x022a:
            MessageType r0 = r2.f2047b
            a.d.a.a.h.g.x0 r0 = (a.d.a.a.h.g.x0) r0
            a.d.a.a.h.g.x0.x(r0, r9)
            a.d.a.a.h.g.i7 r0 = r2.m()
            a.d.a.a.h.g.y5 r0 = (a.d.a.a.h.g.y5) r0
            a.d.a.a.h.g.x0 r0 = (a.d.a.a.h.g.x0) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.ga.a(java.lang.String, a.d.a.a.h.g.x0):a.d.a.a.h.g.x0");
    }
}
