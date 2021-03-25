package a.g.a.b;

import a.e.a.a.r.b;
import android.graphics.Bitmap;
import android.os.Handler;

public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final h f3408a;

    /* renamed from: b  reason: collision with root package name */
    public final Bitmap f3409b;

    /* renamed from: c  reason: collision with root package name */
    public final i f3410c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f3411d;

    public k(h hVar, Bitmap bitmap, i iVar, Handler handler) {
        this.f3408a = hVar;
        this.f3409b = bitmap;
        this.f3410c = iVar;
        this.f3411d = handler;
    }

    public void run() {
        if (this.f3408a.f3390a.p) {
            b.H("PostProcess image before displaying [%s]", this.f3410c.f3396b);
        }
        Bitmap a2 = this.f3410c.f3399e.m.a(this.f3409b);
        Bitmap bitmap = this.f3409b;
        if (a2 != bitmap) {
            bitmap.recycle();
        }
        this.f3411d.post(new a(a2, this.f3410c, this.f3408a));
    }
}
