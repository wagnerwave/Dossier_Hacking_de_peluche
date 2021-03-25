package com.cuatroochenta.miniland.pregnancy.sounds;

import a.c.a.e.f;
import a.c.d.s.e.g.a.c;
import a.c.d.s.e.g.b.b;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.cuatroochenta.miniland.model.HeartBeatSound;
import com.cuatroochenta.miniland.pregnancy.escuchalatidos.PregnancyEscuchaLatidosActivity;
import com.cuatroochenta.miniland.webservices.pregnancy.sonidos.delete.PregnancySoundDeleteRequest;
import com.cuatroochenta.miniland.webservices.pregnancy.sonidos.list.PregnancySoundListRequest;
import com.sozpic.miniland.R;
import com.sozpic.miniland.TopMenuActivity;
import java.util.ArrayList;
import java.util.Iterator;

public class PregnancySoundsListActivity extends a.c.d.c implements a.c.d.s.e.g.b.a, a.c.d.s.e.g.a.a {

    /* renamed from: b  reason: collision with root package name */
    public ListView f4074b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f4075c;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            a.c.d.m.l.c cVar = (a.c.d.m.l.c) PregnancySoundsListActivity.this.f4074b.getAdapter();
            if (cVar != null && cVar.f722d == 2) {
                Iterator<HeartBeatSound> it = cVar.f720b.iterator();
                while (it.hasNext()) {
                    HeartBeatSound next = it.next();
                    if (!cVar.f721c.contains(next.getId())) {
                        cVar.f721c.add(next.getId());
                    }
                }
                cVar.notifyDataSetChanged();
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            PregnancySoundsListActivity.this.onBackPressed();
        }
    }

    public class c implements View.OnClickListener {

        public class a implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a.c.d.m.l.c f4079a;

            public a(a.c.d.m.l.c cVar) {
                this.f4079a = cVar;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                PregnancySoundsListActivity.q(PregnancySoundsListActivity.this, this.f4079a.f721c);
            }
        }

        public c() {
        }

        public void onClick(View view) {
            a.c.d.m.l.c cVar = (a.c.d.m.l.c) PregnancySoundsListActivity.this.f4074b.getAdapter();
            if (cVar != null && cVar.f722d == 2) {
                ArrayList<String> arrayList = cVar.f721c;
                if (arrayList != null && !arrayList.isEmpty()) {
                    a.c.a.f.b.m0(view.getContext(), (String) null, a.c.a.d.a.h(R.string.TR_MESSAGE_DELETE_PREGNANCY_SOUND_LIST), a.c.a.d.a.h(R.string.TR_ACEPTAR), a.c.a.d.a.h(R.string.TR_CANCEL), new a(cVar));
                }
            }
        }
    }

    public class d implements AdapterView.OnItemLongClickListener {
        public d() {
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            a.c.d.m.l.c cVar = (a.c.d.m.l.c) PregnancySoundsListActivity.this.f4074b.getAdapter();
            if (cVar == null || cVar.f722d == 2) {
                return false;
            }
            cVar.a();
            cVar.b(cVar.f720b.get(i));
            PregnancySoundsListActivity.this.f4075c.setVisibility(0);
            return true;
        }
    }

    public class e implements AdapterView.OnItemClickListener {
        public e() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            a.c.d.m.l.c cVar = (a.c.d.m.l.c) PregnancySoundsListActivity.this.f4074b.getAdapter();
            if (cVar == null) {
                return;
            }
            if (cVar.f722d == 1) {
                PregnancySoundsListActivity pregnancySoundsListActivity = PregnancySoundsListActivity.this;
                HeartBeatSound heartBeatSound = cVar.f720b.get(i);
                if (heartBeatSound != null) {
                    Intent intent = new Intent(pregnancySoundsListActivity, PregnancyEscuchaLatidosActivity.class);
                    intent.putExtra("KEY_INTENT_HEART_BEAT_SOUND", heartBeatSound);
                    pregnancySoundsListActivity.startActivity(intent);
                    return;
                }
                return;
            }
            cVar.b(cVar.f720b.get(i));
        }
    }

    public static void q(PregnancySoundsListActivity pregnancySoundsListActivity, ArrayList arrayList) {
        if (pregnancySoundsListActivity != null) {
            pregnancySoundsListActivity.p(a.c.a.d.a.h(R.string.TR_UPDATING), false);
            new c.a(new PregnancySoundDeleteRequest(arrayList), pregnancySoundsListActivity).start();
            return;
        }
        throw null;
    }

    public void onBackPressed() {
        a.c.d.m.l.c cVar = (a.c.d.m.l.c) this.f4074b.getAdapter();
        if (cVar == null || cVar.f722d != 2) {
            super.onBackPressed();
            return;
        }
        cVar.a();
        this.f4075c.setVisibility(8);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_pregnancy_sound_list);
        TopMenuActivity topMenuActivity = (TopMenuActivity) findViewById(R.id.pregnancy_sound_list_common_header);
        topMenuActivity.setListener(this);
        topMenuActivity.setSeccion(a.c.a.d.a.h(R.string.TR_MENU_MI_EMBARAZO));
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.pregnancy_sound_list_header);
        ((ImageView) viewGroup.findViewById(R.id.pregnancy_section_header_image)).setImageResource(R.drawable.ic_pregnancy_my_sounds);
        ((TextView) viewGroup.findViewById(R.id.pregnancy_section_header_title)).setText(a.c.a.d.a.h(R.string.TR_MENU_MI_EMBARAZO_TUS_SONIDOS).toUpperCase());
        ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.pregnancy_sound_list_bottom_container);
        this.f4075c = viewGroup2;
        viewGroup2.setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.bottom_bar_multiple_selector_select_all);
        textView.setText(a.c.a.d.a.h(R.string.TR_SELECCIONAR_TODO).toUpperCase());
        textView.setOnClickListener(new a());
        TextView textView2 = (TextView) findViewById(R.id.bottom_bar_multiple_selector_cancel);
        textView2.setText(a.c.a.d.a.h(R.string.TR_CANCEL).toUpperCase());
        textView2.setOnClickListener(new b());
        findViewById(R.id.bottom_bar_multiple_selector_delete).setOnClickListener(new c());
        ListView listView = (ListView) findViewById(R.id.pregnancy_sound_list_listview);
        this.f4074b = listView;
        listView.setOnItemLongClickListener(new d());
        this.f4074b.setOnItemClickListener(new e());
        r();
        f.c().e("MI_EMBARAZO_TUS_SONIDOS");
    }

    public final void r() {
        p(a.c.a.d.a.h(R.string.TR_UPDATING), false);
        new b.a(new PregnancySoundListRequest(), this).start();
    }
}
