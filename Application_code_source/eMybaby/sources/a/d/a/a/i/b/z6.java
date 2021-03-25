package a.d.a.a.i.b;

import java.util.concurrent.atomic.AtomicReference;

public final class z6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f2666a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f6 f2667b;

    public z6(f6 f6Var, AtomicReference atomicReference) {
        this.f2667b = f6Var;
        this.f2666a = atomicReference;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:(1:6)(2:7|(6:9|10|13|14|15|16))|11|12|13|14|15|16) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r7 = this;
            java.util.concurrent.atomic.AtomicReference r0 = r7.f2666a
            monitor-enter(r0)
            java.util.concurrent.atomic.AtomicReference r1 = r7.f2666a     // Catch:{ all -> 0x0059 }
            a.d.a.a.i.b.f6 r2 = r7.f2667b     // Catch:{ all -> 0x0059 }
            a.d.a.a.i.b.c5 r2 = r2.f2563a     // Catch:{ all -> 0x0059 }
            a.d.a.a.i.b.ka r2 = r2.g     // Catch:{ all -> 0x0059 }
            a.d.a.a.i.b.f6 r3 = r7.f2667b     // Catch:{ all -> 0x0059 }
            a.d.a.a.i.b.q3 r3 = r3.p()     // Catch:{ all -> 0x0059 }
            r3.u()     // Catch:{ all -> 0x0059 }
            java.lang.String r3 = r3.f2474c     // Catch:{ all -> 0x0059 }
            a.d.a.a.i.b.n3<java.lang.Double> r4 = a.d.a.a.i.b.q.O     // Catch:{ all -> 0x0059 }
            r5 = 0
            if (r2 == 0) goto L_0x0058
            if (r3 != 0) goto L_0x001e
            goto L_0x0040
        L_0x001e:
            a.d.a.a.i.b.b r2 = r2.f2331c     // Catch:{ all -> 0x0059 }
            java.lang.String r6 = r4.f2393a     // Catch:{ all -> 0x0059 }
            java.lang.String r2 = r2.h(r3, r6)     // Catch:{ all -> 0x0059 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0059 }
            if (r3 == 0) goto L_0x002d
            goto L_0x0040
        L_0x002d:
            double r2 = java.lang.Double.parseDouble(r2)     // Catch:{ NumberFormatException -> 0x0040 }
            java.lang.Double r2 = java.lang.Double.valueOf(r2)     // Catch:{ NumberFormatException -> 0x0040 }
            java.lang.Object r2 = r4.a(r2)     // Catch:{ NumberFormatException -> 0x0040 }
            java.lang.Double r2 = (java.lang.Double) r2     // Catch:{ NumberFormatException -> 0x0040 }
            double r2 = r2.doubleValue()     // Catch:{ NumberFormatException -> 0x0040 }
            goto L_0x004a
        L_0x0040:
            java.lang.Object r2 = r4.a(r5)     // Catch:{ all -> 0x0059 }
            java.lang.Double r2 = (java.lang.Double) r2     // Catch:{ all -> 0x0059 }
            double r2 = r2.doubleValue()     // Catch:{ all -> 0x0059 }
        L_0x004a:
            java.lang.Double r2 = java.lang.Double.valueOf(r2)     // Catch:{ all -> 0x0059 }
            r1.set(r2)     // Catch:{ all -> 0x0059 }
            java.util.concurrent.atomic.AtomicReference r1 = r7.f2666a     // Catch:{ all -> 0x0060 }
            r1.notify()     // Catch:{ all -> 0x0060 }
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            return
        L_0x0058:
            throw r5     // Catch:{ all -> 0x0059 }
        L_0x0059:
            r1 = move-exception
            java.util.concurrent.atomic.AtomicReference r2 = r7.f2666a     // Catch:{ all -> 0x0060 }
            r2.notify()     // Catch:{ all -> 0x0060 }
            throw r1     // Catch:{ all -> 0x0060 }
        L_0x0060:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0060 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.i.b.z6.run():void");
    }
}
