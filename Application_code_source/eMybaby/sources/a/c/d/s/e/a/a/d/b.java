package a.c.d.s.e.a.a.d;

import a.c.a.f.d;
import com.cuatroochenta.miniland.pregnancy.babyDiary.BabyDiaryActivity;
import com.cuatroochenta.miniland.webservices.pregnancy.baby.babyDiary.list.BabyDiaryEntryListRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import e.a.a.c0.k.c;
import java.util.HashMap;
import org.json.JSONArray;

public class b extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f913b = "https://emybaby.com/api/diariobebe.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public c f914a;

        public a(BabyDiaryEntryListRequest babyDiaryEntryListRequest, c cVar) {
            this.f914a = cVar;
        }

        public void run() {
            try {
                g a2 = d.a();
                HashMap hashMap = new HashMap();
                hashMap.put("verentradas", "1");
                Usuario i = AppMiniland.f().i();
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("id", i.getId());
                hashMap.put("pass", i.getPass());
                String c0 = a.e.a.a.r.b.c0(((e.a.a.g0.g.g) a2).g(new c(a.c.a.d.a.c(b.this.f913b, hashMap))).b());
                c cVar = this.f914a;
                BabyDiaryActivity.b bVar = (BabyDiaryActivity.b) cVar;
                BabyDiaryActivity.this.runOnUiThread(new a.c.d.m.f.a(bVar, new a(new JSONArray(c0))));
            } catch (Exception e2) {
                e2.printStackTrace();
                a aVar = new a();
                aVar.f42a = Boolean.FALSE;
                BabyDiaryActivity.b bVar2 = (BabyDiaryActivity.b) this.f914a;
                BabyDiaryActivity.this.runOnUiThread(new a.c.d.m.f.a(bVar2, aVar));
            }
        }
    }

    public b() {
        super("BABY_DIARY_LIST");
    }
}
