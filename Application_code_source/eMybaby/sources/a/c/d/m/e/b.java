package a.c.d.m.e;

import android.content.Intent;
import android.view.View;
import com.cuatroochenta.miniland.pregnancy.baby.MyPregnancyActivity;
import com.cuatroochenta.miniland.pregnancy.baby.medicalData.MedicalDataFormActivity;

public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MyPregnancyActivity f342a;

    public b(MyPregnancyActivity myPregnancyActivity) {
        this.f342a = myPregnancyActivity;
    }

    public void onClick(View view) {
        MyPregnancyActivity myPregnancyActivity = this.f342a;
        myPregnancyActivity.startActivityForResult(new Intent(myPregnancyActivity, MedicalDataFormActivity.class), 4823);
    }
}
