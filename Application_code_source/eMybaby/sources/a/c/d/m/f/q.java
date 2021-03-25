package a.c.d.m.f;

import android.view.View;
import com.cuatroochenta.miniland.pregnancy.babyDiary.FormBabyDiaryEntryActivity;

public class q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FormBabyDiaryEntryActivity f460a;

    public q(FormBabyDiaryEntryActivity formBabyDiaryEntryActivity) {
        this.f460a = formBabyDiaryEntryActivity;
    }

    public void onClick(View view) {
        this.f460a.setResult(0);
        this.f460a.finish();
    }
}
