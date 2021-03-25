package com.cuatroochenta.miniland.emybuddy;

import a.c.a.e.f;
import a.c.d.c;
import a.c.d.s.a.d.d;
import a.c.d.s.a.d.e;
import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.sozpic.miniland.R;
import com.sozpic.miniland.TopMenuActivity;

public class BuddyActivateActivity extends c implements e {

    /* renamed from: b  reason: collision with root package name */
    public EditText f3813b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f3814c = new Handler();

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            BuddyActivateActivity.q(BuddyActivateActivity.this);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            a.c.a.d.a.n(BuddyActivateActivity.this, a.c.a.d.a.h(R.string.TR_EMYBUDDY_URL));
        }
    }

    public static void q(BuddyActivateActivity buddyActivateActivity) {
        if (buddyActivateActivity != null) {
            buddyActivateActivity.f3813b = new EditText(buddyActivateActivity);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, a.c.a.f.b.H(10), 0, a.c.a.f.b.H(10));
            buddyActivateActivity.f3813b.setLayoutParams(layoutParams);
            buddyActivateActivity.f3813b.setSingleLine(true);
            buddyActivateActivity.f3813b.setBackgroundResource(17170443);
            buddyActivateActivity.f3813b.setTextColor(buddyActivateActivity.getResources().getColor(R.color.default_text_color));
            new AlertDialog.Builder(buddyActivateActivity).setView(buddyActivateActivity.f3813b).setTitle(a.c.a.d.a.h(R.string.TR_ENTER_CODE_TITLE)).setMessage(a.c.a.d.a.h(R.string.TR_ENTER_CODE_DESCRIPTION)).setPositiveButton(a.c.a.d.a.h(R.string.TR_ACEPTAR), new a.c.d.g.b(buddyActivateActivity)).setNegativeButton(a.c.a.d.a.h(R.string.TR_CANCEL), new a.c.d.g.a(buddyActivateActivity)).show();
            new Handler().post(new a.c.d.g.c(buddyActivateActivity));
            return;
        }
        throw null;
    }

    public static void r(BuddyActivateActivity buddyActivateActivity) {
        if (buddyActivateActivity != null) {
            buddyActivateActivity.p(a.c.a.d.a.h(R.string.TR_CHECKING_BUDDY_CODE), true);
            a.c.d.s.a.d.a aVar = new a.c.d.s.a.d.a();
            aVar.f859a = buddyActivateActivity.f3813b.getText().toString();
            d dVar = new d();
            dVar.f41a = "https://emybaby.com/api/emybuddy.php";
            new d.a(aVar, buddyActivateActivity).start();
            return;
        }
        throw null;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.activity_mybuddy_activate);
        TopMenuActivity topMenuActivity = (TopMenuActivity) findViewById(R.id.cabecera);
        topMenuActivity.setListener(this);
        topMenuActivity.setSeccion(a.c.a.d.a.h(R.string.TR_BEMYBUDDY_TITLE_IOS));
        ((TextView) findViewById(R.id.buddy_activate_instructions)).setText(a.c.a.d.a.h(R.string.TR_AVAILABILITY_MODULE));
        TextView textView = (TextView) findViewById(R.id.buddy_activate_continue);
        textView.setText(a.c.a.d.a.h(R.string.TR_CONTINUE).toUpperCase());
        textView.setOnClickListener(new a());
        TextView textView2 = (TextView) findViewById(R.id.buddy_activate_link);
        textView2.setText(a.c.a.d.a.h(R.string.TR_CLICK_TO_KNOW_MORE));
        textView2.setOnClickListener(new b());
    }

    public void onResume() {
        super.onResume();
        f.c().e("BEMYBUDDY_ACCESO");
    }
}
