package com.cuatroochenta.miniland.pregnancy.medicalAppointments;

import a.c.a.d.a;
import a.c.d.c;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.sozpic.miniland.R;
import com.sozpic.miniland.TopMenuActivity;

public class AddAppointmentActivity extends c {

    /* renamed from: b  reason: collision with root package name */
    public TopMenuActivity f4055b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f4056c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f4057d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4058e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 42332 && i3 == -1) {
            setResult(-1, intent);
            finish();
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_medical_appointment);
        TextView textView = (TextView) findViewById(R.id.medical_appointment_text_clases_de_preparacion_al_parto);
        this.f4057d = textView;
        textView.setText(a.h(R.string.TR_CLASES_DE_PREPARACION_AL_PARTO));
        TextView textView2 = (TextView) findViewById(R.id.medical_appointment_text_ginecologo);
        this.f4058e = textView2;
        textView2.setText(a.h(R.string.TR_GINECOLOGO));
        TextView textView3 = (TextView) findViewById(R.id.medical_appointment_text_analitica);
        this.f = textView3;
        textView3.setText(a.h(R.string.TR_ANALITICA));
        TextView textView4 = (TextView) findViewById(R.id.medical_appointment_text_monitores);
        this.g = textView4;
        textView4.setText(a.h(R.string.TR_MONITORES));
        TextView textView5 = (TextView) findViewById(R.id.medical_appointment_text_matrona);
        this.h = textView5;
        textView5.setText(a.h(R.string.TR_MATRONA));
        TextView textView6 = (TextView) findViewById(R.id.medical_appointment_text_otros);
        this.i = textView6;
        textView6.setText(a.h(R.string.TR_OTROS));
        this.f4055b = (TopMenuActivity) findViewById(R.id.medical_appointment_toolbar);
        this.f4056c = (ViewGroup) findViewById(R.id.medical_appointment_header);
        this.f4055b.setListener(this);
        this.f4055b.setSeccion(a.h(R.string.TR_MENU_MI_EMBARAZO));
        this.f4056c.setBackgroundColor(-3052133);
        ((ImageView) this.f4056c.findViewById(R.id.pregnancy_section_header_image)).setImageResource(R.drawable.ic_calendar);
        ((TextView) this.f4056c.findViewById(R.id.pregnancy_section_header_title)).setText(a.h(R.string.TR_NUEVA_CITA_MEDICA).toUpperCase());
        this.f4057d.setOnClickListener(new a.c.d.m.j.a(this, 4));
        this.f.setOnClickListener(new a.c.d.m.j.a(this, 3));
        this.f4058e.setOnClickListener(new a.c.d.m.j.a(this, 2));
        this.g.setOnClickListener(new a.c.d.m.j.a(this, 5));
        this.h.setOnClickListener(new a.c.d.m.j.a(this, 1));
        this.i.setOnClickListener(new a.c.d.m.j.a(this, 6));
    }
}
