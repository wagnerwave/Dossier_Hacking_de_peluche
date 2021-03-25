package a.d.a.a.i.b;

import a.c.a.f.b;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.WorkerThread;

public final class g extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f2201a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(d dVar, Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.f2201a = dVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0027 A[SYNTHETIC, Splitter:B:9:0x0027] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.database.sqlite.SQLiteDatabase getWritableDatabase() {
        /*
            r8 = this;
            a.d.a.a.i.b.d r0 = r8.f2201a
            a.d.a.a.i.b.i9 r0 = r0.f2143e
            long r1 = r0.f2278b
            r3 = 0
            r4 = 0
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x000e
            goto L_0x0022
        L_0x000e:
            a.d.a.a.e.q.b r1 = r0.f2277a
            a.d.a.a.e.q.c r1 = (a.d.a.a.e.q.c) r1
            if (r1 == 0) goto L_0x008b
            long r1 = android.os.SystemClock.elapsedRealtime()
            long r6 = r0.f2278b
            long r1 = r1 - r6
            r6 = 3600000(0x36ee80, double:1.7786363E-317)
            int r0 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r0 < 0) goto L_0x0024
        L_0x0022:
            r0 = 1
            goto L_0x0025
        L_0x0024:
            r0 = 0
        L_0x0025:
            if (r0 == 0) goto L_0x0083
            android.database.sqlite.SQLiteDatabase r0 = super.getWritableDatabase()     // Catch:{ SQLiteException -> 0x002c }
            return r0
        L_0x002c:
            a.d.a.a.i.b.d r0 = r8.f2201a
            a.d.a.a.i.b.i9 r0 = r0.f2143e
            a.d.a.a.e.q.b r1 = r0.f2277a
            a.d.a.a.e.q.c r1 = (a.d.a.a.e.q.c) r1
            if (r1 == 0) goto L_0x0082
            long r1 = android.os.SystemClock.elapsedRealtime()
            r0.f2278b = r1
            a.d.a.a.i.b.d r0 = r8.f2201a
            a.d.a.a.i.b.x3 r0 = r0.i()
            a.d.a.a.i.b.z3 r0 = r0.f
            java.lang.String r1 = "Opening the database failed, dropping and recreating it"
            r0.a(r1)
            java.lang.String r0 = "google_app_measurement.db"
            a.d.a.a.i.b.d r1 = r8.f2201a
            a.d.a.a.i.b.c5 r1 = r1.f2563a
            android.content.Context r1 = r1.f2123a
            java.io.File r1 = r1.getDatabasePath(r0)
            boolean r1 = r1.delete()
            if (r1 != 0) goto L_0x0068
            a.d.a.a.i.b.d r1 = r8.f2201a
            a.d.a.a.i.b.x3 r1 = r1.i()
            a.d.a.a.i.b.z3 r1 = r1.f
            java.lang.String r2 = "Failed to delete corrupted db file"
            r1.b(r2, r0)
        L_0x0068:
            android.database.sqlite.SQLiteDatabase r0 = super.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0073 }
            a.d.a.a.i.b.d r1 = r8.f2201a     // Catch:{ SQLiteException -> 0x0073 }
            a.d.a.a.i.b.i9 r1 = r1.f2143e     // Catch:{ SQLiteException -> 0x0073 }
            r1.f2278b = r4     // Catch:{ SQLiteException -> 0x0073 }
            return r0
        L_0x0073:
            r0 = move-exception
            a.d.a.a.i.b.d r1 = r8.f2201a
            a.d.a.a.i.b.x3 r1 = r1.i()
            a.d.a.a.i.b.z3 r1 = r1.f
            java.lang.String r2 = "Failed to open freshly created database"
            r1.b(r2, r0)
            throw r0
        L_0x0082:
            throw r3
        L_0x0083:
            android.database.sqlite.SQLiteException r0 = new android.database.sqlite.SQLiteException
            java.lang.String r1 = "Database open failed"
            r0.<init>(r1)
            throw r0
        L_0x008b:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.g.getWritableDatabase():android.database.sqlite.SQLiteDatabase");
    }

    @WorkerThread
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        b.l1(this.f2201a.i(), sQLiteDatabase);
    }

    @WorkerThread
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @WorkerThread
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        b.m1(this.f2201a.i(), sQLiteDatabase2, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", d.f);
        b.m1(this.f2201a.i(), sQLiteDatabase2, "conditional_properties", "CREATE TABLE IF NOT EXISTS conditional_properties ( app_id TEXT NOT NULL, origin TEXT NOT NULL, name TEXT NOT NULL, value BLOB NOT NULL, creation_timestamp INTEGER NOT NULL, active INTEGER NOT NULL, trigger_event_name TEXT, trigger_timeout INTEGER NOT NULL, timed_out_event BLOB,triggered_event BLOB, triggered_timestamp INTEGER NOT NULL, time_to_live INTEGER NOT NULL, expired_event BLOB, PRIMARY KEY (app_id, name)) ;", "app_id,origin,name,value,active,trigger_event_name,trigger_timeout,creation_timestamp,timed_out_event,triggered_event,triggered_timestamp,time_to_live,expired_event", (String[]) null);
        b.m1(this.f2201a.i(), sQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", d.g);
        b.m1(this.f2201a.i(), sQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", d.h);
        SQLiteDatabase sQLiteDatabase3 = sQLiteDatabase;
        b.m1(this.f2201a.i(), sQLiteDatabase3, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", d.j);
        b.m1(this.f2201a.i(), sQLiteDatabase3, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", (String[]) null);
        b.m1(this.f2201a.i(), sQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", d.i);
        b.m1(this.f2201a.i(), sQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", d.k);
        SQLiteDatabase sQLiteDatabase4 = sQLiteDatabase;
        b.m1(this.f2201a.i(), sQLiteDatabase4, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", d.l);
        b.m1(this.f2201a.i(), sQLiteDatabase4, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", (String[]) null);
        SQLiteDatabase sQLiteDatabase5 = sQLiteDatabase;
        b.m1(this.f2201a.i(), sQLiteDatabase5, "app2", "CREATE TABLE IF NOT EXISTS app2 ( app_id TEXT NOT NULL, first_open_count INTEGER NOT NULL, PRIMARY KEY (app_id));", "app_id,first_open_count", d.m);
        b.m1(this.f2201a.i(), sQLiteDatabase5, "main_event_params", "CREATE TABLE IF NOT EXISTS main_event_params ( app_id TEXT NOT NULL, event_id TEXT NOT NULL, children_to_process INTEGER NOT NULL, main_event BLOB NOT NULL, PRIMARY KEY (app_id));", "app_id,event_id,children_to_process,main_event", (String[]) null);
        b.m1(this.f2201a.i(), sQLiteDatabase5, "default_event_params", "CREATE TABLE IF NOT EXISTS default_event_params ( app_id TEXT NOT NULL, parameters BLOB NOT NULL, PRIMARY KEY (app_id));", "app_id,parameters", (String[]) null);
        b.m1(this.f2201a.i(), sQLiteDatabase5, "consent_settings", "CREATE TABLE IF NOT EXISTS consent_settings ( app_id TEXT NOT NULL, consent_state TEXT NOT NULL, PRIMARY KEY (app_id));", "app_id,consent_state", (String[]) null);
    }

    @WorkerThread
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
