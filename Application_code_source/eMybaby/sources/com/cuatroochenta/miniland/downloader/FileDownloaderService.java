package com.cuatroochenta.miniland.downloader;

import a.c.a.c.c;
import a.c.a.c.e;
import a.c.a.c.h;
import a.c.d.f.a;
import a.c.d.r.j;
import android.app.IntentService;
import com.cuatroochenta.miniland.model.HeartBeatSound;
import java.util.ArrayList;
import java.util.Iterator;

public class FileDownloaderService extends IntentService implements h {

    /* renamed from: a  reason: collision with root package name */
    public int f3809a;

    /* renamed from: b  reason: collision with root package name */
    public e f3810b = new e(this);

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<c> f3811c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public HeartBeatSound f3812d;

    public FileDownloaderService() {
        super("FileDownloaderService");
    }

    public void a(String str) {
        a.c.a.f.e.b("downloadError: " + str);
        b(false);
    }

    public final void b(boolean z) {
        j b2 = j.b();
        int i = this.f3809a;
        Iterator<a> it = b2.f800a.iterator();
        while (it.hasNext()) {
            it.next().d(i, z);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0055, code lost:
        r7 = r6.getUrlFile();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c() {
        /*
            r11 = this;
            com.sozpic.miniland.AppMiniland r0 = com.sozpic.miniland.AppMiniland.f()
            a.g.a.b.d r0 = r0.k
            int r1 = r11.f3809a
            java.lang.String r2 = "_downloadtmp"
            r3 = 0
            if (r1 != 0) goto L_0x0123
            java.util.ArrayList<a.c.a.c.c> r1 = r11.f3811c
            r1.clear()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            a.c.d.r.a r4 = a.c.d.r.a.f781d
            java.util.Collection r4 = r4.b()
            java.util.Iterator r4 = r4.iterator()
        L_0x0021:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00d5
            java.lang.Object r5 = r4.next()
            com.cuatroochenta.miniland.model.SongCategory r5 = (com.cuatroochenta.miniland.model.SongCategory) r5
            java.util.ArrayList r5 = r5.getSongList()
            java.util.Iterator r5 = r5.iterator()
        L_0x0035:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0021
            java.lang.Object r6 = r5.next()
            com.cuatroochenta.miniland.model.Song r6 = (com.cuatroochenta.miniland.model.Song) r6
            java.lang.String r7 = r6.getUrlFile()
            boolean r7 = a.c.a.d.a.j(r7)
            if (r7 != 0) goto L_0x008a
            java.lang.String r7 = r6.getUrlFile()
            boolean r7 = r1.contains(r7)
            if (r7 != 0) goto L_0x008a
            java.lang.String r7 = r6.getUrlFile()
            a.g.a.a.a.a r8 = r0.c()
            java.io.File r8 = r8.a(r7)
            if (r8 == 0) goto L_0x0069
            boolean r8 = r8.exists()
            if (r8 != 0) goto L_0x008a
        L_0x0069:
            a.c.c.b r8 = a.c.c.b.c()
            java.io.File r8 = r8.b(r7)
            a.c.c.b r9 = a.c.c.b.c()
            java.lang.String r10 = r7.concat(r2)
            java.io.File r9 = r9.b(r10)
            a.c.a.c.c r10 = new a.c.a.c.c
            r10.<init>(r7, r8, r9)
            java.util.ArrayList<a.c.a.c.c> r8 = r11.f3811c
            r8.add(r10)
            r1.add(r7)
        L_0x008a:
            java.lang.String r7 = r6.getUrlImage()
            boolean r7 = a.c.a.d.a.j(r7)
            if (r7 != 0) goto L_0x0035
            java.lang.String r7 = r6.getUrlImage()
            boolean r7 = r1.contains(r7)
            if (r7 != 0) goto L_0x0035
            java.lang.String r6 = r6.getUrlImage()
            a.g.a.a.a.a r7 = r0.c()
            java.io.File r7 = r7.a(r6)
            if (r7 == 0) goto L_0x00b2
            boolean r7 = r7.exists()
            if (r7 != 0) goto L_0x0035
        L_0x00b2:
            a.c.c.b r7 = a.c.c.b.c()
            java.io.File r7 = r7.b(r6)
            a.c.c.b r8 = a.c.c.b.c()
            java.lang.String r9 = r6.concat(r2)
            java.io.File r8 = r8.b(r9)
            a.c.a.c.c r9 = new a.c.a.c.c
            r9.<init>(r6, r7, r8)
            java.util.ArrayList<a.c.a.c.c> r7 = r11.f3811c
            r7.add(r9)
            r1.add(r6)
            goto L_0x0035
        L_0x00d5:
            a.c.d.r.a r4 = a.c.d.r.a.f781d
            java.util.HashMap<java.lang.String, java.util.ArrayList<java.lang.String>> r4 = r4.f784c
            java.lang.String r5 = "HELP_BUDDY"
            java.lang.Object r4 = r4.get(r5)
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x00e5:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0157
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            a.g.a.a.a.a r6 = r0.c()
            java.io.File r6 = r6.a(r5)
            if (r6 == 0) goto L_0x0101
            boolean r6 = r6.exists()
            if (r6 != 0) goto L_0x00e5
        L_0x0101:
            a.c.c.b r6 = a.c.c.b.c()
            java.io.File r6 = r6.b(r5)
            a.c.c.b r7 = a.c.c.b.c()
            java.lang.String r8 = r5.concat(r2)
            java.io.File r7 = r7.b(r8)
            a.c.a.c.c r8 = new a.c.a.c.c
            r8.<init>(r5, r6, r7)
            java.util.ArrayList<a.c.a.c.c> r6 = r11.f3811c
            r6.add(r8)
            r1.add(r5)
            goto L_0x00e5
        L_0x0123:
            r0 = 2
            if (r1 != r0) goto L_0x0154
            java.util.ArrayList<a.c.a.c.c> r0 = r11.f3811c
            r0.clear()
            com.cuatroochenta.miniland.model.HeartBeatSound r0 = r11.f3812d
            java.io.File r0 = r0.getLocalFile()
            a.c.c.b r1 = a.c.c.b.c()
            com.cuatroochenta.miniland.model.HeartBeatSound r4 = r11.f3812d
            java.lang.String r4 = r4.getUrlFile()
            java.lang.String r2 = r4.concat(r2)
            java.io.File r1 = r1.b(r2)
            a.c.a.c.c r2 = new a.c.a.c.c
            com.cuatroochenta.miniland.model.HeartBeatSound r4 = r11.f3812d
            java.lang.String r4 = r4.getUrlFile()
            r2.<init>(r4, r0, r1)
            java.util.ArrayList<a.c.a.c.c> r0 = r11.f3811c
            r0.add(r2)
            goto L_0x0157
        L_0x0154:
            r11.b(r3)
        L_0x0157:
            java.util.ArrayList<a.c.a.c.c> r0 = r11.f3811c
            boolean r0 = r0.isEmpty()
            r1 = 1
            if (r0 != 0) goto L_0x01d6
            boolean r0 = a.c.a.d.a.k(r11)
            if (r0 == 0) goto L_0x01d2
            a.c.a.c.e r0 = r11.f3810b
            java.util.ArrayList<a.c.a.c.c> r2 = r11.f3811c
            r4 = 0
            if (r0 == 0) goto L_0x01d1
            java.util.Iterator r2 = r2.iterator()
        L_0x0171:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x0186
            java.lang.Object r5 = r2.next()
            a.c.a.c.c r5 = (a.c.a.c.c) r5
            if (r5 == 0) goto L_0x0185
            java.util.ArrayList<a.c.a.c.c> r6 = r0.f15b
            r6.add(r5)
            goto L_0x0171
        L_0x0185:
            throw r4
        L_0x0186:
            monitor-enter(r0)
            java.util.ArrayList<a.c.a.c.c> r2 = r0.f15b     // Catch:{ all -> 0x01ce }
            int r2 = r2.size()     // Catch:{ all -> 0x01ce }
            if (r2 != 0) goto L_0x019f
            a.c.a.c.h r2 = r0.f14a     // Catch:{ all -> 0x01ce }
            com.cuatroochenta.miniland.downloader.FileDownloaderService r2 = (com.cuatroochenta.miniland.downloader.FileDownloaderService) r2     // Catch:{ all -> 0x01ce }
            if (r2 == 0) goto L_0x019e
            java.lang.String r3 = "downloadFinished"
            a.c.a.f.e.b(r3)     // Catch:{ all -> 0x01ce }
            r2.b(r1)     // Catch:{ all -> 0x01ce }
            goto L_0x01cc
        L_0x019e:
            throw r4     // Catch:{ all -> 0x01ce }
        L_0x019f:
            java.util.ArrayList<a.c.a.c.c> r1 = r0.f16c     // Catch:{ all -> 0x01ce }
            r1.clear()     // Catch:{ all -> 0x01ce }
            java.util.ArrayList<a.c.a.c.c> r1 = r0.f17d     // Catch:{ all -> 0x01ce }
            r1.clear()     // Catch:{ all -> 0x01ce }
            java.util.HashMap<a.c.a.c.c, java.lang.Integer> r1 = r0.h     // Catch:{ all -> 0x01ce }
            r1.clear()     // Catch:{ all -> 0x01ce }
            r0.i = r3     // Catch:{ all -> 0x01ce }
            r1 = 5
            java.util.concurrent.ExecutorService r1 = java.util.concurrent.Executors.newFixedThreadPool(r1)     // Catch:{ all -> 0x01ce }
            r0.f18e = r1     // Catch:{ all -> 0x01ce }
            a.c.a.c.f r1 = new a.c.a.c.f     // Catch:{ all -> 0x01ce }
            java.util.ArrayList<a.c.a.c.c> r2 = r0.f15b     // Catch:{ all -> 0x01ce }
            r1.<init>(r2)     // Catch:{ all -> 0x01ce }
            java.util.concurrent.ExecutorService r2 = r0.f18e     // Catch:{ all -> 0x01ce }
            java.util.concurrent.Future r1 = r2.submit(r1)     // Catch:{ all -> 0x01ce }
            a.c.a.c.d r2 = new a.c.a.c.d     // Catch:{ all -> 0x01ce }
            r2.<init>(r0, r1)     // Catch:{ all -> 0x01ce }
            r2.start()     // Catch:{ all -> 0x01ce }
        L_0x01cc:
            monitor-exit(r0)     // Catch:{ all -> 0x01ce }
            goto L_0x01d9
        L_0x01ce:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x01ce }
            throw r1
        L_0x01d1:
            throw r4
        L_0x01d2:
            r11.b(r3)
            goto L_0x01d9
        L_0x01d6:
            r11.b(r1)
        L_0x01d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cuatroochenta.miniland.downloader.FileDownloaderService.c():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        if (a.c.a.d.a.j(r4.getUrlFile()) == false) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onHandleIntent(android.content.Intent r4) {
        /*
            r3 = this;
            java.lang.String r0 = "KEY_INTENT_DOWNLOADER_MODE"
            r1 = -1
            int r0 = r4.getIntExtra(r0, r1)
            r3.f3809a = r0
            if (r0 == 0) goto L_0x003b
            r1 = 1
            if (r0 == r1) goto L_0x002d
            r1 = 2
            r2 = 0
            if (r0 == r1) goto L_0x0016
        L_0x0012:
            r3.b(r2)
            goto L_0x003e
        L_0x0016:
            java.lang.String r0 = "KEY_INTENT_HEART_BEAT_SOUND"
            android.os.Parcelable r4 = r4.getParcelableExtra(r0)
            com.cuatroochenta.miniland.model.HeartBeatSound r4 = (com.cuatroochenta.miniland.model.HeartBeatSound) r4
            r3.f3812d = r4
            if (r4 == 0) goto L_0x0012
            java.lang.String r4 = r4.getUrlFile()
            boolean r4 = a.c.a.d.a.j(r4)
            if (r4 != 0) goto L_0x0012
            goto L_0x003b
        L_0x002d:
            a.c.a.c.e r4 = r3.f3810b
            if (r4 == 0) goto L_0x003e
            r4.i = r1
            java.util.concurrent.ExecutorService r4 = r4.f18e
            if (r4 == 0) goto L_0x003e
            r4.shutdownNow()
            goto L_0x003e
        L_0x003b:
            r3.c()
        L_0x003e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cuatroochenta.miniland.downloader.FileDownloaderService.onHandleIntent(android.content.Intent):void");
    }
}
