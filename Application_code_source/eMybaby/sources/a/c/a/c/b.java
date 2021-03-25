package a.c.a.c;

import java.util.concurrent.Callable;

public class b implements Callable<Long> {

    /* renamed from: a  reason: collision with root package name */
    public g f7a;

    /* renamed from: b  reason: collision with root package name */
    public c f8b;

    public b(c cVar, g gVar) {
        this.f7a = gVar;
        this.f8b = cVar;
    }

    public final boolean a() {
        return Thread.currentThread().isInterrupted();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01b0, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01b1, code lost:
        a.c.a.f.e.d(r1);
        r1 = r13.f7a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01b6, code lost:
        if (r1 != null) goto L_0x01b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01b8, code lost:
        ((a.c.a.c.e) r1).b(r13.f8b, "Error inesperado en la descarga");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0196 A[Catch:{ Exception -> 0x01b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0110 A[EDGE_INSN: B:119:0x0110->B:58:0x0110 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ed A[Catch:{ all -> 0x0190 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0119 A[Catch:{ all -> 0x0192 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0167 A[Catch:{ all -> 0x0192 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object call() {
        /*
            r13 = this;
            r0 = 0
            a.c.a.c.g r1 = r13.f7a     // Catch:{ Exception -> 0x01b0 }
            if (r1 == 0) goto L_0x000d
            a.c.a.c.g r1 = r13.f7a     // Catch:{ Exception -> 0x01b0 }
            a.c.a.c.a r1 = (a.c.a.c.a) r1     // Catch:{ Exception -> 0x01b0 }
            if (r1 == 0) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            throw r0     // Catch:{ Exception -> 0x01b0 }
        L_0x000d:
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x01b0 }
            a.c.a.c.c r2 = r13.f8b     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r2 = r2.f9a     // Catch:{ Exception -> 0x01b0 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x01b0 }
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Exception -> 0x01b0 }
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x01b0 }
            r2 = 1
            r1.setInstanceFollowRedirects(r2)     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r3 = "Accept-Encoding"
            java.lang.String r4 = "identity"
            r1.setRequestProperty(r3, r4)     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r3 = "connection"
            java.lang.String r4 = "close"
            r1.setRequestProperty(r3, r4)     // Catch:{ Exception -> 0x01b0 }
            r3 = 0
            r1.setUseCaches(r3)     // Catch:{ Exception -> 0x01b0 }
            r1.connect()     // Catch:{ Exception -> 0x01b0 }
            r1.getHeaderFields()     // Catch:{ Exception -> 0x01b0 }
            int r4 = r1.getResponseCode()     // Catch:{ Exception -> 0x01b0 }
            r5 = 301(0x12d, float:4.22E-43)
            if (r4 == r5) goto L_0x0048
            r5 = 302(0x12e, float:4.23E-43)
            if (r4 == r5) goto L_0x0048
            r5 = 303(0x12f, float:4.25E-43)
            if (r4 != r5) goto L_0x0077
        L_0x0048:
            java.lang.String r4 = "Location"
            java.lang.String r4 = r1.getHeaderField(r4)     // Catch:{ Exception -> 0x01b0 }
            r1.disconnect()     // Catch:{ Exception -> 0x01b0 }
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x01b0 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x01b0 }
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Exception -> 0x01b0 }
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x01b0 }
            r1.setInstanceFollowRedirects(r2)     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r4 = "Accept-Encoding"
            java.lang.String r5 = "identity"
            r1.setRequestProperty(r4, r5)     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r4 = "connection"
            java.lang.String r5 = "close"
            r1.setRequestProperty(r4, r5)     // Catch:{ Exception -> 0x01b0 }
            r1.setUseCaches(r3)     // Catch:{ Exception -> 0x01b0 }
            r1.connect()     // Catch:{ Exception -> 0x01b0 }
            int r4 = r1.getResponseCode()     // Catch:{ Exception -> 0x01b0 }
        L_0x0077:
            r5 = 200(0xc8, float:2.8E-43)
            if (r4 != r5) goto L_0x01a0
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x01b0 }
            java.io.InputStream r5 = r1.getInputStream()     // Catch:{ Exception -> 0x01b0 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x01b0 }
            r1.getContentLength()     // Catch:{ Exception -> 0x01b0 }
            r5 = 0
            a.c.a.c.c r7 = r13.f8b     // Catch:{ Exception -> 0x01b0 }
            java.io.File r7 = r7.f11c     // Catch:{ Exception -> 0x01b0 }
            if (r7 == 0) goto L_0x0094
            a.c.a.c.c r7 = r13.f8b     // Catch:{ Exception -> 0x01b0 }
            java.io.File r7 = r7.f11c     // Catch:{ Exception -> 0x01b0 }
            goto L_0x0098
        L_0x0094:
            a.c.a.c.c r7 = r13.f8b     // Catch:{ Exception -> 0x01b0 }
            java.io.File r7 = r7.f10b     // Catch:{ Exception -> 0x01b0 }
        L_0x0098:
            boolean r8 = r7.exists()     // Catch:{ all -> 0x0192 }
            if (r8 == 0) goto L_0x00b1
            boolean r8 = r7.delete()     // Catch:{ all -> 0x0192 }
            if (r8 != 0) goto L_0x00dd
            a.c.a.c.g r8 = r13.f7a     // Catch:{ all -> 0x0192 }
            if (r8 == 0) goto L_0x00dd
            a.c.a.c.g r8 = r13.f7a     // Catch:{ all -> 0x0192 }
            a.c.a.c.c r9 = r13.f8b     // Catch:{ all -> 0x0192 }
            java.lang.String r10 = "Error inesperado al eliminar el fichero anterior"
        L_0x00ae:
            a.c.a.c.e r8 = (a.c.a.c.e) r8
            goto L_0x00da
        L_0x00b1:
            java.io.File r8 = r7.getParentFile()     // Catch:{ all -> 0x0192 }
            boolean r8 = r8.exists()     // Catch:{ all -> 0x0192 }
            if (r8 != 0) goto L_0x00dd
            java.io.File r8 = r7.getParentFile()     // Catch:{ all -> 0x0192 }
            boolean r8 = r8.mkdirs()     // Catch:{ all -> 0x0192 }
            if (r8 != 0) goto L_0x00dd
            java.io.File r8 = r7.getParentFile()     // Catch:{ all -> 0x0192 }
            boolean r8 = r8.exists()     // Catch:{ all -> 0x0192 }
            if (r8 != 0) goto L_0x00dd
            a.c.a.c.g r8 = r13.f7a     // Catch:{ all -> 0x0192 }
            if (r8 == 0) goto L_0x00dd
            a.c.a.c.g r8 = r13.f7a     // Catch:{ all -> 0x0192 }
            a.c.a.c.c r9 = r13.f8b     // Catch:{ all -> 0x0192 }
            java.lang.String r10 = "Error inesperado al crear el directorio"
            goto L_0x00ae
        L_0x00da:
            r8.b(r9, r10)     // Catch:{ all -> 0x0192 }
        L_0x00dd:
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ all -> 0x0192 }
            r8.<init>(r7)     // Catch:{ all -> 0x0192 }
            r7 = 4096(0x1000, float:5.74E-42)
            byte[] r7 = new byte[r7]     // Catch:{ all -> 0x0190 }
        L_0x00e6:
            int r9 = r4.read(r7)     // Catch:{ all -> 0x0190 }
            r10 = -1
            if (r9 == r10) goto L_0x0110
            r8.write(r7, r3, r9)     // Catch:{ all -> 0x0190 }
            long r9 = (long) r9     // Catch:{ all -> 0x0190 }
            long r5 = r5 + r9
            boolean r9 = r13.a()     // Catch:{ all -> 0x0190 }
            if (r9 == 0) goto L_0x00f9
            goto L_0x0110
        L_0x00f9:
            a.c.a.c.g r9 = r13.f7a     // Catch:{ all -> 0x0190 }
            if (r9 == 0) goto L_0x00e6
            a.c.a.c.g r9 = r13.f7a     // Catch:{ all -> 0x0190 }
            a.c.a.c.c r10 = r13.f8b     // Catch:{ all -> 0x0190 }
            java.lang.Long r11 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0190 }
            a.c.a.c.c r12 = r13.f8b     // Catch:{ all -> 0x0190 }
            if (r12 == 0) goto L_0x010f
            a.c.a.c.e r9 = (a.c.a.c.e) r9
            r9.c(r10, r11, r0)     // Catch:{ all -> 0x0190 }
            goto L_0x00e6
        L_0x010f:
            throw r0     // Catch:{ all -> 0x0190 }
        L_0x0110:
            r8.close()     // Catch:{ all -> 0x0190 }
            a.c.a.c.c r3 = r13.f8b     // Catch:{ all -> 0x0192 }
            java.io.File r3 = r3.f11c     // Catch:{ all -> 0x0192 }
            if (r3 == 0) goto L_0x0161
            boolean r3 = r13.a()     // Catch:{ all -> 0x0192 }
            if (r3 == 0) goto L_0x0127
            a.c.a.c.c r3 = r13.f8b     // Catch:{ all -> 0x0192 }
            java.io.File r3 = r3.f11c     // Catch:{ all -> 0x0192 }
            r3.delete()     // Catch:{ all -> 0x0192 }
            goto L_0x0161
        L_0x0127:
            a.c.a.c.c r3 = r13.f8b     // Catch:{ all -> 0x0192 }
            if (r3 == 0) goto L_0x0160
            a.c.a.c.c r3 = r13.f8b     // Catch:{ all -> 0x0192 }
            java.io.File r3 = r3.f10b     // Catch:{ all -> 0x0192 }
            java.io.File r3 = r3.getParentFile()     // Catch:{ all -> 0x0192 }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x0192 }
            if (r3 != 0) goto L_0x0144
            a.c.a.c.c r3 = r13.f8b     // Catch:{ all -> 0x0192 }
            java.io.File r3 = r3.f10b     // Catch:{ all -> 0x0192 }
            java.io.File r3 = r3.getParentFile()     // Catch:{ all -> 0x0192 }
            r3.mkdirs()     // Catch:{ all -> 0x0192 }
        L_0x0144:
            a.c.a.c.c r3 = r13.f8b     // Catch:{ all -> 0x0192 }
            java.io.File r3 = r3.f11c     // Catch:{ all -> 0x0192 }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x0192 }
            if (r3 == 0) goto L_0x015a
            a.c.a.c.c r3 = r13.f8b     // Catch:{ all -> 0x0192 }
            java.io.File r3 = r3.f11c     // Catch:{ all -> 0x0192 }
            a.c.a.c.c r5 = r13.f8b     // Catch:{ all -> 0x0192 }
            java.io.File r5 = r5.f10b     // Catch:{ all -> 0x0192 }
            a.c.a.f.b.X(r3, r5)     // Catch:{ all -> 0x0192 }
            goto L_0x0161
        L_0x015a:
            java.lang.String r3 = "HEREE"
            a.c.a.f.e.b(r3)     // Catch:{ all -> 0x0192 }
            goto L_0x0161
        L_0x0160:
            throw r0     // Catch:{ all -> 0x0192 }
        L_0x0161:
            boolean r3 = r13.a()     // Catch:{ all -> 0x0192 }
            if (r3 != 0) goto L_0x0189
            a.c.a.c.c r3 = r13.f8b     // Catch:{ all -> 0x0192 }
            if (r3 == 0) goto L_0x0188
            a.c.a.c.c r3 = r13.f8b     // Catch:{ all -> 0x0192 }
            if (r3 == 0) goto L_0x0187
            a.c.a.c.g r3 = r13.f7a     // Catch:{ all -> 0x0192 }
            if (r3 == 0) goto L_0x0189
            a.c.a.c.g r3 = r13.f7a     // Catch:{ all -> 0x0192 }
            a.c.a.c.c r5 = r13.f8b     // Catch:{ all -> 0x0192 }
            a.c.a.c.e r3 = (a.c.a.c.e) r3     // Catch:{ all -> 0x0192 }
            monitor-enter(r3)     // Catch:{ all -> 0x0192 }
            java.util.ArrayList<a.c.a.c.c> r6 = r3.f16c     // Catch:{ all -> 0x0184 }
            r6.add(r5)     // Catch:{ all -> 0x0184 }
            r3.e(r5, r2)     // Catch:{ all -> 0x0184 }
            monitor-exit(r3)     // Catch:{ all -> 0x0184 }
            goto L_0x0189
        L_0x0184:
            r2 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0184 }
            throw r2     // Catch:{ all -> 0x0192 }
        L_0x0187:
            throw r0     // Catch:{ all -> 0x0192 }
        L_0x0188:
            throw r0     // Catch:{ all -> 0x0192 }
        L_0x0189:
            r4.close()     // Catch:{ Exception -> 0x01b0 }
            r1.disconnect()     // Catch:{ Exception -> 0x01b0 }
            goto L_0x01c1
        L_0x0190:
            r2 = move-exception
            goto L_0x0194
        L_0x0192:
            r2 = move-exception
            r8 = r0
        L_0x0194:
            if (r8 == 0) goto L_0x0199
            r8.close()     // Catch:{ Exception -> 0x01b0 }
        L_0x0199:
            r4.close()     // Catch:{ Exception -> 0x01b0 }
            r1.disconnect()     // Catch:{ Exception -> 0x01b0 }
            throw r2     // Catch:{ Exception -> 0x01b0 }
        L_0x01a0:
            a.c.a.c.g r1 = r13.f7a     // Catch:{ Exception -> 0x01b0 }
            if (r1 == 0) goto L_0x01c1
            a.c.a.c.g r1 = r13.f7a     // Catch:{ Exception -> 0x01b0 }
            a.c.a.c.c r2 = r13.f8b     // Catch:{ Exception -> 0x01b0 }
            java.lang.String r3 = "Error inesperado en la descarga"
            a.c.a.c.e r1 = (a.c.a.c.e) r1
            r1.b(r2, r3)     // Catch:{ Exception -> 0x01b0 }
            goto L_0x01c1
        L_0x01b0:
            r1 = move-exception
            a.c.a.f.e.d(r1)
            a.c.a.c.g r1 = r13.f7a
            if (r1 == 0) goto L_0x01c1
            a.c.a.c.c r2 = r13.f8b
            java.lang.String r3 = "Error inesperado en la descarga"
            a.c.a.c.e r1 = (a.c.a.c.e) r1
            r1.b(r2, r3)
        L_0x01c1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.c.a.c.b.call():java.lang.Object");
    }
}
