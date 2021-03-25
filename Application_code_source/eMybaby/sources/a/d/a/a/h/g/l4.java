package a.d.a.a.h.g;

public final class l4 extends j4 {

    /* renamed from: a  reason: collision with root package name */
    public final i4 f1800a = new i4();

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0025, code lost:
        r1 = new java.util.Vector(2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.Throwable r5, java.lang.Throwable r6) {
        /*
            r4 = this;
            if (r6 == r5) goto L_0x004a
            if (r6 == 0) goto L_0x0042
            a.d.a.a.h.g.i4 r0 = r4.f1800a
        L_0x0006:
            java.lang.ref.ReferenceQueue<java.lang.Throwable> r1 = r0.f1735b
            java.lang.ref.Reference r1 = r1.poll()
            if (r1 == 0) goto L_0x0014
            java.util.concurrent.ConcurrentHashMap<a.d.a.a.h.g.m4, java.util.List<java.lang.Throwable>> r2 = r0.f1734a
            r2.remove(r1)
            goto L_0x0006
        L_0x0014:
            a.d.a.a.h.g.m4 r1 = new a.d.a.a.h.g.m4
            r2 = 0
            r1.<init>(r5, r2)
            java.util.concurrent.ConcurrentHashMap<a.d.a.a.h.g.m4, java.util.List<java.lang.Throwable>> r2 = r0.f1734a
            java.lang.Object r1 = r2.get(r1)
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x0025
            goto L_0x003e
        L_0x0025:
            java.util.Vector r1 = new java.util.Vector
            r2 = 2
            r1.<init>(r2)
            java.util.concurrent.ConcurrentHashMap<a.d.a.a.h.g.m4, java.util.List<java.lang.Throwable>> r2 = r0.f1734a
            a.d.a.a.h.g.m4 r3 = new a.d.a.a.h.g.m4
            java.lang.ref.ReferenceQueue<java.lang.Throwable> r0 = r0.f1735b
            r3.<init>(r5, r0)
            java.lang.Object r5 = r2.putIfAbsent(r3, r1)
            java.util.List r5 = (java.util.List) r5
            if (r5 != 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r1 = r5
        L_0x003e:
            r1.add(r6)
            return
        L_0x0042:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "The suppressed exception cannot be null."
            r5.<init>(r6)
            throw r5
        L_0x004a:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Self suppression is not allowed."
            r5.<init>(r0, r6)
            goto L_0x0053
        L_0x0052:
            throw r5
        L_0x0053:
            goto L_0x0052
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.h.g.l4.a(java.lang.Throwable, java.lang.Throwable):void");
    }
}
