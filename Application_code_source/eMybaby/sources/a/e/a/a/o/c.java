package a.e.a.a.o;

import a.e.a.a.o.i.a;
import a.e.a.a.o.i.d;
import a.e.a.a.o.i.e;
import a.e.a.a.o.i.f;
import a.e.a.a.o.i.g;
import a.e.a.a.o.i.h;
import a.e.a.a.o.i.i;
import a.e.a.a.o.i.j;
import a.e.a.a.o.i.k;
import a.e.a.a.o.i.l;
import a.e.a.a.o.i.m;
import a.e.a.a.o.i.n;
import a.e.a.a.o.i.o;
import a.e.a.a.r.c.b;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.inuker.bluetooth.library.connect.options.BleConnectOptions;
import java.lang.reflect.Method;
import java.util.UUID;

public class c implements Handler.Callback, f, b {

    /* renamed from: a  reason: collision with root package name */
    public Handler f3241a;

    /* renamed from: b  reason: collision with root package name */
    public String f3242b;

    /* renamed from: c  reason: collision with root package name */
    public a f3243c;

    public c(String str, Looper looper) {
        this.f3242b = str;
        this.f3241a = new Handler(looper, this);
    }

    public void a(int i, a.e.a.a.o.j.b bVar) {
        a r = r();
        if (r != null) {
            r.a(new a(i, bVar));
            return;
        }
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004c, code lost:
        if ((r5 instanceof a.e.a.a.o.i.n) == false) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005d, code lost:
        if ((r5 instanceof a.e.a.a.o.i.d) == false) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(int r8) {
        /*
            r7 = this;
            a.e.a.a.o.a r0 = r7.r()
            r0.y()
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.Integer r3 = java.lang.Integer.valueOf(r8)
            r4 = 0
            r2[r4] = r3
            java.lang.String r3 = "clearRequest %d"
            java.lang.String r2 = a.e.a.a.r.b.o(r3, r2)
            java.lang.String r3 = "miio-bluetooth"
            android.util.Log.w(r3, r2)
            java.util.LinkedList r2 = new java.util.LinkedList
            r2.<init>()
            if (r8 != 0) goto L_0x0029
            java.util.List<a.e.a.a.o.i.k> r8 = r0.f3234a
            r2.addAll(r8)
            goto L_0x006f
        L_0x0029:
            java.util.List<a.e.a.a.o.i.k> r3 = r0.f3234a
            java.util.Iterator r3 = r3.iterator()
        L_0x002f:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x006f
            java.lang.Object r5 = r3.next()
            a.e.a.a.o.i.k r5 = (a.e.a.a.o.i.k) r5
            r6 = r8 & 1
            if (r6 == 0) goto L_0x0042
            boolean r6 = r5 instanceof a.e.a.a.o.i.h
            goto L_0x0069
        L_0x0042:
            r6 = r8 & 2
            if (r6 == 0) goto L_0x004f
            boolean r6 = r5 instanceof a.e.a.a.o.i.o
            if (r6 != 0) goto L_0x005f
            boolean r6 = r5 instanceof a.e.a.a.o.i.n
            if (r6 == 0) goto L_0x0068
            goto L_0x005f
        L_0x004f:
            r6 = r8 & 4
            if (r6 == 0) goto L_0x0061
            boolean r6 = r5 instanceof a.e.a.a.o.i.f
            if (r6 != 0) goto L_0x005f
            boolean r6 = r5 instanceof a.e.a.a.o.i.l
            if (r6 != 0) goto L_0x005f
            boolean r6 = r5 instanceof a.e.a.a.o.i.d
            if (r6 == 0) goto L_0x0068
        L_0x005f:
            r6 = 1
            goto L_0x0069
        L_0x0061:
            r6 = r8 & 8
            if (r6 == 0) goto L_0x0068
            boolean r6 = r5 instanceof a.e.a.a.o.i.i
            goto L_0x0069
        L_0x0068:
            r6 = 0
        L_0x0069:
            if (r6 == 0) goto L_0x002f
            r2.add(r5)
            goto L_0x002f
        L_0x006f:
            java.util.Iterator r8 = r2.iterator()
        L_0x0073:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x0083
            java.lang.Object r1 = r8.next()
            a.e.a.a.o.i.k r1 = (a.e.a.a.o.i.k) r1
            r1.t()
            goto L_0x0073
        L_0x0083:
            java.util.List<a.e.a.a.o.i.k> r8 = r0.f3234a
            r8.removeAll(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e.a.a.o.c.b(int):void");
    }

    public void c() {
        a r = r();
        r.y();
        Log.w("miio-bluetooth", a.e.a.a.r.b.o("Process close", new Object[0]));
        k kVar = r.f3235b;
        if (kVar != null) {
            kVar.t();
            r.f3235b = null;
        }
        for (k t : r.f3234a) {
            t.t();
        }
        r.f3234a.clear();
        r.f3236c.disconnect();
    }

    public void d(UUID uuid, UUID uuid2, a.e.a.a.o.j.b bVar) {
        a r = r();
        if (r != null) {
            r.a(new d(uuid, uuid2, bVar));
            return;
        }
        throw null;
    }

    public void disconnect() {
        a r = r();
        r.y();
        Log.w("miio-bluetooth", a.e.a.a.r.b.o("Process disconnect", new Object[0]));
        k kVar = r.f3235b;
        if (kVar != null) {
            kVar.t();
            r.f3235b = null;
        }
        for (k t : r.f3234a) {
            t.t();
        }
        r.f3234a.clear();
        r.f3236c.r();
    }

    public void e(UUID uuid, UUID uuid2, byte[] bArr, a.e.a.a.o.j.b bVar) {
        a r = r();
        if (r != null) {
            r.a(new o(uuid, uuid2, bArr, bVar));
            return;
        }
        throw null;
    }

    public void f(UUID uuid, UUID uuid2, a.e.a.a.o.j.b bVar) {
        a r = r();
        if (r != null) {
            r.a(new h(uuid, uuid2, bVar));
            return;
        }
        throw null;
    }

    public void g(a.e.a.a.o.j.b bVar) {
        a r = r();
        if (r != null) {
            r.a(new a.e.a.a.o.i.c(bVar));
            return;
        }
        throw null;
    }

    public void h(BleConnectOptions bleConnectOptions, a.e.a.a.o.j.b bVar) {
        a r = r();
        if (r != null) {
            r.a(new a.e.a.a.o.i.b(bleConnectOptions, bVar));
            return;
        }
        throw null;
    }

    public boolean handleMessage(Message message) {
        a.e.a.a.r.c.a.a(message.obj);
        return true;
    }

    public void i(UUID uuid, UUID uuid2, byte[] bArr, a.e.a.a.o.j.b bVar) {
        a r = r();
        if (r != null) {
            r.a(new n(uuid, uuid2, bArr, bVar));
            return;
        }
        throw null;
    }

    public void j(UUID uuid, UUID uuid2, a.e.a.a.o.j.b bVar) {
        a r = r();
        if (r != null) {
            r.a(new e(uuid, uuid2, bVar));
            return;
        }
        throw null;
    }

    public void k(UUID uuid, UUID uuid2, a.e.a.a.o.j.b bVar) {
        a r = r();
        if (r != null) {
            r.a(new f(uuid, uuid2, bVar));
            return;
        }
        throw null;
    }

    public void l(UUID uuid, UUID uuid2, a.e.a.a.o.j.b bVar) {
        a r = r();
        if (r != null) {
            r.a(new l(uuid, uuid2, bVar));
            return;
        }
        throw null;
    }

    public void m(a.e.a.a.o.j.b bVar) {
        a r = r();
        if (r != null) {
            r.a(new i(bVar));
            return;
        }
        throw null;
    }

    public void n(UUID uuid, UUID uuid2, UUID uuid3, byte[] bArr, a.e.a.a.o.j.b bVar) {
        a r = r();
        if (r != null) {
            r.a(new m(uuid, uuid2, uuid3, bArr, bVar));
            return;
        }
        throw null;
    }

    public void o() {
        a r = r();
        if (r != null) {
            r.a(new j((a.e.a.a.o.j.b) null));
            return;
        }
        throw null;
    }

    public void p(int i) {
        r().f3236c.s(i);
    }

    public void q(UUID uuid, UUID uuid2, UUID uuid3, a.e.a.a.o.j.b bVar) {
        a r = r();
        if (r != null) {
            r.a(new g(uuid, uuid2, uuid3, bVar));
            return;
        }
        throw null;
    }

    public final a r() {
        if (this.f3243c == null) {
            this.f3243c = new a(this.f3242b);
        }
        return this.f3243c;
    }

    public boolean x(Object obj, Method method, Object[] objArr) {
        this.f3241a.obtainMessage(0, new a.e.a.a.r.c.a(obj, method, objArr)).sendToTarget();
        return true;
    }
}
