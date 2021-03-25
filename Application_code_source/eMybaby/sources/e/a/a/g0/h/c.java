package e.a.a.g0.h;

import e.a.a.d0.b;
import e.a.a.d0.l.a;

public abstract class c extends a {
    public volatile b f;

    public c(b bVar, b bVar2) {
        super(bVar, bVar2.f5011b);
        this.f = bVar2;
    }

    public void close() {
        b o = o();
        if (o != null) {
            o.a();
        }
        e eVar = this.f5006b;
        if (eVar != null) {
            eVar.close();
        }
    }

    public a g() {
        b o = o();
        m(o);
        if (o.f5014e == null) {
            return null;
        }
        return o.f5014e.e();
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00eb A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k(e.a.a.d0.l.a r19, e.a.a.k0.c r20, e.a.a.j0.c r21) {
        /*
            r18 = this;
            r0 = r19
            r1 = r21
            e.a.a.g0.h.b r2 = r18.o()
            r3 = r18
            r3.m(r2)
            if (r0 == 0) goto L_0x015c
            if (r1 == 0) goto L_0x0154
            e.a.a.d0.l.d r4 = r2.f5014e
            if (r4 == 0) goto L_0x0024
            e.a.a.d0.l.d r4 = r2.f5014e
            boolean r4 = r4.f4877c
            if (r4 != 0) goto L_0x001c
            goto L_0x0024
        L_0x001c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Connection already open."
            r0.<init>(r1)
            throw r0
        L_0x0024:
            e.a.a.d0.l.d r4 = new e.a.a.d0.l.d
            r4.<init>(r0)
            r2.f5014e = r4
            e.a.a.j r4 = r19.d()
            e.a.a.g0.h.f r5 = r2.f5010a
            e.a.a.g0.h.e r6 = r2.f5011b
            if (r4 == 0) goto L_0x0037
            r7 = r4
            goto L_0x0039
        L_0x0037:
            e.a.a.j r7 = r0.f4864a
        L_0x0039:
            java.net.InetAddress r8 = r0.f4865b
            if (r5 == 0) goto L_0x0152
            if (r6 == 0) goto L_0x014a
            if (r7 == 0) goto L_0x0142
            boolean r0 = r6.i
            if (r0 != 0) goto L_0x013a
            e.a.a.d0.m.g r0 = r5.f5016b
            java.lang.String r10 = r7.f5173d
            e.a.a.d0.m.f r0 = r0.a(r10)
            e.a.a.d0.m.h r10 = r0.f4883b
            java.lang.String r11 = r7.f5170a
            java.net.InetAddress[] r11 = java.net.InetAddress.getAllByName(r11)
            int r12 = r7.f5172c
            if (r12 > 0) goto L_0x005b
            int r12 = r0.f4884c
        L_0x005b:
            r14 = 0
        L_0x005c:
            int r0 = r11.length
            r15 = 1
            if (r14 >= r0) goto L_0x00fb
            r0 = r11[r14]
            int r9 = r11.length
            int r9 = r9 - r15
            if (r14 != r9) goto L_0x0068
            r9 = 1
            goto L_0x0069
        L_0x0068:
            r9 = 0
        L_0x0069:
            java.net.Socket r15 = r10.e(r1)
            r6.m(r15, r7)
            e.a.a.g0.h.i r13 = new e.a.a.g0.h.i
            r13.<init>(r7, r0, r12)
            if (r8 == 0) goto L_0x007e
            java.net.InetSocketAddress r0 = new java.net.InetSocketAddress
            r3 = 0
            r0.<init>(r8, r3)
            goto L_0x007f
        L_0x007e:
            r0 = 0
        L_0x007f:
            org.apache.commons.logging.Log r3 = r5.f5015a
            boolean r3 = r3.isDebugEnabled()
            if (r3 == 0) goto L_0x00a2
            org.apache.commons.logging.Log r3 = r5.f5015a
            r16 = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r17 = r11
            java.lang.String r11 = "Connecting to "
            r8.append(r11)
            r8.append(r13)
            java.lang.String r8 = r8.toString()
            r3.debug(r8)
            goto L_0x00a6
        L_0x00a2:
            r16 = r8
            r17 = r11
        L_0x00a6:
            java.net.Socket r0 = r10.f(r15, r13, r0, r1)     // Catch:{ ConnectException -> 0x00c0, e -> 0x00bb }
            if (r15 == r0) goto L_0x00b0
            r6.m(r0, r7)     // Catch:{ ConnectException -> 0x00c0, e -> 0x00bb }
            r15 = r0
        L_0x00b0:
            r5.a(r15, r1)     // Catch:{ ConnectException -> 0x00c0, e -> 0x00bb }
            boolean r0 = r10.a(r15)     // Catch:{ ConnectException -> 0x00c0, e -> 0x00bb }
            r6.l(r0, r1)     // Catch:{ ConnectException -> 0x00c0, e -> 0x00bb }
            goto L_0x00fb
        L_0x00bb:
            r0 = move-exception
            if (r9 != 0) goto L_0x00bf
            goto L_0x00c3
        L_0x00bf:
            throw r0
        L_0x00c0:
            r0 = move-exception
            if (r9 != 0) goto L_0x00f5
        L_0x00c3:
            org.apache.commons.logging.Log r0 = r5.f5015a
            boolean r0 = r0.isDebugEnabled()
            if (r0 == 0) goto L_0x00eb
            org.apache.commons.logging.Log r0 = r5.f5015a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r8 = "Connect to "
            r3.append(r8)
            r3.append(r13)
            java.lang.String r8 = " timed out. "
            r3.append(r8)
            java.lang.String r8 = "Connection will be retried using another IP address"
            r3.append(r8)
            java.lang.String r3 = r3.toString()
            r0.debug(r3)
        L_0x00eb:
            int r14 = r14 + 1
            r3 = r18
            r8 = r16
            r11 = r17
            goto L_0x005c
        L_0x00f5:
            e.a.a.d0.i r1 = new e.a.a.d0.i
            r1.<init>(r7, r0)
            throw r1
        L_0x00fb:
            e.a.a.d0.l.d r0 = r2.f5014e
            if (r0 == 0) goto L_0x0132
            java.lang.String r1 = "Already connected."
            if (r4 != 0) goto L_0x0117
            e.a.a.g0.h.e r2 = r2.f5011b
            boolean r2 = r2.o
            boolean r3 = r0.f4877c
            if (r3 != 0) goto L_0x0111
            r3 = 1
            r0.f4877c = r3
            r0.g = r2
            goto L_0x012b
        L_0x0111:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>(r1)
            throw r0
        L_0x0117:
            r3 = 1
            e.a.a.g0.h.e r2 = r2.f5011b
            boolean r2 = r2.o
            boolean r5 = r0.f4877c
            if (r5 != 0) goto L_0x012c
            r0.f4877c = r3
            e.a.a.j[] r1 = new e.a.a.j[r3]
            r3 = 0
            r1[r3] = r4
            r0.f4878d = r1
            r0.g = r2
        L_0x012b:
            return
        L_0x012c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>(r1)
            throw r0
        L_0x0132:
            java.io.InterruptedIOException r0 = new java.io.InterruptedIOException
            java.lang.String r1 = "Request aborted"
            r0.<init>(r1)
            throw r0
        L_0x013a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Connection must not be open"
            r0.<init>(r1)
            throw r0
        L_0x0142:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Target host may not be null"
            r0.<init>(r1)
            throw r0
        L_0x014a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Connection may not be null"
            r0.<init>(r1)
            throw r0
        L_0x0152:
            r1 = 0
            throw r1
        L_0x0154:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Parameters must not be null."
            r0.<init>(r1)
            throw r0
        L_0x015c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Route must not be null."
            r0.<init>(r1)
            goto L_0x0165
        L_0x0164:
            throw r0
        L_0x0165:
            goto L_0x0164
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.g0.h.c.k(e.a.a.d0.l.a, e.a.a.k0.c, e.a.a.j0.c):void");
    }

    public void m(b bVar) {
        if (this.f5008d || bVar == null) {
            throw new d();
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public synchronized void n() {
        /*
            r2 = this;
            monitor-enter(r2)
            r0 = 0
            r2.f = r0     // Catch:{ all -> 0x0014 }
            monitor-enter(r2)     // Catch:{ all -> 0x0014 }
            r2.f5006b = r0     // Catch:{ all -> 0x0011 }
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r2.f5009e = r0     // Catch:{ all -> 0x0011 }
            monitor-exit(r2)     // Catch:{ all -> 0x0014 }
            monitor-exit(r2)
            return
        L_0x0011:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0014 }
            throw r0     // Catch:{ all -> 0x0014 }
        L_0x0014:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.g0.h.c.n():void");
    }

    public b o() {
        return this.f;
    }

    public void shutdown() {
        b o = o();
        if (o != null) {
            o.a();
        }
        e eVar = this.f5006b;
        if (eVar != null) {
            eVar.shutdown();
        }
    }
}
