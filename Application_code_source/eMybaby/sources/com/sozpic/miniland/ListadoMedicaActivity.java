package com.sozpic.miniland;

import a.g.a.b.l.c;
import a.h.a.k0.d;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.cuatroochenta.commons.widget.CircularImageView;
import com.sozpic.miniland.TopMenuActivity;
import com.sozpic.miniland.modelos.Bebe;
import com.sozpic.miniland.modelos.Medica;
import com.sozpic.miniland.modelos.Usuario;
import com.tuya.smart.common.o0O00000;
import com.tuya.smart.common.oOO0O0O0;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;

public class ListadoMedicaActivity extends Activity implements View.OnClickListener, TopMenuActivity.c {

    /* renamed from: a  reason: collision with root package name */
    public Context f4429a;

    /* renamed from: b  reason: collision with root package name */
    public ListView f4430b;

    /* renamed from: c  reason: collision with root package name */
    public ProgressDialog f4431c;

    /* renamed from: d  reason: collision with root package name */
    public Medica[] f4432d = null;

    /* renamed from: e  reason: collision with root package name */
    public Medica f4433e;
    public Activity f;
    public int g;
    public int h = 0;
    public TextView i;
    public TextView j;
    public TopMenuActivity k;
    public Bebe l;
    public LinearLayout m;
    public LinearLayout n;
    public LinearLayout o;
    public LinearLayout p;
    public TextView q;
    public TextView r;
    public TextView s;
    public Handler t = new b();

    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Medica medica = (Medica) ListadoMedicaActivity.this.f4430b.getAdapter().getItem(i);
            if (!medica.getId().equals(oOO0O0O0.O0000oO0)) {
                Intent intent = null;
                if (medica.getTipo() == 3) {
                    intent = new Intent(ListadoMedicaActivity.this.f4429a, DetalleMedicaVacunaActivity.class);
                } else if (medica.getTipo() == 2) {
                    intent = new Intent(ListadoMedicaActivity.this.f4429a, DetalleMedicaCitaActivity.class);
                } else if (medica.getTipo() == 1) {
                    intent = new Intent(ListadoMedicaActivity.this.f4429a, DetalleMedicaCrecimientoActivity.class);
                }
                if (intent != null) {
                    intent.putExtra("KEY_INTENT_MEDICAL_RECORD", medica);
                    intent.putExtra("KEY_INTENT_BABY", ListadoMedicaActivity.this.l);
                    ListadoMedicaActivity.this.startActivity(intent);
                }
            }
        }
    }

    public class b extends Handler {
        public b() {
        }

        public void handleMessage(Message message) {
            ListadoMedicaActivity.this.f4431c.dismiss();
            Medica[] medicaArr = null;
            if (message == null || message.obj == null) {
                ListadoMedicaActivity.this.f4430b.setAdapter((ListAdapter) null);
                Toast.makeText(ListadoMedicaActivity.this.f4429a, "Error", 0).show();
                return;
            }
            StringBuilder n = a.a.a.a.a.n("SH2:");
            n.append(message.toString());
            Log.d("MINILAND_EBABY", n.toString());
            ListadoMedicaActivity listadoMedicaActivity = ListadoMedicaActivity.this;
            int i = listadoMedicaActivity.h;
            if (i == 1) {
                String obj = message.obj.toString();
                if (!(obj == null || obj.length() <= 0 || obj.length() == 0)) {
                    try {
                        JSONArray jSONArray = new JSONArray(obj);
                        medicaArr = new Medica[jSONArray.length()];
                        int i2 = 0;
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            medicaArr[i2] = new Medica(jSONArray.getJSONObject(i3));
                            i2++;
                        }
                    } catch (JSONException e2) {
                        StringBuilder n2 = a.a.a.a.a.n("Ex: ");
                        n2.append(e2.toString());
                        a.e.a.a.r.b.j("parsejson", n2.toString());
                    }
                }
                listadoMedicaActivity.f4432d = medicaArr;
            } else if (i == 2) {
                String obj2 = message.obj.toString();
                if (!(obj2 == null || obj2.length() <= 0 || obj2.length() == 0)) {
                    try {
                        JSONArray jSONArray2 = new JSONArray(obj2);
                        medicaArr = new Medica[jSONArray2.length()];
                        int i4 = 0;
                        for (int i5 = 0; i5 < jSONArray2.length(); i5++) {
                            medicaArr[i4] = new Medica(jSONArray2.getJSONObject(i5));
                            i4++;
                        }
                    } catch (JSONException e3) {
                        StringBuilder n3 = a.a.a.a.a.n("Ex: ");
                        n3.append(e3.toString());
                        a.e.a.a.r.b.j("parsejson", n3.toString());
                    }
                }
                listadoMedicaActivity.f4432d = medicaArr;
            } else if (i == 3) {
                String obj3 = message.obj.toString();
                if (!(obj3 == null || obj3.length() <= 0 || obj3.length() == 0)) {
                    try {
                        JSONArray jSONArray3 = new JSONArray(obj3);
                        medicaArr = new Medica[jSONArray3.length()];
                        int i6 = 0;
                        for (int i7 = 0; i7 < jSONArray3.length(); i7++) {
                            medicaArr[i6] = new Medica(jSONArray3.getJSONObject(i7));
                            i6++;
                        }
                    } catch (JSONException e4) {
                        StringBuilder n4 = a.a.a.a.a.n("Ex: ");
                        n4.append(e4.toString());
                        a.e.a.a.r.b.j("parsejson", n4.toString());
                    }
                }
                listadoMedicaActivity.f4432d = medicaArr;
            }
            ListadoMedicaActivity listadoMedicaActivity2 = ListadoMedicaActivity.this;
            if (listadoMedicaActivity2.f4432d == null) {
                Medica[] medicaArr2 = new Medica[1];
                listadoMedicaActivity2.f4432d = medicaArr2;
                medicaArr2[0] = listadoMedicaActivity2.f4433e;
            }
            ListadoMedicaActivity listadoMedicaActivity3 = ListadoMedicaActivity.this;
            ListadoMedicaActivity.this.f4430b.setAdapter(new d(listadoMedicaActivity3.f, listadoMedicaActivity3.f4432d));
            a.e.a.a.r.b.Z(ListadoMedicaActivity.this.f4430b);
        }
    }

    public ListadoMedicaActivity() {
        new ArrayList();
    }

    public void a() {
        finish();
    }

    public void b() {
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        a.h.a.l0.b bVar;
        if (intent != null) {
            if (intent.getStringExtra("nuevocrecimiento") != null) {
                if (intent.getStringExtra("nuevocrecimiento").equals(o0O00000.O000000o)) {
                    ProgressDialog progressDialog = new ProgressDialog(this.f4429a);
                    this.f4431c = progressDialog;
                    progressDialog.setCancelable(false);
                    this.f4431c.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
                    this.f4431c.setIndeterminate(true);
                    this.f4431c.show();
                    this.h = 1;
                    try {
                        Usuario i4 = AppMiniland.f().i();
                        bVar = new a.h.a.l0.b(this.t, "&bd=" + i4.getBd() + "&bdpre=" + i4.getBdpre() + "&idBebe=" + this.l.getId() + "&lang=" + Locale.getDefault().getLanguage(), "fichamedica.php?vercrecimiento=1");
                    } catch (Exception unused) {
                        this.f4431c.dismiss();
                        return;
                    }
                } else {
                    return;
                }
            } else if (intent.getStringExtra("nuevocita") != null) {
                if (intent.getStringExtra("nuevocita").equals(o0O00000.O000000o)) {
                    ProgressDialog progressDialog2 = new ProgressDialog(this.f4429a);
                    this.f4431c = progressDialog2;
                    progressDialog2.setCancelable(false);
                    this.f4431c.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
                    this.f4431c.setIndeterminate(true);
                    this.f4431c.show();
                    this.h = 2;
                    Usuario i5 = AppMiniland.f().i();
                    bVar = new a.h.a.l0.b(this.t, "&bd=" + i5.getBd() + "&bdpre=" + i5.getBdpre() + "&idBebe=" + this.l.getId() + "&lang=" + Locale.getDefault().getLanguage(), "fichamedica.php?vercitamedica=1");
                } else {
                    return;
                }
            } else if (intent.getStringExtra("nuevovacuna") != null && intent.getStringExtra("nuevovacuna").equals(o0O00000.O000000o)) {
                ProgressDialog progressDialog3 = new ProgressDialog(this.f4429a);
                this.f4431c = progressDialog3;
                progressDialog3.setCancelable(false);
                this.f4431c.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
                this.f4431c.setIndeterminate(true);
                this.f4431c.show();
                this.h = 3;
                Usuario i6 = AppMiniland.f().i();
                bVar = new a.h.a.l0.b(this.t, "&bd=" + i6.getBd() + "&bdpre=" + i6.getBdpre() + "&idBebe=" + this.l.getId() + "&lang=" + Locale.getDefault().getLanguage(), "fichamedica.php?vervacunas=1");
            } else {
                return;
            }
            bVar.start();
        }
    }

    public void onClick(View view) {
        a.h.a.l0.b bVar;
        LinearLayout linearLayout = this.m;
        if (view != linearLayout) {
            LinearLayout linearLayout2 = this.o;
            if (view != linearLayout2) {
                LinearLayout linearLayout3 = this.n;
                if (view == linearLayout3) {
                    if (!linearLayout3.isSelected()) {
                        this.n.setSelected(true);
                        this.m.setSelected(false);
                        this.o.setSelected(false);
                        this.r.setTextColor(-1);
                        this.q.setTextColor(-12566463);
                        this.s.setTextColor(-12566463);
                        this.h = 3;
                        this.g = 2;
                        ProgressDialog progressDialog = new ProgressDialog(this.f4429a);
                        this.f4431c = progressDialog;
                        progressDialog.setCancelable(false);
                        this.f4431c.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
                        this.f4431c.setIndeterminate(true);
                        this.f4431c.show();
                        Usuario i2 = AppMiniland.f().i();
                        bVar = new a.h.a.l0.b(this.t, "&bd=" + i2.getBd() + "&bdpre=" + i2.getBdpre() + "&idBebe=" + this.l.getId() + "&lang=" + Locale.getDefault().getLanguage(), "fichamedica.php?vervacunas=1");
                    } else {
                        return;
                    }
                } else if (this.p == view) {
                    Intent intent = new Intent(this.f4429a, ListadoMedicaPreviaActivity.class);
                    intent.putExtra("KEY_INTENT_BABY", this.l);
                    startActivityForResult(intent, 0);
                    return;
                } else {
                    return;
                }
            } else if (!linearLayout2.isSelected()) {
                this.o.setSelected(true);
                this.n.setSelected(false);
                this.m.setSelected(false);
                this.s.setTextColor(-1);
                this.r.setTextColor(-12566463);
                this.q.setTextColor(-12566463);
                this.g = 1;
                this.h = 1;
                ProgressDialog progressDialog2 = new ProgressDialog(this.f4429a);
                this.f4431c = progressDialog2;
                progressDialog2.setCancelable(false);
                this.f4431c.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
                this.f4431c.setIndeterminate(true);
                this.f4431c.show();
                try {
                    Usuario i3 = AppMiniland.f().i();
                    bVar = new a.h.a.l0.b(this.t, "&bd=" + i3.getBd() + "&bdpre=" + i3.getBdpre() + "&idBebe=" + this.l.getId() + "&lang=" + Locale.getDefault().getLanguage(), "fichamedica.php?vercrecimiento=1");
                } catch (Exception unused) {
                    this.f4431c.dismiss();
                    return;
                }
            } else {
                return;
            }
            bVar.start();
        } else if (!linearLayout.isSelected()) {
            this.m.setSelected(true);
            this.n.setSelected(false);
            this.o.setSelected(false);
            this.q.setTextColor(-1);
            this.r.setTextColor(-12566463);
            this.s.setTextColor(-12566463);
            this.g = 0;
            ProgressDialog progressDialog3 = new ProgressDialog(this.f4429a);
            this.f4431c = progressDialog3;
            progressDialog3.setCancelable(false);
            this.f4431c.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
            this.f4431c.setIndeterminate(true);
            this.f4431c.show();
            try {
                Usuario i4 = AppMiniland.f().i();
                new a.h.a.l0.b(this.t, "&bd=" + i4.getBd() + "&bdpre=" + i4.getBdpre() + "&idBebe=" + this.l.getId() + "&lang=" + Locale.getDefault().getLanguage(), "fichamedica.php?vercitamedica=1").start();
            } catch (Exception unused2) {
                this.f4431c.dismiss();
            }
            this.h = 2;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4429a = this;
        requestWindowFeature(1);
        setContentView(R.layout.activity_listado_medica);
        this.f = this;
        this.g = 0;
        TopMenuActivity topMenuActivity = (TopMenuActivity) findViewById(R.id.cabecera);
        this.k = topMenuActivity;
        topMenuActivity.setListener(this);
        this.k.setSeccion(a.c.a.d.a.h(R.string.TR_MENU_MEDICAL_RECORDS));
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("KEY_INTENT_BABY")) {
            this.l = (Bebe) extras.getParcelable("KEY_INTENT_BABY");
        }
        if (this.l == null) {
            finish();
            return;
        }
        CircularImageView circularImageView = (CircularImageView) findViewById(R.id.lo);
        circularImageView.setBorder(true);
        circularImageView.setBorderColor(getResources().getColor(R.color.selected_medica));
        circularImageView.setImageResource(R.drawable.baby_big_default);
        if (!this.l.isPhotoEmpty()) {
            AppMiniland.f().k.b(this.l.getFoto(), circularImageView, (a.g.a.b.b) null, (c) null);
        }
        this.f4430b = (ListView) findViewById(R.id.list_bebe_medico);
        TextView textView = (TextView) findViewById(R.id.tv_crio);
        this.i = textView;
        textView.setText(this.l.getNombre());
        TextView textView2 = (TextView) findViewById(R.id.apellido);
        this.j = textView2;
        textView2.setText(this.l.getApellidos());
        this.f4430b.setOnItemClickListener(new a());
        Medica medica = new Medica();
        this.f4433e = medica;
        medica.setId(oOO0O0O0.O0000oO0);
        this.f4433e.setFechacrecimiento(a.c.a.d.a.h(R.string.TR_EMPTY));
        this.h = 2;
        TextView textView3 = (TextView) findViewById(R.id.op1);
        this.q = textView3;
        textView3.setTextColor(-1);
        this.q.setText(a.c.a.d.a.h(R.string.TR_APPOINTMENT).toUpperCase());
        ((TextView) findViewById(R.id.op1_1)).setText(a.c.a.d.a.h(R.string.TR_MEDICAL).toUpperCase());
        ((TextView) findViewById(R.id.op2_1)).setText(a.c.a.d.a.h(R.string.TR_REGISTER).toUpperCase());
        ((TextView) findViewById(R.id.op3_1)).setText(a.c.a.d.a.h(R.string.TR_REGISTER).toUpperCase());
        TextView textView4 = (TextView) findViewById(R.id.op2);
        this.r = textView4;
        textView4.setText(a.c.a.d.a.h(R.string.TR_VACCINATION).toUpperCase());
        TextView textView5 = (TextView) findViewById(R.id.op3);
        this.s = textView5;
        textView5.setText(a.c.a.d.a.h(R.string.TR_GROWTH).toUpperCase());
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.lop1);
        this.m = linearLayout;
        linearLayout.setOnClickListener(this);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.lop2);
        this.n = linearLayout2;
        linearLayout2.setOnClickListener(this);
        LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.lop3);
        this.o = linearLayout3;
        linearLayout3.setOnClickListener(this);
        LinearLayout linearLayout4 = (LinearLayout) findViewById(R.id.nuevo);
        this.p = linearLayout4;
        linearLayout4.setOnClickListener(this);
        this.m.setSelected(true);
    }

    public void onResume() {
        a.h.a.l0.b bVar;
        super.onResume();
        int i2 = this.g;
        if (i2 == 0) {
            ProgressDialog progressDialog = new ProgressDialog(this.f4429a);
            this.f4431c = progressDialog;
            progressDialog.setCancelable(false);
            this.f4431c.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
            this.f4431c.setIndeterminate(true);
            this.f4431c.show();
            this.h = 2;
            try {
                Usuario i3 = AppMiniland.f().i();
                bVar = new a.h.a.l0.b(this.t, "&bd=" + i3.getBd() + "&bdpre=" + i3.getBdpre() + "&idBebe=" + this.l.getId() + "&lang=" + Locale.getDefault().getLanguage(), "fichamedica.php?vercitamedica=1");
            } catch (Exception unused) {
                this.f4431c.dismiss();
                return;
            }
        } else if (i2 == 1) {
            ProgressDialog progressDialog2 = new ProgressDialog(this.f4429a);
            this.f4431c = progressDialog2;
            progressDialog2.setCancelable(false);
            this.f4431c.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
            this.f4431c.setIndeterminate(true);
            this.f4431c.show();
            this.h = 1;
            Usuario i4 = AppMiniland.f().i();
            bVar = new a.h.a.l0.b(this.t, "&bd=" + i4.getBd() + "&bdpre=" + i4.getBdpre() + "&idBebe=" + this.l.getId() + "&lang=" + Locale.getDefault().getLanguage(), "fichamedica.php?vercrecimiento=1");
        } else if (i2 == 2) {
            ProgressDialog progressDialog3 = new ProgressDialog(this.f4429a);
            this.f4431c = progressDialog3;
            progressDialog3.setCancelable(false);
            this.f4431c.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
            this.f4431c.setIndeterminate(true);
            this.f4431c.show();
            this.h = 3;
            Usuario i5 = AppMiniland.f().i();
            bVar = new a.h.a.l0.b(this.t, "&bd=" + i5.getBd() + "&bdpre=" + i5.getBdpre() + "&idBebe=" + this.l.getId() + "&lang=" + Locale.getDefault().getLanguage(), "fichamedica.php?vervacunas=1");
        } else {
            return;
        }
        bVar.start();
    }
}
