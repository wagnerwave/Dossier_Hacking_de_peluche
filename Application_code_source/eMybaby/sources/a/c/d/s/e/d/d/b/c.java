package a.c.d.s.e.d.d.b;

import a.c.a.f.d;
import a.c.d.m.i.h;
import a.c.d.m.i.i;
import a.c.d.r.j;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.cuatroochenta.miniland.model.MyBellyData;
import com.cuatroochenta.miniland.webservices.pregnancy.mama.my_belly.edit.MyBellyEditRequest;
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
    public String f1048b = "https://emybaby.com/api/mitripita.php";

    /* renamed from: c  reason: collision with root package name */
    public long f1049c;

    /* renamed from: d  reason: collision with root package name */
    public NotificationManager f1050d;

    /* renamed from: e  reason: collision with root package name */
    public NotificationCompat.Builder f1051e;
    public int f;
    public long g;

    public class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public MyBellyEditRequest f1053a;

        /* renamed from: b  reason: collision with root package name */
        public a f1054b;

        public b(MyBellyEditRequest myBellyEditRequest, a aVar) {
            this.f1053a = myBellyEditRequest;
            this.f1054b = aVar;
        }

        public void run() {
            c cVar;
            String h;
            try {
                MyBellyData myBellyData = this.f1053a.f4140a;
                File file = new File(myBellyData.getImageUrl());
                b bVar = new b();
                a aVar = new a();
                if (!file.toString().startsWith("http") && file.exists()) {
                    c.this.f1049c = file.length();
                    aVar.a("file", new e.a.a.f0.g.h.c(file));
                    aVar.writeTo(new ByteArrayOutputStream((int) aVar.getContentLength()));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("editarentrada", "1");
                Usuario i = AppMiniland.f().i();
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("fecha", j.k.format(Calendar.getInstance().getTime()));
                hashMap.put("titulo", myBellyData.getTitle());
                hashMap.put("descripcion", myBellyData.getDescription());
                hashMap.put("idMiTripita", String.valueOf(myBellyData.getId()));
                c.this.f1050d = (NotificationManager) ((AppMiniland) a.c.a.a.f).getApplicationContext().getSystemService("notification");
                c.this.f1051e = new NotificationCompat.Builder(((AppMiniland) a.c.a.a.f).getApplicationContext(), "CHANNEL_ID");
                a.c.a.d.a.o(c.this.f1050d);
                e eVar = new e(a.c.a.d.a.c(c.this.f1048b, hashMap));
                g a2 = d.a();
                eVar.f = aVar;
                c.this.f1051e.setContentTitle(a.c.a.d.a.h(R.string.TR_NOTIFICATION_UPLOADING_PHOTO_TITLE)).setContentText(a.c.a.d.a.h(R.string.TR_NOTIFICATION_UPLOADING_PHOTO_DESC)).setContentIntent(PendingIntent.getActivity((AppMiniland) a.c.a.a.f, 0, new Intent(), 0)).setSmallIcon(R.mipmap.ic_launcher);
                JSONObject jSONObject = new JSONObject(a.e.a.a.r.b.c0(((e.a.a.g0.g.g) a2).g(eVar).b()));
                if (jSONObject.has("idMiTripita")) {
                    bVar.f42a = Boolean.TRUE;
                    bVar.f1047c = jSONObject.getLong("idMiTripita");
                    if (this.f1054b != null) {
                        i.a aVar2 = (i.a) this.f1054b;
                        i.this.f504a.runOnUiThread(new h(aVar2, bVar));
                    }
                    cVar = c.this;
                    h = a.c.a.d.a.h(R.string.TR_UPLOAD_PHOTO_OK);
                } else {
                    bVar.f42a = Boolean.FALSE;
                    bVar.f43b = a.c.a.d.a.h(R.string.TR_ERROR_GUARDAR_ECOGRAFIA);
                    cVar = c.this;
                    h = a.c.a.d.a.h(R.string.TR_UPLOAD_PHOTO_KO);
                }
                c.a(cVar, h);
            } catch (Exception e2) {
                c cVar2 = c.this;
                if (!(cVar2.f1050d == null || cVar2.f1051e == null)) {
                    c.a(cVar2, a.c.a.d.a.h(R.string.TR_UPLOAD_SONG_KO));
                }
                b bVar2 = new b();
                bVar2.f42a = Boolean.FALSE;
                bVar2.f43b = a.c.a.d.a.h(R.string.TR_ERROR_GUARDAR_ECOGRAFIA);
                a aVar3 = this.f1054b;
                if (aVar3 != null) {
                    i.a aVar4 = (i.a) aVar3;
                    i.this.f504a.runOnUiThread(new h(aVar4, bVar2));
                }
                e2.printStackTrace();
            }
        }
    }

    public c() {
        super("MAMA_BELLY_EDIT");
    }

    public static void a(c cVar, String str) {
        if (Build.VERSION.SDK_INT >= 26 && cVar.f1050d.getNotificationChannel("CHANNEL_ID") == null) {
            cVar.f1050d.createNotificationChannel(new NotificationChannel("CHANNEL_ID", "eMyBaby", 3));
        }
        if (cVar.f1050d != null && cVar.f1051e != null) {
            if (AppMiniland.f().n()) {
                cVar.f1050d.cancel(0);
                return;
            }
            cVar.f1051e.setContentText(str).setProgress(0, 0, false);
            cVar.f1050d.notify(0, cVar.f1051e.build());
        }
    }

    public class a extends e.a.a.f0.g.g {
        public a() {
        }

        public void writeTo(OutputStream outputStream) {
            C0050a aVar = new C0050a(outputStream);
            e.a.a.f0.g.c cVar = this.f4927a;
            cVar.a(cVar.f4919d, aVar, true);
        }

        /* renamed from: a.c.d.s.e.d.d.b.c$a$a  reason: collision with other inner class name */
        public class C0050a extends FilterOutputStream {
            public C0050a(OutputStream outputStream) {
                super(outputStream);
                c.this.g = 0;
            }

            public void write(int i) {
                NotificationManager notificationManager;
                this.out.write(i);
                c cVar = c.this;
                cVar.g++;
                if (cVar.f1051e != null && (notificationManager = cVar.f1050d) != null) {
                    if (Build.VERSION.SDK_INT >= 26 && notificationManager.getNotificationChannel("CHANNEL_ID") == null) {
                        c.this.f1050d.createNotificationChannel(new NotificationChannel("CHANNEL_ID", "eMyBaby", 3));
                    }
                    c cVar2 = c.this;
                    cVar2.f1051e.setProgress((int) cVar2.f1049c, i, false);
                    c cVar3 = c.this;
                    cVar3.f1050d.notify(cVar3.f, cVar3.f1051e.build());
                }
            }

            public void write(@NonNull byte[] bArr, int i, int i2) {
                NotificationManager notificationManager;
                this.out.write(bArr, i, i2);
                c cVar = c.this;
                cVar.g += (long) i2;
                if (cVar.f1051e != null && (notificationManager = cVar.f1050d) != null) {
                    if (Build.VERSION.SDK_INT >= 26 && notificationManager.getNotificationChannel("CHANNEL_ID") == null) {
                        c.this.f1050d.createNotificationChannel(new NotificationChannel("CHANNEL_ID", "eMyBaby", 3));
                    }
                    c cVar2 = c.this;
                    cVar2.f1051e.setProgress((int) cVar2.f1049c, (int) cVar2.g, false);
                    c cVar3 = c.this;
                    cVar3.f1050d.notify(cVar3.f, cVar3.f1051e.build());
                }
            }
        }
    }
}
