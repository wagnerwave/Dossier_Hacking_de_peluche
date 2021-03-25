package a.c.d.g;

import a.c.d.r.a;
import a.c.d.r.j;
import a.c.d.s.a.c.b.c;
import android.widget.Toast;
import com.cuatroochenta.miniland.emybuddy.BuddyPlayerActivity;
import com.cuatroochenta.miniland.model.Song;
import com.cuatroochenta.miniland.model.SongCategory;
import com.sozpic.miniland.R;
import java.util.Iterator;

public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f77a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BuddyPlayerActivity f78b;

    public h(BuddyPlayerActivity buddyPlayerActivity, c cVar) {
        this.f78b = buddyPlayerActivity;
        this.f77a = cVar;
    }

    public void run() {
        String str;
        this.f78b.o();
        c cVar = this.f77a;
        if (cVar != null && cVar.f42a.booleanValue() && this.f77a.f838c != null) {
            SongCategory a2 = a.f781d.a(j.o);
            if (a2 != null) {
                Iterator<Song> it = a2.getSongList().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Song next = it.next();
                    if (next.getId() == this.f77a.f838c.getId()) {
                        next.setTitle(this.f77a.f838c.getTitle());
                        break;
                    }
                }
            }
            str = a.c.a.d.a.h(R.string.TR_EDIT_SONG_OK);
            this.f78b.v();
        } else if (!a.c.a.d.a.j(this.f77a.f43b)) {
            str = this.f77a.f43b;
        } else {
            str = a.c.a.d.a.h(R.string.TR_EDIT_SONG_KO);
        }
        Toast.makeText(this.f78b, str, 0).show();
    }
}
