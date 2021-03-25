package a.d.a.a.a.a;

import a.d.a.a.e.d;
import a.d.a.a.e.e;
import a.d.a.a.e.g;
import a.d.a.a.h.a.c;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import com.tuya.smart.common.oOO0O0O0;
import com.tuya.smart.mqtt.MqttServiceConstants;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
public class a {
    @GuardedBy("this")
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public a.d.a.a.e.a f1165a;
    @GuardedBy("this")
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public a.d.a.a.h.a.b f1166b;
    @GuardedBy("this")

    /* renamed from: c  reason: collision with root package name */
    public boolean f1167c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f1168d = new Object();
    @GuardedBy("mAutoDisconnectTaskLock")
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public b f1169e;
    @GuardedBy("this")
    public final Context f;
    public final boolean g;
    public final long h;

    /* renamed from: a.d.a.a.a.a.a$a  reason: collision with other inner class name */
    public static final class C0053a {

        /* renamed from: a  reason: collision with root package name */
        public final String f1170a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f1171b;

        public C0053a(String str, boolean z) {
            this.f1170a = str;
            this.f1171b = z;
        }

        public final String toString() {
            String str = this.f1170a;
            boolean z = this.f1171b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(z);
            return sb.toString();
        }
    }

    public static class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<a> f1172a;

        /* renamed from: b  reason: collision with root package name */
        public long f1173b;

        /* renamed from: c  reason: collision with root package name */
        public CountDownLatch f1174c = new CountDownLatch(1);

        /* renamed from: d  reason: collision with root package name */
        public boolean f1175d = false;

        public b(a aVar, long j) {
            this.f1172a = new WeakReference<>(aVar);
            this.f1173b = j;
            start();
        }

        public final void run() {
            a aVar;
            try {
                if (!this.f1174c.await(this.f1173b, TimeUnit.MILLISECONDS) && (aVar = (a) this.f1172a.get()) != null) {
                    aVar.a();
                    this.f1175d = true;
                }
            } catch (InterruptedException unused) {
                a aVar2 = (a) this.f1172a.get();
                if (aVar2 != null) {
                    aVar2.a();
                    this.f1175d = true;
                }
            }
        }
    }

    public a(Context context, long j, boolean z, boolean z2) {
        Context applicationContext;
        a.c.a.f.b.k(context);
        if (z && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.f = context;
        this.f1167c = false;
        this.h = j;
        this.g = z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c A[Catch:{ all -> 0x0034 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002d A[Catch:{ all -> 0x0034 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static a.d.a.a.a.a.a.C0053a b(android.content.Context r13) {
        /*
            java.lang.String r0 = "Error while reading from SharedPreferences "
            java.lang.String r1 = "GmscoreFlag"
            a.d.a.a.a.a.c r2 = new a.d.a.a.a.a.c
            r2.<init>(r13)
            java.lang.String r3 = "gads:ad_id_app_context:enabled"
            boolean r3 = r2.a(r3)
            java.lang.String r4 = "gads:ad_id_app_context:ping_ratio"
            r5 = 0
            android.content.SharedPreferences r6 = r2.f1177a     // Catch:{ all -> 0x001f }
            if (r6 != 0) goto L_0x0017
            goto L_0x0023
        L_0x0017:
            android.content.SharedPreferences r6 = r2.f1177a     // Catch:{ all -> 0x001f }
            float r4 = r6.getFloat(r4, r5)     // Catch:{ all -> 0x001f }
            r12 = r4
            goto L_0x0024
        L_0x001f:
            r4 = move-exception
            android.util.Log.w(r1, r0, r4)
        L_0x0023:
            r12 = 0
        L_0x0024:
            java.lang.String r4 = "gads:ad_id_use_shared_preference:experiment_id"
            java.lang.String r5 = ""
            android.content.SharedPreferences r6 = r2.f1177a     // Catch:{ all -> 0x0034 }
            if (r6 != 0) goto L_0x002d
            goto L_0x0038
        L_0x002d:
            android.content.SharedPreferences r6 = r2.f1177a     // Catch:{ all -> 0x0034 }
            java.lang.String r0 = r6.getString(r4, r5)     // Catch:{ all -> 0x0034 }
            goto L_0x0039
        L_0x0034:
            r4 = move-exception
            android.util.Log.w(r1, r0, r4)
        L_0x0038:
            r0 = r5
        L_0x0039:
            java.lang.String r1 = "gads:ad_id_use_persistent_service:enabled"
            boolean r9 = r2.a(r1)
            a.d.a.a.a.a.a r1 = new a.d.a.a.a.a.a
            r6 = -1
            r4 = r1
            r5 = r13
            r8 = r3
            r4.<init>(r5, r6, r8, r9)
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0068 }
            r13 = 0
            r1.f(r13)     // Catch:{ all -> 0x0068 }
            a.d.a.a.a.a.a$a r13 = r1.c()     // Catch:{ all -> 0x0068 }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0068 }
            long r8 = r6 - r4
            r11 = 0
            r4 = r1
            r5 = r13
            r6 = r3
            r7 = r12
            r10 = r0
            r4.g(r5, r6, r7, r8, r10, r11)     // Catch:{ all -> 0x0068 }
            r1.a()
            return r13
        L_0x0068:
            r13 = move-exception
            r5 = 0
            r8 = -1
            r4 = r1
            r6 = r3
            r7 = r12
            r10 = r0
            r11 = r13
            r4.g(r5, r6, r7, r8, r10, r11)     // Catch:{ all -> 0x0075 }
            throw r13     // Catch:{ all -> 0x0075 }
        L_0x0075:
            r13 = move-exception
            r1.a()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.a.a.a.b(android.content.Context):a.d.a.a.a.a.a$a");
    }

    public static a.d.a.a.e.a d(Context context, boolean z) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            int b2 = d.f1239b.b(context, g.f1241a);
            if (b2 == 0 || b2 == 2) {
                String str = z ? "com.google.android.gms.ads.identifier.service.PERSISTENT_START" : "com.google.android.gms.ads.identifier.service.START";
                a.d.a.a.e.a aVar = new a.d.a.a.e.a();
                Intent intent = new Intent(str);
                intent.setPackage("com.google.android.gms");
                try {
                    a.d.a.a.e.p.a a2 = a.d.a.a.e.p.a.a();
                    if (a2 != null) {
                        context.getClass().getName();
                        if (a2.b(context, intent, aVar, 1)) {
                            return aVar;
                        }
                        throw new IOException("Connection failure");
                    }
                    throw null;
                } catch (Throwable th) {
                    throw new IOException(th);
                }
            } else {
                throw new IOException("Google Play services not available");
            }
        } catch (PackageManager.NameNotFoundException unused) {
            throw new e(9);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0035, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r4 = this;
            java.lang.String r0 = "Calling this from your main thread can lead to deadlock"
            a.c.a.f.b.j(r0)
            monitor-enter(r4)
            android.content.Context r0 = r4.f     // Catch:{ all -> 0x0036 }
            if (r0 == 0) goto L_0x0034
            a.d.a.a.e.a r0 = r4.f1165a     // Catch:{ all -> 0x0036 }
            if (r0 != 0) goto L_0x000f
            goto L_0x0034
        L_0x000f:
            r0 = 0
            boolean r1 = r4.f1167c     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x002b
            a.d.a.a.e.p.a r1 = a.d.a.a.e.p.a.a()     // Catch:{ all -> 0x0023 }
            android.content.Context r2 = r4.f     // Catch:{ all -> 0x0023 }
            a.d.a.a.e.a r3 = r4.f1165a     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x0022
            r2.unbindService(r3)     // Catch:{ all -> 0x0023 }
            goto L_0x002b
        L_0x0022:
            throw r0     // Catch:{ all -> 0x0023 }
        L_0x0023:
            r1 = move-exception
            java.lang.String r2 = "AdvertisingIdClient"
            java.lang.String r3 = "AdvertisingIdClient unbindService failed."
            android.util.Log.i(r2, r3, r1)     // Catch:{ all -> 0x0036 }
        L_0x002b:
            r1 = 0
            r4.f1167c = r1     // Catch:{ all -> 0x0036 }
            r4.f1166b = r0     // Catch:{ all -> 0x0036 }
            r4.f1165a = r0     // Catch:{ all -> 0x0036 }
            monitor-exit(r4)     // Catch:{ all -> 0x0036 }
            return
        L_0x0034:
            monitor-exit(r4)     // Catch:{ all -> 0x0036 }
            return
        L_0x0036:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0036 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.a.a.a.a():void");
    }

    public C0053a c() {
        C0053a aVar;
        a.c.a.f.b.j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.f1167c) {
                synchronized (this.f1168d) {
                    if (this.f1169e == null || !this.f1169e.f1175d) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    f(false);
                    if (!this.f1167c) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (RemoteException e2) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
                    throw new IOException("Remote exception");
                } catch (Exception e3) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e3);
                }
            }
            a.c.a.f.b.k(this.f1165a);
            a.c.a.f.b.k(this.f1166b);
            aVar = new C0053a(this.f1166b.getId(), this.f1166b.J(true));
        }
        e();
        return aVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:2|3|(3:5|6|7)|8|9|(1:11)|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0013 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f1168d
            monitor-enter(r0)
            a.d.a.a.a.a.a$b r1 = r6.f1169e     // Catch:{ all -> 0x0026 }
            if (r1 == 0) goto L_0x0013
            a.d.a.a.a.a.a$b r1 = r6.f1169e     // Catch:{ all -> 0x0026 }
            java.util.concurrent.CountDownLatch r1 = r1.f1174c     // Catch:{ all -> 0x0026 }
            r1.countDown()     // Catch:{ all -> 0x0026 }
            a.d.a.a.a.a.a$b r1 = r6.f1169e     // Catch:{ InterruptedException -> 0x0013 }
            r1.join()     // Catch:{ InterruptedException -> 0x0013 }
        L_0x0013:
            long r1 = r6.h     // Catch:{ all -> 0x0026 }
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0024
            a.d.a.a.a.a.a$b r1 = new a.d.a.a.a.a.a$b     // Catch:{ all -> 0x0026 }
            long r2 = r6.h     // Catch:{ all -> 0x0026 }
            r1.<init>(r6, r2)     // Catch:{ all -> 0x0026 }
            r6.f1169e = r1     // Catch:{ all -> 0x0026 }
        L_0x0024:
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            return
        L_0x0026:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.a.a.a.e():void");
    }

    public final void f(boolean z) {
        a.c.a.f.b.j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f1167c) {
                a();
            }
            a.d.a.a.e.a d2 = d(this.f, this.g);
            this.f1165a = d2;
            try {
                this.f1166b = c.e(d2.a(10000, TimeUnit.MILLISECONDS));
                this.f1167c = true;
                if (z) {
                    e();
                }
            } catch (InterruptedException unused) {
                throw new IOException("Interrupted exception");
            } catch (Throwable th) {
                throw new IOException(th);
            }
        }
    }

    public void finalize() {
        a();
        super.finalize();
    }

    public final boolean g(C0053a aVar, boolean z, float f2, long j, String str, Throwable th) {
        String str2;
        if (Math.random() > ((double) f2)) {
            return false;
        }
        HashMap hashMap = new HashMap();
        String str3 = "1";
        hashMap.put("app_context", z ? str3 : oOO0O0O0.O0000oO0);
        if (aVar != null) {
            if (!aVar.f1171b) {
                str3 = oOO0O0O0.O0000oO0;
            }
            hashMap.put("limit_ad_tracking", str3);
        }
        if (!(aVar == null || (str2 = aVar.f1170a) == null)) {
            hashMap.put("ad_id_size", Integer.toString(str2.length()));
        }
        if (th != null) {
            hashMap.put(MqttServiceConstants.TRACE_ERROR, th.getClass().getName());
        }
        if (str != null && !str.isEmpty()) {
            hashMap.put("experiment_id", str);
        }
        hashMap.put("tag", "AdvertisingIdClient");
        hashMap.put("time_spent", Long.toString(j));
        new b(hashMap).start();
        return true;
    }
}
