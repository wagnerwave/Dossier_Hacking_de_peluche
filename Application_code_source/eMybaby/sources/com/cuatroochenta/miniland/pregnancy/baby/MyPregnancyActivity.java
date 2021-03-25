package com.cuatroochenta.miniland.pregnancy.baby;

import a.c.a.d.a;
import a.c.d.c;
import a.c.d.m.e.b;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.sozpic.miniland.R;
import com.sozpic.miniland.TopMenuActivity;

public class MyPregnancyActivity extends c {

    /* renamed from: b  reason: collision with root package name */
    public TextView f3940b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f3941c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f3942d;

    /* renamed from: e  reason: collision with root package name */
    public TopMenuActivity f3943e;

    public void onActivityResult(int i, int i2, Intent intent) {
        String str;
        if (i2 == -1) {
            if (i == 9342) {
                str = "ACTION_ECOGRAPHY_ADDED";
            } else {
                if (i == 4823) {
                    str = "ACTION_MEDICAL_ENTRY_ADDED";
                }
                setResult(-1, intent);
                finish();
            }
            intent.setAction(str);
            setResult(-1, intent);
            finish();
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_my_pregnancy);
        this.f3942d = (ViewGroup) findViewById(R.id.my_pregnancy_header);
        this.f3943e = (TopMenuActivity) findViewById(R.id.my_pregnancy_common_toolbar_header);
        this.f3940b = (TextView) findViewById(R.id.my_pregnancy_button_pulse_para_anadir_una_ecografia);
        this.f3941c = (TextView) findViewById(R.id.my_pregnancy_button_pulse_para_anadir_datos_medicos);
        this.f3943e.setListener(this);
        this.f3943e.setSeccion(a.h(R.string.TR_MENU_MI_EMBARAZO));
        ((ImageView) this.f3942d.findViewById(R.id.pregnancy_section_header_image)).setImageResource(R.drawable.ic_ecography_baby);
        ((TextView) this.f3942d.findViewById(R.id.pregnancy_section_header_title)).setText(a.h(R.string.TR_BEBE).toUpperCase());
        this.f3941c.setText(a.h(R.string.TR_PULSE_AQUI_PARA_ANYADIR_DATOS_MEDICOS));
        this.f3940b.setText(a.h(R.string.TR_PULSE_AQUI_PARA_ANYADIR_UNA_ECOGRAFIA));
        this.f3940b.setOnClickListener(new a.c.d.m.e.a(this));
        this.f3941c.setOnClickListener(new b(this));
    }
}
