package a.d.a.a.h.g;

import a.d.a.a.e.q.c;
import a.d.a.a.i.b.d6;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class f {
    public static volatile f i;
    public static Boolean j;

    /* renamed from: a  reason: collision with root package name */
    public final String f1681a;

    /* renamed from: b  reason: collision with root package name */
    public final a.d.a.a.e.q.b f1682b;

    /* renamed from: c  reason: collision with root package name */
    public final ExecutorService f1683c;

    /* renamed from: d  reason: collision with root package name */
    public final a.d.a.a.i.a.a f1684d;

    /* renamed from: e  reason: collision with root package name */
    public List<Pair<d6, Object>> f1685e;
    public int f;
    public boolean g;
    public nd h;

    public abstract class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final long f1686a;

        /* renamed from: b  reason: collision with root package name */
        public final long f1687b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f1688c;

        public a(boolean z) {
            if (((c) f.this.f1682b) != null) {
                this.f1686a = System.currentTimeMillis();
                if (((c) f.this.f1682b) != null) {
                    this.f1687b = SystemClock.elapsedRealtime();
                    this.f1688c = z;
                    return;
                }
                throw null;
            }
            throw null;
        }

        public abstract void a();

        public void b() {
        }

        public void run() {
            if (f.this.g) {
                b();
                return;
            }
            try {
                a();
            } catch (Exception e2) {
                f.this.b(e2, false, this.f1688c);
                b();
            }
        }
    }

    public class b implements Application.ActivityLifecycleCallbacks {
        public b() {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            f fVar = f.this;
            fVar.f1683c.execute(new b0(this, bundle, activity));
        }

        public final void onActivityDestroyed(Activity activity) {
            f fVar = f.this;
            fVar.f1683c.execute(new g0(this, activity));
        }

        public final void onActivityPaused(Activity activity) {
            f fVar = f.this;
            fVar.f1683c.execute(new c0(this, activity));
        }

        public final void onActivityResumed(Activity activity) {
            f fVar = f.this;
            fVar.f1683c.execute(new d0(this, activity));
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            ld ldVar = new ld();
            f fVar = f.this;
            fVar.f1683c.execute(new e0(this, activity, ldVar));
            Bundle U = ldVar.U(50);
            if (U != null) {
                bundle.putAll(U);
            }
        }

        public final void onActivityStarted(Activity activity) {
            f fVar = f.this;
            fVar.f1683c.execute(new a0(this, activity));
        }

        public final void onActivityStopped(Activity activity) {
            f fVar = f.this;
            fVar.f1683c.execute(new f0(this, activity));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public f(android.content.Context r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, android.os.Bundle r13) {
        /*
            r8 = this;
            r8.<init>()
            if (r10 == 0) goto L_0x000b
            boolean r0 = e(r11, r12)
            if (r0 != 0) goto L_0x000d
        L_0x000b:
            java.lang.String r10 = "FA"
        L_0x000d:
            r8.f1681a = r10
            a.d.a.a.e.q.c r10 = a.d.a.a.e.q.c.f1429a
            r8.f1682b = r10
            a.d.a.a.h.g.n r7 = new a.d.a.a.h.g.n
            r7.<init>()
            java.util.concurrent.ThreadPoolExecutor r10 = new java.util.concurrent.ThreadPoolExecutor
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS
            java.util.concurrent.LinkedBlockingQueue r6 = new java.util.concurrent.LinkedBlockingQueue
            r6.<init>()
            r1 = 1
            r2 = 1
            r3 = 60
            r0 = r10
            r0.<init>(r1, r2, r3, r5, r6, r7)
            r0 = 1
            r10.allowCoreThreadTimeOut(r0)
            java.util.concurrent.ExecutorService r10 = java.util.concurrent.Executors.unconfigurableExecutorService(r10)
            r8.f1683c = r10
            a.d.a.a.i.a.a r10 = new a.d.a.a.i.a.a
            r10.<init>(r8)
            r8.f1684d = r10
            r10 = 0
            java.lang.String r1 = "google_app_id"
            java.lang.String r1 = a.c.a.f.b.Z0(r9, r1)     // Catch:{ IllegalStateException -> 0x0045 }
            if (r1 == 0) goto L_0x0045
            r1 = 1
            goto L_0x0046
        L_0x0045:
            r1 = 0
        L_0x0046:
            if (r1 == 0) goto L_0x0055
            java.lang.String r1 = "com.google.firebase.analytics.FirebaseAnalytics"
            java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x004f }
            r1 = 1
            goto L_0x0050
        L_0x004f:
            r1 = 0
        L_0x0050:
            if (r1 == 0) goto L_0x0053
            goto L_0x0055
        L_0x0053:
            r1 = 0
            goto L_0x0056
        L_0x0055:
            r1 = 1
        L_0x0056:
            if (r1 != 0) goto L_0x0062
            r8.g = r0
            java.lang.String r9 = r8.f1681a
            java.lang.String r10 = "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection."
            android.util.Log.w(r9, r10)
            return
        L_0x0062:
            boolean r1 = e(r11, r12)
            if (r1 != 0) goto L_0x0088
            if (r11 == 0) goto L_0x0074
            if (r12 == 0) goto L_0x0074
            java.lang.String r10 = r8.f1681a
            java.lang.String r0 = "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy"
            android.util.Log.v(r10, r0)
            goto L_0x0088
        L_0x0074:
            if (r11 != 0) goto L_0x0078
            r1 = 1
            goto L_0x0079
        L_0x0078:
            r1 = 0
        L_0x0079:
            if (r12 != 0) goto L_0x007c
            goto L_0x007d
        L_0x007c:
            r0 = 0
        L_0x007d:
            r10 = r1 ^ r0
            if (r10 == 0) goto L_0x0088
            java.lang.String r10 = r8.f1681a
            java.lang.String r0 = "Specified origin or custom app id is null. Both parameters will be ignored."
            android.util.Log.w(r10, r0)
        L_0x0088:
            a.d.a.a.h.g.i r10 = new a.d.a.a.h.g.i
            r1 = r10
            r2 = r8
            r3 = r11
            r4 = r12
            r5 = r9
            r6 = r13
            r1.<init>(r2, r3, r4, r5, r6)
            java.util.concurrent.ExecutorService r11 = r8.f1683c
            r11.execute(r10)
            android.content.Context r9 = r9.getApplicationContext()
            android.app.Application r9 = (android.app.Application) r9
            if (r9 != 0) goto L_0x00a8
            java.lang.String r9 = r8.f1681a
            java.lang.String r10 = "Unable to register lifecycle notifications. Application null."
            android.util.Log.w(r9, r10)
            return
        L_0x00a8:
            a.d.a.a.h.g.f$b r10 = new a.d.a.a.h.g.f$b
            r10.<init>()
            r9.registerActivityLifecycleCallbacks(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.f.<init>(android.content.Context, java.lang.String, java.lang.String, java.lang.String, android.os.Bundle):void");
    }

    public static f a(Context context, String str, String str2, String str3, Bundle bundle) {
        a.c.a.f.b.k(context);
        if (i == null) {
            synchronized (f.class) {
                if (i == null) {
                    i = new f(context, (String) null, (String) null, (String) null, bundle);
                }
            }
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x002e A[SYNTHETIC, Splitter:B:21:0x002e] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0033 A[Catch:{ Exception -> 0x0054 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void d(android.content.Context r6) {
        /*
            java.lang.Class<a.d.a.a.h.g.f> r0 = a.d.a.a.h.g.f.class
            monitor-enter(r0)
            java.lang.Boolean r1 = j     // Catch:{ Exception -> 0x0054 }
            if (r1 == 0) goto L_0x0009
        L_0x0007:
            monitor-exit(r0)     // Catch:{ all -> 0x0052 }
            goto L_0x0061
        L_0x0009:
            java.lang.String r1 = "app_measurement_internal_disable_startup_flags"
            a.c.a.f.b.h(r1)     // Catch:{ Exception -> 0x0054 }
            r2 = 0
            a.d.a.a.e.r.b r3 = a.d.a.a.e.r.c.a(r6)     // Catch:{ NameNotFoundException -> 0x002b }
            java.lang.String r4 = r6.getPackageName()     // Catch:{ NameNotFoundException -> 0x002b }
            r5 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r3 = r3.a(r4, r5)     // Catch:{ NameNotFoundException -> 0x002b }
            if (r3 == 0) goto L_0x002b
            android.os.Bundle r4 = r3.metaData     // Catch:{ NameNotFoundException -> 0x002b }
            if (r4 != 0) goto L_0x0024
            goto L_0x002b
        L_0x0024:
            android.os.Bundle r3 = r3.metaData     // Catch:{ NameNotFoundException -> 0x002b }
            boolean r1 = r3.getBoolean(r1)     // Catch:{ NameNotFoundException -> 0x002b }
            goto L_0x002c
        L_0x002b:
            r1 = 0
        L_0x002c:
            if (r1 == 0) goto L_0x0033
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x0054 }
            j = r6     // Catch:{ Exception -> 0x0054 }
            goto L_0x0007
        L_0x0033:
            java.lang.String r1 = "com.google.android.gms.measurement.prefs"
            android.content.SharedPreferences r6 = r6.getSharedPreferences(r1, r2)     // Catch:{ Exception -> 0x0054 }
            java.lang.String r1 = "allow_remote_dynamite"
            boolean r1 = r6.getBoolean(r1, r2)     // Catch:{ Exception -> 0x0054 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ Exception -> 0x0054 }
            j = r1     // Catch:{ Exception -> 0x0054 }
            android.content.SharedPreferences$Editor r6 = r6.edit()     // Catch:{ Exception -> 0x0054 }
            java.lang.String r1 = "allow_remote_dynamite"
            r6.remove(r1)     // Catch:{ Exception -> 0x0054 }
            r6.apply()     // Catch:{ Exception -> 0x0054 }
            goto L_0x0007
        L_0x0052:
            r6 = move-exception
            goto L_0x0062
        L_0x0054:
            r6 = move-exception
            java.lang.String r1 = "FA"
            java.lang.String r2 = "Exception reading flag from SharedPreferences."
            android.util.Log.e(r1, r2, r6)     // Catch:{ all -> 0x0052 }
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0052 }
            j = r6     // Catch:{ all -> 0x0052 }
            goto L_0x0007
        L_0x0061:
            return
        L_0x0062:
            monitor-exit(r0)     // Catch:{ all -> 0x0052 }
            goto L_0x0065
        L_0x0064:
            throw r6
        L_0x0065:
            goto L_0x0064
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.f.d(android.content.Context):void");
    }

    public static boolean e(String str, String str2) {
        boolean z;
        if (!(str2 == null || str == null)) {
            try {
                Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
                z = true;
            } catch (ClassNotFoundException unused) {
                z = false;
            }
            if (!z) {
                return true;
            }
        }
        return false;
    }

    public final void b(Exception exc, boolean z, boolean z2) {
        this.g |= z;
        if (z) {
            Log.w(this.f1681a, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            this.f1683c.execute(new x(this, "Error with data collection. Data lost.", exc));
        }
        Log.w(this.f1681a, "Error with data collection. Data lost.", exc);
    }

    public final void c(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        this.f1683c.execute(new z(this, (Long) null, str, str2, bundle, z, z2));
    }
}
