package a.i.a;

import a.i.a.t;
import a.i.a.w;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class x {
    public static final AtomicInteger f = new AtomicInteger();

    /* renamed from: a  reason: collision with root package name */
    public final t f3687a;

    /* renamed from: b  reason: collision with root package name */
    public final w.b f3688b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3689c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3690d = true;

    /* renamed from: e  reason: collision with root package name */
    public int f3691e;

    public x(t tVar, Uri uri, int i) {
        this.f3687a = tVar;
        this.f3688b = new w.b(uri, i, tVar.l);
    }

    public final w a(long j) {
        long j2 = j;
        int andIncrement = f.getAndIncrement();
        w.b bVar = this.f3688b;
        if (bVar.f == null) {
            bVar.f = t.e.NORMAL;
        }
        w wVar = new w(bVar.f3682a, bVar.f3683b, (String) null, (List) null, bVar.f3684c, bVar.f3685d, false, false, false, 0.0f, 0.0f, 0.0f, false, bVar.f3686e, bVar.f, (w.a) null);
        wVar.f3677a = andIncrement;
        wVar.f3678b = j2;
        boolean z = this.f3687a.n;
        if (z) {
            g0.p("Main", "created", wVar.d(), wVar.toString());
        }
        if (((t.f.a) this.f3687a.f3654b) != null) {
            if (wVar != wVar) {
                wVar.f3677a = andIncrement;
                wVar.f3678b = j2;
                if (z) {
                    String b2 = wVar.b();
                    g0.p("Main", "changed", b2, "into " + wVar);
                }
            }
            return wVar;
        }
        throw null;
    }

    public void b(ImageView imageView, e eVar) {
        Bitmap e2;
        t.d dVar = t.d.MEMORY;
        long nanoTime = System.nanoTime();
        g0.c();
        if (imageView != null) {
            w.b bVar = this.f3688b;
            boolean z = true;
            if (!((bVar.f3682a == null && bVar.f3683b == 0) ? false : true)) {
                this.f3687a.a(imageView);
                if (this.f3690d) {
                    u.c(imageView, (Drawable) null);
                    return;
                }
                return;
            }
            if (this.f3689c) {
                w.b bVar2 = this.f3688b;
                if (bVar2.f3684c == 0 && bVar2.f3685d == 0) {
                    z = false;
                }
                if (!z) {
                    int width = imageView.getWidth();
                    int height = imageView.getHeight();
                    if (width == 0 || height == 0) {
                        if (this.f3690d) {
                            u.c(imageView, (Drawable) null);
                        }
                        this.f3687a.j.put(imageView, new h(this, imageView, eVar));
                        return;
                    }
                    this.f3688b.a(width, height);
                } else {
                    throw new IllegalStateException("Fit cannot be used with resize.");
                }
            }
            w a2 = a(nanoTime);
            String h = g0.h(a2);
            if (!p.f(0) || (e2 = this.f3687a.e(h)) == null) {
                if (this.f3690d) {
                    u.c(imageView, (Drawable) null);
                }
                this.f3687a.c(new l(this.f3687a, imageView, a2, 0, 0, this.f3691e, (Drawable) null, h, (Object) null, eVar, false));
                return;
            }
            this.f3687a.a(imageView);
            t tVar = this.f3687a;
            u.b(imageView, tVar.f3657e, e2, dVar, false, tVar.m);
            if (this.f3687a.n) {
                String d2 = a2.d();
                g0.p("Main", "completed", d2, "from " + dVar);
            }
            if (eVar != null) {
                eVar.onSuccess();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Target must not be null.");
    }

    public void c(c0 c0Var) {
        Bitmap e2;
        long nanoTime = System.nanoTime();
        g0.c();
        if (c0Var == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (!this.f3689c) {
            w.b bVar = this.f3688b;
            if (!((bVar.f3682a == null && bVar.f3683b == 0) ? false : true)) {
                this.f3687a.a(c0Var);
                c0Var.b((Drawable) null);
                return;
            }
            w a2 = a(nanoTime);
            String h = g0.h(a2);
            if (!p.f(0) || (e2 = this.f3687a.e(h)) == null) {
                c0Var.b((Drawable) null);
                this.f3687a.c(new d0(this.f3687a, c0Var, a2, 0, 0, (Drawable) null, h, (Object) null, this.f3691e));
                return;
            }
            this.f3687a.a(c0Var);
            c0Var.c(e2, t.d.MEMORY);
        } else {
            throw new IllegalStateException("Fit cannot be used with a Target.");
        }
    }
}
