package a.i.a;

import a.i.a.t;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class l extends a<ImageView> {
    public e m;

    public l(t tVar, ImageView imageView, w wVar, int i, int i2, int i3, Drawable drawable, String str, Object obj, e eVar, boolean z) {
        super(tVar, imageView, wVar, i, i2, i3, (Drawable) null, str, (Object) null, z);
        this.m = eVar;
    }

    public void a() {
        this.l = true;
        if (this.m != null) {
            this.m = null;
        }
    }

    public void b(Bitmap bitmap, t.d dVar) {
        ImageView imageView = (ImageView) this.f3573c.get();
        if (imageView != null) {
            t tVar = this.f3571a;
            Bitmap bitmap2 = bitmap;
            t.d dVar2 = dVar;
            u.b(imageView, tVar.f3657e, bitmap2, dVar2, this.f3574d, tVar.m);
            e eVar = this.m;
            if (eVar != null) {
                eVar.onSuccess();
            }
        }
    }

    public void c() {
        ImageView imageView = (ImageView) this.f3573c.get();
        if (imageView != null) {
            int i = this.g;
            if (i != 0) {
                imageView.setImageResource(i);
            } else {
                Drawable drawable = this.h;
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                }
            }
            e eVar = this.m;
            if (eVar != null) {
                eVar.a();
            }
        }
    }
}
