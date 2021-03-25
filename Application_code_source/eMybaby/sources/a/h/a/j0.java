package a.h.a;

import a.c.a.d.a;
import a.c.d.s.h.b;
import com.sozpic.miniland.R;
import com.sozpic.miniland.StreamingActivity;

public class j0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f3481a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ StreamingActivity f3482b;

    public j0(StreamingActivity streamingActivity, b bVar) {
        this.f3482b = streamingActivity;
        this.f3481a = bVar;
    }

    public void run() {
        this.f3482b.o();
        b bVar = this.f3481a;
        if (bVar == null || !bVar.f42a.booleanValue()) {
            a.c.a.f.b.h0(this.f3482b, a.h(R.string.TR_ASEGURARSE_CAMARA_CONECTADA), a.h(R.string.TR_ACEPTAR));
            return;
        }
        this.f3482b.h.setEnabled(true);
        this.f3482b.h.setAlpha(1.0f);
        this.f3482b.g = this.f3481a.f1160c;
    }
}
