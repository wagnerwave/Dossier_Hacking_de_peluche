package a.c.d.m.f;

import android.content.Intent;
import android.view.View;
import com.cuatroochenta.miniland.pregnancy.babyDiary.BabyDiaryActivity;
import com.cuatroochenta.miniland.pregnancy.babyDiary.FormBabyDiaryEntryActivity;

public class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BabyDiaryActivity f438a;

    public f(BabyDiaryActivity babyDiaryActivity) {
        this.f438a = babyDiaryActivity;
    }

    public void onClick(View view) {
        BabyDiaryActivity babyDiaryActivity = this.f438a;
        babyDiaryActivity.startActivityForResult(new Intent(babyDiaryActivity, FormBabyDiaryEntryActivity.class), 42830);
    }
}
