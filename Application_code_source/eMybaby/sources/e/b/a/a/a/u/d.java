package e.b.a.a.a.u;

import e.b.a.a.a.n;
import e.b.a.a.a.t;
import e.b.a.a.a.u.t.f;
import e.b.a.a.a.u.t.k;
import e.b.a.a.a.u.t.l;
import e.b.a.a.a.u.t.m;
import e.b.a.a.a.u.t.u;
import e.b.a.a.a.v.b;
import e.b.a.a.a.v.c;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

public class d implements Runnable {
    public static final String k;
    public static final b l;

    /* renamed from: a  reason: collision with root package name */
    public boolean f5251a = false;

    /* renamed from: b  reason: collision with root package name */
    public Object f5252b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public b f5253c = null;

    /* renamed from: d  reason: collision with root package name */
    public a f5254d = null;

    /* renamed from: e  reason: collision with root package name */
    public f f5255e;
    public f f = null;
    public Thread g = null;
    public final Semaphore h = new Semaphore(1);
    public String i;
    public Future j;

    static {
        String name = d.class.getName();
        k = name;
        l = c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", name);
    }

    public d(a aVar, b bVar, f fVar, InputStream inputStream) {
        this.f5255e = new f(bVar, inputStream);
        this.f5254d = aVar;
        this.f5253c = bVar;
        this.f = fVar;
        l.i(aVar.f5224a.getClientId());
    }

    public void a(String str, ExecutorService executorService) {
        this.i = str;
        l.h(k, "start", "855");
        synchronized (this.f5252b) {
            if (!this.f5251a) {
                this.f5251a = true;
                this.j = executorService.submit(this);
            }
        }
    }

    public void run() {
        Thread currentThread = Thread.currentThread();
        this.g = currentThread;
        currentThread.setName(this.i);
        try {
            this.h.acquire();
            t tVar = null;
            while (this.f5251a && this.f5255e != null) {
                try {
                    l.h(k, "run", "852");
                    int available = this.f5255e.available();
                    u b2 = this.f5255e.b();
                    if (b2 instanceof e.b.a.a.a.u.t.b) {
                        tVar = this.f.d(b2);
                        if (tVar != null) {
                            synchronized (tVar) {
                                this.f5253c.p((e.b.a.a.a.u.t.b) b2);
                            }
                        } else {
                            if (!(b2 instanceof m) && !(b2 instanceof l)) {
                                if (!(b2 instanceof k)) {
                                    throw new n(6);
                                }
                            }
                            l.h(k, "run", "857");
                        }
                    } else if (b2 != null) {
                        this.f5253c.r(b2);
                    }
                } catch (n e2) {
                    n nVar = e2;
                    l.c(k, "run", "856", (Object[]) null, nVar);
                    this.f5251a = false;
                    this.f5254d.l(tVar, nVar);
                } catch (IOException e3) {
                    try {
                        l.h(k, "run", "853");
                        this.f5251a = false;
                        if (!this.f5254d.j()) {
                            this.f5254d.l(tVar, new n(32109, e3));
                        }
                    } catch (Throwable th) {
                        this.h.release();
                        throw th;
                    }
                }
                this.h.release();
            }
            l.h(k, "run", "854");
        } catch (InterruptedException unused) {
            this.f5251a = false;
        }
    }
}
