package a.c.d.m.e.k;

import android.content.DialogInterface;
import com.cuatroochenta.miniland.pregnancy.baby.medicalData.MedicalDataFormActivity;

public class m implements DialogInterface.OnClickListener {
    public m(MedicalDataFormActivity medicalDataFormActivity) {
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
