package com.sozpic.miniland.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sozpic.miniland.R;

public class TopMenuActivityVideo extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public c f4791a = null;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f4792b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f4793c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f4794d;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            TopMenuActivityVideo.this.f4791a.b();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            TopMenuActivityVideo.this.f4791a.a();
        }
    }

    public interface c {
        void a();

        void b();
    }

    public TopMenuActivityVideo(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        addView(LayoutInflater.from(context).inflate(R.layout.top_menu_activity_video, (ViewGroup) null));
        this.f4794d = (TextView) findViewById(R.id.topmenu_section_title);
        this.f4792b = (ImageView) findViewById(R.id.menu);
        this.f4793c = (ImageView) findViewById(R.id.atras);
        this.f4792b.setOnClickListener(new a());
        this.f4793c.setOnClickListener(new b());
    }

    public void setListener(c cVar) {
        this.f4791a = cVar;
    }

    public void setSeccion(String str) {
        TextView textView;
        int i;
        if (str != null) {
            this.f4794d.setText(str.toUpperCase());
            textView = this.f4794d;
            i = 0;
        } else {
            textView = this.f4794d;
            i = 4;
        }
        textView.setVisibility(i);
    }

    public void setSeccion2(String str) {
        this.f4794d.setText(str);
        this.f4794d.setVisibility(0);
        this.f4792b.setVisibility(8);
    }
}
