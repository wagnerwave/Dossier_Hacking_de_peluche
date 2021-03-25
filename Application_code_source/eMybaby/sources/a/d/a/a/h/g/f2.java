package a.d.a.a.h.g;

import android.content.Context;

public final /* synthetic */ class f2 implements u2 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1692a;

    public f2(Context context) {
        this.f1692a = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a() {
        /*
            r10 = this;
            android.content.Context r0 = r10.f1692a
            java.lang.String r1 = "HermeticFileOverrides"
            java.lang.String r2 = android.os.Build.TYPE
            java.lang.String r3 = android.os.Build.TAGS
            java.lang.String r4 = "eng"
            boolean r4 = r2.equals(r4)
            r5 = 1
            r6 = 0
            if (r4 != 0) goto L_0x001b
            java.lang.String r4 = "userdebug"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x001b
            goto L_0x002b
        L_0x001b:
            java.lang.String r2 = "dev-keys"
            boolean r2 = r3.contains(r2)
            if (r2 != 0) goto L_0x002d
            java.lang.String r2 = "test-keys"
            boolean r2 = r3.contains(r2)
            if (r2 != 0) goto L_0x002d
        L_0x002b:
            r2 = 0
            goto L_0x002e
        L_0x002d:
            r2 = 1
        L_0x002e:
            if (r2 != 0) goto L_0x0032
            goto L_0x011a
        L_0x0032:
            boolean r2 = a.d.a.a.h.g.n1.a()
            if (r2 == 0) goto L_0x0043
            boolean r2 = r0.isDeviceProtectedStorage()
            if (r2 == 0) goto L_0x003f
            goto L_0x0043
        L_0x003f:
            android.content.Context r0 = r0.createDeviceProtectedStorageContext()
        L_0x0043:
            android.os.StrictMode$ThreadPolicy r2 = android.os.StrictMode.allowThreadDiskReads()
            android.os.StrictMode.allowThreadDiskWrites()     // Catch:{ all -> 0x011d }
            java.io.File r3 = new java.io.File     // Catch:{ RuntimeException -> 0x0063 }
            java.lang.String r4 = "phenotype_hermetic"
            java.io.File r0 = r0.getDir(r4, r6)     // Catch:{ RuntimeException -> 0x0063 }
            java.lang.String r4 = "overrides.txt"
            r3.<init>(r0, r4)     // Catch:{ RuntimeException -> 0x0063 }
            boolean r0 = r3.exists()     // Catch:{ all -> 0x011d }
            if (r0 == 0) goto L_0x0069
            a.d.a.a.h.g.t2 r0 = new a.d.a.a.h.g.t2     // Catch:{ all -> 0x011d }
            r0.<init>(r3)     // Catch:{ all -> 0x011d }
            goto L_0x006b
        L_0x0063:
            r0 = move-exception
            java.lang.String r3 = "no data dir"
            android.util.Log.e(r1, r3, r0)     // Catch:{ all -> 0x011d }
        L_0x0069:
            a.d.a.a.h.g.r2<java.lang.Object> r0 = a.d.a.a.h.g.r2.f1911a     // Catch:{ all -> 0x011d }
        L_0x006b:
            android.os.StrictMode.setThreadPolicy(r2)
            boolean r2 = r0.b()
            if (r2 == 0) goto L_0x011a
            java.lang.Object r0 = r0.c()
            java.io.File r0 = (java.io.File) r0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0113 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0113 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0113 }
            r4.<init>(r0)     // Catch:{ IOException -> 0x0113 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0113 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0113 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x0107 }
            r3.<init>()     // Catch:{ all -> 0x0107 }
        L_0x008e:
            java.lang.String r4 = r2.readLine()     // Catch:{ all -> 0x0107 }
            if (r4 == 0) goto L_0x00db
            java.lang.String r7 = " "
            r8 = 3
            java.lang.String[] r7 = r4.split(r7, r8)     // Catch:{ all -> 0x0107 }
            int r9 = r7.length     // Catch:{ all -> 0x0107 }
            if (r9 == r8) goto L_0x00b4
            java.lang.String r7 = "Invalid: "
            int r8 = r4.length()     // Catch:{ all -> 0x0107 }
            if (r8 == 0) goto L_0x00ab
            java.lang.String r4 = r7.concat(r4)     // Catch:{ all -> 0x0107 }
            goto L_0x00b0
        L_0x00ab:
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x0107 }
            r4.<init>(r7)     // Catch:{ all -> 0x0107 }
        L_0x00b0:
            android.util.Log.e(r1, r4)     // Catch:{ all -> 0x0107 }
            goto L_0x008e
        L_0x00b4:
            r4 = r7[r6]     // Catch:{ all -> 0x0107 }
            r8 = r7[r5]     // Catch:{ all -> 0x0107 }
            java.lang.String r8 = android.net.Uri.decode(r8)     // Catch:{ all -> 0x0107 }
            r9 = 2
            r7 = r7[r9]     // Catch:{ all -> 0x0107 }
            java.lang.String r7 = android.net.Uri.decode(r7)     // Catch:{ all -> 0x0107 }
            boolean r9 = r3.containsKey(r4)     // Catch:{ all -> 0x0107 }
            if (r9 != 0) goto L_0x00d1
            java.util.HashMap r9 = new java.util.HashMap     // Catch:{ all -> 0x0107 }
            r9.<init>()     // Catch:{ all -> 0x0107 }
            r3.put(r4, r9)     // Catch:{ all -> 0x0107 }
        L_0x00d1:
            java.lang.Object r4 = r3.get(r4)     // Catch:{ all -> 0x0107 }
            java.util.Map r4 = (java.util.Map) r4     // Catch:{ all -> 0x0107 }
            r4.put(r8, r7)     // Catch:{ all -> 0x0107 }
            goto L_0x008e
        L_0x00db:
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0107 }
            int r4 = r0.length()     // Catch:{ all -> 0x0107 }
            int r4 = r4 + 7
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0107 }
            r5.<init>(r4)     // Catch:{ all -> 0x0107 }
            java.lang.String r4 = "Parsed "
            r5.append(r4)     // Catch:{ all -> 0x0107 }
            r5.append(r0)     // Catch:{ all -> 0x0107 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x0107 }
            android.util.Log.i(r1, r0)     // Catch:{ all -> 0x0107 }
            a.d.a.a.h.g.y1 r0 = new a.d.a.a.h.g.y1     // Catch:{ all -> 0x0107 }
            r0.<init>(r3)     // Catch:{ all -> 0x0107 }
            r2.close()     // Catch:{ IOException -> 0x0113 }
            a.d.a.a.h.g.t2 r1 = new a.d.a.a.h.g.t2
            r1.<init>(r0)
            goto L_0x011c
        L_0x0107:
            r0 = move-exception
            r2.close()     // Catch:{ all -> 0x010c }
            goto L_0x0112
        L_0x010c:
            r1 = move-exception
            a.d.a.a.h.g.j4 r2 = a.d.a.a.h.g.h4.f1724a     // Catch:{ IOException -> 0x0113 }
            r2.a(r0, r1)     // Catch:{ IOException -> 0x0113 }
        L_0x0112:
            throw r0     // Catch:{ IOException -> 0x0113 }
        L_0x0113:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r0)
            throw r1
        L_0x011a:
            a.d.a.a.h.g.r2<java.lang.Object> r1 = a.d.a.a.h.g.r2.f1911a
        L_0x011c:
            return r1
        L_0x011d:
            r0 = move-exception
            android.os.StrictMode.setThreadPolicy(r2)
            goto L_0x0123
        L_0x0122:
            throw r0
        L_0x0123:
            goto L_0x0122
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.f2.a():java.lang.Object");
    }
}
