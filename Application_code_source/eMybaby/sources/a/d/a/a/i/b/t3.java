package a.d.a.a.i.b;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.SystemClock;
import androidx.annotation.WorkerThread;
import androidx.core.app.NotificationCompat;
import com.tuya.smart.common.OO000o0;

public final class t3 extends a5 {

    /* renamed from: c  reason: collision with root package name */
    public final s3 f2527c = new s3(this, this.f2563a.f2123a, "google_app_measurement_local.db");

    /* renamed from: d  reason: collision with root package name */
    public boolean f2528d;

    public t3(c5 c5Var) {
        super(c5Var);
    }

    public static long y(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            Cursor query = sQLiteDatabase.query(NotificationCompat.CarExtender.KEY_MESSAGES, new String[]{"rowid"}, "type=?", new String[]{OO000o0.O00000o}, (String) null, (String) null, "rowid desc", "1");
            if (query.moveToFirst()) {
                long j = query.getLong(0);
                query.close();
                return j;
            }
            query.close();
            return -1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final void A() {
        b();
        try {
            int delete = C().delete(NotificationCompat.CarExtender.KEY_MESSAGES, (String) null, (String[]) null) + 0;
            if (delete > 0) {
                i().n.b("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e2) {
            i().f.b("Error resetting local analytics data. error", e2);
        }
    }

    @WorkerThread
    public final boolean B() {
        b();
        if (this.f2528d || !this.f2563a.f2123a.getDatabasePath("google_app_measurement_local.db").exists()) {
            return false;
        }
        int i = 0;
        int i2 = 5;
        while (i < 5) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = C();
                if (sQLiteDatabase == null) {
                    this.f2528d = true;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return false;
                }
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.delete(NotificationCompat.CarExtender.KEY_MESSAGES, "type == ?", new String[]{Integer.toString(3)});
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                sQLiteDatabase.close();
                return true;
            } catch (SQLiteFullException e2) {
                i().f.b("Error deleting app launch break from local database", e2);
                this.f2528d = true;
                if (sQLiteDatabase == null) {
                    i++;
                }
                sQLiteDatabase.close();
                i++;
            } catch (SQLiteDatabaseLockedException unused) {
                SystemClock.sleep((long) i2);
                i2 += 20;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                    i++;
                } else {
                    i++;
                }
            } catch (SQLiteException e3) {
                if (sQLiteDatabase != null) {
                    if (sQLiteDatabase.inTransaction()) {
                        sQLiteDatabase.endTransaction();
                    }
                }
                i().f.b("Error deleting app launch break from local database", e3);
                this.f2528d = true;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                    i++;
                } else {
                    i++;
                }
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        }
        i().i.a("Error deleting app launch break from local database in reasonable time");
        return false;
    }

    @WorkerThread
    public final SQLiteDatabase C() {
        if (this.f2528d) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f2527c.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.f2528d = true;
        return null;
    }

    public final boolean w() {
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r7v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r7v7 */
    /* JADX WARNING: type inference failed for: r7v8 */
    /* JADX WARNING: type inference failed for: r7v9 */
    /* JADX WARNING: type inference failed for: r7v10 */
    /* JADX WARNING: type inference failed for: r7v11 */
    /* JADX WARNING: type inference failed for: r7v12 */
    /* JADX WARNING: type inference failed for: r7v17 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c2 A[SYNTHETIC, Splitter:B:49:0x00c2] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0111 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0111 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0111 A[SYNTHETIC] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean z(int r17, byte[] r18) {
        /*
            r16 = this;
            r1 = r16
            r16.b()
            boolean r0 = r1.f2528d
            r2 = 0
            if (r0 == 0) goto L_0x000b
            return r2
        L_0x000b:
            android.content.ContentValues r3 = new android.content.ContentValues
            r3.<init>()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r17)
            java.lang.String r4 = "type"
            r3.put(r4, r0)
            java.lang.String r0 = "entry"
            r4 = r18
            r3.put(r0, r4)
            r4 = 5
            r5 = 0
            r6 = 5
        L_0x0023:
            if (r5 >= r4) goto L_0x0122
            r7 = 0
            r8 = 1
            android.database.sqlite.SQLiteDatabase r9 = r16.C()     // Catch:{ SQLiteFullException -> 0x00f7, SQLiteDatabaseLockedException -> 0x00e8, SQLiteException -> 0x00be, all -> 0x00bb }
            if (r9 != 0) goto L_0x0035
            r1.f2528d = r8     // Catch:{ SQLiteFullException -> 0x00b9, SQLiteDatabaseLockedException -> 0x00e9, SQLiteException -> 0x00b5 }
            if (r9 == 0) goto L_0x0034
            r9.close()
        L_0x0034:
            return r2
        L_0x0035:
            r9.beginTransaction()     // Catch:{ SQLiteFullException -> 0x00b9, SQLiteDatabaseLockedException -> 0x00e9, SQLiteException -> 0x00b5 }
            r10 = 0
            java.lang.String r0 = "select count(1) from messages"
            android.database.Cursor r12 = r9.rawQuery(r0, r7)     // Catch:{ SQLiteFullException -> 0x00b9, SQLiteDatabaseLockedException -> 0x00e9, SQLiteException -> 0x00b5 }
            if (r12 == 0) goto L_0x0053
            boolean r0 = r12.moveToFirst()     // Catch:{ SQLiteFullException -> 0x0051, SQLiteDatabaseLockedException -> 0x00ae, SQLiteException -> 0x004f, all -> 0x004d }
            if (r0 == 0) goto L_0x0053
            long r10 = r12.getLong(r2)     // Catch:{ SQLiteFullException -> 0x0051, SQLiteDatabaseLockedException -> 0x00ae, SQLiteException -> 0x004f, all -> 0x004d }
            goto L_0x0053
        L_0x004d:
            r0 = move-exception
            goto L_0x00a9
        L_0x004f:
            r0 = move-exception
            goto L_0x00ac
        L_0x0051:
            r0 = move-exception
            goto L_0x00b0
        L_0x0053:
            java.lang.String r0 = "messages"
            r13 = 100000(0x186a0, double:4.94066E-319)
            int r15 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r15 < 0) goto L_0x0096
            a.d.a.a.i.b.x3 r15 = r16.i()     // Catch:{ SQLiteFullException -> 0x0051, SQLiteDatabaseLockedException -> 0x00ae, SQLiteException -> 0x004f, all -> 0x004d }
            a.d.a.a.i.b.z3 r15 = r15.f     // Catch:{ SQLiteFullException -> 0x0051, SQLiteDatabaseLockedException -> 0x00ae, SQLiteException -> 0x004f, all -> 0x004d }
            java.lang.String r4 = "Data loss, local db full"
            r15.a(r4)     // Catch:{ SQLiteFullException -> 0x0051, SQLiteDatabaseLockedException -> 0x00ae, SQLiteException -> 0x004f, all -> 0x004d }
            long r13 = r13 - r10
            r10 = 1
            long r13 = r13 + r10
            java.lang.String r4 = "rowid in (select rowid from messages order by rowid asc limit ?)"
            java.lang.String[] r10 = new java.lang.String[r8]     // Catch:{ SQLiteFullException -> 0x0051, SQLiteDatabaseLockedException -> 0x00ae, SQLiteException -> 0x004f, all -> 0x004d }
            java.lang.String r11 = java.lang.Long.toString(r13)     // Catch:{ SQLiteFullException -> 0x0051, SQLiteDatabaseLockedException -> 0x00ae, SQLiteException -> 0x004f, all -> 0x004d }
            r10[r2] = r11     // Catch:{ SQLiteFullException -> 0x0051, SQLiteDatabaseLockedException -> 0x00ae, SQLiteException -> 0x004f, all -> 0x004d }
            int r4 = r9.delete(r0, r4, r10)     // Catch:{ SQLiteFullException -> 0x0051, SQLiteDatabaseLockedException -> 0x00ae, SQLiteException -> 0x004f, all -> 0x004d }
            long r10 = (long) r4     // Catch:{ SQLiteFullException -> 0x0051, SQLiteDatabaseLockedException -> 0x00ae, SQLiteException -> 0x004f, all -> 0x004d }
            int r4 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x0096
            a.d.a.a.i.b.x3 r4 = r16.i()     // Catch:{ SQLiteFullException -> 0x0051, SQLiteDatabaseLockedException -> 0x00ae, SQLiteException -> 0x004f, all -> 0x004d }
            a.d.a.a.i.b.z3 r4 = r4.f     // Catch:{ SQLiteFullException -> 0x0051, SQLiteDatabaseLockedException -> 0x00ae, SQLiteException -> 0x004f, all -> 0x004d }
            java.lang.String r15 = "Different delete count than expected in local db. expected, received, difference"
            java.lang.Long r2 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteFullException -> 0x0051, SQLiteDatabaseLockedException -> 0x00ae, SQLiteException -> 0x004f, all -> 0x004d }
            java.lang.Long r8 = java.lang.Long.valueOf(r10)     // Catch:{ SQLiteFullException -> 0x0051, SQLiteDatabaseLockedException -> 0x00ae, SQLiteException -> 0x004f, all -> 0x004d }
            long r13 = r13 - r10
            java.lang.Long r10 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteFullException -> 0x0051, SQLiteDatabaseLockedException -> 0x00ae, SQLiteException -> 0x004f, all -> 0x004d }
            r4.d(r15, r2, r8, r10)     // Catch:{ SQLiteFullException -> 0x0051, SQLiteDatabaseLockedException -> 0x00ae, SQLiteException -> 0x004f, all -> 0x004d }
        L_0x0096:
            r9.insertOrThrow(r0, r7, r3)     // Catch:{ SQLiteFullException -> 0x0051, SQLiteDatabaseLockedException -> 0x00ae, SQLiteException -> 0x004f, all -> 0x004d }
            r9.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0051, SQLiteDatabaseLockedException -> 0x00ae, SQLiteException -> 0x004f, all -> 0x004d }
            r9.endTransaction()     // Catch:{ SQLiteFullException -> 0x0051, SQLiteDatabaseLockedException -> 0x00ae, SQLiteException -> 0x004f, all -> 0x004d }
            if (r12 == 0) goto L_0x00a4
            r12.close()
        L_0x00a4:
            r9.close()
            r2 = 1
            return r2
        L_0x00a9:
            r7 = r12
            goto L_0x0117
        L_0x00ac:
            r7 = r12
            goto L_0x00b6
        L_0x00ae:
            r7 = r12
            goto L_0x00e9
        L_0x00b0:
            r7 = r12
            goto L_0x00f9
        L_0x00b2:
            r0 = move-exception
            goto L_0x0117
        L_0x00b5:
            r0 = move-exception
        L_0x00b6:
            r2 = r7
            r7 = r9
            goto L_0x00c0
        L_0x00b9:
            r0 = move-exception
            goto L_0x00f9
        L_0x00bb:
            r0 = move-exception
            r9 = r7
            goto L_0x0117
        L_0x00be:
            r0 = move-exception
            r2 = r7
        L_0x00c0:
            if (r7 == 0) goto L_0x00cb
            boolean r4 = r7.inTransaction()     // Catch:{ all -> 0x00e4 }
            if (r4 == 0) goto L_0x00cb
            r7.endTransaction()     // Catch:{ all -> 0x00e4 }
        L_0x00cb:
            a.d.a.a.i.b.x3 r4 = r16.i()     // Catch:{ all -> 0x00e4 }
            a.d.a.a.i.b.z3 r4 = r4.f     // Catch:{ all -> 0x00e4 }
            java.lang.String r8 = "Error writing entry to local database"
            r4.b(r8, r0)     // Catch:{ all -> 0x00e4 }
            r4 = 1
            r1.f2528d = r4     // Catch:{ all -> 0x00e4 }
            if (r2 == 0) goto L_0x00de
            r2.close()
        L_0x00de:
            if (r7 == 0) goto L_0x0111
            r7.close()
            goto L_0x0111
        L_0x00e4:
            r0 = move-exception
            r9 = r7
            r7 = r2
            goto L_0x0117
        L_0x00e8:
            r9 = r7
        L_0x00e9:
            long r10 = (long) r6
            android.os.SystemClock.sleep(r10)     // Catch:{ all -> 0x00b2 }
            int r6 = r6 + 20
            if (r7 == 0) goto L_0x00f4
            r7.close()
        L_0x00f4:
            if (r9 == 0) goto L_0x0111
            goto L_0x010e
        L_0x00f7:
            r0 = move-exception
            r9 = r7
        L_0x00f9:
            a.d.a.a.i.b.x3 r2 = r16.i()     // Catch:{ all -> 0x00b2 }
            a.d.a.a.i.b.z3 r2 = r2.f     // Catch:{ all -> 0x00b2 }
            java.lang.String r4 = "Error writing entry; local database full"
            r2.b(r4, r0)     // Catch:{ all -> 0x00b2 }
            r2 = 1
            r1.f2528d = r2     // Catch:{ all -> 0x00b2 }
            if (r7 == 0) goto L_0x010c
            r7.close()
        L_0x010c:
            if (r9 == 0) goto L_0x0111
        L_0x010e:
            r9.close()
        L_0x0111:
            int r5 = r5 + 1
            r2 = 0
            r4 = 5
            goto L_0x0023
        L_0x0117:
            if (r7 == 0) goto L_0x011c
            r7.close()
        L_0x011c:
            if (r9 == 0) goto L_0x0121
            r9.close()
        L_0x0121:
            throw r0
        L_0x0122:
            a.d.a.a.i.b.x3 r0 = r16.i()
            a.d.a.a.i.b.z3 r0 = r0.n
            java.lang.String r2 = "Failed to write entry to local database"
            r0.a(r2)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.t3.z(int, byte[]):boolean");
    }
}
