package a.d.a.a.i.b;

import a.a.a.a.a;
import a.c.a.f.b;
import a.d.a.a.e.q.c;
import a.d.a.a.h.g.b1;
import a.d.a.a.h.g.i0;
import a.d.a.a.h.g.jb;
import a.d.a.a.h.g.l0;
import a.d.a.a.h.g.t9;
import a.d.a.a.h.g.x0;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.measurement.internal.zzw;
import com.tutk.IOTC.AVFrame;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class d extends m9 {
    public static final String[] f = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    public static final String[] g = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    public static final String[] h = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;"};
    public static final String[] i = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    public static final String[] j = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    public static final String[] k = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    public static final String[] l = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    public static final String[] m = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};

    /* renamed from: d  reason: collision with root package name */
    public final g f2142d = new g(this, this.f2563a.f2123a, "google_app_measurement.db");

    /* renamed from: e  reason: collision with root package name */
    public final i9 f2143e = new i9(this.f2563a.n);

    public d(o9 o9Var) {
        super(o9Var);
    }

    @WorkerThread
    public static void G(ContentValues contentValues, String str, Object obj) {
        b.h(str);
        b.k(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    @WorkerThread
    public final Object A(Cursor cursor, int i2) {
        int type = cursor.getType(i2);
        if (type == 0) {
            i().f.a("Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i2));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i2));
            }
            if (type == 3) {
                return cursor.getString(i2);
            }
            if (type != 4) {
                i().f.b("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            i().f.a("Loaded invalid blob type value, ignoring it");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String B(long r5) {
        /*
            r4 = this;
            r4.b()
            r4.n()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.t()     // Catch:{ SQLiteException -> 0x003c, all -> 0x003a }
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x003c, all -> 0x003a }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x003c, all -> 0x003a }
            r6 = 0
            r3[r6] = r5     // Catch:{ SQLiteException -> 0x003c, all -> 0x003a }
            android.database.Cursor r5 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x003c, all -> 0x003a }
            boolean r1 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0038 }
            if (r1 != 0) goto L_0x0030
            a.d.a.a.i.b.x3 r6 = r4.i()     // Catch:{ SQLiteException -> 0x0038 }
            a.d.a.a.i.b.z3 r6 = r6.n     // Catch:{ SQLiteException -> 0x0038 }
            java.lang.String r1 = "No expired configs for apps with pending events"
            r6.a(r1)     // Catch:{ SQLiteException -> 0x0038 }
            r5.close()
            return r0
        L_0x0030:
            java.lang.String r6 = r5.getString(r6)     // Catch:{ SQLiteException -> 0x0038 }
            r5.close()
            return r6
        L_0x0038:
            r6 = move-exception
            goto L_0x003e
        L_0x003a:
            r6 = move-exception
            goto L_0x0051
        L_0x003c:
            r6 = move-exception
            r5 = r0
        L_0x003e:
            a.d.a.a.i.b.x3 r1 = r4.i()     // Catch:{ all -> 0x004f }
            a.d.a.a.i.b.z3 r1 = r1.f     // Catch:{ all -> 0x004f }
            java.lang.String r2 = "Error selecting expired configs"
            r1.b(r2, r6)     // Catch:{ all -> 0x004f }
            if (r5 == 0) goto L_0x004e
            r5.close()
        L_0x004e:
            return r0
        L_0x004f:
            r6 = move-exception
            r0 = r5
        L_0x0051:
            if (r0 == 0) goto L_0x0056
            r0.close()
        L_0x0056:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.d.B(long):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c4 A[Catch:{ all -> 0x00d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d9  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<a.d.a.a.i.b.w9> C(java.lang.String r21) {
        /*
            r20 = this;
            r1 = r20
            r9 = r21
            a.c.a.f.b.h(r21)
            r20.b()
            r20.n()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r11 = r20.t()     // Catch:{ SQLiteException -> 0x00a1, all -> 0x009e }
            java.lang.String r12 = "user_attributes"
            r2 = 4
            java.lang.String[] r13 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00a1, all -> 0x009e }
            java.lang.String r2 = "name"
            r8 = 0
            r13[r8] = r2     // Catch:{ SQLiteException -> 0x00a1, all -> 0x009e }
            java.lang.String r2 = "origin"
            r6 = 1
            r13[r6] = r2     // Catch:{ SQLiteException -> 0x00a1, all -> 0x009e }
            java.lang.String r2 = "set_timestamp"
            r7 = 2
            r13[r7] = r2     // Catch:{ SQLiteException -> 0x00a1, all -> 0x009e }
            java.lang.String r2 = "value"
            r5 = 3
            r13[r5] = r2     // Catch:{ SQLiteException -> 0x00a1, all -> 0x009e }
            java.lang.String r14 = "app_id=?"
            java.lang.String[] r15 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x00a1, all -> 0x009e }
            r15[r8] = r9     // Catch:{ SQLiteException -> 0x00a1, all -> 0x009e }
            r16 = 0
            r17 = 0
            java.lang.String r18 = "rowid"
            java.lang.String r19 = "1000"
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ SQLiteException -> 0x00a1, all -> 0x009e }
            boolean r2 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x009c }
            if (r2 != 0) goto L_0x004b
            r11.close()
            return r0
        L_0x004b:
            java.lang.String r12 = r11.getString(r8)     // Catch:{ SQLiteException -> 0x009c }
            java.lang.String r2 = r11.getString(r6)     // Catch:{ SQLiteException -> 0x009c }
            if (r2 != 0) goto L_0x0057
            java.lang.String r2 = ""
        L_0x0057:
            r4 = r2
            long r13 = r11.getLong(r7)     // Catch:{ SQLiteException -> 0x009c }
            java.lang.Object r15 = r1.A(r11, r5)     // Catch:{ SQLiteException -> 0x009c }
            if (r15 != 0) goto L_0x0078
            a.d.a.a.i.b.x3 r2 = r20.i()     // Catch:{ SQLiteException -> 0x009c }
            a.d.a.a.i.b.z3 r2 = r2.f     // Catch:{ SQLiteException -> 0x009c }
            java.lang.String r3 = "Read invalid user property value, ignoring it. appId"
            java.lang.Object r4 = a.d.a.a.i.b.x3.s(r21)     // Catch:{ SQLiteException -> 0x009c }
            r2.b(r3, r4)     // Catch:{ SQLiteException -> 0x009c }
            r12 = 2
            r13 = 0
            r17 = 3
            r18 = 1
            goto L_0x008d
        L_0x0078:
            a.d.a.a.i.b.w9 r3 = new a.d.a.a.i.b.w9     // Catch:{ SQLiteException -> 0x009c }
            r2 = r3
            r10 = r3
            r3 = r21
            r17 = 3
            r5 = r12
            r12 = 2
            r18 = 1
            r6 = r13
            r13 = 0
            r8 = r15
            r2.<init>(r3, r4, r5, r6, r8)     // Catch:{ SQLiteException -> 0x009c }
            r0.add(r10)     // Catch:{ SQLiteException -> 0x009c }
        L_0x008d:
            boolean r2 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x009c }
            if (r2 != 0) goto L_0x0097
            r11.close()
            return r0
        L_0x0097:
            r5 = 3
            r6 = 1
            r7 = 2
            r8 = 0
            goto L_0x004b
        L_0x009c:
            r0 = move-exception
            goto L_0x00a3
        L_0x009e:
            r0 = move-exception
            r10 = 0
            goto L_0x00d7
        L_0x00a1:
            r0 = move-exception
            r11 = 0
        L_0x00a3:
            a.d.a.a.i.b.x3 r2 = r20.i()     // Catch:{ all -> 0x00d5 }
            a.d.a.a.i.b.z3 r2 = r2.f     // Catch:{ all -> 0x00d5 }
            java.lang.String r3 = "Error querying user properties. appId"
            java.lang.Object r4 = a.d.a.a.i.b.x3.s(r21)     // Catch:{ all -> 0x00d5 }
            r2.c(r3, r4, r0)     // Catch:{ all -> 0x00d5 }
            boolean r0 = a.d.a.a.h.g.ra.b()     // Catch:{ all -> 0x00d5 }
            if (r0 == 0) goto L_0x00ce
            a.d.a.a.i.b.c5 r0 = r1.f2563a     // Catch:{ all -> 0x00d5 }
            a.d.a.a.i.b.ka r0 = r0.g     // Catch:{ all -> 0x00d5 }
            a.d.a.a.i.b.n3<java.lang.Boolean> r2 = a.d.a.a.i.b.q.N0     // Catch:{ all -> 0x00d5 }
            boolean r0 = r0.t(r9, r2)     // Catch:{ all -> 0x00d5 }
            if (r0 == 0) goto L_0x00ce
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x00d5 }
            if (r11 == 0) goto L_0x00cd
            r11.close()
        L_0x00cd:
            return r0
        L_0x00ce:
            if (r11 == 0) goto L_0x00d3
            r11.close()
        L_0x00d3:
            r2 = 0
            return r2
        L_0x00d5:
            r0 = move-exception
            r10 = r11
        L_0x00d7:
            if (r10 == 0) goto L_0x00dc
            r10.close()
        L_0x00dc:
            goto L_0x00de
        L_0x00dd:
            throw r0
        L_0x00de:
            goto L_0x00dd
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.d.C(java.lang.String):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c6 A[LOOP:0: B:17:0x005a->B:40:0x00c6, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00c8 A[EDGE_INSN: B:53:0x00c8->B:41:0x00c8 ?: BREAK  , SYNTHETIC] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<android.util.Pair<a.d.a.a.h.g.b1, java.lang.Long>> D(java.lang.String r16, int r17, int r18) {
        /*
            r15 = this;
            r1 = r18
            r15.b()
            r15.n()
            r2 = 1
            r3 = 0
            if (r17 <= 0) goto L_0x000e
            r0 = 1
            goto L_0x000f
        L_0x000e:
            r0 = 0
        L_0x000f:
            a.c.a.f.b.d(r0)
            if (r1 <= 0) goto L_0x0016
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            a.c.a.f.b.d(r0)
            a.c.a.f.b.h(r16)
            r4 = 0
            android.database.sqlite.SQLiteDatabase r5 = r15.t()     // Catch:{ SQLiteException -> 0x00ce }
            java.lang.String r6 = "queue"
            r0 = 3
            java.lang.String[] r7 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x00ce }
            java.lang.String r0 = "rowid"
            r7[r3] = r0     // Catch:{ SQLiteException -> 0x00ce }
            java.lang.String r0 = "data"
            r7[r2] = r0     // Catch:{ SQLiteException -> 0x00ce }
            java.lang.String r0 = "retry_count"
            r14 = 2
            r7[r14] = r0     // Catch:{ SQLiteException -> 0x00ce }
            java.lang.String r8 = "app_id=?"
            java.lang.String[] r9 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00ce }
            r9[r3] = r16     // Catch:{ SQLiteException -> 0x00ce }
            r10 = 0
            r11 = 0
            java.lang.String r12 = "rowid"
            java.lang.String r13 = java.lang.String.valueOf(r17)     // Catch:{ SQLiteException -> 0x00ce }
            android.database.Cursor r4 = r5.query(r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ SQLiteException -> 0x00ce }
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x00ce }
            if (r0 != 0) goto L_0x0054
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ SQLiteException -> 0x00ce }
            r4.close()
            return r0
        L_0x0054:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x00ce }
            r5.<init>()     // Catch:{ SQLiteException -> 0x00ce }
            r6 = 0
        L_0x005a:
            long r7 = r4.getLong(r3)     // Catch:{ SQLiteException -> 0x00ce }
            byte[] r0 = r4.getBlob(r2)     // Catch:{ IOException -> 0x00b2 }
            a.d.a.a.i.b.s9 r9 = r15.l()     // Catch:{ IOException -> 0x00b2 }
            byte[] r0 = r9.S(r0)     // Catch:{ IOException -> 0x00b2 }
            boolean r9 = r5.isEmpty()     // Catch:{ SQLiteException -> 0x00ce }
            if (r9 != 0) goto L_0x0074
            int r9 = r0.length     // Catch:{ SQLiteException -> 0x00ce }
            int r9 = r9 + r6
            if (r9 > r1) goto L_0x00c8
        L_0x0074:
            a.d.a.a.h.g.b1$a r9 = a.d.a.a.h.g.b1.C()     // Catch:{ IOException -> 0x00a1 }
            a.d.a.a.h.g.h7 r9 = a.d.a.a.i.b.s9.x(r9, r0)     // Catch:{ IOException -> 0x00a1 }
            a.d.a.a.h.g.b1$a r9 = (a.d.a.a.h.g.b1.a) r9     // Catch:{ IOException -> 0x00a1 }
            boolean r10 = r4.isNull(r14)     // Catch:{ SQLiteException -> 0x00ce }
            if (r10 != 0) goto L_0x008b
            int r10 = r4.getInt(r14)     // Catch:{ SQLiteException -> 0x00ce }
            r9.e0(r10)     // Catch:{ SQLiteException -> 0x00ce }
        L_0x008b:
            int r0 = r0.length     // Catch:{ SQLiteException -> 0x00ce }
            int r6 = r6 + r0
            a.d.a.a.h.g.i7 r0 = r9.m()     // Catch:{ SQLiteException -> 0x00ce }
            a.d.a.a.h.g.y5 r0 = (a.d.a.a.h.g.y5) r0     // Catch:{ SQLiteException -> 0x00ce }
            a.d.a.a.h.g.b1 r0 = (a.d.a.a.h.g.b1) r0     // Catch:{ SQLiteException -> 0x00ce }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ SQLiteException -> 0x00ce }
            android.util.Pair r0 = android.util.Pair.create(r0, r7)     // Catch:{ SQLiteException -> 0x00ce }
            r5.add(r0)     // Catch:{ SQLiteException -> 0x00ce }
            goto L_0x00c0
        L_0x00a1:
            r0 = move-exception
            a.d.a.a.i.b.x3 r7 = r15.i()     // Catch:{ SQLiteException -> 0x00ce }
            a.d.a.a.i.b.z3 r7 = r7.f     // Catch:{ SQLiteException -> 0x00ce }
            java.lang.String r8 = "Failed to merge queued bundle. appId"
            java.lang.Object r9 = a.d.a.a.i.b.x3.s(r16)     // Catch:{ SQLiteException -> 0x00ce }
        L_0x00ae:
            r7.c(r8, r9, r0)     // Catch:{ SQLiteException -> 0x00ce }
            goto L_0x00c0
        L_0x00b2:
            r0 = move-exception
            a.d.a.a.i.b.x3 r7 = r15.i()     // Catch:{ SQLiteException -> 0x00ce }
            a.d.a.a.i.b.z3 r7 = r7.f     // Catch:{ SQLiteException -> 0x00ce }
            java.lang.String r8 = "Failed to unzip queued bundle. appId"
            java.lang.Object r9 = a.d.a.a.i.b.x3.s(r16)     // Catch:{ SQLiteException -> 0x00ce }
            goto L_0x00ae
        L_0x00c0:
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x00ce }
            if (r0 == 0) goto L_0x00c8
            if (r6 <= r1) goto L_0x005a
        L_0x00c8:
            r4.close()
            return r5
        L_0x00cc:
            r0 = move-exception
            goto L_0x00e8
        L_0x00ce:
            r0 = move-exception
            a.d.a.a.i.b.x3 r1 = r15.i()     // Catch:{ all -> 0x00cc }
            a.d.a.a.i.b.z3 r1 = r1.f     // Catch:{ all -> 0x00cc }
            java.lang.String r2 = "Error querying bundles. appId"
            java.lang.Object r3 = a.d.a.a.i.b.x3.s(r16)     // Catch:{ all -> 0x00cc }
            r1.c(r2, r3, r0)     // Catch:{ all -> 0x00cc }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x00cc }
            if (r4 == 0) goto L_0x00e7
            r4.close()
        L_0x00e7:
            return r0
        L_0x00e8:
            if (r4 == 0) goto L_0x00ed
            r4.close()
        L_0x00ed:
            goto L_0x00ef
        L_0x00ee:
            throw r0
        L_0x00ef:
            goto L_0x00ee
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.d.D(java.lang.String, int, int):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0107, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0109, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x010a, code lost:
        r4 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x012e, code lost:
        r0 = java.util.Collections.emptyList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0132, code lost:
        if (r12 != null) goto L_0x0134;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0134, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0137, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0138, code lost:
        if (r12 != null) goto L_0x013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x013a, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x013d, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0142, code lost:
        r10.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0107 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0013] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x012e A[Catch:{ all -> 0x013e }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0142  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<a.d.a.a.i.b.w9> E(java.lang.String r22, java.lang.String r23, java.lang.String r24) {
        /*
            r21 = this;
            r1 = r21
            r9 = r22
            a.c.a.f.b.h(r22)
            r21.b()
            r21.n()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r10 = 0
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0109, all -> 0x0107 }
            r11 = 3
            r2.<init>(r11)     // Catch:{ SQLiteException -> 0x0109, all -> 0x0107 }
            r2.add(r9)     // Catch:{ SQLiteException -> 0x0109, all -> 0x0107 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0109, all -> 0x0107 }
            java.lang.String r4 = "app_id=?"
            r3.<init>(r4)     // Catch:{ SQLiteException -> 0x0109, all -> 0x0107 }
            boolean r4 = android.text.TextUtils.isEmpty(r23)     // Catch:{ SQLiteException -> 0x0109, all -> 0x0107 }
            if (r4 != 0) goto L_0x0034
            r4 = r23
            r2.add(r4)     // Catch:{ SQLiteException -> 0x0105, all -> 0x0107 }
            java.lang.String r5 = " and origin=?"
            r3.append(r5)     // Catch:{ SQLiteException -> 0x0105, all -> 0x0107 }
            goto L_0x0036
        L_0x0034:
            r4 = r23
        L_0x0036:
            boolean r5 = android.text.TextUtils.isEmpty(r24)     // Catch:{ SQLiteException -> 0x0105, all -> 0x0107 }
            if (r5 != 0) goto L_0x004e
            java.lang.String r5 = java.lang.String.valueOf(r24)     // Catch:{ SQLiteException -> 0x0105, all -> 0x0107 }
            java.lang.String r6 = "*"
            java.lang.String r5 = r5.concat(r6)     // Catch:{ SQLiteException -> 0x0105, all -> 0x0107 }
            r2.add(r5)     // Catch:{ SQLiteException -> 0x0105, all -> 0x0107 }
            java.lang.String r5 = " and name glob ?"
            r3.append(r5)     // Catch:{ SQLiteException -> 0x0105, all -> 0x0107 }
        L_0x004e:
            int r5 = r2.size()     // Catch:{ SQLiteException -> 0x0105, all -> 0x0107 }
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0105, all -> 0x0107 }
            java.lang.Object[] r2 = r2.toArray(r5)     // Catch:{ SQLiteException -> 0x0105, all -> 0x0107 }
            r16 = r2
            java.lang.String[] r16 = (java.lang.String[]) r16     // Catch:{ SQLiteException -> 0x0105, all -> 0x0107 }
            android.database.sqlite.SQLiteDatabase r12 = r21.t()     // Catch:{ SQLiteException -> 0x0105, all -> 0x0107 }
            java.lang.String r13 = "user_attributes"
            r2 = 4
            java.lang.String[] r14 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0105, all -> 0x0107 }
            java.lang.String r2 = "name"
            r8 = 0
            r14[r8] = r2     // Catch:{ SQLiteException -> 0x0105, all -> 0x0107 }
            java.lang.String r2 = "set_timestamp"
            r6 = 1
            r14[r6] = r2     // Catch:{ SQLiteException -> 0x0105, all -> 0x0107 }
            java.lang.String r2 = "value"
            r7 = 2
            r14[r7] = r2     // Catch:{ SQLiteException -> 0x0105, all -> 0x0107 }
            java.lang.String r2 = "origin"
            r14[r11] = r2     // Catch:{ SQLiteException -> 0x0105, all -> 0x0107 }
            java.lang.String r15 = r3.toString()     // Catch:{ SQLiteException -> 0x0105, all -> 0x0107 }
            r17 = 0
            r18 = 0
            java.lang.String r19 = "rowid"
            java.lang.String r20 = "1001"
            android.database.Cursor r12 = r12.query(r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ SQLiteException -> 0x0105, all -> 0x0107 }
            boolean r2 = r12.moveToFirst()     // Catch:{ SQLiteException -> 0x0103 }
            if (r2 != 0) goto L_0x0092
            r12.close()
            return r0
        L_0x0092:
            int r2 = r0.size()     // Catch:{ SQLiteException -> 0x0103 }
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r2 < r3) goto L_0x00aa
            a.d.a.a.i.b.x3 r2 = r21.i()     // Catch:{ SQLiteException -> 0x0103 }
            a.d.a.a.i.b.z3 r2 = r2.f     // Catch:{ SQLiteException -> 0x0103 }
            java.lang.String r5 = "Read more than the max allowed user properties, ignoring excess"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0103 }
            r2.b(r5, r3)     // Catch:{ SQLiteException -> 0x0103 }
            goto L_0x00f0
        L_0x00aa:
            java.lang.String r5 = r12.getString(r8)     // Catch:{ SQLiteException -> 0x0103 }
            long r13 = r12.getLong(r6)     // Catch:{ SQLiteException -> 0x0103 }
            java.lang.Object r15 = r1.A(r12, r7)     // Catch:{ SQLiteException -> 0x0103 }
            java.lang.String r4 = r12.getString(r11)     // Catch:{ SQLiteException -> 0x0103 }
            if (r15 != 0) goto L_0x00d5
            a.d.a.a.i.b.x3 r2 = r21.i()     // Catch:{ SQLiteException -> 0x0103 }
            a.d.a.a.i.b.z3 r2 = r2.f     // Catch:{ SQLiteException -> 0x0103 }
            java.lang.String r3 = "(2)Read invalid user property value, ignoring it"
            java.lang.Object r5 = a.d.a.a.i.b.x3.s(r22)     // Catch:{ SQLiteException -> 0x0103 }
            r13 = r24
            r2.d(r3, r5, r4, r13)     // Catch:{ SQLiteException -> 0x0103 }
            r17 = r4
            r13 = 0
            r18 = 2
            r19 = 1
            goto L_0x00ea
        L_0x00d5:
            a.d.a.a.i.b.w9 r3 = new a.d.a.a.i.b.w9     // Catch:{ SQLiteException -> 0x00ff }
            r2 = r3
            r11 = r3
            r3 = r22
            r17 = r4
            r18 = 2
            r19 = 1
            r6 = r13
            r13 = 0
            r8 = r15
            r2.<init>(r3, r4, r5, r6, r8)     // Catch:{ SQLiteException -> 0x00fb }
            r0.add(r11)     // Catch:{ SQLiteException -> 0x00fb }
        L_0x00ea:
            boolean r2 = r12.moveToNext()     // Catch:{ SQLiteException -> 0x00fb }
            if (r2 != 0) goto L_0x00f4
        L_0x00f0:
            r12.close()
            return r0
        L_0x00f4:
            r4 = r17
            r6 = 1
            r7 = 2
            r8 = 0
            r11 = 3
            goto L_0x0092
        L_0x00fb:
            r0 = move-exception
            r4 = r17
            goto L_0x010d
        L_0x00ff:
            r0 = move-exception
            r17 = r4
            goto L_0x010d
        L_0x0103:
            r0 = move-exception
            goto L_0x010d
        L_0x0105:
            r0 = move-exception
            goto L_0x010c
        L_0x0107:
            r0 = move-exception
            goto L_0x0140
        L_0x0109:
            r0 = move-exception
            r4 = r23
        L_0x010c:
            r12 = r10
        L_0x010d:
            a.d.a.a.i.b.x3 r2 = r21.i()     // Catch:{ all -> 0x013e }
            a.d.a.a.i.b.z3 r2 = r2.f     // Catch:{ all -> 0x013e }
            java.lang.String r3 = "(2)Error querying user properties"
            java.lang.Object r5 = a.d.a.a.i.b.x3.s(r22)     // Catch:{ all -> 0x013e }
            r2.d(r3, r5, r4, r0)     // Catch:{ all -> 0x013e }
            boolean r0 = a.d.a.a.h.g.ra.b()     // Catch:{ all -> 0x013e }
            if (r0 == 0) goto L_0x0138
            a.d.a.a.i.b.c5 r0 = r1.f2563a     // Catch:{ all -> 0x013e }
            a.d.a.a.i.b.ka r0 = r0.g     // Catch:{ all -> 0x013e }
            a.d.a.a.i.b.n3<java.lang.Boolean> r2 = a.d.a.a.i.b.q.N0     // Catch:{ all -> 0x013e }
            boolean r0 = r0.t(r9, r2)     // Catch:{ all -> 0x013e }
            if (r0 == 0) goto L_0x0138
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x013e }
            if (r12 == 0) goto L_0x0137
            r12.close()
        L_0x0137:
            return r0
        L_0x0138:
            if (r12 == 0) goto L_0x013d
            r12.close()
        L_0x013d:
            return r10
        L_0x013e:
            r0 = move-exception
            r10 = r12
        L_0x0140:
            if (r10 == 0) goto L_0x0145
            r10.close()
        L_0x0145:
            goto L_0x0147
        L_0x0146:
            throw r0
        L_0x0147:
            goto L_0x0146
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.d.E(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x016d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.zzw> F(java.lang.String r40, java.lang.String[] r41) {
        /*
            r39 = this;
            r39.b()
            r39.n()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r2 = r39.t()     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            java.lang.String r3 = "conditional_properties"
            r4 = 13
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            java.lang.String r5 = "app_id"
            r11 = 0
            r4[r11] = r5     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            java.lang.String r5 = "origin"
            r12 = 1
            r4[r12] = r5     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            java.lang.String r5 = "name"
            r13 = 2
            r4[r13] = r5     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            java.lang.String r5 = "value"
            r14 = 3
            r4[r14] = r5     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            java.lang.String r5 = "active"
            r15 = 4
            r4[r15] = r5     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            java.lang.String r5 = "trigger_event_name"
            r10 = 5
            r4[r10] = r5     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            java.lang.String r5 = "trigger_timeout"
            r9 = 6
            r4[r9] = r5     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            java.lang.String r5 = "timed_out_event"
            r8 = 7
            r4[r8] = r5     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            java.lang.String r5 = "creation_timestamp"
            r7 = 8
            r4[r7] = r5     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            java.lang.String r5 = "triggered_event"
            r6 = 9
            r4[r6] = r5     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            java.lang.String r5 = "triggered_timestamp"
            r1 = 10
            r4[r1] = r5     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            java.lang.String r5 = "time_to_live"
            r1 = 11
            r4[r1] = r5     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            java.lang.String r5 = "expired_event"
            r1 = 12
            r4[r1] = r5     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            r19 = 0
            r20 = 0
            java.lang.String r21 = "rowid"
            java.lang.String r22 = "1001"
            r5 = r40
            r1 = 9
            r6 = r41
            r1 = 8
            r7 = r19
            r1 = 7
            r8 = r20
            r1 = 6
            r9 = r21
            r1 = 5
            r10 = r22
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x0153, all -> 0x0150 }
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            if (r3 != 0) goto L_0x0084
            r2.close()
            return r0
        L_0x0084:
            int r3 = r0.size()     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            r4 = 1000(0x3e8, float:1.401E-42)
            if (r3 < r4) goto L_0x009d
            a.d.a.a.i.b.x3 r1 = r39.i()     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            a.d.a.a.i.b.z3 r1 = r1.f     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            java.lang.String r3 = "Read more than the max allowed conditional properties, ignoring extra"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            r1.b(r3, r4)     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            goto L_0x0142
        L_0x009d:
            java.lang.String r3 = r2.getString(r11)     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            java.lang.String r10 = r2.getString(r12)     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            java.lang.String r5 = r2.getString(r13)     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            r9 = r39
            java.lang.Object r8 = r9.A(r2, r14)     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            int r4 = r2.getInt(r15)     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            if (r4 == 0) goto L_0x00b8
            r22 = 1
            goto L_0x00ba
        L_0x00b8:
            r22 = 0
        L_0x00ba:
            java.lang.String r24 = r2.getString(r1)     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            r6 = 6
            long r25 = r2.getLong(r6)     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            a.d.a.a.i.b.s9 r4 = r39.l()     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            r7 = 7
            byte[] r1 = r2.getBlob(r7)     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzar> r6 = com.google.android.gms.measurement.internal.zzar.CREATOR     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            android.os.Parcelable r1 = r4.u(r1, r6)     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            com.google.android.gms.measurement.internal.zzar r1 = (com.google.android.gms.measurement.internal.zzar) r1     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            r6 = 8
            long r27 = r2.getLong(r6)     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            a.d.a.a.i.b.s9 r4 = r39.l()     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            r11 = 9
            byte[] r6 = r2.getBlob(r11)     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzar> r7 = com.google.android.gms.measurement.internal.zzar.CREATOR     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            android.os.Parcelable r4 = r4.u(r6, r7)     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            r29 = r4
            com.google.android.gms.measurement.internal.zzar r29 = (com.google.android.gms.measurement.internal.zzar) r29     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            r6 = 10
            long r16 = r2.getLong(r6)     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            r7 = 11
            long r31 = r2.getLong(r7)     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            a.d.a.a.i.b.s9 r4 = r39.l()     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            r11 = 12
            byte[] r6 = r2.getBlob(r11)     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzar> r7 = com.google.android.gms.measurement.internal.zzar.CREATOR     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            android.os.Parcelable r4 = r4.u(r6, r7)     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            r30 = r4
            com.google.android.gms.measurement.internal.zzar r30 = (com.google.android.gms.measurement.internal.zzar) r30     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            com.google.android.gms.measurement.internal.zzkw r33 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            r4 = r33
            r34 = 11
            r35 = 10
            r36 = 8
            r37 = 7
            r38 = 6
            r6 = r16
            r9 = r10
            r4.<init>(r5, r6, r8, r9)     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            com.google.android.gms.measurement.internal.zzw r4 = new com.google.android.gms.measurement.internal.zzw     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            r16 = r4
            r17 = r3
            r18 = r10
            r19 = r33
            r20 = r27
            r23 = r24
            r24 = r1
            r27 = r29
            r28 = r31
            r16.<init>(r17, r18, r19, r20, r22, r23, r24, r25, r27, r28, r30)     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            r0.add(r4)     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            boolean r1 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x014d, all -> 0x014a }
            if (r1 != 0) goto L_0x0146
        L_0x0142:
            r2.close()
            return r0
        L_0x0146:
            r1 = 5
            r11 = 0
            goto L_0x0084
        L_0x014a:
            r0 = move-exception
            r1 = r2
            goto L_0x016b
        L_0x014d:
            r0 = move-exception
            r1 = r2
            goto L_0x0155
        L_0x0150:
            r0 = move-exception
            r1 = 0
            goto L_0x016b
        L_0x0153:
            r0 = move-exception
            r1 = 0
        L_0x0155:
            a.d.a.a.i.b.x3 r2 = r39.i()     // Catch:{ all -> 0x016a }
            a.d.a.a.i.b.z3 r2 = r2.f     // Catch:{ all -> 0x016a }
            java.lang.String r3 = "Error querying conditional user property value"
            r2.b(r3, r0)     // Catch:{ all -> 0x016a }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x016a }
            if (r1 == 0) goto L_0x0169
            r1.close()
        L_0x0169:
            return r0
        L_0x016a:
            r0 = move-exception
        L_0x016b:
            if (r1 == 0) goto L_0x0170
            r1.close()
        L_0x0170:
            goto L_0x0172
        L_0x0171:
            throw r0
        L_0x0172:
            goto L_0x0171
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.d.F(java.lang.String, java.lang.String[]):java.util.List");
    }

    @WorkerThread
    public final void H(l lVar) {
        b.k(lVar);
        b();
        n();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", lVar.f2333a);
        contentValues.put("name", lVar.f2334b);
        contentValues.put("lifetime_count", Long.valueOf(lVar.f2335c));
        contentValues.put("current_bundle_count", Long.valueOf(lVar.f2336d));
        contentValues.put("last_fire_timestamp", Long.valueOf(lVar.f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(lVar.g));
        contentValues.put("last_bundled_day", lVar.h);
        contentValues.put("last_sampled_complex_event_id", lVar.i);
        contentValues.put("last_sampling_rate", lVar.j);
        contentValues.put("current_session_count", Long.valueOf(lVar.f2337e));
        Boolean bool = lVar.k;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (t().insertWithOnConflict("events", (String) null, contentValues, 5) == -1) {
                i().f.b("Failed to insert/update event aggregates (got -1). appId", x3.s(lVar.f2333a));
            }
        } catch (SQLiteException e2) {
            i().f.c("Error storing event aggregates. appId", x3.s(lVar.f2333a), e2);
        }
    }

    @WorkerThread
    public final void I(a4 a4Var) {
        b.k(a4Var);
        b();
        n();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", a4Var.o());
        contentValues.put("app_instance_id", a4Var.s());
        contentValues.put("gmp_app_id", a4Var.v());
        contentValues.put("resettable_device_id_hash", a4Var.E());
        contentValues.put("last_bundle_index", Long.valueOf(a4Var.U()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(a4Var.K()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(a4Var.L()));
        contentValues.put("app_version", a4Var.M());
        contentValues.put("app_store", a4Var.O());
        contentValues.put("gmp_version", Long.valueOf(a4Var.P()));
        contentValues.put("dev_cert_hash", Long.valueOf(a4Var.Q()));
        contentValues.put("measurement_enabled", Boolean.valueOf(a4Var.T()));
        a4Var.f2076a.f().b();
        contentValues.put("day", Long.valueOf(a4Var.x));
        a4Var.f2076a.f().b();
        contentValues.put("daily_public_events_count", Long.valueOf(a4Var.y));
        a4Var.f2076a.f().b();
        contentValues.put("daily_events_count", Long.valueOf(a4Var.z));
        a4Var.f2076a.f().b();
        contentValues.put("daily_conversions_count", Long.valueOf(a4Var.A));
        a4Var.f2076a.f().b();
        contentValues.put("config_fetched_time", Long.valueOf(a4Var.F));
        a4Var.f2076a.f().b();
        contentValues.put("failed_config_fetch_time", Long.valueOf(a4Var.G));
        contentValues.put("app_version_int", Long.valueOf(a4Var.N()));
        contentValues.put("firebase_instance_id", a4Var.H());
        a4Var.f2076a.f().b();
        contentValues.put("daily_error_events_count", Long.valueOf(a4Var.B));
        a4Var.f2076a.f().b();
        contentValues.put("daily_realtime_events_count", Long.valueOf(a4Var.C));
        a4Var.f2076a.f().b();
        contentValues.put("health_monitor_sample", a4Var.D);
        contentValues.put("android_id", Long.valueOf(a4Var.g()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(a4Var.h()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(a4Var.i()));
        contentValues.put("admob_app_id", a4Var.y());
        contentValues.put("dynamite_version", Long.valueOf(a4Var.S()));
        if (a4Var.k() != null) {
            if (a4Var.k().size() == 0) {
                i().i.b("Safelisted events should not be an empty list. appId", a4Var.o());
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", a4Var.k()));
            }
        }
        if (jb.b() && this.f2563a.g.t(a4Var.o(), q.k0)) {
            contentValues.put("ga_app_id", a4Var.B());
        }
        try {
            SQLiteDatabase t = t();
            if (((long) t.update("apps", contentValues, "app_id = ?", new String[]{a4Var.o()})) == 0 && t.insertWithOnConflict("apps", (String) null, contentValues, 5) == -1) {
                i().f.b("Failed to insert/update app (got -1). appId", x3.s(a4Var.o()));
            }
        } catch (SQLiteException e2) {
            i().f.c("Error storing app. appId", x3.s(a4Var.o()), e2);
        }
    }

    @WorkerThread
    public final void J(List<Long> list) {
        b();
        n();
        b.k(list);
        if (list.size() == 0) {
            throw new IllegalArgumentException("Given Integer is zero");
        } else if (R()) {
            String join = TextUtils.join(",", list);
            String d2 = a.d(String.valueOf(join).length() + 2, "(", join, ")");
            if (S(a.d(String.valueOf(d2).length() + 80, "SELECT COUNT(1) FROM queue WHERE rowid IN ", d2, " AND retry_count =  2147483647 LIMIT 1"), (String[]) null) > 0) {
                i().i.a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase t = t();
                StringBuilder sb = new StringBuilder(String.valueOf(d2).length() + 127);
                sb.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb.append(d2);
                sb.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                t.execSQL(sb.toString());
            } catch (SQLiteException e2) {
                i().f.b("Error incrementing retry count. error", e2);
            }
        }
    }

    @WorkerThread
    public final boolean K(b1 b1Var, boolean z) {
        Object obj;
        String str;
        z3 z3Var;
        b();
        n();
        b.k(b1Var);
        b.h(b1Var.zzs);
        b.n((b1Var.zzc & 8) != 0);
        i0();
        if (((c) this.f2563a.n) != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (b1Var.zzj < currentTimeMillis - ka.z() || b1Var.zzj > ka.z() + currentTimeMillis) {
                i().i.d("Storing bundle outside of the max uploading time span. appId, now, timestamp", x3.s(b1Var.zzs), Long.valueOf(currentTimeMillis), Long.valueOf(b1Var.zzj));
            }
            try {
                byte[] T = l().T(b1Var.j());
                i().n.b("Saving bundle, size", Integer.valueOf(T.length));
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", b1Var.zzs);
                contentValues.put("bundle_end_timestamp", Long.valueOf(b1Var.zzj));
                contentValues.put("data", T);
                contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
                if ((b1Var.zzd & 2) != 0) {
                    contentValues.put("retry_count", Integer.valueOf(b1Var.zzao));
                }
                try {
                    if (t().insert("queue", (String) null, contentValues) != -1) {
                        return true;
                    }
                    i().f.b("Failed to insert bundle (got -1). appId", x3.s(b1Var.zzs));
                    return false;
                } catch (SQLiteException e2) {
                    e = e2;
                    z3Var = i().f;
                    obj = x3.s(b1Var.zzs);
                    str = "Error storing bundle. appId";
                    z3Var.c(str, obj, e);
                    return false;
                }
            } catch (IOException e3) {
                e = e3;
                z3Var = i().f;
                obj = x3.s(b1Var.zzs);
                str = "Data loss. Failed to serialize bundle. appId";
                z3Var.c(str, obj, e);
                return false;
            }
        } else {
            throw null;
        }
    }

    public final boolean L(j jVar, long j2, boolean z) {
        b();
        n();
        b.k(jVar);
        b.h(jVar.f2284a);
        byte[] j3 = l().v(jVar).j();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", jVar.f2284a);
        contentValues.put("name", jVar.f2285b);
        contentValues.put("timestamp", Long.valueOf(jVar.f2287d));
        contentValues.put("metadata_fingerprint", Long.valueOf(j2));
        contentValues.put("data", j3);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (t().insert("raw_events", (String) null, contentValues) != -1) {
                return true;
            }
            i().f.b("Failed to insert raw event (got -1). appId", x3.s(jVar.f2284a));
            return false;
        } catch (SQLiteException e2) {
            i().f.c("Error storing raw event. appId", x3.s(jVar.f2284a), e2);
            return false;
        }
    }

    @WorkerThread
    public final boolean M(w9 w9Var) {
        b.k(w9Var);
        b();
        n();
        if (Y(w9Var.f2606a, w9Var.f2608c) == null) {
            if (v9.V(w9Var.f2608c)) {
                long S = S("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{w9Var.f2606a});
                ka kaVar = this.f2563a.g;
                String str = w9Var.f2606a;
                if (kaVar != null) {
                    int i2 = 25;
                    if (t9.b() && kaVar.t((String) null, q.E0)) {
                        i2 = Math.max(Math.min(kaVar.q(str, q.G), 100), 25);
                    }
                    if (S >= ((long) i2)) {
                        return false;
                    }
                } else {
                    throw null;
                }
            } else if (!"_npa".equals(w9Var.f2608c)) {
                if (S("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{w9Var.f2606a, w9Var.f2607b}) >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", w9Var.f2606a);
        contentValues.put("origin", w9Var.f2607b);
        contentValues.put("name", w9Var.f2608c);
        contentValues.put("set_timestamp", Long.valueOf(w9Var.f2609d));
        G(contentValues, "value", w9Var.f2610e);
        try {
            if (t().insertWithOnConflict("user_attributes", (String) null, contentValues, 5) == -1) {
                i().f.b("Failed to insert/update user property (got -1). appId", x3.s(w9Var.f2606a));
            }
        } catch (SQLiteException e2) {
            i().f.c("Error storing user property. appId", x3.s(w9Var.f2606a), e2);
        }
        return true;
    }

    @WorkerThread
    public final boolean N(zzw zzw) {
        b.k(zzw);
        b();
        n();
        if (Y(zzw.f4290a, zzw.f4292c.f4281b) == null) {
            if (S("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzw.f4290a}) >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzw.f4290a);
        contentValues.put("origin", zzw.f4291b);
        contentValues.put("name", zzw.f4292c.f4281b);
        G(contentValues, "value", zzw.f4292c.e());
        contentValues.put("active", Boolean.valueOf(zzw.f4294e));
        contentValues.put("trigger_event_name", zzw.f);
        contentValues.put("trigger_timeout", Long.valueOf(zzw.h));
        e();
        contentValues.put("timed_out_event", v9.e0(zzw.g));
        contentValues.put("creation_timestamp", Long.valueOf(zzw.f4293d));
        e();
        contentValues.put("triggered_event", v9.e0(zzw.i));
        contentValues.put("triggered_timestamp", Long.valueOf(zzw.f4292c.f4282c));
        contentValues.put("time_to_live", Long.valueOf(zzw.j));
        e();
        contentValues.put("expired_event", v9.e0(zzw.k));
        try {
            if (t().insertWithOnConflict("conditional_properties", (String) null, contentValues, 5) == -1) {
                i().f.b("Failed to insert/update conditional user property (got -1)", x3.s(zzw.f4290a));
            }
        } catch (SQLiteException e2) {
            i().f.c("Error storing conditional user property", x3.s(zzw.f4290a), e2);
        }
        return true;
    }

    @WorkerThread
    public final boolean O(String str, int i2, i0 i0Var) {
        n();
        b();
        b.h(str);
        b.k(i0Var);
        Integer num = null;
        if (TextUtils.isEmpty(i0Var.zze)) {
            z3 z3Var = i().i;
            Object s = x3.s(str);
            Integer valueOf = Integer.valueOf(i2);
            if (i0Var.u()) {
                num = Integer.valueOf(i0Var.zzd);
            }
            z3Var.d("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", s, valueOf, String.valueOf(num));
            return false;
        }
        byte[] j2 = i0Var.j();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i2));
        contentValues.put("filter_id", i0Var.u() ? Integer.valueOf(i0Var.zzd) : null);
        contentValues.put("event_name", i0Var.zze);
        contentValues.put("session_scoped", (i0Var.zzc & 64) != 0 ? Boolean.valueOf(i0Var.zzk) : null);
        contentValues.put("data", j2);
        try {
            if (t().insertWithOnConflict("event_filters", (String) null, contentValues, 5) == -1) {
                i().f.b("Failed to insert event filter (got -1). appId", x3.s(str));
            }
            return true;
        } catch (SQLiteException e2) {
            i().f.c("Error storing event filter. appId", x3.s(str), e2);
            return false;
        }
    }

    @WorkerThread
    public final boolean P(String str, int i2, l0 l0Var) {
        n();
        b();
        b.h(str);
        b.k(l0Var);
        Integer num = null;
        if (TextUtils.isEmpty(l0Var.zze)) {
            z3 z3Var = i().i;
            Object s = x3.s(str);
            Integer valueOf = Integer.valueOf(i2);
            if (l0Var.t()) {
                num = Integer.valueOf(l0Var.zzd);
            }
            z3Var.d("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", s, valueOf, String.valueOf(num));
            return false;
        }
        byte[] j2 = l0Var.j();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i2));
        contentValues.put("filter_id", l0Var.t() ? Integer.valueOf(l0Var.zzd) : null);
        contentValues.put("property_name", l0Var.zze);
        contentValues.put("session_scoped", (l0Var.zzc & 32) != 0 ? Boolean.valueOf(l0Var.zzi) : null);
        contentValues.put("data", j2);
        try {
            if (t().insertWithOnConflict("property_filters", (String) null, contentValues, 5) != -1) {
                return true;
            }
            i().f.b("Failed to insert property filter (got -1). appId", x3.s(str));
            return false;
        } catch (SQLiteException e2) {
            i().f.c("Error storing property filter. appId", x3.s(str), e2);
            return false;
        }
    }

    public final boolean Q(String str, Long l2, long j2, x0 x0Var) {
        b();
        n();
        b.k(x0Var);
        b.h(str);
        b.k(l2);
        byte[] j3 = x0Var.j();
        i().n.c("Saving complex main event, appId, data size", d().u(str), Integer.valueOf(j3.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l2);
        contentValues.put("children_to_process", Long.valueOf(j2));
        contentValues.put("main_event", j3);
        try {
            if (t().insertWithOnConflict("main_event_params", (String) null, contentValues, 5) != -1) {
                return true;
            }
            i().f.b("Failed to insert complex main event (got -1). appId", x3.s(str));
            return false;
        } catch (SQLiteException e2) {
            i().f.c("Error storing complex main event. appId", x3.s(str), e2);
            return false;
        }
    }

    public final boolean R() {
        return this.f2563a.f2123a.getDatabasePath("google_app_measurement.db").exists();
    }

    @WorkerThread
    public final long S(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = t().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j2 = cursor.getLong(0);
                cursor.close();
                return j2;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e2) {
            i().f.c("Database error", str, e2);
            throw e2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0167 A[Catch:{ SQLiteException -> 0x02fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0169 A[Catch:{ SQLiteException -> 0x02fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0186 A[Catch:{ SQLiteException -> 0x02fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0188 A[Catch:{ SQLiteException -> 0x02fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x01a5 A[Catch:{ SQLiteException -> 0x02fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x01a7 A[Catch:{ SQLiteException -> 0x02fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x01c4 A[Catch:{ SQLiteException -> 0x02fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x01c6 A[Catch:{ SQLiteException -> 0x02fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x01e6 A[Catch:{ SQLiteException -> 0x02fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x01ea A[Catch:{ SQLiteException -> 0x02fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0212 A[Catch:{ SQLiteException -> 0x02fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0214 A[Catch:{ SQLiteException -> 0x02fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0231 A[Catch:{ SQLiteException -> 0x02fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0233 A[Catch:{ SQLiteException -> 0x02fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x024e A[Catch:{ SQLiteException -> 0x02fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0268 A[Catch:{ SQLiteException -> 0x02fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x027d A[Catch:{ SQLiteException -> 0x02fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0299 A[Catch:{ SQLiteException -> 0x02fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x029c A[Catch:{ SQLiteException -> 0x02fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x02ab A[Catch:{ SQLiteException -> 0x02fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x02e9 A[Catch:{ SQLiteException -> 0x02fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0313  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x031b  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final a.d.a.a.i.b.a4 T(java.lang.String r24) {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            a.c.a.f.b.h(r24)
            r23.b()
            r23.n()
            r3 = 0
            android.database.sqlite.SQLiteDatabase r4 = r23.t()     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            java.lang.String r5 = "apps"
            r0 = 29
            java.lang.String[] r6 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            java.lang.String r0 = "app_instance_id"
            r12 = 0
            r6[r12] = r0     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            java.lang.String r0 = "gmp_app_id"
            r13 = 1
            r6[r13] = r0     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            java.lang.String r0 = "resettable_device_id_hash"
            r14 = 2
            r6[r14] = r0     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            java.lang.String r0 = "last_bundle_index"
            r15 = 3
            r6[r15] = r0     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            java.lang.String r0 = "last_bundle_start_timestamp"
            r11 = 4
            r6[r11] = r0     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            java.lang.String r0 = "last_bundle_end_timestamp"
            r10 = 5
            r6[r10] = r0     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            java.lang.String r0 = "app_version"
            r9 = 6
            r6[r9] = r0     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            java.lang.String r0 = "app_store"
            r8 = 7
            r6[r8] = r0     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            java.lang.String r0 = "gmp_version"
            r7 = 8
            r6[r7] = r0     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            java.lang.String r0 = "dev_cert_hash"
            r15 = 9
            r6[r15] = r0     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            java.lang.String r0 = "measurement_enabled"
            r15 = 10
            r6[r15] = r0     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            java.lang.String r0 = "day"
            r15 = 11
            r6[r15] = r0     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            java.lang.String r0 = "daily_public_events_count"
            r15 = 12
            r6[r15] = r0     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            java.lang.String r0 = "daily_events_count"
            r15 = 13
            r6[r15] = r0     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            java.lang.String r0 = "daily_conversions_count"
            r15 = 14
            r6[r15] = r0     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            r0 = 15
            java.lang.String r16 = "config_fetched_time"
            r6[r0] = r16     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            r0 = 16
            java.lang.String r16 = "failed_config_fetch_time"
            r6[r0] = r16     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            java.lang.String r0 = "app_version_int"
            r15 = 17
            r6[r15] = r0     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            r0 = 18
            java.lang.String r17 = "firebase_instance_id"
            r6[r0] = r17     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            r0 = 19
            java.lang.String r17 = "daily_error_events_count"
            r6[r0] = r17     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            r0 = 20
            java.lang.String r17 = "daily_realtime_events_count"
            r6[r0] = r17     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            r0 = 21
            java.lang.String r17 = "health_monitor_sample"
            r6[r0] = r17     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            java.lang.String r0 = "android_id"
            r15 = 22
            r6[r15] = r0     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            java.lang.String r0 = "adid_reporting_enabled"
            r15 = 23
            r6[r15] = r0     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            java.lang.String r0 = "ssaid_reporting_enabled"
            r15 = 24
            r6[r15] = r0     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            r0 = 25
            java.lang.String r18 = "admob_app_id"
            r6[r0] = r18     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            java.lang.String r0 = "dynamite_version"
            r15 = 26
            r6[r15] = r0     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            java.lang.String r0 = "safelisted_events"
            r15 = 27
            r6[r15] = r0     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            r0 = 28
            java.lang.String r19 = "ga_app_id"
            r6[r0] = r19     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            java.lang.String r0 = "app_id=?"
            java.lang.String[] r8 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            r8[r12] = r2     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            r20 = 0
            r21 = 0
            r22 = 0
            r15 = 8
            r7 = r0
            r0 = 7
            r15 = 6
            r9 = r20
            r0 = 5
            r10 = r21
            r15 = 4
            r11 = r22
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x0300, all -> 0x02fe }
            boolean r5 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x02fc }
            if (r5 != 0) goto L_0x00e5
            r4.close()
            return r3
        L_0x00e5:
            a.d.a.a.i.b.a4 r5 = new a.d.a.a.i.b.a4     // Catch:{ SQLiteException -> 0x02fc }
            a.d.a.a.i.b.o9 r6 = r1.f2386b     // Catch:{ SQLiteException -> 0x02fc }
            a.d.a.a.i.b.c5 r6 = r6.j     // Catch:{ SQLiteException -> 0x02fc }
            r5.<init>(r6, r2)     // Catch:{ SQLiteException -> 0x02fc }
            java.lang.String r6 = r4.getString(r12)     // Catch:{ SQLiteException -> 0x02fc }
            r5.c(r6)     // Catch:{ SQLiteException -> 0x02fc }
            java.lang.String r6 = r4.getString(r13)     // Catch:{ SQLiteException -> 0x02fc }
            r5.m(r6)     // Catch:{ SQLiteException -> 0x02fc }
            java.lang.String r6 = r4.getString(r14)     // Catch:{ SQLiteException -> 0x02fc }
            r5.x(r6)     // Catch:{ SQLiteException -> 0x02fc }
            r6 = 3
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x02fc }
            r5.C(r6)     // Catch:{ SQLiteException -> 0x02fc }
            long r6 = r4.getLong(r15)     // Catch:{ SQLiteException -> 0x02fc }
            r5.a(r6)     // Catch:{ SQLiteException -> 0x02fc }
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x02fc }
            r5.l(r6)     // Catch:{ SQLiteException -> 0x02fc }
            r0 = 6
            java.lang.String r0 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x02fc }
            r5.D(r0)     // Catch:{ SQLiteException -> 0x02fc }
            r0 = 7
            java.lang.String r0 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x02fc }
            r5.G(r0)     // Catch:{ SQLiteException -> 0x02fc }
            r0 = 8
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x02fc }
            r5.t(r6)     // Catch:{ SQLiteException -> 0x02fc }
            r0 = 9
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x02fc }
            r5.w(r6)     // Catch:{ SQLiteException -> 0x02fc }
            r0 = 10
            boolean r6 = r4.isNull(r0)     // Catch:{ SQLiteException -> 0x02fc }
            if (r6 != 0) goto L_0x014c
            int r0 = r4.getInt(r0)     // Catch:{ SQLiteException -> 0x02fc }
            if (r0 == 0) goto L_0x014a
            goto L_0x014c
        L_0x014a:
            r0 = 0
            goto L_0x014d
        L_0x014c:
            r0 = 1
        L_0x014d:
            r5.e(r0)     // Catch:{ SQLiteException -> 0x02fc }
            r0 = 11
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x02fc }
            a.d.a.a.i.b.c5 r0 = r5.f2076a     // Catch:{ SQLiteException -> 0x02fc }
            a.d.a.a.i.b.v4 r0 = r0.f()     // Catch:{ SQLiteException -> 0x02fc }
            r0.b()     // Catch:{ SQLiteException -> 0x02fc }
            boolean r0 = r5.E     // Catch:{ SQLiteException -> 0x02fc }
            long r8 = r5.x     // Catch:{ SQLiteException -> 0x02fc }
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r10 == 0) goto L_0x0169
            r8 = 1
            goto L_0x016a
        L_0x0169:
            r8 = 0
        L_0x016a:
            r0 = r0 | r8
            r5.E = r0     // Catch:{ SQLiteException -> 0x02fc }
            r5.x = r6     // Catch:{ SQLiteException -> 0x02fc }
            r0 = 12
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x02fc }
            a.d.a.a.i.b.c5 r0 = r5.f2076a     // Catch:{ SQLiteException -> 0x02fc }
            a.d.a.a.i.b.v4 r0 = r0.f()     // Catch:{ SQLiteException -> 0x02fc }
            r0.b()     // Catch:{ SQLiteException -> 0x02fc }
            boolean r0 = r5.E     // Catch:{ SQLiteException -> 0x02fc }
            long r8 = r5.y     // Catch:{ SQLiteException -> 0x02fc }
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r10 == 0) goto L_0x0188
            r8 = 1
            goto L_0x0189
        L_0x0188:
            r8 = 0
        L_0x0189:
            r0 = r0 | r8
            r5.E = r0     // Catch:{ SQLiteException -> 0x02fc }
            r5.y = r6     // Catch:{ SQLiteException -> 0x02fc }
            r0 = 13
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x02fc }
            a.d.a.a.i.b.c5 r0 = r5.f2076a     // Catch:{ SQLiteException -> 0x02fc }
            a.d.a.a.i.b.v4 r0 = r0.f()     // Catch:{ SQLiteException -> 0x02fc }
            r0.b()     // Catch:{ SQLiteException -> 0x02fc }
            boolean r0 = r5.E     // Catch:{ SQLiteException -> 0x02fc }
            long r8 = r5.z     // Catch:{ SQLiteException -> 0x02fc }
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r10 == 0) goto L_0x01a7
            r8 = 1
            goto L_0x01a8
        L_0x01a7:
            r8 = 0
        L_0x01a8:
            r0 = r0 | r8
            r5.E = r0     // Catch:{ SQLiteException -> 0x02fc }
            r5.z = r6     // Catch:{ SQLiteException -> 0x02fc }
            r0 = 14
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x02fc }
            a.d.a.a.i.b.c5 r0 = r5.f2076a     // Catch:{ SQLiteException -> 0x02fc }
            a.d.a.a.i.b.v4 r0 = r0.f()     // Catch:{ SQLiteException -> 0x02fc }
            r0.b()     // Catch:{ SQLiteException -> 0x02fc }
            boolean r0 = r5.E     // Catch:{ SQLiteException -> 0x02fc }
            long r8 = r5.A     // Catch:{ SQLiteException -> 0x02fc }
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r10 == 0) goto L_0x01c6
            r8 = 1
            goto L_0x01c7
        L_0x01c6:
            r8 = 0
        L_0x01c7:
            r0 = r0 | r8
            r5.E = r0     // Catch:{ SQLiteException -> 0x02fc }
            r5.A = r6     // Catch:{ SQLiteException -> 0x02fc }
            r0 = 15
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x02fc }
            r5.F(r6)     // Catch:{ SQLiteException -> 0x02fc }
            r0 = 16
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x02fc }
            r5.I(r6)     // Catch:{ SQLiteException -> 0x02fc }
            r0 = 17
            boolean r6 = r4.isNull(r0)     // Catch:{ SQLiteException -> 0x02fc }
            if (r6 == 0) goto L_0x01ea
            r6 = -2147483648(0xffffffff80000000, double:NaN)
            goto L_0x01ef
        L_0x01ea:
            int r0 = r4.getInt(r0)     // Catch:{ SQLiteException -> 0x02fc }
            long r6 = (long) r0     // Catch:{ SQLiteException -> 0x02fc }
        L_0x01ef:
            r5.p(r6)     // Catch:{ SQLiteException -> 0x02fc }
            r0 = 18
            java.lang.String r0 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x02fc }
            r5.A(r0)     // Catch:{ SQLiteException -> 0x02fc }
            r0 = 19
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x02fc }
            a.d.a.a.i.b.c5 r0 = r5.f2076a     // Catch:{ SQLiteException -> 0x02fc }
            a.d.a.a.i.b.v4 r0 = r0.f()     // Catch:{ SQLiteException -> 0x02fc }
            r0.b()     // Catch:{ SQLiteException -> 0x02fc }
            boolean r0 = r5.E     // Catch:{ SQLiteException -> 0x02fc }
            long r8 = r5.B     // Catch:{ SQLiteException -> 0x02fc }
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r10 == 0) goto L_0x0214
            r8 = 1
            goto L_0x0215
        L_0x0214:
            r8 = 0
        L_0x0215:
            r0 = r0 | r8
            r5.E = r0     // Catch:{ SQLiteException -> 0x02fc }
            r5.B = r6     // Catch:{ SQLiteException -> 0x02fc }
            r0 = 20
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x02fc }
            a.d.a.a.i.b.c5 r0 = r5.f2076a     // Catch:{ SQLiteException -> 0x02fc }
            a.d.a.a.i.b.v4 r0 = r0.f()     // Catch:{ SQLiteException -> 0x02fc }
            r0.b()     // Catch:{ SQLiteException -> 0x02fc }
            boolean r0 = r5.E     // Catch:{ SQLiteException -> 0x02fc }
            long r8 = r5.C     // Catch:{ SQLiteException -> 0x02fc }
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r10 == 0) goto L_0x0233
            r8 = 1
            goto L_0x0234
        L_0x0233:
            r8 = 0
        L_0x0234:
            r0 = r0 | r8
            r5.E = r0     // Catch:{ SQLiteException -> 0x02fc }
            r5.C = r6     // Catch:{ SQLiteException -> 0x02fc }
            r0 = 21
            java.lang.String r0 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x02fc }
            r5.J(r0)     // Catch:{ SQLiteException -> 0x02fc }
            a.d.a.a.i.b.c5 r0 = r1.f2563a     // Catch:{ SQLiteException -> 0x02fc }
            a.d.a.a.i.b.ka r0 = r0.g     // Catch:{ SQLiteException -> 0x02fc }
            a.d.a.a.i.b.n3<java.lang.Boolean> r6 = a.d.a.a.i.b.q.G0     // Catch:{ SQLiteException -> 0x02fc }
            boolean r0 = r0.o(r6)     // Catch:{ SQLiteException -> 0x02fc }
            if (r0 != 0) goto L_0x0260
            r0 = 22
            boolean r6 = r4.isNull(r0)     // Catch:{ SQLiteException -> 0x02fc }
            if (r6 == 0) goto L_0x0259
            r6 = 0
            goto L_0x025d
        L_0x0259:
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x02fc }
        L_0x025d:
            r5.R(r6)     // Catch:{ SQLiteException -> 0x02fc }
        L_0x0260:
            r0 = 23
            boolean r6 = r4.isNull(r0)     // Catch:{ SQLiteException -> 0x02fc }
            if (r6 != 0) goto L_0x0271
            int r0 = r4.getInt(r0)     // Catch:{ SQLiteException -> 0x02fc }
            if (r0 == 0) goto L_0x026f
            goto L_0x0271
        L_0x026f:
            r0 = 0
            goto L_0x0272
        L_0x0271:
            r0 = 1
        L_0x0272:
            r5.n(r0)     // Catch:{ SQLiteException -> 0x02fc }
            r0 = 24
            boolean r6 = r4.isNull(r0)     // Catch:{ SQLiteException -> 0x02fc }
            if (r6 != 0) goto L_0x0285
            int r0 = r4.getInt(r0)     // Catch:{ SQLiteException -> 0x02fc }
            if (r0 == 0) goto L_0x0284
            goto L_0x0285
        L_0x0284:
            r13 = 0
        L_0x0285:
            r5.r(r13)     // Catch:{ SQLiteException -> 0x02fc }
            r0 = 25
            java.lang.String r0 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x02fc }
            r5.q(r0)     // Catch:{ SQLiteException -> 0x02fc }
            r0 = 26
            boolean r6 = r4.isNull(r0)     // Catch:{ SQLiteException -> 0x02fc }
            if (r6 == 0) goto L_0x029c
            r6 = 0
            goto L_0x02a0
        L_0x029c:
            long r6 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x02fc }
        L_0x02a0:
            r5.z(r6)     // Catch:{ SQLiteException -> 0x02fc }
            r0 = 27
            boolean r6 = r4.isNull(r0)     // Catch:{ SQLiteException -> 0x02fc }
            if (r6 != 0) goto L_0x02bd
            java.lang.String r0 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x02fc }
            java.lang.String r6 = ","
            r7 = -1
            java.lang.String[] r0 = r0.split(r6, r7)     // Catch:{ SQLiteException -> 0x02fc }
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch:{ SQLiteException -> 0x02fc }
            r5.d(r0)     // Catch:{ SQLiteException -> 0x02fc }
        L_0x02bd:
            boolean r0 = a.d.a.a.h.g.jb.b()     // Catch:{ SQLiteException -> 0x02fc }
            if (r0 == 0) goto L_0x02d8
            a.d.a.a.i.b.c5 r0 = r1.f2563a     // Catch:{ SQLiteException -> 0x02fc }
            a.d.a.a.i.b.ka r0 = r0.g     // Catch:{ SQLiteException -> 0x02fc }
            a.d.a.a.i.b.n3<java.lang.Boolean> r6 = a.d.a.a.i.b.q.k0     // Catch:{ SQLiteException -> 0x02fc }
            boolean r0 = r0.t(r2, r6)     // Catch:{ SQLiteException -> 0x02fc }
            if (r0 == 0) goto L_0x02d8
            r0 = 28
            java.lang.String r0 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x02fc }
            r5.u(r0)     // Catch:{ SQLiteException -> 0x02fc }
        L_0x02d8:
            a.d.a.a.i.b.c5 r0 = r5.f2076a     // Catch:{ SQLiteException -> 0x02fc }
            a.d.a.a.i.b.v4 r0 = r0.f()     // Catch:{ SQLiteException -> 0x02fc }
            r0.b()     // Catch:{ SQLiteException -> 0x02fc }
            r5.E = r12     // Catch:{ SQLiteException -> 0x02fc }
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x02fc }
            if (r0 == 0) goto L_0x02f8
            a.d.a.a.i.b.x3 r0 = r23.i()     // Catch:{ SQLiteException -> 0x02fc }
            a.d.a.a.i.b.z3 r0 = r0.f     // Catch:{ SQLiteException -> 0x02fc }
            java.lang.String r6 = "Got multiple records for app, expected one. appId"
            java.lang.Object r7 = a.d.a.a.i.b.x3.s(r24)     // Catch:{ SQLiteException -> 0x02fc }
            r0.b(r6, r7)     // Catch:{ SQLiteException -> 0x02fc }
        L_0x02f8:
            r4.close()
            return r5
        L_0x02fc:
            r0 = move-exception
            goto L_0x0302
        L_0x02fe:
            r0 = move-exception
            goto L_0x0319
        L_0x0300:
            r0 = move-exception
            r4 = r3
        L_0x0302:
            a.d.a.a.i.b.x3 r5 = r23.i()     // Catch:{ all -> 0x0317 }
            a.d.a.a.i.b.z3 r5 = r5.f     // Catch:{ all -> 0x0317 }
            java.lang.String r6 = "Error querying app. appId"
            java.lang.Object r2 = a.d.a.a.i.b.x3.s(r24)     // Catch:{ all -> 0x0317 }
            r5.c(r6, r2, r0)     // Catch:{ all -> 0x0317 }
            if (r4 == 0) goto L_0x0316
            r4.close()
        L_0x0316:
            return r3
        L_0x0317:
            r0 = move-exception
            r3 = r4
        L_0x0319:
            if (r3 == 0) goto L_0x031e
            r3.close()
        L_0x031e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.d.T(java.lang.String):a.d.a.a.i.b.a4");
    }

    @WorkerThread
    public final List<zzw> U(String str, String str2, String str3) {
        b.h(str);
        b();
        n();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return F(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    @WorkerThread
    public final void V(String str, String str2) {
        b.h(str);
        b.h(str2);
        b();
        n();
        try {
            t().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e2) {
            i().f.d("Error deleting user property. appId", x3.s(str), d().y(str2), e2);
        }
    }

    public final boolean W(String str, List<Integer> list) {
        b.h(str);
        n();
        b();
        SQLiteDatabase t = t();
        try {
            long S = S("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(RecyclerView.MAX_SCROLL_DURATION, this.f2563a.g.q(str, q.F)));
            if (S <= ((long) max)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                Integer num = list.get(i2);
                if (num == null) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            String d2 = a.d(String.valueOf(join).length() + 2, "(", join, ")");
            return t.delete("audience_filter_values", a.d(String.valueOf(d2).length() + AVFrame.MEDIA_CODEC_AUDIO_PCM, "audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ", d2, " order by rowid desc limit -1 offset ?)"), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e2) {
            i().f.c("Database error querying filters. appId", x3.s(str), e2);
            return false;
        }
    }

    public final long X(String str) {
        b.h(str);
        b();
        n();
        try {
            return (long) t().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, this.f2563a.g.q(str, q.p))))});
        } catch (SQLiteException e2) {
            i().f.c("Error deleting over the limit events. appId", x3.s(str), e2);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a6  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final a.d.a.a.i.b.w9 Y(java.lang.String r19, java.lang.String r20) {
        /*
            r18 = this;
            r8 = r20
            a.c.a.f.b.h(r19)
            a.c.a.f.b.h(r20)
            r18.b()
            r18.n()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r18.t()     // Catch:{ SQLiteException -> 0x0081, all -> 0x007d }
            java.lang.String r11 = "user_attributes"
            r0 = 3
            java.lang.String[] r12 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0081, all -> 0x007d }
            java.lang.String r0 = "set_timestamp"
            r1 = 0
            r12[r1] = r0     // Catch:{ SQLiteException -> 0x0081, all -> 0x007d }
            java.lang.String r0 = "value"
            r2 = 1
            r12[r2] = r0     // Catch:{ SQLiteException -> 0x0081, all -> 0x007d }
            java.lang.String r0 = "origin"
            r3 = 2
            r12[r3] = r0     // Catch:{ SQLiteException -> 0x0081, all -> 0x007d }
            java.lang.String r13 = "app_id=? and name=?"
            java.lang.String[] r14 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0081, all -> 0x007d }
            r14[r1] = r19     // Catch:{ SQLiteException -> 0x0081, all -> 0x007d }
            r14[r2] = r8     // Catch:{ SQLiteException -> 0x0081, all -> 0x007d }
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x0081, all -> 0x007d }
            boolean r0 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x0079, all -> 0x0075 }
            if (r0 != 0) goto L_0x0042
            r10.close()
            return r9
        L_0x0042:
            long r5 = r10.getLong(r1)     // Catch:{ SQLiteException -> 0x0079, all -> 0x0075 }
            r11 = r18
            java.lang.Object r7 = r11.A(r10, r2)     // Catch:{ SQLiteException -> 0x0073 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ SQLiteException -> 0x0073 }
            a.d.a.a.i.b.w9 r0 = new a.d.a.a.i.b.w9     // Catch:{ SQLiteException -> 0x0073 }
            r1 = r0
            r2 = r19
            r4 = r20
            r1.<init>(r2, r3, r4, r5, r7)     // Catch:{ SQLiteException -> 0x0073 }
            boolean r1 = r10.moveToNext()     // Catch:{ SQLiteException -> 0x0073 }
            if (r1 == 0) goto L_0x006f
            a.d.a.a.i.b.x3 r1 = r18.i()     // Catch:{ SQLiteException -> 0x0073 }
            a.d.a.a.i.b.z3 r1 = r1.f     // Catch:{ SQLiteException -> 0x0073 }
            java.lang.String r2 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r3 = a.d.a.a.i.b.x3.s(r19)     // Catch:{ SQLiteException -> 0x0073 }
            r1.b(r2, r3)     // Catch:{ SQLiteException -> 0x0073 }
        L_0x006f:
            r10.close()
            return r0
        L_0x0073:
            r0 = move-exception
            goto L_0x0085
        L_0x0075:
            r0 = move-exception
            r11 = r18
            goto L_0x00a3
        L_0x0079:
            r0 = move-exception
            r11 = r18
            goto L_0x0085
        L_0x007d:
            r0 = move-exception
            r11 = r18
            goto L_0x00a4
        L_0x0081:
            r0 = move-exception
            r11 = r18
            r10 = r9
        L_0x0085:
            a.d.a.a.i.b.x3 r1 = r18.i()     // Catch:{ all -> 0x00a2 }
            a.d.a.a.i.b.z3 r1 = r1.f     // Catch:{ all -> 0x00a2 }
            java.lang.String r2 = "Error querying user property. appId"
            java.lang.Object r3 = a.d.a.a.i.b.x3.s(r19)     // Catch:{ all -> 0x00a2 }
            a.d.a.a.i.b.v3 r4 = r18.d()     // Catch:{ all -> 0x00a2 }
            java.lang.String r4 = r4.y(r8)     // Catch:{ all -> 0x00a2 }
            r1.d(r2, r3, r4, r0)     // Catch:{ all -> 0x00a2 }
            if (r10 == 0) goto L_0x00a1
            r10.close()
        L_0x00a1:
            return r9
        L_0x00a2:
            r0 = move-exception
        L_0x00a3:
            r9 = r10
        L_0x00a4:
            if (r9 == 0) goto L_0x00a9
            r9.close()
        L_0x00a9:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.d.Y(java.lang.String, java.lang.String):a.d.a.a.i.b.w9");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x014d  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzw Z(java.lang.String r33, java.lang.String r34) {
        /*
            r32 = this;
            r7 = r34
            a.c.a.f.b.h(r33)
            a.c.a.f.b.h(r34)
            r32.b()
            r32.n()
            r8 = 0
            android.database.sqlite.SQLiteDatabase r9 = r32.t()     // Catch:{ SQLiteException -> 0x0128, all -> 0x0124 }
            java.lang.String r10 = "conditional_properties"
            r0 = 11
            java.lang.String[] r11 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0128, all -> 0x0124 }
            java.lang.String r0 = "origin"
            r1 = 0
            r11[r1] = r0     // Catch:{ SQLiteException -> 0x0128, all -> 0x0124 }
            java.lang.String r0 = "value"
            r2 = 1
            r11[r2] = r0     // Catch:{ SQLiteException -> 0x0128, all -> 0x0124 }
            java.lang.String r0 = "active"
            r3 = 2
            r11[r3] = r0     // Catch:{ SQLiteException -> 0x0128, all -> 0x0124 }
            java.lang.String r0 = "trigger_event_name"
            r4 = 3
            r11[r4] = r0     // Catch:{ SQLiteException -> 0x0128, all -> 0x0124 }
            java.lang.String r0 = "trigger_timeout"
            r5 = 4
            r11[r5] = r0     // Catch:{ SQLiteException -> 0x0128, all -> 0x0124 }
            java.lang.String r0 = "timed_out_event"
            r6 = 5
            r11[r6] = r0     // Catch:{ SQLiteException -> 0x0128, all -> 0x0124 }
            java.lang.String r0 = "creation_timestamp"
            r15 = 6
            r11[r15] = r0     // Catch:{ SQLiteException -> 0x0128, all -> 0x0124 }
            java.lang.String r0 = "triggered_event"
            r14 = 7
            r11[r14] = r0     // Catch:{ SQLiteException -> 0x0128, all -> 0x0124 }
            java.lang.String r0 = "triggered_timestamp"
            r13 = 8
            r11[r13] = r0     // Catch:{ SQLiteException -> 0x0128, all -> 0x0124 }
            java.lang.String r0 = "time_to_live"
            r12 = 9
            r11[r12] = r0     // Catch:{ SQLiteException -> 0x0128, all -> 0x0124 }
            java.lang.String r0 = "expired_event"
            r6 = 10
            r11[r6] = r0     // Catch:{ SQLiteException -> 0x0128, all -> 0x0124 }
            java.lang.String r0 = "app_id=? and name=?"
            java.lang.String[] r13 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0128, all -> 0x0124 }
            r13[r1] = r33     // Catch:{ SQLiteException -> 0x0128, all -> 0x0124 }
            r13[r2] = r7     // Catch:{ SQLiteException -> 0x0128, all -> 0x0124 }
            r17 = 0
            r18 = 0
            r19 = 0
            r6 = 9
            r12 = r0
            r0 = 8
            r6 = 7
            r14 = r17
            r0 = 6
            r15 = r18
            r16 = r19
            android.database.Cursor r9 = r9.query(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ SQLiteException -> 0x0128, all -> 0x0124 }
            boolean r10 = r9.moveToFirst()     // Catch:{ SQLiteException -> 0x0120, all -> 0x011c }
            if (r10 != 0) goto L_0x007c
            r9.close()
            return r8
        L_0x007c:
            java.lang.String r19 = r9.getString(r1)     // Catch:{ SQLiteException -> 0x0120, all -> 0x011c }
            r10 = r32
            java.lang.Object r11 = r10.A(r9, r2)     // Catch:{ SQLiteException -> 0x011a }
            int r3 = r9.getInt(r3)     // Catch:{ SQLiteException -> 0x011a }
            if (r3 == 0) goto L_0x008f
            r23 = 1
            goto L_0x0091
        L_0x008f:
            r23 = 0
        L_0x0091:
            java.lang.String r24 = r9.getString(r4)     // Catch:{ SQLiteException -> 0x011a }
            long r26 = r9.getLong(r5)     // Catch:{ SQLiteException -> 0x011a }
            a.d.a.a.i.b.s9 r1 = r32.l()     // Catch:{ SQLiteException -> 0x011a }
            r2 = 5
            byte[] r2 = r9.getBlob(r2)     // Catch:{ SQLiteException -> 0x011a }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzar> r3 = com.google.android.gms.measurement.internal.zzar.CREATOR     // Catch:{ SQLiteException -> 0x011a }
            android.os.Parcelable r1 = r1.u(r2, r3)     // Catch:{ SQLiteException -> 0x011a }
            r25 = r1
            com.google.android.gms.measurement.internal.zzar r25 = (com.google.android.gms.measurement.internal.zzar) r25     // Catch:{ SQLiteException -> 0x011a }
            long r12 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x011a }
            a.d.a.a.i.b.s9 r0 = r32.l()     // Catch:{ SQLiteException -> 0x011a }
            byte[] r1 = r9.getBlob(r6)     // Catch:{ SQLiteException -> 0x011a }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzar> r2 = com.google.android.gms.measurement.internal.zzar.CREATOR     // Catch:{ SQLiteException -> 0x011a }
            android.os.Parcelable r0 = r0.u(r1, r2)     // Catch:{ SQLiteException -> 0x011a }
            r28 = r0
            com.google.android.gms.measurement.internal.zzar r28 = (com.google.android.gms.measurement.internal.zzar) r28     // Catch:{ SQLiteException -> 0x011a }
            r0 = 8
            long r3 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x011a }
            r0 = 9
            long r29 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x011a }
            a.d.a.a.i.b.s9 r0 = r32.l()     // Catch:{ SQLiteException -> 0x011a }
            r1 = 10
            byte[] r1 = r9.getBlob(r1)     // Catch:{ SQLiteException -> 0x011a }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzar> r2 = com.google.android.gms.measurement.internal.zzar.CREATOR     // Catch:{ SQLiteException -> 0x011a }
            android.os.Parcelable r0 = r0.u(r1, r2)     // Catch:{ SQLiteException -> 0x011a }
            r31 = r0
            com.google.android.gms.measurement.internal.zzar r31 = (com.google.android.gms.measurement.internal.zzar) r31     // Catch:{ SQLiteException -> 0x011a }
            com.google.android.gms.measurement.internal.zzkw r20 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ SQLiteException -> 0x011a }
            r1 = r20
            r2 = r34
            r5 = r11
            r6 = r19
            r1.<init>(r2, r3, r5, r6)     // Catch:{ SQLiteException -> 0x011a }
            com.google.android.gms.measurement.internal.zzw r0 = new com.google.android.gms.measurement.internal.zzw     // Catch:{ SQLiteException -> 0x011a }
            r17 = r0
            r18 = r33
            r21 = r12
            r17.<init>(r18, r19, r20, r21, r23, r24, r25, r26, r28, r29, r31)     // Catch:{ SQLiteException -> 0x011a }
            boolean r1 = r9.moveToNext()     // Catch:{ SQLiteException -> 0x011a }
            if (r1 == 0) goto L_0x0116
            a.d.a.a.i.b.x3 r1 = r32.i()     // Catch:{ SQLiteException -> 0x011a }
            a.d.a.a.i.b.z3 r1 = r1.f     // Catch:{ SQLiteException -> 0x011a }
            java.lang.String r2 = "Got multiple records for conditional property, expected one"
            java.lang.Object r3 = a.d.a.a.i.b.x3.s(r33)     // Catch:{ SQLiteException -> 0x011a }
            a.d.a.a.i.b.v3 r4 = r32.d()     // Catch:{ SQLiteException -> 0x011a }
            java.lang.String r4 = r4.y(r7)     // Catch:{ SQLiteException -> 0x011a }
            r1.c(r2, r3, r4)     // Catch:{ SQLiteException -> 0x011a }
        L_0x0116:
            r9.close()
            return r0
        L_0x011a:
            r0 = move-exception
            goto L_0x012c
        L_0x011c:
            r0 = move-exception
            r10 = r32
            goto L_0x014a
        L_0x0120:
            r0 = move-exception
            r10 = r32
            goto L_0x012c
        L_0x0124:
            r0 = move-exception
            r10 = r32
            goto L_0x014b
        L_0x0128:
            r0 = move-exception
            r10 = r32
            r9 = r8
        L_0x012c:
            a.d.a.a.i.b.x3 r1 = r32.i()     // Catch:{ all -> 0x0149 }
            a.d.a.a.i.b.z3 r1 = r1.f     // Catch:{ all -> 0x0149 }
            java.lang.String r2 = "Error querying conditional property"
            java.lang.Object r3 = a.d.a.a.i.b.x3.s(r33)     // Catch:{ all -> 0x0149 }
            a.d.a.a.i.b.v3 r4 = r32.d()     // Catch:{ all -> 0x0149 }
            java.lang.String r4 = r4.y(r7)     // Catch:{ all -> 0x0149 }
            r1.d(r2, r3, r4, r0)     // Catch:{ all -> 0x0149 }
            if (r9 == 0) goto L_0x0148
            r9.close()
        L_0x0148:
            return r8
        L_0x0149:
            r0 = move-exception
        L_0x014a:
            r8 = r9
        L_0x014b:
            if (r8 == 0) goto L_0x0150
            r8.close()
        L_0x0150:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.d.Z(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzw");
    }

    @WorkerThread
    public final int a0(String str, String str2) {
        b.h(str);
        b.h(str2);
        b();
        n();
        try {
            return t().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e2) {
            i().f.d("Error deleting conditional property", x3.s(str), d().y(str2), e2);
            return 0;
        }
    }

    @WorkerThread
    public final void b0() {
        n();
        t().beginTransaction();
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c2 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<a.d.a.a.h.g.i0>> c0(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.n()
            r12.b()
            a.c.a.f.b.h(r13)
            a.c.a.f.b.h(r14)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.t()
            r9 = 0
            java.lang.String r2 = "event_filters"
            r3 = 2
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x009e, all -> 0x009c }
            java.lang.String r5 = "audience_id"
            r10 = 0
            r4[r10] = r5     // Catch:{ SQLiteException -> 0x009e, all -> 0x009c }
            java.lang.String r5 = "data"
            r11 = 1
            r4[r11] = r5     // Catch:{ SQLiteException -> 0x009e, all -> 0x009c }
            java.lang.String r5 = "app_id=? AND event_name=?"
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x009e, all -> 0x009c }
            r6[r10] = r13     // Catch:{ SQLiteException -> 0x009e, all -> 0x009c }
            r6[r11] = r14     // Catch:{ SQLiteException -> 0x009e, all -> 0x009c }
            r14 = 0
            r7 = 0
            r8 = 0
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r14
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x009e, all -> 0x009c }
            boolean r1 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x009a }
            if (r1 != 0) goto L_0x0046
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x009a }
            r14.close()
            return r13
        L_0x0046:
            byte[] r1 = r14.getBlob(r11)     // Catch:{ SQLiteException -> 0x009a }
            a.d.a.a.h.g.i0 r2 = a.d.a.a.h.g.i0.zzl     // Catch:{ IOException -> 0x0080 }
            a.d.a.a.h.g.y5$b r2 = r2.q()     // Catch:{ IOException -> 0x0080 }
            a.d.a.a.h.g.i0$a r2 = (a.d.a.a.h.g.i0.a) r2     // Catch:{ IOException -> 0x0080 }
            a.d.a.a.h.g.h7 r1 = a.d.a.a.i.b.s9.x(r2, r1)     // Catch:{ IOException -> 0x0080 }
            a.d.a.a.h.g.i0$a r1 = (a.d.a.a.h.g.i0.a) r1     // Catch:{ IOException -> 0x0080 }
            a.d.a.a.h.g.i7 r1 = r1.m()     // Catch:{ IOException -> 0x0080 }
            a.d.a.a.h.g.y5 r1 = (a.d.a.a.h.g.y5) r1     // Catch:{ IOException -> 0x0080 }
            a.d.a.a.h.g.i0 r1 = (a.d.a.a.h.g.i0) r1     // Catch:{ IOException -> 0x0080 }
            int r2 = r14.getInt(r10)     // Catch:{ SQLiteException -> 0x009a }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x009a }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ SQLiteException -> 0x009a }
            java.util.List r3 = (java.util.List) r3     // Catch:{ SQLiteException -> 0x009a }
            if (r3 != 0) goto L_0x007c
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x009a }
            r3.<init>()     // Catch:{ SQLiteException -> 0x009a }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x009a }
            r0.put(r2, r3)     // Catch:{ SQLiteException -> 0x009a }
        L_0x007c:
            r3.add(r1)     // Catch:{ SQLiteException -> 0x009a }
            goto L_0x0090
        L_0x0080:
            r1 = move-exception
            a.d.a.a.i.b.x3 r2 = r12.i()     // Catch:{ SQLiteException -> 0x009a }
            a.d.a.a.i.b.z3 r2 = r2.f     // Catch:{ SQLiteException -> 0x009a }
            java.lang.String r3 = "Failed to merge filter. appId"
            java.lang.Object r4 = a.d.a.a.i.b.x3.s(r13)     // Catch:{ SQLiteException -> 0x009a }
            r2.c(r3, r4, r1)     // Catch:{ SQLiteException -> 0x009a }
        L_0x0090:
            boolean r1 = r14.moveToNext()     // Catch:{ SQLiteException -> 0x009a }
            if (r1 != 0) goto L_0x0046
            r14.close()
            return r0
        L_0x009a:
            r0 = move-exception
            goto L_0x00a1
        L_0x009c:
            r13 = move-exception
            goto L_0x00d4
        L_0x009e:
            r14 = move-exception
            r0 = r14
            r14 = r9
        L_0x00a1:
            a.d.a.a.i.b.x3 r1 = r12.i()     // Catch:{ all -> 0x00d2 }
            a.d.a.a.i.b.z3 r1 = r1.f     // Catch:{ all -> 0x00d2 }
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r3 = a.d.a.a.i.b.x3.s(r13)     // Catch:{ all -> 0x00d2 }
            r1.c(r2, r3, r0)     // Catch:{ all -> 0x00d2 }
            boolean r0 = a.d.a.a.h.g.ra.b()     // Catch:{ all -> 0x00d2 }
            if (r0 == 0) goto L_0x00cc
            a.d.a.a.i.b.c5 r0 = r12.f2563a     // Catch:{ all -> 0x00d2 }
            a.d.a.a.i.b.ka r0 = r0.g     // Catch:{ all -> 0x00d2 }
            a.d.a.a.i.b.n3<java.lang.Boolean> r1 = a.d.a.a.i.b.q.N0     // Catch:{ all -> 0x00d2 }
            boolean r13 = r0.t(r13, r1)     // Catch:{ all -> 0x00d2 }
            if (r13 == 0) goto L_0x00cc
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x00d2 }
            if (r14 == 0) goto L_0x00cb
            r14.close()
        L_0x00cb:
            return r13
        L_0x00cc:
            if (r14 == 0) goto L_0x00d1
            r14.close()
        L_0x00d1:
            return r9
        L_0x00d2:
            r13 = move-exception
            r9 = r14
        L_0x00d4:
            if (r9 == 0) goto L_0x00d9
            r9.close()
        L_0x00d9:
            goto L_0x00db
        L_0x00da:
            throw r13
        L_0x00db:
            goto L_0x00da
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.d.c0(java.lang.String, java.lang.String):java.util.Map");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c1 A[Catch:{ all -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<a.d.a.a.h.g.l0>> d0(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.n()
            r12.b()
            a.c.a.f.b.h(r13)
            a.c.a.f.b.h(r14)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.t()
            r9 = 0
            java.lang.String r2 = "property_filters"
            r3 = 2
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x009e, all -> 0x009c }
            java.lang.String r5 = "audience_id"
            r10 = 0
            r4[r10] = r5     // Catch:{ SQLiteException -> 0x009e, all -> 0x009c }
            java.lang.String r5 = "data"
            r11 = 1
            r4[r11] = r5     // Catch:{ SQLiteException -> 0x009e, all -> 0x009c }
            java.lang.String r5 = "app_id=? AND property_name=?"
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x009e, all -> 0x009c }
            r6[r10] = r13     // Catch:{ SQLiteException -> 0x009e, all -> 0x009c }
            r6[r11] = r14     // Catch:{ SQLiteException -> 0x009e, all -> 0x009c }
            r14 = 0
            r7 = 0
            r8 = 0
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r14
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x009e, all -> 0x009c }
            boolean r1 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x009a }
            if (r1 != 0) goto L_0x0046
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x009a }
            r14.close()
            return r13
        L_0x0046:
            byte[] r1 = r14.getBlob(r11)     // Catch:{ SQLiteException -> 0x009a }
            a.d.a.a.h.g.l0 r2 = a.d.a.a.h.g.l0.zzj     // Catch:{ IOException -> 0x0080 }
            a.d.a.a.h.g.y5$b r2 = r2.q()     // Catch:{ IOException -> 0x0080 }
            a.d.a.a.h.g.l0$a r2 = (a.d.a.a.h.g.l0.a) r2     // Catch:{ IOException -> 0x0080 }
            a.d.a.a.h.g.h7 r1 = a.d.a.a.i.b.s9.x(r2, r1)     // Catch:{ IOException -> 0x0080 }
            a.d.a.a.h.g.l0$a r1 = (a.d.a.a.h.g.l0.a) r1     // Catch:{ IOException -> 0x0080 }
            a.d.a.a.h.g.i7 r1 = r1.m()     // Catch:{ IOException -> 0x0080 }
            a.d.a.a.h.g.y5 r1 = (a.d.a.a.h.g.y5) r1     // Catch:{ IOException -> 0x0080 }
            a.d.a.a.h.g.l0 r1 = (a.d.a.a.h.g.l0) r1     // Catch:{ IOException -> 0x0080 }
            int r2 = r14.getInt(r10)     // Catch:{ SQLiteException -> 0x009a }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x009a }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ SQLiteException -> 0x009a }
            java.util.List r3 = (java.util.List) r3     // Catch:{ SQLiteException -> 0x009a }
            if (r3 != 0) goto L_0x007c
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x009a }
            r3.<init>()     // Catch:{ SQLiteException -> 0x009a }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x009a }
            r0.put(r2, r3)     // Catch:{ SQLiteException -> 0x009a }
        L_0x007c:
            r3.add(r1)     // Catch:{ SQLiteException -> 0x009a }
            goto L_0x0090
        L_0x0080:
            r1 = move-exception
            a.d.a.a.i.b.x3 r2 = r12.i()     // Catch:{ SQLiteException -> 0x009a }
            a.d.a.a.i.b.z3 r2 = r2.f     // Catch:{ SQLiteException -> 0x009a }
            java.lang.String r3 = "Failed to merge filter"
            java.lang.Object r4 = a.d.a.a.i.b.x3.s(r13)     // Catch:{ SQLiteException -> 0x009a }
            r2.c(r3, r4, r1)     // Catch:{ SQLiteException -> 0x009a }
        L_0x0090:
            boolean r1 = r14.moveToNext()     // Catch:{ SQLiteException -> 0x009a }
            if (r1 != 0) goto L_0x0046
            r14.close()
            return r0
        L_0x009a:
            r0 = move-exception
            goto L_0x00a0
        L_0x009c:
            r13 = move-exception
            goto L_0x00d3
        L_0x009e:
            r0 = move-exception
            r14 = r9
        L_0x00a0:
            a.d.a.a.i.b.x3 r1 = r12.i()     // Catch:{ all -> 0x00d1 }
            a.d.a.a.i.b.z3 r1 = r1.f     // Catch:{ all -> 0x00d1 }
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r3 = a.d.a.a.i.b.x3.s(r13)     // Catch:{ all -> 0x00d1 }
            r1.c(r2, r3, r0)     // Catch:{ all -> 0x00d1 }
            boolean r0 = a.d.a.a.h.g.ra.b()     // Catch:{ all -> 0x00d1 }
            if (r0 == 0) goto L_0x00cb
            a.d.a.a.i.b.c5 r0 = r12.f2563a     // Catch:{ all -> 0x00d1 }
            a.d.a.a.i.b.ka r0 = r0.g     // Catch:{ all -> 0x00d1 }
            a.d.a.a.i.b.n3<java.lang.Boolean> r1 = a.d.a.a.i.b.q.N0     // Catch:{ all -> 0x00d1 }
            boolean r13 = r0.t(r13, r1)     // Catch:{ all -> 0x00d1 }
            if (r13 == 0) goto L_0x00cb
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x00d1 }
            if (r14 == 0) goto L_0x00ca
            r14.close()
        L_0x00ca:
            return r13
        L_0x00cb:
            if (r14 == 0) goto L_0x00d0
            r14.close()
        L_0x00d0:
            return r9
        L_0x00d1:
            r13 = move-exception
            r9 = r14
        L_0x00d3:
            if (r9 == 0) goto L_0x00d8
            r9.close()
        L_0x00d8:
            goto L_0x00da
        L_0x00d9:
            throw r13
        L_0x00da:
            goto L_0x00d9
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.d.d0(java.lang.String, java.lang.String):java.util.Map");
    }

    @WorkerThread
    public final void e0() {
        n();
        t().endTransaction();
    }

    public final long f0(String str) {
        b.h(str);
        return w("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    @WorkerThread
    public final long g0(String str, String str2) {
        long w;
        String str3 = str;
        String str4 = str2;
        b.h(str);
        b.h(str2);
        b();
        n();
        SQLiteDatabase t = t();
        t.beginTransaction();
        long j2 = 0;
        try {
            StringBuilder sb = new StringBuilder(str2.length() + 32);
            sb.append("select ");
            sb.append(str4);
            sb.append(" from app2 where app_id=?");
            try {
                w = w(sb.toString(), new String[]{str3}, -1);
                if (w == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str3);
                    contentValues.put("first_open_count", 0);
                    contentValues.put("previous_install_count", 0);
                    if (t.insertWithOnConflict("app2", (String) null, contentValues, 5) == -1) {
                        i().f.c("Failed to insert column (got -1). appId", x3.s(str), str4);
                        t.endTransaction();
                        return -1;
                    }
                    w = 0;
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    i().f.d("Error inserting column. appId", x3.s(str), str4, e);
                    t.endTransaction();
                    return j2;
                } catch (Throwable th) {
                    th = th;
                    t.endTransaction();
                    throw th;
                }
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str3);
                contentValues2.put(str4, Long.valueOf(1 + w));
                if (((long) t.update("app2", contentValues2, "app_id = ?", new String[]{str3})) == 0) {
                    i().f.c("Failed to update column (got 0). appId", x3.s(str), str4);
                    t.endTransaction();
                    return -1;
                }
                t.setTransactionSuccessful();
                t.endTransaction();
                return w;
            } catch (SQLiteException e3) {
                e = e3;
                j2 = w;
                i().f.d("Error inserting column. appId", x3.s(str), str4, e);
                t.endTransaction();
                return j2;
            }
        } catch (SQLiteException e4) {
            e = e4;
            i().f.d("Error inserting column. appId", x3.s(str), str4, e);
            t.endTransaction();
            return j2;
        } catch (Throwable th2) {
            th = th2;
            t.endTransaction();
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle h0(java.lang.String r10) {
        /*
            r9 = this;
            r9.b()
            r9.n()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r9.t()     // Catch:{ SQLiteException -> 0x00af, all -> 0x00ad }
            java.lang.String r2 = "select parameters from default_event_params where app_id=?"
            r3 = 1
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x00af, all -> 0x00ad }
            r5 = 0
            r4[r5] = r10     // Catch:{ SQLiteException -> 0x00af, all -> 0x00ad }
            android.database.Cursor r1 = r1.rawQuery(r2, r4)     // Catch:{ SQLiteException -> 0x00af, all -> 0x00ad }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x00ab }
            if (r2 != 0) goto L_0x002c
            a.d.a.a.i.b.x3 r10 = r9.i()     // Catch:{ SQLiteException -> 0x00ab }
            a.d.a.a.i.b.z3 r10 = r10.n     // Catch:{ SQLiteException -> 0x00ab }
            java.lang.String r2 = "Default event parameters not found"
            r10.a(r2)     // Catch:{ SQLiteException -> 0x00ab }
            r1.close()
            return r0
        L_0x002c:
            byte[] r2 = r1.getBlob(r5)     // Catch:{ SQLiteException -> 0x00ab }
            a.d.a.a.h.g.x0$a r4 = a.d.a.a.h.g.x0.C()     // Catch:{ IOException -> 0x0097 }
            a.d.a.a.h.g.h7 r2 = a.d.a.a.i.b.s9.x(r4, r2)     // Catch:{ IOException -> 0x0097 }
            a.d.a.a.h.g.x0$a r2 = (a.d.a.a.h.g.x0.a) r2     // Catch:{ IOException -> 0x0097 }
            a.d.a.a.h.g.i7 r2 = r2.m()     // Catch:{ IOException -> 0x0097 }
            a.d.a.a.h.g.y5 r2 = (a.d.a.a.h.g.y5) r2     // Catch:{ IOException -> 0x0097 }
            a.d.a.a.h.g.x0 r2 = (a.d.a.a.h.g.x0) r2     // Catch:{ IOException -> 0x0097 }
            r9.l()     // Catch:{ SQLiteException -> 0x00ab }
            a.d.a.a.h.g.f6<a.d.a.a.h.g.z0> r10 = r2.zzd     // Catch:{ SQLiteException -> 0x00ab }
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ SQLiteException -> 0x00ab }
            r2.<init>()     // Catch:{ SQLiteException -> 0x00ab }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ SQLiteException -> 0x00ab }
        L_0x0050:
            boolean r4 = r10.hasNext()     // Catch:{ SQLiteException -> 0x00ab }
            if (r4 == 0) goto L_0x0093
            java.lang.Object r4 = r10.next()     // Catch:{ SQLiteException -> 0x00ab }
            a.d.a.a.h.g.z0 r4 = (a.d.a.a.h.g.z0) r4     // Catch:{ SQLiteException -> 0x00ab }
            java.lang.String r6 = r4.zzd     // Catch:{ SQLiteException -> 0x00ab }
            boolean r7 = r4.B()     // Catch:{ SQLiteException -> 0x00ab }
            if (r7 == 0) goto L_0x006a
            double r7 = r4.zzh     // Catch:{ SQLiteException -> 0x00ab }
            r2.putDouble(r6, r7)     // Catch:{ SQLiteException -> 0x00ab }
            goto L_0x0050
        L_0x006a:
            int r7 = r4.zzc     // Catch:{ SQLiteException -> 0x00ab }
            r7 = r7 & 8
            if (r7 == 0) goto L_0x0072
            r7 = 1
            goto L_0x0073
        L_0x0072:
            r7 = 0
        L_0x0073:
            if (r7 == 0) goto L_0x007b
            float r4 = r4.zzg     // Catch:{ SQLiteException -> 0x00ab }
            r2.putFloat(r6, r4)     // Catch:{ SQLiteException -> 0x00ab }
            goto L_0x0050
        L_0x007b:
            boolean r7 = r4.w()     // Catch:{ SQLiteException -> 0x00ab }
            if (r7 == 0) goto L_0x0087
            java.lang.String r4 = r4.zze     // Catch:{ SQLiteException -> 0x00ab }
            r2.putString(r6, r4)     // Catch:{ SQLiteException -> 0x00ab }
            goto L_0x0050
        L_0x0087:
            boolean r7 = r4.z()     // Catch:{ SQLiteException -> 0x00ab }
            if (r7 == 0) goto L_0x0050
            long r7 = r4.zzf     // Catch:{ SQLiteException -> 0x00ab }
            r2.putLong(r6, r7)     // Catch:{ SQLiteException -> 0x00ab }
            goto L_0x0050
        L_0x0093:
            r1.close()
            return r2
        L_0x0097:
            r2 = move-exception
            a.d.a.a.i.b.x3 r3 = r9.i()     // Catch:{ SQLiteException -> 0x00ab }
            a.d.a.a.i.b.z3 r3 = r3.f     // Catch:{ SQLiteException -> 0x00ab }
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r10 = a.d.a.a.i.b.x3.s(r10)     // Catch:{ SQLiteException -> 0x00ab }
            r3.c(r4, r10, r2)     // Catch:{ SQLiteException -> 0x00ab }
            r1.close()
            return r0
        L_0x00ab:
            r10 = move-exception
            goto L_0x00b1
        L_0x00ad:
            r10 = move-exception
            goto L_0x00c4
        L_0x00af:
            r10 = move-exception
            r1 = r0
        L_0x00b1:
            a.d.a.a.i.b.x3 r2 = r9.i()     // Catch:{ all -> 0x00c2 }
            a.d.a.a.i.b.z3 r2 = r2.f     // Catch:{ all -> 0x00c2 }
            java.lang.String r3 = "Error selecting default event parameters"
            r2.b(r3, r10)     // Catch:{ all -> 0x00c2 }
            if (r1 == 0) goto L_0x00c1
            r1.close()
        L_0x00c1:
            return r0
        L_0x00c2:
            r10 = move-exception
            r0 = r1
        L_0x00c4:
            if (r0 == 0) goto L_0x00c9
            r0.close()
        L_0x00c9:
            goto L_0x00cb
        L_0x00ca:
            throw r10
        L_0x00cb:
            goto L_0x00ca
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.d.h0(java.lang.String):android.os.Bundle");
    }

    @WorkerThread
    public final void i0() {
        b();
        n();
        if (R()) {
            long a2 = k().h.a();
            if (((c) this.f2563a.n) != null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (Math.abs(elapsedRealtime - a2) > q.y.a(null).longValue()) {
                    k().h.b(elapsedRealtime);
                    b();
                    n();
                    if (R()) {
                        SQLiteDatabase t = t();
                        String[] strArr = new String[2];
                        if (((c) this.f2563a.n) != null) {
                            strArr[0] = String.valueOf(System.currentTimeMillis());
                            strArr[1] = String.valueOf(ka.z());
                            int delete = t.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", strArr);
                            if (delete > 0) {
                                i().n.b("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                                return;
                            }
                            return;
                        }
                        throw null;
                    }
                    return;
                }
                return;
            }
            throw null;
        }
    }

    public final long j0() {
        Cursor cursor = null;
        try {
            cursor = t().rawQuery("select rowid from raw_events order by rowid desc limit 1;", (String[]) null);
            if (!cursor.moveToFirst()) {
                cursor.close();
                return -1;
            }
            long j2 = cursor.getLong(0);
            cursor.close();
            return j2;
        } catch (SQLiteException e2) {
            i().f.b("Error querying raw events", e2);
            if (cursor != null) {
                cursor.close();
            }
            return -1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final boolean p() {
        return false;
    }

    @WorkerThread
    public final void s() {
        n();
        t().setTransactionSuccessful();
    }

    @WorkerThread
    public final SQLiteDatabase t() {
        b();
        try {
            return this.f2142d.getWritableDatabase();
        } catch (SQLiteException e2) {
            i().i.b("Error opening database", e2);
            throw e2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003b  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String u() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.t()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch:{ SQLiteException -> 0x0025, all -> 0x0020 }
            boolean r2 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x001e }
            if (r2 == 0) goto L_0x001a
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x001e }
            r0.close()
            return r1
        L_0x001a:
            r0.close()
            return r1
        L_0x001e:
            r2 = move-exception
            goto L_0x0027
        L_0x0020:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x0039
        L_0x0025:
            r2 = move-exception
            r0 = r1
        L_0x0027:
            a.d.a.a.i.b.x3 r3 = r6.i()     // Catch:{ all -> 0x0038 }
            a.d.a.a.i.b.z3 r3 = r3.f     // Catch:{ all -> 0x0038 }
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.b(r4, r2)     // Catch:{ all -> 0x0038 }
            if (r0 == 0) goto L_0x0037
            r0.close()
        L_0x0037:
            return r1
        L_0x0038:
            r1 = move-exception
        L_0x0039:
            if (r0 == 0) goto L_0x003e
            r0.close()
        L_0x003e:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.d.u():java.lang.String");
    }

    public final long v(b1 b1Var) {
        b();
        n();
        b.k(b1Var);
        b.h(b1Var.zzs);
        byte[] j2 = b1Var.j();
        long t = l().t(j2);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", b1Var.zzs);
        contentValues.put("metadata_fingerprint", Long.valueOf(t));
        contentValues.put("metadata", j2);
        try {
            t().insertWithOnConflict("raw_events_metadata", (String) null, contentValues, 4);
            return t;
        } catch (SQLiteException e2) {
            i().f.c("Error storing raw event metadata. appId", x3.s(b1Var.zzs), e2);
            throw e2;
        }
    }

    @WorkerThread
    public final long w(String str, String[] strArr, long j2) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = t().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j3 = rawQuery.getLong(0);
                rawQuery.close();
                return j3;
            }
            rawQuery.close();
            return j2;
        } catch (SQLiteException e2) {
            i().f.c("Database error", str, e2);
            throw e2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0125  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final a.d.a.a.i.b.f x(long r22, java.lang.String r24, long r25, boolean r27, boolean r28, boolean r29, boolean r30, boolean r31) {
        /*
            r21 = this;
            java.lang.String r0 = "daily_realtime_events_count"
            java.lang.String r1 = "daily_error_events_count"
            java.lang.String r2 = "daily_conversions_count"
            java.lang.String r3 = "daily_public_events_count"
            java.lang.String r4 = "daily_events_count"
            java.lang.String r5 = "day"
            a.c.a.f.b.h(r24)
            r21.b()
            r21.n()
            r6 = 1
            java.lang.String[] r7 = new java.lang.String[r6]
            r8 = 0
            r7[r8] = r24
            a.d.a.a.i.b.f r9 = new a.d.a.a.i.b.f
            r9.<init>()
            android.database.sqlite.SQLiteDatabase r15 = r21.t()     // Catch:{ SQLiteException -> 0x010b, all -> 0x0108 }
            java.lang.String r12 = "apps"
            r11 = 6
            java.lang.String[] r13 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x010b, all -> 0x0108 }
            r13[r8] = r5     // Catch:{ SQLiteException -> 0x010b, all -> 0x0108 }
            r13[r6] = r4     // Catch:{ SQLiteException -> 0x010b, all -> 0x0108 }
            r14 = 2
            r13[r14] = r3     // Catch:{ SQLiteException -> 0x010b, all -> 0x0108 }
            r11 = 3
            r13[r11] = r2     // Catch:{ SQLiteException -> 0x010b, all -> 0x0108 }
            r10 = 4
            r13[r10] = r1     // Catch:{ SQLiteException -> 0x010b, all -> 0x0108 }
            r10 = 5
            r13[r10] = r0     // Catch:{ SQLiteException -> 0x010b, all -> 0x0108 }
            java.lang.String r16 = "app_id=?"
            java.lang.String[] r10 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x010b, all -> 0x0108 }
            r10[r8] = r24     // Catch:{ SQLiteException -> 0x010b, all -> 0x0108 }
            r17 = 0
            r18 = 0
            r19 = 0
            r11 = r15
            r14 = r16
            r20 = r15
            r15 = r10
            r16 = r17
            r17 = r18
            r18 = r19
            android.database.Cursor r10 = r11.query(r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SQLiteException -> 0x010b, all -> 0x0108 }
            boolean r11 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x0106 }
            if (r11 != 0) goto L_0x006e
            a.d.a.a.i.b.x3 r0 = r21.i()     // Catch:{ SQLiteException -> 0x0106 }
            a.d.a.a.i.b.z3 r0 = r0.i     // Catch:{ SQLiteException -> 0x0106 }
            java.lang.String r1 = "Not updating daily counts, app is not known. appId"
            java.lang.Object r2 = a.d.a.a.i.b.x3.s(r24)     // Catch:{ SQLiteException -> 0x0106 }
            r0.b(r1, r2)     // Catch:{ SQLiteException -> 0x0106 }
            r10.close()
            return r9
        L_0x006e:
            long r11 = r10.getLong(r8)     // Catch:{ SQLiteException -> 0x0106 }
            int r8 = (r11 > r22 ? 1 : (r11 == r22 ? 0 : -1))
            if (r8 != 0) goto L_0x0098
            long r11 = r10.getLong(r6)     // Catch:{ SQLiteException -> 0x0106 }
            r9.f2178b = r11     // Catch:{ SQLiteException -> 0x0106 }
            r6 = 2
            long r11 = r10.getLong(r6)     // Catch:{ SQLiteException -> 0x0106 }
            r9.f2177a = r11     // Catch:{ SQLiteException -> 0x0106 }
            r6 = 3
            long r11 = r10.getLong(r6)     // Catch:{ SQLiteException -> 0x0106 }
            r9.f2179c = r11     // Catch:{ SQLiteException -> 0x0106 }
            r6 = 4
            long r11 = r10.getLong(r6)     // Catch:{ SQLiteException -> 0x0106 }
            r9.f2180d = r11     // Catch:{ SQLiteException -> 0x0106 }
            r6 = 5
            long r11 = r10.getLong(r6)     // Catch:{ SQLiteException -> 0x0106 }
            r9.f2181e = r11     // Catch:{ SQLiteException -> 0x0106 }
        L_0x0098:
            if (r27 == 0) goto L_0x00a0
            long r11 = r9.f2178b     // Catch:{ SQLiteException -> 0x0106 }
            long r11 = r11 + r25
            r9.f2178b = r11     // Catch:{ SQLiteException -> 0x0106 }
        L_0x00a0:
            if (r28 == 0) goto L_0x00a8
            long r11 = r9.f2177a     // Catch:{ SQLiteException -> 0x0106 }
            long r11 = r11 + r25
            r9.f2177a = r11     // Catch:{ SQLiteException -> 0x0106 }
        L_0x00a8:
            if (r29 == 0) goto L_0x00b0
            long r11 = r9.f2179c     // Catch:{ SQLiteException -> 0x0106 }
            long r11 = r11 + r25
            r9.f2179c = r11     // Catch:{ SQLiteException -> 0x0106 }
        L_0x00b0:
            if (r30 == 0) goto L_0x00b8
            long r11 = r9.f2180d     // Catch:{ SQLiteException -> 0x0106 }
            long r11 = r11 + r25
            r9.f2180d = r11     // Catch:{ SQLiteException -> 0x0106 }
        L_0x00b8:
            if (r31 == 0) goto L_0x00c0
            long r11 = r9.f2181e     // Catch:{ SQLiteException -> 0x0106 }
            long r11 = r11 + r25
            r9.f2181e = r11     // Catch:{ SQLiteException -> 0x0106 }
        L_0x00c0:
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x0106 }
            r6.<init>()     // Catch:{ SQLiteException -> 0x0106 }
            java.lang.Long r8 = java.lang.Long.valueOf(r22)     // Catch:{ SQLiteException -> 0x0106 }
            r6.put(r5, r8)     // Catch:{ SQLiteException -> 0x0106 }
            long r11 = r9.f2177a     // Catch:{ SQLiteException -> 0x0106 }
            java.lang.Long r5 = java.lang.Long.valueOf(r11)     // Catch:{ SQLiteException -> 0x0106 }
            r6.put(r3, r5)     // Catch:{ SQLiteException -> 0x0106 }
            long r11 = r9.f2178b     // Catch:{ SQLiteException -> 0x0106 }
            java.lang.Long r3 = java.lang.Long.valueOf(r11)     // Catch:{ SQLiteException -> 0x0106 }
            r6.put(r4, r3)     // Catch:{ SQLiteException -> 0x0106 }
            long r3 = r9.f2179c     // Catch:{ SQLiteException -> 0x0106 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ SQLiteException -> 0x0106 }
            r6.put(r2, r3)     // Catch:{ SQLiteException -> 0x0106 }
            long r2 = r9.f2180d     // Catch:{ SQLiteException -> 0x0106 }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ SQLiteException -> 0x0106 }
            r6.put(r1, r2)     // Catch:{ SQLiteException -> 0x0106 }
            long r1 = r9.f2181e     // Catch:{ SQLiteException -> 0x0106 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ SQLiteException -> 0x0106 }
            r6.put(r0, r1)     // Catch:{ SQLiteException -> 0x0106 }
            java.lang.String r0 = "apps"
            java.lang.String r1 = "app_id=?"
            r2 = r20
            r2.update(r0, r6, r1, r7)     // Catch:{ SQLiteException -> 0x0106 }
            r10.close()
            return r9
        L_0x0106:
            r0 = move-exception
            goto L_0x010d
        L_0x0108:
            r0 = move-exception
            r10 = 0
            goto L_0x0123
        L_0x010b:
            r0 = move-exception
            r10 = 0
        L_0x010d:
            a.d.a.a.i.b.x3 r1 = r21.i()     // Catch:{ all -> 0x0122 }
            a.d.a.a.i.b.z3 r1 = r1.f     // Catch:{ all -> 0x0122 }
            java.lang.String r2 = "Error updating daily counts. appId"
            java.lang.Object r3 = a.d.a.a.i.b.x3.s(r24)     // Catch:{ all -> 0x0122 }
            r1.c(r2, r3, r0)     // Catch:{ all -> 0x0122 }
            if (r10 == 0) goto L_0x0121
            r10.close()
        L_0x0121:
            return r9
        L_0x0122:
            r0 = move-exception
        L_0x0123:
            if (r10 == 0) goto L_0x0128
            r10.close()
        L_0x0128:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.d.x(long, java.lang.String, long, boolean, boolean, boolean, boolean, boolean):a.d.a.a.i.b.f");
    }

    @WorkerThread
    public final f y(long j2, String str, boolean z, boolean z2) {
        return x(j2, str, 1, false, false, z, false, z2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0162  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final a.d.a.a.i.b.l z(java.lang.String r28, java.lang.String r29) {
        /*
            r27 = this;
            r15 = r29
            a.c.a.f.b.h(r28)
            a.c.a.f.b.h(r29)
            r27.b()
            r27.n()
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 9
            java.lang.String[] r1 = new java.lang.String[r1]
            java.lang.String r2 = "lifetime_count"
            r3 = 0
            r1[r3] = r2
            java.lang.String r2 = "current_bundle_count"
            r4 = 1
            r1[r4] = r2
            java.lang.String r2 = "last_fire_timestamp"
            r5 = 2
            r1[r5] = r2
            java.lang.String r2 = "last_bundled_timestamp"
            r6 = 3
            r1[r6] = r2
            java.lang.String r2 = "last_bundled_day"
            r7 = 4
            r1[r7] = r2
            java.lang.String r2 = "last_sampled_complex_event_id"
            r8 = 5
            r1[r8] = r2
            java.lang.String r2 = "last_sampling_rate"
            r9 = 6
            r1[r9] = r2
            java.lang.String r2 = "last_exempt_from_sampling"
            r10 = 7
            r1[r10] = r2
            java.lang.String r2 = "current_session_count"
            r11 = 8
            r1[r11] = r2
            java.util.List r1 = java.util.Arrays.asList(r1)
            r0.<init>(r1)
            r18 = 0
            android.database.sqlite.SQLiteDatabase r19 = r27.t()     // Catch:{ SQLiteException -> 0x013b, all -> 0x0139 }
            java.lang.String r20 = "events"
            java.lang.String[] r1 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x013b, all -> 0x0139 }
            java.lang.Object[] r0 = r0.toArray(r1)     // Catch:{ SQLiteException -> 0x013b, all -> 0x0139 }
            r21 = r0
            java.lang.String[] r21 = (java.lang.String[]) r21     // Catch:{ SQLiteException -> 0x013b, all -> 0x0139 }
            java.lang.String r22 = "app_id=? and name=?"
            java.lang.String[] r0 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x013b, all -> 0x0139 }
            r0[r3] = r28     // Catch:{ SQLiteException -> 0x013b, all -> 0x0139 }
            r0[r4] = r15     // Catch:{ SQLiteException -> 0x013b, all -> 0x0139 }
            r24 = 0
            r25 = 0
            r26 = 0
            r23 = r0
            android.database.Cursor r14 = r19.query(r20, r21, r22, r23, r24, r25, r26)     // Catch:{ SQLiteException -> 0x013b, all -> 0x0139 }
            boolean r0 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x0135, all -> 0x012f }
            if (r0 != 0) goto L_0x0079
            r14.close()
            return r18
        L_0x0079:
            long r12 = r14.getLong(r3)     // Catch:{ SQLiteException -> 0x0135, all -> 0x012f }
            long r16 = r14.getLong(r4)     // Catch:{ SQLiteException -> 0x0135, all -> 0x012f }
            long r19 = r14.getLong(r5)     // Catch:{ SQLiteException -> 0x0135, all -> 0x012f }
            boolean r0 = r14.isNull(r6)     // Catch:{ SQLiteException -> 0x0135, all -> 0x012f }
            r1 = 0
            if (r0 == 0) goto L_0x0090
            r21 = r1
            goto L_0x0096
        L_0x0090:
            long r5 = r14.getLong(r6)     // Catch:{ SQLiteException -> 0x0135, all -> 0x012f }
            r21 = r5
        L_0x0096:
            boolean r0 = r14.isNull(r7)     // Catch:{ SQLiteException -> 0x0135, all -> 0x012f }
            if (r0 == 0) goto L_0x009f
            r0 = r18
            goto L_0x00a7
        L_0x009f:
            long r5 = r14.getLong(r7)     // Catch:{ SQLiteException -> 0x0135, all -> 0x012f }
            java.lang.Long r0 = java.lang.Long.valueOf(r5)     // Catch:{ SQLiteException -> 0x0135, all -> 0x012f }
        L_0x00a7:
            boolean r5 = r14.isNull(r8)     // Catch:{ SQLiteException -> 0x0135, all -> 0x012f }
            if (r5 == 0) goto L_0x00b0
            r23 = r18
            goto L_0x00ba
        L_0x00b0:
            long r5 = r14.getLong(r8)     // Catch:{ SQLiteException -> 0x0135, all -> 0x012f }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ SQLiteException -> 0x0135, all -> 0x012f }
            r23 = r5
        L_0x00ba:
            boolean r5 = r14.isNull(r9)     // Catch:{ SQLiteException -> 0x0135, all -> 0x012f }
            if (r5 == 0) goto L_0x00c3
            r24 = r18
            goto L_0x00cd
        L_0x00c3:
            long r5 = r14.getLong(r9)     // Catch:{ SQLiteException -> 0x0135, all -> 0x012f }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ SQLiteException -> 0x0135, all -> 0x012f }
            r24 = r5
        L_0x00cd:
            boolean r5 = r14.isNull(r10)     // Catch:{ SQLiteException -> 0x0135, all -> 0x012f }
            if (r5 != 0) goto L_0x00e7
            long r5 = r14.getLong(r10)     // Catch:{ SQLiteException -> 0x00e5 }
            r7 = 1
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x00de
            r3 = 1
        L_0x00de:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ SQLiteException -> 0x00e5 }
            r25 = r3
            goto L_0x00e9
        L_0x00e5:
            r0 = move-exception
            goto L_0x013e
        L_0x00e7:
            r25 = r18
        L_0x00e9:
            boolean r3 = r14.isNull(r11)     // Catch:{ SQLiteException -> 0x0135, all -> 0x012f }
            if (r3 == 0) goto L_0x00f0
            goto L_0x00f4
        L_0x00f0:
            long r1 = r14.getLong(r11)     // Catch:{ SQLiteException -> 0x0135, all -> 0x012f }
        L_0x00f4:
            r8 = r1
            a.d.a.a.i.b.l r26 = new a.d.a.a.i.b.l     // Catch:{ SQLiteException -> 0x0135, all -> 0x012f }
            r1 = r26
            r2 = r28
            r3 = r29
            r4 = r12
            r6 = r16
            r10 = r19
            r12 = r21
            r19 = r14
            r14 = r0
            r15 = r23
            r16 = r24
            r17 = r25
            r1.<init>(r2, r3, r4, r6, r8, r10, r12, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x012b, all -> 0x0129 }
            boolean r0 = r19.moveToNext()     // Catch:{ SQLiteException -> 0x012b, all -> 0x0129 }
            if (r0 == 0) goto L_0x0125
            a.d.a.a.i.b.x3 r0 = r27.i()     // Catch:{ SQLiteException -> 0x012b, all -> 0x0129 }
            a.d.a.a.i.b.z3 r0 = r0.f     // Catch:{ SQLiteException -> 0x012b, all -> 0x0129 }
            java.lang.String r1 = "Got multiple records for event aggregates, expected one. appId"
            java.lang.Object r2 = a.d.a.a.i.b.x3.s(r28)     // Catch:{ SQLiteException -> 0x012b, all -> 0x0129 }
            r0.b(r1, r2)     // Catch:{ SQLiteException -> 0x012b, all -> 0x0129 }
        L_0x0125:
            r19.close()
            return r26
        L_0x0129:
            r0 = move-exception
            goto L_0x0132
        L_0x012b:
            r0 = move-exception
            r14 = r19
            goto L_0x013e
        L_0x012f:
            r0 = move-exception
            r19 = r14
        L_0x0132:
            r18 = r19
            goto L_0x0160
        L_0x0135:
            r0 = move-exception
            r19 = r14
            goto L_0x013e
        L_0x0139:
            r0 = move-exception
            goto L_0x0160
        L_0x013b:
            r0 = move-exception
            r14 = r18
        L_0x013e:
            a.d.a.a.i.b.x3 r1 = r27.i()     // Catch:{ all -> 0x015d }
            a.d.a.a.i.b.z3 r1 = r1.f     // Catch:{ all -> 0x015d }
            java.lang.String r2 = "Error querying events. appId"
            java.lang.Object r3 = a.d.a.a.i.b.x3.s(r28)     // Catch:{ all -> 0x015d }
            a.d.a.a.i.b.v3 r4 = r27.d()     // Catch:{ all -> 0x015d }
            r5 = r29
            java.lang.String r4 = r4.u(r5)     // Catch:{ all -> 0x015d }
            r1.d(r2, r3, r4, r0)     // Catch:{ all -> 0x015d }
            if (r14 == 0) goto L_0x015c
            r14.close()
        L_0x015c:
            return r18
        L_0x015d:
            r0 = move-exception
            r18 = r14
        L_0x0160:
            if (r18 == 0) goto L_0x0165
            r18.close()
        L_0x0165:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.d.z(java.lang.String, java.lang.String):a.d.a.a.i.b.l");
    }
}
