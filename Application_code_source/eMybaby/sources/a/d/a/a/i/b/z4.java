package a.d.a.a.i.b;

import a.c.a.f.b;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public final class z4<V> extends FutureTask<V> implements Comparable<z4<V>> {

    /* renamed from: a  reason: collision with root package name */
    public final long f2658a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f2659b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2660c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ v4 f2661d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z4(v4 v4Var, Runnable runnable, boolean z, String str) {
        super(runnable, (Object) null);
        this.f2661d = v4Var;
        b.k(str);
        long andIncrement = v4.l.getAndIncrement();
        this.f2658a = andIncrement;
        this.f2660c = str;
        this.f2659b = z;
        if (andIncrement == RecyclerView.FOREVER_NS) {
            v4Var.i().f.a("Tasks index overflow");
        }
    }

    public final int compareTo(@NonNull Object obj) {
        z4 z4Var = (z4) obj;
        boolean z = this.f2659b;
        if (z != z4Var.f2659b) {
            return z ? -1 : 1;
        }
        long j = this.f2658a;
        long j2 = z4Var.f2658a;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        this.f2661d.i().g.b("Two tasks share the same index. index", Long.valueOf(this.f2658a));
        return 0;
    }

    public final void setException(Throwable th) {
        this.f2661d.i().f.b(this.f2660c, th);
        super.setException(th);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z4(v4 v4Var, Callable<V> callable, boolean z, String str) {
        super(callable);
        this.f2661d = v4Var;
        b.k(str);
        long andIncrement = v4.l.getAndIncrement();
        this.f2658a = andIncrement;
        this.f2660c = str;
        this.f2659b = z;
        if (andIncrement == RecyclerView.FOREVER_NS) {
            v4Var.i().f.a("Tasks index overflow");
        }
    }
}
