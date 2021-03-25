package com.sozpic.miniland;

import a.c.a.e.f;
import a.c.d.d.d;
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
import com.cuatroochenta.commons.widget.CircularImageView;
import com.sozpic.miniland.TopMenuActivity;
import com.sozpic.miniland.modelos.Bebe;
import com.sozpic.miniland.modelos.Usuario;

public class DetalleBebeActivity extends Activity implements TopMenuActivity.c, d.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f4341a;

    /* renamed from: b  reason: collision with root package name */
    public ProgressDialog f4342b;

    /* renamed from: c  reason: collision with root package name */
    public Bebe f4343c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f4344d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4345e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TopMenuActivity q;
    public a.c.d.d.d r;
    public CircularImageView s;
    public Handler t = new d();

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            DetalleBebeActivity detalleBebeActivity = DetalleBebeActivity.this;
            detalleBebeActivity.r.t(1, new a.c.d.s.g.b(detalleBebeActivity.f4343c));
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            Intent intent = new Intent(DetalleBebeActivity.this, NuevoBebeActivity.class);
            intent.putExtra("KEY_INTENT_BABY", DetalleBebeActivity.this.f4343c);
            DetalleBebeActivity.this.startActivity(intent);
            DetalleBebeActivity.this.finish();
        }
    }

    public class c implements View.OnClickListener {

        public class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Dialog f4349a;

            public a(c cVar, Dialog dialog) {
                this.f4349a = dialog;
            }

            public void onClick(View view) {
                this.f4349a.dismiss();
            }
        }

        public class b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Dialog f4350a;

            public b(Dialog dialog) {
                this.f4350a = dialog;
            }

            public void onClick(View view) {
                DetalleBebeActivity.this.f4342b = new ProgressDialog(DetalleBebeActivity.this.f4341a);
                DetalleBebeActivity.this.f4342b.setCancelable(false);
                DetalleBebeActivity.this.f4342b.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
                DetalleBebeActivity.this.f4342b.setIndeterminate(true);
                DetalleBebeActivity.this.f4342b.show();
                try {
                    Usuario i = AppMiniland.f().i();
                    new a.h.a.l0.b(DetalleBebeActivity.this.t, "&bd=" + i.getBd() + "&bdpre=" + i.getBdpre() + "&idBebe=" + DetalleBebeActivity.this.f4343c.getId(), "bebe.php?borrarbebe=1").start();
                } catch (Exception unused) {
                    DetalleBebeActivity.this.f4342b.dismiss();
                }
                this.f4350a.dismiss();
            }
        }

        public c() {
        }

        public void onClick(View view) {
            Dialog dialog = new Dialog(DetalleBebeActivity.this, 2131886561);
            dialog.requestWindowFeature(1);
            dialog.setContentView(R.layout.popup_mensaje);
            dialog.setCancelable(true);
            Button button = (Button) a.a.a.a.a.A(R.string.TR_DELETE_BABY_CONFIRM_DIALOG, (TextView) dialog.findViewById(R.id.texto), dialog, R.id.ccancel);
            button.setText(a.c.a.d.a.h(R.string.TR_CANCEL).toUpperCase());
            button.setOnClickListener(new a(this, dialog));
            Button button2 = (Button) dialog.findViewById(R.id.ook);
            button2.setText(a.c.a.d.a.h(R.string.TR_OK).toUpperCase());
            button2.setOnClickListener(new b(dialog));
            dialog.show();
        }
    }

    public class d extends Handler {
        public d() {
        }

        public void handleMessage(Message message) {
            DetalleBebeActivity.this.f4342b.dismiss();
            if (!(message == null || message.obj == null)) {
                StringBuilder n = a.a.a.a.a.n("SH2:");
                n.append(message.toString());
                Log.d("MINILAND_EBABY", n.toString());
                if ("OK".equalsIgnoreCase(message.obj.toString())) {
                    DetalleBebeActivity.this.finish();
                    return;
                }
            }
            Toast.makeText(DetalleBebeActivity.this.f4341a, "Error", 0).show();
        }
    }

    public void a() {
        finish();
    }

    public void b() {
    }

    public void l(String str) {
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        a.c.d.d.d dVar = this.r;
        if (dVar == null || !dVar.n(i2, i3, intent)) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        TextView textView;
        String str;
        super.onCreate(bundle);
        this.f4341a = this;
        requestWindowFeature(1);
        setContentView(R.layout.activity_detalle_bebe);
        TopMenuActivity topMenuActivity = (TopMenuActivity) findViewById(R.id.cabecera);
        this.q = topMenuActivity;
        topMenuActivity.setListener(this);
        this.q.setSeccion(a.c.a.d.a.h(R.string.TR_MENU_MY_BABY).toUpperCase());
        this.r = new a.c.d.d.d((Activity) this, (d.a) this, bundle);
        CircularImageView circularImageView = (CircularImageView) findViewById(R.id.lo);
        this.s = circularImageView;
        circularImageView.setBorder(true);
        this.s.setBorderColor(getResources().getColor(R.color.azul_selected));
        this.s.setImageResource(R.drawable.baby_big_default);
        this.s.setOnClickListener(new a());
        ((TextView) findViewById(R.id.sexo_title)).setText(a.c.a.d.a.h(R.string.TR_SEX));
        ((TextView) findViewById(R.id.altura_title)).setText(a.c.a.d.a.h(R.string.TR_HEIGHT));
        ((TextView) findViewById(R.id.peso_title)).setText(a.c.a.d.a.h(R.string.TR_WEIGHT_KG));
        ((TextView) findViewById(R.id.medidacabeza_title)).setText(a.c.a.d.a.h(R.string.TR_CRANIAL_PERIMETER));
        ((TextView) findViewById(R.id.piel_title)).setText(a.c.a.d.a.h(R.string.TR_SKIN));
        ((TextView) findViewById(R.id.ojos_title)).setText(a.c.a.d.a.h(R.string.TR_EYES));
        ((TextView) findViewById(R.id.pelo_title)).setText(a.c.a.d.a.h(R.string.TR_HAIR));
        ((TextView) findViewById(R.id.hospital_title)).setText(a.c.a.d.a.h(R.string.TR_HOSPITAL));
        ((TextView) findViewById(R.id.ginecologo_title)).setText(a.c.a.d.a.h(R.string.TR_GINECOLYST));
        ((TextView) findViewById(R.id.matron_title)).setText(a.c.a.d.a.h(R.string.TR_MIDWIFE));
        Bundle extras = getIntent().getExtras();
        if (extras == null || !extras.containsKey("KEY_INTENT_BABY")) {
            finish();
            return;
        }
        Bebe bebe = (Bebe) extras.getParcelable("KEY_INTENT_BABY");
        this.f4343c = bebe;
        if (!bebe.isPhotoEmpty()) {
            AppMiniland.f().k.b(this.f4343c.getFoto(), this.s, (a.g.a.b.b) null, (a.g.a.b.l.c) null);
        }
        this.f4345e = (TextView) findViewById(R.id.nombre);
        this.f4344d = (TextView) findViewById(R.id.apel);
        this.f = (TextView) findViewById(R.id.medidacabeza);
        this.g = (TextView) findViewById(R.id.fechanac);
        this.h = (TextView) findViewById(R.id.piel);
        this.i = (TextView) findViewById(R.id.sexo);
        this.j = (TextView) findViewById(R.id.pelo);
        this.k = (TextView) findViewById(R.id.ojos);
        this.m = (TextView) findViewById(R.id.peso);
        this.l = (TextView) findViewById(R.id.altura);
        this.n = (TextView) findViewById(R.id.hospital);
        this.o = (TextView) findViewById(R.id.ginecologo);
        this.p = (TextView) findViewById(R.id.matron);
        this.f4345e.setText(this.f4343c.getNombre());
        this.f4344d.setText(this.f4343c.getApellidos());
        if ("0.00".equals(this.f4343c.getMedidacabeza())) {
            textView = this.f;
            str = "";
        } else {
            textView = this.f;
            str = this.f4343c.getMedidacabeza();
        }
        textView.setText(str);
        this.g.setText(this.f4343c.getFechanacimiento());
        this.h.setText(this.f4343c.getPiel());
        this.i.setText(a.c.a.d.a.h("M".equals(this.f4343c.getSexo()) ? R.string.TR_FEMALE : R.string.TR_MALE));
        this.j.setText(this.f4343c.getPelo());
        this.k.setText(this.f4343c.getColorojos());
        this.m.setText(String.valueOf(this.f4343c.getPeso()));
        this.l.setText(String.valueOf(this.f4343c.getAltura()));
        this.n.setText(this.f4343c.getHospital());
        this.o.setText(this.f4343c.getGinecologo());
        this.p.setText(this.f4343c.getMatron());
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.detalle_bebe_buttons_container);
        ((ImageView) viewGroup.findViewById(R.id.layout_ed_edit_button)).setOnClickListener(new b());
        ((ImageView) viewGroup.findViewById(R.id.layout_ed_delete_button)).setOnClickListener(new c());
    }

    public void onResume() {
        super.onResume();
        f.c().e("MIBEBE_DETALLE");
    }
}
