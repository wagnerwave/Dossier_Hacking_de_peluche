package a.d.a.a.e.p;

import java.util.Collections;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f1425a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f1426b;

    public a() {
        List list = Collections.EMPTY_LIST;
    }

    public static a a() {
        if (f1426b == null) {
            synchronized (f1425a) {
                if (f1426b == null) {
                    f1426b = new a();
                }
            }
        }
        return f1426b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(android.content.Context r4, android.content.Intent r5, android.content.ServiceConnection r6, int r7) {
        /*
            r3 = this;
            android.content.ComponentName r0 = r5.getComponent()
            r1 = 0
            if (r0 != 0) goto L_0x0009
        L_0x0007:
            r0 = 0
            goto L_0x0028
        L_0x0009:
            java.lang.String r0 = r0.getPackageName()
            java.lang.String r2 = "com.google.android.gms"
            r2.equals(r0)
            a.d.a.a.e.r.b r2 = a.d.a.a.e.r.c.a(r4)     // Catch:{ NameNotFoundException -> 0x0007 }
            android.content.Context r2 = r2.f1443a     // Catch:{ NameNotFoundException -> 0x0007 }
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0007 }
            android.content.pm.ApplicationInfo r0 = r2.getApplicationInfo(r0, r1)     // Catch:{ NameNotFoundException -> 0x0007 }
            int r0 = r0.flags     // Catch:{ NameNotFoundException -> 0x0007 }
            r2 = 2097152(0x200000, float:2.938736E-39)
            r0 = r0 & r2
            if (r0 == 0) goto L_0x0007
            r0 = 1
        L_0x0028:
            if (r0 == 0) goto L_0x0032
            java.lang.String r4 = "ConnectionTracker"
            java.lang.String r5 = "Attempted to bind to a service in a STOPPED package."
            android.util.Log.w(r4, r5)
            return r1
        L_0x0032:
            boolean r4 = r4.bindService(r5, r6, r7)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.e.p.a.b(android.content.Context, android.content.Intent, android.content.ServiceConnection, int):boolean");
    }
}
