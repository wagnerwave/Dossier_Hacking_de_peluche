package a.d.a.a.e.k.l;

import a.d.a.a.e.g;
import a.d.a.a.e.k.a;
import a.d.a.a.e.k.d;
import a.d.a.a.e.k.k;
import a.d.a.a.e.m.b;
import a.d.a.a.e.m.i;
import a.d.a.a.e.m.j;
import a.d.a.a.e.m.o;
import a.d.a.a.e.m.s;
import a.d.a.a.j.e;
import android.app.ActivityManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArraySet;
import androidx.core.app.Person;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

public class f implements Handler.Callback {
    public static final Status n = new Status(4, "Sign-out occurred while this API call was in progress.");
    public static final Status o = new Status(4, "The user must be signed in to make this API call.");
    public static final Object p = new Object();
    @GuardedBy("lock")
    public static f q;

    /* renamed from: a  reason: collision with root package name */
    public long f1280a = 5000;

    /* renamed from: b  reason: collision with root package name */
    public long f1281b = 120000;

    /* renamed from: c  reason: collision with root package name */
    public long f1282c = 10000;

    /* renamed from: d  reason: collision with root package name */
    public final Context f1283d;

    /* renamed from: e  reason: collision with root package name */
    public final a.d.a.a.e.c f1284e;
    public final i f;
    public final AtomicInteger g = new AtomicInteger(1);
    public final AtomicInteger h = new AtomicInteger(0);
    public final Map<b<?>, a<?>> i = new ConcurrentHashMap(5, 0.75f, 1);
    @GuardedBy("lock")
    public n j = null;
    @GuardedBy("lock")
    public final Set<b<?>> k = new ArraySet();
    public final Set<b<?>> l = new ArraySet();
    public final Handler m;

    public class a<O extends a.d> implements d.a, d.b {

        /* renamed from: a  reason: collision with root package name */
        public final Queue<b0> f1285a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        public final a.f f1286b;

        /* renamed from: c  reason: collision with root package name */
        public final a.b f1287c;

        /* renamed from: d  reason: collision with root package name */
        public final b<O> f1288d;

        /* renamed from: e  reason: collision with root package name */
        public final r0 f1289e;
        public final Set<l0> f = new HashSet();
        public final Map<j<?>, a0> g = new HashMap();
        public final int h;
        public final d0 i;
        public boolean j;
        public final List<c> k = new ArrayList();
        public ConnectionResult l = null;

        @WorkerThread
        public a(a.d.a.a.e.k.c<O> cVar) {
            Looper looper = f.this.m.getLooper();
            a.d.a.a.e.m.c a2 = cVar.a().a();
            a.d.a.a.e.k.a<O> aVar = cVar.f1255b;
            a.c.a.f.b.o(aVar.f1250a != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
            a.f a3 = aVar.f1250a.a(cVar.f1254a, looper, a2, cVar.f1256c, this, this);
            this.f1286b = a3;
            if (!(a3 instanceof s)) {
                this.f1287c = a3;
            } else if (((s) a3) != null) {
                this.f1287c = null;
            } else {
                throw null;
            }
            this.f1288d = cVar.f1257d;
            this.f1289e = new r0();
            this.h = cVar.f;
            if (this.f1286b.j()) {
                this.i = new d0(f.this.f1283d, f.this.m, cVar.a().a());
            } else {
                this.i = null;
            }
        }

        @WorkerThread
        public final void a() {
            a.c.a.f.b.f(f.this.m);
            if (!this.f1286b.isConnected() && !this.f1286b.g()) {
                f fVar = f.this;
                i iVar = fVar.f;
                Context context = fVar.f1283d;
                a.f fVar2 = this.f1286b;
                if (iVar != null) {
                    a.c.a.f.b.k(context);
                    a.c.a.f.b.k(fVar2);
                    int i2 = 0;
                    if (fVar2.e()) {
                        int f2 = fVar2.f();
                        int i3 = iVar.f1393a.get(f2, -1);
                        if (i3 != -1) {
                            i2 = i3;
                        } else {
                            int i4 = 0;
                            while (true) {
                                if (i4 >= iVar.f1393a.size()) {
                                    i2 = i3;
                                    break;
                                }
                                int keyAt = iVar.f1393a.keyAt(i4);
                                if (keyAt > f2 && iVar.f1393a.get(keyAt) == 0) {
                                    break;
                                }
                                i4++;
                            }
                            if (i2 == -1) {
                                i2 = iVar.f1394b.b(context, f2);
                            }
                            iVar.f1393a.put(f2, i2);
                        }
                    }
                    if (i2 != 0) {
                        g(new ConnectionResult(i2, (PendingIntent) null));
                        return;
                    }
                    b bVar = new b(this.f1286b, this.f1288d);
                    if (this.f1286b.j()) {
                        d0 d0Var = this.i;
                        e eVar = d0Var.f;
                        if (eVar != null) {
                            eVar.disconnect();
                        }
                        d0Var.f1279e.h = Integer.valueOf(System.identityHashCode(d0Var));
                        a.C0057a<? extends e, a.d.a.a.j.a> aVar = d0Var.f1277c;
                        Context context2 = d0Var.f1275a;
                        Looper looper = d0Var.f1276b.getLooper();
                        a.d.a.a.e.m.c cVar = d0Var.f1279e;
                        d0Var.f = (e) aVar.a(context2, looper, cVar, cVar.g, d0Var, d0Var);
                        d0Var.g = bVar;
                        Set<Scope> set = d0Var.f1278d;
                        if (set == null || set.isEmpty()) {
                            d0Var.f1276b.post(new c0(d0Var));
                        } else {
                            d0Var.f.connect();
                        }
                    }
                    this.f1286b.i(bVar);
                    return;
                }
                throw null;
            }
        }

        public final boolean b() {
            return this.f1286b.j();
        }

        @WorkerThread
        @Nullable
        public final Feature c(@Nullable Feature[] featureArr) {
            return null;
        }

        @WorkerThread
        public final void d(b0 b0Var) {
            a.c.a.f.b.f(f.this.m);
            if (!this.f1286b.isConnected()) {
                this.f1285a.add(b0Var);
                ConnectionResult connectionResult = this.l;
                if (connectionResult == null || !connectionResult.e()) {
                    a();
                } else {
                    g(this.l);
                }
            } else if (f(b0Var)) {
                o();
            } else {
                this.f1285a.add(b0Var);
            }
        }

        public final void e(int i2) {
            if (Looper.myLooper() == f.this.m.getLooper()) {
                j();
            } else {
                f.this.m.post(new t(this));
            }
        }

        @WorkerThread
        public final boolean f(b0 b0Var) {
            if (!(b0Var instanceof q)) {
                q(b0Var);
                return true;
            }
            q qVar = (q) b0Var;
            k0 k0Var = (k0) qVar;
            if (k0Var == null) {
                throw null;
            } else if (this.g.get(k0Var.f1308b) == null) {
                Feature c2 = c((Feature[]) null);
                if (c2 == null) {
                    q(b0Var);
                    return true;
                } else if (this.g.get(k0Var.f1308b) == null) {
                    ((j0) qVar).f1307a.a(new k(c2));
                    return false;
                } else {
                    throw null;
                }
            } else {
                throw null;
            }
        }

        @WorkerThread
        public final void g(@NonNull ConnectionResult connectionResult) {
            e eVar;
            a.c.a.f.b.f(f.this.m);
            d0 d0Var = this.i;
            if (!(d0Var == null || (eVar = d0Var.f) == null)) {
                eVar.disconnect();
            }
            m();
            f.this.f.f1393a.clear();
            t(connectionResult);
            if (connectionResult.f4192b == 4) {
                p(f.o);
            } else if (this.f1285a.isEmpty()) {
                this.l = connectionResult;
            } else if (!s(connectionResult) && !f.this.d(connectionResult, this.h)) {
                if (connectionResult.f4192b == 18) {
                    this.j = true;
                }
                if (this.j) {
                    Handler handler = f.this.m;
                    handler.sendMessageDelayed(Message.obtain(handler, 9, this.f1288d), f.this.f1280a);
                    return;
                }
                String str = this.f1288d.f1267c.f1252c;
                String valueOf = String.valueOf(connectionResult);
                StringBuilder sb = new StringBuilder(valueOf.length() + String.valueOf(str).length() + 63);
                sb.append("API: ");
                sb.append(str);
                sb.append(" is not available on this device. Connection failed with: ");
                sb.append(valueOf);
                p(new Status(17, sb.toString()));
            }
        }

        public final void h(@Nullable Bundle bundle) {
            if (Looper.myLooper() == f.this.m.getLooper()) {
                i();
            } else {
                f.this.m.post(new s(this));
            }
        }

        @WorkerThread
        public final void i() {
            m();
            t(ConnectionResult.f4190e);
            n();
            Iterator<a0> it = this.g.values().iterator();
            if (!it.hasNext()) {
                k();
                o();
                return;
            }
            a0 next = it.next();
            throw null;
        }

        @WorkerThread
        public final void j() {
            m();
            this.j = true;
            this.f1289e.a(true, g0.f1304a);
            Handler handler = f.this.m;
            handler.sendMessageDelayed(Message.obtain(handler, 9, this.f1288d), f.this.f1280a);
            Handler handler2 = f.this.m;
            handler2.sendMessageDelayed(Message.obtain(handler2, 11, this.f1288d), f.this.f1281b);
            f.this.f.f1393a.clear();
        }

        @WorkerThread
        public final void k() {
            ArrayList arrayList = new ArrayList(this.f1285a);
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                b0 b0Var = (b0) obj;
                if (!this.f1286b.isConnected()) {
                    return;
                }
                if (f(b0Var)) {
                    this.f1285a.remove(b0Var);
                }
            }
        }

        @WorkerThread
        public final void l() {
            a.c.a.f.b.f(f.this.m);
            p(f.n);
            r0 r0Var = this.f1289e;
            if (r0Var != null) {
                r0Var.a(false, f.n);
                for (j k0Var : (j[]) this.g.keySet().toArray(new j[this.g.size()])) {
                    d(new k0(k0Var, new a.d.a.a.l.e()));
                }
                t(new ConnectionResult(4));
                if (this.f1286b.isConnected()) {
                    this.f1286b.a(new v(this));
                    return;
                }
                return;
            }
            throw null;
        }

        @WorkerThread
        public final void m() {
            a.c.a.f.b.f(f.this.m);
            this.l = null;
        }

        @WorkerThread
        public final void n() {
            if (this.j) {
                f.this.m.removeMessages(11, this.f1288d);
                f.this.m.removeMessages(9, this.f1288d);
                this.j = false;
            }
        }

        public final void o() {
            f.this.m.removeMessages(12, this.f1288d);
            Handler handler = f.this.m;
            handler.sendMessageDelayed(handler.obtainMessage(12, this.f1288d), f.this.f1282c);
        }

        @WorkerThread
        public final void p(Status status) {
            a.c.a.f.b.f(f.this.m);
            for (b0 a2 : this.f1285a) {
                a2.a(status);
            }
            this.f1285a.clear();
        }

        @WorkerThread
        public final void q(b0 b0Var) {
            b0Var.b(this.f1289e, b());
            try {
                b0Var.e(this);
            } catch (DeadObjectException unused) {
                e(1);
                this.f1286b.disconnect();
            }
        }

        @WorkerThread
        public final boolean r(boolean z) {
            a.c.a.f.b.f(f.this.m);
            if (!this.f1286b.isConnected() || this.g.size() != 0) {
                return false;
            }
            r0 r0Var = this.f1289e;
            if (!r0Var.f1322a.isEmpty() || !r0Var.f1323b.isEmpty()) {
                if (z) {
                    o();
                }
                return false;
            }
            this.f1286b.disconnect();
            return true;
        }

        @WorkerThread
        public final boolean s(@NonNull ConnectionResult connectionResult) {
            synchronized (f.p) {
                if (f.this.j == null || !f.this.k.contains(this.f1288d)) {
                    return false;
                }
                n nVar = f.this.j;
                int i2 = this.h;
                if (nVar != null) {
                    o0 o0Var = new o0(connectionResult, i2);
                    if (nVar.f1312c.compareAndSet((Object) null, o0Var)) {
                        nVar.f1313d.post(new n0(nVar, o0Var));
                    }
                    return true;
                }
                throw null;
            }
        }

        @WorkerThread
        public final void t(ConnectionResult connectionResult) {
            Iterator<l0> it = this.f.iterator();
            if (it.hasNext()) {
                l0 next = it.next();
                if (a.c.a.f.b.B(connectionResult, ConnectionResult.f4190e)) {
                    this.f1286b.h();
                }
                throw null;
            }
            this.f.clear();
        }
    }

    public class b implements e0, b.c {

        /* renamed from: a  reason: collision with root package name */
        public final a.f f1290a;

        /* renamed from: b  reason: collision with root package name */
        public final b<?> f1291b;

        /* renamed from: c  reason: collision with root package name */
        public j f1292c = null;

        /* renamed from: d  reason: collision with root package name */
        public Set<Scope> f1293d = null;

        /* renamed from: e  reason: collision with root package name */
        public boolean f1294e = false;

        public b(a.f fVar, b<?> bVar) {
            this.f1290a = fVar;
            this.f1291b = bVar;
        }

        public final void a(@NonNull ConnectionResult connectionResult) {
            f.this.m.post(new x(this, connectionResult));
        }

        @WorkerThread
        public final void b(ConnectionResult connectionResult) {
            a aVar = f.this.i.get(this.f1291b);
            a.c.a.f.b.f(f.this.m);
            aVar.f1286b.disconnect();
            aVar.g(connectionResult);
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final b<?> f1295a;

        /* renamed from: b  reason: collision with root package name */
        public final Feature f1296b;

        public final boolean equals(Object obj) {
            if (obj != null && (obj instanceof c)) {
                c cVar = (c) obj;
                return a.c.a.f.b.B(this.f1295a, cVar.f1295a) && a.c.a.f.b.B(this.f1296b, cVar.f1296b);
            }
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.f1295a, this.f1296b});
        }

        public final String toString() {
            o y0 = a.c.a.f.b.y0(this);
            y0.a(Person.KEY_KEY, this.f1295a);
            y0.a("feature", this.f1296b);
            return y0.toString();
        }
    }

    public f(Context context, Looper looper, a.d.a.a.e.c cVar) {
        this.f1283d = context;
        this.m = new a.d.a.a.h.d.d(looper, this);
        this.f1284e = cVar;
        this.f = new i(cVar);
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(6));
    }

    public static f b(Context context) {
        f fVar;
        synchronized (p) {
            if (q == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                q = new f(context.getApplicationContext(), handlerThread.getLooper(), a.d.a.a.e.c.f1231d);
            }
            fVar = q;
        }
        return fVar;
    }

    public final void a(@NonNull n nVar) {
        synchronized (p) {
            if (this.j != nVar) {
                this.j = nVar;
                this.k.clear();
            }
            this.k.addAll(nVar.f);
        }
    }

    @WorkerThread
    public final void c(a.d.a.a.e.k.c<?> cVar) {
        b<O> bVar = cVar.f1257d;
        a aVar = this.i.get(bVar);
        if (aVar == null) {
            aVar = new a(cVar);
            this.i.put(bVar, aVar);
        }
        if (aVar.b()) {
            this.l.add(bVar);
        }
        aVar.a();
    }

    public final boolean d(ConnectionResult connectionResult, int i2) {
        a.d.a.a.e.c cVar = this.f1284e;
        Context context = this.f1283d;
        PendingIntent pendingIntent = null;
        if (cVar != null) {
            if (connectionResult.e()) {
                pendingIntent = connectionResult.f4193c;
            } else {
                Intent a2 = cVar.a(context, connectionResult.f4192b, (String) null);
                if (a2 != null) {
                    pendingIntent = PendingIntent.getActivity(context, 0, a2, 134217728);
                }
            }
            if (pendingIntent == null) {
                return false;
            }
            cVar.h(context, connectionResult.f4192b, GoogleApiActivity.a(context, pendingIntent, i2));
            return true;
        }
        throw null;
    }

    @WorkerThread
    public boolean handleMessage(Message message) {
        a aVar;
        int i2 = message.what;
        long j2 = 300000;
        int i3 = 0;
        switch (i2) {
            case 1:
                if (((Boolean) message.obj).booleanValue()) {
                    j2 = 10000;
                }
                this.f1282c = j2;
                this.m.removeMessages(12);
                for (b<?> obtainMessage : this.i.keySet()) {
                    Handler handler = this.m;
                    handler.sendMessageDelayed(handler.obtainMessage(12, obtainMessage), this.f1282c);
                }
                break;
            case 2:
                l0 l0Var = (l0) message.obj;
                throw null;
            case 3:
                for (a next : this.i.values()) {
                    next.m();
                    next.a();
                }
                break;
            case 4:
            case 8:
            case 13:
                z zVar = (z) message.obj;
                a aVar2 = this.i.get(zVar.f1349c.f1257d);
                if (aVar2 == null) {
                    c(zVar.f1349c);
                    aVar2 = this.i.get(zVar.f1349c.f1257d);
                }
                if (aVar2.b() && this.h.get() != zVar.f1348b) {
                    zVar.f1347a.a(n);
                    aVar2.l();
                    break;
                } else {
                    aVar2.d(zVar.f1347a);
                    break;
                }
                break;
            case 5:
                int i4 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator<a<?>> it = this.i.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        aVar = it.next();
                        if (aVar.h == i4) {
                        }
                    } else {
                        aVar = null;
                    }
                }
                if (aVar == null) {
                    StringBuilder sb = new StringBuilder(76);
                    sb.append("Could not find API instance ");
                    sb.append(i4);
                    sb.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb.toString(), new Exception());
                    break;
                } else {
                    a.d.a.a.e.c cVar = this.f1284e;
                    int i5 = connectionResult.f4192b;
                    if (cVar != null) {
                        String b2 = g.b(i5);
                        String str = connectionResult.f4194d;
                        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + String.valueOf(b2).length() + 69);
                        sb2.append("Error resolution was canceled by the user, original error message: ");
                        sb2.append(b2);
                        sb2.append(": ");
                        sb2.append(str);
                        aVar.p(new Status(17, sb2.toString()));
                        break;
                    } else {
                        throw null;
                    }
                }
            case 6:
                if (this.f1283d.getApplicationContext() instanceof Application) {
                    c.a((Application) this.f1283d.getApplicationContext());
                    c cVar2 = c.f1269e;
                    r rVar = new r(this);
                    if (cVar2 != null) {
                        synchronized (c.f1269e) {
                            cVar2.f1272c.add(rVar);
                        }
                        c cVar3 = c.f1269e;
                        if (!cVar3.f1271b.get()) {
                            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                            ActivityManager.getMyMemoryState(runningAppProcessInfo);
                            if (!cVar3.f1271b.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                                cVar3.f1270a.set(true);
                            }
                        }
                        if (!cVar3.f1270a.get()) {
                            this.f1282c = 300000;
                            break;
                        }
                    } else {
                        throw null;
                    }
                }
                break;
            case 7:
                c((a.d.a.a.e.k.c) message.obj);
                break;
            case 9:
                if (this.i.containsKey(message.obj)) {
                    a aVar3 = this.i.get(message.obj);
                    a.c.a.f.b.f(f.this.m);
                    if (aVar3.j) {
                        aVar3.a();
                        break;
                    }
                }
                break;
            case 10:
                for (b<?> remove : this.l) {
                    this.i.remove(remove).l();
                }
                this.l.clear();
                break;
            case 11:
                if (this.i.containsKey(message.obj)) {
                    a aVar4 = this.i.get(message.obj);
                    a.c.a.f.b.f(f.this.m);
                    if (aVar4.j) {
                        aVar4.n();
                        f fVar = f.this;
                        aVar4.p(fVar.f1284e.c(fVar.f1283d) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
                        aVar4.f1286b.disconnect();
                        break;
                    }
                }
                break;
            case 12:
                if (this.i.containsKey(message.obj)) {
                    this.i.get(message.obj).r(true);
                    break;
                }
                break;
            case 14:
                if (((o) message.obj) == null) {
                    throw null;
                } else if (!this.i.containsKey((Object) null)) {
                    throw null;
                } else {
                    this.i.get((Object) null).r(false);
                    throw null;
                }
            case 15:
                c cVar4 = (c) message.obj;
                if (this.i.containsKey(cVar4.f1295a)) {
                    a aVar5 = this.i.get(cVar4.f1295a);
                    if (aVar5.k.contains(cVar4) && !aVar5.j) {
                        if (aVar5.f1286b.isConnected()) {
                            aVar5.k();
                            break;
                        } else {
                            aVar5.a();
                            break;
                        }
                    }
                }
                break;
            case 16:
                c cVar5 = (c) message.obj;
                if (this.i.containsKey(cVar5.f1295a)) {
                    a aVar6 = this.i.get(cVar5.f1295a);
                    if (aVar6.k.remove(cVar5)) {
                        f.this.m.removeMessages(15, cVar5);
                        f.this.m.removeMessages(16, cVar5);
                        Feature feature = cVar5.f1296b;
                        ArrayList arrayList = new ArrayList(aVar6.f1285a.size());
                        for (b0 b0Var : aVar6.f1285a) {
                            if (b0Var instanceof q) {
                                k0 k0Var = (k0) ((q) b0Var);
                                if (k0Var == null) {
                                    throw null;
                                } else if (aVar6.g.get(k0Var.f1308b) != null) {
                                    throw null;
                                }
                            }
                        }
                        int size = arrayList.size();
                        while (i3 < size) {
                            Object obj = arrayList.get(i3);
                            i3++;
                            b0 b0Var2 = (b0) obj;
                            aVar6.f1285a.remove(b0Var2);
                            b0Var2.c(new k(feature));
                        }
                        break;
                    }
                }
                break;
            default:
                StringBuilder sb3 = new StringBuilder(31);
                sb3.append("Unknown message id: ");
                sb3.append(i2);
                Log.w("GoogleApiManager", sb3.toString());
                return false;
        }
        return true;
    }
}
