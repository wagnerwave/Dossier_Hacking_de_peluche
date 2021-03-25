package com.cuatroochenta.miniland.emyscale;

import a.c.a.e.f;
import a.c.d.c;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.sozpic.miniland.R;
import com.sozpic.miniland.TopMenuActivity;
import com.sozpic.miniland.modelos.Bebe;

public class MyScaleSelectOptionActivity extends c {

    /* renamed from: b  reason: collision with root package name */
    public Bebe f3875b = null;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            MyScaleSelectOptionActivity myScaleSelectOptionActivity = MyScaleSelectOptionActivity.this;
            if (myScaleSelectOptionActivity.f3875b == null) {
                myScaleSelectOptionActivity.finish();
            }
            MyScaleSelectOptionActivity myScaleSelectOptionActivity2 = MyScaleSelectOptionActivity.this;
            Bebe bebe = myScaleSelectOptionActivity2.f3875b;
            if (bebe != null) {
                Intent intent = new Intent(myScaleSelectOptionActivity2, MyScaleBabyActivity.class);
                intent.putExtra("KEY_INTENT_BABY", bebe);
                myScaleSelectOptionActivity2.startActivity(intent);
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            MyScaleSelectOptionActivity myScaleSelectOptionActivity = MyScaleSelectOptionActivity.this;
            if (myScaleSelectOptionActivity.f3875b == null) {
                myScaleSelectOptionActivity.finish();
            }
            MyScaleSelectOptionActivity myScaleSelectOptionActivity2 = MyScaleSelectOptionActivity.this;
            a.c.a.d.a.m(myScaleSelectOptionActivity2, myScaleSelectOptionActivity2.f3875b);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_myscale_select_option);
        TopMenuActivity topMenuActivity = (TopMenuActivity) findViewById(R.id.select_option_common_header);
        topMenuActivity.setListener(this);
        topMenuActivity.setSeccion(a.c.a.d.a.h(R.string.TR_WEIGHT));
        if (bundle != null || ((bundle = getIntent().getExtras()) != null && bundle.containsKey("KEY_INTENT_BABY"))) {
            this.f3875b = (Bebe) bundle.getParcelable("KEY_INTENT_BABY");
        }
        if (this.f3875b == null) {
            finish();
            return;
        }
        View findViewById = findViewById(R.id.baby_list_header);
        findViewById.setBackgroundColor(getResources().getColor(R.color.list_selector_header));
        ((TextView) findViewById.findViewById(R.id.list_header)).setText(a.c.a.d.a.h(R.string.TR_SELECT_OPTION_WANT_TO_CHECK));
        TextView textView = (TextView) findViewById(R.id.select_option_new_reading_option);
        textView.setText(a.c.a.d.a.h(R.string.TR_NEW_READING));
        textView.setOnClickListener(new a());
        TextView textView2 = (TextView) findViewById(R.id.select_option_historical_option);
        textView2.setText(a.c.a.d.a.i(R.string.TR_WEIGHT_HISTORICAL));
        textView2.setOnClickListener(new b());
    }

    public void onResume() {
        super.onResume();
        f.c().e("EMYSCALE_OPCIONES");
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable("KEY_INTENT_BABY", this.f3875b);
        super.onSaveInstanceState(bundle);
    }
}
