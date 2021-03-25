package com.cuatroochenta.miniland.emybuddy;

import a.c.a.e.f;
import a.c.d.c;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sozpic.miniland.R;
import com.sozpic.miniland.TopMenuActivity;
import java.util.ArrayList;
import java.util.Iterator;

public class BuddySettingsActivity extends c {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f3845b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f3846c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f3847d;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            a.c.a.d.a.l(BuddySettingsActivity.this, "HELP_BUDDY");
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            Boolean bool;
            ImageView imageView = (ImageView) view.findViewById(R.id.settings_item_disclosure);
            if (Boolean.TRUE.equals(view.getTag())) {
                BuddySettingsActivity.this.f3845b.setVisibility(4);
                view.setBackgroundColor(BuddySettingsActivity.this.getResources().getColor(R.color.bg_buddy_settings_section_opened));
                BuddySettingsActivity buddySettingsActivity = BuddySettingsActivity.this;
                buddySettingsActivity.f3846c.setBackgroundColor(buddySettingsActivity.getResources().getColor(R.color.bg_buddy_settings_section_opened));
                imageView.setImageResource(R.drawable.ic_disclosure_right);
                bool = Boolean.FALSE;
            } else {
                BuddySettingsActivity.this.f3845b.setVisibility(0);
                view.setBackgroundColor(BuddySettingsActivity.this.getResources().getColor(R.color.bg_buddy_settings_section_opened));
                BuddySettingsActivity buddySettingsActivity2 = BuddySettingsActivity.this;
                buddySettingsActivity2.f3846c.setBackgroundColor(buddySettingsActivity2.getResources().getColor(R.color.bg_buddy_settings_section));
                imageView.setImageResource(R.drawable.ic_disclosure_bottom);
                bool = Boolean.TRUE;
            }
            view.setTag(bool);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_mybuddy_settings);
        TopMenuActivity topMenuActivity = (TopMenuActivity) findViewById(R.id.buddy_settings_common_header);
        topMenuActivity.setListener(this);
        topMenuActivity.setSeccion(a.c.a.d.a.h(R.string.TR_BEMYBUDDY_TITLE_IOS).toUpperCase());
        ((TextView) findViewById(R.id.buddy_settings_title)).setText(a.c.a.d.a.h(R.string.TR_SETTINGS).toUpperCase());
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.buddy_settings_bluetooth);
        this.f3846c = viewGroup;
        viewGroup.setBackgroundColor(getResources().getColor(R.color.bg_buddy_settings_section_opened));
        ((TextView) this.f3846c.findViewById(R.id.settings_item_name)).setText(a.c.a.d.a.h(R.string.TR_BLUETOOTH));
        this.f3846c.setOnClickListener(new a());
        ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.buddy_settings_technical_specifications);
        this.f3847d = viewGroup2;
        viewGroup2.setBackgroundColor(getResources().getColor(R.color.bg_buddy_settings_section_opened));
        ((TextView) this.f3847d.findViewById(R.id.settings_item_name)).setText(a.c.a.d.a.h(R.string.TR_TECHNICAL_SPECIFICATIONS));
        this.f3847d.setOnClickListener(new b());
        ViewGroup viewGroup3 = (ViewGroup) findViewById(R.id.buddy_settings_technical_specifications_detail_container);
        this.f3845b = viewGroup3;
        viewGroup3.setVisibility(4);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a.c.a.d.a.h(R.string.TR_STANDARD_BLUETOOTH));
        arrayList.add(a.c.a.d.a.h(R.string.TR_COMPATIBILITY_BLUETOOTH));
        arrayList.add(a.c.a.d.a.h(R.string.TR_COBERTURE_BLUETOOTH));
        arrayList.add(String.format(a.c.a.d.a.h(R.string.TR_APP_VERSION_PLACEHOLDER), new Object[]{a.c.a.a.f.a()}));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, (float) 1, getResources().getDisplayMetrics()));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            RelativeLayout relativeLayout = (RelativeLayout) getWindow().getLayoutInflater().inflate(R.layout.item_settings, (ViewGroup) null);
            ((ImageView) relativeLayout.findViewById(R.id.settings_item_disclosure)).setVisibility(8);
            ((TextView) relativeLayout.findViewById(R.id.settings_item_name)).setText((String) it.next());
            relativeLayout.setBackgroundColor(getResources().getColor(R.color.bg_buddy_settings_detail));
            this.f3845b.addView(relativeLayout);
            View view = new View(this);
            view.setBackgroundColor(getResources().getColor(R.color.list_divider));
            view.setLayoutParams(layoutParams);
            this.f3845b.addView(view);
        }
    }

    public void onResume() {
        super.onResume();
        f.c().e("BEMYBUDDY_SETTINGS");
    }
}
