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
import com.sozpic.miniland.modelos.Familia;
import com.sozpic.miniland.modelos.Usuario;

public class DetalleFamiliaActivity extends Activity implements TopMenuActivity.c, d.a {

    /* renamed from: a  reason: collision with root package name */
    public ProgressDialog f4365a;

    /* renamed from: b  reason: collision with root package name */
    public Context f4366b;

    /* renamed from: c  reason: collision with root package name */
    public Familia f4367c = null;

    /* renamed from: d  reason: collision with root package name */
    public TextView f4368d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4369e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TopMenuActivity l;
    public a.c.d.d.d m;
    public Handler n = new d();

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            DetalleFamiliaActivity detalleFamiliaActivity = DetalleFamiliaActivity.this;
            detalleFamiliaActivity.m.t(1, new a.c.d.s.g.b(detalleFamiliaActivity.f4367c));
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            Intent intent = new Intent(DetalleFamiliaActivity.this, NuevoFamiliaActivity.class);
            intent.putExtra("KEY_INTENT_FAMILIAR", DetalleFamiliaActivity.this.f4367c);
            DetalleFamiliaActivity.this.startActivity(intent);
            DetalleFamiliaActivity.this.finish();
        }
    }

    public class c implements View.OnClickListener {

        public class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Dialog f4373a;

            public a(c cVar, Dialog dialog) {
                this.f4373a = dialog;
            }

            public void onClick(View view) {
                this.f4373a.dismiss();
            }
        }

        public class b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Dialog f4374a;

            public b(Dialog dialog) {
                this.f4374a = dialog;
            }

            public void onClick(View view) {
                DetalleFamiliaActivity.this.f4365a = new ProgressDialog(DetalleFamiliaActivity.this.f4366b);
                DetalleFamiliaActivity.this.f4365a.setCancelable(false);
                DetalleFamiliaActivity.this.f4365a.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
                DetalleFamiliaActivity.this.f4365a.setIndeterminate(true);
                DetalleFamiliaActivity.this.f4365a.show();
                try {
                    Usuario i = AppMiniland.f().i();
                    new a.h.a.l0.b(DetalleFamiliaActivity.this.n, "&bd=" + i.getBd() + "&bdpre=" + i.getBdpre() + "&idPersona=" + String.valueOf(DetalleFamiliaActivity.this.f4367c.getId()), "familia.php?borrarfamiliar=1").start();
                } catch (Exception unused) {
                    DetalleFamiliaActivity.this.f4365a.dismiss();
                }
                this.f4374a.dismiss();
            }
        }

        public c() {
        }

        public void onClick(View view) {
            Dialog dialog = new Dialog(DetalleFamiliaActivity.this, 2131886561);
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
            DetalleFamiliaActivity.this.f4365a.dismiss();
            if (!(message == null || message.obj == null)) {
                StringBuilder n = a.a.a.a.a.n("SH2:");
                n.append(message.toString());
                Log.d("MINILAND_EBABY", n.toString());
                if ("OK".equalsIgnoreCase(message.obj.toString())) {
                    DetalleFamiliaActivity.this.finish();
                    return;
                }
            }
            Toast.makeText(DetalleFamiliaActivity.this.f4366b, "Error", 0).show();
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
        a.c.d.d.d dVar = this.m;
        if (dVar == null || !dVar.n(i2, i3, intent)) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4366b = this;
        requestWindowFeature(1);
        setContentView(R.layout.activity_detalle_familia);
        this.m = new a.c.d.d.d((Activity) this, (d.a) this, bundle);
        CircularImageView circularImageView = (CircularImageView) findViewById(R.id.lo);
        circularImageView.setBorder(true);
        circularImageView.setBorderColor(getResources().getColor(R.color.azul_selected));
        circularImageView.setImageResource(R.drawable.baby_big_default);
        circularImageView.setOnClickListener(new a());
        ((TextView) findViewById(R.id.sexo_title)).setText(a.c.a.d.a.h(R.string.TR_SEX));
        ((TextView) findViewById(R.id.fechanac_title)).setText(a.c.a.d.a.h(R.string.TR_DATE_BIRTH));
        ((TextView) findViewById(R.id.ojos_title)).setText(a.c.a.d.a.h(R.string.TR_EYES));
        ((TextView) findViewById(R.id.pelo_title)).setText(a.c.a.d.a.h(R.string.TR_HAIR));
        ((TextView) findViewById(R.id.piel_title)).setText(a.c.a.d.a.h(R.string.TR_SKIN));
        TopMenuActivity topMenuActivity = (TopMenuActivity) findViewById(R.id.cabecera);
        this.l = topMenuActivity;
        topMenuActivity.setListener(this);
        this.l.setSeccion(a.c.a.d.a.h(R.string.TR_MENU_FAMILY).toUpperCase());
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("KEY_INTENT_FAMILIAR")) {
            this.f4367c = (Familia) extras.getParcelable("KEY_INTENT_FAMILIAR");
        }
        Familia familia = this.f4367c;
        if (familia == null) {
            finish();
            return;
        }
        if (!familia.isPhotoEmpty()) {
            AppMiniland.f().k.b(this.f4367c.getFoto(), circularImageView, (a.g.a.b.b) null, (a.g.a.b.l.c) null);
        }
        TextView textView = (TextView) findViewById(R.id.nombre);
        this.f4369e = textView;
        textView.setText(this.f4367c.getNombre());
        TextView textView2 = (TextView) findViewById(R.id.apel);
        this.f4368d = textView2;
        textView2.setText(this.f4367c.getApellidos());
        TextView textView3 = (TextView) findViewById(R.id.tipo);
        this.f = textView3;
        textView3.setText(this.f4367c.getTipo());
        TextView textView4 = (TextView) findViewById(R.id.fechanac);
        this.g = textView4;
        textView4.setText(this.f4367c.getFechanacimiento());
        TextView textView5 = (TextView) findViewById(R.id.piel);
        this.h = textView5;
        textView5.setText(this.f4367c.getPiel());
        TextView textView6 = (TextView) findViewById(R.id.pelo);
        this.j = textView6;
        textView6.setText(this.f4367c.getPelo());
        TextView textView7 = (TextView) findViewById(R.id.sexo);
        this.i = textView7;
        textView7.setText(a.c.a.d.a.h("M".equals(this.f4367c.getSexo()) ? R.string.TR_FEMALE : R.string.TR_MALE));
        TextView textView8 = (TextView) findViewById(R.id.ojos);
        this.k = textView8;
        textView8.setText(this.f4367c.getOjos());
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.detalle_familia_buttons_container);
        ((ImageView) viewGroup.findViewById(R.id.layout_ed_edit_button)).setOnClickListener(new b());
        ((ImageView) viewGroup.findViewById(R.id.layout_ed_delete_button)).setOnClickListener(new c());
    }

    public void onResume() {
        super.onResume();
        f.c().e("LA_FAMILIA_DETALLE");
    }
}
