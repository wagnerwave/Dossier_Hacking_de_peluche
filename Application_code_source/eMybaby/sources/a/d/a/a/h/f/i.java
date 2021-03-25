package a.d.a.a.h.f;

import java.lang.Thread;

public final class i implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f1509a;

    public i(h hVar) {
        this.f1509a = hVar;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        r0 r0Var = this.f1509a.f1507e;
        if (r0Var != null) {
            r0Var.n("Job execution failed", th);
        }
    }
}
