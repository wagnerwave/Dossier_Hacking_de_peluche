package com.sozpic.miniland;

import a.c.d.r.j;
import a.c.d.s.c.c;
import a.h.a.d0;
import a.h.a.e0;
import a.h.a.f0;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.cuatroochenta.miniland.webservices.help.HelpInfoRequest;

public class PreLoginActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public Context f4526a;

    /* renamed from: b  reason: collision with root package name */
    public Button f4527b;

    /* renamed from: c  reason: collision with root package name */
    public Button f4528c;

    /* renamed from: d  reason: collision with root package name */
    public Button f4529d;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            PreLoginActivity preLoginActivity = PreLoginActivity.this;
            if (preLoginActivity != null) {
                preLoginActivity.startActivity(new Intent(preLoginActivity.f4526a, LoginActivity.class));
                return;
            }
            throw null;
        }
    }

    public class b implements View.OnClickListener {
        public b(PreLoginActivity preLoginActivity) {
        }

        public void onClick(View view) {
            a.c.a.d.a.n(view.getContext(), j.b().f());
        }
    }

    public class c implements View.OnClickListener {
        public c(PreLoginActivity preLoginActivity) {
        }

        public void onClick(View view) {
            a.c.a.d.a.n(view.getContext(), j.b().g());
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            PreLoginActivity preLoginActivity = PreLoginActivity.this;
            if (preLoginActivity != null) {
                Dialog dialog = new Dialog(preLoginActivity, 2131886561);
                dialog.requestWindowFeature(1);
                dialog.setContentView(R.layout.popup_que);
                dialog.setCancelable(true);
                ((TextView) dialog.findViewById(R.id.texto)).setText(Html.fromHtml(a.c.a.d.a.h(R.string.TR_ABOUT_EMYBABY_DESCRIPTION)));
                Button button = (Button) dialog.findViewById(R.id.ccancel);
                button.setText(a.c.a.d.a.h(R.string.TR_OK).toUpperCase());
                button.setOnClickListener(new e0(preLoginActivity, dialog));
                dialog.show();
                return;
            }
            throw null;
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            PreLoginActivity preLoginActivity = PreLoginActivity.this;
            if (preLoginActivity != null) {
                preLoginActivity.startActivity(new Intent(preLoginActivity.f4526a, RegistroActivity.class));
                return;
            }
            throw null;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4526a = this;
        requestWindowFeature(1);
        setContentView(R.layout.activity_prelogin);
        Button button = (Button) findViewById(R.id.blogin);
        this.f4527b = button;
        button.setText(a.c.a.d.a.h(R.string.TR_LOG_IN).toUpperCase());
        Button button2 = (Button) findViewById(R.id.bque);
        this.f4528c = button2;
        button2.setText(a.c.a.d.a.h(R.string.TR_WHAT_IS).toUpperCase());
        Button button3 = (Button) findViewById(R.id.bregistrar);
        this.f4529d = button3;
        button3.setText(a.c.a.d.a.h(R.string.TR_REGISTER).toUpperCase());
        this.f4527b.setOnClickListener(new a());
        Button button4 = (Button) findViewById(R.id.bprivacidad);
        button4.setText(a.c.a.d.a.h(R.string.TR_POLITICA_PRIVACIDAD).toUpperCase());
        button4.setOnClickListener(new b(this));
        Button button5 = (Button) findViewById(R.id.btn_condiciones);
        button5.setText(a.c.a.d.a.h(R.string.TR_CONDICIONES_USO).toUpperCase());
        button5.setOnClickListener(new c(this));
        this.f4528c.setOnClickListener(new d());
        this.f4529d.setOnClickListener(new e());
        a.c.d.s.c.c cVar = new a.c.d.s.c.c();
        cVar.f882b = "https://emybaby.com/api/helpimages.php";
        new c.a(new HelpInfoRequest(), new d0(this)).start();
    }

    public void onResume() {
        super.onResume();
        d.a.a.e.d(this, getString(R.string.hockeyAppId), new f0(this));
    }
}
