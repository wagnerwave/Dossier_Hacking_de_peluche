package a.d.a.a.i.b;

import androidx.annotation.GuardedBy;

public final class n3<V> {
    public static final Object h = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final String f2393a;

    /* renamed from: b  reason: collision with root package name */
    public final l3<V> f2394b;

    /* renamed from: c  reason: collision with root package name */
    public final V f2395c;

    /* renamed from: d  reason: collision with root package name */
    public final V f2396d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f2397e = new Object();
    @GuardedBy("overrideLock")
    public volatile V f = null;
    @GuardedBy("cachingLock")
    public volatile V g = null;

    public n3(String str, Object obj, Object obj2, l3 l3Var, m3 m3Var) {
        this.f2393a = str;
        this.f2395c = obj;
        this.f2396d = obj2;
        this.f2394b = l3Var;
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processHandlersOutBlocks(RegionMaker.java:1008)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:978)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0046 */
    public final V a(@androidx.annotation.Nullable V r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f2397e
            monitor-enter(r0)
            monitor-exit(r0)     // Catch:{ all -> 0x006e }
            if (r4 == 0) goto L_0x0007
            return r4
        L_0x0007:
            a.d.a.a.i.b.ja r4 = a.c.a.f.b.g
            if (r4 != 0) goto L_0x000e
            V r4 = r3.f2395c
            return r4
        L_0x000e:
            java.lang.Object r4 = h
            monitor-enter(r4)
            boolean r0 = a.d.a.a.i.b.ja.a()     // Catch:{ all -> 0x006b }
            if (r0 == 0) goto L_0x0022
            V r0 = r3.g     // Catch:{ all -> 0x006b }
            if (r0 != 0) goto L_0x001e
            V r0 = r3.f2395c     // Catch:{ all -> 0x006b }
            goto L_0x0020
        L_0x001e:
            V r0 = r3.g     // Catch:{ all -> 0x006b }
        L_0x0020:
            monitor-exit(r4)     // Catch:{ all -> 0x006b }
            return r0
        L_0x0022:
            monitor-exit(r4)     // Catch:{ all -> 0x006b }
            java.util.List<a.d.a.a.i.b.n3<?>> r4 = a.d.a.a.i.b.q.f2466a     // Catch:{ SecurityException -> 0x0058 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ SecurityException -> 0x0058 }
        L_0x0029:
            boolean r0 = r4.hasNext()     // Catch:{ SecurityException -> 0x0058 }
            if (r0 == 0) goto L_0x0059
            java.lang.Object r0 = r4.next()     // Catch:{ SecurityException -> 0x0058 }
            a.d.a.a.i.b.n3 r0 = (a.d.a.a.i.b.n3) r0     // Catch:{ SecurityException -> 0x0058 }
            boolean r1 = a.d.a.a.i.b.ja.a()     // Catch:{ SecurityException -> 0x0058 }
            if (r1 != 0) goto L_0x0050
            r1 = 0
            a.d.a.a.i.b.l3<V> r2 = r0.f2394b     // Catch:{ IllegalStateException -> 0x0046 }
            if (r2 == 0) goto L_0x0046
            a.d.a.a.i.b.l3<V> r2 = r0.f2394b     // Catch:{ IllegalStateException -> 0x0046 }
            java.lang.Object r1 = r2.a()     // Catch:{ IllegalStateException -> 0x0046 }
        L_0x0046:
            java.lang.Object r2 = h     // Catch:{ SecurityException -> 0x0058 }
            monitor-enter(r2)     // Catch:{ SecurityException -> 0x0058 }
            r0.g = r1     // Catch:{ all -> 0x004d }
            monitor-exit(r2)     // Catch:{ all -> 0x004d }
            goto L_0x0029
        L_0x004d:
            r4 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x004d }
            throw r4     // Catch:{ SecurityException -> 0x0058 }
        L_0x0050:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ SecurityException -> 0x0058 }
            java.lang.String r0 = "Refreshing flag cache must be done on a worker thread."
            r4.<init>(r0)     // Catch:{ SecurityException -> 0x0058 }
            throw r4     // Catch:{ SecurityException -> 0x0058 }
        L_0x0058:
        L_0x0059:
            a.d.a.a.i.b.l3<V> r4 = r3.f2394b
            if (r4 != 0) goto L_0x0060
            V r4 = r3.f2395c
            return r4
        L_0x0060:
            java.lang.Object r4 = r4.a()     // Catch:{ SecurityException -> 0x0068, IllegalStateException -> 0x0065 }
            return r4
        L_0x0065:
            V r4 = r3.f2395c
            return r4
        L_0x0068:
            V r4 = r3.f2395c
            return r4
        L_0x006b:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x006b }
            throw r0
        L_0x006e:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006e }
            goto L_0x0072
        L_0x0071:
            throw r4
        L_0x0072:
            goto L_0x0071
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.n3.a(java.lang.Object):java.lang.Object");
    }
}
