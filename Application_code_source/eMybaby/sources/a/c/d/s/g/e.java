package a.c.d.s.g;

import a.c.d.d.c;
import a.c.d.d.d;
import android.app.Activity;
import android.app.NotificationManager;
import androidx.core.app.NotificationCompat;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.util.HashMap;

public class e extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f1152b;

    /* renamed from: c  reason: collision with root package name */
    public long f1153c;

    /* renamed from: d  reason: collision with root package name */
    public NotificationManager f1154d;

    /* renamed from: e  reason: collision with root package name */
    public NotificationCompat.Builder f1155e;
    public int f = 101100;
    public long g;
    public int h = -1;

    public class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public a f1157a;

        /* renamed from: b  reason: collision with root package name */
        public b f1158b;

        public b(b bVar, a aVar) {
            this.f1157a = aVar;
            this.f1158b = bVar;
        }

        public void run() {
            c cVar;
            c cVar2;
            Activity activity;
            String str;
            String str2;
            try {
                File file = new File(this.f1158b.f1146a);
                if (!file.exists()) {
                    c cVar3 = new c();
                    cVar3.f1149a = false;
                    d dVar = (d) this.f1157a;
                    dVar.m.runOnUiThread(new c(dVar, cVar3));
                    return;
                }
                e.this.f1153c = file.length();
                a aVar = new a();
                aVar.a("file", new e.a.a.f0.g.h.c(file));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) aVar.getContentLength());
                aVar.writeTo(byteArrayOutputStream);
                new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                HashMap hashMap = new HashMap();
                hashMap.put("subirfoto", "1");
                Usuario i = AppMiniland.f().i();
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                int i2 = e.this.h;
                if (i2 != 0) {
                    if (i2 == 1) {
                        str2 = "idBebe";
                        str = String.valueOf(this.f1158b.f1147b.getId());
                    } else if (i2 == 2) {
                        str2 = "idPersona";
                        str = this.f1158b.f1148c.getId();
                    }
                    hashMap.put(str2, str);
                } else {
                    hashMap.put("carpeta", i.getCarpeta());
                }
                e.this.f1154d = (NotificationManager) ((AppMiniland) a.c.a.a.f).getApplicationContext().getSystemService("notification");
                e.this.f1155e = new NotificationCompat.Builder(((AppMiniland) a.c.a.a.f).getApplicationContext(), "CHANNEL_ID");
                a.c.a.d.a.o(e.this.f1154d);
                e.this.f1155e.setContentTitle(a.c.a.d.a.h(R.string.TR_NOTIFICATION_UPLOADING_PHOTO_TITLE)).setContentText(a.c.a.d.a.h(R.string.TR_NOTIFICATION_UPLOADING_PHOTO_DESC)).setSmallIcon(R.mipmap.ic_launcher);
                e.a.a.c0.k.e eVar = new e.a.a.c0.k.e(a.c.a.d.a.c(e.this.f1152b, hashMap));
                g a2 = a.c.a.f.d.a();
                eVar.f = aVar;
                String d0 = a.e.a.a.r.b.d0(((e.a.a.g0.g.g) a2).g(eVar).b(), "UTF-8");
                d dVar2 = new d();
                try {
                    c cVar4 = new c();
                    dVar2.f1151a = cVar4;
                    cVar4.f1149a = false;
                    d0.replaceAll("&", "&amp;");
                    dVar2.a(d0);
                    cVar = dVar2.f1151a;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    cVar = null;
                }
                if (cVar == null) {
                    if (!(e.this.f1154d == null || e.this.f1155e == null)) {
                        e.a(e.this, a.c.a.d.a.h(R.string.TR_UPLOAD_PHOTO_KO));
                    }
                    c cVar5 = new c();
                    cVar5.f1149a = false;
                    d dVar3 = (d) this.f1157a;
                    activity = dVar3.m;
                    cVar2 = new c(dVar3, cVar5);
                } else if (cVar.f1149a) {
                    e.a(e.this, a.c.a.d.a.h(R.string.TR_UPLOAD_PHOTO_OK));
                    d dVar4 = (d) this.f1157a;
                    activity = dVar4.m;
                    cVar2 = new c(dVar4, cVar);
                } else {
                    e.a(e.this, a.c.a.d.a.h(R.string.TR_UPLOAD_PHOTO_KO));
                    d dVar5 = (d) this.f1157a;
                    activity = dVar5.m;
                    cVar2 = new c(dVar5, cVar);
                }
                activity.runOnUiThread(cVar2);
            } catch (Exception e3) {
                e eVar2 = e.this;
                if (!(eVar2.f1154d == null || eVar2.f1155e == null)) {
                    e.a(eVar2, a.c.a.d.a.h(R.string.TR_UPLOAD_PHOTO_KO));
                }
                c cVar6 = new c();
                cVar6.f1149a = false;
                d dVar6 = (d) this.f1157a;
                dVar6.m.runOnUiThread(new c(dVar6, cVar6));
                e3.printStackTrace();
            }
        }
    }

    public e(String str, int i) {
        super("UPLOAD_PHOTO_SERVICE");
        this.f1152b = str;
        this.h = i;
    }

    public static void a(e eVar, String str) {
        if (eVar.f1154d != null && eVar.f1155e != null) {
            if (AppMiniland.f().n()) {
                eVar.f1154d.cancel(eVar.f);
                return;
            }
            eVar.f1155e.setContentText(str).setProgress(0, 0, false);
            eVar.f1154d.notify(eVar.f, eVar.f1155e.build());
        }
    }

    public class a extends e.a.a.f0.g.g {
        public a() {
        }

        public void writeTo(OutputStream outputStream) {
            C0052a aVar = new C0052a(outputStream);
            e.a.a.f0.g.c cVar = this.f4927a;
            cVar.a(cVar.f4919d, aVar, true);
        }

        /* renamed from: a.c.d.s.g.e$a$a  reason: collision with other inner class name */
        public class C0052a extends FilterOutputStream {
            public C0052a(OutputStream outputStream) {
                super(outputStream);
                e.this.g = 0;
            }

            public void write(int i) {
                this.out.write(i);
                e eVar = e.this;
                eVar.g++;
                NotificationCompat.Builder builder = eVar.f1155e;
                if (builder != null && eVar.f1154d != null) {
                    builder.setProgress((int) eVar.f1153c, i, false);
                    e eVar2 = e.this;
                    eVar2.f1154d.notify(eVar2.f, eVar2.f1155e.build());
                }
            }

            public void write(byte[] bArr, int i, int i2) {
                this.out.write(bArr, i, i2);
                e eVar = e.this;
                long j = eVar.g + ((long) i2);
                eVar.g = j;
                NotificationCompat.Builder builder = eVar.f1155e;
                if (builder != null && eVar.f1154d != null) {
                    builder.setProgress((int) eVar.f1153c, (int) j, false);
                    e eVar2 = e.this;
                    eVar2.f1154d.notify(eVar2.f, eVar2.f1155e.build());
                }
            }
        }
    }
}
