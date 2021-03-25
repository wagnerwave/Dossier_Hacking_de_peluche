package a.c.d.m.f;

import a.c.d.r.k.a;
import android.view.View;
import com.cuatroochenta.miniland.pregnancy.babyDiary.BabyDiaryActivity;
import com.sozpic.miniland.R;

public class k implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a.C0042a f447a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f448b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n f449c;

    public k(n nVar, a.C0042a aVar, int i) {
        this.f449c = nVar;
        this.f447a = aVar;
        this.f448b = i;
    }

    public boolean onLongClick(View view) {
        if (this.f447a.b() instanceof BabyDiaryActivity) {
            BabyDiaryActivity babyDiaryActivity = this.f449c.g;
            babyDiaryActivity.f3969d.setVisibility(0);
            babyDiaryActivity.f3969d.post(new j(babyDiaryActivity));
            n nVar = this.f449c;
            nVar.f455d = true;
            nVar.f456e = this.f447a.c(R.id.baby_diary_entry_check);
            n nVar2 = this.f449c;
            nVar2.f = this.f448b;
            nVar2.notifyDataSetChanged();
        }
        return true;
    }
}
