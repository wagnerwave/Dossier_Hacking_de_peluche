package a.c.d.m.e.l;

import android.view.View;
import com.cuatroochenta.miniland.pregnancy.baby.ultrasound.UltrasoundFormActivity;

public class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UltrasoundFormActivity f413a;

    public e(UltrasoundFormActivity ultrasoundFormActivity) {
        this.f413a = ultrasoundFormActivity;
    }

    public void onClick(View view) {
        this.f413a.setResult(0);
        this.f413a.finish();
    }
}
