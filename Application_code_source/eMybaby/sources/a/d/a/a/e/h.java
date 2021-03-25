package a.d.a.a.e;

import a.c.a.f.b;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
public class h {

    /* renamed from: b  reason: collision with root package name */
    public static h f1246b;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1247a;

    public h(Context context) {
        this.f1247a = context.getApplicationContext();
    }

    public static h a(Context context) {
        b.k(context);
        synchronized (h.class) {
            if (f1246b == null) {
                u.b(context);
                f1246b = new h(context);
            }
        }
        return f1246b;
    }

    public static v c(PackageInfo packageInfo, v... vVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        y yVar = new y(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < vVarArr.length; i++) {
            if (vVarArr[i].equals(yVar)) {
                return vVarArr[i];
            }
        }
        return null;
    }

    public static boolean d(PackageInfo packageInfo, boolean z) {
        v vVar;
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z) {
                vVar = c(packageInfo, a0.f1227a);
            } else {
                vVar = c(packageInfo, a0.f1227a[0]);
            }
            if (vVar != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a9 A[LOOP:0: B:5:0x001b->B:43:0x00a9, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b3 A[EDGE_INSN: B:56:0x00b3->B:45:0x00b3 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(int r11) {
        /*
            r10 = this;
            android.content.Context r0 = r10.f1247a
            a.d.a.a.e.r.b r0 = a.d.a.a.e.r.c.a(r0)
            android.content.Context r0 = r0.f1443a
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            java.lang.String[] r11 = r0.getPackagesForUid(r11)
            if (r11 == 0) goto L_0x00ad
            int r0 = r11.length
            if (r0 != 0) goto L_0x0017
            goto L_0x00ad
        L_0x0017:
            r0 = 0
            int r1 = r11.length
            r2 = 0
            r3 = 0
        L_0x001b:
            if (r3 >= r1) goto L_0x00b3
            r0 = r11[r3]
            android.content.Context r4 = r10.f1247a     // Catch:{ NameNotFoundException -> 0x008a }
            a.d.a.a.e.r.b r4 = a.d.a.a.e.r.c.a(r4)     // Catch:{ NameNotFoundException -> 0x008a }
            android.content.Context r4 = r4.f1443a     // Catch:{ NameNotFoundException -> 0x008a }
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch:{ NameNotFoundException -> 0x008a }
            r5 = 64
            android.content.pm.PackageInfo r4 = r4.getPackageInfo(r0, r5)     // Catch:{ NameNotFoundException -> 0x008a }
            android.content.Context r5 = r10.f1247a     // Catch:{ NameNotFoundException -> 0x008a }
            boolean r5 = a.d.a.a.e.g.d(r5)     // Catch:{ NameNotFoundException -> 0x008a }
            if (r4 != 0) goto L_0x0040
            java.lang.String r4 = "null pkg"
        L_0x003b:
            a.d.a.a.e.c0 r0 = a.d.a.a.e.c0.b(r4)     // Catch:{ NameNotFoundException -> 0x008a }
            goto L_0x00a5
        L_0x0040:
            android.content.pm.Signature[] r6 = r4.signatures     // Catch:{ NameNotFoundException -> 0x008a }
            if (r6 == 0) goto L_0x0087
            android.content.pm.Signature[] r6 = r4.signatures     // Catch:{ NameNotFoundException -> 0x008a }
            int r6 = r6.length     // Catch:{ NameNotFoundException -> 0x008a }
            r7 = 1
            if (r6 == r7) goto L_0x004b
            goto L_0x0087
        L_0x004b:
            a.d.a.a.e.y r6 = new a.d.a.a.e.y     // Catch:{ NameNotFoundException -> 0x008a }
            android.content.pm.Signature[] r8 = r4.signatures     // Catch:{ NameNotFoundException -> 0x008a }
            r8 = r8[r2]     // Catch:{ NameNotFoundException -> 0x008a }
            byte[] r8 = r8.toByteArray()     // Catch:{ NameNotFoundException -> 0x008a }
            r6.<init>(r8)     // Catch:{ NameNotFoundException -> 0x008a }
            java.lang.String r8 = r4.packageName     // Catch:{ NameNotFoundException -> 0x008a }
            a.d.a.a.e.c0 r5 = a.d.a.a.e.u.a(r8, r6, r5, r2)     // Catch:{ NameNotFoundException -> 0x008a }
            boolean r9 = r5.f1235a     // Catch:{ NameNotFoundException -> 0x008a }
            if (r9 == 0) goto L_0x0085
            android.content.pm.ApplicationInfo r9 = r4.applicationInfo     // Catch:{ NameNotFoundException -> 0x008a }
            if (r9 == 0) goto L_0x0085
            android.content.pm.ApplicationInfo r4 = r4.applicationInfo     // Catch:{ NameNotFoundException -> 0x008a }
            int r4 = r4.flags     // Catch:{ NameNotFoundException -> 0x008a }
            r4 = r4 & 2
            if (r4 == 0) goto L_0x0085
            android.os.StrictMode$ThreadPolicy r4 = android.os.StrictMode.allowThreadDiskReads()     // Catch:{ NameNotFoundException -> 0x008a }
            a.d.a.a.e.c0 r6 = a.d.a.a.e.u.c(r8, r6, r2, r7)     // Catch:{ all -> 0x0080 }
            android.os.StrictMode.setThreadPolicy(r4)     // Catch:{ NameNotFoundException -> 0x008a }
            boolean r4 = r6.f1235a     // Catch:{ NameNotFoundException -> 0x008a }
            if (r4 == 0) goto L_0x0085
            java.lang.String r4 = "debuggable release cert app rejected"
            goto L_0x003b
        L_0x0080:
            r5 = move-exception
            android.os.StrictMode.setThreadPolicy(r4)     // Catch:{ NameNotFoundException -> 0x008a }
            throw r5     // Catch:{ NameNotFoundException -> 0x008a }
        L_0x0085:
            r0 = r5
            goto L_0x00a5
        L_0x0087:
            java.lang.String r4 = "single cert required"
            goto L_0x003b
        L_0x008a:
            java.lang.String r4 = "no pkg "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r5 = r0.length()
            if (r5 == 0) goto L_0x009c
            java.lang.String r0 = r4.concat(r0)
            goto L_0x00a1
        L_0x009c:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r4)
        L_0x00a1:
            a.d.a.a.e.c0 r0 = a.d.a.a.e.c0.b(r0)
        L_0x00a5:
            boolean r4 = r0.f1235a
            if (r4 != 0) goto L_0x00b3
            int r3 = r3 + 1
            goto L_0x001b
        L_0x00ad:
            java.lang.String r11 = "no pkgs"
            a.d.a.a.e.c0 r0 = a.d.a.a.e.c0.b(r11)
        L_0x00b3:
            boolean r11 = r0.f1235a
            if (r11 != 0) goto L_0x00d5
            r11 = 3
            java.lang.String r1 = "GoogleCertificatesRslt"
            boolean r11 = android.util.Log.isLoggable(r1, r11)
            if (r11 == 0) goto L_0x00d5
            java.lang.Throwable r11 = r0.f1237c
            if (r11 == 0) goto L_0x00ce
            java.lang.String r11 = r0.a()
            java.lang.Throwable r2 = r0.f1237c
            android.util.Log.d(r1, r11, r2)
            goto L_0x00d5
        L_0x00ce:
            java.lang.String r11 = r0.a()
            android.util.Log.d(r1, r11)
        L_0x00d5:
            boolean r11 = r0.f1235a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.e.h.b(int):boolean");
    }
}
