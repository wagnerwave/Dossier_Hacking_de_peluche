package e.b.a.a.a.u.s;

import e.b.a.a.a.v.b;
import e.b.a.a.a.v.c;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class g implements Runnable {
    public static final String g;
    public static final b h;

    /* renamed from: a  reason: collision with root package name */
    public boolean f5315a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5316b = false;

    /* renamed from: c  reason: collision with root package name */
    public Object f5317c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public InputStream f5318d;

    /* renamed from: e  reason: collision with root package name */
    public Thread f5319e = null;
    public PipedOutputStream f;

    static {
        String name = g.class.getName();
        g = name;
        h = c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", name);
    }

    public g(InputStream inputStream, PipedInputStream pipedInputStream) {
        this.f5318d = inputStream;
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        this.f = pipedOutputStream;
        pipedInputStream.connect(pipedOutputStream);
    }

    public void a(String str) {
        h.h(g, "start", "855");
        synchronized (this.f5317c) {
            if (!this.f5315a) {
                this.f5315a = true;
                Thread thread = new Thread(this, str);
                this.f5319e = thread;
                thread.start();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(3:5|6|7)(1:8)|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r6 = this;
            r0 = 1
            r6.f5316b = r0
            java.lang.Object r1 = r6.f5317c
            monitor-enter(r1)
            e.b.a.a.a.v.b r2 = h     // Catch:{ all -> 0x0042 }
            java.lang.String r3 = g     // Catch:{ all -> 0x0042 }
            java.lang.String r4 = "stop"
            java.lang.String r5 = "850"
            r2.h(r3, r4, r5)     // Catch:{ all -> 0x0042 }
            boolean r2 = r6.f5315a     // Catch:{ all -> 0x0042 }
            r3 = 0
            if (r2 == 0) goto L_0x001e
            r6.f5315a = r3     // Catch:{ all -> 0x0042 }
            java.io.PipedOutputStream r2 = r6.f     // Catch:{ IOException -> 0x001f }
            r2.close()     // Catch:{ IOException -> 0x001f }
            goto L_0x001f
        L_0x001e:
            r0 = 0
        L_0x001f:
            monitor-exit(r1)     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0033
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.Thread r1 = r6.f5319e
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0033
            java.lang.Thread r0 = r6.f5319e     // Catch:{ InterruptedException -> 0x0033 }
            r0.join()     // Catch:{ InterruptedException -> 0x0033 }
        L_0x0033:
            r0 = 0
            r6.f5319e = r0
            e.b.a.a.a.v.b r0 = h
            java.lang.String r1 = g
            java.lang.String r2 = "stop"
            java.lang.String r3 = "851"
            r0.h(r1, r2, r3)
            return
        L_0x0042:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0042 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.b.a.a.a.u.s.g.b():void");
    }

    public void run() {
        while (this.f5315a && this.f5318d != null) {
            try {
                h.h(g, "run", "852");
                this.f5318d.available();
                d dVar = new d(this.f5318d);
                if (!dVar.f5309d) {
                    for (byte write : dVar.f5308c) {
                        this.f.write(write);
                    }
                    this.f.flush();
                } else if (!this.f5316b) {
                    throw new IOException("Server sent a WebSocket Frame with the Stop OpCode");
                }
            } catch (IOException unused) {
                b();
            }
        }
    }
}
