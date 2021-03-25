package a.d.b.g;

import a.d.b.h.a;
import a.d.b.h.b;
import a.d.b.h.c;
import a.d.b.h.d;
import androidx.annotation.GuardedBy;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

public class u implements d, c {
    @GuardedBy("this")

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<?>, ConcurrentHashMap<b<Object>, Executor>> f2767a = new HashMap();
    @GuardedBy("this")

    /* renamed from: b  reason: collision with root package name */
    public Queue<a<?>> f2768b = new ArrayDeque();

    public u(Executor executor) {
    }

    public synchronized <T> void a(Class<T> cls, Executor executor, b<? super T> bVar) {
        if (!this.f2767a.containsKey(cls)) {
            this.f2767a.put(cls, new ConcurrentHashMap());
        }
        this.f2767a.get(cls).put(bVar, executor);
    }
}
