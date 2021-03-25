package a.d.a.a.h.g;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

public abstract class c2<T> {
    public static final Object g = new Object();
    @Nullable
    public static volatile k2 h;
    public static o2 i = new o2(e2.f1672a);
    public static final AtomicInteger j = new AtomicInteger();

    /* renamed from: a  reason: collision with root package name */
    public final l2 f1630a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1631b;

    /* renamed from: c  reason: collision with root package name */
    public final T f1632c;

    /* renamed from: d  reason: collision with root package name */
    public volatile int f1633d = -1;

    /* renamed from: e  reason: collision with root package name */
    public volatile T f1634e;
    public final boolean f;

    static {
        new AtomicReference();
    }

    public c2(l2 l2Var, String str, Object obj, boolean z, h2 h2Var) {
        if (l2Var.f1796a != null) {
            this.f1630a = l2Var;
            this.f1631b = str;
            this.f1632c = obj;
            this.f = z;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    public static c2 a(l2 l2Var, String str) {
        return new j2(l2Var, str, Double.valueOf(-3.0d));
    }

    public static c2 b(l2 l2Var, String str, long j2) {
        return new h2(l2Var, str, Long.valueOf(j2));
    }

    public static c2 c(l2 l2Var, String str, String str2) {
        return new i2(l2Var, str, str2);
    }

    public static c2 d(l2 l2Var, String str, boolean z) {
        return new g2(l2Var, str, Boolean.valueOf(z));
    }

    public abstract T e(Object obj);

    public final String f(String str) {
        if (str != null && str.isEmpty()) {
            return this.f1631b;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(this.f1631b);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final String g() {
        return f(this.f1630a.f1798c);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x012c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T h() {
        /*
            r7 = this;
            boolean r0 = r7.f
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x004d
            a.d.a.a.h.g.o2 r0 = i
            java.lang.String r4 = r7.f1631b
            if (r0 == 0) goto L_0x004c
            if (r4 == 0) goto L_0x0044
            boolean r0 = r0.f1861a
            if (r0 != 0) goto L_0x0014
            goto L_0x003a
        L_0x0014:
            a.d.a.a.h.g.u2<a.d.a.a.h.g.t3<java.lang.String, java.lang.String>> r0 = a.d.a.a.h.g.q2.f1893a
            java.lang.Object r0 = r0.a()
            a.d.a.a.h.g.s3 r0 = (a.d.a.a.h.g.s3) r0
            if (r0 == 0) goto L_0x0043
            a.d.a.a.h.g.r3<K, ? extends a.d.a.a.h.g.n3<V>> r0 = r0.f1928a
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
        L_0x0028:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x003c
            java.lang.Object r5 = r0.next()
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.contains(r4)
            if (r5 == 0) goto L_0x0028
        L_0x003a:
            r0 = 1
            goto L_0x003d
        L_0x003c:
            r0 = 0
        L_0x003d:
            java.lang.String r4 = "Attempt to access PhenotypeFlag not via codegen. All new PhenotypeFlags must be accessed through codegen APIs. If you believe you are seeing this error by mistake, you can add your flag to the exemption list located at //java/com/google/android/libraries/phenotype/client/lockdown/flags.textproto. Send the addition CL to ph-reviews@. See go/phenotype-android-codegen for information about generated code. See go/ph-lockdown for more information about this error."
            a.c.a.d.a.B(r0, r4)
            goto L_0x004d
        L_0x0043:
            throw r3
        L_0x0044:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "flagName must not be null"
            r0.<init>(r1)
            throw r0
        L_0x004c:
            throw r3
        L_0x004d:
            java.util.concurrent.atomic.AtomicInteger r0 = j
            int r0 = r0.get()
            int r4 = r7.f1633d
            if (r4 >= r0) goto L_0x0180
            monitor-enter(r7)
            int r4 = r7.f1633d     // Catch:{ all -> 0x017d }
            if (r4 >= r0) goto L_0x017b
            a.d.a.a.h.g.k2 r4 = h     // Catch:{ all -> 0x017d }
            if (r4 == 0) goto L_0x0062
            r5 = 1
            goto L_0x0063
        L_0x0062:
            r5 = 0
        L_0x0063:
            java.lang.String r6 = "Must call PhenotypeFlag.init() first"
            a.c.a.d.a.B(r5, r6)     // Catch:{ all -> 0x017d }
            r5 = r4
            a.d.a.a.h.g.q1 r5 = (a.d.a.a.h.g.q1) r5     // Catch:{ all -> 0x017d }
            android.content.Context r5 = r5.f1891a     // Catch:{ all -> 0x017d }
            a.d.a.a.h.g.x1 r5 = a.d.a.a.h.g.x1.a(r5)     // Catch:{ all -> 0x017d }
            java.lang.String r6 = "gms:phenotype:phenotype_flag:debug_bypass_phenotype"
            java.lang.Object r5 = r5.g(r6)     // Catch:{ all -> 0x017d }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x017d }
            if (r5 == 0) goto L_0x0088
            java.util.regex.Pattern r6 = a.d.a.a.h.g.l1.f1793c     // Catch:{ all -> 0x017d }
            java.util.regex.Matcher r5 = r6.matcher(r5)     // Catch:{ all -> 0x017d }
            boolean r5 = r5.matches()     // Catch:{ all -> 0x017d }
            if (r5 == 0) goto L_0x0088
            r1 = 1
        L_0x0088:
            if (r1 != 0) goto L_0x00cd
            a.d.a.a.h.g.l2 r1 = r7.f1630a     // Catch:{ all -> 0x017d }
            android.net.Uri r1 = r1.f1796a     // Catch:{ all -> 0x017d }
            if (r1 == 0) goto L_0x00b3
            r1 = r4
            a.d.a.a.h.g.q1 r1 = (a.d.a.a.h.g.q1) r1     // Catch:{ all -> 0x017d }
            android.content.Context r1 = r1.f1891a     // Catch:{ all -> 0x017d }
            a.d.a.a.h.g.l2 r2 = r7.f1630a     // Catch:{ all -> 0x017d }
            android.net.Uri r2 = r2.f1796a     // Catch:{ all -> 0x017d }
            boolean r1 = a.d.a.a.h.g.b2.a(r1, r2)     // Catch:{ all -> 0x017d }
            if (r1 == 0) goto L_0x00b1
            r1 = r4
            a.d.a.a.h.g.q1 r1 = (a.d.a.a.h.g.q1) r1     // Catch:{ all -> 0x017d }
            android.content.Context r1 = r1.f1891a     // Catch:{ all -> 0x017d }
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ all -> 0x017d }
            a.d.a.a.h.g.l2 r2 = r7.f1630a     // Catch:{ all -> 0x017d }
            android.net.Uri r2 = r2.f1796a     // Catch:{ all -> 0x017d }
            a.d.a.a.h.g.p1 r1 = a.d.a.a.h.g.p1.a(r1, r2)     // Catch:{ all -> 0x017d }
            goto L_0x00bc
        L_0x00b1:
            r1 = r3
            goto L_0x00bc
        L_0x00b3:
            r1 = r4
            a.d.a.a.h.g.q1 r1 = (a.d.a.a.h.g.q1) r1     // Catch:{ all -> 0x017d }
            android.content.Context r1 = r1.f1891a     // Catch:{ all -> 0x017d }
            a.d.a.a.h.g.m2 r1 = a.d.a.a.h.g.m2.a(r1)     // Catch:{ all -> 0x017d }
        L_0x00bc:
            if (r1 == 0) goto L_0x00f6
            java.lang.String r2 = r7.g()     // Catch:{ all -> 0x017d }
            java.lang.Object r1 = r1.g(r2)     // Catch:{ all -> 0x017d }
            if (r1 == 0) goto L_0x00f6
            java.lang.Object r1 = r7.e(r1)     // Catch:{ all -> 0x017d }
            goto L_0x00f7
        L_0x00cd:
            java.lang.String r1 = "PhenotypeFlag"
            r2 = 3
            boolean r1 = android.util.Log.isLoggable(r1, r2)     // Catch:{ all -> 0x017d }
            if (r1 == 0) goto L_0x00f6
            java.lang.String r1 = "PhenotypeFlag"
            java.lang.String r2 = "Bypass reading Phenotype values for flag: "
            java.lang.String r5 = r7.g()     // Catch:{ all -> 0x017d }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x017d }
            int r6 = r5.length()     // Catch:{ all -> 0x017d }
            if (r6 == 0) goto L_0x00ed
            java.lang.String r2 = r2.concat(r5)     // Catch:{ all -> 0x017d }
            goto L_0x00f3
        L_0x00ed:
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x017d }
            r5.<init>(r2)     // Catch:{ all -> 0x017d }
            r2 = r5
        L_0x00f3:
            android.util.Log.d(r1, r2)     // Catch:{ all -> 0x017d }
        L_0x00f6:
            r1 = r3
        L_0x00f7:
            if (r1 == 0) goto L_0x00fa
            goto L_0x011c
        L_0x00fa:
            r1 = r4
            a.d.a.a.h.g.q1 r1 = (a.d.a.a.h.g.q1) r1     // Catch:{ all -> 0x017d }
            android.content.Context r1 = r1.f1891a     // Catch:{ all -> 0x017d }
            a.d.a.a.h.g.x1 r1 = a.d.a.a.h.g.x1.a(r1)     // Catch:{ all -> 0x017d }
            a.d.a.a.h.g.l2 r2 = r7.f1630a     // Catch:{ all -> 0x017d }
            java.lang.String r2 = r2.f1797b     // Catch:{ all -> 0x017d }
            java.lang.String r2 = r7.f(r2)     // Catch:{ all -> 0x017d }
            java.lang.Object r1 = r1.g(r2)     // Catch:{ all -> 0x017d }
            if (r1 == 0) goto L_0x0116
            java.lang.Object r1 = r7.e(r1)     // Catch:{ all -> 0x017d }
            goto L_0x0117
        L_0x0116:
            r1 = r3
        L_0x0117:
            if (r1 == 0) goto L_0x011a
            goto L_0x011c
        L_0x011a:
            T r1 = r7.f1632c     // Catch:{ all -> 0x017d }
        L_0x011c:
            a.d.a.a.h.g.q1 r4 = (a.d.a.a.h.g.q1) r4     // Catch:{ all -> 0x017d }
            a.d.a.a.h.g.u2<a.d.a.a.h.g.s2<a.d.a.a.h.g.y1>> r2 = r4.f1892b     // Catch:{ all -> 0x017d }
            java.lang.Object r2 = r2.a()     // Catch:{ all -> 0x017d }
            a.d.a.a.h.g.s2 r2 = (a.d.a.a.h.g.s2) r2     // Catch:{ all -> 0x017d }
            boolean r4 = r2.b()     // Catch:{ all -> 0x017d }
            if (r4 == 0) goto L_0x0177
            java.lang.Object r1 = r2.c()     // Catch:{ all -> 0x017d }
            a.d.a.a.h.g.y1 r1 = (a.d.a.a.h.g.y1) r1     // Catch:{ all -> 0x017d }
            a.d.a.a.h.g.l2 r2 = r7.f1630a     // Catch:{ all -> 0x017d }
            android.net.Uri r2 = r2.f1796a     // Catch:{ all -> 0x017d }
            a.d.a.a.h.g.l2 r4 = r7.f1630a     // Catch:{ all -> 0x017d }
            java.lang.String r4 = r4.f1798c     // Catch:{ all -> 0x017d }
            java.lang.String r5 = r7.f1631b     // Catch:{ all -> 0x017d }
            if (r1 == 0) goto L_0x0176
            if (r2 == 0) goto L_0x016c
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x017d }
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r1 = r1.f2039a     // Catch:{ all -> 0x017d }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x017d }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ all -> 0x017d }
            if (r1 != 0) goto L_0x014f
            goto L_0x016c
        L_0x014f:
            if (r4 == 0) goto L_0x0165
            java.lang.String r2 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x017d }
            int r3 = r2.length()     // Catch:{ all -> 0x017d }
            if (r3 == 0) goto L_0x0160
            java.lang.String r5 = r4.concat(r2)     // Catch:{ all -> 0x017d }
            goto L_0x0165
        L_0x0160:
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x017d }
            r5.<init>(r4)     // Catch:{ all -> 0x017d }
        L_0x0165:
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x017d }
            r3 = r1
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x017d }
        L_0x016c:
            if (r3 != 0) goto L_0x0171
            T r1 = r7.f1632c     // Catch:{ all -> 0x017d }
            goto L_0x0177
        L_0x0171:
            java.lang.Object r1 = r7.e(r3)     // Catch:{ all -> 0x017d }
            goto L_0x0177
        L_0x0176:
            throw r3     // Catch:{ all -> 0x017d }
        L_0x0177:
            r7.f1634e = r1     // Catch:{ all -> 0x017d }
            r7.f1633d = r0     // Catch:{ all -> 0x017d }
        L_0x017b:
            monitor-exit(r7)     // Catch:{ all -> 0x017d }
            goto L_0x0180
        L_0x017d:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x017d }
            throw r0
        L_0x0180:
            T r0 = r7.f1634e
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.c2.h():java.lang.Object");
    }
}
