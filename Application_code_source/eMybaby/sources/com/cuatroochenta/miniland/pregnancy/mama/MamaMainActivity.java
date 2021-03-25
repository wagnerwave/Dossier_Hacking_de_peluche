package com.cuatroochenta.miniland.pregnancy.mama;

import a.c.d.c;
import a.c.d.m.i.d;
import a.c.d.m.i.k.a0;
import a.c.d.m.i.k.e;
import a.c.d.m.i.k.h0;
import a.c.d.m.i.k.k;
import a.c.d.m.i.k.k0;
import a.c.d.m.i.k.l0;
import a.c.d.m.i.k.m0;
import a.c.d.m.i.k.s;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.cuatroochenta.miniland.utils.CustomViewPager;
import com.sozpic.miniland.R;
import com.sozpic.miniland.TopMenuActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MamaMainActivity extends c implements TopMenuActivity.c, k0 {

    /* renamed from: b  reason: collision with root package name */
    public a0 f4039b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<WeakReference<l0>> f4040c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public TopMenuActivity f4041d;

    /* renamed from: e  reason: collision with root package name */
    public List<ImageView> f4042e;
    public LinearLayout f;
    public int g;
    public int h;
    public CustomViewPager i;
    public a j;

    public class a extends FragmentStatePagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public List<m0> f4043a = new ArrayList();

        public a(MamaMainActivity mamaMainActivity, FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public int getCount() {
            return this.f4043a.size();
        }

        public Fragment getItem(int i) {
            return this.f4043a.get(i);
        }
    }

    public enum b {
        MAMA_OPTION_WEIGHT_EVOLUTION(0, R.string.TR_EVOLUCION_PESO),
        MAMA_OPTION_BLOOD_PRESSURE(1, R.string.TR_TENSION_ARTERIAL),
        MAMA_OPTION_BABY_MOVEMENTS(2, R.string.TR_MOVIMIENTOS_FETALES),
        MAMA_OPTION_UTERUS_HEIGHT(3, R.string.TR_ALTURA_UTERO),
        MAMA_OPTION_MY_BELLY(4, R.string.TR_MI_TRIPITA);
        

        /* renamed from: a  reason: collision with root package name */
        public final int f4047a;

        /* renamed from: b  reason: collision with root package name */
        public final String f4048b;

        /* access modifiers changed from: public */
        b(int i, int i2) {
            this.f4047a = i;
            this.f4048b = a.c.a.d.a.h(i2);
        }
    }

    public void j(l0 l0Var) {
        Iterator<WeakReference<l0>> it = this.f4040c.iterator();
        while (it.hasNext()) {
            if (it.next().get() == l0Var) {
                it.remove();
            }
        }
    }

    public void n(l0 l0Var) {
        this.f4040c.add(new WeakReference(l0Var));
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 1043 && i3 == -1) {
            q(b.MAMA_OPTION_MY_BELLY);
            this.f4039b.D();
            return;
        }
        super.onActivityResult(i2, i3, intent);
    }

    public void onBackPressed() {
        Iterator<WeakReference<l0>> it = this.f4040c.iterator();
        boolean z = false;
        while (it.hasNext()) {
            l0 l0Var = (l0) it.next().get();
            if (l0Var != null) {
                boolean h2 = l0Var.h();
                if (!z) {
                    z = h2;
                }
            }
        }
        if (!z) {
            super.onBackPressed();
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_mama_main_base);
        this.f4042e = new ArrayList(b.values().length);
        this.h = 0;
        TopMenuActivity topMenuActivity = (TopMenuActivity) findViewById(R.id.mama_common_toolbar_header);
        this.f4041d = topMenuActivity;
        topMenuActivity.setSeccion(a.c.a.d.a.h(R.string.TR_MENU_MI_EMBARAZO).toUpperCase());
        this.f4041d.setListener(this);
        this.i = (CustomViewPager) findViewById(R.id.mama_main_view_pager);
        this.f = (LinearLayout) findViewById(R.id.ll_bottom_item_options);
        this.f4042e.add(b.MAMA_OPTION_WEIGHT_EVOLUTION.f4047a, (ImageView) findViewById(R.id.mama_img_weight_evolution));
        this.f4042e.add(b.MAMA_OPTION_BLOOD_PRESSURE.f4047a, (ImageView) findViewById(R.id.mama_img_blood_pressure));
        this.f4042e.add(b.MAMA_OPTION_BABY_MOVEMENTS.f4047a, (ImageView) findViewById(R.id.mama_img_baby_movements));
        this.f4042e.add(b.MAMA_OPTION_UTERUS_HEIGHT.f4047a, (ImageView) findViewById(R.id.mama_img_uterus_height));
        this.f4042e.add(b.MAMA_OPTION_MY_BELLY.f4047a, (ImageView) findViewById(R.id.mama_img_my_belly));
        a aVar = new a(this, getSupportFragmentManager());
        this.j = aVar;
        aVar.f4043a.add(b.MAMA_OPTION_WEIGHT_EVOLUTION.f4047a, new h0());
        a aVar2 = this.j;
        aVar2.f4043a.add(b.MAMA_OPTION_BLOOD_PRESSURE.f4047a, new k());
        a aVar3 = this.j;
        aVar3.f4043a.add(b.MAMA_OPTION_BABY_MOVEMENTS.f4047a, new e());
        a aVar4 = this.j;
        aVar4.f4043a.add(b.MAMA_OPTION_UTERUS_HEIGHT.f4047a, new s());
        a aVar5 = this.j;
        a0 a0Var = new a0();
        this.f4039b = a0Var;
        aVar5.f4043a.add(b.MAMA_OPTION_MY_BELLY.f4047a, a0Var);
        a aVar6 = this.j;
        LinearLayout linearLayout = this.f;
        for (m0 next : aVar6.f4043a) {
            next.j = linearLayout;
            next.h = (FrameLayout) linearLayout.findViewById(R.id.fl_mama_main_edit);
            next.i = (FrameLayout) linearLayout.findViewById(R.id.fl_mama_main_delete);
        }
        this.i.setPagingEnabled(false);
        this.i.setOffscreenPageLimit(this.j.getCount());
        this.i.setAdapter(this.j);
        this.f4042e.get(b.MAMA_OPTION_WEIGHT_EVOLUTION.f4047a).setOnClickListener(new a.c.d.m.i.a(this));
        this.f4042e.get(b.MAMA_OPTION_BLOOD_PRESSURE.f4047a).setOnClickListener(new a.c.d.m.i.b(this));
        this.f4042e.get(b.MAMA_OPTION_BABY_MOVEMENTS.f4047a).setOnClickListener(new a.c.d.m.i.c(this));
        this.f4042e.get(b.MAMA_OPTION_UTERUS_HEIGHT.f4047a).setOnClickListener(new d(this));
        this.f4042e.get(b.MAMA_OPTION_MY_BELLY.f4047a).setOnClickListener(new a.c.d.m.i.e(this));
        b bVar = (b) getIntent().getSerializableExtra("EXTRA_KEY_TAB_OPTION");
        if (bVar == null) {
            bVar = b.MAMA_OPTION_WEIGHT_EVOLUTION;
        }
        q(bVar);
    }

    public void q(b bVar) {
        int i2 = bVar.f4047a;
        int i3 = this.h;
        this.g = i3;
        this.h = i2;
        this.f4042e.get(i3).setColorFilter(getResources().getColor(R.color.mama_menu_options_start_color));
        this.f4042e.get(this.h).setColorFilter(getResources().getColor(R.color.mama_menu_options_color));
        this.i.setCurrentItem(i2);
    }
}
