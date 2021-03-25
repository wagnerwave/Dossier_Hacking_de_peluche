package a.i.a;

import a.i.a.j;
import a.i.a.r;
import a.i.a.t;
import a.i.a.y;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class c implements Runnable {
    public static final Object t = new Object();
    public static final ThreadLocal<StringBuilder> u = new a();
    public static final AtomicInteger v = new AtomicInteger();
    public static final y w = new b();

    /* renamed from: a  reason: collision with root package name */
    public final int f3590a = v.incrementAndGet();

    /* renamed from: b  reason: collision with root package name */
    public final t f3591b;

    /* renamed from: c  reason: collision with root package name */
    public final i f3592c;

    /* renamed from: d  reason: collision with root package name */
    public final d f3593d;

    /* renamed from: e  reason: collision with root package name */
    public final a0 f3594e;
    public final String f;
    public final w g;
    public final int h;
    public int i;
    public final y j;
    public a k;
    public List<a> l;
    public Bitmap m;
    public Future<?> n;
    public t.d o;
    public Exception p;
    public int q;
    public int r;
    public t.e s;

    public static class a extends ThreadLocal<StringBuilder> {
        public Object initialValue() {
            return new StringBuilder("Picasso-");
        }
    }

    public static class b extends y {
        public boolean c(w wVar) {
            return true;
        }

        public y.a f(w wVar, int i) {
            throw new IllegalStateException("Unrecognized type of request: " + wVar);
        }
    }

    /* renamed from: a.i.a.c$c  reason: collision with other inner class name */
    public static class C0086c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e0 f3595a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RuntimeException f3596b;

        public C0086c(e0 e0Var, RuntimeException runtimeException) {
            this.f3595a = e0Var;
            this.f3596b = runtimeException;
        }

        public void run() {
            StringBuilder n = a.a.a.a.a.n("Transformation ");
            n.append(this.f3595a.b());
            n.append(" crashed with exception.");
            throw new RuntimeException(n.toString(), this.f3596b);
        }
    }

    public static class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ StringBuilder f3597a;

        public d(StringBuilder sb) {
            this.f3597a = sb;
        }

        public void run() {
            throw new NullPointerException(this.f3597a.toString());
        }
    }

    public static class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e0 f3598a;

        public e(e0 e0Var) {
            this.f3598a = e0Var;
        }

        public void run() {
            StringBuilder n = a.a.a.a.a.n("Transformation ");
            n.append(this.f3598a.b());
            n.append(" returned input Bitmap but recycled it.");
            throw new IllegalStateException(n.toString());
        }
    }

    public static class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e0 f3599a;

        public f(e0 e0Var) {
            this.f3599a = e0Var;
        }

        public void run() {
            StringBuilder n = a.a.a.a.a.n("Transformation ");
            n.append(this.f3599a.b());
            n.append(" mutated input Bitmap but failed to recycle the original.");
            throw new IllegalStateException(n.toString());
        }
    }

    public c(t tVar, i iVar, d dVar, a0 a0Var, a aVar, y yVar) {
        this.f3591b = tVar;
        this.f3592c = iVar;
        this.f3593d = dVar;
        this.f3594e = a0Var;
        this.k = aVar;
        this.f = aVar.i;
        w wVar = aVar.f3572b;
        this.g = wVar;
        this.s = wVar.r;
        this.h = aVar.f3575e;
        this.i = aVar.f;
        this.j = yVar;
        this.r = yVar.e();
    }

    public static Bitmap a(List<e0> list, Bitmap bitmap) {
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            e0 e0Var = list.get(i2);
            try {
                Bitmap a2 = e0Var.a(bitmap);
                if (a2 == null) {
                    StringBuilder n2 = a.a.a.a.a.n("Transformation ");
                    n2.append(e0Var.b());
                    n2.append(" returned null after ");
                    n2.append(i2);
                    n2.append(" previous transformation(s).\n\nTransformation list:\n");
                    for (e0 b2 : list) {
                        n2.append(b2.b());
                        n2.append(10);
                    }
                    t.o.post(new d(n2));
                    return null;
                } else if (a2 == bitmap && bitmap.isRecycled()) {
                    t.o.post(new e(e0Var));
                    return null;
                } else if (a2 == bitmap || bitmap.isRecycled()) {
                    i2++;
                    bitmap = a2;
                } else {
                    t.o.post(new f(e0Var));
                    return null;
                }
            } catch (RuntimeException e2) {
                t.o.post(new C0086c(e0Var, e2));
                return null;
            }
        }
        return bitmap;
    }

    public static Bitmap c(InputStream inputStream, w wVar) {
        n nVar = new n(inputStream);
        long b2 = nVar.b(65536);
        BitmapFactory.Options d2 = y.d(wVar);
        boolean z = d2 != null && d2.inJustDecodeBounds;
        boolean o2 = g0.o(nVar);
        nVar.a(b2);
        if (o2) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[4096];
            while (true) {
                int read = nVar.read(bArr);
                if (-1 == read) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (z) {
                BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, d2);
                y.b(wVar.h, wVar.i, d2, wVar);
            }
            return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, d2);
        }
        if (z) {
            BitmapFactory.decodeStream(nVar, (Rect) null, d2);
            y.b(wVar.h, wVar.i, d2, wVar);
            nVar.a(b2);
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(nVar, (Rect) null, d2);
        if (decodeStream != null) {
            return decodeStream;
        }
        throw new IOException("Failed to decode stream.");
    }

    public static c e(t tVar, i iVar, d dVar, a0 a0Var, a aVar) {
        w wVar = aVar.f3572b;
        List<y> list = tVar.f3656d;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            y yVar = list.get(i2);
            if (yVar.c(wVar)) {
                return new c(tVar, iVar, dVar, a0Var, aVar, yVar);
            }
        }
        return new c(tVar, iVar, dVar, a0Var, aVar, w);
    }

    public static boolean g(boolean z, int i2, int i3, int i4, int i5) {
        return !z || i2 > i4 || i3 > i5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap h(a.i.a.w r13, android.graphics.Bitmap r14, int r15) {
        /*
            int r0 = r14.getWidth()
            int r1 = r14.getHeight()
            boolean r2 = r13.l
            android.graphics.Matrix r8 = new android.graphics.Matrix
            r8.<init>()
            boolean r3 = r13.c()
            r4 = 0
            if (r3 == 0) goto L_0x00af
            int r3 = r13.h
            int r5 = r13.i
            float r6 = r13.m
            r7 = 0
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x0030
            boolean r7 = r13.p
            if (r7 == 0) goto L_0x002d
            float r7 = r13.n
            float r9 = r13.o
            r8.setRotate(r6, r7, r9)
            goto L_0x0030
        L_0x002d:
            r8.setRotate(r6)
        L_0x0030:
            boolean r6 = r13.j
            if (r6 == 0) goto L_0x0074
            float r13 = (float) r3
            float r6 = (float) r0
            float r7 = r13 / r6
            float r9 = (float) r5
            float r10 = (float) r1
            float r11 = r9 / r10
            int r12 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r12 <= 0) goto L_0x0053
            float r11 = r11 / r7
            float r11 = r11 * r10
            double r10 = (double) r11
            double r10 = java.lang.Math.ceil(r10)
            int r13 = (int) r10
            int r6 = r1 - r13
            int r6 = r6 / 2
            float r10 = (float) r13
            float r11 = r9 / r10
            r9 = r7
            r7 = r0
            goto L_0x0067
        L_0x0053:
            float r7 = r7 / r11
            float r7 = r7 * r6
            double r6 = (double) r7
            double r6 = java.lang.Math.ceil(r6)
            int r6 = (int) r6
            int r7 = r0 - r6
            int r7 = r7 / 2
            float r9 = (float) r6
            float r13 = r13 / r9
            r9 = r13
            r13 = r1
            r4 = r7
            r7 = r6
            r6 = 0
        L_0x0067:
            boolean r0 = g(r2, r0, r1, r3, r5)
            if (r0 == 0) goto L_0x0070
            r8.preScale(r9, r11)
        L_0x0070:
            r5 = r6
            r6 = r7
            r7 = r13
            goto L_0x00b2
        L_0x0074:
            boolean r13 = r13.k
            if (r13 == 0) goto L_0x008e
            float r13 = (float) r3
            float r6 = (float) r0
            float r13 = r13 / r6
            float r6 = (float) r5
            float r7 = (float) r1
            float r6 = r6 / r7
            int r7 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r7 >= 0) goto L_0x0083
            goto L_0x0084
        L_0x0083:
            r13 = r6
        L_0x0084:
            boolean r2 = g(r2, r0, r1, r3, r5)
            if (r2 == 0) goto L_0x00af
            r8.preScale(r13, r13)
            goto L_0x00af
        L_0x008e:
            if (r3 != 0) goto L_0x0092
            if (r5 == 0) goto L_0x00af
        L_0x0092:
            if (r3 != r0) goto L_0x0096
            if (r5 == r1) goto L_0x00af
        L_0x0096:
            if (r3 == 0) goto L_0x009b
            float r13 = (float) r3
            float r6 = (float) r0
            goto L_0x009d
        L_0x009b:
            float r13 = (float) r5
            float r6 = (float) r1
        L_0x009d:
            float r13 = r13 / r6
            if (r5 == 0) goto L_0x00a3
            float r6 = (float) r5
            float r7 = (float) r1
            goto L_0x00a5
        L_0x00a3:
            float r6 = (float) r3
            float r7 = (float) r0
        L_0x00a5:
            float r6 = r6 / r7
            boolean r2 = g(r2, r0, r1, r3, r5)
            if (r2 == 0) goto L_0x00af
            r8.preScale(r13, r6)
        L_0x00af:
            r6 = r0
            r7 = r1
            r5 = 0
        L_0x00b2:
            if (r15 == 0) goto L_0x00b8
            float r13 = (float) r15
            r8.preRotate(r13)
        L_0x00b8:
            r9 = 1
            r3 = r14
            android.graphics.Bitmap r13 = android.graphics.Bitmap.createBitmap(r3, r4, r5, r6, r7, r8, r9)
            if (r13 == r14) goto L_0x00c4
            r14.recycle()
            r14 = r13
        L_0x00c4:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: a.i.a.c.h(a.i.a.w, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }

    public static void i(w wVar) {
        Uri uri = wVar.f3680d;
        String valueOf = uri != null ? String.valueOf(uri.getPath()) : Integer.toHexString(wVar.f3681e);
        StringBuilder sb = u.get();
        sb.ensureCapacity(valueOf.length() + 8);
        sb.replace(8, sb.length(), valueOf);
        Thread.currentThread().setName(sb.toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        r0 = r2.n;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b() {
        /*
            r2 = this;
            a.i.a.a r0 = r2.k
            r1 = 0
            if (r0 != 0) goto L_0x001a
            java.util.List<a.i.a.a> r0 = r2.l
            if (r0 == 0) goto L_0x000f
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x001a
        L_0x000f:
            java.util.concurrent.Future<?> r0 = r2.n
            if (r0 == 0) goto L_0x001a
            boolean r0 = r0.cancel(r1)
            if (r0 == 0) goto L_0x001a
            r1 = 1
        L_0x001a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.i.a.c.b():boolean");
    }

    public void d(a aVar) {
        boolean z;
        boolean z2 = true;
        if (this.k == aVar) {
            this.k = null;
            z = true;
        } else {
            List<a> list = this.l;
            z = list != null ? list.remove(aVar) : false;
        }
        if (z && aVar.f3572b.r == this.s) {
            t.e eVar = t.e.LOW;
            List<a> list2 = this.l;
            boolean z3 = list2 != null && !list2.isEmpty();
            if (this.k == null && !z3) {
                z2 = false;
            }
            if (z2) {
                a aVar2 = this.k;
                if (aVar2 != null) {
                    eVar = aVar2.f3572b.r;
                }
                if (z3) {
                    int size = this.l.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        t.e eVar2 = this.l.get(i2).f3572b.r;
                        if (eVar2.ordinal() > eVar.ordinal()) {
                            eVar = eVar2;
                        }
                    }
                }
            }
            this.s = eVar;
        }
        if (this.f3591b.n) {
            g0.p("Hunter", "removed", aVar.f3572b.b(), g0.l(this, "from "));
        }
    }

    /* JADX INFO: finally extract failed */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public android.graphics.Bitmap f() {
        /*
            r9 = this;
            int r0 = r9.h
            boolean r0 = a.i.a.p.f(r0)
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x0035
            a.i.a.d r0 = r9.f3593d
            java.lang.String r3 = r9.f
            android.graphics.Bitmap r0 = r0.get(r3)
            if (r0 == 0) goto L_0x0036
            a.i.a.a0 r2 = r9.f3594e
            android.os.Handler r2 = r2.f3579c
            r2.sendEmptyMessage(r1)
            a.i.a.t$d r1 = a.i.a.t.d.MEMORY
            r9.o = r1
            a.i.a.t r1 = r9.f3591b
            boolean r1 = r1.n
            if (r1 == 0) goto L_0x0034
            java.lang.String r1 = "Hunter"
            java.lang.String r2 = "decoded"
            a.i.a.w r3 = r9.g
            java.lang.String r3 = r3.b()
            java.lang.String r4 = "from cache"
            a.i.a.g0.p(r1, r2, r3, r4)
        L_0x0034:
            return r0
        L_0x0035:
            r0 = r2
        L_0x0036:
            a.i.a.w r3 = r9.g
            int r4 = r9.r
            if (r4 != 0) goto L_0x0041
            a.i.a.q r4 = a.i.a.q.OFFLINE
            int r4 = r4.f3649a
            goto L_0x0043
        L_0x0041:
            int r4 = r9.i
        L_0x0043:
            r3.f3679c = r4
            a.i.a.y r3 = r9.j
            a.i.a.w r4 = r9.g
            int r5 = r9.i
            a.i.a.y$a r3 = r3.f(r4, r5)
            if (r3 == 0) goto L_0x006f
            a.i.a.t$d r0 = r3.f3692a
            r9.o = r0
            int r0 = r3.f3695d
            r9.q = r0
            android.graphics.Bitmap r0 = r3.f3693b
            if (r0 != 0) goto L_0x006f
            java.io.InputStream r0 = r3.f3694c
            a.i.a.w r3 = r9.g     // Catch:{ all -> 0x006a }
            android.graphics.Bitmap r3 = c(r0, r3)     // Catch:{ all -> 0x006a }
            a.i.a.g0.e(r0)
            r0 = r3
            goto L_0x006f
        L_0x006a:
            r1 = move-exception
            a.i.a.g0.e(r0)
            throw r1
        L_0x006f:
            if (r0 == 0) goto L_0x0122
            a.i.a.t r3 = r9.f3591b
            boolean r3 = r3.n
            if (r3 == 0) goto L_0x0086
            java.lang.String r3 = "Hunter"
            java.lang.String r4 = "decoded"
            a.i.a.w r5 = r9.g
            java.lang.String r5 = r5.b()
            java.lang.String r6 = ""
            a.i.a.g0.p(r3, r4, r5, r6)
        L_0x0086:
            a.i.a.a0 r3 = r9.f3594e
            if (r3 == 0) goto L_0x0121
            int r4 = a.i.a.g0.j(r0)
            android.os.Handler r3 = r3.f3579c
            r5 = 2
            android.os.Message r4 = r3.obtainMessage(r5, r4, r1)
            r3.sendMessage(r4)
            a.i.a.w r3 = r9.g
            boolean r4 = r3.c()
            r5 = 1
            if (r4 != 0) goto L_0x00ad
            java.util.List<a.i.a.e0> r3 = r3.g
            if (r3 == 0) goto L_0x00a7
            r3 = 1
            goto L_0x00a8
        L_0x00a7:
            r3 = 0
        L_0x00a8:
            if (r3 == 0) goto L_0x00ab
            goto L_0x00ad
        L_0x00ab:
            r3 = 0
            goto L_0x00ae
        L_0x00ad:
            r3 = 1
        L_0x00ae:
            if (r3 != 0) goto L_0x00b4
            int r3 = r9.q
            if (r3 == 0) goto L_0x0122
        L_0x00b4:
            java.lang.Object r3 = t
            monitor-enter(r3)
            a.i.a.w r4 = r9.g     // Catch:{ all -> 0x011e }
            boolean r4 = r4.c()     // Catch:{ all -> 0x011e }
            if (r4 != 0) goto L_0x00c3
            int r4 = r9.q     // Catch:{ all -> 0x011e }
            if (r4 == 0) goto L_0x00e0
        L_0x00c3:
            a.i.a.w r4 = r9.g     // Catch:{ all -> 0x011e }
            int r6 = r9.q     // Catch:{ all -> 0x011e }
            android.graphics.Bitmap r0 = h(r4, r0, r6)     // Catch:{ all -> 0x011e }
            a.i.a.t r4 = r9.f3591b     // Catch:{ all -> 0x011e }
            boolean r4 = r4.n     // Catch:{ all -> 0x011e }
            if (r4 == 0) goto L_0x00e0
            java.lang.String r4 = "Hunter"
            java.lang.String r6 = "transformed"
            a.i.a.w r7 = r9.g     // Catch:{ all -> 0x011e }
            java.lang.String r7 = r7.b()     // Catch:{ all -> 0x011e }
            java.lang.String r8 = ""
            a.i.a.g0.p(r4, r6, r7, r8)     // Catch:{ all -> 0x011e }
        L_0x00e0:
            a.i.a.w r4 = r9.g     // Catch:{ all -> 0x011e }
            java.util.List<a.i.a.e0> r4 = r4.g     // Catch:{ all -> 0x011e }
            if (r4 == 0) goto L_0x00e7
            goto L_0x00e8
        L_0x00e7:
            r5 = 0
        L_0x00e8:
            if (r5 == 0) goto L_0x0107
            a.i.a.w r4 = r9.g     // Catch:{ all -> 0x011e }
            java.util.List<a.i.a.e0> r4 = r4.g     // Catch:{ all -> 0x011e }
            android.graphics.Bitmap r0 = a(r4, r0)     // Catch:{ all -> 0x011e }
            a.i.a.t r4 = r9.f3591b     // Catch:{ all -> 0x011e }
            boolean r4 = r4.n     // Catch:{ all -> 0x011e }
            if (r4 == 0) goto L_0x0107
            java.lang.String r4 = "Hunter"
            java.lang.String r5 = "transformed"
            a.i.a.w r6 = r9.g     // Catch:{ all -> 0x011e }
            java.lang.String r6 = r6.b()     // Catch:{ all -> 0x011e }
            java.lang.String r7 = "from custom transformations"
            a.i.a.g0.p(r4, r5, r6, r7)     // Catch:{ all -> 0x011e }
        L_0x0107:
            monitor-exit(r3)     // Catch:{ all -> 0x011e }
            if (r0 == 0) goto L_0x0122
            a.i.a.a0 r3 = r9.f3594e
            if (r3 == 0) goto L_0x011d
            int r2 = a.i.a.g0.j(r0)
            android.os.Handler r3 = r3.f3579c
            r4 = 3
            android.os.Message r1 = r3.obtainMessage(r4, r2, r1)
            r3.sendMessage(r1)
            goto L_0x0122
        L_0x011d:
            throw r2
        L_0x011e:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x011e }
            throw r0
        L_0x0121:
            throw r2
        L_0x0122:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.i.a.c.f():android.graphics.Bitmap");
    }

    public void run() {
        Handler handler;
        Handler handler2;
        try {
            i(this.g);
            if (this.f3591b.n) {
                g0.p("Hunter", "executing", g0.k(this), "");
            }
            Bitmap f2 = f();
            this.m = f2;
            if (f2 == null) {
                this.f3592c.c(this);
            } else {
                this.f3592c.b(this);
            }
        } catch (j.b e2) {
            if (!e2.f3623a || e2.f3624b != 504) {
                this.p = e2;
            }
            handler = this.f3592c.i;
        } catch (r.a e3) {
            this.p = e3;
            handler2 = this.f3592c.i;
            handler2.sendMessageDelayed(handler2.obtainMessage(5, this), 500);
            Thread.currentThread().setName("Picasso-Idle");
        } catch (IOException e4) {
            this.p = e4;
            handler2 = this.f3592c.i;
            handler2.sendMessageDelayed(handler2.obtainMessage(5, this), 500);
            Thread.currentThread().setName("Picasso-Idle");
        } catch (OutOfMemoryError e5) {
            StringWriter stringWriter = new StringWriter();
            this.f3594e.a().a(new PrintWriter(stringWriter));
            this.p = new RuntimeException(stringWriter.toString(), e5);
            handler = this.f3592c.i;
        } catch (Exception e6) {
            this.p = e6;
            handler = this.f3592c.i;
        } catch (Throwable th) {
            Thread.currentThread().setName("Picasso-Idle");
            throw th;
        }
        Thread.currentThread().setName("Picasso-Idle");
        handler.sendMessage(handler.obtainMessage(6, this));
        Thread.currentThread().setName("Picasso-Idle");
    }
}
