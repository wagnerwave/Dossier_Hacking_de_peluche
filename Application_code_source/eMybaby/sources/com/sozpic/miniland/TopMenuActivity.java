package com.sozpic.miniland;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TopMenuActivity extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f4570a;

    /* renamed from: b  reason: collision with root package name */
    public c f4571b = null;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f4572c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f4573d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4574e;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            TopMenuActivity.this.f4571b.b();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            TopMenuActivity.this.f4571b.a();
        }
    }

    public interface c {
        void a();

        void b();
    }

    public TopMenuActivity(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        addView(LayoutInflater.from(context).inflate(R.layout.top_menu_activity, (ViewGroup) null));
        this.f4574e = (TextView) findViewById(R.id.topmenu_section_title);
        this.f4572c = (ImageView) findViewById(R.id.menu);
        this.f4573d = (ImageView) findViewById(R.id.atras);
        this.f4570a = (ImageView) findViewById(R.id.menu_right_button);
        this.f4572c.setOnClickListener(new a());
        this.f4573d.setOnClickListener(new b());
    }

    public ImageView getRightButton() {
        return this.f4570a;
    }

    public void setListener(c cVar) {
        this.f4571b = cVar;
    }

    public void setSeccion(String str) {
        TextView textView;
        int i;
        if (str != null) {
            this.f4574e.setText(str.toUpperCase());
            textView = this.f4574e;
            i = 0;
        } else {
            textView = this.f4574e;
            i = 4;
        }
        textView.setVisibility(i);
    }
}
