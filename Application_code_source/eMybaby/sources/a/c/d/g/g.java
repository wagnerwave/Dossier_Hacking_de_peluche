package a.c.d.g;

import a.c.a.d.a;
import a.c.a.f.b;
import a.c.d.r.j;
import a.c.d.s.a.c.c.c;
import android.widget.Toast;
import com.cuatroochenta.miniland.emybuddy.BuddyPlayerActivity;
import com.sozpic.miniland.R;

public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f75a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BuddyPlayerActivity f76b;

    public g(BuddyPlayerActivity buddyPlayerActivity, c cVar) {
        this.f76b = buddyPlayerActivity;
        this.f75a = cVar;
    }

    public void run() {
        String str;
        this.f76b.o();
        c cVar = this.f75a;
        if (cVar == null || !cVar.f847a) {
            str = !a.j(this.f75a.f848b) ? this.f75a.f848b : a.h(R.string.TR_UPLOAD_SONG_KO);
        } else {
            if (cVar.f849c != null) {
                a.c.d.r.a.f781d.a(j.o).addSongToList(this.f75a.f849c);
            }
            str = a.h(R.string.TR_UPLOAD_SONG_OK);
            this.f76b.v();
            if (b.U(this.f76b)) {
                b.x0(this.f76b);
            }
        }
        Toast.makeText(this.f76b, str, 0).show();
    }
}
