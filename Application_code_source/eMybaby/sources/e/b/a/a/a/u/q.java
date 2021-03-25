package e.b.a.a.a.u;

import e.b.a.a.a.d;
import e.b.a.a.a.n;
import e.b.a.a.a.u.t.u;
import e.b.a.a.a.v.b;
import e.b.a.a.a.v.c;

public class q {
    public static final b o = c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", q.class.getName());

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f5290a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5291b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5292c = false;

    /* renamed from: d  reason: collision with root package name */
    public Object f5293d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public Object f5294e = new Object();
    public u f = null;
    public n g = null;
    public String[] h = null;
    public String i;
    public d j = null;
    public e.b.a.a.a.c k = null;
    public Object l = null;
    public int m = 0;
    public boolean n = false;

    public q(String str) {
        o.i(str);
    }

    public void a(u uVar, n nVar) {
        o.e("e.b.a.a.a.u.q", "markComplete", "404", new Object[]{this.i, uVar, nVar});
        synchronized (this.f5293d) {
            boolean z = uVar instanceof e.b.a.a.a.u.t.b;
            this.f5291b = true;
            this.f = uVar;
            this.g = nVar;
        }
    }

    public void b() {
        o.e("e.b.a.a.a.u.q", "notifyComplete", "404", new Object[]{this.i, this.f, this.g});
        synchronized (this.f5293d) {
            if (this.g == null && this.f5291b) {
                this.f5290a = true;
            }
            this.f5291b = false;
            this.f5293d.notifyAll();
        }
        synchronized (this.f5294e) {
            this.f5292c = true;
            this.f5294e.notifyAll();
        }
    }

    public void c(n nVar) {
        synchronized (this.f5293d) {
            this.g = nVar;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:22|23|36|34|10|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x000b */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0022 A[SYNTHETIC, Splitter:B:22:0x0022] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d() {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f5294e
            monitor-enter(r0)
            java.lang.Object r1 = r8.f5293d     // Catch:{ all -> 0x0041 }
            monitor-enter(r1)     // Catch:{ all -> 0x0041 }
            e.b.a.a.a.n r2 = r8.g     // Catch:{ all -> 0x003e }
            if (r2 != 0) goto L_0x003b
            monitor-exit(r1)     // Catch:{ all -> 0x003e }
        L_0x000b:
            boolean r1 = r8.f5292c     // Catch:{ all -> 0x0041 }
            if (r1 == 0) goto L_0x0022
            boolean r1 = r8.f5292c     // Catch:{ all -> 0x0041 }
            if (r1 != 0) goto L_0x0020
            e.b.a.a.a.n r1 = r8.g     // Catch:{ all -> 0x0041 }
            if (r1 != 0) goto L_0x001d
            r1 = 6
            e.b.a.a.a.n r1 = a.e.a.a.r.b.g(r1)     // Catch:{ all -> 0x0041 }
            throw r1     // Catch:{ all -> 0x0041 }
        L_0x001d:
            e.b.a.a.a.n r1 = r8.g     // Catch:{ all -> 0x0041 }
            throw r1     // Catch:{ all -> 0x0041 }
        L_0x0020:
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            return
        L_0x0022:
            e.b.a.a.a.v.b r1 = o     // Catch:{ InterruptedException -> 0x000b }
            java.lang.String r2 = "e.b.a.a.a.u.q"
            java.lang.String r3 = "waitUntilSent"
            java.lang.String r4 = "409"
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ InterruptedException -> 0x000b }
            r6 = 0
            java.lang.String r7 = r8.i     // Catch:{ InterruptedException -> 0x000b }
            r5[r6] = r7     // Catch:{ InterruptedException -> 0x000b }
            r1.e(r2, r3, r4, r5)     // Catch:{ InterruptedException -> 0x000b }
            java.lang.Object r1 = r8.f5294e     // Catch:{ InterruptedException -> 0x000b }
            r1.wait()     // Catch:{ InterruptedException -> 0x000b }
            goto L_0x000b
        L_0x003b:
            e.b.a.a.a.n r2 = r8.g     // Catch:{ all -> 0x003e }
            throw r2     // Catch:{ all -> 0x003e }
        L_0x003e:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x003e }
            throw r2     // Catch:{ all -> 0x0041 }
        L_0x0041:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            goto L_0x0045
        L_0x0044:
            throw r1
        L_0x0045:
            goto L_0x0044
        */
        throw new UnsupportedOperationException("Method not decompiled: e.b.a.a.a.u.q.d():void");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(this.i);
        stringBuffer.append(" ,topics=");
        if (this.h != null) {
            int i2 = 0;
            while (true) {
                String[] strArr = this.h;
                if (i2 >= strArr.length) {
                    break;
                }
                stringBuffer.append(strArr[i2]);
                stringBuffer.append(", ");
                i2++;
            }
        }
        stringBuffer.append(" ,usercontext=");
        stringBuffer.append(this.l);
        stringBuffer.append(" ,isComplete=");
        stringBuffer.append(this.f5290a);
        stringBuffer.append(" ,isNotified=");
        stringBuffer.append(this.n);
        stringBuffer.append(" ,exception=");
        stringBuffer.append(this.g);
        stringBuffer.append(" ,actioncallback=");
        stringBuffer.append(this.k);
        return stringBuffer.toString();
    }
}
