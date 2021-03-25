package a.c.d.h;

import a.c.a.d.a;
import a.c.d.s.b.b.b;
import a.c.d.s.b.b.e;
import android.app.Dialog;
import android.view.View;
import com.cuatroochenta.miniland.emyscale.MyScaleStatisticsActivity;
import com.cuatroochenta.miniland.model.Measure;
import com.sozpic.miniland.R;

public class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Measure f137a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Dialog f138b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MyScaleStatisticsActivity f139c;

    public e(MyScaleStatisticsActivity myScaleStatisticsActivity, Measure measure, Dialog dialog) {
        this.f139c = myScaleStatisticsActivity;
        this.f137a = measure;
        this.f138b = dialog;
    }

    public void onClick(View view) {
        this.f139c.p(a.h(R.string.TR_DELETING_WEIGHT), true);
        a.c.d.s.b.b.e eVar = new a.c.d.s.b.b.e();
        eVar.f871b = "https://emybaby.com/api/fichamedica.php";
        new e.a(new b(this.f137a), this.f139c).start();
        this.f138b.dismiss();
    }
}
