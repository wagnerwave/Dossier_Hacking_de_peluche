package a.d.a.a.h.g;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public final class n implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public ThreadFactory f1840a = Executors.defaultThreadFactory();

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f1840a.newThread(runnable);
        newThread.setName("ScionFrontendApi");
        return newThread;
    }
}
