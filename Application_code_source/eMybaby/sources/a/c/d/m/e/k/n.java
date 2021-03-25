package a.c.d.m.e.k;

import android.content.Intent;
import android.view.View;
import com.cuatroochenta.miniland.pregnancy.baby.medicalData.MedicalDataFormActivity;

public class n implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o f391a;

    public n(o oVar) {
        this.f391a = oVar;
    }

    public void onClick(View view) {
        o oVar = this.f391a;
        oVar.startActivityForResult(new Intent(oVar.getActivity(), MedicalDataFormActivity.class), 4293);
    }
}
