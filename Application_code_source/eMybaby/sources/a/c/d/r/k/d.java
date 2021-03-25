package a.c.d.r.k;

import android.view.View;

public class d implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f811a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f812b;

    public d(f fVar, int i) {
        this.f812b = fVar;
        this.f811a = i;
    }

    public boolean onLongClick(View view) {
        f fVar = this.f812b;
        if (!fVar.f) {
            f.e(fVar);
        }
        this.f812b.i(this.f811a);
        return true;
    }
}
