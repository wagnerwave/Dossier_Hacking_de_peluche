package a.e.a.a.r.c;

import a.c.a.f.b;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class c implements Handler.Callback, b, InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    public Object f3299a;

    /* renamed from: b  reason: collision with root package name */
    public b f3300b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3301c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3302d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f3303e;

    public c(Object obj, b bVar, boolean z, boolean z2) {
        this.f3301c = z;
        this.f3300b = bVar;
        this.f3302d = z2;
        this.f3299a = z ? new WeakReference(obj) : obj;
        this.f3303e = new Handler(Looper.getMainLooper(), this);
    }

    public boolean handleMessage(Message message) {
        a.a(message.obj);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke(java.lang.Object r4, java.lang.reflect.Method r5, java.lang.Object[] r6) {
        /*
            r3 = this;
            boolean r4 = r3.f3301c
            if (r4 == 0) goto L_0x000d
            java.lang.Object r4 = r3.f3299a
            java.lang.ref.WeakReference r4 = (java.lang.ref.WeakReference) r4
            java.lang.Object r4 = r4.get()
            goto L_0x000f
        L_0x000d:
            java.lang.Object r4 = r3.f3299a
        L_0x000f:
            a.e.a.a.r.c.b r0 = r3.f3300b
            r1 = 0
            if (r0 == 0) goto L_0x001d
            boolean r0 = r0.x(r4, r5, r6)     // Catch:{ Exception -> 0x0019 }
            goto L_0x001e
        L_0x0019:
            r0 = move-exception
            a.c.a.f.b.z(r0)
        L_0x001d:
            r0 = 0
        L_0x001e:
            r2 = 0
            if (r0 != 0) goto L_0x0043
            a.e.a.a.r.c.a r0 = new a.e.a.a.r.c.a
            r0.<init>(r4, r5, r6)
            boolean r4 = r3.f3302d
            if (r4 == 0) goto L_0x0034
            android.os.Handler r4 = r3.f3303e
            android.os.Message r4 = r4.obtainMessage(r1, r0)
            r4.sendToTarget()
            goto L_0x0043
        L_0x0034:
            java.lang.reflect.Method r4 = r0.f3297b     // Catch:{ all -> 0x003f }
            java.lang.Object r5 = r0.f3296a     // Catch:{ all -> 0x003f }
            java.lang.Object[] r6 = r0.f3298c     // Catch:{ all -> 0x003f }
            java.lang.Object r2 = r4.invoke(r5, r6)     // Catch:{ all -> 0x003f }
            goto L_0x0043
        L_0x003f:
            r4 = move-exception
            a.c.a.f.b.z(r4)     // Catch:{ all -> 0x0043 }
        L_0x0043:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e.a.a.r.c.c.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
    }

    public boolean x(Object obj, Method method, Object[] objArr) {
        b bVar = this.f3300b;
        if (bVar == null) {
            return false;
        }
        try {
            return bVar.x(obj, method, objArr);
        } catch (Exception e2) {
            b.z(e2);
            return false;
        }
    }
}
