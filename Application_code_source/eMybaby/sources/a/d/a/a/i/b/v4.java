package a.d.a.a.i.b;

import a.c.a.f.b;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

public final class v4 extends y5 {
    public static final AtomicLong l = new AtomicLong(Long.MIN_VALUE);

    /* renamed from: c  reason: collision with root package name */
    public y4 f2560c;

    /* renamed from: d  reason: collision with root package name */
    public y4 f2561d;

    /* renamed from: e  reason: collision with root package name */
    public final PriorityBlockingQueue<z4<?>> f2562e = new PriorityBlockingQueue<>();
    public final BlockingQueue<z4<?>> f = new LinkedBlockingQueue();
    public final Thread.UncaughtExceptionHandler g = new x4(this, "Thread death: Uncaught exception on worker thread");
    public final Thread.UncaughtExceptionHandler h = new x4(this, "Thread death: Uncaught exception on network thread");
    public final Object i = new Object();
    public final Semaphore j = new Semaphore(2);
    public volatile boolean k;

    public v4(c5 c5Var) {
        super(c5Var);
    }

    public final void a() {
        if (Thread.currentThread() != this.f2561d) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final void b() {
        if (Thread.currentThread() != this.f2560c) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final boolean q() {
        return false;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:15|16|(1:18)(1:19)|20|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        if (r5.length() == 0) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
        r4 = "Timed out waiting for ".concat(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        r4 = new java.lang.String("Timed out waiting for ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        r3.a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = i().i;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003b, code lost:
        if (r5.length() != 0) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
        r4 = "Interrupted waiting for ".concat(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        r4 = new java.lang.String("Interrupted waiting for ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
        r3.a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004d, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000c, code lost:
        r2 = r2.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0010, code lost:
        if (r2 != null) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        r3 = i().i;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T s(java.util.concurrent.atomic.AtomicReference<T> r2, long r3, java.lang.String r5, java.lang.Runnable r6) {
        /*
            r1 = this;
            monitor-enter(r2)
            a.d.a.a.i.b.v4 r0 = r1.f()     // Catch:{ all -> 0x004e }
            r0.v(r6)     // Catch:{ all -> 0x004e }
            r2.wait(r3)     // Catch:{ InterruptedException -> 0x002f }
            monitor-exit(r2)     // Catch:{ all -> 0x004e }
            java.lang.Object r2 = r2.get()
            if (r2 != 0) goto L_0x002e
            a.d.a.a.i.b.x3 r3 = r1.i()
            a.d.a.a.i.b.z3 r3 = r3.i
            java.lang.String r4 = "Timed out waiting for "
            int r6 = r5.length()
            if (r6 == 0) goto L_0x0025
            java.lang.String r4 = r4.concat(r5)
            goto L_0x002b
        L_0x0025:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r4)
            r4 = r5
        L_0x002b:
            r3.a(r4)
        L_0x002e:
            return r2
        L_0x002f:
            a.d.a.a.i.b.x3 r3 = r1.i()     // Catch:{ all -> 0x004e }
            a.d.a.a.i.b.z3 r3 = r3.i     // Catch:{ all -> 0x004e }
            java.lang.String r4 = "Interrupted waiting for "
            int r6 = r5.length()     // Catch:{ all -> 0x004e }
            if (r6 == 0) goto L_0x0042
            java.lang.String r4 = r4.concat(r5)     // Catch:{ all -> 0x004e }
            goto L_0x0048
        L_0x0042:
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x004e }
            r5.<init>(r4)     // Catch:{ all -> 0x004e }
            r4 = r5
        L_0x0048:
            r3.a(r4)     // Catch:{ all -> 0x004e }
            r3 = 0
            monitor-exit(r2)     // Catch:{ all -> 0x004e }
            return r3
        L_0x004e:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x004e }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.v4.s(java.util.concurrent.atomic.AtomicReference, long, java.lang.String, java.lang.Runnable):java.lang.Object");
    }

    public final <V> Future<V> t(Callable<V> callable) {
        n();
        b.k(callable);
        z4 z4Var = new z4(this, callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.f2560c) {
            if (!this.f2562e.isEmpty()) {
                i().i.a("Callable skipped the worker queue.");
            }
            z4Var.run();
        } else {
            u(z4Var);
        }
        return z4Var;
    }

    public final void u(z4<?> z4Var) {
        synchronized (this.i) {
            this.f2562e.add(z4Var);
            if (this.f2560c == null) {
                y4 y4Var = new y4(this, "Measurement Worker", this.f2562e);
                this.f2560c = y4Var;
                y4Var.setUncaughtExceptionHandler(this.g);
                this.f2560c.start();
            } else {
                y4 y4Var2 = this.f2560c;
                synchronized (y4Var2.f2634a) {
                    y4Var2.f2634a.notifyAll();
                }
            }
        }
    }

    public final void v(Runnable runnable) {
        n();
        b.k(runnable);
        u(new z4(this, runnable, false, "Task exception on worker thread"));
    }

    public final void w(Runnable runnable) {
        n();
        b.k(runnable);
        z4 z4Var = new z4(this, runnable, false, "Task exception on network thread");
        synchronized (this.i) {
            this.f.add(z4Var);
            if (this.f2561d == null) {
                y4 y4Var = new y4(this, "Measurement Network", this.f);
                this.f2561d = y4Var;
                y4Var.setUncaughtExceptionHandler(this.h);
                this.f2561d.start();
            } else {
                y4 y4Var2 = this.f2561d;
                synchronized (y4Var2.f2634a) {
                    y4Var2.f2634a.notifyAll();
                }
            }
        }
    }

    public final boolean x() {
        return Thread.currentThread() == this.f2560c;
    }
}
