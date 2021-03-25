package a.d.a.a.k;

import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class a {
    public static ScheduledExecutorService l;

    /* renamed from: a  reason: collision with root package name */
    public final Object f2683a = this;

    /* renamed from: b  reason: collision with root package name */
    public final PowerManager.WakeLock f2684b;

    /* renamed from: c  reason: collision with root package name */
    public WorkSource f2685c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2686d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2687e;
    public final String f;
    public final Context g;
    public boolean h = true;
    public final Map<String, Integer[]> i = new HashMap();
    public int j;
    public AtomicInteger k;

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0101  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(@androidx.annotation.NonNull android.content.Context r7, int r8, @androidx.annotation.NonNull java.lang.String r9) {
        /*
            r6 = this;
            java.lang.String r0 = r7.getPackageName()
            r6.<init>()
            r6.f2683a = r6
            r1 = 1
            r6.h = r1
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r6.i = r2
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.util.Collections.synchronizedSet(r2)
            java.util.concurrent.atomic.AtomicInteger r2 = new java.util.concurrent.atomic.AtomicInteger
            r3 = 0
            r2.<init>(r3)
            r6.k = r2
            java.lang.String r2 = "WakeLock: context must not be null"
            a.c.a.f.b.l(r7, r2)
            java.lang.String r2 = "WakeLock: wakeLockName must not be empty"
            a.c.a.f.b.i(r9, r2)
            r6.f2686d = r8
            r2 = 0
            r6.f = r2
            android.content.Context r4 = r7.getApplicationContext()
            r6.g = r4
            java.lang.String r4 = "com.google.android.gms"
            java.lang.String r5 = r7.getPackageName()
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x005a
            java.lang.String r4 = "*gcore*:"
            int r5 = r9.length()
            if (r5 == 0) goto L_0x0051
            java.lang.String r4 = r4.concat(r9)
            goto L_0x0057
        L_0x0051:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r4)
            r4 = r5
        L_0x0057:
            r6.f2687e = r4
            goto L_0x005c
        L_0x005a:
            r6.f2687e = r9
        L_0x005c:
            java.lang.String r4 = "power"
            java.lang.Object r4 = r7.getSystemService(r4)
            android.os.PowerManager r4 = (android.os.PowerManager) r4
            android.os.PowerManager$WakeLock r8 = r4.newWakeLock(r8, r9)
            r6.f2684b = r8
            boolean r8 = a.d.a.a.e.q.h.b(r7)
            if (r8 == 0) goto L_0x0117
            boolean r8 = a.d.a.a.e.q.g.a(r0)
            if (r8 == 0) goto L_0x007a
            java.lang.String r0 = r7.getPackageName()
        L_0x007a:
            java.lang.String r8 = "WorkSourceUtil"
            android.content.pm.PackageManager r9 = r7.getPackageManager()
            if (r9 == 0) goto L_0x00ec
            if (r0 != 0) goto L_0x0085
            goto L_0x00ec
        L_0x0085:
            a.d.a.a.e.r.b r7 = a.d.a.a.e.r.c.a(r7)     // Catch:{ NameNotFoundException -> 0x00d5 }
            android.content.Context r7 = r7.f1443a     // Catch:{ NameNotFoundException -> 0x00d5 }
            android.content.pm.PackageManager r7 = r7.getPackageManager()     // Catch:{ NameNotFoundException -> 0x00d5 }
            android.content.pm.ApplicationInfo r7 = r7.getApplicationInfo(r0, r3)     // Catch:{ NameNotFoundException -> 0x00d5 }
            if (r7 != 0) goto L_0x00a4
            java.lang.String r7 = "Could not get applicationInfo from package: "
            int r9 = r0.length()
            if (r9 == 0) goto L_0x009e
            goto L_0x00de
        L_0x009e:
            java.lang.String r9 = new java.lang.String
            r9.<init>(r7)
            goto L_0x00e8
        L_0x00a4:
            int r7 = r7.uid
            android.os.WorkSource r9 = new android.os.WorkSource
            r9.<init>()
            java.lang.reflect.Method r4 = a.d.a.a.e.q.h.f1435b
            if (r4 == 0) goto L_0x00be
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x00ce }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x00ce }
            r5[r3] = r7     // Catch:{ Exception -> 0x00ce }
            r5[r1] = r0     // Catch:{ Exception -> 0x00ce }
            r4.invoke(r9, r5)     // Catch:{ Exception -> 0x00ce }
            goto L_0x00ed
        L_0x00be:
            java.lang.reflect.Method r0 = a.d.a.a.e.q.h.f1434a
            if (r0 == 0) goto L_0x00ed
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x00ce }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x00ce }
            r4[r3] = r7     // Catch:{ Exception -> 0x00ce }
            r0.invoke(r9, r4)     // Catch:{ Exception -> 0x00ce }
            goto L_0x00ed
        L_0x00ce:
            r7 = move-exception
            java.lang.String r0 = "Unable to assign blame through WorkSource"
            android.util.Log.wtf(r8, r0, r7)
            goto L_0x00ed
        L_0x00d5:
            java.lang.String r7 = "Could not find package: "
            int r9 = r0.length()
            if (r9 == 0) goto L_0x00e3
        L_0x00de:
            java.lang.String r7 = r7.concat(r0)
            goto L_0x00e9
        L_0x00e3:
            java.lang.String r9 = new java.lang.String
            r9.<init>(r7)
        L_0x00e8:
            r7 = r9
        L_0x00e9:
            android.util.Log.e(r8, r7)
        L_0x00ec:
            r9 = r2
        L_0x00ed:
            r6.f2685c = r9
            if (r9 == 0) goto L_0x0117
            android.content.Context r7 = r6.g
            boolean r7 = a.d.a.a.e.q.h.b(r7)
            if (r7 == 0) goto L_0x0117
            android.os.WorkSource r7 = r6.f2685c
            if (r7 == 0) goto L_0x0101
            r7.add(r9)
            goto L_0x0103
        L_0x0101:
            r6.f2685c = r9
        L_0x0103:
            android.os.WorkSource r7 = r6.f2685c
            android.os.PowerManager$WakeLock r8 = r6.f2684b     // Catch:{ IllegalArgumentException -> 0x010d, ArrayIndexOutOfBoundsException -> 0x010b }
            r8.setWorkSource(r7)     // Catch:{ IllegalArgumentException -> 0x010d, ArrayIndexOutOfBoundsException -> 0x010b }
            goto L_0x0117
        L_0x010b:
            r7 = move-exception
            goto L_0x010e
        L_0x010d:
            r7 = move-exception
        L_0x010e:
            java.lang.String r8 = "WakeLock"
            java.lang.String r7 = r7.toString()
            android.util.Log.wtf(r8, r7)
        L_0x0117:
            java.util.concurrent.ScheduledExecutorService r7 = l
            if (r7 != 0) goto L_0x013f
            java.lang.Class<a.d.a.a.e.o.a> r7 = a.d.a.a.e.o.a.class
            monitor-enter(r7)
            a.d.a.a.e.o.a$a r8 = a.d.a.a.e.o.a.f1424a     // Catch:{ all -> 0x013c }
            if (r8 != 0) goto L_0x0129
            a.d.a.a.e.o.b r8 = new a.d.a.a.e.o.b     // Catch:{ all -> 0x013c }
            r8.<init>()     // Catch:{ all -> 0x013c }
            a.d.a.a.e.o.a.f1424a = r8     // Catch:{ all -> 0x013c }
        L_0x0129:
            a.d.a.a.e.o.a$a r8 = a.d.a.a.e.o.a.f1424a     // Catch:{ all -> 0x013c }
            monitor-exit(r7)
            a.d.a.a.e.o.b r8 = (a.d.a.a.e.o.b) r8
            if (r8 == 0) goto L_0x013b
            java.util.concurrent.ScheduledExecutorService r7 = java.util.concurrent.Executors.newScheduledThreadPool(r1)
            java.util.concurrent.ScheduledExecutorService r7 = java.util.concurrent.Executors.unconfigurableScheduledExecutorService(r7)
            l = r7
            goto L_0x013f
        L_0x013b:
            throw r2
        L_0x013c:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        L_0x013f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.k.a.<init>(android.content.Context, int, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005e, code lost:
        if (r2 == false) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0066, code lost:
        if (r12.j == 0) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0068, code lost:
        a.d.a.a.e.p.c.a(r12.g, a.c.a.f.b.G(r12.f2684b, r6), 7, r12.f2687e, r6, (java.lang.String) null, r12.f2686d, a.d.a.a.e.q.h.a(r12.f2685c), r13);
        r12.j++;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(long r13) {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = r12.k
            r0.incrementAndGet()
            boolean r0 = r12.h
            r1 = 0
            if (r0 == 0) goto L_0x0011
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto L_0x0011
            goto L_0x0013
        L_0x0011:
            java.lang.String r1 = r12.f
        L_0x0013:
            r6 = r1
            java.lang.Object r0 = r12.f2683a
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.i     // Catch:{ all -> 0x009f }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x009f }
            r2 = 0
            if (r1 == 0) goto L_0x0024
            int r1 = r12.j     // Catch:{ all -> 0x009f }
            if (r1 <= 0) goto L_0x0033
        L_0x0024:
            android.os.PowerManager$WakeLock r1 = r12.f2684b     // Catch:{ all -> 0x009f }
            boolean r1 = r1.isHeld()     // Catch:{ all -> 0x009f }
            if (r1 != 0) goto L_0x0033
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.i     // Catch:{ all -> 0x009f }
            r1.clear()     // Catch:{ all -> 0x009f }
            r12.j = r2     // Catch:{ all -> 0x009f }
        L_0x0033:
            boolean r1 = r12.h     // Catch:{ all -> 0x009f }
            r3 = 1
            if (r1 == 0) goto L_0x0060
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.i     // Catch:{ all -> 0x009f }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ all -> 0x009f }
            java.lang.Integer[] r1 = (java.lang.Integer[]) r1     // Catch:{ all -> 0x009f }
            if (r1 != 0) goto L_0x0051
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.i     // Catch:{ all -> 0x009f }
            java.lang.Integer[] r4 = new java.lang.Integer[r3]     // Catch:{ all -> 0x009f }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x009f }
            r4[r2] = r3     // Catch:{ all -> 0x009f }
            r1.put(r6, r4)     // Catch:{ all -> 0x009f }
            r2 = 1
            goto L_0x005e
        L_0x0051:
            r4 = r1[r2]     // Catch:{ all -> 0x009f }
            int r4 = r4.intValue()     // Catch:{ all -> 0x009f }
            int r4 = r4 + r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x009f }
            r1[r2] = r3     // Catch:{ all -> 0x009f }
        L_0x005e:
            if (r2 != 0) goto L_0x0068
        L_0x0060:
            boolean r1 = r12.h     // Catch:{ all -> 0x009f }
            if (r1 != 0) goto L_0x0086
            int r1 = r12.j     // Catch:{ all -> 0x009f }
            if (r1 != 0) goto L_0x0086
        L_0x0068:
            android.content.Context r2 = r12.g     // Catch:{ all -> 0x009f }
            android.os.PowerManager$WakeLock r1 = r12.f2684b     // Catch:{ all -> 0x009f }
            java.lang.String r3 = a.c.a.f.b.G(r1, r6)     // Catch:{ all -> 0x009f }
            r4 = 7
            java.lang.String r5 = r12.f2687e     // Catch:{ all -> 0x009f }
            r7 = 0
            int r8 = r12.f2686d     // Catch:{ all -> 0x009f }
            android.os.WorkSource r1 = r12.f2685c     // Catch:{ all -> 0x009f }
            java.util.List r9 = a.d.a.a.e.q.h.a(r1)     // Catch:{ all -> 0x009f }
            r10 = r13
            a.d.a.a.e.p.c.a(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x009f }
            int r1 = r12.j     // Catch:{ all -> 0x009f }
            int r1 = r1 + 1
            r12.j = r1     // Catch:{ all -> 0x009f }
        L_0x0086:
            monitor-exit(r0)     // Catch:{ all -> 0x009f }
            android.os.PowerManager$WakeLock r0 = r12.f2684b
            r0.acquire()
            r0 = 0
            int r2 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x009e
            java.util.concurrent.ScheduledExecutorService r0 = l
            a.d.a.a.k.b r1 = new a.d.a.a.k.b
            r1.<init>(r12)
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS
            r0.schedule(r1, r13, r2)
        L_0x009e:
            return
        L_0x009f:
            r13 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x009f }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.k.a.a(long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0058, code lost:
        if (r2 == false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0060, code lost:
        if (r12.j == 1) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0062, code lost:
        a.d.a.a.e.p.c.a(r12.g, a.c.a.f.b.G(r12.f2684b, r5), 8, r12.f2687e, r5, (java.lang.String) null, r12.f2686d, a.d.a.a.e.q.h.a(r12.f2685c), 0);
        r12.j--;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = r12.k
            int r0 = r0.decrementAndGet()
            if (r0 >= 0) goto L_0x0019
            java.lang.String r0 = "WakeLock"
            java.lang.String r1 = r12.f2687e
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = " release without a matched acquire!"
            java.lang.String r1 = r1.concat(r2)
            android.util.Log.e(r0, r1)
        L_0x0019:
            r0 = 0
            boolean r1 = r12.h
            if (r1 == 0) goto L_0x0025
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            java.lang.String r0 = r12.f
        L_0x0027:
            r5 = r0
            java.lang.Object r0 = r12.f2683a
            monitor-enter(r0)
            boolean r1 = r12.h     // Catch:{ all -> 0x0086 }
            r11 = 1
            if (r1 == 0) goto L_0x005a
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.i     // Catch:{ all -> 0x0086 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x0086 }
            java.lang.Integer[] r1 = (java.lang.Integer[]) r1     // Catch:{ all -> 0x0086 }
            r2 = 0
            if (r1 != 0) goto L_0x003c
            goto L_0x0058
        L_0x003c:
            r3 = r1[r2]     // Catch:{ all -> 0x0086 }
            int r3 = r3.intValue()     // Catch:{ all -> 0x0086 }
            if (r3 != r11) goto L_0x004b
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.i     // Catch:{ all -> 0x0086 }
            r1.remove(r5)     // Catch:{ all -> 0x0086 }
            r2 = 1
            goto L_0x0058
        L_0x004b:
            r3 = r1[r2]     // Catch:{ all -> 0x0086 }
            int r3 = r3.intValue()     // Catch:{ all -> 0x0086 }
            int r3 = r3 - r11
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0086 }
            r1[r2] = r3     // Catch:{ all -> 0x0086 }
        L_0x0058:
            if (r2 != 0) goto L_0x0062
        L_0x005a:
            boolean r1 = r12.h     // Catch:{ all -> 0x0086 }
            if (r1 != 0) goto L_0x0081
            int r1 = r12.j     // Catch:{ all -> 0x0086 }
            if (r1 != r11) goto L_0x0081
        L_0x0062:
            android.content.Context r1 = r12.g     // Catch:{ all -> 0x0086 }
            android.os.PowerManager$WakeLock r2 = r12.f2684b     // Catch:{ all -> 0x0086 }
            java.lang.String r2 = a.c.a.f.b.G(r2, r5)     // Catch:{ all -> 0x0086 }
            r3 = 8
            java.lang.String r4 = r12.f2687e     // Catch:{ all -> 0x0086 }
            r6 = 0
            int r7 = r12.f2686d     // Catch:{ all -> 0x0086 }
            android.os.WorkSource r8 = r12.f2685c     // Catch:{ all -> 0x0086 }
            java.util.List r8 = a.d.a.a.e.q.h.a(r8)     // Catch:{ all -> 0x0086 }
            r9 = 0
            a.d.a.a.e.p.c.a(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0086 }
            int r1 = r12.j     // Catch:{ all -> 0x0086 }
            int r1 = r1 - r11
            r12.j = r1     // Catch:{ all -> 0x0086 }
        L_0x0081:
            monitor-exit(r0)     // Catch:{ all -> 0x0086 }
            r12.c()
            return
        L_0x0086:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0086 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.k.a.b():void");
    }

    public final void c() {
        if (this.f2684b.isHeld()) {
            try {
                this.f2684b.release();
            } catch (RuntimeException e2) {
                if (e2.getClass().equals(RuntimeException.class)) {
                    Log.e("WakeLock", String.valueOf(this.f2687e).concat(" was already released!"), e2);
                } else {
                    throw e2;
                }
            }
            this.f2684b.isHeld();
        }
    }
}
