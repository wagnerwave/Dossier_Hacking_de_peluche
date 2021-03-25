package a.c.d.m.f;

import a.c.a.f.b;
import a.c.d.m.f.s;
import a.c.d.s.e.a.a.c.a;
import com.cuatroochenta.miniland.pregnancy.babyDiary.FormBabyDiaryEntryActivity;

public class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f470a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ s.b f471b;

    public t(s.b bVar, a aVar) {
        this.f471b = bVar;
        this.f470a = aVar;
    }

    public void run() {
        this.f471b.f467a.dismiss();
        if (this.f470a.f42a.booleanValue()) {
            this.f471b.f468b.setId(this.f470a.f903c);
            s.b bVar = this.f471b;
            FormBabyDiaryEntryActivity.q(s.this.f463a, bVar.f468b);
            return;
        }
        b.j0(s.this.f463a, this.f470a.f43b);
    }
}
