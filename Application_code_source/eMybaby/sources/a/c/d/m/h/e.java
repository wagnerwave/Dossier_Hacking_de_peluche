package a.c.d.m.h;

import android.view.View;
import com.cuatroochenta.miniland.model.TimeData;
import com.cuatroochenta.miniland.pregnancy.customs.FhrView;
import com.cuatroochenta.miniland.pregnancy.escuchalatidos.PregnancyEscuchaLatidosActivity;
import java.util.LinkedList;

public class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PregnancyEscuchaLatidosActivity f493a;

    public e(PregnancyEscuchaLatidosActivity pregnancyEscuchaLatidosActivity) {
        this.f493a = pregnancyEscuchaLatidosActivity;
    }

    public void onClick(View view) {
        PregnancyEscuchaLatidosActivity pregnancyEscuchaLatidosActivity = this.f493a;
        int i = pregnancyEscuchaLatidosActivity.o + 1;
        pregnancyEscuchaLatidosActivity.o = i;
        pregnancyEscuchaLatidosActivity.f4022c.setText(String.valueOf(i));
        FhrView fhrView = this.f493a.A;
        if (fhrView.r && fhrView.q.size() > 0) {
            LinkedList<TimeData> linkedList = fhrView.q;
            linkedList.get(linkedList.size() - 1).setFetalMovement(true);
        }
        if (fhrView.p.size() > 0) {
            LinkedList<TimeData> linkedList2 = fhrView.p;
            linkedList2.get(linkedList2.size() - 1).setFetalMovement(true);
        }
    }
}
