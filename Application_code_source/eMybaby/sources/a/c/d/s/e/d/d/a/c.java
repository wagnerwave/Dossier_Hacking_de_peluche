package a.c.d.s.e.d.d.a;

import a.c.a.f.d;
import a.c.d.r.j;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.my_belly.add.MamaMyBellyAddRequest;
import com.sozpic.miniland.AppMiniland;
import com.sozpic.miniland.R;
import com.sozpic.miniland.modelos.Usuario;
import e.a.a.c0.g;
import e.a.a.c0.k.e;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.HashMap;
import org.json.JSONObject;

public class c extends a.c.a.g.a {

    /* renamed from: b  reason: collision with root package name */
    public String f1039b;

    /* renamed from: c  reason: collision with root package name */
    public long f1040c;

    /* renamed from: d  reason: collision with root package name */
    public NotificationManager f1041d;

    /* renamed from: e  reason: collision with root package name */
    public NotificationCompat.Builder f1042e;
    public int f = 101101;
    public long g;

    public class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public a f1044a;

        /* renamed from: b  reason: collision with root package name */
        public MamaMyBellyAddRequest f1045b;

        public b(MamaMyBellyAddRequest mamaMyBellyAddRequest, a aVar) {
            this.f1044a = aVar;
            this.f1045b = mamaMyBellyAddRequest;
        }

        public void run() {
            String str;
            c cVar;
            try {
                File file = new File(this.f1045b.f4139c);
                b bVar = new b();
                if (!file.exists()) {
                    bVar.f42a = Boolean.FALSE;
                    this.f1044a.l(bVar);
                    return;
                }
                c.this.f1040c = file.length();
                a aVar = new a();
                aVar.a("file", new e.a.a.f0.g.h.c(file));
                aVar.writeTo(new ByteArrayOutputStream((int) aVar.getContentLength()));
                HashMap hashMap = new HashMap();
                hashMap.put("anadirentrada", "1");
                Usuario i = AppMiniland.f().i();
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("fecha", j.k.format(Calendar.getInstance().getTime()));
                hashMap.put("titulo", this.f1045b.f4137a);
                hashMap.put("descripcion", this.f1045b.f4138b);
                c.this.f1041d = (NotificationManager) ((AppMiniland) a.c.a.a.f).getApplicationContext().getSystemService("notification");
                c.this.f1042e = new NotificationCompat.Builder(((AppMiniland) a.c.a.a.f).getApplicationContext(), "CHANNEL_ID");
                a.c.a.d.a.o(c.this.f1041d);
                e eVar = new e(a.c.a.d.a.c(c.this.f1039b, hashMap));
                g a2 = d.a();
                eVar.f = aVar;
                c.this.f1042e.setContentTitle(a.c.a.d.a.h(R.string.TR_NOTIFICATION_UPLOADING_PHOTO_TITLE)).setContentText(a.c.a.d.a.h(R.string.TR_NOTIFICATION_UPLOADING_PHOTO_DESC)).setContentIntent(PendingIntent.getActivity((AppMiniland) a.c.a.a.f, 0, new Intent(), 0)).setSmallIcon(R.mipmap.ic_launcher);
                JSONObject jSONObject = new JSONObject(a.e.a.a.r.b.c0(((e.a.a.g0.g.g) a2).g(eVar).b()));
                if (jSONObject.has("idMiTripita")) {
                    bVar.f42a = Boolean.TRUE;
                    bVar.f1038c = Long.valueOf(jSONObject.getLong("idMiTripita"));
                    if (this.f1044a != null) {
                        this.f1044a.l(bVar);
                    }
                    cVar = c.this;
                    str = a.c.a.d.a.h(R.string.TR_UPLOAD_PHOTO_OK);
                } else {
                    bVar.f42a = Boolean.FALSE;
                    bVar.f43b = a.c.a.d.a.h(R.string.TR_ERROR_GUARDAR_ECOGRAFIA);
                    cVar = c.this;
                    str = a.c.a.d.a.h(R.string.TR_UPLOAD_PHOTO_KO);
                }
                c.a(cVar, str);
            } catch (Exception e2) {
                c cVar2 = c.this;
                if (!(cVar2.f1041d == null || cVar2.f1042e == null)) {
                    c.a(cVar2, a.c.a.d.a.h(R.string.TR_UPLOAD_SONG_KO));
                }
                b bVar2 = new b();
                bVar2.f42a = Boolean.FALSE;
                bVar2.f43b = a.c.a.d.a.h(R.string.TR_ERROR_GUARDAR_ECOGRAFIA);
                a aVar2 = this.f1044a;
                if (aVar2 != null) {
                    aVar2.l(bVar2);
                }
                e2.printStackTrace();
            }
        }
    }

    public c(String str) {
        super("BELLY_ADD_SERVICE");
        this.f1039b = str;
    }

    public static void a(c cVar, String str) {
        if (cVar.f1041d != null && cVar.f1042e != null) {
            if (AppMiniland.f().n()) {
                cVar.f1041d.cancel(cVar.f);
                return;
            }
            cVar.f1042e.setContentText(str).setProgress(0, 0, false);
            cVar.f1041d.notify(cVar.f, cVar.f1042e.build());
        }
    }

    public class a extends e.a.a.f0.g.g {
        public a() {
        }

        public void writeTo(OutputStream outputStream) {
            C0049a aVar = new C0049a(outputStream);
            e.a.a.f0.g.c cVar = this.f4927a;
            cVar.a(cVar.f4919d, aVar, true);
        }

        /* renamed from: a.c.d.s.e.d.d.a.c$a$a  reason: collision with other inner class name */
        public class C0049a extends FilterOutputStream {
            public C0049a(OutputStream outputStream) {
                super(outputStream);
                c.this.g = 0;
            }

            public void write(int i) {
                NotificationManager notificationManager;
                this.out.write(i);
                c cVar = c.this;
                cVar.g++;
                if (cVar.f1042e != null && (notificationManager = cVar.f1041d) != null) {
                    if (Build.VERSION.SDK_INT >= 26 && notificationManager.getNotificationChannel("CHANNEL_ID") == null) {
                        c.this.f1041d.createNotificationChannel(new NotificationChannel("CHANNEL_ID", "eMyBaby", 3));
                    }
                    c cVar2 = c.this;
                    cVar2.f1042e.setProgress((int) cVar2.f1040c, i, false);
                    c cVar3 = c.this;
                    cVar3.f1041d.notify(cVar3.f, cVar3.f1042e.build());
                }
            }

            public void write(byte[] bArr, int i, int i2) {
                NotificationManager notificationManager;
                this.out.write(bArr, i, i2);
                c cVar = c.this;
                cVar.g += (long) i2;
                if (cVar.f1042e != null && (notificationManager = cVar.f1041d) != null) {
                    if (Build.VERSION.SDK_INT >= 26 && notificationManager.getNotificationChannel("CHANNEL_ID") == null) {
                        c.this.f1041d.createNotificationChannel(new NotificationChannel("CHANNEL_ID", "eMyBaby", 3));
                    }
                    c cVar2 = c.this;
                    cVar2.f1042e.setProgress((int) cVar2.f1040c, (int) cVar2.g, false);
                    c cVar3 = c.this;
                    cVar3.f1041d.notify(cVar3.f, cVar3.f1042e.build());
                }
            }
        }
    }
}
