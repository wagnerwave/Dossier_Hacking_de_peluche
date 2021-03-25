package com.sozpic.miniland;

import a.c.a.e.f;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.sozpic.miniland.TopMenuActivity;
import com.sozpic.miniland.modelos.Bebe;
import com.sozpic.miniland.modelos.Medica;
import com.sozpic.miniland.modelos.Usuario;

public class DetalleMedicaVacunaActivity extends Activity implements TopMenuActivity.c {

    /* renamed from: a  reason: collision with root package name */
    public Context f4410a;

    /* renamed from: b  reason: collision with root package name */
    public Medica f4411b;

    /* renamed from: c  reason: collision with root package name */
    public Bebe f4412c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f4413d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4414e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TopMenuActivity k;
    public ProgressDialog l;
    public Handler m = new c();

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            Intent intent = new Intent(DetalleMedicaVacunaActivity.this, NuevoMedicaActivity.class);
            intent.putExtra("KEY_INTENT_MEDICAL_RECORD", DetalleMedicaVacunaActivity.this.f4411b);
            intent.putExtra("KEY_INTENT_BABY", DetalleMedicaVacunaActivity.this.f4412c);
            intent.putExtra("tipo", 2);
            DetalleMedicaVacunaActivity.this.startActivity(intent);
            DetalleMedicaVacunaActivity.this.finish();
        }
    }

    public class b implements View.OnClickListener {

        public class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Dialog f4417a;

            public a(b bVar, Dialog dialog) {
                this.f4417a = dialog;
            }

            public void onClick(View view) {
                this.f4417a.dismiss();
            }
        }

        /* renamed from: com.sozpic.miniland.DetalleMedicaVacunaActivity$b$b  reason: collision with other inner class name */
        public class C0098b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Dialog f4418a;

            public C0098b(Dialog dialog) {
                this.f4418a = dialog;
            }

            public void onClick(View view) {
                DetalleMedicaVacunaActivity.this.l = new ProgressDialog(DetalleMedicaVacunaActivity.this.f4410a);
                DetalleMedicaVacunaActivity.this.l.setCancelable(false);
                DetalleMedicaVacunaActivity.this.l.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
                DetalleMedicaVacunaActivity.this.l.setIndeterminate(true);
                DetalleMedicaVacunaActivity.this.l.show();
                try {
                    Usuario i = AppMiniland.f().i();
                    new a.h.a.l0.b(DetalleMedicaVacunaActivity.this.m, "&bd=" + i.getBd() + "&bdpre=" + i.getBdpre() + "&id=" + DetalleMedicaVacunaActivity.this.f4411b.getId(), "fichamedica.php?eliminarvacuna=1").start();
                } catch (Exception unused) {
                    DetalleMedicaVacunaActivity.this.l.dismiss();
                }
                this.f4418a.dismiss();
            }
        }

        public b() {
        }

        public void onClick(View view) {
            Dialog dialog = new Dialog(DetalleMedicaVacunaActivity.this, 2131886561);
            dialog.requestWindowFeature(1);
            dialog.setContentView(R.layout.popup_mensaje);
            dialog.setCancelable(true);
            Button button = (Button) a.a.a.a.a.A(R.string.TR_DELETE_MEDICAL_VACCINE_CONFIRM_DIALOG, (TextView) dialog.findViewById(R.id.texto), dialog, R.id.ccancel);
            button.setText(a.c.a.d.a.h(R.string.TR_CANCEL).toUpperCase());
            button.setOnClickListener(new a(this, dialog));
            Button button2 = (Button) dialog.findViewById(R.id.ook);
            button2.setText(a.c.a.d.a.h(R.string.TR_OK).toUpperCase());
            button2.setOnClickListener(new C0098b(dialog));
            dialog.show();
        }
    }

    public class c extends Handler {
        public c() {
        }

        public void handleMessage(Message message) {
            DetalleMedicaVacunaActivity.this.l.dismiss();
            if (!(message == null || message.obj == null)) {
                StringBuilder n = a.a.a.a.a.n("SH2:");
                n.append(message.toString());
                Log.d("MINILAND_EBABY", n.toString());
                if ("OK".equalsIgnoreCase(message.obj.toString())) {
                    DetalleMedicaVacunaActivity.this.finish();
                    return;
                }
            }
            Toast.makeText(DetalleMedicaVacunaActivity.this.f4410a, "Error", 0).show();
        }
    }

    public void a() {
        finish();
    }

    public void b() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4410a = this;
        requestWindowFeature(1);
        setContentView(R.layout.activity_detalle_medica_vacuna);
        TopMenuActivity topMenuActivity = (TopMenuActivity) findViewById(R.id.cabecera);
        this.k = topMenuActivity;
        topMenuActivity.setListener(this);
        this.k.setSeccion(a.c.a.d.a.h(R.string.TR_MENU_MEDICAL_RECORDS));
        ((TextView) findViewById(R.id.header)).setText(a.c.a.d.a.h(R.string.TR_VACCINE));
        ((TextView) findViewById(R.id.vacuna_title)).setText(a.c.a.d.a.h(R.string.TR_VACCINE));
        ((TextView) findViewById(R.id.vacuna_tipo_title)).setText(a.c.a.d.a.h(R.string.TR_VACCINE_TYPE_TITLE));
        ((TextView) findViewById(R.id.fecha_title)).setText(a.c.a.d.a.h(R.string.TR_DATE));
        ((TextView) findViewById(R.id.lote_title)).setText(a.c.a.d.a.h(R.string.TR_LOT));
        ((TextView) findViewById(R.id.laboratorio_title)).setText(a.c.a.d.a.h(R.string.TR_LABORATORY));
        ((TextView) findViewById(R.id.colegiado_title)).setText(a.c.a.d.a.h(R.string.TR_COLLEGIATE_NUM));
        ((TextView) findViewById(R.id.observa_title)).setText(a.c.a.d.a.h(R.string.TR_COMMENTS));
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f4411b = (Medica) extras.getParcelable("KEY_INTENT_MEDICAL_RECORD");
            this.f4412c = (Bebe) extras.getParcelable("KEY_INTENT_BABY");
        }
        if (this.f4411b == null) {
            finish();
            return;
        }
        TextView textView = (TextView) findViewById(R.id.fecha);
        this.f4413d = textView;
        textView.setText(this.f4411b.getFechavacuna());
        TextView textView2 = (TextView) findViewById(R.id.vacuna);
        this.f4414e = textView2;
        textView2.setText(this.f4411b.getVacunavacuna());
        TextView textView3 = (TextView) findViewById(R.id.tipo);
        this.f = textView3;
        textView3.setText(this.f4411b.getBebibleinyectablevacuna());
        TextView textView4 = (TextView) findViewById(R.id.colegiado);
        this.g = textView4;
        textView4.setText(this.f4411b.getColegiadovacuna());
        TextView textView5 = (TextView) findViewById(R.id.lote);
        this.h = textView5;
        textView5.setText(this.f4411b.getLotevacuna());
        TextView textView6 = (TextView) findViewById(R.id.laboratorio);
        this.i = textView6;
        textView6.setText(this.f4411b.getLaboratoriovacuna());
        TextView textView7 = (TextView) findViewById(R.id.observaciones);
        this.j = textView7;
        textView7.setText(this.f4411b.getObservacionesvacuna());
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.detalle_medica_vacuna_buttons_container);
        ((ImageView) viewGroup.findViewById(R.id.layout_ed_edit_button)).setOnClickListener(new a());
        ((ImageView) viewGroup.findViewById(R.id.layout_ed_delete_button)).setOnClickListener(new b());
    }

    public void onResume() {
        super.onResume();
        f.c().e("FICHA_MEDICA_DETALLE_VACUNACION");
    }
}
