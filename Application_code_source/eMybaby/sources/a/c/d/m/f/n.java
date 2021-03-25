package a.c.d.m.f;

import a.c.a.f.e;
import a.c.d.r.k.a;
import a.c.d.r.k.b;
import a.i.a.t;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cuatroochenta.miniland.model.BabyDiaryEntry;
import com.cuatroochenta.miniland.pregnancy.babyDiary.BabyDiaryActivity;
import com.cuatroochenta.miniland.utils.LoadeablePicassoImageView;
import com.sozpic.miniland.R;

public class n extends b<BabyDiaryEntry> {

    /* renamed from: d  reason: collision with root package name */
    public boolean f455d;

    /* renamed from: e  reason: collision with root package name */
    public View f456e;
    public int f = -1;
    public BabyDiaryActivity g;

    public void a(a.C0042a aVar) {
        aVar.a(R.id.baby_diary_entry_text_body);
        aVar.a(R.id.baby_diary_entry_check);
        aVar.a(R.id.baby_diary_entry_image_body);
        aVar.a(R.id.baby_diary_text_timestamp);
        aVar.a(R.id.baby_diary_entry_area_body);
    }

    public void b(int i, Object obj, a.C0042a aVar) {
        BabyDiaryEntry babyDiaryEntry = (BabyDiaryEntry) obj;
        this.g = (BabyDiaryActivity) aVar.b();
        ((TextView) aVar.c(R.id.baby_diary_entry_text_body)).setText(babyDiaryEntry.getCommentary());
        ((TextView) aVar.c(R.id.baby_diary_text_timestamp)).setText(babyDiaryEntry.getTitle());
        aVar.c(R.id.baby_diary_entry_text_body).setVisibility(babyDiaryEntry.getCommentary() == null ? 8 : 0);
        aVar.c(R.id.baby_diary_entry_image_body).setVisibility(babyDiaryEntry.getPhotoPath() == null ? 8 : 0);
        aVar.c(R.id.baby_diary_entry_area_body).setOnLongClickListener(new k(this, aVar, i));
        aVar.c(R.id.baby_diary_entry_area_body).setOnClickListener(new l(this, aVar));
        if (babyDiaryEntry.getPhotoPath() != null && !babyDiaryEntry.getPhotoPath().isEmpty()) {
            if (babyDiaryEntry.getPhotoPath().startsWith("http")) {
                t.f(aVar.b()).d(babyDiaryEntry.getPhotoPath()).c((LoadeablePicassoImageView) aVar.c(R.id.baby_diary_entry_image_body));
            } else {
                try {
                    ((LoadeablePicassoImageView) aVar.c(R.id.baby_diary_entry_image_body)).setImageBitmap(BitmapFactory.decodeFile(babyDiaryEntry.getPhotoPath()));
                } catch (OutOfMemoryError e2) {
                    e.c(e2.getMessage());
                }
            }
        }
        ImageView imageView = (ImageView) aVar.c(R.id.baby_diary_entry_check);
        if (this.f455d) {
            imageView.setVisibility(0);
            imageView.setOnClickListener(new m(this, i, imageView));
            if (this.f == i) {
                imageView.setSelected(true);
            } else {
                imageView.setSelected(false);
            }
        } else {
            imageView.setVisibility(8);
            this.f456e = null;
            this.f = -1;
        }
    }

    public long c(int i, Object obj) {
        return ((BabyDiaryEntry) obj).getId();
    }

    public View d(Context context, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.item_baby_diary_entry, viewGroup, false);
    }

    public void e(int i, Object obj, Object obj2, a.C0042a aVar) {
        BabyDiaryEntry babyDiaryEntry = (BabyDiaryEntry) obj;
        ((TextView) aVar.c(R.id.baby_diary_entry_header_text_label_semana)).setText(a.c.a.d.a.h(R.string.TR_SEMANA).toUpperCase());
        ((TextView) aVar.c(R.id.baby_diary_entry_header_text_semana)).setText(String.valueOf(((BabyDiaryEntry) obj2).getWeek()));
    }
}
