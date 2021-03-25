package a.g.a.b;

import a.g.a.b.f;
import java.util.concurrent.ThreadFactory;

public class e implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f.a f3377a;

    public e(f fVar, f.a aVar) {
        this.f3377a = aVar;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setPriority(this.f3377a.i);
        return thread;
    }
}
