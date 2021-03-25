package com.sozpic.miniland;

import a.c.a.e.f;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sozpic.miniland.TopMenuActivity;
import com.sozpic.miniland.modelos.Bebe;

public class ListadoTermometroPreviaActivity extends Activity implements TopMenuActivity.c {

    /* renamed from: a  reason: collision with root package name */
    public Context f4457a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f4458b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f4459c;

    /* renamed from: d  reason: collision with root package name */
    public TopMenuActivity f4460d;

    /* renamed from: e  reason: collision with root package name */
    public Bebe f4461e;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            Intent intent = new Intent(ListadoTermometroPreviaActivity.this.f4457a, HistoricoTermometroActivity.class);
            intent.putExtra("KEY_INTENT_BABY", ListadoTermometroPreviaActivity.this.f4461e);
            ListadoTermometroPreviaActivity.this.startActivity(intent);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            Intent intent = new Intent(ListadoTermometroPreviaActivity.this.f4457a, ListadoTermometroActivity.class);
            intent.putExtra("KEY_INTENT_BABY", ListadoTermometroPreviaActivity.this.f4461e);
            ListadoTermometroPreviaActivity.this.startActivity(intent);
        }
    }

    public void a() {
        finish();
    }

    public void b() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4457a = this;
        requestWindowFeature(1);
        setContentView(R.layout.activity_temperatura_1_previa);
        TopMenuActivity topMenuActivity = (TopMenuActivity) findViewById(R.id.cabecera);
        this.f4460d = topMenuActivity;
        topMenuActivity.setListener(this);
        this.f4460d.setSeccion(a.c.a.d.a.h(R.string.TR_TEMPERATURE));
        Bundle extras = getIntent().getExtras();
        if (extras == null || !extras.containsKey("KEY_INTENT_BABY")) {
            finish();
            return;
        }
        this.f4461e = (Bebe) extras.getParcelable("KEY_INTENT_BABY");
        ((TextView) findViewById(R.id.select_option)).setText(a.c.a.d.a.h(R.string.TR_SELECT_OPTION_WANT_TO_CHECK));
        this.f4458b = (TextView) findViewById(R.id.stats);
        TextView textView = (TextView) findViewById(R.id.newreading);
        this.f4459c = textView;
        textView.setText(a.c.a.d.a.h(R.string.TR_NEW_READING));
        this.f4458b.setText(a.c.a.d.a.h(R.string.TR_TEMPERATURE_HISTORICAL));
        ((ViewGroup) findViewById(R.id.lstats)).setOnClickListener(new a());
        ((ViewGroup) findViewById(R.id.lnewreader)).setOnClickListener(new b());
    }

    public void onResume() {
        super.onResume();
        f.c().e("TERMOMETRO_OPCIONES");
    }
}
