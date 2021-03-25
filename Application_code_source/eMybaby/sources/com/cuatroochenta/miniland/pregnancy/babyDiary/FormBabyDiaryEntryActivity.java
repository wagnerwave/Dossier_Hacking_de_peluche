package com.cuatroochenta.miniland.pregnancy.babyDiary;

import a.c.a.d.a;
import a.c.a.e.f;
import a.c.d.c;
import a.c.d.d.d;
import a.c.d.m.f.q;
import a.c.d.m.f.s;
import a.c.d.m.f.u;
import a.c.d.r.h;
import a.i.a.e;
import a.i.a.t;
import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cuatroochenta.miniland.model.BabyDiaryEntry;
import com.sozpic.miniland.R;
import com.sozpic.miniland.TopMenuActivity;

public class FormBabyDiaryEntryActivity extends c implements h.b {

    /* renamed from: b  reason: collision with root package name */
    public TopMenuActivity f3974b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f3975c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f3976d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f3977e;
    public TextView f;
    public EditText g;
    public TextView h;
    public TextView i;
    public TextView j;
    public String k;
    public d l;
    public BabyDiaryEntry m;

    public static void q(FormBabyDiaryEntryActivity formBabyDiaryEntryActivity, BabyDiaryEntry babyDiaryEntry) {
        if (formBabyDiaryEntryActivity != null) {
            Intent intent = new Intent();
            intent.putExtra("ARGS_DIARY_ENTRY", babyDiaryEntry);
            formBabyDiaryEntryActivity.setResult(-1, intent);
            f.c().d("MI_EMBARAZO", "DIARIO_NUEVO", "");
            formBabyDiaryEntryActivity.finish();
            return;
        }
        throw null;
    }

    public void c(String str) {
        this.k = str;
        this.f3976d.setVisibility(0);
        this.f3976d.setImageBitmap(BitmapFactory.decodeFile(str));
        this.f3976d.setBackgroundColor(-1);
    }

    public void i() {
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (!this.l.n(i2, i3, intent)) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_add_baby_diary_entry);
        this.l = new d((Activity) this, (h.b) this, bundle);
        this.f = (TextView) findViewById(R.id.add_baby_diary_entry_text_label_anadir_comentario);
        this.g = (EditText) findViewById(R.id.add_baby_diary_entry_input_anadir_comentario);
        this.h = (TextView) findViewById(R.id.add_baby_diary_entry_text_label_anadir_foto);
        this.i = (TextView) findViewById(R.id.add_baby_diary_entry_button_cancel);
        this.f3975c = (ImageView) findViewById(R.id.add_baby_diary_entry_button_photo_image);
        this.f3976d = (ImageView) findViewById(R.id.add_baby_diary_entry_icon_photo_image);
        this.j = (TextView) findViewById(R.id.add_baby_diary_entry_button_ok);
        this.f3974b = (TopMenuActivity) findViewById(R.id.add_baby_diary_entry_toolbar);
        this.f3977e = (ViewGroup) findViewById(R.id.add_baby_diary_entry_header);
        this.f3974b.setSeccion(a.h(R.string.TR_MENU_MI_EMBARAZO).toUpperCase());
        this.f3974b.setListener(this);
        ((ImageView) this.f3977e.findViewById(R.id.pregnancy_section_header_image)).setImageResource(R.drawable.ic_pregnant_woman);
        ((TextView) this.f3977e.findViewById(R.id.pregnancy_section_header_title)).setText(a.h(R.string.TR_DIARIO_DEL_BEBE).toUpperCase());
        ((TextView) this.f3977e.findViewById(R.id.pregnancy_section_header_subtitle)).setText(a.h(R.string.TR_NUEVA_ANOTACION).toUpperCase());
        this.f.setText(a.h(R.string.TR_ANADIR_COMENTARIO).toUpperCase());
        this.h.setText(a.h(R.string.TR_ANADIR_FOTO).toUpperCase());
        this.i.setOnClickListener(new q(this));
        this.i.setText(a.h(R.string.TR_CANCEL).toUpperCase());
        this.j.setText(a.h(R.string.TR_OK).toUpperCase());
        this.j.setOnClickListener(new s(this));
        this.f3975c.setOnClickListener(new u(this));
        if (getIntent().getAction() != null && getIntent().getAction().equals("ACTION_EDIT")) {
            BabyDiaryEntry babyDiaryEntry = (BabyDiaryEntry) getIntent().getParcelableExtra("ARGS_DIARY_ENTRY");
            this.m = babyDiaryEntry;
            if (babyDiaryEntry.getPhotoPath() != null) {
                if (this.m.getPhotoPath().startsWith("http")) {
                    t.f(this).d(this.m.getPhotoPath()).b(this.f3976d, (e) null);
                } else {
                    this.f3976d.setImageBitmap(BitmapFactory.decodeFile(this.m.getPhotoPath()));
                }
                this.f3976d.setVisibility(0);
                this.f3976d.setBackgroundColor(-1);
                this.k = this.m.getPhotoPath();
            }
            if (this.m.getCommentary() != null) {
                this.g.setText(this.m.getCommentary());
            }
        }
        f.c().e("MI_EMBARAZO_DIARIO_ADD");
    }

    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        d dVar = this.l;
        if (dVar == null || !dVar.o(i2, iArr)) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }
}
