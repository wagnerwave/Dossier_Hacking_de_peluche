package a.d.a.a.h.f;

import a.c.a.f.b;
import a.d.a.a.b.f;
import a.d.a.a.e.q.c;
import a.d.a.a.e.q.e;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class p extends f implements Closeable {
    public static final String f = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[]{"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});
    public static final String g = String.format("SELECT MAX(%s) FROM %s WHERE 1;", new Object[]{"hit_time", "hits2"});

    /* renamed from: c  reason: collision with root package name */
    public final q f1545c;

    /* renamed from: d  reason: collision with root package name */
    public final d1 f1546d = new d1(this.f1490a.f1505c);

    /* renamed from: e  reason: collision with root package name */
    public final d1 f1547e = new d1(this.f1490a.f1505c);

    public p(h hVar) {
        super(hVar);
        this.f1545c = new q(this, hVar.f1503a, "google_analytics_v4.db");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00a1 A[LOOP:0: B:10:0x005c->B:19:0x00a1, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a6 A[EDGE_INSN: B:35:0x00a6->B:20:0x00a6 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<a.d.a.a.h.f.n0> A(long r23) {
        /*
            r22 = this;
            r10 = r22
            java.lang.String r0 = "hit_id"
            r11 = 1
            r12 = 0
            r1 = 0
            int r3 = (r23 > r1 ? 1 : (r23 == r1 ? 0 : -1))
            if (r3 < 0) goto L_0x000e
            r1 = 1
            goto L_0x000f
        L_0x000e:
            r1 = 0
        L_0x000f:
            a.c.a.f.b.d(r1)
            a.d.a.a.b.f.b()
            r22.u()
            android.database.sqlite.SQLiteDatabase r13 = r22.w()
            r1 = 0
            java.lang.String r14 = "hits2"
            r2 = 5
            java.lang.String[] r15 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00b2 }
            r15[r12] = r0     // Catch:{ SQLiteException -> 0x00b2 }
            java.lang.String r2 = "hit_time"
            r15[r11] = r2     // Catch:{ SQLiteException -> 0x00b2 }
            java.lang.String r2 = "hit_string"
            r9 = 2
            r15[r9] = r2     // Catch:{ SQLiteException -> 0x00b2 }
            java.lang.String r2 = "hit_url"
            r7 = 3
            r15[r7] = r2     // Catch:{ SQLiteException -> 0x00b2 }
            java.lang.String r2 = "hit_app_id"
            r8 = 4
            r15[r8] = r2     // Catch:{ SQLiteException -> 0x00b2 }
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            java.lang.String r2 = "%s ASC"
            java.lang.Object[] r3 = new java.lang.Object[r11]     // Catch:{ SQLiteException -> 0x00b2 }
            r3[r12] = r0     // Catch:{ SQLiteException -> 0x00b2 }
            java.lang.String r20 = java.lang.String.format(r2, r3)     // Catch:{ SQLiteException -> 0x00b2 }
            java.lang.String r21 = java.lang.Long.toString(r23)     // Catch:{ SQLiteException -> 0x00b2 }
            android.database.Cursor r13 = r13.query(r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ SQLiteException -> 0x00b2 }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x00ad, all -> 0x00aa }
            r0.<init>()     // Catch:{ SQLiteException -> 0x00ad, all -> 0x00aa }
            boolean r1 = r13.moveToFirst()     // Catch:{ SQLiteException -> 0x00ad, all -> 0x00aa }
            if (r1 == 0) goto L_0x00a6
        L_0x005c:
            long r14 = r13.getLong(r12)     // Catch:{ SQLiteException -> 0x00ad, all -> 0x00aa }
            long r4 = r13.getLong(r11)     // Catch:{ SQLiteException -> 0x00ad, all -> 0x00aa }
            java.lang.String r1 = r13.getString(r9)     // Catch:{ SQLiteException -> 0x00ad, all -> 0x00aa }
            java.lang.String r2 = r13.getString(r7)     // Catch:{ SQLiteException -> 0x00ad, all -> 0x00aa }
            int r16 = r13.getInt(r8)     // Catch:{ SQLiteException -> 0x00ad, all -> 0x00aa }
            java.util.Map r3 = r10.E(r1)     // Catch:{ SQLiteException -> 0x00ad, all -> 0x00aa }
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch:{ SQLiteException -> 0x00ad, all -> 0x00aa }
            if (r1 == 0) goto L_0x007c
        L_0x007a:
            r6 = 1
            goto L_0x0086
        L_0x007c:
            java.lang.String r1 = "http:"
            boolean r1 = r2.startsWith(r1)     // Catch:{ SQLiteException -> 0x00ad, all -> 0x00aa }
            if (r1 != 0) goto L_0x0085
            goto L_0x007a
        L_0x0085:
            r6 = 0
        L_0x0086:
            a.d.a.a.h.f.n0 r2 = new a.d.a.a.h.f.n0     // Catch:{ SQLiteException -> 0x00ad, all -> 0x00aa }
            r1 = r2
            r11 = r2
            r2 = r22
            r18 = 4
            r19 = 3
            r7 = r14
            r14 = 2
            r9 = r16
            r1.<init>(r2, r3, r4, r6, r7, r9)     // Catch:{ SQLiteException -> 0x00ad, all -> 0x00aa }
            r0.add(r11)     // Catch:{ SQLiteException -> 0x00ad, all -> 0x00aa }
            boolean r1 = r13.moveToNext()     // Catch:{ SQLiteException -> 0x00ad, all -> 0x00aa }
            if (r1 != 0) goto L_0x00a1
            goto L_0x00a6
        L_0x00a1:
            r7 = 3
            r8 = 4
            r9 = 2
            r11 = 1
            goto L_0x005c
        L_0x00a6:
            r13.close()
            return r0
        L_0x00aa:
            r0 = move-exception
            r1 = r13
            goto L_0x00b9
        L_0x00ad:
            r0 = move-exception
            r1 = r13
            goto L_0x00b3
        L_0x00b0:
            r0 = move-exception
            goto L_0x00b9
        L_0x00b2:
            r0 = move-exception
        L_0x00b3:
            java.lang.String r2 = "Error loading hits from the database"
            r10.n(r2, r0)     // Catch:{ all -> 0x00b0 }
            throw r0     // Catch:{ all -> 0x00b0 }
        L_0x00b9:
            if (r1 == 0) goto L_0x00be
            r1.close()
        L_0x00be:
            goto L_0x00c0
        L_0x00bf:
            throw r0
        L_0x00c0:
            goto L_0x00bf
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.f.p.A(long):java.util.List");
    }

    public final int B() {
        f.b();
        u();
        if (!this.f1546d.b(86400000)) {
            return 0;
        }
        this.f1546d.a();
        o("Deleting stale hits (if any)");
        SQLiteDatabase w = w();
        if (((c) this.f1490a.f1505c) != null) {
            int delete = w.delete("hits2", "hit_time < ?", new String[]{Long.toString(System.currentTimeMillis() - 2592000000L)});
            b("Deleted stale hits, count", Integer.valueOf(delete));
            return delete;
        }
        throw null;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.String[], android.database.Cursor] */
    public final long C() {
        f.b();
        u();
        String str = g;
        ? r2 = 0;
        try {
            Cursor rawQuery = w().rawQuery(str, r2);
            if (rawQuery.moveToFirst()) {
                long j = rawQuery.getLong(0);
                rawQuery.close();
                return j;
            }
            rawQuery.close();
            return 0;
        } catch (SQLiteException e2) {
            m("Database error", str, e2);
            throw e2;
        } catch (Throwable th) {
            if (r2 != 0) {
                r2.close();
            }
            throw th;
        }
    }

    public final void D(long j) {
        f.b();
        u();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j));
        b("Deleting hit, id", Long.valueOf(j));
        z(arrayList);
    }

    public final Map<String, String> E(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            if (!str.startsWith("?")) {
                str = str.length() != 0 ? "?".concat(str) : new String("?");
            }
            return e.a(new URI(str), "UTF-8");
        } catch (URISyntaxException e2) {
            n("Error parsing hit parameters", e2);
            return new HashMap(0);
        }
    }

    public final void close() {
        String str;
        try {
            this.f1545c.close();
        } catch (SQLiteException e2) {
            e = e2;
            str = "Sql error closing database";
            n(str, e);
        } catch (IllegalStateException e3) {
            e = e3;
            str = "Error closing database";
            n(str, e);
        }
    }

    public final void t() {
    }

    public final void v() {
        u();
        w().endTransaction();
    }

    public final SQLiteDatabase w() {
        try {
            return this.f1545c.getWritableDatabase();
        } catch (SQLiteException e2) {
            l("Error opening database", e2);
            throw e2;
        }
    }

    public final boolean x() {
        f.b();
        u();
        Cursor cursor = null;
        try {
            cursor = w().rawQuery("SELECT COUNT(*) FROM hits2", (String[]) null);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                cursor.close();
                return j == 0;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e2) {
            m("Database error", "SELECT COUNT(*) FROM hits2", e2);
            throw e2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void y() {
        u();
        w().setTransactionSuccessful();
    }

    public final void z(List<Long> list) {
        b.k(list);
        f.b();
        u();
        if (!list.isEmpty()) {
            StringBuilder sb = new StringBuilder("hit_id");
            sb.append(" in (");
            for (int i = 0; i < list.size(); i++) {
                Long l = list.get(i);
                if (l == null || l.longValue() == 0) {
                    throw new SQLiteException("Invalid hit id");
                }
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(l);
            }
            sb.append(")");
            String sb2 = sb.toString();
            try {
                SQLiteDatabase w = w();
                b("Deleting dispatched hits. count", Integer.valueOf(list.size()));
                int delete = w.delete("hits2", sb2, (String[]) null);
                if (delete != list.size()) {
                    a(5, "Deleted fewer hits then expected", Integer.valueOf(list.size()), Integer.valueOf(delete), sb2);
                }
            } catch (SQLiteException e2) {
                n("Error deleting hits", e2);
                throw e2;
            }
        }
    }
}
