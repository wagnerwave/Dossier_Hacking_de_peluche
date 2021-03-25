package com.cuatroochenta.miniland.pregnancy.settings;

import a.c.a.d.a;
import a.c.a.e.f;
import a.c.d.c;
import a.c.d.m.k.b;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.sozpic.miniland.R;
import com.sozpic.miniland.TopMenuActivity;

public class ActivityPrengnacySettings extends c {

    /* renamed from: b  reason: collision with root package name */
    public View f4070b;

    /* renamed from: c  reason: collision with root package name */
    public View f4071c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f4072d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4073e;
    public ViewGroup f;
    public TopMenuActivity g;

    public static void q(Activity activity) {
        activity.startActivityForResult(new Intent(activity, ActivityPrengnacySettings.class), 1005);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_my_pregnancy_settings);
        this.f4070b = findViewById(R.id.pregnancy_settings_button_borrar_informacion);
        this.f4072d = (TextView) findViewById(R.id.pregnancy_settings_text_borrar_informacion);
        this.f4071c = findViewById(R.id.pregnancy_settings_button_nuevo_embarazo);
        this.f4073e = (TextView) findViewById(R.id.pregnancy_settings_text_nuevo_embarazo);
        this.g = (TopMenuActivity) findViewById(R.id.pregnancy_settings_toolbar);
        this.f = (ViewGroup) findViewById(R.id.pregnancy_settings_header);
        this.g.setListener(this);
        this.g.setSeccion(a.h(R.string.TR_MENU_MI_EMBARAZO));
        ((ImageView) this.f.findViewById(R.id.pregnancy_section_header_image)).setImageResource(R.drawable.ic_tuerca);
        ((TextView) this.f.findViewById(R.id.pregnancy_section_header_title)).setText(a.h(R.string.TR_MENU_MI_EMBARAZO_AJUSTES).toUpperCase());
        this.f.setBackgroundColor(-1711305807);
        this.f4071c.setOnClickListener(new a.c.d.m.k.a(this));
        this.f4070b.setOnClickListener(new b(this));
        this.f4072d.setText(a.h(R.string.TR_BORRAR_INFORMACION));
        this.f4073e.setText(a.h(R.string.TR_NUEVO_EMBARAZO));
        f.c().e("MI_EMBARAZO_AJUSTES");
    }
}
