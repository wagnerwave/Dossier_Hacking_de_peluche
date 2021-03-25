package a.d.a.a.e.q;

import a.d.a.a.e.r.c;
import android.content.Context;
import java.lang.reflect.Method;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final Method f1434a;

    /* renamed from: b  reason: collision with root package name */
    public static final Method f1435b;

    /* renamed from: c  reason: collision with root package name */
    public static final Method f1436c;

    /* renamed from: d  reason: collision with root package name */
    public static final Method f1437d;

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    static {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.String r1 = "add"
            android.os.Process.myUid()
            r2 = 0
            r3 = 1
            r4 = 0
            java.lang.Class<android.os.WorkSource> r5 = android.os.WorkSource.class
            java.lang.Class[] r6 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0017 }
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0017 }
            r6[r4] = r7     // Catch:{ Exception -> 0x0017 }
            java.lang.reflect.Method r5 = r5.getMethod(r1, r6)     // Catch:{ Exception -> 0x0017 }
            goto L_0x0018
        L_0x0017:
            r5 = r2
        L_0x0018:
            f1434a = r5
            boolean r5 = a.c.a.f.b.M()
            r6 = 2
            if (r5 == 0) goto L_0x0030
            java.lang.Class<android.os.WorkSource> r5 = android.os.WorkSource.class
            java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch:{ Exception -> 0x0030 }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0030 }
            r7[r4] = r8     // Catch:{ Exception -> 0x0030 }
            r7[r3] = r0     // Catch:{ Exception -> 0x0030 }
            java.lang.reflect.Method r1 = r5.getMethod(r1, r7)     // Catch:{ Exception -> 0x0030 }
            goto L_0x0031
        L_0x0030:
            r1 = r2
        L_0x0031:
            f1435b = r1
            java.lang.Class<android.os.WorkSource> r1 = android.os.WorkSource.class
            java.lang.String r5 = "size"
            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x003e }
            java.lang.reflect.Method r1 = r1.getMethod(r5, r7)     // Catch:{ Exception -> 0x003e }
            goto L_0x003f
        L_0x003e:
            r1 = r2
        L_0x003f:
            f1436c = r1
            java.lang.Class<android.os.WorkSource> r1 = android.os.WorkSource.class
            java.lang.String r5 = "get"
            java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x004e }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x004e }
            r7[r4] = r8     // Catch:{ Exception -> 0x004e }
            r1.getMethod(r5, r7)     // Catch:{ Exception -> 0x004e }
        L_0x004e:
            boolean r1 = a.c.a.f.b.M()
            if (r1 == 0) goto L_0x0062
            java.lang.Class<android.os.WorkSource> r1 = android.os.WorkSource.class
            java.lang.String r5 = "getName"
            java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0062 }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0062 }
            r7[r4] = r8     // Catch:{ Exception -> 0x0062 }
            java.lang.reflect.Method r2 = r1.getMethod(r5, r7)     // Catch:{ Exception -> 0x0062 }
        L_0x0062:
            f1437d = r2
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r1 < r2) goto L_0x006c
            r1 = 1
            goto L_0x006d
        L_0x006c:
            r1 = 0
        L_0x006d:
            java.lang.String r5 = "WorkSourceUtil"
            if (r1 == 0) goto L_0x0081
            java.lang.Class<android.os.WorkSource> r1 = android.os.WorkSource.class
            java.lang.String r7 = "createWorkChain"
            java.lang.Class[] r8 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x007b }
            r1.getMethod(r7, r8)     // Catch:{ Exception -> 0x007b }
            goto L_0x0081
        L_0x007b:
            r1 = move-exception
            java.lang.String r7 = "Missing WorkChain API createWorkChain"
            android.util.Log.w(r5, r7, r1)
        L_0x0081:
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 < r2) goto L_0x0087
            r1 = 1
            goto L_0x0088
        L_0x0087:
            r1 = 0
        L_0x0088:
            if (r1 == 0) goto L_0x00a4
            java.lang.String r1 = "android.os.WorkSource$WorkChain"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ Exception -> 0x009e }
            java.lang.String r2 = "addNode"
            java.lang.Class[] r6 = new java.lang.Class[r6]     // Catch:{ Exception -> 0x009e }
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x009e }
            r6[r4] = r7     // Catch:{ Exception -> 0x009e }
            r6[r3] = r0     // Catch:{ Exception -> 0x009e }
            r1.getMethod(r2, r6)     // Catch:{ Exception -> 0x009e }
            goto L_0x00a4
        L_0x009e:
            r0 = move-exception
            java.lang.String r1 = "Missing WorkChain class"
            android.util.Log.w(r5, r1, r0)
        L_0x00a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.e.q.h.<clinit>():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0050 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<java.lang.String> a(@androidx.annotation.Nullable android.os.WorkSource r9) {
        /*
            java.lang.String r0 = "Unable to assign blame through WorkSource"
            java.lang.String r1 = "WorkSourceUtil"
            r2 = 0
            if (r9 != 0) goto L_0x0009
        L_0x0007:
            r3 = 0
            goto L_0x001f
        L_0x0009:
            java.lang.reflect.Method r3 = f1436c
            if (r3 == 0) goto L_0x0007
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x001a }
            java.lang.Object r3 = r3.invoke(r9, r4)     // Catch:{ Exception -> 0x001a }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ Exception -> 0x001a }
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x001a }
            goto L_0x001f
        L_0x001a:
            r3 = move-exception
            android.util.Log.wtf(r1, r0, r3)
            goto L_0x0007
        L_0x001f:
            if (r3 != 0) goto L_0x0026
            java.util.List r9 = java.util.Collections.emptyList()
            return r9
        L_0x0026:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r5 = 0
        L_0x002c:
            if (r5 >= r3) goto L_0x0053
            java.lang.reflect.Method r6 = f1437d
            if (r6 == 0) goto L_0x0046
            r7 = 1
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x0042 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0042 }
            r7[r2] = r8     // Catch:{ Exception -> 0x0042 }
            java.lang.Object r6 = r6.invoke(r9, r7)     // Catch:{ Exception -> 0x0042 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0042 }
            goto L_0x0047
        L_0x0042:
            r6 = move-exception
            android.util.Log.wtf(r1, r0, r6)
        L_0x0046:
            r6 = 0
        L_0x0047:
            boolean r7 = a.d.a.a.e.q.g.a(r6)
            if (r7 != 0) goto L_0x0050
            r4.add(r6)
        L_0x0050:
            int r5 = r5 + 1
            goto L_0x002c
        L_0x0053:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.e.q.h.a(android.os.WorkSource):java.util.List");
    }

    public static boolean b(Context context) {
        if (context == null || context.getPackageManager() == null) {
            return false;
        }
        return c.a(context).f1443a.getPackageManager().checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) == 0;
    }
}
