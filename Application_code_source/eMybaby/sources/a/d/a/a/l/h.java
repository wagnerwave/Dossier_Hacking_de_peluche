package a.d.a.a.l;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

public final class h<TResult> implements m<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f2692a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f2693b = new Object();
    @GuardedBy("mLock")

    /* renamed from: c  reason: collision with root package name */
    public a f2694c;

    public h(@NonNull Executor executor, @NonNull a aVar) {
        this.f2692a = executor;
        this.f2694c = aVar;
    }

    public final void a(@NonNull p pVar) {
        if (pVar == null) {
            throw null;
        }
    }
}
