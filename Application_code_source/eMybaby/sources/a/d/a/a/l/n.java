package a.d.a.a.l;

import androidx.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

public final class n<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Object f2705a = new Object();
    @GuardedBy("mLock")

    /* renamed from: b  reason: collision with root package name */
    public Queue<m<TResult>> f2706b;
    @GuardedBy("mLock")

    /* renamed from: c  reason: collision with root package name */
    public boolean f2707c;

    public final void a(@NonNull m<TResult> mVar) {
        synchronized (this.f2705a) {
            if (this.f2706b == null) {
                this.f2706b = new ArrayDeque();
            }
            this.f2706b.add(mVar);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0010, code lost:
        r1 = r2.f2705a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0012, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r0 = r2.f2706b.poll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001b, code lost:
        if (r0 != null) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001d, code lost:
        r2.f2707c = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0020, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0022, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0023, code lost:
        r0.a(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(@androidx.annotation.NonNull a.d.a.a.l.p<TResult> r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f2705a
            monitor-enter(r0)
            java.util.Queue<a.d.a.a.l.m<TResult>> r1 = r2.f2706b     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x002a
            boolean r1 = r2.f2707c     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x000c
            goto L_0x002a
        L_0x000c:
            r1 = 1
            r2.f2707c = r1     // Catch:{ all -> 0x002c }
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
        L_0x0010:
            java.lang.Object r1 = r2.f2705a
            monitor-enter(r1)
            java.util.Queue<a.d.a.a.l.m<TResult>> r0 = r2.f2706b     // Catch:{ all -> 0x0027 }
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x0027 }
            a.d.a.a.l.m r0 = (a.d.a.a.l.m) r0     // Catch:{ all -> 0x0027 }
            if (r0 != 0) goto L_0x0022
            r3 = 0
            r2.f2707c = r3     // Catch:{ all -> 0x0027 }
            monitor-exit(r1)     // Catch:{ all -> 0x0027 }
            return
        L_0x0022:
            monitor-exit(r1)     // Catch:{ all -> 0x0027 }
            r0.a(r3)
            goto L_0x0010
        L_0x0027:
            r3 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0027 }
            throw r3
        L_0x002a:
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
            return
        L_0x002c:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
            goto L_0x0030
        L_0x002f:
            throw r3
        L_0x0030:
            goto L_0x002f
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.l.n.b(a.d.a.a.l.p):void");
    }
}
