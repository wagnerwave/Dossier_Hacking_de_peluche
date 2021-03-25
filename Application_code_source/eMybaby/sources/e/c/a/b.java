package e.c.a;

public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final i f5360a = new i();

    /* renamed from: b  reason: collision with root package name */
    public final c f5361b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f5362c;

    public b(c cVar) {
        this.f5361b = cVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0032, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0034, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        android.util.Log.w("Event", java.lang.Thread.currentThread().getName() + " was interruppted", r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0055, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0056, code lost:
        r5.f5362c = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0059, code lost:
        throw r1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r5 = this;
        L_0x0000:
            r0 = 0
            e.c.a.i r1 = r5.f5360a     // Catch:{ InterruptedException -> 0x0034 }
            r2 = 1000(0x3e8, float:1.401E-42)
            monitor-enter(r1)     // Catch:{ InterruptedException -> 0x0034 }
            e.c.a.h r3 = r1.f5387a     // Catch:{ all -> 0x002f }
            if (r3 != 0) goto L_0x000e
            long r2 = (long) r2     // Catch:{ all -> 0x002f }
            r1.wait(r2)     // Catch:{ all -> 0x002f }
        L_0x000e:
            e.c.a.h r2 = r1.a()     // Catch:{ all -> 0x002f }
            monitor-exit(r1)     // Catch:{ InterruptedException -> 0x0034 }
            if (r2 != 0) goto L_0x0029
            monitor-enter(r5)     // Catch:{ InterruptedException -> 0x0034 }
            e.c.a.i r1 = r5.f5360a     // Catch:{ all -> 0x0026 }
            e.c.a.h r2 = r1.a()     // Catch:{ all -> 0x0026 }
            if (r2 != 0) goto L_0x0024
            r5.f5362c = r0     // Catch:{ all -> 0x0026 }
            monitor-exit(r5)     // Catch:{ all -> 0x0026 }
            r5.f5362c = r0
            return
        L_0x0024:
            monitor-exit(r5)     // Catch:{ all -> 0x0026 }
            goto L_0x0029
        L_0x0026:
            r1 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0026 }
            throw r1     // Catch:{ InterruptedException -> 0x0034 }
        L_0x0029:
            e.c.a.c r1 = r5.f5361b     // Catch:{ InterruptedException -> 0x0034 }
            r1.b(r2)     // Catch:{ InterruptedException -> 0x0034 }
            goto L_0x0000
        L_0x002f:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ InterruptedException -> 0x0034 }
            throw r2     // Catch:{ InterruptedException -> 0x0034 }
        L_0x0032:
            r1 = move-exception
            goto L_0x0056
        L_0x0034:
            r1 = move-exception
            java.lang.String r2 = "Event"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0032 }
            r3.<init>()     // Catch:{ all -> 0x0032 }
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0032 }
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x0032 }
            r3.append(r4)     // Catch:{ all -> 0x0032 }
            java.lang.String r4 = " was interruppted"
            r3.append(r4)     // Catch:{ all -> 0x0032 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0032 }
            android.util.Log.w(r2, r3, r1)     // Catch:{ all -> 0x0032 }
            r5.f5362c = r0
            return
        L_0x0056:
            r5.f5362c = r0
            goto L_0x005a
        L_0x0059:
            throw r1
        L_0x005a:
            goto L_0x0059
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.b.run():void");
    }
}
