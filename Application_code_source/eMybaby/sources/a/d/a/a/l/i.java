package a.d.a.a.l;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

public final class i<TResult> implements m<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f2695a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f2696b = new Object();
    @GuardedBy("mLock")

    /* renamed from: c  reason: collision with root package name */
    public b f2697c;

    public i(@NonNull Executor executor, @NonNull b bVar) {
        this.f2695a = executor;
        this.f2697c = bVar;
    }

    public final void a(@NonNull p<TResult> pVar) {
        if (!pVar.c()) {
            synchronized (this.f2696b) {
                if (this.f2697c != null) {
                    this.f2695a.execute(new j(this, pVar));
                }
            }
        }
    }
}
