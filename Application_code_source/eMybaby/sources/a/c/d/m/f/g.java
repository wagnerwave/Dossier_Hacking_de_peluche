package a.c.d.m.f;

import android.content.Intent;
import android.view.View;
import com.cuatroochenta.miniland.model.BabyDiaryEntry;
import com.cuatroochenta.miniland.pregnancy.babyDiary.BabyDiaryActivity;
import com.cuatroochenta.miniland.pregnancy.babyDiary.FormBabyDiaryEntryActivity;

public class g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BabyDiaryActivity f439a;

    public g(BabyDiaryActivity babyDiaryActivity) {
        this.f439a = babyDiaryActivity;
    }

    public void onClick(View view) {
        BabyDiaryActivity babyDiaryActivity = this.f439a;
        n a2 = babyDiaryActivity.k.a();
        BabyDiaryEntry babyDiaryEntry = (BabyDiaryEntry) a2.getItem(a2.f);
        Intent intent = new Intent(babyDiaryActivity, FormBabyDiaryEntryActivity.class);
        intent.setAction("ACTION_EDIT");
        intent.putExtra("ARGS_DIARY_ENTRY", babyDiaryEntry);
        intent.putExtra("ARGS_DIARY_ID", babyDiaryEntry.getId());
        babyDiaryActivity.startActivityForResult(intent, 44823);
    }
}
