package a.c.d.m.e;

import android.content.Intent;
import android.view.View;
import com.cuatroochenta.miniland.pregnancy.baby.MyPregnancyActivity;
import com.cuatroochenta.miniland.pregnancy.baby.ultrasound.UltrasoundFormActivity;

public class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MyPregnancyActivity f341a;

    public a(MyPregnancyActivity myPregnancyActivity) {
        this.f341a = myPregnancyActivity;
    }

    public void onClick(View view) {
        MyPregnancyActivity myPregnancyActivity = this.f341a;
        myPregnancyActivity.startActivityForResult(new Intent(myPregnancyActivity, UltrasoundFormActivity.class), 9342);
    }
}
