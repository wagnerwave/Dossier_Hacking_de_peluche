package com.sozpic.miniland;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TopMenu extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f4564a;

    /* renamed from: b  reason: collision with root package name */
    public b f4565b = null;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f4566c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f4567d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f4568e;
    public ImageView f;
    public ImageView g;
    public int h = -1;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            ((MainActivity) TopMenu.this.f4565b).b();
        }
    }

    public interface b {
    }

    public TopMenu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        addView(LayoutInflater.from(context).inflate(R.layout.top_menu, (ViewGroup) null));
        this.f4567d = (TextView) findViewById(R.id.topmenu_section_title);
        this.f4566c = (ImageView) findViewById(R.id.menu);
        this.f4568e = (ImageView) findViewById(R.id.topmenu_section_logo);
        this.f = (ImageView) findViewById(R.id.iv_emybaby_menu);
        this.g = (ImageView) findViewById(R.id.iv_miniland_menu);
        this.f4566c.setOnClickListener(new a());
        this.f4564a = (ImageView) findViewById(R.id.topmenu_right_button);
    }

    public void a() {
        this.f4567d.setText("");
        this.f4567d.setVisibility(8);
        this.f.setVisibility(0);
        this.g.setVisibility(0);
        this.f4568e.setVisibility(8);
        int i = this.h;
        if (i != -1) {
            this.f4564a.setVisibility(i);
        }
    }

    public ImageView getRightButton() {
        return this.f4564a;
    }

    public void setListener(b bVar) {
        this.f4565b = bVar;
    }

    public void setSeccion(String str) {
        this.f4567d.setText(str);
        this.f4567d.setVisibility(0);
        this.f.setVisibility(8);
        this.g.setVisibility(8);
        this.f4568e.setVisibility(0);
        this.h = this.f4564a.getVisibility();
        this.f4564a.setVisibility(8);
    }
}
