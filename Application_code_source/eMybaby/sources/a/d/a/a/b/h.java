package a.d.a.a.b;

import a.d.a.a.b.f;
import android.util.Log;
import java.lang.Thread;
import java.util.concurrent.FutureTask;

public final class h extends FutureTask<T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f.a f1188a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(f.a aVar, Runnable runnable, Object obj) {
        super(runnable, obj);
        this.f1188a = aVar;
    }

    public final void setException(Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = f.this.f1185d;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        } else if (Log.isLoggable("GAv4", 6)) {
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(valueOf.length() + 37);
            sb.append("MeasurementExecutor: job failed with ");
            sb.append(valueOf);
            Log.e("GAv4", sb.toString());
        }
        super.setException(th);
    }
}
