package a.d.a.a.c.a.d.c;

import android.content.Context;
import androidx.annotation.Nullable;

public final class l {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public static l f1220b;

    /* renamed from: a  reason: collision with root package name */
    public a f1221a;

    public l(Context context) {
        a a2 = a.a(context);
        this.f1221a = a2;
        a2.b();
        this.f1221a.c();
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
    public static synchronized a.d.a.a.c.a.d.c.l b(@androidx.annotation.NonNull android.content.Context r2) {
        /*
            java.lang.Class<a.d.a.a.c.a.d.c.l> r0 = a.d.a.a.c.a.d.c.l.class
            monitor-enter(r0)
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x001e }
            monitor-enter(r0)     // Catch:{ all -> 0x001e }
            a.d.a.a.c.a.d.c.l r1 = f1220b     // Catch:{ all -> 0x001b }
            if (r1 == 0) goto L_0x0010
            a.d.a.a.c.a.d.c.l r2 = f1220b     // Catch:{ all -> 0x001b }
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            goto L_0x0019
        L_0x0010:
            a.d.a.a.c.a.d.c.l r1 = new a.d.a.a.c.a.d.c.l     // Catch:{ all -> 0x001b }
            r1.<init>(r2)     // Catch:{ all -> 0x001b }
            f1220b = r1     // Catch:{ all -> 0x001b }
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            r2 = r1
        L_0x0019:
            monitor-exit(r0)
            return r2
        L_0x001b:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            throw r2     // Catch:{ all -> 0x001e }
        L_0x001e:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.c.a.d.c.l.b(android.content.Context):a.d.a.a.c.a.d.c.l");
    }

    public final synchronized void a() {
        a aVar = this.f1221a;
        aVar.f1210a.lock();
        try {
            aVar.f1211b.edit().clear().apply();
        } finally {
            aVar.f1210a.unlock();
        }
    }
}
