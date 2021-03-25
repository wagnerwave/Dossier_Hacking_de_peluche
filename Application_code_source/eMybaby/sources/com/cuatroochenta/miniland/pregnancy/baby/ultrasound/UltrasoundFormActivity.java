package com.cuatroochenta.miniland.pregnancy.baby.ultrasound;

import a.c.a.d.a;
import a.c.a.e.f;
import a.c.d.c;
import a.c.d.d.d;
import a.c.d.m.e.l.b;
import a.c.d.m.e.l.e;
import a.c.d.r.h;
import a.i.a.t;
import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cuatroochenta.miniland.model.UltrasoundPhoto;
import com.sozpic.miniland.R;
import com.sozpic.miniland.TopMenuActivity;

public class UltrasoundFormActivity extends c implements h.b {

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f3963b;

    /* renamed from: c  reason: collision with root package name */
    public TopMenuActivity f3964c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f3965d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f3966e;
    public TextView f;
    public EditText g;
    public EditText h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public String m;
    public long n;
    public d o;

    public static void q(UltrasoundFormActivity ultrasoundFormActivity, long j2) {
        UltrasoundPhoto r = ultrasoundFormActivity.r();
        r.setId(j2);
        Intent intent = new Intent();
        intent.putExtra("ARGS_ECOGRAPHY_PHOTO", r);
        ultrasoundFormActivity.setResult(-1, intent);
        f.c().d("MI_EMBARAZO", "BEBE_NUEVA_ECO", "");
        ultrasoundFormActivity.finish();
    }

    public void c(String str) {
        this.f3965d.setVisibility(0);
        this.m = str;
        this.f3965d.setImageBitmap(BitmapFactory.decodeFile(str));
    }

    public void i() {
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (!this.o.n(i2, i3, intent)) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_add_ecography);
        this.o = new d((Activity) this, (h.b) this, bundle);
        this.f = (TextView) findViewById(R.id.add_ecography_label_anadir_comentario);
        this.g = (EditText) findViewById(R.id.add_ecography_input_anadir_comentario);
        this.h = (EditText) findViewById(R.id.add_ecography_input_anadir_titulo);
        this.i = (TextView) findViewById(R.id.add_ecography_label_anadir_titulo);
        this.k = (TextView) findViewById(R.id.add_ecography_text_anadir_foto);
        this.l = (TextView) findViewById(R.id.add_ecography_button_cancel);
        this.f3963b = (RelativeLayout) findViewById(R.id.add_ecography_button_photo);
        this.j = (TextView) findViewById(R.id.add_ecography_button_ok);
        this.f3964c = (TopMenuActivity) findViewById(R.id.add_ecography_toolbar);
        this.f3966e = (ViewGroup) findViewById(R.id.add_ecography_header);
        this.f3965d = (ImageView) findViewById(R.id.add_ecography_image_photo);
        this.f3964c.setListener(this);
        this.f3964c.setSeccion(a.h(R.string.TR_MENU_MI_EMBARAZO));
        ((ImageView) this.f3966e.findViewById(R.id.pregnancy_section_header_image)).setImageResource(R.drawable.ic_ecography_baby);
        ((TextView) this.f3966e.findViewById(R.id.pregnancy_section_header_title)).setText(a.h(R.string.TR_BEBE).toUpperCase());
        ((TextView) this.f3966e.findViewById(R.id.pregnancy_section_header_subtitle)).setText(a.h(R.string.TR_ECOGRAFIA).toUpperCase());
        this.f.setText(a.h(R.string.TR_ANADIR_COMENTARIO).toUpperCase());
        this.i.setText(a.h(R.string.TR_ANADIR_TITULO).toUpperCase());
        this.k.setText(a.h(R.string.TR_ANADIR_FOTO));
        this.j.setText(a.h(R.string.TR_OK).toUpperCase());
        this.f3963b.setOnClickListener(new b(this));
        this.j.setOnClickListener(new a.c.d.m.e.l.c(this));
        this.l.setOnClickListener(new e(this));
        String action = getIntent().getAction();
        if (action == null) {
            action = "ACTION_CREATE";
        }
        char c2 = 65535;
        if (action.hashCode() == -529162637 && action.equals("ACTION_EDIT")) {
            c2 = 0;
        }
        if (c2 == 0) {
            UltrasoundPhoto ultrasoundPhoto = (UltrasoundPhoto) getIntent().getParcelableExtra("ARGS_ECOGRAPHY_PHOTO");
            String photoPath = ultrasoundPhoto.getPhotoPath();
            this.m = photoPath;
            if (photoPath.startsWith("http")) {
                t.f(this).d(ultrasoundPhoto.getPhotoPath()).c(new a.c.d.m.e.l.a(this));
            } else {
                this.f3965d.setImageBitmap(BitmapFactory.decodeFile(ultrasoundPhoto.getPhotoPath()));
            }
            this.f3965d.setVisibility(0);
            this.g.setText(ultrasoundPhoto.getDescription());
            this.h.setText(ultrasoundPhoto.getTitle());
            this.n = ultrasoundPhoto.getId();
        }
        f.c().e("MI_EMBARAZO_BEBE_NUEVA_ECOGRAFIA");
    }

    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        d dVar = this.o;
        if (dVar == null || !dVar.o(i2, iArr)) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    @NonNull
    public final UltrasoundPhoto r() {
        UltrasoundPhoto ultrasoundPhoto = new UltrasoundPhoto();
        ultrasoundPhoto.setDescription(this.g.getText().toString());
        ultrasoundPhoto.setTitle(this.h.getText().toString());
        ultrasoundPhoto.setPhotoPath(this.m);
        return ultrasoundPhoto;
    }
}
