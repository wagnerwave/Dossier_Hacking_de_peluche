package a.i.a;

import a.i.a.g0;
import a.i.a.t;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class v extends ThreadPoolExecutor {

    public static final class a extends FutureTask<c> implements Comparable<a> {

        /* renamed from: a  reason: collision with root package name */
        public final c f3676a;

        public a(c cVar) {
            super(cVar, (Object) null);
            this.f3676a = cVar;
        }

        public int compareTo(Object obj) {
            c cVar = this.f3676a;
            t.e eVar = cVar.s;
            c cVar2 = ((a) obj).f3676a;
            t.e eVar2 = cVar2.s;
            return eVar == eVar2 ? cVar.f3590a - cVar2.f3590a : eVar2.ordinal() - eVar.ordinal();
        }
    }

    public v() {
        super(3, 3, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new g0.c());
    }

    public Future<?> submit(Runnable runnable) {
        a aVar = new a((c) runnable);
        execute(aVar);
        return aVar;
    }
}
