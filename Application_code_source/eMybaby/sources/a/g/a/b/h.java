package a.g.a.b;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public final f f3390a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f3391b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f3392c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f3393d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<Integer, String> f3394e = Collections.synchronizedMap(new HashMap());
    public final Map<String, ReentrantLock> f = new WeakHashMap();
    public final AtomicBoolean g = new AtomicBoolean(false);
    public final AtomicBoolean h = new AtomicBoolean(false);

    public h(f fVar) {
        this.f3390a = fVar;
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [a.g.a.b.l.j.a] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.concurrent.ExecutorService a() {
        /*
            r9 = this;
            a.g.a.b.f r0 = r9.f3390a
            a.g.a.b.l.g r0 = r0.j
            a.g.a.b.l.g r1 = a.g.a.b.l.g.LIFO
            if (r0 != r1) goto L_0x000a
            r0 = 1
            goto L_0x000b
        L_0x000a:
            r0 = 0
        L_0x000b:
            if (r0 == 0) goto L_0x0013
            a.g.a.b.l.j.a r0 = new a.g.a.b.l.j.a
            r0.<init>()
            goto L_0x0018
        L_0x0013:
            java.util.concurrent.LinkedBlockingQueue r0 = new java.util.concurrent.LinkedBlockingQueue
            r0.<init>()
        L_0x0018:
            r7 = r0
            java.util.concurrent.ThreadPoolExecutor r0 = new java.util.concurrent.ThreadPoolExecutor
            a.g.a.b.f r1 = r9.f3390a
            int r3 = r1.h
            r4 = 0
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS
            java.util.concurrent.ThreadFactory r8 = r1.o
            r1 = r0
            r2 = r3
            r1.<init>(r2, r3, r4, r6, r7, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.g.a.b.h.a():java.util.concurrent.ExecutorService");
    }

    public final void b() {
        ExecutorService executorService = this.f3391b;
        if (executorService == null || executorService.isShutdown()) {
            this.f3391b = a();
        }
        ExecutorService executorService2 = this.f3392c;
        if (executorService2 == null || executorService2.isShutdown()) {
            this.f3392c = a();
        }
        ExecutorService executorService3 = this.f3393d;
        if (executorService3 == null || executorService3.isShutdown()) {
            this.f3393d = Executors.newCachedThreadPool();
        }
    }
}
