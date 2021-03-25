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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.sozpic.miniland.TopMenuActivity;
import com.sozpic.miniland.modelos.Bebe;
import com.sozpic.miniland.modelos.Medica;
import com.sozpic.miniland.modelos.Usuario;

public class DetalleMedicaCitaActivity extends Activity implements TopMenuActivity.c {

    /* renamed from: a  reason: collision with root package name */
    public Context f4389a;

    /* renamed from: b  reason: collision with root package name */
    public Medica f4390b;

    /* renamed from: c  reason: collision with root package name */
    public Bebe f4391c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f4392d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4393e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TopMenuActivity i;
    public ProgressDialog j;
    public Handler k = new c();

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            Intent intent = new Intent(DetalleMedicaCitaActivity.this, NuevoMedicaActivity.class);
            intent.putExtra("KEY_INTENT_MEDICAL_RECORD", DetalleMedicaCitaActivity.this.f4390b);
            intent.putExtra("KEY_INTENT_BABY", DetalleMedicaCitaActivity.this.f4391c);
            intent.putExtra("tipo", 0);
            DetalleMedicaCitaActivity.this.startActivity(intent);
            DetalleMedicaCitaActivity.this.finish();
        }
    }

    public class b implements View.OnClickListener {

        public class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Dialog f4396a;

            public a(b bVar, Dialog dialog) {
                this.f4396a = dialog;
            }

            public void onClick(View view) {
                this.f4396a.dismiss();
            }
        }

        /* renamed from: com.sozpic.miniland.DetalleMedicaCitaActivity$b$b  reason: collision with other inner class name */
        public class C0096b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Dialog f4397a;

            public C0096b(Dialog dialog) {
                this.f4397a = dialog;
            }

            public void onClick(View view) {
                DetalleMedicaCitaActivity.this.j = new ProgressDialog(DetalleMedicaCitaActivity.this.f4389a);
                DetalleMedicaCitaActivity.this.j.setCancelable(false);
                DetalleMedicaCitaActivity.this.j.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
                DetalleMedicaCitaActivity.this.j.setIndeterminate(true);
                DetalleMedicaCitaActivity.this.j.show();
                try {
                    Usuario i = AppMiniland.f().i();
                    new a.h.a.l0.b(DetalleMedicaCitaActivity.this.k, "&bd=" + i.getBd() + "&bdpre=" + i.getBdpre() + "&id=" + DetalleMedicaCitaActivity.this.f4390b.getId(), "fichamedica.php?eliminarcita=1").start();
                } catch (Exception unused) {
                    DetalleMedicaCitaActivity.this.j.dismiss();
                }
                this.f4397a.dismiss();
            }
        }

        public b() {
        }

        public void onClick(View view) {
            Dialog dialog = new Dialog(DetalleMedicaCitaActivity.this, 2131886561);
            dialog.requestWindowFeature(1);
            dialog.setContentView(R.layout.popup_mensaje);
            dialog.setCancelable(true);
            Button button = (Button) a.a.a.a.a.A(R.string.TR_DELETE_MEDICAL_APPOINTMENT_CONFIRM_DIALOG, (TextView) dialog.findViewById(R.id.texto), dialog, R.id.ccancel);
            button.setText(a.c.a.d.a.h(R.string.TR_CANCEL).toUpperCase());
            button.setOnClickListener(new a(this, dialog));
            Button button2 = (Button) dialog.findViewById(R.id.ook);
            button2.setText(a.c.a.d.a.h(R.string.TR_OK).toUpperCase());
            button2.setOnClickListener(new C0096b(dialog));
            dialog.show();
        }
    }

    public class c extends Handler {
        public c() {
        }

        public void handleMessage(Message message) {
            DetalleMedicaCitaActivity.this.j.dismiss();
            if (!(message == null || message.obj == null)) {
                StringBuilder n = a.a.a.a.a.n("SH2:");
                n.append(message.toString());
                Log.d("MINILAND_EBABY", n.toString());
                if ("OK".equalsIgnoreCase(message.obj.toString())) {
                    DetalleMedicaCitaActivity.this.finish();
                    return;
                }
            }
            Toast.makeText(DetalleMedicaCitaActivity.this.f4389a, "Error", 0).show();
        }
    }

    public void a() {
        finish();
    }

    public void b() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4389a = this;
        requestWindowFeature(1);
        setContentView(R.layout.activity_detalle_medica_cita);
        TopMenuActivity topMenuActivity = (TopMenuActivity) findViewById(R.id.cabecera);
        this.i = topMenuActivity;
        topMenuActivity.setListener(this);
        this.i.setSeccion(a.c.a.d.a.h(R.string.TR_MENU_MEDICAL_RECORDS).toUpperCase());
        ((TextView) findViewById(R.id.medical_appointment_header)).setText(a.c.a.d.a.h(R.string.TR_MEDICAL_APPOINTMENT));
        ((TextView) findViewById(R.id.especialista_title)).setText(a.c.a.d.a.h(R.string.TR_SPECIALIST));
        ((TextView) findViewById(R.id.medico_title)).setText(a.c.a.d.a.h(R.string.TR_DOCTOR));
        ((TextView) findViewById(R.id.lugar_title)).setText(a.c.a.d.a.h(R.string.TR_PLACE));
        ((TextView) findViewById(R.id.fecha_title)).setText(a.c.a.d.a.h(R.string.TR_DATE));
        ((TextView) findViewById(R.id.tratamiento_title)).setText(a.c.a.d.a.h(R.string.TR_TREATMENT));
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f4390b = (Medica) extras.getParcelable("KEY_INTENT_MEDICAL_RECORD");
            this.f4391c = (Bebe) extras.getParcelable("KEY_INTENT_BABY");
        }
        Medica medica = this.f4390b;
        if (medica == null) {
            finish();
            return;
        }
        String horacita = medica.getHoracita();
        this.f4392d = (EditText) findViewById(R.id.et_fecha);
        if (!horacita.equals("")) {
            try {
                String[] a0 = a.e.a.a.r.b.a0(horacita, ":");
                horacita = a0[0] + ":" + a0[1];
            } catch (Exception unused) {
            }
        }
        this.f4392d.setText(this.f4390b.getFechacita() + " " + horacita);
        TextView textView = (TextView) findViewById(R.id.especialista);
        this.f4393e = textView;
        textView.setText(a.e.a.a.r.b.R(this.f4390b.getEspecialistacita()));
        TextView textView2 = (TextView) findViewById(R.id.medico);
        this.f = textView2;
        textView2.setText(this.f4390b.getMedicocita());
        TextView textView3 = (TextView) findViewById(R.id.lugar);
        this.g = textView3;
        textView3.setText(this.f4390b.getLugarcita());
        TextView textView4 = (TextView) findViewById(R.id.et_tratamiento);
        this.h = textView4;
        textView4.setText(this.f4390b.getTratamientocita());
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.detalle_medica_cita_buttons_container);
        ((ImageView) viewGroup.findViewById(R.id.layout_ed_edit_button)).setOnClickListener(new a());
        ((ImageView) viewGroup.findViewById(R.id.layout_ed_delete_button)).setOnClickListener(new b());
    }

    public void onResume() {
        super.onResume();
        f.c().e("FICHA_MEDICA_DETALLE_CITA");
    }
}
