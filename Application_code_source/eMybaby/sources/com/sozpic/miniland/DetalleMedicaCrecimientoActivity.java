package com.sozpic.miniland;

import android.app.Dialog;
import android.app.ProgressDialog;
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
import com.sozpic.miniland.modelos.Bebe;
import com.sozpic.miniland.modelos.Medica;
import com.sozpic.miniland.modelos.Usuario;

public class DetalleMedicaCrecimientoActivity extends a.c.d.c {

    /* renamed from: b  reason: collision with root package name */
    public TopMenuActivity f4400b;

    /* renamed from: c  reason: collision with root package name */
    public Medica f4401c;

    /* renamed from: d  reason: collision with root package name */
    public Bebe f4402d;

    /* renamed from: e  reason: collision with root package name */
    public ProgressDialog f4403e;
    public Handler f = new c();

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            Intent intent = new Intent(DetalleMedicaCrecimientoActivity.this, NuevoMedicaActivity.class);
            intent.putExtra("KEY_INTENT_MEDICAL_RECORD", DetalleMedicaCrecimientoActivity.this.f4401c);
            intent.putExtra("KEY_INTENT_BABY", DetalleMedicaCrecimientoActivity.this.f4402d);
            intent.putExtra("tipo", 1);
            DetalleMedicaCrecimientoActivity.this.startActivity(intent);
            DetalleMedicaCrecimientoActivity.this.finish();
        }
    }

    public class b implements View.OnClickListener {

        public class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Dialog f4406a;

            public a(b bVar, Dialog dialog) {
                this.f4406a = dialog;
            }

            public void onClick(View view) {
                this.f4406a.dismiss();
            }
        }

        /* renamed from: com.sozpic.miniland.DetalleMedicaCrecimientoActivity$b$b  reason: collision with other inner class name */
        public class C0097b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Dialog f4407a;

            public C0097b(Dialog dialog) {
                this.f4407a = dialog;
            }

            public void onClick(View view) {
                DetalleMedicaCrecimientoActivity.this.f4403e = new ProgressDialog(DetalleMedicaCrecimientoActivity.this);
                DetalleMedicaCrecimientoActivity.this.f4403e.setCancelable(false);
                DetalleMedicaCrecimientoActivity.this.f4403e.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
                DetalleMedicaCrecimientoActivity.this.f4403e.setIndeterminate(true);
                DetalleMedicaCrecimientoActivity.this.f4403e.show();
                try {
                    Usuario i = AppMiniland.f().i();
                    new a.h.a.l0.b(DetalleMedicaCrecimientoActivity.this.f, "&bd=" + i.getBd() + "&bdpre=" + i.getBdpre() + "&id=" + DetalleMedicaCrecimientoActivity.this.f4401c.getId(), "fichamedica.php?eliminarcrecimiento=1").start();
                } catch (Exception unused) {
                    DetalleMedicaCrecimientoActivity.this.f4403e.dismiss();
                }
                this.f4407a.dismiss();
            }
        }

        public b() {
        }

        public void onClick(View view) {
            Dialog dialog = new Dialog(DetalleMedicaCrecimientoActivity.this, 2131886561);
            dialog.requestWindowFeature(1);
            dialog.setContentView(R.layout.popup_mensaje);
            dialog.setCancelable(true);
            Button button = (Button) a.a.a.a.a.A(R.string.TR_DELETE_MEASUREMENT_CONFIRM_DIALOG, (TextView) dialog.findViewById(R.id.texto), dialog, R.id.ccancel);
            button.setText(a.c.a.d.a.h(R.string.TR_CANCEL).toUpperCase());
            button.setOnClickListener(new a(this, dialog));
            Button button2 = (Button) dialog.findViewById(R.id.ook);
            button2.setText(a.c.a.d.a.h(R.string.TR_OK).toUpperCase());
            button2.setOnClickListener(new C0097b(dialog));
            dialog.show();
        }
    }

    public class c extends Handler {
        public c() {
        }

        public void handleMessage(Message message) {
            DetalleMedicaCrecimientoActivity.this.f4403e.dismiss();
            if (!(message == null || message.obj == null)) {
                StringBuilder n = a.a.a.a.a.n("SH2:");
                n.append(message.toString());
                Log.d("MINILAND_EBABY", n.toString());
                if ("OK".equalsIgnoreCase(message.obj.toString())) {
                    DetalleMedicaCrecimientoActivity.this.finish();
                    return;
                }
            }
            Toast.makeText(DetalleMedicaCrecimientoActivity.this, "Error", 0).show();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_detalle_crecimiento);
        TopMenuActivity topMenuActivity = (TopMenuActivity) findViewById(R.id.detalle_crecimiento_cabecera);
        this.f4400b = topMenuActivity;
        topMenuActivity.setListener(this);
        this.f4400b.setSeccion(a.c.a.d.a.h(R.string.TR_MENU_MEDICAL_RECORDS).toUpperCase());
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f4401c = (Medica) extras.getParcelable("KEY_INTENT_MEDICAL_RECORD");
            this.f4402d = (Bebe) extras.getParcelable("KEY_INTENT_BABY");
        }
        if (this.f4401c == null) {
            finish();
            return;
        }
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.detalle_crecimiento_main_container);
        ((TextView) viewGroup.findViewById(R.id.txtNuevoCrecimiento)).setText(a.c.a.d.a.h(R.string.TR_GROWTH));
        ((TextView) viewGroup.findViewById(R.id.txtPeso)).setText(a.c.a.d.a.h(R.string.TR_WEIGHT_KG));
        ((TextView) viewGroup.findViewById(R.id.txtAltura)).setText(a.c.a.d.a.h(R.string.TR_HEIGHT));
        ((TextView) viewGroup.findViewById(R.id.txtCraneo)).setText(a.c.a.d.a.h(R.string.TR_CRANIAL_PERIMETER));
        ((ViewGroup) viewGroup.findViewById(R.id.footer)).setVisibility(8);
        EditText editText = (EditText) viewGroup.findViewById(R.id.et_peso);
        editText.setEnabled(false);
        if (!a.c.a.d.a.j(this.f4401c.getPesocrecimiento())) {
            editText.setText(this.f4401c.getPesocrecimiento());
        }
        EditText editText2 = (EditText) viewGroup.findViewById(R.id.et_altura);
        editText2.setEnabled(false);
        if (!a.c.a.d.a.j(this.f4401c.getAlturacrecimiento())) {
            editText2.setText(this.f4401c.getAlturacrecimiento());
        }
        EditText editText3 = (EditText) viewGroup.findViewById(R.id.et_fecha);
        editText3.setEnabled(false);
        if (!a.c.a.d.a.j(this.f4401c.getFechacrecimiento())) {
            editText3.setText(this.f4401c.getFechacrecimiento());
        }
        EditText editText4 = (EditText) viewGroup.findViewById(R.id.et_craneo);
        editText4.setEnabled(false);
        if (!a.c.a.d.a.j(this.f4401c.getFechacrecimiento())) {
            editText4.setText(a.c.a.d.a.g(this.f4401c.getMedidaCabCrecimiento()));
        }
        ((ImageView) viewGroup.findViewById(R.id.tick)).setVisibility(8);
        ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.detalle_crecimiento_buttons_container);
        ((ImageView) viewGroup2.findViewById(R.id.layout_ed_edit_button)).setOnClickListener(new a());
        ((ImageView) viewGroup2.findViewById(R.id.layout_ed_delete_button)).setOnClickListener(new b());
    }
}
