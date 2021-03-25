package a.c.d.m.h;

import a.c.a.d.a;
import a.c.d.s.e.g.c.c;
import android.view.WindowManager;
import com.cuatroochenta.miniland.pregnancy.escuchalatidos.PregnancyEscuchaLatidosActivity;
import com.sozpic.miniland.R;

public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f489a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PregnancyEscuchaLatidosActivity f490b;

    public b(PregnancyEscuchaLatidosActivity pregnancyEscuchaLatidosActivity, c cVar) {
        this.f490b = pregnancyEscuchaLatidosActivity;
        this.f489a = cVar;
    }

    public void run() {
        String str;
        this.f490b.o();
        c cVar = this.f489a;
        if (!cVar.f1126a) {
            PregnancyEscuchaLatidosActivity pregnancyEscuchaLatidosActivity = this.f490b;
            if (!a.j(cVar.f1127b)) {
                str = this.f489a.f1127b;
            } else {
                str = a.h(R.string.TR_UPLOAD_PREGNANCY_SOUND_KO);
            }
            a.c.a.f.b.h0(pregnancyEscuchaLatidosActivity, str, a.h(R.string.TR_ACEPTAR));
        } else if (!this.f490b.isFinishing()) {
            try {
                a.c.a.f.b.l0(this.f490b, a.h(R.string.TR_UPLOAD_PREGNANCY_SOUND_OK), a.h(R.string.TR_ACEPTAR));
            } catch (WindowManager.BadTokenException unused) {
            }
        }
    }
}
