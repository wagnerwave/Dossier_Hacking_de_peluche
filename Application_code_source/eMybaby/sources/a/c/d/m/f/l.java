package a.c.d.m.f;

import a.c.d.r.k.a;
import android.view.View;
import com.cuatroochenta.miniland.pregnancy.babyDiary.BabyDiaryActivity;

public class l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a.C0042a f450a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f451b;

    public l(n nVar, a.C0042a aVar) {
        this.f451b = nVar;
        this.f450a = aVar;
    }

    public void onClick(View view) {
        if ((this.f450a.b() instanceof BabyDiaryActivity) && this.f451b.f455d) {
            ((BabyDiaryActivity) this.f450a.b()).q();
            n nVar = this.f451b;
            nVar.f455d = false;
            nVar.f456e = null;
            nVar.f = -1;
            nVar.notifyDataSetChanged();
        }
    }
}
