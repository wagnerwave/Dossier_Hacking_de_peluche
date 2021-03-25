package e.b.a.a.a.u;

import e.b.a.a.a.n;
import e.b.a.a.a.t;
import e.b.a.a.a.u.t.g;
import e.b.a.a.a.u.t.u;
import e.b.a.a.a.v.b;
import e.b.a.a.a.v.c;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class e implements Runnable {
    public static final String k;
    public static final b l;

    /* renamed from: a  reason: collision with root package name */
    public boolean f5256a = false;

    /* renamed from: b  reason: collision with root package name */
    public Object f5257b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public b f5258c = null;

    /* renamed from: d  reason: collision with root package name */
    public g f5259d;

    /* renamed from: e  reason: collision with root package name */
    public a f5260e = null;
    public f f = null;
    public Thread g = null;
    public String h;
    public final Semaphore i = new Semaphore(1);
    public Future j;

    static {
        String name = e.class.getName();
        k = name;
        l = c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", name);
    }

    public e(a aVar, b bVar, f fVar, OutputStream outputStream) {
        this.f5259d = new g(bVar, outputStream);
        this.f5260e = aVar;
        this.f5258c = bVar;
        this.f = fVar;
        l.i(aVar.f5224a.getClientId());
    }

    public final void a(Exception exc) {
        l.c(k, "handleRunException", "804", (Object[]) null, exc);
        n nVar = !(exc instanceof n) ? new n(32109, exc) : (n) exc;
        this.f5256a = false;
        this.f5260e.l((t) null, nVar);
    }

    public void b(String str, ExecutorService executorService) {
        this.h = str;
        synchronized (this.f5257b) {
            if (!this.f5256a) {
                this.f5256a = true;
                this.j = executorService.submit(this);
            }
        }
    }

    public void c() {
        Semaphore semaphore;
        synchronized (this.f5257b) {
            if (this.j != null) {
                this.j.cancel(true);
            }
            l.h(k, "stop", "800");
            if (this.f5256a) {
                this.f5256a = false;
                if (!Thread.currentThread().equals(this.g)) {
                    while (this.f5256a) {
                        try {
                            this.f5258c.o();
                            this.i.tryAcquire(100, TimeUnit.MILLISECONDS);
                        } catch (InterruptedException unused) {
                            semaphore = this.i;
                        } catch (Throwable th) {
                            this.i.release();
                            throw th;
                        }
                    }
                    semaphore = this.i;
                    semaphore.release();
                }
            }
            this.g = null;
            l.h(k, "stop", "801");
        }
    }

    /* JADX INFO: finally extract failed */
    public void run() {
        Thread currentThread = Thread.currentThread();
        this.g = currentThread;
        currentThread.setName(this.h);
        try {
            this.i.acquire();
            while (this.f5256a && this.f5259d != null) {
                try {
                    try {
                        u g2 = this.f5258c.g();
                        if (g2 != null) {
                            l.e(k, "run", "802", new Object[]{g2.m(), g2});
                            if (g2 instanceof e.b.a.a.a.u.t.b) {
                                this.f5259d.a(g2);
                                this.f5259d.f5332b.flush();
                            } else {
                                t d2 = this.f.d(g2);
                                if (d2 != null) {
                                    synchronized (d2) {
                                        this.f5259d.a(g2);
                                        try {
                                            this.f5259d.f5332b.flush();
                                        } catch (IOException e2) {
                                            if (!(g2 instanceof e.b.a.a.a.u.t.e)) {
                                                throw e2;
                                            }
                                        }
                                        this.f5258c.t(g2);
                                    }
                                } else {
                                    continue;
                                }
                            }
                        } else {
                            l.h(k, "run", "803");
                            this.f5256a = false;
                        }
                    } catch (n | Exception e3) {
                        a(e3);
                    }
                } catch (Throwable th) {
                    this.f5256a = false;
                    this.i.release();
                    throw th;
                }
            }
            this.f5256a = false;
            this.i.release();
            l.h(k, "run", "805");
        } catch (InterruptedException unused) {
            this.f5256a = false;
        }
    }
}
