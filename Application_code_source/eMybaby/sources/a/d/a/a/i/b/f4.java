package a.d.a.a.i.b;

import a.c.a.f.b;
import androidx.annotation.WorkerThread;
import java.net.URL;
import java.util.Map;

@WorkerThread
public final class f4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final URL f2186a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f2187b;

    /* renamed from: c  reason: collision with root package name */
    public final d4 f2188c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2189d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, String> f2190e;
    public final /* synthetic */ b4 f;

    public f4(b4 b4Var, String str, URL url, byte[] bArr, Map<String, String> map, d4 d4Var) {
        this.f = b4Var;
        b.h(str);
        b.k(url);
        b.k(d4Var);
        this.f2186a = url;
        this.f2187b = bArr;
        this.f2188c = d4Var;
        this.f2189d = str;
        this.f2190e = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cb A[SYNTHETIC, Splitter:B:46:0x00cb] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0104 A[SYNTHETIC, Splitter:B:59:0x0104] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x011c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r13 = this;
            java.lang.String r0 = "Error closing HTTP compressed POST connection output stream. appId"
            a.d.a.a.i.b.b4 r1 = r13.f
            r1.a()
            r1 = 0
            r2 = 0
            a.d.a.a.i.b.b4 r3 = r13.f     // Catch:{ IOException -> 0x00fd, all -> 0x00c4 }
            java.net.URL r4 = r13.f2186a     // Catch:{ IOException -> 0x00fd, all -> 0x00c4 }
            java.net.HttpURLConnection r3 = r3.s(r4)     // Catch:{ IOException -> 0x00fd, all -> 0x00c4 }
            java.util.Map<java.lang.String, java.lang.String> r4 = r13.f2190e     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
            if (r4 == 0) goto L_0x003b
            java.util.Map<java.lang.String, java.lang.String> r4 = r13.f2190e     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
            java.util.Set r4 = r4.entrySet()     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
        L_0x001f:
            boolean r5 = r4.hasNext()     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
            if (r5 == 0) goto L_0x003b
            java.lang.Object r5 = r4.next()     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
            java.lang.Object r6 = r5.getKey()     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
            java.lang.Object r5 = r5.getValue()     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
            r3.addRequestProperty(r6, r5)     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
            goto L_0x001f
        L_0x003b:
            byte[] r4 = r13.f2187b     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
            if (r4 == 0) goto L_0x0086
            a.d.a.a.i.b.b4 r4 = r13.f     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
            a.d.a.a.i.b.s9 r4 = r4.l()     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
            byte[] r5 = r13.f2187b     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
            byte[] r4 = r4.T(r5)     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
            a.d.a.a.i.b.b4 r5 = r13.f     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
            a.d.a.a.i.b.x3 r5 = r5.i()     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
            a.d.a.a.i.b.z3 r5 = r5.n     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
            java.lang.String r6 = "Uploading data. size"
            int r7 = r4.length     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
            r5.b(r6, r7)     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
            r5 = 1
            r3.setDoOutput(r5)     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
            java.lang.String r5 = "Content-Encoding"
            java.lang.String r6 = "gzip"
            r3.addRequestProperty(r5, r6)     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
            int r5 = r4.length     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
            r3.setFixedLengthStreamingMode(r5)     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
            r3.connect()     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
            java.io.OutputStream r5 = r3.getOutputStream()     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
            r5.write(r4)     // Catch:{ IOException -> 0x0080, all -> 0x007a }
            r5.close()     // Catch:{ IOException -> 0x0080, all -> 0x007a }
            goto L_0x0086
        L_0x007a:
            r4 = move-exception
            r10 = r1
            r2 = r4
            r1 = r5
            goto L_0x00c8
        L_0x0080:
            r4 = move-exception
            r10 = r1
            r8 = r4
            r1 = r5
            goto L_0x0101
        L_0x0086:
            int r8 = r3.getResponseCode()     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
            java.util.Map r11 = r3.getHeaderFields()     // Catch:{ IOException -> 0x00b9, all -> 0x00b4 }
            byte[] r10 = a.d.a.a.i.b.b4.t(r3)     // Catch:{ IOException -> 0x00b0, all -> 0x00ab }
            r3.disconnect()
            a.d.a.a.i.b.b4 r0 = r13.f
            a.d.a.a.i.b.v4 r0 = r0.f()
            a.d.a.a.i.b.g4 r1 = new a.d.a.a.i.b.g4
            java.lang.String r6 = r13.f2189d
            a.d.a.a.i.b.d4 r7 = r13.f2188c
            r9 = 0
            r12 = 0
            r5 = r1
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
        L_0x00a7:
            r0.v(r1)
            return
        L_0x00ab:
            r4 = move-exception
            r2 = r4
            r7 = r8
            r10 = r11
            goto L_0x00c9
        L_0x00b0:
            r4 = move-exception
            r7 = r8
            r10 = r11
            goto L_0x00bc
        L_0x00b4:
            r4 = move-exception
            r10 = r1
            r2 = r4
            r7 = r8
            goto L_0x00c9
        L_0x00b9:
            r4 = move-exception
            r10 = r1
            r7 = r8
        L_0x00bc:
            r8 = r4
            goto L_0x0102
        L_0x00be:
            r4 = move-exception
            r10 = r1
            goto L_0x00c7
        L_0x00c1:
            r4 = move-exception
            r10 = r1
            goto L_0x0100
        L_0x00c4:
            r4 = move-exception
            r3 = r1
            r10 = r3
        L_0x00c7:
            r2 = r4
        L_0x00c8:
            r7 = 0
        L_0x00c9:
            if (r1 == 0) goto L_0x00e1
            r1.close()     // Catch:{ IOException -> 0x00cf }
            goto L_0x00e1
        L_0x00cf:
            r1 = move-exception
            a.d.a.a.i.b.b4 r4 = r13.f
            a.d.a.a.i.b.x3 r4 = r4.i()
            a.d.a.a.i.b.z3 r4 = r4.f
            java.lang.String r5 = r13.f2189d
            java.lang.Object r5 = a.d.a.a.i.b.x3.s(r5)
            r4.c(r0, r5, r1)
        L_0x00e1:
            if (r3 == 0) goto L_0x00e6
            r3.disconnect()
        L_0x00e6:
            a.d.a.a.i.b.b4 r0 = r13.f
            a.d.a.a.i.b.v4 r0 = r0.f()
            a.d.a.a.i.b.g4 r1 = new a.d.a.a.i.b.g4
            java.lang.String r5 = r13.f2189d
            a.d.a.a.i.b.d4 r6 = r13.f2188c
            r8 = 0
            r9 = 0
            r11 = 0
            r4 = r1
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            r0.v(r1)
            throw r2
        L_0x00fd:
            r4 = move-exception
            r3 = r1
            r10 = r3
        L_0x0100:
            r8 = r4
        L_0x0101:
            r7 = 0
        L_0x0102:
            if (r1 == 0) goto L_0x011a
            r1.close()     // Catch:{ IOException -> 0x0108 }
            goto L_0x011a
        L_0x0108:
            r1 = move-exception
            a.d.a.a.i.b.b4 r2 = r13.f
            a.d.a.a.i.b.x3 r2 = r2.i()
            a.d.a.a.i.b.z3 r2 = r2.f
            java.lang.String r4 = r13.f2189d
            java.lang.Object r4 = a.d.a.a.i.b.x3.s(r4)
            r2.c(r0, r4, r1)
        L_0x011a:
            if (r3 == 0) goto L_0x011f
            r3.disconnect()
        L_0x011f:
            a.d.a.a.i.b.b4 r0 = r13.f
            a.d.a.a.i.b.v4 r0 = r0.f()
            a.d.a.a.i.b.g4 r1 = new a.d.a.a.i.b.g4
            java.lang.String r5 = r13.f2189d
            a.d.a.a.i.b.d4 r6 = r13.f2188c
            r9 = 0
            r11 = 0
            r4 = r1
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            goto L_0x00a7
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.f4.run():void");
    }
}
