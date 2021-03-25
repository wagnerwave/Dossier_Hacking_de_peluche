package a.c.d.r.k;

import android.view.View;

public class c implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f809a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f810b;

    public c(f fVar, int i) {
        this.f810b = fVar;
        this.f809a = i;
    }

    public boolean onLongClick(View view) {
        f fVar = this.f810b;
        if (!fVar.f) {
            f.e(fVar);
        }
        this.f810b.i(this.f809a);
        return true;
    }
}
