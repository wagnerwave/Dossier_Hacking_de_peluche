package com.cuatroochenta.miniland.help;

import a.c.a.b;
import a.c.d.c;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import com.cuatroochenta.genericviewflow.CircleFlowIndicator;
import com.cuatroochenta.genericviewflow.ViewFlow;
import com.sozpic.miniland.R;
import com.sozpic.miniland.TopMenuActivity;
import java.util.ArrayList;

public class HelpActivity extends c {

    /* renamed from: b  reason: collision with root package name */
    public ViewFlow f3886b;

    /* renamed from: c  reason: collision with root package name */
    public CircleFlowIndicator f3887c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f3888d;

    /* renamed from: e  reason: collision with root package name */
    public String f3889e;

    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if ("HELP_BUDDY".equals(HelpActivity.this.f3889e)) {
                HelpActivity.this.startActivity(new Intent("android.settings.BLUETOOTH_SETTINGS"));
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_help);
        String stringExtra = getIntent().getStringExtra("KEY_INTENT_HELP_SECTION_CODE");
        this.f3889e = stringExtra;
        if (a.c.a.d.a.j(stringExtra)) {
            finish();
            return;
        }
        if (!a.c.d.r.a.f781d.f784c.containsKey(this.f3889e)) {
            finish();
            return;
        }
        TopMenuActivity topMenuActivity = (TopMenuActivity) findViewById(R.id.help_viewflow_common_header);
        topMenuActivity.setListener(this);
        topMenuActivity.setSeccion("HELP_BUDDY".equals(this.f3889e) ? a.c.a.d.a.h(R.string.TR_BEMYBUDDY_TITLE_IOS).toUpperCase() : "");
        a.c.d.a l = a.c.d.a.l();
        String str = this.f3889e;
        ArrayList<String> p = l.p();
        if (p == null) {
            p = new ArrayList<>();
        }
        if (!p.contains(str)) {
            p.add(str);
        }
        SharedPreferences.Editor edit = l.f6a.edit();
        edit.putString("KEY_TUTORIALES_REPRODUCIDOS", b.f(p));
        edit.commit();
        ViewFlow viewFlow = (ViewFlow) findViewById(R.id.help_viewflow);
        this.f3886b = viewFlow;
        viewFlow.setOnItemClickListener(new a());
        this.f3886b.setAdapter(new a.c.d.i.a.a(this));
        CircleFlowIndicator circleFlowIndicator = (CircleFlowIndicator) findViewById(R.id.help_viewflow_indicator);
        this.f3887c = circleFlowIndicator;
        this.f3886b.setFlowIndicator(circleFlowIndicator);
        this.f3888d = (ImageView) findViewById(R.id.help_viewflow_default_image);
    }

    public void onResume() {
        super.onResume();
        a.c.d.i.a.a aVar = (a.c.d.i.a.a) this.f3886b.getAdapter();
        if (aVar == null) {
            aVar = new a.c.d.i.a.a(this);
            this.f3886b.setAdapter(aVar);
        }
        String str = this.f3889e;
        aVar.f160b.clear();
        aVar.f161c = str;
        ArrayList arrayList = a.c.d.r.a.f781d.f784c.get(str);
        if (arrayList != null) {
            aVar.f160b.addAll(arrayList);
        }
        aVar.notifyDataSetChanged();
        if (aVar.getCount() == 0) {
            this.f3888d.setVisibility(0);
        } else {
            this.f3888d.setVisibility(8);
            if (aVar.getCount() > 1) {
                this.f3887c.setVisibility(0);
                return;
            }
        }
        this.f3887c.setVisibility(4);
    }
}
