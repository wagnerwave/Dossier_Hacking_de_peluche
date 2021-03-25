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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.sozpic.miniland.TopMenuActivity;
import com.sozpic.miniland.modelos.Familia;
import com.sozpic.miniland.modelos.Usuario;
import com.tuya.smart.common.o0O00000;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
public class NuevoFamiliaActivity extends FragmentActivity implements TopMenuActivity.c, View.OnClickListener, DatePickerDialog.OnDateSetListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f4502a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f4503b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f4504c;

    /* renamed from: d  reason: collision with root package name */
    public RadioGroup f4505d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4506e;
    public TextView f;
    public TextView g;
    public Spinner h;
    public Button i;
    public Button j;
    public ProgressDialog k;
    public TopMenuActivity l;
    public int m;
    public int n;
    public int o;
    public EditText p;
    public Familia q;
    public Handler r = new e();

    public class a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RadioButton f4507a;

        public a(NuevoFamiliaActivity nuevoFamiliaActivity, RadioButton radioButton) {
            this.f4507a = radioButton;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.f4507a.setTextColor(z ? -1 : -12486401);
        }
    }

    public class b implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RadioButton f4508a;

        public b(NuevoFamiliaActivity nuevoFamiliaActivity, RadioButton radioButton) {
            this.f4508a = radioButton;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.f4508a.setTextColor(z ? -1 : -59291);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            String str;
            NuevoFamiliaActivity nuevoFamiliaActivity = NuevoFamiliaActivity.this;
            if (nuevoFamiliaActivity != null) {
                ProgressDialog progressDialog = new ProgressDialog(nuevoFamiliaActivity.f4502a);
                nuevoFamiliaActivity.k = progressDialog;
                progressDialog.setCancelable(false);
                nuevoFamiliaActivity.k.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
                nuevoFamiliaActivity.k.setIndeterminate(true);
                try {
                    if (!nuevoFamiliaActivity.f4503b.getText().toString().equals("") && !nuevoFamiliaActivity.f4504c.getText().toString().equals("")) {
                        if (nuevoFamiliaActivity.m > 0) {
                            nuevoFamiliaActivity.k.show();
                            String str2 = nuevoFamiliaActivity.o + "-" + nuevoFamiliaActivity.n + "-" + nuevoFamiliaActivity.m;
                            String str3 = nuevoFamiliaActivity.f4505d.getCheckedRadioButtonId() == R.id.radioButtonM ? "M" : "V";
                            Usuario i = AppMiniland.f().i();
                            HashMap hashMap = new HashMap();
                            new ArrayList(1);
                            hashMap.put("nombre", nuevoFamiliaActivity.f4503b.getText().toString());
                            hashMap.put("apellidos", nuevoFamiliaActivity.f4504c.getText().toString());
                            hashMap.put("tipopersona", String.valueOf(nuevoFamiliaActivity.h.getSelectedItemPosition() + 1));
                            hashMap.put("sexo", str3);
                            hashMap.put("fechanacimiento", str2);
                            hashMap.put("colorojos", nuevoFamiliaActivity.f4506e.getText().toString());
                            hashMap.put("pelo", nuevoFamiliaActivity.f.getText().toString());
                            hashMap.put("foto", "");
                            hashMap.put("bd", i.getBd());
                            hashMap.put("bdpre", i.getBdpre());
                            if (nuevoFamiliaActivity.q != null) {
                                hashMap.put("idPersona", String.valueOf(nuevoFamiliaActivity.q.getId()));
                                str = "editarfamiliar";
                            } else {
                                str = "anadirfamiliar";
                            }
                            hashMap.put(str, "1");
                            new a.h.a.l0.b(nuevoFamiliaActivity.r, a.c.a.d.a.c("https://emybaby.com/api/familia.php", hashMap)).start();
                            return;
                        }
                    }
                    Toast.makeText(nuevoFamiliaActivity.f4502a, a.c.a.d.a.h(R.string.TR_MENSAJE_FALTAN_CAMPOS), 1).show();
                    if (nuevoFamiliaActivity.f4503b.getText().toString().equals("")) {
                        nuevoFamiliaActivity.f4503b.setHintTextColor(-59291);
                    }
                    if (nuevoFamiliaActivity.f4504c.getText().toString().equals("")) {
                        nuevoFamiliaActivity.f4504c.setHintTextColor(-59291);
                    }
                    if (nuevoFamiliaActivity.o <= 0) {
                        nuevoFamiliaActivity.p.setHintTextColor(-59291);
                    }
                } catch (Exception unused) {
                    nuevoFamiliaActivity.k.dismiss();
                }
            } else {
                throw null;
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            NuevoFamiliaActivity.this.finish();
        }
    }

    public class e extends Handler {
        public e() {
        }

        public void handleMessage(Message message) {
            Object obj;
            NuevoFamiliaActivity.this.k.dismiss();
            if (!(message == null || (obj = message.obj) == null || a.c.a.d.a.j(obj.toString()))) {
                StringBuilder n = a.a.a.a.a.n("SH2:");
                n.append(message.toString());
                Log.d("MINILAND_EBABY", n.toString());
                String obj2 = message.obj.toString();
                if ("OK".equalsIgnoreCase(obj2)) {
                    Intent intent = new Intent();
                    intent.putExtra("editafamilia", o0O00000.O000000o);
                    NuevoFamiliaActivity.this.setResult(-1, intent);
                    NuevoFamiliaActivity.this.finish();
                    return;
                }
                try {
                    if (new JSONObject(obj2).has("idPersona")) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("nuevofamilia", o0O00000.O000000o);
                        NuevoFamiliaActivity.this.setResult(-1, intent2);
                        ((InputMethodManager) NuevoFamiliaActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(NuevoFamiliaActivity.this.f4503b.getWindowToken(), 0);
                        NuevoFamiliaActivity.this.finish();
                        return;
                    }
                    Toast.makeText(NuevoFamiliaActivity.this.f4502a, "Error", 0).show();
                    return;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            Toast.makeText(NuevoFamiliaActivity.this.f4502a, "Error", 0).show();
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
        if (view == this.p) {
            int i5 = this.m;
            if (i5 > 0) {
                i4 = this.n - 1;
                i3 = i5;
                i2 = this.o;
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
        super.onCreate(bundle);
        this.f4502a = this;
        requestWindowFeature(1);
        setContentView(R.layout.activity_nuevo_familia);
        TopMenuActivity topMenuActivity = (TopMenuActivity) findViewById(R.id.cabecera);
        this.l = topMenuActivity;
        topMenuActivity.setListener(this);
        this.l.setSeccion(a.c.a.d.a.h(R.string.TR_MENU_FAMILY));
        Bundle extras = getIntent().getExtras();
        this.q = (extras == null || !extras.containsKey("KEY_INTENT_FAMILIAR")) ? null : (Familia) extras.getParcelable("KEY_INTENT_FAMILIAR");
        TextView textView = (TextView) findViewById(R.id.et_nombre);
        this.f4503b = textView;
        textView.setHint(a.c.a.d.a.h(R.string.TR_NAME));
        TextView textView2 = (TextView) findViewById(R.id.et_apellidos);
        this.f4504c = textView2;
        textView2.setHint(a.c.a.d.a.h(R.string.TR_SURNAME));
        TextView textView3 = (TextView) findViewById(R.id.et_ojos);
        this.f4506e = textView3;
        textView3.setHint(a.c.a.d.a.h(R.string.TR_EYE_COLOR));
        TextView textView4 = (TextView) findViewById(R.id.et_pelo);
        this.f = textView4;
        textView4.setHint(a.c.a.d.a.h(R.string.TR_HAIR));
        TextView textView5 = (TextView) findViewById(R.id.et_piel);
        this.g = textView5;
        textView5.setHint(a.c.a.d.a.h(R.string.TR_SKIN));
        this.h = (Spinner) findViewById(R.id.spinner1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a.c.a.d.a.h(R.string.TR_BROTHER_SISTER));
        arrayList.add(a.c.a.d.a.h(R.string.TR_MOTHER));
        arrayList.add(a.c.a.d.a.h(R.string.TR_FATHER));
        arrayList.add(a.c.a.d.a.h(R.string.TR_COUSIN));
        arrayList.add(a.c.a.d.a.h(R.string.TR_UNCLE_AUNT));
        arrayList.add(a.c.a.d.a.h(R.string.TR_GRAND_FATHER_MOTHER));
        arrayList.add(a.c.a.d.a.h(R.string.TR_OTHER));
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        this.h.setAdapter(arrayAdapter);
        EditText editText = (EditText) findViewById(R.id.et_fecha);
        this.p = editText;
        editText.setHint(a.c.a.d.a.h(R.string.TR_DATE_BIRTH));
        this.p.setOnClickListener(this);
        this.f4505d = (RadioGroup) findViewById(R.id.radio);
        RadioButton radioButton = (RadioButton) findViewById(R.id.radioButtonV);
        radioButton.setText(a.c.a.d.a.h(R.string.TR_MALE));
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButtonM);
        radioButton2.setText(a.c.a.d.a.h(R.string.TR_FEMALE));
        radioButton.setOnCheckedChangeListener(new a(this, radioButton));
        radioButton2.setOnCheckedChangeListener(new b(this, radioButton2));
        Familia familia = this.q;
        if (familia != null) {
            this.f4503b.setText(familia.getNombre());
            this.f4504c.setText(this.q.getApellidos());
            this.f4506e.setText(this.q.getOjos());
            this.f.setText(this.q.getPelo());
            this.g.setText(this.q.getPiel());
            if ("M".equals(this.q.getSexo())) {
                radioButton2.setSelected(true);
            } else {
                radioButton.setSelected(true);
            }
            this.p.setText(this.q.getFechanacimiento());
            try {
                Date parse = j.f.parse(this.q.getFechanacimiento());
                Calendar instance = Calendar.getInstance();
                instance.setTime(parse);
                this.o = instance.get(5);
                this.n = instance.get(2) + 1;
                this.m = instance.get(1);
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
            this.h.setSelection(Integer.valueOf(this.q.getTipoId()).intValue() - 1);
        }
        Button button = (Button) findViewById(R.id.familiaguardar);
        this.i = button;
        button.setOnClickListener(new c());
        this.i.setText(a.c.a.d.a.h(R.string.TR_GUARDAR).toUpperCase());
        Button button2 = (Button) findViewById(R.id.btnCancel);
        this.j = button2;
        button2.setOnClickListener(new d());
        this.j.setText(a.c.a.d.a.h(R.string.TR_CANCEL).toUpperCase());
    }

    public void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
        EditText editText = this.p;
        StringBuilder sb = new StringBuilder();
        sb.append(i4);
        sb.append("/");
        int i5 = i3 + 1;
        sb.append(i5);
        sb.append("/");
        sb.append(i2);
        editText.setText(sb.toString());
        this.m = i2;
        this.n = i5;
        this.o = i4;
    }

    public void onResume() {
        super.onResume();
        f.c().e("LA_FAMILIA_ANYADIR");
    }
}
