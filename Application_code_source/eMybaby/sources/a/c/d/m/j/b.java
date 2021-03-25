package a.c.d.m.j;

import a.c.a.d.a;
import android.content.DialogInterface;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.cuatroochenta.miniland.pregnancy.medicalAppointments.AddAppointmentFormActivity;
import com.sozpic.miniland.R;

public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AddAppointmentFormActivity f675a;

    public b(AddAppointmentFormActivity addAppointmentFormActivity) {
        this.f675a = addAppointmentFormActivity;
    }

    public void onClick(View view) {
        if ("ACTION_EDIT".equals(this.f675a.v)) {
            AddAppointmentFormActivity addAppointmentFormActivity = this.f675a;
            if (addAppointmentFormActivity.w != null) {
                new AlertDialog.Builder(addAppointmentFormActivity).setTitle((CharSequence) a.h(R.string.TR_INFORMATION)).setNegativeButton((CharSequence) a.h(R.string.TR_CANCEL), (DialogInterface.OnClickListener) new j(addAppointmentFormActivity)).setMessage((CharSequence) a.h(R.string.TR_DELETE_MEDICAL_APPOINTMENT_CONFIRM_DIALOG)).setPositiveButton((CharSequence) a.h(R.string.TR_ACEPTAR), (DialogInterface.OnClickListener) new i(addAppointmentFormActivity)).show();
                return;
            }
        }
        AddAppointmentFormActivity addAppointmentFormActivity2 = this.f675a;
        addAppointmentFormActivity2.f4059b.setChecked(false);
        addAppointmentFormActivity2.g.setText("");
        addAppointmentFormActivity2.j.setText("");
        addAppointmentFormActivity2.m.setText("");
        addAppointmentFormActivity2.q.setText("");
        addAppointmentFormActivity2.p.setText("");
    }
}
