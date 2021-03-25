package a.d.a.a.i.b;

import a.c.a.f.b;
import androidx.annotation.WorkerThread;
import java.net.URL;
import java.util.List;
import java.util.Map;

@WorkerThread
public final class j7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final URL f2298a;

    /* renamed from: b  reason: collision with root package name */
    public final b5 f2299b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2300c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ h7 f2301d;

    public j7(h7 h7Var, String str, URL url, b5 b5Var) {
        this.f2301d = h7Var;
        b.h(str);
        b.k(url);
        b.k(b5Var);
        this.f2298a = url;
        this.f2299b = b5Var;
        this.f2300c = str;
    }

    public final void a(int i, Exception exc, byte[] bArr, Map<String, List<String>> map) {
        this.f2301d.f().v(new i7(this, i, exc, bArr, map));
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r5 = this;
            a.d.a.a.i.b.h7 r0 = r5.f2301d
            r0.a()
            r0 = 0
            r1 = 0
            a.d.a.a.i.b.h7 r2 = r5.f2301d     // Catch:{ IOException -> 0x0038, all -> 0x002c }
            java.net.URL r3 = r5.f2298a     // Catch:{ IOException -> 0x0038, all -> 0x002c }
            java.net.HttpURLConnection r2 = r2.s(r3)     // Catch:{ IOException -> 0x0038, all -> 0x002c }
            int r1 = r2.getResponseCode()     // Catch:{ IOException -> 0x0029, all -> 0x0026 }
            java.util.Map r3 = r2.getHeaderFields()     // Catch:{ IOException -> 0x0029, all -> 0x0026 }
            byte[] r4 = a.d.a.a.i.b.h7.t(r2)     // Catch:{ IOException -> 0x0024, all -> 0x0022 }
            r2.disconnect()
            r5.a(r1, r0, r4, r3)
            return
        L_0x0022:
            r4 = move-exception
            goto L_0x002f
        L_0x0024:
            r4 = move-exception
            goto L_0x003b
        L_0x0026:
            r4 = move-exception
            r3 = r0
            goto L_0x002f
        L_0x0029:
            r4 = move-exception
            r3 = r0
            goto L_0x003b
        L_0x002c:
            r4 = move-exception
            r2 = r0
            r3 = r2
        L_0x002f:
            if (r2 == 0) goto L_0x0034
            r2.disconnect()
        L_0x0034:
            r5.a(r1, r0, r0, r3)
            throw r4
        L_0x0038:
            r4 = move-exception
            r2 = r0
            r3 = r2
        L_0x003b:
            if (r2 == 0) goto L_0x0040
            r2.disconnect()
        L_0x0040:
            r5.a(r1, r4, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.j7.run():void");
    }
}
