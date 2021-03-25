package a.d.b.k;

import a.d.a.a.l.p;
import a.d.b.k.j.a;
import a.d.b.k.j.b;
import a.d.b.k.j.c;
import a.d.b.k.j.d;
import a.d.b.k.k.b;
import a.d.b.k.k.e;
import a.d.b.m.f;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class c implements d {
    public static final Object k = new Object();
    public static final ThreadFactory l = new a();

    /* renamed from: a  reason: collision with root package name */
    public final a.d.b.c f2789a;

    /* renamed from: b  reason: collision with root package name */
    public final a.d.b.k.k.c f2790b;

    /* renamed from: c  reason: collision with root package name */
    public final a.d.b.k.j.c f2791c;

    /* renamed from: d  reason: collision with root package name */
    public final i f2792d;

    /* renamed from: e  reason: collision with root package name */
    public final b f2793e;
    public final g f;
    public final Object g = new Object();
    public final ExecutorService h;
    public String i = null;
    @GuardedBy("lock")
    public final List<h> j = new ArrayList();

    public class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f2794a = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", new Object[]{Integer.valueOf(this.f2794a.getAndIncrement())}));
        }
    }

    public c(a.d.b.c cVar, @Nullable f fVar, @Nullable a.d.b.i.c cVar2) {
        new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), l);
        cVar.a();
        a.d.b.k.k.c cVar3 = new a.d.b.k.k.c(cVar.f2715a, fVar, cVar2);
        a.d.b.k.j.c cVar4 = new a.d.b.k.j.c(cVar);
        i iVar = new i();
        b bVar = new b(cVar);
        g gVar = new g();
        this.f2789a = cVar;
        this.f2790b = cVar3;
        this.f2791c = cVar4;
        this.f2792d = iVar;
        this.f2793e = bVar;
        this.f = gVar;
        this.h = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), l);
    }

    @NonNull
    public static c e() {
        a.d.b.c b2 = a.d.b.c.b();
        a.c.a.f.b.e(true, "Null is not a valid value of FirebaseApp.");
        b2.a();
        return (c) b2.f2718d.a(d.class);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066 A[Catch:{ IOException -> 0x00eb }] */
    public static void g(a.d.b.k.c r12) {
        /*
            r0 = 0
            if (r12 == 0) goto L_0x00fa
            a.d.b.k.j.c$a r1 = a.d.b.k.j.c.a.REGISTER_ERROR
            java.lang.Object r2 = k
            monitor-enter(r2)
            a.d.b.c r3 = r12.f2789a     // Catch:{ all -> 0x00f7 }
            r3.a()     // Catch:{ all -> 0x00f7 }
            android.content.Context r3 = r3.f2715a     // Catch:{ all -> 0x00f7 }
            java.lang.String r4 = "generatefid.lock"
            a.d.b.k.a r3 = a.d.b.k.a.a(r3, r4)     // Catch:{ all -> 0x00f7 }
            a.d.b.k.j.c r4 = r12.f2791c     // Catch:{ all -> 0x00f0 }
            a.d.b.k.j.d r4 = r4.b()     // Catch:{ all -> 0x00f0 }
            if (r3 == 0) goto L_0x0020
            r3.b()     // Catch:{ all -> 0x00f7 }
        L_0x0020:
            monitor-exit(r2)     // Catch:{ all -> 0x00f7 }
            r2 = r4
            a.d.b.k.j.a r2 = (a.d.b.k.j.a) r2     // Catch:{ IOException -> 0x00eb }
            a.d.b.k.j.c$a r2 = r2.f2803b     // Catch:{ IOException -> 0x00eb }
            r3 = 0
            r5 = 1
            if (r2 != r1) goto L_0x002c
            r2 = 1
            goto L_0x002d
        L_0x002c:
            r2 = 0
        L_0x002d:
            if (r2 != 0) goto L_0x006c
            r2 = r4
            a.d.b.k.j.a r2 = (a.d.b.k.j.a) r2     // Catch:{ IOException -> 0x00eb }
            a.d.b.k.j.c$a r2 = r2.f2803b     // Catch:{ IOException -> 0x00eb }
            a.d.b.k.j.c$a r6 = a.d.b.k.j.c.a.UNREGISTERED     // Catch:{ IOException -> 0x00eb }
            if (r2 != r6) goto L_0x003a
            r2 = 1
            goto L_0x003b
        L_0x003a:
            r2 = 0
        L_0x003b:
            if (r2 == 0) goto L_0x003e
            goto L_0x006c
        L_0x003e:
            a.d.b.k.i r2 = r12.f2792d     // Catch:{ IOException -> 0x00eb }
            if (r2 == 0) goto L_0x006b
            r0 = r4
            a.d.b.k.j.a r0 = (a.d.b.k.j.a) r0     // Catch:{ IOException -> 0x00eb }
            java.lang.String r0 = r0.f2804c     // Catch:{ IOException -> 0x00eb }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ IOException -> 0x00eb }
            if (r0 == 0) goto L_0x004e
            goto L_0x0061
        L_0x004e:
            r0 = r4
            a.d.b.k.j.a r0 = (a.d.b.k.j.a) r0     // Catch:{ IOException -> 0x00eb }
            long r6 = r0.f     // Catch:{ IOException -> 0x00eb }
            long r8 = r0.f2806e     // Catch:{ IOException -> 0x00eb }
            long r6 = r6 + r8
            long r8 = r2.a()     // Catch:{ IOException -> 0x00eb }
            long r10 = a.d.b.k.i.f2800a     // Catch:{ IOException -> 0x00eb }
            long r8 = r8 + r10
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x0063
        L_0x0061:
            r0 = 1
            goto L_0x0064
        L_0x0063:
            r0 = 0
        L_0x0064:
            if (r0 == 0) goto L_0x00ef
            a.d.b.k.j.d r0 = r12.a(r4)     // Catch:{ IOException -> 0x00eb }
            goto L_0x0070
        L_0x006b:
            throw r0     // Catch:{ IOException -> 0x00eb }
        L_0x006c:
            a.d.b.k.j.d r0 = r12.i(r4)     // Catch:{ IOException -> 0x00eb }
        L_0x0070:
            java.lang.Object r2 = k
            monitor-enter(r2)
            a.d.b.c r4 = r12.f2789a     // Catch:{ all -> 0x00e8 }
            r4.a()     // Catch:{ all -> 0x00e8 }
            android.content.Context r4 = r4.f2715a     // Catch:{ all -> 0x00e8 }
            java.lang.String r6 = "generatefid.lock"
            a.d.b.k.a r4 = a.d.b.k.a.a(r4, r6)     // Catch:{ all -> 0x00e8 }
            a.d.b.k.j.c r6 = r12.f2791c     // Catch:{ all -> 0x00e1 }
            r6.a(r0)     // Catch:{ all -> 0x00e1 }
            if (r4 == 0) goto L_0x008a
            r4.b()     // Catch:{ all -> 0x00e8 }
        L_0x008a:
            monitor-exit(r2)     // Catch:{ all -> 0x00e8 }
            r2 = r0
            a.d.b.k.j.a r2 = (a.d.b.k.j.a) r2
            a.d.b.k.j.c$a r4 = r2.f2803b
            a.d.b.k.j.c$a r6 = a.d.b.k.j.c.a.REGISTERED
            if (r4 != r6) goto L_0x0096
            r4 = 1
            goto L_0x0097
        L_0x0096:
            r4 = 0
        L_0x0097:
            if (r4 == 0) goto L_0x009d
            java.lang.String r4 = r2.f2802a
            r12.i = r4
        L_0x009d:
            a.d.b.k.j.c$a r2 = r2.f2803b
            if (r2 != r1) goto L_0x00a2
            r3 = 1
        L_0x00a2:
            if (r3 == 0) goto L_0x00ac
            a.d.b.k.e r1 = new a.d.b.k.e
            a.d.b.k.e$a r2 = a.d.b.k.e.a.BAD_CONFIG
            r1.<init>(r2)
            goto L_0x00b9
        L_0x00ac:
            boolean r1 = r0.b()
            if (r1 == 0) goto L_0x00bd
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "cleared fid due to auth error"
            r1.<init>(r2)
        L_0x00b9:
            r12.j(r0, r1)
            goto L_0x00ef
        L_0x00bd:
            java.lang.Object r1 = r12.g
            monitor-enter(r1)
            java.util.List<a.d.b.k.h> r12 = r12.j     // Catch:{ all -> 0x00de }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ all -> 0x00de }
        L_0x00c6:
            boolean r2 = r12.hasNext()     // Catch:{ all -> 0x00de }
            if (r2 == 0) goto L_0x00dc
            java.lang.Object r2 = r12.next()     // Catch:{ all -> 0x00de }
            a.d.b.k.h r2 = (a.d.b.k.h) r2     // Catch:{ all -> 0x00de }
            boolean r2 = r2.b(r0)     // Catch:{ all -> 0x00de }
            if (r2 == 0) goto L_0x00c6
            r12.remove()     // Catch:{ all -> 0x00de }
            goto L_0x00c6
        L_0x00dc:
            monitor-exit(r1)     // Catch:{ all -> 0x00de }
            goto L_0x00ef
        L_0x00de:
            r12 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00de }
            throw r12
        L_0x00e1:
            r12 = move-exception
            if (r4 == 0) goto L_0x00e7
            r4.b()     // Catch:{ all -> 0x00e8 }
        L_0x00e7:
            throw r12     // Catch:{ all -> 0x00e8 }
        L_0x00e8:
            r12 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00e8 }
            throw r12
        L_0x00eb:
            r0 = move-exception
            r12.j(r4, r0)
        L_0x00ef:
            return
        L_0x00f0:
            r12 = move-exception
            if (r3 == 0) goto L_0x00f6
            r3.b()     // Catch:{ all -> 0x00f7 }
        L_0x00f6:
            throw r12     // Catch:{ all -> 0x00f7 }
        L_0x00f7:
            r12 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00f7 }
            throw r12
        L_0x00fa:
            goto L_0x00fc
        L_0x00fb:
            throw r0
        L_0x00fc:
            goto L_0x00fb
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.b.k.c.g(a.d.b.k.c):void");
    }

    public final d a(@NonNull d dVar) {
        e e2;
        e.b bVar;
        b.C0068b bVar2;
        a.d.b.k.k.c cVar = this.f2790b;
        String b2 = b();
        a.d.b.k.j.a aVar = (a.d.b.k.j.a) dVar;
        String str = aVar.f2802a;
        String f2 = f();
        String str2 = aVar.f2805d;
        if (cVar != null) {
            int i2 = 0;
            URL url = new URL(String.format("https://%s/%s/%s", new Object[]{"firebaseinstallations.googleapis.com", "v1", String.format("projects/%s/installations/%s/authTokens:generate", new Object[]{f2, str})}));
            while (i2 <= 1) {
                HttpURLConnection b3 = cVar.b(url, b2);
                try {
                    b3.setRequestMethod("POST");
                    b3.addRequestProperty("Authorization", "FIS_v2 " + str2);
                    cVar.g(b3);
                    int responseCode = b3.getResponseCode();
                    if (responseCode == 200) {
                        e2 = cVar.e(b3);
                    } else {
                        a.d.b.k.k.c.a(b3, (String) null, b2, f2);
                        if (responseCode != 401) {
                            if (responseCode != 404) {
                                if (responseCode != 429) {
                                    if (responseCode < 500 || responseCode >= 600) {
                                        Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                                        e.a a2 = e.a();
                                        bVar = e.b.BAD_CONFIG;
                                        bVar2 = (b.C0068b) a2;
                                        bVar2.f2832c = bVar;
                                        e2 = bVar2.a();
                                    }
                                }
                                i2++;
                            }
                        }
                        e.a a3 = e.a();
                        bVar = e.b.AUTH_ERROR;
                        bVar2 = (b.C0068b) a3;
                        bVar2.f2832c = bVar;
                        e2 = bVar2.a();
                    }
                    b3.disconnect();
                    a.d.b.k.k.b bVar3 = (a.d.b.k.k.b) e2;
                    int ordinal = bVar3.f2829c.ordinal();
                    if (ordinal == 0) {
                        String str3 = bVar3.f2827a;
                        long j2 = bVar3.f2828b;
                        long a4 = this.f2792d.a();
                        a.b bVar4 = (a.b) dVar.c();
                        bVar4.f2809c = str3;
                        bVar4.f2811e = Long.valueOf(j2);
                        bVar4.f = Long.valueOf(a4);
                        return bVar4.a();
                    } else if (ordinal == 1) {
                        a.b bVar5 = (a.b) dVar.c();
                        bVar5.g = "BAD CONFIG";
                        bVar5.c(c.a.REGISTER_ERROR);
                        return bVar5.a();
                    } else if (ordinal == 2) {
                        this.i = null;
                        d.a c2 = dVar.c();
                        c2.c(c.a.NOT_GENERATED);
                        return c2.a();
                    } else {
                        throw new IOException();
                    }
                } finally {
                    b3.disconnect();
                }
            }
            throw new IOException();
        }
        throw null;
    }

    @Nullable
    public String b() {
        a.d.b.c cVar = this.f2789a;
        cVar.a();
        return cVar.f2717c.f2724a;
    }

    @VisibleForTesting
    public String c() {
        a.d.b.c cVar = this.f2789a;
        cVar.a();
        return cVar.f2717c.f2725b;
    }

    @NonNull
    public p<String> d() {
        d b2;
        a.c.a.f.b.h(c());
        a.c.a.f.b.h(f());
        a.c.a.f.b.h(b());
        a.c.a.f.b.e(i.b(c()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        a.c.a.f.b.e(i.f2801b.matcher(b()).matches(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        p<String> pVar = new p<>();
        TResult tresult = this.i;
        if (tresult == null) {
            synchronized (k) {
                a.d.b.c cVar = this.f2789a;
                cVar.a();
                a a2 = a.a(cVar.f2715a, "generatefid.lock");
                try {
                    b2 = this.f2791c.b();
                    if (b2.b()) {
                        String h2 = h(b2);
                        a.d.b.k.j.c cVar2 = this.f2791c;
                        a.b bVar = (a.b) b2.c();
                        bVar.f2807a = h2;
                        bVar.c(c.a.UNREGISTERED);
                        b2 = bVar.a();
                        cVar2.a(b2);
                    }
                } finally {
                    if (a2 != null) {
                        a2.b();
                    }
                }
            }
            this.h.execute(new b(this));
            tresult = ((a.d.b.k.j.a) b2).f2802a;
        }
        synchronized (pVar.f2708a) {
            if (!pVar.f2710c) {
                pVar.f2710c = true;
                pVar.f2711d = tresult;
                pVar.f2709b.b(pVar);
            }
        }
        return pVar;
    }

    @Nullable
    public String f() {
        a.d.b.c cVar = this.f2789a;
        cVar.a();
        return cVar.f2717c.g;
    }

    public final String h(d dVar) {
        String string;
        a.d.b.c cVar = this.f2789a;
        cVar.a();
        if (cVar.f2716b.equals("CHIME_ANDROID_SDK") || this.f2789a.f()) {
            if (((a.d.b.k.j.a) dVar).f2803b == c.a.ATTEMPT_MIGRATION) {
                a.d.b.k.j.b bVar = this.f2793e;
                synchronized (bVar.f2813a) {
                    synchronized (bVar.f2813a) {
                        string = bVar.f2813a.getString("|S|id", (String) null);
                    }
                    if (string == null) {
                        string = bVar.a();
                    }
                }
                return TextUtils.isEmpty(string) ? this.f.a() : string;
            }
        }
        return this.f.a();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: a.d.b.k.k.d} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: a.d.b.k.k.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: a.d.b.k.k.a} */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0157  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final a.d.b.k.j.d i(a.d.b.k.j.d r17) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            a.d.b.k.j.a r0 = (a.d.b.k.j.a) r0
            java.lang.String r2 = r0.f2802a
            int r2 = r2.length()
            r3 = 0
            r4 = 11
            r5 = 0
            if (r2 != r4) goto L_0x0067
            a.d.b.k.j.b r2 = r1.f2793e
            android.content.SharedPreferences r4 = r2.f2813a
            monitor-enter(r4)
            java.lang.String[] r6 = a.d.b.k.j.b.f2812c     // Catch:{ all -> 0x0064 }
            int r7 = r6.length     // Catch:{ all -> 0x0064 }
            r8 = 0
        L_0x001b:
            if (r8 >= r7) goto L_0x0062
            r9 = r6[r8]     // Catch:{ all -> 0x0064 }
            java.lang.String r10 = r2.f2814b     // Catch:{ all -> 0x0064 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0064 }
            r11.<init>()     // Catch:{ all -> 0x0064 }
            java.lang.String r12 = "|T|"
            r11.append(r12)     // Catch:{ all -> 0x0064 }
            r11.append(r10)     // Catch:{ all -> 0x0064 }
            java.lang.String r10 = "|"
            r11.append(r10)     // Catch:{ all -> 0x0064 }
            r11.append(r9)     // Catch:{ all -> 0x0064 }
            java.lang.String r9 = r11.toString()     // Catch:{ all -> 0x0064 }
            android.content.SharedPreferences r10 = r2.f2813a     // Catch:{ all -> 0x0064 }
            java.lang.String r9 = r10.getString(r9, r5)     // Catch:{ all -> 0x0064 }
            if (r9 == 0) goto L_0x005f
            boolean r10 = r9.isEmpty()     // Catch:{ all -> 0x0064 }
            if (r10 != 0) goto L_0x005f
            java.lang.String r2 = "{"
            boolean r2 = r9.startsWith(r2)     // Catch:{ all -> 0x0064 }
            if (r2 == 0) goto L_0x005d
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x005c }
            r2.<init>(r9)     // Catch:{ JSONException -> 0x005c }
            java.lang.String r6 = "token"
            java.lang.String r9 = r2.getString(r6)     // Catch:{ JSONException -> 0x005c }
            goto L_0x005d
        L_0x005c:
            r9 = r5
        L_0x005d:
            monitor-exit(r4)     // Catch:{ all -> 0x0064 }
            goto L_0x0068
        L_0x005f:
            int r8 = r8 + 1
            goto L_0x001b
        L_0x0062:
            monitor-exit(r4)     // Catch:{ all -> 0x0064 }
            goto L_0x0067
        L_0x0064:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0064 }
            throw r0
        L_0x0067:
            r9 = r5
        L_0x0068:
            a.d.b.k.k.c r2 = r1.f2790b
            java.lang.String r4 = r16.b()
            java.lang.String r0 = r0.f2802a
            java.lang.String r6 = r16.f()
            java.lang.String r7 = r16.c()
            if (r2 == 0) goto L_0x0156
            r5 = 1
            java.lang.Object[] r8 = new java.lang.Object[r5]
            r8[r3] = r6
            java.lang.String r10 = "projects/%s/installations"
            java.lang.String r8 = java.lang.String.format(r10, r8)
            java.net.URL r10 = new java.net.URL
            r11 = 3
            java.lang.Object[] r11 = new java.lang.Object[r11]
            java.lang.String r12 = "firebaseinstallations.googleapis.com"
            r11[r3] = r12
            java.lang.String r12 = "v1"
            r11[r5] = r12
            r12 = 2
            r11[r12] = r8
            java.lang.String r8 = "https://%s/%s/%s"
            java.lang.String r8 = java.lang.String.format(r8, r11)
            r10.<init>(r8)
        L_0x009e:
            if (r3 > r5) goto L_0x0150
            java.net.HttpURLConnection r8 = r2.b(r10, r4)
            java.lang.String r11 = "POST"
            r8.setRequestMethod(r11)     // Catch:{ all -> 0x014b }
            r8.setDoOutput(r5)     // Catch:{ all -> 0x014b }
            if (r9 == 0) goto L_0x00b3
            java.lang.String r11 = "x-goog-fis-android-iid-migration-auth"
            r8.addRequestProperty(r11, r9)     // Catch:{ all -> 0x014b }
        L_0x00b3:
            r2.f(r8, r0, r7)     // Catch:{ all -> 0x014b }
            int r11 = r8.getResponseCode()     // Catch:{ all -> 0x014b }
            r12 = 200(0xc8, float:2.8E-43)
            if (r11 != r12) goto L_0x00c3
            a.d.b.k.k.d r0 = r2.d(r8)     // Catch:{ all -> 0x014b }
            goto L_0x00e7
        L_0x00c3:
            a.d.b.k.k.c.a(r8, r7, r4, r6)     // Catch:{ all -> 0x014b }
            r12 = 429(0x1ad, float:6.01E-43)
            if (r11 == r12) goto L_0x0144
            r12 = 500(0x1f4, float:7.0E-43)
            if (r11 < r12) goto L_0x00d3
            r12 = 600(0x258, float:8.41E-43)
            if (r11 >= r12) goto L_0x00d3
            goto L_0x0144
        L_0x00d3:
            java.lang.String r0 = "Firebase-Installations"
            java.lang.String r2 = "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase."
            android.util.Log.e(r0, r2)     // Catch:{ all -> 0x014b }
            r13 = 0
            r12 = 0
            r11 = 0
            r10 = 0
            a.d.b.k.k.d$a r14 = a.d.b.k.k.d.a.BAD_CONFIG     // Catch:{ all -> 0x014b }
            a.d.b.k.k.a r0 = new a.d.b.k.k.a     // Catch:{ all -> 0x014b }
            r15 = 0
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x014b }
        L_0x00e7:
            r8.disconnect()
            a.d.b.k.k.a r0 = (a.d.b.k.k.a) r0
            a.d.b.k.k.d$a r2 = r0.f2826e
            int r2 = r2.ordinal()
            if (r2 == 0) goto L_0x0110
            if (r2 != r5) goto L_0x010a
            java.lang.String r0 = "BAD CONFIG"
            a.d.b.k.j.d$a r2 = r17.c()
            a.d.b.k.j.a$b r2 = (a.d.b.k.j.a.b) r2
            r2.g = r0
            a.d.b.k.j.c$a r0 = a.d.b.k.j.c.a.REGISTER_ERROR
            r2.c(r0)
            a.d.b.k.j.d r0 = r2.a()
            return r0
        L_0x010a:
            java.io.IOException r0 = new java.io.IOException
            r0.<init>()
            throw r0
        L_0x0110:
            java.lang.String r2 = r0.f2823b
            java.lang.String r3 = r0.f2824c
            a.d.b.k.i r4 = r1.f2792d
            long r4 = r4.a()
            a.d.b.k.k.e r0 = r0.f2825d
            a.d.b.k.k.b r0 = (a.d.b.k.k.b) r0
            java.lang.String r6 = r0.f2827a
            long r7 = r0.f2828b
            a.d.b.k.j.d$a r0 = r17.c()
            a.d.b.k.j.a$b r0 = (a.d.b.k.j.a.b) r0
            r0.f2807a = r2
            a.d.b.k.j.c$a r2 = a.d.b.k.j.c.a.REGISTERED
            r0.c(r2)
            r0.f2809c = r6
            r0.f2810d = r3
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            r0.f2811e = r2
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            r0.f = r2
            a.d.b.k.j.d r0 = r0.a()
            return r0
        L_0x0144:
            int r3 = r3 + 1
            r8.disconnect()
            goto L_0x009e
        L_0x014b:
            r0 = move-exception
            r8.disconnect()
            throw r0
        L_0x0150:
            java.io.IOException r0 = new java.io.IOException
            r0.<init>()
            throw r0
        L_0x0156:
            goto L_0x0158
        L_0x0157:
            throw r5
        L_0x0158:
            goto L_0x0157
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.b.k.c.i(a.d.b.k.j.d):a.d.b.k.j.d");
    }

    public final void j(d dVar, Exception exc) {
        synchronized (this.g) {
            Iterator<h> it = this.j.iterator();
            while (it.hasNext()) {
                if (it.next().a(dVar, exc)) {
                    it.remove();
                }
            }
        }
    }
}
