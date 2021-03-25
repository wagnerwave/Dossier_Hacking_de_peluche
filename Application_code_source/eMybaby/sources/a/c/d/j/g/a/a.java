package a.c.d.j.g.a;

import android.view.View;
import com.cuatroochenta.miniland.humidificador.test.widget.NumberPicker;
import com.sozpic.miniland.R;

public class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NumberPicker f294a;

    public a(NumberPicker numberPicker) {
        this.f294a = numberPicker;
    }

    public void onClick(View view) {
        NumberPicker numberPicker;
        boolean z;
        this.f294a.k();
        this.f294a.f3912e.clearFocus();
        if (view.getId() == R.id.np__increment) {
            numberPicker = this.f294a;
            z = true;
        } else {
            numberPicker = this.f294a;
            z = false;
        }
        numberPicker.d(z);
    }
}
