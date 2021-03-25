package a.c.d.m.h;

import a.a.a.a.a;
import a.c.a.f.e;
import android.widget.SeekBar;
import com.cuatroochenta.miniland.pregnancy.escuchalatidos.PregnancyEscuchaLatidosActivity;

public class c implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PregnancyEscuchaLatidosActivity f491a;

    public c(PregnancyEscuchaLatidosActivity pregnancyEscuchaLatidosActivity) {
        this.f491a = pregnancyEscuchaLatidosActivity;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        StringBuilder n = a.n("Set Volume value to:");
        n.append(seekBar.getProgress());
        e.b(n.toString());
        this.f491a.B.setStreamVolume(3, seekBar.getProgress(), 4);
    }
}
