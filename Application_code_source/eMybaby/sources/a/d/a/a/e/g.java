package a.d.a.a.e;

import a.c.a.f.b;
import a.d.a.a.e.r.c;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.atomic.AtomicBoolean;

public class g {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final int f1241a = 12451000;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f1242b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f1243c = false;

    /* renamed from: d  reason: collision with root package name */
    public static final AtomicBoolean f1244d = new AtomicBoolean();

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicBoolean f1245e = new AtomicBoolean();

    @Deprecated
    public static int a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }

    @Deprecated
    public static String b(int i) {
        return ConnectionResult.l(i);
    }

    public static Context c(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean d(Context context) {
        if (!f1243c) {
            try {
                PackageInfo packageInfo = c.a(context).f1443a.getPackageManager().getPackageInfo("com.google.android.gms", 64);
                h.a(context);
                if (packageInfo == null || h.d(packageInfo, false) || !h.d(packageInfo, true)) {
                    f1242b = false;
                } else {
                    f1242b = true;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e2);
            } catch (Throwable th) {
                f1243c = true;
                throw th;
            }
            f1243c = true;
        }
        return f1242b || !"user".equals(Build.TYPE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c8  */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int e(android.content.Context r10, int r11) {
        /*
            java.lang.String r0 = "GooglePlayServicesUtil"
            android.content.res.Resources r1 = r10.getResources()     // Catch:{ all -> 0x000c }
            int r2 = a.d.a.a.e.i.common_google_play_services_unknown_issue     // Catch:{ all -> 0x000c }
            r1.getString(r2)     // Catch:{ all -> 0x000c }
            goto L_0x0011
        L_0x000c:
            java.lang.String r1 = "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included."
            android.util.Log.e(r0, r1)
        L_0x0011:
            java.lang.String r1 = r10.getPackageName()
            java.lang.String r2 = "com.google.android.gms"
            boolean r1 = r2.equals(r1)
            java.lang.String r3 = " but found "
            if (r1 != 0) goto L_0x0060
            java.util.concurrent.atomic.AtomicBoolean r1 = f1245e
            boolean r1 = r1.get()
            if (r1 != 0) goto L_0x0060
            a.d.a.a.e.m.q0.a(r10)
            int r1 = a.d.a.a.e.m.q0.f1412d
            if (r1 == 0) goto L_0x0058
            r4 = 12451000(0xbdfcb8, float:1.7447567E-38)
            if (r1 != r4) goto L_0x0034
            goto L_0x0060
        L_0x0034:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            r11 = 320(0x140, float:4.48E-43)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r11)
            java.lang.String r11 = "The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected "
            r0.append(r11)
            r0.append(r4)
            r0.append(r3)
            r0.append(r1)
            java.lang.String r11 = ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />"
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            r10.<init>(r11)
            throw r10
        L_0x0058:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />"
            r10.<init>(r11)
            throw r10
        L_0x0060:
            boolean r1 = a.c.a.f.b.W(r10)
            r4 = 1
            r5 = 0
            if (r1 != 0) goto L_0x0098
            java.lang.Boolean r1 = a.c.a.f.b.f
            if (r1 != 0) goto L_0x008e
            android.content.pm.PackageManager r1 = r10.getPackageManager()
            java.lang.String r6 = "android.hardware.type.iot"
            boolean r1 = r1.hasSystemFeature(r6)
            if (r1 != 0) goto L_0x0087
            android.content.pm.PackageManager r1 = r10.getPackageManager()
            java.lang.String r6 = "android.hardware.type.embedded"
            boolean r1 = r1.hasSystemFeature(r6)
            if (r1 == 0) goto L_0x0085
            goto L_0x0087
        L_0x0085:
            r1 = 0
            goto L_0x0088
        L_0x0087:
            r1 = 1
        L_0x0088:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            a.c.a.f.b.f = r1
        L_0x008e:
            java.lang.Boolean r1 = a.c.a.f.b.f
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0098
            r1 = 1
            goto L_0x0099
        L_0x0098:
            r1 = 0
        L_0x0099:
            if (r11 < 0) goto L_0x009d
            r6 = 1
            goto L_0x009e
        L_0x009d:
            r6 = 0
        L_0x009e:
            a.c.a.f.b.d(r6)
            android.content.pm.PackageManager r6 = r10.getPackageManager()
            r7 = 0
            r8 = 9
            if (r1 == 0) goto L_0x00b6
            java.lang.String r7 = "com.android.vending"
            r9 = 8256(0x2040, float:1.1569E-41)
            android.content.pm.PackageInfo r7 = r6.getPackageInfo(r7, r9)     // Catch:{ NameNotFoundException -> 0x00b3 }
            goto L_0x00b6
        L_0x00b3:
            java.lang.String r10 = "Google Play Store is missing."
            goto L_0x00e0
        L_0x00b6:
            r9 = 64
            android.content.pm.PackageInfo r9 = r6.getPackageInfo(r2, r9)     // Catch:{ NameNotFoundException -> 0x012e }
            a.d.a.a.e.h.a(r10)
            boolean r10 = a.d.a.a.e.h.d(r9, r4)
            if (r10 != 0) goto L_0x00c8
            java.lang.String r10 = "Google Play services signature invalid."
            goto L_0x00e0
        L_0x00c8:
            if (r1 == 0) goto L_0x00e6
            boolean r10 = a.d.a.a.e.h.d(r7, r4)
            if (r10 == 0) goto L_0x00de
            android.content.pm.Signature[] r10 = r7.signatures
            r10 = r10[r5]
            android.content.pm.Signature[] r1 = r9.signatures
            r1 = r1[r5]
            boolean r10 = r10.equals(r1)
            if (r10 != 0) goto L_0x00e6
        L_0x00de:
            java.lang.String r10 = "Google Play Store signature invalid."
        L_0x00e0:
            android.util.Log.w(r0, r10)
            r4 = 9
            goto L_0x0133
        L_0x00e6:
            int r10 = r9.versionCode
            r1 = -1
            if (r10 != r1) goto L_0x00ed
            r10 = -1
            goto L_0x00ef
        L_0x00ed:
            int r10 = r10 / 1000
        L_0x00ef:
            if (r11 != r1) goto L_0x00f2
            goto L_0x00f4
        L_0x00f2:
            int r1 = r11 / 1000
        L_0x00f4:
            if (r10 >= r1) goto L_0x0116
            int r10 = r9.versionCode
            r1 = 77
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Google Play services out of date.  Requires "
            r2.append(r1)
            r2.append(r11)
            r2.append(r3)
            r2.append(r10)
            java.lang.String r10 = r2.toString()
            android.util.Log.w(r0, r10)
            r4 = 2
            goto L_0x0133
        L_0x0116:
            android.content.pm.ApplicationInfo r10 = r9.applicationInfo
            if (r10 != 0) goto L_0x0126
            android.content.pm.ApplicationInfo r10 = r6.getApplicationInfo(r2, r5)     // Catch:{ NameNotFoundException -> 0x011f }
            goto L_0x0126
        L_0x011f:
            r10 = move-exception
            java.lang.String r11 = "Google Play services missing when getting application info."
            android.util.Log.wtf(r0, r11, r10)
            goto L_0x0133
        L_0x0126:
            boolean r10 = r10.enabled
            if (r10 != 0) goto L_0x012c
            r4 = 3
            goto L_0x0133
        L_0x012c:
            r4 = 0
            goto L_0x0133
        L_0x012e:
            java.lang.String r10 = "Google Play services is missing."
            android.util.Log.w(r0, r10)
        L_0x0133:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.e.g.e(android.content.Context, int):int");
    }

    @TargetApi(21)
    public static boolean f(Context context, String str) {
        Bundle applicationRestrictions;
        boolean equals = str.equals("com.google.android.gms");
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                for (PackageInstaller.SessionInfo appPackageName : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                    if (str.equals(appPackageName.getAppPackageName())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
                return false;
            }
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
            if (equals) {
                return applicationInfo.enabled;
            }
            if (applicationInfo.enabled) {
                if (!(b.M() && (applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName())) != null && "true".equals(applicationRestrictions.getString("restricted_profile")))) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused2) {
        }
    }

    @Deprecated
    public static boolean g(int i) {
        return i == 1 || i == 2 || i == 3 || i == 9;
    }

    @TargetApi(19)
    @Deprecated
    public static boolean h(Context context, int i, String str) {
        return b.z0(context, i, str);
    }
}
