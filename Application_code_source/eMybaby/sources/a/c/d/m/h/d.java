package a.c.d.m.h;

import a.c.a.d.a;
import a.c.a.e.f;
import a.c.d.r.j;
import android.os.SystemClock;
import android.view.View;
import com.cuatroochenta.miniland.pregnancy.escuchalatidos.PregnancyBTService;
import com.cuatroochenta.miniland.pregnancy.escuchalatidos.PregnancyEscuchaLatidosActivity;
import com.sozpic.miniland.R;
import java.util.Calendar;

public class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PregnancyEscuchaLatidosActivity f492a;

    public d(PregnancyEscuchaLatidosActivity pregnancyEscuchaLatidosActivity) {
        this.f492a = pregnancyEscuchaLatidosActivity;
    }

    public void onClick(View view) {
        PregnancyEscuchaLatidosActivity pregnancyEscuchaLatidosActivity = this.f492a;
        if (pregnancyEscuchaLatidosActivity.n == 1) {
            PregnancyBTService pregnancyBTService = pregnancyEscuchaLatidosActivity.v;
            if (pregnancyBTService == null || !pregnancyBTService.m) {
                return;
            }
            if (pregnancyBTService.f) {
                pregnancyBTService.b();
                pregnancyEscuchaLatidosActivity.A.setRecordingMode(false);
                return;
            }
            f.c().d("MI_EMBARAZO", "SWEETBEAT_RECORD", "");
            pregnancyEscuchaLatidosActivity.v.c();
            pregnancyEscuchaLatidosActivity.q = Calendar.getInstance().getTime();
            pregnancyEscuchaLatidosActivity.m.setVisibility(0);
            pregnancyEscuchaLatidosActivity.m.setText(j.i.format(pregnancyEscuchaLatidosActivity.q));
            pregnancyEscuchaLatidosActivity.w.setText(a.h(R.string.TR_STOP));
            pregnancyEscuchaLatidosActivity.f4024e.setVisibility(0);
            pregnancyEscuchaLatidosActivity.f.setVisibility(0);
            pregnancyEscuchaLatidosActivity.A.setRecordingMode(true);
            pregnancyEscuchaLatidosActivity.f4023d.setVisibility(0);
            pregnancyEscuchaLatidosActivity.f4023d.setBase(SystemClock.elapsedRealtime());
            pregnancyEscuchaLatidosActivity.f4023d.start();
            return;
        }
        pregnancyEscuchaLatidosActivity.s();
    }
}
