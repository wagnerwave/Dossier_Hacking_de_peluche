package e.a.a.g0.h.o;

import androidx.recyclerview.widget.RecyclerView;
import e.a.a.d0.k.b;
import e.a.a.d0.l.a;
import e.a.a.g0.h.f;
import e.a.a.j0.c;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class e extends a {

    /* renamed from: c  reason: collision with root package name */
    public final Log f5041c;

    /* renamed from: d  reason: collision with root package name */
    public final Lock f5042d;

    /* renamed from: e  reason: collision with root package name */
    public final f f5043e;
    public final b f;
    public final Set<b> g;
    public final Queue<b> h;
    public final Queue<i> i;
    public final Map<a, g> j;
    public final long k;
    public final TimeUnit l;
    public volatile boolean m;
    public volatile int n;
    public volatile int o;

    @Deprecated
    public e(f fVar, c cVar) {
        if (cVar != null) {
            b bVar = (b) cVar.e("http.conn-manager.max-per-route");
            bVar = bVar == null ? e.a.a.d0.k.a.f4861a : bVar;
            int b2 = cVar.b("http.conn-manager.max-total", 20);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.f5041c = LogFactory.getLog(e.class);
            if (fVar != null) {
                this.f5042d = this.f5035a;
                this.g = this.f5036b;
                this.f5043e = fVar;
                this.f = bVar;
                this.n = b2;
                this.h = new LinkedList();
                this.i = new LinkedList();
                this.j = new HashMap();
                this.k = -1;
                this.l = timeUnit;
                return;
            }
            throw new IllegalArgumentException("Connection operator may not be null");
        }
        throw new IllegalArgumentException("HTTP parameters must not be null.");
    }

    public final void a(b bVar) {
        e.a.a.g0.h.e eVar = bVar.f5011b;
        if (eVar != null) {
            try {
                eVar.close();
            } catch (IOException e2) {
                this.f5041c.debug("I/O error closing connection", e2);
            }
        }
    }

    public b b(g gVar, f fVar) {
        if (this.f5041c.isDebugEnabled()) {
            Log log = this.f5041c;
            StringBuilder n2 = a.a.a.a.a.n("Creating new connection [");
            n2.append(gVar.f5045b);
            n2.append("]");
            log.debug(n2.toString());
        }
        b bVar = new b(fVar, gVar.f5045b, this.k, this.l);
        this.f5042d.lock();
        try {
            gVar.b(bVar);
            this.o++;
            this.g.add(bVar);
            return bVar;
        } finally {
            this.f5042d.unlock();
        }
    }

    public void c(b bVar) {
        a aVar = bVar.f5012c;
        if (this.f5041c.isDebugEnabled()) {
            this.f5041c.debug("Deleting connection [" + aVar + "][" + bVar.f5013d + "]");
        }
        this.f5042d.lock();
        try {
            a(bVar);
            boolean z = true;
            g g2 = g(aVar, true);
            if (g2.f5048e.remove(bVar)) {
                g2.g--;
            }
            this.o--;
            if (g2.g >= 1 || !g2.f.isEmpty()) {
                z = false;
            }
            if (z) {
                this.j.remove(aVar);
            }
        } finally {
            this.f5042d.unlock();
        }
    }

    public void d() {
        this.f5042d.lock();
        try {
            b remove = this.h.remove();
            if (remove != null) {
                c(remove);
            } else if (this.f5041c.isDebugEnabled()) {
                this.f5041c.debug("No free connection to delete");
            }
        } finally {
            this.f5042d.unlock();
        }
    }

    public void e(b bVar, boolean z, long j2, TimeUnit timeUnit) {
        String str;
        a aVar = bVar.f5012c;
        if (this.f5041c.isDebugEnabled()) {
            this.f5041c.debug("Releasing connection [" + aVar + "][" + bVar.f5013d + "]");
        }
        this.f5042d.lock();
        try {
            if (this.m) {
                a(bVar);
            } else {
                this.g.remove(bVar);
                g g2 = g(aVar, true);
                if (z) {
                    if (this.f5041c.isDebugEnabled()) {
                        if (j2 > 0) {
                            str = "for " + j2 + " " + timeUnit;
                        } else {
                            str = "indefinitely";
                        }
                        this.f5041c.debug("Pooling connection [" + aVar + "][" + bVar.f5013d + "]; keep alive " + str);
                    }
                    g2.c(bVar);
                    long currentTimeMillis = System.currentTimeMillis();
                    bVar.g = currentTimeMillis;
                    bVar.i = Math.min(bVar.h, j2 > 0 ? timeUnit.toMillis(j2) + currentTimeMillis : RecyclerView.FOREVER_NS);
                    this.h.add(bVar);
                } else {
                    int i2 = g2.g;
                    if (i2 >= 1) {
                        g2.g = i2 - 1;
                        this.o--;
                    } else {
                        throw new IllegalStateException("There is no entry that could be dropped.");
                    }
                }
                h(g2);
            }
        } finally {
            this.f5042d.unlock();
        }
    }

    public b f(g gVar, Object obj) {
        this.f5042d.lock();
        b bVar = null;
        boolean z = false;
        while (!z) {
            try {
                bVar = gVar.a(obj);
                if (bVar != null) {
                    if (this.f5041c.isDebugEnabled()) {
                        this.f5041c.debug("Getting free connection [" + gVar.f5045b + "][" + obj + "]");
                    }
                    this.h.remove(bVar);
                    if (System.currentTimeMillis() >= bVar.i) {
                        if (this.f5041c.isDebugEnabled()) {
                            this.f5041c.debug("Closing expired free connection [" + gVar.f5045b + "][" + obj + "]");
                        }
                        a(bVar);
                        int i2 = gVar.g;
                        if (i2 >= 1) {
                            gVar.g = i2 - 1;
                            this.o--;
                        } else {
                            throw new IllegalStateException("There is no entry that could be dropped.");
                        }
                    } else {
                        this.g.add(bVar);
                    }
                } else if (this.f5041c.isDebugEnabled()) {
                    this.f5041c.debug("No free connections [" + gVar.f5045b + "][" + obj + "]");
                }
                z = true;
            } catch (Throwable th) {
                this.f5042d.unlock();
                throw th;
            }
        }
        this.f5042d.unlock();
        return bVar;
    }

    public g g(a aVar, boolean z) {
        this.f5042d.lock();
        try {
            g gVar = this.j.get(aVar);
            if (gVar == null && z) {
                gVar = new g(aVar, this.f);
                this.j.put(aVar, gVar);
            }
            return gVar;
        } finally {
            this.f5042d.unlock();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0071 A[Catch:{ all -> 0x0089 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h(e.a.a.g0.h.o.g r4) {
        /*
            r3 = this;
            java.util.concurrent.locks.Lock r0 = r3.f5042d
            r0.lock()
            if (r4 == 0) goto L_0x003f
            java.util.Queue<e.a.a.g0.h.o.i> r0 = r4.f     // Catch:{ all -> 0x0089 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0089 }
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x003f
            org.apache.commons.logging.Log r0 = r3.f5041c     // Catch:{ all -> 0x0089 }
            boolean r0 = r0.isDebugEnabled()     // Catch:{ all -> 0x0089 }
            if (r0 == 0) goto L_0x0036
            org.apache.commons.logging.Log r0 = r3.f5041c     // Catch:{ all -> 0x0089 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0089 }
            r1.<init>()     // Catch:{ all -> 0x0089 }
            java.lang.String r2 = "Notifying thread waiting on pool ["
            r1.append(r2)     // Catch:{ all -> 0x0089 }
            e.a.a.d0.l.a r2 = r4.f5045b     // Catch:{ all -> 0x0089 }
            r1.append(r2)     // Catch:{ all -> 0x0089 }
            java.lang.String r2 = "]"
            r1.append(r2)     // Catch:{ all -> 0x0089 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0089 }
            r0.debug(r1)     // Catch:{ all -> 0x0089 }
        L_0x0036:
            java.util.Queue<e.a.a.g0.h.o.i> r4 = r4.f     // Catch:{ all -> 0x0089 }
            java.lang.Object r4 = r4.peek()     // Catch:{ all -> 0x0089 }
            e.a.a.g0.h.o.i r4 = (e.a.a.g0.h.o.i) r4     // Catch:{ all -> 0x0089 }
            goto L_0x006f
        L_0x003f:
            java.util.Queue<e.a.a.g0.h.o.i> r4 = r3.i     // Catch:{ all -> 0x0089 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0089 }
            if (r4 != 0) goto L_0x005f
            org.apache.commons.logging.Log r4 = r3.f5041c     // Catch:{ all -> 0x0089 }
            boolean r4 = r4.isDebugEnabled()     // Catch:{ all -> 0x0089 }
            if (r4 == 0) goto L_0x0056
            org.apache.commons.logging.Log r4 = r3.f5041c     // Catch:{ all -> 0x0089 }
            java.lang.String r0 = "Notifying thread waiting on any pool"
            r4.debug(r0)     // Catch:{ all -> 0x0089 }
        L_0x0056:
            java.util.Queue<e.a.a.g0.h.o.i> r4 = r3.i     // Catch:{ all -> 0x0089 }
            java.lang.Object r4 = r4.remove()     // Catch:{ all -> 0x0089 }
            e.a.a.g0.h.o.i r4 = (e.a.a.g0.h.o.i) r4     // Catch:{ all -> 0x0089 }
            goto L_0x006f
        L_0x005f:
            org.apache.commons.logging.Log r4 = r3.f5041c     // Catch:{ all -> 0x0089 }
            boolean r4 = r4.isDebugEnabled()     // Catch:{ all -> 0x0089 }
            if (r4 == 0) goto L_0x006e
            org.apache.commons.logging.Log r4 = r3.f5041c     // Catch:{ all -> 0x0089 }
            java.lang.String r0 = "Notifying no-one, there are no waiting threads"
            r4.debug(r0)     // Catch:{ all -> 0x0089 }
        L_0x006e:
            r4 = 0
        L_0x006f:
            if (r4 == 0) goto L_0x0083
            java.lang.Thread r0 = r4.f5057b     // Catch:{ all -> 0x0089 }
            if (r0 == 0) goto L_0x007b
            java.util.concurrent.locks.Condition r4 = r4.f5056a     // Catch:{ all -> 0x0089 }
            r4.signalAll()     // Catch:{ all -> 0x0089 }
            goto L_0x0083
        L_0x007b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0089 }
            java.lang.String r0 = "Nobody waiting on this object."
            r4.<init>(r0)     // Catch:{ all -> 0x0089 }
            throw r4     // Catch:{ all -> 0x0089 }
        L_0x0083:
            java.util.concurrent.locks.Lock r4 = r3.f5042d
            r4.unlock()
            return
        L_0x0089:
            r4 = move-exception
            java.util.concurrent.locks.Lock r0 = r3.f5042d
            r0.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.g0.h.o.e.h(e.a.a.g0.h.o.g):void");
    }
}
