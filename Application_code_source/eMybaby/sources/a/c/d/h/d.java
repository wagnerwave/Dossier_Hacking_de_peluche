package a.c.d.h;

import android.app.Dialog;
import android.view.View;
import com.cuatroochenta.miniland.emyscale.MyScaleStatisticsActivity;

public class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Dialog f136a;

    public d(MyScaleStatisticsActivity myScaleStatisticsActivity, Dialog dialog) {
        this.f136a = dialog;
    }

    public void onClick(View view) {
        this.f136a.dismiss();
    }
}
