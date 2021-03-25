package a.d.a.a.b;

import a.d.a.a.h.f.k1;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Process;
import java.lang.Thread;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressLint({"StaticFieldLeak"})
public final class f {

    /* renamed from: e  reason: collision with root package name */
    public static volatile f f1181e;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1182a;

    /* renamed from: b  reason: collision with root package name */
    public final a f1183b = new a();

    /* renamed from: c  reason: collision with root package name */
    public volatile k1 f1184c;

    /* renamed from: d  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f1185d;

    public class a extends ThreadPoolExecutor {
        public a() {
            super(1, 1, 1, TimeUnit.MINUTES, new LinkedBlockingQueue());
            setThreadFactory(new b((g) null));
            allowCoreThreadTimeOut(true);
        }

        public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
            return new h(this, runnable, t);
        }
    }

    public static class b implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public static final AtomicInteger f1187a = new AtomicInteger();

        public b(g gVar) {
        }

        public final Thread newThread(Runnable runnable) {
            int incrementAndGet = f1187a.incrementAndGet();
            StringBuilder sb = new StringBuilder(23);
            sb.append("measurement-");
            sb.append(incrementAndGet);
            return new c(runnable, sb.toString());
        }
    }

    public static class c extends Thread {
        public c(Runnable runnable, String str) {
            super(runnable, str);
        }

        public final void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    public f(Context context) {
        Context applicationContext = context.getApplicationContext();
        a.c.a.f.b.k(applicationContext);
        this.f1182a = applicationContext;
        new CopyOnWriteArrayList();
        new d();
    }

    public static void b() {
        if (!(Thread.currentThread() instanceof c)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final void a(Runnable runnable) {
        a.c.a.f.b.k(runnable);
        this.f1183b.submit(runnable);
    }
}
