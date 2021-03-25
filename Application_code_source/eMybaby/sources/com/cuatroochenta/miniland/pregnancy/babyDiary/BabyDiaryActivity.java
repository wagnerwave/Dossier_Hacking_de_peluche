package com.cuatroochenta.miniland.pregnancy.babyDiary;

import a.c.d.c;
import a.c.d.m.f.d;
import a.c.d.m.f.e;
import a.c.d.m.f.f;
import a.c.d.m.f.g;
import a.c.d.m.f.i;
import a.c.d.m.f.n;
import a.c.d.m.f.p;
import a.c.d.s.e.a.a.d.b;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.cuatroochenta.miniland.pregnancy.customs.CircleGreenWeeksLeft;
import com.cuatroochenta.miniland.webservices.pregnancy.baby.babyDiary.list.BabyDiaryEntryListRequest;
import com.sozpic.miniland.R;
import com.sozpic.miniland.TopMenuActivity;
import java.util.Calendar;
import java.util.Date;

public class BabyDiaryActivity extends c {

    /* renamed from: b  reason: collision with root package name */
    public TopMenuActivity f3967b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f3968c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f3969d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f3970e;
    public TextView f;
    public TextView g;
    public ViewPager h;
    public View i;
    public View j;
    public p k;
    public ImageView l;
    public ImageView m;
    public ImageView n;
    public ImageView o;
    public CircleGreenWeeksLeft p;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            BabyDiaryActivity.this.f3969d.requestLayout();
        }
    }

    public class b implements a.c.d.s.e.a.a.d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ProgressDialog f3972a;

        public b(ProgressDialog progressDialog) {
            this.f3972a = progressDialog;
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 42830) {
            q();
            if (i3 != -1) {
                return;
            }
        } else if (i2 == 44823) {
            q();
            if (i3 != -1) {
                return;
            }
        } else {
            return;
        }
        r();
    }

    public void onBackPressed() {
        if (this.f3969d.getVisibility() == 0) {
            p pVar = this.k;
            n a2 = pVar.a();
            a2.f455d = false;
            a2.g.q();
            pVar.a().notifyDataSetChanged();
            q();
            return;
        }
        super.onBackPressed();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_baby_diary);
        this.f3968c = (LinearLayout) findViewById(R.id.baby_diary_area_anadir_nueva_anotacion);
        this.g = (TextView) findViewById(R.id.baby_diary_text_faltan_27_semanas);
        this.f = (TextView) findViewById(R.id.baby_diary_text_anadir_nueva_anotacion);
        this.j = findViewById(R.id.baby_diary_progress_bar_background);
        this.n = (ImageView) findViewById(R.id.baby_diary_button_viewpager_right);
        this.i = findViewById(R.id.baby_diary_progress_bar_progress);
        this.o = (ImageView) findViewById(R.id.baby_diary_button_viewpager_left);
        this.f3969d = (LinearLayout) findViewById(R.id.baby_diary_area_edit_mode);
        this.l = (ImageView) findViewById(R.id.baby_diary_button_delete);
        this.p = (CircleGreenWeeksLeft) findViewById(R.id.baby_diary_circle_green_weeks);
        this.m = (ImageView) findViewById(R.id.baby_diary_button_edit);
        this.h = (ViewPager) findViewById(R.id.baby_diary_viewpager);
        this.f3967b = (TopMenuActivity) findViewById(R.id.baby_diary_toolbar);
        this.f3970e = (ViewGroup) findViewById(R.id.baby_diary_header);
        this.f3967b.setSeccion(a.c.a.d.a.h(R.string.TR_MENU_MI_EMBARAZO));
        this.f3967b.setListener(this);
        ((ImageView) this.f3970e.findViewById(R.id.pregnancy_section_header_image)).setImageResource(R.drawable.ic_baby_diary_transparent);
        ((TextView) this.f3970e.findViewById(R.id.pregnancy_section_header_title)).setText(a.c.a.d.a.h(R.string.TR_DIARIO_DEL_BEBE).toUpperCase());
        this.f.setText(a.c.a.d.a.h(R.string.TR_ANADIR_NUEVA_ANOTACION).toUpperCase());
        this.p.setSemanasHoyText(a.c.a.d.a.h(R.string.TR_SEMANAS_HOY).toUpperCase());
        this.f3968c.setOnClickListener(new f(this));
        this.m.setOnClickListener(new g(this));
        this.l.setOnClickListener(new i(this));
        this.k = new p();
        this.n.setOnClickListener(new a.c.d.m.f.c(this));
        this.o.setOnClickListener(new d(this));
        this.h.setAdapter(this.k);
        this.h.addOnPageChangeListener(new e(this));
        r();
        a.c.a.e.f.c().e("MI_EMBARAZO_DIARIO");
    }

    public void q() {
        this.f3969d.setVisibility(8);
        this.f3969d.post(new a());
    }

    public final void r() {
        Date time = Calendar.getInstance().getTime();
        int c2 = (int) a.c.d.r.i.c(time);
        int a2 = (int) a.c.d.r.i.a(time);
        this.p.setWeeks(c2);
        this.p.setDays(a2);
        this.j.post(new a.c.d.m.f.b(this, c2));
        TextView textView = this.g;
        String[] split = a.c.a.d.a.h(R.string.TR_FALTAN_SEMANAS_PLACEHOLDER).split("%s");
        String str = split[0];
        String str2 = split[1];
        String valueOf = String.valueOf(Math.max(40 - c2, 0));
        String l2 = a.a.a.a.a.l(str, valueOf, str2);
        SpannableString spannableString = new SpannableString(l2.toUpperCase());
        spannableString.setSpan(new RelativeSizeSpan(0.67f), 0, str.length(), 33);
        spannableString.setSpan(new StyleSpan(1), str.length(), valueOf.length() + str.length(), 33);
        spannableString.setSpan(new RelativeSizeSpan(0.67f), valueOf.length() + str.length(), l2.length(), 33);
        textView.setText(spannableString);
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.show();
        new b.a(new BabyDiaryEntryListRequest(), new b(progressDialog)).start();
    }
}
