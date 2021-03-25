package e.c.a;

import android.os.Looper;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

public class c {
    public static volatile c n;
    public static final d o = new d();
    public static final Map<Class<?>, List<Class<?>>> p = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<?>, CopyOnWriteArrayList<l>> f5363a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final ThreadLocal<b> f5364b = new a(this);

    /* renamed from: c  reason: collision with root package name */
    public final f f5365c;

    /* renamed from: d  reason: collision with root package name */
    public final b f5366d;

    /* renamed from: e  reason: collision with root package name */
    public final a f5367e;
    public final ExecutorService f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final int m;

    public class a extends ThreadLocal<b> {
        public a(c cVar) {
        }

        public Object initialValue() {
            return new b();
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final List<Object> f5368a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public boolean f5369b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f5370c;

        /* renamed from: d  reason: collision with root package name */
        public Object f5371d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f5372e;
    }

    public c() {
        d dVar = o;
        new HashMap();
        new ConcurrentHashMap();
        this.f5365c = new f(this, Looper.getMainLooper(), 10);
        this.f5366d = new b(this);
        this.f5367e = new a(this);
        List<Object> list = dVar.h;
        this.m = list != null ? list.size() : 0;
        this.h = dVar.f5373a;
        this.i = dVar.f5374b;
        this.j = dVar.f5375c;
        this.k = dVar.f5376d;
        this.g = dVar.f5377e;
        this.l = dVar.f;
        this.f = dVar.g;
    }

    public static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    public void b(h hVar) {
        l lVar = hVar.f5385b;
        hVar.f5384a = null;
        hVar.f5385b = null;
        hVar.f5386c = null;
        synchronized (h.f5383d) {
            if (h.f5383d.size() < 10000) {
                h.f5383d.add(hVar);
            }
        }
        if (lVar.f5390b) {
            throw null;
        }
    }

    public void c(Object obj) {
        b bVar = this.f5364b.get();
        List<Object> list = bVar.f5368a;
        list.add(obj);
        if (!bVar.f5369b) {
            bVar.f5370c = Looper.getMainLooper() == Looper.myLooper();
            bVar.f5369b = true;
            if (!bVar.f5372e) {
                while (!list.isEmpty()) {
                    try {
                        d(list.remove(0), bVar);
                    } finally {
                        bVar.f5369b = false;
                        bVar.f5370c = false;
                    }
                }
                return;
            }
            throw new e("Internal error. Abort state was not reset");
        }
    }

    public final void d(Object obj, b bVar) {
        boolean z;
        ArrayList arrayList;
        Class<?> cls = obj.getClass();
        if (this.l) {
            synchronized (p) {
                List list = p.get(cls);
                arrayList = list;
                if (list == null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                        arrayList2.add(cls2);
                        a(arrayList2, cls2.getInterfaces());
                    }
                    p.put(cls, arrayList2);
                    arrayList = arrayList2;
                }
            }
            int size = arrayList.size();
            z = false;
            for (int i2 = 0; i2 < size; i2++) {
                z |= e(obj, bVar, (Class) arrayList.get(i2));
            }
        } else {
            z = e(obj, bVar, cls);
        }
        if (!z) {
            if (this.i) {
                Log.d("EventBus", "No subscribers registered for event " + cls);
            }
            if (this.k && cls != g.class && cls != j.class) {
                c(new g(this, obj));
            }
        }
    }

    public final boolean e(Object obj, b bVar, Class<?> cls) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.f5363a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        if (!it.hasNext()) {
            return true;
        }
        l lVar = (l) it.next();
        bVar.f5371d = obj;
        try {
            throw null;
        } catch (Throwable th) {
            bVar.f5372e = false;
            throw th;
        }
    }

    public String toString() {
        StringBuilder n2 = a.a.a.a.a.n("EventBus[indexCount=");
        n2.append(this.m);
        n2.append(", eventInheritance=");
        n2.append(this.l);
        n2.append("]");
        return n2.toString();
    }
}
