package a.c.d.g;

import a.c.a.f.b;
import a.c.d.r.a;
import a.c.d.r.j;
import a.c.d.s.a.c.a.c;
import android.widget.Toast;
import com.cuatroochenta.miniland.emybuddy.BuddyPlayerActivity;
import com.cuatroochenta.miniland.model.Song;
import com.cuatroochenta.miniland.model.SongCategory;
import com.sozpic.miniland.R;
import java.util.Iterator;

public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f79a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BuddyPlayerActivity f80b;

    public i(BuddyPlayerActivity buddyPlayerActivity, c cVar) {
        this.f80b = buddyPlayerActivity;
        this.f79a = cVar;
    }

    public void run() {
        String str;
        int i;
        int a2;
        this.f80b.o();
        c cVar = this.f79a;
        if (cVar != null && cVar.f42a.booleanValue() && this.f79a.f830c != null) {
            SongCategory a3 = a.f781d.a(j.o);
            if (a3 != null) {
                Iterator<Song> it = a3.getSongList().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Song next = it.next();
                    if (next.getId() == this.f79a.f830c.getId()) {
                        a3.getSongList().remove(next);
                        break;
                    }
                }
            }
            a.c.d.g.j.c cVar2 = (a.c.d.g.j.c) this.f80b.f3828e.getAdapter();
            if (cVar2 != null && (a2 = cVar2.a(this.f79a.f830c)) >= 0) {
                b.e0(this.f80b, a2);
            }
            this.f80b.v();
            i = R.string.TR_DELETE_SONG_OK;
        } else if (!a.c.a.d.a.j(this.f79a.f43b)) {
            str = this.f79a.f43b;
            Toast.makeText(this.f80b, str, 0).show();
        } else {
            i = R.string.TR_DELETE_SONG_KO;
        }
        str = a.c.a.d.a.h(i);
        Toast.makeText(this.f80b, str, 0).show();
    }
}
