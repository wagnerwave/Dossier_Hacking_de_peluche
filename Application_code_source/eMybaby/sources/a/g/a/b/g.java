package a.g.a.b;

import java.util.concurrent.ExecutorService;

public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f3388a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f3389b;

    public g(h hVar, j jVar) {
        this.f3389b = hVar;
        this.f3388a = jVar;
    }

    public void run() {
        ExecutorService executorService;
        if (this.f3389b.f3390a.l.a(this.f3388a.h).exists()) {
            executorService = this.f3389b.f3392c;
        } else {
            executorService = this.f3389b.f3391b;
        }
        executorService.submit(this.f3388a);
    }
}
