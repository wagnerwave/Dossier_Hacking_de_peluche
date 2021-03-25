package a.c.d.m.f;

import a.c.a.f.b;
import a.c.d.m.f.s;
import a.c.d.s.e.a.a.a.a;
import com.cuatroochenta.miniland.pregnancy.babyDiary.FormBabyDiaryEntryActivity;

public class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f461a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ s.a f462b;

    public r(s.a aVar, a aVar2) {
        this.f462b = aVar;
        this.f461a = aVar2;
    }

    public void run() {
        this.f462b.f464a.dismiss();
        if (this.f461a.f42a.booleanValue()) {
            this.f462b.f465b.setId(this.f461a.f890c);
            s.a aVar = this.f462b;
            FormBabyDiaryEntryActivity.q(s.this.f463a, aVar.f465b);
            return;
        }
        b.j0(s.this.f463a, this.f461a.f43b);
    }
}
