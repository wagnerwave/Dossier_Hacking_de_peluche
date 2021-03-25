package a.c.d.m.g;

import a.c.d.s.e.b.a.b;
import android.view.WindowManager;
import com.cuatroochenta.miniland.pregnancy.contraction.PregnancyContractionListActivity;
import com.sozpic.miniland.R;

public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f473a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PregnancyContractionListActivity f474b;

    public a(PregnancyContractionListActivity pregnancyContractionListActivity, b bVar) {
        this.f474b = pregnancyContractionListActivity;
        this.f473a = bVar;
    }

    public void run() {
        this.f474b.o();
        if (this.f473a.f42a.booleanValue()) {
            this.f474b.t();
            if (!this.f474b.isFinishing()) {
                try {
                    a.c.a.f.b.l0(this.f474b, a.c.a.d.a.h(R.string.TR_CONTRACCION_GUARDADA_CORRECTAMENTE), a.c.a.d.a.h(R.string.TR_ACEPTAR));
                } catch (WindowManager.BadTokenException unused) {
                }
            }
        } else {
            a.c.a.f.b.h0(this.f474b, a.c.a.d.a.h(R.string.TR_ERROR_GUARDAR_CONTRACCION), a.c.a.d.a.h(R.string.TR_ACEPTAR));
        }
    }
}
