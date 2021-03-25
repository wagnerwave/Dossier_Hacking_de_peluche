package d.a.a;

import android.content.Context;
import android.util.Log;
import com.tuya.smart.android.network.TuyaSmartNetWork;
import d.a.a.i.a;
import e.a.a.g0.g.g;
import e.a.a.i0.k;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public static String f4824a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f4825b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f4826c = false;

    public static class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WeakReference f4827a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f4828b;

        public a(WeakReference weakReference, f fVar) {
            this.f4827a = weakReference;
            this.f4828b = fVar;
        }

        public void run() {
            String str;
            WeakReference weakReference = this.f4827a;
            String[] f = e.f();
            Boolean bool = Boolean.FALSE;
            if (f != null && f.length > 0) {
                StringBuilder n = a.a.a.a.a.n("Found ");
                n.append(f.length);
                n.append(" stacktrace(s).");
                Log.d("HockeyApp", n.toString());
                for (int i = 0; i < f.length; i++) {
                    try {
                        String str2 = f[i];
                        String a2 = e.a(weakReference, str2);
                        if (a2.length() > 0) {
                            Log.d("HockeyApp", "Transmitting crash data: \n" + a2);
                            e.a.a.c0.k.e eVar = new e.a.a.c0.k.e(e.c());
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(new k("raw", a2));
                            arrayList.add(new k("userID", e.a(weakReference, str2.replace(".stacktrace", ".user"))));
                            arrayList.add(new k("contact", e.a(weakReference, str2.replace(".stacktrace", ".contact"))));
                            arrayList.add(new k("description", e.a(weakReference, str2.replace(".stacktrace", ".description"))));
                            arrayList.add(new k(TuyaSmartNetWork.CHANNEL_SDK, "HockeySDK"));
                            arrayList.add(new k("sdk_version", "3.5.0"));
                            eVar.f = new e.a.a.c0.j.a(arrayList, "UTF-8");
                            ((g) a.b.f4834a.f4833a).g(eVar);
                            bool = Boolean.TRUE;
                        }
                        if (bool.booleanValue()) {
                            Log.d("HockeyApp", "Transmission succeeded");
                            str = f[i];
                            e.b(weakReference, str);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        if (bool.booleanValue()) {
                            Log.d("HockeyApp", "Transmission succeeded");
                            str = f[i];
                        }
                    } catch (Throwable th) {
                        if (bool.booleanValue()) {
                            Log.d("HockeyApp", "Transmission succeeded");
                            e.b(weakReference, f[i]);
                        } else {
                            Log.d("HockeyApp", "Transmission failed, will retry on next register() call");
                        }
                        throw th;
                    }
                    Log.d("HockeyApp", "Transmission failed, will retry on next register() call");
                }
            }
            e.f4826c = false;
        }
    }

    public static class b implements FilenameFilter {
        public boolean accept(File file, String str) {
            return str.endsWith(".stacktrace");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0043, code lost:
        if (r0 != null) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0050, code lost:
        if (r0 != null) goto L_0x0045;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004b A[SYNTHETIC, Splitter:B:27:0x004b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.ref.WeakReference<android.content.Context> r4, java.lang.String r5) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x0058
            java.lang.Object r4 = r4.get()
            android.content.Context r4 = (android.content.Context) r4
            if (r4 == 0) goto L_0x0058
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x003f }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x003f }
            java.io.FileInputStream r4 = r4.openFileInput(r5)     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x003f }
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x003f }
            r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x003f }
        L_0x001e:
            java.lang.String r4 = r2.readLine()     // Catch:{ FileNotFoundException -> 0x003b, IOException -> 0x0038, all -> 0x0035 }
            if (r4 == 0) goto L_0x0031
            r1.append(r4)     // Catch:{ FileNotFoundException -> 0x003b, IOException -> 0x0038, all -> 0x0035 }
            java.lang.String r4 = "line.separator"
            java.lang.String r4 = java.lang.System.getProperty(r4)     // Catch:{ FileNotFoundException -> 0x003b, IOException -> 0x0038, all -> 0x0035 }
            r1.append(r4)     // Catch:{ FileNotFoundException -> 0x003b, IOException -> 0x0038, all -> 0x0035 }
            goto L_0x001e
        L_0x0031:
            r2.close()     // Catch:{ IOException -> 0x0053 }
            goto L_0x0053
        L_0x0035:
            r4 = move-exception
            r0 = r2
            goto L_0x0049
        L_0x0038:
            r4 = move-exception
            r0 = r2
            goto L_0x0040
        L_0x003b:
            r0 = r2
            goto L_0x0050
        L_0x003d:
            r4 = move-exception
            goto L_0x0049
        L_0x003f:
            r4 = move-exception
        L_0x0040:
            r4.printStackTrace()     // Catch:{ all -> 0x003d }
            if (r0 == 0) goto L_0x0053
        L_0x0045:
            r0.close()     // Catch:{ IOException -> 0x0053 }
            goto L_0x0053
        L_0x0049:
            if (r0 == 0) goto L_0x004e
            r0.close()     // Catch:{ IOException -> 0x004e }
        L_0x004e:
            throw r4
        L_0x004f:
        L_0x0050:
            if (r0 == 0) goto L_0x0053
            goto L_0x0045
        L_0x0053:
            java.lang.String r4 = r1.toString()
            return r4
        L_0x0058:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d.a.a.e.a(java.lang.ref.WeakReference, java.lang.String):java.lang.String");
    }

    public static void b(WeakReference<Context> weakReference, String str) {
        Context context;
        if (weakReference != null && (context = (Context) weakReference.get()) != null) {
            context.deleteFile(str);
            context.deleteFile(str.replace(".stacktrace", ".user"));
            context.deleteFile(str.replace(".stacktrace", ".contact"));
            context.deleteFile(str.replace(".stacktrace", ".description"));
        }
    }

    public static String c() {
        StringBuilder sb = new StringBuilder();
        sb.append(f4825b);
        sb.append("api/2/apps/");
        return a.a.a.a.a.m(sb, f4824a, "/crashes/");
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0157 A[SYNTHETIC, Splitter:B:44:0x0157] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0205  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void d(android.content.Context r8, java.lang.String r9, d.a.a.f r10) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "https://sdk.hockeyapp.net/"
            f4825b = r1
            java.lang.String r9 = d.a.a.i.b.a(r9)
            f4824a = r9
            java.lang.String r9 = android.os.Build.VERSION.RELEASE
            d.a.a.a.f4814e = r9
            java.lang.String r9 = android.os.Build.MODEL
            d.a.a.a.f = r9
            java.lang.String r9 = android.os.Build.MANUFACTURER
            d.a.a.a.g = r9
            java.lang.String r9 = "HockeyApp"
            java.io.File r1 = r8.getFilesDir()     // Catch:{ Exception -> 0x0027 }
            if (r1 == 0) goto L_0x0030
            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ Exception -> 0x0027 }
            d.a.a.a.f4810a = r1     // Catch:{ Exception -> 0x0027 }
            goto L_0x0030
        L_0x0027:
            r1 = move-exception
            java.lang.String r2 = "Exception thrown when accessing the files dir:"
            android.util.Log.e(r9, r2)
            r1.printStackTrace()
        L_0x0030:
            r1 = 0
            android.content.pm.PackageManager r2 = r8.getPackageManager()     // Catch:{ Exception -> 0x008f }
            java.lang.String r3 = r8.getPackageName()     // Catch:{ Exception -> 0x008f }
            android.content.pm.PackageInfo r3 = r2.getPackageInfo(r3, r1)     // Catch:{ Exception -> 0x008f }
            java.lang.String r4 = r3.packageName     // Catch:{ Exception -> 0x008f }
            d.a.a.a.f4813d = r4     // Catch:{ Exception -> 0x008f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008f }
            r4.<init>()     // Catch:{ Exception -> 0x008f }
            r4.append(r0)     // Catch:{ Exception -> 0x008f }
            int r5 = r3.versionCode     // Catch:{ Exception -> 0x008f }
            r4.append(r5)     // Catch:{ Exception -> 0x008f }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x008f }
            d.a.a.a.f4811b = r4     // Catch:{ Exception -> 0x008f }
            java.lang.String r4 = r3.versionName     // Catch:{ Exception -> 0x008f }
            d.a.a.a.f4812c = r4     // Catch:{ Exception -> 0x008f }
            java.lang.String r4 = r8.getPackageName()     // Catch:{ Exception -> 0x006d }
            r5 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r2 = r2.getApplicationInfo(r4, r5)     // Catch:{ Exception -> 0x006d }
            android.os.Bundle r2 = r2.metaData     // Catch:{ Exception -> 0x006d }
            if (r2 == 0) goto L_0x0076
            java.lang.String r4 = "buildNumber"
            int r2 = r2.getInt(r4, r1)     // Catch:{ Exception -> 0x006d }
            goto L_0x0077
        L_0x006d:
            r2 = move-exception
            java.lang.String r4 = "Exception thrown when accessing the application info:"
            android.util.Log.e(r9, r4)     // Catch:{ Exception -> 0x008f }
            r2.printStackTrace()     // Catch:{ Exception -> 0x008f }
        L_0x0076:
            r2 = 0
        L_0x0077:
            if (r2 == 0) goto L_0x0098
            int r3 = r3.versionCode     // Catch:{ Exception -> 0x008f }
            if (r2 <= r3) goto L_0x0098
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008f }
            r3.<init>()     // Catch:{ Exception -> 0x008f }
            r3.append(r0)     // Catch:{ Exception -> 0x008f }
            r3.append(r2)     // Catch:{ Exception -> 0x008f }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x008f }
            d.a.a.a.f4811b = r2     // Catch:{ Exception -> 0x008f }
            goto L_0x0098
        L_0x008f:
            r2 = move-exception
            java.lang.String r3 = "Exception thrown when accessing the package info:"
            android.util.Log.e(r9, r3)
            r2.printStackTrace()
        L_0x0098:
            android.content.ContentResolver r9 = r8.getContentResolver()
            java.lang.String r2 = "android_id"
            java.lang.String r9 = android.provider.Settings.Secure.getString(r9, r2)
            java.lang.String r2 = d.a.a.a.f4813d
            r3 = 0
            if (r2 == 0) goto L_0x013f
            if (r9 == 0) goto L_0x013f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = d.a.a.a.f4813d
            r2.append(r4)
            java.lang.String r4 = ":"
            r2.append(r4)
            r2.append(r9)
            r2.append(r4)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r5 = "HA"
            r9.append(r5)
            java.lang.String r5 = android.os.Build.BOARD
            int r5 = r5.length()
            int r5 = r5 % 10
            r9.append(r5)
            java.lang.String r5 = android.os.Build.BRAND
            int r5 = r5.length()
            int r5 = r5 % 10
            r9.append(r5)
            java.lang.String r5 = android.os.Build.CPU_ABI
            int r5 = r5.length()
            int r5 = r5 % 10
            r9.append(r5)
            java.lang.String r5 = android.os.Build.PRODUCT
            int r5 = r5.length()
            int r5 = r5 % 10
            r9.append(r5)
            java.lang.String r9 = r9.toString()
            java.lang.Class<android.os.Build> r5 = android.os.Build.class
            java.lang.String r6 = "SERIAL"
            java.lang.reflect.Field r5 = r5.getField(r6)     // Catch:{ all -> 0x0109 }
            java.lang.Object r5 = r5.get(r3)     // Catch:{ all -> 0x0109 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0109 }
            goto L_0x010a
        L_0x0109:
            r5 = r0
        L_0x010a:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r9)
            r6.append(r4)
            r6.append(r5)
            java.lang.String r9 = r6.toString()
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            java.lang.String r2 = "SHA-1"
            java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch:{ all -> 0x013e }
            java.lang.String r4 = "UTF-8"
            byte[] r9 = r9.getBytes(r4)     // Catch:{ all -> 0x013e }
            int r4 = r9.length     // Catch:{ all -> 0x013e }
            r2.update(r9, r1, r4)     // Catch:{ all -> 0x013e }
            byte[] r9 = r2.digest()     // Catch:{ all -> 0x013e }
            java.lang.String r9 = d.a.a.a.a(r9)     // Catch:{ all -> 0x013e }
            d.a.a.a.h = r9     // Catch:{ all -> 0x013e }
            goto L_0x013f
        L_0x013e:
        L_0x013f:
            java.lang.String r9 = f4824a
            if (r9 != 0) goto L_0x0147
            java.lang.String r9 = d.a.a.a.f4813d
            f4824a = r9
        L_0x0147:
            java.lang.ref.WeakReference r9 = new java.lang.ref.WeakReference
            r9.<init>(r8)
            java.lang.String[] r2 = f()
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x018d
            int r6 = r2.length
            if (r6 <= 0) goto L_0x018d
            java.lang.Object r6 = r9.get()     // Catch:{ Exception -> 0x0176 }
            android.content.Context r6 = (android.content.Context) r6     // Catch:{ Exception -> 0x0176 }
            if (r6 == 0) goto L_0x0177
            java.lang.String r7 = "HockeySDK"
            android.content.SharedPreferences r6 = r6.getSharedPreferences(r7, r1)     // Catch:{ Exception -> 0x0176 }
            java.lang.String r7 = "ConfirmedFilenames"
            java.lang.String r0 = r6.getString(r7, r0)     // Catch:{ Exception -> 0x0176 }
            java.lang.String r6 = "\\|"
            java.lang.String[] r0 = r0.split(r6)     // Catch:{ Exception -> 0x0176 }
            java.util.List r3 = java.util.Arrays.asList(r0)     // Catch:{ Exception -> 0x0176 }
            goto L_0x0177
        L_0x0176:
        L_0x0177:
            if (r3 == 0) goto L_0x018b
            int r0 = r2.length
            r6 = 0
        L_0x017b:
            if (r6 >= r0) goto L_0x0189
            r7 = r2[r6]
            boolean r7 = r3.contains(r7)
            if (r7 != 0) goto L_0x0186
            goto L_0x018b
        L_0x0186:
            int r6 = r6 + 1
            goto L_0x017b
        L_0x0189:
            r0 = 2
            goto L_0x018e
        L_0x018b:
            r0 = 1
            goto L_0x018e
        L_0x018d:
            r0 = 0
        L_0x018e:
            if (r0 != r5) goto L_0x0205
            android.content.SharedPreferences r8 = android.preference.PreferenceManager.getDefaultSharedPreferences(r8)
            java.lang.String r0 = "always_send_crash_reports"
            boolean r8 = r8.getBoolean(r0, r1)
            r8 = r8 | r1
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            boolean r8 = r8.booleanValue()
            boolean r0 = r10.a()
            r8 = r8 | r0
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            boolean r8 = r8.booleanValue()
            r8 = r8 | r1
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L_0x0207
            java.lang.Object r8 = r9.get()
            android.content.Context r8 = (android.content.Context) r8
            if (r8 != 0) goto L_0x01c4
            goto L_0x020e
        L_0x01c4:
            android.app.AlertDialog$Builder r0 = new android.app.AlertDialog$Builder
            r0.<init>(r8)
            java.lang.String r8 = d.a.a.h.a(r10, r1)
            r0.setTitle(r8)
            java.lang.String r8 = d.a.a.h.a(r10, r5)
            r0.setMessage(r8)
            java.lang.String r8 = d.a.a.h.a(r10, r4)
            d.a.a.b r2 = new d.a.a.b
            r2.<init>(r10, r9, r1)
            r0.setNegativeButton(r8, r2)
            r8 = 3
            java.lang.String r8 = d.a.a.h.a(r10, r8)
            d.a.a.c r2 = new d.a.a.c
            r2.<init>(r9, r10, r1)
            r0.setNeutralButton(r8, r2)
            r8 = 4
            java.lang.String r8 = d.a.a.h.a(r10, r8)
            d.a.a.d r2 = new d.a.a.d
            r2.<init>(r9, r10, r1)
            r0.setPositiveButton(r8, r2)
            android.app.AlertDialog r8 = r0.create()
            r8.show()
            goto L_0x020e
        L_0x0205:
            if (r0 != r4) goto L_0x020b
        L_0x0207:
            g(r9, r10, r1)
            goto L_0x020e
        L_0x020b:
            e(r9, r10, r1)
        L_0x020e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.a.a.e.d(android.content.Context, java.lang.String, d.a.a.f):void");
    }

    public static void e(WeakReference<Context> weakReference, f fVar, boolean z) {
        if (a.f4811b == null || a.f4813d == null) {
            Log.d("HockeyApp", "Exception handler not set because version or package is null.");
            return;
        }
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            StringBuilder n = a.a.a.a.a.n("Current handler class = ");
            n.append(defaultUncaughtExceptionHandler.getClass().getName());
            Log.d("HockeyApp", n.toString());
        }
        if (defaultUncaughtExceptionHandler instanceof g) {
            ((g) defaultUncaughtExceptionHandler).f4830b = fVar;
        } else {
            Thread.setDefaultUncaughtExceptionHandler(new g(defaultUncaughtExceptionHandler, fVar, z));
        }
    }

    public static String[] f() {
        if (a.f4810a != null) {
            StringBuilder n = a.a.a.a.a.n("Looking for exceptions in: ");
            n.append(a.f4810a);
            Log.d("HockeyApp", n.toString());
            File file = new File(a.a.a.a.a.m(new StringBuilder(), a.f4810a, "/"));
            return (file.mkdir() || file.exists()) ? file.list(new b()) : new String[0];
        }
        Log.d("HockeyApp", "Can't search for exception as file path is null.");
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:3|4|(4:7|(2:9|25)(1:26)|10|5)|24|11|12|13|14|15|16|(1:18)(1:19)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void g(java.lang.ref.WeakReference<android.content.Context> r7, d.a.a.f r8, boolean r9) {
        /*
            if (r7 == 0) goto L_0x004e
            java.lang.Object r0 = r7.get()
            android.content.Context r0 = (android.content.Context) r0
            if (r0 == 0) goto L_0x004e
            java.lang.String[] r1 = f()     // Catch:{ Exception -> 0x004e }
            java.lang.String r2 = "HockeySDK"
            r3 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r2, r3)     // Catch:{ Exception -> 0x004e }
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ Exception -> 0x004e }
            java.lang.String r2 = "ConfirmedFilenames"
            java.lang.String r4 = "|"
            java.lang.StringBuffer r5 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x004e }
            r5.<init>()     // Catch:{ Exception -> 0x004e }
        L_0x0022:
            int r6 = r1.length     // Catch:{ Exception -> 0x004e }
            if (r3 >= r6) goto L_0x0035
            r6 = r1[r3]     // Catch:{ Exception -> 0x004e }
            r5.append(r6)     // Catch:{ Exception -> 0x004e }
            int r6 = r1.length     // Catch:{ Exception -> 0x004e }
            int r6 = r6 + -1
            if (r3 >= r6) goto L_0x0032
            r5.append(r4)     // Catch:{ Exception -> 0x004e }
        L_0x0032:
            int r3 = r3 + 1
            goto L_0x0022
        L_0x0035:
            java.lang.String r1 = r5.toString()     // Catch:{ Exception -> 0x004e }
            r0.putString(r2, r1)     // Catch:{ Exception -> 0x004e }
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ NoClassDefFoundError -> 0x003f }
            goto L_0x0041
        L_0x003f:
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x004e }
        L_0x0041:
            boolean r1 = r1.booleanValue()     // Catch:{ Exception -> 0x004e }
            if (r1 == 0) goto L_0x004b
            r0.apply()     // Catch:{ Exception -> 0x004e }
            goto L_0x004e
        L_0x004b:
            r0.commit()     // Catch:{ Exception -> 0x004e }
        L_0x004e:
            e(r7, r8, r9)
            boolean r9 = f4826c
            if (r9 != 0) goto L_0x0060
            r9 = 1
            f4826c = r9
            d.a.a.e$a r9 = new d.a.a.e$a
            r9.<init>(r7, r8)
            r9.start()
        L_0x0060:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.a.a.e.g(java.lang.ref.WeakReference, d.a.a.f, boolean):void");
    }
}
