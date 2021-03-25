package com.tuya.smart.common;

import a.a.a.a.a;
import android.os.Looper;
import android.util.Log;
import com.tuya.sdk.eventbus.EventBusException;
import com.tuya.sdk.eventbus.ThreadMode;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

public class oOOO00o0 {
    public static String O000000o = "Event";
    public static volatile oOOO00o0 O00000Oo;
    public static final Map<Class<?>, List<Class<?>>> O00000o = new HashMap();
    public static final oOOO0oOO O00000o0 = new oOOO0oOO();
    public final Map<Class<?>, CopyOnWriteArrayList<o0000000o>> O00000oO;
    public final Map<Object, List<Class<?>>> O00000oo;
    public final Map<Class<?>, Object> O0000O0o;
    public final ThreadLocal<O00000Oo> O0000OOo;
    public final oOOO000o O0000Oo;
    public final oOOO0O0o O0000Oo0;
    public final ooooO0O0 O0000OoO;
    public final o00000000 O0000Ooo;
    public final boolean O0000o;
    public final boolean O0000o0;
    public final ExecutorService O0000o00;
    public final boolean O0000o0O;
    public final boolean O0000o0o;
    public final boolean O0000oO;
    public final boolean O0000oO0;

    /* renamed from: com.tuya.smart.common.oOOO00o0$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] O000000o;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001d */
        static {
            /*
                com.tuya.sdk.eventbus.ThreadMode[] r0 = com.tuya.sdk.eventbus.ThreadMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                O000000o = r0
                r1 = 1
                com.tuya.sdk.eventbus.ThreadMode r2 = com.tuya.sdk.eventbus.ThreadMode.PostThread     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = O000000o     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.tuya.sdk.eventbus.ThreadMode r3 = com.tuya.sdk.eventbus.ThreadMode.MainThread     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = O000000o     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tuya.sdk.eventbus.ThreadMode r3 = com.tuya.sdk.eventbus.ThreadMode.BackgroundThread     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = O000000o     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.tuya.sdk.eventbus.ThreadMode r2 = com.tuya.sdk.eventbus.ThreadMode.Async     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tuya.smart.common.oOOO00o0.AnonymousClass2.<clinit>():void");
        }
    }

    public interface O000000o {
        void O000000o(List<oOOo0000> list);
    }

    public static final class O00000Oo {
        public final List<Object> O000000o = new ArrayList();
        public boolean O00000Oo;
        public o0000000o O00000o;
        public boolean O00000o0;
        public Object O00000oO;
        public boolean O00000oo;
    }

    public oOOO00o0() {
        this(O00000o0);
    }

    public oOOO00o0(oOOO0oOO oooo0ooo) {
        this.O0000OOo = new ThreadLocal<O00000Oo>() {
            /* renamed from: O000000o */
            public O00000Oo initialValue() {
                return new O00000Oo();
            }
        };
        this.O00000oO = new HashMap();
        this.O00000oo = new HashMap();
        this.O0000O0o = new ConcurrentHashMap();
        this.O0000Oo0 = new oOOO0O0o(this, Looper.getMainLooper(), 10);
        this.O0000Oo = new oOOO000o(this);
        this.O0000OoO = new ooooO0O0(this);
        this.O0000Ooo = new o00000000(oooo0ooo.O0000OOo);
        this.O0000o0O = oooo0ooo.O000000o;
        this.O0000o0o = oooo0ooo.O00000Oo;
        this.O0000o = oooo0ooo.O00000o0;
        this.O0000oO0 = oooo0ooo.O00000o;
        this.O0000o0 = oooo0ooo.O00000oO;
        this.O0000oO = oooo0ooo.O00000oo;
        this.O0000o00 = oooo0ooo.O0000O0o;
    }

    public static oOOO00o0 O000000o() {
        if (O00000Oo == null) {
            synchronized (oOOO00o0.class) {
                if (O00000Oo == null) {
                    O00000Oo = new oOOO00o0();
                }
            }
        }
        return O00000Oo;
    }

    private void O000000o(o0000000o o0000000o, Object obj, Throwable th) {
        if (obj instanceof oOOo0000) {
            if (this.O0000o0O) {
                String str = O000000o;
                StringBuilder n = a.n("SubscriberExceptionEvent subscriber ");
                n.append(o0000000o.O000000o.getClass());
                n.append(" threw an exception");
                Log.e(str, n.toString(), th);
                oOOo0000 oooo0000 = (oOOo0000) obj;
                String str2 = O000000o;
                StringBuilder n2 = a.n("Initial event ");
                n2.append(oooo0000.O00000o0);
                n2.append(" caused exception in ");
                n2.append(oooo0000.O00000o);
                Log.e(str2, n2.toString(), oooo0000.O00000Oo);
            }
        } else if (!this.O0000o0) {
            if (this.O0000o0O) {
                String str3 = O000000o;
                StringBuilder n3 = a.n("Could not dispatch event: ");
                n3.append(obj.getClass());
                n3.append(" to subscribing class ");
                n3.append(o0000000o.O000000o.getClass());
                Log.e(str3, n3.toString(), th);
            }
            if (this.O0000o) {
                O00000oO(new oOOo0000(this, th, obj, o0000000o.O000000o));
            }
        } else {
            throw new EventBusException("Invoking subscriber failed", th);
        }
    }

    private void O000000o(o0000000o o0000000o, Object obj, boolean z) {
        int i = AnonymousClass2.O000000o[o0000000o.O00000Oo.O00000Oo.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        this.O0000OoO.O000000o(o0000000o, obj);
                        return;
                    }
                    StringBuilder n = a.n("Unknown thread mode: ");
                    n.append(o0000000o.O00000Oo.O00000Oo);
                    throw new IllegalStateException(n.toString());
                } else if (z) {
                    this.O0000Oo.O000000o(o0000000o, obj);
                    return;
                }
            } else if (!z) {
                this.O0000Oo0.O000000o(o0000000o, obj);
                return;
            }
        }
        O000000o(o0000000o, obj);
    }

    private void O000000o(Object obj, O00000Oo o00000Oo) {
        boolean z;
        Class<?> cls = obj.getClass();
        if (this.O0000oO) {
            List<Class<?>> O00000o2 = O00000o(cls);
            int size = O00000o2.size();
            z = false;
            for (int i = 0; i < size; i++) {
                z |= O000000o(obj, o00000Oo, O00000o2.get(i));
            }
        } else {
            z = O000000o(obj, o00000Oo, cls);
        }
        if (!z) {
            if (this.O0000o0o) {
                String str = O000000o;
                Log.d(str, "No subscribers registered for event " + cls);
            }
            if (this.O0000oO0 && cls != oOOO0OO0.class && cls != oOOo0000.class) {
                O00000oO(new oOOO0OO0(this, obj));
            }
        }
    }

    private void O000000o(Object obj, oo000000 oo000000, boolean z, int i) {
        Object obj2;
        Class<?> cls = oo000000.O00000o0;
        CopyOnWriteArrayList copyOnWriteArrayList = this.O00000oO.get(cls);
        o0000000o o0000000o = new o0000000o(obj, oo000000, i);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.O00000oO.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(o0000000o)) {
            StringBuilder n = a.n("Subscriber ");
            n.append(obj.getClass());
            n.append(" already registered to event ");
            n.append(cls);
            throw new EventBusException(n.toString());
        }
        int size = copyOnWriteArrayList.size();
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 > size) {
                break;
            } else if (i2 == size || o0000000o.O00000o0 > ((o0000000o) copyOnWriteArrayList.get(i2)).O00000o0) {
                copyOnWriteArrayList.add(i2, o0000000o);
            } else {
                i2++;
            }
        }
        copyOnWriteArrayList.add(i2, o0000000o);
        List list = this.O00000oo.get(obj);
        if (list == null) {
            list = new ArrayList();
            this.O00000oo.put(obj, list);
        }
        list.add(cls);
        if (z) {
            synchronized (this.O0000O0o) {
                obj2 = this.O0000O0o.get(cls);
            }
            if (obj2 != null) {
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    z2 = true;
                }
                O000000o(o0000000o, obj2, z2);
            }
        }
    }

    private void O000000o(Object obj, Class<?> cls) {
        List list = this.O00000oO.get(cls);
        if (list != null) {
            int size = list.size();
            int i = 0;
            while (i < size) {
                o0000000o o0000000o = (o0000000o) list.get(i);
                if (o0000000o.O000000o == obj) {
                    o0000000o.O00000o = false;
                    list.remove(i);
                    i--;
                    size--;
                }
                i++;
            }
        }
    }

    private synchronized void O000000o(Object obj, boolean z, int i) {
        for (oo000000 O000000o2 : this.O0000Ooo.O000000o(obj.getClass())) {
            O000000o(obj, O000000o2, z, i);
        }
    }

    public static void O000000o(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                O000000o(list, (Class<?>[]) cls.getInterfaces());
            }
        }
    }

    private boolean O000000o(Object obj, O00000Oo o00000Oo, Class<?> cls) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.O00000oO.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            o0000000o o0000000o = (o0000000o) it.next();
            o00000Oo.O00000oO = obj;
            o00000Oo.O00000o = o0000000o;
            try {
                O000000o(o0000000o, obj, o00000Oo.O00000o0);
                if (o00000Oo.O00000oo) {
                    return true;
                }
            } finally {
                o00000Oo.O00000oO = null;
                o00000Oo.O00000o = null;
                o00000Oo.O00000oo = false;
            }
        }
        return true;
    }

    public static oOOO0oOO O00000Oo() {
        return new oOOO0oOO();
    }

    private List<Class<?>> O00000o(Class<?> cls) {
        ArrayList arrayList;
        synchronized (O00000o) {
            List<Class<?>> list = O00000o.get(cls);
            arrayList = list;
            if (list == null) {
                ArrayList arrayList2 = new ArrayList();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    arrayList2.add(cls2);
                    O000000o((List<Class<?>>) arrayList2, (Class<?>[]) cls2.getInterfaces());
                }
                O00000o.put(cls, arrayList2);
                arrayList = arrayList2;
            }
        }
        return arrayList;
    }

    public static void O00000o0() {
        o00000000.O000000o();
        O00000o.clear();
    }

    public <T> T O000000o(Class<T> cls) {
        T cast;
        synchronized (this.O0000O0o) {
            cast = cls.cast(this.O0000O0o.get(cls));
        }
        return cast;
    }

    public void O000000o(o0000000o o0000000o, Object obj) {
        try {
            o0000000o.O00000Oo.O000000o.invoke(o0000000o.O000000o, new Object[]{obj});
        } catch (InvocationTargetException e2) {
            O000000o(o0000000o, obj, e2.getCause());
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException("Unexpected exception", e3);
        }
    }

    public void O000000o(oOOO0o00 oooo0o00) {
        Object obj = oooo0o00.O000000o;
        o0000000o o0000000o = oooo0o00.O00000Oo;
        oOOO0o00.O000000o(oooo0o00);
        if (o0000000o.O00000o) {
            O000000o(o0000000o, obj);
        }
    }

    public void O000000o(Object obj) {
        O000000o(obj, false, 0);
    }

    public void O000000o(Object obj, int i) {
        O000000o(obj, false, i);
    }

    public <T> T O00000Oo(Class<T> cls) {
        T cast;
        synchronized (this.O0000O0o) {
            cast = cls.cast(this.O0000O0o.remove(cls));
        }
        return cast;
    }

    public void O00000Oo(Object obj) {
        O000000o(obj, true, 0);
    }

    public void O00000Oo(Object obj, int i) {
        O000000o(obj, true, i);
    }

    public void O00000o() {
        synchronized (this.O0000O0o) {
            this.O0000O0o.clear();
        }
    }

    public synchronized void O00000o(Object obj) {
        List<Class> list = this.O00000oo.get(obj);
        if (list != null) {
            for (Class O000000o2 : list) {
                O000000o(obj, (Class<?>) O000000o2);
            }
            this.O00000oo.remove(obj);
        } else {
            String str = O000000o;
            Log.w(str, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    public boolean O00000o0(Class<?> cls) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        List<Class<?>> O00000o2 = O00000o(cls);
        if (O00000o2 != null) {
            int size = O00000o2.size();
            for (int i = 0; i < size; i++) {
                Class cls2 = O00000o2.get(i);
                synchronized (this) {
                    copyOnWriteArrayList = this.O00000oO.get(cls2);
                }
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public synchronized boolean O00000o0(Object obj) {
        return this.O00000oo.containsKey(obj);
    }

    public ExecutorService O00000oO() {
        return this.O0000o00;
    }

    public void O00000oO(Object obj) {
        O00000Oo o00000Oo = this.O0000OOo.get();
        List<Object> list = o00000Oo.O000000o;
        list.add(obj);
        if (!o00000Oo.O00000Oo) {
            o00000Oo.O00000o0 = Looper.getMainLooper() == Looper.myLooper();
            o00000Oo.O00000Oo = true;
            if (!o00000Oo.O00000oo) {
                while (!list.isEmpty()) {
                    try {
                        O000000o(list.remove(0), o00000Oo);
                    } finally {
                        o00000Oo.O00000Oo = false;
                        o00000Oo.O00000o0 = false;
                    }
                }
                return;
            }
            throw new EventBusException("Internal error. Abort state was not reset");
        }
    }

    public void O00000oo(Object obj) {
        O00000Oo o00000Oo = this.O0000OOo.get();
        if (!o00000Oo.O00000Oo) {
            throw new EventBusException("This method may only be called from inside event handling methods on the posting thread");
        } else if (obj == null) {
            throw new EventBusException("Event may not be null");
        } else if (o00000Oo.O00000oO != obj) {
            throw new EventBusException("Only the currently handled event may be aborted");
        } else if (o00000Oo.O00000o.O00000Oo.O00000Oo == ThreadMode.PostThread) {
            o00000Oo.O00000oo = true;
        } else {
            throw new EventBusException(" event handlers may only abort the incoming event");
        }
    }

    public void O0000O0o(Object obj) {
        synchronized (this.O0000O0o) {
            this.O0000O0o.put(obj.getClass(), obj);
        }
        O00000oO(obj);
    }

    public boolean O0000OOo(Object obj) {
        synchronized (this.O0000O0o) {
            Class<?> cls = obj.getClass();
            if (!obj.equals(this.O0000O0o.get(cls))) {
                return false;
            }
            this.O0000O0o.remove(cls);
            return true;
        }
    }
}
