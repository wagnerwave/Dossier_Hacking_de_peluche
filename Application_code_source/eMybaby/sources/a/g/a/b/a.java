package a.g.a.b;

import a.e.a.a.r.b;
import a.g.a.b.l.c;
import android.graphics.Bitmap;
import android.widget.ImageView;

public final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final Bitmap f3353a;

    /* renamed from: b  reason: collision with root package name */
    public final String f3354b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f3355c;

    /* renamed from: d  reason: collision with root package name */
    public final String f3356d;

    /* renamed from: e  reason: collision with root package name */
    public final a.g.a.b.m.a f3357e;
    public final c f;
    public final h g;
    public boolean h;

    public a(Bitmap bitmap, i iVar, h hVar) {
        this.f3353a = bitmap;
        this.f3354b = iVar.f3395a;
        this.f3355c = iVar.f3397c;
        this.f3356d = iVar.f3396b;
        this.f3357e = iVar.f3399e.n;
        this.f = iVar.f;
        this.g = hVar;
    }

    public void run() {
        h hVar = this.g;
        ImageView imageView = this.f3355c;
        if (!this.f3356d.equals(hVar.f3394e.get(Integer.valueOf(imageView.hashCode())))) {
            if (this.h) {
                b.H("ImageView is reused for another image. Task is cancelled. [%s]", this.f3356d);
            }
            this.f.d(this.f3354b, this.f3355c);
            return;
        }
        if (this.h) {
            b.H("Display image in ImageView [%s]", this.f3356d);
        }
        this.f.a(this.f3354b, this.f3355c, this.f3357e.a(this.f3353a, this.f3355c));
        this.g.f3394e.remove(Integer.valueOf(this.f3355c.hashCode()));
    }
}
