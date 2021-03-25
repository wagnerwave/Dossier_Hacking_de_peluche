package com.sozpic.miniland;

import a.c.a.e.f;
import a.h.a.q;
import a.h.a.r;
import a.h.a.s;
import a.h.a.t;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.sozpic.miniland.TopMenuActivity;
import com.sozpic.miniland.modelos.Agenda;
import com.tuya.smart.common.o0O00000;
import com.tuya.smart.common.oOO0O0O0;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
public class NuevoCalendarioActivity extends FragmentActivity implements TopMenuActivity.c, View.OnClickListener {
    public Agenda A;
    public CheckBox B;
    public Handler C = new c();

    /* renamed from: a  reason: collision with root package name */
    public Context f4494a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f4495b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f4496c;

    /* renamed from: d  reason: collision with root package name */
    public CheckBox f4497d;

    /* renamed from: e  reason: collision with root package name */
    public Button f4498e;
    public Button f;
    public ProgressDialog g;
    public TopMenuActivity h;
    public ViewGroup i;
    public ViewGroup j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public String q = "00";
    public String r = "00";
    public String s = "00";
    public String t = "00";
    public String u = "00";
    public String v = "00";
    public EditText w;
    public EditText x;
    public EditText y;
    public EditText z;

    public class a implements View.OnClickListener {
        public a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x010b A[Catch:{ Exception -> 0x019f }] */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x018e A[Catch:{ Exception -> 0x019f }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onClick(android.view.View r12) {
            /*
                r11 = this;
                com.sozpic.miniland.NuevoCalendarioActivity r12 = com.sozpic.miniland.NuevoCalendarioActivity.this
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                int r1 = r12.m
                r0.append(r1)
                java.lang.String r1 = "/"
                r0.append(r1)
                int r2 = r12.l
                r0.append(r2)
                r0.append(r1)
                int r2 = r12.k
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                int r3 = r12.p
                r2.append(r3)
                r2.append(r1)
                int r3 = r12.o
                r2.append(r3)
                r2.append(r1)
                int r1 = r12.n
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = r12.q
                r2.append(r3)
                java.lang.String r3 = ":"
                r2.append(r3)
                java.lang.String r4 = r12.r
                r2.append(r4)
                r2.append(r3)
                java.lang.String r4 = r12.s
                r2.append(r4)
                java.lang.String r2 = r2.toString()
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = r12.t
                r4.append(r5)
                r4.append(r3)
                java.lang.String r5 = r12.u
                r4.append(r5)
                r4.append(r3)
                java.lang.String r3 = r12.v
                r4.append(r3)
                java.lang.String r3 = r4.toString()
                android.widget.CheckBox r4 = r12.f4497d
                boolean r4 = r4.isChecked()
                java.lang.String r5 = ""
                java.lang.String r6 = "1"
                java.lang.String r7 = "0"
                if (r4 == 0) goto L_0x0091
                r1 = r0
                r2 = r5
                r3 = r2
                r4 = r6
                goto L_0x0092
            L_0x0091:
                r4 = r7
            L_0x0092:
                android.app.ProgressDialog r5 = new android.app.ProgressDialog
                android.content.Context r8 = r12.f4494a
                r5.<init>(r8)
                r12.g = r5
                r8 = 0
                r5.setCancelable(r8)
                android.app.ProgressDialog r5 = r12.g
                r9 = 2131821439(0x7f11037f, float:1.9275621E38)
                java.lang.String r9 = a.c.a.d.a.h(r9)
                r5.setMessage(r9)
                android.app.ProgressDialog r5 = r12.g
                r9 = 1
                r5.setIndeterminate(r9)
                android.widget.TextView r5 = r12.f4495b     // Catch:{ Exception -> 0x019f }
                java.lang.CharSequence r5 = r5.getText()     // Catch:{ Exception -> 0x019f }
                java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x019f }
                boolean r5 = a.c.a.d.a.j(r5)     // Catch:{ Exception -> 0x019f }
                r10 = -59291(0xffffffffffff1865, float:NaN)
                if (r5 == 0) goto L_0x00ca
                android.widget.TextView r5 = r12.f4495b     // Catch:{ Exception -> 0x019f }
                r5.setHintTextColor(r10)     // Catch:{ Exception -> 0x019f }
                r8 = 1
            L_0x00ca:
                android.widget.CheckBox r5 = r12.f4497d     // Catch:{ Exception -> 0x019f }
                boolean r5 = r5.isChecked()     // Catch:{ Exception -> 0x019f }
                if (r5 != 0) goto L_0x00ff
                int r5 = r12.m     // Catch:{ Exception -> 0x019f }
                if (r5 != 0) goto L_0x00dc
                android.widget.EditText r5 = r12.w     // Catch:{ Exception -> 0x019f }
                r5.setHintTextColor(r10)     // Catch:{ Exception -> 0x019f }
                r8 = 1
            L_0x00dc:
                int r5 = r12.p     // Catch:{ Exception -> 0x019f }
                if (r5 != 0) goto L_0x00e6
                android.widget.EditText r5 = r12.x     // Catch:{ Exception -> 0x019f }
                r5.setHintTextColor(r10)     // Catch:{ Exception -> 0x019f }
                r8 = 1
            L_0x00e6:
                java.lang.String r5 = r12.q     // Catch:{ Exception -> 0x019f }
                boolean r5 = r5.equals(r7)     // Catch:{ Exception -> 0x019f }
                if (r5 == 0) goto L_0x00f4
                android.widget.EditText r5 = r12.y     // Catch:{ Exception -> 0x019f }
                r5.setHintTextColor(r10)     // Catch:{ Exception -> 0x019f }
                r8 = 1
            L_0x00f4:
                java.lang.String r5 = r12.t     // Catch:{ Exception -> 0x019f }
                boolean r5 = r5.equals(r7)     // Catch:{ Exception -> 0x019f }
                if (r5 == 0) goto L_0x0109
                android.widget.EditText r5 = r12.z     // Catch:{ Exception -> 0x019f }
                goto L_0x0105
            L_0x00ff:
                int r5 = r12.m     // Catch:{ Exception -> 0x019f }
                if (r5 != 0) goto L_0x0109
                android.widget.EditText r5 = r12.w     // Catch:{ Exception -> 0x019f }
            L_0x0105:
                r5.setHintTextColor(r10)     // Catch:{ Exception -> 0x019f }
                r8 = 1
            L_0x0109:
                if (r8 != 0) goto L_0x018e
                android.app.ProgressDialog r5 = r12.g     // Catch:{ Exception -> 0x019f }
                r5.show()     // Catch:{ Exception -> 0x019f }
                com.sozpic.miniland.AppMiniland r5 = com.sozpic.miniland.AppMiniland.f()     // Catch:{ Exception -> 0x019f }
                com.sozpic.miniland.modelos.Usuario r5 = r5.i()     // Catch:{ Exception -> 0x019f }
                java.util.HashMap r7 = new java.util.HashMap     // Catch:{ Exception -> 0x019f }
                r7.<init>()     // Catch:{ Exception -> 0x019f }
                java.lang.String r8 = "fecha"
                r7.put(r8, r0)     // Catch:{ Exception -> 0x019f }
                java.lang.String r0 = "fechafin"
                r7.put(r0, r1)     // Catch:{ Exception -> 0x019f }
                java.lang.String r0 = "hora"
                r7.put(r0, r2)     // Catch:{ Exception -> 0x019f }
                java.lang.String r0 = "horafin"
                r7.put(r0, r3)     // Catch:{ Exception -> 0x019f }
                java.lang.String r0 = "asunto"
                android.widget.TextView r1 = r12.f4495b     // Catch:{ Exception -> 0x019f }
                java.lang.CharSequence r1 = r1.getText()     // Catch:{ Exception -> 0x019f }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x019f }
                r7.put(r0, r1)     // Catch:{ Exception -> 0x019f }
                java.lang.String r0 = "tododia"
                r7.put(r0, r4)     // Catch:{ Exception -> 0x019f }
                java.lang.String r0 = "descripcion"
                android.widget.TextView r1 = r12.f4496c     // Catch:{ Exception -> 0x019f }
                java.lang.CharSequence r1 = r1.getText()     // Catch:{ Exception -> 0x019f }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x019f }
                r7.put(r0, r1)     // Catch:{ Exception -> 0x019f }
                java.lang.String r0 = "bd"
                java.lang.String r1 = r5.getBd()     // Catch:{ Exception -> 0x019f }
                r7.put(r0, r1)     // Catch:{ Exception -> 0x019f }
                java.lang.String r0 = "bdpre"
                java.lang.String r1 = r5.getBdpre()     // Catch:{ Exception -> 0x019f }
                r7.put(r0, r1)     // Catch:{ Exception -> 0x019f }
                java.lang.String r0 = "https://emybaby.com/api/calendario.php"
                com.sozpic.miniland.modelos.Agenda r1 = r12.A     // Catch:{ Exception -> 0x019f }
                if (r1 == 0) goto L_0x017a
                java.lang.String r1 = "idActividad"
                com.sozpic.miniland.modelos.Agenda r2 = r12.A     // Catch:{ Exception -> 0x019f }
                java.lang.String r2 = r2.getId()     // Catch:{ Exception -> 0x019f }
                r7.put(r1, r2)     // Catch:{ Exception -> 0x019f }
                java.lang.String r1 = "editaractividad"
                goto L_0x017c
            L_0x017a:
                java.lang.String r1 = "anadiractividad"
            L_0x017c:
                r7.put(r1, r6)     // Catch:{ Exception -> 0x019f }
                a.h.a.l0.b r1 = new a.h.a.l0.b     // Catch:{ Exception -> 0x019f }
                android.os.Handler r2 = r12.C     // Catch:{ Exception -> 0x019f }
                java.lang.String r0 = a.c.a.d.a.c(r0, r7)     // Catch:{ Exception -> 0x019f }
                r1.<init>(r2, r0)     // Catch:{ Exception -> 0x019f }
                r1.start()     // Catch:{ Exception -> 0x019f }
                goto L_0x01a4
            L_0x018e:
                android.content.Context r0 = r12.f4494a     // Catch:{ Exception -> 0x019f }
                r1 = 2131820674(0x7f110082, float:1.927407E38)
                java.lang.String r1 = a.c.a.d.a.h(r1)     // Catch:{ Exception -> 0x019f }
                android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r9)     // Catch:{ Exception -> 0x019f }
                r0.show()     // Catch:{ Exception -> 0x019f }
                goto L_0x01a4
            L_0x019f:
                android.app.ProgressDialog r12 = r12.g
                r12.dismiss()
            L_0x01a4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sozpic.miniland.NuevoCalendarioActivity.a.onClick(android.view.View):void");
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            NuevoCalendarioActivity.this.finish();
        }
    }

    public class c extends Handler {
        public c() {
        }

        public void handleMessage(Message message) {
            NuevoCalendarioActivity.this.g.dismiss();
            if (!(message == null || message.obj == null)) {
                StringBuilder n = a.a.a.a.a.n("SH2:");
                n.append(message.toString());
                Log.d("MINILAND_EBABY", n.toString());
                String obj = message.obj.toString();
                if ("OK".equalsIgnoreCase(obj)) {
                    Intent intent = new Intent();
                    intent.putExtra("nuevoactividad", o0O00000.O000000o);
                    NuevoCalendarioActivity.this.setResult(-1, intent);
                    NuevoCalendarioActivity.this.finish();
                    return;
                }
                try {
                    if (new JSONObject(obj).has("idActividad")) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("nuevoactividad", o0O00000.O000000o);
                        NuevoCalendarioActivity.this.setResult(-1, intent2);
                        ((InputMethodManager) NuevoCalendarioActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(NuevoCalendarioActivity.this.f4495b.getWindowToken(), 0);
                        f.c().d("CALENDARIO", "EVENTO_GUARDADO", "");
                        if (NuevoCalendarioActivity.this.B.isChecked()) {
                            NuevoCalendarioActivity.this.A = new Agenda();
                            NuevoCalendarioActivity.this.A.setNombre(NuevoCalendarioActivity.this.f4495b.getText().toString());
                            NuevoCalendarioActivity.this.A.setTexto(NuevoCalendarioActivity.this.f4496c.getText().toString());
                            NuevoCalendarioActivity.this.A.setTododia(NuevoCalendarioActivity.this.f4497d.isChecked() ? "1" : oOO0O0O0.O0000oO0);
                            StringBuilder sb = new StringBuilder();
                            if (NuevoCalendarioActivity.this.m < 10) {
                                sb.append(oOO0O0O0.O0000oO0);
                            }
                            sb.append(NuevoCalendarioActivity.this.m);
                            sb.append("-");
                            if (NuevoCalendarioActivity.this.l < 10) {
                                sb.append(oOO0O0O0.O0000oO0);
                            }
                            sb.append(NuevoCalendarioActivity.this.l);
                            sb.append("-");
                            sb.append(NuevoCalendarioActivity.this.k);
                            sb.append(" ");
                            sb.append(NuevoCalendarioActivity.this.q);
                            sb.append(":");
                            sb.append(NuevoCalendarioActivity.this.r);
                            sb.append(":");
                            sb.append(NuevoCalendarioActivity.this.s);
                            NuevoCalendarioActivity.this.A.setFechainicio(sb.toString());
                            if (!NuevoCalendarioActivity.this.f4497d.isChecked()) {
                                StringBuilder sb2 = new StringBuilder();
                                if (NuevoCalendarioActivity.this.p < 10) {
                                    sb.append(oOO0O0O0.O0000oO0);
                                }
                                sb2.append(NuevoCalendarioActivity.this.p);
                                sb2.append("-");
                                if (NuevoCalendarioActivity.this.o < 10) {
                                    sb.append(oOO0O0O0.O0000oO0);
                                }
                                sb2.append(NuevoCalendarioActivity.this.o);
                                sb2.append("-");
                                sb2.append(NuevoCalendarioActivity.this.n);
                                sb2.append(" ");
                                sb2.append(NuevoCalendarioActivity.this.t);
                                sb2.append(":");
                                sb2.append(NuevoCalendarioActivity.this.u);
                                sb2.append(":");
                                sb2.append(NuevoCalendarioActivity.this.v);
                                NuevoCalendarioActivity.this.A.setFechafin(sb2.toString());
                            }
                            a.c.a.d.a.b(NuevoCalendarioActivity.this, NuevoCalendarioActivity.this.A);
                        }
                        NuevoCalendarioActivity.this.finish();
                        return;
                    }
                    Toast.makeText(NuevoCalendarioActivity.this.f4494a, "Error", 0).show();
                    return;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            Toast.makeText(NuevoCalendarioActivity.this.f4494a, "Error", 0).show();
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
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        ViewGroup viewGroup;
        int i12;
        CheckBox checkBox = this.f4497d;
        if (view == checkBox) {
            if (checkBox.isChecked()) {
                viewGroup = this.i;
                i12 = 8;
            } else {
                viewGroup = this.i;
                i12 = 0;
            }
            viewGroup.setVisibility(i12);
            this.j.setVisibility(i12);
        } else if (view == this.w) {
            int i13 = this.k;
            if (i13 > 0) {
                i11 = i13;
                i10 = this.l - 1;
                i9 = this.m;
            } else {
                Calendar instance = Calendar.getInstance();
                int i14 = instance.get(1);
                int i15 = instance.get(2);
                i11 = i14;
                i9 = instance.get(5);
                i10 = i15;
            }
            new DatePickerDialog(this, new s(this), i11, i10, i9).show();
        } else if (view == this.x) {
            int i16 = this.n;
            if (i16 > 0) {
                i8 = i16;
                i7 = this.o - 1;
                i6 = this.p;
            } else {
                Calendar instance2 = Calendar.getInstance();
                int i17 = instance2.get(1);
                int i18 = instance2.get(2);
                i8 = i17;
                i6 = instance2.get(5);
                i7 = i18;
            }
            new DatePickerDialog(this, new t(this), i8, i7, i6).show();
        } else if (view == this.y) {
            if (a.c.a.d.a.j(this.r) || oOO0O0O0.O0000oO0.equals(this.r)) {
                Calendar instance3 = Calendar.getInstance();
                int i19 = instance3.get(11);
                i4 = instance3.get(12);
                i5 = i19;
            } else {
                i5 = Integer.valueOf(this.q).intValue();
                i4 = Integer.valueOf(this.r).intValue();
            }
            new TimePickerDialog(this, new q(this), i5, i4, DateFormat.is24HourFormat(this)).show();
        } else if (view == this.z) {
            if (a.c.a.d.a.j(this.u) || oOO0O0O0.O0000oO0.equals(this.u)) {
                Calendar instance4 = Calendar.getInstance();
                int i20 = instance4.get(11);
                i2 = instance4.get(12);
                i3 = i20;
            } else {
                i3 = Integer.valueOf(this.t).intValue();
                i2 = Integer.valueOf(this.u).intValue();
            }
            new TimePickerDialog(this, new r(this), i3, i2, DateFormat.is24HourFormat(this)).show();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0205 A[Catch:{ Exception -> 0x020c }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0264  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x02a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r10) {
        /*
            r9 = this;
            super.onCreate(r10)
            r9.f4494a = r9
            r10 = 1
            r9.requestWindowFeature(r10)
            r0 = 2131492940(0x7f0c004c, float:1.8609346E38)
            r9.setContentView(r0)
            r0 = 2131296574(0x7f09013e, float:1.8211069E38)
            android.view.View r0 = r9.findViewById(r0)
            com.sozpic.miniland.TopMenuActivity r0 = (com.sozpic.miniland.TopMenuActivity) r0
            r9.h = r0
            r0.setListener(r9)
            com.sozpic.miniland.TopMenuActivity r0 = r9.h
            r1 = 2131821105(0x7f110231, float:1.9274944E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setSeccion(r1)
            r0 = 2131296846(0x7f09024e, float:1.821162E38)
            android.view.View r0 = r9.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131820571(0x7f11001b, float:1.927386E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setText(r1)
            r0 = 2131297628(0x7f09055c, float:1.8213206E38)
            android.view.View r0 = r9.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131820586(0x7f11002a, float:1.9273891E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            r0.setText(r1)
            android.content.Intent r0 = r9.getIntent()
            android.os.Bundle r0 = r0.getExtras()
            r1 = 0
            if (r0 == 0) goto L_0x006b
            java.lang.String r2 = "KEY_INTENT_AGENDA"
            boolean r3 = r0.containsKey(r2)
            if (r3 == 0) goto L_0x006b
            android.os.Parcelable r0 = r0.getParcelable(r2)
            com.sozpic.miniland.modelos.Agenda r0 = (com.sozpic.miniland.modelos.Agenda) r0
            r9.A = r0
            goto L_0x006d
        L_0x006b:
            r9.A = r1
        L_0x006d:
            r0 = 2131296737(0x7f0901e1, float:1.82114E38)
            android.view.View r0 = r9.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r9.f4495b = r0
            r2 = 2131821354(0x7f11032a, float:1.9275449E38)
            java.lang.String r2 = a.c.a.d.a.h(r2)
            r0.setHint(r2)
            r0 = 2131296743(0x7f0901e7, float:1.8211411E38)
            android.view.View r0 = r9.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r9.f4496c = r0
            r2 = 2131820772(0x7f1100e4, float:1.9274268E38)
            java.lang.String r2 = a.c.a.d.a.h(r2)
            r0.setHint(r2)
            r0 = 2131297627(0x7f09055b, float:1.8213204E38)
            android.view.View r0 = r9.findViewById(r0)
            android.widget.CheckBox r0 = (android.widget.CheckBox) r0
            r9.f4497d = r0
            r0.setOnClickListener(r9)
            r0 = 2131296964(0x7f0902c4, float:1.821186E38)
            android.view.View r0 = r9.findViewById(r0)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r9.j = r0
            r0 = 2131297193(0x7f0903a9, float:1.8212324E38)
            android.view.View r0 = r9.findViewById(r0)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r9.i = r0
            r0 = 2131296466(0x7f0900d2, float:1.821085E38)
            android.view.View r0 = r9.findViewById(r0)
            android.widget.Button r0 = (android.widget.Button) r0
            r9.f4498e = r0
            r2 = 2131821000(0x7f1101c8, float:1.927473E38)
            java.lang.String r2 = a.c.a.d.a.h(r2)
            java.lang.String r2 = r2.toUpperCase()
            r0.setText(r2)
            android.widget.Button r0 = r9.f4498e
            com.sozpic.miniland.NuevoCalendarioActivity$a r2 = new com.sozpic.miniland.NuevoCalendarioActivity$a
            r2.<init>()
            r0.setOnClickListener(r2)
            r0 = 2131296492(0x7f0900ec, float:1.8210902E38)
            android.view.View r0 = r9.findViewById(r0)
            android.widget.Button r0 = (android.widget.Button) r0
            r9.f = r0
            r2 = 2131820651(0x7f11006b, float:1.9274023E38)
            java.lang.String r2 = a.c.a.d.a.h(r2)
            java.lang.String r2 = r2.toUpperCase()
            r0.setText(r2)
            android.widget.Button r0 = r9.f
            com.sozpic.miniland.NuevoCalendarioActivity$b r2 = new com.sozpic.miniland.NuevoCalendarioActivity$b
            r2.<init>()
            r0.setOnClickListener(r2)
            r0 = 2131296747(0x7f0901eb, float:1.821142E38)
            android.view.View r0 = r9.findViewById(r0)
            android.widget.EditText r0 = (android.widget.EditText) r0
            r9.w = r0
            r2 = 2131821340(0x7f11031c, float:1.927542E38)
            java.lang.String r2 = a.c.a.d.a.h(r2)
            r0.setHint(r2)
            android.widget.EditText r0 = r9.w
            r0.setOnClickListener(r9)
            r0 = 2131296748(0x7f0901ec, float:1.8211421E38)
            android.view.View r0 = r9.findViewById(r0)
            android.widget.EditText r0 = (android.widget.EditText) r0
            r9.x = r0
            r2 = 2131820824(0x7f110118, float:1.9274374E38)
            java.lang.String r2 = a.c.a.d.a.h(r2)
            r0.setHint(r2)
            android.widget.EditText r0 = r9.x
            r0.setOnClickListener(r9)
            r0 = 2131296771(0x7f090203, float:1.8211468E38)
            android.view.View r0 = r9.findViewById(r0)
            android.widget.EditText r0 = (android.widget.EditText) r0
            r9.y = r0
            r2 = 2131821343(0x7f11031f, float:1.9275427E38)
            java.lang.String r2 = a.c.a.d.a.h(r2)
            r0.setHint(r2)
            android.widget.EditText r0 = r9.y
            r0.setOnClickListener(r9)
            r0 = 2131296772(0x7f090204, float:1.821147E38)
            android.view.View r0 = r9.findViewById(r0)
            android.widget.EditText r0 = (android.widget.EditText) r0
            r9.z = r0
            r2 = 2131820825(0x7f110119, float:1.9274376E38)
            java.lang.String r2 = a.c.a.d.a.h(r2)
            r0.setHint(r2)
            android.widget.EditText r0 = r9.z
            r0.setOnClickListener(r9)
            r0 = 2131297189(0x7f0903a5, float:1.8212316E38)
            android.view.View r0 = r9.findViewById(r0)
            android.widget.CheckBox r0 = (android.widget.CheckBox) r0
            r9.B = r0
            r0 = 2131297191(0x7f0903a7, float:1.821232E38)
            android.view.View r0 = r9.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r2 = 2131820579(0x7f110023, float:1.9273877E38)
            java.lang.String r2 = a.c.a.d.a.h(r2)
            r0.setText(r2)
            r0 = 2131297190(0x7f0903a6, float:1.8212318E38)
            android.view.View r0 = r9.findViewById(r0)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            com.sozpic.miniland.modelos.Agenda r2 = r9.A
            if (r2 == 0) goto L_0x02ae
            r2 = 8
            r0.setVisibility(r2)
            android.widget.TextView r0 = r9.f4495b
            com.sozpic.miniland.modelos.Agenda r3 = r9.A
            java.lang.String r3 = r3.getNombre()
            r0.setText(r3)
            android.widget.TextView r0 = r9.f4496c
            com.sozpic.miniland.modelos.Agenda r3 = r9.A
            java.lang.String r3 = r3.getTexto()
            r0.setText(r3)
            com.sozpic.miniland.modelos.Agenda r0 = r9.A
            java.lang.String r0 = r0.getTododia()
            java.lang.String r3 = "0"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x01c4
            android.widget.CheckBox r0 = r9.f4497d
            r2 = 0
            r0.setChecked(r2)
            goto L_0x01d3
        L_0x01c4:
            android.widget.CheckBox r0 = r9.f4497d
            r0.setChecked(r10)
            android.view.ViewGroup r0 = r9.i
            r0.setVisibility(r2)
            android.view.ViewGroup r0 = r9.j
            r0.setVisibility(r2)
        L_0x01d3:
            com.sozpic.miniland.modelos.Agenda r0 = r9.A
            java.lang.String r0 = r0.getFechainicio()
            com.sozpic.miniland.modelos.Agenda r2 = r9.A
            java.lang.String r2 = r2.getFechafin()
            java.text.DateFormat r3 = a.c.d.r.j.i     // Catch:{ Exception -> 0x01f4 }
            java.util.Date r3 = r3.parse(r0)     // Catch:{ Exception -> 0x01f4 }
            int r4 = r3.getYear()     // Catch:{ Exception -> 0x01f2 }
            if (r4 >= 0) goto L_0x01f9
            java.text.DateFormat r4 = a.c.d.r.j.j     // Catch:{ Exception -> 0x01f2 }
            java.util.Date r3 = r4.parse(r0)     // Catch:{ Exception -> 0x01f2 }
            goto L_0x01f9
        L_0x01f2:
            r4 = move-exception
            goto L_0x01f6
        L_0x01f4:
            r4 = move-exception
            r3 = r1
        L_0x01f6:
            r4.printStackTrace()
        L_0x01f9:
            java.text.DateFormat r4 = a.c.d.r.j.i     // Catch:{ Exception -> 0x020c }
            java.util.Date r1 = r4.parse(r2)     // Catch:{ Exception -> 0x020c }
            int r4 = r1.getYear()     // Catch:{ Exception -> 0x020c }
            if (r4 >= 0) goto L_0x0210
            java.text.DateFormat r4 = a.c.d.r.j.j     // Catch:{ Exception -> 0x020c }
            java.util.Date r1 = r4.parse(r2)     // Catch:{ Exception -> 0x020c }
            goto L_0x0210
        L_0x020c:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0210:
            r2 = 12
            r4 = 11
            r5 = 2
            r6 = 5
            if (r3 == 0) goto L_0x025d
            android.widget.EditText r7 = r9.w
            java.text.DateFormat r8 = a.c.d.r.j.f
            java.lang.String r8 = r8.format(r3)
            r7.setText(r8)
            android.widget.EditText r7 = r9.y
            java.text.DateFormat r8 = a.c.d.r.j.l
            java.lang.String r8 = r8.format(r3)
            r7.setText(r8)
            java.util.Calendar r7 = java.util.Calendar.getInstance()
            r7.setTime(r3)
            int r3 = r7.get(r6)
            r9.m = r3
            int r3 = r7.get(r5)
            int r3 = r3 + r10
            r9.l = r3
            int r3 = r7.get(r10)
            r9.k = r3
            int r3 = r7.get(r4)
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r9.q = r3
            int r3 = r7.get(r2)
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r9.r = r3
            goto L_0x0262
        L_0x025d:
            android.widget.EditText r3 = r9.w
            r3.setText(r0)
        L_0x0262:
            if (r1 == 0) goto L_0x02a9
            android.widget.EditText r0 = r9.x
            java.text.DateFormat r3 = a.c.d.r.j.f
            java.lang.String r3 = r3.format(r1)
            r0.setText(r3)
            android.widget.EditText r0 = r9.z
            java.text.DateFormat r3 = a.c.d.r.j.l
            java.lang.String r3 = r3.format(r1)
            r0.setText(r3)
            java.util.Calendar r0 = java.util.Calendar.getInstance()
            r0.setTime(r1)
            int r1 = r0.get(r6)
            r9.p = r1
            int r1 = r0.get(r5)
            int r1 = r1 + r10
            r9.o = r1
            int r10 = r0.get(r10)
            r9.n = r10
            int r10 = r0.get(r4)
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r9.t = r10
            int r10 = r0.get(r2)
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r9.u = r10
            goto L_0x02ae
        L_0x02a9:
            android.widget.EditText r10 = r9.x
            r10.setText(r0)
        L_0x02ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sozpic.miniland.NuevoCalendarioActivity.onCreate(android.os.Bundle):void");
    }

    public void onResume() {
        super.onResume();
        f.c().e("CALENDARIO_EVENTO_ANYADIR");
    }
}
