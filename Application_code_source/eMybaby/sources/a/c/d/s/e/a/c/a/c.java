package a.c.d.s.e.a.c.a;

import a.c.a.f.d;
import a.c.d.r.j;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.cuatroochenta.miniland.model.UltrasoundPhoto;
import com.cuatroochenta.miniland.webservices.pregnancy.baby.ultrasound.add.UltrasoundAddRequest;
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
    public String f937b;

    /* renamed from: c  reason: collision with root package name */
    public long f938c;

    /* renamed from: d  reason: collision with root package name */
    public NotificationManager f939d;

    /* renamed from: e  reason: collision with root package name */
    public NotificationCompat.Builder f940e;
    public int f = 101101;
    public long g;

    public class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public a f942a;

        /* renamed from: b  reason: collision with root package name */
        public UltrasoundAddRequest f943b;

        public b(UltrasoundAddRequest ultrasoundAddRequest, a aVar) {
            this.f942a = aVar;
            this.f943b = ultrasoundAddRequest;
        }

        public void run() {
            String str;
            c cVar;
            try {
                UltrasoundPhoto ultrasoundPhoto = this.f943b.f4108a;
                File file = new File(ultrasoundPhoto.getPhotoPath());
                b bVar = new b();
                if (!file.exists()) {
                    bVar.f42a = Boolean.FALSE;
                    this.f942a.a(bVar);
                    return;
                }
                c.this.f938c = file.length();
                a aVar = new a();
                aVar.a("file", new e.a.a.f0.g.h.c(file));
                aVar.writeTo(new ByteArrayOutputStream((int) aVar.getContentLength()));
                HashMap hashMap = new HashMap();
                hashMap.put("anadirentrada", "1");
                Usuario i = AppMiniland.f().i();
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("fecha", j.j.format(Calendar.getInstance().getTime()));
                hashMap.put("titulo", ultrasoundPhoto.getTitle());
                hashMap.put("descripcion", ultrasoundPhoto.getDescription());
                c.this.f939d = (NotificationManager) ((AppMiniland) a.c.a.a.f).getApplicationContext().getSystemService("notification");
                c.this.f940e = new NotificationCompat.Builder(((AppMiniland) a.c.a.a.f).getApplicationContext(), "CHANNEL_ID");
                a.c.a.d.a.o(c.this.f939d);
                e eVar = new e(a.c.a.d.a.c(c.this.f937b, hashMap));
                g a2 = d.a();
                eVar.f = aVar;
                c.this.f940e.setContentTitle(a.c.a.d.a.h(R.string.TR_NOTIFICATION_UPLOADING_PHOTO_TITLE)).setContentText(a.c.a.d.a.h(R.string.TR_NOTIFICATION_UPLOADING_PHOTO_DESC)).setContentIntent(PendingIntent.getActivity((AppMiniland) a.c.a.a.f, 0, new Intent(), 0)).setSmallIcon(R.mipmap.ic_launcher);
                JSONObject jSONObject = new JSONObject(a.e.a.a.r.b.c0(((e.a.a.g0.g.g) a2).g(eVar).b()));
                if (jSONObject.has("idEcografia")) {
                    bVar.f42a = Boolean.TRUE;
                    bVar.f936c = jSONObject.getLong("idEcografia");
                    if (this.f942a != null) {
                        this.f942a.a(bVar);
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
                if (!(cVar2.f939d == null || cVar2.f940e == null)) {
                    c.a(cVar2, a.c.a.d.a.h(R.string.TR_UPLOAD_SONG_KO));
                }
                b bVar2 = new b();
                bVar2.f42a = Boolean.FALSE;
                bVar2.f43b = a.c.a.d.a.h(R.string.TR_ERROR_GUARDAR_ECOGRAFIA);
                a aVar2 = this.f942a;
                if (aVar2 != null) {
                    aVar2.a(bVar2);
                }
                e2.printStackTrace();
            }
        }
    }

    public c(String str) {
        super("ULTRASOND_ADD_SERVICE");
        this.f937b = str;
    }

    public static void a(c cVar, String str) {
        if (Build.VERSION.SDK_INT >= 26 && cVar.f939d.getNotificationChannel("CHANNEL_ID") == null) {
            cVar.f939d.createNotificationChannel(new NotificationChannel("CHANNEL_ID", "eMyBaby", 3));
        }
        if (cVar.f939d != null && cVar.f940e != null) {
            if (AppMiniland.f().n()) {
                cVar.f939d.cancel(cVar.f);
                return;
            }
            cVar.f940e.setContentText(str).setProgress(0, 0, false);
            cVar.f939d.notify(cVar.f, cVar.f940e.build());
        }
    }

    public class a extends e.a.a.f0.g.g {
        public a() {
        }

        public void writeTo(OutputStream outputStream) {
            C0047a aVar = new C0047a(outputStream);
            e.a.a.f0.g.c cVar = this.f4927a;
            cVar.a(cVar.f4919d, aVar, true);
        }

        /* renamed from: a.c.d.s.e.a.c.a.c$a$a  reason: collision with other inner class name */
        public class C0047a extends FilterOutputStream {
            public C0047a(OutputStream outputStream) {
                super(outputStream);
                c.this.g = 0;
            }

            public void write(int i) {
                NotificationManager notificationManager;
                this.out.write(i);
                c cVar = c.this;
                cVar.g++;
                if (cVar.f940e != null && (notificationManager = cVar.f939d) != null) {
                    if (Build.VERSION.SDK_INT >= 26 && notificationManager.getNotificationChannel("CHANNEL_ID") == null) {
                        c.this.f939d.createNotificationChannel(new NotificationChannel("CHANNEL_ID", "eMyBaby", 3));
                    }
                    c cVar2 = c.this;
                    cVar2.f940e.setProgress((int) cVar2.f938c, i, false);
                    c cVar3 = c.this;
                    cVar3.f939d.notify(cVar3.f, cVar3.f940e.build());
                }
            }

            public void write(@NonNull byte[] bArr, int i, int i2) {
                NotificationManager notificationManager;
                this.out.write(bArr, i, i2);
                c cVar = c.this;
                cVar.g += (long) i2;
                if (cVar.f940e != null && (notificationManager = cVar.f939d) != null) {
                    if (Build.VERSION.SDK_INT >= 26 && notificationManager.getNotificationChannel("CHANNEL_ID") == null) {
                        c.this.f939d.createNotificationChannel(new NotificationChannel("CHANNEL_ID", "eMyBaby", 3));
                    }
                    c cVar2 = c.this;
                    cVar2.f940e.setProgress((int) cVar2.f938c, (int) cVar2.g, false);
                    c cVar3 = c.this;
                    cVar3.f939d.notify(cVar3.f, cVar3.f940e.build());
                }
            }
        }
    }
}
