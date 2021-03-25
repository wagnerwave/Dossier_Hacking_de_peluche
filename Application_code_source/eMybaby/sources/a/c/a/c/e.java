package a.c.a.c;

import a.c.d.f.a;
import a.c.d.r.j;
import com.cuatroochenta.miniland.downloader.FileDownloaderService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;

public class e extends a {

    /* renamed from: a  reason: collision with root package name */
    public h f14a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<c> f15b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<c> f16c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<c> f17d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public ExecutorService f18e;
    public Long f;
    public HashMap<c, Long> g = new HashMap<>();
    public HashMap<c, Integer> h = new HashMap<>();
    public boolean i;

    public e(h hVar) {
        this.f14a = hVar;
    }

    public static void a(e eVar) {
        Iterator<c> it = eVar.f15b.iterator();
        while (it.hasNext()) {
            eVar.g.put(it.next(), 0L);
        }
        Iterator<c> it2 = eVar.f15b.iterator();
        while (it2.hasNext()) {
            c next = it2.next();
            try {
                eVar.f18e.submit(new b(next, eVar));
            } catch (Exception e2) {
                e2.printStackTrace();
                eVar.e(next, false);
            }
        }
    }

    public synchronized void b(c cVar, String str) {
        d(cVar);
    }

    public synchronized void c(c cVar, Long l, Long l2) {
        this.g.put(cVar, l);
        long j = 0;
        Iterator<c> it = this.f15b.iterator();
        while (it.hasNext()) {
            j += this.g.get(it.next()).longValue();
        }
        h hVar = this.f14a;
        long longValue = this.f.longValue();
        if (((FileDownloaderService) hVar) != null) {
            Iterator<a> it2 = j.b().f800a.iterator();
            while (it2.hasNext()) {
                it2.next().e(j, longValue);
            }
        } else {
            throw null;
        }
    }

    public final void d(c cVar) {
        synchronized (this) {
            this.f17d.add(cVar);
            e(cVar, false);
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
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
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
    public final synchronized void e(a.c.a.c.c r5, boolean r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            monitor-enter(r4)     // Catch:{ all -> 0x00a9 }
            java.util.ArrayList<a.c.a.c.c> r0 = r4.f15b     // Catch:{ all -> 0x00a6 }
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0009
            goto L_0x001e
        L_0x0009:
            java.util.ArrayList<a.c.a.c.c> r0 = r4.f16c     // Catch:{ all -> 0x00a6 }
            int r0 = r0.size()     // Catch:{ all -> 0x00a6 }
            java.util.ArrayList<a.c.a.c.c> r3 = r4.f17d     // Catch:{ all -> 0x00a6 }
            int r3 = r3.size()     // Catch:{ all -> 0x00a6 }
            int r3 = r3 + r0
            java.util.ArrayList<a.c.a.c.c> r0 = r4.f15b     // Catch:{ all -> 0x00a6 }
            int r0 = r0.size()     // Catch:{ all -> 0x00a6 }
            if (r3 != r0) goto L_0x0020
        L_0x001e:
            r0 = 1
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            r3 = 0
            if (r0 == 0) goto L_0x0055
            a.c.a.c.h r5 = r4.f14a     // Catch:{ all -> 0x00a6 }
            if (r5 == 0) goto L_0x00a3
            java.util.ArrayList<a.c.a.c.c> r5 = r4.f17d     // Catch:{ all -> 0x00a6 }
            int r5 = r5.size()     // Catch:{ all -> 0x00a6 }
            if (r5 != 0) goto L_0x0040
            a.c.a.c.h r5 = r4.f14a     // Catch:{ all -> 0x00a6 }
            com.cuatroochenta.miniland.downloader.FileDownloaderService r5 = (com.cuatroochenta.miniland.downloader.FileDownloaderService) r5     // Catch:{ all -> 0x00a6 }
            if (r5 == 0) goto L_0x003f
            java.lang.String r6 = "downloadFinished"
            a.c.a.f.e.b(r6)     // Catch:{ all -> 0x00a6 }
            r5.b(r1)     // Catch:{ all -> 0x00a6 }
            goto L_0x00a3
        L_0x003f:
            throw r3     // Catch:{ all -> 0x00a6 }
        L_0x0040:
            a.c.a.c.h r5 = r4.f14a     // Catch:{ all -> 0x00a6 }
            java.util.ArrayList<a.c.a.c.c> r6 = r4.f17d     // Catch:{ all -> 0x00a6 }
            r6.size()     // Catch:{ all -> 0x00a6 }
            com.cuatroochenta.miniland.downloader.FileDownloaderService r5 = (com.cuatroochenta.miniland.downloader.FileDownloaderService) r5     // Catch:{ all -> 0x00a6 }
            if (r5 == 0) goto L_0x0054
            java.lang.String r6 = "downloadFinishedWithErrors"
            a.c.a.f.e.b(r6)     // Catch:{ all -> 0x00a6 }
            r5.b(r2)     // Catch:{ all -> 0x00a6 }
            goto L_0x00a3
        L_0x0054:
            throw r3     // Catch:{ all -> 0x00a6 }
        L_0x0055:
            a.c.a.c.h r0 = r4.f14a     // Catch:{ all -> 0x00a6 }
            if (r0 == 0) goto L_0x00a3
            if (r6 == 0) goto L_0x0085
            a.c.a.c.h r6 = r4.f14a     // Catch:{ all -> 0x00a6 }
            com.cuatroochenta.miniland.downloader.FileDownloaderService r6 = (com.cuatroochenta.miniland.downloader.FileDownloaderService) r6     // Catch:{ all -> 0x00a6 }
            if (r6 == 0) goto L_0x0084
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a6 }
            r6.<init>()     // Catch:{ all -> 0x00a6 }
            java.lang.String r0 = "downloadItemSuccess: "
            r6.append(r0)     // Catch:{ all -> 0x00a6 }
            java.lang.String r5 = r5.f9a     // Catch:{ all -> 0x00a6 }
            r6.append(r5)     // Catch:{ all -> 0x00a6 }
            java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x00a6 }
            a.c.a.f.e.b(r5)     // Catch:{ all -> 0x00a6 }
            a.c.a.c.h r5 = r4.f14a     // Catch:{ all -> 0x00a6 }
            java.util.ArrayList<a.c.a.c.c> r6 = r4.f16c     // Catch:{ all -> 0x00a6 }
            r6.size()     // Catch:{ all -> 0x00a6 }
            com.cuatroochenta.miniland.downloader.FileDownloaderService r5 = (com.cuatroochenta.miniland.downloader.FileDownloaderService) r5     // Catch:{ all -> 0x00a6 }
            if (r5 == 0) goto L_0x0083
            goto L_0x00a3
        L_0x0083:
            throw r3     // Catch:{ all -> 0x00a6 }
        L_0x0084:
            throw r3     // Catch:{ all -> 0x00a6 }
        L_0x0085:
            a.c.a.c.h r6 = r4.f14a     // Catch:{ all -> 0x00a6 }
            com.cuatroochenta.miniland.downloader.FileDownloaderService r6 = (com.cuatroochenta.miniland.downloader.FileDownloaderService) r6     // Catch:{ all -> 0x00a6 }
            if (r6 == 0) goto L_0x00a2
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a6 }
            r6.<init>()     // Catch:{ all -> 0x00a6 }
            java.lang.String r0 = "downloadItemError: "
            r6.append(r0)     // Catch:{ all -> 0x00a6 }
            java.lang.String r5 = r5.f9a     // Catch:{ all -> 0x00a6 }
            r6.append(r5)     // Catch:{ all -> 0x00a6 }
            java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x00a6 }
            a.c.a.f.e.b(r5)     // Catch:{ all -> 0x00a6 }
            goto L_0x00a3
        L_0x00a2:
            throw r3     // Catch:{ all -> 0x00a6 }
        L_0x00a3:
            monitor-exit(r4)     // Catch:{ all -> 0x00a6 }
            monitor-exit(r4)
            return
        L_0x00a6:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00a6 }
            throw r5     // Catch:{ all -> 0x00a9 }
        L_0x00a9:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: a.c.a.c.e.e(a.c.a.c.c, boolean):void");
    }
}
