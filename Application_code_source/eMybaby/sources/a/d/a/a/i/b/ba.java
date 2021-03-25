package a.d.a.a.i.b;

import java.util.Map;
import java.util.Set;

public final class ba extends m9 {

    /* renamed from: d  reason: collision with root package name */
    public String f2112d;

    /* renamed from: e  reason: collision with root package name */
    public Set<Integer> f2113e;
    public Map<Integer, da> f;
    public Long g;
    public Long h;

    public ba(o9 o9Var) {
        super(o9Var);
    }

    public final boolean p() {
        return false;
    }

    public final da s(int i) {
        if (this.f.containsKey(Integer.valueOf(i))) {
            return this.f.get(Integer.valueOf(i));
        }
        da daVar = new da(this, this.f2112d, (ea) null);
        this.f.put(Integer.valueOf(i), daVar);
        return daVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v23, resolved type: androidx.collection.ArrayMap} */
    /* JADX WARNING: type inference failed for: r0v114, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r0v132, types: [java.util.Map] */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0255, code lost:
        if (r4 != null) goto L_0x0257;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0305, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0306, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0331, code lost:
        if (r5 != null) goto L_0x0333;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0400, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:334:0x087b, code lost:
        if (r8.t() == false) goto L_0x0886;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:335:0x087d, code lost:
        r8 = java.lang.Integer.valueOf(r8.u());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:336:0x0886, code lost:
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:337:0x0887, code lost:
        r7.c("Invalid property filter ID. appId, id", r9, java.lang.String.valueOf(r8));
        r8 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0174, code lost:
        if (r5 != null) goto L_0x0176;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0251 A[Catch:{ all -> 0x0943 }] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x028c  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0305 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:123:0x02b8] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x032d A[Catch:{ all -> 0x03fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0337  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x034b  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0400  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0406  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0411  */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x050b  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x05c6  */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x074f  */
    /* JADX WARNING: Removed duplicated region for block: B:343:0x08b8  */
    /* JADX WARNING: Removed duplicated region for block: B:363:0x0947  */
    /* JADX WARNING: Removed duplicated region for block: B:396:0x0512 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01bb A[Catch:{ SQLiteException -> 0x0228 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01d9 A[SYNTHETIC, Splitter:B:80:0x01d9] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<a.d.a.a.h.g.v0> t(java.lang.String r62, java.util.List<a.d.a.a.h.g.x0> r63, java.util.List<a.d.a.a.h.g.f1> r64, java.lang.Long r65, java.lang.Long r66) {
        /*
            r61 = this;
            r10 = r61
            java.lang.String r11 = "current_results"
            a.c.a.f.b.h(r62)
            a.c.a.f.b.k(r63)
            a.c.a.f.b.k(r64)
            r0 = r62
            r10.f2112d = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r10.f2113e = r0
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            r10.f = r0
            r0 = r65
            r10.g = r0
            r0 = r66
            r10.h = r0
            java.util.Iterator r0 = r63.iterator()
        L_0x002b:
            boolean r1 = r0.hasNext()
            r12 = 0
            r13 = 1
            if (r1 == 0) goto L_0x0045
            java.lang.Object r1 = r0.next()
            a.d.a.a.h.g.x0 r1 = (a.d.a.a.h.g.x0) r1
            java.lang.String r1 = r1.zze
            java.lang.String r2 = "_s"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x002b
            r1 = 1
            goto L_0x0046
        L_0x0045:
            r1 = 0
        L_0x0046:
            boolean r0 = a.d.a.a.h.g.la.b()
            if (r0 == 0) goto L_0x005c
            a.d.a.a.i.b.c5 r0 = r10.f2563a
            a.d.a.a.i.b.ka r0 = r0.g
            java.lang.String r2 = r10.f2112d
            a.d.a.a.i.b.n3<java.lang.Boolean> r3 = a.d.a.a.i.b.q.d0
            boolean r0 = r0.t(r2, r3)
            if (r0 == 0) goto L_0x005c
            r14 = 1
            goto L_0x005d
        L_0x005c:
            r14 = 0
        L_0x005d:
            boolean r0 = a.d.a.a.h.g.la.b()
            if (r0 == 0) goto L_0x0073
            a.d.a.a.i.b.c5 r0 = r10.f2563a
            a.d.a.a.i.b.ka r0 = r0.g
            java.lang.String r2 = r10.f2112d
            a.d.a.a.i.b.n3<java.lang.Boolean> r3 = a.d.a.a.i.b.q.c0
            boolean r0 = r0.t(r2, r3)
            if (r0 == 0) goto L_0x0073
            r15 = 1
            goto L_0x0074
        L_0x0073:
            r15 = 0
        L_0x0074:
            if (r1 == 0) goto L_0x00b3
            a.d.a.a.i.b.d r2 = r61.q()
            java.lang.String r3 = r10.f2112d
            r2.n()
            r2.b()
            a.c.a.f.b.h(r3)
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r12)
            java.lang.String r5 = "current_session_count"
            r0.put(r5, r4)
            android.database.sqlite.SQLiteDatabase r4 = r2.t()     // Catch:{ SQLiteException -> 0x00a3 }
            java.lang.String r5 = "events"
            java.lang.String r6 = "app_id = ?"
            java.lang.String[] r7 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x00a3 }
            r7[r12] = r3     // Catch:{ SQLiteException -> 0x00a3 }
            r4.update(r5, r0, r6, r7)     // Catch:{ SQLiteException -> 0x00a3 }
            goto L_0x00b3
        L_0x00a3:
            r0 = move-exception
            a.d.a.a.i.b.x3 r2 = r2.i()
            a.d.a.a.i.b.z3 r2 = r2.f
            java.lang.Object r3 = a.d.a.a.i.b.x3.s(r3)
            java.lang.String r4 = "Error resetting session-scoped event counts. appId"
            r2.c(r4, r3, r0)
        L_0x00b3:
            java.util.Map r0 = java.util.Collections.emptyMap()
            java.lang.String r9 = "audience_id"
            r8 = 2
            r7 = 0
            if (r15 == 0) goto L_0x0183
            if (r14 == 0) goto L_0x0183
            a.d.a.a.i.b.d r2 = r61.q()
            java.lang.String r3 = r10.f2112d
            if (r2 == 0) goto L_0x0182
            a.c.a.f.b.h(r3)
            androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap
            r4.<init>()
            android.database.sqlite.SQLiteDatabase r16 = r2.t()
            java.lang.String r17 = "event_filters"
            java.lang.String[] r0 = new java.lang.String[r8]     // Catch:{ SQLiteException -> 0x015f, all -> 0x015d }
            r0[r12] = r9     // Catch:{ SQLiteException -> 0x015f, all -> 0x015d }
            java.lang.String r5 = "data"
            r0[r13] = r5     // Catch:{ SQLiteException -> 0x015f, all -> 0x015d }
            java.lang.String r19 = "app_id=?"
            java.lang.String[] r5 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x015f, all -> 0x015d }
            r5[r12] = r3     // Catch:{ SQLiteException -> 0x015f, all -> 0x015d }
            r21 = 0
            r22 = 0
            r23 = 0
            r18 = r0
            r20 = r5
            android.database.Cursor r5 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x015f, all -> 0x015d }
            boolean r0 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x015b }
            if (r0 != 0) goto L_0x00fd
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x015b }
            goto L_0x0176
        L_0x00fd:
            byte[] r0 = r5.getBlob(r13)     // Catch:{ SQLiteException -> 0x015b }
            a.d.a.a.h.g.i0 r6 = a.d.a.a.h.g.i0.zzl     // Catch:{ IOException -> 0x013d }
            a.d.a.a.h.g.y5$b r6 = r6.q()     // Catch:{ IOException -> 0x013d }
            a.d.a.a.h.g.i0$a r6 = (a.d.a.a.h.g.i0.a) r6     // Catch:{ IOException -> 0x013d }
            a.d.a.a.h.g.h7 r0 = a.d.a.a.i.b.s9.x(r6, r0)     // Catch:{ IOException -> 0x013d }
            a.d.a.a.h.g.i0$a r0 = (a.d.a.a.h.g.i0.a) r0     // Catch:{ IOException -> 0x013d }
            a.d.a.a.h.g.i7 r0 = r0.m()     // Catch:{ IOException -> 0x013d }
            a.d.a.a.h.g.y5 r0 = (a.d.a.a.h.g.y5) r0     // Catch:{ IOException -> 0x013d }
            a.d.a.a.h.g.i0 r0 = (a.d.a.a.h.g.i0) r0     // Catch:{ IOException -> 0x013d }
            boolean r6 = r0.w()     // Catch:{ SQLiteException -> 0x015b }
            if (r6 == 0) goto L_0x014d
            int r6 = r5.getInt(r12)     // Catch:{ SQLiteException -> 0x015b }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r6)     // Catch:{ SQLiteException -> 0x015b }
            java.lang.Object r13 = r4.get(r13)     // Catch:{ SQLiteException -> 0x015b }
            java.util.List r13 = (java.util.List) r13     // Catch:{ SQLiteException -> 0x015b }
            if (r13 != 0) goto L_0x0139
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x015b }
            r13.<init>()     // Catch:{ SQLiteException -> 0x015b }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ SQLiteException -> 0x015b }
            r4.put(r6, r13)     // Catch:{ SQLiteException -> 0x015b }
        L_0x0139:
            r13.add(r0)     // Catch:{ SQLiteException -> 0x015b }
            goto L_0x014d
        L_0x013d:
            r0 = move-exception
            a.d.a.a.i.b.x3 r6 = r2.i()     // Catch:{ SQLiteException -> 0x015b }
            a.d.a.a.i.b.z3 r6 = r6.f     // Catch:{ SQLiteException -> 0x015b }
            java.lang.String r13 = "Failed to merge filter. appId"
            java.lang.Object r12 = a.d.a.a.i.b.x3.s(r3)     // Catch:{ SQLiteException -> 0x015b }
            r6.c(r13, r12, r0)     // Catch:{ SQLiteException -> 0x015b }
        L_0x014d:
            boolean r0 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x015b }
            if (r0 != 0) goto L_0x0158
            r5.close()
            r12 = r4
            goto L_0x0184
        L_0x0158:
            r12 = 0
            r13 = 1
            goto L_0x00fd
        L_0x015b:
            r0 = move-exception
            goto L_0x0161
        L_0x015d:
            r0 = move-exception
            goto L_0x017c
        L_0x015f:
            r0 = move-exception
            r5 = r7
        L_0x0161:
            a.d.a.a.i.b.x3 r2 = r2.i()     // Catch:{ all -> 0x017a }
            a.d.a.a.i.b.z3 r2 = r2.f     // Catch:{ all -> 0x017a }
            java.lang.String r4 = "Database error querying filters. appId"
            java.lang.Object r3 = a.d.a.a.i.b.x3.s(r3)     // Catch:{ all -> 0x017a }
            r2.c(r4, r3, r0)     // Catch:{ all -> 0x017a }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x017a }
            if (r5 == 0) goto L_0x0183
        L_0x0176:
            r5.close()
            goto L_0x0183
        L_0x017a:
            r0 = move-exception
            r7 = r5
        L_0x017c:
            if (r7 == 0) goto L_0x0181
            r7.close()
        L_0x0181:
            throw r0
        L_0x0182:
            throw r7
        L_0x0183:
            r12 = r0
        L_0x0184:
            a.d.a.a.i.b.d r2 = r61.q()
            java.lang.String r3 = r10.f2112d
            r2.n()
            r2.b()
            a.c.a.f.b.h(r3)
            android.database.sqlite.SQLiteDatabase r16 = r2.t()
            java.lang.String r17 = "audience_filter_values"
            java.lang.String[] r0 = new java.lang.String[r8]     // Catch:{ SQLiteException -> 0x022e, all -> 0x022a }
            r4 = 0
            r0[r4] = r9     // Catch:{ SQLiteException -> 0x022e, all -> 0x022a }
            r5 = 1
            r0[r5] = r11     // Catch:{ SQLiteException -> 0x022e, all -> 0x022a }
            java.lang.String r19 = "app_id=?"
            java.lang.String[] r6 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x022e, all -> 0x022a }
            r6[r4] = r3     // Catch:{ SQLiteException -> 0x022e, all -> 0x022a }
            r21 = 0
            r22 = 0
            r23 = 0
            r18 = r0
            r20 = r6
            android.database.Cursor r4 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x022e, all -> 0x022a }
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0228 }
            if (r0 != 0) goto L_0x01d9
            boolean r0 = a.d.a.a.h.g.ra.b()     // Catch:{ SQLiteException -> 0x0228 }
            if (r0 == 0) goto L_0x01d3
            a.d.a.a.i.b.c5 r0 = r2.f2563a     // Catch:{ SQLiteException -> 0x0228 }
            a.d.a.a.i.b.ka r0 = r0.g     // Catch:{ SQLiteException -> 0x0228 }
            a.d.a.a.i.b.n3<java.lang.Boolean> r5 = a.d.a.a.i.b.q.N0     // Catch:{ SQLiteException -> 0x0228 }
            boolean r0 = r0.t(r3, r5)     // Catch:{ SQLiteException -> 0x0228 }
            if (r0 == 0) goto L_0x01d3
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0228 }
            goto L_0x0257
        L_0x01d3:
            r4.close()
            r13 = r7
            goto L_0x0263
        L_0x01d9:
            androidx.collection.ArrayMap r5 = new androidx.collection.ArrayMap     // Catch:{ SQLiteException -> 0x0228 }
            r5.<init>()     // Catch:{ SQLiteException -> 0x0228 }
            r6 = 0
        L_0x01df:
            int r13 = r4.getInt(r6)     // Catch:{ SQLiteException -> 0x0228 }
            r6 = 1
            byte[] r0 = r4.getBlob(r6)     // Catch:{ SQLiteException -> 0x0228 }
            a.d.a.a.h.g.d1 r6 = a.d.a.a.h.g.d1.zzg     // Catch:{ IOException -> 0x0206 }
            a.d.a.a.h.g.y5$b r6 = r6.q()     // Catch:{ IOException -> 0x0206 }
            a.d.a.a.h.g.d1$a r6 = (a.d.a.a.h.g.d1.a) r6     // Catch:{ IOException -> 0x0206 }
            a.d.a.a.h.g.h7 r0 = a.d.a.a.i.b.s9.x(r6, r0)     // Catch:{ IOException -> 0x0206 }
            a.d.a.a.h.g.d1$a r0 = (a.d.a.a.h.g.d1.a) r0     // Catch:{ IOException -> 0x0206 }
            a.d.a.a.h.g.i7 r0 = r0.m()     // Catch:{ IOException -> 0x0206 }
            a.d.a.a.h.g.y5 r0 = (a.d.a.a.h.g.y5) r0     // Catch:{ IOException -> 0x0206 }
            a.d.a.a.h.g.d1 r0 = (a.d.a.a.h.g.d1) r0     // Catch:{ IOException -> 0x0206 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r13)     // Catch:{ SQLiteException -> 0x0228 }
            r5.put(r6, r0)     // Catch:{ SQLiteException -> 0x0228 }
            goto L_0x021a
        L_0x0206:
            r0 = move-exception
            a.d.a.a.i.b.x3 r6 = r2.i()     // Catch:{ SQLiteException -> 0x0228 }
            a.d.a.a.i.b.z3 r6 = r6.f     // Catch:{ SQLiteException -> 0x0228 }
            java.lang.String r7 = "Failed to merge filter results. appId, audienceId, error"
            java.lang.Object r8 = a.d.a.a.i.b.x3.s(r3)     // Catch:{ SQLiteException -> 0x0228 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ SQLiteException -> 0x0228 }
            r6.d(r7, r8, r13, r0)     // Catch:{ SQLiteException -> 0x0228 }
        L_0x021a:
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x0228 }
            if (r0 != 0) goto L_0x0224
            r4.close()
            goto L_0x025b
        L_0x0224:
            r6 = 0
            r7 = 0
            r8 = 2
            goto L_0x01df
        L_0x0228:
            r0 = move-exception
            goto L_0x0230
        L_0x022a:
            r0 = move-exception
            r7 = 0
            goto L_0x0945
        L_0x022e:
            r0 = move-exception
            r4 = 0
        L_0x0230:
            a.d.a.a.i.b.x3 r5 = r2.i()     // Catch:{ all -> 0x0943 }
            a.d.a.a.i.b.z3 r5 = r5.f     // Catch:{ all -> 0x0943 }
            java.lang.String r6 = "Database error querying filter results. appId"
            java.lang.Object r7 = a.d.a.a.i.b.x3.s(r3)     // Catch:{ all -> 0x0943 }
            r5.c(r6, r7, r0)     // Catch:{ all -> 0x0943 }
            boolean r0 = a.d.a.a.h.g.ra.b()     // Catch:{ all -> 0x0943 }
            if (r0 == 0) goto L_0x025d
            a.d.a.a.i.b.c5 r0 = r2.f2563a     // Catch:{ all -> 0x0943 }
            a.d.a.a.i.b.ka r0 = r0.g     // Catch:{ all -> 0x0943 }
            a.d.a.a.i.b.n3<java.lang.Boolean> r2 = a.d.a.a.i.b.q.N0     // Catch:{ all -> 0x0943 }
            boolean r0 = r0.t(r3, r2)     // Catch:{ all -> 0x0943 }
            if (r0 == 0) goto L_0x025d
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0943 }
            if (r4 == 0) goto L_0x025a
        L_0x0257:
            r4.close()
        L_0x025a:
            r5 = r0
        L_0x025b:
            r13 = r5
            goto L_0x0263
        L_0x025d:
            if (r4 == 0) goto L_0x0262
            r4.close()
        L_0x0262:
            r13 = 0
        L_0x0263:
            boolean r0 = a.d.a.a.h.g.ra.b()
            if (r0 == 0) goto L_0x0277
            a.d.a.a.i.b.c5 r0 = r10.f2563a
            a.d.a.a.i.b.ka r0 = r0.g
            java.lang.String r2 = r10.f2112d
            a.d.a.a.i.b.n3<java.lang.Boolean> r3 = a.d.a.a.i.b.q.N0
            boolean r0 = r0.t(r2, r3)
            if (r0 != 0) goto L_0x0279
        L_0x0277:
            if (r13 == 0) goto L_0x05b7
        L_0x0279:
            boolean r0 = r13.isEmpty()
            if (r0 == 0) goto L_0x0281
            goto L_0x05b7
        L_0x0281:
            java.util.HashSet r2 = new java.util.HashSet
            java.util.Set r0 = r13.keySet()
            r2.<init>(r0)
            if (r1 == 0) goto L_0x0406
            java.lang.String r1 = r10.f2112d
            a.c.a.f.b.h(r1)
            a.c.a.f.b.k(r13)
            androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap
            r3.<init>()
            boolean r0 = r13.isEmpty()
            if (r0 != 0) goto L_0x0404
            a.d.a.a.i.b.d r4 = r61.q()
            r4.n()
            r4.b()
            a.c.a.f.b.h(r1)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r5 = r4.t()
            java.lang.String r6 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            r8 = 2
            java.lang.String[] r7 = new java.lang.String[r8]     // Catch:{ SQLiteException -> 0x0303, all -> 0x0305 }
            r16 = 0
            r7[r16] = r1     // Catch:{ SQLiteException -> 0x0303, all -> 0x0305 }
            r16 = 1
            r7[r16] = r1     // Catch:{ SQLiteException -> 0x0303, all -> 0x0305 }
            android.database.Cursor r5 = r5.rawQuery(r6, r7)     // Catch:{ SQLiteException -> 0x0303, all -> 0x0305 }
            boolean r6 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0301 }
            if (r6 != 0) goto L_0x02d1
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0301 }
            goto L_0x0333
        L_0x02d1:
            r7 = 0
            int r6 = r5.getInt(r7)     // Catch:{ SQLiteException -> 0x0301 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)     // Catch:{ SQLiteException -> 0x0301 }
            java.lang.Object r7 = r0.get(r7)     // Catch:{ SQLiteException -> 0x0301 }
            java.util.List r7 = (java.util.List) r7     // Catch:{ SQLiteException -> 0x0301 }
            if (r7 != 0) goto L_0x02ee
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0301 }
            r7.<init>()     // Catch:{ SQLiteException -> 0x0301 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ SQLiteException -> 0x0301 }
            r0.put(r6, r7)     // Catch:{ SQLiteException -> 0x0301 }
        L_0x02ee:
            r6 = 1
            int r16 = r5.getInt(r6)     // Catch:{ SQLiteException -> 0x0301 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x0301 }
            r7.add(r6)     // Catch:{ SQLiteException -> 0x0301 }
            boolean r6 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x0301 }
            if (r6 != 0) goto L_0x02d1
            goto L_0x0333
        L_0x0301:
            r0 = move-exception
            goto L_0x030c
        L_0x0303:
            r0 = move-exception
            goto L_0x030b
        L_0x0305:
            r0 = move-exception
            r7 = 0
            goto L_0x03fe
        L_0x0309:
            r0 = move-exception
            r8 = 2
        L_0x030b:
            r5 = 0
        L_0x030c:
            a.d.a.a.i.b.x3 r6 = r4.i()     // Catch:{ all -> 0x03fc }
            a.d.a.a.i.b.z3 r6 = r6.f     // Catch:{ all -> 0x03fc }
            java.lang.String r7 = "Database error querying scoped filters. appId"
            java.lang.Object r8 = a.d.a.a.i.b.x3.s(r1)     // Catch:{ all -> 0x03fc }
            r6.c(r7, r8, r0)     // Catch:{ all -> 0x03fc }
            boolean r0 = a.d.a.a.h.g.ra.b()     // Catch:{ all -> 0x03fc }
            if (r0 == 0) goto L_0x0337
            a.d.a.a.i.b.c5 r0 = r4.f2563a     // Catch:{ all -> 0x03fc }
            a.d.a.a.i.b.ka r0 = r0.g     // Catch:{ all -> 0x03fc }
            a.d.a.a.i.b.n3<java.lang.Boolean> r4 = a.d.a.a.i.b.q.N0     // Catch:{ all -> 0x03fc }
            boolean r0 = r0.t(r1, r4)     // Catch:{ all -> 0x03fc }
            if (r0 == 0) goto L_0x0337
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x03fc }
            if (r5 == 0) goto L_0x033d
        L_0x0333:
            r5.close()
            goto L_0x033d
        L_0x0337:
            if (r5 == 0) goto L_0x033c
            r5.close()
        L_0x033c:
            r0 = 0
        L_0x033d:
            java.util.Set r1 = r13.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0345:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0404
            java.lang.Object r4 = r1.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            java.lang.Object r5 = r13.get(r5)
            a.d.a.a.h.g.d1 r5 = (a.d.a.a.h.g.d1) r5
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            java.lang.Object r6 = r0.get(r6)
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L_0x03ef
            boolean r7 = r6.isEmpty()
            if (r7 == 0) goto L_0x0373
            goto L_0x03ef
        L_0x0373:
            a.d.a.a.i.b.s9 r7 = r61.l()
            a.d.a.a.h.g.g6 r8 = r5.zzd
            java.util.List r7 = r7.C(r8, r6)
            boolean r8 = r7.isEmpty()
            if (r8 != 0) goto L_0x0345
            a.d.a.a.h.g.y5$b r8 = r5.r()
            a.d.a.a.h.g.d1$a r8 = (a.d.a.a.h.g.d1.a) r8
            r8.q()
            r8.s(r7)
            a.d.a.a.i.b.s9 r7 = r61.l()
            r17 = r0
            a.d.a.a.h.g.g6 r0 = r5.zzc
            java.util.List r0 = r7.C(r0, r6)
            r8.n()
            r8.p(r0)
            r0 = 0
        L_0x03a2:
            int r7 = r5.w()
            if (r0 >= r7) goto L_0x03c0
            a.d.a.a.h.g.w0 r7 = r5.s(r0)
            int r7 = r7.s()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            boolean r7 = r6.contains(r7)
            if (r7 == 0) goto L_0x03bd
            r8.o(r0)
        L_0x03bd:
            int r0 = r0 + 1
            goto L_0x03a2
        L_0x03c0:
            r0 = 0
        L_0x03c1:
            int r7 = r5.x()
            if (r0 >= r7) goto L_0x03df
            a.d.a.a.h.g.e1 r7 = r5.u(r0)
            int r7 = r7.t()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            boolean r7 = r6.contains(r7)
            if (r7 == 0) goto L_0x03dc
            r8.r(r0)
        L_0x03dc:
            int r0 = r0 + 1
            goto L_0x03c1
        L_0x03df:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            a.d.a.a.h.g.i7 r4 = r8.m()
            a.d.a.a.h.g.y5 r4 = (a.d.a.a.h.g.y5) r4
            a.d.a.a.h.g.d1 r4 = (a.d.a.a.h.g.d1) r4
            r3.put(r0, r4)
            goto L_0x03f8
        L_0x03ef:
            r17 = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            r3.put(r0, r5)
        L_0x03f8:
            r0 = r17
            goto L_0x0345
        L_0x03fc:
            r0 = move-exception
            r7 = r5
        L_0x03fe:
            if (r7 == 0) goto L_0x0403
            r7.close()
        L_0x0403:
            throw r0
        L_0x0404:
            r0 = r3
            goto L_0x0407
        L_0x0406:
            r0 = r13
        L_0x0407:
            java.util.Iterator r17 = r2.iterator()
        L_0x040b:
            boolean r1 = r17.hasNext()
            if (r1 == 0) goto L_0x05b7
            java.lang.Object r1 = r17.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r18 = r1.intValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r18)
            java.lang.Object r1 = r0.get(r1)
            a.d.a.a.h.g.d1 r1 = (a.d.a.a.h.g.d1) r1
            java.util.BitSet r5 = new java.util.BitSet
            r5.<init>()
            java.util.BitSet r6 = new java.util.BitSet
            r6.<init>()
            androidx.collection.ArrayMap r7 = new androidx.collection.ArrayMap
            r7.<init>()
            if (r1 == 0) goto L_0x0474
            int r2 = r1.w()
            if (r2 != 0) goto L_0x043d
            goto L_0x0474
        L_0x043d:
            a.d.a.a.h.g.f6<a.d.a.a.h.g.w0> r2 = r1.zze
            java.util.Iterator r2 = r2.iterator()
        L_0x0443:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0474
            java.lang.Object r3 = r2.next()
            a.d.a.a.h.g.w0 r3 = (a.d.a.a.h.g.w0) r3
            int r4 = r3.zzc
            r8 = 1
            r4 = r4 & r8
            if (r4 == 0) goto L_0x0457
            r4 = 1
            goto L_0x0458
        L_0x0457:
            r4 = 0
        L_0x0458:
            if (r4 == 0) goto L_0x0443
            int r4 = r3.zzd
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r8 = r3.t()
            if (r8 == 0) goto L_0x046f
            long r19 = r3.u()
            java.lang.Long r3 = java.lang.Long.valueOf(r19)
            goto L_0x0470
        L_0x046f:
            r3 = 0
        L_0x0470:
            r7.put(r4, r3)
            goto L_0x0443
        L_0x0474:
            androidx.collection.ArrayMap r8 = new androidx.collection.ArrayMap
            r8.<init>()
            if (r1 == 0) goto L_0x04c8
            int r2 = r1.x()
            if (r2 != 0) goto L_0x0482
            goto L_0x04c8
        L_0x0482:
            a.d.a.a.h.g.f6<a.d.a.a.h.g.e1> r2 = r1.zzf
            java.util.Iterator r2 = r2.iterator()
        L_0x0488:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x04c8
            java.lang.Object r3 = r2.next()
            a.d.a.a.h.g.e1 r3 = (a.d.a.a.h.g.e1) r3
            int r4 = r3.zzc
            r19 = 1
            r4 = r4 & 1
            if (r4 == 0) goto L_0x049e
            r4 = 1
            goto L_0x049f
        L_0x049e:
            r4 = 0
        L_0x049f:
            if (r4 == 0) goto L_0x04c3
            a.d.a.a.h.g.g6 r4 = r3.zze
            int r4 = r4.size()
            if (r4 <= 0) goto L_0x04c3
            int r4 = r3.zzd
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r20 = r3.u()
            r21 = r0
            int r0 = r20 + -1
            long r22 = r3.s(r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r22)
            r8.put(r4, r0)
            goto L_0x04c5
        L_0x04c3:
            r21 = r0
        L_0x04c5:
            r0 = r21
            goto L_0x0488
        L_0x04c8:
            r21 = r0
            r19 = 1
            if (r1 == 0) goto L_0x0517
            r4 = 0
        L_0x04cf:
            a.d.a.a.h.g.g6 r0 = r1.zzc
            int r0 = r0.size()
            int r0 = r0 << 6
            if (r4 >= r0) goto L_0x0517
            a.d.a.a.h.g.g6 r0 = r1.zzc
            boolean r0 = a.d.a.a.i.b.s9.Q(r0, r4)
            if (r0 == 0) goto L_0x0506
            a.d.a.a.i.b.x3 r0 = r61.i()
            a.d.a.a.i.b.z3 r0 = r0.n
            java.lang.Integer r2 = java.lang.Integer.valueOf(r18)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            r62 = r9
            java.lang.String r9 = "Filter already evaluated. audience ID, filter ID"
            r0.c(r9, r2, r3)
            r6.set(r4)
            a.d.a.a.h.g.g6 r0 = r1.zzd
            boolean r0 = a.d.a.a.i.b.s9.Q(r0, r4)
            if (r0 == 0) goto L_0x0508
            r5.set(r4)
            r0 = 1
            goto L_0x0509
        L_0x0506:
            r62 = r9
        L_0x0508:
            r0 = 0
        L_0x0509:
            if (r0 != 0) goto L_0x0512
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            r7.remove(r0)
        L_0x0512:
            int r4 = r4 + 1
            r9 = r62
            goto L_0x04cf
        L_0x0517:
            r62 = r9
            java.lang.Integer r0 = java.lang.Integer.valueOf(r18)
            java.lang.Object r0 = r13.get(r0)
            r4 = r0
            a.d.a.a.h.g.d1 r4 = (a.d.a.a.h.g.d1) r4
            if (r15 == 0) goto L_0x0594
            if (r14 == 0) goto L_0x0594
            java.lang.Integer r0 = java.lang.Integer.valueOf(r18)
            java.lang.Object r0 = r12.get(r0)
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x0594
            java.lang.Long r1 = r10.h
            if (r1 == 0) goto L_0x0594
            java.lang.Long r1 = r10.g
            if (r1 != 0) goto L_0x053d
            goto L_0x0594
        L_0x053d:
            java.util.Iterator r0 = r0.iterator()
        L_0x0541:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0594
            java.lang.Object r1 = r0.next()
            a.d.a.a.h.g.i0 r1 = (a.d.a.a.h.g.i0) r1
            int r2 = r1.v()
            java.lang.Long r3 = r10.h
            long r22 = r3.longValue()
            r24 = 1000(0x3e8, double:4.94E-321)
            long r22 = r22 / r24
            boolean r1 = r1.x()
            if (r1 == 0) goto L_0x0569
            java.lang.Long r1 = r10.g
            long r22 = r1.longValue()
            long r22 = r22 / r24
        L_0x0569:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            boolean r1 = r7.containsKey(r1)
            if (r1 == 0) goto L_0x057e
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            java.lang.Long r3 = java.lang.Long.valueOf(r22)
            r7.put(r1, r3)
        L_0x057e:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            boolean r1 = r8.containsKey(r1)
            if (r1 == 0) goto L_0x0541
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            java.lang.Long r2 = java.lang.Long.valueOf(r22)
            r8.put(r1, r2)
            goto L_0x0541
        L_0x0594:
            a.d.a.a.i.b.da r0 = new a.d.a.a.i.b.da
            java.lang.String r3 = r10.f2112d
            r9 = 0
            r1 = r0
            r2 = r61
            r20 = 0
            r22 = r12
            r12 = 2
            r26 = r62
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            java.util.Map<java.lang.Integer, a.d.a.a.i.b.da> r1 = r10.f
            java.lang.Integer r2 = java.lang.Integer.valueOf(r18)
            r1.put(r2, r0)
            r0 = r21
            r12 = r22
            r9 = r26
            goto L_0x040b
        L_0x05b7:
            r26 = r9
            r12 = 2
            r19 = 1
            r20 = 0
            boolean r0 = r63.isEmpty()
            java.lang.String r1 = "Skipping failed audience ID"
            if (r0 != 0) goto L_0x0749
            a.d.a.a.i.b.ga r0 = new a.d.a.a.i.b.ga
            r2 = 0
            r0.<init>(r10, r2)
            androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap
            r3.<init>()
            java.util.Iterator r4 = r63.iterator()
        L_0x05d5:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0749
            java.lang.Object r5 = r4.next()
            a.d.a.a.h.g.x0 r5 = (a.d.a.a.h.g.x0) r5
            java.lang.String r6 = r10.f2112d
            a.d.a.a.h.g.x0 r6 = r0.a(r6, r5)
            if (r6 == 0) goto L_0x05d5
            a.d.a.a.i.b.d r7 = r61.q()
            java.lang.String r8 = r10.f2112d
            java.lang.String r9 = r6.zze
            java.lang.String r13 = r5.zze
            a.d.a.a.i.b.l r13 = r7.z(r8, r13)
            if (r13 != 0) goto L_0x0632
            a.d.a.a.i.b.x3 r13 = r7.i()
            a.d.a.a.i.b.z3 r13 = r13.i
            java.lang.Object r14 = a.d.a.a.i.b.x3.s(r8)
            a.d.a.a.i.b.v3 r7 = r7.d()
            java.lang.String r7 = r7.u(r9)
            java.lang.String r9 = "Event aggregate wasn't created during raw event logging. appId, event"
            r13.c(r9, r14, r7)
            a.d.a.a.i.b.l r7 = new a.d.a.a.i.b.l
            r27 = r7
            java.lang.String r9 = r5.zze
            r29 = r9
            r30 = 1
            r32 = 1
            r34 = 1
            long r13 = r5.zzf
            r36 = r13
            r38 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r28 = r8
            r27.<init>(r28, r29, r30, r32, r34, r36, r38, r40, r41, r42, r43)
            goto L_0x0667
        L_0x0632:
            a.d.a.a.i.b.l r7 = new a.d.a.a.i.b.l
            r44 = r7
            java.lang.String r5 = r13.f2333a
            r45 = r5
            java.lang.String r5 = r13.f2334b
            r46 = r5
            long r8 = r13.f2335c
            r14 = 1
            long r47 = r8 + r14
            long r8 = r13.f2336d
            long r49 = r8 + r14
            long r8 = r13.f2337e
            long r51 = r8 + r14
            long r8 = r13.f
            r53 = r8
            long r8 = r13.g
            r55 = r8
            java.lang.Long r5 = r13.h
            r57 = r5
            java.lang.Long r5 = r13.i
            r58 = r5
            java.lang.Long r5 = r13.j
            r59 = r5
            java.lang.Boolean r5 = r13.k
            r60 = r5
            r44.<init>(r45, r46, r47, r49, r51, r53, r55, r57, r58, r59, r60)
        L_0x0667:
            a.d.a.a.i.b.d r5 = r61.q()
            r5.H(r7)
            long r8 = r7.f2335c
            java.lang.String r5 = r6.zze
            java.lang.Object r13 = r3.get(r5)
            java.util.Map r13 = (java.util.Map) r13
            if (r13 != 0) goto L_0x06a3
            a.d.a.a.i.b.d r13 = r61.q()
            java.lang.String r14 = r10.f2112d
            java.util.Map r13 = r13.c0(r14, r5)
            boolean r14 = a.d.a.a.h.g.ra.b()
            if (r14 == 0) goto L_0x0698
            a.d.a.a.i.b.c5 r14 = r10.f2563a
            a.d.a.a.i.b.ka r14 = r14.g
            java.lang.String r15 = r10.f2112d
            a.d.a.a.i.b.n3<java.lang.Boolean> r2 = a.d.a.a.i.b.q.N0
            boolean r2 = r14.t(r15, r2)
            if (r2 != 0) goto L_0x06a0
        L_0x0698:
            if (r13 != 0) goto L_0x06a0
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap
            r2.<init>()
            r13 = r2
        L_0x06a0:
            r3.put(r5, r13)
        L_0x06a3:
            java.util.Set r2 = r13.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x06ab:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x0746
            java.lang.Object r5 = r2.next()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.util.Set<java.lang.Integer> r14 = r10.f2113e
            java.lang.Integer r15 = java.lang.Integer.valueOf(r5)
            boolean r14 = r14.contains(r15)
            if (r14 == 0) goto L_0x06d5
            a.d.a.a.i.b.x3 r14 = r61.i()
            a.d.a.a.i.b.z3 r14 = r14.n
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r14.b(r1, r5)
            goto L_0x06ab
        L_0x06d5:
            java.lang.Integer r14 = java.lang.Integer.valueOf(r5)
            java.lang.Object r14 = r13.get(r14)
            java.util.List r14 = (java.util.List) r14
            java.util.Iterator r14 = r14.iterator()
            r15 = 1
        L_0x06e4:
            boolean r16 = r14.hasNext()
            if (r16 == 0) goto L_0x0730
            java.lang.Object r15 = r14.next()
            a.d.a.a.h.g.i0 r15 = (a.d.a.a.h.g.i0) r15
            a.d.a.a.i.b.fa r12 = new a.d.a.a.i.b.fa
            r62 = r0
            java.lang.String r0 = r10.f2112d
            r12.<init>(r10, r0, r5, r15)
            java.lang.Long r0 = r10.g
            r63 = r2
            java.lang.Long r2 = r10.h
            int r15 = r15.v()
            boolean r34 = r10.u(r5, r15)
            r27 = r12
            r28 = r0
            r29 = r2
            r30 = r6
            r31 = r8
            r33 = r7
            boolean r15 = r27.i(r28, r29, r30, r31, r33, r34)
            if (r15 == 0) goto L_0x0726
            a.d.a.a.i.b.da r0 = r10.s(r5)
            r0.b(r12)
            r0 = r62
            r2 = r63
            r12 = 2
            goto L_0x06e4
        L_0x0726:
            java.util.Set<java.lang.Integer> r0 = r10.f2113e
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            r0.add(r2)
            goto L_0x0734
        L_0x0730:
            r62 = r0
            r63 = r2
        L_0x0734:
            if (r15 != 0) goto L_0x073f
            java.util.Set<java.lang.Integer> r0 = r10.f2113e
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            r0.add(r2)
        L_0x073f:
            r0 = r62
            r2 = r63
            r12 = 2
            goto L_0x06ab
        L_0x0746:
            r2 = 0
            goto L_0x05d5
        L_0x0749:
            boolean r0 = r64.isEmpty()
            if (r0 != 0) goto L_0x089e
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            java.util.Iterator r2 = r64.iterator()
        L_0x0758:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x089e
            java.lang.Object r3 = r2.next()
            a.d.a.a.h.g.f1 r3 = (a.d.a.a.h.g.f1) r3
            java.lang.String r4 = r3.zze
            java.lang.Object r5 = r0.get(r4)
            java.util.Map r5 = (java.util.Map) r5
            if (r5 != 0) goto L_0x0796
            a.d.a.a.i.b.d r5 = r61.q()
            java.lang.String r6 = r10.f2112d
            java.util.Map r5 = r5.d0(r6, r4)
            boolean r6 = a.d.a.a.h.g.ra.b()
            if (r6 == 0) goto L_0x078c
            a.d.a.a.i.b.c5 r6 = r10.f2563a
            a.d.a.a.i.b.ka r6 = r6.g
            java.lang.String r7 = r10.f2112d
            a.d.a.a.i.b.n3<java.lang.Boolean> r8 = a.d.a.a.i.b.q.N0
            boolean r6 = r6.t(r7, r8)
            if (r6 != 0) goto L_0x0793
        L_0x078c:
            if (r5 != 0) goto L_0x0793
            androidx.collection.ArrayMap r5 = new androidx.collection.ArrayMap
            r5.<init>()
        L_0x0793:
            r0.put(r4, r5)
        L_0x0796:
            java.util.Set r4 = r5.keySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x079e:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0758
            java.lang.Object r6 = r4.next()
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            java.util.Set<java.lang.Integer> r7 = r10.f2113e
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
            boolean r7 = r7.contains(r8)
            if (r7 == 0) goto L_0x07c8
            a.d.a.a.i.b.x3 r3 = r61.i()
            a.d.a.a.i.b.z3 r3 = r3.n
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)
            r3.b(r1, r4)
            goto L_0x0758
        L_0x07c8:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            java.lang.Object r7 = r5.get(r7)
            java.util.List r7 = (java.util.List) r7
            java.util.Iterator r7 = r7.iterator()
            r8 = 1
        L_0x07d7:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x0891
            java.lang.Object r8 = r7.next()
            a.d.a.a.h.g.l0 r8 = (a.d.a.a.h.g.l0) r8
            a.d.a.a.i.b.x3 r9 = r61.i()
            r12 = 2
            boolean r9 = r9.x(r12)
            if (r9 == 0) goto L_0x082e
            a.d.a.a.i.b.x3 r9 = r61.i()
            a.d.a.a.i.b.z3 r9 = r9.n
            java.lang.Integer r13 = java.lang.Integer.valueOf(r6)
            boolean r14 = r8.t()
            if (r14 == 0) goto L_0x0807
            int r14 = r8.u()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            goto L_0x0808
        L_0x0807:
            r14 = 0
        L_0x0808:
            a.d.a.a.i.b.v3 r15 = r61.d()
            java.lang.String r12 = r8.v()
            java.lang.String r12 = r15.y(r12)
            java.lang.String r15 = "Evaluating filter. audience, filter, property"
            r9.d(r15, r13, r14, r12)
            a.d.a.a.i.b.x3 r9 = r61.i()
            a.d.a.a.i.b.z3 r9 = r9.D()
            a.d.a.a.i.b.s9 r12 = r61.l()
            java.lang.String r12 = r12.y(r8)
            java.lang.String r13 = "Filter definition"
            r9.b(r13, r12)
        L_0x082e:
            boolean r9 = r8.t()
            if (r9 == 0) goto L_0x0869
            int r9 = r8.u()
            r12 = 256(0x100, float:3.59E-43)
            if (r9 <= r12) goto L_0x083d
            goto L_0x0869
        L_0x083d:
            a.d.a.a.i.b.ha r9 = new a.d.a.a.i.b.ha
            java.lang.String r12 = r10.f2112d
            r9.<init>(r10, r12, r6, r8)
            java.lang.Long r12 = r10.g
            java.lang.Long r13 = r10.h
            int r8 = r8.u()
            boolean r8 = r10.u(r6, r8)
            boolean r8 = r9.i(r12, r13, r3, r8)
            if (r8 == 0) goto L_0x085f
            a.d.a.a.i.b.da r12 = r10.s(r6)
            r12.b(r9)
            goto L_0x07d7
        L_0x085f:
            java.util.Set<java.lang.Integer> r7 = r10.f2113e
            java.lang.Integer r9 = java.lang.Integer.valueOf(r6)
            r7.add(r9)
            goto L_0x0891
        L_0x0869:
            a.d.a.a.i.b.x3 r7 = r61.i()
            a.d.a.a.i.b.z3 r7 = r7.A()
            java.lang.String r9 = r10.f2112d
            java.lang.Object r9 = a.d.a.a.i.b.x3.s(r9)
            boolean r12 = r8.t()
            if (r12 == 0) goto L_0x0886
            int r8 = r8.u()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            goto L_0x0887
        L_0x0886:
            r8 = 0
        L_0x0887:
            java.lang.String r8 = java.lang.String.valueOf(r8)
            java.lang.String r12 = "Invalid property filter ID. appId, id"
            r7.c(r12, r9, r8)
            r8 = 0
        L_0x0891:
            if (r8 != 0) goto L_0x079e
            java.util.Set<java.lang.Integer> r7 = r10.f2113e
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r7.add(r6)
            goto L_0x079e
        L_0x089e:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Map<java.lang.Integer, a.d.a.a.i.b.da> r0 = r10.f
            java.util.Set r0 = r0.keySet()
            java.util.Set<java.lang.Integer> r2 = r10.f2113e
            r0.removeAll(r2)
            java.util.Iterator r2 = r0.iterator()
        L_0x08b2:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0942
            java.lang.Object r0 = r2.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.util.Map<java.lang.Integer, a.d.a.a.i.b.da> r3 = r10.f
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            java.lang.Object r3 = r3.get(r4)
            a.d.a.a.i.b.da r3 = (a.d.a.a.i.b.da) r3
            a.d.a.a.h.g.v0 r3 = r3.a(r0)
            r1.add(r3)
            a.d.a.a.i.b.d r4 = r61.q()
            java.lang.String r5 = r10.f2112d
            a.d.a.a.h.g.d1 r3 = r3.zze
            if (r3 != 0) goto L_0x08e1
            a.d.a.a.h.g.d1 r3 = a.d.a.a.h.g.d1.zzg
        L_0x08e1:
            r4.n()
            r4.b()
            a.c.a.f.b.h(r5)
            a.c.a.f.b.k(r3)
            byte[] r3 = r3.j()
            android.content.ContentValues r6 = new android.content.ContentValues
            r6.<init>()
            java.lang.String r7 = "app_id"
            r6.put(r7, r5)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7 = r26
            r6.put(r7, r0)
            r6.put(r11, r3)
            android.database.sqlite.SQLiteDatabase r0 = r4.t()     // Catch:{ SQLiteException -> 0x092d }
            java.lang.String r3 = "audience_filter_values"
            r8 = 5
            r9 = 0
            long r12 = r0.insertWithOnConflict(r3, r9, r6, r8)     // Catch:{ SQLiteException -> 0x092b }
            r14 = -1
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 != 0) goto L_0x093e
            a.d.a.a.i.b.x3 r0 = r4.i()     // Catch:{ SQLiteException -> 0x092b }
            a.d.a.a.i.b.z3 r0 = r0.z()     // Catch:{ SQLiteException -> 0x092b }
            java.lang.String r3 = "Failed to insert filter results (got -1). appId"
            java.lang.Object r6 = a.d.a.a.i.b.x3.s(r5)     // Catch:{ SQLiteException -> 0x092b }
            r0.b(r3, r6)     // Catch:{ SQLiteException -> 0x092b }
            goto L_0x093e
        L_0x092b:
            r0 = move-exception
            goto L_0x092f
        L_0x092d:
            r0 = move-exception
            r9 = 0
        L_0x092f:
            a.d.a.a.i.b.x3 r3 = r4.i()
            a.d.a.a.i.b.z3 r3 = r3.f
            java.lang.Object r4 = a.d.a.a.i.b.x3.s(r5)
            java.lang.String r5 = "Error storing filter results. appId"
            r3.c(r5, r4, r0)
        L_0x093e:
            r26 = r7
            goto L_0x08b2
        L_0x0942:
            return r1
        L_0x0943:
            r0 = move-exception
            r7 = r4
        L_0x0945:
            if (r7 == 0) goto L_0x094a
            r7.close()
        L_0x094a:
            goto L_0x094c
        L_0x094b:
            throw r0
        L_0x094c:
            goto L_0x094b
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.ba.t(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }

    public final boolean u(int i, int i2) {
        if (this.f.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.f.get(Integer.valueOf(i)).f2158d.get(i2);
    }
}
