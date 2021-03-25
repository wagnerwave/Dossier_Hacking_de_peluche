package a.d.c.q.a;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public final ScheduledExecutorService f2932a = Executors.newSingleThreadScheduledExecutor(new b((a) null));

    /* renamed from: b  reason: collision with root package name */
    public final Activity f2933b;

    /* renamed from: c  reason: collision with root package name */
    public ScheduledFuture<?> f2934c = null;

    /* renamed from: d  reason: collision with root package name */
    public final BroadcastReceiver f2935d = new c((a) null);

    public static final class b implements ThreadFactory {
        public b(a aVar) {
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            return thread;
        }
    }

    public final class c extends BroadcastReceiver {
        public c(a aVar) {
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction()) && intent.getIntExtra("plugged", -1) > 0) {
                h.this.a();
            }
        }
    }

    public h(Activity activity) {
        this.f2933b = activity;
        b();
    }

    public final void a() {
        ScheduledFuture<?> scheduledFuture = this.f2934c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.f2934c = null;
        }
    }

    public void b() {
        a();
        if (!this.f2932a.isShutdown()) {
            try {
                this.f2934c = this.f2932a.schedule(new g(this.f2933b), 300, TimeUnit.SECONDS);
            } catch (RejectedExecutionException unused) {
            }
        }
    }
}
