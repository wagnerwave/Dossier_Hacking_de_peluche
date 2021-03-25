package a.c.d.m.e.k;

import android.view.View;
import com.cuatroochenta.miniland.pregnancy.baby.medicalData.MedicalDataFormActivity;

public class l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MedicalDataFormActivity f390a;

    public l(MedicalDataFormActivity medicalDataFormActivity) {
        this.f390a = medicalDataFormActivity;
    }

    public void onClick(View view) {
        this.f390a.setResult(0);
        this.f390a.finish();
    }
}
