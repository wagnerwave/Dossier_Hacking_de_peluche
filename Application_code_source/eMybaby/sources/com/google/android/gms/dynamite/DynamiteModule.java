package com.google.android.gms.dynamite;

import a.d.a.a.g.f;
import a.d.a.a.g.g;
import a.d.a.a.g.h;
import a.d.a.a.g.i;
import android.content.Context;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.util.DynamiteApi;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.concurrent.GuardedBy;

public final class DynamiteModule {
    @GuardedBy("DynamiteModule.class")

    /* renamed from: b  reason: collision with root package name */
    public static Boolean f4247b = null;
    @GuardedBy("DynamiteModule.class")

    /* renamed from: c  reason: collision with root package name */
    public static g f4248c = null;
    @GuardedBy("DynamiteModule.class")

    /* renamed from: d  reason: collision with root package name */
    public static i f4249d = null;
    @GuardedBy("DynamiteModule.class")

    /* renamed from: e  reason: collision with root package name */
    public static String f4250e = null;
    @GuardedBy("DynamiteModule.class")
    public static int f = -1;
    public static final ThreadLocal<c> g = new ThreadLocal<>();
    public static final b.C0093b h = new a.d.a.a.g.a();
    public static final b i = new a.d.a.a.g.b();
    public static final b j = new a.d.a.a.g.c();
    public static final b k = new a.d.a.a.g.d();

    /* renamed from: a  reason: collision with root package name */
    public final Context f4251a;

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        @GuardedBy("DynamiteLoaderClassLoader.class")
        public static ClassLoader sClassLoader;
    }

    public static class a extends Exception {
        public a(String str, a.d.a.a.g.a aVar) {
            super(str);
        }

        public a(String str, Throwable th, a.d.a.a.g.a aVar) {
            super(str, th);
        }
    }

    public interface b {

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public int f4252a = 0;

            /* renamed from: b  reason: collision with root package name */
            public int f4253b = 0;

            /* renamed from: c  reason: collision with root package name */
            public int f4254c = 0;
        }

        /* renamed from: com.google.android.gms.dynamite.DynamiteModule$b$b  reason: collision with other inner class name */
        public interface C0093b {
            int a(Context context, String str);

            int b(Context context, String str, boolean z);
        }

        a a(Context context, String str, C0093b bVar);
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public Cursor f4255a;

        public c() {
        }

        public c(a.d.a.a.g.a aVar) {
        }
    }

    public static class d implements b.C0093b {

        /* renamed from: a  reason: collision with root package name */
        public final int f4256a;

        public d(int i) {
            this.f4256a = i;
        }

        public final int a(Context context, String str) {
            return this.f4256a;
        }

        public final int b(Context context, String str, boolean z) {
            return 0;
        }
    }

    public DynamiteModule(Context context) {
        a.c.a.f.b.k(context);
        this.f4251a = context;
    }

    public static int a(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get((Object) null).equals(str)) {
                return declaredField2.getInt((Object) null);
            }
            String valueOf = String.valueOf(declaredField.get((Object) null));
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 51 + String.valueOf(str).length());
            sb2.append("Module descriptor id '");
            sb2.append(valueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            Log.e("DynamiteModule", sb2.toString());
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(e2.getMessage());
            Log.e("DynamiteModule", valueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0074, code lost:
        if (r11 != null) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0083, code lost:
        if (r11 != null) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00be, code lost:
        if (r11 != null) goto L_0x00c0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.dynamite.DynamiteModule c(android.content.Context r10, com.google.android.gms.dynamite.DynamiteModule.b r11, java.lang.String r12) {
        /*
            java.lang.String r0 = ":"
            java.lang.String r1 = "DynamiteModule"
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$c> r2 = g
            java.lang.Object r2 = r2.get()
            com.google.android.gms.dynamite.DynamiteModule$c r2 = (com.google.android.gms.dynamite.DynamiteModule.c) r2
            com.google.android.gms.dynamite.DynamiteModule$c r3 = new com.google.android.gms.dynamite.DynamiteModule$c
            r4 = 0
            r3.<init>(r4)
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$c> r5 = g
            r5.set(r3)
            com.google.android.gms.dynamite.DynamiteModule$b$b r5 = h     // Catch:{ all -> 0x0116 }
            com.google.android.gms.dynamite.DynamiteModule$b$a r5 = r11.a(r10, r12, r5)     // Catch:{ all -> 0x0116 }
            int r6 = r5.f4252a     // Catch:{ all -> 0x0116 }
            int r7 = r5.f4253b     // Catch:{ all -> 0x0116 }
            int r8 = r12.length()     // Catch:{ all -> 0x0116 }
            int r8 = r8 + 68
            int r9 = r12.length()     // Catch:{ all -> 0x0116 }
            int r8 = r8 + r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0116 }
            r9.<init>(r8)     // Catch:{ all -> 0x0116 }
            java.lang.String r8 = "Considering local module "
            r9.append(r8)     // Catch:{ all -> 0x0116 }
            r9.append(r12)     // Catch:{ all -> 0x0116 }
            r9.append(r0)     // Catch:{ all -> 0x0116 }
            r9.append(r6)     // Catch:{ all -> 0x0116 }
            java.lang.String r6 = " and remote module "
            r9.append(r6)     // Catch:{ all -> 0x0116 }
            r9.append(r12)     // Catch:{ all -> 0x0116 }
            r9.append(r0)     // Catch:{ all -> 0x0116 }
            r9.append(r7)     // Catch:{ all -> 0x0116 }
            java.lang.String r0 = r9.toString()     // Catch:{ all -> 0x0116 }
            android.util.Log.i(r1, r0)     // Catch:{ all -> 0x0116 }
            int r0 = r5.f4254c     // Catch:{ all -> 0x0116 }
            if (r0 == 0) goto L_0x00ec
            int r0 = r5.f4254c     // Catch:{ all -> 0x0116 }
            r6 = -1
            if (r0 != r6) goto L_0x0061
            int r0 = r5.f4252a     // Catch:{ all -> 0x0116 }
            if (r0 == 0) goto L_0x00ec
        L_0x0061:
            int r0 = r5.f4254c     // Catch:{ all -> 0x0116 }
            r7 = 1
            if (r0 != r7) goto L_0x006a
            int r0 = r5.f4253b     // Catch:{ all -> 0x0116 }
            if (r0 == 0) goto L_0x00ec
        L_0x006a:
            int r0 = r5.f4254c     // Catch:{ all -> 0x0116 }
            if (r0 != r6) goto L_0x0077
            com.google.android.gms.dynamite.DynamiteModule r10 = j(r10, r12)     // Catch:{ all -> 0x0116 }
            android.database.Cursor r11 = r3.f4255a
            if (r11 == 0) goto L_0x00c3
            goto L_0x00c0
        L_0x0077:
            int r0 = r5.f4254c     // Catch:{ all -> 0x0116 }
            if (r0 != r7) goto L_0x00d1
            int r0 = r5.f4253b     // Catch:{ a -> 0x0086 }
            com.google.android.gms.dynamite.DynamiteModule r10 = e(r10, r12, r0)     // Catch:{ a -> 0x0086 }
            android.database.Cursor r11 = r3.f4255a
            if (r11 == 0) goto L_0x00c3
            goto L_0x00c0
        L_0x0086:
            r0 = move-exception
            java.lang.String r7 = "Failed to load remote module: "
            java.lang.String r8 = r0.getMessage()     // Catch:{ all -> 0x0116 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0116 }
            int r9 = r8.length()     // Catch:{ all -> 0x0116 }
            if (r9 == 0) goto L_0x009c
            java.lang.String r7 = r7.concat(r8)     // Catch:{ all -> 0x0116 }
            goto L_0x00a2
        L_0x009c:
            java.lang.String r8 = new java.lang.String     // Catch:{ all -> 0x0116 }
            r8.<init>(r7)     // Catch:{ all -> 0x0116 }
            r7 = r8
        L_0x00a2:
            android.util.Log.w(r1, r7)     // Catch:{ all -> 0x0116 }
            int r1 = r5.f4252a     // Catch:{ all -> 0x0116 }
            if (r1 == 0) goto L_0x00c9
            com.google.android.gms.dynamite.DynamiteModule$d r1 = new com.google.android.gms.dynamite.DynamiteModule$d     // Catch:{ all -> 0x0116 }
            int r5 = r5.f4252a     // Catch:{ all -> 0x0116 }
            r1.<init>(r5)     // Catch:{ all -> 0x0116 }
            com.google.android.gms.dynamite.DynamiteModule$b$a r11 = r11.a(r10, r12, r1)     // Catch:{ all -> 0x0116 }
            int r11 = r11.f4254c     // Catch:{ all -> 0x0116 }
            if (r11 != r6) goto L_0x00c9
            com.google.android.gms.dynamite.DynamiteModule r10 = j(r10, r12)     // Catch:{ all -> 0x0116 }
            android.database.Cursor r11 = r3.f4255a
            if (r11 == 0) goto L_0x00c3
        L_0x00c0:
            r11.close()
        L_0x00c3:
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$c> r11 = g
            r11.set(r2)
            return r10
        L_0x00c9:
            com.google.android.gms.dynamite.DynamiteModule$a r10 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch:{ all -> 0x0116 }
            java.lang.String r11 = "Remote load failed. No local fallback found."
            r10.<init>(r11, r0, r4)     // Catch:{ all -> 0x0116 }
            throw r10     // Catch:{ all -> 0x0116 }
        L_0x00d1:
            com.google.android.gms.dynamite.DynamiteModule$a r10 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch:{ all -> 0x0116 }
            int r11 = r5.f4254c     // Catch:{ all -> 0x0116 }
            r12 = 47
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0116 }
            r0.<init>(r12)     // Catch:{ all -> 0x0116 }
            java.lang.String r12 = "VersionPolicy returned invalid code:"
            r0.append(r12)     // Catch:{ all -> 0x0116 }
            r0.append(r11)     // Catch:{ all -> 0x0116 }
            java.lang.String r11 = r0.toString()     // Catch:{ all -> 0x0116 }
            r10.<init>(r11, r4)     // Catch:{ all -> 0x0116 }
            throw r10     // Catch:{ all -> 0x0116 }
        L_0x00ec:
            com.google.android.gms.dynamite.DynamiteModule$a r10 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch:{ all -> 0x0116 }
            int r11 = r5.f4252a     // Catch:{ all -> 0x0116 }
            int r12 = r5.f4253b     // Catch:{ all -> 0x0116 }
            r0 = 91
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0116 }
            r1.<init>(r0)     // Catch:{ all -> 0x0116 }
            java.lang.String r0 = "No acceptable module found. Local version is "
            r1.append(r0)     // Catch:{ all -> 0x0116 }
            r1.append(r11)     // Catch:{ all -> 0x0116 }
            java.lang.String r11 = " and remote version is "
            r1.append(r11)     // Catch:{ all -> 0x0116 }
            r1.append(r12)     // Catch:{ all -> 0x0116 }
            java.lang.String r11 = "."
            r1.append(r11)     // Catch:{ all -> 0x0116 }
            java.lang.String r11 = r1.toString()     // Catch:{ all -> 0x0116 }
            r10.<init>(r11, r4)     // Catch:{ all -> 0x0116 }
            throw r10     // Catch:{ all -> 0x0116 }
        L_0x0116:
            r10 = move-exception
            android.database.Cursor r11 = r3.f4255a
            if (r11 == 0) goto L_0x011e
            r11.close()
        L_0x011e:
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$c> r11 = g
            r11.set(r2)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.c(android.content.Context, com.google.android.gms.dynamite.DynamiteModule$b, java.lang.String):com.google.android.gms.dynamite.DynamiteModule");
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
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:17:0x0033=Splitter:B:17:0x0033, B:39:0x0089=Splitter:B:39:0x0089, B:23:0x004e=Splitter:B:23:0x004e} */
    public static int d(android.content.Context r8, java.lang.String r9, boolean r10) {
        /*
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r0 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r0)     // Catch:{ all -> 0x00f8 }
            java.lang.Boolean r1 = f4247b     // Catch:{ all -> 0x00f5 }
            if (r1 != 0) goto L_0x00c2
            android.content.Context r1 = r8.getApplicationContext()     // Catch:{ ClassNotFoundException -> 0x009d, IllegalAccessException -> 0x009b, NoSuchFieldException -> 0x0099 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x009d, IllegalAccessException -> 0x009b, NoSuchFieldException -> 0x0099 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader> r2 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class
            java.lang.String r2 = r2.getName()     // Catch:{ ClassNotFoundException -> 0x009d, IllegalAccessException -> 0x009b, NoSuchFieldException -> 0x0099 }
            java.lang.Class r1 = r1.loadClass(r2)     // Catch:{ ClassNotFoundException -> 0x009d, IllegalAccessException -> 0x009b, NoSuchFieldException -> 0x0099 }
            java.lang.String r2 = "sClassLoader"
            java.lang.reflect.Field r2 = r1.getDeclaredField(r2)     // Catch:{ ClassNotFoundException -> 0x009d, IllegalAccessException -> 0x009b, NoSuchFieldException -> 0x0099 }
            monitor-enter(r1)     // Catch:{ ClassNotFoundException -> 0x009d, IllegalAccessException -> 0x009b, NoSuchFieldException -> 0x0099 }
            r3 = 0
            java.lang.Object r4 = r2.get(r3)     // Catch:{ all -> 0x0096 }
            java.lang.ClassLoader r4 = (java.lang.ClassLoader) r4     // Catch:{ all -> 0x0096 }
            if (r4 == 0) goto L_0x0036
            java.lang.ClassLoader r2 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x0096 }
            if (r4 != r2) goto L_0x0030
            goto L_0x0091
        L_0x0030:
            f(r4)     // Catch:{ a -> 0x0033 }
        L_0x0033:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0096 }
            goto L_0x0093
        L_0x0036:
            java.lang.String r4 = "com.google.android.gms"
            android.content.Context r5 = r8.getApplicationContext()     // Catch:{ all -> 0x0096 }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ all -> 0x0096 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x0096 }
            if (r4 == 0) goto L_0x004e
            java.lang.ClassLoader r4 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x0096 }
        L_0x004a:
            r2.set(r3, r4)     // Catch:{ all -> 0x0096 }
            goto L_0x0091
        L_0x004e:
            int r4 = i(r8, r9, r10)     // Catch:{ a -> 0x008c }
            java.lang.String r5 = f4250e     // Catch:{ a -> 0x008c }
            if (r5 == 0) goto L_0x0089
            java.lang.String r5 = f4250e     // Catch:{ a -> 0x008c }
            boolean r5 = r5.isEmpty()     // Catch:{ a -> 0x008c }
            if (r5 == 0) goto L_0x005f
            goto L_0x0089
        L_0x005f:
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ a -> 0x008c }
            r6 = 29
            if (r5 < r6) goto L_0x0071
            dalvik.system.DelegateLastClassLoader r5 = new dalvik.system.DelegateLastClassLoader     // Catch:{ a -> 0x008c }
            java.lang.String r6 = f4250e     // Catch:{ a -> 0x008c }
            java.lang.ClassLoader r7 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ a -> 0x008c }
            r5.<init>(r6, r7)     // Catch:{ a -> 0x008c }
            goto L_0x007c
        L_0x0071:
            a.d.a.a.g.e r5 = new a.d.a.a.g.e     // Catch:{ a -> 0x008c }
            java.lang.String r6 = f4250e     // Catch:{ a -> 0x008c }
            java.lang.ClassLoader r7 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ a -> 0x008c }
            r5.<init>(r6, r7)     // Catch:{ a -> 0x008c }
        L_0x007c:
            f(r5)     // Catch:{ a -> 0x008c }
            r2.set(r3, r5)     // Catch:{ a -> 0x008c }
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ a -> 0x008c }
            f4247b = r5     // Catch:{ a -> 0x008c }
            monitor-exit(r1)     // Catch:{ all -> 0x0096 }
            monitor-exit(r0)     // Catch:{ all -> 0x00f5 }
            return r4
        L_0x0089:
            monitor-exit(r1)     // Catch:{ all -> 0x0096 }
            monitor-exit(r0)     // Catch:{ all -> 0x00f5 }
            return r4
        L_0x008c:
            java.lang.ClassLoader r4 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x0096 }
            goto L_0x004a
        L_0x0091:
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0096 }
        L_0x0093:
            monitor-exit(r1)     // Catch:{ all -> 0x0096 }
            r1 = r2
            goto L_0x00c0
        L_0x0096:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0096 }
            throw r2     // Catch:{ ClassNotFoundException -> 0x009d, IllegalAccessException -> 0x009b, NoSuchFieldException -> 0x0099 }
        L_0x0099:
            r1 = move-exception
            goto L_0x009e
        L_0x009b:
            r1 = move-exception
            goto L_0x009e
        L_0x009d:
            r1 = move-exception
        L_0x009e:
            java.lang.String r2 = "DynamiteModule"
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00f5 }
            int r3 = r1.length()     // Catch:{ all -> 0x00f5 }
            int r3 = r3 + 30
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f5 }
            r4.<init>(r3)     // Catch:{ all -> 0x00f5 }
            java.lang.String r3 = "Failed to load module via V2: "
            r4.append(r3)     // Catch:{ all -> 0x00f5 }
            r4.append(r1)     // Catch:{ all -> 0x00f5 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x00f5 }
            android.util.Log.w(r2, r1)     // Catch:{ all -> 0x00f5 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00f5 }
        L_0x00c0:
            f4247b = r1     // Catch:{ all -> 0x00f5 }
        L_0x00c2:
            monitor-exit(r0)     // Catch:{ all -> 0x00f5 }
            boolean r0 = r1.booleanValue()     // Catch:{ all -> 0x00f8 }
            if (r0 == 0) goto L_0x00f0
            int r8 = i(r8, r9, r10)     // Catch:{ a -> 0x00ce }
            return r8
        L_0x00ce:
            r9 = move-exception
            java.lang.String r10 = "DynamiteModule"
            java.lang.String r0 = "Failed to retrieve remote module version: "
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x00f8 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x00f8 }
            int r1 = r9.length()     // Catch:{ all -> 0x00f8 }
            if (r1 == 0) goto L_0x00e6
            java.lang.String r9 = r0.concat(r9)     // Catch:{ all -> 0x00f8 }
            goto L_0x00eb
        L_0x00e6:
            java.lang.String r9 = new java.lang.String     // Catch:{ all -> 0x00f8 }
            r9.<init>(r0)     // Catch:{ all -> 0x00f8 }
        L_0x00eb:
            android.util.Log.w(r10, r9)     // Catch:{ all -> 0x00f8 }
            r8 = 0
            return r8
        L_0x00f0:
            int r8 = g(r8, r9, r10)     // Catch:{ all -> 0x00f8 }
            return r8
        L_0x00f5:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00f5 }
            throw r9     // Catch:{ all -> 0x00f8 }
        L_0x00f8:
            r9 = move-exception
            a.c.a.f.b.k(r8)     // Catch:{ Exception -> 0x0100 }
            a.c.a.f.b.k(r9)     // Catch:{ Exception -> 0x0100 }
            goto L_0x0108
        L_0x0100:
            r8 = move-exception
            java.lang.String r10 = "CrashUtils"
            java.lang.String r0 = "Error adding exception to DropBox!"
            android.util.Log.e(r10, r0, r8)
        L_0x0108:
            goto L_0x010a
        L_0x0109:
            throw r9
        L_0x010a:
            goto L_0x0109
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.d(android.content.Context, java.lang.String, boolean):int");
    }

    public static DynamiteModule e(Context context, String str, int i2) {
        Boolean bool;
        a.d.a.a.f.a aVar;
        try {
            synchronized (DynamiteModule.class) {
                bool = f4247b;
            }
            if (bool == null) {
                throw new a("Failed to determine which loading route to use.", (a.d.a.a.g.a) null);
            } else if (bool.booleanValue()) {
                return h(context, str, i2);
            } else {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
                sb.append("Selected remote version of ");
                sb.append(str);
                sb.append(", version >= ");
                sb.append(i2);
                Log.i("DynamiteModule", sb.toString());
                g k2 = k(context);
                if (k2 != null) {
                    if (k2.M() >= 2) {
                        aVar = k2.B(new a.d.a.a.f.b(context), str, i2);
                    } else {
                        Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                        aVar = k2.I(new a.d.a.a.f.b(context), str, i2);
                    }
                    if (a.d.a.a.f.b.h(aVar) != null) {
                        return new DynamiteModule((Context) a.d.a.a.f.b.h(aVar));
                    }
                    throw new a("Failed to load remote module.", (a.d.a.a.g.a) null);
                }
                throw new a("Failed to create IDynamiteLoader.", (a.d.a.a.g.a) null);
            }
        } catch (RemoteException e2) {
            throw new a("Failed to load remote module.", e2, (a.d.a.a.g.a) null);
        } catch (a e3) {
            throw e3;
        } catch (Throwable th) {
            try {
                a.c.a.f.b.k(context);
                a.c.a.f.b.k(th);
            } catch (Exception e4) {
                Log.e("CrashUtils", "Error adding exception to DropBox!", e4);
            }
            throw new a("Failed to load remote module.", th, (a.d.a.a.g.a) null);
        }
    }

    @GuardedBy("DynamiteModule.class")
    public static void f(ClassLoader classLoader) {
        i iVar;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                iVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                iVar = queryLocalInterface instanceof i ? (i) queryLocalInterface : new h(iBinder);
            }
            f4249d = iVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new a("Failed to instantiate dynamite loader", e2, (a.d.a.a.g.a) null);
        }
    }

    public static int g(Context context, String str, boolean z) {
        g k2 = k(context);
        if (k2 == null) {
            return 0;
        }
        try {
            if (k2.M() >= 2) {
                return k2.i(new a.d.a.a.f.b(context), str, z);
            }
            Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
            return k2.v(new a.d.a.a.f.b(context), str, z);
        } catch (RemoteException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf) : new String("Failed to retrieve remote module version: "));
            return 0;
        }
    }

    public static DynamiteModule h(Context context, String str, int i2) {
        i iVar;
        Boolean valueOf;
        a.d.a.a.f.a aVar;
        Class<DynamiteModule> cls = DynamiteModule.class;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
        sb.append("Selected remote version of ");
        sb.append(str);
        sb.append(", version >= ");
        sb.append(i2);
        Log.i("DynamiteModule", sb.toString());
        synchronized (cls) {
            iVar = f4249d;
        }
        if (iVar != null) {
            c cVar = g.get();
            if (cVar == null || cVar.f4255a == null) {
                throw new a("No result cursor", (a.d.a.a.g.a) null);
            }
            Context applicationContext = context.getApplicationContext();
            Cursor cursor = cVar.f4255a;
            new a.d.a.a.f.b(null);
            synchronized (cls) {
                valueOf = Boolean.valueOf(f >= 2);
            }
            if (valueOf.booleanValue()) {
                Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                aVar = iVar.t(new a.d.a.a.f.b(applicationContext), str, i2, new a.d.a.a.f.b(cursor));
            } else {
                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                aVar = iVar.s(new a.d.a.a.f.b(applicationContext), str, i2, new a.d.a.a.f.b(cursor));
            }
            Context context2 = (Context) a.d.a.a.f.b.h(aVar);
            if (context2 != null) {
                return new DynamiteModule(context2);
            }
            throw new a("Failed to get module context", (a.d.a.a.g.a) null);
        }
        throw new a("DynamiteLoaderV2 was not cached.", (a.d.a.a.g.a) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int i(android.content.Context r8, java.lang.String r9, boolean r10) {
        /*
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            if (r10 == 0) goto L_0x000a
            java.lang.String r8 = "api_force_staging"
            goto L_0x000c
        L_0x000a:
            java.lang.String r8 = "api"
        L_0x000c:
            int r10 = r8.length()     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            int r10 = r10 + 42
            java.lang.String r2 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            int r2 = r2.length()     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            int r10 = r10 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r2.<init>(r10)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            java.lang.String r10 = "content://com.google.android.gms.chimera/"
            r2.append(r10)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r2.append(r8)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            java.lang.String r8 = "/"
            r2.append(r8)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r2.append(r9)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            java.lang.String r8 = r2.toString()     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            android.net.Uri r2 = android.net.Uri.parse(r8)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x009d, all -> 0x009b }
            if (r8 == 0) goto L_0x0083
            boolean r9 = r8.moveToFirst()     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            if (r9 == 0) goto L_0x0083
            r9 = 0
            int r9 = r8.getInt(r9)     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            if (r9 <= 0) goto L_0x007c
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r10 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r10)     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            r1 = 2
            java.lang.String r1 = r8.getString(r1)     // Catch:{ all -> 0x0079 }
            f4250e = r1     // Catch:{ all -> 0x0079 }
            java.lang.String r1 = "loaderVersion"
            int r1 = r8.getColumnIndex(r1)     // Catch:{ all -> 0x0079 }
            if (r1 < 0) goto L_0x0067
            int r1 = r8.getInt(r1)     // Catch:{ all -> 0x0079 }
            f = r1     // Catch:{ all -> 0x0079 }
        L_0x0067:
            monitor-exit(r10)     // Catch:{ all -> 0x0079 }
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$c> r10 = g     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            java.lang.Object r10 = r10.get()     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            com.google.android.gms.dynamite.DynamiteModule$c r10 = (com.google.android.gms.dynamite.DynamiteModule.c) r10     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            if (r10 == 0) goto L_0x007c
            android.database.Cursor r1 = r10.f4255a     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            if (r1 != 0) goto L_0x007c
            r10.f4255a = r8     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            goto L_0x007d
        L_0x0079:
            r9 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0079 }
            throw r9     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
        L_0x007c:
            r0 = r8
        L_0x007d:
            if (r0 == 0) goto L_0x0082
            r0.close()
        L_0x0082:
            return r9
        L_0x0083:
            java.lang.String r9 = "DynamiteModule"
            java.lang.String r10 = "Failed to retrieve remote module version."
            android.util.Log.w(r9, r10)     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            com.google.android.gms.dynamite.DynamiteModule$a r9 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            java.lang.String r10 = "Failed to connect to dynamite module ContentResolver."
            r9.<init>(r10, r0)     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
            throw r9     // Catch:{ Exception -> 0x0096, all -> 0x0092 }
        L_0x0092:
            r9 = move-exception
            r0 = r8
            r8 = r9
            goto L_0x00ae
        L_0x0096:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L_0x009f
        L_0x009b:
            r8 = move-exception
            goto L_0x00ae
        L_0x009d:
            r8 = move-exception
            r9 = r0
        L_0x009f:
            boolean r10 = r8 instanceof com.google.android.gms.dynamite.DynamiteModule.a     // Catch:{ all -> 0x00ac }
            if (r10 == 0) goto L_0x00a4
            throw r8     // Catch:{ all -> 0x00ac }
        L_0x00a4:
            com.google.android.gms.dynamite.DynamiteModule$a r10 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch:{ all -> 0x00ac }
            java.lang.String r1 = "V2 version check failed"
            r10.<init>(r1, r8, r0)     // Catch:{ all -> 0x00ac }
            throw r10     // Catch:{ all -> 0x00ac }
        L_0x00ac:
            r8 = move-exception
            r0 = r9
        L_0x00ae:
            if (r0 == 0) goto L_0x00b3
            r0.close()
        L_0x00b3:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.i(android.content.Context, java.lang.String, boolean):int");
    }

    public static DynamiteModule j(Context context, String str) {
        String valueOf = String.valueOf(str);
        Log.i("DynamiteModule", valueOf.length() != 0 ? "Selected local version of ".concat(valueOf) : new String("Selected local version of "));
        return new DynamiteModule(context.getApplicationContext());
    }

    public static g k(Context context) {
        g gVar;
        synchronized (DynamiteModule.class) {
            if (f4248c != null) {
                g gVar2 = f4248c;
                return gVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    gVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    gVar = queryLocalInterface instanceof g ? (g) queryLocalInterface : new f(iBinder);
                }
                if (gVar != null) {
                    f4248c = gVar;
                    return gVar;
                }
            } catch (Exception e2) {
                String valueOf = String.valueOf(e2.getMessage());
                Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
            }
        }
        return null;
    }

    public final IBinder b(String str) {
        try {
            return (IBinder) this.f4251a.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            throw new a(str.length() != 0 ? "Failed to instantiate module class: ".concat(str) : new String("Failed to instantiate module class: "), e2, (a.d.a.a.g.a) null);
        }
    }
}
