package com.cuatroochenta.miniland.pregnancy.medicalAppointments;

import a.c.d.c;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.app.NotificationCompatJellybean;
import com.cuatroochenta.miniland.model.MedicalAppointment;
import com.sozpic.miniland.TopMenuActivity;
import com.tuya.smart.home.sdk.bean.scene.PreCondition;
import java.util.Calendar;

public class AddAppointmentFormActivity extends c {

    /* renamed from: b  reason: collision with root package name */
    public AppCompatCheckBox f4059b;

    /* renamed from: c  reason: collision with root package name */
    public TopMenuActivity f4060c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f4061d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4062e;
    public TextView f;
    public EditText g;
    public TextView h;
    public TextView i;
    public EditText j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public View r;
    public View s;
    public int t;
    public Calendar u;
    public String v;
    public MedicalAppointment w;

    public static void q(AddAppointmentFormActivity addAppointmentFormActivity, MedicalAppointment medicalAppointment) {
        if (addAppointmentFormActivity != null) {
            Intent intent = new Intent("android.intent.action.EDIT");
            intent.setType("vnd.android.cursor.item/event");
            intent.putExtra("beginTime", medicalAppointment.getDate().getTime());
            intent.putExtra(PreCondition.TIMEINTERVAL_ALLDAY, true);
            intent.putExtra(NotificationCompatJellybean.KEY_TITLE, medicalAppointment.getDoctor());
            addAppointmentFormActivity.startActivity(intent);
            return;
        }
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x01d4, code lost:
        r5.setText(a.c.a.d.a.h(r0));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle r5) {
        /*
            r4 = this;
            super.onCreate(r5)
            r5 = 2131492896(0x7f0c0020, float:1.8609257E38)
            r4.setContentView(r5)
            r5 = 2131296359(0x7f090067, float:1.8210632E38)
            android.view.View r5 = r4.findViewById(r5)
            androidx.appcompat.widget.AppCompatCheckBox r5 = (androidx.appcompat.widget.AppCompatCheckBox) r5
            r4.f4059b = r5
            r5 = 2131296372(0x7f090074, float:1.8210659E38)
            android.view.View r5 = r4.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r4.f = r5
            r5 = 2131296367(0x7f09006f, float:1.8210649E38)
            android.view.View r5 = r4.findViewById(r5)
            android.widget.EditText r5 = (android.widget.EditText) r5
            r4.g = r5
            r5 = 2131296357(0x7f090065, float:1.8210628E38)
            android.view.View r5 = r4.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r4.h = r5
            r5 = 2131296355(0x7f090063, float:1.8210624E38)
            android.view.View r5 = r4.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r4.i = r5
            r5 = 2131296363(0x7f09006b, float:1.821064E38)
            android.view.View r5 = r4.findViewById(r5)
            android.widget.EditText r5 = (android.widget.EditText) r5
            r4.j = r5
            r5.requestFocus()
            r5 = 2131296373(0x7f090075, float:1.821066E38)
            android.view.View r5 = r4.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r4.k = r5
            r5 = 2131296356(0x7f090064, float:1.8210626E38)
            android.view.View r5 = r4.findViewById(r5)
            r4.r = r5
            r5 = 2131296358(0x7f090066, float:1.821063E38)
            android.view.View r5 = r4.findViewById(r5)
            r4.s = r5
            r5 = 2131296364(0x7f09006c, float:1.8210643E38)
            android.view.View r5 = r4.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r4.q = r5
            r5 = 2131296376(0x7f090078, float:1.8210667E38)
            android.view.View r5 = r4.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r4.l = r5
            r5 = 2131296366(0x7f09006e, float:1.8210647E38)
            android.view.View r5 = r4.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r4.m = r5
            r5 = 2131296374(0x7f090076, float:1.8210663E38)
            android.view.View r5 = r4.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r4.n = r5
            r5 = 2131296375(0x7f090077, float:1.8210665E38)
            android.view.View r5 = r4.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r4.o = r5
            r5 = 2131296365(0x7f09006d, float:1.8210645E38)
            android.view.View r5 = r4.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r4.p = r5
            r5 = 2131296377(0x7f090079, float:1.8210669E38)
            android.view.View r5 = r4.findViewById(r5)
            com.sozpic.miniland.TopMenuActivity r5 = (com.sozpic.miniland.TopMenuActivity) r5
            r4.f4060c = r5
            r5 = 2131296360(0x7f090068, float:1.8210634E38)
            android.view.View r5 = r4.findViewById(r5)
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            r4.f4061d = r5
            com.sozpic.miniland.TopMenuActivity r5 = r4.f4060c
            r0 = 2131821111(0x7f110237, float:1.9274956E38)
            java.lang.String r0 = a.c.a.d.a.h(r0)
            java.lang.String r0 = r0.toUpperCase()
            r5.setSeccion(r0)
            com.sozpic.miniland.TopMenuActivity r5 = r4.f4060c
            r5.setListener(r4)
            android.widget.TextView r5 = r4.f
            r0 = 2131820589(0x7f11002d, float:1.9273897E38)
            java.lang.String r0 = a.c.a.d.a.h(r0)
            r5.setText(r0)
            android.widget.EditText r5 = r4.g
            r0 = 2131821189(0x7f110285, float:1.9275114E38)
            java.lang.String r0 = a.c.a.d.a.h(r0)
            r5.setHint(r0)
            android.widget.TextView r5 = r4.h
            r0 = 2131821000(0x7f1101c8, float:1.927473E38)
            java.lang.String r0 = a.c.a.d.a.h(r0)
            java.lang.String r0 = r0.toUpperCase()
            r5.setText(r0)
            android.widget.TextView r5 = r4.i
            r0 = 2131820628(0x7f110054, float:1.9273976E38)
            java.lang.String r0 = a.c.a.d.a.h(r0)
            java.lang.String r0 = r0.toUpperCase()
            r5.setText(r0)
            android.widget.TextView r5 = r4.k
            r0 = 2131820789(0x7f1100f5, float:1.9274303E38)
            java.lang.String r0 = a.c.a.d.a.h(r0)
            r5.setText(r0)
            android.widget.TextView r5 = r4.l
            r0 = 2131821057(0x7f110201, float:1.9274846E38)
            java.lang.String r0 = a.c.a.d.a.h(r0)
            r5.setText(r0)
            android.widget.TextView r5 = r4.n
            r0 = 2131820948(0x7f110194, float:1.9274625E38)
            java.lang.String r0 = a.c.a.d.a.h(r0)
            r5.setText(r0)
            android.widget.TextView r5 = r4.o
            r0 = 2131821010(0x7f1101d2, float:1.9274751E38)
            java.lang.String r0 = a.c.a.d.a.h(r0)
            r5.setText(r0)
            java.util.Calendar r5 = java.util.Calendar.getInstance()
            r4.u = r5
            android.view.ViewGroup r5 = r4.f4061d
            r0 = -3052133(0xffffffffffd16d9b, float:NaN)
            r5.setBackgroundColor(r0)
            android.view.ViewGroup r5 = r4.f4061d
            r0 = 2131297290(0x7f09040a, float:1.821252E38)
            android.view.View r5 = r5.findViewById(r0)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r0 = 2131231092(0x7f080174, float:1.8078255E38)
            r5.setImageResource(r0)
            android.view.ViewGroup r5 = r4.f4061d
            r0 = 2131297292(0x7f09040c, float:1.8212525E38)
            android.view.View r5 = r5.findViewById(r0)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r4.f4062e = r5
            android.widget.TextView r5 = r4.i
            a.c.d.m.j.b r0 = new a.c.d.m.j.b
            r0.<init>(r4)
            r5.setOnClickListener(r0)
            android.widget.TextView r5 = r4.h
            a.c.d.m.j.c r0 = new a.c.d.m.j.c
            r0.<init>(r4)
            r5.setOnClickListener(r0)
            android.view.View r5 = r4.r
            a.c.d.m.j.d r0 = new a.c.d.m.j.d
            r0.<init>(r4)
            r5.setOnClickListener(r0)
            android.view.View r5 = r4.s
            a.c.d.m.j.e r0 = new a.c.d.m.j.e
            r0.<init>(r4)
            r5.setOnClickListener(r0)
            android.view.ViewGroup r5 = r4.f4061d
            r0 = 2131297291(0x7f09040b, float:1.8212523E38)
            android.view.View r5 = r5.findViewById(r0)
            android.widget.TextView r5 = (android.widget.TextView) r5
            android.content.Intent r0 = r4.getIntent()
            android.os.Bundle r0 = r0.getExtras()
            if (r0 != 0) goto L_0x01ab
            goto L_0x0271
        L_0x01ab:
            java.lang.String r1 = "ARGS_APPOINTMENT_TYPE"
            boolean r2 = r0.containsKey(r1)
            if (r2 == 0) goto L_0x01f1
            int r0 = r0.getInt(r1)
            r4.t = r0
            switch(r0) {
                case 1: goto L_0x01d1;
                case 2: goto L_0x01cd;
                case 3: goto L_0x01c9;
                case 4: goto L_0x01c5;
                case 5: goto L_0x01c1;
                case 6: goto L_0x01bd;
                default: goto L_0x01bc;
            }
        L_0x01bc:
            goto L_0x01db
        L_0x01bd:
            r0 = 2131821197(0x7f11028d, float:1.927513E38)
            goto L_0x01d4
        L_0x01c1:
            r0 = 2131821141(0x7f110255, float:1.9275017E38)
            goto L_0x01d4
        L_0x01c5:
            r0 = 2131820661(0x7f110075, float:1.9274043E38)
            goto L_0x01d4
        L_0x01c9:
            r0 = 2131820597(0x7f110035, float:1.9273913E38)
            goto L_0x01d4
        L_0x01cd:
            r0 = 2131820982(0x7f1101b6, float:1.9274694E38)
            goto L_0x01d4
        L_0x01d1:
            r0 = 2131821067(0x7f11020b, float:1.9274867E38)
        L_0x01d4:
            java.lang.String r0 = a.c.a.d.a.h(r0)
            r5.setText(r0)
        L_0x01db:
            java.lang.String r5 = "ACTION_CREATE"
            r4.v = r5
            android.widget.TextView r5 = r4.f4062e
            r0 = 2131821185(0x7f110281, float:1.9275106E38)
            java.lang.String r0 = a.c.a.d.a.h(r0)
            java.lang.String r0 = r0.toUpperCase()
            r5.setText(r0)
            goto L_0x0274
        L_0x01f1:
            java.lang.String r1 = "ARGS_NEW_APPOINTMENT"
            boolean r2 = r0.containsKey(r1)
            if (r2 == 0) goto L_0x0274
            java.lang.String r2 = "ACTION_EDIT"
            r4.v = r2
            android.widget.TextView r2 = r4.f4062e
            r3 = 2131820803(0x7f110103, float:1.9274331E38)
            java.lang.String r3 = a.c.a.d.a.h(r3)
            java.lang.String r3 = r3.toUpperCase()
            r2.setText(r3)
            android.os.Parcelable r0 = r0.getParcelable(r1)
            com.cuatroochenta.miniland.model.MedicalAppointment r0 = (com.cuatroochenta.miniland.model.MedicalAppointment) r0
            r4.w = r0
            if (r0 == 0) goto L_0x0271
            java.lang.String r0 = r0.getTypeAsString()
            r5.setText(r0)
            java.util.Calendar r5 = java.util.Calendar.getInstance()
            r4.u = r5
            com.cuatroochenta.miniland.model.MedicalAppointment r0 = r4.w
            java.util.Date r0 = r0.getDate()
            r5.setTime(r0)
            android.widget.EditText r5 = r4.j
            com.cuatroochenta.miniland.model.MedicalAppointment r0 = r4.w
            java.lang.String r0 = r0.getDoctor()
            r5.setText(r0)
            android.widget.TextView r5 = r4.m
            com.cuatroochenta.miniland.model.MedicalAppointment r0 = r4.w
            java.lang.String r0 = r0.getPlace()
            r5.setText(r0)
            android.widget.TextView r5 = r4.q
            java.text.DateFormat r0 = a.c.d.r.j.f
            java.util.Calendar r1 = r4.u
            java.util.Date r1 = r1.getTime()
            java.lang.String r0 = r0.format(r1)
            r5.setText(r0)
            android.widget.TextView r5 = r4.p
            java.text.DateFormat r0 = a.c.d.r.j.l
            java.util.Calendar r1 = r4.u
            java.util.Date r1 = r1.getTime()
            java.lang.String r0 = r0.format(r1)
            r5.setText(r0)
            android.widget.EditText r5 = r4.g
            com.cuatroochenta.miniland.model.MedicalAppointment r0 = r4.w
            java.lang.String r0 = r0.getObservation()
            r5.setText(r0)
            goto L_0x0274
        L_0x0271:
            r4.finish()
        L_0x0274:
            a.c.a.e.f r5 = a.c.a.e.f.c()
            java.lang.String r0 = "MI_EMBARAZO_CITAS_ADD"
            r5.e(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cuatroochenta.miniland.pregnancy.medicalAppointments.AddAppointmentFormActivity.onCreate(android.os.Bundle):void");
    }
}
