package a.d.a.a.h.f;

import a.a.a.a.a;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

public final class q extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f1550a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(p pVar, Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.f1550a = pVar;
    }

    public static Set<String> b(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        Cursor rawQuery = sQLiteDatabase.rawQuery(a.d(str.length() + 22, "SELECT * FROM ", str, " LIMIT 0"), (String[]) null);
        try {
            String[] columnNames = rawQuery.getColumnNames();
            for (String add : columnNames) {
                hashSet.add(add);
            }
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    public final boolean a(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor = null;
        try {
            Cursor query = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, (String) null, (String) null, (String) null);
            boolean moveToFirst = query.moveToFirst();
            query.close();
            return moveToFirst;
        } catch (SQLiteException e2) {
            this.f1550a.f("Error querying for table", str, e2);
            if (cursor != null) {
                cursor.close();
            }
            return false;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final SQLiteDatabase getWritableDatabase() {
        if (this.f1550a.f1547e.b(3600000)) {
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException unused) {
                this.f1550a.f1547e.a();
                this.f1550a.q("Opening the database failed, dropping the table and recreating it");
                this.f1550a.f1490a.f1503a.getDatabasePath("google_analytics_v4.db").delete();
                try {
                    SQLiteDatabase writableDatabase = super.getWritableDatabase();
                    this.f1550a.f1547e.f1489b = 0;
                    return writableDatabase;
                } catch (SQLiteException e2) {
                    this.f1550a.n("Failed to open freshly created database", e2);
                    throw e2;
                }
            }
        } else {
            throw new SQLiteException("Database open failed");
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        int i;
        String path = sQLiteDatabase.getPath();
        try {
            i = Integer.parseInt(Build.VERSION.SDK);
        } catch (NumberFormatException unused) {
            String str = "Invalid version number";
            String str2 = Build.VERSION.SDK;
            r0 r0Var = r0.f1553c;
            if (r0Var != null) {
                r0Var.n(str, str2);
            } else {
                if (q0.f1551a.f1481a <= 3) {
                    if (str2 != null) {
                        str = a.d(str2.length() + 23, str, ":", str2);
                    }
                    Log.e((String) i0.f1511b.f1517a, str);
                }
            }
            i = 0;
        }
        if (i >= 9) {
            File file = new File(path);
            file.setReadable(false, false);
            file.setWritable(false, false);
            file.setReadable(true, true);
            file.setWritable(true, true);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0079  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onOpen(android.database.sqlite.SQLiteDatabase r11) {
        /*
            r10 = this;
            java.lang.String r0 = "hits2"
            boolean r1 = r10.a(r11, r0)
            r2 = 3
            r3 = 2
            r4 = 4
            r5 = 0
            r6 = 1
            if (r1 != 0) goto L_0x0013
            java.lang.String r0 = a.d.a.a.h.f.p.f
        L_0x000f:
            r11.execSQL(r0)
            goto L_0x006b
        L_0x0013:
            java.util.Set r0 = b(r11, r0)
            java.lang.String[] r1 = new java.lang.String[r4]
            java.lang.String r7 = "hit_id"
            r1[r5] = r7
            java.lang.String r7 = "hit_string"
            r1[r6] = r7
            java.lang.String r7 = "hit_time"
            r1[r3] = r7
            java.lang.String r7 = "hit_url"
            r1[r2] = r7
            r7 = 0
        L_0x002a:
            if (r7 >= r4) goto L_0x0057
            r8 = r1[r7]
            r9 = r0
            java.util.HashSet r9 = (java.util.HashSet) r9
            boolean r9 = r9.remove(r8)
            if (r9 != 0) goto L_0x0054
            android.database.sqlite.SQLiteException r11 = new android.database.sqlite.SQLiteException
            java.lang.String r0 = "Database hits2 is missing required column: "
            java.lang.String r1 = java.lang.String.valueOf(r8)
            int r2 = r1.length()
            if (r2 == 0) goto L_0x004a
            java.lang.String r0 = r0.concat(r1)
            goto L_0x0050
        L_0x004a:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r0)
            r0 = r1
        L_0x0050:
            r11.<init>(r0)
            throw r11
        L_0x0054:
            int r7 = r7 + 1
            goto L_0x002a
        L_0x0057:
            java.util.HashSet r0 = (java.util.HashSet) r0
            java.lang.String r1 = "hit_app_id"
            boolean r1 = r0.remove(r1)
            r1 = r1 ^ r6
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x00d7
            if (r1 == 0) goto L_0x006b
            java.lang.String r0 = "ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER"
            goto L_0x000f
        L_0x006b:
            java.lang.String r0 = "properties"
            boolean r1 = r10.a(r11, r0)
            if (r1 != 0) goto L_0x0079
            java.lang.String r0 = "CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;"
            r11.execSQL(r0)
            return
        L_0x0079:
            java.util.Set r11 = b(r11, r0)
            r0 = 6
            java.lang.String[] r1 = new java.lang.String[r0]
            java.lang.String r7 = "app_uid"
            r1[r5] = r7
            java.lang.String r7 = "cid"
            r1[r6] = r7
            java.lang.String r6 = "tid"
            r1[r3] = r6
            java.lang.String r3 = "params"
            r1[r2] = r3
            java.lang.String r2 = "adid"
            r1[r4] = r2
            r2 = 5
            java.lang.String r3 = "hits_count"
            r1[r2] = r3
        L_0x0099:
            if (r5 >= r0) goto L_0x00c6
            r2 = r1[r5]
            r3 = r11
            java.util.HashSet r3 = (java.util.HashSet) r3
            boolean r3 = r3.remove(r2)
            if (r3 != 0) goto L_0x00c3
            android.database.sqlite.SQLiteException r11 = new android.database.sqlite.SQLiteException
            java.lang.String r0 = "Database properties is missing required column: "
            java.lang.String r1 = java.lang.String.valueOf(r2)
            int r2 = r1.length()
            if (r2 == 0) goto L_0x00b9
            java.lang.String r0 = r0.concat(r1)
            goto L_0x00bf
        L_0x00b9:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r0)
            r0 = r1
        L_0x00bf:
            r11.<init>(r0)
            throw r11
        L_0x00c3:
            int r5 = r5 + 1
            goto L_0x0099
        L_0x00c6:
            java.util.HashSet r11 = (java.util.HashSet) r11
            boolean r11 = r11.isEmpty()
            if (r11 == 0) goto L_0x00cf
            return
        L_0x00cf:
            android.database.sqlite.SQLiteException r11 = new android.database.sqlite.SQLiteException
            java.lang.String r0 = "Database properties table has extra columns"
            r11.<init>(r0)
            throw r11
        L_0x00d7:
            android.database.sqlite.SQLiteException r11 = new android.database.sqlite.SQLiteException
            java.lang.String r0 = "Database hits2 has extra columns"
            r11.<init>(r0)
            goto L_0x00e0
        L_0x00df:
            throw r11
        L_0x00e0:
            goto L_0x00df
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.f.q.onOpen(android.database.sqlite.SQLiteDatabase):void");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
