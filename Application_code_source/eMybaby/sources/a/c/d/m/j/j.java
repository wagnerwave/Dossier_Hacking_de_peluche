package a.c.d.m.j;

import android.content.DialogInterface;
import com.cuatroochenta.miniland.pregnancy.medicalAppointments.AddAppointmentFormActivity;

public class j implements DialogInterface.OnClickListener {
    public j(AddAppointmentFormActivity addAppointmentFormActivity) {
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
