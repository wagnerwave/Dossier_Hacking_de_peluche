package a.h.a;

import a.c.a.d.a;
import a.c.d.s.f.b.b;
import com.sozpic.miniland.MyProfileActivity;
import com.sozpic.miniland.R;

public class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f3537a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MyProfileActivity f3538b;

    public p(MyProfileActivity myProfileActivity, b bVar) {
        this.f3538b = myProfileActivity;
        this.f3537a = bVar;
    }

    public void run() {
        this.f3538b.o();
        if (this.f3537a.f42a.booleanValue()) {
            this.f3538b.finish();
        } else {
            a.c.a.f.b.h0(this.f3538b, a.h(R.string.TR_ERROR_GUARDANDO_INFORMACION), a.h(R.string.TR_ACEPTAR));
        }
    }
}
