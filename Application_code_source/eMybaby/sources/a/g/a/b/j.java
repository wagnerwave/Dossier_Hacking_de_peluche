package a.g.a.b;

import a.g.a.b.l.c;
import a.g.a.b.l.e;
import a.g.a.b.l.i;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.ImageView;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final h f3400a;

    /* renamed from: b  reason: collision with root package name */
    public final i f3401b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f3402c;

    /* renamed from: d  reason: collision with root package name */
    public final f f3403d;

    /* renamed from: e  reason: collision with root package name */
    public final a.g.a.b.n.b f3404e;
    public final a.g.a.b.n.b f;
    public final boolean g;
    public final String h;
    public final String i;
    public final ImageView j;
    public final e k;
    public final b l;
    public final c m;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            j jVar = j.this;
            jVar.m.d(jVar.h, jVar.j);
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.g.a.b.l.a f3406a;

        public b(a.g.a.b.l.a aVar) {
            this.f3406a = aVar;
        }

        public void run() {
            if (j.this.l.f3361d != 0) {
                j jVar = j.this;
                jVar.j.setImageResource(jVar.l.f3361d);
            }
            j jVar2 = j.this;
            jVar2.m.c(jVar2.h, jVar2.j, this.f3406a);
        }
    }

    public j(h hVar, i iVar, Handler handler) {
        this.f3400a = hVar;
        this.f3401b = iVar;
        this.f3402c = handler;
        f fVar = hVar.f3390a;
        this.f3403d = fVar;
        this.f3404e = fVar.m;
        this.f = fVar.q;
        this.g = fVar.p;
        this.h = iVar.f3395a;
        this.i = iVar.f3396b;
        this.j = iVar.f3397c;
        this.k = iVar.f3398d;
        this.l = iVar.f3399e;
        this.m = iVar.f;
    }

    public final boolean a() {
        boolean interrupted = Thread.interrupted();
        if (interrupted) {
            Object[] objArr = {this.i};
            if (this.g) {
                a.e.a.a.r.b.H("Task was interrupted [%s]", objArr);
            }
        }
        return interrupted;
    }

    public final boolean b() {
        boolean z = !this.i.equals(this.f3400a.f3394e.get(Integer.valueOf(this.j.hashCode())));
        if (z) {
            this.f3402c.post(new a());
        }
        if (z) {
            Object[] objArr = {this.i};
            if (this.g) {
                a.e.a.a.r.b.H("ImageView is reused for another image. Task is cancelled. [%s]", objArr);
            }
        }
        return z;
    }

    public Bitmap c(URI uri) {
        if (this.f3403d.i) {
            c cVar = new c(uri, e(), this.l);
            cVar.f3371d = this.g;
            int i2 = 1;
            while (i2 <= 3) {
                try {
                    return cVar.a(this.k, this.l.h, i.f(this.j));
                } catch (OutOfMemoryError e2) {
                    a.e.a.a.r.b.k(e2);
                    if (i2 != 1) {
                        if (i2 == 2) {
                            this.f3403d.k.clear();
                        } else if (i2 != 3) {
                            SystemClock.sleep((long) (i2 * 1000));
                            i2++;
                        } else {
                            throw e2;
                        }
                    }
                    System.gc();
                    SystemClock.sleep((long) (i2 * 1000));
                    i2++;
                }
            }
            return null;
        }
        c cVar2 = new c(uri, e(), this.l);
        cVar2.f3371d = this.g;
        return cVar2.a(this.k, this.l.h, i.f(this.j));
    }

    public final void d(a.g.a.b.l.a aVar) {
        if (!Thread.interrupted()) {
            this.f3402c.post(new b(aVar));
        }
    }

    public final a.g.a.b.n.b e() {
        return this.f3400a.h.get() ? this.f : this.f3404e;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:30|31|32|33|47) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:37|38|39|40|41) */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x008e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x009a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(java.io.File r7) {
        /*
            r6 = this;
            java.io.File r0 = r7.getParentFile()
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x000d
            r0.mkdirs()
        L_0x000d:
            a.g.a.b.f r0 = r6.f3403d
            int r1 = r0.f3381d
            int r0 = r0.f3382e
            r2 = 8192(0x2000, float:1.14794E-41)
            if (r1 > 0) goto L_0x0019
            if (r0 <= 0) goto L_0x0064
        L_0x0019:
            a.g.a.b.l.e r3 = new a.g.a.b.l.e
            r3.<init>(r1, r0)
            a.g.a.b.c r0 = new a.g.a.b.c
            java.net.URI r1 = new java.net.URI
            java.lang.String r4 = r6.h
            r1.<init>(r4)
            a.g.a.b.n.b r4 = r6.e()
            a.g.a.b.b r5 = r6.l
            r0.<init>(r1, r4, r5)
            boolean r1 = r6.g
            r0.f3371d = r1
            a.g.a.b.l.d r1 = a.g.a.b.l.d.IN_SAMPLE_INT
            a.g.a.b.l.i r4 = a.g.a.b.l.i.FIT_INSIDE
            android.graphics.Bitmap r0 = r0.a(r3, r1, r4)
            if (r0 == 0) goto L_0x0064
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream
            java.io.FileOutputStream r3 = new java.io.FileOutputStream
            r3.<init>(r7)
            r1.<init>(r3, r2)
            a.g.a.b.f r3 = r6.f3403d     // Catch:{ all -> 0x005f }
            android.graphics.Bitmap$CompressFormat r3 = r3.f     // Catch:{ all -> 0x005f }
            a.g.a.b.f r4 = r6.f3403d     // Catch:{ all -> 0x005f }
            int r4 = r4.g     // Catch:{ all -> 0x005f }
            boolean r3 = r0.compress(r3, r4, r1)     // Catch:{ all -> 0x005f }
            r1.close()     // Catch:{ Exception -> 0x0058 }
            goto L_0x0059
        L_0x0058:
        L_0x0059:
            if (r3 == 0) goto L_0x0064
            r0.recycle()
            return
        L_0x005f:
            r7 = move-exception
            r1.close()     // Catch:{ Exception -> 0x0063 }
        L_0x0063:
            throw r7
        L_0x0064:
            a.g.a.b.n.b r0 = r6.e()
            java.net.URI r1 = new java.net.URI
            java.lang.String r3 = r6.h
            r1.<init>(r3)
            a.g.a.b.b r3 = r6.l
            java.lang.Object r3 = r3.k
            java.io.InputStream r0 = r0.a(r1, r3)
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x009b }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x009b }
            r3.<init>(r7)     // Catch:{ all -> 0x009b }
            r1.<init>(r3, r2)     // Catch:{ all -> 0x009b }
            byte[] r7 = new byte[r2]     // Catch:{ all -> 0x0096 }
        L_0x0083:
            r3 = 0
            int r4 = r0.read(r7, r3, r2)     // Catch:{ all -> 0x0096 }
            r5 = -1
            if (r4 != r5) goto L_0x0092
            r1.close()     // Catch:{ Exception -> 0x008e }
        L_0x008e:
            r0.close()     // Catch:{ Exception -> 0x0091 }
        L_0x0091:
            return
        L_0x0092:
            r1.write(r7, r3, r4)     // Catch:{ all -> 0x0096 }
            goto L_0x0083
        L_0x0096:
            r7 = move-exception
            r1.close()     // Catch:{ Exception -> 0x009a }
        L_0x009a:
            throw r7     // Catch:{ all -> 0x009b }
        L_0x009b:
            r7 = move-exception
            r0.close()     // Catch:{ Exception -> 0x009f }
        L_0x009f:
            goto L_0x00a1
        L_0x00a0:
            throw r7
        L_0x00a1:
            goto L_0x00a0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.g.a.b.j.f(java.io.File):void");
    }

    public final Bitmap g() {
        a.g.a.b.l.a aVar;
        URI uri;
        a.g.a.b.l.a aVar2 = a.g.a.b.l.a.IO_ERROR;
        a.g.a.a.a.a aVar3 = this.f3403d.l;
        File a2 = aVar3.a(this.h);
        Bitmap bitmap = null;
        try {
            if (a2.exists()) {
                Object[] objArr = {this.i};
                if (this.g) {
                    a.e.a.a.r.b.H("Load image from disc cache [%s]", objArr);
                }
                Bitmap c2 = c(a2.toURI());
                if (c2 != null) {
                    return c2;
                }
            }
            Object[] objArr2 = {this.i};
            if (this.g) {
                a.e.a.a.r.b.H("Load image from Internet [%s]", objArr2);
            }
            if (this.l.g) {
                Object[] objArr3 = {this.i};
                if (this.g) {
                    a.e.a.a.r.b.H("Cache image on disc [%s]", objArr3);
                }
                f(a2);
                aVar3.b(this.h, a2);
                uri = a2.toURI();
            } else {
                uri = new URI(this.h);
            }
            bitmap = c(uri);
            if (bitmap == null) {
                if (a2.exists()) {
                    a2.delete();
                }
                d(aVar2);
            }
        } catch (IllegalStateException unused) {
            aVar = a.g.a.b.l.a.NETWORK_DENIED;
            d(aVar);
        } catch (UnsupportedOperationException e2) {
            a.e.a.a.r.b.k(e2);
            aVar = a.g.a.b.l.a.UNSUPPORTED_URI_SCHEME;
            d(aVar);
        } catch (IOException e3) {
            a.e.a.a.r.b.k(e3);
            d(aVar2);
            if (a2.exists()) {
                a2.delete();
            }
        } catch (OutOfMemoryError e4) {
            a.e.a.a.r.b.k(e4);
            aVar = a.g.a.b.l.a.OUT_OF_MEMORY;
            d(aVar);
        } catch (Throwable th) {
            a.e.a.a.r.b.k(th);
            aVar = a.g.a.b.l.a.UNKNOWN;
            d(aVar);
        }
        return bitmap;
    }

    public void run() {
        AtomicBoolean atomicBoolean = this.f3400a.g;
        if (atomicBoolean.get()) {
            synchronized (atomicBoolean) {
                Object[] objArr = {this.i};
                if (this.g) {
                    a.e.a.a.r.b.H("ImageLoader is paused. Waiting...  [%s]", objArr);
                }
                try {
                    atomicBoolean.wait();
                    Object[] objArr2 = {this.i};
                    if (this.g) {
                        a.e.a.a.r.b.H(".. Resume loading [%s]", objArr2);
                    }
                } catch (InterruptedException unused) {
                    a.e.a.a.r.b.O(6, (Throwable) null, "Task was interrupted [%s]", this.i);
                    return;
                }
            }
        }
        if (!b()) {
            if (this.l.j > 0) {
                Object[] objArr3 = {Integer.valueOf(this.l.j), this.i};
                if (this.g) {
                    a.e.a.a.r.b.H("Delay %d ms before loading...  [%s]", objArr3);
                }
                try {
                    Thread.sleep((long) this.l.j);
                    if (b()) {
                        return;
                    }
                } catch (InterruptedException unused2) {
                    a.e.a.a.r.b.O(6, (Throwable) null, "Task was interrupted [%s]", this.i);
                    return;
                }
            }
            ReentrantLock reentrantLock = this.f3401b.g;
            Object[] objArr4 = {this.i};
            if (this.g) {
                a.e.a.a.r.b.H("Start display image task [%s]", objArr4);
            }
            if (reentrantLock.isLocked()) {
                Object[] objArr5 = {this.i};
                if (this.g) {
                    a.e.a.a.r.b.H("Image already is loading. Waiting... [%s]", objArr5);
                }
            }
            reentrantLock.lock();
            try {
                if (!b()) {
                    Bitmap bitmap = this.f3403d.k.get(this.i);
                    if (bitmap == null) {
                        bitmap = g();
                        if (bitmap == null) {
                            reentrantLock.unlock();
                            return;
                        }
                        if (!b()) {
                            if (!a()) {
                                if (this.l.l != null) {
                                    Object[] objArr6 = {this.i};
                                    if (this.g) {
                                        a.e.a.a.r.b.H("PreProcess image before caching in memory [%s]", objArr6);
                                    }
                                    bitmap = this.l.l.a(bitmap);
                                }
                                if (this.l.f) {
                                    Object[] objArr7 = {this.i};
                                    if (this.g) {
                                        a.e.a.a.r.b.H("Cache image in memory [%s]", objArr7);
                                    }
                                    this.f3403d.k.put(this.i, bitmap);
                                }
                            }
                        }
                        reentrantLock.unlock();
                        return;
                    }
                    Object[] objArr8 = {this.i};
                    if (this.g) {
                        a.e.a.a.r.b.H("...Get cached bitmap from memory after waiting. [%s]", objArr8);
                    }
                    if (this.l.m != null) {
                        Object[] objArr9 = {this.i};
                        if (this.g) {
                            a.e.a.a.r.b.H("PostProcess image before displaying [%s]", objArr9);
                        }
                        bitmap = this.l.m.a(bitmap);
                    }
                    reentrantLock.unlock();
                    if (!b() && !a()) {
                        a aVar = new a(bitmap, this.f3401b, this.f3400a);
                        aVar.h = this.g;
                        this.f3402c.post(aVar);
                    }
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}
