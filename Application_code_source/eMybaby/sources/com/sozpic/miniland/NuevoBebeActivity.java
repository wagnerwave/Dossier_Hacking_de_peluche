package com.sozpic.miniland;

import a.c.a.e.f;
import a.c.d.r.j;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.sozpic.miniland.TopMenuActivity;
import com.sozpic.miniland.modelos.Bebe;
import com.sozpic.miniland.modelos.Usuario;
import com.tuya.smart.common.o0O00000;
import e.a.a.i0.k;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
public class NuevoBebeActivity extends FragmentActivity implements TopMenuActivity.c, View.OnClickListener, DatePickerDialog.OnDateSetListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f4484a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f4485b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f4486c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f4487d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4488e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public RadioGroup m;
    public Button n;
    public Button o;
    public ProgressDialog p;
    public TopMenuActivity q;
    public int r = 0;
    public int s = 0;
    public int t = 0;
    public EditText u;
    public Bebe v;
    public Handler w = new e();

    public class a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RadioButton f4489a;

        public a(NuevoBebeActivity nuevoBebeActivity, RadioButton radioButton) {
            this.f4489a = radioButton;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.f4489a.setTextColor(z ? -1 : -12486401);
        }
    }

    public class b implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RadioButton f4490a;

        public b(NuevoBebeActivity nuevoBebeActivity, RadioButton radioButton) {
            this.f4490a = radioButton;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.f4490a.setTextColor(z ? -1 : -59291);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            String str;
            NuevoBebeActivity nuevoBebeActivity = NuevoBebeActivity.this;
            String str2 = nuevoBebeActivity.t + "-" + nuevoBebeActivity.s + "-" + nuevoBebeActivity.r;
            String str3 = nuevoBebeActivity.m.getCheckedRadioButtonId() == R.id.radioButtonM ? "M" : "V";
            ProgressDialog progressDialog = new ProgressDialog(nuevoBebeActivity.f4484a);
            nuevoBebeActivity.p = progressDialog;
            progressDialog.setCancelable(true);
            nuevoBebeActivity.p.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
            nuevoBebeActivity.p.setIndeterminate(true);
            try {
                if (!nuevoBebeActivity.f4485b.getText().toString().equals("") && !nuevoBebeActivity.f4486c.getText().toString().equals("")) {
                    if (nuevoBebeActivity.t > 0) {
                        nuevoBebeActivity.p.show();
                        Usuario i = AppMiniland.f().i();
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(new k("nombre", nuevoBebeActivity.f4485b.getText().toString()));
                        arrayList.add(new k("apellidos", nuevoBebeActivity.f4486c.getText().toString()));
                        arrayList.add(new k("fechanacimiento", str2));
                        arrayList.add(new k("sexo", str3));
                        arrayList.add(new k("altura", nuevoBebeActivity.f4487d.getText().toString()));
                        arrayList.add(new k("peso", nuevoBebeActivity.f4488e.getText().toString()));
                        arrayList.add(new k("medidacabeza", nuevoBebeActivity.k.getText().toString()));
                        arrayList.add(new k("colorojos", nuevoBebeActivity.f.getText().toString()));
                        arrayList.add(new k("pelo", nuevoBebeActivity.g.getText().toString()));
                        arrayList.add(new k("hospital", nuevoBebeActivity.h.getText().toString()));
                        arrayList.add(new k("ginecologo", nuevoBebeActivity.i.getText().toString()));
                        arrayList.add(new k("matron", nuevoBebeActivity.j.getText().toString()));
                        arrayList.add(new k("foto", ""));
                        arrayList.add(new k("bd", i.getBd()));
                        arrayList.add(new k("bdpre", i.getBdpre()));
                        if (nuevoBebeActivity.v != null) {
                            arrayList.add(new k("idBebe", String.valueOf(nuevoBebeActivity.v.getId())));
                            str = "bebe.php?editarbebe=1";
                        } else {
                            str = "bebe.php?anadirbebe=1";
                        }
                        new a.h.a.l0.a(nuevoBebeActivity.w, arrayList, str).start();
                        return;
                    }
                }
                if (nuevoBebeActivity.f4485b.getText().toString().equals("")) {
                    nuevoBebeActivity.f4485b.setHintTextColor(-59291);
                }
                if (nuevoBebeActivity.f4486c.getText().toString().equals("")) {
                    nuevoBebeActivity.f4486c.setHintTextColor(-59291);
                }
                if (nuevoBebeActivity.t <= 0) {
                    nuevoBebeActivity.u.setHintTextColor(-59291);
                }
                Toast.makeText(nuevoBebeActivity.f4484a, a.c.a.d.a.h(R.string.TR_MENSAJE_FALTAN_CAMPOS), 1).show();
            } catch (Exception unused) {
                nuevoBebeActivity.p.dismiss();
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            NuevoBebeActivity.this.finish();
        }
    }

    public class e extends Handler {
        public e() {
        }

        public void handleMessage(Message message) {
            Object obj;
            NuevoBebeActivity.this.p.dismiss();
            if (!(message == null || (obj = message.obj) == null || a.c.a.d.a.j(obj.toString()))) {
                StringBuilder n = a.a.a.a.a.n("SH2:");
                n.append(message.toString());
                Log.d("MINILAND_EBABY", n.toString());
                String obj2 = message.obj.toString();
                if ("OK".equalsIgnoreCase(obj2)) {
                    Intent intent = new Intent();
                    intent.putExtra("editbaby", o0O00000.O000000o);
                    NuevoBebeActivity.this.setResult(-1, intent);
                    NuevoBebeActivity.this.finish();
                    return;
                }
                try {
                    if (obj2.length() > 0) {
                        new JSONObject(obj2).getString("idBebe");
                        Intent intent2 = new Intent();
                        intent2.putExtra("nuevobebe", o0O00000.O000000o);
                        NuevoBebeActivity.this.setResult(-1, intent2);
                        ((InputMethodManager) NuevoBebeActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(NuevoBebeActivity.this.f4485b.getWindowToken(), 0);
                        f.c().d("MIBEBE", "BEBE_GUARDADO", "");
                        NuevoBebeActivity.this.finish();
                        return;
                    }
                    Toast.makeText(NuevoBebeActivity.this.f4484a, "Error", 0).show();
                    return;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            Toast.makeText(NuevoBebeActivity.this.f4484a, "Error", 0).show();
        }
    }

    public void a() {
        finish();
    }

    public void b() {
    }

    public void onClick(View view) {
        int i2;
        int i3;
        int i4;
        if (view == this.u) {
            int i5 = this.r;
            if (i5 > 0) {
                i4 = this.s - 1;
                i3 = i5;
                i2 = this.t;
            } else {
                Calendar instance = Calendar.getInstance();
                int i6 = instance.get(1);
                i4 = instance.get(2);
                i2 = instance.get(5);
                i3 = i6;
            }
            new DatePickerDialog(this, this, i3, i4, i2).show();
        }
    }

    public void onCreate(Bundle bundle) {
        String str;
        TextView textView;
        super.onCreate(bundle);
        this.f4484a = this;
        requestWindowFeature(1);
        setContentView(R.layout.activity_nuevo_bebe);
        TopMenuActivity topMenuActivity = (TopMenuActivity) findViewById(R.id.cabecera);
        this.q = topMenuActivity;
        topMenuActivity.setListener(this);
        this.q.setSeccion(a.c.a.d.a.h(R.string.TR_MENU_MY_BABY));
        Bundle extras = getIntent().getExtras();
        this.v = (extras == null || !extras.containsKey("KEY_INTENT_BABY")) ? null : (Bebe) extras.getParcelable("KEY_INTENT_BABY");
        ((TextView) findViewById(R.id.txt_datos_nacimiento)).setText(a.c.a.d.a.h(R.string.TR_BIRTH_INFORMATION));
        TextView textView2 = (TextView) findViewById(R.id.et_nombre);
        this.f4485b = textView2;
        textView2.setHint(a.c.a.d.a.h(R.string.TR_NAME));
        TextView textView3 = (TextView) findViewById(R.id.et_apellidos);
        this.f4486c = textView3;
        textView3.setHint(a.c.a.d.a.h(R.string.TR_SURNAME));
        TextView textView4 = (TextView) findViewById(R.id.et_altura);
        this.f4487d = textView4;
        textView4.setHint(a.c.a.d.a.h(R.string.TR_HEIGHT));
        TextView textView5 = (TextView) findViewById(R.id.et_peso);
        this.f4488e = textView5;
        textView5.setHint(a.c.a.d.a.h(R.string.TR_WEIGHT_KG));
        TextView textView6 = (TextView) findViewById(R.id.et_ojos);
        this.f = textView6;
        textView6.setHint(a.c.a.d.a.h(R.string.TR_EYE_COLOR));
        TextView textView7 = (TextView) findViewById(R.id.et_pelo);
        this.g = textView7;
        textView7.setHint(a.c.a.d.a.h(R.string.TR_HAIR));
        TextView textView8 = (TextView) findViewById(R.id.et_hospital);
        this.h = textView8;
        textView8.setHint(a.c.a.d.a.h(R.string.TR_HOSPITAL));
        TextView textView9 = (TextView) findViewById(R.id.et_ginecologo);
        this.i = textView9;
        textView9.setHint(a.c.a.d.a.h(R.string.TR_GINECOLYST));
        TextView textView10 = (TextView) findViewById(R.id.et_matrona);
        this.j = textView10;
        textView10.setHint(a.c.a.d.a.h(R.string.TR_MIDWIFE));
        TextView textView11 = (TextView) findViewById(R.id.et_medidacabeza);
        this.k = textView11;
        textView11.setHint(a.c.a.d.a.h(R.string.TR_CRANIAL_PERIMETER));
        TextView textView12 = (TextView) findViewById(R.id.et_piel);
        this.l = textView12;
        textView12.setHint(a.c.a.d.a.h(R.string.TR_SKIN));
        EditText editText = (EditText) findViewById(R.id.et_fecha);
        this.u = editText;
        editText.setHint(a.c.a.d.a.h(R.string.TR_DATE_BIRTH));
        this.u.setOnClickListener(this);
        this.m = (RadioGroup) findViewById(R.id.radio);
        RadioButton radioButton = (RadioButton) findViewById(R.id.radioButtonV);
        radioButton.setText(a.c.a.d.a.h(R.string.TR_MALE));
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButtonM);
        radioButton2.setText(a.c.a.d.a.h(R.string.TR_FEMALE));
        radioButton.setOnCheckedChangeListener(new a(this, radioButton));
        radioButton2.setOnCheckedChangeListener(new b(this, radioButton2));
        Bebe bebe = this.v;
        if (bebe != null) {
            this.f4485b.setText(bebe.getNombre());
            this.f4486c.setText(this.v.getApellidos());
            this.f.setText(this.v.getColorojos());
            this.g.setText(this.v.getPelo());
            this.l.setText(this.v.getPiel());
            this.h.setText(this.v.getHospital());
            this.i.setText(this.v.getGinecologo());
            this.j.setText(this.v.getMatron());
            this.f4488e.setText(String.valueOf(this.v.getPeso()));
            this.f4487d.setText(String.valueOf(this.v.getAltura()));
            if ("0.00".equals(this.v.getMedidacabeza())) {
                textView = this.k;
                str = "";
            } else {
                textView = this.k;
                str = this.v.getMedidacabeza();
            }
            textView.setText(str);
            if ("M".equals(this.v.getSexo())) {
                radioButton2.setSelected(true);
            } else {
                radioButton.setSelected(true);
            }
            this.u.setText(this.v.getFechanacimiento());
            try {
                Date parse = j.f.parse(this.v.getFechanacimiento());
                Calendar instance = Calendar.getInstance();
                instance.setTime(parse);
                this.t = instance.get(5);
                this.s = instance.get(2) + 1;
                this.r = instance.get(1);
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        }
        Button button = (Button) findViewById(R.id.bebeguardar);
        this.n = button;
        button.setText(a.c.a.d.a.h(R.string.TR_GUARDAR).toUpperCase());
        this.n.setOnClickListener(new c());
        Button button2 = (Button) findViewById(R.id.btnCancel);
        this.o = button2;
        button2.setText(a.c.a.d.a.h(R.string.TR_CANCEL).toUpperCase());
        this.o.setOnClickListener(new d());
    }

    public void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
        EditText editText = this.u;
        StringBuilder sb = new StringBuilder();
        sb.append(i4);
        sb.append("-");
        int i5 = i3 + 1;
        sb.append(i5);
        sb.append("-");
        sb.append(i2);
        editText.setText(sb.toString());
        this.r = i2;
        this.s = i5;
        this.t = i4;
    }

    public void onResume() {
        super.onResume();
        f.c().e("MIBEBE_ANYADIR");
    }
}
