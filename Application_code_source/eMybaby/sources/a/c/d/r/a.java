package a.c.d.r;

import com.cuatroochenta.miniland.model.HeartBeatSound;
import com.cuatroochenta.miniland.model.SongCategory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class a {

    /* renamed from: d  reason: collision with root package name */
    public static a f781d = new a();

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<HeartBeatSound> f782a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, SongCategory> f783b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, ArrayList<String>> f784c = new HashMap<>();

    public SongCategory a(String str) {
        return (a.c.a.d.a.j(str) || !this.f783b.containsKey(str)) ? new SongCategory() : this.f783b.get(str);
    }

    public Collection<SongCategory> b() {
        return this.f783b.values();
    }
}
