package a.d.b;

import a.d.a.a.e.k.l.c;
import a.d.a.a.e.m.o;
import a.d.a.a.e.q.f;
import a.d.b.g.m;
import a.d.b.g.t;
import a.d.b.g.u;
import a.d.b.g.v;
import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.core.os.UserManagerCompat;
import com.google.android.material.badge.BadgeDrawable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.GuardedBy;

public class c {
    public static final Object i = new Object();
    public static final Executor j = new d((a) null);
    @GuardedBy("LOCK")
    public static final Map<String, c> k = new ArrayMap();

    /* renamed from: a  reason: collision with root package name */
    public final Context f2715a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2716b;

    /* renamed from: c  reason: collision with root package name */
    public final e f2717c;

    /* renamed from: d  reason: collision with root package name */
    public final m f2718d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f2719e = new AtomicBoolean(false);
    public final AtomicBoolean f = new AtomicBoolean();
    public final v<a.d.b.l.a> g;
    public final List<b> h = new CopyOnWriteArrayList();

    public interface b {
        void a(boolean z);
    }

    @TargetApi(14)
    /* renamed from: a.d.b.c$c  reason: collision with other inner class name */
    public static class C0065c implements c.a {

        /* renamed from: a  reason: collision with root package name */
        public static AtomicReference<C0065c> f2720a = new AtomicReference<>();

        public static void b(Context context) {
            if (context.getApplicationContext() instanceof Application) {
                Application application = (Application) context.getApplicationContext();
                if (f2720a.get() == null) {
                    C0065c cVar = new C0065c();
                    if (f2720a.compareAndSet((Object) null, cVar)) {
                        a.d.a.a.e.k.l.c.a(application);
                        a.d.a.a.e.k.l.c cVar2 = a.d.a.a.e.k.l.c.f1269e;
                        if (cVar2 != null) {
                            synchronized (cVar2) {
                                cVar2.f1272c.add(cVar);
                            }
                            return;
                        }
                        throw null;
                    }
                }
            }
        }

        public void a(boolean z) {
            synchronized (c.i) {
                Iterator it = new ArrayList(c.k.values()).iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar.f2719e.get()) {
                        Log.d("FirebaseApp", "Notifying background state change listeners.");
                        for (b a2 : cVar.h) {
                            a2.a(z);
                        }
                    }
                }
            }
        }
    }

    public static class d implements Executor {

        /* renamed from: a  reason: collision with root package name */
        public static final Handler f2721a = new Handler(Looper.getMainLooper());

        public d(a aVar) {
        }

        public void execute(@NonNull Runnable runnable) {
            f2721a.post(runnable);
        }
    }

    @TargetApi(24)
    public static class e extends BroadcastReceiver {

        /* renamed from: b  reason: collision with root package name */
        public static AtomicReference<e> f2722b = new AtomicReference<>();

        /* renamed from: a  reason: collision with root package name */
        public final Context f2723a;

        public e(Context context) {
            this.f2723a = context;
        }

        public void onReceive(Context context, Intent intent) {
            synchronized (c.i) {
                for (c d2 : c.k.values()) {
                    d2.d();
                }
            }
            this.f2723a.unregisterReceiver(this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0176  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public c(android.content.Context r13, java.lang.String r14, a.d.b.e r15) {
        /*
            r12 = this;
            r12.<init>()
            java.util.concurrent.atomic.AtomicBoolean r0 = new java.util.concurrent.atomic.AtomicBoolean
            r1 = 0
            r0.<init>(r1)
            r12.f2719e = r0
            java.util.concurrent.atomic.AtomicBoolean r0 = new java.util.concurrent.atomic.AtomicBoolean
            r0.<init>()
            r12.f = r0
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList
            r0.<init>()
            r12.h = r0
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList
            r0.<init>()
            a.c.a.f.b.k(r13)
            r12.f2715a = r13
            a.c.a.f.b.h(r14)
            r12.f2716b = r14
            a.c.a.f.b.k(r15)
            r12.f2717c = r15
            java.lang.Class<com.google.firebase.components.ComponentDiscoveryService> r14 = com.google.firebase.components.ComponentDiscoveryService.class
            a.d.b.g.g r0 = new a.d.b.g.g
            r2 = 0
            r0.<init>(r14, r2)
            java.lang.String r14 = "ComponentDiscovery"
            android.content.pm.PackageManager r3 = r13.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0069 }
            if (r3 != 0) goto L_0x0040
            java.lang.String r0 = "Context has no PackageManager."
            goto L_0x0062
        L_0x0040:
            android.content.ComponentName r4 = new android.content.ComponentName     // Catch:{ NameNotFoundException -> 0x0069 }
            java.lang.Class<? extends android.app.Service> r5 = r0.f2747a     // Catch:{ NameNotFoundException -> 0x0069 }
            r4.<init>(r13, r5)     // Catch:{ NameNotFoundException -> 0x0069 }
            r5 = 128(0x80, float:1.794E-43)
            android.content.pm.ServiceInfo r3 = r3.getServiceInfo(r4, r5)     // Catch:{ NameNotFoundException -> 0x0069 }
            if (r3 != 0) goto L_0x0066
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NameNotFoundException -> 0x0069 }
            r3.<init>()     // Catch:{ NameNotFoundException -> 0x0069 }
            java.lang.Class<? extends android.app.Service> r0 = r0.f2747a     // Catch:{ NameNotFoundException -> 0x0069 }
            r3.append(r0)     // Catch:{ NameNotFoundException -> 0x0069 }
            java.lang.String r0 = " has no service info."
            r3.append(r0)     // Catch:{ NameNotFoundException -> 0x0069 }
            java.lang.String r0 = r3.toString()     // Catch:{ NameNotFoundException -> 0x0069 }
        L_0x0062:
            android.util.Log.w(r14, r0)     // Catch:{ NameNotFoundException -> 0x0069 }
            goto L_0x006e
        L_0x0066:
            android.os.Bundle r0 = r3.metaData     // Catch:{ NameNotFoundException -> 0x0069 }
            goto L_0x006f
        L_0x0069:
            java.lang.String r0 = "Application info not found."
            android.util.Log.w(r14, r0)
        L_0x006e:
            r0 = r2
        L_0x006f:
            java.lang.String r3 = "com.google.firebase.components.ComponentRegistrar"
            if (r0 != 0) goto L_0x007d
            java.lang.String r0 = "Could not retrieve metadata, returning empty list of registrars."
            android.util.Log.w(r14, r0)
            java.util.List r0 = java.util.Collections.emptyList()
            goto L_0x00b3
        L_0x007d:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Set r5 = r0.keySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x008a:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00b2
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r0.get(r6)
            boolean r7 = r3.equals(r7)
            if (r7 == 0) goto L_0x008a
            java.lang.String r7 = "com.google.firebase.components:"
            boolean r7 = r6.startsWith(r7)
            if (r7 == 0) goto L_0x008a
            r7 = 31
            java.lang.String r6 = r6.substring(r7)
            r4.add(r6)
            goto L_0x008a
        L_0x00b2:
            r0 = r4
        L_0x00b3:
            java.lang.String r4 = "Could not instantiate %s"
            java.lang.String r5 = "Could not instantiate %s."
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x00c0:
            boolean r7 = r0.hasNext()
            r8 = 1
            r9 = 2
            if (r7 == 0) goto L_0x0133
            java.lang.Object r7 = r0.next()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Class r10 = java.lang.Class.forName(r7)     // Catch:{ ClassNotFoundException -> 0x0124, IllegalAccessException -> 0x011a, InstantiationException -> 0x0110, NoSuchMethodException -> 0x0106, InvocationTargetException -> 0x00fc }
            java.lang.Class<a.d.b.g.i> r11 = a.d.b.g.i.class
            boolean r11 = r11.isAssignableFrom(r10)     // Catch:{ ClassNotFoundException -> 0x0124, IllegalAccessException -> 0x011a, InstantiationException -> 0x0110, NoSuchMethodException -> 0x0106, InvocationTargetException -> 0x00fc }
            if (r11 != 0) goto L_0x00ea
            java.lang.String r10 = "Class %s is not an instance of %s"
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ ClassNotFoundException -> 0x0124, IllegalAccessException -> 0x011a, InstantiationException -> 0x0110, NoSuchMethodException -> 0x0106, InvocationTargetException -> 0x00fc }
            r9[r1] = r7     // Catch:{ ClassNotFoundException -> 0x0124, IllegalAccessException -> 0x011a, InstantiationException -> 0x0110, NoSuchMethodException -> 0x0106, InvocationTargetException -> 0x00fc }
            r9[r8] = r3     // Catch:{ ClassNotFoundException -> 0x0124, IllegalAccessException -> 0x011a, InstantiationException -> 0x0110, NoSuchMethodException -> 0x0106, InvocationTargetException -> 0x00fc }
            java.lang.String r9 = java.lang.String.format(r10, r9)     // Catch:{ ClassNotFoundException -> 0x0124, IllegalAccessException -> 0x011a, InstantiationException -> 0x0110, NoSuchMethodException -> 0x0106, InvocationTargetException -> 0x00fc }
            android.util.Log.w(r14, r9)     // Catch:{ ClassNotFoundException -> 0x0124, IllegalAccessException -> 0x011a, InstantiationException -> 0x0110, NoSuchMethodException -> 0x0106, InvocationTargetException -> 0x00fc }
            goto L_0x00c0
        L_0x00ea:
            java.lang.Class[] r9 = new java.lang.Class[r1]     // Catch:{ ClassNotFoundException -> 0x0124, IllegalAccessException -> 0x011a, InstantiationException -> 0x0110, NoSuchMethodException -> 0x0106, InvocationTargetException -> 0x00fc }
            java.lang.reflect.Constructor r9 = r10.getDeclaredConstructor(r9)     // Catch:{ ClassNotFoundException -> 0x0124, IllegalAccessException -> 0x011a, InstantiationException -> 0x0110, NoSuchMethodException -> 0x0106, InvocationTargetException -> 0x00fc }
            java.lang.Object[] r10 = new java.lang.Object[r1]     // Catch:{ ClassNotFoundException -> 0x0124, IllegalAccessException -> 0x011a, InstantiationException -> 0x0110, NoSuchMethodException -> 0x0106, InvocationTargetException -> 0x00fc }
            java.lang.Object r9 = r9.newInstance(r10)     // Catch:{ ClassNotFoundException -> 0x0124, IllegalAccessException -> 0x011a, InstantiationException -> 0x0110, NoSuchMethodException -> 0x0106, InvocationTargetException -> 0x00fc }
            a.d.b.g.i r9 = (a.d.b.g.i) r9     // Catch:{ ClassNotFoundException -> 0x0124, IllegalAccessException -> 0x011a, InstantiationException -> 0x0110, NoSuchMethodException -> 0x0106, InvocationTargetException -> 0x00fc }
            r6.add(r9)     // Catch:{ ClassNotFoundException -> 0x0124, IllegalAccessException -> 0x011a, InstantiationException -> 0x0110, NoSuchMethodException -> 0x0106, InvocationTargetException -> 0x00fc }
            goto L_0x00c0
        L_0x00fc:
            r9 = move-exception
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r8[r1] = r7
            java.lang.String r7 = java.lang.String.format(r4, r8)
            goto L_0x012f
        L_0x0106:
            r9 = move-exception
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r8[r1] = r7
            java.lang.String r7 = java.lang.String.format(r4, r8)
            goto L_0x012f
        L_0x0110:
            r9 = move-exception
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r8[r1] = r7
            java.lang.String r7 = java.lang.String.format(r5, r8)
            goto L_0x012f
        L_0x011a:
            r9 = move-exception
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r8[r1] = r7
            java.lang.String r7 = java.lang.String.format(r5, r8)
            goto L_0x012f
        L_0x0124:
            r9 = move-exception
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r8[r1] = r7
            java.lang.String r7 = "Class %s is not an found."
            java.lang.String r7 = java.lang.String.format(r7, r8)
        L_0x012f:
            android.util.Log.w(r14, r7, r9)
            goto L_0x00c0
        L_0x0133:
            java.lang.String r14 = a.c.a.f.b.y()
            a.d.b.g.m r0 = new a.d.b.g.m
            java.util.concurrent.Executor r3 = j
            r4 = 8
            a.d.b.g.d[] r4 = new a.d.b.g.d[r4]
            java.lang.Class<android.content.Context> r5 = android.content.Context.class
            java.lang.Class[] r7 = new java.lang.Class[r1]
            a.d.b.g.d r5 = a.d.b.g.d.c(r13, r5, r7)
            r4[r1] = r5
            java.lang.Class<a.d.b.c> r5 = a.d.b.c.class
            java.lang.Class[] r7 = new java.lang.Class[r1]
            a.d.b.g.d r5 = a.d.b.g.d.c(r12, r5, r7)
            r4[r8] = r5
            java.lang.Class<a.d.b.e> r5 = a.d.b.e.class
            java.lang.Class[] r7 = new java.lang.Class[r1]
            a.d.b.g.d r15 = a.d.b.g.d.c(r15, r5, r7)
            r4[r9] = r15
            r15 = 3
            java.lang.String r5 = "fire-android"
            java.lang.String r7 = ""
            a.d.b.g.d r5 = a.c.a.f.b.q(r5, r7)
            r4[r15] = r5
            r15 = 4
            java.lang.String r5 = "fire-core"
            java.lang.String r7 = "19.3.0"
            a.d.b.g.d r5 = a.c.a.f.b.q(r5, r7)
            r4[r15] = r5
            r15 = 5
            if (r14 == 0) goto L_0x017c
            java.lang.String r2 = "kotlin"
            a.d.b.g.d r2 = a.c.a.f.b.q(r2, r14)
        L_0x017c:
            r4[r15] = r2
            r14 = 6
            java.lang.Class<a.d.b.m.f> r15 = a.d.b.m.f.class
            a.d.b.g.d$b r15 = a.d.b.g.d.a(r15)
            java.lang.Class<a.d.b.m.e> r2 = a.d.b.m.e.class
            a.d.b.g.q r5 = new a.d.b.g.q
            r5.<init>(r2, r9, r1)
            r15.a(r5)
            a.d.b.m.b r1 = a.d.b.m.b.f2850a
            r15.c(r1)
            a.d.b.g.d r15 = r15.b()
            r4[r14] = r15
            r14 = 7
            java.lang.Class<a.d.b.i.c> r15 = a.d.b.i.c.class
            a.d.b.g.d$b r15 = a.d.b.g.d.a(r15)
            java.lang.Class<android.content.Context> r1 = android.content.Context.class
            a.d.b.g.q r1 = a.d.b.g.q.b(r1)
            r15.a(r1)
            a.d.b.i.a r1 = a.d.b.i.a.f2777a
            r15.c(r1)
            a.d.b.g.d r15 = r15.b()
            r4[r14] = r15
            r0.<init>(r3, r6, r4)
            r12.f2718d = r0
            a.d.b.g.v r14 = new a.d.b.g.v
            a.d.b.b r15 = new a.d.b.b
            r15.<init>(r12, r13)
            r14.<init>(r15)
            r12.g = r14
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.b.c.<init>(android.content.Context, java.lang.String, a.d.b.e):void");
    }

    @NonNull
    public static c b() {
        c cVar;
        synchronized (i) {
            cVar = k.get("[DEFAULT]");
            if (cVar == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + f.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return cVar;
    }

    @NonNull
    public static c e(@NonNull Context context, @NonNull e eVar) {
        c cVar;
        C0065c.b(context);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (i) {
            a.c.a.f.b.o(!k.containsKey("[DEFAULT]"), "FirebaseApp name [DEFAULT] already exists!");
            a.c.a.f.b.l(context, "Application context cannot be null.");
            cVar = new c(context, "[DEFAULT]", eVar);
            k.put("[DEFAULT]", cVar);
        }
        cVar.d();
        return cVar;
    }

    public static /* synthetic */ a.d.b.l.a g(c cVar, Context context) {
        return new a.d.b.l.a(context, cVar.c(), (a.d.b.h.c) cVar.f2718d.a(a.d.b.h.c.class));
    }

    public final void a() {
        a.c.a.f.b.o(!this.f.get(), "FirebaseApp was deleted");
    }

    public String c() {
        String str;
        StringBuilder sb = new StringBuilder();
        a();
        byte[] bytes = this.f2716b.getBytes(Charset.defaultCharset());
        String str2 = null;
        if (bytes == null) {
            str = null;
        } else {
            str = Base64.encodeToString(bytes, 11);
        }
        sb.append(str);
        sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
        a();
        byte[] bytes2 = this.f2717c.f2725b.getBytes(Charset.defaultCharset());
        if (bytes2 != null) {
            str2 = Base64.encodeToString(bytes2, 11);
        }
        sb.append(str2);
        return sb.toString();
    }

    public final void d() {
        Queue<a.d.b.h.a<?>> queue;
        Set<Map.Entry> emptySet;
        if (!UserManagerCompat.isUserUnlocked(this.f2715a)) {
            Context context = this.f2715a;
            if (e.f2722b.get() == null) {
                e eVar = new e(context);
                if (e.f2722b.compareAndSet((Object) null, eVar)) {
                    context.registerReceiver(eVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                    return;
                }
                return;
            }
            return;
        }
        m mVar = this.f2718d;
        boolean f2 = f();
        for (Map.Entry next : mVar.f2753a.entrySet()) {
            a.d.b.g.d dVar = (a.d.b.g.d) next.getKey();
            v vVar = (v) next.getValue();
            boolean z = false;
            if (!(dVar.f2739c == 1)) {
                if (dVar.f2739c == 2) {
                    z = true;
                }
                if (z) {
                    if (!f2) {
                    }
                }
            }
            vVar.get();
        }
        u uVar = mVar.f2756d;
        synchronized (uVar) {
            if (uVar.f2768b != null) {
                queue = uVar.f2768b;
                uVar.f2768b = null;
            } else {
                queue = null;
            }
        }
        if (queue != null) {
            for (a.d.b.h.a aVar : queue) {
                if (aVar != null) {
                    synchronized (uVar) {
                        if (uVar.f2768b != null) {
                            uVar.f2768b.add(aVar);
                        } else {
                            synchronized (uVar) {
                                Map map = uVar.f2767a.get((Object) null);
                                emptySet = map == null ? Collections.emptySet() : map.entrySet();
                            }
                            for (Map.Entry entry : emptySet) {
                                ((Executor) entry.getValue()).execute(new t(entry, aVar));
                            }
                        }
                    }
                } else {
                    throw null;
                }
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        String str = this.f2716b;
        c cVar = (c) obj;
        cVar.a();
        return str.equals(cVar.f2716b);
    }

    @VisibleForTesting
    public boolean f() {
        a();
        return "[DEFAULT]".equals(this.f2716b);
    }

    public int hashCode() {
        return this.f2716b.hashCode();
    }

    public String toString() {
        o y0 = a.c.a.f.b.y0(this);
        y0.a("name", this.f2716b);
        y0.a("options", this.f2717c);
        return y0.toString();
    }
}
