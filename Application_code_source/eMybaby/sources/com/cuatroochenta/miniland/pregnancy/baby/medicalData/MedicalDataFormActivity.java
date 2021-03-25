package com.cuatroochenta.miniland.pregnancy.baby.medicalData;

import a.c.a.d.a;
import a.c.a.e.f;
import a.c.d.c;
import a.c.d.m.e.k.j;
import a.c.d.m.e.k.k;
import a.c.d.m.e.k.l;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.cuatroochenta.miniland.model.MedicalDataEntry;
import com.sozpic.miniland.R;
import com.sozpic.miniland.TopMenuActivity;
import java.util.Calendar;

public class MedicalDataFormActivity extends c {

    /* renamed from: b  reason: collision with root package name */
    public TopMenuActivity f3959b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f3960c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f3961d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f3962e;
    public TextView f;
    public TextView g;
    public EditText h;
    public TextView i;
    public EditText j;
    public TextView k;
    public EditText l;
    public TextView m;
    public EditText n;
    public TextView o;
    public Calendar p;
    public TextView q;

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_add_medical_info);
        TextView textView = (TextView) findViewById(R.id.add_medical_info_button_cancelar);
        this.q = textView;
        textView.setText(a.h(R.string.TR_CANCEL).toUpperCase());
        this.f3962e = (TextView) findViewById(R.id.add_medical_info_text_label_fecha);
        this.o = (TextView) findViewById(R.id.add_medical_info_text_date_selector);
        this.f3960c = (LinearLayout) findViewById(R.id.add_medical_info_date_selector_container);
        TextView textView2 = (TextView) findViewById(R.id.add_medical_info_button_guardar);
        this.f = textView2;
        textView2.setText(a.h(R.string.TR_OK).toUpperCase());
        this.g = (TextView) findViewById(R.id.add_medical_info_text_label_efw);
        this.h = (EditText) findViewById(R.id.add_medical_info_input_efw);
        this.f3959b = (TopMenuActivity) findViewById(R.id.add_medical_info_toolbar);
        this.i = (TextView) findViewById(R.id.add_medical_info_text_label_fl);
        this.j = (EditText) findViewById(R.id.add_medical_info_input_fl);
        this.k = (TextView) findViewById(R.id.add_medical_info_text_label_hc);
        this.l = (EditText) findViewById(R.id.add_medical_info_input_hc);
        this.m = (TextView) findViewById(R.id.add_medical_info_text_label_ac);
        this.n = (EditText) findViewById(R.id.add_medical_info_input_ac);
        this.f3961d = (ViewGroup) findViewById(R.id.add_medical_info_header);
        this.f3959b.setListener(this);
        this.f3959b.setSeccion(a.h(R.string.TR_MENU_MI_EMBARAZO).toUpperCase());
        ((TextView) this.f3961d.findViewById(R.id.pregnancy_section_header_title)).setText(a.h(R.string.TR_BEBE).toUpperCase());
        ((TextView) this.f3961d.findViewById(R.id.pregnancy_section_header_subtitle)).setText(a.h(R.string.TR_DATOS_MEDICOS).toUpperCase());
        ((ImageView) this.f3961d.findViewById(R.id.pregnancy_section_header_image)).setImageResource(R.drawable.ic_ecography_baby);
        this.f3962e.setText(a.h(R.string.TR_FECHA));
        this.o.setText(a.h(R.string.TR_CHOOSE_DATE));
        this.g.setText(a.h(R.string.TR_EFW_ESTIMACION_PESO));
        this.h.setHint(a.h(R.string.TR_GR));
        this.i.setText(a.h(R.string.TR_FL_LONGITUD_FEMUR));
        this.j.setHint(a.h(R.string.TR_MM));
        this.k.setText(a.h(R.string.TR_HC_PERIMETRO_CRANEAL));
        this.l.setHint(a.h(R.string.TR_MM));
        this.m.setText(a.h(R.string.TR_AC_PERIMETRO_ABDOMINAL));
        this.n.setHint(a.h(R.string.TR_MM));
        this.f3960c.setOnClickListener(new j(this));
        this.f.setOnClickListener(new k(this));
        this.q.setOnClickListener(new l(this));
        if (getIntent().getAction() != null && getIntent().getAction().equals("ACTION_EDIT")) {
            MedicalDataEntry medicalDataEntry = (MedicalDataEntry) getIntent().getParcelableExtra("ARGS_MEDICAL_DATA_ENTRY");
            Calendar instance = Calendar.getInstance();
            this.p = instance;
            instance.setTime(medicalDataEntry.getDate());
            this.o.setText(a.c.d.r.j.h.format(medicalDataEntry.getDate()));
            this.j.setText(String.valueOf(medicalDataEntry.getFL()));
            this.l.setText(String.valueOf(medicalDataEntry.getHC()));
            this.n.setText(String.valueOf(medicalDataEntry.getAC()));
            this.h.setText(String.valueOf(medicalDataEntry.getEFW()));
        }
        f.c().e("MI_EMBARAZO_BEBE_NUEVOS_DATOS");
    }
}
