package a.i.a;

import a.i.a.t;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public final class d0 extends a<c0> {
    public d0(t tVar, c0 c0Var, w wVar, int i, int i2, Drawable drawable, String str, Object obj, int i3) {
        super(tVar, c0Var, wVar, i, i2, i3, (Drawable) null, str, (Object) null, false);
    }

    public void b(Bitmap bitmap, t.d dVar) {
        c0 c0Var = (c0) d();
        if (c0Var != null) {
            c0Var.c(bitmap, dVar);
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Target callback must not recycle bitmap!");
            }
        }
    }

    public void c() {
        c0 c0Var = (c0) d();
        if (c0Var != null) {
            c0Var.a(this.g != 0 ? this.f3571a.f3657e.getResources().getDrawable(this.g) : this.h);
        }
    }
}
