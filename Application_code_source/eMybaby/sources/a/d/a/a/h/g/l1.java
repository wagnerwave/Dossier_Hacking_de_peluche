package a.d.a.a.h.g;

import android.net.Uri;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class l1 {

    /* renamed from: a  reason: collision with root package name */
    public static final Uri f1791a = Uri.parse("content://com.google.android.gsf.gservices");

    /* renamed from: b  reason: collision with root package name */
    public static final Uri f1792b = Uri.parse("content://com.google.android.gsf.gservices/prefix");

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f1793c = Pattern.compile("^(1|true|t|on|yes|y)$", 2);

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f1794d = Pattern.compile("^(0|false|f|off|no|n)$", 2);

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicBoolean f1795e = new AtomicBoolean();
    public static HashMap<String, String> f;
    public static final HashMap<String, Boolean> g = new HashMap<>();
    public static final HashMap<String, Integer> h = new HashMap<>();
    public static final HashMap<String, Long> i = new HashMap<>();
    public static final HashMap<String, Float> j = new HashMap<>();
    public static Object k;
    public static boolean l;
    public static String[] m = new String[0];

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006a, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c9, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00cb, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d5, code lost:
        r12 = r12.query(f1791a, (java.lang.String[]) null, (java.lang.String) null, new java.lang.String[]{r13}, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e3, code lost:
        if (r12 != null) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00e5, code lost:
        if (r12 == null) goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e7, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ea, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ef, code lost:
        if (r12.moveToFirst() != false) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f1, code lost:
        b(r1, r13, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00f7, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r0 = r12.getString(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00fc, code lost:
        if (r0 == null) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0102, code lost:
        if (r0.equals((java.lang.Object) null) == false) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0104, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0105, code lost:
        b(r1, r13, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0108, code lost:
        if (r0 == null) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x010a, code lost:
        r5 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x010b, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x010e, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x010f, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0110, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0113, code lost:
        throw r13;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.ContentResolver r12, java.lang.String r13) {
        /*
            java.lang.Class<a.d.a.a.h.g.l1> r0 = a.d.a.a.h.g.l1.class
            monitor-enter(r0)
            java.util.HashMap<java.lang.String, java.lang.String> r1 = f     // Catch:{ all -> 0x0114 }
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0029
            java.util.concurrent.atomic.AtomicBoolean r1 = f1795e     // Catch:{ all -> 0x0114 }
            r1.set(r3)     // Catch:{ all -> 0x0114 }
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x0114 }
            r1.<init>()     // Catch:{ all -> 0x0114 }
            f = r1     // Catch:{ all -> 0x0114 }
            java.lang.Object r1 = new java.lang.Object     // Catch:{ all -> 0x0114 }
            r1.<init>()     // Catch:{ all -> 0x0114 }
            k = r1     // Catch:{ all -> 0x0114 }
            l = r3     // Catch:{ all -> 0x0114 }
            android.net.Uri r1 = f1791a     // Catch:{ all -> 0x0114 }
            a.d.a.a.h.g.o1 r4 = new a.d.a.a.h.g.o1     // Catch:{ all -> 0x0114 }
            r4.<init>()     // Catch:{ all -> 0x0114 }
            r12.registerContentObserver(r1, r2, r4)     // Catch:{ all -> 0x0114 }
            goto L_0x0053
        L_0x0029:
            java.util.concurrent.atomic.AtomicBoolean r1 = f1795e     // Catch:{ all -> 0x0114 }
            boolean r1 = r1.getAndSet(r3)     // Catch:{ all -> 0x0114 }
            if (r1 == 0) goto L_0x0053
            java.util.HashMap<java.lang.String, java.lang.String> r1 = f     // Catch:{ all -> 0x0114 }
            r1.clear()     // Catch:{ all -> 0x0114 }
            java.util.HashMap<java.lang.String, java.lang.Boolean> r1 = g     // Catch:{ all -> 0x0114 }
            r1.clear()     // Catch:{ all -> 0x0114 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = h     // Catch:{ all -> 0x0114 }
            r1.clear()     // Catch:{ all -> 0x0114 }
            java.util.HashMap<java.lang.String, java.lang.Long> r1 = i     // Catch:{ all -> 0x0114 }
            r1.clear()     // Catch:{ all -> 0x0114 }
            java.util.HashMap<java.lang.String, java.lang.Float> r1 = j     // Catch:{ all -> 0x0114 }
            r1.clear()     // Catch:{ all -> 0x0114 }
            java.lang.Object r1 = new java.lang.Object     // Catch:{ all -> 0x0114 }
            r1.<init>()     // Catch:{ all -> 0x0114 }
            k = r1     // Catch:{ all -> 0x0114 }
            l = r3     // Catch:{ all -> 0x0114 }
        L_0x0053:
            java.lang.Object r1 = k     // Catch:{ all -> 0x0114 }
            java.util.HashMap<java.lang.String, java.lang.String> r4 = f     // Catch:{ all -> 0x0114 }
            boolean r4 = r4.containsKey(r13)     // Catch:{ all -> 0x0114 }
            r5 = 0
            if (r4 == 0) goto L_0x006b
            java.util.HashMap<java.lang.String, java.lang.String> r12 = f     // Catch:{ all -> 0x0114 }
            java.lang.Object r12 = r12.get(r13)     // Catch:{ all -> 0x0114 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0114 }
            if (r12 == 0) goto L_0x0069
            r5 = r12
        L_0x0069:
            monitor-exit(r0)     // Catch:{ all -> 0x0114 }
            return r5
        L_0x006b:
            java.lang.String[] r4 = m     // Catch:{ all -> 0x0114 }
            int r6 = r4.length     // Catch:{ all -> 0x0114 }
            r7 = 0
        L_0x006f:
            if (r7 >= r6) goto L_0x00d4
            r8 = r4[r7]     // Catch:{ all -> 0x0114 }
            boolean r8 = r13.startsWith(r8)     // Catch:{ all -> 0x0114 }
            if (r8 == 0) goto L_0x00d1
            boolean r1 = l     // Catch:{ all -> 0x0114 }
            if (r1 == 0) goto L_0x0085
            java.util.HashMap<java.lang.String, java.lang.String> r1 = f     // Catch:{ all -> 0x0114 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0114 }
            if (r1 == 0) goto L_0x00ca
        L_0x0085:
            java.lang.String[] r10 = m     // Catch:{ all -> 0x0114 }
            java.util.HashMap<java.lang.String, java.lang.String> r1 = f     // Catch:{ all -> 0x0114 }
            android.net.Uri r7 = f1792b     // Catch:{ all -> 0x0114 }
            r8 = 0
            r9 = 0
            r11 = 0
            r6 = r12
            android.database.Cursor r12 = r6.query(r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0114 }
            java.util.TreeMap r4 = new java.util.TreeMap     // Catch:{ all -> 0x0114 }
            r4.<init>()     // Catch:{ all -> 0x0114 }
            if (r12 != 0) goto L_0x009b
            goto L_0x00b0
        L_0x009b:
            boolean r6 = r12.moveToNext()     // Catch:{ all -> 0x00cc }
            if (r6 == 0) goto L_0x00ad
            java.lang.String r6 = r12.getString(r3)     // Catch:{ all -> 0x00cc }
            java.lang.String r7 = r12.getString(r2)     // Catch:{ all -> 0x00cc }
            r4.put(r6, r7)     // Catch:{ all -> 0x00cc }
            goto L_0x009b
        L_0x00ad:
            r12.close()     // Catch:{ all -> 0x0114 }
        L_0x00b0:
            r1.putAll(r4)     // Catch:{ all -> 0x0114 }
            l = r2     // Catch:{ all -> 0x0114 }
            java.util.HashMap<java.lang.String, java.lang.String> r12 = f     // Catch:{ all -> 0x0114 }
            boolean r12 = r12.containsKey(r13)     // Catch:{ all -> 0x0114 }
            if (r12 == 0) goto L_0x00ca
            java.util.HashMap<java.lang.String, java.lang.String> r12 = f     // Catch:{ all -> 0x0114 }
            java.lang.Object r12 = r12.get(r13)     // Catch:{ all -> 0x0114 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0114 }
            if (r12 == 0) goto L_0x00c8
            r5 = r12
        L_0x00c8:
            monitor-exit(r0)     // Catch:{ all -> 0x0114 }
            return r5
        L_0x00ca:
            monitor-exit(r0)     // Catch:{ all -> 0x0114 }
            return r5
        L_0x00cc:
            r13 = move-exception
            r12.close()     // Catch:{ all -> 0x0114 }
            throw r13     // Catch:{ all -> 0x0114 }
        L_0x00d1:
            int r7 = r7 + 1
            goto L_0x006f
        L_0x00d4:
            monitor-exit(r0)     // Catch:{ all -> 0x0114 }
            android.net.Uri r7 = f1791a
            r8 = 0
            r9 = 0
            java.lang.String[] r10 = new java.lang.String[r2]
            r10[r3] = r13
            r11 = 0
            r6 = r12
            android.database.Cursor r12 = r6.query(r7, r8, r9, r10, r11)
            if (r12 != 0) goto L_0x00eb
            if (r12 == 0) goto L_0x00ea
            r12.close()
        L_0x00ea:
            return r5
        L_0x00eb:
            boolean r0 = r12.moveToFirst()     // Catch:{ all -> 0x010f }
            if (r0 != 0) goto L_0x00f8
            b(r1, r13, r5)     // Catch:{ all -> 0x010f }
            r12.close()
            return r5
        L_0x00f8:
            java.lang.String r0 = r12.getString(r2)     // Catch:{ all -> 0x010f }
            if (r0 == 0) goto L_0x0105
            boolean r2 = r0.equals(r5)     // Catch:{ all -> 0x010f }
            if (r2 == 0) goto L_0x0105
            r0 = r5
        L_0x0105:
            b(r1, r13, r0)     // Catch:{ all -> 0x010f }
            if (r0 == 0) goto L_0x010b
            r5 = r0
        L_0x010b:
            r12.close()
            return r5
        L_0x010f:
            r13 = move-exception
            r12.close()
            throw r13
        L_0x0114:
            r12 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0114 }
            goto L_0x0118
        L_0x0117:
            throw r12
        L_0x0118:
            goto L_0x0117
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.l1.a(android.content.ContentResolver, java.lang.String):java.lang.String");
    }

    public static void b(Object obj, String str, String str2) {
        synchronized (l1.class) {
            if (obj == k) {
                f.put(str, str2);
            }
        }
    }
}
