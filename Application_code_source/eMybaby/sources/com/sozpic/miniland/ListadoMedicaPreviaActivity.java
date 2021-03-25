package com.sozpic.miniland;

import a.c.a.d.a;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sozpic.miniland.TopMenuActivity;
import com.sozpic.miniland.modelos.Bebe;

public class ListadoMedicaPreviaActivity extends Activity implements TopMenuActivity.c, View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public TopMenuActivity f4436a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f4437b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f4438c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f4439d;

    /* renamed from: e  reason: collision with root package name */
    public Bebe f4440e;

    public void a() {
        finish();
    }

    public void b() {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Log.d("MINILAND_EBABY", "HOLA");
    }

    public void onClick(View view) {
        int i;
        Intent intent = new Intent(this, NuevoMedicaActivity.class);
        intent.putExtra("KEY_INTENT_BABY", this.f4440e);
        if (this.f4437b == view) {
            i = 0;
        } else if (this.f4438c == view) {
            i = 2;
        } else {
            if (this.f4439d == view) {
                i = 1;
            }
            startActivity(intent);
            finish();
        }
        intent.putExtra("tipo", i);
        startActivity(intent);
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.activity_listado_medica_previa);
        TopMenuActivity topMenuActivity = (TopMenuActivity) findViewById(R.id.cabecera);
        this.f4436a = topMenuActivity;
        topMenuActivity.setListener(this);
        this.f4436a.setSeccion(a.h(R.string.TR_MENU_MEDICAL_RECORDS));
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("KEY_INTENT_BABY")) {
            this.f4440e = (Bebe) extras.getParcelable("KEY_INTENT_BABY");
        }
        if (this.f4440e == null) {
            finish();
            return;
        }
        this.f4437b = (LinearLayout) findViewById(R.id.op1);
        this.f4438c = (LinearLayout) findViewById(R.id.op2);
        this.f4439d = (LinearLayout) findViewById(R.id.op3);
        this.f4437b.setOnClickListener(this);
        this.f4438c.setOnClickListener(this);
        this.f4439d.setOnClickListener(this);
        ((TextView) findViewById(R.id.t1)).setText(a.h(R.string.TR_TAP_ADD_MEDICAL_APPOINTMENT));
        ((TextView) findViewById(R.id.t2)).setText(a.h(R.string.TR_TAP_ADD_VACCINE_APPOINTMENT));
        ((TextView) findViewById(R.id.t3)).setText(a.h(R.string.TR_TAP_ADD_GROWTH_APPOINTMENT));
    }
}
