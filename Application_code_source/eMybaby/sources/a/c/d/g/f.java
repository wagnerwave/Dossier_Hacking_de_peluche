package a.c.d.g;

import a.c.a.f.b;
import a.c.d.c;
import a.c.d.s.a.a.a;
import a.g.a.b.d;
import android.os.Bundle;
import com.cuatroochenta.miniland.model.Song;
import com.cuatroochenta.miniland.model.SongCategory;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import java.util.ArrayList;
import java.util.Iterator;

public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f73a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f74b;

    public f(e eVar, a aVar) {
        this.f74b = eVar;
        this.f73a = aVar;
    }

    public void run() {
        if (this.f74b.getActivity() instanceof c) {
            ((c) this.f74b.getActivity()).o();
        }
        a aVar = this.f73a;
        if (aVar == null || !aVar.f42a.booleanValue()) {
            b.h0(this.f74b.getActivity(), a.c.a.d.a.h(R.string.TR_ERROR_RETRIEVING_SONGS_INFO), a.c.a.d.a.h(R.string.TR_ACEPTAR));
            return;
        }
        a.c.d.r.a aVar2 = a.c.d.r.a.f781d;
        ArrayList<SongCategory> arrayList = this.f73a.f817d;
        aVar2.f783b.clear();
        Iterator<SongCategory> it = arrayList.iterator();
        while (it.hasNext()) {
            SongCategory next = it.next();
            aVar2.f783b.put(next.getId(), next);
        }
        a.c.d.r.a aVar3 = a.c.d.r.a.f781d;
        aVar3.f784c.put("HELP_BUDDY", this.f73a.f816c);
        d dVar = AppMiniland.f().k;
        long j = 0;
        int i = 0;
        for (SongCategory songList : a.c.d.r.a.f781d.b()) {
            Iterator<Song> it2 = songList.getSongList().iterator();
            while (it2.hasNext()) {
                Song next2 = it2.next();
                if (!a.c.a.d.a.j(next2.getUrlFile())) {
                    if (!dVar.c().a(next2.getUrlFile()).exists()) {
                        i++;
                        j += next2.getFileSize();
                    }
                }
            }
        }
        if (i > 0) {
            a.c.d.g.k.a aVar4 = new a.c.d.g.k.a();
            Bundle bundle = new Bundle();
            bundle.putInt("PENDING_SONGS", i);
            bundle.putLong("PENDING_SIZE", j);
            aVar4.setArguments(bundle);
            aVar4.f100a = this.f74b;
            aVar4.setCancelable(false);
            aVar4.show(this.f74b.getChildFragmentManager(), "DOWNLOAD_DIALOG");
        }
    }
}
