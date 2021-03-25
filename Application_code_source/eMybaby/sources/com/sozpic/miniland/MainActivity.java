package com.sozpic.miniland;

import a.c.d.c;
import a.c.d.m.a;
import a.c.d.m.d;
import a.h.a.b0;
import a.h.a.i;
import a.h.a.j;
import a.h.a.k;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.sozpic.miniland.TopMenu;

public class MainActivity extends c implements TopMenu.b, a.i {

    /* renamed from: b  reason: collision with root package name */
    public k f4474b = new k();

    /* renamed from: c  reason: collision with root package name */
    public TopMenu f4475c;

    /* renamed from: d  reason: collision with root package name */
    public DrawerLayout f4476d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f4477e;
    public Fragment f;
    public int g;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            a.c.a.d.a.l(MainActivity.this, "MAIN_MENU");
        }
    }

    public class b implements a.c.d.s.e.f.b.a {
        public b() {
        }
    }

    public void a() {
        r();
    }

    public void b() {
        if (this.f4476d.isDrawerOpen(3)) {
            this.f4476d.closeDrawer(3);
        } else {
            this.f4476d.openDrawer(3);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 1005) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1 && intent != null) {
            this.g = intent.getIntExtra("KEY_EXTRA_DELETE_MODE", 0);
        }
    }

    public void onBackPressed() {
        r();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.activity_main);
        TopMenu topMenu = (TopMenu) findViewById(R.id.cabecera);
        this.f4475c = topMenu;
        topMenu.setListener(this);
        ImageView rightButton = this.f4475c.getRightButton();
        this.f4477e = rightButton;
        if (rightButton != null) {
            rightButton.setVisibility(0);
            this.f4477e.setImageResource(R.drawable.ic_help_menu);
            this.f4477e.setOnClickListener(new a());
        }
        this.f4476d = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_menu_container, this.f4474b).commit();
        u(new b0(), false);
        if (!a.c.d.a.l().q("MAIN_MENU")) {
            a.c.a.d.a.l(this, "MAIN_MENU");
        }
        a.c.d.n.a.m(getSupportFragmentManager());
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        int i = this.g;
        if (i == 1) {
            q();
            s(4, false);
        } else if (i == 2) {
            q();
            u(new b0(), false);
        }
        this.g = 0;
    }

    public final void q() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.getBackStackEntryCount() > 0) {
            supportFragmentManager.popBackStack(supportFragmentManager.getBackStackEntryAt(0).getId(), 1);
        }
    }

    public final void r() {
        Fragment fragment = this.f;
        if ((fragment instanceof a.h.a.a) && ((a.h.a.a) fragment).i()) {
            return;
        }
        if (this.f4476d.isDrawerOpen(3)) {
            this.f4476d.closeDrawer(3);
        } else if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            Dialog dialog = new Dialog(this, 2131886561);
            dialog.requestWindowFeature(1);
            dialog.setContentView(R.layout.popup_mensaje);
            dialog.setCancelable(true);
            Button button = (Button) a.a.a.a.a.A(R.string.TR_EXIT_CONFIRM, (TextView) dialog.findViewById(R.id.texto), dialog, R.id.ccancel);
            button.setText(a.c.a.d.a.h(R.string.TR_CANCEL).toUpperCase());
            button.setOnClickListener(new i(this, dialog));
            Button button2 = (Button) dialog.findViewById(R.id.ook);
            button2.setText(a.c.a.d.a.h(R.string.TR_OK).toUpperCase());
            button2.setOnClickListener(new j(this));
            dialog.show();
        } else {
            this.f4475c.a();
            this.f4477e.setVisibility(0);
            this.f4475c.invalidate();
            super.onBackPressed();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00f6, code lost:
        u(r3, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x01d1, code lost:
        r3.e(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void s(int r3, boolean r4) {
        /*
            r2 = this;
            if (r4 == 0) goto L_0x0005
            r2.b()
        L_0x0005:
            r4 = 0
            r0 = 1
            switch(r3) {
                case 0: goto L_0x01d5;
                case 1: goto L_0x01b3;
                case 2: goto L_0x0194;
                case 3: goto L_0x0175;
                case 4: goto L_0x015a;
                case 5: goto L_0x013a;
                case 6: goto L_0x011b;
                case 7: goto L_0x00fb;
                case 8: goto L_0x00ba;
                case 9: goto L_0x009a;
                case 10: goto L_0x007a;
                case 11: goto L_0x0063;
                case 12: goto L_0x004c;
                case 13: goto L_0x002c;
                case 14: goto L_0x000c;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x01e1
        L_0x000c:
            com.sozpic.miniland.TopMenu r3 = r2.f4475c
            r4 = 2131821318(0x7f110306, float:1.9275376E38)
            java.lang.String r4 = a.c.a.d.a.h(r4)
            java.lang.String r4 = r4.toUpperCase()
            r3.setSeccion(r4)
            a.c.d.p.b r3 = new a.c.d.p.b
            r3.<init>()
            r2.u(r3, r0)
            a.c.a.e.f r3 = a.c.a.e.f.c()
            java.lang.String r4 = "SETTINGS_MENU"
            goto L_0x01d1
        L_0x002c:
            a.h.a.z r3 = new a.h.a.z
            r3.<init>()
            com.sozpic.miniland.TopMenu r4 = r2.f4475c
            r1 = 2131821105(0x7f110231, float:1.9274944E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            java.lang.String r1 = r1.toUpperCase()
            r4.setSeccion(r1)
            r2.u(r3, r0)
            a.c.a.e.f r3 = a.c.a.e.f.c()
            java.lang.String r4 = "CALENDARIO_MENU"
            goto L_0x01d1
        L_0x004c:
            com.sozpic.miniland.TopMenu r3 = r2.f4475c
            r4 = 2131821110(0x7f110236, float:1.9274954E38)
            java.lang.String r4 = a.c.a.d.a.h(r4)
            java.lang.String r4 = r4.toUpperCase()
            r3.setSeccion(r4)
            a.c.d.k.a r3 = new a.c.d.k.a
            r3.<init>()
            goto L_0x00f6
        L_0x0063:
            com.sozpic.miniland.TopMenu r3 = r2.f4475c
            r4 = 2131821121(0x7f110241, float:1.9274976E38)
            java.lang.String r4 = a.c.a.d.a.h(r4)
            java.lang.String r4 = r4.toUpperCase()
            r3.setSeccion(r4)
            a.c.d.l.b r3 = new a.c.d.l.b
            r3.<init>()
            goto L_0x00f6
        L_0x007a:
            a.h.a.u r3 = new a.h.a.u
            r3.<init>()
            com.sozpic.miniland.TopMenu r4 = r2.f4475c
            r1 = 2131821122(0x7f110242, float:1.9274978E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            java.lang.String r1 = r1.toUpperCase()
            r4.setSeccion(r1)
            r2.u(r3, r0)
            a.c.a.e.f r3 = a.c.a.e.f.c()
            java.lang.String r4 = "ALBUM_FOTOS_MENU"
            goto L_0x01d1
        L_0x009a:
            com.sozpic.miniland.TopMenu r3 = r2.f4475c
            r4 = 2131821109(0x7f110235, float:1.9274952E38)
            java.lang.String r4 = a.c.a.d.a.h(r4)
            java.lang.String r4 = r4.toUpperCase()
            r3.setSeccion(r4)
            r3 = 2
            a.c.d.h.a r3 = a.c.d.h.a.m(r3)
            r2.u(r3, r0)
            a.c.a.e.f r3 = a.c.a.e.f.c()
            java.lang.String r4 = "FICHA_MEDICA_SELECCION"
            goto L_0x01d1
        L_0x00ba:
            com.sozpic.miniland.TopMenu r3 = r2.f4475c
            r4 = 2131821108(0x7f110234, float:1.927495E38)
            java.lang.String r4 = a.c.a.d.a.h(r4)
            java.lang.String r4 = r4.toUpperCase()
            r3.setSeccion(r4)
            a.c.d.j.a r3 = new a.c.d.j.a
            android.content.Context r4 = com.sozpic.miniland.AppMiniland.l
            a.c.a.a r1 = a.c.a.a.f
            com.sozpic.miniland.AppMiniland r1 = (com.sozpic.miniland.AppMiniland) r1
            com.sozpic.miniland.modelos.Usuario r1 = r1.i()
            java.lang.String r1 = r1.getId()
            r3.<init>(r4, r1)
            a.c.d.j.b.d.e r3 = a.c.d.j.b.d.e.m
            if (r3 != 0) goto L_0x00f4
            java.lang.Class<a.c.d.j.b.d.e> r3 = a.c.d.j.b.d.e.class
            monitor-enter(r3)
            a.c.d.j.b.d.e r4 = a.c.d.j.b.d.e.m     // Catch:{ all -> 0x00f1 }
            if (r4 != 0) goto L_0x00ef
            a.c.d.j.b.d.e r4 = new a.c.d.j.b.d.e     // Catch:{ all -> 0x00f1 }
            r4.<init>()     // Catch:{ all -> 0x00f1 }
            a.c.d.j.b.d.e.m = r4     // Catch:{ all -> 0x00f1 }
        L_0x00ef:
            monitor-exit(r3)     // Catch:{ all -> 0x00f1 }
            goto L_0x00f4
        L_0x00f1:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00f1 }
            throw r4
        L_0x00f4:
            a.c.d.j.b.d.e r3 = a.c.d.j.b.d.e.m
        L_0x00f6:
            r2.u(r3, r0)
            goto L_0x01e1
        L_0x00fb:
            com.sozpic.miniland.TopMenu r3 = r2.f4475c
            r4 = 2131820820(0x7f110114, float:1.9274366E38)
            java.lang.String r4 = a.c.a.d.a.h(r4)
            java.lang.String r4 = r4.toUpperCase()
            r3.setSeccion(r4)
            r3 = 0
            a.c.d.h.a r3 = a.c.d.h.a.m(r3)
            r2.u(r3, r0)
            a.c.a.e.f r3 = a.c.a.e.f.c()
            java.lang.String r4 = "EMYSCALE_SELECCION"
            goto L_0x01d1
        L_0x011b:
            com.sozpic.miniland.TopMenu r3 = r2.f4475c
            r4 = 2131821380(0x7f110344, float:1.9275502E38)
            java.lang.String r4 = a.c.a.d.a.h(r4)
            java.lang.String r4 = r4.toUpperCase()
            r3.setSeccion(r4)
            a.c.d.h.a r3 = a.c.d.h.a.m(r0)
            r2.u(r3, r0)
            a.c.a.e.f r3 = a.c.a.e.f.c()
            java.lang.String r4 = "TERMOMETRO_SELECCION"
            goto L_0x01d1
        L_0x013a:
            com.sozpic.miniland.TopMenu r3 = r2.f4475c
            r4 = 2131820617(0x7f110049, float:1.9273954E38)
            java.lang.String r4 = a.c.a.d.a.h(r4)
            java.lang.String r4 = r4.toUpperCase()
            r3.setSeccion(r4)
            a.c.d.g.e r3 = new a.c.d.g.e
            r3.<init>()
            r2.u(r3, r0)
            a.c.a.e.f r3 = a.c.a.e.f.c()
            java.lang.String r4 = "BEMYBUDDY_MENU"
            goto L_0x01d1
        L_0x015a:
            r2.p(r4, r0)
            com.cuatroochenta.miniland.webservices.pregnancy.savedate.get.PregnancyDateGetRequest r3 = new com.cuatroochenta.miniland.webservices.pregnancy.savedate.get.PregnancyDateGetRequest
            r3.<init>()
            a.c.d.s.e.f.b.c r4 = new a.c.d.s.e.f.b.c
            r4.<init>()
            com.sozpic.miniland.MainActivity$b r0 = new com.sozpic.miniland.MainActivity$b
            r0.<init>()
            a.c.d.s.e.f.b.c$a r1 = new a.c.d.s.e.f.b.c$a
            r1.<init>(r3, r0)
            r1.start()
            goto L_0x01e1
        L_0x0175:
            a.h.a.c0 r3 = new a.h.a.c0
            r3.<init>()
            com.sozpic.miniland.TopMenu r4 = r2.f4475c
            r1 = 2131821106(0x7f110232, float:1.9274946E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            java.lang.String r1 = r1.toUpperCase()
            r4.setSeccion(r1)
            r2.u(r3, r0)
            a.c.a.e.f r3 = a.c.a.e.f.c()
            java.lang.String r4 = "VIGILABEBES_SELECCION_MODELO"
            goto L_0x01d1
        L_0x0194:
            a.h.a.a0 r3 = new a.h.a.a0
            r3.<init>()
            com.sozpic.miniland.TopMenu r4 = r2.f4475c
            r1 = 2131821107(0x7f110233, float:1.9274948E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            java.lang.String r1 = r1.toUpperCase()
            r4.setSeccion(r1)
            r2.u(r3, r0)
            a.c.a.e.f r3 = a.c.a.e.f.c()
            java.lang.String r4 = "LA_FAMILIA_SELECCION"
            goto L_0x01d1
        L_0x01b3:
            a.h.a.v r3 = new a.h.a.v
            r3.<init>()
            com.sozpic.miniland.TopMenu r4 = r2.f4475c
            r1 = 2131821120(0x7f110240, float:1.9274974E38)
            java.lang.String r1 = a.c.a.d.a.h(r1)
            java.lang.String r1 = r1.toUpperCase()
            r4.setSeccion(r1)
            r2.u(r3, r0)
            a.c.a.e.f r3 = a.c.a.e.f.c()
            java.lang.String r4 = "MIBEBE_SELECCION"
        L_0x01d1:
            r3.e(r4)
            goto L_0x01e1
        L_0x01d5:
            androidx.fragment.app.FragmentManager r3 = r2.getSupportFragmentManager()
            r3.popBackStack((java.lang.String) r4, (int) r0)
            com.sozpic.miniland.TopMenu r3 = r2.f4475c
            r3.a()
        L_0x01e1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sozpic.miniland.MainActivity.s(int, boolean):void");
    }

    public void t() {
        getSupportFragmentManager().popBackStack();
        u(new d(), true);
    }

    public void u(Fragment fragment, boolean z) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        this.f = fragment;
        beginTransaction.replace(R.id.fragment_container, fragment);
        if (z) {
            beginTransaction.addToBackStack((String) null);
        }
        beginTransaction.commit();
    }
}
