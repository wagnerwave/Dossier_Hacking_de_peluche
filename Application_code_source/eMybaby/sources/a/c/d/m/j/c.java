package a.c.d.m.j;

import android.view.View;
import com.cuatroochenta.miniland.pregnancy.medicalAppointments.AddAppointmentFormActivity;

public class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AddAppointmentFormActivity f676a;

    public c(AddAppointmentFormActivity addAppointmentFormActivity) {
        this.f676a = addAppointmentFormActivity;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0142  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r6) {
        /*
            r5 = this;
            com.cuatroochenta.miniland.pregnancy.medicalAppointments.AddAppointmentFormActivity r6 = r5.f676a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            android.widget.EditText r1 = r6.j
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x001b
            r6 = 2131820941(0x7f11018d, float:1.9274611E38)
            goto L_0x0056
        L_0x001b:
            android.widget.TextView r1 = r6.m
            java.lang.CharSequence r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x002f
            r6 = 2131820940(0x7f11018c, float:1.927461E38)
            goto L_0x0056
        L_0x002f:
            android.widget.TextView r1 = r6.q
            java.lang.CharSequence r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0043
            r6 = 2131820942(0x7f11018e, float:1.9274613E38)
            goto L_0x0056
        L_0x0043:
            android.widget.TextView r6 = r6.p
            java.lang.CharSequence r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x005d
            r6 = 2131820943(0x7f11018f, float:1.9274615E38)
        L_0x0056:
            java.lang.String r6 = a.c.a.d.a.h(r6)
            r0.append(r6)
        L_0x005d:
            java.lang.String r6 = r0.toString()
            boolean r6 = r6.isEmpty()
            r1 = 0
            if (r6 == 0) goto L_0x0142
            com.cuatroochenta.miniland.pregnancy.medicalAppointments.AddAppointmentFormActivity r6 = r5.f676a
            java.lang.String r6 = r6.v
            java.lang.String r0 = "ACTION_CREATE"
            boolean r6 = r0.equals(r6)
            if (r6 == 0) goto L_0x00de
            com.cuatroochenta.miniland.model.MedicalAppointment r6 = new com.cuatroochenta.miniland.model.MedicalAppointment
            r6.<init>()
            com.cuatroochenta.miniland.pregnancy.medicalAppointments.AddAppointmentFormActivity r0 = r5.f676a
            int r0 = r0.t
            r6.setType(r0)
            com.cuatroochenta.miniland.pregnancy.medicalAppointments.AddAppointmentFormActivity r0 = r5.f676a
            java.util.Calendar r0 = r0.u
            java.util.Date r0 = r0.getTime()
            r6.setDate(r0)
            com.cuatroochenta.miniland.pregnancy.medicalAppointments.AddAppointmentFormActivity r0 = r5.f676a
            android.widget.EditText r0 = r0.g
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            r6.setObservation(r0)
            com.cuatroochenta.miniland.pregnancy.medicalAppointments.AddAppointmentFormActivity r0 = r5.f676a
            android.widget.TextView r0 = r0.m
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            r6.setPlace(r0)
            com.cuatroochenta.miniland.pregnancy.medicalAppointments.AddAppointmentFormActivity r0 = r5.f676a
            android.widget.EditText r0 = r0.j
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            r6.setDoctor(r0)
            com.cuatroochenta.miniland.pregnancy.medicalAppointments.AddAppointmentFormActivity r0 = r5.f676a
            if (r0 == 0) goto L_0x00dd
            android.app.ProgressDialog r1 = new android.app.ProgressDialog
            r1.<init>(r0)
            r1.show()
            com.cuatroochenta.miniland.webservices.pregnancy.medicalAppointments.add.MedicalAppointmentAddRequest r2 = new com.cuatroochenta.miniland.webservices.pregnancy.medicalAppointments.add.MedicalAppointmentAddRequest
            r2.<init>(r6)
            a.c.d.s.e.e.a.c r3 = new a.c.d.s.e.e.a.c
            r3.<init>()
            a.c.d.m.j.g r4 = new a.c.d.m.j.g
            r4.<init>(r0, r1, r6)
            a.c.d.s.e.e.a.c$a r6 = new a.c.d.s.e.e.a.c$a
            r6.<init>(r2, r4)
            r6.start()
            goto L_0x0171
        L_0x00dd:
            throw r1
        L_0x00de:
            com.cuatroochenta.miniland.pregnancy.medicalAppointments.AddAppointmentFormActivity r6 = r5.f676a
            com.cuatroochenta.miniland.model.MedicalAppointment r0 = r6.w
            java.util.Calendar r6 = r6.u
            java.util.Date r6 = r6.getTime()
            r0.setDate(r6)
            com.cuatroochenta.miniland.pregnancy.medicalAppointments.AddAppointmentFormActivity r6 = r5.f676a
            com.cuatroochenta.miniland.model.MedicalAppointment r0 = r6.w
            android.widget.EditText r6 = r6.g
            android.text.Editable r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            r0.setObservation(r6)
            com.cuatroochenta.miniland.pregnancy.medicalAppointments.AddAppointmentFormActivity r6 = r5.f676a
            com.cuatroochenta.miniland.model.MedicalAppointment r0 = r6.w
            android.widget.TextView r6 = r6.m
            java.lang.CharSequence r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            r0.setPlace(r6)
            com.cuatroochenta.miniland.pregnancy.medicalAppointments.AddAppointmentFormActivity r6 = r5.f676a
            com.cuatroochenta.miniland.model.MedicalAppointment r0 = r6.w
            android.widget.EditText r6 = r6.j
            android.text.Editable r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            r0.setDoctor(r6)
            com.cuatroochenta.miniland.pregnancy.medicalAppointments.AddAppointmentFormActivity r6 = r5.f676a
            com.cuatroochenta.miniland.model.MedicalAppointment r0 = r6.w
            android.app.ProgressDialog r1 = new android.app.ProgressDialog
            r1.<init>(r6)
            r1.show()
            com.cuatroochenta.miniland.webservices.pregnancy.medicalAppointments.edit.MedicalAppointmentEditRequest r2 = new com.cuatroochenta.miniland.webservices.pregnancy.medicalAppointments.edit.MedicalAppointmentEditRequest
            r2.<init>(r0)
            a.c.d.s.e.e.c.c r3 = new a.c.d.s.e.e.c.c
            r3.<init>()
            a.c.d.m.j.h r4 = new a.c.d.m.j.h
            r4.<init>(r6, r1, r0)
            a.c.d.s.e.e.c.c$a r6 = new a.c.d.s.e.e.c.c$a
            r6.<init>(r2, r4)
            r6.start()
            goto L_0x0171
        L_0x0142:
            com.cuatroochenta.miniland.pregnancy.medicalAppointments.AddAppointmentFormActivity r6 = r5.f676a
            java.lang.String r0 = r0.toString()
            if (r6 == 0) goto L_0x0172
            androidx.appcompat.app.AlertDialog$Builder r1 = new androidx.appcompat.app.AlertDialog$Builder
            r1.<init>(r6)
            r2 = 2131821023(0x7f1101df, float:1.9274777E38)
            java.lang.String r2 = a.c.a.d.a.h(r2)
            androidx.appcompat.app.AlertDialog$Builder r1 = r1.setTitle((java.lang.CharSequence) r2)
            androidx.appcompat.app.AlertDialog$Builder r0 = r1.setMessage((java.lang.CharSequence) r0)
            r1 = 2131820553(0x7f110009, float:1.9273824E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            a.c.d.m.j.k r2 = new a.c.d.m.j.k
            r2.<init>(r6)
            androidx.appcompat.app.AlertDialog$Builder r6 = r0.setPositiveButton((java.lang.CharSequence) r1, (android.content.DialogInterface.OnClickListener) r2)
            r6.show()
        L_0x0171:
            return
        L_0x0172:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.c.d.m.j.c.onClick(android.view.View):void");
    }
}
