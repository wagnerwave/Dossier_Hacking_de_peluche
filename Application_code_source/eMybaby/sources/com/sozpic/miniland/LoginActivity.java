package com.sozpic.miniland;

import a.c.d.r.j;
import a.c.d.s.d.c;
import a.d.a.a.c.a.d.h;
import a.d.a.a.l.p;
import android.accounts.Account;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.cuatroochenta.miniland.webservices.login.GoogleLoginPostRequest;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.sozpic.miniland.modelos.Usuario;
import com.tuya.smart.common.oOO0O0O0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends a.c.d.c implements a.c.d.s.d.d {

    /* renamed from: b  reason: collision with root package name */
    public Context f4464b;

    /* renamed from: c  reason: collision with root package name */
    public Button f4465c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f4466d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f4467e;
    public ProgressDialog f;
    public AppCompatCheckBox g;
    public SharedPreferences h;
    public SharedPreferences.Editor i;
    public String j;
    public a.d.a.a.c.a.d.a k;
    public Handler l = new f();

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            StringBuilder p = a.a.a.a.a.p("https://emybaby.com/", "recuperar_pass.php?lang=");
            p.append(AppMiniland.f().f1b);
            a.c.a.d.a.n(LoginActivity.this, p.toString());
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            LoginActivity.this.startActivity(new Intent(LoginActivity.this.f4464b, RegistroActivity.class));
            LoginActivity.this.finish();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            a.c.a.d.a.n(LoginActivity.this.f4464b, j.b().f());
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            Context context;
            int i;
            LoginActivity loginActivity = LoginActivity.this;
            String obj = loginActivity.f4466d.getText().toString();
            String obj2 = loginActivity.f4467e.getText().toString();
            loginActivity.j = obj2;
            loginActivity.j = a.e.a.a.r.b.P(obj2);
            if ((loginActivity.g.isChecked() ? "1" : oOO0O0O0.O0000oO0).equals("1")) {
                loginActivity.i.putString("correo", obj);
                loginActivity.i.putString("passw", obj2);
            } else {
                loginActivity.i.putString("correo", "");
                loginActivity.i.putString("passw", "");
            }
            loginActivity.i.commit();
            if (obj.equals("") || loginActivity.j.equals("")) {
                Context context2 = loginActivity.f4464b;
                i = R.string.TR_COMPLETE_ALL_FIELDS;
                context = context2;
            } else if (a.c.a.d.a.k(loginActivity)) {
                ProgressDialog progressDialog = new ProgressDialog(loginActivity.f4464b);
                loginActivity.f = progressDialog;
                progressDialog.setCancelable(true);
                loginActivity.f.setMessage(a.c.a.d.a.h(R.string.TR_UPDATING));
                loginActivity.f.setIndeterminate(true);
                loginActivity.f.show();
                try {
                    new a.h.a.l0.b(loginActivity.l, "&email=" + obj + "&pass=" + loginActivity.j + "&osname=" + "Android" + "&osversion=" + Build.VERSION.RELEASE + "&appversion=" + AppMiniland.f().a() + "&brand=" + Uri.encode(Build.MANUFACTURER) + "&model=" + Uri.encode(Build.MODEL), "login.php?applogin=1").start();
                    return;
                } catch (Exception unused) {
                    return;
                }
            } else {
                i = R.string.TR_NO_NETWORK_CONNECTION;
                context = loginActivity;
            }
            Toast.makeText(context, a.c.a.d.a.h(i), 0).show();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            Intent intent;
            a.d.a.a.c.a.d.a aVar = LoginActivity.this.k;
            Context context = aVar.f1254a;
            int i = h.f1224a[aVar.b() - 1];
            if (i == 1) {
                a.d.a.a.c.a.d.c.f.f1217a.a("getFallbackSignInIntent()", new Object[0]);
                intent = a.d.a.a.c.a.d.c.f.b(context, (GoogleSignInOptions) aVar.f1256c);
                intent.setAction("com.google.android.gms.auth.APPAUTH_SIGN_IN");
            } else if (i != 2) {
                a.d.a.a.c.a.d.c.f.f1217a.a("getNoImplementationSignInIntent()", new Object[0]);
                intent = a.d.a.a.c.a.d.c.f.b(context, (GoogleSignInOptions) aVar.f1256c);
                intent.setAction("com.google.android.gms.auth.NO_IMPL");
            } else {
                intent = a.d.a.a.c.a.d.c.f.b(context, (GoogleSignInOptions) aVar.f1256c);
            }
            LoginActivity.this.startActivityForResult(intent, 999);
        }
    }

    public class f extends Handler {
        public f() {
        }

        public void handleMessage(Message message) {
            Context context;
            int i;
            LoginActivity.this.f.dismiss();
            if (message != null) {
                StringBuilder n = a.a.a.a.a.n("SH2:");
                n.append(message.toString());
                Log.d("MINILAND_EBABY", n.toString());
                if (message.obj != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(message.obj.toString());
                        if (jSONObject.has("errorMessage")) {
                            Toast.makeText(LoginActivity.this.f4464b, jSONObject.getString("errorMessage"), 0).show();
                            return;
                        }
                        Usuario U = a.e.a.a.r.b.U(jSONObject, LoginActivity.this.f4466d.getText().toString(), LoginActivity.this.j);
                        if (U != null) {
                            AppMiniland.f().g = U;
                            LoginActivity.this.startActivityForResult(new Intent(LoginActivity.this.f4464b, MainActivity.class), 0);
                            LoginActivity.this.finish();
                            return;
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                context = LoginActivity.this.f4464b;
                i = R.string.TR_ERROR_LOGIN_INCORRECT;
            } else {
                context = LoginActivity.this.f4464b;
                i = R.string.TR_NO_NETWORK_CONNECTION;
            }
            Toast.makeText(context, a.c.a.d.a.h(i), 0).show();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        p pVar;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 999) {
            a.d.a.a.c.a.d.b a2 = a.d.a.a.c.a.d.c.f.a(intent);
            GoogleSignInAccount googleSignInAccount = a2.f1207b;
            if (!a2.f1206a.e() || googleSignInAccount == null) {
                a.d.a.a.e.k.b C = a.c.a.f.b.C(a2.f1206a);
                p pVar2 = new p();
                pVar2.d(C);
                pVar = pVar2;
            } else {
                pVar = new p();
                pVar.e(googleSignInAccount);
            }
            q(pVar);
        }
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        this.f4464b = this;
        requestWindowFeature(1);
        setContentView(R.layout.activity_login);
        boolean z2 = false;
        SharedPreferences sharedPreferences = getSharedPreferences("MisPreferenciasEbaby", 0);
        this.h = sharedPreferences;
        this.i = sharedPreferences.edit();
        Button button = (Button) findViewById(R.id.blogin);
        this.f4465c = button;
        button.setText(a.c.a.d.a.h(R.string.TR_LOG_IN).toUpperCase());
        EditText editText = (EditText) findViewById(R.id.correo);
        this.f4466d = editText;
        editText.setHint(a.c.a.d.a.h(R.string.TR_EMAIL));
        EditText editText2 = (EditText) findViewById(R.id.contrasena);
        this.f4467e = editText2;
        editText2.setHint(a.c.a.d.a.h(R.string.TR_PASSWORD));
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) findViewById(R.id.recordar);
        this.g = appCompatCheckBox;
        appCompatCheckBox.setText(a.c.a.d.a.h(R.string.TR_REMEMBER_ME));
        TextView textView = (TextView) findViewById(R.id.login_forgot_password);
        textView.setText(a.c.a.d.a.h(R.string.TR_FORGOT_PASSWORD));
        textView.setOnClickListener(new a());
        TextView textView2 = (TextView) findViewById(R.id.login_register);
        textView2.setText(a.c.a.d.a.h(R.string.TR_LAUNCH_REGISTER_FROM_LOGIN));
        textView2.setOnClickListener(new b());
        TextView textView3 = (TextView) findViewById(R.id.login_privacy_policy);
        textView3.setVisibility(8);
        textView3.setText(a.c.a.d.a.h(R.string.TR_POLITICA_PRIVACIDAD));
        textView3.setOnClickListener(new c());
        if (!this.h.getString("correo", "").equals("")) {
            this.f4466d.setText(this.h.getString("correo", ""));
            z = true;
        } else {
            z = false;
        }
        if (!this.h.getString("passw", "").equals("")) {
            this.f4467e.setText(this.h.getString("passw", ""));
        }
        if (z) {
            this.g.setChecked(true);
        }
        this.f4465c.setOnClickListener(new d());
        GoogleSignInOptions googleSignInOptions = GoogleSignInOptions.p;
        new HashSet();
        new HashMap();
        a.c.a.f.b.k(googleSignInOptions);
        HashSet hashSet = new HashSet(googleSignInOptions.f4172b);
        boolean z3 = googleSignInOptions.f4175e;
        boolean z4 = googleSignInOptions.f;
        boolean z5 = googleSignInOptions.f4174d;
        String str = googleSignInOptions.g;
        Account account = googleSignInOptions.f4173c;
        String str2 = googleSignInOptions.h;
        Map<Integer, GoogleSignInOptionsExtensionParcelable> h2 = GoogleSignInOptions.h(googleSignInOptions.i);
        String str3 = googleSignInOptions.j;
        hashSet.add(GoogleSignInOptions.l);
        a.c.a.f.b.h("741327798069-pdav60tjnimmq6o3gu9dlpvkq4pqs70k.apps.googleusercontent.com");
        if (str == null || str.equals("741327798069-pdav60tjnimmq6o3gu9dlpvkq4pqs70k.apps.googleusercontent.com")) {
            z2 = true;
        }
        a.c.a.f.b.e(z2, "two different server client ids provided");
        if (hashSet.contains(GoogleSignInOptions.o) && hashSet.contains(GoogleSignInOptions.n)) {
            hashSet.remove(GoogleSignInOptions.n);
        }
        if (account == null || !hashSet.isEmpty()) {
            hashSet.add(GoogleSignInOptions.m);
        }
        GoogleSignInOptions googleSignInOptions2 = new GoogleSignInOptions(3, new ArrayList(hashSet), account, true, z3, z4, "741327798069-pdav60tjnimmq6o3gu9dlpvkq4pqs70k.apps.googleusercontent.com", str2, h2, str3);
        a.c.a.f.b.k(googleSignInOptions2);
        this.k = new a.d.a.a.c.a.d.a((Activity) this, googleSignInOptions2);
        findViewById(R.id.btn_google_sign_in).setOnClickListener(new e());
    }

    public void onResume() {
        super.onResume();
        a.c.a.e.f.c().e("LOGIN");
    }

    public final void q(p<GoogleSignInAccount> pVar) {
        try {
            GoogleSignInAccount b2 = pVar.b(a.d.a.a.e.k.b.class);
            if (b2 != null) {
                a.c.d.a.l().i("KEY_USER_USERNAME", b2.f4169d);
                new c.a(new GoogleLoginPostRequest(b2.f4168c), this).start();
                p(a.c.a.d.a.h(R.string.TR_GETTING_INFO), false);
            }
        } catch (a.d.a.a.e.k.b e2) {
            StringBuilder n = a.a.a.a.a.n("signInResult:failed code=");
            n.append(e2.f1253a.f4207b);
            a.e.a.a.r.b.j("LoginActivity", n.toString());
        }
    }
}
