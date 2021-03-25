package com.cuatroochenta.miniland.pregnancy.mama;

import a.c.a.e.f;
import a.c.d.c;
import a.c.d.d.d;
import a.c.d.m.i.g;
import a.c.d.m.i.i;
import a.c.d.m.i.j;
import a.c.d.r.h;
import a.c.d.s.e.d.d.a.b;
import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cuatroochenta.miniland.model.MyBellyData;
import com.sozpic.miniland.R;
import com.sozpic.miniland.TopMenuActivity;

public class MyBellyImageFormActivity extends c implements a.c.d.s.e.d.d.a.a, h.b {

    /* renamed from: b  reason: collision with root package name */
    public TopMenuActivity f4049b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f4050c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f4051d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4052e;
    public TextView f;
    public EditText g;
    public TextView h;
    public EditText i;
    public TextView j;
    public TextView k;
    public String l;
    public d m;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f4053a;

        public a(b bVar) {
            this.f4053a = bVar;
        }

        public void run() {
            MyBellyImageFormActivity.this.o();
            if (this.f4053a.f42a.booleanValue()) {
                if (!MyBellyImageFormActivity.this.isFinishing()) {
                    try {
                        a.c.a.f.b.l0(MyBellyImageFormActivity.this, a.c.a.d.a.h(R.string.TR_NUEVA_IMAGEN_ANADIDA), a.c.a.d.a.h(R.string.TR_ACEPTAR));
                    } catch (WindowManager.BadTokenException unused) {
                    }
                }
                f.c().d("MI_EMBARAZO", "MAMA_NUEVA_TRIPITA", "");
                MyBellyImageFormActivity.this.setResult(-1);
                MyBellyImageFormActivity.this.finish();
                return;
            }
            a.c.a.f.b.h0(MyBellyImageFormActivity.this, a.c.a.d.a.h(R.string.TR_ERROR_GUARDAR_MI_TRIPITA), a.c.a.d.a.h(R.string.TR_ACEPTAR));
        }
    }

    public static void q(MyBellyImageFormActivity myBellyImageFormActivity, MyBellyData myBellyData) {
        if (myBellyImageFormActivity != null) {
            myBellyImageFormActivity.setResult(-1, new Intent().putExtra("ARGS_MY_BELLY_IMAGE", myBellyData));
            myBellyImageFormActivity.finish();
            return;
        }
        throw null;
    }

    public void c(String str) {
        this.l = str;
        this.f4051d.setVisibility(0);
        this.f4051d.setImageBitmap(BitmapFactory.decodeFile(str));
    }

    public void i() {
    }

    public void l(b bVar) {
        runOnUiThread(new a(bVar));
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (!this.m.n(i2, i3, intent)) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_add_my_belly_photo);
        this.m = new d((Activity) this, (h.b) this, bundle);
        TopMenuActivity topMenuActivity = (TopMenuActivity) findViewById(R.id.mama_common_toolbar_header);
        this.f4049b = topMenuActivity;
        topMenuActivity.setSeccion(a.c.a.d.a.h(R.string.TR_MENU_MI_EMBARAZO).toUpperCase());
        this.f4049b.setListener(this);
        ((TextView) findViewById(R.id.tv_mama_my_belly_title)).setText(a.c.a.d.a.h(R.string.TR_MENU_MI_EMBARAZO_MAMA).toUpperCase());
        ((TextView) findViewById(R.id.tv_mama_my_belly_subtitle)).setText(a.c.a.d.a.h(R.string.TR_MI_TRIPITA).toUpperCase());
        this.f4050c = (RelativeLayout) findViewById(R.id.rl_add_my_belly_photo);
        this.f4051d = (ImageView) findViewById(R.id.img_add_my_belly_result_photo);
        this.f = (TextView) findViewById(R.id.tv_add_my_belly_title);
        this.h = (TextView) findViewById(R.id.tv_add_my_belly_description);
        this.j = (TextView) findViewById(R.id.tv_add_my_belly_photo_ok);
        this.k = (TextView) findViewById(R.id.tv_add_my_belly_photo_cancel);
        this.g = (EditText) findViewById(R.id.et_add_my_belly_title);
        this.i = (EditText) findViewById(R.id.et_add_my_belly_description);
        this.f4052e = (TextView) findViewById(R.id.tv_add_my_belly_icon_add_photo);
        this.f.setText(a.c.a.d.a.h(R.string.TR_ANADIR_TITULO));
        this.h.setText(a.c.a.d.a.h(R.string.TR_ANADIR_COMENTARIO));
        this.f4052e.setText(a.c.a.d.a.h(R.string.TR_ANADIR_FOTO));
        this.f4050c.setOnClickListener(new g(this));
        this.j.setText(a.c.a.d.a.h(R.string.TR_OK).toUpperCase());
        this.j.setOnClickListener(new i(this));
        this.k.setText(a.c.a.d.a.h(R.string.TR_CANCEL).toUpperCase());
        this.k.setOnClickListener(new j(this));
        Intent intent = getIntent();
        if (intent.hasExtra("key_image_url")) {
            String stringExtra = intent.getStringExtra("key_image_url");
            if (stringExtra.startsWith("http")) {
                a.g.a.b.d.e().h(stringExtra, new a.c.d.m.i.f(this));
            } else {
                this.f4051d.setImageBitmap(BitmapFactory.decodeFile(stringExtra));
                this.f4051d.setVisibility(0);
            }
            this.g.setText(intent.getStringExtra("key_image_title"));
            this.i.setText(intent.getStringExtra("key_image_description"));
            this.l = stringExtra;
        }
        f.c().e("MI_EMBARAZO_MAMA_TRIPITA_ANYADIR");
    }

    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        d dVar = this.m;
        if (dVar == null || !dVar.o(i2, iArr)) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }
}
