package a.c.d.m.j;

import android.content.DialogInterface;
import com.cuatroochenta.miniland.pregnancy.medicalAppointments.AddAppointmentFormActivity;

public class k implements DialogInterface.OnClickListener {
    public k(AddAppointmentFormActivity addAppointmentFormActivity) {
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
