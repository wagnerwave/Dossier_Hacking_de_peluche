package a.i.a;

import a.i.a.a;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.core.internal.view.SupportMenu;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class t {
    public static final Handler o = new a(Looper.getMainLooper());
    public static volatile t p = null;

    /* renamed from: a  reason: collision with root package name */
    public final c f3653a = null;

    /* renamed from: b  reason: collision with root package name */
    public final f f3654b;

    /* renamed from: c  reason: collision with root package name */
    public final b f3655c;

    /* renamed from: d  reason: collision with root package name */
    public final List<y> f3656d;

    /* renamed from: e  reason: collision with root package name */
    public final Context f3657e;
    public final i f;
    public final d g;
    public final a0 h;
    public final Map<Object, a> i;
    public final Map<ImageView, h> j;
    public final ReferenceQueue<Object> k;
    public final Bitmap.Config l;
    public boolean m;
    public volatile boolean n;

    public static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 3) {
                int i2 = 0;
                if (i == 8) {
                    List list = (List) message.obj;
                    int size = list.size();
                    int i3 = 0;
                    while (i3 < size) {
                        c cVar = (c) list.get(i3);
                        t tVar = cVar.f3591b;
                        if (tVar != null) {
                            a aVar = cVar.k;
                            List<a> list2 = cVar.l;
                            boolean z = true;
                            boolean z2 = list2 != null && !list2.isEmpty();
                            if (aVar == null && !z2) {
                                z = false;
                            }
                            if (z) {
                                Uri uri = cVar.g.f3680d;
                                Exception exc = cVar.p;
                                Bitmap bitmap = cVar.m;
                                d dVar = cVar.o;
                                if (aVar != null) {
                                    tVar.b(bitmap, dVar, aVar);
                                }
                                if (z2) {
                                    int size2 = list2.size();
                                    for (int i4 = 0; i4 < size2; i4++) {
                                        tVar.b(bitmap, dVar, list2.get(i4));
                                    }
                                }
                                c cVar2 = tVar.f3653a;
                                if (!(cVar2 == null || exc == null)) {
                                    cVar2.a(tVar, uri, exc);
                                }
                            }
                            i3++;
                        } else {
                            throw null;
                        }
                    }
                } else if (i == 13) {
                    List list3 = (List) message.obj;
                    int size3 = list3.size();
                    while (i2 < size3) {
                        a aVar2 = (a) list3.get(i2);
                        t tVar2 = aVar2.f3571a;
                        if (tVar2 != null) {
                            d dVar2 = d.MEMORY;
                            Bitmap e2 = p.f(aVar2.f3575e) ? tVar2.e(aVar2.i) : null;
                            if (e2 != null) {
                                tVar2.b(e2, dVar2, aVar2);
                                if (tVar2.n) {
                                    String b2 = aVar2.f3572b.b();
                                    g0.p("Main", "completed", b2, "from " + dVar2);
                                }
                            } else {
                                tVar2.c(aVar2);
                                if (tVar2.n) {
                                    g0.p("Main", "resumed", aVar2.f3572b.b(), "");
                                }
                            }
                            i2++;
                        } else {
                            throw null;
                        }
                    }
                } else {
                    StringBuilder n = a.a.a.a.a.n("Unknown handler message received: ");
                    n.append(message.what);
                    throw new AssertionError(n.toString());
                }
            } else {
                a aVar3 = (a) message.obj;
                if (aVar3.f3571a.n) {
                    g0.p("Main", "canceled", aVar3.f3572b.b(), "target got garbage collected");
                }
                aVar3.f3571a.a(aVar3.d());
            }
        }
    }

    public static class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public final ReferenceQueue<Object> f3658a;

        /* renamed from: b  reason: collision with root package name */
        public final Handler f3659b;

        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Exception f3660a;

            public a(b bVar, Exception exc) {
                this.f3660a = exc;
            }

            public void run() {
                throw new RuntimeException(this.f3660a);
            }
        }

        public b(ReferenceQueue<Object> referenceQueue, Handler handler) {
            this.f3658a = referenceQueue;
            this.f3659b = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    a.C0084a aVar = (a.C0084a) this.f3658a.remove(1000);
                    Message obtainMessage = this.f3659b.obtainMessage();
                    if (aVar != null) {
                        obtainMessage.what = 3;
                        obtainMessage.obj = aVar.f3576a;
                        this.f3659b.sendMessage(obtainMessage);
                    } else {
                        obtainMessage.recycle();
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e2) {
                    this.f3659b.post(new a(this, e2));
                    return;
                }
            }
        }
    }

    public interface c {
        void a(t tVar, Uri uri, Exception exc);
    }

    public enum d {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(SupportMenu.CATEGORY_MASK);
        

        /* renamed from: a  reason: collision with root package name */
        public final int f3665a;

        /* access modifiers changed from: public */
        d(int i) {
            this.f3665a = i;
        }
    }

    public enum e {
        LOW,
        NORMAL,
        HIGH
    }

    public interface f {

        /* renamed from: a  reason: collision with root package name */
        public static final f f3670a = new a();

        public static class a implements f {
        }
    }

    public t(Context context, i iVar, d dVar, c cVar, f fVar, List<y> list, a0 a0Var, Bitmap.Config config, boolean z, boolean z2) {
        this.f3657e = context;
        this.f = iVar;
        this.g = dVar;
        this.f3654b = fVar;
        this.l = null;
        ArrayList arrayList = new ArrayList(7);
        arrayList.add(new z(context));
        arrayList.add(new f(context));
        arrayList.add(new o(context));
        arrayList.add(new g(context));
        arrayList.add(new b(context));
        arrayList.add(new k(context));
        arrayList.add(new r(iVar.f3614d, a0Var));
        this.f3656d = Collections.unmodifiableList(arrayList);
        this.h = a0Var;
        this.i = new WeakHashMap();
        this.j = new WeakHashMap();
        this.m = z;
        this.n = z2;
        this.k = new ReferenceQueue<>();
        b bVar = new b(this.k, o);
        this.f3655c = bVar;
        bVar.start();
    }

    public static t f(Context context) {
        if (p == null) {
            synchronized (t.class) {
                if (p == null) {
                    if (context != null) {
                        Context applicationContext = context.getApplicationContext();
                        j g2 = g0.g(applicationContext);
                        m mVar = new m(applicationContext);
                        v vVar = new v();
                        f fVar = f.f3670a;
                        a0 a0Var = new a0(mVar);
                        p = new t(applicationContext, new i(applicationContext, vVar, o, g2, mVar, a0Var), mVar, (c) null, fVar, (List<y>) null, a0Var, (Bitmap.Config) null, false, false);
                    } else {
                        throw new IllegalArgumentException("Context must not be null.");
                    }
                }
            }
        }
        return p;
    }

    public final void a(Object obj) {
        h remove;
        g0.c();
        a remove2 = this.i.remove(obj);
        if (remove2 != null) {
            remove2.a();
            Handler handler = this.f.i;
            handler.sendMessage(handler.obtainMessage(2, remove2));
        }
        if ((obj instanceof ImageView) && (remove = this.j.remove((ImageView) obj)) != null) {
            remove.f3610c = null;
            ImageView imageView = (ImageView) remove.f3609b.get();
            if (imageView != null) {
                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(remove);
                }
            }
        }
    }

    public final void b(Bitmap bitmap, d dVar, a aVar) {
        if (!aVar.l) {
            if (!aVar.k) {
                this.i.remove(aVar.d());
            }
            if (bitmap == null) {
                aVar.c();
                if (this.n) {
                    g0.p("Main", "errored", aVar.f3572b.b(), "");
                }
            } else if (dVar != null) {
                aVar.b(bitmap, dVar);
                if (this.n) {
                    String b2 = aVar.f3572b.b();
                    g0.p("Main", "completed", b2, "from " + dVar);
                }
            } else {
                throw new AssertionError("LoadedFrom cannot be null.");
            }
        }
    }

    public void c(a aVar) {
        Object d2 = aVar.d();
        if (!(d2 == null || this.i.get(d2) == aVar)) {
            a(d2);
            this.i.put(d2, aVar);
        }
        Handler handler = this.f.i;
        handler.sendMessage(handler.obtainMessage(1, aVar));
    }

    public x d(String str) {
        if (str == null) {
            return new x(this, (Uri) null, 0);
        }
        if (str.trim().length() != 0) {
            return new x(this, Uri.parse(str), 0);
        }
        throw new IllegalArgumentException("Path must not be empty.");
    }

    public Bitmap e(String str) {
        Bitmap bitmap = this.g.get(str);
        a0 a0Var = this.h;
        if (bitmap != null) {
            a0Var.f3579c.sendEmptyMessage(0);
        } else {
            a0Var.f3579c.sendEmptyMessage(1);
        }
        return bitmap;
    }
}
