package a.c.d.m.i.k;

import android.view.View;
import android.widget.ImageView;

public class g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f583a;

    public g(e eVar) {
        this.f583a = eVar;
    }

    public void onClick(View view) {
        boolean z = !((Boolean) view.getTag()).booleanValue();
        e.D(this.f583a, (ImageView) view, z);
        if (!z) {
            e eVar = this.f583a;
            e.D(eVar, eVar.w, false);
        }
    }
}
