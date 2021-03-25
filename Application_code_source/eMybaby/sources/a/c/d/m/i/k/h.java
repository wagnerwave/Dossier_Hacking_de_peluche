package a.c.d.m.i.k;

import android.view.View;
import android.widget.ImageView;

public class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f587a;

    public h(e eVar) {
        this.f587a = eVar;
    }

    public void onClick(View view) {
        boolean z = !((Boolean) view.getTag()).booleanValue();
        e.D(this.f587a, (ImageView) view, z);
        if (z) {
            e eVar = this.f587a;
            e.D(eVar, eVar.v, true);
        }
    }
}
