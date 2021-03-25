package a.c.d.s.e.g.c;

import a.c.d.r.j;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.cuatroochenta.miniland.model.TimeData;
import com.cuatroochenta.miniland.pregnancy.escuchalatidos.PregnancyEscuchaLatidosActivity;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import com.sozpic.miniland.modelos.Usuario;
import com.tuya.smart.home.sdk.bean.scene.ConditionExtraInfoBean;
import e.a.a.c0.g;
import e.a.a.f0.g.h.c;
import e.a.a.f0.g.h.d;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;

public class e extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f1129b;

    /* renamed from: c  reason: collision with root package name */
    public long f1130c;

    /* renamed from: d  reason: collision with root package name */
    public NotificationManager f1131d;

    /* renamed from: e  reason: collision with root package name */
    public NotificationCompat.Builder f1132e;
    public int f = 101101;
    public long g;

    public class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public a f1134a;

        /* renamed from: b  reason: collision with root package name */
        public b f1135b;

        public b(b bVar, a aVar) {
            this.f1134a = aVar;
            this.f1135b = bVar;
        }

        public void run() {
            c cVar;
            a.c.d.m.h.b bVar;
            PregnancyEscuchaLatidosActivity pregnancyEscuchaLatidosActivity;
            try {
                Charset forName = Charset.forName("UTF-8");
                File file = new File(this.f1135b.f1121a);
                if (!file.exists()) {
                    c cVar2 = new c();
                    cVar2.f1126a = false;
                    PregnancyEscuchaLatidosActivity pregnancyEscuchaLatidosActivity2 = (PregnancyEscuchaLatidosActivity) this.f1134a;
                    pregnancyEscuchaLatidosActivity2.runOnUiThread(new a.c.d.m.h.b(pregnancyEscuchaLatidosActivity2, cVar2));
                } else if (!a.c.a.d.a.j(this.f1135b.f1123c)) {
                    d dVar = new d(this.f1135b.f1123c, "text/plain", forName);
                    e.this.f1130c = file.length();
                    a aVar = new a();
                    aVar.a("titulo", dVar);
                    aVar.a(ConditionExtraInfoBean.CAL_TYPE_DURATION, new d(String.valueOf(this.f1135b.f1122b)));
                    if (this.f1135b.f1124d != null) {
                        aVar.a("fecha", new d(j.j.format(this.f1135b.f1124d)));
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append('[');
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append('[');
                    Iterator it = this.f1135b.f1125e.iterator();
                    while (it.hasNext()) {
                        TimeData timeData = (TimeData) it.next();
                        if (sb.length() > 1) {
                            sb.append(',');
                        }
                        sb.append('[');
                        sb.append(timeData.getSecondsElapsed());
                        sb.append(',');
                        sb.append(timeData.getHeartRate());
                        sb.append(']');
                        if (timeData.isFetalMovement()) {
                            if (sb2.length() > 1) {
                                sb2.append(',');
                            }
                            sb2.append(timeData.getSecondsElapsed());
                        }
                    }
                    sb.append("]");
                    sb2.append(']');
                    aVar.a("fhrs", new d(sb.toString()));
                    aVar.a("kicks", new d(sb2.toString()));
                    aVar.writeTo(new ByteArrayOutputStream((int) aVar.getContentLength()));
                    aVar.a("file", new c(file));
                    HashMap hashMap = new HashMap();
                    hashMap.put("anadirsonido", "1");
                    Usuario i = AppMiniland.f().i();
                    hashMap.put("bd", i.getBd());
                    hashMap.put("bdpre", i.getBdpre());
                    hashMap.put("id", i.getId());
                    hashMap.put("pass", i.getPass());
                    e.this.f1131d = (NotificationManager) ((AppMiniland) a.c.a.a.f).getApplicationContext().getSystemService("notification");
                    e.this.f1132e = new NotificationCompat.Builder(((AppMiniland) a.c.a.a.f).getApplicationContext(), "CHANNEL_ID");
                    a.c.a.d.a.o(e.this.f1131d);
                    e.a.a.c0.k.e eVar = new e.a.a.c0.k.e(a.c.a.d.a.c(e.this.f1129b, hashMap));
                    g a2 = a.c.a.f.d.a();
                    eVar.f = aVar;
                    e.this.f1132e.setContentTitle(a.c.a.d.a.h(R.string.TR_NOTIFICATION_UPLOADING_PREGNANCY_SOUND_TITLE)).setContentText(a.c.a.d.a.h(R.string.TR_NOTIFICATION_UPLOADING_PREGNANCY_SOUND_DESC)).setSmallIcon(R.mipmap.ic_launcher);
                    String c0 = a.e.a.a.r.b.c0(((e.a.a.g0.g.g) a2).g(eVar).b());
                    d dVar2 = new d();
                    try {
                        c cVar3 = new c();
                        dVar2.f1128a = cVar3;
                        cVar3.f1126a = false;
                        c0.replaceAll("&", "&amp;");
                        dVar2.a(c0);
                        cVar = dVar2.f1128a;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        cVar = null;
                    }
                    if (cVar == null) {
                        if (!(e.this.f1131d == null || e.this.f1132e == null)) {
                            e.a(e.this, a.c.a.d.a.h(R.string.TR_UPLOAD_PREGNANCY_SOUND_KO));
                        }
                        c cVar4 = new c();
                        cVar4.f1126a = false;
                        pregnancyEscuchaLatidosActivity = (PregnancyEscuchaLatidosActivity) this.f1134a;
                        bVar = new a.c.d.m.h.b(pregnancyEscuchaLatidosActivity, cVar4);
                    } else if (cVar.f1126a) {
                        e.a(e.this, a.c.a.d.a.h(R.string.TR_UPLOAD_PREGNANCY_SOUND_OK));
                        PregnancyEscuchaLatidosActivity pregnancyEscuchaLatidosActivity3 = (PregnancyEscuchaLatidosActivity) this.f1134a;
                        pregnancyEscuchaLatidosActivity3.runOnUiThread(new a.c.d.m.h.b(pregnancyEscuchaLatidosActivity3, cVar));
                        if (!a.c.a.d.a.j((String) null)) {
                            file.renameTo(a.c.c.b.c().b((String) null));
                            return;
                        }
                        return;
                    } else {
                        e.a(e.this, a.c.a.d.a.h(R.string.TR_UPLOAD_PREGNANCY_SOUND_KO));
                        pregnancyEscuchaLatidosActivity = (PregnancyEscuchaLatidosActivity) this.f1134a;
                        bVar = new a.c.d.m.h.b(pregnancyEscuchaLatidosActivity, cVar);
                    }
                    pregnancyEscuchaLatidosActivity.runOnUiThread(bVar);
                } else {
                    c cVar5 = new c();
                    cVar5.f1126a = false;
                    PregnancyEscuchaLatidosActivity pregnancyEscuchaLatidosActivity4 = (PregnancyEscuchaLatidosActivity) this.f1134a;
                    pregnancyEscuchaLatidosActivity4.runOnUiThread(new a.c.d.m.h.b(pregnancyEscuchaLatidosActivity4, cVar5));
                }
            } catch (Exception e3) {
                e eVar2 = e.this;
                if (!(eVar2.f1131d == null || eVar2.f1132e == null)) {
                    e.a(eVar2, a.c.a.d.a.h(R.string.TR_UPLOAD_SONG_KO));
                }
                c cVar6 = new c();
                cVar6.f1126a = false;
                PregnancyEscuchaLatidosActivity pregnancyEscuchaLatidosActivity5 = (PregnancyEscuchaLatidosActivity) this.f1134a;
                pregnancyEscuchaLatidosActivity5.runOnUiThread(new a.c.d.m.h.b(pregnancyEscuchaLatidosActivity5, cVar6));
                e3.printStackTrace();
            }
        }
    }

    public e(String str) {
        super("UPLOAD_SOUND_PREGNANCY_SERVICE");
        this.f1129b = str;
    }

    public static void a(e eVar, String str) {
        if (Build.VERSION.SDK_INT >= 26 && eVar.f1131d.getNotificationChannel("CHANNEL_ID") == null) {
            eVar.f1131d.createNotificationChannel(new NotificationChannel("CHANNEL_ID", "eMyBaby", 3));
        }
        if (eVar.f1131d != null && eVar.f1132e != null) {
            if (AppMiniland.f().n()) {
                eVar.f1131d.cancel(eVar.f);
                return;
            }
            eVar.f1132e.setContentText(str).setProgress(0, 0, false);
            eVar.f1131d.notify(eVar.f, eVar.f1132e.build());
        }
    }

    public class a extends e.a.a.f0.g.g {
        public a() {
        }

        public void writeTo(OutputStream outputStream) {
            C0051a aVar = new C0051a(outputStream);
            e.a.a.f0.g.c cVar = this.f4927a;
            cVar.a(cVar.f4919d, aVar, true);
        }

        /* renamed from: a.c.d.s.e.g.c.e$a$a  reason: collision with other inner class name */
        public class C0051a extends FilterOutputStream {
            public C0051a(OutputStream outputStream) {
                super(outputStream);
                e.this.g = 0;
            }

            public void write(int i) {
                NotificationManager notificationManager;
                this.out.write(i);
                e eVar = e.this;
                eVar.g++;
                if (eVar.f1132e != null && (notificationManager = eVar.f1131d) != null) {
                    if (Build.VERSION.SDK_INT >= 26 && notificationManager.getNotificationChannel("CHANNEL_ID") == null) {
                        e.this.f1131d.createNotificationChannel(new NotificationChannel("CHANNEL_ID", "eMyBaby", 3));
                    }
                    e eVar2 = e.this;
                    eVar2.f1132e.setProgress((int) eVar2.f1130c, i, false);
                    e eVar3 = e.this;
                    eVar3.f1131d.notify(eVar3.f, eVar3.f1132e.build());
                }
            }

            public void write(byte[] bArr, int i, int i2) {
                NotificationManager notificationManager;
                this.out.write(bArr, i, i2);
                e eVar = e.this;
                eVar.g += (long) i2;
                if (eVar.f1132e != null && (notificationManager = eVar.f1131d) != null) {
                    if (Build.VERSION.SDK_INT >= 26 && notificationManager.getNotificationChannel("CHANNEL_ID") == null) {
                        e.this.f1131d.createNotificationChannel(new NotificationChannel("CHANNEL_ID", "eMyBaby", 3));
                    }
                    e eVar2 = e.this;
                    eVar2.f1132e.setProgress((int) eVar2.f1130c, (int) eVar2.g, false);
                    e eVar3 = e.this;
                    eVar3.f1131d.notify(eVar3.f, eVar3.f1132e.build());
                }
            }
        }
    }
}
