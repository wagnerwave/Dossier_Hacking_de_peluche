package a.c.d.g;

import a.c.d.s.a.d.b;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.cuatroochenta.miniland.emybuddy.BuddyActivateActivity;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;

public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f68a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BuddyActivateActivity f69b;

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            d.this.f69b.finish();
        }
    }

    public d(BuddyActivateActivity buddyActivateActivity, b bVar) {
        this.f69b = buddyActivateActivity;
        this.f68a = bVar;
    }

    public void run() {
        String str;
        this.f69b.o();
        b bVar = this.f68a;
        if (bVar == null || !Boolean.TRUE.equals(bVar.f42a)) {
            BuddyActivateActivity buddyActivateActivity = this.f69b;
            b bVar2 = this.f68a;
            if (bVar2 == null || a.c.a.d.a.j(bVar2.f43b)) {
                str = a.c.a.d.a.h(R.string.TR_NO_NETWORK_CONNECTION);
            } else {
                str = this.f68a.f43b;
            }
            a.c.a.f.b.h0(buddyActivateActivity, str, a.c.a.d.a.h(R.string.TR_ACEPTAR));
            return;
        }
        AppMiniland.f().i().setBuddyActive(true);
        BuddyActivateActivity buddyActivateActivity2 = this.f69b;
        String h = a.c.a.d.a.h(R.string.TR_ENTER_CODE_GRANTED);
        String h2 = a.c.a.d.a.h(R.string.TR_ACEPTAR);
        a aVar = new a();
        if (!a.c.a.d.a.j(h)) {
            new AlertDialog.Builder(buddyActivateActivity2).setIcon(17301659).setMessage(h).setPositiveButton(h2, aVar).setCancelable(false).show();
        }
    }
}
