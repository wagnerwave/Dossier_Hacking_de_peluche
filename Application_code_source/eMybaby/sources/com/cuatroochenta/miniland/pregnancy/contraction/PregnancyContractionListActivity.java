package com.cuatroochenta.miniland.pregnancy.contraction;

import a.c.d.s.e.b.a.c;
import a.c.d.s.e.b.b.c;
import a.c.d.s.e.b.c.b;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.cuatroochenta.miniland.model.Contraction;
import com.cuatroochenta.miniland.webservices.pregnancy.contraction.add.PregnancyContractionAddRequest;
import com.cuatroochenta.miniland.webservices.pregnancy.contraction.delete.PregnancyContractionDeleteRequest;
import com.cuatroochenta.miniland.webservices.pregnancy.contraction.list.PregnancyContractionListRequest;
import com.sozpic.miniland.R;
import com.sozpic.miniland.TopMenuActivity;
import java.util.ArrayList;
import java.util.Iterator;

public class PregnancyContractionListActivity extends a.c.d.c implements a.c.d.s.e.b.c.a, a.c.d.s.e.b.b.a, a.c.d.s.e.b.a.a {

    /* renamed from: b  reason: collision with root package name */
    public ListView f3978b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f3979c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f3980d;

    /* renamed from: e  reason: collision with root package name */
    public Chronometer f3981e;
    public ImageView f;
    public boolean g = false;
    public int h = 0;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            PregnancyContractionListActivity.q(PregnancyContractionListActivity.this);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            PregnancyContractionListActivity.q(PregnancyContractionListActivity.this);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            a.c.d.m.g.d dVar = (a.c.d.m.g.d) PregnancyContractionListActivity.this.f3978b.getAdapter();
            if (dVar != null && dVar.f482d == 2) {
                Iterator<Contraction> it = dVar.f480b.iterator();
                while (it.hasNext()) {
                    Contraction next = it.next();
                    if (!dVar.f481c.contains(next.getId())) {
                        dVar.f481c.add(next.getId());
                    }
                }
                dVar.notifyDataSetChanged();
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            PregnancyContractionListActivity.this.onBackPressed();
        }
    }

    public class e implements View.OnClickListener {

        public class a implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a.c.d.m.g.d f3987a;

            public a(a.c.d.m.g.d dVar) {
                this.f3987a = dVar;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                PregnancyContractionListActivity.r(PregnancyContractionListActivity.this, this.f3987a.f481c);
            }
        }

        public e() {
        }

        public void onClick(View view) {
            a.c.d.m.g.d dVar = (a.c.d.m.g.d) PregnancyContractionListActivity.this.f3978b.getAdapter();
            if (dVar != null && dVar.f482d == 2) {
                ArrayList<String> arrayList = dVar.f481c;
                if (arrayList != null && !arrayList.isEmpty()) {
                    a.c.a.f.b.m0(view.getContext(), (String) null, a.c.a.d.a.h(R.string.TR_DELETE_CONTRACCION_CONFIRM), a.c.a.d.a.h(R.string.TR_ACEPTAR), a.c.a.d.a.h(R.string.TR_CANCEL), new a(dVar));
                }
            }
        }
    }

    public class f implements AdapterView.OnItemLongClickListener {
        public f() {
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            a.c.d.m.g.d dVar = (a.c.d.m.g.d) PregnancyContractionListActivity.this.f3978b.getAdapter();
            if (dVar == null || dVar.f482d == 2) {
                return false;
            }
            dVar.a();
            dVar.c(dVar.f480b.get(i));
            PregnancyContractionListActivity.this.f3979c.setVisibility(0);
            return true;
        }
    }

    public class g implements AdapterView.OnItemClickListener {
        public g() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            a.c.d.m.g.d dVar = (a.c.d.m.g.d) PregnancyContractionListActivity.this.f3978b.getAdapter();
            if (dVar != null && dVar.f482d == 2) {
                dVar.c(dVar.f480b.get(i));
            }
        }
    }

    public static void q(PregnancyContractionListActivity pregnancyContractionListActivity) {
        a.c.a.e.f fVar;
        String str;
        if (pregnancyContractionListActivity.g) {
            pregnancyContractionListActivity.f3981e.stop();
            int elapsedRealtime = (int) ((SystemClock.elapsedRealtime() - pregnancyContractionListActivity.f3981e.getBase()) / 1000);
            pregnancyContractionListActivity.p(a.c.a.d.a.h(R.string.TR_UPDATING), true);
            new c.a(new PregnancyContractionAddRequest(elapsedRealtime), pregnancyContractionListActivity).start();
            pregnancyContractionListActivity.g = false;
            pregnancyContractionListActivity.f3980d.setText(a.c.a.d.a.h(R.string.TR_INICIO_CONTRACCION).toUpperCase());
            pregnancyContractionListActivity.f3981e.stop();
            pregnancyContractionListActivity.f.setImageResource(R.drawable.ic_pregnancy_contraction_play);
            fVar = a.c.a.e.f.c();
            str = "CONTRAC_FIN";
        } else {
            pregnancyContractionListActivity.g = true;
            pregnancyContractionListActivity.f3981e.setBase(SystemClock.elapsedRealtime());
            pregnancyContractionListActivity.f3981e.start();
            pregnancyContractionListActivity.f3980d.setText(a.c.a.d.a.h(R.string.TR_FINAL_CONTRACCION).toUpperCase());
            pregnancyContractionListActivity.f.setImageResource(R.drawable.ic_pregnancy_contraction_pause);
            fVar = a.c.a.e.f.c();
            str = "CONTRAC_INICIO";
        }
        fVar.d("MI_EMBARAZO", str, "");
    }

    public static void r(PregnancyContractionListActivity pregnancyContractionListActivity, ArrayList arrayList) {
        if (pregnancyContractionListActivity != null) {
            pregnancyContractionListActivity.p(a.c.a.d.a.h(R.string.TR_UPDATING), false);
            a.c.d.s.e.b.b.c cVar = new a.c.d.s.e.b.b.c();
            pregnancyContractionListActivity.h = arrayList.size();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                new c.a(new PregnancyContractionDeleteRequest((String) it.next()), pregnancyContractionListActivity).start();
            }
            return;
        }
        throw null;
    }

    public void onBackPressed() {
        a.c.d.m.g.d dVar = (a.c.d.m.g.d) this.f3978b.getAdapter();
        if (dVar == null || dVar.f482d != 2) {
            super.onBackPressed();
            return;
        }
        dVar.a();
        this.f3979c.setVisibility(8);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_pregnancy_contraction);
        TopMenuActivity topMenuActivity = (TopMenuActivity) findViewById(R.id.pregnancy_contraction_common_header);
        topMenuActivity.setListener(this);
        topMenuActivity.setSeccion(a.c.a.d.a.h(R.string.TR_MENU_MI_EMBARAZO));
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.pregnancy_contraction_list_header);
        ((ImageView) viewGroup.findViewById(R.id.pregnancy_section_header_image)).setImageResource(R.drawable.ic_pregnancy_contraction);
        ((TextView) viewGroup.findViewById(R.id.pregnancy_section_header_title)).setText(a.c.a.d.a.h(R.string.TR_MENU_MI_EMBARAZO_CONTRACCIONES).toUpperCase());
        ((ViewGroup) findViewById(R.id.pregnancy_contraction_button_container)).setOnClickListener(new a());
        ImageView imageView = (ImageView) findViewById(R.id.pregnancy_contraction_play_pause);
        this.f = imageView;
        imageView.setOnClickListener(new b());
        TextView textView = (TextView) findViewById(R.id.pregnancy_contraction_start_text);
        this.f3980d = textView;
        textView.setText(a.c.a.d.a.h(R.string.TR_INICIO_CONTRACCION).toUpperCase());
        Chronometer chronometer = (Chronometer) findViewById(R.id.pregnancy_contraction_chrono);
        this.f3981e = chronometer;
        chronometer.setVisibility(8);
        ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.pregnancy_contraction_list_bottom_container);
        this.f3979c = viewGroup2;
        viewGroup2.setVisibility(8);
        TextView textView2 = (TextView) findViewById(R.id.bottom_bar_multiple_selector_select_all);
        textView2.setText(a.c.a.d.a.h(R.string.TR_SELECCIONAR_TODO).toUpperCase());
        textView2.setOnClickListener(new c());
        TextView textView3 = (TextView) findViewById(R.id.bottom_bar_multiple_selector_cancel);
        textView3.setText(a.c.a.d.a.h(R.string.TR_CANCEL).toUpperCase());
        textView3.setOnClickListener(new d());
        findViewById(R.id.bottom_bar_multiple_selector_delete).setOnClickListener(new e());
        ListView listView = (ListView) findViewById(R.id.pregnancy_contraction_list_listview);
        this.f3978b = listView;
        listView.setOnItemLongClickListener(new f());
        this.f3978b.setOnItemClickListener(new g());
        t();
        a.c.a.e.f.c().e("MI_EMBARAZO_CONTRACCIONES");
    }

    public final void t() {
        p(a.c.a.d.a.h(R.string.TR_UPDATING), false);
        new b.a(new PregnancyContractionListRequest(), this).start();
    }
}
