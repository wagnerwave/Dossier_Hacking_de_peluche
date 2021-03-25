package a.d.a.a.l;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

public final class k<TResult> implements m<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f2700a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f2701b = new Object();
    @GuardedBy("mLock")

    /* renamed from: c  reason: collision with root package name */
    public c<? super TResult> f2702c;

    public k(@NonNull Executor executor, @NonNull c<? super TResult> cVar) {
        this.f2700a = executor;
        this.f2702c = cVar;
    }

    public final void a(@NonNull p<TResult> pVar) {
        if (pVar.c()) {
            synchronized (this.f2701b) {
                if (this.f2702c != null) {
                    this.f2700a.execute(new l(this, pVar));
                }
            }
        }
    }
}
