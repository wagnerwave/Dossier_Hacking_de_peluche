package a.c.d.h;

import a.c.a.d.a;
import a.c.d.s.b.b.c;
import android.widget.Toast;
import com.cuatroochenta.miniland.emyscale.MyScaleStatisticsActivity;
import com.sozpic.miniland.R;

public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f140a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MyScaleStatisticsActivity f141b;

    public f(MyScaleStatisticsActivity myScaleStatisticsActivity, c cVar) {
        this.f141b = myScaleStatisticsActivity;
        this.f140a = cVar;
    }

    public void run() {
        String str;
        this.f141b.o();
        c cVar = this.f140a;
        if (cVar == null || !cVar.f42a.booleanValue()) {
            if (!a.j(this.f140a.f43b)) {
                str = this.f140a.f43b;
            } else {
                str = a.h(R.string.TR_DELETE_WEIGHT_KO);
            }
            Toast.makeText(this.f141b, str, 0).show();
            return;
        }
        this.f141b.t();
    }
}
