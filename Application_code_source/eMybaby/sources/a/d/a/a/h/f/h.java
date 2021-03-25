package a.d.a.a.h.f;

import a.a.a.a.a;
import a.d.a.a.b.f;
import a.d.a.a.e.q.b;
import a.d.a.a.e.q.c;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;

@SuppressLint({"StaticFieldLeak"})
public class h {
    public static volatile h k;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1503a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f1504b;

    /* renamed from: c  reason: collision with root package name */
    public final b f1505c = c.f1429a;

    /* renamed from: d  reason: collision with root package name */
    public final b0 f1506d = new b0(this);

    /* renamed from: e  reason: collision with root package name */
    public final r0 f1507e;
    public final f f;
    public final b g;
    public final g0 h;
    public final f1 i;
    public final u0 j;

    public h(j jVar) {
        Context context = jVar.f1515a;
        a.c.a.f.b.l(context, "Application context can't be null");
        Context context2 = jVar.f1516b;
        a.c.a.f.b.k(context2);
        this.f1503a = context;
        this.f1504b = context2;
        r0 r0Var = new r0(this);
        r0Var.s();
        this.f1507e = r0Var;
        r0 c2 = c();
        String str = g.f1496a;
        c2.a(4, a.d(String.valueOf(str).length() + 134, "Google Analytics ", str, " is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4"), (Object) null, (Object) null, (Object) null);
        u0 u0Var = new u0(this);
        u0Var.s();
        this.j = u0Var;
        f1 f1Var = new f1(this);
        f1Var.s();
        this.i = f1Var;
        b bVar = new b(this, jVar);
        y yVar = new y(this);
        a aVar = new a(this);
        r rVar = new r(this);
        f0 f0Var = new f0(this);
        a.c.a.f.b.k(context);
        if (f.f1181e == null) {
            synchronized (f.class) {
                if (f.f1181e == null) {
                    f.f1181e = new f(context);
                }
            }
        }
        f fVar = f.f1181e;
        fVar.f1185d = new i(this);
        this.f = fVar;
        a.d.a.a.b.b bVar2 = new a.d.a.a.b.b(this);
        yVar.s();
        aVar.s();
        rVar.s();
        f0Var.s();
        g0 g0Var = new g0(this);
        g0Var.s();
        this.h = g0Var;
        bVar.s();
        this.g = bVar;
        h hVar = bVar2.f1180a;
        a(hVar.i);
        f1 f1Var2 = hVar.i;
        f1Var2.u();
        f1Var2.u();
        if (f1Var2.g) {
            f1Var2.u();
        }
        f1Var2.u();
        s sVar = bVar.f1473c;
        sVar.u();
        a.c.a.f.b.o(!sVar.f1554c, "Analytics backend already started");
        sVar.f1554c = true;
        sVar.h().a(new v(sVar));
    }

    public static void a(f fVar) {
        a.c.a.f.b.l(fVar, "Analytics service not created/initialized");
        a.c.a.f.b.e(fVar.r(), "Analytics service not initialized");
    }

    public static h b(Context context) {
        a.c.a.f.b.k(context);
        if (k == null) {
            synchronized (h.class) {
                if (k == null) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    h hVar = new h(new j(context));
                    k = hVar;
                    synchronized (a.d.a.a.b.b.class) {
                        if (a.d.a.a.b.b.f1179b != null) {
                            for (Runnable run : a.d.a.a.b.b.f1179b) {
                                run.run();
                            }
                            a.d.a.a.b.b.f1179b = null;
                        }
                    }
                    long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                    long longValue = ((Long) i0.B.f1517a).longValue();
                    if (elapsedRealtime2 > longValue) {
                        hVar.c().f("Slow initialization (ms)", Long.valueOf(elapsedRealtime2), Long.valueOf(longValue));
                    }
                }
            }
        }
        return k;
    }

    public final r0 c() {
        a(this.f1507e);
        return this.f1507e;
    }

    public final f d() {
        a.c.a.f.b.k(this.f);
        return this.f;
    }

    public final b e() {
        a(this.g);
        return this.g;
    }
}
