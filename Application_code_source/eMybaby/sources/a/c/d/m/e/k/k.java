package a.c.d.m.e.k;

import a.c.a.e.f;
import a.c.d.s.e.a.b.c.b;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import com.cuatroochenta.miniland.model.MedicalDataEntry;
import com.cuatroochenta.miniland.pregnancy.baby.medicalData.MedicalDataFormActivity;

public class k implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MedicalDataFormActivity f386a;

    public class a implements a.c.d.s.e.a.b.c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ProgressDialog f387a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MedicalDataEntry f388b;

        public a(ProgressDialog progressDialog, MedicalDataEntry medicalDataEntry) {
            this.f387a = progressDialog;
            this.f388b = medicalDataEntry;
        }

        public void a(b bVar) {
            this.f387a.dismiss();
            if (bVar.f42a.booleanValue()) {
                Intent intent = new Intent();
                intent.putExtra("ARGS_MEDICAL_DATA_ENTRY", this.f388b);
                k.this.f386a.setResult(-1, intent);
                f.c().d("MI_EMBARAZO", "BEBE_NUEVOS_DATOS", "");
                k.this.f386a.finish();
                return;
            }
            a.c.a.f.b.j0(k.this.f386a, bVar.f43b);
        }
    }

    public k(MedicalDataFormActivity medicalDataFormActivity) {
        this.f386a = medicalDataFormActivity;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x019e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r11) {
        /*
            r10 = this;
            com.cuatroochenta.miniland.pregnancy.baby.medicalData.MedicalDataFormActivity r11 = r10.f386a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.util.Calendar r1 = r11.p
            if (r1 != 0) goto L_0x0010
            r11 = 2131820935(0x7f110187, float:1.9274599E38)
            goto L_0x008b
        L_0x0010:
            android.widget.EditText r1 = r11.j
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0024
            r11 = 2131820937(0x7f110189, float:1.9274603E38)
            goto L_0x008b
        L_0x0024:
            android.widget.EditText r1 = r11.l
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0038
            r11 = 2131820938(0x7f11018a, float:1.9274605E38)
            goto L_0x008b
        L_0x0038:
            android.widget.EditText r1 = r11.n
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x004c
            r11 = 2131820932(0x7f110184, float:1.9274593E38)
            goto L_0x008b
        L_0x004c:
            android.widget.EditText r1 = r11.h
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0060
            r11 = 2131820934(0x7f110186, float:1.9274597E38)
            goto L_0x008b
        L_0x0060:
            java.util.Calendar r1 = r11.p
            java.util.Date r1 = r1.getTime()
            java.util.Date r2 = a.c.d.r.i.e()
            boolean r1 = r1.before(r2)
            if (r1 != 0) goto L_0x0088
            java.util.Calendar r11 = r11.p
            java.util.Date r11 = r11.getTime()
            com.sozpic.miniland.AppMiniland r1 = com.sozpic.miniland.AppMiniland.f()
            com.sozpic.miniland.modelos.Usuario r1 = r1.i()
            java.util.Date r1 = r1.getBirthDate()
            boolean r11 = r11.after(r1)
            if (r11 == 0) goto L_0x0092
        L_0x0088:
            r11 = 2131820949(0x7f110195, float:1.9274627E38)
        L_0x008b:
            java.lang.String r11 = a.c.a.d.a.h(r11)
            r0.append(r11)
        L_0x0092:
            java.lang.String r11 = r0.toString()
            boolean r11 = r11.isEmpty()
            if (r11 == 0) goto L_0x019e
            com.cuatroochenta.miniland.pregnancy.baby.medicalData.MedicalDataFormActivity r11 = r10.f386a
            android.content.Intent r11 = r11.getIntent()
            java.lang.String r0 = "ARGS_MEDICAL_DATA_ENTRY"
            boolean r11 = r11.hasExtra(r0)
            if (r11 == 0) goto L_0x00b7
            com.cuatroochenta.miniland.pregnancy.baby.medicalData.MedicalDataFormActivity r11 = r10.f386a
            android.content.Intent r11 = r11.getIntent()
            android.os.Parcelable r11 = r11.getParcelableExtra(r0)
            com.cuatroochenta.miniland.model.MedicalDataEntry r11 = (com.cuatroochenta.miniland.model.MedicalDataEntry) r11
            goto L_0x00bc
        L_0x00b7:
            com.cuatroochenta.miniland.model.MedicalDataEntry r11 = new com.cuatroochenta.miniland.model.MedicalDataEntry
            r11.<init>()
        L_0x00bc:
            com.cuatroochenta.miniland.pregnancy.baby.medicalData.MedicalDataFormActivity r1 = r10.f386a
            java.util.Calendar r1 = r1.p
            java.util.Date r1 = r1.getTime()
            r11.setDate(r1)
            com.cuatroochenta.miniland.pregnancy.baby.medicalData.MedicalDataFormActivity r1 = r10.f386a
            android.widget.EditText r1 = r1.j
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            float r1 = java.lang.Float.parseFloat(r1)
            r11.setFL(r1)
            com.cuatroochenta.miniland.pregnancy.baby.medicalData.MedicalDataFormActivity r1 = r10.f386a
            android.widget.EditText r1 = r1.l
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            float r1 = java.lang.Float.parseFloat(r1)
            r11.setHC(r1)
            com.cuatroochenta.miniland.pregnancy.baby.medicalData.MedicalDataFormActivity r1 = r10.f386a
            android.widget.EditText r1 = r1.n
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            float r1 = java.lang.Float.parseFloat(r1)
            r11.setAC(r1)
            com.cuatroochenta.miniland.pregnancy.baby.medicalData.MedicalDataFormActivity r1 = r10.f386a
            android.widget.EditText r1 = r1.h
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            int r1 = java.lang.Integer.parseInt(r1)
            r11.setEFW(r1)
            java.util.Date r1 = r11.getDate()
            java.lang.String r1 = a.c.d.r.i.b(r1)
            r11.setTitle(r1)
            com.cuatroochenta.miniland.pregnancy.baby.medicalData.MedicalDataFormActivity r1 = r10.f386a
            android.content.Intent r1 = r1.getIntent()
            java.lang.String r1 = r1.getAction()
            if (r1 == 0) goto L_0x017d
            com.cuatroochenta.miniland.pregnancy.baby.medicalData.MedicalDataFormActivity r1 = r10.f386a
            android.content.Intent r1 = r1.getIntent()
            java.lang.String r1 = r1.getAction()
            java.lang.String r2 = "ACTION_EDIT"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x017d
            android.app.ProgressDialog r0 = new android.app.ProgressDialog
            com.cuatroochenta.miniland.pregnancy.baby.medicalData.MedicalDataFormActivity r1 = r10.f386a
            r0.<init>(r1)
            r0.show()
            com.cuatroochenta.miniland.webservices.pregnancy.baby.medicalData.edit.MedicalDataEditRequest r1 = new com.cuatroochenta.miniland.webservices.pregnancy.baby.medicalData.edit.MedicalDataEditRequest
            long r3 = r11.getId()
            java.text.DateFormat r2 = a.c.d.r.j.j
            java.util.Date r5 = r11.getDate()
            java.lang.String r5 = r2.format(r5)
            float r6 = r11.getFL()
            float r7 = r11.getHC()
            float r8 = r11.getAC()
            int r9 = r11.getEFW()
            r2 = r1
            r2.<init>(r3, r5, r6, r7, r8, r9)
            a.c.d.s.e.a.b.c.c r2 = new a.c.d.s.e.a.b.c.c
            r2.<init>()
            a.c.d.m.e.k.k$a r3 = new a.c.d.m.e.k.k$a
            r3.<init>(r0, r11)
            a.c.d.s.e.a.b.c.c$a r11 = new a.c.d.s.e.a.b.c.c$a
            r11.<init>(r1, r3)
            r11.start()
            goto L_0x01cd
        L_0x017d:
            android.content.Intent r1 = new android.content.Intent
            r1.<init>()
            r1.putExtra(r0, r11)
            com.cuatroochenta.miniland.pregnancy.baby.medicalData.MedicalDataFormActivity r11 = r10.f386a
            r0 = -1
            r11.setResult(r0, r1)
            a.c.a.e.f r11 = a.c.a.e.f.c()
            java.lang.String r0 = "MI_EMBARAZO"
            java.lang.String r1 = "BEBE_NUEVOS_DATOS"
            java.lang.String r2 = ""
            r11.d(r0, r1, r2)
            com.cuatroochenta.miniland.pregnancy.baby.medicalData.MedicalDataFormActivity r11 = r10.f386a
            r11.finish()
            goto L_0x01cd
        L_0x019e:
            com.cuatroochenta.miniland.pregnancy.baby.medicalData.MedicalDataFormActivity r11 = r10.f386a
            if (r11 == 0) goto L_0x01ce
            androidx.appcompat.app.AlertDialog$Builder r1 = new androidx.appcompat.app.AlertDialog$Builder
            r1.<init>(r11)
            r2 = 2131821023(0x7f1101df, float:1.9274777E38)
            java.lang.String r2 = a.c.a.d.a.h(r2)
            androidx.appcompat.app.AlertDialog$Builder r1 = r1.setTitle((java.lang.CharSequence) r2)
            java.lang.String r0 = r0.toString()
            androidx.appcompat.app.AlertDialog$Builder r0 = r1.setMessage((java.lang.CharSequence) r0)
            r1 = 2131821192(0x7f110288, float:1.927512E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            a.c.d.m.e.k.m r2 = new a.c.d.m.e.k.m
            r2.<init>(r11)
            androidx.appcompat.app.AlertDialog$Builder r11 = r0.setPositiveButton((java.lang.CharSequence) r1, (android.content.DialogInterface.OnClickListener) r2)
            r11.show()
        L_0x01cd:
            return
        L_0x01ce:
            r11 = 0
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: a.c.d.m.e.k.k.onClick(android.view.View):void");
    }
}
