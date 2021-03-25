package a.h.a;

import a.c.a.f.b;
import a.c.d.s.d.a;
import android.content.Intent;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.LoginActivity;
import com.sozpic.miniland.MainActivity;
import com.sozpic.miniland.R;

public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f3473a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoginActivity f3474b;

    public g(LoginActivity loginActivity, a aVar) {
        this.f3474b = loginActivity;
        this.f3473a = aVar;
    }

    public void run() {
        this.f3474b.o();
        if (this.f3473a.f42a.booleanValue()) {
            a aVar = this.f3473a;
            if (aVar.f885c != null) {
                AppMiniland.f().g = this.f3473a.f885c;
                this.f3474b.startActivityForResult(new Intent(this.f3474b.f4464b, MainActivity.class), 0);
                this.f3474b.finish();
                return;
            }
            b.h0(this.f3474b, aVar.f43b, a.c.a.d.a.h(R.string.TR_ACEPTAR));
            return;
        }
        b.h0(this.f3474b, a.c.a.d.a.h(R.string.TR_ERROR_RECUPERANDO_PERFIL_USUARIO), a.c.a.d.a.h(R.string.TR_ACEPTAR));
    }
}
