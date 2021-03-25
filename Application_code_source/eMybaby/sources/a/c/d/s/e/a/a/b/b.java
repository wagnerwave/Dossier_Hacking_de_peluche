package a.c.d.s.e.a.a.b;

import a.c.a.f.d;
import a.c.d.m.f.h;
import a.c.d.m.f.i;
import com.cuatroochenta.miniland.webservices.pregnancy.baby.babyDiary.delete.BabyDiaryEntryDeleteRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import e.a.a.c0.k.c;
import java.util.HashMap;
import org.json.JSONObject;

public class b extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f899b = "https://emybaby.com/api/diariobebe.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public c f900a;

        /* renamed from: b  reason: collision with root package name */
        public BabyDiaryEntryDeleteRequest f901b;

        public a(BabyDiaryEntryDeleteRequest babyDiaryEntryDeleteRequest, c cVar) {
            this.f900a = cVar;
            this.f901b = babyDiaryEntryDeleteRequest;
        }

        public void run() {
            try {
                g a2 = d.a();
                HashMap hashMap = new HashMap();
                hashMap.put("eliminarentrada", "1");
                Usuario i = AppMiniland.f().i();
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("idEntrada", String.valueOf(this.f901b.f4097a));
                String c0 = a.e.a.a.r.b.c0(((e.a.a.g0.g.g) a2).g(new c(a.c.a.d.a.c(b.this.f899b, hashMap))).b());
                c cVar = this.f900a;
                i.a.C0025a aVar = (i.a.C0025a) cVar;
                i.this.f442a.runOnUiThread(new h(aVar, new a(new JSONObject(c0))));
            } catch (Exception e2) {
                e2.printStackTrace();
                a aVar2 = new a();
                aVar2.f42a = Boolean.FALSE;
                i.a.C0025a aVar3 = (i.a.C0025a) this.f900a;
                i.this.f442a.runOnUiThread(new h(aVar3, aVar2));
            }
        }
    }

    public b() {
        super("PREGNANCY_CONTRACTION_DELETE");
    }
}
