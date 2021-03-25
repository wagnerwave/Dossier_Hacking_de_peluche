package a.d.a.a.i.b;

import a.c.a.f.b;
import androidx.annotation.GuardedBy;
import java.util.concurrent.BlockingQueue;

public final class y4 extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final Object f2634a;

    /* renamed from: b  reason: collision with root package name */
    public final BlockingQueue<z4<?>> f2635b;
    @GuardedBy("threadLifeCycleLock")

    /* renamed from: c  reason: collision with root package name */
    public boolean f2636c = false;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ v4 f2637d;

    public y4(v4 v4Var, String str, BlockingQueue<z4<?>> blockingQueue) {
        this.f2637d = v4Var;
        b.k(str);
        b.k(blockingQueue);
        this.f2634a = new Object();
        this.f2635b = blockingQueue;
        setName(str);
    }

    public final void a(InterruptedException interruptedException) {
        this.f2637d.i().i.b(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    public final void b() {
        synchronized (this.f2637d.i) {
            if (!this.f2636c) {
                this.f2637d.j.release();
                this.f2637d.i.notifyAll();
                if (this == this.f2637d.f2560c) {
                    this.f2637d.f2560c = null;
                } else if (this == this.f2637d.f2561d) {
                    this.f2637d.f2561d = null;
                } else {
                    this.f2637d.i().f.a("Current scheduler thread is neither worker nor network");
                }
                this.f2636c = true;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x006f, code lost:
        b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0072, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r5 = this;
            r0 = 0
        L_0x0001:
            if (r0 != 0) goto L_0x0011
            a.d.a.a.i.b.v4 r1 = r5.f2637d     // Catch:{ InterruptedException -> 0x000c }
            java.util.concurrent.Semaphore r1 = r1.j     // Catch:{ InterruptedException -> 0x000c }
            r1.acquire()     // Catch:{ InterruptedException -> 0x000c }
            r0 = 1
            goto L_0x0001
        L_0x000c:
            r1 = move-exception
            r5.a(r1)
            goto L_0x0001
        L_0x0011:
            int r0 = android.os.Process.myTid()     // Catch:{ all -> 0x007b }
            int r0 = android.os.Process.getThreadPriority(r0)     // Catch:{ all -> 0x007b }
        L_0x0019:
            java.util.concurrent.BlockingQueue<a.d.a.a.i.b.z4<?>> r1 = r5.f2635b     // Catch:{ all -> 0x007b }
            java.lang.Object r1 = r1.poll()     // Catch:{ all -> 0x007b }
            a.d.a.a.i.b.z4 r1 = (a.d.a.a.i.b.z4) r1     // Catch:{ all -> 0x007b }
            if (r1 == 0) goto L_0x0032
            boolean r2 = r1.f2659b     // Catch:{ all -> 0x007b }
            if (r2 == 0) goto L_0x0029
            r2 = r0
            goto L_0x002b
        L_0x0029:
            r2 = 10
        L_0x002b:
            android.os.Process.setThreadPriority(r2)     // Catch:{ all -> 0x007b }
            r1.run()     // Catch:{ all -> 0x007b }
            goto L_0x0019
        L_0x0032:
            java.lang.Object r1 = r5.f2634a     // Catch:{ all -> 0x007b }
            monitor-enter(r1)     // Catch:{ all -> 0x007b }
            java.util.concurrent.BlockingQueue<a.d.a.a.i.b.z4<?>> r2 = r5.f2635b     // Catch:{ all -> 0x0078 }
            java.lang.Object r2 = r2.peek()     // Catch:{ all -> 0x0078 }
            if (r2 != 0) goto L_0x004f
            a.d.a.a.i.b.v4 r2 = r5.f2637d     // Catch:{ all -> 0x0078 }
            boolean r2 = r2.k     // Catch:{ all -> 0x0078 }
            if (r2 != 0) goto L_0x004f
            java.lang.Object r2 = r5.f2634a     // Catch:{ InterruptedException -> 0x004b }
            r3 = 30000(0x7530, double:1.4822E-319)
            r2.wait(r3)     // Catch:{ InterruptedException -> 0x004b }
            goto L_0x004f
        L_0x004b:
            r2 = move-exception
            r5.a(r2)     // Catch:{ all -> 0x0078 }
        L_0x004f:
            monitor-exit(r1)     // Catch:{ all -> 0x0078 }
            a.d.a.a.i.b.v4 r1 = r5.f2637d     // Catch:{ all -> 0x007b }
            java.lang.Object r1 = r1.i     // Catch:{ all -> 0x007b }
            monitor-enter(r1)     // Catch:{ all -> 0x007b }
            java.util.concurrent.BlockingQueue<a.d.a.a.i.b.z4<?>> r2 = r5.f2635b     // Catch:{ all -> 0x0075 }
            java.lang.Object r2 = r2.peek()     // Catch:{ all -> 0x0075 }
            if (r2 != 0) goto L_0x0073
            a.d.a.a.i.b.v4 r0 = r5.f2637d     // Catch:{ all -> 0x0075 }
            a.d.a.a.i.b.c5 r0 = r0.f2563a     // Catch:{ all -> 0x0075 }
            a.d.a.a.i.b.ka r0 = r0.g     // Catch:{ all -> 0x0075 }
            a.d.a.a.i.b.n3<java.lang.Boolean> r2 = a.d.a.a.i.b.q.t0     // Catch:{ all -> 0x0075 }
            boolean r0 = r0.o(r2)     // Catch:{ all -> 0x0075 }
            if (r0 == 0) goto L_0x006e
            r5.b()     // Catch:{ all -> 0x0075 }
        L_0x006e:
            monitor-exit(r1)     // Catch:{ all -> 0x0075 }
            r5.b()
            return
        L_0x0073:
            monitor-exit(r1)     // Catch:{ all -> 0x0075 }
            goto L_0x0019
        L_0x0075:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0075 }
            throw r0     // Catch:{ all -> 0x007b }
        L_0x0078:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0078 }
            throw r0     // Catch:{ all -> 0x007b }
        L_0x007b:
            r0 = move-exception
            r5.b()
            goto L_0x0081
        L_0x0080:
            throw r0
        L_0x0081:
            goto L_0x0080
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.y4.run():void");
    }
}
