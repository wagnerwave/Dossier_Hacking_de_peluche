package a.c.d.s.e.a.c.c;

import a.c.a.f.d;
import a.c.d.m.e.l.c;
import a.c.d.r.j;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.cuatroochenta.miniland.model.UltrasoundPhoto;
import com.cuatroochenta.miniland.webservices.pregnancy.baby.ultrasound.edit.UltrasoundEditRequest;
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
    public String f950b = "https://emybaby.com/api/ecografia.php";

    /* renamed from: c  reason: collision with root package name */
    public long f951c;

    /* renamed from: d  reason: collision with root package name */
    public NotificationManager f952d;

    /* renamed from: e  reason: collision with root package name */
    public NotificationCompat.Builder f953e;
    public int f;
    public long g;

    public class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public UltrasoundEditRequest f955a;

        /* renamed from: b  reason: collision with root package name */
        public a f956b;

        public b(UltrasoundEditRequest ultrasoundEditRequest, a aVar) {
            this.f955a = ultrasoundEditRequest;
            this.f956b = aVar;
        }

        public void run() {
            c cVar;
            String h;
            try {
                UltrasoundPhoto ultrasoundPhoto = this.f955a.f4110a;
                File file = new File(ultrasoundPhoto.getPhotoPath());
                b bVar = new b();
                a aVar = new a();
                if (!file.toString().startsWith("http") && file.exists()) {
                    c.this.f951c = file.length();
                    aVar.a("file", new e.a.a.f0.g.h.c(file));
                    aVar.writeTo(new ByteArrayOutputStream((int) aVar.getContentLength()));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("editarentrada", "1");
                Usuario i = AppMiniland.f().i();
                hashMap.put("bd", i.getBd());
                hashMap.put("bdpre", i.getBdpre());
                hashMap.put("fecha", j.k.format(Calendar.getInstance().getTime()));
                hashMap.put("titulo", ultrasoundPhoto.getTitle());
                hashMap.put("descripcion", ultrasoundPhoto.getDescription());
                hashMap.put("idEcografia", String.valueOf(ultrasoundPhoto.getId()));
                c.this.f952d = (NotificationManager) ((AppMiniland) a.c.a.a.f).getApplicationContext().getSystemService("notification");
                c.this.f953e = new NotificationCompat.Builder(((AppMiniland) a.c.a.a.f).getApplicationContext(), "CHANNEL_ID");
                a.c.a.d.a.o(c.this.f952d);
                e eVar = new e(a.c.a.d.a.c(c.this.f950b, hashMap));
                g a2 = d.a();
                eVar.f = aVar;
                c.this.f953e.setContentTitle(a.c.a.d.a.h(R.string.TR_NOTIFICATION_UPLOADING_PHOTO_TITLE)).setContentText(a.c.a.d.a.h(R.string.TR_NOTIFICATION_UPLOADING_PHOTO_DESC)).setContentIntent(PendingIntent.getActivity((AppMiniland) a.c.a.a.f, 0, new Intent(), 0)).setSmallIcon(R.mipmap.ic_launcher);
                JSONObject jSONObject = new JSONObject(a.e.a.a.r.b.c0(((e.a.a.g0.g.g) a2).g(eVar).b()));
                if (jSONObject.has("idEcografia")) {
                    bVar.f42a = Boolean.TRUE;
                    bVar.f949c = jSONObject.getLong("idEcografia");
                    if (this.f956b != null) {
                        c.b bVar2 = (c.b) this.f956b;
                        a.c.d.m.e.l.c.this.f404a.runOnUiThread(new a.c.d.m.e.l.d(bVar2, bVar));
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
                if (!(cVar2.f952d == null || cVar2.f953e == null)) {
                    c.a(cVar2, a.c.a.d.a.h(R.string.TR_UPLOAD_SONG_KO));
                }
                b bVar3 = new b();
                bVar3.f42a = Boolean.FALSE;
                bVar3.f43b = a.c.a.d.a.h(R.string.TR_ERROR_GUARDAR_ECOGRAFIA);
                a aVar2 = this.f956b;
                if (aVar2 != null) {
                    c.b bVar4 = (c.b) aVar2;
                    a.c.d.m.e.l.c.this.f404a.runOnUiThread(new a.c.d.m.e.l.d(bVar4, bVar3));
                }
                e2.printStackTrace();
            }
        }
    }

    public c() {
        super("MAMA_ADD_WEIGHT");
    }

    public static void a(c cVar, String str) {
        if (cVar.f952d != null && cVar.f953e != null) {
            if (AppMiniland.f().n()) {
                cVar.f952d.cancel(0);
                return;
            }
            cVar.f953e.setContentText(str).setProgress(0, 0, false);
            cVar.f952d.notify(0, cVar.f953e.build());
        }
    }

    public class a extends e.a.a.f0.g.g {
        public a() {
        }

        public void writeTo(OutputStream outputStream) {
            C0048a aVar = new C0048a(outputStream);
            e.a.a.f0.g.c cVar = this.f4927a;
            cVar.a(cVar.f4919d, aVar, true);
        }

        /* renamed from: a.c.d.s.e.a.c.c.c$a$a  reason: collision with other inner class name */
        public class C0048a extends FilterOutputStream {
            public C0048a(OutputStream outputStream) {
                super(outputStream);
                c.this.g = 0;
            }

            public void write(int i) {
                this.out.write(i);
                c cVar = c.this;
                cVar.g++;
                NotificationCompat.Builder builder = cVar.f953e;
                if (builder != null && cVar.f952d != null) {
                    builder.setProgress((int) cVar.f951c, i, false);
                    c cVar2 = c.this;
                    cVar2.f952d.notify(cVar2.f, cVar2.f953e.build());
                }
            }

            public void write(@NonNull byte[] bArr, int i, int i2) {
                this.out.write(bArr, i, i2);
                c cVar = c.this;
                long j = cVar.g + ((long) i2);
                cVar.g = j;
                NotificationCompat.Builder builder = cVar.f953e;
                if (builder != null && cVar.f952d != null) {
                    builder.setProgress((int) cVar.f951c, (int) j, false);
                    c cVar2 = c.this;
                    cVar2.f952d.notify(cVar2.f, cVar2.f953e.build());
                }
            }
        }
    }
}
