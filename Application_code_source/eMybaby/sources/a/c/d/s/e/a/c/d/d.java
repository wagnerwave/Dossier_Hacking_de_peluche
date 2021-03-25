package a.c.d.s.e.a.c.d;

import a.c.d.m.e.i;
import a.e.a.a.r.b;
import com.cuatroochenta.miniland.webservices.pregnancy.baby.ultrasound.list.UltrasoundListRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import e.a.a.c0.k.c;
import java.text.ParseException;
import java.util.HashMap;

public class d extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f960b = "https://emybaby.com/api/ecografia.php";

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public a f961a;

        public a(UltrasoundListRequest ultrasoundListRequest, a aVar) {
            this.f961a = aVar;
        }

        public void run() {
            try {
                g a2 = a.c.a.f.d.a();
                HashMap hashMap = new HashMap();
                Usuario i = AppMiniland.f().i();
                hashMap.put("verecografias", "1");
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("id", i.getId());
                hashMap.put("pass", i.getPass());
                String c0 = b.c0(((e.a.a.g0.g.g) a2).g(new c(a.c.a.d.a.c(d.this.f960b, hashMap))).b());
                c cVar = new c();
                b bVar = new b();
                cVar.f959a = bVar;
                bVar.f42a = Boolean.FALSE;
                if (c0.equals("null")) {
                    cVar.f959a.f42a = Boolean.TRUE;
                } else {
                    try {
                        cVar.a(c0);
                    } catch (ParseException e2) {
                        e2.printStackTrace();
                    }
                }
                ((i) this.f961a).a(cVar.f959a);
            } catch (Exception e3) {
                e3.printStackTrace();
                b bVar2 = new b();
                bVar2.f42a = Boolean.FALSE;
                i iVar = (i) this.f961a;
                iVar.f351a.runOnUiThread(new i.a(bVar2));
            }
        }
    }

    public d() {
        super("ULTRASOUND_LIST");
    }
}
