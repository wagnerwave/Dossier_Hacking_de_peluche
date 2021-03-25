package a.c.a.c;

import a.c.a.f.e;
import com.cuatroochenta.miniland.downloader.FileDownloaderService;
import java.util.concurrent.Future;

public class d extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Future f12a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f13b;

    public d(e eVar, Future future) {
        this.f13b = eVar;
        this.f12a = future;
    }

    public void run() {
        try {
            this.f13b.f = (Long) this.f12a.get();
            e.a(this.f13b);
        } catch (Exception e2) {
            e.d(e2);
            ((FileDownloaderService) this.f13b.f14a).a(e2.getMessage());
        }
    }
}
