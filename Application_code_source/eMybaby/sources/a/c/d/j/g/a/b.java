package a.c.d.j.g.a;

import android.view.View;
import com.cuatroochenta.miniland.humidificador.test.widget.NumberPicker;
import com.sozpic.miniland.R;

public class b implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NumberPicker f295a;

    public b(NumberPicker numberPicker) {
        this.f295a = numberPicker;
    }

    public boolean onLongClick(View view) {
        this.f295a.k();
        this.f295a.f3912e.clearFocus();
        if (view.getId() == R.id.np__increment) {
            this.f295a.q(true, 0);
        } else {
            this.f295a.q(false, 0);
        }
        return true;
    }
}
