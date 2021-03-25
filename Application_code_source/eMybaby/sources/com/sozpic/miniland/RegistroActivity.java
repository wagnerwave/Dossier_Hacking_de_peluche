package com.sozpic.miniland;

import a.h.a.h0;
import a.h.a.i0;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.sozpic.miniland.TopMenuActivity;
import com.tuya.smart.android.network.TuyaApiParams;
import com.tuya.smart.common.OO000o0;
import com.tuya.smart.common.oOO0O0O0;
import com.tuya.smart.mqtt.MqttServiceConstants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class RegistroActivity extends FragmentActivity implements TopMenuActivity.c {
    public static EditText C;
    public HashMap<String, String> A = new HashMap<>();
    public Handler B = new d();

    /* renamed from: a  reason: collision with root package name */
    public Context f4533a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f4534b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f4535c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f4536d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f4537e;
    public Button f;
    public Button g;
    public boolean h;
    public boolean i;
    public boolean j;
    public Spinner k;
    public Spinner l;
    public List<String> m = new ArrayList();
    public List<String> n = new ArrayList();
    public EditText o;
    public EditText p;
    public EditText q;
    public EditText r;
    public EditText s;
    public ImageView t;
    public ImageView u;
    public Button v;
    public Button w;
    public ProgressDialog x;
    public RelativeLayout y;
    public TextView z;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            Toast toast;
            Context context;
            String str;
            int i;
            boolean z;
            RegistroActivity.o(RegistroActivity.this);
            RegistroActivity registroActivity = RegistroActivity.this;
            int selectedItemPosition = registroActivity.k.getSelectedItemPosition();
            int selectedItemPosition2 = registroActivity.l.getSelectedItemPosition();
            String str2 = registroActivity.A.get(registroActivity.m.get(selectedItemPosition));
            if (!Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", 2).matcher(registroActivity.q.getText().toString()).matches()) {
                toast = Toast.makeText(registroActivity.f4533a, a.c.a.d.a.h(R.string.TR_COMPLETE_ALL_FIELDS), 0);
            } else {
                if (selectedItemPosition == 0) {
                    context = registroActivity.f4533a;
                    str = a.c.a.d.a.h(R.string.TR_COMPLETE_ALL_FIELDS);
                } else {
                    String str3 = registroActivity.n.get(selectedItemPosition2);
                    String obj = registroActivity.o.getText().toString();
                    String obj2 = registroActivity.p.getText().toString();
                    String obj3 = registroActivity.q.getText().toString();
                    String obj4 = registroActivity.r.getText().toString();
                    String obj5 = registroActivity.s.getText().toString();
                    String[] split = RegistroActivity.C.getText().toString().split("-");
                    try {
                        if (split.length == 3) {
                            String obj6 = RegistroActivity.C.getText().toString();
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                            simpleDateFormat.setLenient(false);
                            try {
                                simpleDateFormat.parse(obj6);
                                z = true;
                            } catch (ParseException unused) {
                                z = false;
                            }
                            if (z) {
                                int parseInt = Integer.parseInt(split[2]);
                                int parseInt2 = Integer.parseInt(split[1]);
                                int parseInt3 = Integer.parseInt(split[0]);
                                Calendar instance = Calendar.getInstance();
                                Calendar instance2 = Calendar.getInstance();
                                instance2.set(parseInt, parseInt2, parseInt3);
                                if (instance2.before(instance)) {
                                    String str4 = split[0] + "/" + split[1] + "/" + split[2];
                                    if (obj2.equals("") || obj.equals("") || obj3.equals("") || obj4.equals("") || obj5.equals("") || str4.equals("")) {
                                        context = registroActivity.f4533a;
                                        i = R.string.TR_COMPLETE_ALL_FIELDS;
                                        str = a.c.a.d.a.h(i);
                                    } else if (registroActivity.p(obj4)) {
                                        if (!obj4.equals(obj5)) {
                                            context = registroActivity.f4533a;
                                            i = R.string.TR_PASSWORDS_NOT_MATCH;
                                            str = a.c.a.d.a.h(i);
                                        } else if (registroActivity.h && registroActivity.i) {
                                            ProgressDialog progressDialog = new ProgressDialog(registroActivity.f4533a);
                                            registroActivity.x = progressDialog;
                                            progressDialog.setCancelable(false);
                                            registroActivity.x.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
                                            registroActivity.x.setIndeterminate(true);
                                            registroActivity.x.show();
                                            String str5 = registroActivity.h ? "1" : oOO0O0O0.O0000oO0;
                                            String str6 = registroActivity.j ? "S" : "N";
                                            ArrayList arrayList = new ArrayList(1);
                                            arrayList.add(new e.a.a.i0.k("nombre", obj));
                                            arrayList.add(new e.a.a.i0.k("apellidos", obj2));
                                            arrayList.add(new e.a.a.i0.k("email", obj3));
                                            arrayList.add(new e.a.a.i0.k("password", a.e.a.a.r.b.P(obj4)));
                                            arrayList.add(new e.a.a.i0.k("pais", str2));
                                            arrayList.add(new e.a.a.i0.k("fechanacimiento", str4));
                                            arrayList.add(new e.a.a.i0.k(TuyaApiParams.KEY_APP_LANG, a.c.d.a.l().c()));
                                            arrayList.add(new e.a.a.i0.k("acepta", str5));
                                            arrayList.add(new e.a.a.i0.k("aceptoinfo", str6));
                                            new a.h.a.l0.b(registroActivity.B, a.a.a.a.a.k("&", a.e.a.a.r.b.p(arrayList, "utf-8")), "registro.php?appregistro=1").start();
                                            return;
                                        } else {
                                            context = registroActivity.f4533a;
                                            str = a.c.a.d.a.h(R.string.TR_ERROR_ACCEPT_TERMS_AND_CONDITIONS);
                                        }
                                    } else {
                                        return;
                                    }
                                }
                            }
                        }
                        Toast.makeText(registroActivity.f4533a, a.c.a.d.a.h(R.string.TR_FORMATO_FECHA_NACIMIENTO_INCORRECTO), 1).show();
                        return;
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                        context = registroActivity.f4533a;
                        i = R.string.TR_FORMATO_FECHA_NACIMIENTO_INCORRECTO;
                    }
                }
                toast = Toast.makeText(context, str, 1);
            }
            toast.show();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            EditText editText;
            TransformationMethod transformationMethod;
            if (RegistroActivity.this.r.getTransformationMethod() == PasswordTransformationMethod.getInstance()) {
                RegistroActivity.this.t.setImageResource(R.drawable.ic_show_password);
                editText = RegistroActivity.this.r;
                transformationMethod = HideReturnsTransformationMethod.getInstance();
            } else {
                RegistroActivity.this.t.setImageResource(R.drawable.ic_hide_password);
                editText = RegistroActivity.this.r;
                transformationMethod = PasswordTransformationMethod.getInstance();
            }
            editText.setTransformationMethod(transformationMethod);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            EditText editText;
            TransformationMethod transformationMethod;
            if (RegistroActivity.this.s.getTransformationMethod() == PasswordTransformationMethod.getInstance()) {
                RegistroActivity.this.u.setImageResource(R.drawable.ic_show_password);
                editText = RegistroActivity.this.s;
                transformationMethod = HideReturnsTransformationMethod.getInstance();
            } else {
                RegistroActivity.this.u.setImageResource(R.drawable.ic_hide_password);
                editText = RegistroActivity.this.s;
                transformationMethod = PasswordTransformationMethod.getInstance();
            }
            editText.setTransformationMethod(transformationMethod);
        }
    }

    public class d extends Handler {
        public d() {
        }

        public void handleMessage(Message message) {
            CharSequence charSequence;
            RegistroActivity.this.x.dismiss();
            if (message != null) {
                StringBuilder n = a.a.a.a.a.n("SH2:");
                n.append(message.toString());
                Log.d("MINILAND_EBABY", n.toString());
                try {
                    if (message.obj != null) {
                        JSONObject jSONObject = new JSONObject(message.obj.toString());
                        int i = jSONObject.getInt(MqttServiceConstants.TRACE_ERROR);
                        String string = jSONObject.has("mensaje") ? jSONObject.getString("mensaje") : null;
                        if (i == 1) {
                            Context context = RegistroActivity.this.f4533a;
                            if (a.c.a.d.a.j(string)) {
                                string = String.format(a.c.a.d.a.i(R.string.TR_ERROR_REGISTER_USER_EXISTS_PLACEHOLDER), new Object[]{RegistroActivity.this.q.getText().toString()});
                            }
                            a.c.a.f.b.h0(context, string, a.c.a.d.a.h(R.string.TR_ACEPTAR));
                            return;
                        }
                        TextView textView = RegistroActivity.this.z;
                        if (!a.c.a.d.a.j(string)) {
                            charSequence = Html.fromHtml(string);
                        } else {
                            charSequence = String.format(a.c.a.d.a.i(R.string.TR_REGISTER_MESSAGE_PLACEHOLDERPART_ONE), new Object[]{RegistroActivity.this.q.getText().toString()});
                        }
                        textView.setText(charSequence);
                        RegistroActivity.this.y.setVisibility(0);
                        return;
                    }
                    Toast.makeText(RegistroActivity.this.f4533a, "Error", 0).show();
                    return;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            Toast.makeText(RegistroActivity.this.f4533a, "Error", 0).show();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            Resources resources;
            int i;
            ImageView imageView;
            RegistroActivity registroActivity = RegistroActivity.this;
            boolean z = !registroActivity.h;
            registroActivity.h = z;
            if (z) {
                imageView = registroActivity.f4534b;
                resources = registroActivity.getResources();
                i = R.drawable.boton_aceptar_condiciones_verdereg;
            } else {
                imageView = registroActivity.f4534b;
                resources = registroActivity.getResources();
                i = R.drawable.boton_sin_marcar_reg;
            }
            imageView.setImageDrawable(resources.getDrawable(i));
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            RegistroActivity.this.finish();
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        public void onClick(View view) {
            RegistroActivity.this.finish();
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        public void onClick(View view) {
            Resources resources;
            int i;
            ImageView imageView;
            RegistroActivity registroActivity = RegistroActivity.this;
            boolean z = !registroActivity.i;
            registroActivity.i = z;
            if (z) {
                imageView = registroActivity.f4535c;
                resources = registroActivity.getResources();
                i = R.drawable.boton_aceptar_condiciones_verdereg;
            } else {
                imageView = registroActivity.f4535c;
                resources = registroActivity.getResources();
                i = R.drawable.boton_sin_marcar_reg;
            }
            imageView.setImageDrawable(resources.getDrawable(i));
        }
    }

    public class i implements View.OnClickListener {
        public i() {
        }

        public void onClick(View view) {
            Resources resources;
            int i;
            ImageView imageView;
            RegistroActivity registroActivity = RegistroActivity.this;
            boolean z = !registroActivity.j;
            registroActivity.j = z;
            if (z) {
                imageView = registroActivity.f4536d;
                resources = registroActivity.getResources();
                i = R.drawable.boton_aceptar_condiciones_verdereg;
            } else {
                imageView = registroActivity.f4536d;
                resources = registroActivity.getResources();
                i = R.drawable.boton_sin_marcar_reg;
            }
            imageView.setImageDrawable(resources.getDrawable(i));
        }
    }

    public class j implements View.OnClickListener {
        public j() {
        }

        public void onClick(View view) {
            RegistroActivity.this.q();
        }
    }

    public class k implements View.OnClickListener {
        public k(RegistroActivity registroActivity) {
        }

        public void onClick(View view) {
            a.c.a.d.a.n(view.getContext(), a.c.d.r.j.b().f());
        }
    }

    public class l implements View.OnClickListener {
        public l(RegistroActivity registroActivity) {
        }

        public void onClick(View view) {
            a.c.a.d.a.n(view.getContext(), a.c.d.r.j.b().g());
        }
    }

    public class m implements View.OnClickListener {
        public m() {
        }

        public void onClick(View view) {
            RegistroActivity registroActivity = RegistroActivity.this;
            registroActivity.o.setText("");
            registroActivity.p.setText("");
            registroActivity.q.setText("");
            registroActivity.r.setText("");
            registroActivity.s.setText("");
            RegistroActivity.C.setText("");
            registroActivity.f4537e.setVisibility(8);
            registroActivity.h = false;
            registroActivity.f4534b.setImageDrawable(registroActivity.getResources().getDrawable(R.drawable.boton_sin_marcar_reg));
            registroActivity.i = false;
            registroActivity.f4535c.setImageDrawable(registroActivity.getResources().getDrawable(R.drawable.boton_sin_marcar_reg));
            registroActivity.j = false;
            registroActivity.f4536d.setImageDrawable(registroActivity.getResources().getDrawable(R.drawable.boton_sin_marcar_reg));
            registroActivity.k.setSelection(0);
            registroActivity.l.setSelection(0);
        }
    }

    public static void o(Activity activity) {
        if (activity != null && activity.getCurrentFocus() != null) {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }

    public void a() {
        finish();
    }

    public void b() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4533a = this;
        requestWindowFeature(1);
        setContentView(R.layout.activity_registro);
        this.f4534b = (ImageView) findViewById(R.id.imagen_estado_acepto);
        this.f4535c = (ImageView) findViewById(R.id.imagen_estado_condiciones);
        this.f4537e = (ImageView) findViewById(R.id.tick);
        Button button = (Button) findViewById(R.id.atras);
        this.f = button;
        button.setText(a.c.a.d.a.h(R.string.TR_BACK).toUpperCase());
        Button button2 = (Button) findViewById(R.id.atras2);
        this.g = button2;
        button2.setText(a.c.a.d.a.h(R.string.TR_BACK_TO_MENU));
        this.f4536d = (ImageView) findViewById(R.id.imagen_estado_deseo);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.boton_acepto);
        this.f4534b.setOnClickListener(new e());
        this.f.setOnClickListener(new f());
        this.g.setOnClickListener(new g());
        this.f4535c.setOnClickListener(new h());
        ((LinearLayout) findViewById(R.id.boton_deseo)).setOnClickListener(new i());
        EditText editText = (EditText) findViewById(R.id.fecha_nac);
        C = editText;
        editText.setHint(a.c.a.d.a.h(R.string.TR_DATE_BIRTH_WITH_FORMAT));
        C.setOnClickListener(new j());
        this.k = (Spinner) findViewById(R.id.spinner1);
        for (Locale locale : Locale.getAvailableLocales()) {
            String displayCountry = locale.getDisplayCountry();
            if (displayCountry.trim().length() > 0 && !this.m.contains(displayCountry)) {
                this.m.add(displayCountry);
                this.A.put(displayCountry, locale.getCountry());
            }
        }
        Collections.sort(this.m);
        this.m.add(0, a.c.a.d.a.h(R.string.TR_COUNTRY));
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.spinner_item, this.m);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        this.k.setAdapter(arrayAdapter);
        this.l = (Spinner) findViewById(R.id.spinner2);
        this.n.add(a.c.a.d.a.h(R.string.TR_NUMBER_OF_CHILDREN));
        this.n.add("1");
        this.n.add("2");
        this.n.add(OO000o0.O00000o);
        this.n.add(OO000o0.O00000o0);
        this.n.add("5");
        this.n.add("6");
        this.n.add("7");
        this.n.add("8");
        this.n.add("9");
        this.n.add("10");
        this.n.add("11");
        this.n.add("12");
        this.n.add("13");
        this.n.add("14");
        this.n.add("15");
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, R.layout.spinner_item, this.n);
        arrayAdapter2.setDropDownViewResource(R.layout.spinner_item);
        this.l.setAdapter(arrayAdapter2);
        EditText editText2 = (EditText) findViewById(R.id.campo_nombre);
        this.o = editText2;
        editText2.setHint(a.c.a.d.a.h(R.string.TR_NAME));
        EditText editText3 = (EditText) findViewById(R.id.campo_apel);
        this.p = editText3;
        editText3.setHint(a.c.a.d.a.h(R.string.TR_SURNAME));
        EditText editText4 = (EditText) findViewById(R.id.campo_email);
        this.q = editText4;
        editText4.setHint(a.c.a.d.a.h(R.string.TR_EMAIL));
        EditText editText5 = (EditText) findViewById(R.id.campo_pass);
        this.r = editText5;
        editText5.setHint(a.c.a.d.a.h(R.string.TR_PASSWORD));
        EditText editText6 = (EditText) findViewById(R.id.campo_confirm_pass);
        this.s = editText6;
        editText6.setHint(a.c.a.d.a.h(R.string.TR_CONFIRM_PASSWORD));
        TextView textView = (TextView) findViewById(R.id.acepto_terminos_title);
        textView.setText(a.c.a.d.a.h(R.string.TR_ACCEPT_TERMS_AND_CONDITIONS));
        textView.setOnClickListener(new k(this));
        TextView textView2 = (TextView) findViewById(R.id.acepto_condiciones_title);
        textView2.setText(a.c.a.d.a.h(R.string.TR_ACEPTA_CONDICIONES_USO));
        textView2.setOnClickListener(new l(this));
        ((TextView) findViewById(R.id.recibir_informacion_title)).setText(a.c.a.d.a.h(R.string.TR_RECEIVE_INFORMATION_TEXT));
        Button button3 = (Button) findViewById(R.id.eliminar_datos);
        this.v = button3;
        button3.setText(a.c.a.d.a.h(R.string.TR_CLEAN_FORM).toUpperCase());
        this.v.setOnClickListener(new m());
        Button button4 = (Button) findViewById(R.id.activar_cuenta);
        this.w = button4;
        button4.setText(a.c.a.d.a.h(R.string.TR_ACTIVATE_ACCOUNT).toUpperCase());
        this.w.setOnClickListener(new a());
        this.y = (RelativeLayout) findViewById(R.id.vista_respuesta);
        this.z = (TextView) findViewById(R.id.texto_respuesta);
        ImageView imageView = (ImageView) findViewById(R.id.ibtn_show_pass);
        this.t = imageView;
        imageView.setOnClickListener(new b());
        ImageView imageView2 = (ImageView) findViewById(R.id.ibtn_show_pass_bis);
        this.u = imageView2;
        imageView2.setOnClickListener(new c());
        this.r.setOnFocusChangeListener(new h0(this));
        this.s.setOnFocusChangeListener(new i0(this));
    }

    public void onResume() {
        super.onResume();
        a.c.a.e.f.c().e("REGISTER");
    }

    public final boolean p(String str) {
        boolean z2;
        if (str.length() >= 8) {
            int i2 = 0;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            while (true) {
                if (i2 >= str.length()) {
                    break;
                }
                char charAt = str.charAt(i2);
                if (Character.isDigit(charAt)) {
                    z4 = true;
                } else if ("'\\\"#?!@=$%^&-.:_".indexOf(charAt) >= 0) {
                    z6 = true;
                } else if (Character.isUpperCase(charAt)) {
                    z3 = true;
                } else if (Character.isLowerCase(charAt)) {
                    z5 = true;
                }
                if (z4 && z3 && z5 && z6) {
                    z2 = true;
                    break;
                }
                i2++;
            }
        }
        z2 = false;
        if (z2) {
            return true;
        }
        a.c.a.f.b.j0(this, a.c.a.d.a.h(R.string.TR_CONTRASENYA_ROBUSTA_ERROR));
        return false;
    }

    public void q() {
        String obj = this.r.getText().toString();
        if (this.s.getText().toString().equals(obj) && p(obj)) {
            this.f4537e.setVisibility(0);
        }
    }
}
