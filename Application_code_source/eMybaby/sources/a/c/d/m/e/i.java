package a.c.d.m.e;

import a.c.d.s.e.a.c.d.b;
import com.cuatroochenta.miniland.pregnancy.baby.MyPregnancyFragmentContainerActivity;
import com.sozpic.miniland.R;
import java.util.ArrayList;

public class i implements a.c.d.s.e.a.c.d.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MyPregnancyFragmentContainerActivity f351a;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f352a;

        public a(b bVar) {
            this.f352a = bVar;
        }

        public void run() {
            if (this.f352a.f42a.booleanValue()) {
                i.this.f351a.k = new ArrayList<>(this.f352a.f958c);
                return;
            }
            a.c.a.f.b.j0(i.this.f351a, a.c.a.d.a.h(R.string.TR_ERROR_RETRIEVING_DATOS_ECOGRAFIAS));
        }
    }

    public i(MyPregnancyFragmentContainerActivity myPregnancyFragmentContainerActivity) {
        this.f351a = myPregnancyFragmentContainerActivity;
    }

    public void a(b bVar) {
        this.f351a.runOnUiThread(new a(bVar));
    }
}
