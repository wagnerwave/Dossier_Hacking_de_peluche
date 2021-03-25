package e.a.a.i0;

import e.a.a.l0.b;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class d implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    public final j f5132a;

    /* renamed from: b  reason: collision with root package name */
    public final q f5133b;

    /* renamed from: c  reason: collision with root package name */
    public e.a.a.d f5134c = null;

    /* renamed from: d  reason: collision with root package name */
    public b f5135d = null;

    /* renamed from: e  reason: collision with root package name */
    public t f5136e = null;

    public d(j jVar) {
        e eVar = e.f5137a;
        if (jVar != null) {
            this.f5132a = jVar;
            this.f5133b = eVar;
            return;
        }
        throw new IllegalArgumentException("Header iterator may not be null");
    }

    public e.a.a.d a() {
        if (this.f5134c == null) {
            b();
        }
        e.a.a.d dVar = this.f5134c;
        if (dVar != null) {
            this.f5134c = null;
            return dVar;
        }
        throw new NoSuchElementException("No more header elements available");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r5 = this;
        L_0x0000:
            e.a.a.i0.j r0 = r5.f5132a
            boolean r0 = r0.hasNext()
            if (r0 != 0) goto L_0x000e
            e.a.a.i0.t r0 = r5.f5136e
            if (r0 == 0) goto L_0x000d
            goto L_0x000e
        L_0x000d:
            return
        L_0x000e:
            e.a.a.i0.t r0 = r5.f5136e
            r1 = 0
            if (r0 == 0) goto L_0x0019
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x0068
        L_0x0019:
            r5.f5136e = r1
            r5.f5135d = r1
        L_0x001d:
            e.a.a.i0.j r0 = r5.f5132a
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0068
            e.a.a.i0.j r0 = r5.f5132a
            e.a.a.c r0 = r0.b()
            boolean r2 = r0 instanceof e.a.a.b
            r3 = 0
            if (r2 == 0) goto L_0x0049
            e.a.a.b r0 = (e.a.a.b) r0
            e.a.a.l0.b r2 = r0.b()
            r5.f5135d = r2
            e.a.a.i0.t r4 = new e.a.a.i0.t
            int r2 = r2.f5184b
            r4.<init>(r3, r2)
            r5.f5136e = r4
            int r0 = r0.d()
            r4.b(r0)
            goto L_0x0068
        L_0x0049:
            java.lang.String r0 = r0.getValue()
            if (r0 == 0) goto L_0x001d
            e.a.a.l0.b r2 = new e.a.a.l0.b
            int r4 = r0.length()
            r2.<init>(r4)
            r5.f5135d = r2
            r2.b(r0)
            e.a.a.i0.t r0 = new e.a.a.i0.t
            e.a.a.l0.b r2 = r5.f5135d
            int r2 = r2.f5184b
            r0.<init>(r3, r2)
            r5.f5136e = r0
        L_0x0068:
            e.a.a.i0.t r0 = r5.f5136e
            if (r0 == 0) goto L_0x0000
        L_0x006c:
            e.a.a.i0.t r0 = r5.f5136e
            boolean r0 = r0.a()
            if (r0 != 0) goto L_0x0092
            e.a.a.i0.q r0 = r5.f5133b
            e.a.a.l0.b r2 = r5.f5135d
            e.a.a.i0.t r3 = r5.f5136e
            e.a.a.i0.e r0 = (e.a.a.i0.e) r0
            e.a.a.d r0 = r0.c(r2, r3)
            r2 = r0
            e.a.a.i0.c r2 = (e.a.a.i0.c) r2
            java.lang.String r3 = r2.f5129a
            int r3 = r3.length()
            if (r3 != 0) goto L_0x008f
            java.lang.String r2 = r2.f5130b
            if (r2 == 0) goto L_0x006c
        L_0x008f:
            r5.f5134c = r0
            return
        L_0x0092:
            e.a.a.i0.t r0 = r5.f5136e
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x0000
            r5.f5136e = r1
            r5.f5135d = r1
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.i0.d.b():void");
    }

    public boolean hasNext() {
        if (this.f5134c == null) {
            b();
        }
        return this.f5134c != null;
    }

    public final Object next() {
        return a();
    }

    public void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
