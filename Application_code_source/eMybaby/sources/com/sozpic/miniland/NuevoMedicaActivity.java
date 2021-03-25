package com.sozpic.miniland;

import a.c.d.r.j;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.sozpic.miniland.TopMenuActivity;
import com.sozpic.miniland.modelos.Bebe;
import com.sozpic.miniland.modelos.Medica;
import com.sozpic.miniland.modelos.Usuario;
import com.tuya.smart.common.o0O00000;
import com.tuya.smart.common.oOO0O0O0;
import e.a.a.i0.k;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
public class NuevoMedicaActivity extends FragmentActivity implements TopMenuActivity.c, View.OnClickListener, TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {
    public Button A;
    public Bebe B;
    public Medica C;
    public int D;
    public ProgressDialog E;
    public TopMenuActivity F;
    public Handler G = new g();
    public Handler H = new h();
    public Handler I = new i();

    /* renamed from: a  reason: collision with root package name */
    public Context f4512a;

    /* renamed from: b  reason: collision with root package name */
    public View f4513b;

    /* renamed from: c  reason: collision with root package name */
    public View f4514c;

    /* renamed from: d  reason: collision with root package name */
    public View f4515d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f4516e;
    public EditText f;
    public EditText g;
    public EditText h;
    public EditText i;
    public EditText j;
    public Spinner k;
    public int l;
    public int m;
    public int n;
    public String o = "";
    public String p;
    public EditText q;
    public EditText r;
    public EditText s;
    public EditText t;
    public EditText u;
    public Spinner v;
    public EditText w;
    public EditText x;
    public EditText y;
    public Button z;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            NuevoMedicaActivity.this.finish();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            boolean z;
            String str;
            NuevoMedicaActivity.this.E = new ProgressDialog(NuevoMedicaActivity.this.f4512a);
            NuevoMedicaActivity.this.E.setCancelable(false);
            NuevoMedicaActivity.this.E.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
            NuevoMedicaActivity.this.E.setIndeterminate(true);
            try {
                Float valueOf = NuevoMedicaActivity.this.x.getText().length() > 0 ? Float.valueOf(NuevoMedicaActivity.this.x.getText().toString()) : Float.valueOf(0.0f);
                Float valueOf2 = NuevoMedicaActivity.this.w.getText().length() > 0 ? Float.valueOf(NuevoMedicaActivity.this.w.getText().toString()) : Float.valueOf(0.0f);
                Float valueOf3 = NuevoMedicaActivity.this.y.getText().length() > 0 ? Float.valueOf(NuevoMedicaActivity.this.y.getText().toString()) : Float.valueOf(0.0f);
                if (NuevoMedicaActivity.this.x.getText().length() == 0 && NuevoMedicaActivity.this.w.getText().length() == 0 && NuevoMedicaActivity.this.y.getText().length() == 0) {
                    NuevoMedicaActivity.this.x.setHint(a.c.a.d.a.h(R.string.TR_REQUIRED_FIELD));
                    NuevoMedicaActivity.this.x.setHintTextColor(-59291);
                    NuevoMedicaActivity.this.w.setHint(a.c.a.d.a.h(R.string.TR_REQUIRED_FIELD));
                    NuevoMedicaActivity.this.w.setHintTextColor(-59291);
                    NuevoMedicaActivity.this.y.setHint(a.c.a.d.a.h(R.string.TR_REQUIRED_FIELD));
                    NuevoMedicaActivity.this.y.setHintTextColor(-59291);
                    Toast.makeText(NuevoMedicaActivity.this.f4512a, a.c.a.d.a.h(R.string.TR_COMPLETE_ALL_FIELDS), 1).show();
                    z = true;
                } else {
                    NuevoMedicaActivity.this.x.setHint((CharSequence) null);
                    NuevoMedicaActivity.this.w.setHint((CharSequence) null);
                    NuevoMedicaActivity.this.y.setHint((CharSequence) null);
                    z = false;
                }
                if (valueOf.floatValue() > 0.0f && (valueOf.floatValue() < 30.0f || valueOf.floatValue() > 200.0f)) {
                    Toast.makeText(NuevoMedicaActivity.this, String.format(a.c.a.d.a.i(R.string.TR_ERROR_HEIGHT_OUT_OF_RANGE), new Object[]{30, 200}), 0).show();
                    z = true;
                }
                if (valueOf2.floatValue() > 0.0f && (valueOf2.floatValue() < 0.0f || valueOf2.floatValue() > 100.0f)) {
                    Toast.makeText(NuevoMedicaActivity.this, String.format(a.c.a.d.a.i(R.string.TR_ERROR_WEIGHT_OUT_OF_RANGE), new Object[]{0, 100}), 0).show();
                    z = true;
                }
                if (valueOf3.floatValue() > 0.0f && (valueOf3.floatValue() < 15.0f || valueOf3.floatValue() > 75.0f)) {
                    Toast.makeText(NuevoMedicaActivity.this, String.format(a.c.a.d.a.i(R.string.TR_ERROR_CRANIAL_PERIMETER_OUT_OF_RANGE), new Object[]{15, 75}), 0).show();
                    z = true;
                }
                if (NuevoMedicaActivity.this.n == 0) {
                    NuevoMedicaActivity.this.q.setHint(a.c.a.d.a.h(R.string.TR_REQUIRED_FIELD));
                    NuevoMedicaActivity.this.q.setHintTextColor(-59291);
                    Toast.makeText(NuevoMedicaActivity.this.f4512a, a.c.a.d.a.h(R.string.TR_COMPLETE_ALL_FIELDS), 1).show();
                    z = true;
                }
                if (!z) {
                    NuevoMedicaActivity.this.E.show();
                    Usuario i = AppMiniland.f().i();
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(new k("fecharevision", NuevoMedicaActivity.this.n + "-" + NuevoMedicaActivity.this.m + "-" + NuevoMedicaActivity.this.l));
                    arrayList.add(new k("altura", NuevoMedicaActivity.this.x.getText().toString()));
                    arrayList.add(new k("peso", NuevoMedicaActivity.this.w.getText().toString()));
                    arrayList.add(new k("talla", NuevoMedicaActivity.this.y.getText().toString()));
                    arrayList.add(new k("bd", i.getBd()));
                    arrayList.add(new k("bdpre", i.getBdpre()));
                    if (NuevoMedicaActivity.this.B != null) {
                        arrayList.add(new k("idBebe", String.valueOf(NuevoMedicaActivity.this.B.getId())));
                    }
                    if (NuevoMedicaActivity.this.C != null) {
                        arrayList.add(new k("id", String.valueOf(NuevoMedicaActivity.this.C.getId())));
                        str = "fichamedica.php?editarcrecimiento=1";
                    } else {
                        str = "fichamedica.php?anadircrecimiento=1";
                    }
                    new a.h.a.l0.a(NuevoMedicaActivity.this.G, arrayList, str).start();
                }
            } catch (Exception unused) {
                NuevoMedicaActivity.this.E.dismiss();
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            NuevoMedicaActivity.this.finish();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            boolean z;
            String str;
            try {
                String str2 = NuevoMedicaActivity.this.n + "-" + NuevoMedicaActivity.this.m + "-" + NuevoMedicaActivity.this.l;
                String str3 = NuevoMedicaActivity.this.o + ":" + NuevoMedicaActivity.this.p;
                int selectedItemPosition = NuevoMedicaActivity.this.v.getSelectedItemPosition() + 1;
                if (NuevoMedicaActivity.this.n == 0) {
                    NuevoMedicaActivity.this.q.setHint(a.c.a.d.a.h(R.string.TR_REQUIRED_FIELD));
                    NuevoMedicaActivity.this.q.setHintTextColor(-59291);
                    z = true;
                } else {
                    z = false;
                }
                if (a.c.a.d.a.j(NuevoMedicaActivity.this.o)) {
                    NuevoMedicaActivity.this.r.setHint(a.c.a.d.a.h(R.string.TR_REQUIRED_FIELD));
                    NuevoMedicaActivity.this.r.setHintTextColor(-59291);
                    z = true;
                }
                if (!z) {
                    NuevoMedicaActivity.this.E = new ProgressDialog(NuevoMedicaActivity.this.f4512a);
                    NuevoMedicaActivity.this.E.setCancelable(false);
                    NuevoMedicaActivity.this.E.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
                    NuevoMedicaActivity.this.E.setIndeterminate(true);
                    NuevoMedicaActivity.this.E.show();
                    Usuario i = AppMiniland.f().i();
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(new k("fechacita", str2 + " " + str3));
                    arrayList.add(new k("horacita", str3));
                    arrayList.add(new k("especialista", "" + selectedItemPosition));
                    arrayList.add(new k("lugar", NuevoMedicaActivity.this.t.getText().toString()));
                    arrayList.add(new k("medico", NuevoMedicaActivity.this.s.getText().toString()));
                    arrayList.add(new k("tratamiento", NuevoMedicaActivity.this.u.getText().toString()));
                    arrayList.add(new k("bd", i.getBd()));
                    arrayList.add(new k("bdpre", i.getBdpre()));
                    if (NuevoMedicaActivity.this.B != null) {
                        arrayList.add(new k("idBebe", String.valueOf(NuevoMedicaActivity.this.B.getId())));
                    }
                    if (NuevoMedicaActivity.this.C != null) {
                        arrayList.add(new k("id", NuevoMedicaActivity.this.C.getId()));
                        str = "fichamedica.php?editarcitamedica=1";
                    } else {
                        str = "fichamedica.php?anadircitamedica=1";
                    }
                    new a.h.a.l0.a(NuevoMedicaActivity.this.H, arrayList, str).start();
                    return;
                }
                Toast.makeText(NuevoMedicaActivity.this.f4512a, a.c.a.d.a.h(R.string.TR_COMPLETE_ALL_FIELDS), 1).show();
            } catch (Exception unused) {
                NuevoMedicaActivity.this.E.dismiss();
            }
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            NuevoMedicaActivity.this.finish();
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            boolean z;
            String str;
            try {
                String str2 = NuevoMedicaActivity.this.n + "-" + NuevoMedicaActivity.this.m + "-" + NuevoMedicaActivity.this.l;
                if (NuevoMedicaActivity.this.j.getText().toString().equals("")) {
                    NuevoMedicaActivity.this.j.setHint(a.c.a.d.a.h(R.string.TR_REQUIRED_FIELD));
                    NuevoMedicaActivity.this.j.setHintTextColor(-59291);
                    z = true;
                } else {
                    z = false;
                }
                if (NuevoMedicaActivity.this.n == 0) {
                    NuevoMedicaActivity.this.q.setHint(a.c.a.d.a.h(R.string.TR_REQUIRED_FIELD));
                    NuevoMedicaActivity.this.q.setHintTextColor(-59291);
                    z = true;
                }
                if (!z) {
                    NuevoMedicaActivity.this.E = new ProgressDialog(NuevoMedicaActivity.this.f4512a);
                    NuevoMedicaActivity.this.E.setCancelable(false);
                    NuevoMedicaActivity.this.E.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
                    NuevoMedicaActivity.this.E.setIndeterminate(true);
                    NuevoMedicaActivity.this.E.show();
                    Usuario i = AppMiniland.f().i();
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(new k("fechavacuna", str2));
                    arrayList.add(new k("numcolegiado", NuevoMedicaActivity.this.f.getText().toString()));
                    arrayList.add(new k("lote", NuevoMedicaActivity.this.g.getText().toString()));
                    arrayList.add(new k("laboratorio", NuevoMedicaActivity.this.h.getText().toString()));
                    arrayList.add(new k("observaciones", NuevoMedicaActivity.this.i.getText().toString()));
                    arrayList.add(new k("vacuna", NuevoMedicaActivity.this.j.getText().toString()));
                    String str3 = "bebible";
                    if (NuevoMedicaActivity.this.k.getSelectedItemPosition() == 1) {
                        str3 = "inyectable";
                    }
                    arrayList.add(new k("tipo", str3));
                    arrayList.add(new k("bd", i.getBd()));
                    arrayList.add(new k("bdpre", i.getBdpre()));
                    if (NuevoMedicaActivity.this.B != null) {
                        arrayList.add(new k("idBebe", String.valueOf(NuevoMedicaActivity.this.B.getId())));
                    }
                    if (NuevoMedicaActivity.this.C != null) {
                        str = "fichamedica.php?editarvacuna=1";
                        arrayList.add(new k("id", NuevoMedicaActivity.this.C.getId()));
                    } else {
                        str = "fichamedica.php?anadirvacuna=1";
                    }
                    new a.h.a.l0.a(NuevoMedicaActivity.this.I, arrayList, str).start();
                    return;
                }
                Toast.makeText(NuevoMedicaActivity.this.f4512a, a.c.a.d.a.h(R.string.TR_COMPLETE_ALL_FIELDS), 1).show();
            } catch (Exception unused) {
                NuevoMedicaActivity.this.E.dismiss();
            }
        }
    }

    public class g extends Handler {
        public g() {
        }

        public void handleMessage(Message message) {
            NuevoMedicaActivity.this.E.dismiss();
            if (message != null) {
                StringBuilder n = a.a.a.a.a.n("SH2:");
                n.append(message.toString());
                Log.d("MINILAND_EBABY", n.toString());
                String obj = message.obj.toString();
                if ("OK".equalsIgnoreCase(obj)) {
                    Intent intent = new Intent();
                    intent.putExtra("nuevocrecimiento", o0O00000.O000000o);
                    NuevoMedicaActivity.this.setResult(-1, intent);
                    NuevoMedicaActivity.this.finish();
                    a.c.a.e.f.c().d("FICHA_MEDICA", "MEDIDA_GUARDADA", "");
                    return;
                }
                try {
                    if (new JSONObject(obj).has("idCrecimiento")) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("nuevocrecimiento", o0O00000.O000000o);
                        NuevoMedicaActivity.this.setResult(-1, intent2);
                        a.c.a.e.f.c().d("FICHA_MEDICA", "MEDIDA_GUARDADA", "");
                        NuevoMedicaActivity.this.finish();
                        return;
                    }
                    Toast.makeText(NuevoMedicaActivity.this.f4512a, "Error", 0).show();
                } catch (JSONException e2) {
                    Toast.makeText(NuevoMedicaActivity.this.f4512a, "Error", 0).show();
                    e2.printStackTrace();
                }
            } else {
                Toast.makeText(NuevoMedicaActivity.this.f4512a, "Error", 0).show();
            }
        }
    }

    public class h extends Handler {
        public h() {
        }

        public void handleMessage(Message message) {
            NuevoMedicaActivity.this.E.dismiss();
            if (message == null || message.obj == null) {
                Toast.makeText(NuevoMedicaActivity.this.f4512a, "Error", 0).show();
                return;
            }
            StringBuilder n = a.a.a.a.a.n("SH2:");
            n.append(message.toString());
            Log.d("MINILAND_EBABY", n.toString());
            String obj = message.obj.toString();
            if ("OK".equalsIgnoreCase(obj)) {
                Intent intent = new Intent();
                intent.putExtra("nuevocita", o0O00000.O000000o);
                NuevoMedicaActivity.this.setResult(-1, intent);
                NuevoMedicaActivity.this.finish();
                a.c.a.e.f.c().d("FICHA_MEDICA", "CITA_MEDICA_GUARDADA", "");
                return;
            }
            try {
                if (new JSONObject(obj).has("idCita")) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("nuevocita", o0O00000.O000000o);
                    NuevoMedicaActivity.this.setResult(-1, intent2);
                    ((InputMethodManager) NuevoMedicaActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(NuevoMedicaActivity.this.t.getWindowToken(), 0);
                    a.c.a.e.f.c().d("FICHA_MEDICA", "CITA_MEDICA_GUARDADA", "");
                    NuevoMedicaActivity.this.finish();
                    return;
                }
                Toast.makeText(NuevoMedicaActivity.this.f4512a, "Error", 0).show();
            } catch (JSONException e2) {
                Toast.makeText(NuevoMedicaActivity.this.f4512a, "Error", 0).show();
                e2.printStackTrace();
            }
        }
    }

    public class i extends Handler {
        public i() {
        }

        public void handleMessage(Message message) {
            NuevoMedicaActivity.this.E.dismiss();
            if (message == null || message.obj == null) {
                Toast.makeText(NuevoMedicaActivity.this.f4512a, "Error", 0).show();
                return;
            }
            StringBuilder n = a.a.a.a.a.n("SH2:");
            n.append(message.toString());
            Log.d("MINILAND_EBABY", n.toString());
            String obj = message.obj.toString();
            if ("OK".equalsIgnoreCase(obj)) {
                Intent intent = new Intent();
                intent.putExtra("editarvacuna", o0O00000.O000000o);
                NuevoMedicaActivity.this.setResult(-1, intent);
                NuevoMedicaActivity.this.finish();
                a.c.a.e.f.c().d("FICHA_MEDICA", "VACUNA_GUARDADA", "");
                return;
            }
            try {
                if (new JSONObject(obj).has("idVacuna")) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("nuevovacuna", o0O00000.O000000o);
                    NuevoMedicaActivity.this.setResult(-1, intent2);
                    ((InputMethodManager) NuevoMedicaActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(NuevoMedicaActivity.this.j.getWindowToken(), 0);
                    a.c.a.e.f.c().d("FICHA_MEDICA", "VACUNA_GUARDADA", "");
                    NuevoMedicaActivity.this.finish();
                    return;
                }
                Toast.makeText(NuevoMedicaActivity.this.f4512a, "Error", 0).show();
            } catch (JSONException e2) {
                Toast.makeText(NuevoMedicaActivity.this.f4512a, "Error", 0).show();
                e2.printStackTrace();
            }
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
        int i5;
        int i6;
        if (view == this.q) {
            int i7 = this.l;
            if (i7 > 0) {
                i6 = this.m - 1;
                i5 = i7;
                i4 = this.n;
            } else {
                Calendar instance = Calendar.getInstance();
                int i8 = instance.get(1);
                i6 = instance.get(2);
                i4 = instance.get(5);
                i5 = i8;
            }
            new DatePickerDialog(this, this, i5, i6, i4).show();
        } else if (view == this.r) {
            if (!a.c.a.d.a.j(this.o)) {
                i3 = Integer.valueOf(this.o).intValue();
                i2 = Integer.valueOf(this.p).intValue();
            } else {
                Calendar instance2 = Calendar.getInstance();
                int i9 = instance2.get(11);
                i2 = instance2.get(12);
                i3 = i9;
            }
            new TimePickerDialog(this, this, i3, i2, DateFormat.is24HourFormat(this)).show();
        }
    }

    public void onCreate(Bundle bundle) {
        Button button;
        View.OnClickListener fVar;
        super.onCreate(bundle);
        this.f4512a = this;
        requestWindowFeature(1);
        setContentView(R.layout.activity_nuevo_medica);
        TopMenuActivity topMenuActivity = (TopMenuActivity) findViewById(R.id.cabecera);
        this.F = topMenuActivity;
        topMenuActivity.setListener(this);
        this.F.setSeccion(a.c.a.d.a.h(R.string.TR_MENU_MEDICAL_RECORDS));
        this.f4516e = (LinearLayout) findViewById(R.id.formulario_medica);
        LayoutInflater from = LayoutInflater.from(this);
        Date date = null;
        this.f4513b = from.inflate(R.layout.view_cita, (ViewGroup) null);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.B = (Bebe) extras.getParcelable("KEY_INTENT_BABY");
            this.C = (Medica) extras.getParcelable("KEY_INTENT_MEDICAL_RECORD");
            this.D = extras.getInt("tipo");
        }
        ((TextView) this.f4513b.findViewById(R.id.txtNuevaCita)).setText(a.c.a.d.a.h(R.string.TR_NEW_MEDICAL_APPOINTMENT));
        ((TextView) this.f4513b.findViewById(R.id.txtMedicos)).setText(a.c.a.d.a.h(R.string.TR_DOCTOR));
        ((TextView) this.f4513b.findViewById(R.id.txtPlace)).setText(a.c.a.d.a.h(R.string.TR_PLACE));
        ((TextView) this.f4513b.findViewById(R.id.txtTratamiento)).setText(a.c.a.d.a.h(R.string.TR_TREATMENT));
        View inflate = from.inflate(R.layout.view_crecimiento, (ViewGroup) null);
        this.f4515d = inflate;
        ((TextView) inflate.findViewById(R.id.txtNuevoCrecimiento)).setText(a.c.a.d.a.h(R.string.TR_NEW_GROWTH));
        ((TextView) this.f4515d.findViewById(R.id.txtPeso)).setText(a.c.a.d.a.h(R.string.TR_WEIGHT_KG));
        ((TextView) this.f4515d.findViewById(R.id.txtAltura)).setText(a.c.a.d.a.h(R.string.TR_HEIGHT));
        ((TextView) this.f4515d.findViewById(R.id.txtCraneo)).setText(a.c.a.d.a.h(R.string.TR_CRANIAL_PERIMETER));
        View inflate2 = from.inflate(R.layout.view_vacuna, (ViewGroup) null);
        this.f4514c = inflate2;
        ((TextView) inflate2.findViewById(R.id.txtNewVacuna)).setText(a.c.a.d.a.h(R.string.TR_NEW_VACCINE));
        ((TextView) this.f4514c.findViewById(R.id.txtVacuna)).setText(a.c.a.d.a.h(R.string.TR_VACCINE));
        ((TextView) this.f4514c.findViewById(R.id.txtLote)).setText(a.c.a.d.a.h(R.string.TR_LOT));
        ((TextView) this.f4514c.findViewById(R.id.txtLaboratorio)).setText(a.c.a.d.a.h(R.string.TR_LABORATORY));
        ((TextView) this.f4514c.findViewById(R.id.txtColegiado)).setText(a.c.a.d.a.h(R.string.TR_COLLEGIATE_NUM));
        ((TextView) this.f4514c.findViewById(R.id.txtObservaciones)).setText(a.c.a.d.a.h(R.string.TR_COMMENTS));
        int i2 = this.D;
        if (i2 == 1) {
            this.w = (EditText) this.f4515d.findViewById(R.id.et_peso);
            this.x = (EditText) this.f4515d.findViewById(R.id.et_altura);
            this.y = (EditText) this.f4515d.findViewById(R.id.et_craneo);
            Button button2 = (Button) this.f4515d.findViewById(R.id.btguardar_crecimiento);
            this.z = button2;
            button2.setText(a.c.a.d.a.h(R.string.TR_GUARDAR));
            EditText editText = (EditText) this.f4515d.findViewById(R.id.et_fecha);
            this.q = editText;
            editText.setHint(a.c.a.d.a.h(R.string.TR_DATE));
            this.q.setOnClickListener(this);
            this.f4516e.removeAllViews();
            this.f4516e.addView(this.f4515d);
            Button button3 = (Button) this.f4515d.findViewById(R.id.btnCancel);
            this.A = button3;
            button3.setText(a.c.a.d.a.h(R.string.TR_CANCEL).toUpperCase());
            this.A.setOnClickListener(new a());
            Medica medica = this.C;
            if (medica != null) {
                this.w.setText(a.c.a.d.a.g(medica.getPesocrecimiento()));
                this.x.setText(a.c.a.d.a.g(this.C.getAlturacrecimiento()));
                this.y.setText(a.c.a.d.a.g(this.C.getMedidaCabCrecimiento()));
                this.q.setText(a.c.a.d.a.g(this.C.getFechacrecimiento()));
                if (!a.c.a.d.a.j(this.C.getFechacrecimiento())) {
                    try {
                        Date parse = j.f.parse(this.C.getFechacrecimiento());
                        Calendar instance = Calendar.getInstance();
                        instance.setTime(parse);
                        this.n = instance.get(5);
                        this.m = instance.get(2) + 1;
                        this.l = instance.get(1);
                    } catch (ParseException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            button = (Button) this.f4515d.findViewById(R.id.btguardar_crecimiento);
            button.setText(a.c.a.d.a.h(R.string.TR_GUARDAR).toUpperCase());
            fVar = new b();
        } else if (i2 == 0) {
            this.s = (EditText) this.f4513b.findViewById(R.id.et_cita_medico);
            this.t = (EditText) this.f4513b.findViewById(R.id.et_cita_lugar);
            this.u = (EditText) this.f4513b.findViewById(R.id.et_cita_tratamiento);
            this.v = (Spinner) this.f4513b.findViewById(R.id.sp_cita);
            EditText editText2 = (EditText) this.f4513b.findViewById(R.id.et_fecha);
            this.q = editText2;
            editText2.setHint(a.c.a.d.a.h(R.string.TR_DATE));
            EditText editText3 = (EditText) this.f4513b.findViewById(R.id.et_tiempo);
            this.r = editText3;
            editText3.setHint(a.c.a.d.a.h(R.string.TR_TIME));
            this.r.setOnClickListener(this);
            this.q.setOnClickListener(this);
            ArrayList arrayList = new ArrayList();
            arrayList.add(a.c.a.d.a.h(R.string.TR_ESPECIALIST_PEDIATRICIAN));
            arrayList.add(a.c.a.d.a.h(R.string.TR_ESPECIALIST_OPHTHALMOLOGIST));
            arrayList.add(a.c.a.d.a.h(R.string.TR_ESPECIALIST_OTOLARYNGOLOGIST));
            arrayList.add(a.c.a.d.a.h(R.string.TR_ESPECIALIST_ORTHO_TRAUMATOLOGY));
            arrayList.add(a.c.a.d.a.h(R.string.TR_ESPECIALIST_DERMATOLOGIST));
            arrayList.add(a.c.a.d.a.h(R.string.TR_ESPECIALIST_NEUROLOGIST));
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.spinner_item, arrayList);
            arrayAdapter.setDropDownViewResource(17367049);
            this.v.setAdapter(arrayAdapter);
            this.f4516e.removeAllViews();
            this.f4516e.addView(this.f4513b);
            Medica medica2 = this.C;
            if (medica2 != null) {
                this.s.setText(medica2.getMedicocita());
                this.t.setText(this.C.getLugarcita());
                this.u.setText(this.C.getTratamientocita());
                try {
                    this.v.setSelection(Integer.valueOf(this.C.getEspecialistacita()).intValue() - 1);
                } catch (NumberFormatException e3) {
                    e3.printStackTrace();
                }
                if (!a.c.a.d.a.j(this.C.getFechacita())) {
                    try {
                        date = j.i.parse(this.C.getFechacita());
                    } catch (ParseException e4) {
                        e4.printStackTrace();
                    }
                    if (date == null) {
                        try {
                            date = j.f.parse(this.C.getFechacita());
                        } catch (ParseException e5) {
                            e5.printStackTrace();
                        }
                    }
                    if (date != null) {
                        this.q.setText(j.f.format(date));
                        this.r.setText(j.l.format(date));
                        Calendar instance2 = Calendar.getInstance();
                        instance2.setTime(date);
                        this.n = instance2.get(5);
                        this.m = instance2.get(2) + 1;
                        this.l = instance2.get(1);
                        this.o = String.valueOf(instance2.get(11));
                        this.p = String.valueOf(instance2.get(12));
                    }
                }
            }
            Button button4 = (Button) this.f4513b.findViewById(R.id.btnCancel);
            this.A = button4;
            button4.setText(a.c.a.d.a.h(R.string.TR_CANCEL).toUpperCase());
            this.A.setOnClickListener(new c());
            button = (Button) this.f4513b.findViewById(R.id.btguardar_cita);
            button.setText(a.c.a.d.a.h(R.string.TR_GUARDAR).toUpperCase());
            fVar = new d();
        } else if (i2 == 2) {
            this.f = (EditText) this.f4514c.findViewById(R.id.et_col);
            this.g = (EditText) this.f4514c.findViewById(R.id.et_lote);
            this.h = (EditText) this.f4514c.findViewById(R.id.et_lab);
            this.i = (EditText) this.f4514c.findViewById(R.id.et_obs);
            this.j = (EditText) this.f4514c.findViewById(R.id.et_vacuna);
            this.k = (Spinner) this.f4514c.findViewById(R.id.sp_vacuna);
            Button button5 = (Button) this.f4514c.findViewById(R.id.btguardar_vacuna);
            EditText editText4 = (EditText) this.f4514c.findViewById(R.id.et_fecha);
            this.q = editText4;
            editText4.setHint(a.c.a.d.a.h(R.string.TR_DATE));
            EditText editText5 = (EditText) this.f4514c.findViewById(R.id.et_tiempo);
            this.r = editText5;
            editText5.setHint(a.c.a.d.a.h(R.string.TR_TIME));
            this.r.setOnClickListener(this);
            this.q.setOnClickListener(this);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(a.c.a.d.a.h(R.string.TR_VACCINE_TYPE_DRINK));
            arrayList2.add(a.c.a.d.a.h(R.string.TR_VACCINE_TYPE_INJECTION));
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, R.layout.spinner_item, arrayList2);
            arrayAdapter2.setDropDownViewResource(17367049);
            this.k.setAdapter(arrayAdapter2);
            this.f4516e.removeAllViews();
            this.f4516e.addView(this.f4514c);
            Medica medica3 = this.C;
            if (medica3 != null) {
                this.f.setText(medica3.getColegiadovacuna());
                this.g.setText(this.C.getLotevacuna());
                this.i.setText(this.C.getObservacionesvacuna());
                this.j.setText(this.C.getVacunavacuna());
                this.h.setText(this.C.getLaboratoriovacuna());
                if (!a.c.a.d.a.j(this.C.getFechavacuna())) {
                    try {
                        Date parse2 = j.f.parse(this.C.getFechavacuna());
                        this.q.setText(j.f.format(parse2));
                        Calendar instance3 = Calendar.getInstance();
                        instance3.setTime(parse2);
                        this.n = instance3.get(5);
                        this.m = instance3.get(2) + 1;
                        this.l = instance3.get(1);
                    } catch (ParseException e6) {
                        e6.printStackTrace();
                    }
                }
            }
            Button button6 = (Button) this.f4514c.findViewById(R.id.btnCancel);
            this.A = button6;
            button6.setText(a.c.a.d.a.h(R.string.TR_CANCEL).toUpperCase());
            this.A.setOnClickListener(new e());
            button = (Button) this.f4514c.findViewById(R.id.btguardar_vacuna);
            button.setText(a.c.a.d.a.h(R.string.TR_GUARDAR).toUpperCase());
            fVar = new f();
        } else {
            return;
        }
        button.setOnClickListener(fVar);
    }

    public void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
        EditText editText = this.q;
        StringBuilder sb = new StringBuilder();
        sb.append(i4);
        sb.append("/");
        int i5 = i3 + 1;
        sb.append(i5);
        sb.append("/");
        sb.append(i2);
        editText.setText(sb.toString());
        this.l = i2;
        this.m = i5;
        this.n = i4;
    }

    public void onTimeSet(TimePicker timePicker, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        if (i3 < 10) {
            sb.append(oOO0O0O0.O0000oO0);
        } else {
            sb.append("");
        }
        sb.append(i3);
        this.p = sb.toString();
        this.o = i2 < 10 ? a.a.a.a.a.h(oOO0O0O0.O0000oO0, i2) : a.a.a.a.a.h("", i2);
        EditText editText = this.r;
        editText.setText(this.o + ":" + this.p);
    }
}
