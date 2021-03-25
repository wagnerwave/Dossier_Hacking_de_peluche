package a.g.a.b;

import a.g.a.b.b;
import a.g.a.b.l.c;
import a.g.a.b.l.h;
import a.g.a.b.m.a;
import a.g.a.b.m.b;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Field;
import java.util.HashMap;

public class d {
    public static final String f = "d";
    public static volatile d g;

    /* renamed from: a  reason: collision with root package name */
    public f f3372a;

    /* renamed from: b  reason: collision with root package name */
    public h f3373b;

    /* renamed from: c  reason: collision with root package name */
    public final c f3374c = new h();

    /* renamed from: d  reason: collision with root package name */
    public final a f3375d = new b();

    /* renamed from: e  reason: collision with root package name */
    public HashMap<Integer, String> f3376e = new HashMap<>();

    public static d e() {
        if (g == null) {
            synchronized (d.class) {
                if (g == null) {
                    g = new d();
                }
            }
        }
        return g;
    }

    public final void a() {
        if (this.f3372a == null) {
            throw new IllegalStateException("ImageLoader must be init with configuration before using");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x0196  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(java.lang.String r9, android.widget.ImageView r10, a.g.a.b.b r11, a.g.a.b.l.c r12) {
        /*
            r8 = this;
            r8.a()
            if (r10 == 0) goto L_0x01eb
            if (r12 != 0) goto L_0x0009
            a.g.a.b.l.c r12 = r8.f3374c
        L_0x0009:
            r5 = r12
            if (r11 != 0) goto L_0x0010
            a.g.a.b.f r11 = r8.f3372a
            a.g.a.b.b r11 = r11.n
        L_0x0010:
            r4 = r11
            r11 = 0
            r12 = 0
            r0 = 1
            if (r9 == 0) goto L_0x01c5
            int r1 = r9.length()
            if (r1 != 0) goto L_0x001e
            goto L_0x01c5
        L_0x001e:
            android.content.Context r1 = r10.getContext()
            android.content.res.Resources r1 = r1.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            android.view.ViewGroup$LayoutParams r2 = r10.getLayoutParams()
            int r3 = r2.width
            if (r3 > 0) goto L_0x0038
            java.lang.String r3 = "mMaxWidth"
            int r3 = r8.d(r10, r3)
        L_0x0038:
            if (r3 > 0) goto L_0x003e
            a.g.a.b.f r3 = r8.f3372a
            int r3 = r3.f3379b
        L_0x003e:
            if (r3 > 0) goto L_0x0042
            int r3 = r1.widthPixels
        L_0x0042:
            int r2 = r2.height
            if (r2 > 0) goto L_0x004c
            java.lang.String r2 = "mMaxHeight"
            int r2 = r8.d(r10, r2)
        L_0x004c:
            if (r2 > 0) goto L_0x0052
            a.g.a.b.f r2 = r8.f3372a
            int r2 = r2.f3380c
        L_0x0052:
            if (r2 > 0) goto L_0x0056
            int r2 = r1.heightPixels
        L_0x0056:
            a.g.a.b.l.e r6 = new a.g.a.b.l.e
            r6.<init>(r3, r2)
            java.lang.String r1 = a.e.a.a.r.b.q(r9, r6)
            a.g.a.b.h r2 = r8.f3373b
            java.util.Map<java.lang.Integer, java.lang.String> r2 = r2.f3394e
            int r3 = r10.hashCode()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.put(r3, r1)
            r5.b(r9, r10)
            a.g.a.b.f r2 = r8.f3372a
            a.g.a.a.b.c<java.lang.String, android.graphics.Bitmap> r2 = r2.k
            java.lang.Object r2 = r2.get(r1)
            r7 = r2
            android.graphics.Bitmap r7 = (android.graphics.Bitmap) r7
            if (r7 == 0) goto L_0x00dd
            boolean r2 = r7.isRecycled()
            if (r2 != 0) goto L_0x00dd
            a.g.a.b.f r11 = r8.f3372a
            boolean r11 = r11.p
            if (r11 == 0) goto L_0x0093
            java.lang.Object[] r11 = new java.lang.Object[r0]
            r11[r12] = r1
            java.lang.String r1 = "Load image from memory cache [%s]"
            a.e.a.a.r.b.H(r1, r11)
        L_0x0093:
            a.g.a.b.o.a r11 = r4.m
            if (r11 == 0) goto L_0x0098
            r12 = 1
        L_0x0098:
            if (r12 == 0) goto L_0x00d3
            a.g.a.b.i r11 = new a.g.a.b.i
            a.g.a.b.h r12 = r8.f3373b
            java.util.Map<java.lang.String, java.util.concurrent.locks.ReentrantLock> r0 = r12.f
            java.lang.Object r0 = r0.get(r9)
            java.util.concurrent.locks.ReentrantLock r0 = (java.util.concurrent.locks.ReentrantLock) r0
            if (r0 != 0) goto L_0x00b2
            java.util.concurrent.locks.ReentrantLock r0 = new java.util.concurrent.locks.ReentrantLock
            r0.<init>()
            java.util.Map<java.lang.String, java.util.concurrent.locks.ReentrantLock> r12 = r12.f
            r12.put(r9, r0)
        L_0x00b2:
            r12 = r0
            r0 = r11
            r1 = r9
            r2 = r10
            r3 = r6
            r6 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6)
            a.g.a.b.k r9 = new a.g.a.b.k
            a.g.a.b.h r10 = r8.f3373b
            android.os.Handler r12 = new android.os.Handler
            r12.<init>()
            r9.<init>(r10, r7, r11, r12)
            a.g.a.b.h r10 = r8.f3373b
            r10.b()
            java.util.concurrent.ExecutorService r10 = r10.f3392c
            r10.submit(r9)
            goto L_0x01c4
        L_0x00d3:
            a.g.a.b.m.a r11 = r4.n
            r11.a(r7, r10)
            r5.a(r9, r10, r7)
            goto L_0x01c4
        L_0x00dd:
            int r1 = r4.f3358a
            if (r1 == 0) goto L_0x00e3
            r1 = 1
            goto L_0x00e4
        L_0x00e3:
            r1 = 0
        L_0x00e4:
            if (r1 == 0) goto L_0x00e9
            int r11 = r4.f3358a
            goto L_0x010c
        L_0x00e9:
            int r1 = r4.f3359b
            if (r1 == 0) goto L_0x00ef
            r1 = 1
            goto L_0x00f0
        L_0x00ef:
            r1 = 0
        L_0x00f0:
            if (r1 == 0) goto L_0x0111
            a.g.a.a.a.a r11 = r8.c()
            java.io.File r11 = r11.a(r9)
            if (r11 == 0) goto L_0x010a
            a.g.a.a.a.a r11 = r8.c()
            java.io.File r11 = r11.a(r9)
            boolean r11 = r11.exists()
            if (r11 != 0) goto L_0x0188
        L_0x010a:
            int r11 = r4.f3359b
        L_0x010c:
            r10.setImageResource(r11)
            goto L_0x0188
        L_0x0111:
            boolean r1 = r4.o
            if (r1 == 0) goto L_0x011f
            a.g.a.a.a.a r1 = r8.c()
            java.io.File r1 = r1.a(r9)
            if (r1 != 0) goto L_0x012d
        L_0x011f:
            a.g.a.a.a.a r1 = r8.c()
            java.io.File r1 = r1.a(r9)
            boolean r1 = r1.exists()
            if (r1 == 0) goto L_0x0181
        L_0x012d:
            android.graphics.BitmapFactory$Options r11 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x017f }
            r11.<init>()     // Catch:{ Exception -> 0x017f }
            r11.inJustDecodeBounds = r0     // Catch:{ Exception -> 0x017f }
            a.g.a.a.a.a r1 = r8.c()     // Catch:{ Exception -> 0x017f }
            java.io.File r1 = r1.a(r9)     // Catch:{ Exception -> 0x017f }
            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ Exception -> 0x017f }
            android.graphics.BitmapFactory.decodeFile(r1, r11)     // Catch:{ Exception -> 0x017f }
            int r1 = r10.getWidth()     // Catch:{ Exception -> 0x017f }
            int r2 = r10.getHeight()     // Catch:{ Exception -> 0x017f }
            int r3 = r11.outHeight     // Catch:{ Exception -> 0x017f }
            int r7 = r11.outWidth     // Catch:{ Exception -> 0x017f }
            if (r3 > r2) goto L_0x0153
            if (r7 <= r1) goto L_0x0165
        L_0x0153:
            float r0 = (float) r3     // Catch:{ Exception -> 0x017f }
            float r2 = (float) r2     // Catch:{ Exception -> 0x017f }
            float r0 = r0 / r2
            int r0 = java.lang.Math.round(r0)     // Catch:{ Exception -> 0x017f }
            float r2 = (float) r7     // Catch:{ Exception -> 0x017f }
            float r1 = (float) r1     // Catch:{ Exception -> 0x017f }
            float r2 = r2 / r1
            int r1 = java.lang.Math.round(r2)     // Catch:{ Exception -> 0x017f }
            if (r0 >= r1) goto L_0x0164
            goto L_0x0165
        L_0x0164:
            r0 = r1
        L_0x0165:
            r11.inSampleSize = r0     // Catch:{ Exception -> 0x017f }
            r11.inJustDecodeBounds = r12     // Catch:{ Exception -> 0x017f }
            a.g.a.b.m.a r12 = r4.n     // Catch:{ Exception -> 0x017f }
            a.g.a.a.a.a r0 = r8.c()     // Catch:{ Exception -> 0x017f }
            java.io.File r0 = r0.a(r9)     // Catch:{ Exception -> 0x017f }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ Exception -> 0x017f }
            android.graphics.Bitmap r11 = android.graphics.BitmapFactory.decodeFile(r0, r11)     // Catch:{ Exception -> 0x017f }
            r12.a(r11, r10)     // Catch:{ Exception -> 0x017f }
            goto L_0x0188
        L_0x017f:
            goto L_0x0188
        L_0x0181:
            boolean r12 = r4.f3362e
            if (r12 == 0) goto L_0x0188
            r10.setImageBitmap(r11)
        L_0x0188:
            a.g.a.b.i r11 = new a.g.a.b.i
            a.g.a.b.h r12 = r8.f3373b
            java.util.Map<java.lang.String, java.util.concurrent.locks.ReentrantLock> r0 = r12.f
            java.lang.Object r0 = r0.get(r9)
            java.util.concurrent.locks.ReentrantLock r0 = (java.util.concurrent.locks.ReentrantLock) r0
            if (r0 != 0) goto L_0x01a0
            java.util.concurrent.locks.ReentrantLock r0 = new java.util.concurrent.locks.ReentrantLock
            r0.<init>()
            java.util.Map<java.lang.String, java.util.concurrent.locks.ReentrantLock> r12 = r12.f
            r12.put(r9, r0)
        L_0x01a0:
            r12 = r0
            r0 = r11
            r1 = r9
            r2 = r10
            r3 = r6
            r6 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6)
            a.g.a.b.j r9 = new a.g.a.b.j
            a.g.a.b.h r10 = r8.f3373b
            android.os.Handler r12 = new android.os.Handler
            r12.<init>()
            r9.<init>(r10, r11, r12)
            a.g.a.b.h r10 = r8.f3373b
            r10.b()
            java.util.concurrent.ExecutorService r11 = r10.f3393d
            a.g.a.b.g r12 = new a.g.a.b.g
            r12.<init>(r10, r9)
            r11.submit(r12)
        L_0x01c4:
            return
        L_0x01c5:
            a.g.a.b.h r1 = r8.f3373b
            java.util.Map<java.lang.Integer, java.lang.String> r1 = r1.f3394e
            int r2 = r10.hashCode()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.remove(r2)
            r5.b(r9, r10)
            int r1 = r4.f3360c
            if (r1 == 0) goto L_0x01dc
            r12 = 1
        L_0x01dc:
            if (r12 == 0) goto L_0x01e4
            int r12 = r4.f3360c
            r10.setImageResource(r12)
            goto L_0x01e7
        L_0x01e4:
            r10.setImageBitmap(r11)
        L_0x01e7:
            r5.a(r9, r10, r11)
            return
        L_0x01eb:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Wrong arguments were passed to displayImage() method (ImageView reference are required)"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: a.g.a.b.d.b(java.lang.String, android.widget.ImageView, a.g.a.b.b, a.g.a.b.l.c):void");
    }

    public a.g.a.a.a.a c() {
        a();
        return this.f3372a.l;
    }

    public final int d(Object obj, String str) {
        try {
            Field declaredField = ImageView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            int intValue = ((Integer) declaredField.get(obj)).intValue();
            if (intValue <= 0 || intValue >= Integer.MAX_VALUE) {
                return 0;
            }
            return intValue;
        } catch (Exception e2) {
            a.e.a.a.r.b.k(e2);
        }
    }

    public String f() {
        f fVar = this.f3372a;
        if (fVar == null) {
            return null;
        }
        return fVar.r;
    }

    public synchronized void g(f fVar) {
        if (this.f3372a == null) {
            this.f3373b = new h(fVar);
            this.f3372a = fVar;
        }
    }

    public void h(String str, c cVar) {
        a();
        f fVar = this.f3372a;
        int i = fVar.f3379b;
        int i2 = fVar.f3380c;
        b bVar = fVar.n;
        if (!(bVar.n instanceof b)) {
            b.C0080b bVar2 = new b.C0080b();
            bVar2.f3363a = bVar.f3358a;
            bVar2.f3364b = bVar.f3359b;
            bVar2.f3365c = bVar.f3360c;
            bVar2.f3367e = bVar.f3362e;
            bVar2.f = bVar.f;
            bVar2.g = bVar.g;
            bVar2.i = bVar.h;
            bVar2.j = bVar.i;
            bVar2.k = bVar.j;
            bVar2.o = bVar.n;
            bVar2.h = bVar.o;
            bVar2.o = this.f3375d;
            bVar = bVar2.b();
        }
        ImageView imageView = new ImageView(this.f3372a.f3378a);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(i, i2));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        b(str, imageView, bVar, cVar);
    }
}
